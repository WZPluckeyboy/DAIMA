public class Test {
    public static String stringCompress(String str) { 
        char[] arr = str.toCharArray();     //���ַ���ת��Ϊ�ַ�����
          StringBuilder arr1 = new StringBuilder();   //�½�һ��ֱ���ۼӵ�����
         int count = 1;                      //����һ�������������������ظ��ַ��ĸ���
         arr1.append(arr[0]);                //�����һ���ַ�
        char temp = arr[0];                //��Ŀ���ַ�����ĵ�һ��Ԫ����Ϊ�Ƚ�Ŀ�����temp
         for (int j = 1; j < arr.length; j++) {      //�����ַ�����
             if(temp == arr[j]){             //�ж�����arr��ǰ������Ƚ�Ŀ��temp�Ƿ����
                 count++;                    //��ȼ�������һ
                 }
                 else{                           //����arr��ǰ������Ƚ�Ŀ��temp�����
                 arr1.append((char)(count + '0'));   //����arr1��һλ�洢��һԪ�صĸ���
                 arr1.append(arr[j]);        //���µıȽ�Ŀ�����arr1
                  temp = arr[j];              //���±Ƚ�Ŀ��temp��ֵ
                  count = 1;                  //��������1,�����������µıȽ�Ŀ��temp��ֵ
                 }
           }
           arr1.append((char)(count + '0'));//�����һλ��ǰһλ���ʱ��ֱ������ѭ����        //��ʱ����Ҫ��ѭ�����⽫������count��ֵ�ӵ�����ĺ���
         String str1 = new String(arr1);  //���ַ�����ת��Ϊ�ַ���
         return str1;    }
         public static void main(String[] args)
         {

             System.out.println(stringCompress("aabbccdaa"));
         }
}