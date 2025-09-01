

// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\a.java ==========

package a.a.a;

/* compiled from: BarcodeFormat */
public enum a {
    AZTEC,
    CODABAR,
    CODE_39,
    CODE_93,
    CODE_128,
    DATA_MATRIX,
    EAN_8,
    EAN_13,
    ITF,
    MAXICODE,
    PDF_417,
    QR_CODE,
    RSS_14,
    RSS_EXPANDED,
    UPC_A,
    UPC_E,
    UPC_EAN_EXTENSION
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\b.java ==========

package a.a.a;

import a.a.a.b.a;

/* compiled from: Binarizer */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private final g f13a;

    public abstract a a(int i, a aVar) throws i;

    public abstract b a(g gVar);

    public abstract a.a.a.b.b b() throws i;

    protected b(g gVar) {
        this.f13a = gVar;
    }

    public final g a() {
        return this.f13a;
    }

    public final int c() {
        return this.f13a.b();
    }

    public final int d() {
        return this.f13a.c();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\c.java ==========

package a.a.a;

import a.a.a.b.a;
import a.a.a.b.b;

/* compiled from: BinaryBitmap */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final b f41a;

    /* renamed from: b  reason: collision with root package name */
    private b f42b;

    public c(b bVar) {
        if (bVar != null) {
            this.f41a = bVar;
            return;
        }
        throw new IllegalArgumentException("Binarizer must be non-null.");
    }

    public int a() {
        return this.f41a.c();
    }

    public int b() {
        return this.f41a.d();
    }

    public a a(int i, a aVar) throws i {
        return this.f41a.a(i, aVar);
    }

    public b c() throws i {
        if (this.f42b == null) {
            this.f42b = this.f41a.b();
        }
        return this.f42b;
    }

    public boolean d() {
        return this.f41a.a().d();
    }

    public c e() {
        return new c(this.f41a.a(this.f41a.a().e()));
    }

    public String toString() {
        try {
            return c().toString();
        } catch (i unused) {
            return "";
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\d.java ==========

package a.a.a;

/* compiled from: ChecksumException */
public final class d extends l {
    private static final d c;

    static {
        d dVar = new d();
        c = dVar;
        dVar.setStackTrace(f209b);
    }

    private d() {
    }

    public static d a() {
        return f208a ? new d() : c;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e.java ==========

package a.a.a;

import java.util.List;

/* compiled from: DecodeHintType */
public enum e {
    OTHER(Object.class),
    PURE_BARCODE(Void.class),
    POSSIBLE_FORMATS(List.class),
    TRY_HARDER(Void.class),
    CHARACTER_SET(String.class),
    ALLOWED_LENGTHS(int[].class),
    ASSUME_CODE_39_CHECK_DIGIT(Void.class),
    ASSUME_GS1(Void.class),
    RETURN_CODABAR_START_END(Void.class),
    NEED_RESULT_POINT_CALLBACK(p.class),
    ALLOWED_EAN_EXTENSIONS(int[].class);
    
    private final Class<?> l;

    private e(Class<?> cls) {
        this.l = cls;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\f.java ==========

package a.a.a;

/* compiled from: FormatException */
public final class f extends l {
    private static final f c;

    static {
        f fVar = new f();
        c = fVar;
        fVar.setStackTrace(f209b);
    }

    private f() {
    }

    private f(Throwable th) {
        super(th);
    }

    public static f a() {
        return f208a ? new f() : c;
    }

    public static f a(Throwable th) {
        return f208a ? new f(th) : c;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\g.java ==========

package a.a.a;

/* compiled from: LuminanceSource */
public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    private final int f166a;

    /* renamed from: b  reason: collision with root package name */
    private final int f167b;

    public abstract byte[] a();

    public abstract byte[] a(int i, byte[] bArr);

    public boolean d() {
        return false;
    }

    protected g(int i, int i2) {
        this.f166a = i;
        this.f167b = i2;
    }

    public final int b() {
        return this.f166a;
    }

    public final int c() {
        return this.f167b;
    }

    public g e() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(this.f167b * (this.f166a + 1));
        byte[] bArr = new byte[this.f166a];
        for (int i = 0; i < this.f167b; i++) {
            bArr = a(i, bArr);
            for (int i2 = 0; i2 < this.f166a; i2++) {
                byte b2 = bArr[i2] & 255;
                sb.append(b2 < 64 ? '#' : b2 < 128 ? '+' : b2 < 192 ? '.' : ' ');
            }
            sb.append(10);
        }
        return sb.toString();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\h.java ==========

package a.a.a;

import a.a.a.a.b;
import a.a.a.e.i;
import a.a.a.g.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatReader */
public final class h implements k {

    /* renamed from: a  reason: collision with root package name */
    private Map<e, ?> f204a;

    /* renamed from: b  reason: collision with root package name */
    private k[] f205b;

    public m a(c cVar, Map<e, ?> map) throws i {
        a(map);
        return b(cVar);
    }

    public m a(c cVar) throws i {
        if (this.f205b == null) {
            a((Map<e, ?>) null);
        }
        return b(cVar);
    }

    public void a(Map<e, ?> map) {
        Collection collection;
        this.f204a = map;
        boolean z = true;
        boolean z2 = map != null && map.containsKey(e.TRY_HARDER);
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(e.POSSIBLE_FORMATS);
        }
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (!collection.contains(a.UPC_A) && !collection.contains(a.UPC_E) && !collection.contains(a.EAN_13) && !collection.contains(a.EAN_8) && !collection.contains(a.CODABAR) && !collection.contains(a.CODE_39) && !collection.contains(a.CODE_93) && !collection.contains(a.CODE_128) && !collection.contains(a.ITF) && !collection.contains(a.RSS_14) && !collection.contains(a.RSS_EXPANDED)) {
                z = false;
            }
            if (z && !z2) {
                arrayList.add(new i(map));
            }
            if (collection.contains(a.QR_CODE)) {
                arrayList.add(new a());
            }
            if (collection.contains(a.DATA_MATRIX)) {
                arrayList.add(new a.a.a.c.a());
            }
            if (collection.contains(a.AZTEC)) {
                arrayList.add(new b());
            }
            if (collection.contains(a.PDF_417)) {
                arrayList.add(new a.a.a.f.b());
            }
            if (collection.contains(a.MAXICODE)) {
                arrayList.add(new a.a.a.d.a());
            }
            if (z && z2) {
                arrayList.add(new i(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z2) {
                arrayList.add(new i(map));
            }
            arrayList.add(new a());
            arrayList.add(new a.a.a.c.a());
            arrayList.add(new b());
            arrayList.add(new a.a.a.f.b());
            arrayList.add(new a.a.a.d.a());
            if (z2) {
                arrayList.add(new i(map));
            }
        }
        this.f205b = (k[]) arrayList.toArray(new k[arrayList.size()]);
    }

    public void a() {
        if (this.f205b != null) {
            for (k a2 : this.f205b) {
                a2.a();
            }
        }
    }

    private m b(c cVar) throws i {
        if (this.f205b != null) {
            k[] kVarArr = this.f205b;
            int length = kVarArr.length;
            int i = 0;
            while (i < length) {
                try {
                    return kVarArr[i].a(cVar, this.f204a);
                } catch (l unused) {
                    i++;
                }
            }
        }
        throw i.a();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\i.java ==========

package a.a.a;

/* compiled from: NotFoundException */
public final class i extends l {
    private static final i c;

    static {
        i iVar = new i();
        c = iVar;
        iVar.setStackTrace(f209b);
    }

    private i() {
    }

    public static i a() {
        return c;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\j.java ==========

package a.a.a;

/* compiled from: RGBLuminanceSource */
public final class j extends g {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f206a;

    /* renamed from: b  reason: collision with root package name */
    private final int f207b;
    private final int c;
    private final int d = 0;
    private final int e = 0;

    public j(int i, int i2, int[] iArr) {
        super(i, i2);
        this.f207b = i;
        this.c = i2;
        int i3 = i * i2;
        this.f206a = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr[i4];
            this.f206a[i4] = (byte) (((((i5 >> 16) & 255) + ((i5 >> 7) & 510)) + (i5 & 255)) / 4);
        }
    }

    public byte[] a(int i, byte[] bArr) {
        if (i < 0 || i >= c()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int b2 = b();
        if (bArr == null || bArr.length < b2) {
            bArr = new byte[b2];
        }
        System.arraycopy(this.f206a, ((i + this.e) * this.f207b) + this.d, bArr, 0, b2);
        return bArr;
    }

    public byte[] a() {
        int b2 = b();
        int c2 = c();
        if (b2 == this.f207b && c2 == this.c) {
            return this.f206a;
        }
        int i = b2 * c2;
        byte[] bArr = new byte[i];
        int i2 = (this.e * this.f207b) + this.d;
        if (b2 == this.f207b) {
            System.arraycopy(this.f206a, i2, bArr, 0, i);
            return bArr;
        }
        for (int i3 = 0; i3 < c2; i3++) {
            System.arraycopy(this.f206a, i2, bArr, i3 * b2, b2);
            i2 += this.f207b;
        }
        return bArr;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\k.java ==========

package a.a.a;

import java.util.Map;

/* compiled from: Reader */
public interface k {
    m a(c cVar, Map<e, ?> map) throws i, d, f;

    void a();
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\l.java ==========

package a.a.a;

/* compiled from: ReaderException */
public abstract class l extends Exception {

    /* renamed from: a  reason: collision with root package name */
    protected static final boolean f208a = (System.getProperty("surefire.test.class.path") != null);

    /* renamed from: b  reason: collision with root package name */
    protected static final StackTraceElement[] f209b = new StackTraceElement[0];

    l() {
    }

    l(Throwable th) {
        super(th);
    }

    public final synchronized Throwable fillInStackTrace() {
        return null;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\m.java ==========

package a.a.a;

import java.util.EnumMap;
import java.util.Map;

/* compiled from: Result */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final String f210a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f211b;
    private final int c;
    private o[] d;
    private final a e;
    private Map<n, Object> f;
    private final long g;

    public m(String str, byte[] bArr, o[] oVarArr, a aVar) {
        this(str, bArr, oVarArr, aVar, System.currentTimeMillis());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public m(String str, byte[] bArr, o[] oVarArr, a aVar, long j) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, oVarArr, aVar, j);
    }

    public m(String str, byte[] bArr, int i, o[] oVarArr, a aVar, long j) {
        this.f210a = str;
        this.f211b = bArr;
        this.c = i;
        this.d = oVarArr;
        this.e = aVar;
        this.f = null;
        this.g = j;
    }

    public String a() {
        return this.f210a;
    }

    public byte[] b() {
        return this.f211b;
    }

    public o[] c() {
        return this.d;
    }

    public a d() {
        return this.e;
    }

    public Map<n, Object> e() {
        return this.f;
    }

    public void a(n nVar, Object obj) {
        if (this.f == null) {
            this.f = new EnumMap(n.class);
        }
        this.f.put(nVar, obj);
    }

    public void a(Map<n, Object> map) {
        if (map == null) {
            return;
        }
        if (this.f == null) {
            this.f = map;
        } else {
            this.f.putAll(map);
        }
    }

    public void a(o[] oVarArr) {
        o[] oVarArr2 = this.d;
        if (oVarArr2 == null) {
            this.d = oVarArr;
        } else if (oVarArr != null && oVarArr.length > 0) {
            o[] oVarArr3 = new o[(oVarArr2.length + oVarArr.length)];
            System.arraycopy(oVarArr2, 0, oVarArr3, 0, oVarArr2.length);
            System.arraycopy(oVarArr, 0, oVarArr3, oVarArr2.length, oVarArr.length);
            this.d = oVarArr3;
        }
    }

    public String toString() {
        return this.f210a;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\n.java ==========

package a.a.a;

/* compiled from: ResultMetadataType */
public enum n {
    OTHER,
    ORIENTATION,
    BYTE_SEGMENTS,
    ERROR_CORRECTION_LEVEL,
    ISSUE_NUMBER,
    SUGGESTED_PRICE,
    POSSIBLE_COUNTRY,
    UPC_EAN_EXTENSION,
    PDF417_EXTRA_METADATA,
    STRUCTURED_APPEND_SEQUENCE,
    STRUCTURED_APPEND_PARITY
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\o.java ==========

package a.a.a;

import a.a.a.b.a.a;
import net.fxgear.GlobalDefine;

/* compiled from: ResultPoint */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private final float f214a;

    /* renamed from: b  reason: collision with root package name */
    private final float f215b;

    public o(float f, float f2) {
        this.f214a = f;
        this.f215b = f2;
    }

    public final float a() {
        return this.f214a;
    }

    public final float b() {
        return this.f215b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f214a == oVar.f214a && this.f215b == oVar.f215b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f214a) * 31) + Float.floatToIntBits(this.f215b);
    }

    public final String toString() {
        return "(" + this.f214a + ',' + this.f215b + ')';
    }

    public static void a(o[] oVarArr) {
        o oVar;
        o oVar2;
        o oVar3;
        float a2 = a(oVarArr[0], oVarArr[1]);
        float a3 = a(oVarArr[1], oVarArr[2]);
        float a4 = a(oVarArr[0], oVarArr[2]);
        if (a3 >= a2 && a3 >= a4) {
            oVar3 = oVarArr[0];
            oVar2 = oVarArr[1];
            oVar = oVarArr[2];
        } else if (a4 < a3 || a4 < a2) {
            oVar3 = oVarArr[2];
            oVar2 = oVarArr[0];
            oVar = oVarArr[1];
        } else {
            oVar3 = oVarArr[1];
            oVar2 = oVarArr[0];
            oVar = oVarArr[2];
        }
        if (a(oVar2, oVar3, oVar) < GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
            o oVar4 = oVar;
            oVar = oVar2;
            oVar2 = oVar4;
        }
        oVarArr[0] = oVar2;
        oVarArr[1] = oVar3;
        oVarArr[2] = oVar;
    }

    public static float a(o oVar, o oVar2) {
        return a.a(oVar.f214a, oVar.f215b, oVar2.f214a, oVar2.f215b);
    }

    private static float a(o oVar, o oVar2, o oVar3) {
        float f = oVar2.f214a;
        float f2 = oVar2.f215b;
        return ((oVar3.f214a - f) * (oVar.f215b - f2)) - ((oVar3.f215b - f2) * (oVar.f214a - f));
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\p.java ==========

package a.a.a;

/* compiled from: ResultPointCallback */
public interface p {
    void a(o oVar);
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\a\a.java ==========

package a.a.a.a;

import a.a.a.b.b;
import a.a.a.b.g;
import a.a.a.o;

/* compiled from: AztecDetectorResult */
public final class a extends g {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f2a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3b;
    private final int c;

    public a(b bVar, o[] oVarArr, boolean z, int i, int i2) {
        super(bVar, oVarArr);
        this.f2a = z;
        this.f3b = i;
        this.c = i2;
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.f3b;
    }

    public boolean c() {
        return this.f2a;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\a\b.java ==========

package a.a.a.a;

import a.a.a.k;

/* compiled from: AztecReader */
public final class b implements k {
    public void a() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005c A[LOOP:0: B:29:0x005a->B:30:0x005c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.a.a.m a(a.a.a.c r13, java.util.Map<a.a.a.e, ?> r14) throws a.a.a.i, a.a.a.f {
        /*
            r12 = this;
            a.a.a.a.b.a r0 = new a.a.a.a.b.a
            a.a.a.b.b r13 = r13.c()
            r0.<init>(r13)
            r13 = 0
            r1 = 0
            a.a.a.a.a r2 = r0.a((boolean) r13)     // Catch:{ i -> 0x002b, f -> 0x0025 }
            a.a.a.o[] r3 = r2.e()     // Catch:{ i -> 0x002b, f -> 0x0025 }
            a.a.a.a.a.a r4 = new a.a.a.a.a.a     // Catch:{ i -> 0x0023, f -> 0x0021 }
            r4.<init>()     // Catch:{ i -> 0x0023, f -> 0x0021 }
            a.a.a.b.e r2 = r4.a((a.a.a.a.a) r2)     // Catch:{ i -> 0x0023, f -> 0x0021 }
            r4 = r3
            r3 = r1
            r1 = r2
            r2 = r3
            goto L_0x002f
        L_0x0021:
            r2 = move-exception
            goto L_0x0027
        L_0x0023:
            r2 = move-exception
            goto L_0x002d
        L_0x0025:
            r2 = move-exception
            r3 = r1
        L_0x0027:
            r4 = r3
            r3 = r2
            r2 = r1
            goto L_0x002f
        L_0x002b:
            r2 = move-exception
            r3 = r1
        L_0x002d:
            r4 = r3
            r3 = r1
        L_0x002f:
            if (r1 != 0) goto L_0x004c
            r1 = 1
            a.a.a.a.a r0 = r0.a((boolean) r1)     // Catch:{ f | i -> 0x0044 }
            a.a.a.o[] r4 = r0.e()     // Catch:{ f | i -> 0x0044 }
            a.a.a.a.a.a r1 = new a.a.a.a.a.a     // Catch:{ f | i -> 0x0044 }
            r1.<init>()     // Catch:{ f | i -> 0x0044 }
            a.a.a.b.e r1 = r1.a((a.a.a.a.a) r0)     // Catch:{ f | i -> 0x0044 }
            goto L_0x004c
        L_0x0044:
            r13 = move-exception
            if (r2 != 0) goto L_0x004b
            if (r3 == 0) goto L_0x004a
            throw r3
        L_0x004a:
            throw r13
        L_0x004b:
            throw r2
        L_0x004c:
            r8 = r4
            if (r14 == 0) goto L_0x0064
            a.a.a.e r0 = a.a.a.e.NEED_RESULT_POINT_CALLBACK
            java.lang.Object r14 = r14.get(r0)
            a.a.a.p r14 = (a.a.a.p) r14
            if (r14 == 0) goto L_0x0064
            int r0 = r8.length
        L_0x005a:
            if (r13 >= r0) goto L_0x0064
            r2 = r8[r13]
            r14.a(r2)
            int r13 = r13 + 1
            goto L_0x005a
        L_0x0064:
            a.a.a.m r13 = new a.a.a.m
            java.lang.String r5 = r1.c()
            byte[] r6 = r1.a()
            int r7 = r1.b()
            a.a.a.a r9 = a.a.a.a.AZTEC
            long r10 = java.lang.System.currentTimeMillis()
            r4 = r13
            r4.<init>(r5, r6, r7, r8, r9, r10)
            java.util.List r14 = r1.d()
            if (r14 == 0) goto L_0x0087
            a.a.a.n r0 = a.a.a.n.BYTE_SEGMENTS
            r13.a(r0, r14)
        L_0x0087:
            java.lang.String r14 = r1.e()
            if (r14 == 0) goto L_0x0092
            a.a.a.n r0 = a.a.a.n.ERROR_CORRECTION_LEVEL
            r13.a(r0, r14)
        L_0x0092:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.b.a(a.a.a.c, java.util.Map):a.a.a.m");
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\a\a\a.java ==========

package a.a.a.a.a;

import a.a.a.b.e;
import java.util.Arrays;
import java.util.List;
import net.fxgear.GlobalDefine;
import net.fxgear.fitnshop.a.d;
import net.fxgear.fitnshop.d.c;
import net.fxgear.fitnshop.d.f;
import net.fxgear.fitnshop.d.g;
import net.fxgear.fitnshop.d.h;
import net.fxgear.fitnshop.d.i;
import net.fxgear.fitnshop.d.k;
import net.fxgear.fitnshop.d.m;
import net.fxgear.fittingmodenative.a.b;
import net.fxgear.fittingview.data.FittingFaceData;

/* compiled from: Decoder */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f4a = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f5b = {"CTRL_PS", " ", "a", b.f1293a, c.d, d.f888a, "e", f.d, g.d, h.d, i.d, "j", k.d, "l", m.d, "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] c = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] d = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", FittingFaceData.FILE_EXTENSION_DOT, "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] e = {"CTRL_PS", " ", GlobalDefine.REAL_VIDEO_NONE_DATE, "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", FittingFaceData.FILE_EXTENSION_DOT, "CTRL_UL", "CTRL_US"};
    private a.a.a.a.a f;

    /* renamed from: a.a.a.a.a.a$a  reason: collision with other inner class name */
    /* compiled from: Decoder */
    private enum C0000a {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    private static int a(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }

    public e a(a.a.a.a.a aVar) throws a.a.a.f {
        this.f = aVar;
        boolean[] c2 = c(a(aVar.d()));
        e eVar = new e(a(c2), b(c2), (List<byte[]>) null, (String) null);
        eVar.a(c2.length);
        return eVar;
    }

    private static String b(boolean[] zArr) {
        int length = zArr.length;
        C0000a aVar = C0000a.UPPER;
        C0000a aVar2 = C0000a.UPPER;
        StringBuilder sb = new StringBuilder(20);
        C0000a aVar3 = aVar;
        int i = 0;
        while (i < length) {
            if (aVar2 == C0000a.BINARY) {
                if (length - i < 5) {
                    break;
                }
                int a2 = a(zArr, i, 5);
                int i2 = i + 5;
                if (a2 == 0) {
                    if (length - i2 < 11) {
                        break;
                    }
                    a2 = a(zArr, i2, 11) + 31;
                    i2 += 11;
                }
                int i3 = i2;
                int i4 = 0;
                while (true) {
                    if (i4 >= a2) {
                        i = i3;
                        break;
                    } else if (length - i3 < 8) {
                        i = length;
                        break;
                    } else {
                        sb.append((char) a(zArr, i3, 8));
                        i3 += 8;
                        i4++;
                    }
                }
            } else {
                int i5 = aVar2 == C0000a.DIGIT ? 4 : 5;
                if (length - i < i5) {
                    break;
                }
                int a3 = a(zArr, i, i5);
                i += i5;
                String a4 = a(aVar2, a3);
                if (a4.startsWith("CTRL_")) {
                    aVar3 = a(a4.charAt(5));
                    if (a4.charAt(6) != 'L') {
                        C0000a aVar4 = aVar3;
                        aVar3 = aVar2;
                        aVar2 = aVar4;
                    }
                } else {
                    sb.append(a4);
                }
            }
            aVar2 = aVar3;
        }
        return sb.toString();
    }

    private static C0000a a(char c2) {
        if (c2 == 'B') {
            return C0000a.BINARY;
        }
        if (c2 == 'D') {
            return C0000a.DIGIT;
        }
        if (c2 == 'P') {
            return C0000a.PUNCT;
        }
        switch (c2) {
            case 'L':
                return C0000a.LOWER;
            case 'M':
                return C0000a.MIXED;
            default:
                return C0000a.UPPER;
        }
    }

    private static String a(C0000a aVar, int i) {
        switch (aVar) {
            case UPPER:
                return f4a[i];
            case LOWER:
                return f5b[i];
            case MIXED:
                return c[i];
            case PUNCT:
                return d[i];
            case DIGIT:
                return e[i];
            default:
                throw new IllegalStateException("Bad table");
        }
    }

    private boolean[] c(boolean[] zArr) throws a.a.a.f {
        a.a.a.b.b.a aVar;
        int i = 8;
        if (this.f.a() <= 2) {
            i = 6;
            aVar = a.a.a.b.b.a.c;
        } else if (this.f.a() <= 8) {
            aVar = a.a.a.b.b.a.g;
        } else if (this.f.a() <= 22) {
            i = 10;
            aVar = a.a.a.b.b.a.f21b;
        } else {
            i = 12;
            aVar = a.a.a.b.b.a.f20a;
        }
        int b2 = this.f.b();
        int length = zArr.length / i;
        if (length >= b2) {
            int[] iArr = new int[length];
            int length2 = zArr.length % i;
            int i2 = 0;
            while (i2 < length) {
                iArr[i2] = a(zArr, length2, i);
                i2++;
                length2 += i;
            }
            try {
                new a.a.a.b.b.c(aVar).a(iArr, length - b2);
                int i3 = (1 << i) - 1;
                int i4 = 0;
                for (int i5 = 0; i5 < b2; i5++) {
                    int i6 = iArr[i5];
                    if (i6 == 0 || i6 == i3) {
                        throw a.a.a.f.a();
                    }
                    if (i6 == 1 || i6 == i3 - 1) {
                        i4++;
                    }
                }
                boolean[] zArr2 = new boolean[((b2 * i) - i4)];
                int i7 = 0;
                for (int i8 = 0; i8 < b2; i8++) {
                    int i9 = iArr[i8];
                    if (i9 == 1 || i9 == i3 - 1) {
                        Arrays.fill(zArr2, i7, (i7 + i) - 1, i9 > 1);
                        i7 += i - 1;
                    } else {
                        int i10 = i - 1;
                        while (i10 >= 0) {
                            int i11 = i7 + 1;
                            zArr2[i7] = ((1 << i10) & i9) != 0;
                            i10--;
                            i7 = i11;
                        }
                    }
                }
                return zArr2;
            } catch (a.a.a.b.b.d e2) {
                throw a.a.a.f.a(e2);
            }
        } else {
            throw a.a.a.f.a();
        }
    }

    private boolean[] a(a.a.a.b.b bVar) {
        a.a.a.b.b bVar2 = bVar;
        boolean c2 = this.f.c();
        int a2 = this.f.a();
        int i = (c2 ? 11 : 14) + (a2 << 2);
        int[] iArr = new int[i];
        boolean[] zArr = new boolean[a(a2, c2)];
        int i2 = 2;
        if (c2) {
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = i3;
            }
        } else {
            int i4 = i / 2;
            int i5 = ((i + 1) + (((i4 - 1) / 15) * 2)) / 2;
            for (int i6 = 0; i6 < i4; i6++) {
                int i7 = (i6 / 15) + i6;
                iArr[(i4 - i6) - 1] = (i5 - i7) - 1;
                iArr[i4 + i6] = i7 + i5 + 1;
            }
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < a2) {
            int i10 = ((a2 - i8) << i2) + (c2 ? 9 : 12);
            int i11 = i8 << 1;
            int i12 = (i - 1) - i11;
            int i13 = 0;
            while (i13 < i10) {
                int i14 = i13 << 1;
                int i15 = 0;
                while (i15 < i2) {
                    int i16 = i11 + i15;
                    int i17 = i11 + i13;
                    zArr[i9 + i14 + i15] = bVar2.a(iArr[i16], iArr[i17]);
                    int i18 = i12 - i15;
                    zArr[(i10 * 2) + i9 + i14 + i15] = bVar2.a(iArr[i17], iArr[i18]);
                    int i19 = i12 - i13;
                    zArr[(i10 * 4) + i9 + i14 + i15] = bVar2.a(iArr[i18], iArr[i19]);
                    zArr[(i10 * 6) + i9 + i14 + i15] = bVar2.a(iArr[i19], iArr[i16]);
                    i15++;
                    c2 = c2;
                    a2 = a2;
                    i2 = 2;
                }
                boolean z = c2;
                int i20 = a2;
                i13++;
                i2 = 2;
            }
            boolean z2 = c2;
            int i21 = a2;
            i9 += i10 << 3;
            i8++;
            i2 = 2;
        }
        return zArr;
    }

    private static int a(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    private static byte a(boolean[] zArr, int i) {
        int length = zArr.length - i;
        if (length >= 8) {
            return (byte) a(zArr, i, 8);
        }
        return (byte) (a(zArr, i, length) << (8 - length));
    }

    static byte[] a(boolean[] zArr) {
        byte[] bArr = new byte[((zArr.length + 7) / 8)];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = a(zArr, i << 3);
        }
        return bArr;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\a\b\a.java ==========

package a.a.a.a.b;

import a.a.a.b.b;
import a.a.a.b.b.c;
import a.a.a.b.b.d;
import a.a.a.i;
import a.a.a.o;

/* compiled from: Detector */
public final class a {
    private static final int[] g = {3808, 476, 2107, 1799};

    /* renamed from: a  reason: collision with root package name */
    private final b f9a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f10b;
    private int c;
    private int d;
    private int e;
    private int f;

    public a(b bVar) {
        this.f9a = bVar;
    }

    public a.a.a.a.a a(boolean z) throws i {
        o[] a2 = a(a());
        if (z) {
            o oVar = a2[0];
            a2[0] = a2[2];
            a2[2] = oVar;
        }
        a(a2);
        return new a.a.a.a.a(a(this.f9a, a2[this.f % 4], a2[(this.f + 1) % 4], a2[(this.f + 2) % 4], a2[(this.f + 3) % 4]), b(a2), this.f10b, this.d, this.c);
    }

    private void a(o[] oVarArr) throws i {
        long j;
        long j2;
        if (!a(oVarArr[0]) || !a(oVarArr[1]) || !a(oVarArr[2]) || !a(oVarArr[3])) {
            throw i.a();
        }
        int i = this.e * 2;
        int[] iArr = {a(oVarArr[0], oVarArr[1], i), a(oVarArr[1], oVarArr[2], i), a(oVarArr[2], oVarArr[3], i), a(oVarArr[3], oVarArr[0], i)};
        this.f = a(iArr, i);
        long j3 = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = iArr[(this.f + i2) % 4];
            if (this.f10b) {
                j2 = j3 << 7;
                j = (long) ((i3 >> 1) & 127);
            } else {
                j2 = j3 << 10;
                j = (long) (((i3 >> 2) & 992) + ((i3 >> 1) & 31));
            }
            j3 = j2 + j;
        }
        int a2 = a(j3, this.f10b);
        if (this.f10b) {
            this.c = (a2 >> 6) + 1;
            this.d = (a2 & 63) + 1;
            return;
        }
        this.c = (a2 >> 11) + 1;
        this.d = (a2 & 2047) + 1;
    }

    private static int a(int[] iArr, int i) throws i {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 = (i2 << 3) + ((i3 >> (i - 2)) << 1) + (i3 & 1);
        }
        int i4 = ((i2 & 1) << 11) + (i2 >> 1);
        for (int i5 = 0; i5 < 4; i5++) {
            if (Integer.bitCount(g[i5] ^ i4) <= 2) {
                return i5;
            }
        }
        throw i.a();
    }

    private static int a(long j, boolean z) throws i {
        int i;
        int i2;
        if (z) {
            i = 7;
            i2 = 2;
        } else {
            i = 10;
            i2 = 4;
        }
        int i3 = i - i2;
        int[] iArr = new int[i];
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iArr[i4] = ((int) j) & 15;
            j >>= 4;
        }
        try {
            new c(a.a.a.b.b.a.d).a(iArr, i3);
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 = (i5 << 4) + iArr[i6];
            }
            return i5;
        } catch (d unused) {
            throw i.a();
        }
    }

    private o[] a(C0001a aVar) throws i {
        this.e = 1;
        C0001a aVar2 = aVar;
        C0001a aVar3 = aVar2;
        C0001a aVar4 = aVar3;
        C0001a aVar5 = aVar4;
        boolean z = true;
        while (this.e < 9) {
            C0001a a2 = a(aVar2, z, 1, -1);
            C0001a a3 = a(aVar3, z, 1, 1);
            C0001a a4 = a(aVar4, z, -1, 1);
            C0001a a5 = a(aVar5, z, -1, -1);
            if (this.e > 2) {
                double b2 = (double) ((b(a5, a2) * ((float) this.e)) / (b(aVar5, aVar2) * ((float) (this.e + 2))));
                if (b2 < 0.75d || b2 > 1.25d || !a(a2, a3, a4, a5)) {
                    break;
                }
            }
            z = !z;
            this.e++;
            aVar5 = a5;
            aVar2 = a2;
            aVar3 = a3;
            aVar4 = a4;
        }
        if (this.e == 5 || this.e == 7) {
            this.f10b = this.e == 5;
            return a(new o[]{new o(((float) aVar2.b()) + 0.5f, ((float) aVar2.c()) - 0.5f), new o(((float) aVar3.b()) + 0.5f, ((float) aVar3.c()) + 0.5f), new o(((float) aVar4.b()) - 0.5f, ((float) aVar4.c()) + 0.5f), new o(((float) aVar5.b()) - 0.5f, ((float) aVar5.c()) - 0.5f)}, (float) ((this.e * 2) - 3), (float) (this.e * 2));
        }
        throw i.a();
    }

    private C0001a a() {
        o oVar;
        o oVar2;
        o oVar3;
        o oVar4;
        o oVar5;
        o oVar6;
        o oVar7;
        o oVar8;
        try {
            o[] a2 = new a.a.a.b.a.b(this.f9a).a();
            oVar3 = a2[0];
            oVar2 = a2[1];
            oVar = a2[2];
            oVar4 = a2[3];
        } catch (i unused) {
            int e2 = this.f9a.e() / 2;
            int f2 = this.f9a.f() / 2;
            int i = e2 + 7;
            int i2 = f2 - 7;
            o a3 = a(new C0001a(i, i2), false, 1, -1).a();
            int i3 = f2 + 7;
            o a4 = a(new C0001a(i, i3), false, 1, 1).a();
            int i4 = e2 - 7;
            o a5 = a(new C0001a(i4, i3), false, -1, 1).a();
            oVar4 = a(new C0001a(i4, i2), false, -1, -1).a();
            o oVar9 = a4;
            oVar = a5;
            oVar3 = a3;
            oVar2 = oVar9;
        }
        int a6 = a.a.a.b.a.a.a((((oVar3.a() + oVar4.a()) + oVar2.a()) + oVar.a()) / 4.0f);
        int a7 = a.a.a.b.a.a.a((((oVar3.b() + oVar4.b()) + oVar2.b()) + oVar.b()) / 4.0f);
        try {
            o[] a8 = new a.a.a.b.a.b(this.f9a, 15, a6, a7).a();
            oVar6 = a8[0];
            oVar5 = a8[1];
            oVar7 = a8[2];
            oVar8 = a8[3];
        } catch (i unused2) {
            int i5 = a6 + 7;
            int i6 = a7 - 7;
            oVar6 = a(new C0001a(i5, i6), false, 1, -1).a();
            int i7 = a7 + 7;
            oVar5 = a(new C0001a(i5, i7), false, 1, 1).a();
            int i8 = a6 - 7;
            oVar7 = a(new C0001a(i8, i7), false, -1, 1).a();
            oVar8 = a(new C0001a(i8, i6), false, -1, -1).a();
        }
        return new C0001a(a.a.a.b.a.a.a((((oVar6.a() + oVar8.a()) + oVar5.a()) + oVar7.a()) / 4.0f), a.a.a.b.a.a.a((((oVar6.b() + oVar8.b()) + oVar5.b()) + oVar7.b()) / 4.0f));
    }

    private o[] b(o[] oVarArr) {
        return a(oVarArr, (float) (this.e * 2), (float) b());
    }

    private b a(b bVar, o oVar, o oVar2, o oVar3, o oVar4) throws i {
        a.a.a.b.i a2 = a.a.a.b.i.a();
        int b2 = b();
        int i = b2;
        int i2 = b2;
        float f2 = ((float) b2) / 2.0f;
        float f3 = f2 - ((float) this.e);
        float f4 = f3;
        float f5 = f2 + ((float) this.e);
        return a2.a(bVar, i2, i, f4, f3, f5, f3, f5, f5, f3, f5, oVar.a(), oVar.b(), oVar2.a(), oVar2.b(), oVar3.a(), oVar3.b(), oVar4.a(), oVar4.b());
    }

    private int a(o oVar, o oVar2, int i) {
        float a2 = a(oVar, oVar2);
        float f2 = a2 / ((float) i);
        float a3 = oVar.a();
        float b2 = oVar.b();
        float a4 = ((oVar2.a() - oVar.a()) * f2) / a2;
        float b3 = (f2 * (oVar2.b() - oVar.b())) / a2;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f3 = (float) i3;
            if (this.f9a.a(a.a.a.b.a.a.a((f3 * a4) + a3), a.a.a.b.a.a.a((f3 * b3) + b2))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }

    private boolean a(C0001a aVar, C0001a aVar2, C0001a aVar3, C0001a aVar4) {
        C0001a aVar5 = new C0001a(aVar.b() - 3, aVar.c() + 3);
        C0001a aVar6 = new C0001a(aVar2.b() - 3, aVar2.c() - 3);
        C0001a aVar7 = new C0001a(aVar3.b() + 3, aVar3.c() - 3);
        C0001a aVar8 = new C0001a(aVar4.b() + 3, aVar4.c() + 3);
        int a2 = a(aVar8, aVar5);
        if (a2 != 0 && a(aVar5, aVar6) == a2 && a(aVar6, aVar7) == a2 && a(aVar7, aVar8) == a2) {
            return true;
        }
        return false;
    }

    private int a(C0001a aVar, C0001a aVar2) {
        float b2 = b(aVar, aVar2);
        float b3 = ((float) (aVar2.b() - aVar.b())) / b2;
        float c2 = ((float) (aVar2.c() - aVar.c())) / b2;
        boolean a2 = this.f9a.a(aVar.b(), aVar.c());
        int ceil = (int) Math.ceil((double) b2);
        boolean z = false;
        float c3 = (float) aVar.c();
        int i = 0;
        float b4 = (float) aVar.b();
        for (int i2 = 0; i2 < ceil; i2++) {
            b4 += b3;
            c3 += c2;
            if (this.f9a.a(a.a.a.b.a.a.a(b4), a.a.a.b.a.a.a(c3)) != a2) {
                i++;
            }
        }
        float f2 = ((float) i) / b2;
        if (f2 > 0.1f && f2 < 0.9f) {
            return 0;
        }
        if (f2 <= 0.1f) {
            z = true;
        }
        return z == a2 ? 1 : -1;
    }

    private C0001a a(C0001a aVar, boolean z, int i, int i2) {
        int b2 = aVar.b() + i;
        int c2 = aVar.c();
        while (true) {
            c2 += i2;
            if (!a(b2, c2) || this.f9a.a(b2, c2) != z) {
                int i3 = b2 - i;
                int i4 = c2 - i2;
            } else {
                b2 += i;
            }
        }
        int i32 = b2 - i;
        int i42 = c2 - i2;
        while (a(i32, i42) && this.f9a.a(i32, i42) == z) {
            i32 += i;
        }
        int i5 = i32 - i;
        while (a(i5, i42) && this.f9a.a(i5, i42) == z) {
            i42 += i2;
        }
        return new C0001a(i5, i42 - i2);
    }

    private static o[] a(o[] oVarArr, float f2, float f3) {
        float f4 = f3 / (f2 * 2.0f);
        float a2 = oVarArr[0].a() - oVarArr[2].a();
        float b2 = oVarArr[0].b() - oVarArr[2].b();
        float a3 = (oVarArr[0].a() + oVarArr[2].a()) / 2.0f;
        float b3 = (oVarArr[0].b() + oVarArr[2].b()) / 2.0f;
        float f5 = a2 * f4;
        float f6 = b2 * f4;
        o oVar = new o(a3 + f5, b3 + f6);
        o oVar2 = new o(a3 - f5, b3 - f6);
        float a4 = oVarArr[1].a() - oVarArr[3].a();
        float b4 = oVarArr[1].b() - oVarArr[3].b();
        float a5 = (oVarArr[1].a() + oVarArr[3].a()) / 2.0f;
        float b5 = (oVarArr[1].b() + oVarArr[3].b()) / 2.0f;
        float f7 = a4 * f4;
        float f8 = f4 * b4;
        return new o[]{oVar, new o(a5 + f7, b5 + f8), oVar2, new o(a5 - f7, b5 - f8)};
    }

    private boolean a(int i, int i2) {
        return i >= 0 && i < this.f9a.e() && i2 > 0 && i2 < this.f9a.f();
    }

    private boolean a(o oVar) {
        return a(a.a.a.b.a.a.a(oVar.a()), a.a.a.b.a.a.a(oVar.b()));
    }

    private static float b(C0001a aVar, C0001a aVar2) {
        return a.a.a.b.a.a.a(aVar.b(), aVar.c(), aVar2.b(), aVar2.c());
    }

    private static float a(o oVar, o oVar2) {
        return a.a.a.b.a.a.a(oVar.a(), oVar.b(), oVar2.a(), oVar2.b());
    }

    private int b() {
        if (this.f10b) {
            return (this.c * 4) + 11;
        }
        if (this.c <= 4) {
            return (this.c * 4) + 15;
        }
        return (this.c * 4) + ((((this.c - 4) / 8) + 1) * 2) + 15;
    }

    /* renamed from: a.a.a.a.b.a$a  reason: collision with other inner class name */
    /* compiled from: Detector */
    static final class C0001a {

        /* renamed from: a  reason: collision with root package name */
        private final int f11a;

        /* renamed from: b  reason: collision with root package name */
        private final int f12b;

        /* access modifiers changed from: package-private */
        public o a() {
            return new o((float) b(), (float) c());
        }

        C0001a(int i, int i2) {
            this.f11a = i;
            this.f12b = i2;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f11a;
        }

        /* access modifiers changed from: package-private */
        public int c() {
            return this.f12b;
        }

        public String toString() {
            return "<" + this.f11a + ' ' + this.f12b + '>';
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\b\a.java ==========

package a.a.a.b;

import java.util.Arrays;

/* compiled from: BitArray */
public final class a implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private int[] f14a;

    /* renamed from: b  reason: collision with root package name */
    private int f15b;

    public a() {
        this.f15b = 0;
        this.f14a = new int[1];
    }

    public a(int i) {
        this.f15b = i;
        this.f14a = e(i);
    }

    a(int[] iArr, int i) {
        this.f14a = iArr;
        this.f15b = i;
    }

    public int a() {
        return this.f15b;
    }

    public boolean a(int i) {
        return ((1 << (i & 31)) & this.f14a[i / 32]) != 0;
    }

    public void b(int i) {
        int[] iArr = this.f14a;
        int i2 = i / 32;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public int c(int i) {
        if (i >= this.f15b) {
            return this.f15b;
        }
        int i2 = i / 32;
        int i3 = (((1 << (i & 31)) - 1) ^ -1) & this.f14a[i2];
        while (i3 == 0) {
            i2++;
            if (i2 == this.f14a.length) {
                return this.f15b;
            }
            i3 = this.f14a[i2];
        }
        int numberOfTrailingZeros = (i2 << 5) + Integer.numberOfTrailingZeros(i3);
        return numberOfTrailingZeros > this.f15b ? this.f15b : numberOfTrailingZeros;
    }

    public int d(int i) {
        if (i >= this.f15b) {
            return this.f15b;
        }
        int i2 = i / 32;
        int i3 = (((1 << (i & 31)) - 1) ^ -1) & (this.f14a[i2] ^ -1);
        while (i3 == 0) {
            i2++;
            if (i2 == this.f14a.length) {
                return this.f15b;
            }
            i3 = this.f14a[i2] ^ -1;
        }
        int numberOfTrailingZeros = (i2 << 5) + Integer.numberOfTrailingZeros(i3);
        return numberOfTrailingZeros > this.f15b ? this.f15b : numberOfTrailingZeros;
    }

    public void a(int i, int i2) {
        this.f14a[i / 32] = i2;
    }

    public void b() {
        int length = this.f14a.length;
        for (int i = 0; i < length; i++) {
            this.f14a[i] = 0;
        }
    }

    public boolean a(int i, int i2, boolean z) {
        if (i2 < i || i < 0 || i2 > this.f15b) {
            throw new IllegalArgumentException();
        } else if (i2 == i) {
            return true;
        } else {
            int i3 = i2 - 1;
            int i4 = i / 32;
            int i5 = i3 / 32;
            int i6 = i4;
            while (i6 <= i5) {
                int i7 = 31;
                int i8 = i6 > i4 ? 0 : i & 31;
                if (i6 >= i5) {
                    i7 = 31 & i3;
                }
                int i9 = (2 << i7) - (1 << i8);
                int i10 = this.f14a[i6] & i9;
                if (!z) {
                    i9 = 0;
                }
                if (i10 != i9) {
                    return false;
                }
                i6++;
            }
            return true;
        }
    }

    public int[] c() {
        return this.f14a;
    }

    public void d() {
        int[] iArr = new int[this.f14a.length];
        int i = (this.f15b - 1) / 32;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            long j = (long) this.f14a[i3];
            long j2 = ((j & 1431655765) << 1) | ((j >> 1) & 1431655765);
            long j3 = ((j2 & 858993459) << 2) | ((j2 >> 2) & 858993459);
            long j4 = ((j3 & 252645135) << 4) | ((j3 >> 4) & 252645135);
            long j5 = ((j4 & 16711935) << 8) | ((j4 >> 8) & 16711935);
            iArr[i - i3] = (int) (((j5 & 65535) << 16) | ((j5 >> 16) & 65535));
        }
        int i4 = i2 << 5;
        if (this.f15b != i4) {
            int i5 = i4 - this.f15b;
            int i6 = iArr[0] >>> i5;
            for (int i7 = 1; i7 < i2; i7++) {
                int i8 = iArr[i7];
                iArr[i7 - 1] = i6 | (i8 << (32 - i5));
                i6 = i8 >>> i5;
            }
            iArr[i2 - 1] = i6;
        }
        this.f14a = iArr;
    }

    private static int[] e(int i) {
        return new int[((i + 31) / 32)];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f15b != aVar.f15b || !Arrays.equals(this.f14a, aVar.f14a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f15b * 31) + Arrays.hashCode(this.f14a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f15b);
        for (int i = 0; i < this.f15b; i++) {
            if ((i & 7) == 0) {
                sb.append(' ');
            }
            sb.append(a(i) ? 'X' : '.');
        }
        return sb.toString();
    }

    /* renamed from: e */
    public a clone() {
        return new a((int[]) this.f14a.clone(), this.f15b);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\b\b.java ==========

package a.a.a.b;

import java.util.Arrays;

/* compiled from: BitMatrix */
public final class b implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private final int f18a;

    /* renamed from: b  reason: collision with root package name */
    private final int f19b;
    private final int c;
    private final int[] d;

    public b(int i) {
        this(i, i);
    }

    public b(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f18a = i;
        this.f19b = i2;
        this.c = (i + 31) / 32;
        this.d = new int[(this.c * i2)];
    }

    private b(int i, int i2, int i3, int[] iArr) {
        this.f18a = i;
        this.f19b = i2;
        this.c = i3;
        this.d = iArr;
    }

    public boolean a(int i, int i2) {
        return ((this.d[(i2 * this.c) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public void b(int i, int i2) {
        int i3 = (i2 * this.c) + (i / 32);
        int[] iArr = this.d;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    public void c(int i, int i2) {
        int i3 = (i2 * this.c) + (i / 32);
        int[] iArr = this.d;
        iArr[i3] = (1 << (i & 31)) ^ iArr[i3];
    }

    public void a(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i5 = i3 + i;
            int i6 = i4 + i2;
            if (i6 > this.f19b || i5 > this.f18a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = this.c * i2;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.d;
                    int i9 = (i8 / 32) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
        }
    }

    public a a(int i, a aVar) {
        if (aVar == null || aVar.a() < this.f18a) {
            aVar = new a(this.f18a);
        } else {
            aVar.b();
        }
        int i2 = i * this.c;
        for (int i3 = 0; i3 < this.c; i3++) {
            aVar.a(i3 << 5, this.d[i2 + i3]);
        }
        return aVar;
    }

    public void b(int i, a aVar) {
        System.arraycopy(aVar.c(), 0, this.d, i * this.c, this.c);
    }

    public void a() {
        int e = e();
        int f = f();
        a aVar = new a(e);
        a aVar2 = new a(e);
        for (int i = 0; i < (f + 1) / 2; i++) {
            aVar = a(i, aVar);
            int i2 = (f - 1) - i;
            aVar2 = a(i2, aVar2);
            aVar.d();
            aVar2.d();
            b(i, aVar2);
            b(i2, aVar);
        }
    }

    public int[] b() {
        int i = this.f18a;
        int i2 = -1;
        int i3 = this.f19b;
        int i4 = -1;
        int i5 = i;
        int i6 = 0;
        while (i6 < this.f19b) {
            int i7 = i4;
            int i8 = i2;
            int i9 = i5;
            for (int i10 = 0; i10 < this.c; i10++) {
                int i11 = this.d[(this.c * i6) + i10];
                if (i11 != 0) {
                    if (i6 < i3) {
                        i3 = i6;
                    }
                    if (i6 > i7) {
                        i7 = i6;
                    }
                    int i12 = i10 << 5;
                    int i13 = 31;
                    if (i12 < i9) {
                        int i14 = 0;
                        while ((i11 << (31 - i14)) == 0) {
                            i14++;
                        }
                        int i15 = i14 + i12;
                        if (i15 < i9) {
                            i9 = i15;
                        }
                    }
                    if (i12 + 31 > i8) {
                        while ((i11 >>> i13) == 0) {
                            i13--;
                        }
                        int i16 = i12 + i13;
                        if (i16 > i8) {
                            i8 = i16;
                        }
                    }
                }
            }
            i6++;
            i5 = i9;
            i2 = i8;
            i4 = i7;
        }
        if (i2 < i5 || i4 < i3) {
            return null;
        }
        return new int[]{i5, i3, (i2 - i5) + 1, (i4 - i3) + 1};
    }

    public int[] c() {
        int i = 0;
        while (i < this.d.length && this.d[i] == 0) {
            i++;
        }
        if (i == this.d.length) {
            return null;
        }
        int i2 = i / this.c;
        int i3 = (i % this.c) << 5;
        int i4 = 0;
        while ((this.d[i] << (31 - i4)) == 0) {
            i4++;
        }
        return new int[]{i3 + i4, i2};
    }

    public int[] d() {
        int length = this.d.length - 1;
        while (length >= 0 && this.d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = length / this.c;
        int i2 = (length % this.c) << 5;
        int i3 = 31;
        while ((this.d[length] >>> i3) == 0) {
            i3--;
        }
        return new int[]{i2 + i3, i};
    }

    public int e() {
        return this.f18a;
    }

    public int f() {
        return this.f19b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f18a == bVar.f18a && this.f19b == bVar.f19b && this.c == bVar.c && Arrays.equals(this.d, bVar.d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f18a * 31) + this.f18a) * 31) + this.f19b) * 31) + this.c) * 31) + Arrays.hashCode(this.d);
    }

    public String toString() {
        return a("X ", "  ");
    }

    public String a(String str, String str2) {
        return a(str, str2, "\n");
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f19b * (this.f18a + 1));
        for (int i = 0; i < this.f19b; i++) {
            for (int i2 = 0; i2 < this.f18a; i2++) {
                sb.append(a(i2, i) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    /* renamed from: g */
    public b clone() {
        return new b(this.f18a, this.f19b, this.c, (int[]) this.d.clone());
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\b\c.java ==========

package a.a.a.b;

/* compiled from: BitSource */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f25a;

    /* renamed from: b  reason: collision with root package name */
    private int f26b;
    private int c;

    public c(byte[] bArr) {
        this.f25a = bArr;
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.f26b;
    }

    public int a(int i) {
        byte b2;
        if (i <= 0 || i > 32 || i > c()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        if (this.c > 0) {
            int i2 = 8 - this.c;
            int i3 = i < i2 ? i : i2;
            int i4 = i2 - i3;
            b2 = (((255 >> (8 - i3)) << i4) & this.f25a[this.f26b]) >> i4;
            i -= i3;
            this.c += i3;
            if (this.c == 8) {
                this.c = 0;
                this.f26b++;
            }
        } else {
            b2 = 0;
        }
        if (i <= 0) {
            return b2;
        }
        while (i >= 8) {
            b2 = (b2 << 8) | (this.f25a[this.f26b] & 255);
            this.f26b++;
            i -= 8;
        }
        if (i <= 0) {
            return b2;
        }
        int i5 = 8 - i;
        int i6 = (b2 << i) | ((((255 >> i5) << i5) & this.f25a[this.f26b]) >> i5);
        this.c += i;
        return i6;
    }

    public int c() {
        return ((this.f25a.length - this.f26b) * 8) - this.c;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\b\d.java ==========

package a.a.a.b;

import a.a.a.f;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CharacterSetECI */
public enum d {
    Cp437((String) new int[]{0, 2}, (int) new String[0]),
    ISO8859_1((String) new int[]{1, 3}, (int) new String[]{"ISO-8859-1"}),
    ISO8859_2((String) 4, (int) new String[]{"ISO-8859-2"}),
    ISO8859_3((String) 5, (int) new String[]{"ISO-8859-3"}),
    ISO8859_4((String) 6, (int) new String[]{"ISO-8859-4"}),
    ISO8859_5((String) 7, (int) new String[]{"ISO-8859-5"}),
    ISO8859_6((String) 8, (int) new String[]{"ISO-8859-6"}),
    ISO8859_7((String) 9, (int) new String[]{"ISO-8859-7"}),
    ISO8859_8((String) 10, (int) new String[]{"ISO-8859-8"}),
    ISO8859_9((String) 11, (int) new String[]{"ISO-8859-9"}),
    ISO8859_10((String) 12, (int) new String[]{"ISO-8859-10"}),
    ISO8859_11((String) 13, (int) new String[]{"ISO-8859-11"}),
    ISO8859_13((String) 15, (int) new String[]{"ISO-8859-13"}),
    ISO8859_14((String) 16, (int) new String[]{"ISO-8859-14"}),
    ISO8859_15((String) 17, (int) new String[]{"ISO-8859-15"}),
    ISO8859_16((String) 18, (int) new String[]{"ISO-8859-16"}),
    SJIS((String) 20, (int) new String[]{"Shift_JIS"}),
    Cp1250((String) 21, (int) new String[]{"windows-1250"}),
    Cp1251((String) 22, (int) new String[]{"windows-1251"}),
    Cp1252((String) 23, (int) new String[]{"windows-1252"}),
    Cp1256((String) 24, (int) new String[]{"windows-1256"}),
    UnicodeBigUnmarked((String) 25, (int) new String[]{"UTF-16BE", "UnicodeBig"}),
    UTF8((String) 26, (int) new String[]{"UTF-8"}),
    ASCII((String) new int[]{27, 170}, (int) new String[]{"US-ASCII"}),
    Big5(28),
    GB18030((String) 29, (int) new String[]{"GB2312", "EUC_CN", "GBK"}),
    EUC_KR((String) 30, (int) new String[]{"EUC-KR"});
    
    private static final Map<Integer, d> B = null;
    private static final Map<String, d> C = null;
    private final int[] D;
    private final String[] E;

    static {
        B = new HashMap();
        C = new HashMap();
        for (d dVar : values()) {
            for (int valueOf : dVar.D) {
                B.put(Integer.valueOf(valueOf), dVar);
            }
            C.put(dVar.name(), dVar);
            for (String put : dVar.E) {
                C.put(put, dVar);
            }
        }
    }

    private d(int i) {
        this(r3, r4, new int[]{i}, new String[0]);
    }

    private d(int i, String... strArr) {
        this.D = new int[]{i};
        this.E = strArr;
    }

    private d(int[] iArr, String... strArr) {
        this.D = iArr;
        this.E = strArr;
    }

    public static d a(int i) throws f {
        if (i >= 0 && i < 900) {
            return B.get(Integer.valueOf(i));
        }
        throw f.a();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\b\e.java ==========

package a.a.a.b;

import java.util.List;

/* compiled from: DecoderResult */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f29a;

    /* renamed from: b  reason: collision with root package name */
    private int f30b;
    private final String c;
    private final List<byte[]> d;
    private final String e;
    private Integer f;
    private Integer g;
    private Object h;
    private final int i;
    private final int j;

    public e(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public e(byte[] bArr, String str, List<byte[]> list, String str2, int i2, int i3) {
        int i4;
        this.f29a = bArr;
        if (bArr == null) {
            i4 = 0;
        } else {
            i4 = bArr.length * 8;
        }
        this.f30b = i4;
        this.c = str;
        this.d = list;
        this.e = str2;
        this.i = i3;
        this.j = i2;
    }

    public byte[] a() {
        return this.f29a;
    }

    public int b() {
        return this.f30b;
    }

    public void a(int i2) {
        this.f30b = i2;
    }

    public String c() {
        return this.c;
    }

    public List<byte[]> d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public void a(Integer num) {
        this.f = num;
    }

    public void b(Integer num) {
        this.g = num;
    }

    public Object f() {
        return this.h;
    }

    public void a(Object obj) {
        this.h = obj;
    }

    public boolean g() {
        return this.i >= 0 && this.j >= 0;
    }

    public int h() {
        return this.i;
    }

    public int i() {
        return this.j;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\b\f.java ==========

package a.a.a.b;

import a.a.a.i;

/* compiled from: DefaultGridSampler */
public final class f extends i {
    public b a(b bVar, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws i {
        b bVar2 = bVar;
        int i3 = i;
        int i4 = i2;
        return a(bVar, i, i2, k.a(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16));
    }

    public b a(b bVar, int i, int i2, k kVar) throws i {
        if (i <= 0 || i2 <= 0) {
            throw i.a();
        }
        b bVar2 = new b(i, i2);
        float[] fArr = new float[(i * 2)];
        for (int i3 = 0; i3 < i2; i3++) {
            int length = fArr.length;
            float f = ((float) i3) + 0.5f;
            for (int i4 = 0; i4 < length; i4 += 2) {
                fArr[i4] = ((float) (i4 / 2)) + 0.5f;
                fArr[i4 + 1] = f;
            }
            kVar.a(fArr);
            a(bVar, fArr);
            int i5 = 0;
            while (i5 < length) {
                try {
                    if (bVar.a((int) fArr[i5], (int) fArr[i5 + 1])) {
                        bVar2.b(i5 / 2, i3);
                    }
                    i5 += 2;
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw i.a();
                }
            }
        }
        return bVar2;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\b\g.java ==========

package a.a.a.b;

import a.a.a.o;

/* compiled from: DetectorResult */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final b f31a;

    /* renamed from: b  reason: collision with root package name */
    private final o[] f32b;

    public g(b bVar, o[] oVarArr) {
        this.f31a = bVar;
        this.f32b = oVarArr;
    }

    public final b d() {
        return this.f31a;
    }

    public final o[] e() {
        return this.f32b;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\b\h.java ==========

package a.a.a.b;

import a.a.a.b;
import a.a.a.g;
import a.a.a.i;

/* compiled from: GlobalHistogramBinarizer */
public class h extends b {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f33a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    private byte[] f34b = f33a;
    private final int[] c = new int[32];

    public h(g gVar) {
        super(gVar);
    }

    public a a(int i, a aVar) throws i {
        g a2 = a();
        int b2 = a2.b();
        if (aVar == null || aVar.a() < b2) {
            aVar = new a(b2);
        } else {
            aVar.b();
        }
        a(b2);
        byte[] a3 = a2.a(i, this.f34b);
        int[] iArr = this.c;
        for (int i2 = 0; i2 < b2; i2++) {
            int i3 = (a3[i2] & 255) >> 3;
            iArr[i3] = iArr[i3] + 1;
        }
        int a4 = a(iArr);
        if (b2 < 3) {
            for (int i4 = 0; i4 < b2; i4++) {
                if ((a3[i4] & 255) < a4) {
                    aVar.b(i4);
                }
            }
        } else {
            byte b3 = a3[1] & 255;
            byte b4 = a3[0] & 255;
            int i5 = 1;
            while (i5 < b2 - 1) {
                int i6 = i5 + 1;
                byte b5 = a3[i6] & 255;
                if ((((b3 << 2) - b4) - b5) / 2 < a4) {
                    aVar.b(i5);
                }
                b4 = b3;
                i5 = i6;
                b3 = b5;
            }
        }
        return aVar;
    }

    public b b() throws i {
        g a2 = a();
        int b2 = a2.b();
        int c2 = a2.c();
        b bVar = new b(b2, c2);
        a(b2);
        int[] iArr = this.c;
        for (int i = 1; i < 5; i++) {
            byte[] a3 = a2.a((c2 * i) / 5, this.f34b);
            int i2 = (b2 << 2) / 5;
            for (int i3 = b2 / 5; i3 < i2; i3++) {
                int i4 = (a3[i3] & 255) >> 3;
                iArr[i4] = iArr[i4] + 1;
            }
        }
        int a4 = a(iArr);
        byte[] a5 = a2.a();
        for (int i5 = 0; i5 < c2; i5++) {
            int i6 = i5 * b2;
            for (int i7 = 0; i7 < b2; i7++) {
                if ((a5[i6 + i7] & 255) < a4) {
                    bVar.b(i7, i5);
                }
            }
        }
        return bVar;
    }

    public b a(g gVar) {
        return new h(gVar);
    }

    private void a(int i) {
        if (this.f34b.length < i) {
            this.f34b = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.c[i2] = 0;
        }
    }

    private static int a(int[] iArr) throws i {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (iArr[i4] > i) {
                i = iArr[i4];
                i3 = i4;
            }
            if (iArr[i4] > i2) {
                i2 = iArr[i4];
            }
        }
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = i7 - i3;
            int i9 = iArr[i7] * i8 * i8;
            if (i9 > i5) {
                i6 = i7;
                i5 = i9;
            }
        }
        if (i3 > i6) {
            int i10 = i3;
            i3 = i6;
            i6 = i10;
        }
        if (i6 - i3 > length / 16) {
            int i11 = i6 - 1;
            int i12 = -1;
            int i13 = i11;
            while (i11 > i3) {
                int i14 = i11 - i3;
                int i15 = i14 * i14 * (i6 - i11) * (i2 - iArr[i11]);
                if (i15 > i12) {
                    i13 = i11;
                    i12 = i15;
                }
                i11--;
            }
            return i13 << 3;
        }
        throw i.a();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\b\i.java ==========

package a.a.a.b;

/* compiled from: GridSampler */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private static i f35a = new f();

    public abstract b a(b bVar, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws a.a.a.i;

    public abstract b a(b bVar, int i, int i2, k kVar) throws a.a.a.i;

    public static i a() {
        return f35a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static void a(a.a.a.b.b r9, float[] r10) throws a.a.a.i {
        /*
            int r0 = r9.e()
            int r9 = r9.f()
            r1 = 0
            r2 = 1
            r3 = 0
            r4 = 1
        L_0x000c:
            int r5 = r10.length
            r6 = 0
            r7 = -1
            if (r3 >= r5) goto L_0x0048
            if (r4 == 0) goto L_0x0048
            r4 = r10[r3]
            int r4 = (int) r4
            int r5 = r3 + 1
            r8 = r10[r5]
            int r8 = (int) r8
            if (r4 < r7) goto L_0x0043
            if (r4 > r0) goto L_0x0043
            if (r8 < r7) goto L_0x0043
            if (r8 > r9) goto L_0x0043
            if (r4 != r7) goto L_0x0029
            r10[r3] = r6
        L_0x0027:
            r4 = 1
            goto L_0x0032
        L_0x0029:
            if (r4 != r0) goto L_0x0031
            int r4 = r0 + -1
            float r4 = (float) r4
            r10[r3] = r4
            goto L_0x0027
        L_0x0031:
            r4 = 0
        L_0x0032:
            if (r8 != r7) goto L_0x0038
            r10[r5] = r6
        L_0x0036:
            r4 = 1
            goto L_0x0040
        L_0x0038:
            if (r8 != r9) goto L_0x0040
            int r4 = r9 + -1
            float r4 = (float) r4
            r10[r5] = r4
            goto L_0x0036
        L_0x0040:
            int r3 = r3 + 2
            goto L_0x000c
        L_0x0043:
            a.a.a.i r9 = a.a.a.i.a()
            throw r9
        L_0x0048:
            int r3 = r10.length
            int r3 = r3 + -2
            r4 = 1
        L_0x004c:
            if (r3 < 0) goto L_0x0085
            if (r4 == 0) goto L_0x0085
            r4 = r10[r3]
            int r4 = (int) r4
            int r5 = r3 + 1
            r8 = r10[r5]
            int r8 = (int) r8
            if (r4 < r7) goto L_0x0080
            if (r4 > r0) goto L_0x0080
            if (r8 < r7) goto L_0x0080
            if (r8 > r9) goto L_0x0080
            if (r4 != r7) goto L_0x0066
            r10[r3] = r6
        L_0x0064:
            r4 = 1
            goto L_0x006f
        L_0x0066:
            if (r4 != r0) goto L_0x006e
            int r4 = r0 + -1
            float r4 = (float) r4
            r10[r3] = r4
            goto L_0x0064
        L_0x006e:
            r4 = 0
        L_0x006f:
            if (r8 != r7) goto L_0x0075
            r10[r5] = r6
        L_0x0073:
            r4 = 1
            goto L_0x007d
        L_0x0075:
            if (r8 != r9) goto L_0x007d
            int r4 = r9 + -1
            float r4 = (float) r4
            r10[r5] = r4
            goto L_0x0073
        L_0x007d:
            int r3 = r3 + -2
            goto L_0x004c
        L_0x0080:
            a.a.a.i r9 = a.a.a.i.a()
            throw r9
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.b.i.a(a.a.a.b.b, float[]):void");
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\b\j.java ==========

package a.a.a.b;

import a.a.a.b;
import a.a.a.g;
import a.a.a.i;
import java.lang.reflect.Array;

/* compiled from: HybridBinarizer */
public final class j extends h {

    /* renamed from: a  reason: collision with root package name */
    private b f36a;

    private static int a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public j(g gVar) {
        super(gVar);
    }

    public b b() throws i {
        if (this.f36a != null) {
            return this.f36a;
        }
        g a2 = a();
        int b2 = a2.b();
        int c = a2.c();
        if (b2 < 40 || c < 40) {
            this.f36a = super.b();
        } else {
            byte[] a3 = a2.a();
            int i = b2 >> 3;
            if ((b2 & 7) != 0) {
                i++;
            }
            int i2 = i;
            int i3 = c >> 3;
            if ((c & 7) != 0) {
                i3++;
            }
            int i4 = i3;
            int[][] a4 = a(a3, i2, i4, b2, c);
            b bVar = new b(b2, c);
            a(a3, i2, i4, b2, c, a4, bVar);
            this.f36a = bVar;
        }
        return this.f36a;
    }

    public b a(g gVar) {
        return new j(gVar);
    }

    private static void a(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, b bVar) {
        int i5 = i;
        int i6 = i2;
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = i7 << 3;
            int i9 = i4 - 8;
            if (i8 > i9) {
                i8 = i9;
            }
            for (int i10 = 0; i10 < i5; i10++) {
                int i11 = i10 << 3;
                int i12 = i3 - 8;
                if (i11 <= i12) {
                    i12 = i11;
                }
                int a2 = a(i10, 2, i5 - 3);
                int a3 = a(i7, 2, i6 - 3);
                int i13 = 0;
                for (int i14 = -2; i14 <= 2; i14++) {
                    int[] iArr2 = iArr[a3 + i14];
                    i13 += iArr2[a2 - 2] + iArr2[a2 - 1] + iArr2[a2] + iArr2[a2 + 1] + iArr2[a2 + 2];
                }
                a(bArr, i12, i8, i13 / 25, i3, bVar);
            }
        }
    }

    private static void a(byte[] bArr, int i, int i2, int i3, int i4, b bVar) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & 255) <= i3) {
                    bVar.b(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    private static int[][] a(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{i6, i5});
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = i7 << 3;
            int i9 = 8;
            int i10 = i4 - 8;
            if (i8 > i10) {
                i8 = i10;
            }
            int i11 = 0;
            while (i11 < i5) {
                int i12 = i11 << 3;
                int i13 = i3 - 8;
                if (i12 > i13) {
                    i12 = i13;
                }
                int i14 = (i8 * i3) + i12;
                int i15 = 0;
                int i16 = 0;
                byte b2 = 0;
                byte b3 = 255;
                while (i15 < i9) {
                    byte b4 = b2;
                    int i17 = i16;
                    int i18 = 0;
                    while (i18 < i9) {
                        byte b5 = bArr[i14 + i18] & 255;
                        i17 += b5;
                        if (b5 < b3) {
                            b3 = b5;
                        }
                        if (b5 > b4) {
                            b4 = b5;
                        }
                        i18++;
                        i9 = 8;
                    }
                    if (b4 - b3 <= 24) {
                        i16 = i17;
                        i15++;
                        i14 += i3;
                        b2 = b4;
                        i9 = 8;
                    }
                    while (true) {
                        i15++;
                        i14 += i3;
                        if (i15 >= 8) {
                            break;
                        }
                        int i19 = 0;
                        for (int i20 = 8; i19 < i20; i20 = 8) {
                            i17 += bArr[i14 + i19] & 255;
                            i19++;
                        }
                    }
                    i16 = i17;
                    i15++;
                    i14 += i3;
                    b2 = b4;
                    i9 = 8;
                }
                int i21 = i16 >> 6;
                if (b2 - b3 <= 24) {
                    i21 = b3 / 2;
                    if (i7 > 0 && i11 > 0) {
                        int i22 = i7 - 1;
                        int i23 = i11 - 1;
                        int i24 = ((iArr[i22][i11] + (iArr[i7][i23] * 2)) + iArr[i22][i23]) / 4;
                        if (b3 < i24) {
                            i21 = i24;
                        }
                    }
                }
                iArr[i7][i11] = i21;
                i11++;
                i9 = 8;
            }
        }
        return iArr;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\b\k.java ==========

package a.a.a.b;

import net.fxgear.GlobalDefine;

/* compiled from: PerspectiveTransform */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final float f37a;

    /* renamed from: b  reason: collision with root package name */
    private final float f38b;
    private final float c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final float i;

    private k(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.f37a = f2;
        this.f38b = f5;
        this.c = f8;
        this.d = f3;
        this.e = f6;
        this.f = f9;
        this.g = f4;
        this.h = f7;
        this.i = f10;
    }

    public static k a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        return a(f10, f11, f12, f13, f14, f15, f16, f17).a(b(f2, f3, f4, f5, f6, f7, f8, f9));
    }

    public void a(float[] fArr) {
        float[] fArr2 = fArr;
        int length = fArr2.length;
        float f2 = this.f37a;
        float f3 = this.f38b;
        float f4 = this.c;
        float f5 = this.d;
        float f6 = this.e;
        float f7 = this.f;
        float f8 = this.g;
        float f9 = this.h;
        float f10 = this.i;
        for (int i2 = 0; i2 < length; i2 += 2) {
            float f11 = fArr2[i2];
            int i3 = i2 + 1;
            float f12 = fArr2[i3];
            float f13 = (f4 * f11) + (f7 * f12) + f10;
            fArr2[i2] = (((f2 * f11) + (f5 * f12)) + f8) / f13;
            fArr2[i3] = (((f11 * f3) + (f12 * f6)) + f9) / f13;
        }
    }

    public static k a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = ((f2 - f4) + f6) - f8;
        float f11 = ((f3 - f5) + f7) - f9;
        if (f10 == GlobalDefine.DEFAULT_AUTO_FILTER_VALUE && f11 == GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
            return new k(f4 - f2, f6 - f4, f2, f5 - f3, f7 - f5, f3, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f);
        }
        float f12 = f4 - f6;
        float f13 = f8 - f6;
        float f14 = f5 - f7;
        float f15 = f9 - f7;
        float f16 = (f12 * f15) - (f13 * f14);
        float f17 = ((f15 * f10) - (f13 * f11)) / f16;
        float f18 = ((f12 * f11) - (f10 * f14)) / f16;
        return new k((f4 - f2) + (f17 * f4), (f18 * f8) + (f8 - f2), f2, (f5 - f3) + (f17 * f5), (f9 - f3) + (f18 * f9), f3, f17, f18, 1.0f);
    }

    public static k b(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return a(f2, f3, f4, f5, f6, f7, f8, f9).a();
    }

    /* access modifiers changed from: package-private */
    public k a() {
        return new k((this.e * this.i) - (this.f * this.h), (this.f * this.g) - (this.d * this.i), (this.d * this.h) - (this.e * this.g), (this.c * this.h) - (this.f38b * this.i), (this.f37a * this.i) - (this.c * this.g), (this.f38b * this.g) - (this.f37a * this.h), (this.f38b * this.f) - (this.c * this.e), (this.c * this.d) - (this.f37a * this.f), (this.f37a * this.e) - (this.f38b * this.d));
    }

    /* access modifiers changed from: package-private */
    public k a(k kVar) {
        return new k((this.g * kVar.c) + (this.f37a * kVar.f37a) + (this.d * kVar.f38b), (this.g * kVar.f) + (this.f37a * kVar.d) + (this.d * kVar.e), (this.g * kVar.i) + (this.f37a * kVar.g) + (this.d * kVar.h), (this.h * kVar.c) + (this.f38b * kVar.f37a) + (this.e * kVar.f38b), (this.h * kVar.f) + (this.f38b * kVar.d) + (this.e * kVar.e), (this.h * kVar.i) + (this.f38b * kVar.g) + (this.e * kVar.h), (this.i * kVar.c) + (this.c * kVar.f37a) + (this.f * kVar.f38b), (this.i * kVar.f) + (this.c * kVar.d) + (this.f * kVar.e), (this.i * kVar.i) + (this.c * kVar.g) + (this.f * kVar.h));
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\b\l.java ==========

package a.a.a.b;

import a.a.a.e;
import java.nio.charset.Charset;
import java.util.Map;

/* compiled from: StringUtils */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    private static final String f39a = Charset.defaultCharset().name();

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f40b = ("SJIS".equalsIgnoreCase(f39a) || "EUC_JP".equalsIgnoreCase(f39a));

    public static String a(byte[] bArr, Map<e, ?> map) {
        byte[] bArr2 = bArr;
        Map<e, ?> map2 = map;
        if (map2 != null && map2.containsKey(e.CHARACTER_SET)) {
            return map2.get(e.CHARACTER_SET).toString();
        }
        int length = bArr2.length;
        int i = 0;
        boolean z = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        int i2 = 0;
        int i3 = 0;
        boolean z2 = true;
        boolean z3 = true;
        boolean z4 = true;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i3 < length && (z2 || z3 || z4)) {
            byte b2 = bArr2[i3] & 255;
            if (z4) {
                if (i4 > 0) {
                    if ((b2 & 128) != 0) {
                        i4--;
                    }
                } else if ((b2 & 128) != 0) {
                    if ((b2 & 64) != 0) {
                        i4++;
                        if ((b2 & 32) == 0) {
                            i6++;
                        } else {
                            i4++;
                            if ((b2 & 16) == 0) {
                                i7++;
                            } else {
                                i4++;
                                if ((b2 & 8) == 0) {
                                    i8++;
                                }
                            }
                        }
                    }
                }
                z4 = false;
            }
            if (z2) {
                if (b2 > Byte.MAX_VALUE && b2 < 160) {
                    z2 = false;
                } else if (b2 > 159 && (b2 < 192 || b2 == 215 || b2 == 247)) {
                    i10++;
                }
            }
            if (z3) {
                if (i5 > 0) {
                    if (b2 >= 64 && b2 != Byte.MAX_VALUE && b2 <= 252) {
                        i5--;
                    }
                } else if (!(b2 == 128 || b2 == 160 || b2 > 239)) {
                    if (b2 > 160 && b2 < 224) {
                        i2++;
                        int i13 = i11 + 1;
                        if (i13 > i9) {
                            i9 = i13;
                            i11 = i9;
                        } else {
                            i11 = i13;
                        }
                    } else if (b2 > Byte.MAX_VALUE) {
                        i5++;
                        int i14 = i12 + 1;
                        if (i14 > i) {
                            i = i14;
                            i12 = i;
                        } else {
                            i12 = i14;
                        }
                        i11 = 0;
                    } else {
                        i11 = 0;
                    }
                    i12 = 0;
                }
                z3 = false;
            }
            i3++;
            bArr2 = bArr;
        }
        if (z4 && i4 > 0) {
            z4 = false;
        }
        boolean z5 = (!z3 || i5 <= 0) ? z3 : false;
        if (z4 && (z || i6 + i7 + i8 > 0)) {
            return "UTF8";
        }
        if (z5 && (f40b || i9 >= 3 || i >= 3)) {
            return "SJIS";
        }
        if (z2 && z5) {
            return (!(i9 == 2 && i2 == 2) && i10 * 10 < length) ? "ISO8859_1" : "SJIS";
        }
        if (z2) {
            return "ISO8859_1";
        }
        if (z5) {
            return "SJIS";
        }
        return z4 ? "UTF8" : f39a;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\b\a\a.java ==========

package a.a.a.b.a;

import net.fxgear.GlobalDefine;

/* compiled from: MathUtils */
public final class a {
    public static int a(float f) {
        return (int) (f + (f < GlobalDefine.DEFAULT_AUTO_FILTER_VALUE ? -0.5f : 0.5f));
    }

    public static float a(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }

    public static float a(int i, int i2, int i3, int i4) {
        int i5 = i - i3;
        int i6 = i2 - i4;
        return (float) Math.sqrt((double) ((i5 * i5) + (i6 * i6)));
    }

    public static int a(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\b\a\b.java ==========

package a.a.a.b.a;

import a.a.a.i;
import a.a.a.o;

/* compiled from: WhiteRectangleDetector */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final a.a.a.b.b f16a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public b(a.a.a.b.b bVar) throws i {
        this(bVar, 10, bVar.e() / 2, bVar.f() / 2);
    }

    public b(a.a.a.b.b bVar, int i, int i2, int i3) throws i {
        this.f16a = bVar;
        this.f17b = bVar.f();
        this.c = bVar.e();
        int i4 = i / 2;
        this.d = i2 - i4;
        this.e = i2 + i4;
        this.g = i3 - i4;
        this.f = i3 + i4;
        if (this.g < 0 || this.d < 0 || this.f >= this.f17b || this.e >= this.c) {
            throw i.a();
        }
    }

    public o[] a() throws i {
        int i = this.d;
        int i2 = this.e;
        int i3 = this.g;
        int i4 = this.f;
        boolean z = false;
        int i5 = 1;
        int i6 = i;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        while (true) {
            if (!z2) {
                break;
            }
            boolean z8 = true;
            boolean z9 = false;
            while (true) {
                if ((z8 || !z3) && i2 < this.c) {
                    z8 = a(i3, i4, i2, false);
                    if (z8) {
                        i2++;
                        z3 = true;
                        z9 = true;
                    } else if (!z3) {
                        i2++;
                    }
                }
            }
            if (i2 >= this.c) {
                break;
            }
            boolean z10 = true;
            while (true) {
                if ((z10 || !z4) && i4 < this.f17b) {
                    z10 = a(i6, i2, i4, true);
                    if (z10) {
                        i4++;
                        z4 = true;
                        z9 = true;
                    } else if (!z4) {
                        i4++;
                    }
                }
            }
            if (i4 >= this.f17b) {
                break;
            }
            boolean z11 = true;
            while (true) {
                if ((z11 || !z5) && i6 >= 0) {
                    z11 = a(i3, i4, i6, false);
                    if (z11) {
                        i6--;
                        z5 = true;
                        z9 = true;
                    } else if (!z5) {
                        i6--;
                    }
                }
            }
            if (i6 < 0) {
                break;
            }
            boolean z12 = true;
            while (true) {
                if ((z12 || !z7) && i3 >= 0) {
                    z12 = a(i6, i2, i3, true);
                    if (z12) {
                        i3--;
                        z7 = true;
                        z9 = true;
                    } else if (!z7) {
                        i3--;
                    }
                }
            }
            if (i3 < 0) {
                break;
            }
            if (z9) {
                z6 = true;
            }
            z2 = z9;
        }
        z = true;
        if (z || !z6) {
            throw i.a();
        }
        int i7 = i2 - i6;
        o oVar = null;
        o oVar2 = null;
        int i8 = 1;
        while (oVar2 == null && i8 < i7) {
            oVar2 = a((float) i6, (float) (i4 - i8), (float) (i6 + i8), (float) i4);
            i8++;
        }
        if (oVar2 != null) {
            o oVar3 = null;
            int i9 = 1;
            while (oVar3 == null && i9 < i7) {
                oVar3 = a((float) i6, (float) (i3 + i9), (float) (i6 + i9), (float) i3);
                i9++;
            }
            if (oVar3 != null) {
                o oVar4 = null;
                int i10 = 1;
                while (oVar4 == null && i10 < i7) {
                    oVar4 = a((float) i2, (float) (i3 + i10), (float) (i2 - i10), (float) i3);
                    i10++;
                }
                if (oVar4 != null) {
                    while (oVar == null && i5 < i7) {
                        oVar = a((float) i2, (float) (i4 - i5), (float) (i2 - i5), (float) i4);
                        i5++;
                    }
                    if (oVar != null) {
                        return a(oVar, oVar2, oVar4, oVar3);
                    }
                    throw i.a();
                }
                throw i.a();
            }
            throw i.a();
        }
        throw i.a();
    }

    private o a(float f2, float f3, float f4, float f5) {
        int a2 = a.a(a.a(f2, f3, f4, f5));
        float f6 = (float) a2;
        float f7 = (f4 - f2) / f6;
        float f8 = (f5 - f3) / f6;
        for (int i = 0; i < a2; i++) {
            float f9 = (float) i;
            int a3 = a.a((f9 * f7) + f2);
            int a4 = a.a((f9 * f8) + f3);
            if (this.f16a.a(a3, a4)) {
                return new o((float) a3, (float) a4);
            }
        }
        return null;
    }

    private o[] a(o oVar, o oVar2, o oVar3, o oVar4) {
        float a2 = oVar.a();
        float b2 = oVar.b();
        float a3 = oVar2.a();
        float b3 = oVar2.b();
        float a4 = oVar3.a();
        float b4 = oVar3.b();
        float a5 = oVar4.a();
        float b5 = oVar4.b();
        if (a2 < ((float) this.c) / 2.0f) {
            return new o[]{new o(a5 - 1.0f, b5 + 1.0f), new o(a3 + 1.0f, b3 + 1.0f), new o(a4 - 1.0f, b4 - 1.0f), new o(a2 + 1.0f, b2 - 1.0f)};
        }
        return new o[]{new o(a5 + 1.0f, b5 + 1.0f), new o(a3 + 1.0f, b3 - 1.0f), new o(a4 - 1.0f, b4 + 1.0f), new o(a2 - 1.0f, b2 - 1.0f)};
    }

    private boolean a(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.f16a.a(i, i3)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        while (i <= i2) {
            if (this.f16a.a(i3, i)) {
                return true;
            }
            i++;
        }
        return false;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\b\b\a.java ==========

package a.a.a.b.b;

import net.fxgear.util.FXUtil;

/* compiled from: GenericGF */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f20a = new a(4201, 4096, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final a f21b = new a(1033, FXUtil.MAX_CUSTOM_FACE_IMAGE_SIZE, 1);
    public static final a c = new a(67, 64, 1);
    public static final a d = new a(19, 16, 1);
    public static final a e = new a(285, 256, 0);
    public static final a f;
    public static final a g;
    public static final a h = c;
    private final int[] i;
    private final int[] j;
    private final b k;
    private final b l;
    private final int m;
    private final int n;
    private final int o;

    static int b(int i2, int i3) {
        return i2 ^ i3;
    }

    static {
        a aVar = new a(301, 256, 1);
        f = aVar;
        g = aVar;
    }

    public a(int i2, int i3, int i4) {
        this.n = i2;
        this.m = i3;
        this.o = i4;
        this.i = new int[i3];
        this.j = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.i[i6] = i5;
            i5 <<= 1;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.j[this.i[i7]] = i7;
        }
        this.k = new b(this, new int[]{0});
        this.l = new b(this, new int[]{1});
    }

    /* access modifiers changed from: package-private */
    public b a() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public b b() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public b a(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        } else if (i3 == 0) {
            return this.k;
        } else {
            int[] iArr = new int[(i2 + 1)];
            iArr[0] = i3;
            return new b(this, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    public int a(int i2) {
        return this.i[i2];
    }

    /* access modifiers changed from: package-private */
    public int b(int i2) {
        if (i2 != 0) {
            return this.j[i2];
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public int c(int i2) {
        if (i2 != 0) {
            return this.i[(this.m - this.j[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    /* access modifiers changed from: package-private */
    public int c(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        return this.i[(this.j[i2] + this.j[i3]) % (this.m - 1)];
    }

    public int c() {
        return this.m;
    }

    public int d() {
        return this.o;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.n) + ',' + this.m + ')';
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\b\b\b.java ==========

package a.a.a.b.b;

/* compiled from: GenericGFPoly */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final a f22a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f23b;

    b(a aVar, int[] iArr) {
        if (iArr.length != 0) {
            this.f22a = aVar;
            int length = iArr.length;
            if (length <= 1 || iArr[0] != 0) {
                this.f23b = iArr;
                return;
            }
            int i = 1;
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.f23b = new int[]{0};
                return;
            }
            this.f23b = new int[(length - i)];
            System.arraycopy(iArr, i, this.f23b, 0, this.f23b.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f23b.length - 1;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f23b[0] == 0;
    }

    /* access modifiers changed from: package-private */
    public int a(int i) {
        return this.f23b[(this.f23b.length - 1) - i];
    }

    /* access modifiers changed from: package-private */
    public int b(int i) {
        if (i == 0) {
            return a(0);
        }
        if (i == 1) {
            int i2 = 0;
            for (int b2 : this.f23b) {
                i2 = a.b(i2, b2);
            }
            return i2;
        }
        int i3 = this.f23b[0];
        int length = this.f23b.length;
        for (int i4 = 1; i4 < length; i4++) {
            i3 = a.b(this.f22a.c(i, i3), this.f23b[i4]);
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public b a(b bVar) {
        if (!this.f22a.equals(bVar.f22a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (b()) {
            return bVar;
        } else {
            if (bVar.b()) {
                return this;
            }
            int[] iArr = this.f23b;
            int[] iArr2 = bVar.f23b;
            if (iArr.length > iArr2.length) {
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            int[] iArr4 = new int[iArr2.length];
            int length = iArr2.length - iArr.length;
            System.arraycopy(iArr2, 0, iArr4, 0, length);
            for (int i = length; i < iArr2.length; i++) {
                iArr4[i] = a.b(iArr[i - length], iArr2[i]);
            }
            return new b(this.f22a, iArr4);
        }
    }

    /* access modifiers changed from: package-private */
    public b b(b bVar) {
        if (!this.f22a.equals(bVar.f22a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (b() || bVar.b()) {
            return this.f22a.a();
        } else {
            int[] iArr = this.f23b;
            int length = iArr.length;
            int[] iArr2 = bVar.f23b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i + i3;
                    iArr3[i4] = a.b(iArr3[i4], this.f22a.c(i2, iArr2[i3]));
                }
            }
            return new b(this.f22a, iArr3);
        }
    }

    /* access modifiers changed from: package-private */
    public b c(int i) {
        if (i == 0) {
            return this.f22a.a();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f23b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f22a.c(this.f23b[i2], i);
        }
        return new b(this.f22a, iArr);
    }

    /* access modifiers changed from: package-private */
    public b a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f22a.a();
        } else {
            int length = this.f23b.length;
            int[] iArr = new int[(i + length)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.f22a.c(this.f23b[i3], i2);
            }
            return new b(this.f22a, iArr);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(a() * 8);
        for (int a2 = a(); a2 >= 0; a2--) {
            int a3 = a(a2);
            if (a3 != 0) {
                if (a3 < 0) {
                    sb.append(" - ");
                    a3 = -a3;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (a2 == 0 || a3 != 1) {
                    int b2 = this.f22a.b(a3);
                    if (b2 == 0) {
                        sb.append('1');
                    } else if (b2 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(b2);
                    }
                }
                if (a2 != 0) {
                    if (a2 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(a2);
                    }
                }
            }
        }
        return sb.toString();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\b\b\c.java ==========

package a.a.a.b.b;

/* compiled from: ReedSolomonDecoder */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final a f24a;

    public c(a aVar) {
        this.f24a = aVar;
    }

    public void a(int[] iArr, int i) throws d {
        b bVar = new b(this.f24a, iArr);
        int[] iArr2 = new int[i];
        int i2 = 0;
        boolean z = true;
        for (int i3 = 0; i3 < i; i3++) {
            int b2 = bVar.b(this.f24a.a(this.f24a.d() + i3));
            iArr2[(i - 1) - i3] = b2;
            if (b2 != 0) {
                z = false;
            }
        }
        if (!z) {
            b[] a2 = a(this.f24a.a(i, 1), new b(this.f24a, iArr2), i);
            b bVar2 = a2[0];
            b bVar3 = a2[1];
            int[] a3 = a(bVar2);
            int[] a4 = a(bVar3, a3);
            while (i2 < a3.length) {
                int length = (iArr.length - 1) - this.f24a.b(a3[i2]);
                if (length >= 0) {
                    iArr[length] = a.b(iArr[length], a4[i2]);
                    i2++;
                } else {
                    throw new d("Bad error location");
                }
            }
        }
    }

    private b[] a(b bVar, b bVar2, int i) throws d {
        if (bVar.a() < bVar2.a()) {
            b bVar3 = bVar2;
            bVar2 = bVar;
            bVar = bVar3;
        }
        b a2 = this.f24a.a();
        b b2 = this.f24a.b();
        b bVar4 = bVar2;
        b bVar5 = bVar;
        b bVar6 = bVar4;
        while (bVar6.a() >= i / 2) {
            if (!bVar6.b()) {
                b a3 = this.f24a.a();
                int c = this.f24a.c(bVar6.a(bVar6.a()));
                while (bVar5.a() >= bVar6.a() && !bVar5.b()) {
                    int a4 = bVar5.a() - bVar6.a();
                    int c2 = this.f24a.c(bVar5.a(bVar5.a()), c);
                    a3 = a3.a(this.f24a.a(a4, c2));
                    bVar5 = bVar5.a(bVar6.a(a4, c2));
                }
                b a5 = a3.b(b2).a(a2);
                if (bVar5.a() < bVar6.a()) {
                    b bVar7 = bVar5;
                    bVar5 = bVar6;
                    bVar6 = bVar7;
                    b bVar8 = b2;
                    b2 = a5;
                    a2 = bVar8;
                } else {
                    throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
                }
            } else {
                throw new d("r_{i-1} was zero");
            }
        }
        int a6 = b2.a(0);
        if (a6 != 0) {
            int c3 = this.f24a.c(a6);
            return new b[]{b2.c(c3), bVar6.c(c3)};
        }
        throw new d("sigmaTilde(0) was zero");
    }

    private int[] a(b bVar) throws d {
        int a2 = bVar.a();
        int i = 0;
        if (a2 == 1) {
            return new int[]{bVar.a(1)};
        }
        int[] iArr = new int[a2];
        for (int i2 = 1; i2 < this.f24a.c() && i < a2; i2++) {
            if (bVar.b(i2) == 0) {
                iArr[i] = this.f24a.c(i2);
                i++;
            }
        }
        if (i == a2) {
            return iArr;
        }
        throw new d("Error locator degree does not match number of roots");
    }

    private int[] a(b bVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int c = this.f24a.c(iArr[i]);
            int i2 = 1;
            for (int i3 = 0; i3 < length; i3++) {
                if (i != i3) {
                    int c2 = this.f24a.c(iArr[i3], c);
                    i2 = this.f24a.c(i2, (c2 & 1) == 0 ? c2 | 1 : c2 & -2);
                }
            }
            iArr2[i] = this.f24a.c(bVar.b(c), this.f24a.c(i2));
            if (this.f24a.d() != 0) {
                iArr2[i] = this.f24a.c(iArr2[i], c);
            }
        }
        return iArr2;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\b\b\d.java ==========

package a.a.a.b.b;

/* compiled from: ReedSolomonException */
public final class d extends Exception {
    public d(String str) {
        super(str);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\c\a.java ==========

package a.a.a.c;

import a.a.a.b.b;
import a.a.a.b.g;
import a.a.a.c;
import a.a.a.c.a.d;
import a.a.a.e;
import a.a.a.f;
import a.a.a.i;
import a.a.a.k;
import a.a.a.m;
import a.a.a.n;
import a.a.a.o;
import java.util.List;
import java.util.Map;

/* compiled from: DataMatrixReader */
public final class a implements k {

    /* renamed from: a  reason: collision with root package name */
    private static final o[] f43a = new o[0];

    /* renamed from: b  reason: collision with root package name */
    private final d f44b = new d();

    public void a() {
    }

    public m a(c cVar, Map<e, ?> map) throws i, a.a.a.d, f {
        o[] oVarArr;
        a.a.a.b.e eVar;
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            g a2 = new a.a.a.c.b.a(cVar.c()).a();
            a.a.a.b.e a3 = this.f44b.a(a2.d());
            oVarArr = a2.e();
            eVar = a3;
        } else {
            eVar = this.f44b.a(a(cVar.c()));
            oVarArr = f43a;
        }
        m mVar = new m(eVar.c(), eVar.a(), oVarArr, a.a.a.a.DATA_MATRIX);
        List<byte[]> d = eVar.d();
        if (d != null) {
            mVar.a(n.BYTE_SEGMENTS, d);
        }
        String e = eVar.e();
        if (e != null) {
            mVar.a(n.ERROR_CORRECTION_LEVEL, e);
        }
        return mVar;
    }

    private static b a(b bVar) throws i {
        int[] c = bVar.c();
        int[] d = bVar.d();
        if (c == null || d == null) {
            throw i.a();
        }
        int a2 = a(c, bVar);
        int i = c[1];
        int i2 = d[1];
        int i3 = c[0];
        int i4 = ((d[0] - i3) + 1) / a2;
        int i5 = ((i2 - i) + 1) / a2;
        if (i4 <= 0 || i5 <= 0) {
            throw i.a();
        }
        int i6 = a2 / 2;
        int i7 = i + i6;
        int i8 = i3 + i6;
        b bVar2 = new b(i4, i5);
        for (int i9 = 0; i9 < i5; i9++) {
            int i10 = (i9 * a2) + i7;
            for (int i11 = 0; i11 < i4; i11++) {
                if (bVar.a((i11 * a2) + i8, i10)) {
                    bVar2.b(i11, i9);
                }
            }
        }
        return bVar2;
    }

    private static int a(int[] iArr, b bVar) throws i {
        int e = bVar.e();
        int i = iArr[0];
        int i2 = iArr[1];
        while (i < e && bVar.a(i, i2)) {
            i++;
        }
        if (i != e) {
            int i3 = i - iArr[0];
            if (i3 != 0) {
                return i3;
            }
            throw i.a();
        }
        throw i.a();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\c\a\a.java ==========

package a.a.a.c.a;

import a.a.a.b.b;
import a.a.a.f;

/* compiled from: BitMatrixParser */
final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f45a;

    /* renamed from: b  reason: collision with root package name */
    private final b f46b;
    private final e c;

    a(b bVar) throws f {
        int f = bVar.f();
        if (f < 8 || f > 144 || (f & 1) != 0) {
            throw f.a();
        }
        this.c = a(bVar);
        this.f45a = b(bVar);
        this.f46b = new b(this.f45a.e(), this.f45a.f());
    }

    /* access modifiers changed from: package-private */
    public e a() {
        return this.c;
    }

    private static e a(b bVar) throws f {
        return e.a(bVar.f(), bVar.e());
    }

    /* access modifiers changed from: package-private */
    public byte[] b() throws f {
        byte[] bArr = new byte[this.c.f()];
        int f = this.f45a.f();
        int e = this.f45a.e();
        int i = 4;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            if (i == f && i2 == 0 && !z) {
                bArr[i3] = (byte) a(f, e);
                i -= 2;
                i2 += 2;
                i3++;
                z = true;
            } else {
                int i4 = f - 2;
                if (i == i4 && i2 == 0 && (e & 3) != 0 && !z2) {
                    bArr[i3] = (byte) b(f, e);
                    i -= 2;
                    i2 += 2;
                    i3++;
                    z2 = true;
                } else if (i == f + 4 && i2 == 2 && (e & 7) == 0 && !z3) {
                    bArr[i3] = (byte) c(f, e);
                    i -= 2;
                    i2 += 2;
                    i3++;
                    z3 = true;
                } else if (i == i4 && i2 == 0 && (e & 7) == 4 && !z4) {
                    bArr[i3] = (byte) d(f, e);
                    i -= 2;
                    i2 += 2;
                    i3++;
                    z4 = true;
                } else {
                    do {
                        if (i < f && i2 >= 0 && !this.f46b.a(i2, i)) {
                            bArr[i3] = (byte) b(i, i2, f, e);
                            i3++;
                        }
                        i -= 2;
                        i2 += 2;
                        if (i < 0) {
                            break;
                        }
                    } while (i2 < e);
                    int i5 = i + 1;
                    int i6 = i2 + 3;
                    do {
                        if (i5 >= 0 && i6 < e && !this.f46b.a(i6, i5)) {
                            bArr[i3] = (byte) b(i5, i6, f, e);
                            i3++;
                        }
                        i5 += 2;
                        i6 -= 2;
                        if (i5 >= f) {
                            break;
                        }
                    } while (i6 >= 0);
                    i = i5 + 3;
                    i2 = i6 + 1;
                }
            }
            if (i >= f && i2 >= e) {
                break;
            }
        }
        if (i3 == this.c.f()) {
            return bArr;
        }
        throw f.a();
    }

    private boolean a(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += i3;
            i2 += 4 - ((i3 + 4) & 7);
        }
        if (i2 < 0) {
            i2 += i4;
            i += 4 - ((i4 + 4) & 7);
        }
        this.f46b.b(i2, i);
        return this.f45a.a(i2, i);
    }

    private int b(int i, int i2, int i3, int i4) {
        int i5 = i - 2;
        int i6 = i2 - 2;
        int i7 = (a(i5, i6, i3, i4) ? 1 : 0) << true;
        int i8 = i2 - 1;
        if (a(i5, i8, i3, i4)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i - 1;
        if (a(i10, i6, i3, i4)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (a(i10, i8, i3, i4)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (a(i10, i2, i3, i4)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (a(i, i6, i3, i4)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (a(i, i8, i3, i4)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        return a(i, i2, i3, i4) ? i15 | 1 : i15;
    }

    private int a(int i, int i2) {
        int i3 = i - 1;
        int i4 = (a(i3, 0, i, i2) ? 1 : 0) << true;
        if (a(i3, 1, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(i3, 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (a(0, i2 - 2, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        int i8 = i2 - 1;
        if (a(0, i8, i, i2)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        if (a(1, i8, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (a(2, i8, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        return a(3, i8, i, i2) ? i11 | 1 : i11;
    }

    private int b(int i, int i2) {
        int i3 = (a(i + -3, 0, i, i2) ? 1 : 0) << true;
        if (a(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (a(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(0, i2 - 4, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (a(0, i2 - 3, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (a(0, i2 - 2, i, i2)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        int i9 = i2 - 1;
        if (a(0, i9, i, i2)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        return a(1, i9, i, i2) ? i10 | 1 : i10;
    }

    private int c(int i, int i2) {
        int i3 = i - 1;
        int i4 = (a(i3, 0, i, i2) ? 1 : 0) << true;
        int i5 = i2 - 1;
        if (a(i3, i5, i, i2)) {
            i4 |= 1;
        }
        int i6 = i4 << 1;
        int i7 = i2 - 3;
        if (a(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        int i9 = i2 - 2;
        if (a(0, i9, i, i2)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        if (a(0, i5, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (a(1, i7, i, i2)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (a(1, i9, i, i2)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        return a(1, i5, i, i2) ? i13 | 1 : i13;
    }

    private int d(int i, int i2) {
        int i3 = (a(i + -3, 0, i, i2) ? 1 : 0) << true;
        if (a(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (a(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(0, i2 - 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        int i7 = i2 - 1;
        if (a(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        if (a(1, i7, i, i2)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (a(2, i7, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        return a(3, i7, i, i2) ? i10 | 1 : i10;
    }

    private b b(b bVar) {
        int b2 = this.c.b();
        int c2 = this.c.c();
        if (bVar.f() == b2) {
            int d = this.c.d();
            int e = this.c.e();
            int i = b2 / d;
            int i2 = c2 / e;
            b bVar2 = new b(i2 * e, i * d);
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = i3 * d;
                for (int i5 = 0; i5 < i2; i5++) {
                    int i6 = i5 * e;
                    for (int i7 = 0; i7 < d; i7++) {
                        int i8 = ((d + 2) * i3) + 1 + i7;
                        int i9 = i4 + i7;
                        for (int i10 = 0; i10 < e; i10++) {
                            if (bVar.a(((e + 2) * i5) + 1 + i10, i8)) {
                                bVar2.b(i6 + i10, i9);
                            }
                        }
                        b bVar3 = bVar;
                    }
                    b bVar4 = bVar;
                }
                b bVar5 = bVar;
            }
            return bVar2;
        }
        throw new IllegalArgumentException("Dimension of bitMarix must match the version size");
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\c\a\b.java ==========

package a.a.a.c.a;

import a.a.a.c.a.e;

/* compiled from: DataBlock */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f47a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f48b;

    private b(int i, byte[] bArr) {
        this.f47a = i;
        this.f48b = bArr;
    }

    static b[] a(byte[] bArr, e eVar) {
        e.b g = eVar.g();
        e.a[] b2 = g.b();
        int i = 0;
        for (e.a a2 : b2) {
            i += a2.a();
        }
        b[] bVarArr = new b[i];
        int length = b2.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            e.a aVar = b2[i2];
            int i4 = i3;
            int i5 = 0;
            while (i5 < aVar.a()) {
                int b3 = aVar.b();
                bVarArr[i4] = new b(b3, new byte[(g.a() + b3)]);
                i5++;
                i4++;
            }
            i2++;
            i3 = i4;
        }
        int length2 = bVarArr[0].f48b.length - g.a();
        int i6 = length2 - 1;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i6) {
            int i9 = i8;
            int i10 = 0;
            while (i10 < i3) {
                bVarArr[i10].f48b[i7] = bArr[i9];
                i10++;
                i9++;
            }
            i7++;
            i8 = i9;
        }
        boolean z = eVar.a() == 24;
        int i11 = z ? 8 : i3;
        int i12 = i8;
        int i13 = 0;
        while (i13 < i11) {
            bVarArr[i13].f48b[i6] = bArr[i12];
            i13++;
            i12++;
        }
        int length3 = bVarArr[0].f48b.length;
        while (length2 < length3) {
            int i14 = 0;
            while (i14 < i3) {
                int i15 = z ? (i14 + 8) % i3 : i14;
                bVarArr[i15].f48b[(!z || i15 <= 7) ? length2 : length2 - 1] = bArr[i12];
                i14++;
                i12++;
            }
            length2++;
        }
        if (i12 == bArr.length) {
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f47a;
    }

    /* access modifiers changed from: package-private */
    public byte[] b() {
        return this.f48b;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\c\a\c.java ==========

package a.a.a.c.a;

import a.a.a.f;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

/* compiled from: DecodedBitStreamParser */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f49a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f50b = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
    private static final char[] c = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] d = f50b;
    private static final char[] e = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    /* compiled from: DecodedBitStreamParser */
    private enum a {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static a.a.a.b.e a(byte[] r6) throws a.a.a.f {
        /*
            a.a.a.b.c r0 = new a.a.a.b.c
            r0.<init>(r6)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 100
            r1.<init>(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 0
            r2.<init>(r3)
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 1
            r3.<init>(r4)
            a.a.a.c.a.c$a r4 = a.a.a.c.a.c.a.ASCII_ENCODE
        L_0x001a:
            a.a.a.c.a.c$a r5 = a.a.a.c.a.c.a.ASCII_ENCODE
            if (r4 != r5) goto L_0x0023
            a.a.a.c.a.c$a r4 = a((a.a.a.b.c) r0, (java.lang.StringBuilder) r1, (java.lang.StringBuilder) r2)
            goto L_0x0048
        L_0x0023:
            int[] r5 = a.a.a.c.a.c.AnonymousClass1.f51a
            int r4 = r4.ordinal()
            r4 = r5[r4]
            switch(r4) {
                case 1: goto L_0x0043;
                case 2: goto L_0x003f;
                case 3: goto L_0x003b;
                case 4: goto L_0x0037;
                case 5: goto L_0x0033;
                default: goto L_0x002e;
            }
        L_0x002e:
            a.a.a.f r6 = a.a.a.f.a()
            throw r6
        L_0x0033:
            a((a.a.a.b.c) r0, (java.lang.StringBuilder) r1, (java.util.Collection<byte[]>) r3)
            goto L_0x0046
        L_0x0037:
            d(r0, r1)
            goto L_0x0046
        L_0x003b:
            c(r0, r1)
            goto L_0x0046
        L_0x003f:
            b(r0, r1)
            goto L_0x0046
        L_0x0043:
            a((a.a.a.b.c) r0, (java.lang.StringBuilder) r1)
        L_0x0046:
            a.a.a.c.a.c$a r4 = a.a.a.c.a.c.a.ASCII_ENCODE
        L_0x0048:
            a.a.a.c.a.c$a r5 = a.a.a.c.a.c.a.PAD_ENCODE
            if (r4 == r5) goto L_0x0052
            int r5 = r0.c()
            if (r5 > 0) goto L_0x001a
        L_0x0052:
            int r0 = r2.length()
            if (r0 <= 0) goto L_0x005b
            r1.append(r2)
        L_0x005b:
            a.a.a.b.e r0 = new a.a.a.b.e
            java.lang.String r1 = r1.toString()
            boolean r2 = r3.isEmpty()
            r4 = 0
            if (r2 == 0) goto L_0x0069
            r3 = r4
        L_0x0069:
            r0.<init>(r6, r1, r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.c.a.c.a(byte[]):a.a.a.b.e");
    }

    private static a a(a.a.a.b.c cVar, StringBuilder sb, StringBuilder sb2) throws f {
        boolean z = false;
        do {
            int a2 = cVar.a(8);
            if (a2 == 0) {
                throw f.a();
            } else if (a2 <= 128) {
                if (z) {
                    a2 += 128;
                }
                sb.append((char) (a2 - 1));
                return a.ASCII_ENCODE;
            } else if (a2 == 129) {
                return a.PAD_ENCODE;
            } else {
                if (a2 <= 229) {
                    int i = a2 - 130;
                    if (i < 10) {
                        sb.append('0');
                    }
                    sb.append(i);
                } else if (a2 == 230) {
                    return a.C40_ENCODE;
                } else {
                    if (a2 == 231) {
                        return a.BASE256_ENCODE;
                    }
                    if (a2 == 232) {
                        sb.append(29);
                    } else if (!(a2 == 233 || a2 == 234)) {
                        if (a2 == 235) {
                            z = true;
                        } else if (a2 == 236) {
                            sb.append("[)>\u001e05\u001d");
                            sb2.insert(0, "\u001e\u0004");
                        } else if (a2 == 237) {
                            sb.append("[)>\u001e06\u001d");
                            sb2.insert(0, "\u001e\u0004");
                        } else if (a2 == 238) {
                            return a.ANSIX12_ENCODE;
                        } else {
                            if (a2 == 239) {
                                return a.TEXT_ENCODE;
                            }
                            if (a2 == 240) {
                                return a.EDIFACT_ENCODE;
                            }
                            if (!(a2 == 241 || a2 < 242 || (a2 == 254 && cVar.c() == 0))) {
                                throw f.a();
                            }
                        }
                    }
                }
            }
        } while (cVar.c() > 0);
        return a.ASCII_ENCODE;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        r5 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(a.a.a.b.c r8, java.lang.StringBuilder r9) throws a.a.a.f {
        /*
            r0 = 3
            int[] r1 = new int[r0]
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0006:
            int r5 = r8.c()
            r6 = 8
            if (r5 != r6) goto L_0x000f
            return
        L_0x000f:
            int r5 = r8.a(r6)
            r7 = 254(0xfe, float:3.56E-43)
            if (r5 != r7) goto L_0x0018
            return
        L_0x0018:
            int r6 = r8.a(r6)
            a((int) r5, (int) r6, (int[]) r1)
            r5 = r3
            r3 = 0
        L_0x0021:
            if (r3 >= r0) goto L_0x009e
            r6 = r1[r3]
            switch(r4) {
                case 0: goto L_0x007b;
                case 1: goto L_0x006c;
                case 2: goto L_0x003e;
                case 3: goto L_0x002d;
                default: goto L_0x0028;
            }
        L_0x0028:
            a.a.a.f r8 = a.a.a.f.a()
            throw r8
        L_0x002d:
            if (r5 == 0) goto L_0x0037
            int r6 = r6 + 224
            char r4 = (char) r6
            r9.append(r4)
        L_0x0035:
            r5 = 0
            goto L_0x0079
        L_0x0037:
            int r6 = r6 + 96
            char r4 = (char) r6
            r9.append(r4)
            goto L_0x0079
        L_0x003e:
            char[] r4 = f50b
            int r4 = r4.length
            if (r6 >= r4) goto L_0x0055
            char[] r4 = f50b
            char r4 = r4[r6]
            if (r5 == 0) goto L_0x0051
            int r4 = r4 + 128
            char r4 = (char) r4
            r9.append(r4)
            r4 = 0
            goto L_0x0065
        L_0x0051:
            r9.append(r4)
            goto L_0x005e
        L_0x0055:
            r4 = 27
            if (r6 != r4) goto L_0x0060
            r4 = 29
            r9.append(r4)
        L_0x005e:
            r4 = r5
            goto L_0x0065
        L_0x0060:
            r4 = 30
            if (r6 != r4) goto L_0x0067
            r4 = 1
        L_0x0065:
            r5 = r4
            goto L_0x0079
        L_0x0067:
            a.a.a.f r8 = a.a.a.f.a()
            throw r8
        L_0x006c:
            if (r5 == 0) goto L_0x0075
            int r6 = r6 + 128
            char r4 = (char) r6
            r9.append(r4)
            goto L_0x0035
        L_0x0075:
            char r4 = (char) r6
            r9.append(r4)
        L_0x0079:
            r4 = 0
            goto L_0x0096
        L_0x007b:
            if (r6 >= r0) goto L_0x0080
            int r4 = r6 + 1
            goto L_0x0096
        L_0x0080:
            char[] r7 = f49a
            int r7 = r7.length
            if (r6 >= r7) goto L_0x0099
            char[] r7 = f49a
            char r6 = r7[r6]
            if (r5 == 0) goto L_0x0093
            int r6 = r6 + 128
            char r5 = (char) r6
            r9.append(r5)
            r5 = 0
            goto L_0x0096
        L_0x0093:
            r9.append(r6)
        L_0x0096:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x0099:
            a.a.a.f r8 = a.a.a.f.a()
            throw r8
        L_0x009e:
            int r3 = r8.c()
            if (r3 > 0) goto L_0x00a5
            return
        L_0x00a5:
            r3 = r5
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.c.a.c.a(a.a.a.b.c, java.lang.StringBuilder):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003e, code lost:
        r5 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(a.a.a.b.c r8, java.lang.StringBuilder r9) throws a.a.a.f {
        /*
            r0 = 3
            int[] r1 = new int[r0]
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0006:
            int r5 = r8.c()
            r6 = 8
            if (r5 != r6) goto L_0x000f
            return
        L_0x000f:
            int r5 = r8.a(r6)
            r7 = 254(0xfe, float:3.56E-43)
            if (r5 != r7) goto L_0x0018
            return
        L_0x0018:
            int r6 = r8.a(r6)
            a((int) r5, (int) r6, (int[]) r1)
            r5 = r3
            r3 = 0
        L_0x0021:
            if (r3 >= r0) goto L_0x00aa
            r6 = r1[r3]
            switch(r4) {
                case 0: goto L_0x0086;
                case 1: goto L_0x0077;
                case 2: goto L_0x0049;
                case 3: goto L_0x002d;
                default: goto L_0x0028;
            }
        L_0x0028:
            a.a.a.f r8 = a.a.a.f.a()
            throw r8
        L_0x002d:
            char[] r4 = e
            int r4 = r4.length
            if (r6 >= r4) goto L_0x0044
            char[] r4 = e
            char r4 = r4[r6]
            if (r5 == 0) goto L_0x0040
            int r4 = r4 + 128
            char r4 = (char) r4
            r9.append(r4)
        L_0x003e:
            r5 = 0
            goto L_0x0084
        L_0x0040:
            r9.append(r4)
            goto L_0x0084
        L_0x0044:
            a.a.a.f r8 = a.a.a.f.a()
            throw r8
        L_0x0049:
            char[] r4 = d
            int r4 = r4.length
            if (r6 >= r4) goto L_0x0060
            char[] r4 = d
            char r4 = r4[r6]
            if (r5 == 0) goto L_0x005c
            int r4 = r4 + 128
            char r4 = (char) r4
            r9.append(r4)
            r4 = 0
            goto L_0x0070
        L_0x005c:
            r9.append(r4)
            goto L_0x0069
        L_0x0060:
            r4 = 27
            if (r6 != r4) goto L_0x006b
            r4 = 29
            r9.append(r4)
        L_0x0069:
            r4 = r5
            goto L_0x0070
        L_0x006b:
            r4 = 30
            if (r6 != r4) goto L_0x0072
            r4 = 1
        L_0x0070:
            r5 = r4
            goto L_0x0084
        L_0x0072:
            a.a.a.f r8 = a.a.a.f.a()
            throw r8
        L_0x0077:
            if (r5 == 0) goto L_0x0080
            int r6 = r6 + 128
            char r4 = (char) r6
            r9.append(r4)
            goto L_0x003e
        L_0x0080:
            char r4 = (char) r6
            r9.append(r4)
        L_0x0084:
            r4 = 0
            goto L_0x00a1
        L_0x0086:
            if (r6 >= r0) goto L_0x008b
            int r4 = r6 + 1
            goto L_0x00a1
        L_0x008b:
            char[] r7 = c
            int r7 = r7.length
            if (r6 >= r7) goto L_0x00a5
            char[] r7 = c
            char r6 = r7[r6]
            if (r5 == 0) goto L_0x009e
            int r6 = r6 + 128
            char r5 = (char) r6
            r9.append(r5)
            r5 = 0
            goto L_0x00a1
        L_0x009e:
            r9.append(r6)
        L_0x00a1:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x00a5:
            a.a.a.f r8 = a.a.a.f.a()
            throw r8
        L_0x00aa:
            int r3 = r8.c()
            if (r3 > 0) goto L_0x00b1
            return
        L_0x00b1:
            r3 = r5
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.c.a.c.b(a.a.a.b.c, java.lang.StringBuilder):void");
    }

    private static void c(a.a.a.b.c cVar, StringBuilder sb) throws f {
        int a2;
        int[] iArr = new int[3];
        while (cVar.c() != 8 && (a2 = cVar.a(8)) != 254) {
            a(a2, cVar.a(8), iArr);
            for (int i = 0; i < 3; i++) {
                int i2 = iArr[i];
                if (i2 == 0) {
                    sb.append(13);
                } else if (i2 == 1) {
                    sb.append('*');
                } else if (i2 == 2) {
                    sb.append('>');
                } else if (i2 == 3) {
                    sb.append(' ');
                } else if (i2 < 14) {
                    sb.append((char) (i2 + 44));
                } else if (i2 < 40) {
                    sb.append((char) (i2 + 51));
                } else {
                    throw f.a();
                }
            }
            if (cVar.c() <= 0) {
                return;
            }
        }
    }

    private static void a(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        int i5 = i3 - (i4 * 1600);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    private static void d(a.a.a.b.c cVar, StringBuilder sb) {
        while (cVar.c() > 16) {
            for (int i = 0; i < 4; i++) {
                int a2 = cVar.a(6);
                if (a2 == 31) {
                    int a3 = 8 - cVar.a();
                    if (a3 != 8) {
                        cVar.a(a3);
                        return;
                    }
                    return;
                }
                if ((a2 & 32) == 0) {
                    a2 |= 64;
                }
                sb.append((char) a2);
            }
            if (cVar.c() <= 0) {
                return;
            }
        }
    }

    private static void a(a.a.a.b.c cVar, StringBuilder sb, Collection<byte[]> collection) throws f {
        int b2 = cVar.b() + 1;
        int i = b2 + 1;
        int a2 = a(cVar.a(8), b2);
        if (a2 == 0) {
            a2 = cVar.c() / 8;
        } else if (a2 >= 250) {
            a2 = ((a2 - 249) * 250) + a(cVar.a(8), i);
            i++;
        }
        if (a2 >= 0) {
            byte[] bArr = new byte[a2];
            int i2 = 0;
            while (i2 < a2) {
                if (cVar.c() >= 8) {
                    bArr[i2] = (byte) a(cVar.a(8), i);
                    i2++;
                    i++;
                } else {
                    throw f.a();
                }
            }
            collection.add(bArr);
            try {
                sb.append(new String(bArr, "ISO8859_1"));
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalStateException("Platform does not support required encoding: " + e2);
            }
        } else {
            throw f.a();
        }
    }

    private static int a(int i, int i2) {
        int i3 = i - (((i2 * 149) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\c\a\d.java ==========

package a.a.a.c.a;

import a.a.a.b.b;
import a.a.a.b.b.a;
import a.a.a.b.b.c;
import a.a.a.b.e;
import a.a.a.f;

/* compiled from: Decoder */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final c f54a = new c(a.f);

    public e a(b bVar) throws f, a.a.a.d {
        a aVar = new a(bVar);
        b[] a2 = b.a(aVar.b(), aVar.a());
        int i = 0;
        for (b a3 : a2) {
            i += a3.a();
        }
        byte[] bArr = new byte[i];
        int length = a2.length;
        for (int i2 = 0; i2 < length; i2++) {
            b bVar2 = a2[i2];
            byte[] b2 = bVar2.b();
            int a4 = bVar2.a();
            a(b2, a4);
            for (int i3 = 0; i3 < a4; i3++) {
                bArr[(i3 * length) + i2] = b2[i3];
            }
        }
        return c.a(bArr);
    }

    private void a(byte[] bArr, int i) throws a.a.a.d {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.f54a.a(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (a.a.a.b.b.d unused) {
            throw a.a.a.d.a();
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\c\a\e.java ==========

package a.a.a.c.a;

import a.a.a.f;

/* compiled from: Version */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final e[] f55a = h();

    /* renamed from: b  reason: collision with root package name */
    private final int f56b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final b g;
    private final int h;

    private e(int i, int i2, int i3, int i4, int i5, b bVar) {
        this.f56b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = bVar;
        int a2 = bVar.a();
        int i6 = 0;
        for (a aVar : bVar.b()) {
            i6 += aVar.a() * (aVar.b() + a2);
        }
        this.h = i6;
    }

    public int a() {
        return this.f56b;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    public int e() {
        return this.f;
    }

    public int f() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public b g() {
        return this.g;
    }

    public static e a(int i, int i2) throws f {
        if ((i & 1) == 0 && (i2 & 1) == 0) {
            for (e eVar : f55a) {
                if (eVar.c == i && eVar.d == i2) {
                    return eVar;
                }
            }
            throw f.a();
        }
        throw f.a();
    }

    /* compiled from: Version */
    static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f59a;

        /* renamed from: b  reason: collision with root package name */
        private final a[] f60b;

        private b(int i, a aVar) {
            this.f59a = i;
            this.f60b = new a[]{aVar};
        }

        private b(int i, a aVar, a aVar2) {
            this.f59a = i;
            this.f60b = new a[]{aVar, aVar2};
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f59a;
        }

        /* access modifiers changed from: package-private */
        public a[] b() {
            return this.f60b;
        }
    }

    /* compiled from: Version */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f57a;

        /* renamed from: b  reason: collision with root package name */
        private final int f58b;

        private a(int i, int i2) {
            this.f57a = i;
            this.f58b = i2;
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f57a;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f58b;
        }
    }

    public String toString() {
        return String.valueOf(this.f56b);
    }

    private static e[] h() {
        return new e[]{new e(1, 10, 10, 8, 8, new b(5, new a(1, 3))), new e(2, 12, 12, 10, 10, new b(7, new a(1, 5))), new e(3, 14, 14, 12, 12, new b(10, new a(1, 8))), new e(4, 16, 16, 14, 14, new b(12, new a(1, 12))), new e(5, 18, 18, 16, 16, new b(14, new a(1, 18))), new e(6, 20, 20, 18, 18, new b(18, new a(1, 22))), new e(7, 22, 22, 20, 20, new b(20, new a(1, 30))), new e(8, 24, 24, 22, 22, new b(24, new a(1, 36))), new e(9, 26, 26, 24, 24, new b(28, new a(1, 44))), new e(10, 32, 32, 14, 14, new b(36, new a(1, 62))), new e(11, 36, 36, 16, 16, new b(42, new a(1, 86))), new e(12, 40, 40, 18, 18, new b(48, new a(1, 114))), new e(13, 44, 44, 20, 20, new b(56, new a(1, 144))), new e(14, 48, 48, 22, 22, new b(68, new a(1, 174))), new e(15, 52, 52, 24, 24, new b(42, new a(2, 102))), new e(16, 64, 64, 14, 14, new b(56, new a(2, 140))), new e(17, 72, 72, 16, 16, new b(36, new a(4, 92))), new e(18, 80, 80, 18, 18, new b(48, new a(4, 114))), new e(19, 88, 88, 20, 20, new b(56, new a(4, 144))), new e(20, 96, 96, 22, 22, new b(68, new a(4, 174))), new e(21, 104, 104, 24, 24, new b(56, new a(6, 136))), new e(22, 120, 120, 18, 18, new b(68, new a(6, 175))), new e(23, 132, 132, 20, 20, new b(62, new a(8, 163))), new e(24, 144, 144, 22, 22, new b(62, new a(8, 156), new a(2, 155))), new e(25, 8, 18, 6, 16, new b(7, new a(1, 5))), new e(26, 8, 32, 6, 14, new b(11, new a(1, 10))), new e(27, 12, 26, 10, 24, new b(14, new a(1, 16))), new e(28, 12, 36, 10, 16, new b(18, new a(1, 22))), new e(29, 16, 36, 14, 16, new b(24, new a(1, 32))), new e(30, 16, 48, 14, 22, new b(28, new a(1, 49)))};
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\c\b\a.java ==========

package a.a.a.c.b;

import a.a.a.b.g;
import a.a.a.i;
import a.a.a.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import net.fxgear.GlobalDefine;

/* compiled from: Detector */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final a.a.a.b.b f61a;

    /* renamed from: b  reason: collision with root package name */
    private final a.a.a.b.a.b f62b;

    public a(a.a.a.b.b bVar) throws i {
        this.f61a = bVar;
        this.f62b = new a.a.a.b.a.b(bVar);
    }

    public g a() throws i {
        o oVar;
        o oVar2;
        a.a.a.b.b bVar;
        o oVar3;
        o[] a2 = this.f62b.a();
        o oVar4 = a2[0];
        o oVar5 = a2[1];
        o oVar6 = a2[2];
        o oVar7 = a2[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(b(oVar4, oVar5));
        arrayList.add(b(oVar4, oVar6));
        arrayList.add(b(oVar5, oVar7));
        arrayList.add(b(oVar6, oVar7));
        o oVar8 = null;
        Collections.sort(arrayList, new b());
        C0002a aVar = (C0002a) arrayList.get(0);
        C0002a aVar2 = (C0002a) arrayList.get(1);
        HashMap hashMap = new HashMap();
        a((Map<o, Integer>) hashMap, aVar.a());
        a((Map<o, Integer>) hashMap, aVar.b());
        a((Map<o, Integer>) hashMap, aVar2.a());
        a((Map<o, Integer>) hashMap, aVar2.b());
        o oVar9 = null;
        o oVar10 = null;
        for (Map.Entry entry : hashMap.entrySet()) {
            o oVar11 = (o) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                oVar9 = oVar11;
            } else if (oVar8 == null) {
                oVar8 = oVar11;
            } else {
                oVar10 = oVar11;
            }
        }
        if (oVar8 == null || oVar9 == null || oVar10 == null) {
            throw i.a();
        }
        o[] oVarArr = {oVar8, oVar9, oVar10};
        o.a(oVarArr);
        o oVar12 = oVarArr[0];
        o oVar13 = oVarArr[1];
        o oVar14 = oVarArr[2];
        if (!hashMap.containsKey(oVar4)) {
            oVar = oVar4;
        } else if (!hashMap.containsKey(oVar5)) {
            oVar = oVar5;
        } else {
            oVar = !hashMap.containsKey(oVar6) ? oVar6 : oVar7;
        }
        int c = b(oVar14, oVar).c();
        int c2 = b(oVar12, oVar).c();
        if ((c & 1) == 1) {
            c++;
        }
        int i = c + 2;
        if ((c2 & 1) == 1) {
            c2++;
        }
        int i2 = c2 + 2;
        if (i * 4 >= i2 * 7 || i2 * 4 >= i * 7) {
            oVar2 = oVar14;
            o a3 = a(oVar13, oVar12, oVar14, oVar, i, i2);
            if (a3 == null) {
                a3 = oVar;
            }
            int c3 = b(oVar2, oVar3).c();
            int c4 = b(oVar12, oVar3).c();
            if ((c3 & 1) == 1) {
                c3++;
            }
            int i3 = c3;
            if ((c4 & 1) == 1) {
                c4++;
            }
            bVar = a(this.f61a, oVar2, oVar13, oVar12, oVar3, i3, c4);
        } else {
            oVar3 = a(oVar13, oVar12, oVar14, oVar, Math.min(i2, i));
            if (oVar3 == null) {
                oVar3 = oVar;
            }
            int max = Math.max(b(oVar14, oVar3).c(), b(oVar12, oVar3).c()) + 1;
            if ((max & 1) == 1) {
                max++;
            }
            int i4 = max;
            bVar = a(this.f61a, oVar14, oVar13, oVar12, oVar3, i4, i4);
            oVar2 = oVar14;
        }
        return new g(bVar, new o[]{oVar2, oVar13, oVar12, oVar3});
    }

    private o a(o oVar, o oVar2, o oVar3, o oVar4, int i, int i2) {
        float a2 = ((float) a(oVar, oVar2)) / ((float) i);
        float a3 = (float) a(oVar3, oVar4);
        o oVar5 = new o(oVar4.a() + (((oVar4.a() - oVar3.a()) / a3) * a2), oVar4.b() + (a2 * ((oVar4.b() - oVar3.b()) / a3)));
        float a4 = ((float) a(oVar, oVar3)) / ((float) i2);
        float a5 = (float) a(oVar2, oVar4);
        o oVar6 = new o(oVar4.a() + (((oVar4.a() - oVar2.a()) / a5) * a4), oVar4.b() + (a4 * ((oVar4.b() - oVar2.b()) / a5)));
        if (a(oVar5)) {
            return (a(oVar6) && Math.abs(i - b(oVar3, oVar5).c()) + Math.abs(i2 - b(oVar2, oVar5).c()) > Math.abs(i - b(oVar3, oVar6).c()) + Math.abs(i2 - b(oVar2, oVar6).c())) ? oVar6 : oVar5;
        }
        if (a(oVar6)) {
            return oVar6;
        }
        return null;
    }

    private o a(o oVar, o oVar2, o oVar3, o oVar4, int i) {
        float f = (float) i;
        float a2 = ((float) a(oVar, oVar2)) / f;
        float a3 = (float) a(oVar3, oVar4);
        o oVar5 = new o(oVar4.a() + (((oVar4.a() - oVar3.a()) / a3) * a2), oVar4.b() + (a2 * ((oVar4.b() - oVar3.b()) / a3)));
        float a4 = ((float) a(oVar, oVar3)) / f;
        float a5 = (float) a(oVar2, oVar4);
        o oVar6 = new o(oVar4.a() + (((oVar4.a() - oVar2.a()) / a5) * a4), oVar4.b() + (a4 * ((oVar4.b() - oVar2.b()) / a5)));
        if (a(oVar5)) {
            return (a(oVar6) && Math.abs(b(oVar3, oVar5).c() - b(oVar2, oVar5).c()) > Math.abs(b(oVar3, oVar6).c() - b(oVar2, oVar6).c())) ? oVar6 : oVar5;
        }
        if (a(oVar6)) {
            return oVar6;
        }
        return null;
    }

    private boolean a(o oVar) {
        return oVar.a() >= GlobalDefine.DEFAULT_AUTO_FILTER_VALUE && oVar.a() < ((float) this.f61a.e()) && oVar.b() > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE && oVar.b() < ((float) this.f61a.f());
    }

    private static int a(o oVar, o oVar2) {
        return a.a.a.b.a.a.a(o.a(oVar, oVar2));
    }

    private static void a(Map<o, Integer> map, o oVar) {
        Integer num = map.get(oVar);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        map.put(oVar, Integer.valueOf(i));
    }

    private static a.a.a.b.b a(a.a.a.b.b bVar, o oVar, o oVar2, o oVar3, o oVar4, int i, int i2) throws i {
        float f = ((float) i) - 0.5f;
        float f2 = ((float) i2) - 0.5f;
        return a.a.a.b.i.a().a(bVar, i, i2, 0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, oVar.a(), oVar.b(), oVar4.a(), oVar4.b(), oVar3.a(), oVar3.b(), oVar2.a(), oVar2.b());
    }

    private C0002a b(o oVar, o oVar2) {
        int a2 = (int) oVar.a();
        int b2 = (int) oVar.b();
        int a3 = (int) oVar2.a();
        int b3 = (int) oVar2.b();
        int i = 0;
        int i2 = 1;
        boolean z = Math.abs(b3 - b2) > Math.abs(a3 - a2);
        if (z) {
            int i3 = b2;
            b2 = a2;
            a2 = i3;
            int i4 = b3;
            b3 = a3;
            a3 = i4;
        }
        int abs = Math.abs(a3 - a2);
        int abs2 = Math.abs(b3 - b2);
        int i5 = (-abs) / 2;
        int i6 = b2 < b3 ? 1 : -1;
        if (a2 >= a3) {
            i2 = -1;
        }
        boolean a4 = this.f61a.a(z ? b2 : a2, z ? a2 : b2);
        while (a2 != a3) {
            boolean a5 = this.f61a.a(z ? b2 : a2, z ? a2 : b2);
            if (a5 != a4) {
                i++;
                a4 = a5;
            }
            i5 += abs2;
            if (i5 > 0) {
                if (b2 == b3) {
                    break;
                }
                b2 += i6;
                i5 -= abs;
            }
            a2 += i2;
        }
        return new C0002a(oVar, oVar2, i);
    }

    /* renamed from: a.a.a.c.b.a$a  reason: collision with other inner class name */
    /* compiled from: Detector */
    private static final class C0002a {

        /* renamed from: a  reason: collision with root package name */
        private final o f63a;

        /* renamed from: b  reason: collision with root package name */
        private final o f64b;
        private final int c;

        private C0002a(o oVar, o oVar2, int i) {
            this.f63a = oVar;
            this.f64b = oVar2;
            this.c = i;
        }

        /* access modifiers changed from: package-private */
        public o a() {
            return this.f63a;
        }

        /* access modifiers changed from: package-private */
        public o b() {
            return this.f64b;
        }

        /* access modifiers changed from: package-private */
        public int c() {
            return this.c;
        }

        public String toString() {
            return this.f63a + "/" + this.f64b + '/' + this.c;
        }
    }

    /* compiled from: Detector */
    private static final class b implements Serializable, Comparator<C0002a> {
        private b() {
        }

        /* renamed from: a */
        public int compare(C0002a aVar, C0002a aVar2) {
            return aVar.c() - aVar2.c();
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\d\a.java ==========

package a.a.a.d;

import a.a.a.b.b;
import a.a.a.d;
import a.a.a.d.a.c;
import a.a.a.e;
import a.a.a.f;
import a.a.a.i;
import a.a.a.k;
import a.a.a.m;
import a.a.a.n;
import a.a.a.o;
import java.util.Map;

/* compiled from: MaxiCodeReader */
public final class a implements k {

    /* renamed from: a  reason: collision with root package name */
    private static final o[] f65a = new o[0];

    /* renamed from: b  reason: collision with root package name */
    private final c f66b = new c();

    public void a() {
    }

    public m a(a.a.a.c cVar, Map<e, ?> map) throws i, d, f {
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            throw i.a();
        }
        a.a.a.b.e a2 = this.f66b.a(a(cVar.c()), map);
        m mVar = new m(a2.c(), a2.a(), f65a, a.a.a.a.MAXICODE);
        String e = a2.e();
        if (e != null) {
            mVar.a(n.ERROR_CORRECTION_LEVEL, e);
        }
        return mVar;
    }

    private static b a(b bVar) throws i {
        int[] b2 = bVar.b();
        if (b2 != null) {
            int i = b2[0];
            int i2 = b2[1];
            int i3 = b2[2];
            int i4 = b2[3];
            b bVar2 = new b(30, 33);
            for (int i5 = 0; i5 < 33; i5++) {
                int i6 = (((i5 * i4) + (i4 / 2)) / 33) + i2;
                for (int i7 = 0; i7 < 30; i7++) {
                    if (bVar.a(((((i7 * i3) + (i3 / 2)) + (((i5 & 1) * i3) / 2)) / 30) + i, i6)) {
                        bVar2.b(i7, i5);
                    }
                }
            }
            return bVar2;
        }
        throw i.a();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\d\a\a.java ==========

package a.a.a.d.a;

import a.a.a.b.b;
import net.fxgear.GlobalDefine;

/* compiled from: BitMatrixParser */
final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[][] f67a = {new int[]{121, 120, 127, 126, 133, 132, 139, 138, 145, 144, 151, 150, 157, 156, 163, 162, 169, 168, 175, 174, 181, 180, 187, 186, 193, 192, 199, 198, -2, -2}, new int[]{123, 122, 129, 128, 135, 134, 141, 140, 147, 146, 153, 152, 159, 158, 165, 164, 171, 170, 177, 176, 183, 182, 189, 188, 195, 194, 201, 200, 816, -3}, new int[]{125, 124, 131, 130, 137, 136, 143, 142, 149, 148, 155, 154, 161, 160, 167, 166, 173, 172, 179, 178, 185, 184, 191, 190, 197, 196, 203, 202, 818, 817}, new int[]{283, 282, 277, 276, 271, 270, 265, 264, 259, 258, 253, 252, 247, 246, 241, 240, 235, 234, 229, 228, 223, 222, 217, 216, 211, 210, 205, 204, 819, -3}, new int[]{285, 284, 279, 278, 273, 272, 267, 266, 261, 260, 255, 254, 249, 248, 243, 242, 237, 236, 231, 230, 225, 224, 219, 218, 213, 212, 207, 206, 821, 820}, new int[]{287, 286, 281, 280, 275, 274, 269, 268, 263, 262, 257, 256, 251, 250, 245, 244, 239, 238, 233, 232, 227, 226, 221, 220, 215, 214, 209, 208, 822, -3}, new int[]{289, 288, 295, 294, 301, 300, 307, 306, 313, 312, 319, 318, 325, 324, 331, 330, 337, 336, 343, 342, 349, 348, 355, 354, 361, 360, 367, 366, 824, 823}, new int[]{291, 290, 297, 296, 303, 302, 309, 308, 315, 314, 321, 320, 327, 326, 333, 332, 339, 338, 345, 344, 351, 350, 357, 356, 363, 362, 369, 368, 825, -3}, new int[]{293, 292, 299, 298, 305, 304, 311, 310, 317, 316, 323, 322, 329, 328, 335, 334, 341, 340, 347, 346, 353, 352, 359, 358, 365, 364, 371, 370, 827, 826}, new int[]{409, 408, 403, 402, 397, 396, 391, 390, 79, 78, -2, -2, 13, 12, 37, 36, 2, -1, 44, 43, 109, 108, 385, 384, 379, 378, 373, 372, 828, -3}, new int[]{411, 410, 405, 404, 399, 398, 393, 392, 81, 80, 40, -2, 15, 14, 39, 38, 3, -1, -1, 45, 111, 110, 387, 386, 381, 380, 375, 374, 830, 829}, new int[]{413, 412, 407, 406, 401, 400, 395, 394, 83, 82, 41, -3, -3, -3, -3, -3, 5, 4, 47, 46, 113, 112, 389, 388, 383, 382, 377, 376, 831, -3}, new int[]{415, 414, 421, 420, 427, 426, 103, 102, 55, 54, 16, -3, -3, -3, -3, -3, -3, -3, 20, 19, 85, 84, 433, 432, 439, 438, 445, 444, 833, 832}, new int[]{417, 416, 423, 422, 429, 428, 105, 104, 57, 56, -3, -3, -3, -3, -3, -3, -3, -3, 22, 21, 87, 86, 435, 434, 441, 440, 447, 446, 834, -3}, new int[]{419, 418, 425, 424, 431, 430, 107, 106, 59, 58, -3, -3, -3, -3, -3, -3, -3, -3, -3, 23, 89, 88, 437, 436, 443, 442, 449, 448, 836, 835}, new int[]{481, 480, 475, 474, 469, 468, 48, -2, 30, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 0, 53, 52, 463, 462, 457, 456, 451, 450, 837, -3}, new int[]{483, 482, 477, 476, 471, 470, 49, -1, -2, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -2, -1, 465, 464, 459, 458, 453, 452, 839, 838}, new int[]{485, 484, 479, 478, 473, 472, 51, 50, 31, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 1, -2, 42, 467, 466, 461, 460, 455, 454, 840, -3}, new int[]{487, 486, 493, 492, 499, 498, 97, 96, 61, 60, -3, -3, -3, -3, -3, -3, -3, -3, -3, 26, 91, 90, 505, 504, 511, 510, 517, 516, 842, 841}, new int[]{489, 488, 495, 494, 501, 500, 99, 98, 63, 62, -3, -3, -3, -3, -3, -3, -3, -3, 28, 27, 93, 92, 507, 506, 513, 512, 519, 518, 843, -3}, new int[]{491, 490, 497, 496, 503, 502, 101, 100, 65, 64, 17, -3, -3, -3, -3, -3, -3, -3, 18, 29, 95, 94, 509, 508, 515, 514, 521, 520, 845, 844}, new int[]{559, 558, 553, 552, 547, 546, 541, 540, 73, 72, 32, -3, -3, -3, -3, -3, -3, 10, 67, 66, 115, 114, GlobalDefine.THUMBNAIL_WIDTH, 534, 529, 528, 523, 522, 846, -3}, new int[]{561, 560, 555, 554, 549, 548, 543, 542, 75, 74, -2, -1, 7, 6, 35, 34, 11, -2, 69, 68, 117, 116, 537, 536, 531, 530, 525, 524, 848, 847}, new int[]{563, 562, 557, 556, 551, 550, 545, 544, 77, 76, -2, 33, 9, 8, 25, 24, -1, -2, 71, 70, 119, 118, 539, 538, 533, 532, 527, 526, 849, -3}, new int[]{565, 564, 571, 570, 577, 576, 583, 582, 589, 588, 595, 594, 601, 600, 607, 606, 613, 612, 619, 618, 625, 624, 631, 630, 637, 636, 643, 642, 851, 850}, new int[]{567, 566, 573, 572, 579, 578, 585, 584, 591, 590, 597, 596, 603, 602, 609, 608, 615, 614, 621, 620, 627, 626, 633, 632, 639, 638, 645, 644, 852, -3}, new int[]{569, 568, 575, 574, 581, 580, 587, 586, 593, 592, 599, 598, 605, 604, 611, 610, 617, 616, 623, 622, 629, 628, 635, 634, 641, 640, 647, 646, 854, 853}, new int[]{727, 726, 721, 720, 715, 714, 709, 708, 703, 702, 697, 696, 691, 690, 685, 684, 679, 678, 673, 672, 667, 666, 661, 660, 655, 654, 649, 648, 855, -3}, new int[]{729, 728, 723, 722, 717, 716, 711, 710, 705, 704, 699, 698, 693, 692, 687, 686, 681, 680, 675, 674, 669, 668, 663, 662, 657, 656, 651, 650, 857, 856}, new int[]{731, 730, 725, 724, 719, 718, 713, 712, 707, 706, 701, 700, 695, 694, 689, 688, 683, 682, 677, 676, 671, 670, 665, 664, 659, 658, 653, 652, 858, -3}, new int[]{733, 732, 739, 738, 745, 744, 751, 750, 757, 756, 763, 762, 769, 768, 775, 774, 781, 780, 787, 786, 793, 792, 799, 798, 805, 804, 811, 810, 860, 859}, new int[]{735, 734, 741, 740, 747, 746, 753, 752, 759, 758, 765, 764, 771, 770, 777, 776, 783, 782, 789, 788, 795, 794, 801, 800, 807, 806, 813, 812, 861, -3}, new int[]{737, 736, 743, 742, 749, 748, 755, 754, 761, 760, 767, 766, 773, 772, 779, 778, 785, 784, 791, 790, 797, 796, 803, 802, 809, 808, 815, 814, 863, 862}};

    /* renamed from: b  reason: collision with root package name */
    private final b f68b;

    a(b bVar) {
        this.f68b = bVar;
    }

    /* access modifiers changed from: package-private */
    public byte[] a() {
        byte[] bArr = new byte[144];
        int f = this.f68b.f();
        int e = this.f68b.e();
        for (int i = 0; i < f; i++) {
            int[] iArr = f67a[i];
            for (int i2 = 0; i2 < e; i2++) {
                int i3 = iArr[i2];
                if (i3 >= 0 && this.f68b.a(i2, i)) {
                    int i4 = i3 / 6;
                    bArr[i4] = (byte) (((byte) (1 << (5 - (i3 % 6)))) | bArr[i4]);
                }
            }
        }
        return bArr;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\d\a\b.java ==========

package a.a.a.d.a;

import a.a.a.b.e;
import java.text.DecimalFormat;
import java.util.List;

/* compiled from: DecodedBitStreamParser */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f69a = {"\nABCDEFGHIJKLMNOPQRSTUVWXYZ￺\u001c\u001d\u001e￻ ￼\"#$%&'()*+,-./0123456789:￱￲￳￴￸", "`abcdefghijklmnopqrstuvwxyz￺\u001c\u001d\u001e￻{￼}~;<=>?[\\]^_ ,./:@!|￼￵￶￼￰￲￳￴￷", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ￺\u001c\u001d\u001eÛÜÝÞßª¬±²³µ¹º¼½¾￷ ￹￳￴￸", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú￺\u001c\u001d\u001e￻ûüýþÿ¡¨«¯°´·¸»¿￷ ￲￹￴￸", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a￺￼￼\u001b￻\u001c\u001d\u001e\u001f ¢£¤¥¦§©­®¶￷ ￲￳￹￸", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?"};

    static e a(byte[] bArr, int i) {
        String str;
        StringBuilder sb = new StringBuilder(144);
        switch (i) {
            case 2:
            case 3:
                if (i == 2) {
                    str = new DecimalFormat("0000000000".substring(0, c(bArr))).format((long) d(bArr));
                } else {
                    str = e(bArr);
                }
                DecimalFormat decimalFormat = new DecimalFormat("000");
                String format = decimalFormat.format((long) a(bArr));
                String format2 = decimalFormat.format((long) b(bArr));
                sb.append(a(bArr, 10, 84));
                if (!sb.toString().startsWith("[)>\u001e01\u001d")) {
                    sb.insert(0, str + 29 + format + 29 + format2 + 29);
                    break;
                } else {
                    sb.insert(9, str + 29 + format + 29 + format2 + 29);
                    break;
                }
            case 4:
                sb.append(a(bArr, 1, 93));
                break;
            case 5:
                sb.append(a(bArr, 1, 77));
                break;
        }
        return new e(bArr, sb.toString(), (List<byte[]>) null, String.valueOf(i));
    }

    private static int a(int i, byte[] bArr) {
        int i2 = i - 1;
        return ((1 << (5 - (i2 % 6))) & bArr[i2 / 6]) == 0 ? 0 : 1;
    }

    private static int a(byte[] bArr, byte[] bArr2) {
        if (bArr2.length != 0) {
            int i = 0;
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                i += a((int) bArr2[i2], bArr) << ((bArr2.length - i2) - 1);
            }
            return i;
        }
        throw new IllegalArgumentException();
    }

    private static int a(byte[] bArr) {
        return a(bArr, new byte[]{53, 54, 43, 44, 45, 46, 47, 48, 37, 38});
    }

    private static int b(byte[] bArr) {
        return a(bArr, new byte[]{55, 56, 57, 58, 59, 60, 49, 50, 51, 52});
    }

    private static int c(byte[] bArr) {
        return a(bArr, new byte[]{39, 40, 41, 42, 31, 32});
    }

    private static int d(byte[] bArr) {
        return a(bArr, new byte[]{33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, 13, 14, 15, 16, 17, 18, 7, 8, 9, 10, 11, 12, 1, 2});
    }

    private static String e(byte[] bArr) {
        return String.valueOf(new char[]{f69a[0].charAt(a(bArr, new byte[]{39, 40, 41, 42, 31, 32})), f69a[0].charAt(a(bArr, new byte[]{33, 34, 35, 36, 25, 26})), f69a[0].charAt(a(bArr, new byte[]{27, 28, 29, 30, 19, 20})), f69a[0].charAt(a(bArr, new byte[]{21, 22, 23, 24, 13, 14})), f69a[0].charAt(a(bArr, new byte[]{15, 16, 17, 18, 7, 8})), f69a[0].charAt(a(bArr, new byte[]{9, 10, 11, 12, 1, 2}))});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0055, code lost:
        r6 = r4;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0060, code lost:
        r7 = r5 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0062, code lost:
        if (r5 != 0) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0064, code lost:
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0065, code lost:
        r3 = r3 + 1;
        r5 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0050, code lost:
        r5 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(byte[] r12, int r13, int r14) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            r2 = -1
            r3 = r13
            r4 = 0
            r5 = -1
            r6 = 0
        L_0x000b:
            int r7 = r13 + r14
            r8 = 1
            if (r3 >= r7) goto L_0x0068
            java.lang.String[] r7 = f69a
            r7 = r7[r4]
            byte r9 = r12[r3]
            char r7 = r7.charAt(r9)
            switch(r7) {
                case 65520: goto L_0x0058;
                case 65521: goto L_0x0058;
                case 65522: goto L_0x0058;
                case 65523: goto L_0x0058;
                case 65524: goto L_0x0058;
                case 65525: goto L_0x0054;
                case 65526: goto L_0x0052;
                case 65527: goto L_0x004f;
                case 65528: goto L_0x004d;
                case 65529: goto L_0x0050;
                case 65530: goto L_0x001d;
                case 65531: goto L_0x0021;
                default: goto L_0x001d;
            }
        L_0x001d:
            r0.append(r7)
            goto L_0x0060
        L_0x0021:
            int r3 = r3 + 1
            byte r7 = r12[r3]
            int r7 = r7 << 24
            int r3 = r3 + r8
            byte r9 = r12[r3]
            int r9 = r9 << 18
            int r7 = r7 + r9
            int r3 = r3 + r8
            byte r9 = r12[r3]
            int r9 = r9 << 12
            int r7 = r7 + r9
            int r3 = r3 + r8
            byte r9 = r12[r3]
            int r9 = r9 << 6
            int r7 = r7 + r9
            int r3 = r3 + r8
            byte r9 = r12[r3]
            int r7 = r7 + r9
            java.text.DecimalFormat r9 = new java.text.DecimalFormat
            java.lang.String r10 = "000000000"
            r9.<init>(r10)
            long r10 = (long) r7
            java.lang.String r7 = r9.format(r10)
            r0.append(r7)
            goto L_0x0060
        L_0x004d:
            r4 = 1
            goto L_0x0050
        L_0x004f:
            r4 = 0
        L_0x0050:
            r5 = -1
            goto L_0x0060
        L_0x0052:
            r5 = 3
            goto L_0x0055
        L_0x0054:
            r5 = 2
        L_0x0055:
            r6 = r4
            r4 = 0
            goto L_0x0060
        L_0x0058:
            r5 = 65520(0xfff0, float:9.1813E-41)
            int r5 = r7 - r5
            r6 = r4
            r4 = r5
            r5 = 1
        L_0x0060:
            int r7 = r5 + -1
            if (r5 != 0) goto L_0x0065
            r4 = r6
        L_0x0065:
            int r3 = r3 + r8
            r5 = r7
            goto L_0x000b
        L_0x0068:
            int r12 = r0.length()
            if (r12 <= 0) goto L_0x0085
            int r12 = r0.length()
            int r12 = r12 - r8
            char r12 = r0.charAt(r12)
            r13 = 65532(0xfffc, float:9.183E-41)
            if (r12 != r13) goto L_0x0085
            int r12 = r0.length()
            int r12 = r12 - r8
            r0.setLength(r12)
            goto L_0x0068
        L_0x0085:
            java.lang.String r12 = r0.toString()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.d.a.b.a(byte[], int, int):java.lang.String");
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\d\a\c.java ==========

package a.a.a.d.a;

import a.a.a.b.b;
import a.a.a.b.b.a;
import a.a.a.b.e;
import a.a.a.d;
import a.a.a.f;
import java.util.Map;

/* compiled from: Decoder */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final a.a.a.b.b.c f70a = new a.a.a.b.b.c(a.h);

    public e a(b bVar, Map<a.a.a.e, ?> map) throws f, d {
        byte[] bArr;
        byte[] a2 = new a(bVar).a();
        a(a2, 0, 10, 10, 0);
        byte b2 = a2[0] & 15;
        switch (b2) {
            case 2:
            case 3:
            case 4:
                byte[] bArr2 = a2;
                a(bArr2, 20, 84, 40, 1);
                a(bArr2, 20, 84, 40, 2);
                bArr = new byte[94];
                break;
            case 5:
                byte[] bArr3 = a2;
                a(bArr3, 20, 68, 56, 1);
                a(bArr3, 20, 68, 56, 2);
                bArr = new byte[78];
                break;
            default:
                throw f.a();
        }
        System.arraycopy(a2, 0, bArr, 0, 10);
        System.arraycopy(a2, 20, bArr, 10, bArr.length - 10);
        return b.a(bArr, (int) b2);
    }

    private void a(byte[] bArr, int i, int i2, int i3, int i4) throws d {
        int i5 = i2 + i3;
        int i6 = i4 == 0 ? 1 : 2;
        int[] iArr = new int[(i5 / i6)];
        for (int i7 = 0; i7 < i5; i7++) {
            if (i4 == 0 || i7 % 2 == i4 - 1) {
                iArr[i7 / i6] = bArr[i7 + i] & 255;
            }
        }
        try {
            this.f70a.a(iArr, i3 / i6);
            for (int i8 = 0; i8 < i2; i8++) {
                if (i4 == 0 || i8 % 2 == i4 - 1) {
                    bArr[i8 + i] = (byte) iArr[i8 / i6];
                }
            }
        } catch (a.a.a.b.b.d unused) {
            throw d.a();
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a.java ==========

package a.a.a.e;

import a.a.a.i;

/* compiled from: CodaBarReader */
public final class a extends k {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f73a = "0123456789-$:/.+ABCD".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    static final int[] f74b = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    private static final char[] c = {'A', 'B', 'C', 'D'};
    private final StringBuilder d = new StringBuilder(20);
    private int[] e = new int[80];
    private int f = 0;

    /* JADX WARNING: Removed duplicated region for block: B:3:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0109 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.a.a.m a(int r11, a.a.a.b.a r12, java.util.Map<a.a.a.e, ?> r13) throws a.a.a.i {
        /*
            r10 = this;
            int[] r0 = r10.e
            r1 = 0
            java.util.Arrays.fill(r0, r1)
            r10.a((a.a.a.b.a) r12)
            int r12 = r10.b()
            java.lang.StringBuilder r0 = r10.d
            r0.setLength(r1)
            r0 = r12
        L_0x0013:
            int r2 = r10.c(r0)
            r3 = -1
            if (r2 == r3) goto L_0x0109
            java.lang.StringBuilder r4 = r10.d
            char r5 = (char) r2
            r4.append(r5)
            int r0 = r0 + 8
            java.lang.StringBuilder r4 = r10.d
            int r4 = r4.length()
            r5 = 1
            if (r4 <= r5) goto L_0x0037
            char[] r4 = c
            char[] r6 = f73a
            char r2 = r6[r2]
            boolean r2 = a(r4, r2)
            if (r2 != 0) goto L_0x003b
        L_0x0037:
            int r2 = r10.f
            if (r0 < r2) goto L_0x0013
        L_0x003b:
            int[] r2 = r10.e
            int r4 = r0 + -1
            r2 = r2[r4]
            r6 = -8
            r7 = 0
        L_0x0043:
            if (r6 >= r3) goto L_0x004f
            int[] r8 = r10.e
            int r9 = r0 + r6
            r8 = r8[r9]
            int r7 = r7 + r8
            int r6 = r6 + 1
            goto L_0x0043
        L_0x004f:
            int r3 = r10.f
            r6 = 2
            if (r0 >= r3) goto L_0x005d
            int r7 = r7 / r6
            if (r2 < r7) goto L_0x0058
            goto L_0x005d
        L_0x0058:
            a.a.a.i r11 = a.a.a.i.a()
            throw r11
        L_0x005d:
            r10.a((int) r12)
            r0 = 0
        L_0x0061:
            java.lang.StringBuilder r2 = r10.d
            int r2 = r2.length()
            if (r0 >= r2) goto L_0x007b
            java.lang.StringBuilder r2 = r10.d
            char[] r3 = f73a
            java.lang.StringBuilder r7 = r10.d
            char r7 = r7.charAt(r0)
            char r3 = r3[r7]
            r2.setCharAt(r0, r3)
            int r0 = r0 + 1
            goto L_0x0061
        L_0x007b:
            java.lang.StringBuilder r0 = r10.d
            char r0 = r0.charAt(r1)
            char[] r2 = c
            boolean r0 = a(r2, r0)
            if (r0 == 0) goto L_0x0104
            java.lang.StringBuilder r0 = r10.d
            java.lang.StringBuilder r2 = r10.d
            int r2 = r2.length()
            int r2 = r2 - r5
            char r0 = r0.charAt(r2)
            char[] r2 = c
            boolean r0 = a(r2, r0)
            if (r0 == 0) goto L_0x00ff
            java.lang.StringBuilder r0 = r10.d
            int r0 = r0.length()
            r2 = 3
            if (r0 <= r2) goto L_0x00fa
            if (r13 == 0) goto L_0x00b1
            a.a.a.e r0 = a.a.a.e.RETURN_CODABAR_START_END
            boolean r13 = r13.containsKey(r0)
            if (r13 != 0) goto L_0x00c2
        L_0x00b1:
            java.lang.StringBuilder r13 = r10.d
            java.lang.StringBuilder r0 = r10.d
            int r0 = r0.length()
            int r0 = r0 - r5
            r13.deleteCharAt(r0)
            java.lang.StringBuilder r13 = r10.d
            r13.deleteCharAt(r1)
        L_0x00c2:
            r13 = 0
            r0 = 0
        L_0x00c4:
            if (r13 >= r12) goto L_0x00ce
            int[] r2 = r10.e
            r2 = r2[r13]
            int r0 = r0 + r2
            int r13 = r13 + 1
            goto L_0x00c4
        L_0x00ce:
            float r13 = (float) r0
        L_0x00cf:
            if (r12 >= r4) goto L_0x00d9
            int[] r2 = r10.e
            r2 = r2[r12]
            int r0 = r0 + r2
            int r12 = r12 + 1
            goto L_0x00cf
        L_0x00d9:
            float r12 = (float) r0
            a.a.a.m r0 = new a.a.a.m
            java.lang.StringBuilder r2 = r10.d
            java.lang.String r2 = r2.toString()
            r3 = 0
            a.a.a.o[] r4 = new a.a.a.o[r6]
            a.a.a.o r6 = new a.a.a.o
            float r11 = (float) r11
            r6.<init>(r13, r11)
            r4[r1] = r6
            a.a.a.o r13 = new a.a.a.o
            r13.<init>(r12, r11)
            r4[r5] = r13
            a.a.a.a r11 = a.a.a.a.CODABAR
            r0.<init>(r2, r3, r4, r11)
            return r0
        L_0x00fa:
            a.a.a.i r11 = a.a.a.i.a()
            throw r11
        L_0x00ff:
            a.a.a.i r11 = a.a.a.i.a()
            throw r11
        L_0x0104:
            a.a.a.i r11 = a.a.a.i.a()
            throw r11
        L_0x0109:
            a.a.a.i r11 = a.a.a.i.a()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.e.a.a(int, a.a.a.b.a, java.util.Map):a.a.a.m");
    }

    private void a(int i) throws i {
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.d.length() - 1;
        int i2 = 0;
        int i3 = i;
        int i4 = 0;
        while (true) {
            int i5 = f74b[this.d.charAt(i4)];
            for (int i6 = 6; i6 >= 0; i6--) {
                int i7 = (i6 & 1) + ((i5 & 1) << 1);
                iArr[i7] = iArr[i7] + this.e[i3 + i6];
                iArr2[i7] = iArr2[i7] + 1;
                i5 >>= 1;
            }
            if (i4 >= length) {
                break;
            }
            i3 += 8;
            i4++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i8 = 0; i8 < 2; i8++) {
            fArr2[i8] = 0.0f;
            int i9 = i8 + 2;
            fArr2[i9] = ((((float) iArr[i8]) / ((float) iArr2[i8])) + (((float) iArr[i9]) / ((float) iArr2[i9]))) / 2.0f;
            fArr[i8] = fArr2[i9];
            fArr[i9] = ((((float) iArr[i9]) * 2.0f) + 1.5f) / ((float) iArr2[i9]);
        }
        loop3:
        while (true) {
            int i10 = f74b[this.d.charAt(i2)];
            int i11 = 6;
            while (i11 >= 0) {
                int i12 = (i11 & 1) + ((i10 & 1) << 1);
                float f2 = (float) this.e[i + i11];
                if (f2 >= fArr2[i12] && f2 <= fArr[i12]) {
                    i10 >>= 1;
                    i11--;
                }
            }
            if (i2 < length) {
                i += 8;
                i2++;
            } else {
                return;
            }
        }
        throw i.a();
    }

    private void a(a.a.a.b.a aVar) throws i {
        this.f = 0;
        int d2 = aVar.d(0);
        int a2 = aVar.a();
        if (d2 < a2) {
            boolean z = true;
            int i = 0;
            while (d2 < a2) {
                if (aVar.a(d2) ^ z) {
                    i++;
                } else {
                    b(i);
                    z = !z;
                    i = 1;
                }
                d2++;
            }
            b(i);
            return;
        }
        throw i.a();
    }

    private void b(int i) {
        this.e[this.f] = i;
        this.f++;
        if (this.f >= this.e.length) {
            int[] iArr = new int[(this.f << 1)];
            System.arraycopy(this.e, 0, iArr, 0, this.f);
            this.e = iArr;
        }
    }

    private int b() throws i {
        for (int i = 1; i < this.f; i += 2) {
            int c2 = c(i);
            if (c2 != -1 && a(c, f73a[c2])) {
                int i2 = 0;
                for (int i3 = i; i3 < i + 7; i3++) {
                    i2 += this.e[i3];
                }
                if (i == 1 || this.e[i - 1] >= i2 / 2) {
                    return i;
                }
            }
        }
        throw i.a();
    }

    static boolean a(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
        }
        return false;
    }

    private int c(int i) {
        int i2 = i + 7;
        if (i2 >= this.f) {
            return -1;
        }
        int[] iArr = this.e;
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        for (int i6 = i; i6 < i2; i6 += 2) {
            int i7 = iArr[i6];
            if (i7 < i4) {
                i4 = i7;
            }
            if (i7 > i5) {
                i5 = i7;
            }
        }
        int i8 = (i4 + i5) / 2;
        int i9 = 0;
        for (int i10 = i + 1; i10 < i2; i10 += 2) {
            int i11 = iArr[i10];
            if (i11 < i3) {
                i3 = i11;
            }
            if (i11 > i9) {
                i9 = i11;
            }
        }
        int i12 = (i3 + i9) / 2;
        int i13 = 128;
        int i14 = 0;
        for (int i15 = 0; i15 < 7; i15++) {
            i13 >>= 1;
            if (iArr[i + i15] > ((i15 & 1) == 0 ? i8 : i12)) {
                i14 |= i13;
            }
        }
        for (int i16 = 0; i16 < f74b.length; i16++) {
            if (f74b[i16] == i14) {
                return i16;
            }
        }
        return -1;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\b.java ==========

package a.a.a.e;

import a.a.a.b.a;
import a.a.a.i;

/* compiled from: Code128Reader */
public final class b extends k {

    /* renamed from: a  reason: collision with root package name */
    static final int[][] f111a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    private static int[] a(a aVar) throws i {
        int a2 = aVar.a();
        int c = aVar.c(0);
        int[] iArr = new int[6];
        int i = c;
        boolean z = false;
        int i2 = 0;
        while (c < a2) {
            if (aVar.a(c) ^ z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                if (i2 == 5) {
                    float f = 0.25f;
                    int i3 = -1;
                    for (int i4 = 103; i4 <= 105; i4++) {
                        float a3 = a(iArr, f111a[i4], 0.7f);
                        if (a3 < f) {
                            i3 = i4;
                            f = a3;
                        }
                    }
                    if (i3 < 0 || !aVar.a(Math.max(0, i - ((c - i) / 2)), i, false)) {
                        i += iArr[0] + iArr[1];
                        System.arraycopy(iArr, 2, iArr, 0, 4);
                        iArr[4] = 0;
                        iArr[5] = 0;
                        i2--;
                    } else {
                        return new int[]{i, c, i3};
                    }
                } else {
                    i2++;
                }
                iArr[i2] = 1;
                z = !z;
            }
            c++;
        }
        throw i.a();
    }

    private static int a(a aVar, int[] iArr, int i) throws i {
        a(aVar, i, iArr);
        float f = 0.25f;
        int i2 = -1;
        for (int i3 = 0; i3 < f111a.length; i3++) {
            float a2 = a(iArr, f111a[i3], 0.7f);
            if (a2 < f) {
                i2 = i3;
                f = a2;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw i.a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x018d, code lost:
        r15 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x018e, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x018f, code lost:
        if (r8 == false) goto L_0x019b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0193, code lost:
        if (r3 != 'e') goto L_0x0198;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0195, code lost:
        r3 = 'd';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0198, code lost:
        r3 = 'e';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x019d, code lost:
        r8 = r5;
        r5 = r15;
        r15 = 6;
        r21 = r12;
        r12 = r9;
        r9 = r14;
        r14 = r18;
        r18 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e0, code lost:
        if (r5 != false) goto L_0x0137;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0100, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0103, code lost:
        r15 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x012e, code lost:
        r5 = false;
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0135, code lost:
        if (r5 != false) goto L_0x0137;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0137, code lost:
        r5 = false;
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x013c, code lost:
        r5 = false;
        r15 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0141, code lost:
        r15 = r5;
        r3 = 'c';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0148, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x014a, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x014b, code lost:
        r15 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x014c, code lost:
        r5 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.a.a.m a(int r23, a.a.a.b.a r24, java.util.Map<a.a.a.e, ?> r25) throws a.a.a.i, a.a.a.f, a.a.a.d {
        /*
            r22 = this;
            r0 = r24
            r1 = r25
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0012
            a.a.a.e r4 = a.a.a.e.ASSUME_GS1
            boolean r1 = r1.containsKey(r4)
            if (r1 == 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            int[] r4 = a(r24)
            r5 = 2
            r6 = r4[r5]
            java.util.ArrayList r7 = new java.util.ArrayList
            r8 = 20
            r7.<init>(r8)
            byte r9 = (byte) r6
            java.lang.Byte r9 = java.lang.Byte.valueOf(r9)
            r7.add(r9)
            switch(r6) {
                case 103: goto L_0x0037;
                case 104: goto L_0x0034;
                case 105: goto L_0x0031;
                default: goto L_0x002c;
            }
        L_0x002c:
            a.a.a.f r0 = a.a.a.f.a()
            throw r0
        L_0x0031:
            r12 = 99
            goto L_0x0039
        L_0x0034:
            r12 = 100
            goto L_0x0039
        L_0x0037:
            r12 = 101(0x65, float:1.42E-43)
        L_0x0039:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r8)
            r8 = r4[r3]
            r14 = r4[r2]
            r15 = 6
            int[] r2 = new int[r15]
            r16 = r6
            r9 = r8
            r3 = r12
            r5 = 0
            r6 = 0
            r8 = 0
            r11 = 0
            r12 = 0
            r17 = 0
            r18 = 0
            r19 = 1
        L_0x0054:
            if (r6 != 0) goto L_0x01aa
            int r9 = a((a.a.a.b.a) r0, (int[]) r2, (int) r14)
            byte r10 = (byte) r9
            java.lang.Byte r10 = java.lang.Byte.valueOf(r10)
            r7.add(r10)
            r10 = 106(0x6a, float:1.49E-43)
            if (r9 == r10) goto L_0x0068
            r19 = 1
        L_0x0068:
            if (r9 == r10) goto L_0x0070
            int r17 = r17 + 1
            int r18 = r17 * r9
            int r16 = r16 + r18
        L_0x0070:
            r18 = r14
            r10 = 0
        L_0x0073:
            if (r10 >= r15) goto L_0x007c
            r20 = r2[r10]
            int r18 = r18 + r20
            int r10 = r10 + 1
            goto L_0x0073
        L_0x007c:
            switch(r9) {
                case 103: goto L_0x0088;
                case 104: goto L_0x0088;
                case 105: goto L_0x0088;
                default: goto L_0x007f;
            }
        L_0x007f:
            r10 = 96
            switch(r3) {
                case 99: goto L_0x0150;
                case 100: goto L_0x00ed;
                case 101: goto L_0x008d;
                default: goto L_0x0084;
            }
        L_0x0084:
            r10 = 100
            goto L_0x018d
        L_0x0088:
            a.a.a.f r0 = a.a.a.f.a()
            throw r0
        L_0x008d:
            r15 = 64
            if (r9 >= r15) goto L_0x00a4
            if (r5 != r11) goto L_0x009b
            int r5 = r9 + 32
            char r5 = (char) r5
            r13.append(r5)
            goto L_0x0100
        L_0x009b:
            int r5 = r9 + 32
            int r5 = r5 + 128
            char r5 = (char) r5
            r13.append(r5)
            goto L_0x0100
        L_0x00a4:
            if (r9 >= r10) goto L_0x00b6
            if (r5 != r11) goto L_0x00af
            int r5 = r9 + -64
            char r5 = (char) r5
            r13.append(r5)
            goto L_0x0100
        L_0x00af:
            int r5 = r9 + 64
            char r5 = (char) r5
            r13.append(r5)
            goto L_0x0100
        L_0x00b6:
            r10 = 106(0x6a, float:1.49E-43)
            if (r9 == r10) goto L_0x00bc
            r19 = 0
        L_0x00bc:
            if (r9 == r10) goto L_0x014a
            switch(r9) {
                case 96: goto L_0x014b;
                case 97: goto L_0x014b;
                case 98: goto L_0x00e8;
                case 99: goto L_0x0141;
                case 100: goto L_0x00e3;
                case 101: goto L_0x00d9;
                case 102: goto L_0x00c3;
                default: goto L_0x00c1;
            }
        L_0x00c1:
            goto L_0x014b
        L_0x00c3:
            if (r1 == 0) goto L_0x014b
            int r10 = r13.length()
            if (r10 != 0) goto L_0x00d2
            java.lang.String r10 = "]C1"
            r13.append(r10)
            goto L_0x014b
        L_0x00d2:
            r10 = 29
            r13.append(r10)
            goto L_0x014b
        L_0x00d9:
            if (r11 != 0) goto L_0x00de
            if (r5 == 0) goto L_0x00de
            goto L_0x012e
        L_0x00de:
            if (r11 == 0) goto L_0x013c
            if (r5 == 0) goto L_0x013c
            goto L_0x0137
        L_0x00e3:
            r15 = r5
            r3 = 100
            goto L_0x014c
        L_0x00e8:
            r15 = r5
            r3 = 100
            goto L_0x0148
        L_0x00ed:
            if (r9 >= r10) goto L_0x0106
            if (r5 != r11) goto L_0x00f8
            int r5 = r9 + 32
            char r5 = (char) r5
            r13.append(r5)
            goto L_0x0100
        L_0x00f8:
            int r5 = r9 + 32
            int r5 = r5 + 128
            char r5 = (char) r5
            r13.append(r5)
        L_0x0100:
            r5 = 0
            r10 = 100
        L_0x0103:
            r15 = 0
            goto L_0x018f
        L_0x0106:
            r10 = 106(0x6a, float:1.49E-43)
            if (r9 == r10) goto L_0x010c
            r19 = 0
        L_0x010c:
            if (r9 == r10) goto L_0x014a
            switch(r9) {
                case 96: goto L_0x014b;
                case 97: goto L_0x014b;
                case 98: goto L_0x0145;
                case 99: goto L_0x0141;
                case 100: goto L_0x012a;
                case 101: goto L_0x0126;
                case 102: goto L_0x0112;
                default: goto L_0x0111;
            }
        L_0x0111:
            goto L_0x014b
        L_0x0112:
            if (r1 == 0) goto L_0x014b
            int r10 = r13.length()
            if (r10 != 0) goto L_0x0120
            java.lang.String r10 = "]C1"
            r13.append(r10)
            goto L_0x014b
        L_0x0120:
            r10 = 29
            r13.append(r10)
            goto L_0x014b
        L_0x0126:
            r15 = r5
            r3 = 101(0x65, float:1.42E-43)
            goto L_0x014c
        L_0x012a:
            if (r11 != 0) goto L_0x0133
            if (r5 == 0) goto L_0x0133
        L_0x012e:
            r5 = 0
            r10 = 100
            r11 = 1
            goto L_0x0103
        L_0x0133:
            if (r11 == 0) goto L_0x013c
            if (r5 == 0) goto L_0x013c
        L_0x0137:
            r5 = 0
            r10 = 100
            r11 = 0
            goto L_0x0103
        L_0x013c:
            r5 = 0
            r10 = 100
            r15 = 1
            goto L_0x018f
        L_0x0141:
            r15 = r5
            r3 = 99
            goto L_0x014c
        L_0x0145:
            r15 = r5
            r3 = 101(0x65, float:1.42E-43)
        L_0x0148:
            r5 = 1
            goto L_0x014d
        L_0x014a:
            r6 = 1
        L_0x014b:
            r15 = r5
        L_0x014c:
            r5 = 0
        L_0x014d:
            r10 = 100
            goto L_0x018f
        L_0x0150:
            r10 = 100
            if (r9 >= r10) goto L_0x0161
            r15 = 10
            if (r9 >= r15) goto L_0x015d
            r15 = 48
            r13.append(r15)
        L_0x015d:
            r13.append(r9)
            goto L_0x018d
        L_0x0161:
            r15 = 106(0x6a, float:1.49E-43)
            if (r9 == r15) goto L_0x0167
            r19 = 0
        L_0x0167:
            if (r9 == r15) goto L_0x0189
            switch(r9) {
                case 100: goto L_0x0185;
                case 101: goto L_0x0181;
                case 102: goto L_0x016d;
                default: goto L_0x016c;
            }
        L_0x016c:
            goto L_0x018d
        L_0x016d:
            if (r1 == 0) goto L_0x018d
            int r15 = r13.length()
            if (r15 != 0) goto L_0x017b
            java.lang.String r15 = "]C1"
            r13.append(r15)
            goto L_0x018d
        L_0x017b:
            r15 = 29
            r13.append(r15)
            goto L_0x018d
        L_0x0181:
            r15 = r5
            r3 = 101(0x65, float:1.42E-43)
            goto L_0x018e
        L_0x0185:
            r15 = r5
            r3 = 100
            goto L_0x018e
        L_0x0189:
            r15 = r5
            r5 = 0
            r6 = 1
            goto L_0x018f
        L_0x018d:
            r15 = r5
        L_0x018e:
            r5 = 0
        L_0x018f:
            if (r8 == 0) goto L_0x019b
            r8 = 101(0x65, float:1.42E-43)
            if (r3 != r8) goto L_0x0198
            r3 = 100
            goto L_0x019d
        L_0x0198:
            r3 = 101(0x65, float:1.42E-43)
            goto L_0x019d
        L_0x019b:
            r8 = 101(0x65, float:1.42E-43)
        L_0x019d:
            r8 = r5
            r5 = r15
            r15 = 6
            r21 = r12
            r12 = r9
            r9 = r14
            r14 = r18
            r18 = r21
            goto L_0x0054
        L_0x01aa:
            int r1 = r14 - r9
            int r2 = r0.d(r14)
            int r5 = r24.a()
            int r6 = r2 - r9
            r8 = 2
            int r6 = r6 / r8
            int r6 = r6 + r2
            int r5 = java.lang.Math.min(r5, r6)
            r6 = 0
            boolean r0 = r0.a(r2, r5, r6)
            if (r0 == 0) goto L_0x023a
            r12 = r18
            int r17 = r17 * r12
            int r16 = r16 - r17
            int r0 = r16 % 103
            if (r0 != r12) goto L_0x0235
            int r0 = r13.length()
            if (r0 == 0) goto L_0x0230
            if (r0 <= 0) goto L_0x01e7
            if (r19 == 0) goto L_0x01e7
            r2 = 99
            if (r3 != r2) goto L_0x01e2
            int r2 = r0 + -2
            r13.delete(r2, r0)
            goto L_0x01e7
        L_0x01e2:
            int r2 = r0 + -1
            r13.delete(r2, r0)
        L_0x01e7:
            r0 = 1
            r2 = r4[r0]
            r0 = 0
            r3 = r4[r0]
            int r2 = r2 + r3
            float r0 = (float) r2
            r2 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r2
            float r3 = (float) r9
            float r1 = (float) r1
            float r1 = r1 / r2
            float r3 = r3 + r1
            int r1 = r7.size()
            byte[] r2 = new byte[r1]
            r4 = 0
        L_0x01fd:
            if (r4 >= r1) goto L_0x020e
            java.lang.Object r5 = r7.get(r4)
            java.lang.Byte r5 = (java.lang.Byte) r5
            byte r5 = r5.byteValue()
            r2[r4] = r5
            int r4 = r4 + 1
            goto L_0x01fd
        L_0x020e:
            a.a.a.m r1 = new a.a.a.m
            java.lang.String r4 = r13.toString()
            r5 = 2
            a.a.a.o[] r5 = new a.a.a.o[r5]
            a.a.a.o r6 = new a.a.a.o
            r7 = r23
            float r7 = (float) r7
            r6.<init>(r0, r7)
            r0 = 0
            r5[r0] = r6
            a.a.a.o r0 = new a.a.a.o
            r0.<init>(r3, r7)
            r3 = 1
            r5[r3] = r0
            a.a.a.a r0 = a.a.a.a.CODE_128
            r1.<init>(r4, r2, r5, r0)
            return r1
        L_0x0230:
            a.a.a.i r0 = a.a.a.i.a()
            throw r0
        L_0x0235:
            a.a.a.d r0 = a.a.a.d.a()
            throw r0
        L_0x023a:
            a.a.a.i r0 = a.a.a.i.a()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.e.b.a(int, a.a.a.b.a, java.util.Map):a.a.a.m");
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\c.java ==========

package a.a.a.e;

import a.a.a.b.a;
import a.a.a.d;
import a.a.a.e;
import a.a.a.f;
import a.a.a.i;
import a.a.a.m;
import a.a.a.o;
import java.util.Arrays;
import java.util.Map;

/* compiled from: Code39Reader */
public final class c extends k {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f112a;

    /* renamed from: b  reason: collision with root package name */
    static final int f113b;
    private final boolean c;
    private final boolean d;
    private final StringBuilder e;
    private final int[] f;

    static {
        int[] iArr = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 148, 168, 162, 138, 42};
        f112a = iArr;
        f113b = iArr[39];
    }

    public c() {
        this(false);
    }

    public c(boolean z) {
        this(z, false);
    }

    public c(boolean z, boolean z2) {
        this.c = z;
        this.d = z2;
        this.e = new StringBuilder(20);
        this.f = new int[9];
    }

    public m a(int i, a aVar, Map<e, ?> map) throws i, d, f {
        String str;
        int[] iArr = this.f;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.e;
        sb.setLength(0);
        int[] a2 = a(aVar, iArr);
        int c2 = aVar.c(a2[1]);
        int a3 = aVar.a();
        while (true) {
            a(aVar, c2, iArr);
            int a4 = a(iArr);
            if (a4 >= 0) {
                char a5 = a(a4);
                sb.append(a5);
                int i2 = c2;
                for (int i3 : iArr) {
                    i2 += i3;
                }
                int c3 = aVar.c(i2);
                if (a5 == '*') {
                    sb.setLength(sb.length() - 1);
                    int i4 = 0;
                    for (int i5 : iArr) {
                        i4 += i5;
                    }
                    int i6 = (c3 - c2) - i4;
                    if (c3 == a3 || (i6 << 1) >= i4) {
                        if (this.c) {
                            int length = sb.length() - 1;
                            int i7 = 0;
                            for (int i8 = 0; i8 < length; i8++) {
                                i7 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.e.charAt(i8));
                            }
                            if (sb.charAt(length) == "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i7 % 43)) {
                                sb.setLength(length);
                            } else {
                                throw d.a();
                            }
                        }
                        if (sb.length() != 0) {
                            if (this.d) {
                                str = a((CharSequence) sb);
                            } else {
                                str = sb.toString();
                            }
                            float f2 = (float) i;
                            return new m(str, (byte[]) null, new o[]{new o(((float) (a2[1] + a2[0])) / 2.0f, f2), new o(((float) c2) + (((float) i4) / 2.0f), f2)}, a.a.a.a.CODE_39);
                        }
                        throw i.a();
                    }
                    throw i.a();
                }
                c2 = c3;
            } else {
                throw i.a();
            }
        }
    }

    private static int[] a(a aVar, int[] iArr) throws i {
        int a2 = aVar.a();
        int c2 = aVar.c(0);
        int length = iArr.length;
        int i = c2;
        boolean z = false;
        int i2 = 0;
        while (c2 < a2) {
            if (aVar.a(c2) ^ z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                int i3 = length - 1;
                if (i2 != i3) {
                    i2++;
                } else if (a(iArr) != f113b || !aVar.a(Math.max(0, i - ((c2 - i) / 2)), i, false)) {
                    i += iArr[0] + iArr[1];
                    int i4 = length - 2;
                    System.arraycopy(iArr, 2, iArr, 0, i4);
                    iArr[i4] = 0;
                    iArr[i3] = 0;
                    i2--;
                } else {
                    return new int[]{i, c2};
                }
                iArr[i2] = 1;
                z = !z;
            }
            c2++;
        }
        throw i.a();
    }

    private static int a(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            for (int i3 : iArr) {
                if (i3 < i2 && i3 > i) {
                    i2 = i3;
                }
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = iArr[i7];
                if (i8 > i2) {
                    i5 |= 1 << ((length - 1) - i7);
                    i4++;
                    i6 += i8;
                }
            }
            if (i4 == 3) {
                for (int i9 = 0; i9 < length && i4 > 0; i9++) {
                    int i10 = iArr[i9];
                    if (i10 > i2) {
                        i4--;
                        if ((i10 << 1) >= i6) {
                            return -1;
                        }
                    }
                }
                return i5;
            } else if (i4 <= 3) {
                return -1;
            } else {
                i = i2;
            }
        }
    }

    private static char a(int i) throws i {
        for (int i2 = 0; i2 < f112a.length; i2++) {
            if (f112a[i2] == i) {
                return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".charAt(i2);
            }
        }
        throw i.a();
    }

    private static String a(CharSequence charSequence) throws f {
        char c2;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt == '+' || charAt == '$' || charAt == '%' || charAt == '/') {
                i++;
                char charAt2 = charSequence.charAt(i);
                if (charAt != '+') {
                    if (charAt != '/') {
                        switch (charAt) {
                            case '$':
                                if (charAt2 >= 'A' && charAt2 <= 'Z') {
                                    c2 = (char) (charAt2 - '@');
                                    break;
                                } else {
                                    throw f.a();
                                }
                                break;
                            case '%':
                                if (charAt2 < 'A' || charAt2 > 'E') {
                                    if (charAt2 >= 'F' && charAt2 <= 'W') {
                                        c2 = (char) (charAt2 - 11);
                                        break;
                                    } else {
                                        throw f.a();
                                    }
                                } else {
                                    c2 = (char) (charAt2 - '&');
                                    break;
                                }
                                break;
                            default:
                                c2 = 0;
                                break;
                        }
                    } else if (charAt2 >= 'A' && charAt2 <= 'O') {
                        c2 = (char) (charAt2 - ' ');
                    } else if (charAt2 == 'Z') {
                        c2 = ':';
                    } else {
                        throw f.a();
                    }
                } else if (charAt2 < 'A' || charAt2 > 'Z') {
                    throw f.a();
                } else {
                    c2 = (char) (charAt2 + ' ');
                }
                sb.append(c2);
            } else {
                sb.append(charAt);
            }
            i++;
        }
        return sb.toString();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\d.java ==========

package a.a.a.e;

import a.a.a.b.a;
import a.a.a.e;
import a.a.a.f;
import a.a.a.i;
import a.a.a.m;
import a.a.a.o;
import java.util.Arrays;
import java.util.Map;

/* compiled from: Code93Reader */
public final class d extends k {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f114a;

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f115b = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
    private static final int c;
    private final StringBuilder d = new StringBuilder(20);
    private final int[] e = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        f114a = iArr;
        c = iArr[47];
    }

    public m a(int i, a aVar, Map<e, ?> map) throws i, a.a.a.d, f {
        int[] a2 = a(aVar);
        int c2 = aVar.c(a2[1]);
        int a3 = aVar.a();
        int[] iArr = this.e;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.d;
        sb.setLength(0);
        while (true) {
            a(aVar, c2, iArr);
            int a4 = a(iArr);
            if (a4 >= 0) {
                char a5 = a(a4);
                sb.append(a5);
                int i2 = c2;
                for (int i3 : iArr) {
                    i2 += i3;
                }
                int c3 = aVar.c(i2);
                if (a5 == '*') {
                    sb.deleteCharAt(sb.length() - 1);
                    int i4 = 0;
                    for (int i5 : iArr) {
                        i4 += i5;
                    }
                    if (c3 == a3 || !aVar.a(c3)) {
                        throw i.a();
                    } else if (sb.length() >= 2) {
                        b(sb);
                        sb.setLength(sb.length() - 2);
                        float f = (float) i;
                        return new m(a((CharSequence) sb), (byte[]) null, new o[]{new o(((float) (a2[1] + a2[0])) / 2.0f, f), new o(((float) c2) + (((float) i4) / 2.0f), f)}, a.a.a.a.CODE_93);
                    } else {
                        throw i.a();
                    }
                } else {
                    c2 = c3;
                }
            } else {
                throw i.a();
            }
        }
    }

    private int[] a(a aVar) throws i {
        int a2 = aVar.a();
        int c2 = aVar.c(0);
        Arrays.fill(this.e, 0);
        int[] iArr = this.e;
        int length = iArr.length;
        int i = c2;
        boolean z = false;
        int i2 = 0;
        while (c2 < a2) {
            if (aVar.a(c2) ^ z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                int i3 = length - 1;
                if (i2 != i3) {
                    i2++;
                } else if (a(iArr) == c) {
                    return new int[]{i, c2};
                } else {
                    i += iArr[0] + iArr[1];
                    int i4 = length - 2;
                    System.arraycopy(iArr, 2, iArr, 0, i4);
                    iArr[i4] = 0;
                    iArr[i3] = 0;
                    i2--;
                }
                iArr[i2] = 1;
                z = !z;
            }
            c2++;
        }
        throw i.a();
    }

    private static int a(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        int length = iArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int round = Math.round((((float) iArr[i4]) * 9.0f) / ((float) i));
            if (round <= 0 || round > 4) {
                return -1;
            }
            if ((i4 & 1) == 0) {
                int i5 = i3;
                for (int i6 = 0; i6 < round; i6++) {
                    i5 = (i5 << 1) | 1;
                }
                i3 = i5;
            } else {
                i3 <<= round;
            }
        }
        return i3;
    }

    private static char a(int i) throws i {
        for (int i2 = 0; i2 < f114a.length; i2++) {
            if (f114a[i2] == i) {
                return f115b[i2];
            }
        }
        throw i.a();
    }

    private static String a(CharSequence charSequence) throws f {
        char c2;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 'a' || charAt > 'd') {
                sb.append(charAt);
            } else if (i < length - 1) {
                i++;
                char charAt2 = charSequence.charAt(i);
                switch (charAt) {
                    case 'a':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            c2 = (char) (charAt2 - '@');
                            break;
                        } else {
                            throw f.a();
                        }
                        break;
                    case 'b':
                        if (charAt2 < 'A' || charAt2 > 'E') {
                            if (charAt2 < 'F' || charAt2 > 'J') {
                                if (charAt2 < 'K' || charAt2 > 'O') {
                                    if (charAt2 < 'P' || charAt2 > 'S') {
                                        if (charAt2 >= 'T' && charAt2 <= 'Z') {
                                            c2 = 127;
                                            break;
                                        } else {
                                            throw f.a();
                                        }
                                    } else {
                                        c2 = (char) (charAt2 + '+');
                                        break;
                                    }
                                } else {
                                    c2 = (char) (charAt2 + 16);
                                    break;
                                }
                            } else {
                                c2 = (char) (charAt2 - 11);
                                break;
                            }
                        } else {
                            c2 = (char) (charAt2 - '&');
                            break;
                        }
                        break;
                    case 'c':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            c2 = (char) (charAt2 - ' ');
                            break;
                        } else if (charAt2 == 'Z') {
                            c2 = ':';
                            break;
                        } else {
                            throw f.a();
                        }
                    case 'd':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            c2 = (char) (charAt2 + ' ');
                            break;
                        } else {
                            throw f.a();
                        }
                    default:
                        c2 = 0;
                        break;
                }
                sb.append(c2);
            } else {
                throw f.a();
            }
            i++;
        }
        return sb.toString();
    }

    private static void b(CharSequence charSequence) throws a.a.a.d {
        int length = charSequence.length();
        a(charSequence, length - 2, 20);
        a(charSequence, length - 1, 15);
    }

    private static void a(CharSequence charSequence, int i, int i2) throws a.a.a.d {
        int i3 = 0;
        int i4 = 1;
        for (int i5 = i - 1; i5 >= 0; i5--) {
            i3 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i5)) * i4;
            i4++;
            if (i4 > i2) {
                i4 = 1;
            }
        }
        if (charSequence.charAt(i) != f115b[i3 % 47]) {
            throw a.a.a.d.a();
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\e.java ==========

package a.a.a.e;

import a.a.a.b.a;
import a.a.a.i;

/* compiled from: EAN13Reader */
public final class e extends p {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f116a = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    private final int[] g = new int[4];

    /* access modifiers changed from: protected */
    public int a(a aVar, int[] iArr, StringBuilder sb) throws i {
        int[] iArr2 = this.g;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a2 = aVar.a();
        int i = iArr[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 6 && i < a2) {
            int a3 = a(aVar, iArr2, i, f);
            sb.append((char) ((a3 % 10) + 48));
            int i4 = i;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            if (a3 >= 10) {
                i3 = (1 << (5 - i2)) | i3;
            }
            i2++;
            i = i4;
        }
        a(sb, i3);
        int i6 = a(aVar, i, true, c)[1];
        int i7 = 0;
        while (i7 < 6 && i6 < a2) {
            sb.append((char) (a(aVar, iArr2, i6, e) + 48));
            int i8 = i6;
            for (int i9 : iArr2) {
                i8 += i9;
            }
            i7++;
            i6 = i8;
        }
        return i6;
    }

    /* access modifiers changed from: package-private */
    public a.a.a.a b() {
        return a.a.a.a.EAN_13;
    }

    private static void a(StringBuilder sb, int i) throws i {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == f116a[i2]) {
                sb.insert(0, (char) (i2 + 48));
                return;
            }
        }
        throw i.a();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\f.java ==========

package a.a.a.e;

import a.a.a.b.a;
import a.a.a.i;

/* compiled from: EAN8Reader */
public final class f extends p {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f117a = new int[4];

    /* access modifiers changed from: protected */
    public int a(a aVar, int[] iArr, StringBuilder sb) throws i {
        int[] iArr2 = this.f117a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a2 = aVar.a();
        int i = iArr[1];
        int i2 = 0;
        while (i2 < 4 && i < a2) {
            sb.append((char) (a(aVar, iArr2, i, e) + 48));
            int i3 = i;
            for (int i4 : iArr2) {
                i3 += i4;
            }
            i2++;
            i = i3;
        }
        int i5 = a(aVar, i, true, c)[1];
        int i6 = 0;
        while (i6 < 4 && i5 < a2) {
            sb.append((char) (a(aVar, iArr2, i5, e) + 48));
            int i7 = i5;
            for (int i8 : iArr2) {
                i7 += i8;
            }
            i6++;
            i5 = i7;
        }
        return i5;
    }

    /* access modifiers changed from: package-private */
    public a.a.a.a b() {
        return a.a.a.a.EAN_8;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\g.java ==========

package a.a.a.e;

import java.util.ArrayList;
import java.util.List;

/* compiled from: EANManufacturerOrgSupport */
final class g {

    /* renamed from: a  reason: collision with root package name */
    private final List<int[]> f118a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f119b = new ArrayList();

    g() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0017, code lost:
        r4 = r7.f118a.get(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.String r8) {
        /*
            r7 = this;
            r7.a()
            r0 = 0
            r1 = 3
            java.lang.String r8 = r8.substring(r0, r1)
            int r8 = java.lang.Integer.parseInt(r8)
            java.util.List<int[]> r1 = r7.f118a
            int r1 = r1.size()
            r2 = 0
        L_0x0014:
            r3 = 0
            if (r2 >= r1) goto L_0x0039
            java.util.List<int[]> r4 = r7.f118a
            java.lang.Object r4 = r4.get(r2)
            int[] r4 = (int[]) r4
            r5 = r4[r0]
            if (r8 >= r5) goto L_0x0024
            return r3
        L_0x0024:
            int r3 = r4.length
            r6 = 1
            if (r3 != r6) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r5 = r4[r6]
        L_0x002b:
            if (r8 > r5) goto L_0x0036
            java.util.List<java.lang.String> r8 = r7.f119b
            java.lang.Object r8 = r8.get(r2)
            java.lang.String r8 = (java.lang.String) r8
            return r8
        L_0x0036:
            int r2 = r2 + 1
            goto L_0x0014
        L_0x0039:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.e.g.a(java.lang.String):java.lang.String");
    }

    private void a(int[] iArr, String str) {
        this.f118a.add(iArr);
        this.f119b.add(str);
    }

    private synchronized void a() {
        if (this.f118a.isEmpty()) {
            a(new int[]{0, 19}, "US/CA");
            a(new int[]{30, 39}, "US");
            a(new int[]{60, 139}, "US/CA");
            a(new int[]{300, 379}, "FR");
            a(new int[]{380}, "BG");
            a(new int[]{383}, "SI");
            a(new int[]{385}, "HR");
            a(new int[]{387}, "BA");
            a(new int[]{400, 440}, "DE");
            a(new int[]{450, 459}, "JP");
            a(new int[]{460, 469}, "RU");
            a(new int[]{471}, "TW");
            a(new int[]{474}, "EE");
            a(new int[]{475}, "LV");
            a(new int[]{476}, "AZ");
            a(new int[]{477}, "LT");
            a(new int[]{478}, "UZ");
            a(new int[]{479}, "LK");
            a(new int[]{480}, "PH");
            a(new int[]{481}, "BY");
            a(new int[]{482}, "UA");
            a(new int[]{484}, "MD");
            a(new int[]{485}, "AM");
            a(new int[]{486}, "GE");
            a(new int[]{487}, "KZ");
            a(new int[]{489}, "HK");
            a(new int[]{490, 499}, "JP");
            a(new int[]{500, 509}, "GB");
            a(new int[]{520}, "GR");
            a(new int[]{528}, "LB");
            a(new int[]{529}, "CY");
            a(new int[]{531}, "MK");
            a(new int[]{535}, "MT");
            a(new int[]{539}, "IE");
            a(new int[]{540, 549}, "BE/LU");
            a(new int[]{560}, "PT");
            a(new int[]{569}, "IS");
            a(new int[]{570, 579}, "DK");
            a(new int[]{590}, "PL");
            a(new int[]{594}, "RO");
            a(new int[]{599}, "HU");
            a(new int[]{600, 601}, "ZA");
            a(new int[]{603}, "GH");
            a(new int[]{608}, "BH");
            a(new int[]{609}, "MU");
            a(new int[]{611}, "MA");
            a(new int[]{613}, "DZ");
            a(new int[]{616}, "KE");
            a(new int[]{618}, "CI");
            a(new int[]{619}, "TN");
            a(new int[]{621}, "SY");
            a(new int[]{622}, "EG");
            a(new int[]{624}, "LY");
            a(new int[]{625}, "JO");
            a(new int[]{626}, "IR");
            a(new int[]{627}, "KW");
            a(new int[]{628}, "SA");
            a(new int[]{629}, "AE");
            a(new int[]{640, 649}, "FI");
            a(new int[]{690, 695}, "CN");
            a(new int[]{700, 709}, "NO");
            a(new int[]{729}, "IL");
            a(new int[]{730, 739}, "SE");
            a(new int[]{740}, "GT");
            a(new int[]{741}, "SV");
            a(new int[]{742}, "HN");
            a(new int[]{743}, "NI");
            a(new int[]{744}, "CR");
            a(new int[]{745}, "PA");
            a(new int[]{746}, "DO");
            a(new int[]{750}, "MX");
            a(new int[]{754, 755}, "CA");
            a(new int[]{759}, "VE");
            a(new int[]{760, 769}, "CH");
            a(new int[]{770}, "CO");
            a(new int[]{773}, "UY");
            a(new int[]{775}, "PE");
            a(new int[]{777}, "BO");
            a(new int[]{779}, "AR");
            a(new int[]{780}, "CL");
            a(new int[]{784}, "PY");
            a(new int[]{785}, "PE");
            a(new int[]{786}, "EC");
            a(new int[]{789, 790}, "BR");
            a(new int[]{800, 839}, "IT");
            a(new int[]{840, 849}, "ES");
            a(new int[]{850}, "CU");
            a(new int[]{858}, "SK");
            a(new int[]{859}, "CZ");
            a(new int[]{860}, "YU");
            a(new int[]{865}, "MN");
            a(new int[]{867}, "KP");
            a(new int[]{868, 869}, "TR");
            a(new int[]{870, 879}, "NL");
            a(new int[]{880}, "KR");
            a(new int[]{885}, "TH");
            a(new int[]{888}, "SG");
            a(new int[]{890}, "IN");
            a(new int[]{893}, "VN");
            a(new int[]{896}, "PK");
            a(new int[]{899}, "ID");
            a(new int[]{900, 919}, "AT");
            a(new int[]{930, 939}, "AU");
            a(new int[]{940, 949}, "AZ");
            a(new int[]{955}, "MY");
            a(new int[]{958}, "MO");
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\h.java ==========

package a.a.a.e;

import a.a.a.b.a;
import a.a.a.e;
import a.a.a.f;
import a.a.a.i;
import a.a.a.m;
import a.a.a.o;
import java.util.Map;

/* compiled from: ITFReader */
public final class h extends k {

    /* renamed from: a  reason: collision with root package name */
    static final int[][] f120a = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f121b = {6, 8, 10, 12, 14};
    private static final int[] d = {1, 1, 1, 1};
    private static final int[] e = {1, 1, 3};
    private int c = -1;

    public m a(int i, a aVar, Map<e, ?> map) throws f, i {
        boolean z;
        int[] a2 = a(aVar);
        int[] c2 = c(aVar);
        StringBuilder sb = new StringBuilder(20);
        a(aVar, a2[1], c2[0], sb);
        String sb2 = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(e.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f121b;
        }
        int length = sb2.length();
        int length2 = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length2) {
                z = false;
                break;
            }
            int i4 = iArr[i2];
            if (length == i4) {
                z = true;
                break;
            }
            if (i4 > i3) {
                i3 = i4;
            }
            i2++;
        }
        if (!z && length > i3) {
            z = true;
        }
        if (z) {
            float f = (float) i;
            return new m(sb2, (byte[]) null, new o[]{new o((float) a2[1], f), new o((float) c2[0], f)}, a.a.a.a.ITF);
        }
        throw f.a();
    }

    private static void a(a aVar, int i, int i2, StringBuilder sb) throws i {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i < i2) {
            a(aVar, i, iArr);
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = i3 * 2;
                iArr2[i3] = iArr[i4];
                iArr3[i3] = iArr[i4 + 1];
            }
            sb.append((char) (a(iArr2) + 48));
            sb.append((char) (a(iArr3) + 48));
            for (int i5 = 0; i5 < 10; i5++) {
                i += iArr[i5];
            }
        }
    }

    private int[] a(a aVar) throws i {
        int[] c2 = c(aVar, b(aVar), d);
        this.c = (c2[1] - c2[0]) / 4;
        a(aVar, c2[0]);
        return c2;
    }

    private void a(a aVar, int i) throws i {
        int i2 = this.c * 10;
        if (i2 >= i) {
            i2 = i;
        }
        int i3 = i - 1;
        while (i2 > 0 && i3 >= 0 && !aVar.a(i3)) {
            i2--;
            i3--;
        }
        if (i2 != 0) {
            throw i.a();
        }
    }

    private static int b(a aVar) throws i {
        int a2 = aVar.a();
        int c2 = aVar.c(0);
        if (c2 != a2) {
            return c2;
        }
        throw i.a();
    }

    private int[] c(a aVar) throws i {
        aVar.d();
        try {
            int[] c2 = c(aVar, b(aVar), e);
            a(aVar, c2[0]);
            int i = c2[0];
            c2[0] = aVar.a() - c2[1];
            c2[1] = aVar.a() - i;
            return c2;
        } finally {
            aVar.d();
        }
    }

    private static int[] c(a aVar, int i, int[] iArr) throws i {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int a2 = aVar.a();
        int i2 = i;
        boolean z = false;
        int i3 = 0;
        while (i < a2) {
            if (aVar.a(i) ^ z) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                int i4 = length - 1;
                if (i3 != i4) {
                    i3++;
                } else if (a(iArr2, iArr, 0.78f) < 0.38f) {
                    return new int[]{i2, i};
                } else {
                    i2 += iArr2[0] + iArr2[1];
                    int i5 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i4] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z = !z;
            }
            i++;
        }
        throw i.a();
    }

    private static int a(int[] iArr) throws i {
        int length = f120a.length;
        float f = 0.38f;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            float a2 = a(iArr, f120a[i2], 0.78f);
            if (a2 < f) {
                i = i2;
                f = a2;
            }
        }
        if (i >= 0) {
            return i;
        }
        throw i.a();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\i.java ==========

package a.a.a.e;

import a.a.a.a;
import a.a.a.e;
import a.a.a.e.a.a.d;
import a.a.a.l;
import a.a.a.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatOneDReader */
public final class i extends k {

    /* renamed from: a  reason: collision with root package name */
    private final k[] f122a;

    public i(Map<e, ?> map) {
        Collection collection;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(e.POSSIBLE_FORMATS);
        }
        boolean z = (map == null || map.get(e.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(a.EAN_13) || collection.contains(a.UPC_A) || collection.contains(a.EAN_8) || collection.contains(a.UPC_E)) {
                arrayList.add(new j(map));
            }
            if (collection.contains(a.CODE_39)) {
                arrayList.add(new c(z));
            }
            if (collection.contains(a.CODE_93)) {
                arrayList.add(new d());
            }
            if (collection.contains(a.CODE_128)) {
                arrayList.add(new b());
            }
            if (collection.contains(a.ITF)) {
                arrayList.add(new h());
            }
            if (collection.contains(a.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(a.RSS_14)) {
                arrayList.add(new a.a.a.e.a.e());
            }
            if (collection.contains(a.RSS_EXPANDED)) {
                arrayList.add(new d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new j(map));
            arrayList.add(new c());
            arrayList.add(new a());
            arrayList.add(new d());
            arrayList.add(new b());
            arrayList.add(new h());
            arrayList.add(new a.a.a.e.a.e());
            arrayList.add(new d());
        }
        this.f122a = (k[]) arrayList.toArray(new k[arrayList.size()]);
    }

    public m a(int i, a.a.a.b.a aVar, Map<e, ?> map) throws a.a.a.i {
        k[] kVarArr = this.f122a;
        int i2 = 0;
        while (i2 < kVarArr.length) {
            try {
                return kVarArr[i2].a(i, aVar, map);
            } catch (l unused) {
                i2++;
            }
        }
        throw a.a.a.i.a();
    }

    public void a() {
        for (k a2 : this.f122a) {
            a2.a();
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\j.java ==========

package a.a.a.e;

import a.a.a.a;
import a.a.a.e;
import a.a.a.i;
import a.a.a.l;
import a.a.a.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatUPCEANReader */
public final class j extends k {

    /* renamed from: a  reason: collision with root package name */
    private final p[] f123a;

    public j(Map<e, ?> map) {
        Collection collection;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(e.POSSIBLE_FORMATS);
        }
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(a.EAN_13)) {
                arrayList.add(new e());
            } else if (collection.contains(a.UPC_A)) {
                arrayList.add(new l());
            }
            if (collection.contains(a.EAN_8)) {
                arrayList.add(new f());
            }
            if (collection.contains(a.UPC_E)) {
                arrayList.add(new q());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new e());
            arrayList.add(new f());
            arrayList.add(new q());
        }
        this.f123a = (p[]) arrayList.toArray(new p[arrayList.size()]);
    }

    public m a(int i, a.a.a.b.a aVar, Map<e, ?> map) throws i {
        Collection collection;
        int[] a2 = p.a(aVar);
        p[] pVarArr = this.f123a;
        boolean z = false;
        int i2 = 0;
        while (i2 < pVarArr.length) {
            try {
                m a3 = pVarArr[i2].a(i, aVar, a2, map);
                boolean z2 = a3.d() == a.EAN_13 && a3.a().charAt(0) == '0';
                if (map == null) {
                    collection = null;
                } else {
                    collection = (Collection) map.get(e.POSSIBLE_FORMATS);
                }
                if (collection == null || collection.contains(a.UPC_A)) {
                    z = true;
                }
                if (!z2 || !z) {
                    return a3;
                }
                m mVar = new m(a3.a().substring(1), a3.b(), a3.c(), a.UPC_A);
                mVar.a(a3.e());
                return mVar;
            } catch (l unused) {
                i2++;
            }
        }
        throw i.a();
    }

    public void a() {
        for (p a2 : this.f123a) {
            a2.a();
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\k.java ==========

package a.a.a.e;

import a.a.a.b.a;
import a.a.a.c;
import a.a.a.d;
import a.a.a.e;
import a.a.a.f;
import a.a.a.i;
import a.a.a.l;
import a.a.a.m;
import a.a.a.n;
import a.a.a.o;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import net.fxgear.GlobalDefine;

/* compiled from: OneDReader */
public abstract class k implements a.a.a.k {
    public abstract m a(int i, a aVar, Map<e, ?> map) throws i, d, f;

    public void a() {
    }

    public m a(c cVar, Map<e, ?> map) throws i, f {
        try {
            return b(cVar, map);
        } catch (i e) {
            if (!(map != null && map.containsKey(e.TRY_HARDER)) || !cVar.d()) {
                throw e;
            }
            c e2 = cVar.e();
            m b2 = b(e2, map);
            Map<n, Object> e3 = b2.e();
            int i = 270;
            if (e3 != null && e3.containsKey(n.ORIENTATION)) {
                i = (((Integer) e3.get(n.ORIENTATION)).intValue() + 270) % 360;
            }
            b2.a(n.ORIENTATION, Integer.valueOf(i));
            o[] c = b2.c();
            if (c != null) {
                int b3 = e2.b();
                for (int i2 = 0; i2 < c.length; i2++) {
                    c[i2] = new o((((float) b3) - c[i2].b()) - 1.0f, c[i2].a());
                }
            }
            return b2;
        }
    }

    private m b(c cVar, Map<e, ?> map) throws i {
        int i;
        int i2;
        Map<e, ?> map2 = map;
        int a2 = cVar.a();
        int b2 = cVar.b();
        a aVar = new a(a2);
        int i3 = b2 >> 1;
        char c = 0;
        int i4 = 1;
        boolean z = map2 != null && map2.containsKey(e.TRY_HARDER);
        int max = Math.max(1, b2 >> (z ? 8 : 5));
        int i5 = z ? b2 : 15;
        EnumMap enumMap = map2;
        int i6 = 0;
        while (i6 < i5) {
            int i7 = i6 + 1;
            int i8 = i7 / 2;
            if (!((i6 & 1) == 0)) {
                i8 = -i8;
            }
            int i9 = (i8 * max) + i3;
            if (i9 < 0 || i9 >= b2) {
                break;
            }
            try {
                a a3 = cVar.a(i9, aVar);
                int i10 = 0;
                while (i10 < 2) {
                    if (i10 == i4) {
                        a3.d();
                        if (enumMap != null && enumMap.containsKey(e.NEED_RESULT_POINT_CALLBACK)) {
                            EnumMap enumMap2 = new EnumMap(e.class);
                            enumMap2.putAll(enumMap);
                            enumMap2.remove(e.NEED_RESULT_POINT_CALLBACK);
                            enumMap = enumMap2;
                        }
                    }
                    try {
                        m a4 = a(i9, a3, enumMap);
                        if (i10 == i4) {
                            a4.a(n.ORIENTATION, 180);
                            o[] c2 = a4.c();
                            if (c2 != null) {
                                float f = (float) a2;
                                i2 = a2;
                                try {
                                    c2[0] = new o((f - c2[c].a()) - 1.0f, c2[c].b());
                                    try {
                                        c2[1] = new o((f - c2[1].a()) - 1.0f, c2[1].b());
                                    } catch (l unused) {
                                        continue;
                                    }
                                } catch (l unused2) {
                                    i10++;
                                    a2 = i2;
                                    c cVar2 = cVar;
                                    c = 0;
                                    i4 = 1;
                                }
                            }
                        }
                        return a4;
                    } catch (l unused3) {
                        i2 = a2;
                        i10++;
                        a2 = i2;
                        c cVar22 = cVar;
                        c = 0;
                        i4 = 1;
                    }
                }
                i = a2;
                aVar = a3;
            } catch (i unused4) {
                i = a2;
            }
            i6 = i7;
            a2 = i;
            c = 0;
            i4 = 1;
        }
        throw i.a();
    }

    protected static void a(a aVar, int i, int[] iArr) throws i {
        int length = iArr.length;
        Arrays.fill(iArr, 0, length, 0);
        int a2 = aVar.a();
        if (i < a2) {
            boolean z = !aVar.a(i);
            int i2 = 0;
            while (i < a2) {
                if (!(aVar.a(i) ^ z)) {
                    i2++;
                    if (i2 == length) {
                        break;
                    }
                    iArr[i2] = 1;
                    z = !z;
                } else {
                    iArr[i2] = iArr[i2] + 1;
                }
                i++;
            }
            if (i2 == length) {
                return;
            }
            if (i2 != length - 1 || i != a2) {
                throw i.a();
            }
            return;
        }
        throw i.a();
    }

    protected static void b(a aVar, int i, int[] iArr) throws i {
        int length = iArr.length;
        boolean a2 = aVar.a(i);
        while (i > 0 && length >= 0) {
            i--;
            if (aVar.a(i) != a2) {
                length--;
                a2 = !a2;
            }
        }
        if (length < 0) {
            a(aVar, i + 1, iArr);
            return;
        }
        throw i.a();
    }

    protected static float a(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = (float) i;
        float f3 = f2 / ((float) i2);
        float f4 = f * f3;
        float f5 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f6 = ((float) iArr2[i4]) * f3;
            float f7 = (float) i5;
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\l.java ==========

package a.a.a.e;

import a.a.a.b.a;
import a.a.a.c;
import a.a.a.d;
import a.a.a.e;
import a.a.a.f;
import a.a.a.i;
import a.a.a.m;
import java.util.Map;

/* compiled from: UPCAReader */
public final class l extends p {

    /* renamed from: a  reason: collision with root package name */
    private final p f124a = new e();

    public m a(int i, a aVar, int[] iArr, Map<e, ?> map) throws i, f, d {
        return a(this.f124a.a(i, aVar, iArr, map));
    }

    public m a(int i, a aVar, Map<e, ?> map) throws i, f, d {
        return a(this.f124a.a(i, aVar, map));
    }

    public m a(c cVar, Map<e, ?> map) throws i, f {
        return a(this.f124a.a(cVar, map));
    }

    /* access modifiers changed from: package-private */
    public a.a.a.a b() {
        return a.a.a.a.UPC_A;
    }

    /* access modifiers changed from: protected */
    public int a(a aVar, int[] iArr, StringBuilder sb) throws i {
        return this.f124a.a(aVar, iArr, sb);
    }

    private static m a(m mVar) throws f {
        String a2 = mVar.a();
        if (a2.charAt(0) == '0') {
            return new m(a2.substring(1), (byte[]) null, mVar.c(), a.a.a.a.UPC_A);
        }
        throw f.a();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\m.java ==========

package a.a.a.e;

import a.a.a.b.a;
import a.a.a.i;
import a.a.a.n;
import a.a.a.o;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: UPCEANExtension2Support */
final class m {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f125a = new int[4];

    /* renamed from: b  reason: collision with root package name */
    private final StringBuilder f126b = new StringBuilder();

    m() {
    }

    /* access modifiers changed from: package-private */
    public a.a.a.m a(int i, a aVar, int[] iArr) throws i {
        StringBuilder sb = this.f126b;
        sb.setLength(0);
        int a2 = a(aVar, iArr, sb);
        String sb2 = sb.toString();
        Map<n, Object> a3 = a(sb2);
        float f = (float) i;
        a.a.a.m mVar = new a.a.a.m(sb2, (byte[]) null, new o[]{new o(((float) (iArr[0] + iArr[1])) / 2.0f, f), new o((float) a2, f)}, a.a.a.a.UPC_EAN_EXTENSION);
        if (a3 != null) {
            mVar.a(a3);
        }
        return mVar;
    }

    private int a(a aVar, int[] iArr, StringBuilder sb) throws i {
        int[] iArr2 = this.f125a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a2 = aVar.a();
        int i = iArr[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 2 && i < a2) {
            int a3 = p.a(aVar, iArr2, i, p.f);
            sb.append((char) ((a3 % 10) + 48));
            int i4 = i;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            if (a3 >= 10) {
                i3 = (1 << (1 - i2)) | i3;
            }
            i = i2 != 1 ? aVar.d(aVar.c(i4)) : i4;
            i2++;
        }
        if (sb.length() != 2) {
            throw i.a();
        } else if (Integer.parseInt(sb.toString()) % 4 == i3) {
            return i;
        } else {
            throw i.a();
        }
    }

    private static Map<n, Object> a(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(n.class);
        enumMap.put(n.ISSUE_NUMBER, Integer.valueOf(str));
        return enumMap;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\n.java ==========

package a.a.a.e;

import a.a.a.b.a;
import a.a.a.i;
import a.a.a.m;
import a.a.a.o;
import java.util.EnumMap;
import java.util.Map;
import net.fxgear.GlobalDefine;

/* compiled from: UPCEANExtension5Support */
final class n {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f127a = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* renamed from: b  reason: collision with root package name */
    private final int[] f128b = new int[4];
    private final StringBuilder c = new StringBuilder();

    n() {
    }

    /* access modifiers changed from: package-private */
    public m a(int i, a aVar, int[] iArr) throws i {
        StringBuilder sb = this.c;
        sb.setLength(0);
        int a2 = a(aVar, iArr, sb);
        String sb2 = sb.toString();
        Map<a.a.a.n, Object> a3 = a(sb2);
        float f = (float) i;
        m mVar = new m(sb2, (byte[]) null, new o[]{new o(((float) (iArr[0] + iArr[1])) / 2.0f, f), new o((float) a2, f)}, a.a.a.a.UPC_EAN_EXTENSION);
        if (a3 != null) {
            mVar.a(a3);
        }
        return mVar;
    }

    private int a(a aVar, int[] iArr, StringBuilder sb) throws i {
        int[] iArr2 = this.f128b;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a2 = aVar.a();
        int i = iArr[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 5 && i < a2) {
            int a3 = p.a(aVar, iArr2, i, p.f);
            sb.append((char) ((a3 % 10) + 48));
            int i4 = i;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            if (a3 >= 10) {
                i3 |= 1 << (4 - i2);
            }
            i = i2 != 4 ? aVar.d(aVar.c(i4)) : i4;
            i2++;
        }
        if (sb.length() == 5) {
            if (a((CharSequence) sb.toString()) == a(i3)) {
                return i;
            }
            throw i.a();
        }
        throw i.a();
    }

    private static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            i += charSequence.charAt(i2) - '0';
        }
        int i3 = i * 3;
        for (int i4 = length - 1; i4 >= 0; i4 -= 2) {
            i3 += charSequence.charAt(i4) - '0';
        }
        return (i3 * 3) % 10;
    }

    private static int a(int i) throws i {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == f127a[i2]) {
                return i2;
            }
        }
        throw i.a();
    }

    private static Map<a.a.a.n, Object> a(String str) {
        String b2;
        if (str.length() != 5 || (b2 = b(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(a.a.a.n.class);
        enumMap.put(a.a.a.n.SUGGESTED_PRICE, b2);
        return enumMap;
    }

    private static String b(String str) {
        String str2;
        String str3;
        char charAt = str.charAt(0);
        if (charAt == '0') {
            str2 = "£";
        } else if (charAt == '5') {
            str2 = "$";
        } else if (charAt != '9') {
            str2 = "";
        } else if ("90000".equals(str)) {
            return null;
        } else {
            if ("99991".equals(str)) {
                return "0.00";
            }
            if ("99990".equals(str)) {
                return "Used";
            }
            str2 = "";
        }
        int parseInt = Integer.parseInt(str.substring(1));
        String valueOf = String.valueOf(parseInt / 100);
        int i = parseInt % 100;
        if (i < 10) {
            str3 = GlobalDefine.REAL_VIDEO_NONE_DATE + i;
        } else {
            str3 = String.valueOf(i);
        }
        return str2 + valueOf + '.' + str3;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\o.java ==========

package a.a.a.e;

import a.a.a.b.a;
import a.a.a.i;
import a.a.a.l;
import a.a.a.m;

/* compiled from: UPCEANExtensionSupport */
final class o {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f129a = {1, 1, 2};

    /* renamed from: b  reason: collision with root package name */
    private final m f130b = new m();
    private final n c = new n();

    o() {
    }

    /* access modifiers changed from: package-private */
    public m a(int i, a aVar, int i2) throws i {
        int[] a2 = p.a(aVar, i2, false, f129a);
        try {
            return this.c.a(i, aVar, a2);
        } catch (l unused) {
            return this.f130b.a(i, aVar, a2);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\p.java ==========

package a.a.a.e;

import a.a.a.b.a;
import a.a.a.d;
import a.a.a.e;
import a.a.a.f;
import a.a.a.i;
import a.a.a.l;
import a.a.a.m;
import a.a.a.n;
import a.a.a.o;
import java.util.Arrays;
import java.util.Map;

/* compiled from: UPCEANReader */
public abstract class p extends k {

    /* renamed from: b  reason: collision with root package name */
    static final int[] f131b = {1, 1, 1};
    static final int[] c = {1, 1, 1, 1, 1};
    static final int[] d = {1, 1, 1, 1, 1, 1};
    static final int[][] e = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
    static final int[][] f = new int[20][];

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f132a = new StringBuilder(20);
    private final o g = new o();
    private final g h = new g();

    /* access modifiers changed from: protected */
    public abstract int a(a aVar, int[] iArr, StringBuilder sb) throws i;

    /* access modifiers changed from: package-private */
    public abstract a.a.a.a b();

    static {
        System.arraycopy(e, 0, f, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr = e[i - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr2[i2] = iArr[(iArr.length - i2) - 1];
            }
            f[i] = iArr2;
        }
    }

    protected p() {
    }

    static int[] a(a aVar) throws i {
        int[] iArr = new int[f131b.length];
        int[] iArr2 = null;
        boolean z = false;
        int i = 0;
        while (!z) {
            Arrays.fill(iArr, 0, f131b.length, 0);
            iArr2 = a(aVar, i, false, f131b, iArr);
            int i2 = iArr2[0];
            int i3 = iArr2[1];
            int i4 = i2 - (i3 - i2);
            if (i4 >= 0) {
                z = aVar.a(i4, i2, false);
            }
            i = i3;
        }
        return iArr2;
    }

    public m a(int i, a aVar, Map<e, ?> map) throws i, d, f {
        return a(i, aVar, a(aVar), map);
    }

    public m a(int i, a aVar, int[] iArr, Map<e, ?> map) throws i, d, f {
        a.a.a.p pVar;
        int i2;
        String a2;
        int[] iArr2 = null;
        if (map == null) {
            pVar = null;
        } else {
            pVar = (a.a.a.p) map.get(e.NEED_RESULT_POINT_CALLBACK);
        }
        boolean z = true;
        if (pVar != null) {
            pVar.a(new o(((float) (iArr[0] + iArr[1])) / 2.0f, (float) i));
        }
        StringBuilder sb = this.f132a;
        sb.setLength(0);
        int a3 = a(aVar, iArr, sb);
        if (pVar != null) {
            pVar.a(new o((float) a3, (float) i));
        }
        int[] a4 = a(aVar, a3);
        if (pVar != null) {
            pVar.a(new o(((float) (a4[0] + a4[1])) / 2.0f, (float) i));
        }
        int i3 = a4[1];
        int i4 = (i3 - a4[0]) + i3;
        if (i4 >= aVar.a() || !aVar.a(i3, i4, false)) {
            throw i.a();
        }
        String sb2 = sb.toString();
        if (sb2.length() < 8) {
            throw f.a();
        } else if (a(sb2)) {
            a.a.a.a b2 = b();
            float f2 = (float) i;
            m mVar = new m(sb2, (byte[]) null, new o[]{new o(((float) (iArr[1] + iArr[0])) / 2.0f, f2), new o(((float) (a4[1] + a4[0])) / 2.0f, f2)}, b2);
            try {
                m a5 = this.g.a(i, aVar, a4[1]);
                mVar.a(n.UPC_EAN_EXTENSION, a5.a());
                mVar.a(a5.e());
                mVar.a(a5.c());
                i2 = a5.a().length();
            } catch (l unused) {
                i2 = 0;
            }
            if (map != null) {
                iArr2 = (int[]) map.get(e.ALLOWED_EAN_EXTENSIONS);
            }
            if (iArr2 != null) {
                int length = iArr2.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        z = false;
                        break;
                    } else if (i2 == iArr2[i5]) {
                        break;
                    } else {
                        i5++;
                    }
                }
                if (!z) {
                    throw i.a();
                }
            }
            if ((b2 == a.a.a.a.EAN_13 || b2 == a.a.a.a.UPC_A) && (a2 = this.h.a(sb2)) != null) {
                mVar.a(n.POSSIBLE_COUNTRY, a2);
            }
            return mVar;
        } else {
            throw d.a();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str) throws f {
        return a((CharSequence) str);
    }

    static boolean a(CharSequence charSequence) throws f {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            int charAt = charSequence.charAt(i2) - '0';
            if (charAt < 0 || charAt > 9) {
                throw f.a();
            }
            i += charAt;
        }
        int i3 = i * 3;
        for (int i4 = length - 1; i4 >= 0; i4 -= 2) {
            int charAt2 = charSequence.charAt(i4) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw f.a();
            }
            i3 += charAt2;
        }
        if (i3 % 10 == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int[] a(a aVar, int i) throws i {
        return a(aVar, i, false, f131b);
    }

    static int[] a(a aVar, int i, boolean z, int[] iArr) throws i {
        return a(aVar, i, z, iArr, new int[iArr.length]);
    }

    private static int[] a(a aVar, int i, boolean z, int[] iArr, int[] iArr2) throws i {
        int a2 = aVar.a();
        int d2 = z ? aVar.d(i) : aVar.c(i);
        int length = iArr.length;
        int i2 = d2;
        int i3 = 0;
        while (d2 < a2) {
            boolean z2 = true;
            if (aVar.a(d2) ^ z) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                int i4 = length - 1;
                if (i3 != i4) {
                    i3++;
                } else if (a(iArr2, iArr, 0.7f) < 0.48f) {
                    return new int[]{i2, d2};
                } else {
                    i2 += iArr2[0] + iArr2[1];
                    int i5 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i4] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                if (z) {
                    z2 = false;
                }
                z = z2;
            }
            d2++;
        }
        throw i.a();
    }

    static int a(a aVar, int[] iArr, int i, int[][] iArr2) throws i {
        a(aVar, i, iArr);
        int length = iArr2.length;
        float f2 = 0.48f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float a2 = a(iArr, iArr2[i3], 0.7f);
            if (a2 < f2) {
                i2 = i3;
                f2 = a2;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw i.a();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\q.java ==========

package a.a.a.e;

import a.a.a.b.a;
import a.a.a.f;
import a.a.a.i;

/* compiled from: UPCEReader */
public final class q extends p {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f133a = {56, 52, 50, 49, 44, 38, 35, 42, 41, 37};
    private static final int[] g = {1, 1, 1, 1, 1, 1};
    private static final int[][] h = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
    private final int[] i = new int[4];

    /* access modifiers changed from: protected */
    public int a(a aVar, int[] iArr, StringBuilder sb) throws i {
        int[] iArr2 = this.i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a2 = aVar.a();
        int i2 = iArr[1];
        int i3 = 0;
        int i4 = 0;
        while (i3 < 6 && i2 < a2) {
            int a3 = a(aVar, iArr2, i2, f);
            sb.append((char) ((a3 % 10) + 48));
            int i5 = i2;
            for (int i6 : iArr2) {
                i5 += i6;
            }
            if (a3 >= 10) {
                i4 = (1 << (5 - i3)) | i4;
            }
            i3++;
            i2 = i5;
        }
        a(sb, i4);
        return i2;
    }

    /* access modifiers changed from: protected */
    public int[] a(a aVar, int i2) throws i {
        return a(aVar, i2, true, g);
    }

    /* access modifiers changed from: protected */
    public boolean a(String str) throws f {
        return super.a(b(str));
    }

    private static void a(StringBuilder sb, int i2) throws i {
        for (int i3 = 0; i3 <= 1; i3++) {
            for (int i4 = 0; i4 < 10; i4++) {
                if (i2 == h[i3][i4]) {
                    sb.insert(0, (char) (i3 + 48));
                    sb.append((char) (i4 + 48));
                    return;
                }
            }
        }
        throw i.a();
    }

    /* access modifiers changed from: package-private */
    public a.a.a.a b() {
        return a.a.a.a.UPC_E;
    }

    public static String b(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c = cArr[5];
        switch (c) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c);
                break;
        }
        sb.append(str.charAt(7));
        return sb.toString();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a.java ==========

package a.a.a.e.a;

import a.a.a.e.k;
import a.a.a.i;

/* compiled from: AbstractRSSReader */
public abstract class a extends k {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f75a = new int[4];

    /* renamed from: b  reason: collision with root package name */
    private final int[] f76b = new int[8];
    private final float[] c = new float[4];
    private final float[] d = new float[4];
    private final int[] e = new int[(this.f76b.length / 2)];
    private final int[] f = new int[(this.f76b.length / 2)];

    protected a() {
    }

    /* access modifiers changed from: protected */
    public final int[] b() {
        return this.f75a;
    }

    /* access modifiers changed from: protected */
    public final int[] c() {
        return this.f76b;
    }

    /* access modifiers changed from: protected */
    public final float[] d() {
        return this.c;
    }

    /* access modifiers changed from: protected */
    public final float[] e() {
        return this.d;
    }

    /* access modifiers changed from: protected */
    public final int[] f() {
        return this.e;
    }

    /* access modifiers changed from: protected */
    public final int[] g() {
        return this.f;
    }

    protected static int a(int[] iArr, int[][] iArr2) throws i {
        for (int i = 0; i < iArr2.length; i++) {
            if (a(iArr, iArr2[i], 0.45f) < 0.2f) {
                return i;
            }
        }
        throw i.a();
    }

    protected static void a(int[] iArr, float[] fArr) {
        float f2 = fArr[0];
        int i = 0;
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] > f2) {
                f2 = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    protected static void b(int[] iArr, float[] fArr) {
        float f2 = fArr[0];
        int i = 0;
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] < f2) {
                f2 = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    protected static boolean a(int[] iArr) {
        int i = iArr[0] + iArr[1];
        float f2 = ((float) i) / ((float) ((iArr[2] + i) + iArr[3]));
        if (f2 < 0.7916667f || f2 > 0.89285713f) {
            return false;
        }
        int i2 = Integer.MIN_VALUE;
        int i3 = Integer.MAX_VALUE;
        for (int i4 : iArr) {
            if (i4 > i2) {
                i2 = i4;
            }
            if (i4 < i3) {
                i3 = i4;
            }
        }
        return i2 < i3 * 10;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\b.java ==========

package a.a.a.e.a;

/* compiled from: DataCharacter */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f103a;

    /* renamed from: b  reason: collision with root package name */
    private final int f104b;

    public b(int i, int i2) {
        this.f103a = i;
        this.f104b = i2;
    }

    public final int a() {
        return this.f103a;
    }

    public final int b() {
        return this.f104b;
    }

    public final String toString() {
        return this.f103a + "(" + this.f104b + ')';
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f103a == bVar.f103a && this.f104b == bVar.f104b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f103a ^ this.f104b;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\c.java ==========

package a.a.a.e.a;

import a.a.a.o;

/* compiled from: FinderPattern */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final int f105a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f106b;
    private final o[] c;

    public c(int i, int[] iArr, int i2, int i3, int i4) {
        this.f105a = i;
        this.f106b = iArr;
        float f = (float) i4;
        this.c = new o[]{new o((float) i2, f), new o((float) i3, f)};
    }

    public int a() {
        return this.f105a;
    }

    public int[] b() {
        return this.f106b;
    }

    public o[] c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof c) && this.f105a == ((c) obj).f105a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f105a;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\d.java ==========

package a.a.a.e.a;

/* compiled from: Pair */
final class d extends b {

    /* renamed from: a  reason: collision with root package name */
    private final c f107a;

    /* renamed from: b  reason: collision with root package name */
    private int f108b;

    d(int i, int i2, c cVar) {
        super(i, i2);
        this.f107a = cVar;
    }

    /* access modifiers changed from: package-private */
    public c c() {
        return this.f107a;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f108b;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f108b++;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\e.java ==========

package a.a.a.e.a;

import a.a.a.b.a;
import a.a.a.i;
import a.a.a.m;
import a.a.a.o;
import a.a.a.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: RSS14Reader */
public final class e extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f109a = {1, 10, 34, 70, 126};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f110b = {4, 20, 48, 81};
    private static final int[] c = {0, 161, 961, 2015, 2715};
    private static final int[] d = {0, 336, 1036, 1516};
    private static final int[] e = {8, 6, 4, 3, 1};
    private static final int[] f = {2, 4, 6, 8};
    private static final int[][] g = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    private final List<d> h = new ArrayList();
    private final List<d> i = new ArrayList();

    public m a(int i2, a aVar, Map<a.a.a.e, ?> map) throws i {
        a((Collection<d>) this.h, a(aVar, false, i2, map));
        aVar.d();
        a((Collection<d>) this.i, a(aVar, true, i2, map));
        aVar.d();
        for (d next : this.h) {
            if (next.d() > 1) {
                for (d next2 : this.i) {
                    if (next2.d() > 1 && b(next, next2)) {
                        return a(next, next2);
                    }
                }
                continue;
            }
        }
        throw i.a();
    }

    private static void a(Collection<d> collection, d dVar) {
        if (dVar != null) {
            boolean z = false;
            Iterator<d> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d next = it.next();
                if (next.a() == dVar.a()) {
                    next.e();
                    z = true;
                    break;
                }
            }
            if (!z) {
                collection.add(dVar);
            }
        }
    }

    public void a() {
        this.h.clear();
        this.i.clear();
    }

    private static m a(d dVar, d dVar2) {
        String valueOf = String.valueOf((((long) dVar.a()) * 4537077) + ((long) dVar2.a()));
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - valueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(valueOf);
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int charAt = sb.charAt(i3) - '0';
            if ((i3 & 1) == 0) {
                charAt *= 3;
            }
            i2 += charAt;
        }
        int i4 = 10 - (i2 % 10);
        if (i4 == 10) {
            i4 = 0;
        }
        sb.append(i4);
        o[] c2 = dVar.c().c();
        o[] c3 = dVar2.c().c();
        return new m(String.valueOf(sb.toString()), (byte[]) null, new o[]{c2[0], c2[1], c3[0], c3[1]}, a.a.a.a.RSS_14);
    }

    private static boolean b(d dVar, d dVar2) {
        int b2 = (dVar.b() + (dVar2.b() * 16)) % 79;
        int a2 = (dVar.c().a() * 9) + dVar2.c().a();
        if (a2 > 72) {
            a2--;
        }
        if (a2 > 8) {
            a2--;
        }
        return b2 == a2;
    }

    private d a(a aVar, boolean z, int i2, Map<a.a.a.e, ?> map) {
        p pVar;
        try {
            int[] a2 = a(aVar, 0, z);
            c a3 = a(aVar, i2, z, a2);
            if (map == null) {
                pVar = null;
            } else {
                pVar = (p) map.get(a.a.a.e.NEED_RESULT_POINT_CALLBACK);
            }
            if (pVar != null) {
                float f2 = ((float) (a2[0] + a2[1])) / 2.0f;
                if (z) {
                    f2 = ((float) (aVar.a() - 1)) - f2;
                }
                pVar.a(new o(f2, (float) i2));
            }
            b a4 = a(aVar, a3, true);
            b a5 = a(aVar, a3, false);
            return new d((a4.a() * 1597) + a5.a(), a4.b() + (a5.b() * 4), a3);
        } catch (i unused) {
            return null;
        }
    }

    private b a(a aVar, c cVar, boolean z) throws i {
        a aVar2 = aVar;
        boolean z2 = z;
        int[] c2 = c();
        c2[0] = 0;
        c2[1] = 0;
        c2[2] = 0;
        c2[3] = 0;
        c2[4] = 0;
        c2[5] = 0;
        c2[6] = 0;
        c2[7] = 0;
        if (z2) {
            b(aVar2, cVar.b()[0], c2);
        } else {
            a(aVar2, cVar.b()[1] + 1, c2);
            int i2 = 0;
            for (int length = c2.length - 1; i2 < length; length--) {
                int i3 = c2[i2];
                c2[i2] = c2[length];
                c2[length] = i3;
                i2++;
            }
        }
        int i4 = z2 ? 16 : 15;
        float a2 = ((float) a.a.a.b.a.a.a(c2)) / ((float) i4);
        int[] f2 = f();
        int[] g2 = g();
        float[] d2 = d();
        float[] e2 = e();
        for (int i5 = 0; i5 < c2.length; i5++) {
            float f3 = ((float) c2[i5]) / a2;
            int i6 = (int) (0.5f + f3);
            if (i6 <= 0) {
                i6 = 1;
            } else if (i6 > 8) {
                i6 = 8;
            }
            int i7 = i5 / 2;
            if ((i5 & 1) == 0) {
                f2[i7] = i6;
                d2[i7] = f3 - ((float) i6);
            } else {
                g2[i7] = i6;
                e2[i7] = f3 - ((float) i6);
            }
        }
        a(z2, i4);
        int i8 = 0;
        int i9 = 0;
        for (int length2 = f2.length - 1; length2 >= 0; length2--) {
            i8 = (i8 * 9) + f2[length2];
            i9 += f2[length2];
        }
        int i10 = 0;
        int i11 = 0;
        for (int length3 = g2.length - 1; length3 >= 0; length3--) {
            i10 = (i10 * 9) + g2[length3];
            i11 += g2[length3];
        }
        int i12 = i8 + (i10 * 3);
        if (z2) {
            if ((i9 & 1) != 0 || i9 > 12 || i9 < 4) {
                throw i.a();
            }
            int i13 = (12 - i9) / 2;
            int i14 = e[i13];
            return new b((f.a(f2, i14, false) * f109a[i13]) + f.a(g2, 9 - i14, true) + c[i13], i12);
        } else if ((i11 & 1) != 0 || i11 > 10 || i11 < 4) {
            throw i.a();
        } else {
            int i15 = (10 - i11) / 2;
            int i16 = f[i15];
            return new b((f.a(g2, 9 - i16, false) * f110b[i15]) + f.a(f2, i16, true) + d[i15], i12);
        }
    }

    private int[] a(a aVar, int i2, boolean z) throws i {
        int[] b2 = b();
        b2[0] = 0;
        b2[1] = 0;
        b2[2] = 0;
        b2[3] = 0;
        int a2 = aVar.a();
        boolean z2 = false;
        while (i2 < a2) {
            z2 = !aVar.a(i2);
            if (z == z2) {
                break;
            }
            i2++;
        }
        int i3 = i2;
        int i4 = 0;
        while (i2 < a2) {
            if (aVar.a(i2) ^ z2) {
                b2[i4] = b2[i4] + 1;
            } else {
                if (i4 != 3) {
                    i4++;
                } else if (a(b2)) {
                    return new int[]{i3, i2};
                } else {
                    i3 += b2[0] + b2[1];
                    b2[0] = b2[2];
                    b2[1] = b2[3];
                    b2[2] = 0;
                    b2[3] = 0;
                    i4--;
                }
                b2[i4] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw i.a();
    }

    private c a(a aVar, int i2, boolean z, int[] iArr) throws i {
        int i3;
        int i4;
        boolean a2 = aVar.a(iArr[0]);
        int i5 = iArr[0] - 1;
        while (i5 >= 0 && (aVar.a(i5) ^ a2)) {
            i5--;
        }
        int i6 = i5 + 1;
        int[] b2 = b();
        System.arraycopy(b2, 0, b2, 1, b2.length - 1);
        b2[0] = iArr[0] - i6;
        int a3 = a(b2, g);
        int i7 = iArr[1];
        if (z) {
            i3 = (aVar.a() - 1) - i7;
            i4 = (aVar.a() - 1) - i6;
        } else {
            i3 = i7;
            i4 = i6;
        }
        return new c(a3, new int[]{i6, iArr[1]}, i4, i3, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0047, code lost:
        if (r1 < 4) goto L_0x002d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(boolean r10, int r11) throws a.a.a.i {
        /*
            r9 = this;
            int[] r0 = r9.f()
            int r0 = a.a.a.b.a.a.a((int[]) r0)
            int[] r1 = r9.g()
            int r1 = a.a.a.b.a.a.a((int[]) r1)
            r2 = 4
            r3 = 0
            r4 = 1
            if (r10 == 0) goto L_0x0034
            r5 = 12
            if (r0 <= r5) goto L_0x001c
            r6 = 0
            r7 = 1
            goto L_0x0022
        L_0x001c:
            if (r0 >= r2) goto L_0x0020
            r6 = 1
            goto L_0x0021
        L_0x0020:
            r6 = 0
        L_0x0021:
            r7 = 0
        L_0x0022:
            if (r1 <= r5) goto L_0x0029
            r5 = r6
            r6 = r7
        L_0x0026:
            r2 = 0
            r7 = 1
            goto L_0x004a
        L_0x0029:
            if (r1 >= r2) goto L_0x002f
            r5 = r6
            r6 = r7
        L_0x002d:
            r2 = 1
            goto L_0x0032
        L_0x002f:
            r5 = r6
            r6 = r7
        L_0x0031:
            r2 = 0
        L_0x0032:
            r7 = 0
            goto L_0x004a
        L_0x0034:
            r5 = 11
            if (r0 <= r5) goto L_0x003b
            r5 = 0
            r6 = 1
            goto L_0x0042
        L_0x003b:
            r5 = 5
            if (r0 >= r5) goto L_0x0040
            r5 = 1
            goto L_0x0041
        L_0x0040:
            r5 = 0
        L_0x0041:
            r6 = 0
        L_0x0042:
            r7 = 10
            if (r1 <= r7) goto L_0x0047
            goto L_0x0026
        L_0x0047:
            if (r1 >= r2) goto L_0x0031
            goto L_0x002d
        L_0x004a:
            int r8 = r0 + r1
            int r8 = r8 - r11
            r11 = r0 & 1
            if (r11 != r10) goto L_0x0053
            r10 = 1
            goto L_0x0054
        L_0x0053:
            r10 = 0
        L_0x0054:
            r11 = r1 & 1
            if (r11 != r4) goto L_0x0059
            r3 = 1
        L_0x0059:
            if (r8 != r4) goto L_0x006f
            if (r10 == 0) goto L_0x0066
            if (r3 != 0) goto L_0x0061
        L_0x005f:
            r6 = 1
            goto L_0x0099
        L_0x0061:
            a.a.a.i r10 = a.a.a.i.a()
            throw r10
        L_0x0066:
            if (r3 == 0) goto L_0x006a
        L_0x0068:
            r7 = 1
            goto L_0x0099
        L_0x006a:
            a.a.a.i r10 = a.a.a.i.a()
            throw r10
        L_0x006f:
            r11 = -1
            if (r8 != r11) goto L_0x0086
            if (r10 == 0) goto L_0x007d
            if (r3 != 0) goto L_0x0078
            r5 = 1
            goto L_0x0099
        L_0x0078:
            a.a.a.i r10 = a.a.a.i.a()
            throw r10
        L_0x007d:
            if (r3 == 0) goto L_0x0081
            r2 = 1
            goto L_0x0099
        L_0x0081:
            a.a.a.i r10 = a.a.a.i.a()
            throw r10
        L_0x0086:
            if (r8 != 0) goto L_0x00e3
            if (r10 == 0) goto L_0x0097
            if (r3 == 0) goto L_0x0092
            if (r0 >= r1) goto L_0x0090
            r5 = 1
            goto L_0x0068
        L_0x0090:
            r2 = 1
            goto L_0x005f
        L_0x0092:
            a.a.a.i r10 = a.a.a.i.a()
            throw r10
        L_0x0097:
            if (r3 != 0) goto L_0x00de
        L_0x0099:
            if (r5 == 0) goto L_0x00ae
            if (r6 != 0) goto L_0x00a9
            int[] r10 = r9.f()
            float[] r11 = r9.d()
            a((int[]) r10, (float[]) r11)
            goto L_0x00ae
        L_0x00a9:
            a.a.a.i r10 = a.a.a.i.a()
            throw r10
        L_0x00ae:
            if (r6 == 0) goto L_0x00bb
            int[] r10 = r9.f()
            float[] r11 = r9.d()
            b(r10, r11)
        L_0x00bb:
            if (r2 == 0) goto L_0x00d0
            if (r7 != 0) goto L_0x00cb
            int[] r10 = r9.g()
            float[] r11 = r9.d()
            a((int[]) r10, (float[]) r11)
            goto L_0x00d0
        L_0x00cb:
            a.a.a.i r10 = a.a.a.i.a()
            throw r10
        L_0x00d0:
            if (r7 == 0) goto L_0x00dd
            int[] r10 = r9.g()
            float[] r11 = r9.e()
            b(r10, r11)
        L_0x00dd:
            return
        L_0x00de:
            a.a.a.i r10 = a.a.a.i.a()
            throw r10
        L_0x00e3:
            a.a.a.i r10 = a.a.a.i.a()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.e.a.e.a(boolean, int):void");
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\f.java ==========

package a.a.a.e.a;

/* compiled from: RSSUtils */
public final class f {
    public static int a(int[] iArr, int i, boolean z) {
        int[] iArr2 = iArr;
        int i2 = i;
        int i3 = 0;
        for (int i4 : iArr2) {
            i3 += i4;
        }
        int length = iArr2.length;
        int i5 = i3;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = length - 1;
            if (i6 >= i9) {
                return i8;
            }
            int i10 = 1 << i6;
            int i11 = i7 | i10;
            int i12 = 1;
            while (i12 < iArr2[i6]) {
                int i13 = i5 - i12;
                int i14 = length - i6;
                int i15 = i14 - 2;
                int a2 = a(i13 - 1, i15);
                if (z && i11 == 0) {
                    int i16 = i14 - 1;
                    if (i13 - i16 >= i16) {
                        a2 -= a(i13 - i14, i15);
                    }
                }
                if (i14 - 1 > 1) {
                    int i17 = i13 - i15;
                    int i18 = 0;
                    while (i17 > i2) {
                        i18 += a((i13 - i17) - 1, i14 - 3);
                        i17--;
                        int[] iArr3 = iArr;
                    }
                    a2 -= i18 * (i9 - i6);
                } else if (i13 > i2) {
                    a2--;
                }
                i8 += a2;
                i12++;
                i11 &= i10 ^ -1;
                iArr2 = iArr;
            }
            i5 -= i12;
            i6++;
            i7 = i11;
            iArr2 = iArr;
        }
    }

    private static int a(int i, int i2) {
        int i3 = i - i2;
        if (i3 > i2) {
            int i4 = i3;
            i3 = i2;
            i2 = i4;
        }
        int i5 = 1;
        int i6 = 1;
        while (i > i2) {
            i5 *= i;
            if (i6 <= i3) {
                i5 /= i6;
                i6++;
            }
            i--;
        }
        while (i6 <= i3) {
            i5 /= i6;
            i6++;
        }
        return i5;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\a.java ==========

package a.a.a.e.a.a;

import java.util.List;

/* compiled from: BitArrayBuilder */
final class a {
    static a.a.a.b.a a(List<b> list) {
        int size = (list.size() << 1) - 1;
        if (list.get(list.size() - 1).b() == null) {
            size--;
        }
        a.a.a.b.a aVar = new a.a.a.b.a(size * 12);
        int a2 = list.get(0).b().a();
        int i = 0;
        for (int i2 = 11; i2 >= 0; i2--) {
            if (((1 << i2) & a2) != 0) {
                aVar.b(i);
            }
            i++;
        }
        for (int i3 = 1; i3 < list.size(); i3++) {
            b bVar = list.get(i3);
            int a3 = bVar.a().a();
            int i4 = i;
            for (int i5 = 11; i5 >= 0; i5--) {
                if (((1 << i5) & a3) != 0) {
                    aVar.b(i4);
                }
                i4++;
            }
            if (bVar.b() != null) {
                int a4 = bVar.b().a();
                for (int i6 = 11; i6 >= 0; i6--) {
                    if (((1 << i6) & a4) != 0) {
                        aVar.b(i4);
                    }
                    i4++;
                }
            }
            i = i4;
        }
        return aVar;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\b.java ==========

package a.a.a.e.a.a;

import a.a.a.e.a.c;

/* compiled from: ExpandedPair */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f97a;

    /* renamed from: b  reason: collision with root package name */
    private final a.a.a.e.a.b f98b;
    private final a.a.a.e.a.b c;
    private final c d;

    b(a.a.a.e.a.b bVar, a.a.a.e.a.b bVar2, c cVar, boolean z) {
        this.f98b = bVar;
        this.c = bVar2;
        this.d = cVar;
        this.f97a = z;
    }

    /* access modifiers changed from: package-private */
    public a.a.a.e.a.b a() {
        return this.f98b;
    }

    /* access modifiers changed from: package-private */
    public a.a.a.e.a.b b() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public c c() {
        return this.d;
    }

    public boolean d() {
        return this.c == null;
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.f98b);
        sb.append(" , ");
        sb.append(this.c);
        sb.append(" : ");
        if (this.d == null) {
            obj = "null";
        } else {
            obj = Integer.valueOf(this.d.a());
        }
        sb.append(obj);
        sb.append(" ]");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!a(this.f98b, bVar.f98b) || !a(this.c, bVar.c) || !a(this.d, bVar.d)) {
            return false;
        }
        return true;
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public int hashCode() {
        return (a(this.f98b) ^ a(this.c)) ^ a(this.d);
    }

    private static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\c.java ==========

package a.a.a.e.a.a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ExpandedRow */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private final List<b> f99a;

    /* renamed from: b  reason: collision with root package name */
    private final int f100b;
    private final boolean c;

    c(List<b> list, int i, boolean z) {
        this.f99a = new ArrayList(list);
        this.f100b = i;
        this.c = z;
    }

    /* access modifiers changed from: package-private */
    public List<b> a() {
        return this.f99a;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f100b;
    }

    /* access modifiers changed from: package-private */
    public boolean a(List<b> list) {
        return this.f99a.equals(list);
    }

    public String toString() {
        return "{ " + this.f99a + " }";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!this.f99a.equals(cVar.a()) || this.c != cVar.c) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f99a.hashCode() ^ Boolean.valueOf(this.c).hashCode();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\d.java ==========

package a.a.a.e.a.a;

import a.a.a.e;
import a.a.a.e.a.a;
import a.a.a.e.a.a.a.j;
import a.a.a.e.a.b;
import a.a.a.e.a.c;
import a.a.a.f;
import a.a.a.i;
import a.a.a.m;
import a.a.a.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: RSSExpandedReader */
public final class d extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f101a = {7, 5, 4, 3, 1};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f102b = {4, 20, 52, 104, 204};
    private static final int[] c = {0, 348, 1388, 2948, 3988};
    private static final int[][] d = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] e = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};
    private static final int[][] f = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    private final List<b> g = new ArrayList(11);
    private final List<c> h = new ArrayList();
    private final int[] i = new int[2];
    private boolean j;

    public m a(int i2, a.a.a.b.a aVar, Map<e, ?> map) throws i, f {
        this.g.clear();
        this.j = false;
        try {
            return a(a(i2, aVar));
        } catch (i unused) {
            this.g.clear();
            this.j = true;
            return a(a(i2, aVar));
        }
    }

    public void a() {
        this.g.clear();
        this.h.clear();
    }

    /* access modifiers changed from: package-private */
    public List<b> a(int i2, a.a.a.b.a aVar) throws i {
        while (true) {
            try {
                this.g.add(a(aVar, this.g, i2));
            } catch (i e2) {
                if (this.g.isEmpty()) {
                    throw e2;
                } else if (h()) {
                    return this.g;
                } else {
                    boolean z = !this.h.isEmpty();
                    a(i2, false);
                    if (z) {
                        List<b> a2 = a(false);
                        if (a2 != null) {
                            return a2;
                        }
                        List<b> a3 = a(true);
                        if (a3 != null) {
                            return a3;
                        }
                    }
                    throw i.a();
                }
            }
        }
    }

    private List<b> a(boolean z) {
        List<b> list;
        if (this.h.size() > 25) {
            this.h.clear();
            return null;
        }
        this.g.clear();
        if (z) {
            Collections.reverse(this.h);
        }
        try {
            list = a((List<c>) new ArrayList(), 0);
        } catch (i unused) {
            list = null;
        }
        if (z) {
            Collections.reverse(this.h);
        }
        return list;
    }

    private List<b> a(List<c> list, int i2) throws i {
        while (i2 < this.h.size()) {
            c cVar = this.h.get(i2);
            this.g.clear();
            for (c a2 : list) {
                this.g.addAll(a2.a());
            }
            this.g.addAll(cVar.a());
            if (!b(this.g)) {
                i2++;
            } else if (h()) {
                return this.g;
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(cVar);
                try {
                    return a((List<c>) arrayList, i2 + 1);
                } catch (i unused) {
                }
            }
        }
        throw i.a();
    }

    private static boolean b(List<b> list) {
        boolean z;
        for (int[] iArr : f) {
            if (list.size() <= iArr.length) {
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        z = true;
                        break;
                    } else if (list.get(i2).c().a() != iArr[i2]) {
                        z = false;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(int i2, boolean z) {
        boolean z2 = false;
        int i3 = 0;
        boolean z3 = false;
        while (true) {
            if (i3 >= this.h.size()) {
                break;
            }
            c cVar = this.h.get(i3);
            if (cVar.b() > i2) {
                z2 = cVar.a(this.g);
                break;
            } else {
                z3 = cVar.a(this.g);
                i3++;
            }
        }
        if (!z2 && !z3 && !a((Iterable<b>) this.g, (Iterable<c>) this.h)) {
            this.h.add(i3, new c(this.g, i2, z));
            a(this.g, this.h);
        }
    }

    private static void a(List<b> list, List<c> list2) {
        boolean z;
        Iterator<c> it = list2.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.a().size() != list.size()) {
                Iterator<b> it2 = next.a().iterator();
                while (true) {
                    z = false;
                    boolean z2 = true;
                    if (!it2.hasNext()) {
                        z = true;
                        break;
                    }
                    b next2 = it2.next();
                    Iterator<b> it3 = list.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (next2.equals(it3.next())) {
                                continue;
                                break;
                            }
                        } else {
                            z2 = false;
                            continue;
                            break;
                        }
                    }
                    if (!z2) {
                        break;
                    }
                }
                if (z) {
                    it.remove();
                }
            }
        }
    }

    private static boolean a(Iterable<b> iterable, Iterable<c> iterable2) {
        boolean z;
        boolean z2;
        Iterator<c> it = iterable2.iterator();
        do {
            z = false;
            if (it.hasNext()) {
                c next = it.next();
                Iterator<b> it2 = iterable.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = true;
                        continue;
                        break;
                    }
                    b next2 = it2.next();
                    Iterator<b> it3 = next.a().iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (next2.equals(it3.next())) {
                                z2 = true;
                                continue;
                                break;
                            }
                        } else {
                            z2 = false;
                            continue;
                            break;
                        }
                    }
                    if (!z2) {
                        continue;
                        break;
                    }
                }
            } else {
                return false;
            }
        } while (!z);
        return true;
    }

    static m a(List<b> list) throws i, f {
        String a2 = j.a(a.a(list)).a();
        o[] c2 = list.get(0).c().c();
        o[] c3 = list.get(list.size() - 1).c().c();
        return new m(a2, (byte[]) null, new o[]{c2[0], c2[1], c3[0], c3[1]}, a.a.a.a.RSS_EXPANDED);
    }

    private boolean h() {
        b bVar = this.g.get(0);
        b a2 = bVar.a();
        b b2 = bVar.b();
        if (b2 == null) {
            return false;
        }
        int b3 = b2.b();
        int i2 = 2;
        for (int i3 = 1; i3 < this.g.size(); i3++) {
            b bVar2 = this.g.get(i3);
            b3 += bVar2.a().b();
            i2++;
            b b4 = bVar2.b();
            if (b4 != null) {
                b3 += b4.b();
                i2++;
            }
        }
        if (((i2 - 4) * 211) + (b3 % 211) == a2.a()) {
            return true;
        }
        return false;
    }

    private static int a(a.a.a.b.a aVar, int i2) {
        if (aVar.a(i2)) {
            return aVar.c(aVar.d(i2));
        }
        return aVar.d(aVar.c(i2));
    }

    /* access modifiers changed from: package-private */
    public b a(a.a.a.b.a aVar, List<b> list, int i2) throws i {
        c a2;
        b bVar;
        boolean z = list.size() % 2 == 0;
        if (this.j) {
            z = !z;
        }
        int i3 = -1;
        boolean z2 = true;
        do {
            b(aVar, list, i3);
            a2 = a(aVar, i2, z);
            if (a2 == null) {
                i3 = a(aVar, this.i[0]);
                continue;
            } else {
                z2 = false;
                continue;
            }
        } while (z2);
        b a3 = a(aVar, a2, z, true);
        if (list.isEmpty() || !list.get(list.size() - 1).d()) {
            try {
                bVar = a(aVar, a2, z, false);
            } catch (i unused) {
                bVar = null;
            }
            return new b(a3, bVar, a2, true);
        }
        throw i.a();
    }

    private void b(a.a.a.b.a aVar, List<b> list, int i2) throws i {
        int[] b2 = b();
        b2[0] = 0;
        b2[1] = 0;
        b2[2] = 0;
        b2[3] = 0;
        int a2 = aVar.a();
        if (i2 < 0) {
            if (list.isEmpty()) {
                i2 = 0;
            } else {
                i2 = list.get(list.size() - 1).c().b()[1];
            }
        }
        boolean z = list.size() % 2 != 0;
        if (this.j) {
            z = !z;
        }
        boolean z2 = false;
        while (i2 < a2) {
            z2 = !aVar.a(i2);
            if (!z2) {
                break;
            }
            i2++;
        }
        int i3 = i2;
        int i4 = 0;
        while (i2 < a2) {
            if (aVar.a(i2) ^ z2) {
                b2[i4] = b2[i4] + 1;
            } else {
                if (i4 == 3) {
                    if (z) {
                        b(b2);
                    }
                    if (a(b2)) {
                        this.i[0] = i3;
                        this.i[1] = i2;
                        return;
                    }
                    if (z) {
                        b(b2);
                    }
                    i3 += b2[0] + b2[1];
                    b2[0] = b2[2];
                    b2[1] = b2[3];
                    b2[2] = 0;
                    b2[3] = 0;
                    i4--;
                } else {
                    i4++;
                }
                b2[i4] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw i.a();
    }

    private static void b(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length / 2; i2++) {
            int i3 = iArr[i2];
            int i4 = (length - i2) - 1;
            iArr[i2] = iArr[i4];
            iArr[i4] = i3;
        }
    }

    private c a(a.a.a.b.a aVar, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        if (z) {
            int i6 = this.i[0] - 1;
            while (i6 >= 0 && !aVar.a(i6)) {
                i6--;
            }
            i3 = i6 + 1;
            i4 = this.i[0] - i3;
            i5 = this.i[1];
        } else {
            i3 = this.i[0];
            i5 = aVar.d(this.i[1] + 1);
            i4 = i5 - this.i[1];
        }
        int i7 = i3;
        int i8 = i5;
        int[] b2 = b();
        System.arraycopy(b2, 0, b2, 1, b2.length - 1);
        b2[0] = i4;
        try {
            return new c(a(b2, d), new int[]{i7, i8}, i7, i8, i2);
        } catch (i unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public b a(a.a.a.b.a aVar, c cVar, boolean z, boolean z2) throws i {
        a.a.a.b.a aVar2 = aVar;
        int[] c2 = c();
        c2[0] = 0;
        c2[1] = 0;
        c2[2] = 0;
        c2[3] = 0;
        c2[4] = 0;
        c2[5] = 0;
        c2[6] = 0;
        c2[7] = 0;
        if (z2) {
            b(aVar2, cVar.b()[0], c2);
        } else {
            a(aVar2, cVar.b()[1], c2);
            int i2 = 0;
            for (int length = c2.length - 1; i2 < length; length--) {
                int i3 = c2[i2];
                c2[i2] = c2[length];
                c2[length] = i3;
                i2++;
            }
        }
        float a2 = ((float) a.a.a.b.a.a.a(c2)) / 17.0f;
        float f2 = ((float) (cVar.b()[1] - cVar.b()[0])) / 15.0f;
        if (Math.abs(a2 - f2) / f2 <= 0.3f) {
            int[] f3 = f();
            int[] g2 = g();
            float[] d2 = d();
            float[] e2 = e();
            for (int i4 = 0; i4 < c2.length; i4++) {
                float f4 = (((float) c2[i4]) * 1.0f) / a2;
                int i5 = (int) (0.5f + f4);
                if (i5 <= 0) {
                    if (f4 >= 0.3f) {
                        i5 = 1;
                    } else {
                        throw i.a();
                    }
                } else if (i5 > 8) {
                    if (f4 <= 8.7f) {
                        i5 = 8;
                    } else {
                        throw i.a();
                    }
                }
                int i6 = i4 / 2;
                if ((i4 & 1) == 0) {
                    f3[i6] = i5;
                    d2[i6] = f4 - ((float) i5);
                } else {
                    g2[i6] = i5;
                    e2[i6] = f4 - ((float) i5);
                }
            }
            a(17);
            int a3 = (((cVar.a() * 4) + (z ? 0 : 2)) + (z2 ^ true ? 1 : 0)) - 1;
            int i7 = 0;
            int i8 = 0;
            for (int length2 = f3.length - 1; length2 >= 0; length2--) {
                if (a(cVar, z, z2)) {
                    i7 += f3[length2] * e[a3][length2 * 2];
                }
                i8 += f3[length2];
            }
            int i9 = 0;
            for (int length3 = g2.length - 1; length3 >= 0; length3--) {
                if (a(cVar, z, z2)) {
                    i9 += g2[length3] * e[a3][(length3 * 2) + 1];
                }
            }
            int i10 = i7 + i9;
            if ((i8 & 1) != 0 || i8 > 13 || i8 < 4) {
                throw i.a();
            }
            int i11 = (13 - i8) / 2;
            int i12 = f101a[i11];
            return new b((a.a.a.e.a.f.a(f3, i12, true) * f102b[i11]) + a.a.a.e.a.f.a(g2, 9 - i12, false) + c[i11], i10);
        }
        throw i.a();
    }

    private static boolean a(c cVar, boolean z, boolean z2) {
        return cVar.a() != 0 || !z || !z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r11) throws a.a.a.i {
        /*
            r10 = this;
            int[] r0 = r10.f()
            int r0 = a.a.a.b.a.a.a((int[]) r0)
            int[] r1 = r10.g()
            int r1 = a.a.a.b.a.a.a((int[]) r1)
            r2 = 4
            r3 = 13
            r4 = 0
            r5 = 1
            if (r0 <= r3) goto L_0x001a
            r6 = 1
        L_0x0018:
            r7 = 0
            goto L_0x0021
        L_0x001a:
            if (r0 >= r2) goto L_0x001f
            r6 = 0
            r7 = 1
            goto L_0x0021
        L_0x001f:
            r6 = 0
            goto L_0x0018
        L_0x0021:
            if (r1 <= r3) goto L_0x0026
            r2 = 0
            r3 = 1
            goto L_0x002c
        L_0x0026:
            if (r1 >= r2) goto L_0x002a
            r2 = 1
            goto L_0x002b
        L_0x002a:
            r2 = 0
        L_0x002b:
            r3 = 0
        L_0x002c:
            int r8 = r0 + r1
            int r8 = r8 - r11
            r11 = r0 & 1
            if (r11 != r5) goto L_0x0035
            r11 = 1
            goto L_0x0036
        L_0x0035:
            r11 = 0
        L_0x0036:
            r9 = r1 & 1
            if (r9 != 0) goto L_0x003b
            r4 = 1
        L_0x003b:
            if (r8 != r5) goto L_0x0051
            if (r11 == 0) goto L_0x0048
            if (r4 != 0) goto L_0x0043
        L_0x0041:
            r6 = 1
            goto L_0x007b
        L_0x0043:
            a.a.a.i r11 = a.a.a.i.a()
            throw r11
        L_0x0048:
            if (r4 == 0) goto L_0x004c
            r3 = 1
            goto L_0x007b
        L_0x004c:
            a.a.a.i r11 = a.a.a.i.a()
            throw r11
        L_0x0051:
            r9 = -1
            if (r8 != r9) goto L_0x0068
            if (r11 == 0) goto L_0x005f
            if (r4 != 0) goto L_0x005a
        L_0x0058:
            r7 = 1
            goto L_0x007b
        L_0x005a:
            a.a.a.i r11 = a.a.a.i.a()
            throw r11
        L_0x005f:
            if (r4 == 0) goto L_0x0063
            r2 = 1
            goto L_0x007b
        L_0x0063:
            a.a.a.i r11 = a.a.a.i.a()
            throw r11
        L_0x0068:
            if (r8 != 0) goto L_0x00c5
            if (r11 == 0) goto L_0x0079
            if (r4 == 0) goto L_0x0074
            if (r0 >= r1) goto L_0x0072
            r3 = 1
            goto L_0x0058
        L_0x0072:
            r2 = 1
            goto L_0x0041
        L_0x0074:
            a.a.a.i r11 = a.a.a.i.a()
            throw r11
        L_0x0079:
            if (r4 != 0) goto L_0x00c0
        L_0x007b:
            if (r7 == 0) goto L_0x0090
            if (r6 != 0) goto L_0x008b
            int[] r11 = r10.f()
            float[] r0 = r10.d()
            a((int[]) r11, (float[]) r0)
            goto L_0x0090
        L_0x008b:
            a.a.a.i r11 = a.a.a.i.a()
            throw r11
        L_0x0090:
            if (r6 == 0) goto L_0x009d
            int[] r11 = r10.f()
            float[] r0 = r10.d()
            b(r11, r0)
        L_0x009d:
            if (r2 == 0) goto L_0x00b2
            if (r3 != 0) goto L_0x00ad
            int[] r11 = r10.g()
            float[] r0 = r10.d()
            a((int[]) r11, (float[]) r0)
            goto L_0x00b2
        L_0x00ad:
            a.a.a.i r11 = a.a.a.i.a()
            throw r11
        L_0x00b2:
            if (r3 == 0) goto L_0x00bf
            int[] r11 = r10.g()
            float[] r0 = r10.e()
            b(r11, r0)
        L_0x00bf:
            return
        L_0x00c0:
            a.a.a.i r11 = a.a.a.i.a()
            throw r11
        L_0x00c5:
            a.a.a.i r11 = a.a.a.i.a()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.e.a.a.d.a(int):void");
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\a\a.java ==========

package a.a.a.e.a.a.a;

/* compiled from: AI013103decoder */
final class a extends f {
    /* access modifiers changed from: protected */
    public int a(int i) {
        return i;
    }

    a(a.a.a.b.a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: protected */
    public void a(StringBuilder sb, int i) {
        sb.append("(3103)");
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\a\b.java ==========

package a.a.a.e.a.a.a;

import a.a.a.b.a;

/* compiled from: AI01320xDecoder */
final class b extends f {
    /* access modifiers changed from: protected */
    public int a(int i) {
        return i < 10000 ? i : i - 10000;
    }

    b(a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: protected */
    public void a(StringBuilder sb, int i) {
        if (i < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\a\c.java ==========

package a.a.a.e.a.a.a;

import a.a.a.b.a;
import a.a.a.f;
import a.a.a.i;

/* compiled from: AI01392xDecoder */
final class c extends h {
    c(a aVar) {
        super(aVar);
    }

    public String a() throws i, f {
        if (b().a() >= 48) {
            StringBuilder sb = new StringBuilder();
            b(sb, 8);
            int a2 = c().a(48, 2);
            sb.append("(392");
            sb.append(a2);
            sb.append(')');
            sb.append(c().a(50, (String) null).a());
            return sb.toString();
        }
        throw i.a();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\a\d.java ==========

package a.a.a.e.a.a.a;

import a.a.a.b.a;
import a.a.a.f;
import a.a.a.i;

/* compiled from: AI01393xDecoder */
final class d extends h {
    d(a aVar) {
        super(aVar);
    }

    public String a() throws i, f {
        if (b().a() >= 48) {
            StringBuilder sb = new StringBuilder();
            b(sb, 8);
            int a2 = c().a(48, 2);
            sb.append("(393");
            sb.append(a2);
            sb.append(')');
            int a3 = c().a(50, 10);
            if (a3 / 100 == 0) {
                sb.append('0');
            }
            if (a3 / 10 == 0) {
                sb.append('0');
            }
            sb.append(a3);
            sb.append(c().a(60, (String) null).a());
            return sb.toString();
        }
        throw i.a();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\a\e.java ==========

package a.a.a.e.a.a.a;

import a.a.a.b.a;
import a.a.a.i;

/* compiled from: AI013x0x1xDecoder */
final class e extends i {

    /* renamed from: a  reason: collision with root package name */
    private final String f77a;

    /* renamed from: b  reason: collision with root package name */
    private final String f78b;

    e(a aVar, String str, String str2) {
        super(aVar);
        this.f77a = str2;
        this.f78b = str;
    }

    public String a() throws i {
        if (b().a() == 84) {
            StringBuilder sb = new StringBuilder();
            b(sb, 8);
            b(sb, 48, 20);
            c(sb, 68);
            return sb.toString();
        }
        throw i.a();
    }

    private void c(StringBuilder sb, int i) {
        int a2 = c().a(i, 16);
        if (a2 != 38400) {
            sb.append('(');
            sb.append(this.f77a);
            sb.append(')');
            int i2 = a2 % 32;
            int i3 = a2 / 32;
            int i4 = (i3 % 12) + 1;
            int i5 = i3 / 12;
            if (i5 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i5);
            if (i4 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i4);
            if (i2 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i2);
        }
    }

    /* access modifiers changed from: protected */
    public void a(StringBuilder sb, int i) {
        sb.append('(');
        sb.append(this.f78b);
        sb.append(i / 100000);
        sb.append(')');
    }

    /* access modifiers changed from: protected */
    public int a(int i) {
        return i % 100000;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\a\f.java ==========

package a.a.a.e.a.a.a;

import a.a.a.b.a;
import a.a.a.i;

/* compiled from: AI013x0xDecoder */
abstract class f extends i {
    f(a aVar) {
        super(aVar);
    }

    public String a() throws i {
        if (b().a() == 60) {
            StringBuilder sb = new StringBuilder();
            b(sb, 5);
            b(sb, 45, 15);
            return sb.toString();
        }
        throw i.a();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\a\g.java ==========

package a.a.a.e.a.a.a;

import a.a.a.b.a;
import a.a.a.f;
import a.a.a.i;

/* compiled from: AI01AndOtherAIs */
final class g extends h {
    g(a aVar) {
        super(aVar);
    }

    public String a() throws i, f {
        StringBuilder sb = new StringBuilder();
        sb.append("(01)");
        int length = sb.length();
        sb.append(c().a(4, 4));
        a(sb, 8, length);
        return c().a(sb, 48);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\a\h.java ==========

package a.a.a.e.a.a.a;

import a.a.a.b.a;

/* compiled from: AI01decoder */
abstract class h extends j {
    h(a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: package-private */
    public final void b(StringBuilder sb, int i) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        a(sb, i, length);
    }

    /* access modifiers changed from: package-private */
    public final void a(StringBuilder sb, int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            int a2 = c().a((i3 * 10) + i, 10);
            if (a2 / 100 == 0) {
                sb.append('0');
            }
            if (a2 / 10 == 0) {
                sb.append('0');
            }
            sb.append(a2);
        }
        a(sb, i2);
    }

    private static void a(StringBuilder sb, int i) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 13; i4++) {
            int charAt = sb.charAt(i4 + i) - '0';
            if ((i4 & 1) == 0) {
                charAt *= 3;
            }
            i3 += charAt;
        }
        int i5 = 10 - (i3 % 10);
        if (i5 != 10) {
            i2 = i5;
        }
        sb.append(i2);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\a\i.java ==========

package a.a.a.e.a.a.a;

import a.a.a.b.a;

/* compiled from: AI01weightDecoder */
abstract class i extends h {
    /* access modifiers changed from: protected */
    public abstract int a(int i);

    /* access modifiers changed from: protected */
    public abstract void a(StringBuilder sb, int i);

    i(a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: package-private */
    public final void b(StringBuilder sb, int i, int i2) {
        int a2 = c().a(i, i2);
        a(sb, a2);
        int a3 = a(a2);
        int i3 = 100000;
        for (int i4 = 0; i4 < 5; i4++) {
            if (a3 / i3 == 0) {
                sb.append('0');
            }
            i3 /= 10;
        }
        sb.append(a3);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\a\j.java ==========

package a.a.a.e.a.a.a;

import a.a.a.b.a;
import a.a.a.f;
import a.a.a.i;
import net.fxgear.GlobalDefine;

/* compiled from: AbstractExpandedDecoder */
public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    private final a f79a;

    /* renamed from: b  reason: collision with root package name */
    private final s f80b;

    public abstract String a() throws i, f;

    j(a aVar) {
        this.f79a = aVar;
        this.f80b = new s(aVar);
    }

    /* access modifiers changed from: protected */
    public final a b() {
        return this.f79a;
    }

    /* access modifiers changed from: protected */
    public final s c() {
        return this.f80b;
    }

    public static j a(a aVar) {
        if (aVar.a(1)) {
            return new g(aVar);
        }
        if (!aVar.a(2)) {
            return new k(aVar);
        }
        switch (s.a(aVar, 1, 4)) {
            case 4:
                return new a(aVar);
            case 5:
                return new b(aVar);
            default:
                switch (s.a(aVar, 1, 5)) {
                    case 12:
                        return new c(aVar);
                    case GlobalDefine.RESULT_CODE_ERROR_MALFORMEDURL /*13*/:
                        return new d(aVar);
                    default:
                        switch (s.a(aVar, 1, 7)) {
                            case 56:
                                return new e(aVar, "310", "11");
                            case 57:
                                return new e(aVar, "320", "11");
                            case 58:
                                return new e(aVar, "310", "13");
                            case 59:
                                return new e(aVar, "320", "13");
                            case 60:
                                return new e(aVar, "310", "15");
                            case 61:
                                return new e(aVar, "320", "15");
                            case 62:
                                return new e(aVar, "310", "17");
                            case 63:
                                return new e(aVar, "320", "17");
                            default:
                                throw new IllegalStateException("unknown decoder: " + aVar);
                        }
                }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\a\k.java ==========

package a.a.a.e.a.a.a;

import a.a.a.b.a;
import a.a.a.f;
import a.a.a.i;

/* compiled from: AnyAIDecoder */
final class k extends j {
    k(a aVar) {
        super(aVar);
    }

    public String a() throws i, f {
        return c().a(new StringBuilder(), 5);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\a\l.java ==========

package a.a.a.e.a.a.a;

/* compiled from: BlockParsedResult */
final class l {

    /* renamed from: a  reason: collision with root package name */
    private final o f81a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f82b;

    l(boolean z) {
        this((o) null, z);
    }

    l(o oVar, boolean z) {
        this.f82b = z;
        this.f81a = oVar;
    }

    /* access modifiers changed from: package-private */
    public o a() {
        return this.f81a;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f82b;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\a\m.java ==========

package a.a.a.e.a.a.a;

/* compiled from: CurrentParsingState */
final class m {

    /* renamed from: a  reason: collision with root package name */
    private int f83a = 0;

    /* renamed from: b  reason: collision with root package name */
    private a f84b = a.NUMERIC;

    /* compiled from: CurrentParsingState */
    private enum a {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    m() {
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f83a;
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        this.f83a = i;
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
        this.f83a += i;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f84b == a.ALPHA;
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f84b == a.ISO_IEC_646;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f84b = a.NUMERIC;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f84b = a.ALPHA;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f84b = a.ISO_IEC_646;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\a\n.java ==========

package a.a.a.e.a.a.a;

/* compiled from: DecodedChar */
final class n extends q {

    /* renamed from: a  reason: collision with root package name */
    private final char f87a;

    n(int i, char c) {
        super(i);
        this.f87a = c;
    }

    /* access modifiers changed from: package-private */
    public char a() {
        return this.f87a;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f87a == '$';
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\a\o.java ==========

package a.a.a.e.a.a.a;

/* compiled from: DecodedInformation */
final class o extends q {

    /* renamed from: a  reason: collision with root package name */
    private final String f88a;

    /* renamed from: b  reason: collision with root package name */
    private final int f89b;
    private final boolean c;

    o(int i, String str) {
        super(i);
        this.f88a = str;
        this.c = false;
        this.f89b = 0;
    }

    o(int i, String str, int i2) {
        super(i);
        this.c = true;
        this.f89b = i2;
        this.f88a = str;
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return this.f88a;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f89b;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\a\p.java ==========

package a.a.a.e.a.a.a;

import a.a.a.f;

/* compiled from: DecodedNumeric */
final class p extends q {

    /* renamed from: a  reason: collision with root package name */
    private final int f90a;

    /* renamed from: b  reason: collision with root package name */
    private final int f91b;

    p(int i, int i2, int i3) throws f {
        super(i);
        if (i2 < 0 || i2 > 10 || i3 < 0 || i3 > 10) {
            throw f.a();
        }
        this.f90a = i2;
        this.f91b = i3;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f90a;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f91b;
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f90a == 10;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f91b == 10;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\a\q.java ==========

package a.a.a.e.a.a.a;

/* compiled from: DecodedObject */
abstract class q {

    /* renamed from: a  reason: collision with root package name */
    private final int f92a;

    q(int i) {
        this.f92a = i;
    }

    /* access modifiers changed from: package-private */
    public final int e() {
        return this.f92a;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\a\r.java ==========

package a.a.a.e.a.a.a;

import a.a.a.i;

/* compiled from: FieldParser */
final class r {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f93a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static final Object[][] f94b = {new Object[]{"00", 18}, new Object[]{"01", 14}, new Object[]{"02", 14}, new Object[]{"10", f93a, 20}, new Object[]{"11", 6}, new Object[]{"12", 6}, new Object[]{"13", 6}, new Object[]{"15", 6}, new Object[]{"17", 6}, new Object[]{"20", 2}, new Object[]{"21", f93a, 20}, new Object[]{"22", f93a, 29}, new Object[]{"30", f93a, 8}, new Object[]{"37", f93a, 8}, new Object[]{"90", f93a, 30}, new Object[]{"91", f93a, 30}, new Object[]{"92", f93a, 30}, new Object[]{"93", f93a, 30}, new Object[]{"94", f93a, 30}, new Object[]{"95", f93a, 30}, new Object[]{"96", f93a, 30}, new Object[]{"97", f93a, 30}, new Object[]{"98", f93a, 30}, new Object[]{"99", f93a, 30}};
    private static final Object[][] c = {new Object[]{"240", f93a, 30}, new Object[]{"241", f93a, 30}, new Object[]{"242", f93a, 6}, new Object[]{"250", f93a, 30}, new Object[]{"251", f93a, 30}, new Object[]{"253", f93a, 17}, new Object[]{"254", f93a, 20}, new Object[]{"400", f93a, 30}, new Object[]{"401", f93a, 30}, new Object[]{"402", 17}, new Object[]{"403", f93a, 30}, new Object[]{"410", 13}, new Object[]{"411", 13}, new Object[]{"412", 13}, new Object[]{"413", 13}, new Object[]{"414", 13}, new Object[]{"420", f93a, 20}, new Object[]{"421", f93a, 15}, new Object[]{"422", 3}, new Object[]{"423", f93a, 15}, new Object[]{"424", 3}, new Object[]{"425", 3}, new Object[]{"426", 3}};
    private static final Object[][] d = {new Object[]{"310", 6}, new Object[]{"311", 6}, new Object[]{"312", 6}, new Object[]{"313", 6}, new Object[]{"314", 6}, new Object[]{"315", 6}, new Object[]{"316", 6}, new Object[]{"320", 6}, new Object[]{"321", 6}, new Object[]{"322", 6}, new Object[]{"323", 6}, new Object[]{"324", 6}, new Object[]{"325", 6}, new Object[]{"326", 6}, new Object[]{"327", 6}, new Object[]{"328", 6}, new Object[]{"329", 6}, new Object[]{"330", 6}, new Object[]{"331", 6}, new Object[]{"332", 6}, new Object[]{"333", 6}, new Object[]{"334", 6}, new Object[]{"335", 6}, new Object[]{"336", 6}, new Object[]{"340", 6}, new Object[]{"341", 6}, new Object[]{"342", 6}, new Object[]{"343", 6}, new Object[]{"344", 6}, new Object[]{"345", 6}, new Object[]{"346", 6}, new Object[]{"347", 6}, new Object[]{"348", 6}, new Object[]{"349", 6}, new Object[]{"350", 6}, new Object[]{"351", 6}, new Object[]{"352", 6}, new Object[]{"353", 6}, new Object[]{"354", 6}, new Object[]{"355", 6}, new Object[]{"356", 6}, new Object[]{"357", 6}, new Object[]{"360", 6}, new Object[]{"361", 6}, new Object[]{"362", 6}, new Object[]{"363", 6}, new Object[]{"364", 6}, new Object[]{"365", 6}, new Object[]{"366", 6}, new Object[]{"367", 6}, new Object[]{"368", 6}, new Object[]{"369", 6}, new Object[]{"390", f93a, 15}, new Object[]{"391", f93a, 18}, new Object[]{"392", f93a, 15}, new Object[]{"393", f93a, 18}, new Object[]{"703", f93a, 30}};
    private static final Object[][] e = {new Object[]{"7001", 13}, new Object[]{"7002", f93a, 30}, new Object[]{"7003", 10}, new Object[]{"8001", 14}, new Object[]{"8002", f93a, 20}, new Object[]{"8003", f93a, 30}, new Object[]{"8004", f93a, 30}, new Object[]{"8005", 6}, new Object[]{"8006", 18}, new Object[]{"8007", f93a, 30}, new Object[]{"8008", f93a, 12}, new Object[]{"8018", 18}, new Object[]{"8020", f93a, 25}, new Object[]{"8100", 6}, new Object[]{"8101", 10}, new Object[]{"8102", 2}, new Object[]{"8110", f93a, 70}, new Object[]{"8200", f93a, 70}};

    static String a(String str) throws i {
        if (str.isEmpty()) {
            return null;
        }
        if (str.length() >= 2) {
            String substring = str.substring(0, 2);
            Object[][] objArr = f94b;
            int length = objArr.length;
            int i = 0;
            while (i < length) {
                Object[] objArr2 = objArr[i];
                if (!objArr2[0].equals(substring)) {
                    i++;
                } else if (objArr2[1] == f93a) {
                    return b(2, ((Integer) objArr2[2]).intValue(), str);
                } else {
                    return a(2, ((Integer) objArr2[1]).intValue(), str);
                }
            }
            if (str.length() >= 3) {
                String substring2 = str.substring(0, 3);
                Object[][] objArr3 = c;
                int length2 = objArr3.length;
                int i2 = 0;
                while (i2 < length2) {
                    Object[] objArr4 = objArr3[i2];
                    if (!objArr4[0].equals(substring2)) {
                        i2++;
                    } else if (objArr4[1] == f93a) {
                        return b(3, ((Integer) objArr4[2]).intValue(), str);
                    } else {
                        return a(3, ((Integer) objArr4[1]).intValue(), str);
                    }
                }
                Object[][] objArr5 = d;
                int length3 = objArr5.length;
                int i3 = 0;
                while (i3 < length3) {
                    Object[] objArr6 = objArr5[i3];
                    if (!objArr6[0].equals(substring2)) {
                        i3++;
                    } else if (objArr6[1] == f93a) {
                        return b(4, ((Integer) objArr6[2]).intValue(), str);
                    } else {
                        return a(4, ((Integer) objArr6[1]).intValue(), str);
                    }
                }
                if (str.length() >= 4) {
                    String substring3 = str.substring(0, 4);
                    Object[][] objArr7 = e;
                    int length4 = objArr7.length;
                    int i4 = 0;
                    while (i4 < length4) {
                        Object[] objArr8 = objArr7[i4];
                        if (!objArr8[0].equals(substring3)) {
                            i4++;
                        } else if (objArr8[1] == f93a) {
                            return b(4, ((Integer) objArr8[2]).intValue(), str);
                        } else {
                            return a(4, ((Integer) objArr8[1]).intValue(), str);
                        }
                    }
                    throw i.a();
                }
                throw i.a();
            }
            throw i.a();
        }
        throw i.a();
    }

    private static String a(int i, int i2, String str) throws i {
        if (str.length() >= i) {
            String substring = str.substring(0, i);
            int i3 = i2 + i;
            if (str.length() >= i3) {
                String substring2 = str.substring(i, i3);
                String str2 = "(" + substring + ')' + substring2;
                String a2 = a(str.substring(i3));
                if (a2 == null) {
                    return str2;
                }
                return str2 + a2;
            }
            throw i.a();
        }
        throw i.a();
    }

    private static String b(int i, int i2, String str) throws i {
        String substring = str.substring(0, i);
        int i3 = i2 + i;
        if (str.length() < i3) {
            i3 = str.length();
        }
        String substring2 = str.substring(i, i3);
        String str2 = "(" + substring + ')' + substring2;
        String a2 = a(str.substring(i3));
        if (a2 == null) {
            return str2;
        }
        return str2 + a2;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\e\a\a\a\s.java ==========

package a.a.a.e.a.a.a;

import a.a.a.b.a;
import a.a.a.f;
import a.a.a.i;

/* compiled from: GeneralAppIdDecoder */
final class s {

    /* renamed from: a  reason: collision with root package name */
    private final a f95a;

    /* renamed from: b  reason: collision with root package name */
    private final m f96b = new m();
    private final StringBuilder c = new StringBuilder();

    s(a aVar) {
        this.f95a = aVar;
    }

    /* access modifiers changed from: package-private */
    public String a(StringBuilder sb, int i) throws i, f {
        String str = null;
        while (true) {
            o a2 = a(i, str);
            String a3 = r.a(a2.a());
            if (a3 != null) {
                sb.append(a3);
            }
            String valueOf = a2.b() ? String.valueOf(a2.c()) : null;
            if (i == a2.e()) {
                return sb.toString();
            }
            i = a2.e();
            str = valueOf;
        }
    }

    private boolean a(int i) {
        if (i + 7 <= this.f95a.a()) {
            int i2 = i;
            while (true) {
                int i3 = i + 3;
                if (i2 >= i3) {
                    return this.f95a.a(i3);
                }
                if (this.f95a.a(i2)) {
                    return true;
                }
                i2++;
            }
        } else if (i + 4 <= this.f95a.a()) {
            return true;
        } else {
            return false;
        }
    }

    private p b(int i) throws f {
        int i2 = i + 7;
        if (i2 > this.f95a.a()) {
            int a2 = a(i, 4);
            if (a2 == 0) {
                return new p(this.f95a.a(), 10, 10);
            }
            return new p(this.f95a.a(), a2 - 1, 10);
        }
        int a3 = a(i, 7) - 8;
        return new p(i2, a3 / 11, a3 % 11);
    }

    /* access modifiers changed from: package-private */
    public int a(int i, int i2) {
        return a(this.f95a, i, i2);
    }

    static int a(a aVar, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (aVar.a(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public o a(int i, String str) throws f {
        this.c.setLength(0);
        if (str != null) {
            this.c.append(str);
        }
        this.f96b.a(i);
        o a2 = a();
        if (a2 == null || !a2.b()) {
            return new o(this.f96b.a(), this.c.toString());
        }
        return new o(this.f96b.a(), this.c.toString(), a2.c());
    }

    private o a() throws f {
        boolean z;
        l lVar;
        do {
            int a2 = this.f96b.a();
            if (this.f96b.b()) {
                lVar = d();
                z = lVar.b();
            } else if (this.f96b.c()) {
                lVar = c();
                z = lVar.b();
            } else {
                lVar = b();
                z = lVar.b();
            }
            if (!(a2 != this.f96b.a()) && !z) {
                break;
            }
        } while (!z);
        return lVar.a();
    }

    private l b() throws f {
        o oVar;
        while (a(this.f96b.a())) {
            p b2 = b(this.f96b.a());
            this.f96b.a(b2.e());
            if (b2.c()) {
                if (b2.d()) {
                    oVar = new o(this.f96b.a(), this.c.toString());
                } else {
                    oVar = new o(this.f96b.a(), this.c.toString(), b2.b());
                }
                return new l(oVar, true);
            }
            this.c.append(b2.a());
            if (b2.d()) {
                return new l(new o(this.f96b.a(), this.c.toString()), true);
            }
            this.c.append(b2.b());
        }
        if (i(this.f96b.a())) {
            this.f96b.e();
            this.f96b.b(4);
        }
        return new l(false);
    }

    private l c() throws f {
        while (c(this.f96b.a())) {
            n d = d(this.f96b.a());
            this.f96b.a(d.e());
            if (d.b()) {
                return new l(new o(this.f96b.a(), this.c.toString()), true);
            }
            this.c.append(d.a());
        }
        if (h(this.f96b.a())) {
            this.f96b.b(3);
            this.f96b.d();
        } else if (g(this.f96b.a())) {
            if (this.f96b.a() + 5 < this.f95a.a()) {
                this.f96b.b(5);
            } else {
                this.f96b.a(this.f95a.a());
            }
            this.f96b.e();
        }
        return new l(false);
    }

    private l d() {
        while (e(this.f96b.a())) {
            n f = f(this.f96b.a());
            this.f96b.a(f.e());
            if (f.b()) {
                return new l(new o(this.f96b.a(), this.c.toString()), true);
            }
            this.c.append(f.a());
        }
        if (h(this.f96b.a())) {
            this.f96b.b(3);
            this.f96b.d();
        } else if (g(this.f96b.a())) {
            if (this.f96b.a() + 5 < this.f95a.a()) {
                this.f96b.b(5);
            } else {
                this.f96b.a(this.f95a.a());
            }
            this.f96b.f();
        }
        return new l(false);
    }

    private boolean c(int i) {
        int a2;
        if (i + 5 > this.f95a.a()) {
            return false;
        }
        int a3 = a(i, 5);
        if (a3 >= 5 && a3 < 16) {
            return true;
        }
        if (i + 7 > this.f95a.a()) {
            return false;
        }
        int a4 = a(i, 7);
        if (a4 >= 64 && a4 < 116) {
            return true;
        }
        if (i + 8 <= this.f95a.a() && (a2 = a(i, 8)) >= 232 && a2 < 253) {
            return true;
        }
        return false;
    }

    private n d(int i) throws f {
        char c2;
        int a2 = a(i, 5);
        if (a2 == 15) {
            return new n(i + 5, '$');
        }
        if (a2 >= 5 && a2 < 15) {
            return new n(i + 5, (char) ((a2 + 48) - 5));
        }
        int a3 = a(i, 7);
        if (a3 >= 64 && a3 < 90) {
            return new n(i + 7, (char) (a3 + 1));
        }
        if (a3 >= 90 && a3 < 116) {
            return new n(i + 7, (char) (a3 + 7));
        }
        switch (a(i, 8)) {
            case 232:
                c2 = '!';
                break;
            case 233:
                c2 = '\"';
                break;
            case 234:
                c2 = '%';
                break;
            case 235:
                c2 = '&';
                break;
            case 236:
                c2 = '\'';
                break;
            case 237:
                c2 = '(';
                break;
            case 238:
                c2 = ')';
                break;
            case 239:
                c2 = '*';
                break;
            case 240:
                c2 = '+';
                break;
            case 241:
                c2 = ',';
                break;
            case 242:
                c2 = '-';
                break;
            case 243:
                c2 = '.';
                break;
            case 244:
                c2 = '/';
                break;
            case 245:
                c2 = ':';
                break;
            case 246:
                c2 = ';';
                break;
            case 247:
                c2 = '<';
                break;
            case 248:
                c2 = '=';
                break;
            case 249:
                c2 = '>';
                break;
            case 250:
                c2 = '?';
                break;
            case 251:
                c2 = '_';
                break;
            case 252:
                c2 = ' ';
                break;
            default:
                throw f.a();
        }
        return new n(i + 8, c2);
    }

    private boolean e(int i) {
        int a2;
        if (i + 5 > this.f95a.a()) {
            return false;
        }
        int a3 = a(i, 5);
        if (a3 >= 5 && a3 < 16) {
            return true;
        }
        if (i + 6 <= this.f95a.a() && (a2 = a(i, 6)) >= 16 && a2 < 63) {
            return true;
        }
        return false;
    }

    private n f(int i) {
        char c2;
        int a2 = a(i, 5);
        if (a2 == 15) {
            return new n(i + 5, '$');
        }
        if (a2 >= 5 && a2 < 15) {
            return new n(i + 5, (char) ((a2 + 48) - 5));
        }
        int a3 = a(i, 6);
        if (a3 >= 32 && a3 < 58) {
            return new n(i + 6, (char) (a3 + 33));
        }
        switch (a3) {
            case 58:
                c2 = '*';
                break;
            case 59:
                c2 = ',';
                break;
            case 60:
                c2 = '-';
                break;
            case 61:
                c2 = '.';
                break;
            case 62:
                c2 = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + a3);
        }
        return new n(i + 6, c2);
    }

    private boolean g(int i) {
        int i2;
        if (i + 1 > this.f95a.a()) {
            return false;
        }
        int i3 = 0;
        while (i3 < 5 && (i2 = i3 + i) < this.f95a.a()) {
            if (i3 == 2) {
                if (!this.f95a.a(i + 2)) {
                    return false;
                }
            } else if (this.f95a.a(i2)) {
                return false;
            }
            i3++;
        }
        return true;
    }

    private boolean h(int i) {
        int i2 = i + 3;
        if (i2 > this.f95a.a()) {
            return false;
        }
        while (i < i2) {
            if (this.f95a.a(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean i(int i) {
        int i2;
        if (i + 1 > this.f95a.a()) {
            return false;
        }
        int i3 = 0;
        while (i3 < 4 && (i2 = i3 + i) < this.f95a.a()) {
            if (this.f95a.a(i2)) {
                return false;
            }
            i3++;
        }
        return true;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\f\a.java ==========

package a.a.a.f;

import java.util.Arrays;
import java.util.Collection;
import net.fxgear.GlobalDefine;
import net.fxgear.util.FXUtil;

/* compiled from: PDF417Common */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f134a = {66142, 66170, 66206, 66236, 66290, 66292, 66350, 66382, 66396, 66454, 66470, 66476, 66594, 66600, 66614, 66626, 66628, 66632, 66640, 66654, 66662, 66668, 66682, 66690, 66718, 66720, 66748, 66758, 66776, 66798, 66802, 66804, 66820, 66824, 66832, 66846, 66848, 66876, 66880, 66936, 66950, 66956, 66968, 66992, 67006, 67022, 67036, 67042, 67044, 67048, 67062, 67118, 67150, 67164, 67214, 67228, 67256, 67294, 67322, 67350, 67366, 67372, 67398, 67404, 67416, 67438, 67474, 67476, 67490, 67492, 67496, 67510, 67618, 67624, 67650, 67656, 67664, 67678, 67686, 67692, 67706, 67714, 67716, 67728, 67742, 67744, 67772, 67782, 67788, 67800, 67822, 67826, 67828, 67842, 67848, 67870, 67872, 67900, 67904, 67960, 67974, 67992, 68016, 68030, 68046, 68060, 68066, 68068, 68072, 68086, 68104, 68112, 68126, 68128, 68156, 68160, 68216, 68336, 68358, 68364, 68376, 68400, 68414, 68448, 68476, 68494, 68508, 68536, 68546, 68548, 68552, 68560, 68574, 68582, 68588, 68654, 68686, 68700, 68706, 68708, 68712, 68726, 68750, 68764, 68792, 68802, 68804, 68808, 68816, 68830, 68838, 68844, 68858, 68878, 68892, 68920, 68976, 68990, 68994, 68996, 69000, 69008, 69022, 69024, 69052, 69062, 69068, 69080, 69102, 69106, 69108, 69142, 69158, 69164, 69190, 69208, 69230, 69254, 69260, 69272, 69296, 69310, 69326, 69340, 69386, 69394, 69396, 69410, 69416, 69430, 69442, 69444, 69448, 69456, 69470, 69478, 69484, 69554, 69556, 69666, 69672, 69698, 69704, 69712, 69726, 69754, 69762, 69764, 69776, 69790, 69792, 69820, 69830, 69836, 69848, 69870, 69874, 69876, 69890, 69918, 69920, 69948, 69952, 70008, 70022, 70040, 70064, 70078, 70094, 70108, 70114, 70116, 70120, 70134, 70152, 70174, 70176, 70264, 70384, 70412, 70448, 70462, 70496, 70524, 70542, 70556, 70584, 70594, 70600, 70608, 70622, 70630, 70636, 70664, 70672, 70686, 70688, 70716, 70720, 70776, 70896, 71136, 71180, 71192, 71216, 71230, 71264, 71292, 71360, 71416, 71452, 71480, 71536, 71550, 71554, 71556, 71560, 71568, 71582, 71584, 71612, 71622, 71628, 71640, 71662, 71726, 71732, 71758, 71772, 71778, 71780, 71784, 71798, 71822, 71836, 71864, 71874, 71880, 71888, 71902, 71910, 71916, 71930, 71950, 71964, 71992, 72048, 72062, 72066, 72068, 72080, 72094, 72096, 72124, 72134, 72140, 72152, 72174, 72178, 72180, 72206, 72220, 72248, 72304, 72318, 72416, 72444, 72456, 72464, 72478, 72480, 72508, 72512, 72568, 72588, 72600, 72624, 72638, 72654, 72668, 72674, 72676, 72680, 72694, 72726, 72742, 72748, 72774, 72780, 72792, 72814, 72838, 72856, 72880, 72894, 72910, 72924, 72930, 72932, 72936, 72950, 72966, 72972, 72984, 73008, 73022, 73056, 73084, 73102, 73116, 73144, 73156, 73160, 73168, 73182, 73190, 73196, 73210, 73226, 73234, 73236, 73250, 73252, 73256, 73270, 73282, 73284, 73296, 73310, 73318, 73324, 73346, 73348, 73352, 73360, 73374, 73376, 73404, 73414, 73420, 73432, 73454, 73498, 73518, 73522, 73524, 73550, 73564, 73570, 73572, 73576, 73590, 73800, 73822, 73858, 73860, 73872, 73886, 73888, 73916, 73944, 73970, 73972, 73992, 74014, 74016, 74044, 74048, 74104, 74118, 74136, 74160, 74174, 74210, 74212, 74216, 74230, 74244, 74256, 74270, 74272, 74360, 74480, 74502, 74508, 74544, 74558, 74592, 74620, 74638, 74652, 74680, 74690, 74696, 74704, 74726, 74732, 74782, 74784, 74812, 74992, 75232, 75288, 75326, 75360, 75388, 75456, 75512, 75576, 75632, 75646, 75650, 75652, 75664, 75678, 75680, 75708, 75718, 75724, 75736, 75758, 75808, 75836, 75840, 75896, 76016, 76256, 76736, 76824, 76848, 76862, 76896, 76924, 76992, 77048, 77296, 77340, 77368, 77424, 77438, 77536, 77564, 77572, 77576, 77584, 77600, 77628, 77632, 77688, 77702, 77708, 77720, 77744, 77758, 77774, 77788, 77870, 77902, 77916, 77922, 77928, 77966, 77980, 78008, 78018, 78024, 78032, 78046, 78060, 78074, 78094, 78136, 78192, 78206, 78210, 78212, 78224, 78238, 78240, 78268, 78278, 78284, 78296, 78322, 78324, 78350, 78364, 78448, 78462, 78560, 78588, 78600, 78622, 78624, 78652, 78656, 78712, 78726, 78744, 78768, 78782, 78798, 78812, 78818, 78820, 78824, 78838, 78862, 78876, 78904, 78960, 78974, 79072, 79100, 79296, 79352, 79368, 79376, 79390, 79392, 79420, 79424, 79480, 79600, 79628, 79640, 79664, 79678, 79712, 79740, 79772, 79800, 79810, 79812, 79816, 79824, 79838, 79846, 79852, 79894, 79910, 79916, 79942, 79948, 79960, 79982, 79988, 80006, 80024, 80048, 80062, 80078, 80092, 80098, 80100, 80104, 80134, 80140, 80176, 80190, 80224, 80252, 80270, 80284, 80312, 80328, 80336, 80350, 80358, 80364, 80378, 80390, 80396, 80408, 80432, 80446, 80480, 80508, 80576, 80632, 80654, 80668, 80696, 80752, 80766, 80776, 80784, 80798, 80800, 80828, 80844, 80856, 80878, 80882, 80884, 80914, 80916, 80930, 80932, 80936, 80950, 80962, 80968, 80976, 80990, 80998, 81004, 81026, 81028, 81040, 81054, 81056, 81084, 81094, 81100, 81112, 81134, 81154, 81156, 81160, 81168, 81182, 81184, 81212, 81216, 81272, 81286, 81292, 81304, 81328, 81342, 81358, 81372, 81380, 81384, 81398, 81434, 81454, 81458, 81460, 81486, 81500, 81506, 81508, 81512, 81526, 81550, 81564, 81592, 81602, 81604, 81608, 81616, 81630, 81638, 81644, 81702, 81708, 81722, 81734, 81740, 81752, 81774, 81778, 81780, 82050, 82078, 82080, 82108, 82180, 82184, 82192, 82206, 82208, 82236, 82240, 82296, 82316, 82328, 82352, 82366, 82402, 82404, 82408, 82440, 82448, 82462, 82464, 82492, 82496, 82552, 82672, 82694, 82700, 82712, 82736, 82750, 82784, 82812, 82830, 82882, 82884, 82888, 82896, 82918, 82924, 82952, 82960, 82974, 82976, 83004, 83008, 83064, 83184, 83424, 83468, 83480, 83504, 83518, 83552, 83580, 83648, 83704, 83740, 83768, 83824, 83838, 83842, 83844, 83848, 83856, 83872, 83900, 83910, 83916, 83928, 83950, 83984, 84000, 84028, 84032, 84088, 84208, 84448, 84928, 85040, 85054, 85088, 85116, 85184, 85240, 85488, 85560, 85616, 85630, 85728, 85756, 85764, 85768, 85776, 85790, 85792, 85820, 85824, 85880, 85894, 85900, 85912, 85936, 85966, 85980, 86048, 86080, 86136, 86256, 86496, 86976, 88160, 88188, 88256, 88312, 88560, 89056, 89200, 89214, 89312, 89340, 89536, 89592, 89608, 89616, 89632, 89664, 89720, 89840, 89868, 89880, 89904, 89952, 89980, 89998, 90012, 90040, 90190, 90204, 90254, 90268, 90296, 90306, 90308, 90312, 90334, 90382, 90396, 90424, 90480, 90494, 90500, 90504, 90512, 90526, 90528, 90556, 90566, 90572, 90584, 90610, 90612, 90638, 90652, 90680, 90736, 90750, 90848, 90876, 90884, 90888, 90896, 90910, 90912, 90940, 90944, 91000, 91014, 91020, 91032, 91056, 91070, 91086, 91100, 91106, 91108, 91112, 91126, 91150, 91164, 91192, 91248, 91262, 91360, 91388, 91584, 91640, 91664, 91678, 91680, 91708, 91712, 91768, 91888, 91928, 91952, 91966, 92000, 92028, 92046, 92060, 92088, 92098, 92100, 92104, 92112, 92126, 92134, 92140, 92188, 92216, 92272, 92384, 92412, 92608, 92664, 93168, 93200, 93214, 93216, 93244, 93248, 93304, 93424, 93664, 93720, 93744, 93758, 93792, 93820, 93888, 93944, 93980, 94008, 94064, 94078, 94084, 94088, 94096, 94110, 94112, 94140, 94150, 94156, 94168, 94246, 94252, 94278, 94284, 94296, 94318, 94342, 94348, 94360, 94384, 94398, 94414, 94428, 94440, 94470, 94476, 94488, 94512, 94526, 94560, 94588, 94606, 94620, 94648, 94658, 94660, 94664, 94672, 94686, 94694, 94700, 94714, 94726, 94732, 94744, 94768, 94782, 94816, 94844, 94912, 94968, 94990, 95004, 95032, 95088, 95102, 95112, 95120, 95134, 95136, 95164, 95180, 95192, 95214, 95218, 95220, 95244, 95256, 95280, 95294, 95328, 95356, 95424, 95480, 95728, 95758, 95772, 95800, 95856, 95870, 95968, 95996, 96008, 96016, 96030, 96032, 96060, 96064, 96120, 96152, 96176, 96190, 96220, 96226, 96228, 96232, 96290, 96292, 96296, 96310, 96322, 96324, 96328, 96336, 96350, 96358, 96364, 96386, 96388, 96392, 96400, 96414, 96416, 96444, 96454, 96460, 96472, 96494, 96498, 96500, 96514, 96516, 96520, 96528, 96542, 96544, 96572, 96576, 96632, 96646, 96652, 96664, 96688, 96702, 96718, 96732, 96738, 96740, 96744, 96758, 96772, 96776, 96784, 96798, 96800, 96828, 96832, 96888, 97008, 97030, 97036, 97048, 97072, 97086, 97120, 97148, 97166, 97180, 97208, 97220, 97224, 97232, 97246, 97254, 97260, 97326, 97330, 97332, 97358, 97372, 97378, 97380, 97384, 97398, 97422, 97436, 97464, 97474, 97476, 97480, 97488, 97502, 97510, 97516, 97550, 97564, 97592, 97648, 97666, 97668, 97672, 97680, 97694, 97696, 97724, 97734, 97740, 97752, 97774, 97830, 97836, 97850, 97862, 97868, 97880, 97902, 97906, 97908, 97926, 97932, 97944, 97968, 97998, 98012, 98018, 98020, 98024, 98038, 98618, 98674, 98676, 98838, 98854, 98874, 98892, 98904, 98926, 98930, 98932, 98968, 99006, 99042, 99044, 99048, 99062, 99166, 99194, 99246, 99286, 99350, 99366, 99372, 99386, 99398, 99416, 99438, 99442, 99444, 99462, 99504, 99518, 99534, 99548, 99554, 99556, 99560, 99574, 99590, 99596, 99608, 99632, 99646, 99680, 99708, 99726, 99740, 99768, 99778, 99780, 99784, 99792, 99806, 99814, 99820, 99834, 99858, 99860, 99874, 99880, 99894, 99906, 99920, 99934, 99962, 99970, 99972, 99976, 99984, 99998, 100000, 100028, 100038, 100044, 100056, 100078, 100082, 100084, 100142, 100174, 100188, 100246, 100262, 100268, 100306, 100308, 100390, 100396, 100410, 100422, 100428, 100440, 100462, 100466, 100468, 100486, 100504, 100528, 100542, 100558, 100572, 100578, 100580, 100584, 100598, 100620, 100656, 100670, 100704, 100732, 100750, 100792, 100802, 100808, 100816, 100830, 100838, 100844, 100858, 100888, 100912, 100926, 100960, 100988, 101056, 101112, 101148, 101176, 101232, 101246, 101250, 101252, 101256, 101264, 101278, 101280, 101308, 101318, 101324, 101336, 101358, 101362, 101364, 101410, 101412, 101416, 101430, 101442, 101448, 101456, 101470, 101478, 101498, 101506, 101508, 101520, 101534, 101536, 101564, 101580, 101618, 101620, 101636, 101640, 101648, 101662, 101664, 101692, 101696, 101752, 101766, 101784, 101838, 101858, 101860, 101864, 101934, 101938, 101940, 101966, 101980, 101986, 101988, 101992, 102030, 102044, 102072, 102082, 102084, 102088, 102096, 102138, 102166, 102182, 102188, 102214, 102220, 102232, 102254, 102282, 102290, 102292, 102306, 102308, 102312, 102326, 102444, 102458, 102470, 102476, 102488, 102514, 102516, 102534, 102552, 102576, 102590, 102606, 102620, 102626, 102632, 102646, 102662, 102668, 102704, 102718, 102752, 102780, 102798, 102812, 102840, 102850, 102856, 102864, 102878, 102886, 102892, 102906, 102936, 102974, 103008, 103036, 103104, 103160, 103224, 103280, 103294, 103298, 103300, 103312, 103326, 103328, 103356, 103366, 103372, 103384, 103406, 103410, 103412, 103472, 103486, 103520, 103548, 103616, 103672, 103920, 103992, 104048, 104062, 104160, 104188, 104194, 104196, 104200, 104208, 104224, 104252, 104256, 104312, 104326, 104332, 104344, 104368, 104382, 104398, 104412, 104418, 104420, 104424, 104482, 104484, 104514, 104520, 104528, 104542, 104550, 104570, 104578, 104580, 104592, 104606, 104608, 104636, 104652, 104690, 104692, 104706, 104712, 104734, 104736, 104764, 104768, 104824, 104838, 104856, 104910, 104930, 104932, 104936, 104968, 104976, 104990, 104992, 105020, 105024, 105080, 105200, 105240, 105278, 105312, 105372, 105410, 105412, 105416, 105424, 105446, 105518, 105524, 105550, 105564, 105570, 105572, 105576, 105614, 105628, 105656, 105666, 105672, 105680, 105702, 105722, 105742, 105756, 105784, 105840, 105854, 105858, 105860, 105864, 105872, 105888, 105932, 105970, 105972, 106006, 106022, 106028, 106054, 106060, 106072, 106100, 106118, 106124, 106136, 106160, 106174, 106190, 106210, 106212, 106216, 106250, 106258, 106260, 106274, 106276, 106280, 106306, 106308, 106312, 106320, 106334, 106348, 106394, 106414, 106418, 106420, 106566, 106572, 106610, 106612, 106630, 106636, 106648, 106672, 106686, 106722, 106724, 106728, 106742, 106758, 106764, 106776, 106800, 106814, 106848, 106876, 106894, 106908, 106936, 106946, 106948, 106952, 106960, 106974, 106982, 106988, 107032, 107056, 107070, 107104, 107132, 107200, 107256, 107292, 107320, 107376, 107390, 107394, 107396, 107400, 107408, 107422, 107424, 107452, 107462, 107468, 107480, 107502, 107506, 107508, 107544, 107568, 107582, 107616, 107644, 107712, 107768, 108016, 108060, 108088, 108144, 108158, 108256, 108284, 108290, 108292, 108296, 108304, 108318, 108320, 108348, 108352, 108408, 108422, 108428, 108440, 108464, 108478, 108494, 108508, 108514, 108516, 108520, 108592, 108640, 108668, 108736, 108792, 109040, 109536, 109680, 109694, 109792, 109820, 110016, 110072, 110084, 110088, 110096, 110112, 110140, 110144, 110200, 110320, 110342, 110348, 110360, 110384, 110398, 110432, 110460, 110478, 110492, 110520, 110532, 110536, 110544, 110558, 110658, 110686, 110714, 110722, 110724, 110728, 110736, 110750, 110752, 110780, 110796, 110834, 110836, 110850, 110852, 110856, 110864, 110878, 110880, 110908, 110912, 110968, 110982, 111000, 111054, 111074, 111076, 111080, 111108, 111112, 111120, 111134, 111136, 111164, 111168, 111224, 111344, 111372, 111422, 111456, 111516, 111554, 111556, 111560, 111568, 111590, 111632, 111646, 111648, 111676, 111680, 111736, 111856, 112096, 112152, 112224, 112252, 112320, 112440, 112514, 112516, 112520, 112528, 112542, 112544, 112588, 112686, 112718, 112732, 112782, 112796, 112824, 112834, 112836, 112840, 112848, 112870, 112890, 112910, 112924, 112952, 113008, 113022, 113026, 113028, 113032, 113040, 113054, 113056, 113100, 113138, 113140, 113166, 113180, 113208, 113264, 113278, 113376, 113404, 113416, 113424, 113440, 113468, 113472, 113560, 113614, 113634, 113636, 113640, 113686, 113702, 113708, 113734, 113740, 113752, 113778, 113780, 113798, 113804, 113816, 113840, 113854, 113870, 113890, 113892, 113896, 113926, 113932, 113944, 113968, 113982, 114016, 114044, 114076, 114114, 114116, 114120, 114128, 114150, 114170, 114194, 114196, 114210, 114212, 114216, 114242, 114244, 114248, 114256, 114270, 114278, 114306, 114308, 114312, 114320, 114334, 114336, 114364, 114380, 114420, 114458, 114478, 114482, 114484, 114510, 114524, 114530, 114532, 114536, 114842, 114866, 114868, 114970, 114994, 114996, 115042, 115044, 115048, 115062, 115130, 115226, 115250, 115252, 115278, 115292, 115298, 115300, 115304, 115318, 115342, 115394, 115396, 115400, 115408, 115422, 115430, 115436, 115450, 115478, 115494, 115514, 115526, 115532, 115570, 115572, 115738, 115758, 115762, 115764, 115790, 115804, 115810, 115812, 115816, 115830, 115854, 115868, 115896, 115906, 115912, 115920, 115934, 115942, 115948, 115962, 115996, 116024, 116080, 116094, 116098, 116100, 116104, 116112, 116126, 116128, 116156, 116166, 116172, 116184, 116206, 116210, 116212, 116246, 116262, 116268, 116282, 116294, 116300, 116312, 116334, 116338, 116340, 116358, 116364, 116376, 116400, 116414, 116430, 116444, 116450, 116452, 116456, 116498, 116500, 116514, 116520, 116534, 116546, 116548, 116552, 116560, 116574, 116582, 116588, 116602, 116654, 116694, 116714, 116762, 116782, 116786, 116788, 116814, 116828, 116834, 116836, 116840, 116854, 116878, 116892, 116920, 116930, 116936, 116944, 116958, 116966, 116972, 116986, 117006, 117048, 117104, 117118, 117122, 117124, 117136, 117150, 117152, 117180, 117190, 117196, 117208, 117230, 117234, 117236, 117304, 117360, 117374, 117472, 117500, 117506, 117508, 117512, 117520, 117536, 117564, 117568, 117624, 117638, 117644, 117656, 117680, 117694, 117710, 117724, 117730, 117732, 117736, 117750, 117782, 117798, 117804, 117818, 117830, 117848, 117874, 117876, 117894, 117936, 117950, 117966, 117986, 117988, 117992, 118022, 118028, 118040, 118064, 118078, 118112, 118140, 118172, 118210, 118212, 118216, 118224, 118238, 118246, 118266, 118306, 118312, 118338, 118352, 118366, 118374, 118394, 118402, 118404, 118408, 118416, 118430, 118432, 118460, 118476, 118514, 118516, 118574, 118578, 118580, 118606, 118620, 118626, 118628, 118632, 118678, 118694, 118700, 118730, 118738, 118740, 118830, 118834, 118836, 118862, 118876, 118882, 118884, 118888, 118902, 118926, 118940, 118968, 118978, 118980, 118984, 118992, 119006, 119014, 119020, 119034, 119068, 119096, 119152, 119166, 119170, 119172, 119176, 119184, 119198, 119200, 119228, 119238, 119244, 119256, 119278, 119282, 119284, 119324, 119352, 119408, 119422, 119520, 119548, 119554, 119556, 119560, 119568, 119582, 119584, 119612, 119616, 119672, 119686, 119692, 119704, 119728, 119742, 119758, 119772, 119778, 119780, 119784, 119798, 119920, 119934, 120032, 120060, 120256, 120312, 120324, 120328, 120336, 120352, 120384, 120440, 120560, 120582, 120588, 120600, 120624, 120638, 120672, 120700, 120718, 120732, 120760, 120770, 120772, 120776, 120784, 120798, 120806, 120812, 120870, 120876, 120890, 120902, 120908, 120920, 120946, 120948, 120966, 120972, 120984, 121008, 121022, 121038, 121058, 121060, 121064, 121078, 121100, 121112, 121136, 121150, 121184, 121212, 121244, 121282, 121284, 121288, 121296, 121318, 121338, 121356, 121368, 121392, 121406, 121440, 121468, 121536, 121592, 121656, 121730, 121732, 121736, 121744, 121758, 121760, 121804, 121842, 121844, 121890, 121922, 121924, 121928, 121936, 121950, 121958, 121978, 121986, 121988, 121992, 122000, 122014, 122016, 122044, 122060, 122098, 122100, 122116, 122120, 122128, 122142, 122144, 122172, 122176, 122232, 122246, 122264, 122318, 122338, 122340, 122344, 122414, 122418, 122420, 122446, 122460, 122466, 122468, 122472, 122510, 122524, 122552, 122562, 122564, 122568, 122576, 122598, 122618, 122646, 122662, 122668, 122694, 122700, 122712, 122738, 122740, 122762, 122770, 122772, 122786, 122788, 122792, 123018, 123026, 123028, 123042, 123044, 123048, 123062, 123098, 123146, 123154, 123156, 123170, 123172, 123176, 123190, 123202, 123204, 123208, 123216, 123238, 123244, 123258, 123290, 123314, 123316, 123402, 123410, 123412, 123426, 123428, 123432, 123446, 123458, 123464, 123472, 123486, 123494, 123500, 123514, 123522, 123524, 123528, 123536, 123552, 123580, 123590, 123596, 123608, 123630, 123634, 123636, 123674, 123698, 123700, 123740, 123746, 123748, 123752, 123834, 123914, 123922, 123924, 123938, 123944, 123958, 123970, 123976, 123984, 123998, 124006, 124012, 124026, 124034, 124036, 124048, 124062, 124064, 124092, 124102, 124108, 124120, 124142, 124146, 124148, 124162, 124164, 124168, 124176, 124190, 124192, 124220, 124224, 124280, 124294, 124300, 124312, 124336, 124350, 124366, 124380, 124386, 124388, 124392, 124406, 124442, 124462, 124466, 124468, 124494, 124508, 124514, 124520, 124558, 124572, 124600, 124610, 124612, 124616, 124624, 124646, 124666, 124694, 124710, 124716, 124730, 124742, 124748, 124760, 124786, 124788, 124818, 124820, 124834, 124836, 124840, 124854, 124946, 124948, 124962, 124964, 124968, 124982, 124994, 124996, 125000, 125008, 125022, 125030, 125036, 125050, 125058, 125060, 125064, 125072, 125086, 125088, 125116, 125126, 125132, 125144, 125166, 125170, 125172, 125186, 125188, 125192, 125200, 125216, 125244, 125248, 125304, 125318, 125324, 125336, 125360, 125374, 125390, 125404, 125410, 125412, 125416, 125430, 125444, 125448, 125456, 125472, 125504, 125560, 125680, 125702, 125708, 125720, 125744, 125758, 125792, 125820, 125838, 125852, 125880, 125890, 125892, 125896, 125904, 125918, 125926, 125932, 125978, 125998, 126002, 126004, 126030, 126044, 126050, 126052, 126056, 126094, 126108, 126136, 126146, 126148, 126152, 126160, 126182, 126202, 126222, 126236, 126264, 126320, 126334, 126338, 126340, 126344, 126352, 126366, 126368, 126412, 126450, 126452, 126486, 126502, 126508, 126522, 126534, 126540, 126552, 126574, 126578, 126580, 126598, 126604, 126616, 126640, 126654, 126670, 126684, 126690, 126692, 126696, 126738, 126754, 126756, 126760, 126774, 126786, 126788, 126792, 126800, 126814, 126822, 126828, 126842, 126894, 126898, 126900, 126934, 127126, 127142, 127148, 127162, 127178, 127186, 127188, 127254, 127270, 127276, 127290, 127302, 127308, 127320, 127342, 127346, 127348, 127370, 127378, 127380, 127394, 127396, 127400, 127450, 127510, 127526, 127532, 127546, 127558, 127576, 127598, 127602, 127604, 127622, 127628, 127640, 127664, 127678, 127694, 127708, 127714, 127716, 127720, 127734, 127754, 127762, 127764, 127778, 127784, 127810, 127812, 127816, 127824, 127838, 127846, 127866, 127898, 127918, 127922, 127924, 128022, 128038, 128044, 128058, 128070, 128076, 128088, 128110, 128114, 128116, 128134, 128140, 128152, 128176, 128190, 128206, 128220, 128226, 128228, 128232, 128246, 128262, 128268, 128280, 128304, 128318, 128352, 128380, 128398, 128412, 128440, 128450, 128452, 128456, 128464, 128478, 128486, 128492, 128506, 128522, 128530, 128532, 128546, 128548, 128552, 128566, 128578, 128580, 128584, 128592, 128606, 128614, 128634, 128642, 128644, 128648, 128656, 128670, 128672, 128700, 128716, 128754, 128756, 128794, 128814, 128818, 128820, 128846, 128860, 128866, 128868, 128872, 128886, 128918, 128934, 128940, 128954, 128978, 128980, 129178, 129198, 129202, 129204, 129238, 129258, 129306, 129326, 129330, 129332, 129358, 129372, 129378, 129380, 129384, 129398, 129430, 129446, 129452, 129466, 129482, 129490, 129492, 129562, 129582, 129586, 129588, 129614, 129628, 129634, 129636, 129640, 129654, 129678, 129692, 129720, 129730, 129732, 129736, 129744, 129758, 129766, 129772, 129814, 129830, 129836, 129850, 129862, 129868, 129880, 129902, 129906, 129908, 129930, 129938, 129940, 129954, 129956, 129960, 129974, 130010};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f135b = new int[0];
    private static final int[] c = {2627, 1819, 2622, 2621, 1813, 1812, 2729, 2724, 2723, 2779, 2774, 2773, 902, 896, 908, 868, 865, 861, 859, 2511, 873, 871, 1780, 835, 2493, 825, 2491, 842, 837, 844, 1764, 1762, 811, 810, 809, 2483, 807, 2482, 806, 2480, 815, 814, 813, 812, 2484, 817, 816, 1745, 1744, 1742, 1746, 2655, 2637, 2635, 2626, 2625, 2623, 2628, 1820, 2752, 2739, 2737, 2728, 2727, 2725, 2730, 2785, 2783, 2778, 2777, 2775, 2780, 787, 781, 747, 739, 736, 2413, 754, 752, 1719, 692, 689, 681, 2371, 678, 2369, 700, 697, 694, 703, 1688, 1686, 642, 638, 2343, 631, 2341, 627, 2338, 651, 646, 643, 2345, 654, 652, 1652, 1650, 1647, 1654, 601, 599, 2322, 596, 2321, 594, 2319, 2317, 611, 610, 608, 606, 2324, 603, 2323, 615, 614, 612, 1617, 1616, 1614, 1612, 616, 1619, 1618, 2575, 2538, 2536, 905, 901, 898, 909, 2509, 2507, 2504, 870, 867, 864, 860, 2512, 875, 872, 1781, 2490, 2489, 2487, 2485, 1748, 836, 834, 832, 830, 2494, 827, 2492, 843, 841, 839, 845, 1765, 1763, 2701, 2676, 2674, 2653, 2648, 2656, 2634, 2633, 2631, 2629, 1821, 2638, 2636, 2770, 2763, 2761, 2750, 2745, 2753, 2736, 2735, 2733, 2731, 1848, 2740, 2738, 2786, 2784, 591, 588, 576, 569, 566, 2296, 1590, 537, 534, 526, 2276, 522, 2274, 545, 542, 539, 548, 1572, 1570, 481, 2245, 466, 2242, 462, 2239, 492, 485, 482, 2249, 496, 494, 1534, 1531, 1528, 1538, 413, 2196, 406, 2191, 2188, 425, 419, 2202, 415, 2199, 432, 430, 427, 1472, 1467, 1464, 433, 1476, 1474, 368, 367, 2160, 365, 2159, 362, 2157, 2155, 2152, 378, 377, 375, 2166, 372, 2165, 369, 2162, 383, 381, 379, 2168, 1419, 1418, 1416, 1414, 385, 1411, 384, 1423, 1422, 1420, 1424, 2461, 802, 2441, 2439, 790, 786, 783, 794, 2409, 2406, 2403, 750, 742, 738, 2414, 756, 753, 1720, 2367, 2365, 2362, 2359, 1663, 693, 691, 684, 2373, 680, 2370, 702, 699, 696, 704, 1690, 1687, 2337, 2336, 2334, 2332, 1624, 2329, 1622, 640, 637, 2344, 634, 2342, 630, 2340, 650, 648, 645, 2346, 655, 653, 1653, 1651, 1649, 1655, 2612, 2597, 2595, 2571, 2568, 2565, 2576, 2534, 2529, 2526, 1787, 2540, 2537, 907, 904, 900, 910, 2503, 2502, 2500, 2498, 1768, 2495, 1767, 2510, 2508, 2506, 869, 866, 863, 2513, 876, 874, 1782, 2720, 2713, 2711, 2697, 2694, 2691, 2702, 2672, 2670, 2664, 1828, 2678, 2675, 2647, 2646, 2644, 2642, 1823, 2639, 1822, 2654, 2652, 2650, 2657, 2771, 1855, 2765, 2762, 1850, 1849, 2751, 2749, 2747, 2754, 353, 2148, 344, 342, 336, 2142, 332, 2140, 345, 1375, 1373, 306, 2130, 299, 2128, 295, 2125, 319, 314, 311, 2132, 1354, 1352, 1349, 1356, 262, 257, 2101, 253, 2096, 2093, 274, 273, 267, 2107, 263, 2104, 280, 278, 275, 1316, 1311, 1308, 1320, 1318, 2052, 202, 2050, 2044, 2040, 219, 2063, 212, 2060, 208, 2055, 224, 221, 2066, 1260, 1258, 1252, 231, 1248, 229, 1266, 1264, 1261, 1268, 155, 1998, 153, 1996, 1994, 1991, 1988, 165, 164, 2007, 162, 2006, 159, 2003, 2000, 172, 171, 169, 2012, 166, 2010, 1186, 1184, 1182, 1179, 175, 1176, 173, 1192, 1191, 1189, 1187, 176, 1194, 1193, 2313, 2307, 2305, 592, 589, 2294, 2292, 2289, 578, 572, 568, 2297, 580, 1591, 2272, 2267, 2264, 1547, 538, 536, 529, 2278, 525, 2275, 547, 544, 541, 1574, 1571, 2237, 2235, 2229, 1493, 2225, 1489, 478, 2247, 470, 2244, 465, 2241, 493, 488, 484, 2250, 498, 495, 1536, 1533, 1530, 1539, 2187, 2186, 2184, 2182, 1432, 2179, 1430, 2176, 1427, 414, 412, 2197, 409, 2195, 405, 2193, 2190, 426, 424, 421, 2203, 418, 2201, 431, 429, 1473, 1471, 1469, 1466, 434, 1477, 1475, 2478, 2472, 2470, 2459, 2457, 2454, 2462, 803, 2437, 2432, 2429, 1726, 2443, 2440, 792, 789, 785, 2401, 2399, 2393, 1702, 2389, 1699, 2411, 2408, 2405, 745, 741, 2415, 758, 755, 1721, 2358, 2357, 2355, 2353, 1661, 2350, 1660, 2347, 1657, 2368, 2366, 2364, 2361, 1666, 690, 687, 2374, 683, 2372, 701, 698, 705, 1691, 1689, 2619, 2617, 2610, 2608, 2605, 2613, 2593, 2588, 2585, 1803, 2599, 2596, 2563, 2561, 2555, 1797, 2551, 1795, 2573, 2570, 2567, 2577, 2525, 2524, 2522, 2520, 1786, 2517, 1785, 2514, 1783, 2535, 2533, 2531, 2528, 1788, 2541, 2539, 906, 903, 911, 2721, 1844, 2715, 2712, 1838, 1836, 2699, 2696, 2693, 2703, 1827, 1826, 1824, 2673, 2671, 2669, 2666, 1829, 2679, 2677, 1858, 1857, 2772, 1854, 1853, 1851, 1856, 2766, 2764, 143, 1987, 139, 1986, 135, 133, 131, 1984, 128, 1983, 125, 1981, 138, 137, 136, 1985, 1133, 1132, 1130, 112, 110, 1974, 107, 1973, 104, 1971, 1969, 122, 121, 119, 117, 1977, 114, 1976, 124, 1115, 1114, 1112, 1110, 1117, 1116, 84, 83, 1953, 81, 1952, 78, 1950, 1948, 1945, 94, 93, 91, 1959, 88, 1958, 85, 1955, 99, 97, 95, 1961, 1086, 1085, 1083, 1081, 1078, 100, 1090, 1089, 1087, 1091, 49, 47, 1917, 44, 1915, 1913, 1910, 1907, 59, 1926, 56, 1925, 53, 1922, 1919, 66, 64, 1931, 61, 1929, 1042, 1040, 1038, 71, 1035, 70, 1032, 68, 1048, 1047, 1045, 1043, 1050, 1049, 12, 10, 1869, 1867, 1864, 1861, 21, 1880, 19, 1877, 1874, 1871, 28, 1888, 25, 1886, 22, 1883, 982, 980, 977, 974, 32, 30, 991, 989, 987, 984, 34, 995, 994, 992, 2151, 2150, 2147, 2146, 2144, 356, 355, 354, 2149, 2139, 2138, 2136, 2134, 1359, 343, 341, 338, 2143, 335, 2141, 348, 347, 346, 1376, 1374, 2124, 2123, 2121, 2119, 1326, 2116, 1324, 310, 308, 305, 2131, 302, 2129, 298, 2127, 320, 318, 316, 313, 2133, 322, 321, 1355, 1353, 1351, 1357, 2092, 2091, 2089, 2087, 1276, 2084, 1274, 2081, 1271, 259, 2102, 256, 2100, 252, 2098, 2095, 272, 269, 2108, 266, 2106, 281, 279, 277, 1317, 1315, 1313, 1310, 282, 1321, 1319, 2039, 2037, 2035, 2032, 1203, 2029, 1200, 1197, 207, 2053, 205, 2051, 201, 2049, 2046, 2043, 220, 218, 2064, 215, 2062, 211, 2059, 228, 226, 223, 2069, 1259, 1257, 1254, 232, 1251, 230, 1267, 1265, 1263, 2316, 2315, 2312, 2311, 2309, 2314, 2304, 2303, 2301, 2299, 1593, 2308, 2306, 590, 2288, 2287, 2285, 2283, 1578, 2280, 1577, 2295, 2293, 2291, 579, 577, 574, 571, 2298, 582, 581, 1592, 2263, 2262, 2260, 2258, 1545, 2255, 1544, 2252, 1541, 2273, 2271, 2269, 2266, 1550, GlobalDefine.THUMBNAIL_WIDTH, 532, 2279, 528, 2277, 546, 543, 549, 1575, 1573, 2224, 2222, 2220, 1486, 2217, 1485, 2214, 1482, 1479, 2238, 2236, 2234, 2231, 1496, 2228, 1492, 480, 477, 2248, 473, 2246, 469, 2243, 490, 487, 2251, 497, 1537, 1535, 1532, 2477, 2476, 2474, 2479, 2469, 2468, 2466, 2464, 1730, 2473, 2471, 2453, 2452, 2450, 2448, 1729, 2445, 1728, 2460, 2458, 2456, 2463, 805, 804, 2428, 2427, 2425, 2423, 1725, 2420, 1724, 2417, 1722, 2438, 2436, 2434, 2431, 1727, 2444, 2442, 793, 791, 788, 795, 2388, 2386, 2384, 1697, 2381, 1696, 2378, 1694, 1692, 2402, 2400, 2398, 2395, 1703, 2392, 1701, 2412, 2410, 2407, 751, 748, 744, 2416, 759, 757, 1807, 2620, 2618, 1806, 1805, 2611, 2609, 2607, 2614, 1802, 1801, 1799, 2594, 2592, 2590, 2587, 1804, 2600, 2598, 1794, 1793, 1791, 1789, 2564, 2562, 2560, 2557, 1798, 2554, 1796, 2574, 2572, 2569, 2578, 1847, 1846, 2722, 1843, 1842, 1840, 1845, 2716, 2714, 1835, 1834, 1832, 1830, 1839, 1837, 2700, 2698, 2695, 2704, 1817, 1811, 1810, 897, 862, 1777, 829, 826, 838, 1760, 1758, 808, 2481, 1741, 1740, 1738, 1743, 2624, 1818, 2726, 2776, 782, 740, 737, 1715, 686, 679, 695, 1682, 1680, 639, 628, 2339, 647, 644, 1645, 1643, 1640, 1648, 602, 600, 597, 595, 2320, 593, 2318, 609, 607, 604, 1611, 1610, 1608, 1606, 613, 1615, 1613, 2328, 926, 924, 892, 886, 899, 857, 850, 2505, 1778, 824, 823, 821, 819, 2488, 818, 2486, 833, 831, 828, 840, 1761, 1759, 2649, 2632, 2630, 2746, 2734, 2732, 2782, 2781, 570, 567, 1587, 531, 527, 523, 540, 1566, 1564, 476, 467, 463, 2240, 486, 483, 1524, 1521, 1518, 1529, 411, 403, 2192, 399, 2189, 423, 416, 1462, 1457, 1454, 428, 1468, 1465, 2210, 366, 363, 2158, 360, 2156, 357, 2153, 376, 373, 370, 2163, 1410, 1409, 1407, 1405, 382, 1402, 380, 1417, 1415, 1412, 1421, 2175, 2174, 777, 774, 771, 784, 732, 725, 722, 2404, 743, 1716, 676, 674, 668, 2363, 665, 2360, 685, 1684, 1681, 626, 624, 622, 2335, 620, 2333, 617, 2330, 641, 635, 649, 1646, 1644, 1642, 2566, 928, 925, 2530, 2527, 894, 891, 888, 2501, 2499, 2496, 858, 856, 854, 851, 1779, 2692, 2668, 2665, 2645, 2643, 2640, 2651, 2768, 2759, 2757, 2744, 2743, 2741, 2748, 352, 1382, 340, 337, 333, 1371, 1369, 307, 300, 296, 2126, 315, 312, 1347, 1342, 1350, 261, 258, 250, 2097, 246, 2094, 271, 268, 264, 1306, 1301, 1298, 276, 1312, 1309, 2115, 203, 2048, 195, 2045, 191, 2041, 213, 209, 2056, 1246, 1244, 1238, 225, 1234, 222, 1256, 1253, 1249, 1262, 2080, 2079, 154, 1997, 150, 1995, 147, 1992, 1989, 163, 160, 2004, 156, 2001, 1175, 1174, 1172, 1170, 1167, 170, 1164, 167, 1185, 1183, 1180, 1177, 174, 1190, 1188, 2025, 2024, 2022, 587, 586, 564, 559, 556, 2290, 573, 1588, 520, 518, 512, 2268, 508, 2265, 530, 1568, 1565, 461, 457, 2233, 450, 2230, 446, 2226, 479, 471, 489, 1526, 1523, 1520, 397, 395, 2185, 392, 2183, 389, 2180, 2177, 410, 2194, 402, 422, 1463, 1461, 1459, 1456, 1470, 2455, 799, 2433, 2430, 779, 776, 773, 2397, 2394, 2390, 734, 728, 724, 746, 1717, 2356, 2354, 2351, 2348, 1658, 677, 675, 673, 670, 667, 688, 1685, 1683, 2606, 2589, 2586, 2559, 2556, 2552, 927, 2523, 2521, 2518, 2515, 1784, 2532, 895, 893, 890, 2718, 2709, 2707, 2689, 2687, 2684, 2663, 2662, 2660, 2658, 1825, 2667, 2769, 1852, 2760, 2758, 142, 141, 1139, 1138, 134, 132, 129, 126, 1982, 1129, 1128, 1126, 1131, 113, 111, 108, 105, 1972, 101, 1970, 120, 118, 115, 1109, 1108, 1106, 1104, 123, 1113, 1111, 82, 79, 1951, 75, 1949, 72, 1946, 92, 89, 86, 1956, 1077, 1076, 1074, 1072, 98, 1069, 96, 1084, 1082, 1079, 1088, 1968, 1967, 48, 45, 1916, 42, 1914, 39, 1911, 1908, 60, 57, 54, 1923, 50, 1920, 1031, 1030, 1028, 1026, 67, 1023, 65, 1020, 62, 1041, 1039, 1036, 1033, 69, 1046, 1044, 1944, 1943, 1941, 11, 9, 1868, 7, 1865, 1862, 1859, 20, 1878, 16, 1875, 13, 1872, 970, 968, 966, 963, 29, 960, 26, 23, 983, 981, 978, 975, 33, 971, 31, 990, 988, 985, 1906, 1904, 1902, 993, 351, 2145, 1383, 331, 330, 328, 326, 2137, 323, 2135, 339, 1372, 1370, 294, 293, 291, 289, 2122, 286, 2120, 283, 2117, 309, 303, 317, 1348, 1346, 1344, 245, 244, 242, 2090, 239, 2088, 236, 2085, 2082, 260, 2099, 249, 270, 1307, 1305, 1303, 1300, 1314, 189, 2038, 186, 2036, 183, 2033, 2030, 2026, 206, 198, 2047, 194, 216, 1247, 1245, 1243, 1240, 227, 1237, 1255, 2310, 2302, 2300, 2286, 2284, 2281, 565, 563, 561, 558, 575, 1589, 2261, 2259, 2256, 2253, 1542, 521, 519, 517, 514, 2270, 511, 533, 1569, 1567, 2223, 2221, 2218, 2215, 1483, 2211, 1480, 459, 456, 453, 2232, 449, 474, 491, 1527, 1525, 1522, 2475, 2467, 2465, 2451, 2449, 2446, 801, 800, 2426, 2424, 2421, 2418, 1723, 2435, 780, 778, 775, 2387, 2385, 2382, 2379, 1695, 2375, 1693, 2396, 735, 733, 730, 727, 749, 1718, 2616, 2615, 2604, 2603, 2601, 2584, 2583, 2581, 2579, 1800, 2591, 2550, 2549, 2547, 2545, 1792, 2542, 1790, 2558, 929, 2719, 1841, 2710, 2708, 1833, 1831, 2690, 2688, 2686, 1815, 1809, 1808, 1774, 1756, 1754, 1737, 1736, 1734, 1739, 1816, 1711, 1676, 1674, 633, 629, 1638, 1636, 1633, 1641, 598, 1605, 1604, 1602, 1600, 605, 1609, 1607, 2327, 887, 853, 1775, 822, 820, 1757, 1755, 1584, 524, 1560, 1558, 468, 464, 1514, 1511, 1508, 1519, 408, 404, 400, 1452, 1447, 1444, 417, 1458, 1455, 2208, 364, 361, 358, 2154, 1401, 1400, 1398, 1396, 374, 1393, 371, 1408, 1406, 1403, 1413, 2173, 2172, 772, 726, 723, 1712, 672, 669, 666, 682, 1678, 1675, 625, 623, 621, 618, 2331, 636, 632, 1639, 1637, 1635, 920, 918, 884, 880, 889, 849, 848, 847, 846, 2497, 855, 852, 1776, 2641, 2742, 2787, 1380, 334, 1367, 1365, 301, 297, 1340, 1338, 1335, 1343, 255, 251, 247, 1296, 1291, 1288, 265, 1302, 1299, 2113, 204, 196, 192, 2042, 1232, 1230, 1224, 214, 1220, 210, 1242, 1239, 1235, 1250, 2077, 2075, 151, 148, 1993, 144, 1990, 1163, 1162, 1160, 1158, 1155, 161, 1152, 157, 1173, 1171, 1168, 1165, 168, 1181, 1178, 2021, 2020, 2018, 2023, 585, 560, 557, 1585, 516, 509, 1562, 1559, 458, 447, 2227, 472, 1516, 1513, 1510, 398, 396, 393, 390, 2181, 386, 2178, 407, 1453, 1451, 1449, 1446, 420, 1460, 2209, 769, 764, 720, 712, 2391, 729, 1713, 664, 663, 661, 659, 2352, 656, 2349, 671, 1679, 1677, 2553, 922, 919, 2519, 2516, 885, 883, 881, 2685, 2661, 2659, 2767, 2756, 2755, 140, 1137, 1136, 130, 127, 1125, 1124, 1122, 1127, 109, 106, 102, 1103, 1102, 1100, 1098, 116, 1107, 1105, 1980, 80, 76, 73, 1947, 1068, 1067, 1065, 1063, 90, 1060, 87, 1075, 1073, 1070, 1080, 1966, 1965, 46, 43, 40, 1912, 36, 1909, 1019, 1018, 1016, 1014, 58, 1011, 55, 1008, 51, 1029, 1027, FXUtil.MAX_CUSTOM_FACE_IMAGE_SIZE, 1021, 63, 1037, 1034, 1940, 1939, 1937, 1942, 8, 1866, 4, 1863, 1, 1860, 956, 954, 952, 949, 946, 17, 14, 969, 967, 964, 961, 27, 957, 24, 979, 976, 972, 1901, 1900, 1898, 1896, 986, 1905, 1903, 350, 349, 1381, 329, 327, 324, 1368, 1366, 292, 290, 287, 284, 2118, 304, 1341, 1339, 1337, 1345, 243, 240, 237, 2086, 233, 2083, 254, 1297, 1295, 1293, 1290, 1304, 2114, 190, 187, 184, 2034, 180, 2031, 177, 2027, 199, 1233, 1231, 1229, 1226, 217, 1223, 1241, 2078, 2076, 584, 555, 554, 552, 550, 2282, 562, 1586, 507, 506, 504, 502, 2257, 499, 2254, 515, 1563, 1561, 445, 443, 441, 2219, 438, 2216, 435, 2212, 460, 454, 475, 1517, 1515, 1512, 2447, 798, 797, 2422, 2419, 770, 768, 766, 2383, 2380, 2376, 721, 719, 717, 714, 731, 1714, 2602, 2582, 2580, 2548, 2546, 2543, 923, 921, 2717, 2706, 2705, 2683, 2682, 2680, 1771, 1752, 1750, 1733, 1732, 1731, 1735, 1814, 1707, 1670, 1668, 1631, 1629, 1626, 1634, 1599, 1598, 1596, 1594, 1603, 1601, 2326, 1772, 1753, 1751, 1581, 1554, 1552, 1504, 1501, 1498, 1509, 1442, 1437, 1434, 401, 1448, 1445, 2206, 1392, 1391, 1389, 1387, 1384, 359, 1399, 1397, 1394, 1404, 2171, 2170, 1708, 1672, 1669, 619, 1632, 1630, 1628, 1773, 1378, 1363, 1361, 1333, 1328, 1336, 1286, 1281, 1278, 248, 1292, 1289, 2111, 1218, 1216, 1210, 197, 1206, 193, 1228, 1225, 1221, 1236, 2073, 2071, 1151, 1150, 1148, 1146, 152, 1143, 149, 1140, 145, 1161, 1159, 1156, 1153, 158, 1169, 1166, 2017, 2016, 2014, 2019, 1582, 510, 1556, 1553, 452, 448, 1506, 1500, 394, 391, 387, 1443, 1441, 1439, 1436, 1450, 2207, 765, 716, 713, 1709, 662, 660, 657, 1673, 1671, 916, 914, 879, 878, 877, 882, 1135, 1134, 1121, 1120, 1118, 1123, 1097, 1096, 1094, 1092, 103, 1101, 1099, 1979, 1059, 1058, 1056, 1054, 77, 1051, 74, 1066, 1064, 1061, 1071, 1964, 1963, 1007, 1006, 1004, 1002, 999, 41, 996, 37, 1017, 1015, 1012, 1009, 52, 1025, 1022, 1936, 1935, 1933, 1938, 942, 940, 938, 935, 932, 5, 2, 955, 953, 950, 947, 18, 943, 15, 965, 962, 958, 1895, 1894, 1892, 1890, 973, 1899, 1897, 1379, 325, 1364, 1362, 288, 285, 1334, 1332, 1330, 241, 238, 234, 1287, 1285, 1283, 1280, 1294, 2112, 188, 185, 181, 178, 2028, 1219, 1217, 1215, 1212, 200, 1209, 1227, 2074, 2072, 583, 553, 551, 1583, 505, 503, 500, 513, 1557, 1555, 444, 442, 439, 436, 2213, 455, 451, 1507, 1505, 1502, 796, 763, 762, 760, 767, 711, 710, 708, 706, 2377, 718, 715, 1710, 2544, 917, 915, 2681, 1627, 1597, 1595, 2325, 1769, 1749, 1747, 1499, 1438, 1435, 2204, 1390, 1388, 1385, 1395, 2169, 2167, 1704, 1665, 1662, 1625, 1623, 1620, 1770, 1329, 1282, 1279, 2109, 1214, 1207, 1222, 2068, 2065, 1149, 1147, 1144, 1141, 146, 1157, 1154, 2013, 2011, 2008, 2015, 1579, 1549, 1546, 1495, 1487, 1433, 1431, 1428, 1425, 388, 1440, 2205, 1705, 658, 1667, 1664, 1119, 1095, 1093, 1978, 1057, 1055, 1052, 1062, 1962, 1960, 1005, 1003, 1000, 997, 38, 1013, 1010, 1932, 1930, 1927, 1934, 941, 939, 936, 933, 6, 930, 3, GlobalDefine.THUMBNAIL_HEIGHT, 948, 944, 1889, 1887, 1884, 1881, 959, 1893, 1891, 35, 1377, 1360, 1358, 1327, 1325, 1322, 1331, 1277, 1275, 1272, 1269, 235, 1284, 2110, 1205, 1204, 1201, 1198, 182, 1195, 179, 1213, 2070, 2067, 1580, 501, 1551, 1548, 440, 437, 1497, 1494, 1490, 1503, 761, 709, 707, 1706, 913, 912, 2198, 1386, 2164, 2161, 1621, 1766, 2103, 1208, 2058, 2054, 1145, 1142, 2005, 2002, 1999, 2009, 1488, 1429, 1426, 2200, 1698, 1659, 1656, 1975, 1053, 1957, 1954, 1001, 998, 1924, 1921, 1918, 1928, 937, 934, 931, 1879, 1876, 1873, 1870, 945, 1885, 1882, 1323, 1273, 1270, 2105, 1202, 1199, 1196, 1211, 2061, 2057, 1576, 1543, 1540, 1484, 1481, 1478, 1491, 1700};

    public static int[] a(Collection<Integer> collection) {
        if (collection == null || collection.isEmpty()) {
            return f135b;
        }
        int[] iArr = new int[collection.size()];
        int i = 0;
        for (Integer intValue : collection) {
            iArr[i] = intValue.intValue();
            i++;
        }
        return iArr;
    }

    public static int a(int i) {
        int binarySearch = Arrays.binarySearch(f134a, i & 262143);
        if (binarySearch < 0) {
            return -1;
        }
        return (c[binarySearch] - 1) % 929;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\f\b.java ==========

package a.a.a.f;

import a.a.a.c;
import a.a.a.d;
import a.a.a.e;
import a.a.a.f;
import a.a.a.f.a.j;
import a.a.a.f.b.a;
import a.a.a.i;
import a.a.a.k;
import a.a.a.m;
import a.a.a.n;
import a.a.a.o;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: PDF417Reader */
public final class b implements k {
    public void a() {
    }

    public m a(c cVar, Map<e, ?> map) throws i, f, d {
        m[] a2 = a(cVar, map, false);
        if (a2 != null && a2.length != 0 && a2[0] != null) {
            return a2[0];
        }
        throw i.a();
    }

    private static m[] a(c cVar, Map<e, ?> map, boolean z) throws i, f, d {
        ArrayList arrayList = new ArrayList();
        a.a.a.f.b.b a2 = a.a(cVar, map, z);
        for (o[] next : a2.b()) {
            a.a.a.b.e a3 = j.a(a2.a(), next[4], next[5], next[6], next[7], b(next), a(next));
            m mVar = new m(a3.c(), a3.a(), next, a.a.a.a.PDF_417);
            mVar.a(n.ERROR_CORRECTION_LEVEL, a3.e());
            c cVar2 = (c) a3.f();
            if (cVar2 != null) {
                mVar.a(n.PDF417_EXTRA_METADATA, cVar2);
            }
            arrayList.add(mVar);
        }
        return (m[]) arrayList.toArray(new m[arrayList.size()]);
    }

    private static int a(o oVar, o oVar2) {
        if (oVar == null || oVar2 == null) {
            return 0;
        }
        return (int) Math.abs(oVar.a() - oVar2.a());
    }

    private static int b(o oVar, o oVar2) {
        if (oVar == null || oVar2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(oVar.a() - oVar2.a());
    }

    private static int a(o[] oVarArr) {
        return Math.max(Math.max(a(oVarArr[0], oVarArr[4]), (a(oVarArr[6], oVarArr[2]) * 17) / 18), Math.max(a(oVarArr[1], oVarArr[5]), (a(oVarArr[7], oVarArr[3]) * 17) / 18));
    }

    private static int b(o[] oVarArr) {
        return Math.min(Math.min(b(oVarArr[0], oVarArr[4]), (b(oVarArr[6], oVarArr[2]) * 17) / 18), Math.min(b(oVarArr[1], oVarArr[5]), (b(oVarArr[7], oVarArr[3]) * 17) / 18));
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\f\c.java ==========

package a.a.a.f;

/* compiled from: PDF417ResultMetadata */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private int f164a;

    /* renamed from: b  reason: collision with root package name */
    private String f165b;
    private int[] c;
    private boolean d;

    public void a(int i) {
        this.f164a = i;
    }

    public void a(String str) {
        this.f165b = str;
    }

    public void a(int[] iArr) {
        this.c = iArr;
    }

    public void a(boolean z) {
        this.d = z;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\f\a\a.java ==========

package a.a.a.f.a;

/* compiled from: BarcodeMetadata */
final class a {

    /* renamed from: a  reason: collision with root package name */
    private final int f136a;

    /* renamed from: b  reason: collision with root package name */
    private final int f137b;
    private final int c;
    private final int d;
    private final int e;

    a(int i, int i2, int i3, int i4) {
        this.f136a = i;
        this.f137b = i4;
        this.c = i2;
        this.d = i3;
        this.e = i2 + i3;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f136a;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f137b;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.d;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\f\a\b.java ==========

package a.a.a.f.a;

import a.a.a.f.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BarcodeValue */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Integer, Integer> f143a = new HashMap();

    b() {
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        Integer num = this.f143a.get(Integer.valueOf(i));
        if (num == null) {
            num = 0;
        }
        this.f143a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }

    /* access modifiers changed from: package-private */
    public int[] a() {
        ArrayList arrayList = new ArrayList();
        int i = -1;
        for (Map.Entry next : this.f143a.entrySet()) {
            if (((Integer) next.getValue()).intValue() > i) {
                i = ((Integer) next.getValue()).intValue();
                arrayList.clear();
                arrayList.add(next.getKey());
            } else if (((Integer) next.getValue()).intValue() == i) {
                arrayList.add(next.getKey());
            }
        }
        return a.a((Collection<Integer>) arrayList);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\f\a\c.java ==========

package a.a.a.f.a;

import a.a.a.b.b;
import a.a.a.i;
import a.a.a.o;
import net.fxgear.GlobalDefine;

/* compiled from: BoundingBox */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private b f144a;

    /* renamed from: b  reason: collision with root package name */
    private o f145b;
    private o c;
    private o d;
    private o e;
    private int f;
    private int g;
    private int h;
    private int i;

    c(b bVar, o oVar, o oVar2, o oVar3, o oVar4) throws i {
        if (!(oVar == null && oVar3 == null) && (!(oVar2 == null && oVar4 == null) && ((oVar == null || oVar2 != null) && (oVar3 == null || oVar4 != null)))) {
            a(bVar, oVar, oVar2, oVar3, oVar4);
            return;
        }
        throw i.a();
    }

    c(c cVar) {
        a(cVar.f144a, cVar.f145b, cVar.c, cVar.d, cVar.e);
    }

    private void a(b bVar, o oVar, o oVar2, o oVar3, o oVar4) {
        this.f144a = bVar;
        this.f145b = oVar;
        this.c = oVar2;
        this.d = oVar3;
        this.e = oVar4;
        i();
    }

    static c a(c cVar, c cVar2) throws i {
        if (cVar == null) {
            return cVar2;
        }
        return cVar2 == null ? cVar : new c(cVar.f144a, cVar.f145b, cVar.c, cVar2.d, cVar2.e);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.a.a.f.a.c a(int r13, int r14, boolean r15) throws a.a.a.i {
        /*
            r12 = this;
            a.a.a.o r0 = r12.f145b
            a.a.a.o r1 = r12.c
            a.a.a.o r2 = r12.d
            a.a.a.o r3 = r12.e
            if (r13 <= 0) goto L_0x002b
            if (r15 == 0) goto L_0x000f
            a.a.a.o r4 = r12.f145b
            goto L_0x0011
        L_0x000f:
            a.a.a.o r4 = r12.d
        L_0x0011:
            float r5 = r4.b()
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L_0x001a
            r5 = 0
        L_0x001a:
            a.a.a.o r13 = new a.a.a.o
            float r4 = r4.a()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L_0x0028
            r8 = r13
            goto L_0x002c
        L_0x0028:
            r10 = r13
            r8 = r0
            goto L_0x002d
        L_0x002b:
            r8 = r0
        L_0x002c:
            r10 = r2
        L_0x002d:
            if (r14 <= 0) goto L_0x005d
            if (r15 == 0) goto L_0x0034
            a.a.a.o r13 = r12.c
            goto L_0x0036
        L_0x0034:
            a.a.a.o r13 = r12.e
        L_0x0036:
            float r0 = r13.b()
            int r0 = (int) r0
            int r0 = r0 + r14
            a.a.a.b.b r14 = r12.f144a
            int r14 = r14.f()
            if (r0 < r14) goto L_0x004c
            a.a.a.b.b r14 = r12.f144a
            int r14 = r14.f()
            int r0 = r14 + -1
        L_0x004c:
            a.a.a.o r14 = new a.a.a.o
            float r13 = r13.a()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L_0x005a
            r9 = r14
            goto L_0x005e
        L_0x005a:
            r11 = r14
            r9 = r1
            goto L_0x005f
        L_0x005d:
            r9 = r1
        L_0x005e:
            r11 = r3
        L_0x005f:
            r12.i()
            a.a.a.f.a.c r13 = new a.a.a.f.a.c
            a.a.a.b.b r7 = r12.f144a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.f.a.c.a(int, int, boolean):a.a.a.f.a.c");
    }

    private void i() {
        if (this.f145b == null) {
            this.f145b = new o(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, this.d.b());
            this.c = new o(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, this.e.b());
        } else if (this.d == null) {
            this.d = new o((float) (this.f144a.e() - 1), this.f145b.b());
            this.e = new o((float) (this.f144a.e() - 1), this.c.b());
        }
        this.f = (int) Math.min(this.f145b.a(), this.c.a());
        this.g = (int) Math.max(this.d.a(), this.e.a());
        this.h = (int) Math.min(this.f145b.b(), this.d.b());
        this.i = (int) Math.max(this.c.b(), this.e.b());
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public o e() {
        return this.f145b;
    }

    /* access modifiers changed from: package-private */
    public o f() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public o g() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public o h() {
        return this.e;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\f\a\d.java ==========

package a.a.a.f.a;

/* compiled from: Codeword */
final class d {

    /* renamed from: a  reason: collision with root package name */
    private final int f146a;

    /* renamed from: b  reason: collision with root package name */
    private final int f147b;
    private final int c;
    private final int d;
    private int e = -1;

    d(int i, int i2, int i3, int i4) {
        this.f146a = i;
        this.f147b = i2;
        this.c = i3;
        this.d = i4;
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return a(this.e);
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i) {
        return i != -1 && this.c == (i % 3) * 3;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.e = ((this.d / 30) * 3) + (this.c / 3);
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f147b - this.f146a;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f146a;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f147b;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
        this.e = i;
    }

    public String toString() {
        return this.e + "|" + this.d;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\f\a\e.java ==========

package a.a.a.f.a;

import a.a.a.b.d;
import a.a.a.f;
import a.a.a.f.c;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/* compiled from: DecodedBitStreamParser */
final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f148a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f149b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final Charset c = Charset.forName("ISO-8859-1");
    private static final BigInteger[] d;

    /* compiled from: DecodedBitStreamParser */
    private enum a {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        d = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        d[1] = valueOf;
        for (int i = 2; i < d.length; i++) {
            d[i] = d[i - 1].multiply(valueOf);
        }
    }

    static a.a.a.b.e a(int[] iArr, String str) throws f {
        int i;
        StringBuilder sb = new StringBuilder(iArr.length << 1);
        Charset charset = c;
        int i2 = iArr[1];
        c cVar = new c();
        int i3 = 2;
        while (i3 < iArr[0]) {
            if (i2 != 913) {
                switch (i2) {
                    case 900:
                        i = a(iArr, i3, sb);
                        break;
                    case 901:
                        i = a(i2, iArr, charset, i3, sb);
                        break;
                    case 902:
                        i = b(iArr, i3, sb);
                        break;
                    default:
                        switch (i2) {
                            case 922:
                            case 923:
                                throw f.a();
                            case 924:
                                break;
                            case 925:
                                i = i3 + 1;
                                break;
                            case 926:
                                i = i3 + 2;
                                break;
                            case 927:
                                i = i3 + 1;
                                charset = Charset.forName(d.a(iArr[i3]).name());
                                break;
                            case 928:
                                i = a(iArr, i3, cVar);
                                break;
                            default:
                                i = a(iArr, i3 - 1, sb);
                                break;
                        }
                        i = a(i2, iArr, charset, i3, sb);
                        break;
                }
            } else {
                i = i3 + 1;
                sb.append((char) iArr[i3]);
            }
            if (i < iArr.length) {
                i3 = i + 1;
                i2 = iArr[i];
            } else {
                throw f.a();
            }
        }
        if (sb.length() != 0) {
            a.a.a.b.e eVar = new a.a.a.b.e((byte[]) null, sb.toString(), (List<byte[]>) null, str);
            eVar.a((Object) cVar);
            return eVar;
        }
        throw f.a();
    }

    private static int a(int[] iArr, int i, c cVar) throws f {
        if (i + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i2 = i;
            int i3 = 0;
            while (i3 < 2) {
                iArr2[i3] = iArr[i2];
                i3++;
                i2++;
            }
            cVar.a(Integer.parseInt(a(iArr2, 2)));
            StringBuilder sb = new StringBuilder();
            int a2 = a(iArr, i2, sb);
            cVar.a(sb.toString());
            if (iArr[a2] == 923) {
                int i4 = a2 + 1;
                int[] iArr3 = new int[(iArr[0] - i4)];
                boolean z = false;
                int i5 = 0;
                while (i4 < iArr[0] && !z) {
                    int i6 = i4 + 1;
                    int i7 = iArr[i4];
                    if (i7 < 900) {
                        iArr3[i5] = i7;
                        i4 = i6;
                        i5++;
                    } else if (i7 == 922) {
                        cVar.a(true);
                        i4 = i6 + 1;
                        z = true;
                    } else {
                        throw f.a();
                    }
                }
                cVar.a(Arrays.copyOf(iArr3, i5));
                return i4;
            } else if (iArr[a2] != 922) {
                return a2;
            } else {
                cVar.a(true);
                return a2 + 1;
            }
        } else {
            throw f.a();
        }
    }

    private static int a(int[] iArr, int i, StringBuilder sb) {
        int[] iArr2 = new int[((iArr[0] - i) << 1)];
        int[] iArr3 = new int[((iArr[0] - i) << 1)];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i4 < 900) {
                iArr2[i2] = i4 / 30;
                iArr2[i2 + 1] = i4 % 30;
                i2 += 2;
            } else if (i4 != 913) {
                if (i4 != 928) {
                    switch (i4) {
                        case 900:
                            iArr2[i2] = 900;
                            i2++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i4) {
                                case 922:
                                case 923:
                                case 924:
                                    break;
                            }
                    }
                }
                i = i3 - 1;
                z = true;
            } else {
                iArr2[i2] = 913;
                i = i3 + 1;
                iArr3[i2] = iArr[i3];
                i2++;
            }
            i = i3;
        }
        a(iArr2, iArr3, i2, sb);
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0083, code lost:
        r4 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b4, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00d6, code lost:
        r3 = ' ';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00f6, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00f7, code lost:
        if (r3 == 0) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00f9, code lost:
        r0.append(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00fc, code lost:
        r2 = r2 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(int[] r14, int[] r15, int r16, java.lang.StringBuilder r17) {
        /*
            r0 = r17
            a.a.a.f.a.e$a r1 = a.a.a.f.a.e.a.ALPHA
            a.a.a.f.a.e$a r2 = a.a.a.f.a.e.a.ALPHA
            r4 = r1
            r5 = r2
            r2 = 0
            r1 = r16
        L_0x000b:
            if (r2 >= r1) goto L_0x0100
            r6 = r14[r2]
            int[] r7 = a.a.a.f.a.e.AnonymousClass1.f150a
            int r8 = r4.ordinal()
            r7 = r7[r8]
            r8 = 28
            r9 = 27
            r10 = 32
            r11 = 913(0x391, float:1.28E-42)
            r12 = 900(0x384, float:1.261E-42)
            r13 = 29
            r3 = 26
            switch(r7) {
                case 1: goto L_0x00ce;
                case 2: goto L_0x00a7;
                case 3: goto L_0x0075;
                case 4: goto L_0x0059;
                case 5: goto L_0x0044;
                case 6: goto L_0x002a;
                default: goto L_0x0028;
            }
        L_0x0028:
            goto L_0x00f6
        L_0x002a:
            if (r6 >= r13) goto L_0x0031
            char[] r3 = f148a
            char r3 = r3[r6]
            goto L_0x0049
        L_0x0031:
            if (r6 != r13) goto L_0x0036
            a.a.a.f.a.e$a r3 = a.a.a.f.a.e.a.ALPHA
            goto L_0x0083
        L_0x0036:
            if (r6 != r11) goto L_0x003f
            r3 = r15[r2]
            char r3 = (char) r3
            r0.append(r3)
            goto L_0x0056
        L_0x003f:
            if (r6 != r12) goto L_0x0056
            a.a.a.f.a.e$a r3 = a.a.a.f.a.e.a.ALPHA
            goto L_0x0083
        L_0x0044:
            if (r6 >= r3) goto L_0x004c
            int r6 = r6 + 65
            char r3 = (char) r6
        L_0x0049:
            r4 = r5
            goto L_0x00f7
        L_0x004c:
            if (r6 != r3) goto L_0x0051
            r4 = r5
            goto L_0x00d6
        L_0x0051:
            if (r6 != r12) goto L_0x0056
            a.a.a.f.a.e$a r3 = a.a.a.f.a.e.a.ALPHA
            goto L_0x0083
        L_0x0056:
            r4 = r5
            goto L_0x00f6
        L_0x0059:
            if (r6 >= r13) goto L_0x0061
            char[] r3 = f148a
            char r3 = r3[r6]
            goto L_0x00f7
        L_0x0061:
            if (r6 != r13) goto L_0x0066
            a.a.a.f.a.e$a r3 = a.a.a.f.a.e.a.ALPHA
            goto L_0x0083
        L_0x0066:
            if (r6 != r11) goto L_0x0070
            r3 = r15[r2]
            char r3 = (char) r3
            r0.append(r3)
            goto L_0x00f6
        L_0x0070:
            if (r6 != r12) goto L_0x00f6
            a.a.a.f.a.e$a r3 = a.a.a.f.a.e.a.ALPHA
            goto L_0x0083
        L_0x0075:
            r7 = 25
            if (r6 >= r7) goto L_0x007f
            char[] r3 = f149b
            char r3 = r3[r6]
            goto L_0x00f7
        L_0x007f:
            if (r6 != r7) goto L_0x0086
            a.a.a.f.a.e$a r3 = a.a.a.f.a.e.a.PUNCT
        L_0x0083:
            r4 = r3
            goto L_0x00f6
        L_0x0086:
            if (r6 != r3) goto L_0x0089
            goto L_0x00d6
        L_0x0089:
            if (r6 != r9) goto L_0x008e
            a.a.a.f.a.e$a r3 = a.a.a.f.a.e.a.LOWER
            goto L_0x0083
        L_0x008e:
            if (r6 != r8) goto L_0x0093
            a.a.a.f.a.e$a r3 = a.a.a.f.a.e.a.ALPHA
            goto L_0x0083
        L_0x0093:
            if (r6 != r13) goto L_0x0098
            a.a.a.f.a.e$a r3 = a.a.a.f.a.e.a.PUNCT_SHIFT
            goto L_0x00b4
        L_0x0098:
            if (r6 != r11) goto L_0x00a2
            r3 = r15[r2]
            char r3 = (char) r3
            r0.append(r3)
            goto L_0x00f6
        L_0x00a2:
            if (r6 != r12) goto L_0x00f6
            a.a.a.f.a.e$a r3 = a.a.a.f.a.e.a.ALPHA
            goto L_0x0083
        L_0x00a7:
            if (r6 >= r3) goto L_0x00ad
            int r6 = r6 + 97
            char r3 = (char) r6
            goto L_0x00f7
        L_0x00ad:
            if (r6 != r3) goto L_0x00b0
            goto L_0x00d6
        L_0x00b0:
            if (r6 != r9) goto L_0x00b6
            a.a.a.f.a.e$a r3 = a.a.a.f.a.e.a.ALPHA_SHIFT
        L_0x00b4:
            r5 = r4
            goto L_0x0083
        L_0x00b6:
            if (r6 != r8) goto L_0x00bb
            a.a.a.f.a.e$a r3 = a.a.a.f.a.e.a.MIXED
            goto L_0x0083
        L_0x00bb:
            if (r6 != r13) goto L_0x00c0
            a.a.a.f.a.e$a r3 = a.a.a.f.a.e.a.PUNCT_SHIFT
            goto L_0x00b4
        L_0x00c0:
            if (r6 != r11) goto L_0x00c9
            r3 = r15[r2]
            char r3 = (char) r3
            r0.append(r3)
            goto L_0x00f6
        L_0x00c9:
            if (r6 != r12) goto L_0x00f6
            a.a.a.f.a.e$a r3 = a.a.a.f.a.e.a.ALPHA
            goto L_0x0083
        L_0x00ce:
            if (r6 >= r3) goto L_0x00d4
            int r6 = r6 + 65
            char r3 = (char) r6
            goto L_0x00f7
        L_0x00d4:
            if (r6 != r3) goto L_0x00d9
        L_0x00d6:
            r3 = 32
            goto L_0x00f7
        L_0x00d9:
            if (r6 != r9) goto L_0x00de
            a.a.a.f.a.e$a r3 = a.a.a.f.a.e.a.LOWER
            goto L_0x0083
        L_0x00de:
            if (r6 != r8) goto L_0x00e3
            a.a.a.f.a.e$a r3 = a.a.a.f.a.e.a.MIXED
            goto L_0x0083
        L_0x00e3:
            if (r6 != r13) goto L_0x00e8
            a.a.a.f.a.e$a r3 = a.a.a.f.a.e.a.PUNCT_SHIFT
            goto L_0x00b4
        L_0x00e8:
            if (r6 != r11) goto L_0x00f1
            r3 = r15[r2]
            char r3 = (char) r3
            r0.append(r3)
            goto L_0x00f6
        L_0x00f1:
            if (r6 != r12) goto L_0x00f6
            a.a.a.f.a.e$a r3 = a.a.a.f.a.e.a.ALPHA
            goto L_0x0083
        L_0x00f6:
            r3 = 0
        L_0x00f7:
            if (r3 == 0) goto L_0x00fc
            r0.append(r3)
        L_0x00fc:
            int r2 = r2 + 1
            goto L_0x000b
        L_0x0100:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.f.a.e.a(int[], int[], int, java.lang.StringBuilder):void");
    }

    private static int a(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) {
        int i3;
        long j;
        int i4;
        int i5;
        int i6 = i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i7 = 922;
        int i8 = 923;
        int i9 = 928;
        int i10 = 902;
        long j2 = 900;
        if (i6 == 901) {
            int[] iArr2 = new int[6];
            int i11 = iArr[i2];
            int i12 = i2 + 1;
            boolean z = false;
            loop0:
            while (true) {
                i4 = 0;
                long j3 = 0;
                while (i3 < iArr[0] && !z) {
                    int i13 = i4 + 1;
                    iArr2[i4] = i11;
                    j3 = (j3 * j) + ((long) i11);
                    int i14 = i3 + 1;
                    i11 = iArr[i3];
                    if (i11 == 900 || i11 == 901 || i11 == 902 || i11 == 924 || i11 == 928 || i11 == i8 || i11 == i7) {
                        i3 = i14 - 1;
                        i4 = i13;
                        i7 = 922;
                        i8 = 923;
                        j = 900;
                        z = true;
                    } else if (i13 % 5 != 0 || i13 <= 0) {
                        i3 = i14;
                        i4 = i13;
                        i7 = 922;
                        i8 = 923;
                        j = 900;
                    } else {
                        int i15 = 0;
                        while (i15 < 6) {
                            byteArrayOutputStream.write((byte) ((int) (j3 >> ((5 - i15) * 8))));
                            i15++;
                            i7 = 922;
                            i8 = 923;
                        }
                        i12 = i14;
                        j2 = 900;
                    }
                }
            }
            if (i3 != iArr[0] || i11 >= 900) {
                i5 = i4;
            } else {
                i5 = i4 + 1;
                iArr2[i4] = i11;
            }
            for (int i16 = 0; i16 < i5; i16++) {
                byteArrayOutputStream.write((byte) iArr2[i16]);
            }
        } else if (i6 == 924) {
            int i17 = i2;
            boolean z2 = false;
            int i18 = 0;
            long j4 = 0;
            while (i3 < iArr[0] && !z2) {
                int i19 = i3 + 1;
                int i20 = iArr[i3];
                if (i20 < 900) {
                    i18++;
                    j4 = (j4 * 900) + ((long) i20);
                    i17 = i19;
                } else {
                    if (i20 != 900 && i20 != 901 && i20 != i10 && i20 != 924 && i20 != i9) {
                        if (i20 != 923) {
                            if (i20 != 922) {
                                i17 = i19;
                            }
                            i17 = i19 - 1;
                            z2 = true;
                        }
                    }
                    i17 = i19 - 1;
                    z2 = true;
                }
                if (i18 % 5 == 0 && i18 > 0) {
                    for (int i21 = 0; i21 < 6; i21++) {
                        byteArrayOutputStream.write((byte) ((int) (j4 >> ((5 - i21) * 8))));
                    }
                    i18 = 0;
                    j4 = 0;
                }
                i9 = 928;
                i10 = 902;
            }
        } else {
            i3 = i2;
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i3;
    }

    private static int b(int[] iArr, int i, StringBuilder sb) throws f {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i3 == iArr[0]) {
                z = true;
            }
            if (i4 < 900) {
                iArr2[i2] = i4;
                i2++;
            } else if (i4 == 900 || i4 == 901 || i4 == 924 || i4 == 928 || i4 == 923 || i4 == 922) {
                i3--;
                z = true;
            }
            if ((i2 % 15 == 0 || i4 == 902 || z) && i2 > 0) {
                sb.append(a(iArr2, i2));
                i2 = 0;
            }
            i = i3;
        }
        return i;
    }

    private static String a(int[] iArr, int i) throws f {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(d[(i - i2) - 1].multiply(BigInteger.valueOf((long) iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw f.a();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\f\a\f.java ==========

package a.a.a.f.a;

import java.util.Formatter;

/* compiled from: DetectionResult */
final class f {

    /* renamed from: a  reason: collision with root package name */
    private final a f153a;

    /* renamed from: b  reason: collision with root package name */
    private final g[] f154b = new g[(this.d + 2)];
    private c c;
    private final int d;

    f(a aVar, c cVar) {
        this.f153a = aVar;
        this.d = aVar.a();
        this.c = cVar;
    }

    /* access modifiers changed from: package-private */
    public g[] a() {
        a(this.f154b[0]);
        a(this.f154b[this.d + 1]);
        int i = 928;
        while (true) {
            int f = f();
            if (f > 0 && f < i) {
                i = f;
            }
        }
        return this.f154b;
    }

    private void a(g gVar) {
        if (gVar != null) {
            ((h) gVar).a(this.f153a);
        }
    }

    private int f() {
        int g = g();
        if (g == 0) {
            return 0;
        }
        for (int i = 1; i < this.d + 1; i++) {
            d[] b2 = this.f154b[i].b();
            for (int i2 = 0; i2 < b2.length; i2++) {
                if (b2[i2] != null && !b2[i2].a()) {
                    a(i, i2, b2);
                }
            }
        }
        return g;
    }

    private int g() {
        h();
        return j() + i();
    }

    private void h() {
        if (this.f154b[0] != null && this.f154b[this.d + 1] != null) {
            d[] b2 = this.f154b[0].b();
            d[] b3 = this.f154b[this.d + 1].b();
            for (int i = 0; i < b2.length; i++) {
                if (!(b2[i] == null || b3[i] == null || b2[i].h() != b3[i].h())) {
                    for (int i2 = 1; i2 <= this.d; i2++) {
                        d dVar = this.f154b[i2].b()[i];
                        if (dVar != null) {
                            dVar.b(b2[i].h());
                            if (!dVar.a()) {
                                this.f154b[i2].b()[i] = null;
                            }
                        }
                    }
                }
            }
        }
    }

    private int i() {
        if (this.f154b[this.d + 1] == null) {
            return 0;
        }
        d[] b2 = this.f154b[this.d + 1].b();
        int i = 0;
        for (int i2 = 0; i2 < b2.length; i2++) {
            if (b2[i2] != null) {
                int h = b2[i2].h();
                int i3 = i;
                int i4 = 0;
                for (int i5 = this.d + 1; i5 > 0 && i4 < 2; i5--) {
                    d dVar = this.f154b[i5].b()[i2];
                    if (dVar != null) {
                        i4 = a(h, i4, dVar);
                        if (!dVar.a()) {
                            i3++;
                        }
                    }
                }
                i = i3;
            }
        }
        return i;
    }

    private int j() {
        if (this.f154b[0] == null) {
            return 0;
        }
        d[] b2 = this.f154b[0].b();
        int i = 0;
        for (int i2 = 0; i2 < b2.length; i2++) {
            if (b2[i2] != null) {
                int h = b2[i2].h();
                int i3 = i;
                int i4 = 0;
                for (int i5 = 1; i5 < this.d + 1 && i4 < 2; i5++) {
                    d dVar = this.f154b[i5].b()[i2];
                    if (dVar != null) {
                        i4 = a(h, i4, dVar);
                        if (!dVar.a()) {
                            i3++;
                        }
                    }
                }
                i = i3;
            }
        }
        return i;
    }

    private static int a(int i, int i2, d dVar) {
        if (dVar == null || dVar.a()) {
            return i2;
        }
        if (!dVar.a(i)) {
            return i2 + 1;
        }
        dVar.b(i);
        return 0;
    }

    private void a(int i, int i2, d[] dVarArr) {
        d dVar = dVarArr[i2];
        d[] b2 = this.f154b[i - 1].b();
        int i3 = i + 1;
        d[] b3 = this.f154b[i3] != null ? this.f154b[i3].b() : b2;
        d[] dVarArr2 = new d[14];
        dVarArr2[2] = b2[i2];
        dVarArr2[3] = b3[i2];
        int i4 = 0;
        if (i2 > 0) {
            int i5 = i2 - 1;
            dVarArr2[0] = dVarArr[i5];
            dVarArr2[4] = b2[i5];
            dVarArr2[5] = b3[i5];
        }
        if (i2 > 1) {
            int i6 = i2 - 2;
            dVarArr2[8] = dVarArr[i6];
            dVarArr2[10] = b2[i6];
            dVarArr2[11] = b3[i6];
        }
        if (i2 < dVarArr.length - 1) {
            int i7 = i2 + 1;
            dVarArr2[1] = dVarArr[i7];
            dVarArr2[6] = b2[i7];
            dVarArr2[7] = b3[i7];
        }
        if (i2 < dVarArr.length - 2) {
            int i8 = i2 + 2;
            dVarArr2[9] = dVarArr[i8];
            dVarArr2[12] = b2[i8];
            dVarArr2[13] = b3[i8];
        }
        while (i4 < 14 && !a(dVar, dVarArr2[i4])) {
            i4++;
        }
    }

    private static boolean a(d dVar, d dVar2) {
        if (dVar2 == null || !dVar2.a() || dVar2.f() != dVar.f()) {
            return false;
        }
        dVar.b(dVar2.h());
        return true;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f153a.c();
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f153a.b();
    }

    public void a(c cVar) {
        this.c = cVar;
    }

    /* access modifiers changed from: package-private */
    public c e() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public void a(int i, g gVar) {
        this.f154b[i] = gVar;
    }

    /* access modifiers changed from: package-private */
    public g a(int i) {
        return this.f154b[i];
    }

    public String toString() {
        g gVar = this.f154b[0];
        if (gVar == null) {
            gVar = this.f154b[this.d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i = 0; i < gVar.b().length; i++) {
            formatter.format("CW %3d:", new Object[]{Integer.valueOf(i)});
            for (int i2 = 0; i2 < this.d + 2; i2++) {
                if (this.f154b[i2] == null) {
                    formatter.format("    |   ", new Object[0]);
                } else {
                    d dVar = this.f154b[i2].b()[i];
                    if (dVar == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        formatter.format(" %3d|%3d", new Object[]{Integer.valueOf(dVar.h()), Integer.valueOf(dVar.g())});
                    }
                }
            }
            formatter.format("%n", new Object[0]);
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\f\a\g.java ==========

package a.a.a.f.a;

import java.util.Formatter;

/* compiled from: DetectionResultColumn */
class g {

    /* renamed from: a  reason: collision with root package name */
    private final c f155a;

    /* renamed from: b  reason: collision with root package name */
    private final d[] f156b;

    g(c cVar) {
        this.f155a = new c(cVar);
        this.f156b = new d[((cVar.d() - cVar.c()) + 1)];
    }

    /* access modifiers changed from: package-private */
    public final d a(int i) {
        d dVar;
        d dVar2;
        d c = c(i);
        if (c != null) {
            return c;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int b2 = b(i) - i2;
            if (b2 >= 0 && (dVar2 = this.f156b[b2]) != null) {
                return dVar2;
            }
            int b3 = b(i) + i2;
            if (b3 < this.f156b.length && (dVar = this.f156b[b3]) != null) {
                return dVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final int b(int i) {
        return i - this.f155a.c();
    }

    /* access modifiers changed from: package-private */
    public final void a(int i, d dVar) {
        this.f156b[b(i)] = dVar;
    }

    /* access modifiers changed from: package-private */
    public final d c(int i) {
        return this.f156b[b(i)];
    }

    /* access modifiers changed from: package-private */
    public final c a() {
        return this.f155a;
    }

    /* access modifiers changed from: package-private */
    public final d[] b() {
        return this.f156b;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        int i = 0;
        for (d dVar : this.f156b) {
            if (dVar == null) {
                formatter.format("%3d:    |   %n", new Object[]{Integer.valueOf(i)});
                i++;
            } else {
                formatter.format("%3d: %3d|%3d%n", new Object[]{Integer.valueOf(i), Integer.valueOf(dVar.h()), Integer.valueOf(dVar.g())});
                i++;
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\f\a\h.java ==========

package a.a.a.f.a;

import a.a.a.o;

/* compiled from: DetectionResultRowIndicatorColumn */
final class h extends g {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f157a;

    h(c cVar, boolean z) {
        super(cVar);
        this.f157a = z;
    }

    private void f() {
        for (d dVar : b()) {
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        d[] b2 = b();
        f();
        a(b2, aVar);
        c a2 = a();
        o e = this.f157a ? a2.e() : a2.f();
        o g = this.f157a ? a2.g() : a2.h();
        int b3 = b((int) e.b());
        int b4 = b((int) g.b());
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        while (b3 < b4) {
            if (b2[b3] != null) {
                d dVar = b2[b3];
                int h = dVar.h() - i;
                if (h == 0) {
                    i2++;
                } else {
                    if (h == 1) {
                        i3 = Math.max(i3, i2);
                        i = dVar.h();
                    } else if (h < 0 || dVar.h() >= aVar.c() || h > b3) {
                        b2[b3] = null;
                    } else {
                        if (i3 > 2) {
                            h *= i3 - 2;
                        }
                        boolean z = h >= b3;
                        for (int i4 = 1; i4 <= h && !z; i4++) {
                            z = b2[b3 - i4] != null;
                        }
                        if (z) {
                            b2[b3] = null;
                        } else {
                            i = dVar.h();
                        }
                    }
                    i2 = 1;
                }
            }
            b3++;
        }
    }

    /* access modifiers changed from: package-private */
    public int[] c() {
        int h;
        a d = d();
        if (d == null) {
            return null;
        }
        b(d);
        int[] iArr = new int[d.c()];
        for (d dVar : b()) {
            if (dVar != null && (h = dVar.h()) < iArr.length) {
                iArr[h] = iArr[h] + 1;
            }
        }
        return iArr;
    }

    private void b(a aVar) {
        c a2 = a();
        o e = this.f157a ? a2.e() : a2.f();
        o g = this.f157a ? a2.g() : a2.h();
        int b2 = b((int) g.b());
        d[] b3 = b();
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        for (int b4 = b((int) e.b()); b4 < b2; b4++) {
            if (b3[b4] != null) {
                d dVar = b3[b4];
                dVar.b();
                int h = dVar.h() - i;
                if (h == 0) {
                    i2++;
                } else {
                    if (h == 1) {
                        i3 = Math.max(i3, i2);
                        i = dVar.h();
                    } else if (dVar.h() >= aVar.c()) {
                        b3[b4] = null;
                    } else {
                        i = dVar.h();
                    }
                    i2 = 1;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public a d() {
        d[] b2 = b();
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        b bVar4 = new b();
        for (d dVar : b2) {
            if (dVar != null) {
                dVar.b();
                int g = dVar.g() % 30;
                int h = dVar.h();
                if (!this.f157a) {
                    h += 2;
                }
                switch (h % 3) {
                    case 0:
                        bVar2.a((g * 3) + 1);
                        break;
                    case 1:
                        bVar4.a(g / 3);
                        bVar3.a(g % 3);
                        break;
                    case 2:
                        bVar.a(g + 1);
                        break;
                }
            }
        }
        if (bVar.a().length == 0 || bVar2.a().length == 0 || bVar3.a().length == 0 || bVar4.a().length == 0 || bVar.a()[0] <= 0 || bVar2.a()[0] + bVar3.a()[0] < 3 || bVar2.a()[0] + bVar3.a()[0] > 90) {
            return null;
        }
        a aVar = new a(bVar.a()[0], bVar2.a()[0], bVar3.a()[0], bVar4.a()[0]);
        a(b2, aVar);
        return aVar;
    }

    private void a(d[] dVarArr, a aVar) {
        for (int i = 0; i < dVarArr.length; i++) {
            d dVar = dVarArr[i];
            if (dVarArr[i] != null) {
                int g = dVar.g() % 30;
                int h = dVar.h();
                if (h <= aVar.c()) {
                    if (!this.f157a) {
                        h += 2;
                    }
                    switch (h % 3) {
                        case 0:
                            if ((g * 3) + 1 == aVar.d()) {
                                break;
                            } else {
                                dVarArr[i] = null;
                                break;
                            }
                        case 1:
                            if (g / 3 != aVar.b() || g % 3 != aVar.e()) {
                                dVarArr[i] = null;
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (g + 1 == aVar.a()) {
                                break;
                            } else {
                                dVarArr[i] = null;
                                break;
                            }
                    }
                } else {
                    dVarArr[i] = null;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return this.f157a;
    }

    public String toString() {
        return "IsLeft: " + this.f157a + 10 + super.toString();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\f\a\i.java ==========

package a.a.a.f.a;

import a.a.a.f.a;
import java.lang.reflect.Array;
import net.fxgear.GlobalDefine;

/* compiled from: PDF417CodewordDecoder */
final class i {

    /* renamed from: a  reason: collision with root package name */
    private static final float[][] f158a = ((float[][]) Array.newInstance(float.class, new int[]{a.f134a.length, 8}));

    static {
        int i;
        for (int i2 = 0; i2 < a.f134a.length; i2++) {
            int i3 = a.f134a[i2];
            int i4 = i3 & 1;
            int i5 = i3;
            int i6 = 0;
            while (i6 < 8) {
                float f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                while (true) {
                    i = i5 & 1;
                    if (i != i4) {
                        break;
                    }
                    f += 1.0f;
                    i5 >>= 1;
                }
                f158a[i2][(8 - i6) - 1] = f / 17.0f;
                i6++;
                i4 = i;
            }
        }
    }

    static int a(int[] iArr) {
        int c = c(b(iArr));
        if (c != -1) {
            return c;
        }
        return e(iArr);
    }

    private static int[] b(int[] iArr) {
        float a2 = (float) a.a.a.b.a.a.a(iArr);
        int[] iArr2 = new int[8];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 17; i3++) {
            if (((float) (iArr[i2] + i)) <= (a2 / 34.0f) + ((((float) i3) * a2) / 17.0f)) {
                i += iArr[i2];
                i2++;
            }
            iArr2[i2] = iArr2[i2] + 1;
        }
        return iArr2;
    }

    private static int c(int[] iArr) {
        int d = d(iArr);
        if (a.a(d) == -1) {
            return -1;
        }
        return d;
    }

    private static int d(int[] iArr) {
        long j = 0;
        int i = 0;
        while (i < iArr.length) {
            long j2 = j;
            for (int i2 = 0; i2 < iArr[i]; i2++) {
                int i3 = 1;
                long j3 = j2 << 1;
                if (i % 2 != 0) {
                    i3 = 0;
                }
                j2 = j3 | ((long) i3);
            }
            i++;
            j = j2;
        }
        return (int) j;
    }

    private static int e(int[] iArr) {
        int a2 = a.a.a.b.a.a.a(iArr);
        float[] fArr = new float[8];
        for (int i = 0; i < 8; i++) {
            fArr[i] = ((float) iArr[i]) / ((float) a2);
        }
        int i2 = -1;
        float f = Float.MAX_VALUE;
        for (int i3 = 0; i3 < f158a.length; i3++) {
            float[] fArr2 = f158a[i3];
            float f2 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            for (int i4 = 0; i4 < 8; i4++) {
                float f3 = fArr2[i4] - fArr[i4];
                f2 += f3 * f3;
                if (f2 >= f) {
                    break;
                }
            }
            if (f2 < f) {
                i2 = a.f134a[i3];
                f = f2;
            }
        }
        return i2;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\f\a\j.java ==========

package a.a.a.f.a;

import a.a.a.b.b;
import a.a.a.b.e;
import a.a.a.d;
import a.a.a.f;
import a.a.a.f.a.a.a;
import a.a.a.i;
import a.a.a.o;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: PDF417ScanningDecoder */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static final a f159a = new a();

    private static int a(int i) {
        return 2 << i;
    }

    private static boolean a(int i, int i2, int i3) {
        return i2 + -2 <= i && i <= i3 + 2;
    }

    public static e a(b bVar, o oVar, o oVar2, o oVar3, o oVar4, int i, int i2) throws i, f, d {
        h hVar;
        g gVar;
        int i3;
        int i4;
        h hVar2 = null;
        f fVar = null;
        h hVar3 = null;
        c cVar = new c(bVar, oVar, oVar2, oVar3, oVar4);
        int i5 = 0;
        while (true) {
            if (i5 >= 2) {
                hVar = hVar2;
                break;
            }
            if (oVar != null) {
                hVar2 = a(bVar, cVar, oVar, true, i, i2);
            }
            hVar = hVar2;
            if (oVar3 != null) {
                hVar3 = a(bVar, cVar, oVar3, false, i, i2);
            }
            fVar = a(hVar, hVar3);
            if (fVar == null) {
                throw i.a();
            } else if (i5 != 0 || fVar.e() == null || (fVar.e().c() >= cVar.c() && fVar.e().d() <= cVar.d())) {
                fVar.a(cVar);
            } else {
                cVar = fVar.e();
                i5++;
                hVar2 = hVar;
            }
        }
        int b2 = fVar.b() + 1;
        fVar.a(0, (g) hVar);
        fVar.a(b2, (g) hVar3);
        boolean z = hVar != null;
        int i6 = i;
        int i7 = i2;
        for (int i8 = 1; i8 <= b2; i8++) {
            int i9 = z ? i8 : b2 - i8;
            if (fVar.a(i9) == null) {
                if (i9 == 0 || i9 == b2) {
                    gVar = new h(cVar, i9 == 0);
                } else {
                    gVar = new g(cVar);
                }
                fVar.a(i9, gVar);
                int c = cVar.c();
                int i10 = i7;
                int i11 = i6;
                int i12 = -1;
                while (c <= cVar.d()) {
                    int a2 = a(fVar, i9, c, z);
                    if (a2 >= 0 && a2 <= cVar.b()) {
                        i4 = a2;
                    } else if (i12 != -1) {
                        i4 = i12;
                    } else {
                        i3 = i10;
                        i10 = i3;
                        c++;
                    }
                    int i13 = i10;
                    d a3 = a(bVar, cVar.a(), cVar.b(), z, i4, c, i11, i13);
                    if (a3 != null) {
                        gVar.a(c, a3);
                        i11 = Math.min(i11, a3.c());
                        i10 = Math.max(i13, a3.c());
                        i12 = i4;
                        c++;
                    } else {
                        i3 = i13;
                        i10 = i3;
                        c++;
                    }
                }
                i6 = i11;
                i7 = i10;
            }
        }
        return a(fVar);
    }

    private static f a(h hVar, h hVar2) throws i {
        a b2;
        if ((hVar == null && hVar2 == null) || (b2 = b(hVar, hVar2)) == null) {
            return null;
        }
        return new f(b2, c.a(a(hVar), a(hVar2)));
    }

    private static c a(h hVar) throws i {
        int[] c;
        if (hVar == null || (c = hVar.c()) == null) {
            return null;
        }
        int a2 = a(c);
        int i = 0;
        int i2 = 0;
        for (int i3 : c) {
            i2 += a2 - i3;
            if (i3 > 0) {
                break;
            }
        }
        d[] b2 = hVar.b();
        int i4 = 0;
        while (i2 > 0 && b2[i4] == null) {
            i2--;
            i4++;
        }
        for (int length = c.length - 1; length >= 0; length--) {
            i += a2 - c[length];
            if (c[length] > 0) {
                break;
            }
        }
        int length2 = b2.length - 1;
        while (i > 0 && b2[length2] == null) {
            i--;
            length2--;
        }
        return hVar.a().a(i2, i, hVar.e());
    }

    private static int a(int[] iArr) {
        int i = -1;
        for (int max : iArr) {
            i = Math.max(i, max);
        }
        return i;
    }

    private static a b(h hVar, h hVar2) {
        a d;
        a d2;
        if (hVar == null || (d = hVar.d()) == null) {
            if (hVar2 == null) {
                return null;
            }
            return hVar2.d();
        } else if (hVar2 == null || (d2 = hVar2.d()) == null || d.a() == d2.a() || d.b() == d2.b() || d.c() == d2.c()) {
            return d;
        } else {
            return null;
        }
    }

    private static h a(b bVar, c cVar, o oVar, boolean z, int i, int i2) {
        boolean z2 = z;
        h hVar = new h(cVar, z2);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int a2 = (int) oVar.a();
            int b2 = (int) oVar.b();
            while (b2 <= cVar.d() && b2 >= cVar.c()) {
                d a3 = a(bVar, 0, bVar.e(), z, a2, b2, i, i2);
                if (a3 != null) {
                    hVar.a(b2, a3);
                    if (z2) {
                        a2 = a3.d();
                    } else {
                        a2 = a3.e();
                    }
                }
                b2 += i4;
            }
            i3++;
        }
        return hVar;
    }

    private static void a(f fVar, b[][] bVarArr) throws i {
        int[] a2 = bVarArr[0][1].a();
        int b2 = (fVar.b() * fVar.c()) - a(fVar.d());
        if (a2.length == 0) {
            if (b2 <= 0 || b2 > 928) {
                throw i.a();
            }
            bVarArr[0][1].a(b2);
        } else if (a2[0] != b2) {
            bVarArr[0][1].a(b2);
        }
    }

    private static e a(f fVar) throws f, d, i {
        b[][] b2 = b(fVar);
        a(fVar, b2);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[(fVar.c() * fVar.b())];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < fVar.c(); i++) {
            int i2 = 0;
            while (i2 < fVar.b()) {
                int i3 = i2 + 1;
                int[] a2 = b2[i][i3].a();
                int b3 = (fVar.b() * i) + i2;
                if (a2.length == 0) {
                    arrayList.add(Integer.valueOf(b3));
                } else if (a2.length == 1) {
                    iArr[b3] = a2[0];
                } else {
                    arrayList3.add(Integer.valueOf(b3));
                    arrayList2.add(a2);
                }
                i2 = i3;
            }
        }
        int[][] iArr2 = new int[arrayList2.size()][];
        for (int i4 = 0; i4 < iArr2.length; i4++) {
            iArr2[i4] = (int[]) arrayList2.get(i4);
        }
        return a(fVar.d(), iArr, a.a.a.f.a.a((Collection<Integer>) arrayList), a.a.a.f.a.a((Collection<Integer>) arrayList3), iArr2);
    }

    private static e a(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws f, d {
        int[] iArr5 = new int[iArr3.length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                for (int i4 = 0; i4 < iArr5.length; i4++) {
                    iArr[iArr3[i4]] = iArr4[i4][iArr5[i4]];
                }
                try {
                    return a(iArr, i, iArr2);
                } catch (d unused) {
                    if (iArr5.length != 0) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= iArr5.length) {
                                break;
                            } else if (iArr5[i5] < iArr4[i5].length - 1) {
                                iArr5[i5] = iArr5[i5] + 1;
                                break;
                            } else {
                                iArr5[i5] = 0;
                                if (i5 != iArr5.length - 1) {
                                    i5++;
                                } else {
                                    throw d.a();
                                }
                            }
                        }
                        i2 = i3;
                    } else {
                        throw d.a();
                    }
                }
            } else {
                throw d.a();
            }
        }
    }

    private static b[][] b(f fVar) {
        int h;
        b[][] bVarArr = (b[][]) Array.newInstance(b.class, new int[]{fVar.c(), fVar.b() + 2});
        for (int i = 0; i < bVarArr.length; i++) {
            for (int i2 = 0; i2 < bVarArr[i].length; i2++) {
                bVarArr[i][i2] = new b();
            }
        }
        int i3 = 0;
        for (g gVar : fVar.a()) {
            if (gVar != null) {
                for (d dVar : gVar.b()) {
                    if (dVar != null && (h = dVar.h()) >= 0 && h < bVarArr.length) {
                        bVarArr[h][i3].a(dVar.g());
                    }
                }
            }
            i3++;
        }
        return bVarArr;
    }

    private static boolean a(f fVar, int i) {
        return i >= 0 && i <= fVar.b() + 1;
    }

    private static int a(f fVar, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        d dVar = null;
        int i4 = i - i3;
        if (a(fVar, i4)) {
            dVar = fVar.a(i4).c(i2);
        }
        if (dVar != null) {
            return z ? dVar.e() : dVar.d();
        }
        d a2 = fVar.a(i).a(i2);
        if (a2 != null) {
            return z ? a2.d() : a2.e();
        }
        if (a(fVar, i4)) {
            a2 = fVar.a(i4).a(i2);
        }
        if (a2 != null) {
            return z ? a2.e() : a2.d();
        }
        int i5 = 0;
        while (true) {
            i -= i3;
            if (!a(fVar, i)) {
                return z ? fVar.e().a() : fVar.e().b();
            }
            for (d dVar2 : fVar.a(i).b()) {
                if (dVar2 != null) {
                    return (z ? dVar2.e() : dVar2.d()) + (i3 * i5 * (dVar2.e() - dVar2.d()));
                }
            }
            i5++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        r7 = a.a.a.f.a.i.a(r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static a.a.a.f.a.d a(a.a.a.b.b r7, int r8, int r9, boolean r10, int r11, int r12, int r13, int r14) {
        /*
            int r11 = b(r7, r8, r9, r10, r11, r12)
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            int[] r7 = a((a.a.a.b.b) r0, (int) r1, (int) r2, (boolean) r3, (int) r4, (int) r5)
            r8 = 0
            if (r7 != 0) goto L_0x0012
            return r8
        L_0x0012:
            int r9 = a.a.a.b.a.a.a((int[]) r7)
            if (r10 == 0) goto L_0x001e
            int r10 = r11 + r9
            r6 = r11
            r11 = r10
            r10 = r6
            goto L_0x0039
        L_0x001e:
            r10 = 0
        L_0x001f:
            int r12 = r7.length
            int r12 = r12 / 2
            if (r10 >= r12) goto L_0x0037
            r12 = r7[r10]
            int r0 = r7.length
            int r0 = r0 + -1
            int r0 = r0 - r10
            r0 = r7[r0]
            r7[r10] = r0
            int r0 = r7.length
            int r0 = r0 + -1
            int r0 = r0 - r10
            r7[r0] = r12
            int r10 = r10 + 1
            goto L_0x001f
        L_0x0037:
            int r10 = r11 - r9
        L_0x0039:
            boolean r9 = a((int) r9, (int) r13, (int) r14)
            if (r9 != 0) goto L_0x0040
            return r8
        L_0x0040:
            int r7 = a.a.a.f.a.i.a(r7)
            int r9 = a.a.a.f.a.a((int) r7)
            r12 = -1
            if (r9 != r12) goto L_0x004c
            return r8
        L_0x004c:
            a.a.a.f.a.d r8 = new a.a.a.f.a.d
            int r7 = c(r7)
            r8.<init>(r10, r11, r7, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.f.a.j.a(a.a.a.b.b, int, int, boolean, int, int, int, int):a.a.a.f.a.d");
    }

    private static int[] a(b bVar, int i, int i2, boolean z, int i3, int i4) {
        int[] iArr = new int[8];
        int i5 = z ? 1 : -1;
        boolean z2 = z;
        int i6 = 0;
        while (true) {
            if (!z) {
                if (i3 < i) {
                    break;
                }
            } else if (i3 >= i2) {
                break;
            }
            if (i6 >= 8) {
                break;
            } else if (bVar.a(i3, i4) == z2) {
                iArr[i6] = iArr[i6] + 1;
                i3 += i5;
            } else {
                i6++;
                z2 = !z2;
            }
        }
        if (i6 != 8) {
            if (z) {
                i = i2;
            }
            if (!(i3 == i && i6 == 7)) {
                return null;
            }
        }
        return iArr;
    }

    private static int b(b bVar, int i, int i2, boolean z, int i3, int i4) {
        boolean z2 = z;
        int i5 = z ? -1 : 1;
        int i6 = i3;
        for (int i7 = 0; i7 < 2; i7++) {
            while (true) {
                if (!z2) {
                    if (i6 >= i2) {
                        break;
                    }
                } else if (i6 < i) {
                    break;
                }
                if (z2 != bVar.a(i6, i4)) {
                    break;
                } else if (Math.abs(i3 - i6) > 2) {
                    return i3;
                } else {
                    i6 += i5;
                }
            }
            i5 = -i5;
            z2 = !z2;
        }
        return i6;
    }

    private static e a(int[] iArr, int i, int[] iArr2) throws f, d {
        if (iArr.length != 0) {
            int i2 = 1 << (i + 1);
            int a2 = a(iArr, iArr2, i2);
            a(iArr, i2);
            e a3 = e.a(iArr, String.valueOf(i));
            a3.a(Integer.valueOf(a2));
            a3.b(Integer.valueOf(iArr2.length));
            return a3;
        }
        throw f.a();
    }

    private static int a(int[] iArr, int[] iArr2, int i) throws d {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return f159a.a(iArr, i, iArr2);
        }
        throw d.a();
    }

    private static void a(int[] iArr, int i) throws f {
        if (iArr.length >= 4) {
            int i2 = iArr[0];
            if (i2 > iArr.length) {
                throw f.a();
            } else if (i2 != 0) {
            } else {
                if (i < iArr.length) {
                    iArr[0] = iArr.length - i;
                    return;
                }
                throw f.a();
            }
        } else {
            throw f.a();
        }
    }

    private static int[] b(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i & 1;
            if (i4 != i2) {
                i3--;
                if (i3 < 0) {
                    return iArr;
                }
                i2 = i4;
            }
            iArr[i3] = iArr[i3] + 1;
            i >>= 1;
        }
    }

    private static int c(int i) {
        return b(b(i));
    }

    private static int b(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\f\a\a\a.java ==========

package a.a.a.f.a.a;

import a.a.a.d;

/* compiled from: ErrorCorrection */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f138a = b.f139a;

    public int a(int[] iArr, int i, int[] iArr2) throws d {
        c cVar = new c(this.f138a, iArr);
        int[] iArr3 = new int[i];
        int i2 = 0;
        boolean z = false;
        for (int i3 = i; i3 > 0; i3--) {
            int b2 = cVar.b(this.f138a.a(i3));
            iArr3[i - i3] = b2;
            if (b2 != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        c b3 = this.f138a.b();
        if (iArr2 != null) {
            c cVar2 = b3;
            for (int length : iArr2) {
                cVar2 = cVar2.c(new c(this.f138a, new int[]{this.f138a.c(0, this.f138a.a((iArr.length - 1) - length)), 1}));
            }
        }
        c[] a2 = a(this.f138a.a(i, 1), new c(this.f138a, iArr3), i);
        c cVar3 = a2[0];
        c cVar4 = a2[1];
        int[] a3 = a(cVar3);
        int[] a4 = a(cVar4, cVar3, a3);
        while (i2 < a3.length) {
            int length2 = (iArr.length - 1) - this.f138a.b(a3[i2]);
            if (length2 >= 0) {
                iArr[length2] = this.f138a.c(iArr[length2], a4[i2]);
                i2++;
            } else {
                throw d.a();
            }
        }
        return a3.length;
    }

    private c[] a(c cVar, c cVar2, int i) throws d {
        if (cVar.a() < cVar2.a()) {
            c cVar3 = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
        }
        c a2 = this.f138a.a();
        c b2 = this.f138a.b();
        c cVar4 = cVar2;
        c cVar5 = cVar;
        c cVar6 = cVar4;
        while (cVar6.a() >= i / 2) {
            if (!cVar6.b()) {
                c a3 = this.f138a.a();
                int c = this.f138a.c(cVar6.a(cVar6.a()));
                while (cVar5.a() >= cVar6.a() && !cVar5.b()) {
                    int a4 = cVar5.a() - cVar6.a();
                    int d = this.f138a.d(cVar5.a(cVar5.a()), c);
                    a3 = a3.a(this.f138a.a(a4, d));
                    cVar5 = cVar5.b(cVar6.a(a4, d));
                }
                c cVar7 = cVar5;
                cVar5 = cVar6;
                cVar6 = cVar7;
                c cVar8 = b2;
                b2 = a3.c(b2).b(a2).c();
                a2 = cVar8;
            } else {
                throw d.a();
            }
        }
        int a5 = b2.a(0);
        if (a5 != 0) {
            int c2 = this.f138a.c(a5);
            return new c[]{b2.c(c2), cVar6.c(c2)};
        }
        throw d.a();
    }

    private int[] a(c cVar) throws d {
        int a2 = cVar.a();
        int[] iArr = new int[a2];
        int i = 0;
        for (int i2 = 1; i2 < this.f138a.c() && i < a2; i2++) {
            if (cVar.b(i2) == 0) {
                iArr[i] = this.f138a.c(i2);
                i++;
            }
        }
        if (i == a2) {
            return iArr;
        }
        throw d.a();
    }

    private int[] a(c cVar, c cVar2, int[] iArr) {
        int a2 = cVar2.a();
        int[] iArr2 = new int[a2];
        for (int i = 1; i <= a2; i++) {
            iArr2[a2 - i] = this.f138a.d(i, cVar2.a(i));
        }
        c cVar3 = new c(this.f138a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int c = this.f138a.c(iArr[i2]);
            iArr3[i2] = this.f138a.d(this.f138a.c(0, cVar.b(c)), this.f138a.c(cVar3.b(c)));
        }
        return iArr3;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\f\a\a\b.java ==========

package a.a.a.f.a.a;

/* compiled from: ModulusGF */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f139a = new b(929, 3);

    /* renamed from: b  reason: collision with root package name */
    private final int[] f140b;
    private final int[] c;
    private final c d;
    private final c e;
    private final int f;

    private b(int i, int i2) {
        this.f = i;
        this.f140b = new int[i];
        this.c = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            this.f140b[i4] = i3;
            i3 = (i3 * i2) % i;
        }
        for (int i5 = 0; i5 < i - 1; i5++) {
            this.c[this.f140b[i5]] = i5;
        }
        this.d = new c(this, new int[]{0});
        this.e = new c(this, new int[]{1});
    }

    /* access modifiers changed from: package-private */
    public c a() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public c b() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public c a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.d;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new c(this, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    public int b(int i, int i2) {
        return (i + i2) % this.f;
    }

    /* access modifiers changed from: package-private */
    public int c(int i, int i2) {
        return ((this.f + i) - i2) % this.f;
    }

    /* access modifiers changed from: package-private */
    public int a(int i) {
        return this.f140b[i];
    }

    /* access modifiers changed from: package-private */
    public int b(int i) {
        if (i != 0) {
            return this.c[i];
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public int c(int i) {
        if (i != 0) {
            return this.f140b[(this.f - this.c[i]) - 1];
        }
        throw new ArithmeticException();
    }

    /* access modifiers changed from: package-private */
    public int d(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        return this.f140b[(this.c[i] + this.c[i2]) % (this.f - 1)];
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\f\a\a\c.java ==========

package a.a.a.f.a.a;

/* compiled from: ModulusPoly */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private final b f141a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f142b;

    c(b bVar, int[] iArr) {
        if (iArr.length != 0) {
            this.f141a = bVar;
            int length = iArr.length;
            if (length <= 1 || iArr[0] != 0) {
                this.f142b = iArr;
                return;
            }
            int i = 1;
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.f142b = new int[]{0};
                return;
            }
            this.f142b = new int[(length - i)];
            System.arraycopy(iArr, i, this.f142b, 0, this.f142b.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f142b.length - 1;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f142b[0] == 0;
    }

    /* access modifiers changed from: package-private */
    public int a(int i) {
        return this.f142b[(this.f142b.length - 1) - i];
    }

    /* access modifiers changed from: package-private */
    public int b(int i) {
        if (i == 0) {
            return a(0);
        }
        if (i == 1) {
            int i2 = 0;
            for (int b2 : this.f142b) {
                i2 = this.f141a.b(i2, b2);
            }
            return i2;
        }
        int i3 = this.f142b[0];
        int length = this.f142b.length;
        for (int i4 = 1; i4 < length; i4++) {
            i3 = this.f141a.b(this.f141a.d(i, i3), this.f142b[i4]);
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public c a(c cVar) {
        if (!this.f141a.equals(cVar.f141a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (b()) {
            return cVar;
        } else {
            if (cVar.b()) {
                return this;
            }
            int[] iArr = this.f142b;
            int[] iArr2 = cVar.f142b;
            if (iArr.length > iArr2.length) {
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            int[] iArr4 = new int[iArr2.length];
            int length = iArr2.length - iArr.length;
            System.arraycopy(iArr2, 0, iArr4, 0, length);
            for (int i = length; i < iArr2.length; i++) {
                iArr4[i] = this.f141a.b(iArr[i - length], iArr2[i]);
            }
            return new c(this.f141a, iArr4);
        }
    }

    /* access modifiers changed from: package-private */
    public c b(c cVar) {
        if (!this.f141a.equals(cVar.f141a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (cVar.b()) {
            return this;
        } else {
            return a(cVar.c());
        }
    }

    /* access modifiers changed from: package-private */
    public c c(c cVar) {
        if (!this.f141a.equals(cVar.f141a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (b() || cVar.b()) {
            return this.f141a.a();
        } else {
            int[] iArr = this.f142b;
            int length = iArr.length;
            int[] iArr2 = cVar.f142b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i + i3;
                    iArr3[i4] = this.f141a.b(iArr3[i4], this.f141a.d(i2, iArr2[i3]));
                }
            }
            return new c(this.f141a, iArr3);
        }
    }

    /* access modifiers changed from: package-private */
    public c c() {
        int length = this.f142b.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.f141a.c(0, this.f142b[i]);
        }
        return new c(this.f141a, iArr);
    }

    /* access modifiers changed from: package-private */
    public c c(int i) {
        if (i == 0) {
            return this.f141a.a();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f142b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f141a.d(this.f142b[i2], i);
        }
        return new c(this.f141a, iArr);
    }

    /* access modifiers changed from: package-private */
    public c a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f141a.a();
        } else {
            int length = this.f142b.length;
            int[] iArr = new int[(i + length)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.f141a.d(this.f142b[i3], i2);
            }
            return new c(this.f141a, iArr);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(a() * 8);
        for (int a2 = a(); a2 >= 0; a2--) {
            int a3 = a(a2);
            if (a3 != 0) {
                if (a3 < 0) {
                    sb.append(" - ");
                    a3 = -a3;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (a2 == 0 || a3 != 1) {
                    sb.append(a3);
                }
                if (a2 != 0) {
                    if (a2 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(a2);
                    }
                }
            }
        }
        return sb.toString();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\f\b\a.java ==========

package a.a.a.f.b;

import a.a.a.b.b;
import a.a.a.c;
import a.a.a.e;
import a.a.a.i;
import a.a.a.o;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import net.fxgear.GlobalDefine;

/* compiled from: Detector */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f160a = {0, 4, 1, 5};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f161b = {6, 2, 7, 3};
    private static final int[] c = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    public static b a(c cVar, Map<e, ?> map, boolean z) throws i {
        b c2 = cVar.c();
        List<o[]> a2 = a(z, c2);
        if (a2.isEmpty()) {
            c2 = c2.clone();
            c2.a();
            a2 = a(z, c2);
        }
        return new b(c2, a2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        if (r4.hasNext() == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r5 = (a.a.a.o[]) r4.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r5[1] == null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        r3 = (int) java.lang.Math.max((float) r3, r5[1].b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        if (r5[3] == null) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        r3 = java.lang.Math.max(r3, (int) r5[3].b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r5 == false) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r4 = r0.iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<a.a.a.o[]> a(boolean r8, a.a.a.b.b r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 1
            r2 = 0
            r3 = 0
        L_0x0008:
            r4 = 0
            r5 = 0
        L_0x000a:
            int r6 = r9.f()
            if (r3 >= r6) goto L_0x007d
            a.a.a.o[] r4 = a((a.a.a.b.b) r9, (int) r3, (int) r4)
            r6 = r4[r2]
            if (r6 != 0) goto L_0x0052
            r6 = 3
            r7 = r4[r6]
            if (r7 != 0) goto L_0x0052
            if (r5 == 0) goto L_0x007d
            java.util.Iterator r4 = r0.iterator()
        L_0x0023:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x004f
            java.lang.Object r5 = r4.next()
            a.a.a.o[] r5 = (a.a.a.o[]) r5
            r7 = r5[r1]
            if (r7 == 0) goto L_0x003f
            float r3 = (float) r3
            r7 = r5[r1]
            float r7 = r7.b()
            float r3 = java.lang.Math.max(r3, r7)
            int r3 = (int) r3
        L_0x003f:
            r7 = r5[r6]
            if (r7 == 0) goto L_0x0023
            r5 = r5[r6]
            float r5 = r5.b()
            int r5 = (int) r5
            int r3 = java.lang.Math.max(r3, r5)
            goto L_0x0023
        L_0x004f:
            int r3 = r3 + 5
            goto L_0x0008
        L_0x0052:
            r0.add(r4)
            if (r8 == 0) goto L_0x007d
            r3 = 2
            r5 = r4[r3]
            if (r5 == 0) goto L_0x006d
            r5 = r4[r3]
            float r5 = r5.a()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.b()
            int r3 = (int) r3
        L_0x006a:
            r4 = r5
            r5 = 1
            goto L_0x000a
        L_0x006d:
            r3 = 4
            r5 = r4[r3]
            float r5 = r5.a()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.b()
            int r3 = (int) r3
            goto L_0x006a
        L_0x007d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.f.b.a.a(boolean, a.a.a.b.b):java.util.List");
    }

    private static o[] a(b bVar, int i, int i2) {
        int f = bVar.f();
        int e = bVar.e();
        o[] oVarArr = new o[8];
        a(oVarArr, a(bVar, f, e, i, i2, c), f160a);
        if (oVarArr[4] != null) {
            i2 = (int) oVarArr[4].a();
            i = (int) oVarArr[4].b();
        }
        a(oVarArr, a(bVar, f, e, i, i2, d), f161b);
        return oVarArr;
    }

    private static void a(o[] oVarArr, o[] oVarArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            oVarArr[iArr[i]] = oVarArr2[i];
        }
    }

    private static o[] a(b bVar, int i, int i2, int i3, int i4, int[] iArr) {
        int i5;
        boolean z;
        int i6;
        int i7;
        int[] iArr2;
        int i8 = i;
        o[] oVarArr = new o[4];
        int[] iArr3 = new int[iArr.length];
        int i9 = i3;
        while (true) {
            if (i9 >= i8) {
                z = false;
                break;
            }
            int[] a2 = a(bVar, i4, i9, i2, false, iArr, iArr3);
            if (a2 != null) {
                while (true) {
                    iArr2 = a2;
                    if (i9 <= 0) {
                        break;
                    }
                    i9--;
                    a2 = a(bVar, i4, i9, i2, false, iArr, iArr3);
                    if (a2 == null) {
                        i9++;
                        break;
                    }
                }
                float f = (float) i9;
                oVarArr[0] = new o((float) iArr2[0], f);
                oVarArr[1] = new o((float) iArr2[1], f);
                z = true;
            } else {
                i9 += 5;
            }
        }
        int i10 = i9 + 1;
        if (z) {
            int[] iArr4 = {(int) oVarArr[0].a(), (int) oVarArr[1].a()};
            int i11 = i10;
            int i12 = 0;
            while (true) {
                if (i11 >= i8) {
                    i6 = i12;
                    i7 = i11;
                    break;
                }
                i6 = i12;
                i7 = i11;
                int[] a3 = a(bVar, iArr4[0], i11, i2, false, iArr, iArr3);
                if (a3 == null || Math.abs(iArr4[0] - a3[0]) >= 5 || Math.abs(iArr4[1] - a3[1]) >= 5) {
                    if (i6 > 25) {
                        break;
                    }
                    i12 = i6 + 1;
                } else {
                    iArr4 = a3;
                    i12 = 0;
                }
                i11 = i7 + 1;
            }
            i10 = i7 - (i6 + 1);
            float f2 = (float) i10;
            oVarArr[2] = new o((float) iArr4[0], f2);
            oVarArr[3] = new o((float) iArr4[1], f2);
        }
        if (i10 - i9 < 10) {
            for (i5 = 0; i5 < 4; i5++) {
                oVarArr[i5] = null;
            }
        }
        return oVarArr;
    }

    private static int[] a(b bVar, int i, int i2, int i3, boolean z, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (bVar.a(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        int length = iArr.length;
        int i6 = i;
        int i7 = 0;
        while (true) {
            boolean z2 = true;
            if (i < i3) {
                if (bVar.a(i, i2) ^ z) {
                    iArr2[i7] = iArr2[i7] + 1;
                } else {
                    int i8 = length - 1;
                    if (i7 != i8) {
                        i7++;
                    } else if (a(iArr2, iArr, 0.8f) < 0.42f) {
                        return new int[]{i6, i};
                    } else {
                        i6 += iArr2[0] + iArr2[1];
                        int i9 = length - 2;
                        System.arraycopy(iArr2, 2, iArr2, 0, i9);
                        iArr2[i9] = 0;
                        iArr2[i8] = 0;
                        i7--;
                    }
                    iArr2[i7] = 1;
                    if (z) {
                        z2 = false;
                    }
                    z = z2;
                }
                i++;
            } else if (i7 != length - 1 || a(iArr2, iArr, 0.8f) >= 0.42f) {
                return null;
            } else {
                return new int[]{i6, i - 1};
            }
        }
    }

    private static float a(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = (float) i;
        float f3 = f2 / ((float) i2);
        float f4 = f * f3;
        float f5 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f6 = ((float) iArr2[i4]) * f3;
            float f7 = (float) i5;
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\f\b\b.java ==========

package a.a.a.f.b;

import a.a.a.o;
import java.util.List;

/* compiled from: PDF417DetectorResult */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final a.a.a.b.b f162a;

    /* renamed from: b  reason: collision with root package name */
    private final List<o[]> f163b;

    public b(a.a.a.b.b bVar, List<o[]> list) {
        this.f162a = bVar;
        this.f163b = list;
    }

    public a.a.a.b.b a() {
        return this.f162a;
    }

    public List<o[]> b() {
        return this.f163b;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\g\a.java ==========

package a.a.a.g;

import a.a.a.b.b;
import a.a.a.b.g;
import a.a.a.c;
import a.a.a.d;
import a.a.a.f;
import a.a.a.g.a.e;
import a.a.a.i;
import a.a.a.k;
import a.a.a.m;
import a.a.a.n;
import a.a.a.o;
import java.util.List;
import java.util.Map;

/* compiled from: QRCodeReader */
public class a implements k {

    /* renamed from: a  reason: collision with root package name */
    private static final o[] f168a = new o[0];

    /* renamed from: b  reason: collision with root package name */
    private final e f169b = new e();

    public void a() {
    }

    public final m a(c cVar, Map<a.a.a.e, ?> map) throws i, d, f {
        o[] oVarArr;
        a.a.a.b.e eVar;
        if (map == null || !map.containsKey(a.a.a.e.PURE_BARCODE)) {
            g a2 = new a.a.a.g.b.c(cVar.c()).a(map);
            a.a.a.b.e a3 = this.f169b.a(a2.d(), map);
            oVarArr = a2.e();
            eVar = a3;
        } else {
            eVar = this.f169b.a(a(cVar.c()), map);
            oVarArr = f168a;
        }
        if (eVar.f() instanceof a.a.a.g.a.i) {
            ((a.a.a.g.a.i) eVar.f()).a(oVarArr);
        }
        m mVar = new m(eVar.c(), eVar.a(), oVarArr, a.a.a.a.QR_CODE);
        List<byte[]> d = eVar.d();
        if (d != null) {
            mVar.a(n.BYTE_SEGMENTS, d);
        }
        String e = eVar.e();
        if (e != null) {
            mVar.a(n.ERROR_CORRECTION_LEVEL, e);
        }
        if (eVar.g()) {
            mVar.a(n.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(eVar.i()));
            mVar.a(n.STRUCTURED_APPEND_PARITY, Integer.valueOf(eVar.h()));
        }
        return mVar;
    }

    private static b a(b bVar) throws i {
        int[] c = bVar.c();
        int[] d = bVar.d();
        if (c == null || d == null) {
            throw i.a();
        }
        float a2 = a(c, bVar);
        int i = c[1];
        int i2 = d[1];
        int i3 = c[0];
        int i4 = d[0];
        if (i3 >= i4 || i >= i2) {
            throw i.a();
        }
        int i5 = i2 - i;
        if (i5 == i4 - i3 || (i4 = i3 + i5) < bVar.e()) {
            int round = Math.round(((float) ((i4 - i3) + 1)) / a2);
            int round2 = Math.round(((float) (i5 + 1)) / a2);
            if (round <= 0 || round2 <= 0) {
                throw i.a();
            } else if (round2 == round) {
                int i6 = (int) (a2 / 2.0f);
                int i7 = i + i6;
                int i8 = i3 + i6;
                int i9 = (((int) (((float) (round - 1)) * a2)) + i8) - i4;
                if (i9 > 0) {
                    if (i9 <= i6) {
                        i8 -= i9;
                    } else {
                        throw i.a();
                    }
                }
                int i10 = (((int) (((float) (round2 - 1)) * a2)) + i7) - i2;
                if (i10 > 0) {
                    if (i10 <= i6) {
                        i7 -= i10;
                    } else {
                        throw i.a();
                    }
                }
                b bVar2 = new b(round, round2);
                for (int i11 = 0; i11 < round2; i11++) {
                    int i12 = ((int) (((float) i11) * a2)) + i7;
                    for (int i13 = 0; i13 < round; i13++) {
                        if (bVar.a(((int) (((float) i13) * a2)) + i8, i12)) {
                            bVar2.b(i13, i11);
                        }
                    }
                }
                return bVar2;
            } else {
                throw i.a();
            }
        } else {
            throw i.a();
        }
    }

    private static float a(int[] iArr, b bVar) throws i {
        int f = bVar.f();
        int e = bVar.e();
        int i = iArr[0];
        boolean z = true;
        int i2 = iArr[1];
        int i3 = 0;
        while (i < e && i2 < f) {
            if (z != bVar.a(i, i2)) {
                i3++;
                if (i3 == 5) {
                    break;
                }
                z = !z;
            }
            i++;
            i2++;
        }
        if (i != e && i2 != f) {
            return ((float) (i - iArr[0])) / 7.0f;
        }
        throw i.a();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\g\a\a.java ==========

package a.a.a.g.a;

import a.a.a.b.b;
import a.a.a.f;

/* compiled from: BitMatrixParser */
final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f170a;

    /* renamed from: b  reason: collision with root package name */
    private j f171b;
    private g c;
    private boolean d;

    a(b bVar) throws f {
        int f = bVar.f();
        if (f < 21 || (f & 3) != 1) {
            throw f.a();
        }
        this.f170a = bVar;
    }

    /* access modifiers changed from: package-private */
    public g a() throws f {
        if (this.c != null) {
            return this.c;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 = a(i3, 8, i2);
        }
        int a2 = a(8, 7, a(8, 8, a(7, 8, i2)));
        for (int i4 = 5; i4 >= 0; i4--) {
            a2 = a(8, i4, a2);
        }
        int f = this.f170a.f();
        int i5 = f - 7;
        for (int i6 = f - 1; i6 >= i5; i6--) {
            i = a(8, i6, i);
        }
        for (int i7 = f - 8; i7 < f; i7++) {
            i = a(i7, 8, i);
        }
        this.c = g.b(a2, i);
        if (this.c != null) {
            return this.c;
        }
        throw f.a();
    }

    /* access modifiers changed from: package-private */
    public j b() throws f {
        if (this.f171b != null) {
            return this.f171b;
        }
        int f = this.f170a.f();
        int i = (f - 17) / 4;
        if (i <= 6) {
            return j.b(i);
        }
        int i2 = f - 11;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 5; i5 >= 0; i5--) {
            for (int i6 = f - 9; i6 >= i2; i6--) {
                i4 = a(i6, i5, i4);
            }
        }
        j c2 = j.c(i4);
        if (c2 == null || c2.d() != f) {
            for (int i7 = 5; i7 >= 0; i7--) {
                for (int i8 = f - 9; i8 >= i2; i8--) {
                    i3 = a(i7, i8, i3);
                }
            }
            j c3 = j.c(i3);
            if (c3 == null || c3.d() != f) {
                throw f.a();
            }
            this.f171b = c3;
            return c3;
        }
        this.f171b = c2;
        return c2;
    }

    private int a(int i, int i2, int i3) {
        return this.d ? this.f170a.a(i2, i) : this.f170a.a(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    /* access modifiers changed from: package-private */
    public byte[] c() throws f {
        g a2 = a();
        j b2 = b();
        c cVar = c.values()[a2.b()];
        int f = this.f170a.f();
        cVar.a(this.f170a, f);
        b e = b2.e();
        byte[] bArr = new byte[b2.c()];
        int i = f - 1;
        int i2 = i;
        int i3 = 0;
        boolean z = true;
        int i4 = 0;
        int i5 = 0;
        while (i2 > 0) {
            if (i2 == 6) {
                i2--;
            }
            int i6 = i5;
            int i7 = i4;
            int i8 = i3;
            int i9 = 0;
            while (i9 < f) {
                int i10 = z ? i - i9 : i9;
                int i11 = i7;
                int i12 = i8;
                for (int i13 = 0; i13 < 2; i13++) {
                    int i14 = i2 - i13;
                    if (!e.a(i14, i10)) {
                        i6++;
                        int i15 = i11 << 1;
                        int i16 = this.f170a.a(i14, i10) ? i15 | 1 : i15;
                        if (i6 == 8) {
                            bArr[i12] = (byte) i16;
                            i12++;
                            i6 = 0;
                            i11 = 0;
                        } else {
                            i11 = i16;
                        }
                    }
                }
                i9++;
                i8 = i12;
                i7 = i11;
            }
            z = !z;
            i2 -= 2;
            i3 = i8;
            i4 = i7;
            i5 = i6;
        }
        if (i3 == b2.c()) {
            return bArr;
        }
        throw f.a();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (this.c != null) {
            c.values()[this.c.b()].a(this.f170a, this.f170a.f());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f171b = null;
        this.c = null;
        this.d = z;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        int i = 0;
        while (i < this.f170a.e()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.f170a.f(); i3++) {
                if (this.f170a.a(i, i3) != this.f170a.a(i3, i)) {
                    this.f170a.c(i3, i);
                    this.f170a.c(i, i3);
                }
            }
            i = i2;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\g\a\b.java ==========

package a.a.a.g.a;

import a.a.a.g.a.j;

/* compiled from: DataBlock */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f172a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f173b;

    private b(int i, byte[] bArr) {
        this.f172a = i;
        this.f173b = bArr;
    }

    static b[] a(byte[] bArr, j jVar, f fVar) {
        if (bArr.length == jVar.c()) {
            j.b a2 = jVar.a(fVar);
            j.a[] b2 = a2.b();
            int i = 0;
            for (j.a a3 : b2) {
                i += a3.a();
            }
            b[] bVarArr = new b[i];
            int length = b2.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                j.a aVar = b2[i2];
                int i4 = i3;
                int i5 = 0;
                while (i5 < aVar.a()) {
                    int b3 = aVar.b();
                    bVarArr[i4] = new b(b3, new byte[(a2.a() + b3)]);
                    i5++;
                    i4++;
                }
                i2++;
                i3 = i4;
            }
            int length2 = bVarArr[0].f173b.length;
            int length3 = bVarArr.length - 1;
            while (length3 >= 0 && bVarArr[length3].f173b.length != length2) {
                length3--;
            }
            int i6 = length3 + 1;
            int a4 = length2 - a2.a();
            int i7 = 0;
            int i8 = 0;
            while (i7 < a4) {
                int i9 = i8;
                int i10 = 0;
                while (i10 < i3) {
                    bVarArr[i10].f173b[i7] = bArr[i9];
                    i10++;
                    i9++;
                }
                i7++;
                i8 = i9;
            }
            int i11 = i6;
            while (i11 < i3) {
                bVarArr[i11].f173b[a4] = bArr[i8];
                i11++;
                i8++;
            }
            int length4 = bVarArr[0].f173b.length;
            while (a4 < length4) {
                int i12 = i8;
                int i13 = 0;
                while (i13 < i3) {
                    bVarArr[i13].f173b[i13 < i6 ? a4 : a4 + 1] = bArr[i12];
                    i13++;
                    i12++;
                }
                a4++;
                i8 = i12;
            }
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f172a;
    }

    /* access modifiers changed from: package-private */
    public byte[] b() {
        return this.f173b;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\g\a\c.java ==========

package a.a.a.g.a;

import a.a.a.b.b;

/* compiled from: DataMask */
enum c {
    DATA_MASK_000 {
        /* access modifiers changed from: package-private */
        public boolean a(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    },
    DATA_MASK_001 {
        /* access modifiers changed from: package-private */
        public boolean a(int i, int i2) {
            return (i & 1) == 0;
        }
    },
    DATA_MASK_010 {
        /* access modifiers changed from: package-private */
        public boolean a(int i, int i2) {
            return i2 % 3 == 0;
        }
    },
    DATA_MASK_011 {
        /* access modifiers changed from: package-private */
        public boolean a(int i, int i2) {
            return (i + i2) % 3 == 0;
        }
    },
    DATA_MASK_100 {
        /* access modifiers changed from: package-private */
        public boolean a(int i, int i2) {
            return (((i / 2) + (i2 / 3)) & 1) == 0;
        }
    },
    DATA_MASK_101 {
        /* access modifiers changed from: package-private */
        public boolean a(int i, int i2) {
            return (i * i2) % 6 == 0;
        }
    },
    DATA_MASK_110 {
        /* access modifiers changed from: package-private */
        public boolean a(int i, int i2) {
            return (i * i2) % 6 < 3;
        }
    },
    DATA_MASK_111 {
        /* access modifiers changed from: package-private */
        public boolean a(int i, int i2) {
            return (((i + i2) + ((i * i2) % 3)) & 1) == 0;
        }
    };

    /* access modifiers changed from: package-private */
    public abstract boolean a(int i2, int i3);

    /* access modifiers changed from: package-private */
    public final void a(b bVar, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (a(i3, i4)) {
                    bVar.c(i4, i3);
                }
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\g\a\d.java ==========

package a.a.a.g.a;

import a.a.a.b.c;
import a.a.a.b.l;
import a.a.a.e;
import a.a.a.f;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;

/* compiled from: DecodedBitStreamParser */
final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f176a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e8 A[LOOP:0: B:1:0x001e->B:60:0x00e8, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c6 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static a.a.a.b.e a(byte[] r17, a.a.a.g.a.j r18, a.a.a.g.a.f r19, java.util.Map<a.a.a.e, ?> r20) throws a.a.a.f {
        /*
            r0 = r18
            a.a.a.b.c r7 = new a.a.a.b.c
            r8 = r17
            r7.<init>(r8)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r1 = 50
            r9.<init>(r1)
            java.util.ArrayList r10 = new java.util.ArrayList
            r11 = 1
            r10.<init>(r11)
            r1 = 0
            r2 = -1
            r12 = 0
            r14 = r12
            r13 = 0
            r15 = -1
            r16 = -1
        L_0x001e:
            int r1 = r7.c()     // Catch:{ IllegalArgumentException -> 0x00eb }
            r2 = 4
            if (r1 >= r2) goto L_0x0029
            a.a.a.g.a.h r1 = a.a.a.g.a.h.TERMINATOR     // Catch:{ IllegalArgumentException -> 0x00eb }
        L_0x0027:
            r6 = r1
            goto L_0x0032
        L_0x0029:
            int r1 = r7.a(r2)     // Catch:{ IllegalArgumentException -> 0x00eb }
            a.a.a.g.a.h r1 = a.a.a.g.a.h.a((int) r1)     // Catch:{ IllegalArgumentException -> 0x00eb }
            goto L_0x0027
        L_0x0032:
            a.a.a.g.a.h r1 = a.a.a.g.a.h.TERMINATOR     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r6 == r1) goto L_0x0059
            a.a.a.g.a.h r1 = a.a.a.g.a.h.FNC1_FIRST_POSITION     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r6 == r1) goto L_0x00c0
            a.a.a.g.a.h r1 = a.a.a.g.a.h.FNC1_SECOND_POSITION     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r6 != r1) goto L_0x0040
            goto L_0x00c0
        L_0x0040:
            a.a.a.g.a.h r1 = a.a.a.g.a.h.STRUCTURED_APPEND     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r6 != r1) goto L_0x0061
            int r1 = r7.c()     // Catch:{ IllegalArgumentException -> 0x00eb }
            r2 = 16
            if (r1 < r2) goto L_0x005c
            r1 = 8
            int r2 = r7.a(r1)     // Catch:{ IllegalArgumentException -> 0x00eb }
            int r1 = r7.a(r1)     // Catch:{ IllegalArgumentException -> 0x00eb }
            r16 = r1
            r15 = r2
        L_0x0059:
            r11 = r6
            goto L_0x00c2
        L_0x005c:
            a.a.a.f r0 = a.a.a.f.a()     // Catch:{ IllegalArgumentException -> 0x00eb }
            throw r0     // Catch:{ IllegalArgumentException -> 0x00eb }
        L_0x0061:
            a.a.a.g.a.h r1 = a.a.a.g.a.h.ECI     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r6 != r1) goto L_0x0075
            int r1 = a((a.a.a.b.c) r7)     // Catch:{ IllegalArgumentException -> 0x00eb }
            a.a.a.b.d r14 = a.a.a.b.d.a(r1)     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r14 == 0) goto L_0x0070
            goto L_0x0059
        L_0x0070:
            a.a.a.f r0 = a.a.a.f.a()     // Catch:{ IllegalArgumentException -> 0x00eb }
            throw r0     // Catch:{ IllegalArgumentException -> 0x00eb }
        L_0x0075:
            a.a.a.g.a.h r1 = a.a.a.g.a.h.HANZI     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r6 != r1) goto L_0x008b
            int r1 = r7.a(r2)     // Catch:{ IllegalArgumentException -> 0x00eb }
            int r2 = r6.a((a.a.a.g.a.j) r0)     // Catch:{ IllegalArgumentException -> 0x00eb }
            int r2 = r7.a(r2)     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r1 != r11) goto L_0x0059
            a(r7, r9, r2)     // Catch:{ IllegalArgumentException -> 0x00eb }
            goto L_0x0059
        L_0x008b:
            int r1 = r6.a((a.a.a.g.a.j) r0)     // Catch:{ IllegalArgumentException -> 0x00eb }
            int r3 = r7.a(r1)     // Catch:{ IllegalArgumentException -> 0x00eb }
            a.a.a.g.a.h r1 = a.a.a.g.a.h.NUMERIC     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r6 != r1) goto L_0x009b
            c(r7, r9, r3)     // Catch:{ IllegalArgumentException -> 0x00eb }
            goto L_0x0059
        L_0x009b:
            a.a.a.g.a.h r1 = a.a.a.g.a.h.ALPHANUMERIC     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r6 != r1) goto L_0x00a3
            a((a.a.a.b.c) r7, (java.lang.StringBuilder) r9, (int) r3, (boolean) r13)     // Catch:{ IllegalArgumentException -> 0x00eb }
            goto L_0x0059
        L_0x00a3:
            a.a.a.g.a.h r1 = a.a.a.g.a.h.BYTE     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r6 != r1) goto L_0x00b2
            r1 = r7
            r2 = r9
            r4 = r14
            r5 = r10
            r11 = r6
            r6 = r20
            a(r1, r2, r3, r4, r5, r6)     // Catch:{ IllegalArgumentException -> 0x00eb }
            goto L_0x00c2
        L_0x00b2:
            r11 = r6
            a.a.a.g.a.h r1 = a.a.a.g.a.h.KANJI     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r11 != r1) goto L_0x00bb
            b(r7, r9, r3)     // Catch:{ IllegalArgumentException -> 0x00eb }
            goto L_0x00c2
        L_0x00bb:
            a.a.a.f r0 = a.a.a.f.a()     // Catch:{ IllegalArgumentException -> 0x00eb }
            throw r0     // Catch:{ IllegalArgumentException -> 0x00eb }
        L_0x00c0:
            r11 = r6
            r13 = 1
        L_0x00c2:
            a.a.a.g.a.h r1 = a.a.a.g.a.h.TERMINATOR     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r11 != r1) goto L_0x00e8
            a.a.a.b.e r7 = new a.a.a.b.e
            java.lang.String r2 = r9.toString()
            boolean r0 = r10.isEmpty()
            if (r0 == 0) goto L_0x00d4
            r3 = r12
            goto L_0x00d5
        L_0x00d4:
            r3 = r10
        L_0x00d5:
            if (r19 != 0) goto L_0x00d9
            r4 = r12
            goto L_0x00de
        L_0x00d9:
            java.lang.String r0 = r19.toString()
            r4 = r0
        L_0x00de:
            r0 = r7
            r1 = r17
            r5 = r15
            r6 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r7
        L_0x00e8:
            r11 = 1
            goto L_0x001e
        L_0x00eb:
            a.a.a.f r0 = a.a.a.f.a()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.g.a.d.a(byte[], a.a.a.g.a.j, a.a.a.g.a.f, java.util.Map):a.a.a.b.e");
    }

    private static void a(c cVar, StringBuilder sb, int i) throws f {
        if (i * 13 <= cVar.c()) {
            byte[] bArr = new byte[(i * 2)];
            int i2 = 0;
            while (i > 0) {
                int a2 = cVar.a(13);
                int i3 = (a2 % 96) | ((a2 / 96) << 8);
                int i4 = i3 + (i3 < 959 ? 41377 : 42657);
                bArr[i2] = (byte) (i4 >> 8);
                bArr[i2 + 1] = (byte) i4;
                i2 += 2;
                i--;
            }
            try {
                sb.append(new String(bArr, "GB2312"));
            } catch (UnsupportedEncodingException unused) {
                throw f.a();
            }
        } else {
            throw f.a();
        }
    }

    private static void b(c cVar, StringBuilder sb, int i) throws f {
        if (i * 13 <= cVar.c()) {
            byte[] bArr = new byte[(i * 2)];
            int i2 = 0;
            while (i > 0) {
                int a2 = cVar.a(13);
                int i3 = (a2 % 192) | ((a2 / 192) << 8);
                int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
                bArr[i2] = (byte) (i4 >> 8);
                bArr[i2 + 1] = (byte) i4;
                i2 += 2;
                i--;
            }
            try {
                sb.append(new String(bArr, "SJIS"));
            } catch (UnsupportedEncodingException unused) {
                throw f.a();
            }
        } else {
            throw f.a();
        }
    }

    private static void a(c cVar, StringBuilder sb, int i, a.a.a.b.d dVar, Collection<byte[]> collection, Map<e, ?> map) throws f {
        String str;
        if ((i << 3) <= cVar.c()) {
            byte[] bArr = new byte[i];
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = (byte) cVar.a(8);
            }
            if (dVar == null) {
                str = l.a(bArr, map);
            } else {
                str = dVar.name();
            }
            try {
                sb.append(new String(bArr, str));
                collection.add(bArr);
            } catch (UnsupportedEncodingException unused) {
                throw f.a();
            }
        } else {
            throw f.a();
        }
    }

    private static char a(int i) throws f {
        if (i < f176a.length) {
            return f176a[i];
        }
        throw f.a();
    }

    private static void a(c cVar, StringBuilder sb, int i, boolean z) throws f {
        while (i > 1) {
            if (cVar.c() >= 11) {
                int a2 = cVar.a(11);
                sb.append(a(a2 / 45));
                sb.append(a(a2 % 45));
                i -= 2;
            } else {
                throw f.a();
            }
        }
        if (i == 1) {
            if (cVar.c() >= 6) {
                sb.append(a(cVar.a(6)));
            } else {
                throw f.a();
            }
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i2 = length + 1;
                        if (sb.charAt(i2) == '%') {
                            sb.deleteCharAt(i2);
                        }
                    }
                    sb.setCharAt(length, 29);
                }
            }
        }
    }

    private static void c(c cVar, StringBuilder sb, int i) throws f {
        while (i >= 3) {
            if (cVar.c() >= 10) {
                int a2 = cVar.a(10);
                if (a2 < 1000) {
                    sb.append(a(a2 / 100));
                    sb.append(a((a2 / 10) % 10));
                    sb.append(a(a2 % 10));
                    i -= 3;
                } else {
                    throw f.a();
                }
            } else {
                throw f.a();
            }
        }
        if (i == 2) {
            if (cVar.c() >= 7) {
                int a3 = cVar.a(7);
                if (a3 < 100) {
                    sb.append(a(a3 / 10));
                    sb.append(a(a3 % 10));
                    return;
                }
                throw f.a();
            }
            throw f.a();
        } else if (i != 1) {
        } else {
            if (cVar.c() >= 4) {
                int a4 = cVar.a(4);
                if (a4 < 10) {
                    sb.append(a(a4));
                    return;
                }
                throw f.a();
            }
            throw f.a();
        }
    }

    private static int a(c cVar) throws f {
        int a2 = cVar.a(8);
        if ((a2 & 128) == 0) {
            return a2 & 127;
        }
        if ((a2 & 192) == 128) {
            return cVar.a(8) | ((a2 & 63) << 8);
        }
        if ((a2 & 224) == 192) {
            return cVar.a(16) | ((a2 & 31) << 16);
        }
        throw f.a();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\g\a\e.java ==========

package a.a.a.g.a;

import a.a.a.b.b;
import a.a.a.b.b.a;
import a.a.a.b.b.c;
import a.a.a.d;
import a.a.a.f;
import java.util.Map;

/* compiled from: Decoder */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final c f177a = new c(a.e);

    public a.a.a.b.e a(b bVar, Map<a.a.a.e, ?> map) throws f, d {
        d e;
        a aVar = new a(bVar);
        f fVar = null;
        try {
            return a(aVar, map);
        } catch (f e2) {
            f fVar2 = e2;
            e = null;
            fVar = fVar2;
            try {
                aVar.d();
                aVar.a(true);
                aVar.b();
                aVar.a();
                aVar.e();
                a.a.a.b.e a2 = a(aVar, map);
                a2.a((Object) new i(true));
                return a2;
            } catch (d | f e3) {
                if (fVar != null) {
                    throw fVar;
                } else if (e != null) {
                    throw e;
                } else {
                    throw e3;
                }
            }
        } catch (d e4) {
            e = e4;
            aVar.d();
            aVar.a(true);
            aVar.b();
            aVar.a();
            aVar.e();
            a.a.a.b.e a22 = a(aVar, map);
            a22.a((Object) new i(true));
            return a22;
        }
    }

    private a.a.a.b.e a(a aVar, Map<a.a.a.e, ?> map) throws f, d {
        j b2 = aVar.b();
        f a2 = aVar.a().a();
        b[] a3 = b.a(aVar.c(), b2, a2);
        int i = 0;
        for (b a4 : a3) {
            i += a4.a();
        }
        byte[] bArr = new byte[i];
        int length = a3.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            b bVar = a3[i2];
            byte[] b3 = bVar.b();
            int a5 = bVar.a();
            a(b3, a5);
            int i4 = i3;
            int i5 = 0;
            while (i5 < a5) {
                bArr[i4] = b3[i5];
                i5++;
                i4++;
            }
            i2++;
            i3 = i4;
        }
        return d.a(bArr, b2, a2, map);
    }

    private void a(byte[] bArr, int i) throws d {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.f177a.a(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (a.a.a.b.b.d unused) {
            throw d.a();
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\g\a\f.java ==========

package a.a.a.g.a;

/* compiled from: ErrorCorrectionLevel */
public enum f {
    L(1),
    M(0),
    Q(3),
    H(2);
    
    private static final f[] e = null;
    private final int f;

    static {
        e = new f[]{M, L, H, Q};
    }

    private f(int i) {
        this.f = i;
    }

    public static f a(int i) {
        if (i >= 0 && i < e.length) {
            return e[i];
        }
        throw new IllegalArgumentException();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\g\a\g.java ==========

package a.a.a.g.a;

/* compiled from: FormatInformation */
final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final int[][] f180a = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: b  reason: collision with root package name */
    private final f f181b;
    private final byte c;

    private g(int i) {
        this.f181b = f.a((i >> 3) & 3);
        this.c = (byte) (i & 7);
    }

    static int a(int i, int i2) {
        return Integer.bitCount(i ^ i2);
    }

    static g b(int i, int i2) {
        g c2 = c(i, i2);
        if (c2 != null) {
            return c2;
        }
        return c(i ^ 21522, i2 ^ 21522);
    }

    private static g c(int i, int i2) {
        int a2;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        for (int[] iArr : f180a) {
            int i5 = iArr[0];
            if (i5 == i || i5 == i2) {
                return new g(iArr[1]);
            }
            int a3 = a(i, i5);
            if (a3 < i3) {
                i4 = iArr[1];
                i3 = a3;
            }
            if (i != i2 && (a2 = a(i2, i5)) < i3) {
                i4 = iArr[1];
                i3 = a2;
            }
        }
        if (i3 <= 3) {
            return new g(i4);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public f a() {
        return this.f181b;
    }

    /* access modifiers changed from: package-private */
    public byte b() {
        return this.c;
    }

    public int hashCode() {
        return (this.f181b.ordinal() << 3) | this.c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f181b == gVar.f181b && this.c == gVar.c) {
            return true;
        }
        return false;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\g\a\h.java ==========

package a.a.a.g.a;

import net.fxgear.GlobalDefine;

/* compiled from: Mode */
public enum h {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);
    
    private final int[] k;
    private final int l;

    private h(int[] iArr, int i) {
        this.k = iArr;
        this.l = i;
    }

    public static h a(int i) {
        switch (i) {
            case 0:
                return TERMINATOR;
            case 1:
                return NUMERIC;
            case 2:
                return ALPHANUMERIC;
            case 3:
                return STRUCTURED_APPEND;
            case 4:
                return BYTE;
            case 5:
                return FNC1_FIRST_POSITION;
            case 7:
                return ECI;
            case 8:
                return KANJI;
            case 9:
                return FNC1_SECOND_POSITION;
            case GlobalDefine.RESULT_CODE_ERROR_MALFORMEDURL /*13*/:
                return HANZI;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int a(j jVar) {
        int a2 = jVar.a();
        return this.k[a2 <= 9 ? 0 : a2 <= 26 ? (char) 1 : 2];
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\g\a\i.java ==========

package a.a.a.g.a;

import a.a.a.o;

/* compiled from: QRCodeDecoderMetaData */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f184a;

    i(boolean z) {
        this.f184a = z;
    }

    public void a(o[] oVarArr) {
        if (this.f184a && oVarArr != null && oVarArr.length >= 3) {
            o oVar = oVarArr[0];
            oVarArr[0] = oVarArr[2];
            oVarArr[2] = oVar;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\g\a\j.java ==========

package a.a.a.g.a;

import a.a.a.f;

/* compiled from: Version */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f185a = {31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};

    /* renamed from: b  reason: collision with root package name */
    private static final j[] f186b = f();
    private final int c;
    private final int[] d;
    private final b[] e;
    private final int f;

    private j(int i, int[] iArr, b... bVarArr) {
        this.c = i;
        this.d = iArr;
        this.e = bVarArr;
        int a2 = bVarArr[0].a();
        int i2 = 0;
        for (a aVar : bVarArr[0].b()) {
            i2 += aVar.a() * (aVar.b() + a2);
        }
        this.f = i2;
    }

    public int a() {
        return this.c;
    }

    public int[] b() {
        return this.d;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return (this.c * 4) + 17;
    }

    public b a(f fVar) {
        return this.e[fVar.ordinal()];
    }

    public static j a(int i) throws f {
        if (i % 4 == 1) {
            try {
                return b((i - 17) / 4);
            } catch (IllegalArgumentException unused) {
                throw f.a();
            }
        } else {
            throw f.a();
        }
    }

    public static j b(int i) {
        if (i > 0 && i <= 40) {
            return f186b[i - 1];
        }
        throw new IllegalArgumentException();
    }

    static j c(int i) {
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        for (int i4 = 0; i4 < f185a.length; i4++) {
            int i5 = f185a[i4];
            if (i5 == i) {
                return b(i4 + 7);
            }
            int a2 = g.a(i, i5);
            if (a2 < i2) {
                i3 = i4 + 7;
                i2 = a2;
            }
        }
        if (i2 <= 3) {
            return b(i3);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public a.a.a.b.b e() {
        int d2 = d();
        a.a.a.b.b bVar = new a.a.a.b.b(d2);
        bVar.a(0, 0, 9, 9);
        int i = d2 - 8;
        bVar.a(i, 0, 8, 9);
        bVar.a(0, i, 9, 8);
        int length = this.d.length;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = this.d[i2] - 2;
            for (int i4 = 0; i4 < length; i4++) {
                if (!((i2 == 0 && (i4 == 0 || i4 == length - 1)) || (i2 == length - 1 && i4 == 0))) {
                    bVar.a(this.d[i4] - 2, i3, 5, 5);
                }
            }
        }
        int i5 = d2 - 17;
        bVar.a(6, 9, 1, i5);
        bVar.a(9, 6, i5, 1);
        if (this.c > 6) {
            int i6 = d2 - 11;
            bVar.a(i6, 0, 3, 6);
            bVar.a(0, i6, 6, 3);
        }
        return bVar;
    }

    /* compiled from: Version */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f189a;

        /* renamed from: b  reason: collision with root package name */
        private final a[] f190b;

        b(int i, a... aVarArr) {
            this.f189a = i;
            this.f190b = aVarArr;
        }

        public int a() {
            return this.f189a;
        }

        public a[] b() {
            return this.f190b;
        }
    }

    /* compiled from: Version */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f187a;

        /* renamed from: b  reason: collision with root package name */
        private final int f188b;

        a(int i, int i2) {
            this.f187a = i;
            this.f188b = i2;
        }

        public int a() {
            return this.f187a;
        }

        public int b() {
            return this.f188b;
        }
    }

    public String toString() {
        return String.valueOf(this.c);
    }

    private static j[] f() {
        return new j[]{new j(1, new int[0], new b(7, new a(1, 19)), new b(10, new a(1, 16)), new b(13, new a(1, 13)), new b(17, new a(1, 9))), new j(2, new int[]{6, 18}, new b(10, new a(1, 34)), new b(16, new a(1, 28)), new b(22, new a(1, 22)), new b(28, new a(1, 16))), new j(3, new int[]{6, 22}, new b(15, new a(1, 55)), new b(26, new a(1, 44)), new b(18, new a(2, 17)), new b(22, new a(2, 13))), new j(4, new int[]{6, 26}, new b(20, new a(1, 80)), new b(18, new a(2, 32)), new b(26, new a(2, 24)), new b(16, new a(4, 9))), new j(5, new int[]{6, 30}, new b(26, new a(1, 108)), new b(24, new a(2, 43)), new b(18, new a(2, 15), new a(2, 16)), new b(22, new a(2, 11), new a(2, 12))), new j(6, new int[]{6, 34}, new b(18, new a(2, 68)), new b(16, new a(4, 27)), new b(24, new a(4, 19)), new b(28, new a(4, 15))), new j(7, new int[]{6, 22, 38}, new b(20, new a(2, 78)), new b(18, new a(4, 31)), new b(18, new a(2, 14), new a(4, 15)), new b(26, new a(4, 13), new a(1, 14))), new j(8, new int[]{6, 24, 42}, new b(24, new a(2, 97)), new b(22, new a(2, 38), new a(2, 39)), new b(22, new a(4, 18), new a(2, 19)), new b(26, new a(4, 14), new a(2, 15))), new j(9, new int[]{6, 26, 46}, new b(30, new a(2, 116)), new b(22, new a(3, 36), new a(2, 37)), new b(20, new a(4, 16), new a(4, 17)), new b(24, new a(4, 12), new a(4, 13))), new j(10, new int[]{6, 28, 50}, new b(18, new a(2, 68), new a(2, 69)), new b(26, new a(4, 43), new a(1, 44)), new b(24, new a(6, 19), new a(2, 20)), new b(28, new a(6, 15), new a(2, 16))), new j(11, new int[]{6, 30, 54}, new b(20, new a(4, 81)), new b(30, new a(1, 50), new a(4, 51)), new b(28, new a(4, 22), new a(4, 23)), new b(24, new a(3, 12), new a(8, 13))), new j(12, new int[]{6, 32, 58}, new b(24, new a(2, 92), new a(2, 93)), new b(22, new a(6, 36), new a(2, 37)), new b(26, new a(4, 20), new a(6, 21)), new b(28, new a(7, 14), new a(4, 15))), new j(13, new int[]{6, 34, 62}, new b(26, new a(4, 107)), new b(22, new a(8, 37), new a(1, 38)), new b(24, new a(8, 20), new a(4, 21)), new b(22, new a(12, 11), new a(4, 12))), new j(14, new int[]{6, 26, 46, 66}, new b(30, new a(3, 115), new a(1, 116)), new b(24, new a(4, 40), new a(5, 41)), new b(20, new a(11, 16), new a(5, 17)), new b(24, new a(11, 12), new a(5, 13))), new j(15, new int[]{6, 26, 48, 70}, new b(22, new a(5, 87), new a(1, 88)), new b(24, new a(5, 41), new a(5, 42)), new b(30, new a(5, 24), new a(7, 25)), new b(24, new a(11, 12), new a(7, 13))), new j(16, new int[]{6, 26, 50, 74}, new b(24, new a(5, 98), new a(1, 99)), new b(28, new a(7, 45), new a(3, 46)), new b(24, new a(15, 19), new a(2, 20)), new b(30, new a(3, 15), new a(13, 16))), new j(17, new int[]{6, 30, 54, 78}, new b(28, new a(1, 107), new a(5, 108)), new b(28, new a(10, 46), new a(1, 47)), new b(28, new a(1, 22), new a(15, 23)), new b(28, new a(2, 14), new a(17, 15))), new j(18, new int[]{6, 30, 56, 82}, new b(30, new a(5, 120), new a(1, 121)), new b(26, new a(9, 43), new a(4, 44)), new b(28, new a(17, 22), new a(1, 23)), new b(28, new a(2, 14), new a(19, 15))), new j(19, new int[]{6, 30, 58, 86}, new b(28, new a(3, 113), new a(4, 114)), new b(26, new a(3, 44), new a(11, 45)), new b(26, new a(17, 21), new a(4, 22)), new b(26, new a(9, 13), new a(16, 14))), new j(20, new int[]{6, 34, 62, 90}, new b(28, new a(3, 107), new a(5, 108)), new b(26, new a(3, 41), new a(13, 42)), new b(30, new a(15, 24), new a(5, 25)), new b(28, new a(15, 15), new a(10, 16))), new j(21, new int[]{6, 28, 50, 72, 94}, new b(28, new a(4, 116), new a(4, 117)), new b(26, new a(17, 42)), new b(28, new a(17, 22), new a(6, 23)), new b(30, new a(19, 16), new a(6, 17))), new j(22, new int[]{6, 26, 50, 74, 98}, new b(28, new a(2, 111), new a(7, 112)), new b(28, new a(17, 46)), new b(30, new a(7, 24), new a(16, 25)), new b(24, new a(34, 13))), new j(23, new int[]{6, 30, 54, 78, 102}, new b(30, new a(4, 121), new a(5, 122)), new b(28, new a(4, 47), new a(14, 48)), new b(30, new a(11, 24), new a(14, 25)), new b(30, new a(16, 15), new a(14, 16))), new j(24, new int[]{6, 28, 54, 80, 106}, new b(30, new a(6, 117), new a(4, 118)), new b(28, new a(6, 45), new a(14, 46)), new b(30, new a(11, 24), new a(16, 25)), new b(30, new a(30, 16), new a(2, 17))), new j(25, new int[]{6, 32, 58, 84, 110}, new b(26, new a(8, 106), new a(4, 107)), new b(28, new a(8, 47), new a(13, 48)), new b(30, new a(7, 24), new a(22, 25)), new b(30, new a(22, 15), new a(13, 16))), new j(26, new int[]{6, 30, 58, 86, 114}, new b(28, new a(10, 114), new a(2, 115)), new b(28, new a(19, 46), new a(4, 47)), new b(28, new a(28, 22), new a(6, 23)), new b(30, new a(33, 16), new a(4, 17))), new j(27, new int[]{6, 34, 62, 90, 118}, new b(30, new a(8, 122), new a(4, 123)), new b(28, new a(22, 45), new a(3, 46)), new b(30, new a(8, 23), new a(26, 24)), new b(30, new a(12, 15), new a(28, 16))), new j(28, new int[]{6, 26, 50, 74, 98, 122}, new b(30, new a(3, 117), new a(10, 118)), new b(28, new a(3, 45), new a(23, 46)), new b(30, new a(4, 24), new a(31, 25)), new b(30, new a(11, 15), new a(31, 16))), new j(29, new int[]{6, 30, 54, 78, 102, 126}, new b(30, new a(7, 116), new a(7, 117)), new b(28, new a(21, 45), new a(7, 46)), new b(30, new a(1, 23), new a(37, 24)), new b(30, new a(19, 15), new a(26, 16))), new j(30, new int[]{6, 26, 52, 78, 104, 130}, new b(30, new a(5, 115), new a(10, 116)), new b(28, new a(19, 47), new a(10, 48)), new b(30, new a(15, 24), new a(25, 25)), new b(30, new a(23, 15), new a(25, 16))), new j(31, new int[]{6, 30, 56, 82, 108, 134}, new b(30, new a(13, 115), new a(3, 116)), new b(28, new a(2, 46), new a(29, 47)), new b(30, new a(42, 24), new a(1, 25)), new b(30, new a(23, 15), new a(28, 16))), new j(32, new int[]{6, 34, 60, 86, 112, 138}, new b(30, new a(17, 115)), new b(28, new a(10, 46), new a(23, 47)), new b(30, new a(10, 24), new a(35, 25)), new b(30, new a(19, 15), new a(35, 16))), new j(33, new int[]{6, 30, 58, 86, 114, 142}, new b(30, new a(17, 115), new a(1, 116)), new b(28, new a(14, 46), new a(21, 47)), new b(30, new a(29, 24), new a(19, 25)), new b(30, new a(11, 15), new a(46, 16))), new j(34, new int[]{6, 34, 62, 90, 118, 146}, new b(30, new a(13, 115), new a(6, 116)), new b(28, new a(14, 46), new a(23, 47)), new b(30, new a(44, 24), new a(7, 25)), new b(30, new a(59, 16), new a(1, 17))), new j(35, new int[]{6, 30, 54, 78, 102, 126, 150}, new b(30, new a(12, 121), new a(7, 122)), new b(28, new a(12, 47), new a(26, 48)), new b(30, new a(39, 24), new a(14, 25)), new b(30, new a(22, 15), new a(41, 16))), new j(36, new int[]{6, 24, 50, 76, 102, 128, 154}, new b(30, new a(6, 121), new a(14, 122)), new b(28, new a(6, 47), new a(34, 48)), new b(30, new a(46, 24), new a(10, 25)), new b(30, new a(2, 15), new a(64, 16))), new j(37, new int[]{6, 28, 54, 80, 106, 132, 158}, new b(30, new a(17, 122), new a(4, 123)), new b(28, new a(29, 46), new a(14, 47)), new b(30, new a(49, 24), new a(10, 25)), new b(30, new a(24, 15), new a(46, 16))), new j(38, new int[]{6, 32, 58, 84, 110, 136, 162}, new b(30, new a(4, 122), new a(18, 123)), new b(28, new a(13, 46), new a(32, 47)), new b(30, new a(48, 24), new a(14, 25)), new b(30, new a(42, 15), new a(32, 16))), new j(39, new int[]{6, 26, 54, 82, 110, 138, 166}, new b(30, new a(20, 117), new a(4, 118)), new b(28, new a(40, 47), new a(7, 48)), new b(30, new a(43, 24), new a(22, 25)), new b(30, new a(10, 15), new a(67, 16))), new j(40, new int[]{6, 30, 58, 86, 114, 142, 170}, new b(30, new a(19, 118), new a(6, 119)), new b(28, new a(18, 47), new a(31, 48)), new b(30, new a(34, 24), new a(34, 25)), new b(30, new a(20, 15), new a(61, 16)))};
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\g\b\a.java ==========

package a.a.a.g.b;

import a.a.a.o;

/* compiled from: AlignmentPattern */
public final class a extends o {

    /* renamed from: a  reason: collision with root package name */
    private final float f191a;

    a(float f, float f2, float f3) {
        super(f, f2);
        this.f191a = f3;
    }

    /* access modifiers changed from: package-private */
    public boolean a(float f, float f2, float f3) {
        if (Math.abs(f2 - b()) > f || Math.abs(f3 - a()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.f191a);
        if (abs <= 1.0f || abs <= this.f191a) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public a b(float f, float f2, float f3) {
        return new a((a() + f2) / 2.0f, (b() + f) / 2.0f, (this.f191a + f3) / 2.0f);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\g\b\b.java ==========

package a.a.a.g.b;

import a.a.a.i;
import a.a.a.p;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AlignmentPatternFinder */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final a.a.a.b.b f192a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a> f193b = new ArrayList(5);
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final float g;
    private final int[] h;
    private final p i;

    b(a.a.a.b.b bVar, int i2, int i3, int i4, int i5, float f2, p pVar) {
        this.f192a = bVar;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = f2;
        this.h = new int[3];
        this.i = pVar;
    }

    /* access modifiers changed from: package-private */
    public a a() throws i {
        a a2;
        a a3;
        int i2 = this.c;
        int i3 = this.f;
        int i4 = this.e + i2;
        int i5 = this.d + (i3 / 2);
        int[] iArr = new int[3];
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = ((i6 & 1) == 0 ? (i6 + 1) / 2 : -((i6 + 1) / 2)) + i5;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i8 = i2;
            while (i8 < i4 && !this.f192a.a(i8, i7)) {
                i8++;
            }
            int i9 = 0;
            while (i8 < i4) {
                if (!this.f192a.a(i8, i7)) {
                    if (i9 == 1) {
                        i9++;
                    }
                    iArr[i9] = iArr[i9] + 1;
                } else if (i9 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i9 != 2) {
                    i9++;
                    iArr[i9] = iArr[i9] + 1;
                } else if (a(iArr) && (a3 = a(iArr, i7, i8)) != null) {
                    return a3;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i9 = 1;
                }
                i8++;
            }
            if (a(iArr) && (a2 = a(iArr, i7, i4)) != null) {
                return a2;
            }
        }
        if (!this.f193b.isEmpty()) {
            return this.f193b.get(0);
        }
        throw i.a();
    }

    private static float a(int[] iArr, int i2) {
        return ((float) (i2 - iArr[2])) - (((float) iArr[1]) / 2.0f);
    }

    private boolean a(int[] iArr) {
        float f2 = this.g;
        float f3 = f2 / 2.0f;
        for (int i2 = 0; i2 < 3; i2++) {
            if (Math.abs(f2 - ((float) iArr[i2])) >= f3) {
                return false;
            }
        }
        return true;
    }

    private float a(int i2, int i3, int i4, int i5) {
        a.a.a.b.b bVar = this.f192a;
        int f2 = bVar.f();
        int[] iArr = this.h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i6 = i2;
        while (i6 >= 0 && bVar.a(i3, i6) && iArr[1] <= i4) {
            iArr[1] = iArr[1] + 1;
            i6--;
        }
        if (i6 < 0 || iArr[1] > i4) {
            return Float.NaN;
        }
        while (i6 >= 0 && !bVar.a(i3, i6) && iArr[0] <= i4) {
            iArr[0] = iArr[0] + 1;
            i6--;
        }
        if (iArr[0] > i4) {
            return Float.NaN;
        }
        int i7 = i2 + 1;
        while (i7 < f2 && bVar.a(i3, i7) && iArr[1] <= i4) {
            iArr[1] = iArr[1] + 1;
            i7++;
        }
        if (i7 == f2 || iArr[1] > i4) {
            return Float.NaN;
        }
        while (i7 < f2 && !bVar.a(i3, i7) && iArr[2] <= i4) {
            iArr[2] = iArr[2] + 1;
            i7++;
        }
        if (iArr[2] <= i4 && Math.abs(((iArr[0] + iArr[1]) + iArr[2]) - i5) * 5 < i5 * 2 && a(iArr)) {
            return a(iArr, i7);
        }
        return Float.NaN;
    }

    private a a(int[] iArr, int i2, int i3) {
        int i4 = iArr[0] + iArr[1] + iArr[2];
        float a2 = a(iArr, i3);
        float a3 = a(i2, (int) a2, iArr[1] * 2, i4);
        if (Float.isNaN(a3)) {
            return null;
        }
        float f2 = ((float) ((iArr[0] + iArr[1]) + iArr[2])) / 3.0f;
        for (a next : this.f193b) {
            if (next.a(f2, a3, a2)) {
                return next.b(a3, a2, f2);
            }
        }
        a aVar = new a(a2, a3, f2);
        this.f193b.add(aVar);
        if (this.i == null) {
            return null;
        }
        this.i.a(aVar);
        return null;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\g\b\c.java ==========

package a.a.a.g.b;

import a.a.a.b.a.a;
import a.a.a.b.b;
import a.a.a.b.g;
import a.a.a.b.k;
import a.a.a.e;
import a.a.a.f;
import a.a.a.g.a.j;
import a.a.a.i;
import a.a.a.o;
import a.a.a.p;
import java.util.Map;

/* compiled from: Detector */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final b f194a;

    /* renamed from: b  reason: collision with root package name */
    private p f195b;

    public c(b bVar) {
        this.f194a = bVar;
    }

    public final g a(Map<e, ?> map) throws i, f {
        p pVar;
        if (map == null) {
            pVar = null;
        } else {
            pVar = (p) map.get(e.NEED_RESULT_POINT_CALLBACK);
        }
        this.f195b = pVar;
        return a(new e(this.f194a, this.f195b).a(map));
    }

    /* access modifiers changed from: protected */
    public final g a(f fVar) throws i, f {
        o[] oVarArr;
        d b2 = fVar.b();
        d c = fVar.c();
        d a2 = fVar.a();
        float a3 = a((o) b2, (o) c, (o) a2);
        if (a3 >= 1.0f) {
            int a4 = a((o) b2, (o) c, (o) a2, a3);
            j a5 = j.a(a4);
            int d = a5.d() - 7;
            a aVar = null;
            if (a5.b().length > 0) {
                float a6 = (c.a() - b2.a()) + a2.a();
                float b3 = (c.b() - b2.b()) + a2.b();
                float f = 1.0f - (3.0f / ((float) d));
                int a7 = (int) (b2.a() + ((a6 - b2.a()) * f));
                int b4 = (int) (b2.b() + (f * (b3 - b2.b())));
                int i = 4;
                while (true) {
                    if (i > 16) {
                        break;
                    }
                    try {
                        aVar = a(a3, a7, b4, (float) i);
                        break;
                    } catch (i unused) {
                        i <<= 1;
                    }
                }
            }
            b a8 = a(this.f194a, a(b2, c, a2, aVar, a4), a4);
            if (aVar == null) {
                oVarArr = new o[]{a2, b2, c};
            } else {
                oVarArr = new o[]{a2, b2, c, aVar};
            }
            return new g(a8, oVarArr);
        }
        throw i.a();
    }

    private static k a(o oVar, o oVar2, o oVar3, o oVar4, int i) {
        float f;
        float f2;
        float f3;
        float f4 = ((float) i) - 3.5f;
        if (oVar4 != null) {
            float a2 = oVar4.a();
            f = oVar4.b();
            f2 = a2;
            f3 = f4 - 3.0f;
        } else {
            f2 = (oVar2.a() - oVar.a()) + oVar3.a();
            f = (oVar2.b() - oVar.b()) + oVar3.b();
            f3 = f4;
        }
        return k.a(3.5f, 3.5f, f4, 3.5f, f3, f3, 3.5f, f4, oVar.a(), oVar.b(), oVar2.a(), oVar2.b(), f2, f, oVar3.a(), oVar3.b());
    }

    private static b a(b bVar, k kVar, int i) throws i {
        return a.a.a.b.i.a().a(bVar, i, i, kVar);
    }

    private static int a(o oVar, o oVar2, o oVar3, float f) throws i {
        int a2 = ((a.a(o.a(oVar, oVar2) / f) + a.a(o.a(oVar, oVar3) / f)) / 2) + 7;
        int i = a2 & 3;
        if (i == 0) {
            return a2 + 1;
        }
        switch (i) {
            case 2:
                return a2 - 1;
            case 3:
                throw i.a();
            default:
                return a2;
        }
    }

    /* access modifiers changed from: protected */
    public final float a(o oVar, o oVar2, o oVar3) {
        return (a(oVar, oVar2) + a(oVar, oVar3)) / 2.0f;
    }

    private float a(o oVar, o oVar2) {
        float a2 = a((int) oVar.a(), (int) oVar.b(), (int) oVar2.a(), (int) oVar2.b());
        float a3 = a((int) oVar2.a(), (int) oVar2.b(), (int) oVar.a(), (int) oVar.b());
        if (Float.isNaN(a2)) {
            return a3 / 7.0f;
        }
        return Float.isNaN(a3) ? a2 / 7.0f : (a2 + a3) / 14.0f;
    }

    private float a(int i, int i2, int i3, int i4) {
        float f;
        int i5;
        float f2;
        float b2 = b(i, i2, i3, i4);
        int i6 = i - (i3 - i);
        int i7 = 0;
        if (i6 < 0) {
            f = ((float) i) / ((float) (i - i6));
            i5 = 0;
        } else if (i6 >= this.f194a.e()) {
            f = ((float) ((this.f194a.e() - 1) - i)) / ((float) (i6 - i));
            i5 = this.f194a.e() - 1;
        } else {
            i5 = i6;
            f = 1.0f;
        }
        float f3 = (float) i2;
        int i8 = (int) (f3 - (((float) (i4 - i2)) * f));
        if (i8 < 0) {
            f2 = f3 / ((float) (i2 - i8));
        } else if (i8 >= this.f194a.f()) {
            f2 = ((float) ((this.f194a.f() - 1) - i2)) / ((float) (i8 - i2));
            i7 = this.f194a.f() - 1;
        } else {
            i7 = i8;
            f2 = 1.0f;
        }
        return (b2 + b(i, i2, (int) (((float) i) + (((float) (i5 - i)) * f2)), i7)) - 1.0f;
    }

    private float b(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        c cVar;
        boolean z2;
        int i10 = 1;
        boolean z3 = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z3) {
            i6 = i;
            i8 = i2;
            i5 = i3;
            i7 = i4;
        } else {
            i8 = i;
            i6 = i2;
            i7 = i3;
            i5 = i4;
        }
        int abs = Math.abs(i7 - i8);
        int abs2 = Math.abs(i5 - i6);
        int i11 = (-abs) / 2;
        int i12 = -1;
        int i13 = i8 < i7 ? 1 : -1;
        if (i6 < i5) {
            i12 = 1;
        }
        int i14 = i7 + i13;
        int i15 = i6;
        int i16 = i11;
        int i17 = 0;
        int i18 = i8;
        while (true) {
            if (i18 == i14) {
                i9 = i14;
                break;
            }
            int i19 = z3 ? i15 : i18;
            int i20 = z3 ? i18 : i15;
            if (i17 == i10) {
                cVar = this;
                i9 = i14;
                z = z3;
                z2 = true;
            } else {
                cVar = this;
                i9 = i14;
                z = z3;
                z2 = false;
            }
            if (z2 == cVar.f194a.a(i19, i20)) {
                if (i17 == 2) {
                    return a.a(i18, i15, i8, i6);
                }
                i17++;
            }
            i16 += abs2;
            if (i16 > 0) {
                if (i15 == i5) {
                    break;
                }
                i15 += i12;
                i16 -= abs;
            }
            i18 += i13;
            z3 = z;
            i14 = i9;
            i10 = 1;
        }
        if (i17 == 2) {
            return a.a(i9, i5, i8, i6);
        }
        return Float.NaN;
    }

    /* access modifiers changed from: protected */
    public final a a(float f, int i, int i2, float f2) throws i {
        int i3 = (int) (f2 * f);
        int max = Math.max(0, i - i3);
        int min = Math.min(this.f194a.e() - 1, i + i3) - max;
        float f3 = 3.0f * f;
        if (((float) min) >= f3) {
            int max2 = Math.max(0, i2 - i3);
            int min2 = Math.min(this.f194a.f() - 1, i2 + i3) - max2;
            if (((float) min2) >= f3) {
                return new b(this.f194a, max, max2, min, min2, f, this.f195b).a();
            }
            throw i.a();
        }
        throw i.a();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\g\b\d.java ==========

package a.a.a.g.b;

import a.a.a.o;

/* compiled from: FinderPattern */
public final class d extends o {

    /* renamed from: a  reason: collision with root package name */
    private final float f196a;

    /* renamed from: b  reason: collision with root package name */
    private final int f197b;

    d(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    private d(float f, float f2, float f3, int i) {
        super(f, f2);
        this.f196a = f3;
        this.f197b = i;
    }

    public float c() {
        return this.f196a;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f197b;
    }

    /* access modifiers changed from: package-private */
    public boolean a(float f, float f2, float f3) {
        if (Math.abs(f2 - b()) > f || Math.abs(f3 - a()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.f196a);
        if (abs <= 1.0f || abs <= this.f196a) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public d b(float f, float f2, float f3) {
        int i = this.f197b + 1;
        float a2 = (((float) this.f197b) * a()) + f2;
        float f4 = (float) i;
        return new d(a2 / f4, ((((float) this.f197b) * b()) + f) / f4, ((((float) this.f197b) * this.f196a) + f3) / f4, i);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\g\b\e.java ==========

package a.a.a.g.b;

import a.a.a.i;
import a.a.a.o;
import a.a.a.p;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import net.fxgear.GlobalDefine;

/* compiled from: FinderPatternFinder */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final a.a.a.b.b f198a;

    /* renamed from: b  reason: collision with root package name */
    private final List<d> f199b = new ArrayList();
    private boolean c;
    private final int[] d = new int[5];
    private final p e;

    public e(a.a.a.b.b bVar, p pVar) {
        this.f198a = bVar;
        this.e = pVar;
    }

    /* access modifiers changed from: package-private */
    public final f a(Map<a.a.a.e, ?> map) throws i {
        Map<a.a.a.e, ?> map2 = map;
        boolean z = map2 != null && map2.containsKey(a.a.a.e.TRY_HARDER);
        boolean z2 = map2 != null && map2.containsKey(a.a.a.e.PURE_BARCODE);
        int f = this.f198a.f();
        int e2 = this.f198a.e();
        int i = (f * 3) / 228;
        if (i < 3 || z) {
            i = 3;
        }
        int[] iArr = new int[5];
        int i2 = i - 1;
        int i3 = i;
        boolean z3 = false;
        while (i2 < f && !z3) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            boolean z4 = z3;
            int i4 = i3;
            int i5 = 0;
            int i6 = 0;
            while (i5 < e2) {
                if (this.f198a.a(i5, i2)) {
                    if ((i6 & 1) == 1) {
                        i6++;
                    }
                    iArr[i6] = iArr[i6] + 1;
                } else if ((i6 & 1) != 0) {
                    iArr[i6] = iArr[i6] + 1;
                } else if (i6 == 4) {
                    if (!a(iArr)) {
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = iArr[4];
                        iArr[3] = 1;
                        iArr[4] = 0;
                    } else if (a(iArr, i2, i5, z2)) {
                        if (this.c) {
                            z4 = c();
                        } else {
                            int b2 = b();
                            if (b2 > iArr[2]) {
                                i2 += (b2 - iArr[2]) - 2;
                                i5 = e2 - 1;
                            }
                        }
                        iArr[0] = 0;
                        iArr[1] = 0;
                        iArr[2] = 0;
                        iArr[3] = 0;
                        iArr[4] = 0;
                        i6 = 0;
                        i4 = 2;
                    } else {
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = iArr[4];
                        iArr[3] = 1;
                        iArr[4] = 0;
                    }
                    i6 = 3;
                } else {
                    i6++;
                    iArr[i6] = iArr[i6] + 1;
                }
                i5++;
            }
            if (!a(iArr) || !a(iArr, i2, e2, z2)) {
                i3 = i4;
            } else {
                int i7 = iArr[0];
                if (this.c) {
                    i3 = i7;
                    z3 = c();
                    i2 += i3;
                } else {
                    i3 = i7;
                }
            }
            z3 = z4;
            i2 += i3;
        }
        d[] d2 = d();
        o.a(d2);
        return new f(d2);
    }

    private static float a(int[] iArr, int i) {
        return ((float) ((i - iArr[4]) - iArr[3])) - (((float) iArr[2]) / 2.0f);
    }

    protected static boolean a(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = ((float) i) / 7.0f;
        float f2 = f / 2.0f;
        if (Math.abs(f - ((float) iArr[0])) >= f2 || Math.abs(f - ((float) iArr[1])) >= f2 || Math.abs((f * 3.0f) - ((float) iArr[2])) >= 3.0f * f2 || Math.abs(f - ((float) iArr[3])) >= f2 || Math.abs(f - ((float) iArr[4])) >= f2) {
            return false;
        }
        return true;
    }

    private int[] a() {
        this.d[0] = 0;
        this.d[1] = 0;
        this.d[2] = 0;
        this.d[3] = 0;
        this.d[4] = 0;
        return this.d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a1 A[LOOP:4: B:41:0x00a1->B:49:0x00b6, LOOP_START, PHI: r10 
      PHI: (r10v2 int) = (r10v1 int), (r10v5 int) binds: [B:40:0x009d, B:49:0x00b6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c9 A[LOOP:5: B:55:0x00c9->B:63:0x00de, LOOP_START, PHI: r10 
      PHI: (r10v3 int) = (r10v2 int), (r10v4 int) binds: [B:54:0x00c6, B:63:0x00de] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x010d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x010e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(int r16, int r17, int r18, int r19) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r18
            int[] r4 = r15.a()
            r5 = 0
            r6 = 0
        L_0x000d:
            r7 = 2
            r8 = 1
            if (r1 < r6) goto L_0x0027
            if (r2 < r6) goto L_0x0027
            a.a.a.b.b r9 = r0.f198a
            int r10 = r2 - r6
            int r11 = r1 - r6
            boolean r9 = r9.a((int) r10, (int) r11)
            if (r9 == 0) goto L_0x0027
            r9 = r4[r7]
            int r9 = r9 + r8
            r4[r7] = r9
            int r6 = r6 + 1
            goto L_0x000d
        L_0x0027:
            if (r1 < r6) goto L_0x0110
            if (r2 >= r6) goto L_0x002d
            goto L_0x0110
        L_0x002d:
            if (r1 < r6) goto L_0x0049
            if (r2 < r6) goto L_0x0049
            a.a.a.b.b r9 = r0.f198a
            int r10 = r2 - r6
            int r11 = r1 - r6
            boolean r9 = r9.a((int) r10, (int) r11)
            if (r9 != 0) goto L_0x0049
            r9 = r4[r8]
            if (r9 > r3) goto L_0x0049
            r9 = r4[r8]
            int r9 = r9 + r8
            r4[r8] = r9
            int r6 = r6 + 1
            goto L_0x002d
        L_0x0049:
            if (r1 < r6) goto L_0x010f
            if (r2 < r6) goto L_0x010f
            r9 = r4[r8]
            if (r9 <= r3) goto L_0x0053
            goto L_0x010f
        L_0x0053:
            if (r1 < r6) goto L_0x006f
            if (r2 < r6) goto L_0x006f
            a.a.a.b.b r9 = r0.f198a
            int r10 = r2 - r6
            int r11 = r1 - r6
            boolean r9 = r9.a((int) r10, (int) r11)
            if (r9 == 0) goto L_0x006f
            r9 = r4[r5]
            if (r9 > r3) goto L_0x006f
            r9 = r4[r5]
            int r9 = r9 + r8
            r4[r5] = r9
            int r6 = r6 + 1
            goto L_0x0053
        L_0x006f:
            r6 = r4[r5]
            if (r6 <= r3) goto L_0x0074
            return r5
        L_0x0074:
            a.a.a.b.b r6 = r0.f198a
            int r6 = r6.f()
            a.a.a.b.b r9 = r0.f198a
            int r9 = r9.e()
            r10 = 1
        L_0x0081:
            int r11 = r1 + r10
            if (r11 >= r6) goto L_0x0099
            int r12 = r2 + r10
            if (r12 >= r9) goto L_0x0099
            a.a.a.b.b r13 = r0.f198a
            boolean r12 = r13.a((int) r12, (int) r11)
            if (r12 == 0) goto L_0x0099
            r11 = r4[r7]
            int r11 = r11 + r8
            r4[r7] = r11
            int r10 = r10 + 1
            goto L_0x0081
        L_0x0099:
            if (r11 >= r6) goto L_0x010e
            int r11 = r2 + r10
            if (r11 < r9) goto L_0x00a1
            goto L_0x010e
        L_0x00a1:
            int r11 = r1 + r10
            r12 = 3
            if (r11 >= r6) goto L_0x00be
            int r13 = r2 + r10
            if (r13 >= r9) goto L_0x00be
            a.a.a.b.b r14 = r0.f198a
            boolean r13 = r14.a((int) r13, (int) r11)
            if (r13 != 0) goto L_0x00be
            r13 = r4[r12]
            if (r13 >= r3) goto L_0x00be
            r11 = r4[r12]
            int r11 = r11 + r8
            r4[r12] = r11
            int r10 = r10 + 1
            goto L_0x00a1
        L_0x00be:
            if (r11 >= r6) goto L_0x010d
            int r11 = r2 + r10
            if (r11 >= r9) goto L_0x010d
            r11 = r4[r12]
            if (r11 < r3) goto L_0x00c9
            goto L_0x010d
        L_0x00c9:
            int r11 = r1 + r10
            r13 = 4
            if (r11 >= r6) goto L_0x00e7
            int r14 = r2 + r10
            if (r14 >= r9) goto L_0x00e7
            a.a.a.b.b r12 = r0.f198a
            boolean r11 = r12.a((int) r14, (int) r11)
            if (r11 == 0) goto L_0x00e7
            r11 = r4[r13]
            if (r11 >= r3) goto L_0x00e7
            r11 = r4[r13]
            int r11 = r11 + r8
            r4[r13] = r11
            int r10 = r10 + 1
            r12 = 3
            goto L_0x00c9
        L_0x00e7:
            r1 = r4[r13]
            if (r1 < r3) goto L_0x00ec
            return r5
        L_0x00ec:
            r1 = r4[r5]
            r2 = r4[r8]
            int r1 = r1 + r2
            r2 = r4[r7]
            int r1 = r1 + r2
            r2 = 3
            r2 = r4[r2]
            int r1 = r1 + r2
            r2 = r4[r13]
            int r1 = r1 + r2
            int r1 = r1 - r19
            int r1 = java.lang.Math.abs(r1)
            int r2 = r19 * 2
            if (r1 >= r2) goto L_0x010c
            boolean r1 = a((int[]) r4)
            if (r1 == 0) goto L_0x010c
            return r8
        L_0x010c:
            return r5
        L_0x010d:
            return r5
        L_0x010e:
            return r5
        L_0x010f:
            return r5
        L_0x0110:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.g.b.e.a(int, int, int, int):boolean");
    }

    private float b(int i, int i2, int i3, int i4) {
        a.a.a.b.b bVar = this.f198a;
        int f = bVar.f();
        int[] a2 = a();
        int i5 = i;
        while (i5 >= 0 && bVar.a(i2, i5)) {
            a2[2] = a2[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bVar.a(i2, i5) && a2[1] <= i3) {
            a2[1] = a2[1] + 1;
            i5--;
        }
        if (i5 < 0 || a2[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && bVar.a(i2, i5) && a2[0] <= i3) {
            a2[0] = a2[0] + 1;
            i5--;
        }
        if (a2[0] > i3) {
            return Float.NaN;
        }
        int i6 = i + 1;
        while (i6 < f && bVar.a(i2, i6)) {
            a2[2] = a2[2] + 1;
            i6++;
        }
        if (i6 == f) {
            return Float.NaN;
        }
        while (i6 < f && !bVar.a(i2, i6) && a2[3] < i3) {
            a2[3] = a2[3] + 1;
            i6++;
        }
        if (i6 == f || a2[3] >= i3) {
            return Float.NaN;
        }
        while (i6 < f && bVar.a(i2, i6) && a2[4] < i3) {
            a2[4] = a2[4] + 1;
            i6++;
        }
        if (a2[4] < i3 && Math.abs(((((a2[0] + a2[1]) + a2[2]) + a2[3]) + a2[4]) - i4) * 5 < i4 * 2 && a(a2)) {
            return a(a2, i6);
        }
        return Float.NaN;
    }

    private float c(int i, int i2, int i3, int i4) {
        a.a.a.b.b bVar = this.f198a;
        int e2 = bVar.e();
        int[] a2 = a();
        int i5 = i;
        while (i5 >= 0 && bVar.a(i5, i2)) {
            a2[2] = a2[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bVar.a(i5, i2) && a2[1] <= i3) {
            a2[1] = a2[1] + 1;
            i5--;
        }
        if (i5 < 0 || a2[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && bVar.a(i5, i2) && a2[0] <= i3) {
            a2[0] = a2[0] + 1;
            i5--;
        }
        if (a2[0] > i3) {
            return Float.NaN;
        }
        int i6 = i + 1;
        while (i6 < e2 && bVar.a(i6, i2)) {
            a2[2] = a2[2] + 1;
            i6++;
        }
        if (i6 == e2) {
            return Float.NaN;
        }
        while (i6 < e2 && !bVar.a(i6, i2) && a2[3] < i3) {
            a2[3] = a2[3] + 1;
            i6++;
        }
        if (i6 == e2 || a2[3] >= i3) {
            return Float.NaN;
        }
        while (i6 < e2 && bVar.a(i6, i2) && a2[4] < i3) {
            a2[4] = a2[4] + 1;
            i6++;
        }
        if (a2[4] < i3 && Math.abs(((((a2[0] + a2[1]) + a2[2]) + a2[3]) + a2[4]) - i4) * 5 < i4 && a(a2)) {
            return a(a2, i6);
        }
        return Float.NaN;
    }

    /* access modifiers changed from: protected */
    public final boolean a(int[] iArr, int i, int i2, boolean z) {
        boolean z2 = false;
        int i3 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int a2 = (int) a(iArr, i2);
        float b2 = b(i, a2, iArr[2], i3);
        if (!Float.isNaN(b2)) {
            int i4 = (int) b2;
            float c2 = c(a2, i4, iArr[2], i3);
            if (!Float.isNaN(c2) && (!z || a(i4, (int) c2, iArr[2], i3))) {
                float f = ((float) i3) / 7.0f;
                int i5 = 0;
                while (true) {
                    if (i5 >= this.f199b.size()) {
                        break;
                    }
                    d dVar = this.f199b.get(i5);
                    if (dVar.a(f, b2, c2)) {
                        this.f199b.set(i5, dVar.b(b2, c2, f));
                        z2 = true;
                        break;
                    }
                    i5++;
                }
                if (!z2) {
                    d dVar2 = new d(c2, b2, f);
                    this.f199b.add(dVar2);
                    if (this.e != null) {
                        this.e.a(dVar2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    private int b() {
        if (this.f199b.size() <= 1) {
            return 0;
        }
        d dVar = null;
        for (d next : this.f199b) {
            if (next.d() >= 2) {
                if (dVar == null) {
                    dVar = next;
                } else {
                    this.c = true;
                    return ((int) (Math.abs(dVar.a() - next.a()) - Math.abs(dVar.b() - next.b()))) / 2;
                }
            }
        }
        return 0;
    }

    private boolean c() {
        int size = this.f199b.size();
        float f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        int i = 0;
        float f2 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        for (d next : this.f199b) {
            if (next.d() >= 2) {
                i++;
                f2 += next.c();
            }
        }
        if (i < 3) {
            return false;
        }
        float f3 = f2 / ((float) size);
        for (d c2 : this.f199b) {
            f += Math.abs(c2.c() - f3);
        }
        if (f <= f2 * 0.05f) {
            return true;
        }
        return false;
    }

    private d[] d() throws i {
        int size = this.f199b.size();
        if (size >= 3) {
            float f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            if (size > 3) {
                float f2 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                float f3 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                for (d c2 : this.f199b) {
                    float c3 = c2.c();
                    f2 += c3;
                    f3 += c3 * c3;
                }
                float f4 = (float) size;
                float f5 = f2 / f4;
                float sqrt = (float) Math.sqrt((double) ((f3 / f4) - (f5 * f5)));
                Collections.sort(this.f199b, new b(f5));
                float max = Math.max(0.2f * f5, sqrt);
                int i = 0;
                while (i < this.f199b.size() && this.f199b.size() > 3) {
                    if (Math.abs(this.f199b.get(i).c() - f5) > max) {
                        this.f199b.remove(i);
                        i--;
                    }
                    i++;
                }
            }
            if (this.f199b.size() > 3) {
                for (d c4 : this.f199b) {
                    f += c4.c();
                }
                Collections.sort(this.f199b, new a(f / ((float) this.f199b.size())));
                this.f199b.subList(3, this.f199b.size()).clear();
            }
            return new d[]{this.f199b.get(0), this.f199b.get(1), this.f199b.get(2)};
        }
        throw i.a();
    }

    /* compiled from: FinderPatternFinder */
    private static final class b implements Serializable, Comparator<d> {

        /* renamed from: a  reason: collision with root package name */
        private final float f201a;

        private b(float f) {
            this.f201a = f;
        }

        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            float abs = Math.abs(dVar2.c() - this.f201a);
            float abs2 = Math.abs(dVar.c() - this.f201a);
            if (abs < abs2) {
                return -1;
            }
            return abs == abs2 ? 0 : 1;
        }
    }

    /* compiled from: FinderPatternFinder */
    private static final class a implements Serializable, Comparator<d> {

        /* renamed from: a  reason: collision with root package name */
        private final float f200a;

        private a(float f) {
            this.f200a = f;
        }

        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            if (dVar2.d() != dVar.d()) {
                return dVar2.d() - dVar.d();
            }
            float abs = Math.abs(dVar2.c() - this.f200a);
            float abs2 = Math.abs(dVar.c() - this.f200a);
            if (abs < abs2) {
                return 1;
            }
            return abs == abs2 ? 0 : -1;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\a\a\a\g\b\f.java ==========

package a.a.a.g.b;

/* compiled from: FinderPatternInfo */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final d f202a;

    /* renamed from: b  reason: collision with root package name */
    private final d f203b;
    private final d c;

    public f(d[] dVarArr) {
        this.f202a = dVarArr[0];
        this.f203b = dVarArr[1];
        this.c = dVarArr[2];
    }

    public d a() {
        return this.f202a;
    }

    public d b() {
        return this.f203b;
    }

    public d c() {
        return this.c;
    }
}


