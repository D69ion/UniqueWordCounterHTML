import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс, подсчитывающий кол-во вхождений уникальных слов в тексте
 */
public class UniqueWordCounter {
    /** Словарь, хранящий уникальные слова и их кол-во вхождений */
    private Map<String, Integer> dictionary;
    /** Массив символов, являющихся разделителями */
    private final char[] SEPARATORS =  {' ', ',', '.', '!', '?','"', ';', ':', '[', ']', '(', ')', '\n',
            '\r', '\t'};

    public UniqueWordCounter() {
        this.dictionary = new HashMap<String, Integer>();
    }

    public Map<String, Integer> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map<String, Integer> dictionary) {
        this.dictionary = dictionary;
    }

    /**
     * Производит расчет кол-ва вхождений уникальных слов
     * @param text - входная строка, содержащая текст
     * */
    public void CalcUniqueWords(String text){
        for (char separator : SEPARATORS) {
            text = text.replace(separator, ' ');
        }
        String[] words = text.split(" ");
        //TODO: после сплита остаются пустые строки. возникает из-за нескольких пробелов или разделителей стоящих подряд
        for (String word : words) {
            if (dictionary.containsKey(word)) {
                dictionary.put(word, dictionary.get(word) + 1);
            } else {
                dictionary.put(word, 1);
            }
        }
    }

    /**
     * Создает строковое представление словаря уникальных слов
     * @return возвращает строку, содержащую все уникальные слова с кол-вом вхождений
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Map.Entry<String, Integer> item: dictionary.entrySet()
             ) {
            res.append(item.getKey()).append(" - ").append(item.getValue()).append("\r\n");
        }
        return res.toString();
    }
}
