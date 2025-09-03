package net.fxgear.b;

import android.graphics.Bitmap;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import javax.microedition.khronos.opengles.GL10;
import net.fxgear.GlobalDefine;
import net.fxgear.b.h;
import net.fxgear.b.l;
import net.fxgear.fittingview.data.e;
import net.fxgear.fittingview.qlSolver;

/* compiled from: FXAnimationInterface */
public class a {
    private static int[] h = {19, 7978};
    private static int[] i = {6607, 23608};
    private static float j = 0.5f;
    private static float k = 0.01f;

    /* renamed from: a  reason: collision with root package name */
    n f666a;

    /* renamed from: b  reason: collision with root package name */
    m f667b;
    qlSolver c;
    int d;
    int e;
    int f;
    int g;

    public a() {
        this.f666a = null;
        this.f667b = null;
        this.c = null;
        this.d = -1;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.f666a = new n();
        this.f667b = new m(this.f666a);
    }

    public void a() {
        this.f667b.a();
    }

    public void a(int i2, int i3) {
        this.f667b.a(i2, i3);
    }

    public void a(GL10 gl10) {
        if (this.f666a != null) {
            this.f666a.d();
            this.f666a = null;
        }
        if (this.f667b != null) {
            this.f667b.a(gl10);
            this.f667b = null;
        }
    }

    public void b(GL10 gl10) {
        this.f666a.a(gl10);
    }

    public void b() {
        this.f666a.a();
    }

    public void a(String str) {
        k a2 = this.f666a.a(str);
        if (a2 != null) {
            a2.C();
            a2.ah();
            a2.ai();
        }
    }

    public void c() {
        this.f666a.b();
    }

    public void d() {
        this.f666a.c();
    }

    public void a(int i2) {
        this.f666a.a(i2);
    }

    public void a(GL10 gl10, float[] fArr, int i2, int i3, int i4, boolean z, boolean z2) {
        this.f667b.a(gl10, fArr, i2, i3, i4, z, z2);
    }

    public void e() {
        this.d = l.a();
        this.f667b.f(this.d);
    }

    public void a(Bitmap bitmap) {
        this.f667b.a(bitmap, this.g);
    }

    public void b(int i2) {
        this.g = i2;
    }

    public float c(int i2) {
        return this.f667b.c(i2);
    }

    public int f() {
        return this.d;
    }

    public String d(int i2) {
        return this.f667b.d(i2);
    }

    public p e(int i2) {
        return this.f667b.e(i2);
    }

    public void a(h.e eVar, int i2) {
        this.f667b.a(eVar);
        this.f667b.b(i2);
    }

    public void f(int i2) {
        this.f667b.a(i2);
    }

    public h.e g() {
        return this.f667b.d();
    }

    public int h() {
        return this.f667b.f();
    }

    public void g(int i2) {
        if (this.f666a != null) {
            this.f666a.e(i2);
        }
    }

    public void a(String str, ArrayList<String> arrayList, String str2, int i2, int i3, int[] iArr, int i4) {
        p c2 = this.f666a.c(str);
        if (c2 == null) {
            c2 = l.a(str, str2, i3, iArr);
            c2.C();
            c2.b(0);
            c2.a(str);
            c2.b(str2);
            c2.a(i4);
            this.f666a.a(c2);
            b.c(c2, c2.F());
            if (c2.a() != null) {
                b.d(c2, c2.a().F());
            }
            this.f666a.a(c2, i2, true);
        } else {
            this.f666a.a(c2, i2, false);
        }
        e d2 = this.f666a.d(arrayList.get(0));
        if (d2 == null) {
            ArrayList<i> p = c2.p();
            int size = p.size();
            float[] fArr = new float[(size * 3)];
            for (int i5 = 0; i5 < size; i5++) {
                int i6 = i5 * 3;
                fArr[i6 + 0] = p.get(i5).l()[0];
                fArr[i6 + 1] = p.get(i5).l()[1];
                fArr[i6 + 2] = p.get(i5).l()[2];
            }
            e eVar = new e(size);
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                eVar.a(l.a(arrayList.get(i7), iArr), fArr);
            }
            eVar.a(h.a.SKELETON);
            eVar.a(arrayList.get(0));
            this.f666a.a(eVar);
            this.f666a.a(c2, eVar);
            return;
        }
        this.f666a.a(c2, d2);
    }

    public void a(String str, String str2, String str3, int i2, int i3, ArrayList<String> arrayList, int i4) {
        p c2 = this.f666a.c(str);
        if (c2 == null) {
            Log.e("FXAnimationInterface : ", "AttachAvatarHairSkeleton : Attaching custom hair requires body skeleton!");
        } else if (c2.a() == null) {
            p a2 = l.a(str2, str3, i3, arrayList);
            a2.C();
            a2.b(0);
            a2.a(str2);
            a2.b(str3);
            a2.a(i4);
            a2.a(arrayList);
            c2.a(a2);
            b.d(c2, c2.a().F());
        }
    }

    public void a(String str, String str2) {
        p c2 = this.f666a.c(str);
        if (c2 == null) {
            Log.e("FXAnimationInterface : ", "[c] ERROR: Skeleton " + str + " has not been loaded. Attach animation " + str2 + " failed.");
        } else if (c2.m() == null || !c2.m().equals(str2)) {
            c2.b(str2);
            int[] c3 = c(str);
            ArrayList<i> q = c2.q();
            int i2 = 0;
            if (q == null) {
                q = new ArrayList<>();
                int size = c2.p().size();
                while (i2 < size) {
                    q.add(new i());
                    i2++;
                }
            } else {
                int size2 = c2.p().size();
                while (i2 < size2) {
                    q.get(i2).f();
                    i2++;
                }
            }
            l.b(q, str2, c3);
            c2.c(q);
        } else {
            Log.i("FXAnimationInterface : ", "[c] ReplaceSkeletonAnimation() - return: same animation!");
        }
    }

    public boolean b(String str) {
        p c2 = this.f666a.c(str);
        if (c2 == null) {
            Log.e("FXAnimationInterface : ", "[c] ERROR: UpdateSkeletonAnimation() - skeletonRef == null: " + str);
            return false;
        }
        ArrayList<i> q = c2.q();
        if (q == null) {
            return false;
        }
        ArrayList<i> p = c2.p();
        for (int i2 = 0; i2 < p.size(); i2++) {
            p.get(i2).f();
            p.get(i2).a(q.get(i2).p());
            q.get(i2).a(false);
        }
        c2.D();
        q.clear();
        c2.c((ArrayList<i>) null);
        return true;
    }

    public void a(String str, String str2, int i2, int i3, int i4) {
        p b2 = this.f666a.b(str);
        if (b2 != null) {
            this.f666a.a(b2, i2, true);
            return;
        }
        p h2 = h(i4);
        if (h2 == null) {
            Log.e("FXAnimationInterface : ", "[c] ERROR: AttachCustomSkeleton not Man/Woman");
            return;
        }
        p pVar = new p();
        pVar.b(h2);
        pVar.c(i3);
        pVar.a(i4);
        pVar.B();
        a(pVar, str, i2, i4);
        l.a(pVar, str);
        pVar.b(1);
        pVar.a(str);
        pVar.b(str);
        pVar.c(str2);
        pVar.g(pVar.x());
        pVar.g(pVar.F());
        pVar.G();
        pVar.C();
        this.f666a.a(pVar);
        b.c(pVar, pVar.F());
        if (pVar.a() != null) {
            b.d(pVar, pVar.a().F());
        }
        this.f666a.a(pVar, i2, true);
    }

    public p h(int i2) {
        return this.f666a.d(i2);
    }

    public int[] c(String str) {
        return l.a(str);
    }

    public ArrayList<String> d(String str) {
        return l.b(str);
    }

    public void a(String str, ArrayList<String> arrayList, String str2, ArrayList<String> arrayList2, ArrayList<String> arrayList3, int i2, h.d dVar, int i3, boolean z, boolean z2) {
        String str3 = str;
        ArrayList<String> arrayList4 = arrayList;
        String str4 = str2;
        ArrayList<String> arrayList5 = arrayList2;
        ArrayList<String> arrayList6 = arrayList3;
        int i4 = i2;
        h.d dVar2 = dVar;
        k a2 = this.f666a.a(str3);
        e d2 = this.f666a.d(str3);
        if (a2 == null) {
            a2 = new k();
            a2.e();
            a2.a(i3);
            a2.a(dVar2);
            a2.b((Bitmap) null);
            a2.b(str3);
            if (arrayList4 != null) {
                Bitmap[] bitmapArr = new Bitmap[arrayList.size()];
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    bitmapArr[i5] = l.a(arrayList4.get(i5), this.g);
                }
                a2.a(bitmapArr, (String[]) arrayList4.toArray(new String[arrayList.size()]));
                a2.a(str4);
            }
            this.f666a.a(a2);
        } else {
            a2.a(str4);
            a2.e();
        }
        if (d2 == null) {
            p b2 = this.f666a.b(i4);
            if (b2.E().k == null) {
                Log.e("FXAnimationInterface : ", "Skeleton data does not have a bind pose infomation, this causes wrong render result");
            }
            d a3 = l.a(str3, (dVar2 == h.d.HAIR || dVar2 == h.d.HEAD || dVar2 == h.d.HAIR_ACC) ? 46 : 0, b2, true);
            a3.a(z2);
            if (dVar2 == h.d.BODY) {
                a3.g();
                a3.i();
            }
            if (arrayList5 != null) {
                Bitmap[] bitmapArr2 = new Bitmap[arrayList2.size()];
                for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                    bitmapArr2[i6] = l.a(arrayList5.get(i6), this.g);
                }
                a2.b(bitmapArr2);
            }
            e eVar = new e();
            eVar.g();
            eVar.a(a3);
            eVar.a(str3);
            eVar.a(h.a.MESH);
            this.f666a.a(eVar);
            if (arrayList6 != null) {
                for (int i7 = 0; i7 < arrayList3.size(); i7++) {
                    eVar.a(l.c(arrayList6.get(i7)), a3.p());
                }
                this.f666a.a(a2, eVar);
                float[] fArr = new float[26];
                for (int i8 = 0; i8 < 26; i8++) {
                    fArr[i8] = 0.0f;
                }
                a2.e(a2.h(eVar.a(fArr, eVar.q())));
            } else {
                this.f666a.a(a2, eVar);
                a2.e(a2.h(eVar.q()));
            }
        } else {
            this.f666a.a(a2, d2);
            d2.h();
        }
        this.f666a.a(a2, i4, z);
    }

    public void a(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, int i2, h.d dVar, int i3, boolean z, boolean z2) {
        k a2 = this.f666a.a(str);
        e d2 = this.f666a.d(str);
        if (a2 == null) {
            a2 = new k();
            a2.e();
            Bitmap[] bitmapArr = new Bitmap[arrayList.size()];
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                bitmapArr[i4] = l.a(arrayList.get(i4), this.g);
            }
            a2.a(i3);
            a2.a(dVar);
            a2.a(bitmapArr);
            a2.b(str);
            this.f666a.a(a2);
        } else {
            a2.e();
        }
        if (d2 == null) {
            p b2 = this.f666a.b(i2);
            if (b2 == null) {
                Log.e("FXAnimationInterface : ", "mSkeleton is null, we need skeleton to add body mesh: " + str);
                return;
            }
            int i5 = (dVar == h.d.HAIR || dVar == h.d.HEAD || dVar == h.d.HAIR_ACC) ? 46 : 0;
            if (!z2) {
                i5 = 0;
            }
            d a3 = l.a(str, i5, b2, z2);
            a3.a(true);
            e eVar = new e();
            eVar.g();
            eVar.a(a3);
            eVar.a(str);
            eVar.a(h.a.MESH);
            this.f666a.a(eVar);
            if (arrayList2 != null) {
                for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                    eVar.a(l.c(arrayList2.get(i6)), a3.p());
                }
                float[] fArr = new float[26];
                for (int i7 = 0; i7 < 26; i7++) {
                    fArr[i7] = 0.0f;
                }
                float[] a4 = eVar.a(fArr, eVar.q());
                this.f666a.a(a2, eVar);
                a2.e(a2.h(a4));
            } else {
                this.f666a.a(a2, eVar);
                a2.e(a2.h(eVar.q()));
            }
        } else {
            this.f666a.a(a2, d2);
            d2.h();
        }
        this.f666a.a(a2, i2, z);
    }

    public void a(String str, String str2, ArrayList<String> arrayList, ArrayList<String> arrayList2, GlobalDefine.CLOTHES_CATEGORY_TYPE clothes_category_type, h.d dVar, int i2, int i3, int i4) {
        String str3 = str;
        String str4 = str2;
        ArrayList<String> arrayList3 = arrayList2;
        if (this.f667b.g() == null) {
            Log.e("FXAnimationInterface : ", "[c] AddClothMesh - tempAnimator == null!");
            return;
        }
        p h2 = h(i3);
        if (h2 == null) {
            Log.e("FXAnimationInterface : ", "[c] ERROR: AddClothMesh - no available reference skeleton");
            return;
        }
        k a2 = this.f666a.a(str3);
        e d2 = this.f666a.d(str4);
        ArrayList<i> p = h2.p();
        if (d2 == null) {
            d2 = new e();
            d2.g();
            d a3 = l.a(str4, 0, h2, true);
            a3.a(false);
            a3.g();
            a3.i();
            d2.a(a3);
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                d2.a(l.c(arrayList.get(i5)), a3.p());
            }
            if (arrayList3 != null) {
                d2.a(true);
                for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                    d2.a(l.c(arrayList3.get(i6)), a3.p());
                }
            }
            d2.a(h.a.MESH);
            d2.a(str4);
            d2.b(true);
            this.f666a.a(d2);
        } else {
            d2.h();
        }
        e eVar = d2;
        if (a2 == null) {
            l.a b2 = l.b(str3, this.g);
            a2 = l.a(p, str, h2, eVar.y(), eVar.z(), (short[]) null, eVar.A(), b2.h, dVar);
            a2.e();
            a2.a(i2);
            a2.a(dVar);
            a2.a(clothes_category_type);
            a2.b(b2.h);
            a2.a(b2.g);
            a2.b(str3);
            a2.a(true);
            this.f666a.a(a2);
        } else {
            a2.e();
        }
        a2.d(i4);
        this.f666a.a(a2, eVar);
        if (!a2.af()) {
            Log.e("FXAnimationInterface : ", "[i] UpdateCollisionTable failed " + str3);
        }
    }

    public void a(String str, ArrayList<String> arrayList, String str2, int i2, int i3) {
        if (str == null || arrayList == null || str2 == null) {
            Log.e("FXAnimationInterface : ", " SkeletonData Path or Lists are null, please check it ");
        }
        a(str, arrayList, str2, i2, this.f, c(str), i3);
        this.f++;
    }

    public void a(String str, String str2, String str3, int i2, int i3) {
        if (str2 == null || str3 == null) {
            Log.e("FXAnimationInterface : ", " SkeletonHairData Path or SkeletonHairAniData are null, please check it ");
        }
        a(str, str2, str3, i2, this.f, d(str2), i3);
        this.f++;
    }

    public void e(String str) {
        p c2 = this.f666a.c(str);
        if (c2 != null) {
            c2.b();
        }
    }

    public void a(String str, String str2, int i2, int i3) {
        if (str == null) {
            Log.e("FXAnimationInterface : ", " MeshData customAnimationFilePath is null, please check it ");
        }
        a(str, str2, i2, this.f, i3);
        this.f++;
    }

    public void a(String str, ArrayList<String> arrayList, String str2, ArrayList<String> arrayList2, int i2, h.d dVar, ArrayList<String> arrayList3, boolean z, boolean z2) {
        if (str == null) {
            Log.e("FXAnimationInterface : ", " MeshData meshFilePath are null, please check it ");
            return;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            Log.e("FXAnimationInterface : ", " MeshData textureFilePath are null, please check it, mesh will be generated without textures ");
        }
        if (arrayList3 == null) {
            Log.e("FXAnimationInterface : ", " There are no blendShape. If it needs, please add blendShapeFile");
            a(str, arrayList, str2, arrayList2, (ArrayList<String>) null, i2, dVar, this.e, z, z2);
            this.e++;
            return;
        }
        a(str, arrayList, str2, arrayList2, arrayList3, i2, dVar, this.e, z, z2);
        this.e++;
    }

    public void a(String str, ArrayList<String> arrayList, int i2, h.d dVar, ArrayList<String> arrayList2, boolean z, boolean z2) {
        if (str == null || arrayList == null) {
            Log.e("FXAnimationInterface : ", " MeshData meshFilePath or textureFilePath are null, please check it ");
        } else if (arrayList2 == null) {
            Log.e("FXAnimationInterface : ", " There are no blendShape. If it needs, please add blendShapeFile");
            a(str, arrayList, (ArrayList<String>) null, i2, dVar, this.e, z, z2);
            this.e++;
        } else {
            a(str, arrayList, arrayList2, i2, dVar, this.e, z, z2);
            this.e++;
        }
    }

    public void a(String str, String str2, ArrayList<String> arrayList, ArrayList<String> arrayList2, GlobalDefine.CLOTHES_CATEGORY_TYPE clothes_category_type, h.d dVar, int i2, int i3) {
        if (str == null) {
            Log.e("FXAnimationInterface : ", " MeshData meshFilePath or textureFilePath are null, please check it ");
        } else if (arrayList == null || str2 == null) {
            Log.e("FXAnimationInterface : ", " baseMeshFilePath, blendShapeFilePathList is null, please check it ");
        } else {
            a(str, str2, arrayList, arrayList2, clothes_category_type, dVar, this.e, i2, i3);
            this.e++;
        }
    }

    public void a(String str, String str2, int i2, h.d dVar) {
        if (str == null || str2 == null) {
            Log.e("FXAnimationInterface : ", " MeshData meshFilePath or textureFilePath are null, please check it ");
            return;
        }
        a(str, new ArrayList(Arrays.asList(new String[]{str2})), str2, (ArrayList<String>) null, (ArrayList<String>) null, i2, dVar, this.e, false, false);
        this.e++;
    }

    public float[] a(int i2, float[] fArr) {
        p c2 = this.f666a.c(i2);
        if (c2 == null || c2.E() == null || c2.E().k == null) {
            Log.e("FXAnimationInterface : ", "[c] UpdateSkeletonBlendWeight skeleton null!");
            return null;
        }
        c2.g(fArr);
        float[] fArr2 = {c2.E().k[301], c2.E().k[201], c2.E().k[200]};
        b.a(c2, c2.F());
        if (c2.a() != null) {
            b.b(c2, c2.a().F());
        }
        fArr2[0] = c2.E().k[301] - c2.E().m[301];
        fArr2[1] = c2.E().k[201] - c2.E().m[201];
        fArr2[2] = c2.E().k[200] - c2.E().m[200];
        return fArr2;
    }

    public void b(int i2, float[] fArr) {
        if (i2 >= 4) {
            Log.e("FXAnimationInterface : ", "Update Blend Weight is allowed only to avatar");
            return;
        }
        c f2 = this.f666a.f(i2);
        float[] a2 = a(i2, fArr);
        if (f2.f670a != null) {
            f2.f670a.a(fArr, this.f666a.c(i2));
        }
        if (f2.f671b != null) {
            f2.f671b.f(a2[0]);
        }
        if (f2.c != null) {
            f2.c.f(a2[0]);
        }
        if (f2.i != null) {
            f2.i.f(a2[1]);
            f2.i.g(a2[2]);
        }
        f2.a(fArr);
    }

    public void i(int i2) {
        p c2;
        c f2 = this.f666a.f(4);
        c f3 = this.f666a.f(i2 == 0 ? 0 : i2 == 1 ? 1 : i2 == 2 ? 2 : i2 == 3 ? 3 : 4);
        if (!(f3.f670a == null || (c2 = this.f666a.c(4)) == null)) {
            f3.f670a.a(f2.a(), c2);
        }
        f3.a(f2.a());
    }

    public float a(int i2, float[] fArr, int[] iArr, float f2) {
        if (i2 >= 4) {
            Log.e("FXAnimationInterface : ", "Update Blend Weight is allowed only to avatar");
            return GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        }
        c f3 = this.f666a.f(i2);
        if (f3.f670a != null) {
            return f3.f670a.a(fArr, iArr, f2);
        }
        return GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    }

    public float[] a(int i2, float[] fArr, float f2) {
        int[] iArr;
        int i3 = i2;
        float[] fArr2 = fArr;
        if (i3 == 1) {
            iArr = h;
        } else if (i3 == 0) {
            iArr = i;
        } else {
            Log.e("FXAnimationInterface : ", "[c] SearchUpdateBodyBlendWeight not support!");
            return null;
        }
        float f3 = f2;
        float f4 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        while (true) {
            float a2 = a(i3, fArr2, iArr, f3);
            if (f4 == a2 || Math.abs(a2) < j) {
                break;
            }
            float abs = Math.abs(a2) * 5.0f;
            if (abs < 1.0f) {
                abs = 1.0f;
            }
            if (a2 > j) {
                if (fArr2[4] > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                    fArr2[4] = fArr2[4] - (k * abs);
                    if (fArr2[4] < GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                        fArr2[4] = 0.0f;
                        fArr2[5] = k * abs;
                    }
                } else if (fArr2[5] > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                    fArr2[5] = fArr2[5] + (k * abs);
                    if (fArr2[5] > 1.0f) {
                        fArr2[5] = 1.0f;
                        if (this.f667b.e() == 9 || this.f667b.e() == 2 || this.f667b.e() == 6 || this.f667b.e() == -1) {
                            return null;
                        }
                        return fArr2;
                    }
                }
            } else if (a2 < (-j)) {
                if (fArr2[4] > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                    fArr2[4] = fArr2[4] + (k * abs);
                    if (fArr2[4] > 1.0f) {
                        fArr2[4] = 1.0f;
                        if (this.f667b.e() == 9 || this.f667b.e() == 2 || this.f667b.e() == 6 || this.f667b.e() == -1) {
                            return null;
                        }
                        return fArr2;
                    }
                } else if (fArr2[5] > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                    fArr2[5] = fArr2[5] - (k * abs);
                    if (fArr2[5] < GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                        fArr2[5] = 0.0f;
                        fArr2[4] = k * abs;
                    }
                }
            }
            if (Math.abs(a2) <= j) {
                break;
            }
            f4 = a2;
        }
        return fArr2;
    }

    public void b(int i2, float[] fArr, float f2) {
        if (i2 == 1 || i2 == 0) {
            float[] a2 = a(i2, fArr, f2);
            if (a2 != null) {
                b(i2, a2);
            }
        } else if (i2 == 2 || i2 == 3) {
            b(i2, fArr);
        } else {
            Log.e("FXAnimationInterface : ", "[c] UpdateBodyBlendWeight() - adjWeight (only female and male) not support!");
            b(i2, fArr);
        }
    }

    public boolean j(int i2) {
        if (this.f666a.f(i2).f671b != null) {
            return this.f666a.f(i2).f671b.j();
        }
        return false;
    }

    public float k(int i2) {
        return this.f666a.f(i2).f671b != null ? this.f666a.f(i2).f671b.ab() : GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    }

    public void a(int i2, int i3, float f2) {
        if (this.f666a.f(i2).f671b != null) {
            this.f666a.f(i2).f671b.c(i3);
            this.f666a.f(i2).f671b.e(f2);
        }
    }

    public boolean a(String str, int i2) {
        k a2 = this.f666a.a(str);
        if (a2 == null) {
            Log.e("FXAnimationInterface : ", "Requested mesh does not exist!");
            return false;
        }
        a2.f();
        this.f666a.a(a2, i2, false);
        return true;
    }

    public void a(int i2, h.d dVar) {
        this.f666a.a(i2, dVar);
    }

    public void a(int i2, boolean z, boolean z2, boolean z3) {
        this.f666a.a(i2, z, z2, z3);
    }

    public void c(int i2, float[] fArr) {
        this.f666a.a(i2, fArr);
    }

    public Bitmap a(float[] fArr, int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        k kVar;
        if (!z2) {
            int i5 = i4;
            kVar = this.f666a.b(i4, h.d.BODY);
            if (kVar != null) {
                kVar.b(kVar.S());
            }
        } else {
            int i6 = i4;
            kVar = null;
        }
        k kVar2 = kVar;
        Bitmap a2 = this.f667b.a(fArr, i2, i3, i4, z, z2, z3);
        if (kVar2 != null) {
            kVar2.y();
        }
        return a2;
    }

    public void a(int i2, float f2) {
        this.f666a.a(i2, f2);
    }

    public void a(int i2, boolean z) {
        this.f666a.a(i2, z);
    }

    public void a(int i2, e.b bVar) {
        this.f666a.a(i2, bVar.f1504a, bVar.f1505b, bVar.c, bVar.h, bVar.f, bVar.g, bVar.d, bVar.e);
    }

    public void b(int i2, e.b bVar) {
        this.f666a.a(i2, bVar.f1504a, bVar.f1505b, bVar.c, bVar.h, bVar.f, bVar.g, bVar.d);
    }

    public void a(boolean z) {
        this.f667b.a(z);
    }

    public boolean i() {
        return this.f667b.c();
    }

    public void j() {
        this.f667b.h();
    }

    private void a(p pVar, String str, int i2, int i3) {
        p pVar2 = pVar;
        String str2 = str;
        int i4 = i3;
        if (str2.contains("Woman/Animation_44.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 1.0f;
            pVar2.d = 0.36f;
            pVar2.e = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.g = 0.5f;
            pVar2.i[0] = 2.5f;
            pVar2.i[1] = 0.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.0f;
            pVar2.h[1] = 0.25f;
            pVar2.h[2] = 0.674244f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.215634f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.0f;
            pVar2.h[7] = 0.0f;
            pVar2.h[8] = 0.467194f;
            pVar2.h[9] = 0.0f;
            pVar2.h[10] = 0.247555f;
            pVar2.h[11] = 0.0f;
            pVar2.h[12] = 0.494891f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.407443f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = 0.3f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.0f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.1f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.35f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.1f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 0.0f;
            pVar2.j[2] = 0.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (str2.contains("Woman/Animation_55.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 2.3f;
            pVar2.d = 0.32f;
            pVar2.e = -1.6f;
            pVar2.f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.g = 3.0f;
            pVar2.i[0] = 0.0f;
            pVar2.i[1] = 0.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.0f;
            pVar2.h[1] = 0.1f;
            pVar2.h[2] = 0.2f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.2915189f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.089449f;
            pVar2.h[7] = 0.0f;
            pVar2.h[8] = 0.7432f;
            pVar2.h[9] = 0.0f;
            pVar2.h[10] = 0.0f;
            pVar2.h[11] = 0.1f;
            pVar2.h[12] = 0.55f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.16987f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = 0.16987f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.16987f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.20987f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.3f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.3f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 0.0f;
            pVar2.j[2] = 0.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (str2.contains("Woman/Animation_66.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 2.3f;
            pVar2.d = 0.32f;
            pVar2.e = -0.8f;
            pVar2.f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.g = 1.1f;
            pVar2.i[0] = 0.0f;
            pVar2.i[1] = 0.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.4f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.47404128f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.3810875f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.46057597f;
            pVar2.h[7] = 0.0f;
            pVar2.h[8] = 0.312f;
            pVar2.h[9] = 0.0f;
            pVar2.h[10] = 0.1f;
            pVar2.h[11] = 0.0f;
            pVar2.h[12] = 0.95459f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.314f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = 0.314f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.314f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.514f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.48f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.41311f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 0.0f;
            pVar2.j[2] = 0.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (str2.contains("Man/Animation_95.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 2.3f;
            pVar2.d = 0.3f;
            pVar2.e = -0.5f;
            pVar2.f = 0.5f;
            pVar2.g = 0.3f;
            pVar2.i[0] = 0.0f;
            pVar2.i[1] = 0.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.018f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.1243f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.13f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.0f;
            pVar2.h[7] = 0.13f;
            pVar2.h[8] = 0.0f;
            pVar2.h[9] = 0.0f;
            pVar2.h[10] = 0.0f;
            pVar2.h[11] = 0.1971203f;
            pVar2.h[12] = 0.1f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.2539544f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = 0.2539544f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.2539544f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.0f;
            pVar2.h[21] = 0.1f;
            pVar2.h[22] = 0.44008f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.34008f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 0.0f;
            pVar2.j[2] = 0.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (str2.contains("Man/Animation_100.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 2.3f;
            pVar2.d = 0.32f;
            pVar2.e = -0.5f;
            pVar2.f = 0.5f;
            pVar2.g = 0.5f;
            pVar2.i[0] = 0.0f;
            pVar2.i[1] = 0.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.6425976f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.2823115f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.4f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.2229715f;
            pVar2.h[7] = 0.0f;
            pVar2.h[8] = 0.14329383f;
            pVar2.h[9] = 0.0f;
            pVar2.h[10] = 0.12004225f;
            pVar2.h[11] = 0.0f;
            pVar2.h[12] = 0.41687375f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.20291509f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = 0.4829151f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.20291509f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.20291509f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.6f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.6f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 0.0f;
            pVar2.j[2] = 0.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (str2.contains("Man/Animation_105.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 1.0f;
            pVar2.d = 0.25f;
            pVar2.e = 0.5f;
            pVar2.f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.g = 0.5f;
            pVar2.i[0] = 0.0f;
            pVar2.i[1] = 0.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.353029f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.338571f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.381277f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.2239f;
            pVar2.h[7] = 0.0f;
            pVar2.h[8] = 0.239365f;
            pVar2.h[9] = 0.0f;
            pVar2.h[10] = 0.150033f;
            pVar2.h[11] = 0.0f;
            pVar2.h[12] = 0.143097f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.20972f;
            pVar2.h[15] = 0.096143f;
            pVar2.h[16] = 0.4f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.0f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.2f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.45f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.45f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 0.0f;
            pVar2.j[2] = 0.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (str2.contains("Man/Animation_110.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 2.6f;
            pVar2.d = 0.28f;
            pVar2.e = -0.7f;
            pVar2.f = 0.5f;
            pVar2.g = -0.0f;
            pVar2.i[0] = 0.0f;
            pVar2.i[1] = 0.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.6f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.3002237f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.325f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.16160862f;
            pVar2.h[7] = 0.0f;
            pVar2.h[8] = 0.2715246f;
            pVar2.h[9] = 0.0f;
            pVar2.h[10] = 0.2536114f;
            pVar2.h[11] = 0.0f;
            pVar2.h[12] = 0.5723168f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.6487844f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = 0.6487844f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.6487844f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.387844f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.8f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.75f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 0.0f;
            pVar2.j[2] = 0.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (str2.contains("Girl/Animation_110.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 2.0f;
            pVar2.d = 0.25f;
            pVar2.e = 1.0f;
            pVar2.f = 1.0f;
            pVar2.g = 2.5f;
            pVar2.i[0] = 2.0f;
            pVar2.i[1] = 9.5f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.06329296f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.62958974f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.3358619f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.22348475f;
            pVar2.h[7] = 0.0f;
            pVar2.h[8] = 0.0f;
            pVar2.h[9] = 0.10712976f;
            pVar2.h[10] = 0.0f;
            pVar2.h[11] = 0.5890264f;
            pVar2.h[12] = 0.0f;
            pVar2.h[13] = 0.10395266f;
            pVar2.h[14] = -0.004807386f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = -0.004807386f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = -0.004807386f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = -0.004807386f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.2736f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.2736f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 13.0f;
            pVar2.j[2] = 40.0f;
            this.f667b.a(1.15f, 55.0f);
        } else if (str2.contains("Girl/Animation_120.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 2.6f;
            pVar2.d = 0.38f;
            pVar2.e = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.f = 1.0f;
            pVar2.g = 3.0f;
            pVar2.i[0] = 2.5f;
            pVar2.i[1] = 0.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.12058056f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.10224384f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.15f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.0f;
            pVar2.h[7] = 0.10231785f;
            pVar2.h[8] = 0.0f;
            pVar2.h[9] = 0.14370476f;
            pVar2.h[10] = 0.0f;
            pVar2.h[11] = 0.9281824f;
            pVar2.h[12] = 0.0f;
            pVar2.h[13] = 0.48f;
            pVar2.h[14] = -0.03070885f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = -0.03070885f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = -0.03070885f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = -0.03070885f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.2456708f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.2456708f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 20.0f;
            pVar2.j[2] = 60.0f;
            this.f667b.a(1.3f, 80.0f);
        } else if (str2.contains("Girl/Animation_130.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 1.5f;
            pVar2.d = 0.6f;
            pVar2.e = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.g = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.i[0] = 0.0f;
            pVar2.i[1] = -17.5f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.0f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.1f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.0f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.0f;
            pVar2.h[7] = 0.2f;
            pVar2.h[8] = 0.1f;
            pVar2.h[9] = 0.0f;
            pVar2.h[10] = 0.0f;
            pVar2.h[11] = 0.0f;
            pVar2.h[12] = 0.0f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.1f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = 0.0f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.0f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.0f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.0f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.1f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.5f;
            pVar2.j[1] = 7.5f;
            pVar2.j[2] = 15.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (str2.contains("Girl/Animation_160.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 2.6f;
            pVar2.d = 0.28f;
            pVar2.e = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.f = 1.75f;
            pVar2.g = 3.0f;
            pVar2.i[0] = -4.0f;
            pVar2.i[1] = 10.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.7006835f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.7756846f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.6427478f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.5601759f;
            pVar2.h[7] = 0.0f;
            pVar2.h[8] = 0.53588164f;
            pVar2.h[9] = 0.0f;
            pVar2.h[10] = 0.0f;
            pVar2.h[11] = 0.35868695f;
            pVar2.h[12] = 0.45735127f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.35013524f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = 0.20013523f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.20013523f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.20013523f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.41317248f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.41317248f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 0.0f;
            pVar2.j[2] = 0.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (str2.contains("Boy/Animation_110.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 2.6f;
            pVar2.d = 0.225f;
            pVar2.e = 0.5f;
            pVar2.f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.g = 2.0f;
            pVar2.i[0] = -17.0f;
            pVar2.i[1] = -2.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.0f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.0916272f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.34797084f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.0f;
            pVar2.h[7] = 0.4f;
            pVar2.h[8] = 0.0f;
            pVar2.h[9] = 0.2f;
            pVar2.h[10] = 0.0f;
            pVar2.h[11] = 0.57743937f;
            pVar2.h[12] = 0.0f;
            pVar2.h[13] = 0.04564868f;
            pVar2.h[14] = 0.050557543f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = 0.010557541f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.010557541f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.010557541f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.284064f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.284064f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 20.0f;
            pVar2.j[2] = 60.0f;
            this.f667b.a(1.3f, 80.0f);
        } else if (str2.contains("Boy/Animation_140.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 2.6f;
            pVar2.d = 0.34f;
            pVar2.e = -0.2f;
            pVar2.f = 1.0f;
            pVar2.g = 1.5f;
            pVar2.i[0] = -34.0f;
            pVar2.i[1] = 22.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.38541055f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.30064708f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.44554773f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.40478247f;
            pVar2.h[7] = 0.0f;
            pVar2.h[8] = 0.035207264f;
            pVar2.h[9] = 0.0f;
            pVar2.h[10] = 0.0f;
            pVar2.h[11] = 0.4872391f;
            pVar2.h[12] = 1.0f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.29031825f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = 0.020318236f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = -0.020318236f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.020318236f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.19254589f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.16254589f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 0.0f;
            pVar2.j[2] = 0.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (str2.contains("Boy/Animation_150.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 1.2f;
            pVar2.d = 0.28f;
            pVar2.e = -0.5f;
            pVar2.f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.g = 3.0f;
            pVar2.i[0] = -1.5f;
            pVar2.i[1] = -21.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.889333f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.6538292f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.7434853f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.8209944f;
            pVar2.h[7] = 0.0f;
            pVar2.h[8] = 0.7219918f;
            pVar2.h[9] = 0.0f;
            pVar2.h[10] = 0.0f;
            pVar2.h[11] = 0.0f;
            pVar2.h[12] = 0.54013515f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.13163035f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = 0.13163035f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.13163035f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.13163035f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.3665184f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.3665184f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 0.0f;
            pVar2.j[2] = 0.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (str2.contains("Boy/Animation_160.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 1.0f;
            pVar2.d = 0.225f;
            pVar2.e = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.f = 0.1f;
            pVar2.g = 2.0f;
            pVar2.i[0] = -1.0f;
            pVar2.i[1] = -10.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.7f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.705082f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.661184f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.145612f;
            pVar2.h[7] = 0.0f;
            pVar2.h[8] = 0.650056f;
            pVar2.h[9] = 0.2f;
            pVar2.h[10] = 0.0f;
            pVar2.h[11] = 0.0f;
            pVar2.h[12] = 0.54177f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.25873f;
            pVar2.h[15] = 0.071353f;
            pVar2.h[16] = 0.2f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.0f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.25f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.4f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.4f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 1.0f;
            pVar2.j[1] = 5.0f;
            pVar2.j[2] = 10.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else {
            pVar2.c = 2.1f;
            pVar2.d = 0.35f;
            pVar2.e = i4 == 0 ? 1.0f : GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.f = i4 == 0 ? 1.0f : GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.g = (i4 == 3 || i4 == 2) ? GlobalDefine.DEFAULT_AUTO_FILTER_VALUE : 1.0f;
            pVar2.i[0] = 0.0f;
            pVar2.i[1] = 0.0f;
            pVar2.h = null;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 0.0f;
            pVar2.j[2] = 0.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        }
    }

    public boolean b(int i2, int i3) {
        if (this.f667b != null) {
            return this.f667b.b(i2, i3);
        }
        return false;
    }

    public void k() {
        k b2;
        if ((g() == h.e.AVATAR || g() == h.e.CHECK_CLOTHES_SIZE) && this.c != null && (b2 = this.f666a.b(h(), h.d.BODY)) != null) {
            if (this.c.a(b2, this.f666a.b(h(), h.d.PANTS), this.f666a.b(h(), h.d.INNER), this.f666a.b(h(), h.d.ONEPIECE), this.f666a.b(h(), h.d.JACK))) {
                this.c.a();
            } else {
                Log.i("FXAnimationInterface : ", "Draping solver is disabled (or failed to initialize)");
            }
        }
    }

    public void a(int i2, int i3, h.d dVar) {
        if (this.f666a != null) {
            this.f666a.a(i2, i3, dVar);
        }
    }

    public void a(qlSolver qlsolver) {
        this.c = qlsolver;
        if (this.f667b != null) {
            this.f667b.a(qlsolver);
        }
    }
}
