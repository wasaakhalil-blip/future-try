

// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\a\a.java ==========

package net.a.a.a;

import java.io.DataInput;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import net.a.a.e.d;
import net.a.a.e.e;
import net.a.a.e.f;
import net.a.a.e.g;
import net.a.a.e.i;
import net.a.a.e.j;
import net.a.a.e.k;
import net.a.a.e.l;
import net.a.a.h.b;
import net.a.a.h.c;

/* compiled from: HeaderReader */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private RandomAccessFile f488a = null;

    /* renamed from: b  reason: collision with root package name */
    private l f489b;

    public a(RandomAccessFile randomAccessFile) {
        this.f488a = randomAccessFile;
    }

    public l a(String str) throws net.a.a.c.a {
        this.f489b = new l();
        this.f489b.b(str);
        this.f489b.a(a());
        this.f489b.a(c());
        if (this.f489b.g()) {
            this.f489b.a(d());
            if (this.f489b.f() == null || this.f489b.f().b() <= 0) {
                this.f489b.a(false);
            } else {
                this.f489b.a(true);
            }
        }
        this.f489b.a(b());
        return this.f489b;
    }

    private d a() throws net.a.a.c.a {
        if (this.f488a != null) {
            try {
                byte[] bArr = new byte[4];
                long length = this.f488a.length() - 22;
                d dVar = new d();
                int i = 0;
                while (true) {
                    long j = length - 1;
                    this.f488a.seek(length);
                    i++;
                    if (((long) b.a((DataInput) this.f488a, bArr)) == 101010256) {
                        break;
                    } else if (i > 3000) {
                        break;
                    } else {
                        length = j;
                    }
                }
                if (((long) b.d(bArr, 0)) == 101010256) {
                    byte[] bArr2 = new byte[4];
                    byte[] bArr3 = new byte[2];
                    dVar.a(101010256);
                    a(this.f488a, bArr3);
                    dVar.a(b.b(bArr3, 0));
                    a(this.f488a, bArr3);
                    dVar.b(b.b(bArr3, 0));
                    a(this.f488a, bArr3);
                    dVar.c(b.b(bArr3, 0));
                    a(this.f488a, bArr3);
                    dVar.d(b.b(bArr3, 0));
                    a(this.f488a, bArr2);
                    dVar.e(b.d(bArr2, 0));
                    a(this.f488a, bArr2);
                    dVar.b(b.a(a(bArr2), 0));
                    a(this.f488a, bArr3);
                    int b2 = b.b(bArr3, 0);
                    dVar.f(b2);
                    if (b2 > 0) {
                        byte[] bArr4 = new byte[b2];
                        a(this.f488a, bArr4);
                        dVar.a(new String(bArr4));
                        dVar.a(bArr4);
                    } else {
                        dVar.a((String) null);
                    }
                    if (dVar.a() > 0) {
                        this.f489b.a(true);
                    } else {
                        this.f489b.a(false);
                    }
                    return dVar;
                }
                throw new net.a.a.c.a("zip headers not found. probably not a zip file");
            } catch (IOException e) {
                throw new net.a.a.c.a("Probably not a zip file or a corrupted zip file", e, 4);
            }
        } else {
            throw new net.a.a.c.a("random access file was null", 3);
        }
    }

    private net.a.a.e.b b() throws net.a.a.c.a {
        String str;
        if (this.f488a == null) {
            throw new net.a.a.c.a("random access file was null", 3);
        } else if (this.f489b.b() != null) {
            try {
                net.a.a.e.b bVar = new net.a.a.e.b();
                ArrayList arrayList = new ArrayList();
                d b2 = this.f489b.b();
                long c = b2.c();
                int b3 = b2.b();
                if (this.f489b.g()) {
                    c = this.f489b.f().d();
                    b3 = (int) this.f489b.f().c();
                }
                this.f488a.seek(c);
                byte[] bArr = new byte[4];
                byte[] bArr2 = new byte[2];
                byte[] bArr3 = new byte[8];
                int i = 0;
                while (i < b3) {
                    f fVar = new f();
                    a(this.f488a, bArr);
                    int d = b.d(bArr, 0);
                    boolean z = true;
                    if (((long) d) == 33639248) {
                        fVar.a(d);
                        a(this.f488a, bArr2);
                        fVar.b(b.b(bArr2, 0));
                        a(this.f488a, bArr2);
                        fVar.c(b.b(bArr2, 0));
                        a(this.f488a, bArr2);
                        fVar.d((b.b(bArr2, 0) & 2048) != 0);
                        byte b4 = bArr2[0];
                        if ((b4 & 1) != 0) {
                            fVar.b(true);
                        }
                        fVar.a((byte[]) bArr2.clone());
                        fVar.c((b4 >> 3) == 1);
                        a(this.f488a, bArr2);
                        fVar.d(b.b(bArr2, 0));
                        a(this.f488a, bArr);
                        fVar.e(b.d(bArr, 0));
                        a(this.f488a, bArr);
                        fVar.a((long) b.d(bArr, 0));
                        fVar.d((byte[]) bArr.clone());
                        a(this.f488a, bArr);
                        fVar.b(b.a(a(bArr), 0));
                        a(this.f488a, bArr);
                        fVar.c(b.a(a(bArr), 0));
                        a(this.f488a, bArr2);
                        int b5 = b.b(bArr2, 0);
                        fVar.f(b5);
                        a(this.f488a, bArr2);
                        fVar.g(b.b(bArr2, 0));
                        a(this.f488a, bArr2);
                        int b6 = b.b(bArr2, 0);
                        fVar.b(new String(bArr2));
                        a(this.f488a, bArr2);
                        fVar.h(b.b(bArr2, 0));
                        a(this.f488a, bArr2);
                        fVar.b((byte[]) bArr2.clone());
                        a(this.f488a, bArr);
                        fVar.c((byte[]) bArr.clone());
                        a(this.f488a, bArr);
                        fVar.d(b.a(a(bArr), 0) & 4294967295L);
                        if (b5 > 0) {
                            byte[] bArr4 = new byte[b5];
                            a(this.f488a, bArr4);
                            if (c.a(this.f489b.h())) {
                                str = new String(bArr4, this.f489b.h());
                            } else {
                                str = c.a(bArr4, fVar.s());
                            }
                            if (str != null) {
                                if (str.indexOf(":" + System.getProperty("file.separator")) >= 0) {
                                    str = str.substring(str.indexOf(":" + System.getProperty("file.separator")) + 2);
                                }
                                fVar.a(str);
                                if (!str.endsWith("/") && !str.endsWith("\\")) {
                                    z = false;
                                }
                                fVar.a(z);
                            } else {
                                throw new net.a.a.c.a("fileName is null when reading central directory");
                            }
                        } else {
                            fVar.a((String) null);
                        }
                        b(fVar);
                        c(fVar);
                        d(fVar);
                        if (b6 > 0) {
                            byte[] bArr5 = new byte[b6];
                            a(this.f488a, bArr5);
                            fVar.b(new String(bArr5));
                        }
                        arrayList.add(fVar);
                        i++;
                    } else {
                        throw new net.a.a.c.a("Expected central directory entry not found (#" + (i + 1) + ")");
                    }
                }
                bVar.a(arrayList);
                net.a.a.e.c cVar = new net.a.a.e.c();
                a(this.f488a, bArr);
                int d2 = b.d(bArr, 0);
                if (((long) d2) != 84233040) {
                    return bVar;
                }
                cVar.a(d2);
                a(this.f488a, bArr2);
                int b7 = b.b(bArr2, 0);
                cVar.b(b7);
                if (b7 > 0) {
                    byte[] bArr6 = new byte[b7];
                    a(this.f488a, bArr6);
                    cVar.a(new String(bArr6));
                }
                return bVar;
            } catch (IOException e) {
                throw new net.a.a.c.a((Throwable) e);
            }
        } else {
            throw new net.a.a.c.a("EndCentralRecord was null, maybe a corrupt zip file");
        }
    }

    private void b(f fVar) throws net.a.a.c.a {
        if (this.f488a == null) {
            throw new net.a.a.c.a("invalid file handler when trying to read extra data record");
        } else if (fVar != null) {
            int f = fVar.f();
            if (f > 0) {
                fVar.a(a(f));
            }
        } else {
            throw new net.a.a.c.a("file header is null");
        }
    }

    private void a(g gVar) throws net.a.a.c.a {
        if (this.f488a == null) {
            throw new net.a.a.c.a("invalid file handler when trying to read extra data record");
        } else if (gVar != null) {
            int e = gVar.e();
            if (e > 0) {
                gVar.a(a(e));
            }
        } else {
            throw new net.a.a.c.a("file header is null");
        }
    }

    private ArrayList a(int i) throws net.a.a.c.a {
        if (i <= 0) {
            return null;
        }
        try {
            byte[] bArr = new byte[i];
            this.f488a.read(bArr);
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    break;
                }
                e eVar = new e();
                eVar.a((long) b.b(bArr, i2));
                int i3 = i2 + 2;
                int b2 = b.b(bArr, i3);
                if (b2 + 2 > i) {
                    b2 = b.c(bArr, i3);
                    if (b2 + 2 > i) {
                        break;
                    }
                }
                eVar.a(b2);
                int i4 = i3 + 2;
                if (b2 > 0) {
                    byte[] bArr2 = new byte[b2];
                    System.arraycopy(bArr, i4, bArr2, 0, b2);
                    eVar.a(bArr2);
                }
                i2 = i4 + b2;
                arrayList.add(eVar);
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        } catch (IOException e) {
            throw new net.a.a.c.a((Throwable) e);
        }
    }

    private i c() throws net.a.a.c.a {
        if (this.f488a != null) {
            try {
                i iVar = new i();
                e();
                byte[] bArr = new byte[4];
                byte[] bArr2 = new byte[8];
                a(this.f488a, bArr);
                long d = (long) b.d(bArr, 0);
                if (d == 117853008) {
                    this.f489b.b(true);
                    iVar.a(d);
                    a(this.f488a, bArr);
                    iVar.a(b.d(bArr, 0));
                    a(this.f488a, bArr2);
                    iVar.b(b.a(bArr2, 0));
                    a(this.f488a, bArr);
                    iVar.b(b.d(bArr, 0));
                    return iVar;
                }
                this.f489b.b(false);
                return null;
            } catch (Exception e) {
                throw new net.a.a.c.a((Throwable) e);
            }
        } else {
            throw new net.a.a.c.a("invalid file handler when trying to read Zip64EndCentralDirLocator");
        }
    }

    private j d() throws net.a.a.c.a {
        if (this.f489b.e() != null) {
            long a2 = this.f489b.e().a();
            if (a2 >= 0) {
                try {
                    this.f488a.seek(a2);
                    j jVar = new j();
                    byte[] bArr = new byte[2];
                    byte[] bArr2 = new byte[4];
                    byte[] bArr3 = new byte[8];
                    a(this.f488a, bArr2);
                    long d = (long) b.d(bArr2, 0);
                    if (d == 101075792) {
                        jVar.a(d);
                        a(this.f488a, bArr3);
                        jVar.b(b.a(bArr3, 0));
                        a(this.f488a, bArr);
                        jVar.a(b.b(bArr, 0));
                        a(this.f488a, bArr);
                        jVar.b(b.b(bArr, 0));
                        a(this.f488a, bArr2);
                        jVar.c(b.d(bArr2, 0));
                        a(this.f488a, bArr2);
                        jVar.d(b.d(bArr2, 0));
                        a(this.f488a, bArr3);
                        jVar.c(b.a(bArr3, 0));
                        a(this.f488a, bArr3);
                        jVar.d(b.a(bArr3, 0));
                        a(this.f488a, bArr3);
                        jVar.e(b.a(bArr3, 0));
                        a(this.f488a, bArr3);
                        jVar.f(b.a(bArr3, 0));
                        long a3 = jVar.a() - 44;
                        if (a3 > 0) {
                            byte[] bArr4 = new byte[((int) a3)];
                            a(this.f488a, bArr4);
                            jVar.a(bArr4);
                        }
                        return jVar;
                    }
                    throw new net.a.a.c.a("invalid signature for zip64 end of central directory record");
                } catch (IOException e) {
                    throw new net.a.a.c.a((Throwable) e);
                }
            } else {
                throw new net.a.a.c.a("invalid offset for start of end of central directory record");
            }
        } else {
            throw new net.a.a.c.a("invalid zip64 end of central directory locator");
        }
    }

    private void c(f fVar) throws net.a.a.c.a {
        k a2;
        if (fVar == null) {
            throw new net.a.a.c.a("file header is null in reading Zip64 Extended Info");
        } else if (fVar.p() != null && fVar.p().size() > 0 && (a2 = a(fVar.p(), fVar.e(), fVar.d(), fVar.i(), fVar.g())) != null) {
            fVar.a(a2);
            if (a2.b() != -1) {
                fVar.c(a2.b());
            }
            if (a2.a() != -1) {
                fVar.b(a2.a());
            }
            if (a2.c() != -1) {
                fVar.d(a2.c());
            }
            if (a2.d() != -1) {
                fVar.h(a2.d());
            }
        }
    }

    private void b(g gVar) throws net.a.a.c.a {
        k a2;
        if (gVar == null) {
            throw new net.a.a.c.a("file header is null in reading Zip64 Extended Info");
        } else if (gVar.k() != null && gVar.k().size() > 0 && (a2 = a(gVar.k(), gVar.d(), gVar.c(), -1, -1)) != null) {
            gVar.a(a2);
            if (a2.b() != -1) {
                gVar.c(a2.b());
            }
            if (a2.a() != -1) {
                gVar.b(a2.a());
            }
        }
    }

    private k a(ArrayList arrayList, long j, long j2, long j3, int i) throws net.a.a.c.a {
        boolean z;
        int i2;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            e eVar = (e) arrayList.get(i3);
            if (eVar != null && eVar.a() == 1) {
                k kVar = new k();
                byte[] c = eVar.c();
                if (eVar.b() <= 0) {
                    return null;
                }
                byte[] bArr = new byte[8];
                byte[] bArr2 = new byte[4];
                if ((j & 65535) != 65535 || eVar.b() <= 0) {
                    i2 = 0;
                    z = false;
                } else {
                    System.arraycopy(c, 0, bArr, 0, 8);
                    kVar.b(b.a(bArr, 0));
                    i2 = 8;
                    z = true;
                }
                if ((j2 & 65535) == 65535 && i2 < eVar.b()) {
                    System.arraycopy(c, i2, bArr, 0, 8);
                    kVar.a(b.a(bArr, 0));
                    i2 += 8;
                    z = true;
                }
                if ((j3 & 65535) == 65535 && i2 < eVar.b()) {
                    System.arraycopy(c, i2, bArr, 0, 8);
                    kVar.c(b.a(bArr, 0));
                    i2 += 8;
                    z = true;
                }
                if ((i & 65535) == 65535 && i2 < eVar.b()) {
                    System.arraycopy(c, i2, bArr2, 0, 4);
                    kVar.a(b.d(bArr2, 0));
                    z = true;
                }
                if (z) {
                    return kVar;
                }
                return null;
            }
        }
        return null;
    }

    private void e() throws net.a.a.c.a {
        try {
            byte[] bArr = new byte[4];
            long length = this.f488a.length() - 22;
            while (true) {
                long j = length - 1;
                this.f488a.seek(length);
                if (((long) b.a((DataInput) this.f488a, bArr)) == 101010256) {
                    this.f488a.seek(((((this.f488a.getFilePointer() - 4) - 4) - 8) - 4) - 4);
                    return;
                }
                length = j;
            }
        } catch (IOException e) {
            throw new net.a.a.c.a((Throwable) e);
        }
    }

    public g a(f fVar) throws net.a.a.c.a {
        if (fVar == null || this.f488a == null) {
            throw new net.a.a.c.a("invalid read parameters for local header");
        }
        long i = fVar.i();
        if (fVar.q() != null && fVar.q().c() > 0) {
            i = fVar.i();
        }
        if (i >= 0) {
            try {
                this.f488a.seek(i);
                g gVar = new g();
                byte[] bArr = new byte[2];
                byte[] bArr2 = new byte[4];
                byte[] bArr3 = new byte[8];
                a(this.f488a, bArr2);
                gVar.a(b.d(bArr2, 0));
                a(this.f488a, bArr);
                gVar.b(b.b(bArr, 0));
                a(this.f488a, bArr);
                gVar.c((b.b(bArr, 0) & 2048) != 0);
                byte b2 = bArr[0];
                if ((b2 & 1) != 0) {
                    gVar.a(true);
                }
                gVar.a(bArr);
                String binaryString = Integer.toBinaryString(b2);
                if (binaryString.length() >= 4) {
                    gVar.b(binaryString.charAt(3) == '1');
                }
                a(this.f488a, bArr);
                gVar.c(b.b(bArr, 0));
                a(this.f488a, bArr2);
                gVar.d(b.d(bArr2, 0));
                a(this.f488a, bArr2);
                gVar.a((long) b.d(bArr2, 0));
                gVar.b((byte[]) bArr2.clone());
                a(this.f488a, bArr2);
                gVar.b(b.a(a(bArr2), 0));
                a(this.f488a, bArr2);
                gVar.c(b.a(a(bArr2), 0));
                a(this.f488a, bArr);
                int b3 = b.b(bArr, 0);
                gVar.e(b3);
                a(this.f488a, bArr);
                int b4 = b.b(bArr, 0);
                gVar.f(b4);
                int i2 = 30;
                if (b3 > 0) {
                    byte[] bArr4 = new byte[b3];
                    a(this.f488a, bArr4);
                    String a2 = c.a(bArr4, gVar.m());
                    if (a2 != null) {
                        if (a2.indexOf(":" + System.getProperty("file.separator")) >= 0) {
                            a2 = a2.substring(a2.indexOf(":" + System.getProperty("file.separator")) + 2);
                        }
                        gVar.a(a2);
                        i2 = 30 + b3;
                    } else {
                        throw new net.a.a.c.a("file name is null, cannot assign file name to local file header");
                    }
                } else {
                    gVar.a((String) null);
                }
                a(gVar);
                gVar.d(i + ((long) (i2 + b4)));
                gVar.a(fVar.n());
                b(gVar);
                c(gVar);
                if (gVar.h() && gVar.i() != 99) {
                    if ((b2 & 64) == 64) {
                        gVar.g(1);
                    } else {
                        gVar.g(0);
                    }
                }
                if (gVar.b() <= 0) {
                    gVar.a(fVar.c());
                    gVar.b(fVar.o());
                }
                if (gVar.c() <= 0) {
                    gVar.b(fVar.d());
                }
                if (gVar.d() <= 0) {
                    gVar.c(fVar.e());
                }
                return gVar;
            } catch (IOException e) {
                throw new net.a.a.c.a((Throwable) e);
            }
        } else {
            throw new net.a.a.c.a("invalid local header offset");
        }
    }

    private void d(f fVar) throws net.a.a.c.a {
        net.a.a.e.a a2;
        if (fVar == null) {
            throw new net.a.a.c.a("file header is null in reading Zip64 Extended Info");
        } else if (fVar.p() != null && fVar.p().size() > 0 && (a2 = a(fVar.p())) != null) {
            fVar.a(a2);
            fVar.i(99);
        }
    }

    private void c(g gVar) throws net.a.a.c.a {
        net.a.a.e.a a2;
        if (gVar == null) {
            throw new net.a.a.c.a("file header is null in reading Zip64 Extended Info");
        } else if (gVar.k() != null && gVar.k().size() > 0 && (a2 = a(gVar.k())) != null) {
            gVar.a(a2);
            gVar.g(99);
        }
    }

    private net.a.a.e.a a(ArrayList arrayList) throws net.a.a.c.a {
        if (arrayList == null) {
            return null;
        }
        int i = 0;
        while (i < arrayList.size()) {
            e eVar = (e) arrayList.get(i);
            if (eVar == null || eVar.a() != 39169) {
                i++;
            } else if (eVar.c() != null) {
                net.a.a.e.a aVar = new net.a.a.e.a();
                aVar.a(39169);
                aVar.a(eVar.b());
                byte[] c = eVar.c();
                aVar.b(b.b(c, 0));
                byte[] bArr = new byte[2];
                System.arraycopy(c, 2, bArr, 0, 2);
                aVar.a(new String(bArr));
                aVar.c(c[4] & 255);
                aVar.d(b.b(c, 5));
                return aVar;
            } else {
                throw new net.a.a.c.a("corrput AES extra data records");
            }
        }
        return null;
    }

    private byte[] a(RandomAccessFile randomAccessFile, byte[] bArr) throws net.a.a.c.a {
        try {
            if (randomAccessFile.read(bArr, 0, bArr.length) != -1) {
                return bArr;
            }
            throw new net.a.a.c.a("unexpected end of file when reading short buff");
        } catch (IOException e) {
            throw new net.a.a.c.a("IOException when reading short buff", (Throwable) e);
        }
    }

    private byte[] a(byte[] bArr) throws net.a.a.c.a {
        if (bArr == null) {
            throw new net.a.a.c.a("input parameter is null, cannot expand to 8 bytes");
        } else if (bArr.length == 4) {
            byte[] bArr2 = new byte[8];
            bArr2[0] = bArr[0];
            bArr2[1] = bArr[1];
            bArr2[2] = bArr[2];
            bArr2[3] = bArr[3];
            return bArr2;
        } else {
            throw new net.a.a.c.a("invalid byte length, cannot expand to 8 bytes");
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\a\b.java ==========

package net.a.a.a;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.a.a.e.f;
import net.a.a.e.h;
import net.a.a.e.l;
import net.a.a.f.a;
import net.a.a.h.c;

/* compiled from: ZipFile */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f490a;

    /* renamed from: b  reason: collision with root package name */
    private int f491b;
    private l c;
    private boolean d;
    private a e;
    private boolean f;
    private String g;

    public b(File file) throws net.a.a.c.a {
        if (file != null) {
            this.f490a = file.getPath();
            this.f491b = 2;
            this.e = new a();
            this.f = false;
            return;
        }
        throw new net.a.a.c.a("Input zip file parameter is not null", 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0058 A[SYNTHETIC, Splitter:B:28:0x0058] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() throws net.a.a.c.a {
        /*
            r5 = this;
            java.lang.String r0 = r5.f490a
            boolean r0 = net.a.a.h.c.d((java.lang.String) r0)
            if (r0 == 0) goto L_0x006c
            java.lang.String r0 = r5.f490a
            boolean r0 = net.a.a.h.c.c((java.lang.String) r0)
            if (r0 == 0) goto L_0x0064
            int r0 = r5.f491b
            r1 = 2
            if (r0 != r1) goto L_0x005c
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x004b, all -> 0x0046 }
            java.io.File r2 = new java.io.File     // Catch:{ FileNotFoundException -> 0x004b, all -> 0x0046 }
            java.lang.String r3 = r5.f490a     // Catch:{ FileNotFoundException -> 0x004b, all -> 0x0046 }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x004b, all -> 0x0046 }
            java.lang.String r3 = "r"
            r1.<init>(r2, r3)     // Catch:{ FileNotFoundException -> 0x004b, all -> 0x0046 }
            net.a.a.e.l r0 = r5.c     // Catch:{ FileNotFoundException -> 0x0044 }
            if (r0 != 0) goto L_0x0040
            net.a.a.a.a r0 = new net.a.a.a.a     // Catch:{ FileNotFoundException -> 0x0044 }
            r0.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0044 }
            java.lang.String r2 = r5.g     // Catch:{ FileNotFoundException -> 0x0044 }
            net.a.a.e.l r0 = r0.a((java.lang.String) r2)     // Catch:{ FileNotFoundException -> 0x0044 }
            r5.c = r0     // Catch:{ FileNotFoundException -> 0x0044 }
            net.a.a.e.l r0 = r5.c     // Catch:{ FileNotFoundException -> 0x0044 }
            if (r0 == 0) goto L_0x0040
            net.a.a.e.l r0 = r5.c     // Catch:{ FileNotFoundException -> 0x0044 }
            java.lang.String r2 = r5.f490a     // Catch:{ FileNotFoundException -> 0x0044 }
            r0.a((java.lang.String) r2)     // Catch:{ FileNotFoundException -> 0x0044 }
        L_0x0040:
            r1.close()     // Catch:{ IOException -> 0x0043 }
        L_0x0043:
            return
        L_0x0044:
            r0 = move-exception
            goto L_0x004f
        L_0x0046:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0056
        L_0x004b:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x004f:
            net.a.a.c.a r2 = new net.a.a.c.a     // Catch:{ all -> 0x0055 }
            r2.<init>((java.lang.Throwable) r0)     // Catch:{ all -> 0x0055 }
            throw r2     // Catch:{ all -> 0x0055 }
        L_0x0055:
            r0 = move-exception
        L_0x0056:
            if (r1 == 0) goto L_0x005b
            r1.close()     // Catch:{ IOException -> 0x005b }
        L_0x005b:
            throw r0
        L_0x005c:
            net.a.a.c.a r0 = new net.a.a.c.a
            java.lang.String r1 = "Invalid mode"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0064:
            net.a.a.c.a r0 = new net.a.a.c.a
            java.lang.String r1 = "no read access for the input zip file"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x006c:
            net.a.a.c.a r0 = new net.a.a.c.a
            java.lang.String r1 = "zip file does not exist"
            r0.<init>((java.lang.String) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.a.a.a.b.c():void");
    }

    public void a(String str) throws net.a.a.c.a {
        a(str, (h) null);
    }

    public void a(String str, h hVar) throws net.a.a.c.a {
        if (!c.a(str)) {
            throw new net.a.a.c.a("output path is null or invalid");
        } else if (c.b(str)) {
            if (this.c == null) {
                c();
            }
            if (this.c == null) {
                throw new net.a.a.c.a("Internal error occurred when extracting zip file");
            } else if (this.e.a() != 1) {
                new net.a.a.g.a(this.c).a(hVar, str, this.e, this.f);
            } else {
                throw new net.a.a.c.a("invalid operation - Zip4j is in busy state");
            }
        } else {
            throw new net.a.a.c.a("invalid output path");
        }
    }

    public void b(String str) throws net.a.a.c.a {
        if (c.a(str)) {
            a(str.toCharArray());
            return;
        }
        throw new NullPointerException();
    }

    public void a(char[] cArr) throws net.a.a.c.a {
        if (this.c == null) {
            c();
            if (this.c == null) {
                throw new net.a.a.c.a("Zip Model is null");
            }
        }
        if (this.c.a() == null || this.c.a().a() == null) {
            throw new net.a.a.c.a("invalid zip file");
        }
        for (int i = 0; i < this.c.a().a().size(); i++) {
            if (this.c.a().a().get(i) != null && ((f) this.c.a().a().get(i)).l()) {
                ((f) this.c.a().a().get(i)).a(cArr);
            }
        }
    }

    public List a() throws net.a.a.c.a {
        c();
        if (this.c == null || this.c.a() == null) {
            return null;
        }
        return this.c.a().a();
    }

    public boolean b() throws net.a.a.c.a {
        if (this.c == null) {
            c();
            if (this.c == null) {
                throw new net.a.a.c.a("Zip Model is null");
            }
        }
        if (this.c.a() == null || this.c.a().a() == null) {
            throw new net.a.a.c.a("invalid zip file");
        }
        ArrayList a2 = this.c.a().a();
        int i = 0;
        while (true) {
            if (i >= a2.size()) {
                break;
            }
            f fVar = (f) a2.get(i);
            if (fVar != null && fVar.l()) {
                this.d = true;
                break;
            }
            i++;
        }
        return this.d;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\b\a.java ==========

package net.a.a.b;

import java.util.Arrays;
import net.a.a.b.a.c;
import net.a.a.e.g;
import net.a.a.h.b;

/* compiled from: AESDecrypter */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private g f492a;

    /* renamed from: b  reason: collision with root package name */
    private net.a.a.b.b.a f493b;
    private net.a.a.b.a.a c;
    private final int d = 2;
    private int e;
    private int f;
    private int g;
    private byte[] h;
    private byte[] i;
    private byte[] j;
    private byte[] k;
    private int l = 1;
    private byte[] m;
    private byte[] n;
    private int o = 0;

    public int a() {
        return 2;
    }

    public a(g gVar, byte[] bArr, byte[] bArr2) throws net.a.a.c.a {
        if (gVar != null) {
            this.f492a = gVar;
            this.k = null;
            this.m = new byte[16];
            this.n = new byte[16];
            a(bArr, bArr2);
            return;
        }
        throw new net.a.a.c.a("one of the input parameters is null in AESDecryptor Constructor");
    }

    private void a(byte[] bArr, byte[] bArr2) throws net.a.a.c.a {
        if (this.f492a != null) {
            net.a.a.e.a l2 = this.f492a.l();
            if (l2 != null) {
                switch (l2.a()) {
                    case 1:
                        this.e = 16;
                        this.f = 16;
                        this.g = 8;
                        break;
                    case 2:
                        this.e = 24;
                        this.f = 24;
                        this.g = 12;
                        break;
                    case 3:
                        this.e = 32;
                        this.f = 32;
                        this.g = 16;
                        break;
                    default:
                        StringBuffer stringBuffer = new StringBuffer("invalid aes key strength for file: ");
                        stringBuffer.append(this.f492a.f());
                        throw new net.a.a.c.a(stringBuffer.toString());
                }
                if (this.f492a.j() == null || this.f492a.j().length <= 0) {
                    throw new net.a.a.c.a("empty or null password provided for AES Decryptor");
                }
                byte[] a2 = a(bArr, this.f492a.j());
                if (a2 == null || a2.length != this.e + this.f + 2) {
                    throw new net.a.a.c.a("invalid derived key");
                }
                this.h = new byte[this.e];
                this.i = new byte[this.f];
                this.j = new byte[2];
                System.arraycopy(a2, 0, this.h, 0, this.e);
                System.arraycopy(a2, this.e, this.i, 0, this.f);
                System.arraycopy(a2, this.e + this.f, this.j, 0, 2);
                if (this.j == null) {
                    throw new net.a.a.c.a("invalid derived password verifier for AES");
                } else if (Arrays.equals(bArr2, this.j)) {
                    this.f493b = new net.a.a.b.b.a(this.h);
                    this.c = new net.a.a.b.a.a("HmacSHA1");
                    this.c.b(this.i);
                } else {
                    StringBuffer stringBuffer2 = new StringBuffer("Wrong Password for file: ");
                    stringBuffer2.append(this.f492a.f());
                    throw new net.a.a.c.a(stringBuffer2.toString(), 5);
                }
            } else {
                throw new net.a.a.c.a("invalid aes extra data record - in init method of AESDecryptor");
            }
        } else {
            throw new net.a.a.c.a("invalid file header in init method of AESDecryptor");
        }
    }

    public int a(byte[] bArr, int i2, int i3) throws net.a.a.c.a {
        if (this.f493b != null) {
            int i4 = i2;
            while (true) {
                int i5 = i2 + i3;
                if (i4 >= i5) {
                    return i3;
                }
                int i6 = i4 + 16;
                try {
                    this.o = i6 <= i5 ? 16 : i5 - i4;
                    this.c.a(bArr, i4, this.o);
                    b.a(this.m, this.l, 16);
                    this.f493b.a(this.m, this.n);
                    for (int i7 = 0; i7 < this.o; i7++) {
                        int i8 = i4 + i7;
                        bArr[i8] = (byte) (bArr[i8] ^ this.n[i7]);
                    }
                    this.l++;
                    i4 = i6;
                } catch (net.a.a.c.a e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new net.a.a.c.a((Throwable) e3);
                }
            }
        } else {
            throw new net.a.a.c.a("AES not initialized properly");
        }
    }

    private byte[] a(byte[] bArr, char[] cArr) throws net.a.a.c.a {
        try {
            return new net.a.a.b.a.b(new c("HmacSHA1", "ISO-8859-1", bArr, 1000)).a(cArr, this.e + this.f + 2);
        } catch (Exception e2) {
            throw new net.a.a.c.a((Throwable) e2);
        }
    }

    public int b() {
        return this.g;
    }

    public byte[] c() {
        return this.c.a();
    }

    public void a(byte[] bArr) {
        this.k = bArr;
    }

    public byte[] d() {
        return this.k;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\b\b.java ==========

package net.a.a.b;

import net.a.a.c.a;

/* compiled from: IDecrypter */
public interface b {
    int a(byte[] bArr, int i, int i2) throws a;
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\b\c.java ==========

package net.a.a.b;

import net.a.a.b.b.b;
import net.a.a.c.a;
import net.a.a.e.f;

/* compiled from: StandardDecrypter */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private f f504a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f505b = new byte[4];
    private b c;

    public c(f fVar, byte[] bArr) throws a {
        if (fVar != null) {
            this.f504a = fVar;
            this.c = new b();
            a(bArr);
            return;
        }
        throw new a("one of more of the input parameters were null in StandardDecryptor");
    }

    public int a(byte[] bArr, int i, int i2) throws a {
        if (i < 0 || i2 < 0) {
            throw new a("one of the input parameters were null in standard decrpyt data");
        }
        int i3 = i;
        while (i3 < i + i2) {
            try {
                byte a2 = (byte) (((bArr[i3] & 255) ^ this.c.a()) & 255);
                this.c.a(a2);
                bArr[i3] = a2;
                i3++;
            } catch (Exception e) {
                throw new a((Throwable) e);
            }
        }
        return i2;
    }

    public void a(byte[] bArr) throws a {
        byte[] o = this.f504a.o();
        this.f505b[3] = (byte) (o[3] & 255);
        this.f505b[2] = (byte) ((o[3] >> 8) & 255);
        this.f505b[1] = (byte) ((o[3] >> 16) & 255);
        int i = 0;
        this.f505b[0] = (byte) ((o[3] >> 24) & 255);
        if (this.f505b[2] > 0 || this.f505b[1] > 0 || this.f505b[0] > 0) {
            throw new IllegalStateException("Invalid CRC in File Header");
        } else if (this.f504a.n() == null || this.f504a.n().length <= 0) {
            throw new a("Wrong password!", 5);
        } else {
            this.c.a(this.f504a.n());
            try {
                byte b2 = bArr[0];
                while (i < 12) {
                    this.c.a((byte) (this.c.a() ^ b2));
                    i++;
                    if (i != 12) {
                        b2 = bArr[i];
                    }
                }
            } catch (Exception e) {
                throw new a((Throwable) e);
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\b\a\a.java ==========

package net.a.a.b.a;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: MacBasedPRF */
public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    protected Mac f494a;

    /* renamed from: b  reason: collision with root package name */
    protected int f495b;
    protected String c;

    public a(String str) {
        this.c = str;
        try {
            this.f494a = Mac.getInstance(str);
            this.f495b = this.f494a.getMacLength();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] a(byte[] bArr) {
        return this.f494a.doFinal(bArr);
    }

    public byte[] a() {
        return this.f494a.doFinal();
    }

    public int b() {
        return this.f495b;
    }

    public void b(byte[] bArr) {
        try {
            this.f494a.init(new SecretKeySpec(bArr, this.c));
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    public void a(byte[] bArr, int i, int i2) {
        try {
            this.f494a.update(bArr, i, i2);
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\b\a\b.java ==========

package net.a.a.b.a;

/* compiled from: PBKDF2Engine */
public class b {

    /* renamed from: a  reason: collision with root package name */
    protected c f496a;

    /* renamed from: b  reason: collision with root package name */
    protected d f497b;

    public b() {
        this.f496a = null;
        this.f497b = null;
    }

    public b(c cVar) {
        this.f496a = cVar;
        this.f497b = null;
    }

    public byte[] a(char[] cArr, int i) {
        byte[] bArr = null;
        if (cArr != null) {
            a(net.a.a.h.b.a(cArr));
            if (i == 0) {
                i = this.f497b.b();
            }
            return a(this.f497b, this.f496a.b(), this.f496a.a(), i);
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr) {
        if (this.f497b == null) {
            this.f497b = new a(this.f496a.c());
        }
        this.f497b.b(bArr);
    }

    /* access modifiers changed from: protected */
    public byte[] a(d dVar, byte[] bArr, int i, int i2) {
        int i3 = i2;
        byte[] bArr2 = bArr == null ? new byte[0] : bArr;
        int b2 = dVar.b();
        int a2 = a(i3, b2);
        int i4 = i3 - ((a2 - 1) * b2);
        byte[] bArr3 = new byte[(a2 * b2)];
        int i5 = 0;
        for (int i6 = 1; i6 <= a2; i6++) {
            a(bArr3, i5, dVar, bArr2, i, i6);
            i5 += b2;
        }
        if (i4 >= b2) {
            return bArr3;
        }
        byte[] bArr4 = new byte[i3];
        System.arraycopy(bArr3, 0, bArr4, 0, i3);
        return bArr4;
    }

    /* access modifiers changed from: protected */
    public int a(int i, int i2) {
        return (i / i2) + (i % i2 > 0 ? 1 : 0);
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr, int i, d dVar, byte[] bArr2, int i2, int i3) {
        int b2 = dVar.b();
        byte[] bArr3 = new byte[b2];
        byte[] bArr4 = new byte[(bArr2.length + 4)];
        System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
        a(bArr4, bArr2.length, i3);
        for (int i4 = 0; i4 < i2; i4++) {
            bArr4 = dVar.a(bArr4);
            a(bArr3, bArr4);
        }
        System.arraycopy(bArr3, 0, bArr, i, b2);
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr, int i, int i2) {
        bArr[i + 0] = (byte) (i2 / 16777216);
        bArr[i + 1] = (byte) (i2 / 65536);
        bArr[i + 2] = (byte) (i2 / 256);
        bArr[i + 3] = (byte) i2;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\b\a\c.java ==========

package net.a.a.b.a;

/* compiled from: PBKDF2Parameters */
public class c {

    /* renamed from: a  reason: collision with root package name */
    protected byte[] f498a;

    /* renamed from: b  reason: collision with root package name */
    protected int f499b;
    protected String c;
    protected String d;
    protected byte[] e;

    public c() {
        this.c = null;
        this.d = "UTF-8";
        this.f498a = null;
        this.f499b = 1000;
        this.e = null;
    }

    public c(String str, String str2, byte[] bArr, int i) {
        this.c = str;
        this.d = str2;
        this.f498a = bArr;
        this.f499b = i;
        this.e = null;
    }

    public int a() {
        return this.f499b;
    }

    public byte[] b() {
        return this.f498a;
    }

    public String c() {
        return this.c;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\b\a\d.java ==========

package net.a.a.b.a;

/* compiled from: PRF */
interface d {
    byte[] a(byte[] bArr);

    int b();

    void b(byte[] bArr);
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\b\b\a.java ==========

package net.a.a.b.b;

import java.lang.reflect.Array;

/* compiled from: AESEngine */
public class a {
    private static final byte[] g;
    private static final int[] h = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, 239, 197, 145};
    private static final int[] i;

    /* renamed from: a  reason: collision with root package name */
    private int f500a;

    /* renamed from: b  reason: collision with root package name */
    private int[][] f501b = null;
    private int c;
    private int d;
    private int e;
    private int f;

    private int a(int i2, int i3) {
        return (i2 << (-i3)) | (i2 >>> i3);
    }

    public a(byte[] bArr) throws net.a.a.c.a {
        a(bArr);
    }

    public void a(byte[] bArr) throws net.a.a.c.a {
        this.f501b = b(bArr);
    }

    private int[][] b(byte[] bArr) throws net.a.a.c.a {
        int length = bArr.length / 4;
        if ((length == 4 || length == 6 || length == 8) && length * 4 == bArr.length) {
            this.f500a = length + 6;
            int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{this.f500a + 1, 4});
            int i2 = 0;
            int i3 = 0;
            while (i2 < bArr.length) {
                iArr[i3 >> 2][i3 & 3] = (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | (bArr[i2 + 3] << 24);
                i2 += 4;
                i3++;
            }
            int i4 = (this.f500a + 1) << 2;
            for (int i5 = length; i5 < i4; i5++) {
                int i6 = i5 - 1;
                int i7 = iArr[i6 >> 2][i6 & 3];
                int i8 = i5 % length;
                if (i8 == 0) {
                    i7 = a(a(i7, 8)) ^ h[(i5 / length) - 1];
                } else if (length > 6 && i8 == 4) {
                    i7 = a(i7);
                }
                int i9 = i5 - length;
                iArr[i5 >> 2][i5 & 3] = i7 ^ iArr[i9 >> 2][i9 & 3];
            }
            return iArr;
        }
        throw new net.a.a.c.a("invalid key length (not 128/192/256)");
    }

    public int a(byte[] bArr, byte[] bArr2) throws net.a.a.c.a {
        return a(bArr, 0, bArr2, 0);
    }

    public int a(byte[] bArr, int i2, byte[] bArr2, int i3) throws net.a.a.c.a {
        if (this.f501b == null) {
            throw new net.a.a.c.a("AES engine not initialised");
        } else if (i2 + 16 > bArr.length) {
            throw new net.a.a.c.a("input buffer too short");
        } else if (i3 + 16 <= bArr2.length) {
            a(bArr, i2);
            a(this.f501b);
            b(bArr2, i3);
            return 16;
        } else {
            throw new net.a.a.c.a("output buffer too short");
        }
    }

    private final void a(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        this.c = bArr[i2] & 255;
        int i4 = i3 + 1;
        this.c |= (bArr[i3] & 255) << 8;
        int i5 = i4 + 1;
        this.c |= (bArr[i4] & 255) << 16;
        int i6 = i5 + 1;
        this.c |= bArr[i5] << 24;
        int i7 = i6 + 1;
        this.d = bArr[i6] & 255;
        int i8 = i7 + 1;
        this.d = ((bArr[i7] & 255) << 8) | this.d;
        int i9 = i8 + 1;
        this.d |= (bArr[i8] & 255) << 16;
        int i10 = i9 + 1;
        this.d |= bArr[i9] << 24;
        int i11 = i10 + 1;
        this.e = bArr[i10] & 255;
        int i12 = i11 + 1;
        this.e = ((bArr[i11] & 255) << 8) | this.e;
        int i13 = i12 + 1;
        this.e |= (bArr[i12] & 255) << 16;
        int i14 = i13 + 1;
        this.e |= bArr[i13] << 24;
        int i15 = i14 + 1;
        this.f = bArr[i14] & 255;
        int i16 = i15 + 1;
        this.f = ((bArr[i15] & 255) << 8) | this.f;
        this.f |= (bArr[i16] & 255) << 16;
        this.f = (bArr[i16 + 1] << 24) | this.f;
    }

    private final void b(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        bArr[i2] = (byte) this.c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (this.c >> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (this.c >> 16);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (this.c >> 24);
        int i7 = i6 + 1;
        bArr[i6] = (byte) this.d;
        int i8 = i7 + 1;
        bArr[i7] = (byte) (this.d >> 8);
        int i9 = i8 + 1;
        bArr[i8] = (byte) (this.d >> 16);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (this.d >> 24);
        int i11 = i10 + 1;
        bArr[i10] = (byte) this.e;
        int i12 = i11 + 1;
        bArr[i11] = (byte) (this.e >> 8);
        int i13 = i12 + 1;
        bArr[i12] = (byte) (this.e >> 16);
        int i14 = i13 + 1;
        bArr[i13] = (byte) (this.e >> 24);
        int i15 = i14 + 1;
        bArr[i14] = (byte) this.f;
        int i16 = i15 + 1;
        bArr[i15] = (byte) (this.f >> 8);
        bArr[i16] = (byte) (this.f >> 16);
        bArr[i16 + 1] = (byte) (this.f >> 24);
    }

    private final void a(int[][] iArr) {
        this.c ^= iArr[0][0];
        this.d ^= iArr[0][1];
        this.e ^= iArr[0][2];
        char c2 = 3;
        this.f ^= iArr[0][3];
        int i2 = 1;
        while (i2 < this.f500a - 1) {
            int a2 = (((i[this.c & 255] ^ a(i[(this.d >> 8) & 255], 24)) ^ a(i[(this.e >> 16) & 255], 16)) ^ a(i[(this.f >> 24) & 255], 8)) ^ iArr[i2][0];
            int a3 = (((i[this.d & 255] ^ a(i[(this.e >> 8) & 255], 24)) ^ a(i[(this.f >> 16) & 255], 16)) ^ a(i[(this.c >> 24) & 255], 8)) ^ iArr[i2][1];
            int a4 = (((i[this.e & 255] ^ a(i[(this.f >> 8) & 255], 24)) ^ a(i[(this.c >> 16) & 255], 16)) ^ a(i[(this.d >> 24) & 255], 8)) ^ iArr[i2][2];
            int i3 = i2 + 1;
            int a5 = iArr[i2][3] ^ (((i[this.f & 255] ^ a(i[(this.c >> 8) & 255], 24)) ^ a(i[(this.d >> 16) & 255], 16)) ^ a(i[(this.e >> 24) & 255], 8));
            this.c = (((i[a2 & 255] ^ a(i[(a3 >> 8) & 255], 24)) ^ a(i[(a4 >> 16) & 255], 16)) ^ a(i[(a5 >> 24) & 255], 8)) ^ iArr[i3][0];
            this.d = (((i[a3 & 255] ^ a(i[(a4 >> 8) & 255], 24)) ^ a(i[(a5 >> 16) & 255], 16)) ^ a(i[(a2 >> 24) & 255], 8)) ^ iArr[i3][1];
            this.e = (((i[a4 & 255] ^ a(i[(a5 >> 8) & 255], 24)) ^ a(i[(a2 >> 16) & 255], 16)) ^ a(i[(a3 >> 24) & 255], 8)) ^ iArr[i3][2];
            this.f = (((i[a5 & 255] ^ a(i[(a2 >> 8) & 255], 24)) ^ a(i[(a3 >> 16) & 255], 16)) ^ a(i[(a4 >> 24) & 255], 8)) ^ iArr[i3][3];
            i2 = i3 + 1;
            c2 = 3;
        }
        int a6 = (((i[this.c & 255] ^ a(i[(this.d >> 8) & 255], 24)) ^ a(i[(this.e >> 16) & 255], 16)) ^ a(i[(this.f >> 24) & 255], 8)) ^ iArr[i2][0];
        int a7 = (((i[this.d & 255] ^ a(i[(this.e >> 8) & 255], 24)) ^ a(i[(this.f >> 16) & 255], 16)) ^ a(i[(this.c >> 24) & 255], 8)) ^ iArr[i2][1];
        int a8 = (((i[this.e & 255] ^ a(i[(this.f >> 8) & 255], 24)) ^ a(i[(this.c >> 16) & 255], 16)) ^ a(i[(this.d >> 24) & 255], 8)) ^ iArr[i2][2];
        int i4 = i2 + 1;
        int a9 = iArr[i2][c2] ^ (((i[this.f & 255] ^ a(i[(this.c >> 8) & 255], 24)) ^ a(i[(this.d >> 16) & 255], 16)) ^ a(i[(this.e >> 24) & 255], 8));
        this.c = iArr[i4][0] ^ (((((g[(a7 >> 8) & 255] & 255) << 8) ^ (g[a6 & 255] & 255)) ^ ((g[(a8 >> 16) & 255] & 255) << 16)) ^ (g[(a9 >> 24) & 255] << 24));
        this.d = ((((g[a7 & 255] & 255) ^ ((g[(a8 >> 8) & 255] & 255) << 8)) ^ ((g[(a9 >> 16) & 255] & 255) << 16)) ^ (g[(a6 >> 24) & 255] << 24)) ^ iArr[i4][1];
        this.e = ((((g[a8 & 255] & 255) ^ ((g[(a9 >> 8) & 255] & 255) << 8)) ^ ((g[(a6 >> 16) & 255] & 255) << 16)) ^ (g[(a7 >> 24) & 255] << 24)) ^ iArr[i4][2];
        this.f = iArr[i4][3] ^ ((((g[a9 & 255] & 255) ^ ((g[(a6 >> 8) & 255] & 255) << 8)) ^ ((g[(a7 >> 16) & 255] & 255) << 16)) ^ (g[(a8 >> 24) & 255] << 24));
    }

    private int a(int i2) {
        return (g[(i2 >> 24) & 255] << 24) | (g[i2 & 255] & 255) | ((g[(i2 >> 8) & 255] & 255) << 8) | ((g[(i2 >> 16) & 255] & 255) << 16);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: int[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 256(0x100, float:3.59E-43)
            byte[] r0 = new byte[r0]
            r1 = 99
            r2 = 0
            r0[r2] = r1
            r2 = 124(0x7c, float:1.74E-43)
            r3 = 1
            r0[r3] = r2
            r4 = 119(0x77, float:1.67E-43)
            r5 = 2
            r0[r5] = r4
            r6 = 123(0x7b, float:1.72E-43)
            r7 = 3
            r0[r7] = r6
            r8 = 4
            r9 = -14
            r0[r8] = r9
            r9 = 107(0x6b, float:1.5E-43)
            r10 = 5
            r0[r10] = r9
            r11 = 111(0x6f, float:1.56E-43)
            r12 = 6
            r0[r12] = r11
            r13 = 7
            r14 = -59
            r0[r13] = r14
            r14 = 8
            r15 = 48
            r0[r14] = r15
            r15 = 9
            r0[r15] = r3
            r15 = 10
            r16 = 103(0x67, float:1.44E-43)
            r0[r15] = r16
            r15 = 11
            r16 = 43
            r0[r15] = r16
            r15 = 12
            r16 = -2
            r0[r15] = r16
            r15 = 13
            r16 = -41
            r0[r15] = r16
            r15 = 14
            r16 = -85
            r0[r15] = r16
            r15 = 15
            r16 = 118(0x76, float:1.65E-43)
            r0[r15] = r16
            r15 = 16
            r16 = -54
            r0[r15] = r16
            r15 = 17
            r16 = -126(0xffffffffffffff82, float:NaN)
            r0[r15] = r16
            r15 = 18
            r16 = -55
            r0[r15] = r16
            r15 = 19
            r16 = 125(0x7d, float:1.75E-43)
            r0[r15] = r16
            r15 = 20
            r16 = -6
            r0[r15] = r16
            r15 = 21
            r16 = 89
            r0[r15] = r16
            r15 = 22
            r16 = 71
            r0[r15] = r16
            r15 = 23
            r16 = -16
            r0[r15] = r16
            r15 = 24
            r16 = -83
            r0[r15] = r16
            r15 = 25
            r16 = -44
            r0[r15] = r16
            r15 = 26
            r16 = -94
            r0[r15] = r16
            r15 = 27
            r16 = -81
            r0[r15] = r16
            r15 = 28
            r16 = -100
            r0[r15] = r16
            r15 = 29
            r16 = -92
            r0[r15] = r16
            r15 = 30
            r16 = 114(0x72, float:1.6E-43)
            r0[r15] = r16
            r16 = 31
            r17 = -64
            r0[r16] = r17
            r16 = 32
            r17 = -73
            r0[r16] = r17
            r16 = 33
            r17 = -3
            r0[r16] = r17
            r16 = 34
            r17 = -109(0xffffffffffffff93, float:NaN)
            r0[r16] = r17
            r16 = 35
            r17 = 38
            r0[r16] = r17
            r16 = 36
            r17 = 54
            r0[r16] = r17
            r16 = 37
            r17 = 63
            r0[r16] = r17
            r16 = 38
            r17 = -9
            r0[r16] = r17
            r16 = 39
            r17 = -52
            r0[r16] = r17
            r16 = 40
            r17 = 52
            r0[r16] = r17
            r16 = 41
            r17 = -91
            r0[r16] = r17
            r16 = 42
            r17 = -27
            r0[r16] = r17
            r16 = 43
            r17 = -15
            r0[r16] = r17
            r16 = 44
            r17 = 113(0x71, float:1.58E-43)
            r0[r16] = r17
            r16 = 45
            r17 = -40
            r0[r16] = r17
            r16 = 46
            r17 = 49
            r0[r16] = r17
            r16 = 47
            r17 = 21
            r0[r16] = r17
            r16 = 48
            r0[r16] = r8
            r16 = 49
            r17 = -57
            r0[r16] = r17
            r16 = 50
            r17 = 35
            r0[r16] = r17
            r16 = 51
            r17 = -61
            r0[r16] = r17
            r16 = 52
            r17 = 24
            r0[r16] = r17
            r16 = 53
            r17 = -106(0xffffffffffffff96, float:NaN)
            r0[r16] = r17
            r16 = 54
            r0[r16] = r10
            r16 = 55
            r17 = -102(0xffffffffffffff9a, float:NaN)
            r0[r16] = r17
            r16 = 56
            r0[r16] = r13
            r16 = 57
            r17 = 18
            r0[r16] = r17
            r16 = 58
            r17 = -128(0xffffffffffffff80, float:NaN)
            r0[r16] = r17
            r16 = 59
            r17 = -30
            r0[r16] = r17
            r16 = 60
            r17 = -21
            r0[r16] = r17
            r16 = 61
            r17 = 39
            r0[r16] = r17
            r16 = 62
            r17 = -78
            r0[r16] = r17
            r16 = 63
            r17 = 117(0x75, float:1.64E-43)
            r0[r16] = r17
            r16 = 64
            r17 = 9
            r0[r16] = r17
            r16 = 65
            r17 = -125(0xffffffffffffff83, float:NaN)
            r0[r16] = r17
            r16 = 66
            r17 = 44
            r0[r16] = r17
            r16 = 67
            r17 = 26
            r0[r16] = r17
            r16 = 68
            r17 = 27
            r0[r16] = r17
            r16 = 69
            r17 = 110(0x6e, float:1.54E-43)
            r0[r16] = r17
            r16 = 70
            r17 = 90
            r0[r16] = r17
            r16 = 71
            r17 = -96
            r0[r16] = r17
            r16 = 72
            r17 = 82
            r0[r16] = r17
            r16 = 73
            r17 = 59
            r0[r16] = r17
            r16 = 74
            r17 = -42
            r0[r16] = r17
            r16 = 75
            r17 = -77
            r0[r16] = r17
            r16 = 76
            r17 = 41
            r0[r16] = r17
            r16 = 77
            r17 = -29
            r0[r16] = r17
            r16 = 78
            r17 = 47
            r0[r16] = r17
            r16 = 79
            r17 = -124(0xffffffffffffff84, float:NaN)
            r0[r16] = r17
            r16 = 80
            r17 = 83
            r0[r16] = r17
            r16 = 81
            r17 = -47
            r0[r16] = r17
            r16 = 83
            r17 = -19
            r0[r16] = r17
            r16 = 84
            r17 = 32
            r0[r16] = r17
            r16 = 85
            r17 = -4
            r0[r16] = r17
            r16 = 86
            r17 = -79
            r0[r16] = r17
            r16 = 87
            r17 = 91
            r0[r16] = r17
            r16 = 88
            r17 = 106(0x6a, float:1.49E-43)
            r0[r16] = r17
            r16 = 89
            r17 = -53
            r0[r16] = r17
            r16 = 90
            r17 = -66
            r0[r16] = r17
            r16 = 91
            r17 = 57
            r0[r16] = r17
            r16 = 92
            r17 = 74
            r0[r16] = r17
            r16 = 93
            r17 = 76
            r0[r16] = r17
            r16 = 94
            r17 = 88
            r0[r16] = r17
            r16 = 95
            r17 = -49
            r0[r16] = r17
            r16 = 96
            r17 = -48
            r0[r16] = r17
            r16 = 97
            r17 = -17
            r0[r16] = r17
            r16 = 98
            r17 = -86
            r0[r16] = r17
            r16 = -5
            r0[r1] = r16
            r16 = 100
            r17 = 67
            r0[r16] = r17
            r16 = 101(0x65, float:1.42E-43)
            r17 = 77
            r0[r16] = r17
            r16 = 102(0x66, float:1.43E-43)
            r17 = 51
            r0[r16] = r17
            r16 = 103(0x67, float:1.44E-43)
            r17 = -123(0xffffffffffffff85, float:NaN)
            r0[r16] = r17
            r16 = 104(0x68, float:1.46E-43)
            r17 = 69
            r0[r16] = r17
            r16 = 105(0x69, float:1.47E-43)
            r17 = -7
            r0[r16] = r17
            r16 = 106(0x6a, float:1.49E-43)
            r0[r16] = r5
            r16 = 127(0x7f, float:1.78E-43)
            r0[r9] = r16
            r16 = 108(0x6c, float:1.51E-43)
            r17 = 80
            r0[r16] = r17
            r16 = 109(0x6d, float:1.53E-43)
            r17 = 60
            r0[r16] = r17
            r16 = 110(0x6e, float:1.54E-43)
            r17 = -97
            r0[r16] = r17
            r16 = -88
            r0[r11] = r16
            r16 = 112(0x70, float:1.57E-43)
            r17 = 81
            r0[r16] = r17
            r16 = 113(0x71, float:1.58E-43)
            r17 = -93
            r0[r16] = r17
            r16 = 114(0x72, float:1.6E-43)
            r17 = 64
            r0[r16] = r17
            r16 = 115(0x73, float:1.61E-43)
            r17 = -113(0xffffffffffffff8f, float:NaN)
            r0[r16] = r17
            r16 = 116(0x74, float:1.63E-43)
            r17 = -110(0xffffffffffffff92, float:NaN)
            r0[r16] = r17
            r16 = 117(0x75, float:1.64E-43)
            r17 = -99
            r0[r16] = r17
            r16 = 118(0x76, float:1.65E-43)
            r17 = 56
            r0[r16] = r17
            r16 = -11
            r0[r4] = r16
            r16 = 120(0x78, float:1.68E-43)
            r17 = -68
            r0[r16] = r17
            r16 = 121(0x79, float:1.7E-43)
            r17 = -74
            r0[r16] = r17
            r16 = 122(0x7a, float:1.71E-43)
            r17 = -38
            r0[r16] = r17
            r16 = 33
            r0[r6] = r16
            r16 = 16
            r0[r2] = r16
            r16 = 125(0x7d, float:1.75E-43)
            r17 = -1
            r0[r16] = r17
            r16 = 126(0x7e, float:1.77E-43)
            r17 = -13
            r0[r16] = r17
            r16 = 127(0x7f, float:1.78E-43)
            r17 = -46
            r0[r16] = r17
            r16 = 128(0x80, float:1.794E-43)
            r17 = -51
            r0[r16] = r17
            r16 = 129(0x81, float:1.81E-43)
            r17 = 12
            r0[r16] = r17
            r16 = 130(0x82, float:1.82E-43)
            r17 = 19
            r0[r16] = r17
            r16 = 131(0x83, float:1.84E-43)
            r17 = -20
            r0[r16] = r17
            r16 = 132(0x84, float:1.85E-43)
            r17 = 95
            r0[r16] = r17
            r16 = 133(0x85, float:1.86E-43)
            r17 = -105(0xffffffffffffff97, float:NaN)
            r0[r16] = r17
            r16 = 134(0x86, float:1.88E-43)
            r17 = 68
            r0[r16] = r17
            r16 = 135(0x87, float:1.89E-43)
            r17 = 23
            r0[r16] = r17
            r16 = 136(0x88, float:1.9E-43)
            r17 = -60
            r0[r16] = r17
            r16 = 137(0x89, float:1.92E-43)
            r17 = -89
            r0[r16] = r17
            r16 = 138(0x8a, float:1.93E-43)
            r17 = 126(0x7e, float:1.77E-43)
            r0[r16] = r17
            r16 = 139(0x8b, float:1.95E-43)
            r17 = 61
            r0[r16] = r17
            r16 = 140(0x8c, float:1.96E-43)
            r17 = 100
            r0[r16] = r17
            r16 = 141(0x8d, float:1.98E-43)
            r17 = 93
            r0[r16] = r17
            r16 = 142(0x8e, float:1.99E-43)
            r17 = 25
            r0[r16] = r17
            r16 = 143(0x8f, float:2.0E-43)
            r17 = 115(0x73, float:1.61E-43)
            r0[r16] = r17
            r16 = 144(0x90, float:2.02E-43)
            r17 = 96
            r0[r16] = r17
            r16 = 145(0x91, float:2.03E-43)
            r17 = -127(0xffffffffffffff81, float:NaN)
            r0[r16] = r17
            r16 = 146(0x92, float:2.05E-43)
            r17 = 79
            r0[r16] = r17
            r16 = 147(0x93, float:2.06E-43)
            r17 = -36
            r0[r16] = r17
            r16 = 148(0x94, float:2.07E-43)
            r17 = 34
            r0[r16] = r17
            r16 = 149(0x95, float:2.09E-43)
            r17 = 42
            r0[r16] = r17
            r16 = 150(0x96, float:2.1E-43)
            r17 = -112(0xffffffffffffff90, float:NaN)
            r0[r16] = r17
            r16 = 151(0x97, float:2.12E-43)
            r17 = -120(0xffffffffffffff88, float:NaN)
            r0[r16] = r17
            r16 = 152(0x98, float:2.13E-43)
            r17 = 70
            r0[r16] = r17
            r16 = 153(0x99, float:2.14E-43)
            r17 = -18
            r0[r16] = r17
            r16 = 154(0x9a, float:2.16E-43)
            r17 = -72
            r0[r16] = r17
            r16 = 155(0x9b, float:2.17E-43)
            r17 = 20
            r0[r16] = r17
            r16 = 156(0x9c, float:2.19E-43)
            r17 = -34
            r0[r16] = r17
            r16 = 157(0x9d, float:2.2E-43)
            r17 = 94
            r0[r16] = r17
            r16 = 158(0x9e, float:2.21E-43)
            r17 = 11
            r0[r16] = r17
            r16 = 159(0x9f, float:2.23E-43)
            r17 = -37
            r0[r16] = r17
            r16 = 160(0xa0, float:2.24E-43)
            r17 = -32
            r0[r16] = r17
            r16 = 161(0xa1, float:2.26E-43)
            r17 = 50
            r0[r16] = r17
            r16 = 162(0xa2, float:2.27E-43)
            r17 = 58
            r0[r16] = r17
            r16 = 163(0xa3, float:2.28E-43)
            r17 = 10
            r0[r16] = r17
            r16 = 164(0xa4, float:2.3E-43)
            r17 = 73
            r0[r16] = r17
            r16 = 165(0xa5, float:2.31E-43)
            r0[r16] = r12
            r16 = 166(0xa6, float:2.33E-43)
            r17 = 36
            r0[r16] = r17
            r16 = 167(0xa7, float:2.34E-43)
            r17 = 92
            r0[r16] = r17
            r16 = 168(0xa8, float:2.35E-43)
            r17 = -62
            r0[r16] = r17
            r16 = 169(0xa9, float:2.37E-43)
            r17 = -45
            r0[r16] = r17
            r16 = 170(0xaa, float:2.38E-43)
            r17 = -84
            r0[r16] = r17
            r16 = 171(0xab, float:2.4E-43)
            r17 = 98
            r0[r16] = r17
            r16 = 172(0xac, float:2.41E-43)
            r17 = -111(0xffffffffffffff91, float:NaN)
            r0[r16] = r17
            r16 = 173(0xad, float:2.42E-43)
            r17 = -107(0xffffffffffffff95, float:NaN)
            r0[r16] = r17
            r16 = 174(0xae, float:2.44E-43)
            r17 = -28
            r0[r16] = r17
            r16 = 175(0xaf, float:2.45E-43)
            r17 = 121(0x79, float:1.7E-43)
            r0[r16] = r17
            r16 = 176(0xb0, float:2.47E-43)
            r17 = -25
            r0[r16] = r17
            r16 = 177(0xb1, float:2.48E-43)
            r17 = -56
            r0[r16] = r17
            r16 = 178(0xb2, float:2.5E-43)
            r17 = 55
            r0[r16] = r17
            r16 = 179(0xb3, float:2.51E-43)
            r17 = 109(0x6d, float:1.53E-43)
            r0[r16] = r17
            r16 = 180(0xb4, float:2.52E-43)
            r17 = -115(0xffffffffffffff8d, float:NaN)
            r0[r16] = r17
            r16 = 181(0xb5, float:2.54E-43)
            r17 = -43
            r0[r16] = r17
            r16 = 182(0xb6, float:2.55E-43)
            r17 = 78
            r0[r16] = r17
            r16 = 183(0xb7, float:2.56E-43)
            r17 = -87
            r0[r16] = r17
            r16 = 184(0xb8, float:2.58E-43)
            r17 = 108(0x6c, float:1.51E-43)
            r0[r16] = r17
            r16 = 185(0xb9, float:2.59E-43)
            r17 = 86
            r0[r16] = r17
            r16 = 186(0xba, float:2.6E-43)
            r17 = -12
            r0[r16] = r17
            r16 = 187(0xbb, float:2.62E-43)
            r17 = -22
            r0[r16] = r17
            r16 = 188(0xbc, float:2.63E-43)
            r17 = 101(0x65, float:1.42E-43)
            r0[r16] = r17
            r16 = 189(0xbd, float:2.65E-43)
            r17 = 122(0x7a, float:1.71E-43)
            r0[r16] = r17
            r16 = 190(0xbe, float:2.66E-43)
            r17 = -82
            r0[r16] = r17
            r16 = 191(0xbf, float:2.68E-43)
            r0[r16] = r14
            r16 = 192(0xc0, float:2.69E-43)
            r17 = -70
            r0[r16] = r17
            r16 = 193(0xc1, float:2.7E-43)
            r17 = 120(0x78, float:1.68E-43)
            r0[r16] = r17
            r16 = 194(0xc2, float:2.72E-43)
            r17 = 37
            r0[r16] = r17
            r16 = 195(0xc3, float:2.73E-43)
            r17 = 46
            r0[r16] = r17
            r16 = 196(0xc4, float:2.75E-43)
            r17 = 28
            r0[r16] = r17
            r16 = 197(0xc5, float:2.76E-43)
            r17 = -90
            r0[r16] = r17
            r16 = 198(0xc6, float:2.77E-43)
            r17 = -76
            r0[r16] = r17
            r16 = 199(0xc7, float:2.79E-43)
            r17 = -58
            r0[r16] = r17
            r16 = 200(0xc8, float:2.8E-43)
            r17 = -24
            r0[r16] = r17
            r16 = 201(0xc9, float:2.82E-43)
            r17 = -35
            r0[r16] = r17
            r16 = 202(0xca, float:2.83E-43)
            r17 = 116(0x74, float:1.63E-43)
            r0[r16] = r17
            r16 = 203(0xcb, float:2.84E-43)
            r17 = 31
            r0[r16] = r17
            r16 = 204(0xcc, float:2.86E-43)
            r17 = 75
            r0[r16] = r17
            r16 = 205(0xcd, float:2.87E-43)
            r17 = -67
            r0[r16] = r17
            r16 = 206(0xce, float:2.89E-43)
            r17 = -117(0xffffffffffffff8b, float:NaN)
            r0[r16] = r17
            r16 = 207(0xcf, float:2.9E-43)
            r17 = -118(0xffffffffffffff8a, float:NaN)
            r0[r16] = r17
            r16 = 208(0xd0, float:2.91E-43)
            r17 = 112(0x70, float:1.57E-43)
            r0[r16] = r17
            r16 = 209(0xd1, float:2.93E-43)
            r17 = 62
            r0[r16] = r17
            r16 = 210(0xd2, float:2.94E-43)
            r17 = -75
            r0[r16] = r17
            r16 = 211(0xd3, float:2.96E-43)
            r17 = 102(0x66, float:1.43E-43)
            r0[r16] = r17
            r16 = 212(0xd4, float:2.97E-43)
            r17 = 72
            r0[r16] = r17
            r16 = 213(0xd5, float:2.98E-43)
            r0[r16] = r7
            r16 = 214(0xd6, float:3.0E-43)
            r17 = -10
            r0[r16] = r17
            r16 = 215(0xd7, float:3.01E-43)
            r17 = 14
            r0[r16] = r17
            r16 = 216(0xd8, float:3.03E-43)
            r17 = 97
            r0[r16] = r17
            r16 = 217(0xd9, float:3.04E-43)
            r17 = 53
            r0[r16] = r17
            r16 = 218(0xda, float:3.05E-43)
            r17 = 87
            r0[r16] = r17
            r16 = 219(0xdb, float:3.07E-43)
            r17 = -71
            r0[r16] = r17
            r16 = 220(0xdc, float:3.08E-43)
            r17 = -122(0xffffffffffffff86, float:NaN)
            r0[r16] = r17
            r16 = 221(0xdd, float:3.1E-43)
            r17 = -63
            r0[r16] = r17
            r16 = 222(0xde, float:3.11E-43)
            r17 = 29
            r0[r16] = r17
            r16 = 223(0xdf, float:3.12E-43)
            r17 = -98
            r0[r16] = r17
            r16 = 224(0xe0, float:3.14E-43)
            r17 = -31
            r0[r16] = r17
            r16 = 225(0xe1, float:3.15E-43)
            r17 = -8
            r0[r16] = r17
            r16 = 226(0xe2, float:3.17E-43)
            r17 = -104(0xffffffffffffff98, float:NaN)
            r0[r16] = r17
            r16 = 227(0xe3, float:3.18E-43)
            r17 = 17
            r0[r16] = r17
            r16 = 228(0xe4, float:3.2E-43)
            r17 = 105(0x69, float:1.47E-43)
            r0[r16] = r17
            r16 = 229(0xe5, float:3.21E-43)
            r17 = -39
            r0[r16] = r17
            r16 = 230(0xe6, float:3.22E-43)
            r17 = -114(0xffffffffffffff8e, float:NaN)
            r0[r16] = r17
            r16 = 231(0xe7, float:3.24E-43)
            r17 = -108(0xffffffffffffff94, float:NaN)
            r0[r16] = r17
            r16 = 232(0xe8, float:3.25E-43)
            r17 = -101(0xffffffffffffff9b, float:NaN)
            r0[r16] = r17
            r16 = 233(0xe9, float:3.27E-43)
            r0[r16] = r15
            r16 = 234(0xea, float:3.28E-43)
            r17 = -121(0xffffffffffffff87, float:NaN)
            r0[r16] = r17
            r16 = 235(0xeb, float:3.3E-43)
            r17 = -23
            r0[r16] = r17
            r16 = 236(0xec, float:3.31E-43)
            r17 = -50
            r0[r16] = r17
            r16 = 237(0xed, float:3.32E-43)
            r17 = 85
            r0[r16] = r17
            r16 = 238(0xee, float:3.34E-43)
            r17 = 40
            r0[r16] = r17
            r16 = 239(0xef, float:3.35E-43)
            r17 = -33
            r0[r16] = r17
            r16 = 240(0xf0, float:3.36E-43)
            r17 = -116(0xffffffffffffff8c, float:NaN)
            r0[r16] = r17
            r16 = 241(0xf1, float:3.38E-43)
            r17 = -95
            r0[r16] = r17
            r16 = 242(0xf2, float:3.39E-43)
            r17 = -119(0xffffffffffffff89, float:NaN)
            r0[r16] = r17
            r16 = 243(0xf3, float:3.4E-43)
            r17 = 13
            r0[r16] = r17
            r16 = 244(0xf4, float:3.42E-43)
            r17 = -65
            r0[r16] = r17
            r16 = 245(0xf5, float:3.43E-43)
            r17 = -26
            r0[r16] = r17
            r16 = 246(0xf6, float:3.45E-43)
            r17 = 66
            r0[r16] = r17
            r16 = 247(0xf7, float:3.46E-43)
            r17 = 104(0x68, float:1.46E-43)
            r0[r16] = r17
            r16 = 248(0xf8, float:3.48E-43)
            r17 = 65
            r0[r16] = r17
            r16 = 249(0xf9, float:3.49E-43)
            r17 = -103(0xffffffffffffff99, float:NaN)
            r0[r16] = r17
            r16 = 250(0xfa, float:3.5E-43)
            r17 = 45
            r0[r16] = r17
            r16 = 251(0xfb, float:3.52E-43)
            r17 = 15
            r0[r16] = r17
            r16 = 252(0xfc, float:3.53E-43)
            r17 = -80
            r0[r16] = r17
            r16 = 253(0xfd, float:3.55E-43)
            r17 = 84
            r0[r16] = r17
            r16 = 254(0xfe, float:3.56E-43)
            r17 = -69
            r0[r16] = r17
            r16 = 255(0xff, float:3.57E-43)
            r17 = 22
            r0[r16] = r17
            g = r0
            int[] r0 = new int[r15]
            r0 = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, 239, 197, 145} // fill-array
            h = r0
            r0 = 256(0x100, float:3.59E-43)
            int[] r0 = new int[r0]
            r16 = 0
            r17 = -1520213050(0xffffffffa56363c6, float:-1.9722916E-16)
            r0[r16] = r17
            r16 = -2072216328(0xffffffff847c7cf8, float:-2.967984E-36)
            r0[r3] = r16
            r3 = -1720223762(0xffffffff997777ee, float:-1.279382E-23)
            r0[r5] = r3
            r3 = -1921287178(0xffffffff8d7b7bf6, float:-7.749456E-31)
            r0[r7] = r3
            r3 = 234025727(0xdf2f2ff, float:1.4972901E-30)
            r0[r8] = r3
            r3 = -1117033514(0xffffffffbd6b6bd6, float:-0.057475887)
            r0[r10] = r3
            r3 = -1318096930(0xffffffffb16f6fde, float:-3.4842667E-9)
            r0[r12] = r3
            r3 = 1422247313(0x54c5c591, float:6.7953854E12)
            r0[r13] = r3
            r3 = 1345335392(0x50303060, float:1.18238413E10)
            r0[r14] = r3
            r3 = 9
            r5 = 50397442(0x3010102, float:3.791085E-37)
            r0[r3] = r5
            r3 = 10
            r5 = -1452841010(0xffffffffa96767ce, float:-5.138234E-14)
            r0[r3] = r5
            r3 = 11
            r5 = 2099981142(0x7d2b2b56, float:1.4220188E37)
            r0[r3] = r5
            r3 = 12
            r5 = 436141799(0x19fefee7, float:2.6365939E-23)
            r0[r3] = r5
            r3 = 13
            r5 = 1658312629(0x62d7d7b5, float:1.9907967E21)
            r0[r3] = r5
            r3 = 14
            r5 = -424957107(0xffffffffe6abab4d, float:-4.053423E23)
            r0[r3] = r5
            r3 = 15
            r5 = -1703512340(0xffffffff9a7676ec, float:-5.0967672E-23)
            r0[r3] = r5
            r3 = 16
            r5 = 1170918031(0x45caca8f, float:6489.32)
            r0[r3] = r5
            r3 = 17
            r5 = -1652391393(0xffffffff9d82821f, float:-3.4545256E-21)
            r0[r3] = r5
            r3 = 18
            r5 = 1086966153(0x40c9c989, float:6.3058515)
            r0[r3] = r5
            r3 = 19
            r5 = -2021818886(0xffffffff877d7dfa, float:-1.9070626E-34)
            r0[r3] = r5
            r3 = 20
            r5 = 368769775(0x15fafaef, float:1.013701E-25)
            r0[r3] = r5
            r3 = 21
            r5 = -346465870(0xffffffffeb5959b2, float:-2.6276048E26)
            r0[r3] = r5
            r3 = 22
            r5 = -918075506(0xffffffffc947478e, float:-816248.9)
            r0[r3] = r5
            r3 = 23
            r5 = 200339707(0xbf0f0fb, float:9.2807224E-32)
            r0[r3] = r5
            r3 = 24
            r5 = -324162239(0xffffffffecadad41, float:-1.6796987E27)
            r0[r3] = r5
            r3 = 25
            r5 = 1742001331(0x67d4d4b3, float:2.0101306E24)
            r0[r3] = r5
            r3 = 26
            r5 = -39673249(0xfffffffffda2a25f, float:-2.7022252E37)
            r0[r3] = r5
            r3 = 27
            r5 = -357585083(0xffffffffeaafaf45, float:-1.0619485E26)
            r0[r3] = r5
            r3 = 28
            r5 = -1080255453(0xffffffffbf9c9c23, float:-1.2235149)
            r0[r3] = r5
            r3 = 29
            r5 = -140204973(0xfffffffff7a4a453, float:-6.6786686E33)
            r0[r3] = r5
            r3 = -1770884380(0xffffffff967272e4, float:-1.9584857E-25)
            r0[r15] = r3
            r3 = 31
            r5 = 1539358875(0x5bc0c09b, float:1.08509935E17)
            r0[r3] = r5
            r3 = 32
            r5 = -1028147339(0xffffffffc2b7b775, float:-91.858315)
            r0[r3] = r5
            r3 = 33
            r5 = 486407649(0x1cfdfde1, float:1.6807762E-21)
            r0[r3] = r5
            r3 = 34
            r5 = -1366060227(0xffffffffae93933d, float:-6.710941E-11)
            r0[r3] = r5
            r3 = 35
            r5 = 1780885068(0x6a26264c, float:5.0215634E25)
            r0[r3] = r5
            r3 = 36
            r5 = 1513502316(0x5a36366c, float:1.28220708E16)
            r0[r3] = r5
            r3 = 37
            r5 = 1094664062(0x413f3f7e, float:11.953001)
            r0[r3] = r5
            r3 = 38
            r5 = 49805301(0x2f7f7f5, float:3.6435708E-37)
            r0[r3] = r5
            r3 = 39
            r5 = 1338821763(0x4fcccc83, float:6.8719099E9)
            r0[r3] = r5
            r3 = 40
            r5 = 1546925160(0x5c343468, float:2.02892468E17)
            r0[r3] = r5
            r3 = 41
            r5 = -190470831(0xfffffffff4a5a551, float:-1.0499048E32)
            r0[r3] = r5
            r3 = 42
            r5 = 887481809(0x34e5e5d1, float:4.2821787E-7)
            r0[r3] = r5
            r3 = 43
            r5 = 150073849(0x8f1f1f9, float:1.4561547E-33)
            r0[r3] = r5
            r3 = 44
            r5 = -1821281822(0xffffffff937171e2, float:-3.0474625E-27)
            r0[r3] = r5
            r3 = 45
            r5 = 1943591083(0x73d8d8ab, float:3.4360677E31)
            r0[r3] = r5
            r3 = 46
            r5 = 1395732834(0x53313162, float:7.6103772E11)
            r0[r3] = r5
            r3 = 47
            r5 = 1058346282(0x3f15152a, float:0.5823542)
            r0[r3] = r5
            r3 = 48
            r5 = 201589768(0xc040408, float:1.0170123E-31)
            r0[r3] = r5
            r3 = 49
            r5 = 1388824469(0x52c7c795, float:4.29023461E11)
            r0[r3] = r5
            r3 = 50
            r5 = 1696801606(0x65232346, float:4.8149776E22)
            r0[r3] = r5
            r3 = 51
            r5 = 1589887901(0x5ec3c39d, float:7.0531455E18)
            r0[r3] = r5
            r3 = 52
            r5 = 672667696(0x28181830, float:8.44294E-15)
            r0[r3] = r5
            r3 = 53
            r5 = -1583966665(0xffffffffa1969637, float:-1.0204157E-18)
            r0[r3] = r5
            r3 = 54
            r5 = 251987210(0xf05050a, float:6.558377E-30)
            r0[r3] = r5
            r3 = 55
            r5 = -1248159185(0xffffffffb59a9a2f, float:-1.1518767E-6)
            r0[r3] = r5
            r3 = 56
            r5 = 151455502(0x907070e, float:1.6253351E-33)
            r0[r3] = r5
            r3 = 57
            r5 = 907153956(0x36121224, float:2.1766255E-6)
            r0[r3] = r5
            r3 = 58
            r5 = -1686077413(0xffffffff9b80801b, float:-2.125861E-22)
            r0[r3] = r5
            r3 = 59
            r5 = 1038279391(0x3de2e2df, float:0.110784285)
            r0[r3] = r5
            r3 = 60
            r5 = 652995533(0x26ebebcd, float:1.6370315E-15)
            r0[r3] = r5
            r3 = 61
            r5 = 1764173646(0x6927274e, float:1.2629764E25)
            r0[r3] = r5
            r3 = 62
            r5 = -843926913(0xffffffffcdb2b27f, float:-3.74755296E8)
            r0[r3] = r5
            r3 = 63
            r5 = -1619692054(0xffffffff9f7575ea, float:-5.1978304E-20)
            r0[r3] = r5
            r3 = 64
            r5 = 453576978(0x1b090912, float:1.1335305E-22)
            r0[r3] = r5
            r3 = 65
            r5 = -1635548387(0xffffffff9e83831d, float:-1.3924392E-20)
            r0[r3] = r5
            r3 = 66
            r5 = 1949051992(0x742c2c58, float:5.456387E31)
            r0[r3] = r5
            r3 = 67
            r5 = 773462580(0x2e1a1a34, float:3.503882E-11)
            r0[r3] = r5
            r3 = 68
            r5 = 756751158(0x2d1b1b36, float:8.816772E-12)
            r0[r3] = r5
            r3 = 69
            r5 = -1301385508(0xffffffffb26e6edc, float:-1.387863E-8)
            r0[r3] = r5
            r3 = 70
            r5 = -296068428(0xffffffffee5a5ab4, float:-1.6894346E28)
            r0[r3] = r5
            r3 = 71
            r5 = -73359269(0xfffffffffba0a05b, float:-1.6680398E36)
            r0[r3] = r5
            r3 = 72
            r5 = -162377052(0xfffffffff65252a4, float:-1.0664634E33)
            r0[r3] = r5
            r3 = 73
            r5 = 1295727478(0x4d3b3b76, float:1.96327264E8)
            r0[r3] = r5
            r3 = 74
            r5 = 1641469623(0x61d6d6b7, float:4.953844E20)
            r0[r3] = r5
            r3 = 75
            r5 = -827083907(0xffffffffceb3b37d, float:-1.5074423E9)
            r0[r3] = r5
            r3 = 76
            r5 = 2066295122(0x7b292952, float:8.7833624E35)
            r0[r3] = r5
            r3 = 77
            r5 = 1055122397(0x3ee3e3dd, float:0.44509783)
            r0[r3] = r5
            r3 = 78
            r5 = 1898917726(0x712f2f5e, float:8.6747424E29)
            r0[r3] = r5
            r3 = 79
            r5 = -1752923117(0xffffffff97848413, float:-8.56364E-25)
            r0[r3] = r5
            r3 = 80
            r5 = -179088474(0xfffffffff55353a6, float:-2.6788848E32)
            r0[r3] = r5
            r3 = 81
            r5 = 1758581177(0x68d1d1b9, float:7.9267464E24)
            r0[r3] = r5
            r3 = 83
            r5 = 753790401(0x2cededc1, float:6.762341E-12)
            r0[r3] = r5
            r3 = 84
            r5 = 1612718144(0x60202040, float:4.615317E19)
            r0[r3] = r5
            r3 = 85
            r5 = 536673507(0x1ffcfce3, float:1.0714452E-19)
            r0[r3] = r5
            r3 = 86
            r5 = -927878791(0xffffffffc8b1b179, float:-363915.78)
            r0[r3] = r5
            r3 = 87
            r5 = -312779850(0xffffffffed5b5bb6, float:-4.2430056E27)
            r0[r3] = r5
            r3 = 88
            r5 = -1100322092(0xffffffffbe6a6ad4, float:-0.22892314)
            r0[r3] = r5
            r3 = 89
            r5 = 1187761037(0x46cbcb8d, float:26085.775)
            r0[r3] = r5
            r3 = 90
            r5 = -641810841(0xffffffffd9bebe67, float:-6.7111994E15)
            r0[r3] = r5
            r3 = 91
            r5 = 1262041458(0x4b393972, float:1.2138866E7)
            r0[r3] = r5
            r3 = 92
            r5 = -565556588(0xffffffffde4a4a94, float:-3.64415647E18)
            r0[r3] = r5
            r3 = 93
            r5 = -733197160(0xffffffffd44c4c98, float:-3.50983343E12)
            r0[r3] = r5
            r3 = 94
            r5 = -396863312(0xffffffffe85858b0, float:-4.0866686E24)
            r0[r3] = r5
            r3 = 95
            r5 = 1255133061(0x4acfcf85, float:6809538.5)
            r0[r3] = r5
            r3 = 96
            r5 = 1808847035(0x6bd0d0bb, float:5.0488454E26)
            r0[r3] = r5
            r3 = 97
            r5 = 720367557(0x2aefefc5, float:4.2621302E-13)
            r0[r3] = r5
            r3 = 98
            r5 = -441800113(0xffffffffe5aaaa4f, float:-1.0074299E23)
            r0[r3] = r5
            r3 = 385612781(0x16fbfbed, float:4.0710225E-25)
            r0[r1] = r3
            r1 = 100
            r3 = -985447546(0xffffffffc5434386, float:-3124.2202)
            r0[r1] = r3
            r1 = 101(0x65, float:1.42E-43)
            r3 = -682799718(0xffffffffd74d4d9a, float:-2.2573318E14)
            r0[r1] = r3
            r1 = 102(0x66, float:1.43E-43)
            r3 = 1429418854(0x55333366, float:1.23145835E13)
            r0[r1] = r3
            r1 = 103(0x67, float:1.44E-43)
            r3 = -1803188975(0xffffffff94858511, float:-1.3482053E-26)
            r0[r1] = r3
            r1 = 104(0x68, float:1.46E-43)
            r3 = -817543798(0xffffffffcf45458a, float:-3.30966886E9)
            r0[r1] = r3
            r1 = 105(0x69, float:1.47E-43)
            r3 = 284817897(0x10f9f9e9, float:9.859823E-29)
            r0[r1] = r3
            r1 = 106(0x6a, float:1.49E-43)
            r3 = 100794884(0x6020204, float:2.4451763E-35)
            r0[r1] = r3
            r1 = -2122350594(0xffffffff817f7ffe, float:-4.6927933E-38)
            r0[r9] = r1
            r1 = 108(0x6c, float:1.51E-43)
            r3 = -263171936(0xfffffffff05050a0, float:-2.578814E29)
            r0[r1] = r3
            r1 = 109(0x6d, float:1.53E-43)
            r3 = 1144798328(0x443c3c78, float:752.9448)
            r0[r1] = r3
            r1 = 110(0x6e, float:1.54E-43)
            r3 = -1163944155(0xffffffffba9f9f25, float:-0.0012178166)
            r0[r1] = r3
            r1 = -475486133(0xffffffffe3a8a84b, float:-6.2223596E21)
            r0[r11] = r1
            r1 = 112(0x70, float:1.57E-43)
            r3 = -212774494(0xfffffffff35151a2, float:-1.658395E31)
            r0[r1] = r3
            r1 = 113(0x71, float:1.58E-43)
            r3 = -22830243(0xfffffffffea3a35d, float:-1.087562E38)
            r0[r1] = r3
            r1 = 114(0x72, float:1.6E-43)
            r3 = -1069531008(0xffffffffc0404080, float:-3.0039368)
            r0[r1] = r3
            r1 = 115(0x73, float:1.61E-43)
            r3 = -1970303227(0xffffffff8a8f8f05, float:-1.3824197E-32)
            r0[r1] = r3
            r1 = 116(0x74, float:1.63E-43)
            r3 = -1382903233(0xffffffffad92923f, float:-1.6663225E-11)
            r0[r1] = r3
            r1 = 117(0x75, float:1.64E-43)
            r3 = -1130521311(0xffffffffbc9d9d21, float:-0.019239964)
            r0[r1] = r3
            r1 = 118(0x76, float:1.65E-43)
            r3 = 1211644016(0x48383870, float:188641.75)
            r0[r1] = r3
            r1 = 83228145(0x4f5f5f1, float:5.7825085E-36)
            r0[r4] = r1
            r1 = 120(0x78, float:1.68E-43)
            r3 = -541279133(0xffffffffdfbcbc63, float:-2.7199708E19)
            r0[r1] = r3
            r1 = 121(0x79, float:1.7E-43)
            r3 = -1044990345(0xffffffffc1b6b677, float:-22.839094)
            r0[r1] = r3
            r1 = 122(0x7a, float:1.71E-43)
            r3 = 1977277103(0x75dadaaf, float:5.548614E32)
            r0[r1] = r3
            r1 = 1663115586(0x63212142, float:2.9723223E21)
            r0[r6] = r1
            r1 = 806359072(0x30101020, float:5.240981E-10)
            r0[r2] = r1
            r1 = 125(0x7d, float:1.75E-43)
            r2 = 452984805(0x1affffe5, float:1.0587895E-22)
            r0[r1] = r2
            r1 = 126(0x7e, float:1.77E-43)
            r2 = 250868733(0xef3f3fd, float:6.0139077E-30)
            r0[r1] = r2
            r1 = 127(0x7f, float:1.78E-43)
            r2 = 1842533055(0x6dd2d2bf, float:8.1558286E27)
            r0[r1] = r2
            r1 = 128(0x80, float:1.794E-43)
            r2 = 1288555905(0x4ccdcd81, float:1.07899912E8)
            r0[r1] = r2
            r1 = 129(0x81, float:1.81E-43)
            r2 = 336333848(0x140c0c18, float:7.070579E-27)
            r0[r1] = r2
            r1 = 130(0x82, float:1.82E-43)
            r2 = 890442534(0x35131326, float:5.478963E-7)
            r0[r1] = r2
            r1 = 131(0x83, float:1.84E-43)
            r2 = 804056259(0x2fececc3, float:4.309638E-10)
            r0[r1] = r2
            r1 = 132(0x84, float:1.85E-43)
            r2 = -513843266(0xffffffffe15f5fbe, float:-2.5753268E20)
            r0[r1] = r2
            r1 = 133(0x85, float:1.86E-43)
            r2 = -1567123659(0xffffffffa2979735, float:-4.108873E-18)
            r0[r1] = r2
            r1 = 134(0x86, float:1.88E-43)
            r2 = -867941240(0xffffffffcc444488, float:-5.14504E7)
            r0[r1] = r2
            r1 = 135(0x87, float:1.89E-43)
            r2 = 957814574(0x3917172e, float:1.4409117E-4)
            r0[r1] = r2
            r1 = 136(0x88, float:1.9E-43)
            r2 = 1472513171(0x57c4c493, float:4.32697118E14)
            r0[r1] = r2
            r1 = 137(0x89, float:1.92E-43)
            r2 = -223893675(0xfffffffff2a7a755, float:-6.641445E30)
            r0[r1] = r2
            r1 = 138(0x8a, float:1.93E-43)
            r2 = -2105639172(0xffffffff827e7efc, float:-1.8697416E-37)
            r0[r1] = r2
            r1 = 139(0x8b, float:1.95E-43)
            r2 = 1195195770(0x473d3d7a, float:48445.477)
            r0[r1] = r2
            r1 = 140(0x8c, float:1.96E-43)
            r2 = -1402706744(0xffffffffac6464c8, float:-3.2456694E-12)
            r0[r1] = r2
            r1 = 141(0x8d, float:1.98E-43)
            r2 = -413311558(0xffffffffe75d5dba, float:-1.04537194E24)
            r0[r1] = r2
            r1 = 142(0x8e, float:1.99E-43)
            r2 = 723065138(0x2b191932, float:5.4391485E-13)
            r0[r1] = r2
            r1 = 143(0x8f, float:2.0E-43)
            r2 = -1787595802(0xffffffff957373e6, float:-4.9164887E-26)
            r0[r1] = r2
            r1 = 144(0x90, float:2.02E-43)
            r2 = -1604296512(0xffffffffa06060c0, float:-1.900555E-19)
            r0[r1] = r2
            r1 = 145(0x91, float:2.03E-43)
            r2 = -1736343271(0xffffffff98818119, float:-3.3476074E-24)
            r0[r1] = r2
            r1 = 146(0x92, float:2.05E-43)
            r2 = -783331426(0xffffffffd14f4f9e, float:-5.5649624E10)
            r0[r1] = r2
            r1 = 147(0x93, float:2.06E-43)
            r2 = 2145180835(0x7fdcdca3, float:NaN)
            r0[r1] = r2
            r1 = 148(0x94, float:2.07E-43)
            r2 = 1713513028(0x66222244, float:1.9141386E23)
            r0[r1] = r2
            r1 = 149(0x95, float:2.09E-43)
            r2 = 2116692564(0x7e2a2a54, float:5.6547135E37)
            r0[r1] = r2
            r1 = 150(0x96, float:2.1E-43)
            r2 = -1416589253(0xffffffffab90903b, float:-1.0271847E-12)
            r0[r1] = r2
            r1 = 151(0x97, float:2.12E-43)
            r2 = -2088204277(0xffffffff8388880b, float:-8.0245955E-37)
            r0[r1] = r2
            r1 = 152(0x98, float:2.13E-43)
            r2 = -901364084(0xffffffffca46468c, float:-3248547.0)
            r0[r1] = r2
            r1 = 153(0x99, float:2.14E-43)
            r2 = 703524551(0x29eeeec7, float:1.06107445E-13)
            r0[r1] = r2
            r1 = 154(0x9a, float:2.16E-43)
            r2 = -742868885(0xffffffffd3b8b86b, float:-1.58673601E12)
            r0[r1] = r2
            r1 = 155(0x9b, float:2.17E-43)
            r2 = 1007948840(0x3c141428, float:0.009038009)
            r0[r1] = r2
            r1 = 156(0x9c, float:2.19E-43)
            r2 = 2044649127(0x79dedea7, float:1.4465073E35)
            r0[r1] = r2
            r1 = 157(0x9d, float:2.2E-43)
            r2 = -497131844(0xffffffffe25e5ebc, float:-1.0255009E21)
            r0[r1] = r2
            r1 = 158(0x9e, float:2.21E-43)
            r2 = 487262998(0x1d0b0b16, float:1.8402228E-21)
            r0[r1] = r2
            r1 = 159(0x9f, float:2.23E-43)
            r2 = 1994120109(0x76dbdbad, float:2.2296261E33)
            r0[r1] = r2
            r1 = 160(0xa0, float:2.24E-43)
            r2 = 1004593371(0x3be0e0db, float:0.0068627424)
            r0[r1] = r2
            r1 = 161(0xa1, float:2.26E-43)
            r2 = 1446130276(0x56323264, float:4.8982374E13)
            r0[r1] = r2
            r1 = 162(0xa2, float:2.27E-43)
            r2 = 1312438900(0x4e3a3a74, float:7.8109824E8)
            r0[r1] = r2
            r1 = 163(0xa3, float:2.28E-43)
            r2 = 503974420(0x1e0a0a14, float:7.307743E-21)
            r0[r1] = r2
            r1 = 164(0xa4, float:2.3E-43)
            r2 = -615954030(0xffffffffdb494992, float:-5.6657362E16)
            r0[r1] = r2
            r1 = 165(0xa5, float:2.31E-43)
            r2 = 168166924(0xa06060c, float:6.4530026E-33)
            r0[r1] = r2
            r1 = 166(0xa6, float:2.33E-43)
            r2 = 1814307912(0x6c242448, float:7.937407E26)
            r0[r1] = r2
            r1 = 167(0xa7, float:2.34E-43)
            r2 = -463709000(0xffffffffe45c5cb8, float:-1.6259859E22)
            r0[r1] = r2
            r1 = 168(0xa8, float:2.35E-43)
            r2 = 1573044895(0x5dc2c29f, float:1.75424428E18)
            r0[r1] = r2
            r1 = 169(0xa9, float:2.37E-43)
            r2 = 1859376061(0x6ed3d3bd, float:3.2778656E28)
            r0[r1] = r2
            r1 = 170(0xaa, float:2.38E-43)
            r2 = -273896381(0xffffffffefacac43, float:-1.0687935E29)
            r0[r1] = r2
            r1 = 171(0xab, float:2.4E-43)
            r2 = -1503501628(0xffffffffa66262c4, float:-7.8543353E-16)
            r0[r1] = r2
            r1 = 172(0xac, float:2.41E-43)
            r2 = -1466855111(0xffffffffa8919139, float:-1.6161214E-14)
            r0[r1] = r2
            r1 = 173(0xad, float:2.42E-43)
            r2 = -1533700815(0xffffffffa4959531, float:-6.487119E-17)
            r0[r1] = r2
            r1 = 174(0xae, float:2.44E-43)
            r2 = 937747667(0x37e4e4d3, float:2.7286273E-5)
            r0[r1] = r2
            r1 = 175(0xaf, float:2.45E-43)
            r2 = -1954973198(0xffffffff8b7979f2, float:-4.8047397E-32)
            r0[r1] = r2
            r1 = 176(0xb0, float:2.47E-43)
            r2 = 854058965(0x32e7e7d5, float:2.6997364E-8)
            r0[r1] = r2
            r1 = 177(0xb1, float:2.48E-43)
            r2 = 1137232011(0x43c8c88b, float:401.56674)
            r0[r1] = r2
            r1 = 178(0xb2, float:2.5E-43)
            r2 = 1496790894(0x5937376e, float:3.22317915E15)
            r0[r1] = r2
            r1 = 179(0xb3, float:2.51E-43)
            r2 = -1217565222(0xffffffffb76d6dda, float:-1.4151878E-5)
            r0[r1] = r2
            r1 = 180(0xb4, float:2.52E-43)
            r2 = -1936880383(0xffffffff8c8d8d01, float:-2.1809353E-31)
            r0[r1] = r2
            r1 = 181(0xb5, float:2.54E-43)
            r2 = 1691735473(0x64d5d5b1, float:3.1556437E22)
            r0[r1] = r2
            r1 = 182(0xb6, float:2.55E-43)
            r2 = -766620004(0xffffffffd24e4e9c, float:-2.21520527E11)
            r0[r1] = r2
            r1 = 183(0xb7, float:2.56E-43)
            r2 = -525751991(0xffffffffe0a9a949, float:-9.780306E19)
            r0[r1] = r2
            r1 = 184(0xb8, float:2.58E-43)
            r2 = -1267962664(0xffffffffb46c6cd8, float:-2.201881E-7)
            r0[r1] = r2
            r1 = 185(0xb9, float:2.59E-43)
            r2 = -95005012(0xfffffffffa5656ac, float:-2.7822736E35)
            r0[r1] = r2
            r1 = 186(0xba, float:2.6E-43)
            r2 = 133494003(0x7f4f4f3, float:3.6857008E-34)
            r0[r1] = r2
            r1 = 187(0xbb, float:2.62E-43)
            r2 = 636152527(0x25eaeacf, float:4.0751642E-16)
            r0[r1] = r2
            r1 = 188(0xbc, float:2.63E-43)
            r2 = -1352309302(0xffffffffaf6565ca, float:-2.0863591E-10)
            r0[r1] = r2
            r1 = 189(0xbd, float:2.65E-43)
            r2 = -1904575756(0xffffffff8e7a7af4, float:-3.0874079E-30)
            r0[r1] = r2
            r1 = 190(0xbe, float:2.66E-43)
            r2 = -374428089(0xffffffffe9aeae47, float:-2.6397012E25)
            r0[r1] = r2
            r1 = 191(0xbf, float:2.68E-43)
            r2 = 403179536(0x18080810, float:1.7581659E-24)
            r0[r1] = r2
            r1 = 192(0xc0, float:2.69E-43)
            r2 = -709182865(0xffffffffd5baba6f, float:-2.56637361E13)
            r0[r1] = r2
            r1 = 193(0xc1, float:2.7E-43)
            r2 = -2005370640(0xffffffff887878f0, float:-7.4771947E-34)
            r0[r1] = r2
            r1 = 194(0xc2, float:2.72E-43)
            r2 = 1864705354(0x6f25254a, float:5.1110106E28)
            r0[r1] = r2
            r1 = 195(0xc3, float:2.73E-43)
            r2 = 1915629148(0x722e2e5c, float:3.450012E30)
            r0[r1] = r2
            r1 = 196(0xc4, float:2.75E-43)
            r2 = 605822008(0x241c1c38, float:3.385101E-17)
            r0[r1] = r2
            r1 = 197(0xc5, float:2.76E-43)
            r2 = -240736681(0xfffffffff1a6a657, float:-1.6504193E30)
            r0[r1] = r2
            r1 = 198(0xc6, float:2.77E-43)
            r2 = -944458637(0xffffffffc7b4b473, float:-92520.9)
            r0[r1] = r2
            r1 = 199(0xc7, float:2.79E-43)
            r2 = 1371981463(0x51c6c697, float:1.06716914E11)
            r0[r1] = r2
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 602466507(0x23e8e8cb, float:2.5252082E-17)
            r0[r1] = r2
            r1 = 201(0xc9, float:2.82E-43)
            r2 = 2094914977(0x7cdddda1, float:9.215942E36)
            r0[r1] = r2
            r1 = 202(0xca, float:2.83E-43)
            r2 = -1670089496(0xffffffff9c7474e8, float:-8.0883926E-22)
            r0[r1] = r2
            r1 = 203(0xcb, float:2.84E-43)
            r2 = 555687742(0x211f1f3e, float:5.3912644E-19)
            r0[r1] = r2
            r1 = 204(0xcc, float:2.86E-43)
            r2 = -582268010(0xffffffffdd4b4b96, float:-9.1556045E17)
            r0[r1] = r2
            r1 = 205(0xcd, float:2.87E-43)
            r2 = -591544991(0xffffffffdcbdbd61, float:-4.27255959E17)
            r0[r1] = r2
            r1 = 206(0xce, float:2.89E-43)
            r2 = -2037675251(0xffffffff868b8b0d, float:-5.2490305E-35)
            r0[r1] = r2
            r1 = 207(0xcf, float:2.9E-43)
            r2 = -2054518257(0xffffffff858a8a0f, float:-1.3028172E-35)
            r0[r1] = r2
            r1 = 208(0xd0, float:2.91E-43)
            r2 = -1871679264(0xffffffff907070e0, float:-4.741861E-29)
            r0[r1] = r2
            r1 = 209(0xd1, float:2.93E-43)
            r2 = 1111375484(0x423e3e7c, float:47.56102)
            r0[r1] = r2
            r1 = 210(0xd2, float:2.94E-43)
            r2 = -994724495(0xffffffffc4b5b571, float:-1453.67)
            r0[r1] = r2
            r1 = 211(0xd3, float:2.96E-43)
            r2 = -1436129588(0xffffffffaa6666cc, float:-2.0463768E-13)
            r0[r1] = r2
            r1 = 212(0xd4, float:2.97E-43)
            r2 = -666351472(0xffffffffd8484890, float:-8.8085592E14)
            r0[r1] = r2
            r1 = 213(0xd5, float:2.98E-43)
            r2 = 84083462(0x5030306, float:6.160146E-36)
            r0[r1] = r2
            r1 = 214(0xd6, float:3.0E-43)
            r2 = 32962295(0x1f6f6f7, float:9.0720505E-38)
            r0[r1] = r2
            r1 = 215(0xd7, float:3.01E-43)
            r2 = 302911004(0x120e0e1c, float:4.482469E-28)
            r0[r1] = r2
            r1 = 216(0xd8, float:3.03E-43)
            r2 = -1553899070(0xffffffffa36161c2, float:-1.22179755E-17)
            r0[r1] = r2
            r1 = 217(0xd9, float:3.04E-43)
            r2 = 1597322602(0x5f35356a, float:1.3057459E19)
            r0[r1] = r2
            r1 = 218(0xda, float:3.05E-43)
            r2 = -111716434(0xfffffffff95757ae, float:-6.9882636E34)
            r0[r1] = r2
            r1 = 219(0xdb, float:3.07E-43)
            r2 = -793134743(0xffffffffd0b9b969, float:-2.4927488E10)
            r0[r1] = r2
            r1 = 220(0xdc, float:3.08E-43)
            r2 = -1853454825(0xffffffff91868617, float:-2.1224112E-28)
            r0[r1] = r2
            r1 = 221(0xdd, float:3.1E-43)
            r2 = 1489093017(0x58c1c199, float:1.70429792E15)
            r0[r1] = r2
            r1 = 222(0xde, float:3.11E-43)
            r2 = 656219450(0x271d1d3a, float:2.180397E-15)
            r0[r1] = r2
            r1 = 223(0xdf, float:3.12E-43)
            r2 = -1180787161(0xffffffffb99e9e27, float:-3.025394E-4)
            r0[r1] = r2
            r1 = 224(0xe0, float:3.14E-43)
            r2 = 954327513(0x38e1e1d9, float:1.07709035E-4)
            r0[r1] = r2
            r1 = 225(0xe1, float:3.15E-43)
            r2 = 335083755(0x13f8f8eb, float:6.2849454E-27)
            r0[r1] = r2
            r1 = 226(0xe2, float:3.17E-43)
            r2 = -1281845205(0xffffffffb398982b, float:-7.105731E-8)
            r0[r1] = r2
            r1 = 227(0xe3, float:3.18E-43)
            r2 = 856756514(0x33111122, float:3.3776026E-8)
            r0[r1] = r2
            r1 = 228(0xe4, float:3.2E-43)
            r2 = -1150719534(0xffffffffbb6969d2, float:-0.0035616052)
            r0[r1] = r2
            r1 = 229(0xe5, float:3.21E-43)
            r2 = 1893325225(0x70d9d9a9, float:5.3937106E29)
            r0[r1] = r2
            r1 = 230(0xe6, float:3.22E-43)
            r2 = -1987146233(0xffffffff898e8e07, float:-3.431882E-33)
            r0[r1] = r2
            r1 = 231(0xe7, float:3.24E-43)
            r2 = -1483434957(0xffffffffa7949433, float:-4.123893E-15)
            r0[r1] = r2
            r1 = 232(0xe8, float:3.25E-43)
            r2 = -1231316179(0xffffffffb69b9b2d, float:-4.637425E-6)
            r0[r1] = r2
            r1 = 233(0xe9, float:3.27E-43)
            r2 = 572399164(0x221e1e3c, float:2.1428999E-18)
            r0[r1] = r2
            r1 = 234(0xea, float:3.28E-43)
            r2 = -1836611819(0xffffffff92878715, float:-8.552998E-28)
            r0[r1] = r2
            r1 = 235(0xeb, float:3.3E-43)
            r2 = 552200649(0x20e9e9c9, float:3.9626441E-19)
            r0[r1] = r2
            r1 = 236(0xec, float:3.31E-43)
            r2 = 1238290055(0x49cece87, float:1694160.9)
            r0[r1] = r2
            r1 = 237(0xed, float:3.32E-43)
            r2 = -11184726(0xffffffffff5555aa, float:-2.8357036E38)
            r0[r1] = r2
            r1 = 238(0xee, float:3.34E-43)
            r2 = 2015897680(0x78282850, float:1.3642555E34)
            r0[r1] = r2
            r1 = 239(0xef, float:3.35E-43)
            r2 = 2061492133(0x7adfdfa5, float:5.8120912E35)
            r0[r1] = r2
            r1 = 240(0xf0, float:3.36E-43)
            r2 = -1886614525(0xffffffff8f8c8c03, float:-1.3858996E-29)
            r0[r1] = r2
            r1 = 241(0xf1, float:3.38E-43)
            r2 = -123625127(0xfffffffff8a1a159, float:-2.622601E34)
            r0[r1] = r2
            r1 = 242(0xf2, float:3.39E-43)
            r2 = -2138470135(0xffffffff80898909, float:-1.2630622E-38)
            r0[r1] = r2
            r1 = 243(0xf3, float:3.4E-43)
            r2 = 386731290(0x170d0d1a, float:4.5576094E-25)
            r0[r1] = r2
            r1 = 244(0xf4, float:3.42E-43)
            r2 = -624967835(0xffffffffdabfbf65, float:-2.69860805E16)
            r0[r1] = r2
            r1 = 245(0xf5, float:3.43E-43)
            r2 = 837215959(0x31e6e6d7, float:6.7201245E-9)
            r0[r1] = r2
            r1 = 246(0xf6, float:3.45E-43)
            r2 = -968736124(0xffffffffc6424284, float:-12432.629)
            r0[r1] = r2
            r1 = 247(0xf7, float:3.46E-43)
            r2 = -1201116976(0xffffffffb86868d0, float:-5.5410725E-5)
            r0[r1] = r2
            r1 = 248(0xf8, float:3.48E-43)
            r2 = -1019133566(0xffffffffc3414182, float:-193.25589)
            r0[r1] = r2
            r1 = 249(0xf9, float:3.49E-43)
            r2 = -1332111063(0xffffffffb0999929, float:-1.1175746E-9)
            r0[r1] = r2
            r1 = 250(0xfa, float:3.5E-43)
            r2 = 1999449434(0x772d2d5a, float:3.51245E33)
            r0[r1] = r2
            r1 = 251(0xfb, float:3.52E-43)
            r2 = 286199582(0x110f0f1e, float:1.1285369E-28)
            r0[r1] = r2
            r1 = 252(0xfc, float:3.53E-43)
            r2 = -877612933(0xffffffffcbb0b07b, float:-2.315903E7)
            r0[r1] = r2
            r1 = 253(0xfd, float:3.55E-43)
            r2 = -61582168(0xfffffffffc5454a8, float:-4.409936E36)
            r0[r1] = r2
            r1 = 254(0xfe, float:3.56E-43)
            r2 = -692339859(0xffffffffd6bbbb6d, float:-1.03206831E14)
            r0[r1] = r2
            r1 = 255(0xff, float:3.57E-43)
            r2 = 974525996(0x3a16162c, float:5.72535E-4)
            r0[r1] = r2
            i = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.a.a.b.b.a.<clinit>():void");
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\b\b\b.java ==========

package net.a.a.b.b;

/* compiled from: ZipCryptoEngine */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f502b = new int[256];

    /* renamed from: a  reason: collision with root package name */
    private final int[] f503a = new int[3];

    static {
        for (int i = 0; i < 256; i++) {
            int i2 = i;
            for (int i3 = 0; i3 < 8; i3++) {
                i2 = (i2 & 1) == 1 ? (i2 >>> 1) ^ -306674912 : i2 >>> 1;
            }
            f502b[i] = i2;
        }
    }

    public void a(char[] cArr) {
        this.f503a[0] = 305419896;
        this.f503a[1] = 591751049;
        this.f503a[2] = 878082192;
        for (char c : cArr) {
            a((byte) (c & 255));
        }
    }

    public void a(byte b2) {
        this.f503a[0] = a(this.f503a[0], b2);
        int[] iArr = this.f503a;
        iArr[1] = iArr[1] + (this.f503a[0] & 255);
        this.f503a[1] = (this.f503a[1] * 134775813) + 1;
        this.f503a[2] = a(this.f503a[2], (byte) (this.f503a[1] >> 24));
    }

    private int a(int i, byte b2) {
        return f502b[(i ^ b2) & 255] ^ (i >>> 8);
    }

    public byte a() {
        int i = this.f503a[2] | 2;
        return (byte) ((i * (i ^ 1)) >>> 8);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\c\a.java ==========

package net.a.a.c;

/* compiled from: ZipException */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private int f506a = -1;

    public a() {
    }

    public a(String str) {
        super(str);
    }

    public a(String str, Throwable th) {
        super(str, th);
    }

    public a(String str, int i) {
        super(str);
        this.f506a = i;
    }

    public a(String str, Throwable th, int i) {
        super(str, th);
        this.f506a = i;
    }

    public a(Throwable th) {
        super(th);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\d\a.java ==========

package net.a.a.d;

import java.io.IOException;
import java.io.InputStream;
import net.a.a.g.c;

/* compiled from: BaseInputStream */
public abstract class a extends InputStream {
    public c a() {
        return null;
    }

    public int available() throws IOException {
        return 0;
    }

    public int read() throws IOException {
        return 0;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\d\b.java ==========

package net.a.a.d;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import net.a.a.g.c;
import net.fxgear.util.FXUtil;

/* compiled from: InflaterInputStream */
public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private Inflater f507a = new Inflater(true);

    /* renamed from: b  reason: collision with root package name */
    private byte[] f508b = new byte[4096];
    private byte[] c = new byte[1];
    private c d;
    private long e;
    private long f;

    public b(RandomAccessFile randomAccessFile, long j, long j2, c cVar) {
        super(randomAccessFile, j, j2, cVar);
        this.d = cVar;
        this.e = 0;
        this.f = cVar.d().e();
    }

    public int read() throws IOException {
        if (read(this.c, 0, 1) == -1) {
            return -1;
        }
        return this.c[0] & 255;
    }

    public int read(byte[] bArr) throws IOException {
        if (bArr != null) {
            return read(bArr, 0, bArr.length);
        }
        throw new NullPointerException("input buffer is null");
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null) {
            throw new NullPointerException("input buffer is null");
        } else if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        } else if (i2 == 0) {
            return 0;
        } else {
            try {
                if (this.e >= this.f) {
                    c();
                    return -1;
                }
                while (true) {
                    int inflate = this.f507a.inflate(bArr, i, i2);
                    if (inflate != 0) {
                        this.e += (long) inflate;
                        return inflate;
                    } else if (this.f507a.finished()) {
                        break;
                    } else if (this.f507a.needsDictionary()) {
                        break;
                    } else if (this.f507a.needsInput()) {
                        d();
                    }
                }
                c();
                return -1;
            } catch (DataFormatException e2) {
                String str = "Invalid ZLIB data format";
                if (e2.getMessage() != null) {
                    str = e2.getMessage();
                }
                if (this.d != null && this.d.g().h() && this.d.g().i() == 0) {
                    StringBuffer stringBuffer = new StringBuffer(String.valueOf(str));
                    stringBuffer.append(" - Wrong Password?");
                    str = stringBuffer.toString();
                }
                throw new IOException(str);
            }
        }
    }

    private void c() throws IOException {
        do {
        } while (super.read(new byte[FXUtil.MAX_CUSTOM_FACE_IMAGE_SIZE], 0, FXUtil.MAX_CUSTOM_FACE_IMAGE_SIZE) != -1);
        b();
    }

    private void d() throws IOException {
        int read = super.read(this.f508b, 0, this.f508b.length);
        if (read != -1) {
            this.f507a.setInput(this.f508b, 0, read);
            return;
        }
        throw new EOFException("Unexpected end of ZLIB input stream");
    }

    public long skip(long j) throws IOException {
        if (j >= 0) {
            int min = (int) Math.min(j, 2147483647L);
            byte[] bArr = new byte[512];
            int i = 0;
            while (i < min) {
                int i2 = min - i;
                if (i2 > bArr.length) {
                    i2 = bArr.length;
                }
                int read = read(bArr, 0, i2);
                if (read == -1) {
                    break;
                }
                i += read;
            }
            return (long) i;
        }
        throw new IllegalArgumentException("negative skip length");
    }

    public int available() {
        return this.f507a.finished() ^ true ? 1 : 0;
    }

    public void close() throws IOException {
        this.f507a.end();
        super.close();
    }

    public c a() {
        return super.a();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\d\c.java ==========

package net.a.a.d;

import java.io.IOException;
import java.io.RandomAccessFile;
import net.a.a.b.a;
import net.a.a.b.b;

/* compiled from: PartInputStream */
public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    private RandomAccessFile f509a;

    /* renamed from: b  reason: collision with root package name */
    private long f510b;
    private long c;
    private net.a.a.g.c d;
    private b e;
    private byte[] f = new byte[1];
    private byte[] g = new byte[16];
    private int h = 0;
    private boolean i = false;
    private int j = -1;

    public c(RandomAccessFile randomAccessFile, long j2, long j3, net.a.a.g.c cVar) {
        boolean z = true;
        this.f509a = randomAccessFile;
        this.d = cVar;
        this.e = cVar.e();
        this.f510b = 0;
        this.c = j3;
        this.i = (!cVar.d().l() || cVar.d().m() != 99) ? false : z;
    }

    public int available() {
        long j2 = this.c - this.f510b;
        if (j2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j2;
    }

    public int read() throws IOException {
        if (this.f510b >= this.c) {
            return -1;
        }
        if (this.i) {
            if (this.h == 0 || this.h == 16) {
                if (read(this.g) == -1) {
                    return -1;
                }
                this.h = 0;
            }
            byte[] bArr = this.g;
            int i2 = this.h;
            this.h = i2 + 1;
            return bArr[i2] & 255;
        } else if (read(this.f, 0, 1) == -1) {
            return -1;
        } else {
            return this.f[0] & 255;
        }
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        if (((long) i3) <= this.c - this.f510b || (i3 = (int) (this.c - this.f510b)) != 0) {
            if ((this.d.e() instanceof a) && this.f510b + ((long) i3) < this.c && (i4 = i3 % 16) != 0) {
                i3 -= i4;
            }
            synchronized (this.f509a) {
                this.j = this.f509a.read(bArr, i2, i3);
                if (this.j < i3 && this.d.f().c()) {
                    this.f509a.close();
                    this.f509a = this.d.c();
                    if (this.j < 0) {
                        this.j = 0;
                    }
                    int read = this.f509a.read(bArr, this.j, i3 - this.j);
                    if (read > 0) {
                        this.j += read;
                    }
                }
            }
            if (this.j > 0) {
                if (this.e != null) {
                    try {
                        this.e.a(bArr, i2, this.j);
                    } catch (net.a.a.c.a e2) {
                        throw new IOException(e2.getMessage());
                    }
                }
                this.f510b += (long) this.j;
            }
            if (this.f510b >= this.c) {
                b();
            }
            return this.j;
        }
        b();
        return -1;
    }

    /* access modifiers changed from: protected */
    public void b() throws IOException {
        if (this.i && this.e != null && (this.e instanceof a) && ((a) this.e).d() == null) {
            byte[] bArr = new byte[10];
            int read = this.f509a.read(bArr);
            if (read != 10) {
                if (this.d.f().c()) {
                    this.f509a.close();
                    this.f509a = this.d.c();
                    this.f509a.read(bArr, read, 10 - read);
                } else {
                    throw new IOException("Error occured while reading stored AES authentication bytes");
                }
            }
            ((a) this.d.e()).a(bArr);
        }
    }

    public long skip(long j2) throws IOException {
        if (j2 >= 0) {
            if (j2 > this.c - this.f510b) {
                j2 = this.c - this.f510b;
            }
            this.f510b += j2;
            return j2;
        }
        throw new IllegalArgumentException();
    }

    public void close() throws IOException {
        this.f509a.close();
    }

    public net.a.a.g.c a() {
        return this.d;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\d\d.java ==========

package net.a.a.d;

import java.io.IOException;
import java.io.InputStream;
import net.a.a.c.a;

/* compiled from: ZipInputStream */
public class d extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private a f511a;

    public d(a aVar) {
        this.f511a = aVar;
    }

    public int read() throws IOException {
        int read = this.f511a.read();
        if (read != -1) {
            this.f511a.a().a(read);
        }
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.f511a.read(bArr, i, i2);
        if (read > 0 && this.f511a.a() != null) {
            this.f511a.a().a(bArr, i, read);
        }
        return read;
    }

    public void close() throws IOException {
        a(false);
    }

    public void a(boolean z) throws IOException {
        try {
            this.f511a.close();
            if (!z && this.f511a.a() != null) {
                this.f511a.a().b();
            }
        } catch (a e) {
            throw new IOException(e.getMessage());
        }
    }

    public int available() throws IOException {
        return this.f511a.available();
    }

    public long skip(long j) throws IOException {
        return this.f511a.skip(j);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\e\a.java ==========

package net.a.a.e;

/* compiled from: AESExtraDataRecord */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private long f512a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f513b = -1;
    private int c = -1;
    private String d = null;
    private int e = -1;
    private int f = -1;

    public void a(long j) {
        this.f512a = j;
    }

    public void a(int i) {
        this.f513b = i;
    }

    public void b(int i) {
        this.c = i;
    }

    public void a(String str) {
        this.d = str;
    }

    public int a() {
        return this.e;
    }

    public void c(int i) {
        this.e = i;
    }

    public int b() {
        return this.f;
    }

    public void d(int i) {
        this.f = i;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\e\b.java ==========

package net.a.a.e;

import java.util.ArrayList;

/* compiled from: CentralDirectory */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f514a;

    public ArrayList a() {
        return this.f514a;
    }

    public void a(ArrayList arrayList) {
        this.f514a = arrayList;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\e\c.java ==========

package net.a.a.e;

/* compiled from: DigitalSignature */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private int f515a;

    /* renamed from: b  reason: collision with root package name */
    private int f516b;
    private String c;

    public void a(int i) {
        this.f515a = i;
    }

    public void b(int i) {
        this.f516b = i;
    }

    public void a(String str) {
        this.c = str;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\e\d.java ==========

package net.a.a.e;

/* compiled from: EndCentralDirRecord */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private long f517a;

    /* renamed from: b  reason: collision with root package name */
    private int f518b;
    private int c;
    private int d;
    private int e;
    private int f;
    private long g;
    private int h;
    private String i;
    private byte[] j;

    public void a(long j2) {
        this.f517a = j2;
    }

    public int a() {
        return this.f518b;
    }

    public void a(int i2) {
        this.f518b = i2;
    }

    public void b(int i2) {
        this.c = i2;
    }

    public void c(int i2) {
        this.d = i2;
    }

    public int b() {
        return this.e;
    }

    public void d(int i2) {
        this.e = i2;
    }

    public void e(int i2) {
        this.f = i2;
    }

    public long c() {
        return this.g;
    }

    public void b(long j2) {
        this.g = j2;
    }

    public void f(int i2) {
        this.h = i2;
    }

    public void a(String str) {
        this.i = str;
    }

    public void a(byte[] bArr) {
        this.j = bArr;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\e\e.java ==========

package net.a.a.e;

/* compiled from: ExtraDataRecord */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private long f519a;

    /* renamed from: b  reason: collision with root package name */
    private int f520b;
    private byte[] c;

    public long a() {
        return this.f519a;
    }

    public void a(long j) {
        this.f519a = j;
    }

    public int b() {
        return this.f520b;
    }

    public void a(int i) {
        this.f520b = i;
    }

    public byte[] c() {
        return this.c;
    }

    public void a(byte[] bArr) {
        this.c = bArr;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\e\f.java ==========

package net.a.a.e;

import java.util.ArrayList;

/* compiled from: FileHeader */
public class f {
    private boolean A;

    /* renamed from: a  reason: collision with root package name */
    private int f521a;

    /* renamed from: b  reason: collision with root package name */
    private int f522b;
    private int c;
    private byte[] d;
    private int e;
    private int f;
    private long g = 0;
    private byte[] h;
    private long i;
    private long j = 0;
    private int k;
    private int l;
    private int m;
    private byte[] n;
    private byte[] o;
    private long p;
    private String q;
    private String r;
    private boolean s;
    private boolean t;
    private int u = -1;
    private char[] v;
    private boolean w;
    private k x;
    private a y;
    private ArrayList z;

    public void a(int i2) {
        this.f521a = i2;
    }

    public void b(int i2) {
        this.f522b = i2;
    }

    public void c(int i2) {
        this.c = i2;
    }

    public void a(byte[] bArr) {
        this.d = bArr;
    }

    public int a() {
        return this.e;
    }

    public void d(int i2) {
        this.e = i2;
    }

    public int b() {
        return this.f;
    }

    public void e(int i2) {
        this.f = i2;
    }

    public long c() {
        return this.g & 4294967295L;
    }

    public void a(long j2) {
        this.g = j2;
    }

    public long d() {
        return this.i;
    }

    public void b(long j2) {
        this.i = j2;
    }

    public long e() {
        return this.j;
    }

    public void c(long j2) {
        this.j = j2;
    }

    public void f(int i2) {
        this.k = i2;
    }

    public int f() {
        return this.l;
    }

    public void g(int i2) {
        this.l = i2;
    }

    public int g() {
        return this.m;
    }

    public void h(int i2) {
        this.m = i2;
    }

    public void b(byte[] bArr) {
        this.n = bArr;
    }

    public byte[] h() {
        return this.o;
    }

    public void c(byte[] bArr) {
        this.o = bArr;
    }

    public long i() {
        return this.p;
    }

    public void d(long j2) {
        this.p = j2;
    }

    public String j() {
        return this.q;
    }

    public void a(String str) {
        this.q = str;
    }

    public void b(String str) {
        this.r = str;
    }

    public boolean k() {
        return this.s;
    }

    public void a(boolean z2) {
        this.s = z2;
    }

    public boolean l() {
        return this.t;
    }

    public void b(boolean z2) {
        this.t = z2;
    }

    public int m() {
        return this.u;
    }

    public void i(int i2) {
        this.u = i2;
    }

    public char[] n() {
        return this.v;
    }

    public void a(char[] cArr) {
        this.v = cArr;
    }

    public byte[] o() {
        return this.h;
    }

    public void d(byte[] bArr) {
        this.h = bArr;
    }

    public ArrayList p() {
        return this.z;
    }

    public void a(ArrayList arrayList) {
        this.z = arrayList;
    }

    public void c(boolean z2) {
        this.w = z2;
    }

    public k q() {
        return this.x;
    }

    public void a(k kVar) {
        this.x = kVar;
    }

    public a r() {
        return this.y;
    }

    public void a(a aVar) {
        this.y = aVar;
    }

    public boolean s() {
        return this.A;
    }

    public void d(boolean z2) {
        this.A = z2;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\e\g.java ==========

package net.a.a.e;

import java.util.ArrayList;

/* compiled from: LocalFileHeader */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private int f523a;

    /* renamed from: b  reason: collision with root package name */
    private int f524b;
    private byte[] c;
    private int d;
    private int e;
    private long f = 0;
    private byte[] g;
    private long h;
    private long i = 0;
    private int j;
    private int k;
    private String l;
    private long m;
    private boolean n;
    private int o = -1;
    private char[] p;
    private ArrayList q;
    private k r;
    private a s;
    private boolean t;
    private boolean u = false;
    private boolean v;

    public void a(int i2) {
        this.f523a = i2;
    }

    public void b(int i2) {
        this.f524b = i2;
    }

    public void a(byte[] bArr) {
        this.c = bArr;
    }

    public int a() {
        return this.d;
    }

    public void c(int i2) {
        this.d = i2;
    }

    public void d(int i2) {
        this.e = i2;
    }

    public long b() {
        return this.f;
    }

    public void a(long j2) {
        this.f = j2;
    }

    public long c() {
        return this.h;
    }

    public void b(long j2) {
        this.h = j2;
    }

    public long d() {
        return this.i;
    }

    public void c(long j2) {
        this.i = j2;
    }

    public void e(int i2) {
        this.j = i2;
    }

    public int e() {
        return this.k;
    }

    public void f(int i2) {
        this.k = i2;
    }

    public String f() {
        return this.l;
    }

    public void a(String str) {
        this.l = str;
    }

    public long g() {
        return this.m;
    }

    public void d(long j2) {
        this.m = j2;
    }

    public boolean h() {
        return this.n;
    }

    public void a(boolean z) {
        this.n = z;
    }

    public int i() {
        return this.o;
    }

    public void g(int i2) {
        this.o = i2;
    }

    public void b(byte[] bArr) {
        this.g = bArr;
    }

    public char[] j() {
        return this.p;
    }

    public void a(char[] cArr) {
        this.p = cArr;
    }

    public ArrayList k() {
        return this.q;
    }

    public void a(ArrayList arrayList) {
        this.q = arrayList;
    }

    public void b(boolean z) {
        this.t = z;
    }

    public void a(k kVar) {
        this.r = kVar;
    }

    public a l() {
        return this.s;
    }

    public void a(a aVar) {
        this.s = aVar;
    }

    public boolean m() {
        return this.v;
    }

    public void c(boolean z) {
        this.v = z;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\e\h.java ==========

package net.a.a.e;

/* compiled from: UnzipParameters */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private boolean f525a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f526b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;

    public boolean a() {
        return this.f525a;
    }

    public boolean b() {
        return this.f526b;
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\e\i.java ==========

package net.a.a.e;

/* compiled from: Zip64EndCentralDirLocator */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private long f527a;

    /* renamed from: b  reason: collision with root package name */
    private int f528b;
    private long c;
    private int d;

    public void a(long j) {
        this.f527a = j;
    }

    public void a(int i) {
        this.f528b = i;
    }

    public long a() {
        return this.c;
    }

    public void b(long j) {
        this.c = j;
    }

    public void b(int i) {
        this.d = i;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\e\j.java ==========

package net.a.a.e;

/* compiled from: Zip64EndCentralDirRecord */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private long f529a;

    /* renamed from: b  reason: collision with root package name */
    private long f530b;
    private int c;
    private int d;
    private int e;
    private int f;
    private long g;
    private long h;
    private long i;
    private long j;
    private byte[] k;

    public void a(long j2) {
        this.f529a = j2;
    }

    public long a() {
        return this.f530b;
    }

    public void b(long j2) {
        this.f530b = j2;
    }

    public void a(int i2) {
        this.c = i2;
    }

    public void b(int i2) {
        this.d = i2;
    }

    public int b() {
        return this.e;
    }

    public void c(int i2) {
        this.e = i2;
    }

    public void d(int i2) {
        this.f = i2;
    }

    public void c(long j2) {
        this.g = j2;
    }

    public long c() {
        return this.h;
    }

    public void d(long j2) {
        this.h = j2;
    }

    public void e(long j2) {
        this.i = j2;
    }

    public long d() {
        return this.j;
    }

    public void f(long j2) {
        this.j = j2;
    }

    public void a(byte[] bArr) {
        this.k = bArr;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\e\k.java ==========

package net.a.a.e;

/* compiled from: Zip64ExtendedInfo */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private long f531a = -1;

    /* renamed from: b  reason: collision with root package name */
    private long f532b = -1;
    private long c = -1;
    private int d = -1;

    public long a() {
        return this.f531a;
    }

    public void a(long j) {
        this.f531a = j;
    }

    public long b() {
        return this.f532b;
    }

    public void b(long j) {
        this.f532b = j;
    }

    public long c() {
        return this.c;
    }

    public void c(long j) {
        this.c = j;
    }

    public int d() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\e\l.java ==========

package net.a.a.e;

/* compiled from: ZipModel */
public class l implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private b f533a;

    /* renamed from: b  reason: collision with root package name */
    private d f534b;
    private i c;
    private j d;
    private boolean e;
    private long f = -1;
    private String g;
    private boolean h;
    private String i;

    public b a() {
        return this.f533a;
    }

    public void a(b bVar) {
        this.f533a = bVar;
    }

    public d b() {
        return this.f534b;
    }

    public void a(d dVar) {
        this.f534b = dVar;
    }

    public boolean c() {
        return this.e;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public String d() {
        return this.g;
    }

    public void a(String str) {
        this.g = str;
    }

    public i e() {
        return this.c;
    }

    public void a(i iVar) {
        this.c = iVar;
    }

    public j f() {
        return this.d;
    }

    public void a(j jVar) {
        this.d = jVar;
    }

    public boolean g() {
        return this.h;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String h() {
        return this.i;
    }

    public void b(String str) {
        this.i = str;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\f\a.java ==========

package net.a.a.f;

/* compiled from: ProgressMonitor */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f535a;

    /* renamed from: b  reason: collision with root package name */
    private long f536b;
    private long c;
    private int d = 0;
    private int e;
    private String f;
    private int g;
    private Throwable h;
    private boolean i;
    private boolean j;

    public a() {
        c();
    }

    public int a() {
        return this.f535a;
    }

    public void a(int i2) {
        this.f535a = i2;
    }

    public void a(long j2) {
        this.f536b = j2;
    }

    public void b(long j2) {
        this.c += j2;
        if (this.f536b > 0) {
            this.d = (int) ((this.c * 100) / this.f536b);
            if (this.d > 100) {
                this.d = 100;
            }
        }
        while (this.j) {
            try {
                Thread.sleep(150);
            } catch (InterruptedException unused) {
            }
        }
    }

    public void b(int i2) {
        this.g = i2;
    }

    public void a(String str) {
        this.f = str;
    }

    public void c(int i2) {
        this.e = i2;
    }

    public void b() throws net.a.a.c.a {
        c();
        this.g = 0;
    }

    public void a(Throwable th) throws net.a.a.c.a {
        c();
        this.g = 2;
        this.h = th;
    }

    public void c() {
        this.e = -1;
        this.f535a = 0;
        this.f = null;
        this.f536b = 0;
        this.c = 0;
        this.d = 0;
    }

    public boolean d() {
        return this.i;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\g\a.java ==========

package net.a.a.g;

import java.io.File;
import java.util.ArrayList;
import net.a.a.e.b;
import net.a.a.e.f;
import net.a.a.e.h;
import net.a.a.e.l;
import net.a.a.h.c;

/* compiled from: Unzip */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private l f537a;

    public a(l lVar) throws net.a.a.c.a {
        if (lVar != null) {
            this.f537a = lVar;
            return;
        }
        throw new net.a.a.c.a("ZipModel is null");
    }

    public void a(h hVar, String str, net.a.a.f.a aVar, boolean z) throws net.a.a.c.a {
        b a2 = this.f537a.a();
        if (a2 == null || a2.a() == null) {
            throw new net.a.a.c.a("invalid central directory in zipModel");
        }
        ArrayList a3 = a2.a();
        aVar.c(1);
        aVar.a(a(a3));
        aVar.a(1);
        if (z) {
            new b(this, "Zip4j", a3, hVar, aVar, str).start();
        } else {
            a(a3, hVar, aVar, str);
        }
    }

    static void a(a aVar, ArrayList arrayList, h hVar, net.a.a.f.a aVar2, String str) throws net.a.a.c.a {
        aVar.a(arrayList, hVar, aVar2, str);
    }

    private void a(ArrayList arrayList, h hVar, net.a.a.f.a aVar, String str) throws net.a.a.c.a {
        for (int i = 0; i < arrayList.size(); i++) {
            a((f) arrayList.get(i), str, hVar, (String) null, aVar);
            if (aVar.d()) {
                aVar.b(3);
                aVar.a(0);
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007f, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0080, code lost:
        r7.a((java.lang.Throwable) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0083, code lost:
        throw r3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007f A[ExcHandler: a (r3v2 'e' net.a.a.c.a A[CUSTOM_DECLARE]), Splitter:B:1:0x0002] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(net.a.a.e.f r3, java.lang.String r4, net.a.a.e.h r5, java.lang.String r6, net.a.a.f.a r7) throws net.a.a.c.a {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x0084
            java.lang.String r0 = r3.j()     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
            r7.a((java.lang.String) r0)     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
            java.lang.String r0 = net.a.a.h.a.f543b     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
            boolean r0 = r4.endsWith(r0)     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
            if (r0 != 0) goto L_0x0023
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
            r0.<init>(r4)     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
            java.lang.String r4 = net.a.a.h.a.f543b     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
            r0.append(r4)     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
            java.lang.String r4 = r0.toString()     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
        L_0x0023:
            boolean r0 = r3.k()     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
            if (r0 == 0) goto L_0x005d
            java.lang.String r3 = r3.j()     // Catch:{ Exception -> 0x0053, a -> 0x007f }
            boolean r5 = net.a.a.h.c.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0053, a -> 0x007f }
            if (r5 != 0) goto L_0x0034
            return
        L_0x0034:
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x0053, a -> 0x007f }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0053, a -> 0x007f }
            r5.<init>(r4)     // Catch:{ Exception -> 0x0053, a -> 0x007f }
            r5.append(r3)     // Catch:{ Exception -> 0x0053, a -> 0x007f }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x0053, a -> 0x007f }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0053, a -> 0x007f }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0053, a -> 0x007f }
            boolean r3 = r4.exists()     // Catch:{ Exception -> 0x0053, a -> 0x007f }
            if (r3 != 0) goto L_0x006a
            r4.mkdirs()     // Catch:{ Exception -> 0x0053, a -> 0x007f }
            goto L_0x006a
        L_0x0053:
            r3 = move-exception
            r7.a((java.lang.Throwable) r3)     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
            net.a.a.c.a r4 = new net.a.a.c.a     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
            r4.<init>((java.lang.Throwable) r3)     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
            throw r4     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
        L_0x005d:
            r2.a(r3, r4, r6)     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
            net.a.a.g.c r0 = new net.a.a.g.c     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
            net.a.a.e.l r1 = r2.f537a     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
            r0.<init>(r1, r3)     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
            r0.a(r7, r4, r6, r5)     // Catch:{ Exception -> 0x006b, a -> 0x007f }
        L_0x006a:
            return
        L_0x006b:
            r3 = move-exception
            r7.a((java.lang.Throwable) r3)     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
            net.a.a.c.a r4 = new net.a.a.c.a     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
            r4.<init>((java.lang.Throwable) r3)     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
            throw r4     // Catch:{ a -> 0x007f, Exception -> 0x0075 }
        L_0x0075:
            r3 = move-exception
            r7.a((java.lang.Throwable) r3)
            net.a.a.c.a r4 = new net.a.a.c.a
            r4.<init>((java.lang.Throwable) r3)
            throw r4
        L_0x007f:
            r3 = move-exception
            r7.a((java.lang.Throwable) r3)
            throw r3
        L_0x0084:
            net.a.a.c.a r3 = new net.a.a.c.a
            java.lang.String r4 = "fileHeader is null"
            r3.<init>((java.lang.String) r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.a.a.g.a.a(net.a.a.e.f, java.lang.String, net.a.a.e.h, java.lang.String, net.a.a.f.a):void");
    }

    private void a(f fVar, String str, String str2) throws net.a.a.c.a {
        if (fVar == null || !c.a(str)) {
            throw new net.a.a.c.a("Cannot check output directory structure...one of the parameters was null");
        }
        String j = fVar.j();
        if (c.a(str2)) {
            j = str2;
        }
        if (c.a(j)) {
            StringBuffer stringBuffer = new StringBuffer(String.valueOf(str));
            stringBuffer.append(j);
            try {
                File file = new File(new File(stringBuffer.toString()).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                throw new net.a.a.c.a((Throwable) e);
            }
        }
    }

    private long a(ArrayList arrayList) throws net.a.a.c.a {
        long j;
        if (arrayList != null) {
            long j2 = 0;
            for (int i = 0; i < arrayList.size(); i++) {
                f fVar = (f) arrayList.get(i);
                if (fVar.q() == null || fVar.q().b() <= 0) {
                    j = fVar.d();
                } else {
                    j = fVar.q().a();
                }
                j2 += j;
            }
            return j2;
        }
        throw new net.a.a.c.a("fileHeaders is null, cannot calculate total work");
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\g\b.java ==========

package net.a.a.g;

import java.util.ArrayList;
import net.a.a.e.h;
import net.a.a.f.a;

/* compiled from: Unzip */
class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final a f538a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList f539b;
    private final h c;
    private final a d;
    private final String e;

    b(a aVar, String str, ArrayList arrayList, h hVar, a aVar2, String str2) {
        super(str);
        this.f538a = aVar;
        this.f539b = arrayList;
        this.c = hVar;
        this.d = aVar2;
        this.e = str2;
    }

    public void run() {
        try {
            a.a(this.f538a, this.f539b, this.c, this.d, this.e);
            this.d.b();
        } catch (net.a.a.c.a unused) {
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\g\c.java ==========

package net.a.a.g;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.zip.CRC32;
import net.a.a.b.b;
import net.a.a.c.a;
import net.a.a.d.d;
import net.a.a.e.f;
import net.a.a.e.g;
import net.a.a.e.h;
import net.a.a.e.l;
import net.fxgear.fittingview.data.FittingFaceData;

/* compiled from: UnzipEngine */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private l f540a;

    /* renamed from: b  reason: collision with root package name */
    private f f541b;
    private int c = 0;
    private g d;
    private b e;
    private CRC32 f;

    public c(l lVar, f fVar) throws a {
        if (lVar == null || fVar == null) {
            throw new a("Invalid parameters passed to StoreUnzip. One or more of the parameters were null");
        }
        this.f540a = lVar;
        this.f541b = fVar;
        this.f = new CRC32();
    }

    public void a(net.a.a.f.a aVar, String str, String str2, h hVar) throws a {
        FileOutputStream fileOutputStream;
        d dVar;
        if (this.f540a == null || this.f541b == null || !net.a.a.h.c.a(str)) {
            throw new a("Invalid parameters passed during unzipping file. One or more of the parameters were null");
        }
        d dVar2 = null;
        try {
            byte[] bArr = new byte[4096];
            dVar = a();
            try {
                fileOutputStream = a(str, str2);
                do {
                    try {
                        int read = dVar.read(bArr);
                        if (read == -1) {
                            a((InputStream) dVar, (OutputStream) fileOutputStream);
                            d.a(this.f541b, new File(b(str, str2)), hVar);
                            a((InputStream) dVar, (OutputStream) fileOutputStream);
                            return;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        aVar.b((long) read);
                    } catch (IOException e2) {
                        e = e2;
                        d dVar3 = dVar;
                        throw new a((Throwable) e);
                    } catch (Exception e3) {
                        e = e3;
                        dVar2 = dVar;
                        throw new a((Throwable) e);
                    } catch (Throwable th) {
                        th = th;
                        a((InputStream) dVar, (OutputStream) fileOutputStream);
                        throw th;
                    }
                } while (!aVar.d());
                aVar.b(3);
                aVar.a(0);
                a((InputStream) dVar, (OutputStream) fileOutputStream);
            } catch (IOException e4) {
                e = e4;
                d dVar32 = dVar;
                throw new a((Throwable) e);
            } catch (Exception e5) {
                e = e5;
                fileOutputStream = null;
                dVar2 = dVar;
                throw new a((Throwable) e);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                a((InputStream) dVar, (OutputStream) fileOutputStream);
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            throw new a((Throwable) e);
        } catch (Exception e7) {
            e = e7;
            fileOutputStream = null;
            throw new a((Throwable) e);
        } catch (Throwable th3) {
            th = th3;
            dVar = dVar2;
            a((InputStream) dVar, (OutputStream) fileOutputStream);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0104 A[SYNTHETIC, Splitter:B:45:0x0104] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0113 A[SYNTHETIC, Splitter:B:53:0x0113] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.a.a.d.d a() throws net.a.a.c.a {
        /*
            r11 = this;
            net.a.a.e.f r0 = r11.f541b
            if (r0 == 0) goto L_0x0117
            r0 = 0
            java.lang.String r1 = "r"
            java.io.RandomAccessFile r1 = r11.a((java.lang.String) r1)     // Catch:{ a -> 0x010d, Exception -> 0x00fe }
            java.lang.String r0 = "local header and file header do not match"
            boolean r2 = r11.h()     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            if (r2 == 0) goto L_0x00f4
            r11.a((java.io.RandomAccessFile) r1)     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            net.a.a.e.g r0 = r11.d     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            long r2 = r0.c()     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            net.a.a.e.g r0 = r11.d     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            long r4 = r0.g()     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            net.a.a.e.g r0 = r11.d     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            boolean r0 = r0.h()     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            r6 = 99
            if (r0 == 0) goto L_0x0089
            net.a.a.e.g r0 = r11.d     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            int r0 = r0.i()     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            if (r0 != r6) goto L_0x007d
            net.a.a.b.b r0 = r11.e     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            boolean r0 = r0 instanceof net.a.a.b.a     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            if (r0 == 0) goto L_0x0063
            net.a.a.b.b r0 = r11.e     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            net.a.a.b.a r0 = (net.a.a.b.a) r0     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            int r0 = r0.b()     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            net.a.a.b.b r7 = r11.e     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            net.a.a.b.a r7 = (net.a.a.b.a) r7     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            int r7 = r7.a()     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            int r0 = r0 + r7
            int r0 = r0 + 10
            long r7 = (long) r0     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            long r2 = r2 - r7
            net.a.a.b.b r0 = r11.e     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            net.a.a.b.a r0 = (net.a.a.b.a) r0     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            int r0 = r0.b()     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            net.a.a.b.b r7 = r11.e     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            net.a.a.b.a r7 = (net.a.a.b.a) r7     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            int r7 = r7.a()     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            int r0 = r0 + r7
            long r7 = (long) r0     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            long r4 = r4 + r7
            goto L_0x0089
        L_0x0063:
            net.a.a.c.a r0 = new net.a.a.c.a     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            java.lang.String r3 = "invalid decryptor when trying to calculate compressed size for AES encrypted file: "
            r2.<init>(r3)     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            net.a.a.e.f r3 = r11.f541b     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            java.lang.String r3 = r3.j()     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            r2.append(r3)     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            java.lang.String r2 = r2.toString()     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            r0.<init>((java.lang.String) r2)     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            throw r0     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
        L_0x007d:
            net.a.a.e.g r0 = r11.d     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            int r0 = r0.i()     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            if (r0 != 0) goto L_0x0089
            r7 = 12
            long r2 = r2 - r7
            long r4 = r4 + r7
        L_0x0089:
            r7 = r2
            net.a.a.e.f r0 = r11.f541b     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            int r0 = r0.a()     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            net.a.a.e.f r2 = r11.f541b     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            int r2 = r2.m()     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            if (r2 != r6) goto L_0x00c5
            net.a.a.e.f r0 = r11.f541b     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            net.a.a.e.a r0 = r0.r()     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            if (r0 == 0) goto L_0x00ab
            net.a.a.e.f r0 = r11.f541b     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            net.a.a.e.a r0 = r0.r()     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            int r0 = r0.b()     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            goto L_0x00c5
        L_0x00ab:
            net.a.a.c.a r0 = new net.a.a.c.a     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            java.lang.String r3 = "AESExtraDataRecord does not exist for AES encrypted file: "
            r2.<init>(r3)     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            net.a.a.e.f r3 = r11.f541b     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            java.lang.String r3 = r3.j()     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            r2.append(r3)     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            java.lang.String r2 = r2.toString()     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            r0.<init>((java.lang.String) r2)     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            throw r0     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
        L_0x00c5:
            r1.seek(r4)     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            if (r0 == 0) goto L_0x00e5
            r2 = 8
            if (r0 != r2) goto L_0x00dd
            net.a.a.d.d r0 = new net.a.a.d.d     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            net.a.a.d.b r9 = new net.a.a.d.b     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            r2 = r9
            r3 = r1
            r6 = r7
            r8 = r11
            r2.<init>(r3, r4, r6, r8)     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            r0.<init>(r9)     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            return r0
        L_0x00dd:
            net.a.a.c.a r0 = new net.a.a.c.a     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            java.lang.String r2 = "compression type not supported"
            r0.<init>((java.lang.String) r2)     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            throw r0     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
        L_0x00e5:
            net.a.a.d.d r0 = new net.a.a.d.d     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            net.a.a.d.c r9 = new net.a.a.d.c     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            r2 = r9
            r3 = r1
            r6 = r7
            r8 = r11
            r2.<init>(r3, r4, r6, r8)     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            r0.<init>(r9)     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            return r0
        L_0x00f4:
            net.a.a.c.a r2 = new net.a.a.c.a     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            r2.<init>((java.lang.String) r0)     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
            throw r2     // Catch:{ a -> 0x00fc, Exception -> 0x00fa }
        L_0x00fa:
            r0 = move-exception
            goto L_0x0102
        L_0x00fc:
            r0 = move-exception
            goto L_0x0111
        L_0x00fe:
            r1 = move-exception
            r10 = r1
            r1 = r0
            r0 = r10
        L_0x0102:
            if (r1 == 0) goto L_0x0107
            r1.close()     // Catch:{ IOException -> 0x0107 }
        L_0x0107:
            net.a.a.c.a r1 = new net.a.a.c.a
            r1.<init>((java.lang.Throwable) r0)
            throw r1
        L_0x010d:
            r1 = move-exception
            r10 = r1
            r1 = r0
            r0 = r10
        L_0x0111:
            if (r1 == 0) goto L_0x0116
            r1.close()     // Catch:{ IOException -> 0x0116 }
        L_0x0116:
            throw r0
        L_0x0117:
            net.a.a.c.a r0 = new net.a.a.c.a
            java.lang.String r1 = "file header is null, cannot get inputstream"
            r0.<init>((java.lang.String) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.a.a.g.c.a():net.a.a.d.d");
    }

    private void a(RandomAccessFile randomAccessFile) throws a {
        if (this.d != null) {
            try {
                b(randomAccessFile);
            } catch (a e2) {
                throw e2;
            } catch (Exception e3) {
                throw new a((Throwable) e3);
            }
        } else {
            throw new a("local file header is null, cannot initialize input stream");
        }
    }

    private void b(RandomAccessFile randomAccessFile) throws a {
        if (this.d == null) {
            throw new a("local file header is null, cannot init decrypter");
        } else if (!this.d.h()) {
        } else {
            if (this.d.i() == 0) {
                this.e = new net.a.a.b.c(this.f541b, c(randomAccessFile));
            } else if (this.d.i() == 99) {
                this.e = new net.a.a.b.a(this.d, d(randomAccessFile), e(randomAccessFile));
            } else {
                throw new a("unsupported encryption method");
            }
        }
    }

    private byte[] c(RandomAccessFile randomAccessFile) throws a {
        try {
            byte[] bArr = new byte[12];
            randomAccessFile.seek(this.d.g());
            randomAccessFile.read(bArr, 0, 12);
            return bArr;
        } catch (IOException e2) {
            throw new a((Throwable) e2);
        } catch (Exception e3) {
            throw new a((Throwable) e3);
        }
    }

    private byte[] d(RandomAccessFile randomAccessFile) throws a {
        if (this.d.l() == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[a(this.d.l())];
            randomAccessFile.seek(this.d.g());
            randomAccessFile.read(bArr);
            return bArr;
        } catch (IOException e2) {
            throw new a((Throwable) e2);
        }
    }

    private byte[] e(RandomAccessFile randomAccessFile) throws a {
        try {
            byte[] bArr = new byte[2];
            randomAccessFile.read(bArr);
            return bArr;
        } catch (IOException e2) {
            throw new a((Throwable) e2);
        }
    }

    private int a(net.a.a.e.a aVar) throws a {
        if (aVar != null) {
            switch (aVar.a()) {
                case 1:
                    return 8;
                case 2:
                    return 12;
                case 3:
                    return 16;
                default:
                    throw new a("unable to determine salt length: invalid aes key strength");
            }
        } else {
            throw new a("unable to determine salt length: AESExtraDataRecord is null");
        }
    }

    public void b() throws a {
        if (this.f541b == null) {
            return;
        }
        if (this.f541b.m() == 99) {
            if (this.e != null && (this.e instanceof net.a.a.b.a)) {
                byte[] c2 = ((net.a.a.b.a) this.e).c();
                byte[] d2 = ((net.a.a.b.a) this.e).d();
                byte[] bArr = new byte[10];
                if (d2 != null) {
                    System.arraycopy(c2, 0, bArr, 0, 10);
                    if (!Arrays.equals(bArr, d2)) {
                        StringBuffer stringBuffer = new StringBuffer("invalid CRC (MAC) for file: ");
                        stringBuffer.append(this.f541b.j());
                        throw new a(stringBuffer.toString());
                    }
                    return;
                }
                StringBuffer stringBuffer2 = new StringBuffer("CRC (MAC) check failed for ");
                stringBuffer2.append(this.f541b.j());
                throw new a(stringBuffer2.toString());
            }
        } else if ((this.f.getValue() & 4294967295L) != this.f541b.c()) {
            StringBuffer stringBuffer3 = new StringBuffer("invalid CRC for file: ");
            stringBuffer3.append(this.f541b.j());
            String stringBuffer4 = stringBuffer3.toString();
            if (this.d.h() && this.d.i() == 0) {
                StringBuffer stringBuffer5 = new StringBuffer(String.valueOf(stringBuffer4));
                stringBuffer5.append(" - Wrong Password?");
                stringBuffer4 = stringBuffer5.toString();
            }
            throw new a(stringBuffer4);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0065 A[SYNTHETIC, Splitter:B:33:0x0065] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean h() throws net.a.a.c.a {
        /*
            r5 = this;
            r0 = 0
            java.io.RandomAccessFile r1 = r5.i()     // Catch:{ FileNotFoundException -> 0x005c }
            if (r1 != 0) goto L_0x0024
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x001f, all -> 0x001a }
            java.io.File r2 = new java.io.File     // Catch:{ FileNotFoundException -> 0x001f, all -> 0x001a }
            net.a.a.e.l r3 = r5.f540a     // Catch:{ FileNotFoundException -> 0x001f, all -> 0x001a }
            java.lang.String r3 = r3.d()     // Catch:{ FileNotFoundException -> 0x001f, all -> 0x001a }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x001f, all -> 0x001a }
            java.lang.String r3 = "r"
            r0.<init>(r2, r3)     // Catch:{ FileNotFoundException -> 0x001f, all -> 0x001a }
            goto L_0x0025
        L_0x001a:
            r0 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0063
        L_0x001f:
            r0 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x005d
        L_0x0024:
            r0 = r1
        L_0x0025:
            net.a.a.a.a r1 = new net.a.a.a.a     // Catch:{ FileNotFoundException -> 0x005c }
            r1.<init>(r0)     // Catch:{ FileNotFoundException -> 0x005c }
            net.a.a.e.f r2 = r5.f541b     // Catch:{ FileNotFoundException -> 0x005c }
            net.a.a.e.g r1 = r1.a((net.a.a.e.f) r2)     // Catch:{ FileNotFoundException -> 0x005c }
            r5.d = r1     // Catch:{ FileNotFoundException -> 0x005c }
            net.a.a.e.g r1 = r5.d     // Catch:{ FileNotFoundException -> 0x005c }
            if (r1 == 0) goto L_0x0052
            net.a.a.e.g r1 = r5.d     // Catch:{ FileNotFoundException -> 0x005c }
            int r1 = r1.a()     // Catch:{ FileNotFoundException -> 0x005c }
            net.a.a.e.f r2 = r5.f541b     // Catch:{ FileNotFoundException -> 0x005c }
            int r2 = r2.a()     // Catch:{ FileNotFoundException -> 0x005c }
            if (r1 == r2) goto L_0x004b
            if (r0 == 0) goto L_0x0049
            r0.close()     // Catch:{ IOException | Exception -> 0x0049 }
        L_0x0049:
            r0 = 0
            return r0
        L_0x004b:
            if (r0 == 0) goto L_0x0050
            r0.close()     // Catch:{ IOException | Exception -> 0x0050 }
        L_0x0050:
            r0 = 1
            return r0
        L_0x0052:
            net.a.a.c.a r1 = new net.a.a.c.a     // Catch:{ FileNotFoundException -> 0x005c }
            java.lang.String r2 = "error reading local file header. Is this a valid zip file?"
            r1.<init>((java.lang.String) r2)     // Catch:{ FileNotFoundException -> 0x005c }
            throw r1     // Catch:{ FileNotFoundException -> 0x005c }
        L_0x005a:
            r1 = move-exception
            goto L_0x0063
        L_0x005c:
            r1 = move-exception
        L_0x005d:
            net.a.a.c.a r2 = new net.a.a.c.a     // Catch:{ all -> 0x005a }
            r2.<init>((java.lang.Throwable) r1)     // Catch:{ all -> 0x005a }
            throw r2     // Catch:{ all -> 0x005a }
        L_0x0063:
            if (r0 == 0) goto L_0x0068
            r0.close()     // Catch:{ IOException | Exception -> 0x0068 }
        L_0x0068:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.a.a.g.c.h():boolean");
    }

    private RandomAccessFile i() throws a {
        String str;
        if (!this.f540a.c()) {
            return null;
        }
        int g = this.f541b.g();
        int i = g + 1;
        this.c = i;
        String d2 = this.f540a.d();
        if (g == this.f540a.b().a()) {
            str = this.f540a.d();
        } else if (g >= 9) {
            StringBuffer stringBuffer = new StringBuffer(String.valueOf(d2.substring(0, d2.lastIndexOf(FittingFaceData.FILE_EXTENSION_DOT))));
            stringBuffer.append(".z");
            stringBuffer.append(i);
            str = stringBuffer.toString();
        } else {
            StringBuffer stringBuffer2 = new StringBuffer(String.valueOf(d2.substring(0, d2.lastIndexOf(FittingFaceData.FILE_EXTENSION_DOT))));
            stringBuffer2.append(".z0");
            stringBuffer2.append(i);
            str = stringBuffer2.toString();
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
            if (this.c == 1) {
                byte[] bArr = new byte[4];
                randomAccessFile.read(bArr);
                if (((long) net.a.a.h.b.d(bArr, 0)) != 134695760) {
                    throw new a("invalid first part split file signature");
                }
            }
            return randomAccessFile;
        } catch (FileNotFoundException e2) {
            throw new a((Throwable) e2);
        } catch (IOException e3) {
            throw new a((Throwable) e3);
        }
    }

    private RandomAccessFile a(String str) throws a {
        if (this.f540a == null || !net.a.a.h.c.a(this.f540a.d())) {
            throw new a("input parameter is null in getFilePointer");
        }
        try {
            if (this.f540a.c()) {
                return i();
            }
            return new RandomAccessFile(new File(this.f540a.d()), str);
        } catch (FileNotFoundException e2) {
            throw new a((Throwable) e2);
        } catch (Exception e3) {
            throw new a((Throwable) e3);
        }
    }

    private FileOutputStream a(String str, String str2) throws a {
        if (net.a.a.h.c.a(str)) {
            try {
                File file = new File(b(str, str2));
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (file.exists()) {
                    file.delete();
                }
                return new FileOutputStream(file);
            } catch (FileNotFoundException e2) {
                throw new a((Throwable) e2);
            }
        } else {
            throw new a("invalid output path");
        }
    }

    private String b(String str, String str2) throws a {
        if (!net.a.a.h.c.a(str2)) {
            str2 = this.f541b.j();
        }
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(str));
        stringBuffer.append(System.getProperty("file.separator"));
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public RandomAccessFile c() throws IOException, FileNotFoundException {
        String str;
        String d2 = this.f540a.d();
        if (this.c == this.f540a.b().a()) {
            str = this.f540a.d();
        } else if (this.c >= 9) {
            StringBuffer stringBuffer = new StringBuffer(String.valueOf(d2.substring(0, d2.lastIndexOf(FittingFaceData.FILE_EXTENSION_DOT))));
            stringBuffer.append(".z");
            stringBuffer.append(this.c + 1);
            str = stringBuffer.toString();
        } else {
            StringBuffer stringBuffer2 = new StringBuffer(String.valueOf(d2.substring(0, d2.lastIndexOf(FittingFaceData.FILE_EXTENSION_DOT))));
            stringBuffer2.append(".z0");
            stringBuffer2.append(this.c + 1);
            str = stringBuffer2.toString();
        }
        this.c++;
        try {
            if (net.a.a.h.c.d(str)) {
                return new RandomAccessFile(str, "r");
            }
            StringBuffer stringBuffer3 = new StringBuffer("zip split file does not exist: ");
            stringBuffer3.append(str);
            throw new IOException(stringBuffer3.toString());
        } catch (a e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void a(InputStream inputStream, OutputStream outputStream) throws a {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                if (net.a.a.h.c.a(e2.getMessage())) {
                    if (e2.getMessage().indexOf(" - Wrong Password?") >= 0) {
                        throw new a(e2.getMessage());
                    }
                }
                if (outputStream == null) {
                    return;
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
        }
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.close();
        } catch (IOException unused2) {
        }
    }

    public void a(int i) {
        this.f.update(i);
    }

    public void a(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            this.f.update(bArr, i, i2);
        }
    }

    public f d() {
        return this.f541b;
    }

    public b e() {
        return this.e;
    }

    public l f() {
        return this.f540a;
    }

    public g g() {
        return this.d;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\g\d.java ==========

package net.a.a.g;

import java.io.File;
import net.a.a.c.a;
import net.a.a.e.f;
import net.a.a.e.h;
import net.a.a.h.c;

/* compiled from: UnzipUtil */
public class d {
    public static void a(f fVar, File file, h hVar) throws a {
        if (fVar == null) {
            throw new a("cannot set file properties: file header is null");
        } else if (file == null) {
            throw new a("cannot set file properties: output file is null");
        } else if (c.a(file)) {
            if (hVar == null || !hVar.f()) {
                a(fVar, file);
            }
            if (hVar == null) {
                a(fVar, file, true, true, true, true);
            } else if (hVar.e()) {
                a(fVar, file, false, false, false, false);
            } else {
                a(fVar, file, !hVar.a(), !hVar.b(), !hVar.c(), !hVar.d());
            }
        } else {
            throw new a("cannot set file properties: file doesnot exist");
        }
    }

    private static void a(f fVar, File file, boolean z, boolean z2, boolean z3, boolean z4) throws a {
        if (fVar != null) {
            byte[] h = fVar.h();
            if (h != null) {
                byte b2 = h[0];
                if (b2 != 18) {
                    if (b2 != 38) {
                        if (b2 != 48) {
                            if (b2 != 50) {
                                switch (b2) {
                                    case 1:
                                        if (z) {
                                            c.b(file);
                                            return;
                                        }
                                        return;
                                    case 2:
                                        break;
                                    case 3:
                                        if (z) {
                                            c.b(file);
                                        }
                                        if (z2) {
                                            c.c(file);
                                            return;
                                        }
                                        return;
                                    default:
                                        switch (b2) {
                                            case 32:
                                                break;
                                            case 33:
                                                if (z3) {
                                                    c.d(file);
                                                }
                                                if (z) {
                                                    c.b(file);
                                                    return;
                                                }
                                                return;
                                            case 34:
                                                break;
                                            case 35:
                                                if (z3) {
                                                    c.d(file);
                                                }
                                                if (z) {
                                                    c.b(file);
                                                }
                                                if (z2) {
                                                    c.c(file);
                                                    return;
                                                }
                                                return;
                                            default:
                                                return;
                                        }
                                }
                            }
                            if (z3) {
                                c.d(file);
                            }
                            if (z2) {
                                c.c(file);
                                return;
                            }
                            return;
                        }
                        if (z3) {
                            c.d(file);
                            return;
                        }
                        return;
                    }
                    if (z) {
                        c.b(file);
                    }
                    if (z2) {
                        c.c(file);
                    }
                    if (z4) {
                        c.e(file);
                        return;
                    }
                    return;
                }
                if (z2) {
                    c.c(file);
                    return;
                }
                return;
            }
            return;
        }
        throw new a("invalid file header. cannot set file attributes");
    }

    private static void a(f fVar, File file) throws a {
        if (fVar.b() > 0 && file.exists()) {
            file.setLastModified(c.a(fVar.b()));
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\h\a.java ==========

package net.a.a.h;

/* compiled from: InternalZipConstants */
public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f542a = System.getProperty("file.encoding");

    /* renamed from: b  reason: collision with root package name */
    public static final String f543b = System.getProperty("file.separator");
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\h\b.java ==========

package net.a.a.h;

import java.io.DataInput;
import java.io.IOException;
import net.a.a.c.a;

/* compiled from: Raw */
public class b {
    public static long a(byte[] bArr, int i) {
        return ((long) (bArr[i] & 255)) | ((((((((((((((((long) (bArr[i + 7] & 255)) | 0) << 8) | ((long) (bArr[i + 6] & 255))) << 8) | ((long) (bArr[i + 5] & 255))) << 8) | ((long) (bArr[i + 4] & 255))) << 8) | ((long) (bArr[i + 3] & 255))) << 8) | ((long) (bArr[i + 2] & 255))) << 8) | ((long) (bArr[i + 1] & 255))) << 8);
    }

    public static int a(DataInput dataInput, byte[] bArr) throws a {
        try {
            dataInput.readFully(bArr, 0, 4);
            return (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((((bArr[3] & 255) << 8) | (bArr[2] & 255)) << 16);
        } catch (IOException e) {
            throw new a((Throwable) e);
        }
    }

    public static int b(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    public static final short c(byte[] bArr, int i) {
        return (short) ((bArr[i + 1] & 255) | ((short) (((short) ((bArr[i] & 255) | 0)) << 8)));
    }

    public static int d(byte[] bArr, int i) {
        return ((((bArr[i + 3] & 255) << 8) | (bArr[i + 2] & 255)) << 16) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
    }

    public static void a(byte[] bArr, int i, int i2) {
        bArr[0] = (byte) i;
        bArr[1] = (byte) (i >> 8);
        bArr[2] = (byte) (i >> 16);
        bArr[3] = (byte) (i >> 24);
        bArr[4] = 0;
        bArr[5] = 0;
        bArr[6] = 0;
        bArr[7] = 0;
        bArr[8] = 0;
        bArr[9] = 0;
        bArr[10] = 0;
        bArr[11] = 0;
        bArr[12] = 0;
        bArr[13] = 0;
        bArr[14] = 0;
        bArr[15] = 0;
    }

    public static byte[] a(char[] cArr) {
        if (cArr != null) {
            byte[] bArr = new byte[cArr.length];
            for (int i = 0; i < cArr.length; i++) {
                bArr[i] = (byte) cArr[i];
            }
            return bArr;
        }
        throw new NullPointerException();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\a\a\h\c.java ==========

package net.a.a.h;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import net.a.a.c.a;

/* compiled from: Zip4jUtil */
public class c {
    public static void c(File file) throws a {
    }

    public static void d(File file) throws a {
    }

    public static void e(File file) throws a {
    }

    public static boolean a(String str) {
        return str != null && str.trim().length() > 0;
    }

    public static boolean b(String str) throws a {
        if (a(str)) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.mkdirs();
                    if (!file.isDirectory()) {
                        throw new a("output folder is not valid");
                    } else if (file.canWrite()) {
                        return true;
                    } else {
                        throw new a("no write access to destination folder");
                    }
                } catch (Exception unused) {
                    throw new a("Cannot create destination folder");
                }
            } else if (!file.isDirectory()) {
                throw new a("output folder is not valid");
            } else if (file.canWrite()) {
                return true;
            } else {
                throw new a("no write access to output folder");
            }
        } else {
            throw new a((Throwable) new NullPointerException("output path is null"));
        }
    }

    public static boolean c(String str) throws a {
        if (!a(str)) {
            throw new a("path is null");
        } else if (d(str)) {
            try {
                return new File(str).canRead();
            } catch (Exception unused) {
                throw new a("cannot read zip file");
            }
        } else {
            StringBuffer stringBuffer = new StringBuffer("file does not exist: ");
            stringBuffer.append(str);
            throw new a(stringBuffer.toString());
        }
    }

    public static boolean d(String str) throws a {
        if (a(str)) {
            return a(new File(str));
        }
        throw new a("path is null");
    }

    public static boolean a(File file) throws a {
        if (file != null) {
            return file.exists();
        }
        throw new a("cannot check if file exists: input file is null");
    }

    public static void b(File file) throws a {
        if (file == null) {
            throw new a("input file is null. cannot set read only file attribute");
        } else if (file.exists()) {
            file.setReadOnly();
        }
    }

    public static long a(int i) {
        int i2 = (i & 31) * 2;
        int i3 = (i >> 5) & 63;
        int i4 = (i >> 11) & 31;
        int i5 = (i >> 16) & 31;
        int i6 = ((i >> 25) & 127) + 1980;
        Calendar instance = Calendar.getInstance();
        instance.set(i6, ((i >> 21) & 15) - 1, i5, i4, i3, i2);
        instance.set(14, 0);
        return instance.getTime().getTime();
    }

    public static String a(byte[] bArr, boolean z) {
        if (!z) {
            return a(bArr);
        }
        try {
            return new String(bArr, "UTF8");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static String a(byte[] bArr) {
        try {
            return new String(bArr, "Cp850");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }
}


