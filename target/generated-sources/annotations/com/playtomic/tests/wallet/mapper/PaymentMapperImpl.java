package com.playtomic.tests.wallet.mapper;

import com.playtomic.tests.wallet.entity.Payment;
import com.playtomic.tests.wallet.entity.Wallet;
import com.playtomic.tests.wallet.model.PaymentDto;
import com.playtomic.tests.wallet.model.PaymentDto.PaymentDtoBuilder;
import com.playtomic.tests.wallet.model.WalletDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-13T22:45:55+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public PaymentDto toDto(Payment entity) {
        if ( entity == null ) {
            return null;
        }

        PaymentDtoBuilder paymentDto = PaymentDto.builder();

        paymentDto.id( entity.getId() );
        paymentDto.wallet( walletToWalletDto( entity.getWallet() ) );
        paymentDto.amount( entity.getAmount() );

        return paymentDto.build();
    }

    @Override
    public Payment toEntity(PaymentDto dto) {
        if ( dto == null ) {
            return null;
        }

        Payment payment = new Payment();

        payment.setId( dto.getId() );
        payment.setWallet( walletDtoToWallet( dto.getWallet() ) );
        payment.setAmount( dto.getAmount() );

        return payment;
    }

    protected WalletDto walletToWalletDto(Wallet wallet) {
        if ( wallet == null ) {
            return null;
        }

        WalletDto walletDto = new WalletDto();

        walletDto.setId( wallet.getId() );
        walletDto.setBalance( wallet.getBalance() );
        walletDto.setCreditCardNumber( wallet.getCreditCardNumber() );

        return walletDto;
    }

    protected Wallet walletDtoToWallet(WalletDto walletDto) {
        if ( walletDto == null ) {
            return null;
        }

        Wallet wallet = new Wallet();

        wallet.setId( walletDto.getId() );
        wallet.setBalance( walletDto.getBalance() );
        wallet.setCreditCardNumber( walletDto.getCreditCardNumber() );

        return wallet;
    }
}
