�ӿڣ�
interface Computer{
    void printComputer();
}
ʵ�֣�
class Mac implements  Computer{
  @Override
   public void printComputer() {
    System.out.println ("This is a Mac" );
    }
}
class   Surface implements  Computer{
 @Override
  public void printComputer() {
   System.out.println ("This is a Surface" );
    }
}
class ComputerFactory{
 public static Computer getInstance(String type) {
  Computer computer = null;
   switch(type){
     case "mac":
     computer =new Mac ();
       break;
       case"surface":
        computer=new Surface ();
           break;
         default:
                System.out.println ("��������ȷ�ĵ����ͺ�" );
            break;
        }
        return computer;
    }
}
class Client{
    public void Buycomputer(Computer computer){
        computer.printComputer ();
    }
}
���ԣ�
  public static void main(String[] args) {

        Client client=new Client ();
        Scanner scanner=new Scanner ( System.in );
        System.out.println ("����������Ҫ�ĵ����ͺ�" );
        String type=scanner.nextLine();
        Computer computer= ComputerFactory.getInstance ( type );
        client.Buycomputer ( computer );
    }