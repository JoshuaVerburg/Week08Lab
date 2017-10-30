package businesslogic;

import dataaccess.NoteDB;
import domainmodel.Note;
import java.util.List;
import java.util.Date;

public class NoteService {

    private NoteDB userDB;

    public NoteService() {
        userDB = new NoteDB();
    }

    public Note get(int noteid) throws Exception {
        return userDB.getNote(noteid);
    }

    public List<Note> getAll() throws Exception {
        return userDB.getAll();
    }

    public int update(int noteid, Date dateCreated, String contents) throws Exception {
        Note note = userDB.getNote(noteid);
        note.setDateCreated(dateCreated);
        note.setContents(contents);

        return userDB.update(note);
    }

    public int delete(int noteid) throws Exception {
        Note deletedNote = userDB.getNote(noteid);
        return userDB.delete(deletedNote);
    }

    public int insert(int noteid, Date dateCreated, String contents) throws Exception {
       
        Note note = new Note(noteid, dateCreated, contents);

        return userDB.insert(note);
        
    }
}
