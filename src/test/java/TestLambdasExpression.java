public class TestLambdasExpression {
    public static void main(String[] args) {
//        Fox myFox = new Fox();
//        myFox.speak();
//
//        beHuman(myFox);
//
//        beHuman(new Speakable() {
//            @Override
//            public void speak() {
//                System.out.println("你看我像人，还是像神?");
//            }
//        });

        beHuman(
            (language) -> {
                System.out.println("你看我像人，还是像神?");
                System.out.println(language);
                return "狐狸还会说英语咩?";
            }
        );
    }

    static void beHuman (Speakable animal) {
        String result = animal.speak("English");
        System.out.println(result);
    }
}


//class Fox implements Speakable {
//
//    @Override
//    public void speak() {
//        System.out.println("你看我像人，还是像神?");
//    }
//}
