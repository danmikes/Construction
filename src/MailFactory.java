enum MailType {
    SIMPLE, MIME
}

abstract class Mail {

    private MailType mailType;

    Mail(MailType mailType) {
        this.mailType = mailType;
        arrangeParts();
    }

    private void arrangeParts() {
        // Do one time processing here
    }

    // Do subclass level processing in this method
    protected abstract void construct();

    private MailType getMailType() {
        return mailType;
    }

    private void setMailType(MailType mailType) {
        this.mailType = mailType;
    }

    @Override
    public String toString() {
        return "Mail{" +
            "mailType=" + mailType +
            '}';
    }
}

class SimpleMail extends Mail {

    SimpleMail() {
        super(MailType.SIMPLE);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building simple mail");
        // Add accessories
    }
}

class MimeMail extends Mail {

    MimeMail() {
        super(MailType.MIME);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building mime mail");
        // Add accessories
    }
}

class MailFactory {
    static Mail buildMail(MailType mailType) {
        Mail mail = null;
        switch (mailType) {
            case SIMPLE:
                mail = new SimpleMail();
                break;

            case MIME:
                mail = new MimeMail();
                break;

            default:
                // throw some exception
                break;
        }
        return mail;
    }
}

class TestMail {
    public static void main(String[] args) {
        System.out.println(MailFactory.buildMail(MailType.SIMPLE));
        System.out.println(MailFactory.buildMail(MailType.MIME));
    }
}
