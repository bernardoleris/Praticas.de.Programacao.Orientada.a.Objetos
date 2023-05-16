import java.util.Scanner;
import java.util.ArrayList;

public class CaixaEletronico {
    private Cliente cliente;
    private Scanner ler = new Scanner(System.in);
    private ArrayList<ContaBancaria> contas = new ArrayList<>();
    private ContaBancaria novaConta;

    public CaixaEletronico() {
        contas = new ArrayList<>();
    }

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
            System.out.println("6: Exibir dados da conta.");
            System.out.println("7: Cancelar conta.");
            System.out.println("8: Encontrar contas.");
            System.out.println("9: Sair.");
            opcao = Integer.parseInt(ler.nextLine());
            if (opcao > 9 || opcao < 1) {
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
                case 6:
                    exibirDados();
                    break;
                case 7:
                    removerConta();
                    break;
                case 8:
                    filtrarContas();
                    break;
            }
        } while (opcao != 9);
    }

    public void criarConta() {
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
        } else if (opcao == 2) {
            novaConta = new ContaBancaria(cliente);
        } else {
            System.out.println("A opção escolhida é inválida.");
        }
        contas.add(novaConta);
        System.out.println("Conta criada. O número de acesso é " + novaConta.getNumeroConta());
    }

    public void exibirDados() {
        System.out.println("Qual o numero de acesso da conta que deseja exibir os dados?");
        int numeroConta = Integer.parseInt(ler.nextLine());
        boolean encontrou = false;
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                System.out.println("Numero da conta: " + numeroConta);
                System.out.println("Nome do titular: " + conta.getCliente().getNome());
                encontrou = true;
            }
        }
        if (encontrou == false) {
            System.out.println("Nenhuma conta foi encontrada.");
        }
    }

    public void consultarSaldo() {
        System.out.println("Qual o numero de acesso da conta que deseja realizar a consulta?");
        int numeroConta = Integer.parseInt(ler.nextLine());
        boolean encontrou = false;
        if (contas.size() > 0) {
            for (ContaBancaria conta : contas) {
                if (conta.getNumeroConta() == numeroConta) {
                    System.out.println("Saldo da conta " + numeroConta + ": " + conta.getSaldo());
                    encontrou = true;
                }
            }
            if (encontrou == false) {
                System.out.println("Nenhuma conta foi encontrada.");
            }
        } else {
            System.out.println("Nenhuma conta foi registrada.");
        }
    }

    public void DepositarValor() {
        System.out.println("Qual o numero de acesso da conta que deseja realizar o deposito?");
        int numeroConta = Integer.parseInt(ler.nextLine());
        boolean encontrou = false;
        if (contas.size() > 0) {
            for (ContaBancaria conta : contas) {
                if (conta.getNumeroConta() == numeroConta) {
                    System.out.println("Digite o valor a ser depositado.");
                    int valor = Integer.parseInt(ler.nextLine());
                    conta.deposito(valor);
                    encontrou = true;
                }
            }
            if (encontrou == false) {
                System.out.println("Nenhuma conta foi encontrada.");
            }
        } else {
            System.out.println("Nenhuma conta foi registrada.");
        }
    }

    public void SacarValor() {
        System.out.println("Qual o numero de acesso da conta que deseja realizar o saque?");
        int numeroConta = Integer.parseInt(ler.nextLine());
        boolean encontrou = false;
        if (contas.size() > 0) {
            for (ContaBancaria conta : contas) {
                if (conta.getNumeroConta() == numeroConta) {
                    System.out.println("Digite o valor a ser sacado.");
                    int valor = Integer.parseInt(ler.nextLine());
                    conta.saque(valor);
                    encontrou = true;
                }
            }
            if (encontrou == false) {
                System.out.println("Nenhuma conta foi encontrada.");
            }
        } else {
            System.out.println("Nenhuma conta foi registrada.");
        }
    }

    public void realizarTransferencia() {
        System.out.println("Digite o numero da conta que deseja enviar o valor a ser transferido.");
        int numero1 = Integer.parseInt(ler.nextLine());
        System.out.println("Digite o numero da conta que deseja receber o valor a ser transferido.");
        int numero2 = Integer.parseInt(ler.nextLine());
        boolean encontrou1 = false;
        boolean encontrou2 = false;
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta() == numero1) {
                encontrou1 = true;
            }
            if (conta.getNumeroConta() == numero2) {
                encontrou2 = true;
            }
        }
        if (encontrou1 == true && encontrou2 == true) {
            System.out.println("Qual valor deseja transferir?");
            int valor = Integer.parseInt(ler.nextLine());
            for (ContaBancaria conta : contas) {
                if (conta.getNumeroConta() == numero1) {
                    if (conta.verificadorSaldo(valor) == true) {
                        conta.saque(valor);
                        for (ContaBancaria conta2 : contas) {
                            if (conta2.getNumeroConta() == numero2) {
                                conta2.deposito(valor);
                            }
                        }
                    } else {
                        System.out
                                .println("A conta escolhida não possui saldo suficente para realizar a transferência");
                    }
                }
            }
        } else {
            System.out.println("Erro: uma das contas não foi encontrada.");
        }
    }

    public void removerConta() {
        System.out.println("Digite o numero da conta que deseja cancelar.");
        int numero = Integer.parseInt(ler.nextLine());
        boolean contaEncontrada = false;

        for (int i = 0; i < contas.size(); i++) {
            ContaBancaria conta = contas.get(i);
            if (conta.getNumeroConta() == numero) {
                contaEncontrada = true;
                if (conta.getSaldo() == 0) {
                    contas.remove(i);
                    System.out.println("Conta removida com sucesso.");
                } else if (conta.getSaldo() > 0) {
                    System.out.println("Não é possível cancelar contas com saldo disponível.");
                } else if (conta.getSaldo() < 0) {
                    System.out.println("Não é possível cancelar contas em débito.");
                }
            }
        }

        if (!contaEncontrada) {
            System.out.println("Conta não encontrada.");
        }
    }

    public void filtrarContas() {
        System.out.println("Digite o nome da conta que deseja encontrar.");
        String nome = ler.nextLine().toLowerCase();
        Boolean encontrou = false;
        for (ContaBancaria conta : contas) {
            if ((conta.getCliente().getNome().toLowerCase()).contains(nome)) {
                System.out.println(conta.getNumeroConta() + " - " + conta.getCliente().getNome());
                encontrou = true;
            }
        }
        if (encontrou == false) {
            System.out.println("Conta não encontrada.");
        }
    }
}
