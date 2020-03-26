enum BodyType {
    TXT,
    RTF,
    HTML
}

abstract class Body {

    private BodyType bodyType;

    Body(BodyType bodyType) {
        this.bodyType = bodyType;
        arrangeParts();
    }

    private void arrangeParts() {
        // Do one time processing here
    }

    // Do subclass level processing in this method
    protected abstract void construct();

    private BodyType getBodyType() {
        return bodyType;
    }

    private void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return "Body{" +
            "bodyType=" + bodyType +
            '}';
    }
}

class TxtBody extends Body {

    TxtBody() {
        super(BodyType.TXT);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building txt body");
        // Add accessories
    }
}

class RtfBody extends Body {

    RtfBody() {
        super(BodyType.RTF);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building rtf body");
        // Add accessories
    }
}

class HtmlBody extends Body {

    HtmlBody() {
        super(BodyType.HTML);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building html body");
        // Add accessories
    }
}

// @Getter
// @Setter
// @Builder
// @NoArgsConstructor
public class BodyFactory {
    static Body buildBody(BodyType bodyType) {
        Body body = null;
        switch (bodyType) {
            case TXT:
                body = new TxtBody();
                break;

            case RTF:
                body = new RtfBody();
                break;

            case HTML:
                body = new HtmlBody();
                break;

            default:
                // throw some exception
                break;
        }
        return body;
    }
}
