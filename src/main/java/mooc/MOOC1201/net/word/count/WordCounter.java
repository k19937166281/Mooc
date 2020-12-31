package mooc.MOOC1201.net.word.count;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.Map.Entry;

public class WordCounter {

	public static void main(String[] args) throws IOException {

		//接收目录参数和扩展名
        //首先是路径
		Path fileTree = Paths.get("C:/temp/");
		//然后是 老师 通过  继承 实现了  FileVisitor    接口实现的类
        //用来遍历文件文件夹   老师在里面加了操作
        //比我的 java 思想深厚了许多层次     像是 经理当时  实现了  ArrayList    File  然后加上自己的属性
        //如果是我来做。我会创建一个新类  然后把我需要的类 都作为属性  封装到 自定义的类里面
        //但是  其实   java  封装 继承 抽象 多态 这样用确实 让我觉得高深  ， 思想应用的更加到位
		Searcher walk = new Searcher("*.txt");	
		
		
		//查找该目录下所有的txt文件
		EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
		Files.walkFileTree(fileTree, opts, Integer.MAX_VALUE, walk);

		ArrayList<String> filePaths = walk.getFilePaths();
		//System.out.println(filePaths.get(0));
		
		//解析每个文件的单词
		
		HashMap<String, Word> totalMap = new HashMap<String, Word>(); 
		
		for(String str:filePaths)
		{
			HashMap<String, Word> partMap = new FileAnalyzer(str).getWordCount();
			if(partMap != null && partMap.size() > 0)
			{
				combineMap(totalMap, partMap);
			}
		}
		
		//排序
		//Collection<Word> words = totalMap.values();
		ArrayList<Word> words = new ArrayList<Word>(totalMap.values());
		Collections.sort(words);
		
		//输出
		System.out.println("result of the end.");
		for(Word w : words)
		{
			System.out.println(w.getText() + ", " + w.getTimes());
		}
	}
	
	/**
	 * combineMap 合并两个HashMap
	 * @param total
	 * @param part
	 */
	public static void combineMap(HashMap<String, Word> total, HashMap<String, Word> part)
	{
		Iterator<Entry<String, Word>> iter = part.entrySet().iterator();
		while(iter.hasNext()) {
		    Entry<String, Word> entry = iter.next();
		    // 获取key
		    String partKey = entry.getKey();
		    // 获取value
		    Word partWord = entry.getValue();
		    if(total.containsKey(partKey))
		    {
		    	Word totalWord = total.get(partKey);
		    	totalWord.setTimes(totalWord.getTimes() + partWord.getTimes());
		    }
		    else
		    {
		    	total.put(partKey, partWord);
		    }
		}
	}

}
