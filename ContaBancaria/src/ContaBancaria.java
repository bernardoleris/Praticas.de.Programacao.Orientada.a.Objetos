public class ContaBancaria {
    private static int ultimaContaCriada = 100;
    private Cliente cliente;
    private int saldo;
    private int limite;
    private int numeroConta;
    // private int taxaRendimento;

    public void transferencia(int valor, ContaBancaria contaDestino) {
        if (this.limite < this.saldo - valor) {
            this.saque(valor);
            contaDestino.deposito(valor);
        } else {
            System.out.println("Transferência não permitida: o valor solicitado está excedendo o limite da conta.");
        }
    }

    public ContaBancaria(Cliente novoCliente) {
        this.saldo = 0;
        this.limite = -500;
        this.cliente = novoCliente;
        this.numeroConta = ++ultimaContaCriada;
    }

    public ContaBancaria(Cliente novoCliente, int saldoInicial) {
        this.saldo = saldoInicial;
        this.limite = -500;
        this.cliente = novoCliente;
        this.numeroConta = ++ultimaContaCriada;
    }

    public String consultaSaldo() {
        return cliente.getNome() + ", de CPF: " + cliente.getCpf() + ", possui o saldo de: " + this.saldo;
    }

    public Boolean saque(int valor) {
        if (this.saldo - valor < this.limite) {
            return false;
        } else {
            this.saldo = this.saldo - valor;
            return true;
        }
    }

    public void deposito(int valor) {
        this.saldo = this.saldo + valor;
    }

    public int getNumeroConta() {
        return this.numeroConta;
    }

    public int getSaldo() {
        return this.saldo;
    }

    public int getLimite() {
        return this.limite;
    }

    /*
     * public void render() {
     * this.saldo = this.saldo + this.saldo * taxaRendimento;
     * }
     */
}
