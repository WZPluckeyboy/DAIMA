//��������
class Message<T extends Number>{     //������
    private T message;
    public T getMessage(){
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
    public  static void fun(Message<? extends Number> tmp){   //���ͷ���
        System.out.println (tmp.getMessage () );
    }
}
public class TestDome {
    public static void main(String[] args) {
        Message<Integer>  message =new Message<> ();

message.setMessage (110000  );
Message.fun ( message );
    }
}
//��������
class Message1<T>{  
    private T message;


    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
    public static void fun(Message1<? super String> temp){    //�����е����ݿ����޸ĵ��������Ҫ��
        temp.setMessage ( "bit" );
        System.out.println (temp.getMessage () );
    }

    public static void main(String[] args) {
        Message1<String> message =new Message1 ();
        message.setMessage ( "Hello Word" );
        Message1.fun ( message );
    }
}

