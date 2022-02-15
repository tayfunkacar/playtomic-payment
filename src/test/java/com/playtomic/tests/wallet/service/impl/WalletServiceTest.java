package com.playtomic.tests.wallet.service.impl;

import com.playtomic.tests.wallet.WalletApplication;
import com.playtomic.tests.wallet.enummurated.Currency;
import com.playtomic.tests.wallet.model.PaymentDto;
import com.playtomic.tests.wallet.model.WalletDto;
import com.playtomic.tests.wallet.repository.WalletRepository;
import com.playtomic.tests.wallet.service.WalletServiceImpl;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {WalletApplication.class})
@DataJpaTest
@ActiveProfiles("test")
public class WalletServiceTest {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private WalletServiceImpl walletService;

    private static UUID walletId;


    private static final String TEST_CREDIT_CARD = "1212121212121212";

    @Before
    public void setUp() {
        WalletDto wallet = new WalletDto();
        wallet.setBalance(new BigDecimal("0.0"));
        wallet.setCurrency(Currency.EURO);
        wallet.setCreditCardNumber(TEST_CREDIT_CARD);
        wallet = walletService.save(wallet);
        walletId = wallet.getId();
        assertThat(wallet).isNotNull();
    }

    @Test
    public void save() {
        WalletDto wallet = new WalletDto();
        wallet.setBalance(new BigDecimal("0.0"));
        wallet.setCurrency(Currency.EURO);
        wallet.setCreditCardNumber(TEST_CREDIT_CARD);
        wallet = walletService.save(wallet);
        walletId = wallet.getId();
        assertThat(wallet).isNotNull();
    }

    @Test
    public void getWalletById() {
        WalletDto wallet = walletService.getWalletById(walletId);
        assertThat(wallet).isNotNull();
    }

    @Test
    public void addAmountToWallet() {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setAmount(new BigDecimal("10.2"));
        paymentDto.setWallet(walletService.getWalletById(walletId));
        WalletDto wallet = walletService.addAmountToWallet(paymentDto);
        assertThat(wallet.getBalance()).isEqualTo(paymentDto.getAmount());
    }

    @Test
    public void payment() {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setAmount(new BigDecimal("5"));
        paymentDto.setWallet(walletService.getWalletById(walletId));
        WalletDto wallet = walletService.payment(paymentDto);
//        assertThat(wallet.getBalance()).isEqualTo(paymentDto.getAmount());
    }


    @TestConfiguration
    static class TestConfig {
        @Bean
        public RestTemplateBuilder restTemplateBuilder() {
            return new RestTemplateBuilder();
        }
    }
}
