package com.bankAPI.sb.controller;
import com.bankAPI.sb.dto.CheckBalanceDto;
import com.bankAPI.sb.dto.DepositAccountDto;
import com.bankAPI.sb.model.Card;
import com.bankAPI.sb.service.AccountService;
import com.bankAPI.sb.service.CardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/bank")
@Api("Controller Bank API ")
public class bankApiController {

    private CardService cardService;
    private AccountService accountService;


    public bankApiController(CardService cardService, AccountService accountService) {
        this.accountService = accountService;
        this.cardService = cardService;
    }
    @ApiOperation("Creating a new account card")
    @PostMapping("/new_card/{number}") // 1. Выпуск новой карты по номеру счёта
    public String makeCard(@PathVariable String number) {
        long numberAccount = Long.parseLong(number);
        return cardService.makeNewCard(numberAccount);
    }
    @ApiOperation("Viewing the list of cards by account")
    @GetMapping("/cards/{number}")  // 2. Просмотр списка карт по номеру счёта
    public List<Card> getCards(@PathVariable String number) {
        long numberAccount = Long.parseLong(number);
        return cardService.getCardsAll(numberAccount);
    }
    @ApiOperation("Depositing funds to the account")
    @PatchMapping("/deposit") // 3. Внесение средств по счёту
    public DepositAccountDto addMoney(@RequestBody DepositAccountDto accountDto) {
        return accountService.addMoneyToAccount(accountDto);
    }
    @ApiOperation("Checking the account balance")
    @GetMapping("/account/{number}") // 4. Проверка баланса по счёту
    public CheckBalanceDto checkBalance(@PathVariable String number) {
        long numberAccount = Long.parseLong(number);
        return accountService.checkBalance(numberAccount);
    }
}
