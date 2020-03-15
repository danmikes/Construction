public class MailBuilder {

    public static void main(String[] args) {
        Builder mail = new Builder();
        mail
            .to("max@post.cz")
            .from("max@post.cz")
            .subject("subject")
            .text("text")
            .build()
        ;
        System.out.println(mail.to);
        System.out.println(mail.from);
        System.out.println(mail.subject);
        System.out.println(mail.text);
    }

    private String to;
    private String from;
    private String subject;
    private String text;

    public MailBuilder() {
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static class Builder {

        private String to;
        private String from;
        private String subject;
        private String text;

        public Builder() {
        }

        public Builder to(String to) {
            this.to = to;
            return this;
        }

        public Builder from(String from) {
            this.from = from;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder build() {
            return this;
        }
    }
}
