package lesson_3.task_4;

import java.io.Serializable;

public class Message implements Serializable {
    private String subject;
    private String body;

    public Message(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "[subject: " + subject + "; body: " + body + "]";
    }
}
