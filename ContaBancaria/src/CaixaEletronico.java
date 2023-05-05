import java.util.Scanner;

public class CaixaEletronico {
    private Cliente cliente;
    private ContaBancaria novaConta;
    private ContaBancaria novaConta2;
    private Scanner ler = new Scanner(System.in);

    public void executar() {
        int opcao;
        do {
            System.out.println("\n-------- MENU --------");
            System.out.println("Escolha uma opção:");
            System.out.println("1: Criar conta.");
            System.out.println("2: Consultar saldo.");
            System.out.println("3: Depositar.");
            System.out.println("4: Sacar.");
            System.out.println("5: Realizar transferência.");
            System.out.println("6: Sair.");
            opcao = Integer.parseInt(ler.nextLine());
            if (opcao > 6 || opcao < 1) {
                System.out.println("A opção escolhida é inválida.");
            }
            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    consultarSaldo();
                    break;
                case 3:
                    DepositarValor();
                    break;
                case 4:
                    SacarValor();
                    break;
                case 5:
                    realizarTransferencia();
                    break;
            }
        } while (opcao != 6);
    }

    public void realizarTransferencia() {
        System.out.println("Digite o numero da conta que deseja enviar o valor a ser transferido.");
        int numero1 = Integer.parseInt(ler.nextLine());
        System.out.println("Digite o numero da conta que deseja receber o valor a ser transferido.");
        int numero2 = Integer.parseInt(ler.nextLine());
        if (novaConta != null) {
            if (novaConta.getNumeroConta() == numero1 && novaConta2.getNumeroConta() == numero2) {
                System.out.println("Qual valor deseja transferir?");
                int valor = Integer.parseInt(ler.nextLine());
                novaConta.transferencia(valor, novaConta2);
            } else if (novaConta2.getNumeroConta() == numero1 && novaConta.getNumeroConta() == numero2) {
                System.out.println("Qual valor deseja transferir?");
                int valor = Integer.parseInt(ler.nextLine());
                novaConta2.transferencia(valor, novaConta);
            } else {
                System.out.println("Ao menos uma dessas contas não foi registrada.");
            }
        } else {
            System.out.println("Nenhuma conta foi registrada.");
        }
    }

    public void criarConta() {
        System.out.println("Conta 1:");
        System.out.println("Digite o nome do cliente a ser criado.");
        String nome = ler.nextLine();
        System.out.println("Digite o CPF do cliente a ser criado.");
        String cpf = ler.nextLine();
        cliente = new Cliente(nome, cpf);
        System.out.println("Selecione um tipo de criação de conta:");
        System.out.println("1: Com inserção de saldo inicial");
        System.out.println("2: Sem inserção de saldo inicial.");
        int opcao = Integer.parseInt(ler.nextLine());
        if (opcao == 1) {
            System.out.println("Digite o valor do saldo inicial.");
            int saldoIni = Integer.parseInt(ler.nextLine());
            novaConta = new ContaBancaria(cliente, saldoIni);
            System.out.println("Conta criada. O número de acesso é " + novaConta.getNumeroConta());
        } else if (opcao == 2) {
            novaConta = new ContaBancaria(cliente);
            System.out.println("Conta criada. O número de acesso é " + novaConta.getNumeroConta());
        } else {
            System.out.println("A opção escolhida é inválida.");
        }

        System.out.println("Conta 2:");
        System.out.println("Digite o nome do cliente a ser criado.");
        nome = ler.nextLine();
        System.out.println("Digite o CPF do cliente a ser criado.");
        cpf = ler.nextLine();
        cliente = new Cliente(nome, cpf);
        System.out.println("Selecione um tipo de criação de conta:");
        System.out.println("1: Com inserção de saldo inicial");
        System.out.println("2: Sem inserção de saldo inicial.");
        opcao = Integer.parseInt(ler.nextLine());
        if (opcao == 1) {
            System.out.println("Digite o valor do saldo inicial.");
            int saldoIni = Integer.parseInt(ler.nextLine());
            novaConta2 = new ContaBancaria(cliente, saldoIni);
            System.out.println("Conta criada. O número de acesso é " + novaConta2.getNumeroConta());
        } else if (opcao == 2) {
            novaConta2 = new ContaBancaria(cliente);
            System.out.println("Conta criada. O número de acesso é " + novaConta2.getNumeroConta());
        } else {
            System.out.println("A opção escolhida é inválida.");
        }
    }

    public void consultarSaldo() {
        System.out.println("Qual o numero de acesso da conta que deseja realizar a consulta?");
        int opcao = Integer.parseInt(ler.nextLine());
        if (novaConta != null) {
            if (opcao == novaConta.getNumeroConta()) {
                System.out.println("Saldo da conta: " + novaConta.consultaSaldo());
            } else if (opcao == novaConta2.getNumeroConta()) {
                System.out.println("Saldo da conta: " + novaConta2.consultaSaldo());
            } else {
                System.out.println("A opção escolhida é inválida.");
            }
        } else {
            System.out.println("Nenhuma conta foi registrada.");
        }
    }

    public void DepositarValor() {
        System.out.println("Qual o numero de acesso da conta que deseja realizar o deposito?");
        int opcao = Integer.parseInt(ler.nextLine());
        if (novaConta != null) {
            if (opcao == novaConta.getNumeroConta()) {
                System.out.println("Quanto deseja depositar?");
                int valor = Integer.parseInt(ler.nextLine());
                novaConta.deposito(valor);
            } else if (opcao == novaConta2.getNumeroConta()) {
                System.out.println("Quanto deseja depositar?");
                int valor = Integer.parseInt(ler.nextLine());
                novaConta2.deposito(valor);
            } else {
                System.out.println("A opção escolhida é inválida.");
            }
        } else {
            System.out.println("Nenhuma conta foi registrada.");
        }
    }

    public void SacarValor() {
        System.out.println("Qual o numero de acesso da conta que deseja realizar a consulta?");
        int opcao = Integer.parseInt(ler.nextLine());
        if (novaConta != null) {
            if (opcao == novaConta.getNumeroConta()) {
                System.out.println("Quanto deseja sacar?");
                int valor = Integer.parseInt(ler.nextLine());
                if (novaConta.saque(valor) == true) {
                    System.out.println("O valor foi sacado.");
                } else {
                    System.out.println("O valor não pode ser sacado pois passou do limite.");
                }
            } else if (opcao == novaConta2.getNumeroConta()) {
                if (novaConta2 != null) {
                    System.out.println("Quanto deseja sacar?");
                    int valor = Integer.parseInt(ler.nextLine());
                    if (novaConta2.saque(valor) == true) {
                        System.out.println("O valor foi sacado.");
                    } else {
                        System.out.println("O valor não pode ser sacado pois passou do limite.");
                    }
                }
            } else {
                System.out.println("A opção escolhida é inválida.");
            }
        } else {
            System.out.println("Nenhuma conta foi registrada.");
        }
    }
}
