package command.Implementatiion.Transaction;

import Services.Implementation.TransactionService;
import command.Command;
import command.Page;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class TransactionCreate implements Command {
    private TransactionService transactionService=new TransactionService();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        return new Page();
    }
}
