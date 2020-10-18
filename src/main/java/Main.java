import java.util.Scanner;

class Main {
    public static void main(String[] args){
        /*try (Scanner scanner = new Scanner(System.in)){
            while(true){
                System.out.println("Paste the link");
                String url = scanner.nextLine();
                HTMLParser parser = new HTMLParser(url);

            }
        }*/
        UniqueWordCounter wordCounter=new UniqueWordCounter();
        wordCounter.CalcUniqueWords("q w,e?r... q.");
        System.out.println(wordCounter.toString());
    }
}
