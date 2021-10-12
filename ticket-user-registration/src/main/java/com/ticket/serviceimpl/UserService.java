package com.ticket.serviceimpl;

import com.springsec.springsecurityexample.model.PasswordResetToken;
import com.springsec.springsecurityexample.model.User;
import com.springsec.springsecurityexample.model.VerificationToken;
import com.springsec.springsecurityexample.persists.PasswordResetTokenRepository;
import com.springsec.springsecurityexample.persists.UserRepository;
import com.springsec.springsecurityexample.persists.VerificationTokenRepository;
import com.springsec.springsecurityexample.service.IUserService;
import com.springsec.springsecurityexample.validation.EmailExistsException;
import com.ticket.entities.account.Account;
import com.ticket.entities.account.security.VerificationToken;
import com.ticket.exceptions.EmailExistsException;
import com.ticket.repositories.AccountRepository;
import com.ticket.repositories.PasswordResetTokenRepository;
import com.ticket.repositories.VerificationTokenRepository;
import com.ticket.service.IAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IAccountService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final AccountRepository repository;

    private final VerificationTokenRepository verificationTokenRepository;

    private final PasswordResetTokenRepository passwordTokenRepository;

    private final PasswordEncoder passwordEncoder;



    @Autowired
    public UserService(AccountRepository repository, VerificationTokenRepository verificationTokenRepository, PasswordResetTokenRepository passwordTokenRepository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.verificationTokenRepository = verificationTokenRepository;
        this.passwordTokenRepository = passwordTokenRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<Account> registerNewUser(Account account) throws EmailExistsException {
        logger.info("RegisterNewUser: {}", account);
        if (emailExist(account.getLoginEmail())) {
            logger.info("Email already exists");
            throw new EmailExistsException("Account with {} already exists " + account.getLoginEmail());
        }
        logger.info("User status false");
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setEnabled(false);
        logger.info("User save to DB {}", account);
        return Optional.ofNullable(repository.save(account));
    }

    private boolean emailExist(String email) {
        final Account account = repository.findByLoginEmail(email).get();
        return (account != null) ? true : false;
    }

    @Override
    public Optional<Account> updateExistingUser(Account account) throws EmailExistsException {
        logger.info("UpdateExists User: {}", account.toString());
        final Long id = account.getId();
        final String email = account.getLoginEmail();
        final Account emailOwner = repository.findByLoginEmail(email).get();
        if (emailOwner != null && !id.equals(emailOwner.getId())) {
            logger.info("Email {} not available", account.getLoginEmail());
            throw new EmailExistsException("Email not available.");
        }
        logger.info("Save Update");
        return Optional.of(repository.save(account));
    }

    @Override
    public void createVerificationTokenForUser(final Account account, final String token) {
        logger.info("VerificationToken saving");
        final VerificationToken myToken = new VerificationToken(token, account);
        try {
            verificationTokenRepository.save(myToken);
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
        logger.info("VerificationToken saved");
    }

    @Override
    public Optional<VerificationToken> getVerificationToken(final String token) {
        logger.info("Get VerificationToken by token {}", token);
        return verificationTokenRepository.findByToken(token);
    }

    @Override
    public void saveRegisteredUser(final Account account)
    {
        logger.info("SaveRegistered User {}", account);
        account.setEnabled(true);
        logger.info("Change status to active");
        repository.save(account);
    }

    @Override
    public User findUserByEmail(final String email) {
        logger.info("Get User by email {}", email);
        return repository.findByEmail(email);
    }

    @Override
    public void createPasswordResetTokenForUser(User user, String token) {
        logger.info("Creating reset token in DB. Token is  {}", token);
        final PasswordResetToken myToken = new PasswordResetToken(token, user);
        logger.info("Saving token to DB");
        passwordTokenRepository.save(myToken);
    }

    @Override
    public PasswordResetToken getPasswordResetToken(String token)
    {
        logger.info("Get PasswordResetToken by token {}", token);
        return passwordTokenRepository.findByToken(token);
    }

    @Override
    public void changeUserPassword(User user, String password) {
        logger.info("Change password on {} for user {}", password, user);
        user.setPassword(passwordEncoder.encode(password));
        logger.info("User password after encoding: {}", user.getPassword());
        repository.save(user);
        logger.info("User password saved to db");
    }

    @Override
    public User save(User user) {
        logger.info("User save {}", user.toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        logger.info("User password after encoding: {}", user.getPassword());
        return repository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        logger.info("Delete User by Id: {}", id);
        repository.deleteById(id);
    }

    @Override
    public Iterable<User> findAll() {
        return repository.findAll();
    }
}
