package info.guardianproject.bouncycastle.crypto.io;

import info.guardianproject.bouncycastle.crypto.Digest;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class DigestOutputStream
    extends FilterOutputStream
{
    protected Digest digest;

    public DigestOutputStream(
        OutputStream    stream,
        Digest          digest)
    {
        super(stream);
        this.digest = digest;
    }

    public void write(int b)
        throws IOException
    {
        digest.update((byte)b);
        out.write(b);
    }

    public void write(
        byte[] b,
        int off,
        int len)
        throws IOException
    {
        digest.update(b, off, len);
        out.write(b, off, len);
    }

    public Digest getDigest()
    {
        return digest;
    }
}
