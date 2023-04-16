package demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        countByIterator("stream/src/main/resources/alice.txt");
        countByStream("stream/src/main/resources/alice.txt");
    }

    // 传统的通过迭代器统计文本中的单词出现次数
    public static void countByIterator(String url) throws IOException{
        String contents = Files.readString(Path.of(url));
        List<String> words = List.of(contents.split("\\PL+"));
        long count = 0;
        for (String w : words) {
            if (w.length() > 3) count++;
        }
        System.out.println("长度大于3的单词数:" + count);
    }

    // 通过流操作统计文本中的单词出现次数
    public static void countByStream(String url) throws IOException{
        String contents = Files.readString(Path.of(url));
        List<String> words = List.of(contents.split("\\PL+"));
        long count = 0;
        count = words.stream()
                .filter(w -> w.length() > 3)
                .count();
        System.out.println("长度大于3的单词数:" + count);

    }
}
