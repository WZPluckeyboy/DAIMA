class  Member implements  Serializable{
    @Deprecated
    @Override
    public String toString(){
        System.out.println ("this is a Member" );
        return "this is a Member";
    }
}
    public static void main(String[] args) throws NoSuchMethodException {
        Annotation[]  ant =Member.class.getMethod ( "toString").getAnnotations ();
        for(Annotation a:ant){
            System.out.println (a );
        }
    }
}