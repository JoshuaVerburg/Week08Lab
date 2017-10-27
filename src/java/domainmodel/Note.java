/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.util.Date;

/**
 *
 * @author 727334
 */
public class Note {
    private int noteid;
    private Date dateCreated;
    private String contents;
    
    public Note(int noteid, Date dateCreated, String contents){
        this.noteid = noteid;
        this.dateCreated = dateCreated;
        this.contents = contents;
    }

    public int getNoteid() {
        return noteid;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
    
}
