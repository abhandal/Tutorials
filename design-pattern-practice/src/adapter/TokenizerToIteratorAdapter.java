package adapter;

import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.function.Consumer;

public class TokenizerToIteratorAdapter implements Iterator<String> {

    private StringTokenizer stringTokenizer;

    public TokenizerToIteratorAdapter(StringTokenizer stringTokenizer) {
        this.stringTokenizer = stringTokenizer;
    }

    @Override
    public boolean hasNext() {
        return stringTokenizer.hasMoreTokens();
    }

    @Override
    public String next() {
        return stringTokenizer.nextToken();
    }
}
