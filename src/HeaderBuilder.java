// @Getter
// @Setter
// @Builder
// @NoArgsConstructor

import java.util.ArrayList;
import java.util.List;

/**
 * How to incorporate String[]?
 * Builder String?
 * Header String[]?
 */
class Header {

    public static void main(String[] args) {

        List<String> to = new ArrayList<>();
        to.add("max@post.cz");
        to.add("m4x@post.cz");

        String from = "max8@post.cz";

        List<String> cc = new ArrayList<>();
        cc.add("danmik@post.cz");
        cc.add("dmikes@email.cz");

        List<String> bcc = new ArrayList<>();
        bcc.add("daniel.mikes@hva.nl");
        bcc.add("daniel.mikes@kvk.nl");

        String subject = "subject";

        Builder header = new Builder();
        header
            .to(to)
            .from(from)
            .cc(cc)
            .bcc(bcc)
            .subject(subject)
            .build()
            ;
    }

    private MailType mailType;

    private List<String> to;
    private String from;
    private List<String> cc;
    private List<String> bcc;
    private String subject;

    public Header() {
    }

    Header(MailType mailType) {
        this.mailType = mailType;
        arrangeParts();
    }

    private void arrangeParts() {
        // Do one time processing here
    }

    public MailType getMailType() {
        return mailType;
    }

    public void setMailType(MailType mailType) {
        this.mailType = mailType;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public void setBcc(List<String> bcc) {
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public static class Builder {

        private MailType mailType;

        private List<String> to;
        private String from;
        private List<String> cc;
        private List<String> bcc;
        private String subject;

        public Builder to(List<String> to) {
            this.to = to;
            return this;
        }

        public Builder from(String from) {
            this.from = from;
            return this;
        }

        public Builder cc(List<String> cc) {
            this.cc = cc;
            return this;
        }

        public Builder bcc(List<String> bcc) {
            this.bcc = bcc;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder build() {
            return this;
        }
    }

}
