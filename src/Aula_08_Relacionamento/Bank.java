
package Aula_08_Relacionamento;

/**
 * @author david-ferreira
 * Classe que tera N instancias de BankAccount
 */

public class Bank {
    private BankAccount accounts[];  // Vetor de contas bancárias.
    private int last;                // Indice da ultima conta inserida.
    
    public Bank() {
        accounts = new BankAccount[100];  // Um banco com no máximo 100 contas.
        last = 0;
    }
    
    /**
     * Adiciona uma nova conta ao Banco.
     * @param newAccount: Nova conta.
     */
    public void addAccount(BankAccount newAccount) {
        if (this.last == 99)
            throw new RuntimeException("The bank is full");
        
        accounts[last] = newAccount;
        last++;
    }
    
    /** @return A soma do saldo de todas as contas. */
    public double getTotalBalance() {
        double soma = 0;
        
        for (BankAccount conta : accounts) {
            soma += conta.getBalance();
        }
        
        return soma;
    }
    
    /**
     * @return Devolve a conta vinculada ao numero informado.
     * @param accountNumber: Numero da conta.  
     */
    public BankAccount find(int accountNumber) {
        for (BankAccount conta : accounts) {
            if (conta.getAccountNumber() == accountNumber)
                return conta;
        }
        
        return null;  // A conta não está no banco.
    }
    
    /** @return A conta que contém o maior saldo. */
    public BankAccount getMaximum() {
        if (last == 0)
            return null;  // O banco está vazio.
        
        BankAccount maior = accounts[0];
        
        for (int i=1; i < last; i++) {
            if (accounts[i].getBalance() > maior.getBalance())
                maior = accounts[i];
        }
        
        return maior;
    }
    
    /**
     * @param limit: Limite de saldo.
     * @return Retorna o numero de contas que tenha o saldo >= ao limit.
     */
    public int count(double limit) {
        int result = 0;
        
        for (BankAccount conta : accounts) {
            if (conta.getBalance() >= limit)
                result++;
        }
        
        return result;
        
    }
    
    public int getLast() {
        return last;
    }

    public BankAccount[] getAccounts() {
        return accounts;
    }
} 