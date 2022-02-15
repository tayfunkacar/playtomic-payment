package com.playtomic.tests.wallet.mapper;

import com.playtomic.tests.wallet.entity.Wallet;
import com.playtomic.tests.wallet.model.WalletDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-15T21:20:21+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class WalletMapperImpl implements WalletMapper {

    @Override
    public WalletDto toDto(Wallet entity) {
        if ( entity == null ) {
            return null;
        }

        WalletDto walletDto = new WalletDto();

        walletDto.setId( entity.getId() );
        walletDto.setCurrency( entity.getCurrency() );
        walletDto.setBalance( entity.getBalance() );
        walletDto.setCreditCardNumber( entity.getCreditCardNumber() );

        return walletDto;
    }

    @Override
    public Wallet toEntity(WalletDto dto) {
        if ( dto == null ) {
            return null;
        }

        Wallet wallet = new Wallet();

        wallet.setId( dto.getId() );
        wallet.setCurrency( dto.getCurrency() );
        wallet.setBalance( dto.getBalance() );
        wallet.setCreditCardNumber( dto.getCreditCardNumber() );

        return wallet;
    }
}
