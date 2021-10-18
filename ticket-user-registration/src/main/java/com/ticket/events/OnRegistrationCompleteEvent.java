package com.ticket.events;

import com.ticket.entities.account.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
@Slf4j
public class OnRegistrationCompleteEvent extends ApplicationEvent {



    private final String appUrl;
    private final Account account;


    public OnRegistrationCompleteEvent(final Account account, final String appUrl) {
        super(account);
        this.account = account;
        this.appUrl = appUrl;
        log.info(account.toString(), appUrl);
    }

}
