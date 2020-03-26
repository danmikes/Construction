enum AttachType {
    TEXT,
    IMAGE
}

abstract class Attach {

    private AttachType attachType;

    Attach(AttachType attachType) {
        this.attachType = attachType;
        arrangeParts();
    }

    private void arrangeParts() {
        // Do one time processing here
    }

    protected abstract void construct();

    public AttachType getAttachType() {
        return attachType;
    }

    public void setAttachType(AttachType attachType) {
        this.attachType = attachType;
    }

    @Override
    public String toString() {
        return "Attach{" +
            "attachType=" + attachType +
            '}';
    }
}

class TextAttach extends Attach {

    TextAttach() {
        super(AttachType.TEXT);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building doc attach");
        // Add accessories
    }
}

class ImageAttach extends Attach {

    ImageAttach() {
        super(AttachType.IMAGE);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building picture attach");
        // Add accessories
    }
}

public class AttachFactory {
    static Attach buildAttach(AttachType attachType) {
        Attach attach = null;
        switch (attachType) {
            case TEXT:
                attach = new TextAttach();
                break;

            case IMAGE:
                attach = new ImageAttach();
                break;

            default:
                // throw some exception
                break;
        }
        return attach;
    }
}
