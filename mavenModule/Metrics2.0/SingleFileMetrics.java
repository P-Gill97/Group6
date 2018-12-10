import java.util.Date;

public class SingleFileMetrics {
    String nameOfFile;
    int lines;
    int words;
    int characters;
    int sourcelines;
    int commentlines;
    String url;
    Date date;
    public SingleFileMetrics(){

    }
    public SingleFileMetrics(String n, int l, int w, int c, int s, int cm){
        nameOfFile=n;
        lines=l;
        words=w;
        characters=c;
        sourcelines=s;
        commentlines=c;
    }
    public String getName(){
        return nameOfFile;
    }
    public int getLines(){
        return lines;
    }
    public int getWord(){
        return words;
    }
    public int getCharacters(){
        return characters;
    }
    public int getSourcelines(){
        return sourcelines;
    }
    public int getCommentlines(){
        return commentlines;
    }
    public Date getDate(){
        return date;
    }
    public void setDate(Date d){
        date=d;
    }
    public String getUrl(){
        return url;
    }
    public void setUrl(String u){
        url=u;
    }
}
