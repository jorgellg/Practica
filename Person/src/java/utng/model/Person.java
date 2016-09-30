/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utng.model;

/**
 *
 * @author Jorge
 */
public class Person {
    private int pUuid;
    private String lastSeen;
    private String lastClothing;
    private String comments;

    public Person(int pUuid, String lastSeen, String lastClothing, String comments) {
        this.pUuid = pUuid;
        this.lastSeen = lastSeen;
        this.lastClothing = lastClothing;
        this.comments = comments;
    }

    public Person() {
        this(0,"","","");
    }

    public int getpUuid() {
        return pUuid;
    }

    public void setpUuid(int pUuid) {
        this.pUuid = pUuid;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getLastClothing() {
        return lastClothing;
    }

    public void setLastClothing(String lastClothing) {
        this.lastClothing = lastClothing;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Person{" + "pUuid=" + pUuid + ", lastSeen=" + lastSeen + ", lastClothing=" + lastClothing + ", comments=" + comments + '}';
    }        
        
}
