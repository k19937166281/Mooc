
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.james.mime4j.dom.Entity;
import org.apache.james.mime4j.dom.Message;
import org.apache.james.mime4j.dom.Multipart;
import org.apache.james.mime4j.dom.TextBody;
import org.apache.james.mime4j.message.DefaultMessageBuilder;

public class Mime4jUtilCopy {
//
//        <dependency>
//            <groupId>org.apache.james</groupId>
//            <artifactId>apache-mime4j-core</artifactId>
//            <version>0.7.2</version>
//        </dependency>
//        <dependency>
//            <groupId>org.apache.james</groupId>
//            <artifactId>apache-mime4j-dom</artifactId>
//            <version>0.7.2</version>
//        </dependency>
    public static HashMap<String,String> singleData = new HashMap<>();
    public static List<HashMap<String,String>> multiData = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        String s = mht2Html("C:\\Users\\k1326\\Documents\\WeChat Files\\wxid_rj1ijtcurwnb22\\FileStorage\\File\\2020-08\\1.mht");
        int bodyBeginIndex = s.indexOf("<BODY>");
        int bodyEndIndex = s.indexOf("</BODY>");
        String bodyStr = s.substring(bodyBeginIndex, bodyEndIndex+7);
        String replace1= bodyStr.replace("&nbsp;", "");
        String replace= replace1.replace("：", ":");
        String[] split = replace.split("</TD>");
        int tdLength = split.length;
        String tempSingleData = "";
        String[] multiDataKey = new String[5];
        //最后一行不是 split.length-1
        int i=0;
        int j=0;
        int l=-1;
        HashMap<String, String> multiDataHashMap = null;
        for (String s1 : split) {
            i++;
            if (i==tdLength){
                break;
            }
            String td = s1.substring(s1.lastIndexOf(">") + 1);

            if (i==1||i==2||i==tdLength-1||i==tdLength-2){
                //System.out.println(td);
                String[] split1 = td.split(":");
                if (split1.length==1){
                    singleData.put(split1[0],"");
                }else{
                    singleData.put(split1[0],split1[1]);
                }
            }
            if (i==3||i==5||i==7||i==9){
                tempSingleData=td;
            }
            if (i==4||i==6||i==8||i==10){
                singleData.put(tempSingleData,td);
            }
            if (i>10&&i<16){
                multiDataKey[j]=td;
                j++;
            }
            if (i>15&&i<tdLength-2){
                l++;
                if (l==0){
                    multiDataHashMap = new HashMap<>();
                }
                multiDataHashMap.put(multiDataKey[l],td);
                if(l==4){
                    multiData.add(multiDataHashMap);
                    l=0;
                }
            }
        }
        System.out.println("--------------------------");
        singleData.forEach((k,v)->{
            System.out.println(k+"\t"+v);
        });
        System.out.println("--------------------------");
        for (String s1 : multiDataKey) {
            System.out.println(s1);
        }
        System.out.println("--------------------------");
        for (HashMap<String, String> multiDatum : multiData) {
            System.out.println("***************************");
            multiDatum.forEach((k,v)->{
                System.out.println(k+"\t"+v);
            });
        }
    }

    //源文件路径   目标文件路径
    public static String mht2Html(String srcMht) throws IOException {
            DefaultMessageBuilder builder = new DefaultMessageBuilder();
            InputStream inputStream = new FileInputStream(new File(srcMht));
            Message message = builder.parseMessage(inputStream);
            Multipart multipart = (Multipart) message.getBody();
            List<Entity> parts = multipart.getBodyParts();
            //1.取主体
            StringBuilder htmlTextStr = new StringBuilder();
            for (Entity entity : parts) {
                if(!"text/html".equals(entity.getMimeType())){
                    continue;
                }
                TextBody body = (TextBody)entity.getBody();
                BufferedReader br = new BufferedReader(body.getReader());
                String line = null;
                while((line = br.readLine()) != null){
                    htmlTextStr.append(line);
                }
                break;
            }
            String htmlText = htmlTextStr.toString();
            return htmlText;
    }


}