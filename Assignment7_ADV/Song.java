import java.io.Serializable;

public class Song implements Serializable
{
    private String title;
    private String artist;
    private String genre;
    private Date date;

    public Song(String title, String artist, String genre, Date date)
    {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.date = date;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getTitle()
    {
        return title;
    }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }
    public String getArtist()
    {
        return artist;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }
    public String getGenre()
    {
        return genre;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }
    public Date getDate()
    {
        return date;
    }
}  