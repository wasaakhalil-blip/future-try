package net.fxgear;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.fxgear.AvatarSetting;
import net.fxgear.GlobalDefine;
import net.fxgear.a;
import net.fxgear.b.h;
import net.fxgear.customface.CustomFaceInterface;
import net.fxgear.fittingview.FittingSurfaceView;
import net.fxgear.fittingview.data.FittingFaceData;
import net.fxgear.fittingview.data.a;
import net.fxgear.fittingview.data.b;
import net.fxgear.fittingview.data.c;
import net.fxgear.fittingview.data.d;
import net.fxgear.fittingview.data.e;
import net.fxgear.fittingview.data.f;
import net.fxgear.fittingview.data.g;
import net.fxgear.fittingview.data.h;
import net.fxgear.util.FXUtil;

public class FittingView extends FittingSurfaceView {
    public static final ClothesFileInfo[] EMPTY_CLOTHES = {new ClothesFileInfo(), new ClothesFileInfo(), new ClothesFileInfo(), new ClothesFileInfo(), new ClothesFileInfo()};
    /* access modifiers changed from: private */
    public ClothesFileInfo[] A = new ClothesFileInfo[5];
    /* access modifiers changed from: private */
    public GlobalDefine.ClothesSize[] B = {null, null, null, null, null};
    /* access modifiers changed from: private */
    public AvatarSetting C = null;
    private a D;
    /* access modifiers changed from: private */
    public Bitmap E;
    /* access modifiers changed from: private */
    public final String p = FittingView.class.getSimpleName();
    /* access modifiers changed from: private */
    public int q = 0;
    /* access modifiers changed from: private */
    public int r = 1;
    /* access modifiers changed from: private */
    public int s = 2;
    /* access modifiers changed from: private */
    public int t = 0;
    /* access modifiers changed from: private */
    public int u = 0;
    /* access modifiers changed from: private */
    public RealVideoFileInfo v = new RealVideoFileInfo();
    private int w = -1;
    private boolean x = false;
    private float y = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    private float z = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;

    public interface OnFittingViewListener {
        void OnClothChange(ClothesFileInfo[] clothesFileInfoArr);

        void OnFinishAsyncWork(Runnable runnable);

        void OnOccurError(GlobalDefine.Result result);

        void OnResultCustomFace(GlobalDefine.Result result);

        void OnStartAsyncWork();
    }

    /* access modifiers changed from: private */
    public int b(int i, int i2, int i3) {
        if (i == 0) {
            return 4;
        }
        if (i2 == 2) {
            return i3 == 1 ? 2 : 0;
        }
        if (i2 != 1) {
            return 0;
        }
        if (i3 == 1) {
            return 3;
        }
        return i3 == 2 ? 1 : 0;
    }

    public static class ClothesFileInfo {
        public String mBaseDirectoryPath = null;
        public int mClothType = -1;
        public String mPackageFilePath = null;

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof ClothesFileInfo)) {
                return false;
            }
            ClothesFileInfo clothesFileInfo = (ClothesFileInfo) obj;
            return (this.mClothType != clothesFileInfo.mClothType || this.mBaseDirectoryPath == null || clothesFileInfo.mBaseDirectoryPath == null || !this.mBaseDirectoryPath.equals(clothesFileInfo.mBaseDirectoryPath) || this.mPackageFilePath == null || clothesFileInfo.mPackageFilePath == null || !this.mPackageFilePath.equals(clothesFileInfo.mPackageFilePath)) ? false : true;
        }

        private ClothesFileInfo a() {
            ClothesFileInfo clothesFileInfo = new ClothesFileInfo();
            clothesFileInfo.mClothType = this.mClothType;
            String str = null;
            clothesFileInfo.mBaseDirectoryPath = this.mBaseDirectoryPath != null ? new String(this.mBaseDirectoryPath) : null;
            if (this.mPackageFilePath != null) {
                str = new String(this.mPackageFilePath);
            }
            clothesFileInfo.mPackageFilePath = str;
            return clothesFileInfo;
        }

        /* access modifiers changed from: private */
        public static ClothesFileInfo[] b(ClothesFileInfo[] clothesFileInfoArr) {
            if (clothesFileInfoArr == null) {
                return null;
            }
            ClothesFileInfo[] clothesFileInfoArr2 = new ClothesFileInfo[clothesFileInfoArr.length];
            for (int i = 0; i < clothesFileInfoArr.length; i++) {
                clothesFileInfoArr2[i] = clothesFileInfoArr[i].a();
            }
            return clothesFileInfoArr2;
        }
    }

    public static class RealVideoFileInfo {
        public String mAnimationFilePath = null;
        public String mVideoFilePath = null;

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof RealVideoFileInfo)) {
                return false;
            }
            RealVideoFileInfo realVideoFileInfo = (RealVideoFileInfo) obj;
            return (this.mAnimationFilePath == null || realVideoFileInfo.mAnimationFilePath == null || !this.mAnimationFilePath.equals(realVideoFileInfo.mAnimationFilePath) || this.mVideoFilePath == null || realVideoFileInfo.mVideoFilePath == null || !this.mVideoFilePath.equals(realVideoFileInfo.mVideoFilePath)) ? false : true;
        }

        /* access modifiers changed from: private */
        public RealVideoFileInfo a() {
            RealVideoFileInfo realVideoFileInfo = new RealVideoFileInfo();
            String str = null;
            realVideoFileInfo.mAnimationFilePath = this.mAnimationFilePath != null ? new String(this.mAnimationFilePath) : null;
            if (this.mVideoFilePath != null) {
                str = new String(this.mVideoFilePath);
            }
            realVideoFileInfo.mVideoFilePath = str;
            return realVideoFileInfo;
        }
    }

    public FittingView(Context context, OnFittingViewListener onFittingViewListener) {
        super(context);
        CustomFaceInterface.checkSdkAllowed(context);
        this.D = new a();
        this.C = new AvatarSetting(context);
    }

    public boolean SetBackgroundBGBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        return super.SetBackgroundBGBitmap(bitmap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean Initialize(int r3, int r4, int r5, int r6, int r7, int r8, boolean r9, net.fxgear.FittingView.ClothesFileInfo[] r10, net.fxgear.BodySizeData r11, int r12, float r13, net.fxgear.FittingView.OnFittingViewListener r14, java.lang.Runnable r15) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = r2.p     // Catch:{ all -> 0x009f }
            java.lang.String r1 = "Initialize()+"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x009f }
            if (r3 != 0) goto L_0x000f
            java.lang.String r0 = "[ERROR] :: Illegal state. call another Initialize method with parameter RealVideoFileInfo for real mode"
            net.fxgear.util.FXUtil.OccurRunTimeException((java.lang.String) r0)     // Catch:{ all -> 0x009f }
        L_0x000f:
            net.fxgear.a r0 = r2.D     // Catch:{ all -> 0x009f }
            r1 = 0
            if (r0 == 0) goto L_0x009d
            net.fxgear.a r0 = r2.D     // Catch:{ all -> 0x009f }
            boolean r0 = r0.a()     // Catch:{ all -> 0x009f }
            if (r0 != 0) goto L_0x009d
            if (r14 == 0) goto L_0x0021
            r14.OnStartAsyncWork()     // Catch:{ all -> 0x009f }
        L_0x0021:
            r2.q = r3     // Catch:{ all -> 0x009f }
            r2.r = r4     // Catch:{ all -> 0x009f }
            r2.s = r5     // Catch:{ all -> 0x009f }
            r2.t = r6     // Catch:{ all -> 0x009f }
            r2.u = r7     // Catch:{ all -> 0x009f }
            r2.w = r8     // Catch:{ all -> 0x009f }
            r2.x = r9     // Catch:{ all -> 0x009f }
            r2.y = r13     // Catch:{ all -> 0x009f }
            r3 = 3
            float[] r3 = new float[r3]     // Catch:{ all -> 0x009f }
            int r4 = net.fxgear.util.FXUtil.redFromColor(r12)     // Catch:{ all -> 0x009f }
            float r4 = (float) r4     // Catch:{ all -> 0x009f }
            r3[r1] = r4     // Catch:{ all -> 0x009f }
            int r4 = net.fxgear.util.FXUtil.greenFromColor(r12)     // Catch:{ all -> 0x009f }
            float r4 = (float) r4     // Catch:{ all -> 0x009f }
            r5 = 1
            r3[r5] = r4     // Catch:{ all -> 0x009f }
            r4 = 2
            int r6 = net.fxgear.util.FXUtil.blueFromColor(r12)     // Catch:{ all -> 0x009f }
            float r6 = (float) r6     // Catch:{ all -> 0x009f }
            r3[r4] = r6     // Catch:{ all -> 0x009f }
            float r3 = net.fxgear.fittingview.FittingSurfaceView.colorTemperatureToNormalizeValue(r3)     // Catch:{ all -> 0x009f }
            r2.z = r3     // Catch:{ all -> 0x009f }
            int r3 = r2.r     // Catch:{ all -> 0x009f }
            int r4 = r2.s     // Catch:{ all -> 0x009f }
            r2.a((int) r3, (int) r4, (net.fxgear.BodySizeData) r11)     // Catch:{ all -> 0x009f }
            if (r10 == 0) goto L_0x0065
            int r3 = r10.length     // Catch:{ all -> 0x009f }
            net.fxgear.FittingView$ClothesFileInfo[] r4 = r2.A     // Catch:{ all -> 0x009f }
            int r4 = r4.length     // Catch:{ all -> 0x009f }
            if (r3 != r4) goto L_0x0065
            net.fxgear.FittingView$ClothesFileInfo[] r3 = net.fxgear.FittingView.ClothesFileInfo.b(r10)     // Catch:{ all -> 0x009f }
            goto L_0x006b
        L_0x0065:
            net.fxgear.FittingView$ClothesFileInfo[] r3 = EMPTY_CLOTHES     // Catch:{ all -> 0x009f }
            net.fxgear.FittingView$ClothesFileInfo[] r3 = net.fxgear.FittingView.ClothesFileInfo.b(r3)     // Catch:{ all -> 0x009f }
        L_0x006b:
            r11 = r3
            r3 = 0
        L_0x006d:
            net.fxgear.GlobalDefine$ClothesSize[] r4 = r2.B     // Catch:{ all -> 0x009f }
            int r4 = r4.length     // Catch:{ all -> 0x009f }
            if (r3 >= r4) goto L_0x0081
            int r4 = r2.r     // Catch:{ all -> 0x009f }
            int r6 = r2.s     // Catch:{ all -> 0x009f }
            net.fxgear.GlobalDefine$ClothesSize r4 = net.fxgear.ClothesSizeProvider.GetClosestClothSize((int) r4, (int) r6, (int) r3, (boolean) r1)     // Catch:{ all -> 0x009f }
            net.fxgear.GlobalDefine$ClothesSize[] r6 = r2.B     // Catch:{ all -> 0x009f }
            r6[r3] = r4     // Catch:{ all -> 0x009f }
            int r3 = r3 + 1
            goto L_0x006d
        L_0x0081:
            net.fxgear.GlobalDefine$Result r9 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x009f }
            r9.<init>()     // Catch:{ all -> 0x009f }
            r9.resultCode = r1     // Catch:{ all -> 0x009f }
            net.fxgear.a r3 = r2.D     // Catch:{ all -> 0x009f }
            net.fxgear.FittingView$1 r4 = new net.fxgear.FittingView$1     // Catch:{ all -> 0x009f }
            r4.<init>(r11, r9)     // Catch:{ all -> 0x009f }
            net.fxgear.FittingView$12 r12 = new net.fxgear.FittingView$12     // Catch:{ all -> 0x009f }
            r6 = r12
            r7 = r2
            r8 = r14
            r10 = r15
            r6.<init>(r8, r9, r10, r11)     // Catch:{ all -> 0x009f }
            r3.a((java.lang.Runnable) r4, (net.fxgear.a.C0022a) r12)     // Catch:{ all -> 0x009f }
            monitor-exit(r2)
            return r5
        L_0x009d:
            monitor-exit(r2)
            return r1
        L_0x009f:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.Initialize(int, int, int, int, int, int, boolean, net.fxgear.FittingView$ClothesFileInfo[], net.fxgear.BodySizeData, int, float, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00bb, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean Initialize(int r9, int r10, int r11, int r12, int r13, net.fxgear.FittingView.RealVideoFileInfo r14, int r15, boolean r16, net.fxgear.FittingView.ClothesFileInfo[] r17, net.fxgear.BodySizeData r18, int r19, float r20, net.fxgear.FittingView.OnFittingViewListener r21, java.lang.Runnable r22) {
        /*
            r8 = this;
            r1 = r8
            r0 = r17
            monitor-enter(r8)
            java.lang.String r2 = r1.p     // Catch:{ all -> 0x00bc }
            java.lang.String r3 = "Initialize()+"
            android.util.Log.d(r2, r3)     // Catch:{ all -> 0x00bc }
            r2 = r14
            boolean r3 = r8.a((net.fxgear.FittingView.RealVideoFileInfo) r14)     // Catch:{ all -> 0x00bc }
            if (r3 != 0) goto L_0x0017
            java.lang.String r3 = "Not found real data or illegal state."
            net.fxgear.util.FXUtil.OccurRunTimeException((java.lang.String) r3)     // Catch:{ all -> 0x00bc }
        L_0x0017:
            net.fxgear.a r3 = r1.D     // Catch:{ all -> 0x00bc }
            r4 = 0
            if (r3 == 0) goto L_0x00ba
            net.fxgear.a r3 = r1.D     // Catch:{ all -> 0x00bc }
            boolean r3 = r3.a()     // Catch:{ all -> 0x00bc }
            if (r3 != 0) goto L_0x00ba
            if (r21 == 0) goto L_0x0029
            r21.OnStartAsyncWork()     // Catch:{ all -> 0x00bc }
        L_0x0029:
            r5 = r9
            r1.q = r5     // Catch:{ all -> 0x00bc }
            r5 = r10
            r1.r = r5     // Catch:{ all -> 0x00bc }
            r5 = r11
            r1.s = r5     // Catch:{ all -> 0x00bc }
            r5 = r12
            r1.t = r5     // Catch:{ all -> 0x00bc }
            r5 = r13
            r1.u = r5     // Catch:{ all -> 0x00bc }
            net.fxgear.FittingView$RealVideoFileInfo r2 = r14.a()     // Catch:{ all -> 0x00bc }
            r1.v = r2     // Catch:{ all -> 0x00bc }
            r2 = r15
            r1.w = r2     // Catch:{ all -> 0x00bc }
            r2 = r16
            r1.x = r2     // Catch:{ all -> 0x00bc }
            r2 = r20
            r1.y = r2     // Catch:{ all -> 0x00bc }
            r2 = 3
            float[] r2 = new float[r2]     // Catch:{ all -> 0x00bc }
            int r5 = net.fxgear.util.FXUtil.redFromColor(r19)     // Catch:{ all -> 0x00bc }
            float r5 = (float) r5     // Catch:{ all -> 0x00bc }
            r2[r4] = r5     // Catch:{ all -> 0x00bc }
            int r5 = net.fxgear.util.FXUtil.greenFromColor(r19)     // Catch:{ all -> 0x00bc }
            float r5 = (float) r5     // Catch:{ all -> 0x00bc }
            r6 = 1
            r2[r6] = r5     // Catch:{ all -> 0x00bc }
            r5 = 2
            int r7 = net.fxgear.util.FXUtil.blueFromColor(r19)     // Catch:{ all -> 0x00bc }
            float r7 = (float) r7     // Catch:{ all -> 0x00bc }
            r2[r5] = r7     // Catch:{ all -> 0x00bc }
            float r2 = net.fxgear.fittingview.FittingSurfaceView.colorTemperatureToNormalizeValue(r2)     // Catch:{ all -> 0x00bc }
            r1.z = r2     // Catch:{ all -> 0x00bc }
            int r2 = r1.r     // Catch:{ all -> 0x00bc }
            int r5 = r1.s     // Catch:{ all -> 0x00bc }
            r7 = r18
            r8.a((int) r2, (int) r5, (net.fxgear.BodySizeData) r7)     // Catch:{ all -> 0x00bc }
            if (r0 == 0) goto L_0x007f
            int r2 = r0.length     // Catch:{ all -> 0x00bc }
            net.fxgear.FittingView$ClothesFileInfo[] r5 = r1.A     // Catch:{ all -> 0x00bc }
            int r5 = r5.length     // Catch:{ all -> 0x00bc }
            if (r2 != r5) goto L_0x007f
            net.fxgear.FittingView$ClothesFileInfo[] r0 = net.fxgear.FittingView.ClothesFileInfo.b(r17)     // Catch:{ all -> 0x00bc }
            goto L_0x0085
        L_0x007f:
            net.fxgear.FittingView$ClothesFileInfo[] r0 = EMPTY_CLOTHES     // Catch:{ all -> 0x00bc }
            net.fxgear.FittingView$ClothesFileInfo[] r0 = net.fxgear.FittingView.ClothesFileInfo.b(r0)     // Catch:{ all -> 0x00bc }
        L_0x0085:
            r2 = 0
        L_0x0086:
            net.fxgear.GlobalDefine$ClothesSize[] r5 = r1.B     // Catch:{ all -> 0x00bc }
            int r5 = r5.length     // Catch:{ all -> 0x00bc }
            if (r2 >= r5) goto L_0x009a
            int r5 = r1.r     // Catch:{ all -> 0x00bc }
            int r7 = r1.s     // Catch:{ all -> 0x00bc }
            net.fxgear.GlobalDefine$ClothesSize r5 = net.fxgear.ClothesSizeProvider.GetClosestClothSize((int) r5, (int) r7, (int) r2, (boolean) r4)     // Catch:{ all -> 0x00bc }
            net.fxgear.GlobalDefine$ClothesSize[] r7 = r1.B     // Catch:{ all -> 0x00bc }
            r7[r2] = r5     // Catch:{ all -> 0x00bc }
            int r2 = r2 + 1
            goto L_0x0086
        L_0x009a:
            net.fxgear.GlobalDefine$Result r2 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x00bc }
            r2.<init>()     // Catch:{ all -> 0x00bc }
            r2.resultCode = r4     // Catch:{ all -> 0x00bc }
            net.fxgear.a r4 = r1.D     // Catch:{ all -> 0x00bc }
            net.fxgear.FittingView$23 r5 = new net.fxgear.FittingView$23     // Catch:{ all -> 0x00bc }
            r5.<init>(r0, r2)     // Catch:{ all -> 0x00bc }
            net.fxgear.FittingView$34 r7 = new net.fxgear.FittingView$34     // Catch:{ all -> 0x00bc }
            r9 = r7
            r10 = r8
            r11 = r21
            r12 = r2
            r13 = r22
            r14 = r0
            r9.<init>(r11, r12, r13, r14)     // Catch:{ all -> 0x00bc }
            r4.a((java.lang.Runnable) r5, (net.fxgear.a.C0022a) r7)     // Catch:{ all -> 0x00bc }
            monitor-exit(r8)
            return r6
        L_0x00ba:
            monitor-exit(r8)
            return r4
        L_0x00bc:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.Initialize(int, int, int, int, int, net.fxgear.FittingView$RealVideoFileInfo, int, boolean, net.fxgear.FittingView$ClothesFileInfo[], net.fxgear.BodySizeData, int, float, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    public void onDestroy() {
        Log.d(this.p, "onDestroy()+");
        if (this.D != null) {
            this.D.b();
            this.D = null;
        }
        if (this.C != null) {
            this.C.Destroy();
            this.C = null;
        }
        if (this.E != null) {
            if (this.E.isRecycled()) {
                this.E.recycle();
            }
            this.E = null;
        }
        super.onDestroy();
    }

    private boolean a(RealVideoFileInfo realVideoFileInfo) {
        if (realVideoFileInfo != null && realVideoFileInfo.mAnimationFilePath != null && realVideoFileInfo.mVideoFilePath != null) {
            return true;
        }
        Log.e(this.p, "[ERROR] :: invalid real video file info");
        return false;
    }

    /* access modifiers changed from: private */
    public b a(int i, int i2, int i3, int i4, int i5) {
        String str;
        String str2;
        int i6;
        File file;
        File file2;
        String str3;
        int i7 = i;
        int i8 = i2;
        Log.d(this.p, "CreateAvatarData()+");
        b bVar = new b();
        boolean z2 = false;
        if (i7 != 2) {
            if (i7 != 1) {
                bVar.a(1);
                str3 = GlobalDefine.DIRECTORY_NAME_WOMAN;
            } else if (i8 == 1) {
                bVar.a(3);
                str2 = String.format(GlobalDefine.FORMAT_PATH_DEPTH_1, new Object[]{GlobalDefine.DIRECTORY_NAME_COMMON, GlobalDefine.DIRECTORY_NAME_KIDS});
                str = GlobalDefine.DIRECTORY_NAME_GIRL;
                i6 = 3;
            } else {
                bVar.a(1);
                str3 = GlobalDefine.DIRECTORY_NAME_WOMAN;
            }
            str2 = str3;
            str = str2;
            i6 = 1;
        } else if (i8 == 1) {
            bVar.a(2);
            str2 = String.format(GlobalDefine.FORMAT_PATH_DEPTH_1, new Object[]{GlobalDefine.DIRECTORY_NAME_COMMON, GlobalDefine.DIRECTORY_NAME_KIDS});
            str = GlobalDefine.DIRECTORY_NAME_BOY;
            i6 = 2;
        } else {
            bVar.a(0);
            str2 = "Man";
            str = str2;
            i6 = 0;
        }
        bVar.b(i6);
        File GetAvatarDirectory = GlobalDefine.GetAvatarDirectory(getContext());
        File file3 = new File(String.format(GlobalDefine.FORMAT_PATH_DEPTH_1, new Object[]{GetAvatarDirectory.getAbsoluteFile(), str2}), GlobalDefine.DIRECTORY_NAME_BODY);
        File file4 = new File(String.format(GlobalDefine.FORMAT_PATH_DEPTH_1, new Object[]{GetAvatarDirectory.getAbsoluteFile(), str}), GlobalDefine.DIRECTORY_NAME_BODY);
        if (!file3.exists() || !file3.isDirectory() || !file4.exists() || !file4.isDirectory()) {
            FXUtil.OccurRunTimeException(file3 + " & " + file4);
        } else {
            c cVar = new c();
            cVar.a(i6);
            File file5 = new File(file3, GlobalDefine.FILE_NAME_MESH);
            if (!file5.exists() || !file5.isFile()) {
                FXUtil.OccurRunTimeException(file5);
            } else {
                cVar.a(file5.getAbsolutePath());
            }
            ArrayList<String> GetBodyTextureFileNames = GlobalDefine.GetBodyTextureFileNames(getContext(), i7, i8);
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = GetBodyTextureFileNames.iterator();
            while (it.hasNext()) {
                File file6 = new File(file4, it.next());
                if (file6.exists()) {
                    arrayList.add(file6.getAbsolutePath());
                }
            }
            cVar.a((ArrayList<String>) arrayList);
            File file7 = new File(file4, GlobalDefine.GetBodyTextureFileName(getContext(), i7, i8, i3));
            if (!file7.exists()) {
                file7 = new File(file4, GlobalDefine.GetBodyTextureFileName(getContext(), i7, i8, 0));
            }
            if (!file7.exists() || !file7.isFile()) {
                FXUtil.OccurRunTimeException(file7);
            } else {
                cVar.b(file7.getAbsolutePath());
            }
            for (int i9 = 1; i9 <= 26; i9++) {
                File file8 = new File(file3, String.format(GlobalDefine.FILE_NAME_FORMAT_BLEND_TARGET, new Object[]{Integer.valueOf(i9)}));
                if (!file8.exists() || !file8.isFile()) {
                    FXUtil.OccurRunTimeException(file8);
                } else {
                    cVar.c(file8.getAbsolutePath());
                }
            }
            for (int i10 = 0; i10 < 9; i10++) {
                File a2 = a(file3, i10);
                if (!a2.exists() || !a2.isFile()) {
                    FXUtil.OccurRunTimeException(a2);
                } else {
                    cVar.a(i10, a2.getAbsolutePath());
                }
            }
            bVar.a(cVar);
        }
        bVar.a(this.y);
        bVar.b(this.z);
        bVar.c((float) this.C.GetHeadScale());
        File file9 = new File(String.format(GlobalDefine.FORMAT_PATH_DEPTH_1, new Object[]{GetAvatarDirectory.getAbsoluteFile(), str}), GlobalDefine.DIRECTORY_NAME_HEAD);
        if (!file9.exists() || !file9.isDirectory()) {
            FXUtil.OccurRunTimeException(file9);
        } else {
            f fVar = new f();
            fVar.a(i6);
            boolean z3 = this.x;
            AvatarSetting.HeadTypeFilesInfo GetHeadTypeInfoByIndex = AvatarSetting.GetHeadTypeInfoByIndex(getContext(), i4, i7, i8);
            if (z3) {
                File GetAvatarRuntimeDirectory = GlobalDefine.GetAvatarRuntimeDirectory(getContext());
                fVar.a(true);
                String[] GetCustomFaceFile = FittingFaceData.GetCustomFaceFile(GetAvatarRuntimeDirectory.getAbsolutePath());
                file = null;
                if (GetCustomFaceFile == null || GetCustomFaceFile.length <= 0) {
                    FXUtil.OccurRunTimeException("[ERROR] :: Not found custom face files.");
                    file2 = null;
                } else {
                    File file10 = new File(GetCustomFaceFile[3]);
                    File a3 = a(GetCustomFaceFile, GetHeadTypeInfoByIndex.mTypeID);
                    if (a3 == null) {
                        FXUtil.OccurRunTimeException("[ERROR] :: Not found custom mesh file.");
                    }
                    File file11 = file10;
                    file = a3;
                    file2 = file11;
                }
            } else {
                file = GetHeadTypeInfoByIndex.f549b;
                file2 = GetHeadTypeInfoByIndex.c;
            }
            if (!file.exists() || !file.isFile()) {
                FXUtil.OccurRunTimeException(file);
            } else {
                fVar.a(file.getAbsolutePath());
            }
            if (!file2.exists() || !file2.isFile()) {
                FXUtil.OccurRunTimeException(file2);
            } else {
                fVar.b(file2.getAbsolutePath());
            }
            bVar.a(fVar);
        }
        File file12 = new File(String.format(GlobalDefine.FORMAT_PATH_DEPTH_1, new Object[]{GetAvatarDirectory.getAbsoluteFile(), str}), GlobalDefine.DIRECTORY_NAME_HAIR);
        if (!file12.exists() || !file12.isDirectory()) {
            FXUtil.OccurRunTimeException(file12);
        } else {
            e eVar = new e();
            eVar.b(i6);
            AvatarSetting.HairTypeFilesInfo GetHairTypeInfoByIndex = AvatarSetting.GetHairTypeInfoByIndex(getContext(), i5, i7, i8);
            AvatarSetting.c cVar2 = GetHairTypeInfoByIndex.j;
            e.b bVar2 = new e.b();
            bVar2.a(cVar2.f559b);
            bVar2.b(cVar2.c);
            bVar2.c(cVar2.d);
            bVar2.d(cVar2.e);
            bVar2.e(cVar2.f);
            bVar2.a(cVar2.g);
            bVar2.b(cVar2.h);
            bVar2.c(cVar2.i);
            eVar.a(cVar2.f558a);
            eVar.a(bVar2);
            if (GetHairTypeInfoByIndex.k != null) {
                AvatarSetting.a aVar = GetHairTypeInfoByIndex.k;
                e.a aVar2 = new e.a();
                File file13 = aVar.f550a;
                if (!file13.exists() || !file13.isFile()) {
                    FXUtil.OccurRunTimeException(file13);
                } else {
                    aVar2.a(file13.getAbsolutePath());
                }
                e.b bVar3 = new e.b();
                bVar3.a(aVar.f551b.f559b);
                bVar3.b(aVar.f551b.c);
                bVar3.c(aVar.f551b.d);
                bVar3.d(aVar.f551b.e);
                bVar3.a(aVar.f551b.g);
                bVar3.b(aVar.f551b.h);
                bVar3.c(aVar.f551b.i);
                aVar2.a(aVar.f551b.f558a);
                aVar2.a(bVar3);
                eVar.a(aVar2);
            }
            File file14 = GetHairTypeInfoByIndex.f547b;
            if (!file14.exists() || !file14.isFile()) {
                FXUtil.OccurRunTimeException(file14);
            } else {
                eVar.a(file14.getAbsolutePath());
            }
            File file15 = GetHairTypeInfoByIndex.c;
            if (!file15.exists() || !file15.isFile()) {
                FXUtil.OccurRunTimeException(file15);
            } else {
                eVar.d(file15.getAbsolutePath());
            }
            File file16 = GetHairTypeInfoByIndex.d;
            if (!file16.exists() || !file16.isFile()) {
                FXUtil.OccurRunTimeException(file16);
            } else {
                eVar.d(file16.getAbsolutePath());
            }
            File file17 = GetHairTypeInfoByIndex.e;
            if (!file17.exists() || !file17.isFile()) {
                FXUtil.OccurRunTimeException(file17);
            } else {
                eVar.d(file17.getAbsolutePath());
            }
            File file18 = GetHairTypeInfoByIndex.f;
            if (!file18.exists() || !file18.isFile()) {
                FXUtil.OccurRunTimeException(file18);
            } else {
                eVar.d(file18.getAbsolutePath());
            }
            File file19 = GetHairTypeInfoByIndex.g;
            if (file19 == null || !file19.exists()) {
                z2 = true;
            } else {
                eVar.b(file19.getAbsolutePath());
            }
            File file20 = GetHairTypeInfoByIndex.h;
            if (file20 != null && file20.exists()) {
                eVar.c(file20.getAbsolutePath());
                z2 = !z2;
            }
            if (!z2) {
                FXUtil.OccurRunTimeException("ERROR :: wrong anitmaion files");
            }
            bVar.a(eVar);
        }
        File GetAvatarFaceCommonDirectory = GlobalDefine.GetAvatarFaceCommonDirectory(getContext(), i7, i8);
        File GetAvatarFaceDirectory = GlobalDefine.GetAvatarFaceDirectory(getContext(), i7, i8);
        if (!GetAvatarFaceCommonDirectory.exists() || !GetAvatarFaceCommonDirectory.isDirectory()) {
            FXUtil.OccurRunTimeException(GetAvatarFaceCommonDirectory);
        } else {
            FittingFaceData fittingFaceData = new FittingFaceData(0, (String) null, (int[]) null, FittingFaceData.a.FEMALE, i6, GetAvatarFaceDirectory.getAbsolutePath() + File.separator, GetAvatarFaceCommonDirectory.getAbsolutePath() + File.separator, (String) null);
            fittingFaceData.SetModelGender(i6);
            bVar.a(fittingFaceData);
        }
        return bVar;
    }

    private File a(String[] strArr, int i) {
        String format = String.format(GlobalDefine.FILE_NAME_KEYWORD_FORMAT_CUSTOM_MESH_TYPE, new Object[]{Integer.valueOf(i)});
        for (String str : strArr) {
            if (str != null) {
                File file = new File(str);
                if (file.getName().endsWith(GlobalDefine.EXTENSION_BIN) && file.getName().startsWith(format)) {
                    return file;
                }
            }
        }
        return null;
    }

    private File a(File file, int i) {
        String str;
        if (file == null || !file.exists() || !file.isDirectory()) {
            Log.e(this.p, "ERROR :: Wrong body directory.");
            return null;
        } else if (i < 0 || i > 8) {
            Log.e(this.p, "ERROR :: Wrong body texture file index.");
            return null;
        } else {
            switch (i) {
                case 0:
                    str = GlobalDefine.FILE_NAME_BODY_TEXTURE_ARM_THICK;
                    break;
                case 1:
                    str = GlobalDefine.FILE_NAME_BODY_TEXTURE_BUST;
                    break;
                case 2:
                    str = GlobalDefine.FILE_NAME_BODY_TEXTURE_CALF_LENGTH;
                    break;
                case 3:
                    str = GlobalDefine.FILE_NAME_BODY_TEXTURE_CUP_SIZE;
                    break;
                case 4:
                    str = GlobalDefine.FILE_NAME_BODY_TEXTURE_HIP;
                    break;
                case 5:
                    str = GlobalDefine.FILE_NAME_BODY_TEXTURE_SHOULDER;
                    break;
                case 6:
                    str = GlobalDefine.FILE_NAME_BODY_TEXTURE_THIGH_LENGTH;
                    break;
                case 7:
                    str = GlobalDefine.FILE_NAME_BODY_TEXTURE_THIGH_THICK;
                    break;
                default:
                    str = GlobalDefine.FILE_NAME_BODY_TEXTURE_WAIST;
                    break;
            }
            File file2 = new File(file, str);
            if (file2.exists() && file2.isFile()) {
                return file2;
            }
            Log.e(this.p, "ERROR :: Not found body texture file.");
            return null;
        }
    }

    /* access modifiers changed from: private */
    public a a(int i, int i2, int i3) {
        String str;
        String str2 = this.p;
        Log.d(str2, "CreateAnimationData()+, animationType : " + i3);
        a aVar = new a();
        int i4 = 3;
        if (i == 2) {
            if (i2 == 1) {
                str = GlobalDefine.DIRECTORY_NAME_BOY;
                i4 = 2;
            } else {
                str = "Man";
                i4 = 0;
            }
        } else if (i != 1) {
            str = GlobalDefine.DIRECTORY_NAME_WOMAN;
        } else if (i2 == 1) {
            str = GlobalDefine.DIRECTORY_NAME_GIRL;
        } else {
            str = GlobalDefine.DIRECTORY_NAME_WOMAN;
            i4 = 1;
        }
        aVar.a(i4);
        File file = new File(GlobalDefine.GetAnimationDirectory(getContext()).getAbsoluteFile(), str);
        if (!file.exists() || !file.isDirectory()) {
            FXUtil.OccurRunTimeException(file);
        } else {
            File GetBoneAnimationFile = GlobalDefine.GetBoneAnimationFile(getContext(), i, i2, i3);
            if (GetBoneAnimationFile == null || !GetBoneAnimationFile.exists()) {
                GetBoneAnimationFile = GlobalDefine.GetBoneAnimationFile(getContext(), i, i2, 0);
            }
            if (!GetBoneAnimationFile.exists() || !GetBoneAnimationFile.isFile()) {
                FXUtil.OccurRunTimeException(GetBoneAnimationFile);
            } else {
                aVar.b(GetBoneAnimationFile.getAbsolutePath());
            }
            File file2 = new File(file, GlobalDefine.FILE_NAME_BONE_HIERARCHY);
            if (!file2.exists() || !file2.isFile()) {
                FXUtil.OccurRunTimeException(file2);
            } else {
                aVar.a(file2.getAbsolutePath());
            }
            for (int i5 = 1; i5 <= 16; i5++) {
                File file3 = new File(file, String.format(GlobalDefine.FILE_NAME_FORMAT_BLEND_TARGET, new Object[]{Integer.valueOf(i5)}));
                if (!file3.exists() || !file3.isFile()) {
                    FXUtil.OccurRunTimeException(file3);
                } else {
                    aVar.c(file3.getAbsolutePath());
                }
            }
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    public h b(RealVideoFileInfo realVideoFileInfo) {
        Log.d(this.p, "CreateRealData()+");
        File file = null;
        if (realVideoFileInfo != null) {
            h hVar = new h();
            hVar.a(4);
            if (this.r == 2) {
                if (this.s == 1) {
                    hVar.b(2);
                } else {
                    hVar.b(0);
                }
            } else if (this.s == 1) {
                hVar.b(3);
            } else {
                hVar.b(1);
            }
            File file2 = realVideoFileInfo.mAnimationFilePath != null ? new File(realVideoFileInfo.mAnimationFilePath) : null;
            if (file2 == null || !file2.exists() || !file2.isFile()) {
                Log.e(this.p, "[ERROR] :: animationFile is null");
                FXUtil.OccurRunTimeException(file2);
            } else {
                hVar.a(file2.getAbsolutePath());
            }
            if (realVideoFileInfo.mVideoFilePath != null) {
                file = new File(realVideoFileInfo.mVideoFilePath);
            }
            if (file == null || !file.exists() || !file.isFile()) {
                Log.e(this.p, "[ERROR] :: videoFile is null");
                FXUtil.OccurRunTimeException(file);
            } else {
                hVar.b(file.getAbsolutePath());
            }
            return hVar;
        }
        Log.e(this.p, "[ERROR] :: realVideoFileInfo is null");
        return null;
    }

    private ClothesFileInfo[] a(ClothesFileInfo clothesFileInfo, ClothesFileInfo[] clothesFileInfoArr) {
        boolean z2;
        if (clothesFileInfoArr == null || clothesFileInfoArr.length != 5) {
            return null;
        }
        ClothesFileInfo[] a2 = ClothesFileInfo.b(clothesFileInfoArr);
        if (clothesFileInfo == null || clothesFileInfo.mBaseDirectoryPath == null) {
            z2 = true;
        } else {
            String name = new File(clothesFileInfo.mBaseDirectoryPath).getName();
            boolean z3 = GlobalDefine.GetClothesCategoryType(name) == GlobalDefine.CLOTHES_CATEGORY_TYPE.Swimsuit;
            z2 = GlobalDefine.GetClothesCategoryType(name) == GlobalDefine.CLOTHES_CATEGORY_TYPE.Jumpsuit;
            for (ClothesFileInfo clothesFileInfo2 : a2) {
                if (clothesFileInfo2.mBaseDirectoryPath != null) {
                    if (z3 != (GlobalDefine.GetClothesCategoryType(new File(clothesFileInfo2.mBaseDirectoryPath).getName()) == GlobalDefine.CLOTHES_CATEGORY_TYPE.Swimsuit)) {
                        clothesFileInfo2.mBaseDirectoryPath = null;
                        clothesFileInfo2.mPackageFilePath = null;
                    }
                }
            }
        }
        switch (clothesFileInfo.mClothType) {
            case 0:
                if (!(a2[2].mBaseDirectoryPath == null || GlobalDefine.GetClothesCategoryType(new File(a2[2].mBaseDirectoryPath).getName()) == GlobalDefine.CLOTHES_CATEGORY_TYPE.Jumpsuit)) {
                    a2[2].mBaseDirectoryPath = null;
                    a2[2].mPackageFilePath = null;
                    break;
                }
            case 1:
                a2[2].mBaseDirectoryPath = null;
                a2[2].mPackageFilePath = null;
                break;
            case 2:
                if (!z2) {
                    a2[0].mBaseDirectoryPath = null;
                    a2[0].mPackageFilePath = null;
                }
                a2[1].mBaseDirectoryPath = null;
                a2[1].mPackageFilePath = null;
                break;
            case 3:
                a2[4].mBaseDirectoryPath = null;
                a2[4].mPackageFilePath = null;
                break;
            case 4:
                a2[3].mBaseDirectoryPath = null;
                a2[3].mPackageFilePath = null;
                break;
        }
        return a2;
    }

    /* access modifiers changed from: private */
    public g a(int i, int i2, int i3, float[] fArr, float f, ClothesFileInfo[] clothesFileInfoArr) {
        Log.d(this.p, "GenerateModeData()+");
        g gVar = new g();
        if (i != 0) {
            switch (i) {
                case 2:
                case 7:
                    gVar.a(h.e.AVATAR_BODY_EDITING);
                    break;
                case 3:
                    gVar.a(h.e.AVATAR_HAIR_EDITING);
                    break;
                case 4:
                    gVar.a(h.e.AVATAR_FACE_EDITING);
                    break;
                case 5:
                    gVar.a(h.e.AVATAR_SKIN_TONE_EDITING);
                    break;
                case 6:
                    gVar.a(h.e.AVATAR_CUSTOM_FACE_EDITING);
                    break;
                case 8:
                    gVar.a(h.e.CHECK_CLOTHES_SIZE);
                    break;
                default:
                    gVar.a(h.e.AVATAR);
                    break;
            }
        } else {
            gVar.a(h.e.REAL);
        }
        boolean z2 = false;
        if (i2 == 2) {
            gVar.a(0);
        } else if (i2 == 1) {
            gVar.a(1);
        } else {
            gVar.a(2);
            Log.d(this.p, "gender - GENDER_UNISEX");
        }
        if (i3 == 1) {
            gVar.b(0);
        } else if (i3 == 2) {
            gVar.b(1);
        } else {
            gVar.b(2);
            Log.d(this.p, "gender - AGE_OLD");
        }
        gVar.a(fArr);
        gVar.a(f);
        h.e e = gVar.e();
        if (e == h.e.REAL || e == h.e.AVATAR || e == h.e.CHECK_CLOTHES_SIZE) {
            z2 = true;
        }
        ArrayList<d> a2 = a(clothesFileInfoArr, z2, b(i, i2, i3));
        if (a2 == null) {
            return null;
        }
        gVar.a(a2);
        return gVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.util.ArrayList<net.fxgear.fittingview.data.d>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.util.ArrayList<net.fxgear.fittingview.data.d>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.util.ArrayList<net.fxgear.fittingview.data.d>} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<net.fxgear.fittingview.data.d> a(net.fxgear.FittingView.ClothesFileInfo[] r18, boolean r19, int r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r3 = r20
            java.lang.String r4 = r0.p
            java.lang.String r5 = "GenerateClothDataList()+"
            android.util.Log.d(r4, r5)
            r4 = 0
            if (r1 != 0) goto L_0x0018
            java.lang.String r1 = r0.p
            java.lang.String r2 = "[ERROR] :: clothesFileInfoArray is null"
            android.util.Log.e(r1, r2)
            return r4
        L_0x0018:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            int r6 = r0.r
            r7 = 2
            r8 = 0
            r9 = 1
            if (r6 != r7) goto L_0x002c
            int r6 = r0.s
            if (r6 != r9) goto L_0x002a
            r6 = 2
            goto L_0x0037
        L_0x002a:
            r6 = 0
            goto L_0x0037
        L_0x002c:
            int r6 = r0.r
            if (r6 != r9) goto L_0x0036
            int r6 = r0.s
            if (r6 != r9) goto L_0x0036
            r6 = 3
            goto L_0x0037
        L_0x0036:
            r6 = 1
        L_0x0037:
            r11 = 5
            if (r1 == 0) goto L_0x02b5
            int r12 = r1.length
            if (r12 != r11) goto L_0x02b5
            r12 = 0
        L_0x003e:
            int r13 = r1.length
            if (r12 >= r13) goto L_0x02b3
            r13 = r1[r12]
            if (r13 == 0) goto L_0x0283
            java.lang.String r14 = r13.mBaseDirectoryPath
            if (r14 == 0) goto L_0x0268
            java.lang.String r14 = r13.mPackageFilePath
            if (r14 != 0) goto L_0x004f
            goto L_0x0268
        L_0x004f:
            int r14 = r13.mClothType
            if (r12 != r14) goto L_0x0235
            net.fxgear.fittingview.data.d r14 = new net.fxgear.fittingview.data.d
            r14.<init>()
            r14.b((int) r12)
            if (r19 == 0) goto L_0x005f
            r15 = -1
            goto L_0x0060
        L_0x005f:
            r15 = 1
        L_0x0060:
            r14.c((int) r15)
            r14.a((int) r3)
            net.fxgear.GlobalDefine$ClothesSize[] r15 = r0.B
            r15 = r15[r12]
            int r15 = r15.ordinal()
            r14.e((int) r15)
            java.io.File r15 = new java.io.File
            java.lang.String r10 = r13.mBaseDirectoryPath
            r15.<init>(r10)
            java.lang.String r10 = r15.getName()
            r14.a((java.lang.String) r10)
            if (r19 == 0) goto L_0x0233
            boolean r16 = r15.exists()
            if (r16 != 0) goto L_0x00a2
            java.lang.String r1 = r0.p
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[ERROR] :: wrong baseDirectory path : "
            r2.append(r3)
            java.lang.String r3 = r15.getAbsolutePath()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2)
            return r4
        L_0x00a2:
            java.lang.String r11 = r13.mPackageFilePath
            if (r11 != 0) goto L_0x00b2
            java.lang.String r11 = r0.p
            java.lang.String r4 = "ERROR :: Not found package file."
            android.util.Log.e(r11, r4)
            r14.c((int) r9)
            r4 = 0
            goto L_0x00b9
        L_0x00b2:
            java.io.File r4 = new java.io.File
            java.lang.String r11 = r13.mPackageFilePath
            r4.<init>(r11)
        L_0x00b9:
            int r11 = r14.d()
            if (r11 == r9) goto L_0x0230
            boolean r11 = r4.exists()
            if (r11 == 0) goto L_0x0216
            boolean r4 = r4.isFile()
            if (r4 == 0) goto L_0x0216
            java.lang.String r4 = r13.mPackageFilePath
            r14.b((java.lang.String) r4)
            r4 = 1
        L_0x00d1:
            r11 = 26
            if (r4 > r11) goto L_0x0129
            java.lang.String r11 = "Cloth%s_Tar%s.bin"
            java.lang.Object[] r13 = new java.lang.Object[r7]
            java.lang.String r16 = net.fxgear.GlobalDefine.GetClothTargetName(r10)
            r13[r8] = r16
            java.lang.String r7 = "%03d"
            java.lang.Object[] r1 = new java.lang.Object[r9]
            java.lang.Integer r16 = java.lang.Integer.valueOf(r4)
            r1[r8] = r16
            java.lang.String r1 = java.lang.String.format(r7, r1)
            r13[r9] = r1
            java.lang.String r1 = java.lang.String.format(r11, r13)
            java.io.File r7 = new java.io.File
            r7.<init>(r15, r1)
            java.lang.String r1 = r7.getAbsolutePath()
            boolean r11 = r7.exists()
            if (r11 == 0) goto L_0x0111
            boolean r7 = r7.isFile()
            if (r7 == 0) goto L_0x0111
            r14.d((java.lang.String) r1)
            int r4 = r4 + 1
            r1 = r18
            r7 = 2
            goto L_0x00d1
        L_0x0111:
            java.lang.String r2 = r0.p
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "[ERROR] :: wrong blendTargetFile path : "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            android.util.Log.e(r2, r1)
            r1 = 0
            return r1
        L_0x0129:
            java.lang.String r1 = "Cloth%s_Tar%s.bin"
            r4 = 2
            java.lang.Object[] r7 = new java.lang.Object[r4]
            java.lang.String r4 = net.fxgear.GlobalDefine.GetClothTargetName(r10)
            r7[r8] = r4
            java.lang.String r4 = "%03d"
            java.lang.Object[] r11 = new java.lang.Object[r9]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r8)
            r11[r8] = r13
            java.lang.String r4 = java.lang.String.format(r4, r11)
            r7[r9] = r4
            java.lang.String r1 = java.lang.String.format(r1, r7)
            java.io.File r4 = new java.io.File
            r4.<init>(r15, r1)
            java.lang.String r1 = r4.getAbsolutePath()
            boolean r7 = r4.exists()
            if (r7 == 0) goto L_0x0176
            boolean r4 = r4.isFile()
            if (r4 == 0) goto L_0x0176
            r14.d((java.lang.String) r1)
            java.lang.String r4 = r0.p
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r11 = "Adding Tar000 of "
            r7.append(r11)
            r7.append(r1)
            java.lang.String r1 = r7.toString()
            android.util.Log.i(r4, r1)
        L_0x0176:
            java.io.File r1 = new java.io.File
            java.lang.String r4 = "Cloth%s_Base.bin"
            java.lang.Object[] r7 = new java.lang.Object[r9]
            java.lang.String r11 = net.fxgear.GlobalDefine.GetClothTargetName(r10)
            r7[r8] = r11
            java.lang.String r4 = java.lang.String.format(r4, r7)
            r1.<init>(r15, r4)
            java.lang.String r4 = r1.getAbsolutePath()
            boolean r7 = r1.exists()
            if (r7 == 0) goto L_0x01fe
            boolean r1 = r1.isFile()
            if (r1 == 0) goto L_0x01fe
            r14.c((java.lang.String) r4)
            net.fxgear.GlobalDefine$CLOTHES_CATEGORY_TYPE r1 = net.fxgear.GlobalDefine.GetClothesCategoryType(r10)
            r14.a((net.fxgear.GlobalDefine.CLOTHES_CATEGORY_TYPE) r1)
            net.fxgear.GlobalDefine$CLOTHES_CATEGORY_TYPE r4 = net.fxgear.GlobalDefine.CLOTHES_CATEGORY_TYPE.TuckIn
            if (r1 != r4) goto L_0x0230
            r1 = 1
        L_0x01a8:
            r4 = 8
            if (r1 > r4) goto L_0x0230
            java.lang.String r4 = "Cloth%s_Tuckin_Tar%s.bin"
            r7 = 2
            java.lang.Object[] r11 = new java.lang.Object[r7]
            java.lang.String r13 = net.fxgear.GlobalDefine.GetClothTargetName(r10)
            r11[r8] = r13
            java.lang.String r13 = "%03d"
            java.lang.Object[] r7 = new java.lang.Object[r9]
            java.lang.Integer r16 = java.lang.Integer.valueOf(r1)
            r7[r8] = r16
            java.lang.String r7 = java.lang.String.format(r13, r7)
            r11[r9] = r7
            java.lang.String r4 = java.lang.String.format(r4, r11)
            java.io.File r7 = new java.io.File
            r7.<init>(r15, r4)
            java.lang.String r4 = r7.getAbsolutePath()
            boolean r11 = r7.exists()
            if (r11 == 0) goto L_0x01e6
            boolean r7 = r7.isFile()
            if (r7 == 0) goto L_0x01e6
            r14.g(r4)
            int r1 = r1 + 1
            goto L_0x01a8
        L_0x01e6:
            java.lang.String r1 = r0.p
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[ERROR] :: wrong tuckinTargetFile path : "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2)
            r1 = 0
            return r1
        L_0x01fe:
            java.lang.String r1 = r0.p
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[ERROR] :: wrong baseMeshFile path : "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2)
            r1 = 0
            return r1
        L_0x0216:
            java.lang.String r1 = r0.p
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[ERROR] :: wrong packageFile path : "
            r2.append(r3)
            java.lang.String r3 = r13.mPackageFilePath
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2)
            r1 = 0
            return r1
        L_0x0230:
            r1 = 0
            goto L_0x02a4
        L_0x0233:
            r1 = r4
            goto L_0x02a4
        L_0x0235:
            r1 = r4
            java.lang.String r4 = r0.p
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r10 = "ERROR :: wrong clothType = "
            r7.append(r10)
            int r10 = r13.mClothType
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            android.util.Log.e(r4, r7)
            net.fxgear.fittingview.data.d r14 = new net.fxgear.fittingview.data.d
            r14.<init>()
            r14.b((int) r12)
            r14.c((int) r9)
            r14.a((int) r3)
            net.fxgear.GlobalDefine$ClothesSize[] r4 = r0.B
            r4 = r4[r12]
            int r4 = r4.ordinal()
            r14.e((int) r4)
            goto L_0x02a4
        L_0x0268:
            r1 = r4
            net.fxgear.fittingview.data.d r14 = new net.fxgear.fittingview.data.d
            r14.<init>()
            r14.b((int) r12)
            r14.c((int) r9)
            r14.a((int) r3)
            net.fxgear.GlobalDefine$ClothesSize[] r4 = r0.B
            r4 = r4[r12]
            int r4 = r4.ordinal()
            r14.e((int) r4)
            goto L_0x02a4
        L_0x0283:
            r1 = r4
            java.lang.String r4 = r0.p
            java.lang.String r7 = "ERROR :: clothesFileInfo is null"
            android.util.Log.e(r4, r7)
            net.fxgear.fittingview.data.d r14 = new net.fxgear.fittingview.data.d
            r14.<init>()
            r14.b((int) r12)
            r14.c((int) r9)
            r14.a((int) r3)
            net.fxgear.GlobalDefine$ClothesSize[] r4 = r0.B
            r4 = r4[r12]
            int r4 = r4.ordinal()
            r14.e((int) r4)
        L_0x02a4:
            r14.d((int) r6)
            r5.add(r14)
            int r12 = r12 + 1
            r4 = r1
            r1 = r18
            r7 = 2
            r11 = 5
            goto L_0x003e
        L_0x02b3:
            r1 = r4
            goto L_0x02e2
        L_0x02b5:
            r1 = r4
            java.lang.String r2 = r0.p
            java.lang.String r4 = "WARNING :: param error."
            android.util.Log.e(r2, r4)
        L_0x02bd:
            r2 = 5
            if (r8 >= r2) goto L_0x02e2
            net.fxgear.fittingview.data.d r2 = new net.fxgear.fittingview.data.d
            r2.<init>()
            r2.b((int) r8)
            r2.c((int) r9)
            r2.a((int) r3)
            r2.d((int) r6)
            net.fxgear.GlobalDefine$ClothesSize[] r4 = r0.B
            r4 = r4[r8]
            int r4 = r4.ordinal()
            r2.e((int) r4)
            r5.add(r2)
            int r8 = r8 + 1
            goto L_0x02bd
        L_0x02e2:
            android.content.Context r2 = r17.getContext()
            int r4 = r0.r
            int r7 = r0.s
            r8 = 5
            java.io.File r2 = net.fxgear.GlobalDefine.GetClothTypeDirectory(r2, r4, r7, r8)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = r2.getAbsolutePath()
            r4.append(r7)
            java.lang.String r7 = java.io.File.separator
            r4.append(r7)
            java.lang.String r7 = "Mesh.bin"
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r2 = r2.getAbsolutePath()
            r7.append(r2)
            java.lang.String r2 = java.io.File.separator
            r7.append(r2)
            java.lang.String r2 = "Texture.png"
            r7.append(r2)
            java.lang.String r2 = r7.toString()
            java.io.File r7 = new java.io.File
            r7.<init>(r4)
            boolean r8 = r7.exists()
            if (r8 == 0) goto L_0x0334
            boolean r7 = r7.isFile()
            if (r7 != 0) goto L_0x0335
        L_0x0334:
            r4 = r1
        L_0x0335:
            java.io.File r7 = new java.io.File
            r7.<init>(r2)
            boolean r8 = r7.exists()
            if (r8 == 0) goto L_0x0348
            boolean r7 = r7.isFile()
            if (r7 != 0) goto L_0x0347
            goto L_0x0348
        L_0x0347:
            r1 = r2
        L_0x0348:
            if (r4 == 0) goto L_0x0368
            if (r1 == 0) goto L_0x0368
            net.fxgear.fittingview.data.d r2 = new net.fxgear.fittingview.data.d
            r2.<init>()
            r7 = 5
            r2.b((int) r7)
            r7 = -1
            r2.c((int) r7)
            r2.a((int) r3)
            r2.e((java.lang.String) r4)
            r2.f(r1)
            r2.d((int) r6)
            r5.add(r2)
        L_0x0368:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.a(net.fxgear.FittingView$ClothesFileInfo[], boolean, int):java.util.ArrayList");
    }

    /* access modifiers changed from: private */
    public int a(ArrayList<d> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return 0;
        }
        Iterator<d> it = arrayList.iterator();
        while (it.hasNext()) {
            String a2 = it.next().a();
            if (a2 != null && a2.equals(GlobalDefine.BASE_CATEGORY_NAME_WEDDING)) {
                return 1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        r3 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int b(java.util.ArrayList<net.fxgear.fittingview.data.d> r8) {
        /*
            r7 = this;
            int r0 = r7.q
            r1 = 0
            r2 = 8
            if (r0 != r2) goto L_0x0008
            return r1
        L_0x0008:
            r0 = 1
            if (r8 == 0) goto L_0x004f
            boolean r2 = r8.isEmpty()
            if (r2 != 0) goto L_0x004f
            java.util.Iterator r8 = r8.iterator()
            r2 = 0
            r3 = 0
        L_0x0017:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L_0x0044
            java.lang.Object r4 = r8.next()
            net.fxgear.fittingview.data.d r4 = (net.fxgear.fittingview.data.d) r4
            int r5 = r4.c()
            r6 = -1
            switch(r5) {
                case 0: goto L_0x003c;
                case 1: goto L_0x0034;
                case 2: goto L_0x002c;
                default: goto L_0x002b;
            }
        L_0x002b:
            goto L_0x0017
        L_0x002c:
            int r4 = r4.d()
            if (r4 != r6) goto L_0x0017
            r2 = 1
            goto L_0x003a
        L_0x0034:
            int r4 = r4.d()
            if (r4 != r6) goto L_0x0017
        L_0x003a:
            r3 = 1
            goto L_0x0017
        L_0x003c:
            int r4 = r4.d()
            if (r4 != r6) goto L_0x0017
            r2 = 1
            goto L_0x0017
        L_0x0044:
            if (r2 == 0) goto L_0x004c
            if (r3 == 0) goto L_0x004a
            r1 = 3
            goto L_0x004f
        L_0x004a:
            r1 = 1
            goto L_0x004f
        L_0x004c:
            if (r3 == 0) goto L_0x004f
            r1 = 2
        L_0x004f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.b(java.util.ArrayList):int");
    }

    private boolean a() {
        File GetAvatarRuntimeDirectory = GlobalDefine.GetAvatarRuntimeDirectory(getContext());
        if (!GetAvatarRuntimeDirectory.exists() || !GetAvatarRuntimeDirectory.isDirectory()) {
            Log.w(this.p, "[WARNING] :: Not found avatar runtime directory.");
        } else {
            String[] GetCustomFaceFile = FittingFaceData.GetCustomFaceFile(GetAvatarRuntimeDirectory.getAbsolutePath());
            if (GetCustomFaceFile == null || GetCustomFaceFile.length <= 0) {
                Log.w(this.p, "[WARNING] :: Not found custom face files.");
            } else {
                String str = GetCustomFaceFile[3];
                if (str != null) {
                    File file = new File(str);
                    if (!file.exists() || !file.isFile()) {
                        Log.e(this.p, "[ERROR] :: Not found custom texture file.");
                        return false;
                    }
                    int GetHeadTypeCount = AvatarSetting.GetHeadTypeCount(getContext(), this.r, this.s);
                    int i = 0;
                    while (i < GetHeadTypeCount) {
                        int i2 = AvatarSetting.GetHeadTypeInfoByIndex(getContext(), i, this.r, this.s).mTypeID;
                        File a2 = a(GetCustomFaceFile, i2);
                        if (a2 == null) {
                            String str2 = this.p;
                            Log.e(str2, "[ERROR] :: Custom mesh file path is null.(type : " + i2 + ")");
                            return false;
                        } else if (!a2.exists() || !a2.isFile()) {
                            String str3 = this.p;
                            Log.e(str3, "[ERROR] :: Not found custom mesh file.(type : " + i2 + ")");
                            return false;
                        } else {
                            i++;
                        }
                    }
                    return true;
                }
                Log.e(this.p, "[ERROR] :: Custom texture file path is null.");
                return false;
            }
        }
        return false;
    }

    public int GetCurrentMode() {
        return this.q;
    }

    public int GetCurrentGender() {
        return this.r;
    }

    public int GetCurrentAge() {
        return this.s;
    }

    public RealVideoFileInfo GetCurrentRealVideoFileInfo() {
        return this.v;
    }

    public int GetCurrentAvatarID() {
        return this.w;
    }

    public int GetCurrentHeadTypeIndex() {
        return this.t;
    }

    public int GetCurrentHairTypeIndex() {
        return this.u;
    }

    public Bitmap GetScreenShotImage() {
        if (this.E == null || this.E.isRecycled()) {
            return null;
        }
        return this.E;
    }

    public boolean IsWorkingRenderer() {
        if (this.D != null) {
            return this.D.a();
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean SetMode(int r4, final net.fxgear.FittingView.OnFittingViewListener r5, final java.lang.Runnable r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = r3.p     // Catch:{ all -> 0x0051 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
            r1.<init>()     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = "SetMode()+, mode : "
            r1.append(r2)     // Catch:{ all -> 0x0051 }
            r1.append(r4)     // Catch:{ all -> 0x0051 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0051 }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0051 }
            int r0 = r3.q     // Catch:{ all -> 0x0051 }
            r1 = 0
            if (r0 == r4) goto L_0x004f
            net.fxgear.a r0 = r3.D     // Catch:{ all -> 0x0051 }
            if (r0 == 0) goto L_0x0048
            net.fxgear.a r0 = r3.D     // Catch:{ all -> 0x0051 }
            boolean r0 = r0.a()     // Catch:{ all -> 0x0051 }
            if (r0 != 0) goto L_0x0048
            if (r5 == 0) goto L_0x002d
            r5.OnStartAsyncWork()     // Catch:{ all -> 0x0051 }
        L_0x002d:
            r3.q = r4     // Catch:{ all -> 0x0051 }
            net.fxgear.GlobalDefine$Result r4 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x0051 }
            r4.<init>()     // Catch:{ all -> 0x0051 }
            r4.resultCode = r1     // Catch:{ all -> 0x0051 }
            net.fxgear.a r0 = r3.D     // Catch:{ all -> 0x0051 }
            net.fxgear.FittingView$42 r1 = new net.fxgear.FittingView$42     // Catch:{ all -> 0x0051 }
            r1.<init>(r4)     // Catch:{ all -> 0x0051 }
            net.fxgear.FittingView$43 r2 = new net.fxgear.FittingView$43     // Catch:{ all -> 0x0051 }
            r2.<init>(r5, r4, r6)     // Catch:{ all -> 0x0051 }
            r0.a((java.lang.Runnable) r1, (net.fxgear.a.C0022a) r2)     // Catch:{ all -> 0x0051 }
            r4 = 1
            monitor-exit(r3)
            return r4
        L_0x0048:
            java.lang.String r4 = r3.p     // Catch:{ all -> 0x0051 }
            java.lang.String r5 = "fittingView working."
            android.util.Log.d(r4, r5)     // Catch:{ all -> 0x0051 }
        L_0x004f:
            monitor-exit(r3)
            return r1
        L_0x0051:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.SetMode(int, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    public synchronized boolean SetCharacter(int i, int i2, int i3, int i4, int i5, boolean z2, ClothesFileInfo[] clothesFileInfoArr, BodySizeData bodySizeData, int i6, float f, OnFittingViewListener onFittingViewListener, Runnable runnable) {
        ClothesFileInfo[] clothesFileInfoArr2;
        Log.d(this.p, "SetCharacter()+");
        if (this.q == 0) {
            Log.e(this.p, "[ERROR] :: Illegal state. call another SetCharacter method with parameter RealVideoFileInfo for real mode");
            return false;
        } else if (this.D == null || this.D.a()) {
            Log.d(this.p, "fittingView working.");
            return false;
        } else {
            if (onFittingViewListener != null) {
                onFittingViewListener.OnStartAsyncWork();
            }
            final boolean z3 = this.w != i5;
            this.s = i2;
            this.r = i;
            this.t = i3;
            this.u = i4;
            this.w = i5;
            this.x = z2;
            this.y = f;
            this.z = FittingSurfaceView.colorTemperatureToNormalizeValue(new float[]{(float) FXUtil.redFromColor(i6), (float) FXUtil.greenFromColor(i6), (float) FXUtil.blueFromColor(i6)});
            a(this.r, this.s, bodySizeData);
            if (clothesFileInfoArr == null || clothesFileInfoArr.length != this.A.length) {
                clothesFileInfoArr2 = ClothesFileInfo.b(EMPTY_CLOTHES);
            } else {
                clothesFileInfoArr2 = ClothesFileInfo.b(clothesFileInfoArr);
            }
            final ClothesFileInfo[] clothesFileInfoArr3 = clothesFileInfoArr2;
            for (int i7 = 0; i7 < this.B.length; i7++) {
                this.B[i7] = ClothesSizeProvider.GetClosestClothSize(this.r, this.s, i7, false);
            }
            final GlobalDefine.Result result = new GlobalDefine.Result();
            result.resultCode = 0;
            final OnFittingViewListener onFittingViewListener2 = onFittingViewListener;
            final Runnable runnable2 = runnable;
            this.D.a((Runnable) new Runnable() {
                public void run() {
                    try {
                        AvatarSetting unused = FittingView.this.C;
                        float[] a2 = AvatarSetting.a();
                        float GetAvatarHeighWithoutHeadSize = (float) FittingView.this.C.GetAvatarHeighWithoutHeadSize();
                        int unused2 = FittingView.this.b(FittingView.this.q, FittingView.this.r, FittingView.this.s);
                        g a3 = FittingView.this.a(FittingView.this.q, FittingView.this.r, FittingView.this.s, a2, GetAvatarHeighWithoutHeadSize, clothesFileInfoArr3);
                        if (a3 == null) {
                            result.resultCode = 3;
                            return;
                        }
                        ClothesFileInfo[] unused3 = FittingView.this.A = clothesFileInfoArr3;
                        FittingView.this.SetModeData((net.fxgear.fittingview.data.h) null, FittingView.this.a(FittingView.this.r, FittingView.this.s, FittingView.this.b(a3.c()), FittingView.this.t, FittingView.this.u), FittingView.this.a(FittingView.this.r, FittingView.this.s, FittingView.this.a(a3.c())), a3, (FittingFaceData) null, z3);
                        result.resultCode = -1;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        result.resultCode = -3;
                        result.resultExtra = th;
                    }
                }
            }, (a.C0022a) new a.C0022a() {
                public void a() {
                    if (onFittingViewListener2 == null) {
                        return;
                    }
                    if (result.resultCode == -1) {
                        onFittingViewListener2.OnFinishAsyncWork(runnable2);
                        onFittingViewListener2.OnClothChange(clothesFileInfoArr3);
                        return;
                    }
                    onFittingViewListener2.OnOccurError(result);
                }
            });
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0096 A[LOOP:0: B:29:0x0091->B:31:0x0096, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean SetCharacter(int r10, int r11, int r12, int r13, net.fxgear.FittingView.RealVideoFileInfo r14, int r15, boolean r16, net.fxgear.FittingView.ClothesFileInfo[] r17, net.fxgear.BodySizeData r18, int r19, float r20, net.fxgear.FittingView.OnFittingViewListener r21, java.lang.Runnable r22) {
        /*
            r9 = this;
            r1 = r9
            r0 = r14
            r2 = r15
            r3 = r17
            monitor-enter(r9)
            java.lang.String r4 = r1.p     // Catch:{ all -> 0x00ce }
            java.lang.String r5 = "SetCharacter()+"
            android.util.Log.d(r4, r5)     // Catch:{ all -> 0x00ce }
            boolean r4 = r9.a((net.fxgear.FittingView.RealVideoFileInfo) r14)     // Catch:{ all -> 0x00ce }
            r5 = 0
            if (r4 != 0) goto L_0x0016
            monitor-exit(r9)
            return r5
        L_0x0016:
            net.fxgear.a r4 = r1.D     // Catch:{ all -> 0x00ce }
            if (r4 == 0) goto L_0x00c5
            net.fxgear.a r4 = r1.D     // Catch:{ all -> 0x00ce }
            boolean r4 = r4.a()     // Catch:{ all -> 0x00ce }
            if (r4 != 0) goto L_0x00c5
            if (r21 == 0) goto L_0x0027
            r21.OnStartAsyncWork()     // Catch:{ all -> 0x00ce }
        L_0x0027:
            int r6 = r1.w     // Catch:{ all -> 0x00ce }
            r7 = 1
            if (r6 != r2) goto L_0x0038
            net.fxgear.FittingView$RealVideoFileInfo r6 = r1.v     // Catch:{ all -> 0x00ce }
            boolean r6 = r6.equals(r14)     // Catch:{ all -> 0x00ce }
            if (r6 != 0) goto L_0x0035
            goto L_0x0038
        L_0x0035:
            r6 = r11
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r6 = r11
            r8 = 1
        L_0x003a:
            r1.s = r6     // Catch:{ all -> 0x00ce }
            r6 = r10
            r1.r = r6     // Catch:{ all -> 0x00ce }
            r6 = r12
            r1.t = r6     // Catch:{ all -> 0x00ce }
            r6 = r13
            r1.u = r6     // Catch:{ all -> 0x00ce }
            net.fxgear.FittingView$RealVideoFileInfo r0 = r14.a()     // Catch:{ all -> 0x00ce }
            r1.v = r0     // Catch:{ all -> 0x00ce }
            r1.w = r2     // Catch:{ all -> 0x00ce }
            r0 = r16
            r1.x = r0     // Catch:{ all -> 0x00ce }
            r0 = r20
            r1.y = r0     // Catch:{ all -> 0x00ce }
            r0 = 3
            float[] r0 = new float[r0]     // Catch:{ all -> 0x00ce }
            int r2 = net.fxgear.util.FXUtil.redFromColor(r19)     // Catch:{ all -> 0x00ce }
            float r2 = (float) r2     // Catch:{ all -> 0x00ce }
            r0[r5] = r2     // Catch:{ all -> 0x00ce }
            int r2 = net.fxgear.util.FXUtil.greenFromColor(r19)     // Catch:{ all -> 0x00ce }
            float r2 = (float) r2     // Catch:{ all -> 0x00ce }
            r0[r7] = r2     // Catch:{ all -> 0x00ce }
            r2 = 2
            int r6 = net.fxgear.util.FXUtil.blueFromColor(r19)     // Catch:{ all -> 0x00ce }
            float r6 = (float) r6     // Catch:{ all -> 0x00ce }
            r0[r2] = r6     // Catch:{ all -> 0x00ce }
            float r0 = net.fxgear.fittingview.FittingSurfaceView.colorTemperatureToNormalizeValue(r0)     // Catch:{ all -> 0x00ce }
            r1.z = r0     // Catch:{ all -> 0x00ce }
            int r0 = r1.r     // Catch:{ all -> 0x00ce }
            int r2 = r1.s     // Catch:{ all -> 0x00ce }
            r6 = r18
            r9.a((int) r0, (int) r2, (net.fxgear.BodySizeData) r6)     // Catch:{ all -> 0x00ce }
            if (r3 == 0) goto L_0x008a
            int r0 = r3.length     // Catch:{ all -> 0x00ce }
            net.fxgear.FittingView$ClothesFileInfo[] r2 = r1.A     // Catch:{ all -> 0x00ce }
            int r2 = r2.length     // Catch:{ all -> 0x00ce }
            if (r0 != r2) goto L_0x008a
            net.fxgear.FittingView$ClothesFileInfo[] r0 = net.fxgear.FittingView.ClothesFileInfo.b(r17)     // Catch:{ all -> 0x00ce }
            goto L_0x0090
        L_0x008a:
            net.fxgear.FittingView$ClothesFileInfo[] r0 = EMPTY_CLOTHES     // Catch:{ all -> 0x00ce }
            net.fxgear.FittingView$ClothesFileInfo[] r0 = net.fxgear.FittingView.ClothesFileInfo.b(r0)     // Catch:{ all -> 0x00ce }
        L_0x0090:
            r2 = 0
        L_0x0091:
            net.fxgear.GlobalDefine$ClothesSize[] r3 = r1.B     // Catch:{ all -> 0x00ce }
            int r3 = r3.length     // Catch:{ all -> 0x00ce }
            if (r2 >= r3) goto L_0x00a5
            int r3 = r1.r     // Catch:{ all -> 0x00ce }
            int r6 = r1.s     // Catch:{ all -> 0x00ce }
            net.fxgear.GlobalDefine$ClothesSize r3 = net.fxgear.ClothesSizeProvider.GetClosestClothSize((int) r3, (int) r6, (int) r2, (boolean) r5)     // Catch:{ all -> 0x00ce }
            net.fxgear.GlobalDefine$ClothesSize[] r6 = r1.B     // Catch:{ all -> 0x00ce }
            r6[r2] = r3     // Catch:{ all -> 0x00ce }
            int r2 = r2 + 1
            goto L_0x0091
        L_0x00a5:
            net.fxgear.GlobalDefine$Result r2 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x00ce }
            r2.<init>()     // Catch:{ all -> 0x00ce }
            r2.resultCode = r5     // Catch:{ all -> 0x00ce }
            net.fxgear.a r3 = r1.D     // Catch:{ all -> 0x00ce }
            net.fxgear.FittingView$46 r5 = new net.fxgear.FittingView$46     // Catch:{ all -> 0x00ce }
            r5.<init>(r0, r2, r8)     // Catch:{ all -> 0x00ce }
            net.fxgear.FittingView$2 r6 = new net.fxgear.FittingView$2     // Catch:{ all -> 0x00ce }
            r10 = r6
            r11 = r9
            r12 = r21
            r13 = r2
            r14 = r22
            r15 = r0
            r10.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x00ce }
            r3.a((java.lang.Runnable) r5, (net.fxgear.a.C0022a) r6)     // Catch:{ all -> 0x00ce }
            monitor-exit(r9)
            return r7
        L_0x00c5:
            java.lang.String r0 = r1.p     // Catch:{ all -> 0x00ce }
            java.lang.String r2 = "fittingView working."
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x00ce }
            monitor-exit(r9)
            return r5
        L_0x00ce:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.SetCharacter(int, int, int, int, net.fxgear.FittingView$RealVideoFileInfo, int, boolean, net.fxgear.FittingView$ClothesFileInfo[], net.fxgear.BodySizeData, int, float, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    public synchronized boolean SetModeAndCharacter(int i, int i2, int i3, int i4, int i5, int i6, boolean z2, ClothesFileInfo[] clothesFileInfoArr, BodySizeData bodySizeData, int i7, float f, OnFittingViewListener onFittingViewListener, Runnable runnable) {
        final ClothesFileInfo[] clothesFileInfoArr2;
        int i8 = i;
        int i9 = i6;
        ClothesFileInfo[] clothesFileInfoArr3 = clothesFileInfoArr;
        synchronized (this) {
            Log.d(this.p, "SetModeAndCharacter()+");
            if (i8 == 0) {
                Log.e(this.p, "[ERROR] :: Illegal state. call another SetModeAndCharacter method with parameter RealVideoFileInfo for real mode");
                return false;
            } else if (this.D == null || this.D.a()) {
                Log.d(this.p, "fittingView working.");
                return false;
            } else {
                if (onFittingViewListener != null) {
                    onFittingViewListener.OnStartAsyncWork();
                }
                final boolean z3 = this.w != i9;
                this.q = i8;
                this.s = i3;
                this.r = i2;
                this.t = i4;
                this.u = i5;
                this.w = i9;
                this.x = z2;
                this.y = f;
                this.z = FittingSurfaceView.colorTemperatureToNormalizeValue(new float[]{(float) FXUtil.redFromColor(i7), (float) FXUtil.greenFromColor(i7), (float) FXUtil.blueFromColor(i7)});
                a(this.r, this.s, bodySizeData);
                if (clothesFileInfoArr3 == null || clothesFileInfoArr3.length != this.A.length) {
                    clothesFileInfoArr2 = ClothesFileInfo.b(EMPTY_CLOTHES);
                } else {
                    clothesFileInfoArr2 = ClothesFileInfo.b(clothesFileInfoArr);
                }
                final GlobalDefine.Result result = new GlobalDefine.Result();
                result.resultCode = 0;
                final OnFittingViewListener onFittingViewListener2 = onFittingViewListener;
                final GlobalDefine.Result result2 = result;
                final Runnable runnable2 = runnable;
                final ClothesFileInfo[] clothesFileInfoArr4 = clothesFileInfoArr2;
                this.D.a((Runnable) new Runnable() {
                    public void run() {
                        try {
                            AvatarSetting unused = FittingView.this.C;
                            float[] a2 = AvatarSetting.a();
                            float GetAvatarHeighWithoutHeadSize = (float) FittingView.this.C.GetAvatarHeighWithoutHeadSize();
                            int unused2 = FittingView.this.b(FittingView.this.q, FittingView.this.r, FittingView.this.s);
                            g a3 = FittingView.this.a(FittingView.this.q, FittingView.this.r, FittingView.this.s, a2, GetAvatarHeighWithoutHeadSize, clothesFileInfoArr2);
                            if (a3 == null) {
                                result.resultCode = 3;
                                return;
                            }
                            ClothesFileInfo[] unused3 = FittingView.this.A = clothesFileInfoArr2;
                            FittingView.this.SetModeData((net.fxgear.fittingview.data.h) null, FittingView.this.a(FittingView.this.r, FittingView.this.s, FittingView.this.b(a3.c()), FittingView.this.t, FittingView.this.u), FittingView.this.a(FittingView.this.r, FittingView.this.s, FittingView.this.a(a3.c())), a3, (FittingFaceData) null, z3);
                            result.resultCode = -1;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            result.resultCode = -3;
                            result.resultExtra = th;
                        }
                    }
                }, (a.C0022a) new a.C0022a() {
                    public void a() {
                        if (onFittingViewListener2 == null) {
                            return;
                        }
                        if (result2.resultCode == -1) {
                            onFittingViewListener2.OnFinishAsyncWork(runnable2);
                            onFittingViewListener2.OnClothChange(clothesFileInfoArr4);
                            return;
                        }
                        onFittingViewListener2.OnOccurError(result2);
                    }
                });
                return true;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean SetModeAndCharacter(int r10, int r11, int r12, int r13, int r14, net.fxgear.FittingView.RealVideoFileInfo r15, int r16, boolean r17, net.fxgear.FittingView.ClothesFileInfo[] r18, net.fxgear.BodySizeData r19, int r20, float r21, net.fxgear.FittingView.OnFittingViewListener r22, java.lang.Runnable r23) {
        /*
            r9 = this;
            r1 = r9
            r0 = r15
            r2 = r16
            r3 = r18
            monitor-enter(r9)
            java.lang.String r4 = r1.p     // Catch:{ all -> 0x00c4 }
            java.lang.String r5 = "SetModeAndCharacter()+"
            android.util.Log.d(r4, r5)     // Catch:{ all -> 0x00c4 }
            boolean r4 = r9.a((net.fxgear.FittingView.RealVideoFileInfo) r15)     // Catch:{ all -> 0x00c4 }
            r5 = 0
            if (r4 != 0) goto L_0x001e
            java.lang.String r0 = r1.p     // Catch:{ all -> 0x00c4 }
            java.lang.String r2 = "Unknown real data ID."
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x00c4 }
            monitor-exit(r9)
            return r5
        L_0x001e:
            net.fxgear.a r4 = r1.D     // Catch:{ all -> 0x00c4 }
            if (r4 == 0) goto L_0x00bb
            net.fxgear.a r4 = r1.D     // Catch:{ all -> 0x00c4 }
            boolean r4 = r4.a()     // Catch:{ all -> 0x00c4 }
            if (r4 != 0) goto L_0x00bb
            if (r22 == 0) goto L_0x002f
            r22.OnStartAsyncWork()     // Catch:{ all -> 0x00c4 }
        L_0x002f:
            int r6 = r1.w     // Catch:{ all -> 0x00c4 }
            r7 = 1
            if (r6 != r2) goto L_0x0040
            net.fxgear.FittingView$RealVideoFileInfo r6 = r1.v     // Catch:{ all -> 0x00c4 }
            boolean r6 = r6.equals(r15)     // Catch:{ all -> 0x00c4 }
            if (r6 != 0) goto L_0x003d
            goto L_0x0040
        L_0x003d:
            r6 = r10
            r8 = 0
            goto L_0x0042
        L_0x0040:
            r6 = r10
            r8 = 1
        L_0x0042:
            r1.q = r6     // Catch:{ all -> 0x00c4 }
            r6 = r12
            r1.s = r6     // Catch:{ all -> 0x00c4 }
            r6 = r11
            r1.r = r6     // Catch:{ all -> 0x00c4 }
            r6 = r13
            r1.t = r6     // Catch:{ all -> 0x00c4 }
            r6 = r14
            r1.u = r6     // Catch:{ all -> 0x00c4 }
            net.fxgear.FittingView$RealVideoFileInfo r0 = r15.a()     // Catch:{ all -> 0x00c4 }
            r1.v = r0     // Catch:{ all -> 0x00c4 }
            r1.w = r2     // Catch:{ all -> 0x00c4 }
            r0 = r17
            r1.x = r0     // Catch:{ all -> 0x00c4 }
            r0 = r21
            r1.y = r0     // Catch:{ all -> 0x00c4 }
            r0 = 3
            float[] r0 = new float[r0]     // Catch:{ all -> 0x00c4 }
            int r2 = net.fxgear.util.FXUtil.redFromColor(r20)     // Catch:{ all -> 0x00c4 }
            float r2 = (float) r2     // Catch:{ all -> 0x00c4 }
            r0[r5] = r2     // Catch:{ all -> 0x00c4 }
            int r2 = net.fxgear.util.FXUtil.greenFromColor(r20)     // Catch:{ all -> 0x00c4 }
            float r2 = (float) r2     // Catch:{ all -> 0x00c4 }
            r0[r7] = r2     // Catch:{ all -> 0x00c4 }
            r2 = 2
            int r6 = net.fxgear.util.FXUtil.blueFromColor(r20)     // Catch:{ all -> 0x00c4 }
            float r6 = (float) r6     // Catch:{ all -> 0x00c4 }
            r0[r2] = r6     // Catch:{ all -> 0x00c4 }
            float r0 = net.fxgear.fittingview.FittingSurfaceView.colorTemperatureToNormalizeValue(r0)     // Catch:{ all -> 0x00c4 }
            r1.z = r0     // Catch:{ all -> 0x00c4 }
            int r0 = r1.r     // Catch:{ all -> 0x00c4 }
            int r2 = r1.s     // Catch:{ all -> 0x00c4 }
            r6 = r19
            r9.a((int) r0, (int) r2, (net.fxgear.BodySizeData) r6)     // Catch:{ all -> 0x00c4 }
            if (r3 == 0) goto L_0x0095
            int r0 = r3.length     // Catch:{ all -> 0x00c4 }
            net.fxgear.FittingView$ClothesFileInfo[] r2 = r1.A     // Catch:{ all -> 0x00c4 }
            int r2 = r2.length     // Catch:{ all -> 0x00c4 }
            if (r0 != r2) goto L_0x0095
            net.fxgear.FittingView$ClothesFileInfo[] r0 = net.fxgear.FittingView.ClothesFileInfo.b(r18)     // Catch:{ all -> 0x00c4 }
            goto L_0x009b
        L_0x0095:
            net.fxgear.FittingView$ClothesFileInfo[] r0 = EMPTY_CLOTHES     // Catch:{ all -> 0x00c4 }
            net.fxgear.FittingView$ClothesFileInfo[] r0 = net.fxgear.FittingView.ClothesFileInfo.b(r0)     // Catch:{ all -> 0x00c4 }
        L_0x009b:
            net.fxgear.GlobalDefine$Result r2 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x00c4 }
            r2.<init>()     // Catch:{ all -> 0x00c4 }
            r2.resultCode = r5     // Catch:{ all -> 0x00c4 }
            net.fxgear.a r3 = r1.D     // Catch:{ all -> 0x00c4 }
            net.fxgear.FittingView$5 r5 = new net.fxgear.FittingView$5     // Catch:{ all -> 0x00c4 }
            r5.<init>(r0, r2, r8)     // Catch:{ all -> 0x00c4 }
            net.fxgear.FittingView$6 r6 = new net.fxgear.FittingView$6     // Catch:{ all -> 0x00c4 }
            r10 = r6
            r11 = r9
            r12 = r22
            r13 = r2
            r14 = r23
            r15 = r0
            r10.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x00c4 }
            r3.a((java.lang.Runnable) r5, (net.fxgear.a.C0022a) r6)     // Catch:{ all -> 0x00c4 }
            monitor-exit(r9)
            return r7
        L_0x00bb:
            java.lang.String r0 = r1.p     // Catch:{ all -> 0x00c4 }
            java.lang.String r2 = "fittingView working."
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x00c4 }
            monitor-exit(r9)
            return r5
        L_0x00c4:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.SetModeAndCharacter(int, int, int, int, int, net.fxgear.FittingView$RealVideoFileInfo, int, boolean, net.fxgear.FittingView$ClothesFileInfo[], net.fxgear.BodySizeData, int, float, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    public synchronized boolean ResetCamera(final OnFittingViewListener onFittingViewListener, final Runnable runnable) {
        if (this.D == null || this.D.a()) {
            Log.d(this.p, "AsyncWorker is working.");
            return false;
        }
        if (onFittingViewListener != null) {
            onFittingViewListener.OnStartAsyncWork();
        }
        this.D.a((Runnable) new Runnable() {
            public void run() {
                h.e eVar;
                h.e eVar2 = h.e.AVATAR;
                int b2 = FittingView.this.q;
                if (b2 != 0) {
                    switch (b2) {
                        case 2:
                        case 7:
                            eVar = h.e.AVATAR_BODY_EDITING;
                            break;
                        case 3:
                            eVar = h.e.AVATAR_HAIR_EDITING;
                            break;
                        case 4:
                            eVar = h.e.AVATAR_FACE_EDITING;
                            break;
                        case 5:
                            eVar = h.e.AVATAR_SKIN_TONE_EDITING;
                            break;
                        case 6:
                            eVar = h.e.AVATAR_CUSTOM_FACE_EDITING;
                            break;
                        case 8:
                            eVar = h.e.CHECK_CLOTHES_SIZE;
                            break;
                        default:
                            eVar = h.e.AVATAR;
                            break;
                    }
                } else {
                    eVar = h.e.REAL;
                }
                FittingView.this.ResetCamera(eVar);
            }
        }, (a.C0022a) new a.C0022a() {
            public void a() {
                if (onFittingViewListener != null) {
                    onFittingViewListener.OnFinishAsyncWork(runnable);
                }
            }
        });
        return true;
    }

    public synchronized boolean SetClothes(ClothesFileInfo clothesFileInfo, OnFittingViewListener onFittingViewListener, Runnable runnable) {
        return SetClothes(clothesFileInfo, ClothesSizeProvider.GetClosestClothSize(this.r, this.s, clothesFileInfo.mClothType, false), onFittingViewListener, runnable);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b0, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean SetClothes(net.fxgear.FittingView.ClothesFileInfo r9, net.fxgear.GlobalDefine.ClothesSize r10, net.fxgear.FittingView.OnFittingViewListener r11, java.lang.Runnable r12) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.q     // Catch:{ all -> 0x00b1 }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001b
            int r0 = r8.q     // Catch:{ all -> 0x00b1 }
            if (r0 == r1) goto L_0x001b
            int r0 = r8.q     // Catch:{ all -> 0x00b1 }
            r3 = 8
            if (r0 != r3) goto L_0x0012
            goto L_0x001b
        L_0x0012:
            java.lang.String r9 = r8.p     // Catch:{ all -> 0x00b1 }
            java.lang.String r10 = "WARNING :: illegalState - wrong mode."
            android.util.Log.e(r9, r10)     // Catch:{ all -> 0x00b1 }
            goto L_0x00af
        L_0x001b:
            if (r9 != 0) goto L_0x0026
            java.lang.String r9 = r8.p     // Catch:{ all -> 0x00b1 }
            java.lang.String r10 = "[ERROR] :: clothesFileInfo is null"
            android.util.Log.e(r9, r10)     // Catch:{ all -> 0x00b1 }
            monitor-exit(r8)
            return r2
        L_0x0026:
            int r0 = r9.mClothType     // Catch:{ all -> 0x00b1 }
            r3 = -1
            if (r0 <= r3) goto L_0x00a8
            int r0 = r9.mClothType     // Catch:{ all -> 0x00b1 }
            r3 = 5
            if (r0 >= r3) goto L_0x00a8
            net.fxgear.FittingView$ClothesFileInfo[] r0 = r8.A     // Catch:{ all -> 0x00b1 }
            int r3 = r9.mClothType     // Catch:{ all -> 0x00b1 }
            r0 = r0[r3]     // Catch:{ all -> 0x00b1 }
            boolean r0 = r0.equals(r9)     // Catch:{ all -> 0x00b1 }
            if (r0 != 0) goto L_0x00a0
            net.fxgear.a r0 = r8.D     // Catch:{ all -> 0x00b1 }
            if (r0 == 0) goto L_0x0098
            net.fxgear.a r0 = r8.D     // Catch:{ all -> 0x00b1 }
            boolean r0 = r0.a()     // Catch:{ all -> 0x00b1 }
            if (r0 != 0) goto L_0x0098
            if (r11 == 0) goto L_0x004d
            r11.OnStartAsyncWork()     // Catch:{ all -> 0x00b1 }
        L_0x004d:
            net.fxgear.FittingView$ClothesFileInfo[] r0 = r8.A     // Catch:{ all -> 0x00b1 }
            int r0 = r0.length     // Catch:{ all -> 0x00b1 }
            net.fxgear.FittingView$ClothesFileInfo[] r0 = new net.fxgear.FittingView.ClothesFileInfo[r0]     // Catch:{ all -> 0x00b1 }
            r3 = 0
        L_0x0053:
            int r4 = r0.length     // Catch:{ all -> 0x00b1 }
            if (r3 >= r4) goto L_0x0066
            int r4 = r9.mClothType     // Catch:{ all -> 0x00b1 }
            if (r3 != r4) goto L_0x005d
            r0[r3] = r9     // Catch:{ all -> 0x00b1 }
            goto L_0x0063
        L_0x005d:
            net.fxgear.FittingView$ClothesFileInfo[] r4 = r8.A     // Catch:{ all -> 0x00b1 }
            r4 = r4[r3]     // Catch:{ all -> 0x00b1 }
            r0[r3] = r4     // Catch:{ all -> 0x00b1 }
        L_0x0063:
            int r3 = r3 + 1
            goto L_0x0053
        L_0x0066:
            net.fxgear.FittingView$ClothesFileInfo[] r7 = r8.a((net.fxgear.FittingView.ClothesFileInfo) r9, (net.fxgear.FittingView.ClothesFileInfo[]) r0)     // Catch:{ all -> 0x00b1 }
            if (r10 != 0) goto L_0x0076
            int r10 = r8.r     // Catch:{ all -> 0x00b1 }
            int r0 = r8.s     // Catch:{ all -> 0x00b1 }
            int r3 = r9.mClothType     // Catch:{ all -> 0x00b1 }
            net.fxgear.GlobalDefine$ClothesSize r10 = net.fxgear.ClothesSizeProvider.GetClosestClothSize((int) r10, (int) r0, (int) r3, (boolean) r2)     // Catch:{ all -> 0x00b1 }
        L_0x0076:
            net.fxgear.GlobalDefine$ClothesSize[] r0 = r8.B     // Catch:{ all -> 0x00b1 }
            int r9 = r9.mClothType     // Catch:{ all -> 0x00b1 }
            r0[r9] = r10     // Catch:{ all -> 0x00b1 }
            net.fxgear.GlobalDefine$Result r5 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x00b1 }
            r5.<init>()     // Catch:{ all -> 0x00b1 }
            r5.resultCode = r2     // Catch:{ all -> 0x00b1 }
            net.fxgear.a r9 = r8.D     // Catch:{ all -> 0x00b1 }
            net.fxgear.FittingView$9 r10 = new net.fxgear.FittingView$9     // Catch:{ all -> 0x00b1 }
            r10.<init>(r7, r5)     // Catch:{ all -> 0x00b1 }
            net.fxgear.FittingView$10 r0 = new net.fxgear.FittingView$10     // Catch:{ all -> 0x00b1 }
            r2 = r0
            r3 = r8
            r4 = r11
            r6 = r12
            r2.<init>(r4, r5, r6, r7)     // Catch:{ all -> 0x00b1 }
            r9.a((java.lang.Runnable) r10, (net.fxgear.a.C0022a) r0)     // Catch:{ all -> 0x00b1 }
            monitor-exit(r8)
            return r1
        L_0x0098:
            java.lang.String r9 = r8.p     // Catch:{ all -> 0x00b1 }
            java.lang.String r10 = "AsyncWorker is working."
            android.util.Log.d(r9, r10)     // Catch:{ all -> 0x00b1 }
            goto L_0x00af
        L_0x00a0:
            java.lang.String r9 = r8.p     // Catch:{ all -> 0x00b1 }
            java.lang.String r10 = "Did not change data."
            android.util.Log.d(r9, r10)     // Catch:{ all -> 0x00b1 }
            goto L_0x00af
        L_0x00a8:
            java.lang.String r9 = r8.p     // Catch:{ all -> 0x00b1 }
            java.lang.String r10 = "WARNING :: clothType is wrong."
            android.util.Log.e(r9, r10)     // Catch:{ all -> 0x00b1 }
        L_0x00af:
            monitor-exit(r8)
            return r2
        L_0x00b1:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.SetClothes(net.fxgear.FittingView$ClothesFileInfo, net.fxgear.GlobalDefine$ClothesSize, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    public synchronized boolean SetClothes(ClothesFileInfo[] clothesFileInfoArr, OnFittingViewListener onFittingViewListener, Runnable runnable) {
        for (int i = 0; i < this.B.length; i++) {
            this.B[i] = ClothesSizeProvider.GetClosestClothSize(this.r, this.s, i, false);
        }
        return SetClothes(clothesFileInfoArr, this.B, onFittingViewListener, runnable);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e1, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean SetClothes(net.fxgear.FittingView.ClothesFileInfo[] r9, net.fxgear.GlobalDefine.ClothesSize[] r10, net.fxgear.FittingView.OnFittingViewListener r11, java.lang.Runnable r12) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = r8.p     // Catch:{ all -> 0x00e2 }
            java.lang.String r1 = "SetClothes()+"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00e2 }
            int r0 = r8.q     // Catch:{ all -> 0x00e2 }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0022
            int r0 = r8.q     // Catch:{ all -> 0x00e2 }
            if (r0 == r1) goto L_0x0022
            int r0 = r8.q     // Catch:{ all -> 0x00e2 }
            r3 = 8
            if (r0 != r3) goto L_0x0019
            goto L_0x0022
        L_0x0019:
            java.lang.String r9 = r8.p     // Catch:{ all -> 0x00e2 }
            java.lang.String r10 = "WARNING :: illegalState - wrong mode."
            android.util.Log.e(r9, r10)     // Catch:{ all -> 0x00e2 }
            goto L_0x00e0
        L_0x0022:
            if (r9 == 0) goto L_0x00e0
            int r0 = r9.length     // Catch:{ all -> 0x00e2 }
            net.fxgear.FittingView$ClothesFileInfo[] r3 = r8.A     // Catch:{ all -> 0x00e2 }
            int r3 = r3.length     // Catch:{ all -> 0x00e2 }
            if (r0 != r3) goto L_0x00e0
            r0 = 0
        L_0x002b:
            net.fxgear.FittingView$ClothesFileInfo[] r3 = r8.A     // Catch:{ all -> 0x00e2 }
            int r3 = r3.length     // Catch:{ all -> 0x00e2 }
            if (r0 >= r3) goto L_0x0069
            r3 = r9[r0]     // Catch:{ all -> 0x00e2 }
            if (r3 != 0) goto L_0x0058
            java.lang.String r3 = r8.p     // Catch:{ all -> 0x00e2 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e2 }
            r4.<init>()     // Catch:{ all -> 0x00e2 }
            java.lang.String r5 = "clothesFileInfoArray["
            r4.append(r5)     // Catch:{ all -> 0x00e2 }
            r4.append(r0)     // Catch:{ all -> 0x00e2 }
            java.lang.String r5 = "] is null"
            r4.append(r5)     // Catch:{ all -> 0x00e2 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00e2 }
            android.util.Log.e(r3, r4)     // Catch:{ all -> 0x00e2 }
            net.fxgear.FittingView$ClothesFileInfo r3 = new net.fxgear.FittingView$ClothesFileInfo     // Catch:{ all -> 0x00e2 }
            r3.<init>()     // Catch:{ all -> 0x00e2 }
            r3.mClothType = r0     // Catch:{ all -> 0x00e2 }
            r9[r0] = r3     // Catch:{ all -> 0x00e2 }
        L_0x0058:
            r3 = r9[r0]     // Catch:{ all -> 0x00e2 }
            net.fxgear.FittingView$ClothesFileInfo[] r4 = r8.A     // Catch:{ all -> 0x00e2 }
            r4 = r4[r0]     // Catch:{ all -> 0x00e2 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x00e2 }
            if (r3 != 0) goto L_0x0066
            r0 = 1
            goto L_0x006a
        L_0x0066:
            int r0 = r0 + 1
            goto L_0x002b
        L_0x0069:
            r0 = 0
        L_0x006a:
            if (r0 == 0) goto L_0x00d9
            net.fxgear.a r0 = r8.D     // Catch:{ all -> 0x00e2 }
            if (r0 == 0) goto L_0x00d1
            net.fxgear.a r0 = r8.D     // Catch:{ all -> 0x00e2 }
            boolean r0 = r0.a()     // Catch:{ all -> 0x00e2 }
            if (r0 != 0) goto L_0x00d1
            if (r11 == 0) goto L_0x007d
            r11.OnStartAsyncWork()     // Catch:{ all -> 0x00e2 }
        L_0x007d:
            net.fxgear.FittingView$ClothesFileInfo[] r7 = net.fxgear.FittingView.ClothesFileInfo.b(r9)     // Catch:{ all -> 0x00e2 }
            if (r10 == 0) goto L_0x00a0
            r9 = 0
        L_0x0084:
            net.fxgear.GlobalDefine$ClothesSize[] r0 = r8.B     // Catch:{ all -> 0x00e2 }
            int r0 = r0.length     // Catch:{ all -> 0x00e2 }
            if (r9 >= r0) goto L_0x00b5
            r0 = r10[r9]     // Catch:{ all -> 0x00e2 }
            if (r0 != 0) goto L_0x0097
            int r0 = r8.r     // Catch:{ all -> 0x00e2 }
            int r3 = r8.s     // Catch:{ all -> 0x00e2 }
            net.fxgear.GlobalDefine$ClothesSize r0 = net.fxgear.ClothesSizeProvider.GetClosestClothSize((int) r0, (int) r3, (int) r9, (boolean) r2)     // Catch:{ all -> 0x00e2 }
            r10[r9] = r0     // Catch:{ all -> 0x00e2 }
        L_0x0097:
            net.fxgear.GlobalDefine$ClothesSize[] r0 = r8.B     // Catch:{ all -> 0x00e2 }
            r3 = r10[r9]     // Catch:{ all -> 0x00e2 }
            r0[r9] = r3     // Catch:{ all -> 0x00e2 }
            int r9 = r9 + 1
            goto L_0x0084
        L_0x00a0:
            r9 = 0
        L_0x00a1:
            net.fxgear.GlobalDefine$ClothesSize[] r10 = r8.B     // Catch:{ all -> 0x00e2 }
            int r10 = r10.length     // Catch:{ all -> 0x00e2 }
            if (r9 >= r10) goto L_0x00b5
            int r10 = r8.r     // Catch:{ all -> 0x00e2 }
            int r0 = r8.s     // Catch:{ all -> 0x00e2 }
            net.fxgear.GlobalDefine$ClothesSize r10 = net.fxgear.ClothesSizeProvider.GetClosestClothSize((int) r10, (int) r0, (int) r9, (boolean) r2)     // Catch:{ all -> 0x00e2 }
            net.fxgear.GlobalDefine$ClothesSize[] r0 = r8.B     // Catch:{ all -> 0x00e2 }
            r0[r9] = r10     // Catch:{ all -> 0x00e2 }
            int r9 = r9 + 1
            goto L_0x00a1
        L_0x00b5:
            net.fxgear.GlobalDefine$Result r5 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x00e2 }
            r5.<init>()     // Catch:{ all -> 0x00e2 }
            r5.resultCode = r2     // Catch:{ all -> 0x00e2 }
            net.fxgear.a r9 = r8.D     // Catch:{ all -> 0x00e2 }
            net.fxgear.FittingView$11 r10 = new net.fxgear.FittingView$11     // Catch:{ all -> 0x00e2 }
            r10.<init>(r7, r5)     // Catch:{ all -> 0x00e2 }
            net.fxgear.FittingView$13 r0 = new net.fxgear.FittingView$13     // Catch:{ all -> 0x00e2 }
            r2 = r0
            r3 = r8
            r4 = r11
            r6 = r12
            r2.<init>(r4, r5, r6, r7)     // Catch:{ all -> 0x00e2 }
            r9.a((java.lang.Runnable) r10, (net.fxgear.a.C0022a) r0)     // Catch:{ all -> 0x00e2 }
            monitor-exit(r8)
            return r1
        L_0x00d1:
            java.lang.String r9 = r8.p     // Catch:{ all -> 0x00e2 }
            java.lang.String r10 = "AsyncWorker is working."
            android.util.Log.d(r9, r10)     // Catch:{ all -> 0x00e2 }
            goto L_0x00e0
        L_0x00d9:
            java.lang.String r9 = r8.p     // Catch:{ all -> 0x00e2 }
            java.lang.String r10 = "Did not change data."
            android.util.Log.d(r9, r10)     // Catch:{ all -> 0x00e2 }
        L_0x00e0:
            monitor-exit(r8)
            return r2
        L_0x00e2:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.SetClothes(net.fxgear.FittingView$ClothesFileInfo[], net.fxgear.GlobalDefine$ClothesSize[], net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    public void SetClothesRenderingOption(GlobalDefine.ClothesVisualizationOption clothesVisualizationOption) {
        h.c cVar;
        if (clothesVisualizationOption == GlobalDefine.ClothesVisualizationOption.Tension) {
            cVar = h.c.Tension;
        } else if (clothesVisualizationOption == GlobalDefine.ClothesVisualizationOption.Pressure) {
            cVar = h.c.Pressure;
        } else {
            cVar = h.c.Color;
        }
        SetClothRenderMode(cVar);
    }

    public GlobalDefine.ClothesVisualizationOption GetClothesRenderingOption() {
        h.c GetClothRenderMode = GetClothRenderMode();
        if (GetClothRenderMode == h.c.Tension) {
            return GlobalDefine.ClothesVisualizationOption.Tension;
        }
        if (GetClothRenderMode == h.c.Pressure) {
            return GlobalDefine.ClothesVisualizationOption.Pressure;
        }
        return GlobalDefine.ClothesVisualizationOption.Color;
    }

    public void SetClothesSize(final HashMap<Integer, GlobalDefine.ClothesSize> hashMap, final OnFittingViewListener onFittingViewListener, final Runnable runnable) {
        if (GetCurrentSceneMode() != h.e.CHECK_CLOTHES_SIZE) {
            throw new UnsupportedOperationException("This method must be called in \"MODE_CHECK_CLOTHES_SIZE\" mode.");
        } else if (hashMap != null) {
            if (onFittingViewListener != null) {
                onFittingViewListener.OnStartAsyncWork();
            }
            this.D.a((Runnable) new Runnable() {
                public void run() {
                    HashMap hashMap = new HashMap();
                    for (Integer intValue : hashMap.keySet()) {
                        int intValue2 = intValue.intValue();
                        h.d GetClothesMeshCategory = FittingView.this.GetClothesMeshCategory(intValue2);
                        if (GetClothesMeshCategory != h.d.NONE) {
                            GlobalDefine.ClothesSize clothesSize = (GlobalDefine.ClothesSize) hashMap.get(Integer.valueOf(intValue2));
                            FittingView.this.B[intValue2] = clothesSize;
                            hashMap.put(GetClothesMeshCategory, Integer.valueOf(clothesSize.ordinal()));
                        }
                    }
                    FittingView.this.SetClothSize(hashMap);
                }
            }, (a.C0022a) new a.C0022a() {
                public void a() {
                    if (onFittingViewListener != null) {
                        onFittingViewListener.OnFinishAsyncWork(runnable);
                    }
                }
            });
        } else {
            Log.e(this.p, "[ERROR] :: SetClothesSize(), clothesSizeInfo is null");
        }
    }

    public double GetCurrentBodySize(int i) {
        if (this.C == null) {
            return (double) AvatarSetting.NO_VALUE;
        }
        AvatarSetting avatarSetting = this.C;
        return AvatarSetting.GetValueOfBodyPart(i);
    }

    public double GetCurrentBodyThresHoldMaxValue(int i) {
        if (this.C != null) {
            return this.C.GetHighThresholdValueOfBodyPart(i);
        }
        return (double) AvatarSetting.NO_VALUE;
    }

    public double GetCurrentBodyThresHoldMinValue(int i) {
        if (this.C != null) {
            return this.C.GetLowThresholdValueOfBodyPart(i);
        }
        return (double) AvatarSetting.NO_VALUE;
    }

    public BodySizeData GetCurrentBodySizeAll() {
        if (this.C == null) {
            return null;
        }
        BodySizeData bodySizeData = new BodySizeData();
        AvatarSetting avatarSetting = this.C;
        bodySizeData.mTallSize = (float) AvatarSetting.GetValueOfBodyPart(0);
        AvatarSetting avatarSetting2 = this.C;
        bodySizeData.mUpperSize = (float) AvatarSetting.GetValueOfBodyPart(5);
        AvatarSetting avatarSetting3 = this.C;
        bodySizeData.mLowerSize = (float) AvatarSetting.GetValueOfBodyPart(6);
        AvatarSetting avatarSetting4 = this.C;
        bodySizeData.mShoulderSize = (float) AvatarSetting.GetValueOfBodyPart(1);
        AvatarSetting avatarSetting5 = this.C;
        bodySizeData.mBustSize = (float) AvatarSetting.GetValueOfBodyPart(7);
        AvatarSetting avatarSetting6 = this.C;
        bodySizeData.mCupSize = (float) AvatarSetting.GetValueOfBodyPart(8);
        AvatarSetting avatarSetting7 = this.C;
        bodySizeData.mWaistSize = (float) AvatarSetting.GetValueOfBodyPart(9);
        AvatarSetting avatarSetting8 = this.C;
        bodySizeData.mHipSize = (float) AvatarSetting.GetValueOfBodyPart(11);
        AvatarSetting avatarSetting9 = this.C;
        bodySizeData.mArmLengthSize = (float) AvatarSetting.GetValueOfBodyPart(2);
        AvatarSetting avatarSetting10 = this.C;
        bodySizeData.mArmThickSize = (float) AvatarSetting.GetValueOfBodyPart(10);
        AvatarSetting avatarSetting11 = this.C;
        bodySizeData.mThighLengthSize = (float) AvatarSetting.GetValueOfBodyPart(3);
        AvatarSetting avatarSetting12 = this.C;
        bodySizeData.mThighThickSize = (float) AvatarSetting.GetValueOfBodyPart(12);
        AvatarSetting avatarSetting13 = this.C;
        bodySizeData.mCalfLengthSize = (float) AvatarSetting.GetValueOfBodyPart(4);
        AvatarSetting avatarSetting14 = this.C;
        bodySizeData.mHeadHeight = (float) AvatarSetting.GetValueOfBodyPart(14);
        return bodySizeData;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007d, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean SetBodySize(int r10, float r11, boolean r12, final net.fxgear.FittingView.OnFittingViewListener r13, final java.lang.Runnable r14) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r0 = r9.p     // Catch:{ all -> 0x0088 }
            java.lang.String r1 = "SetBodySize()+"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0088 }
            net.fxgear.AvatarSetting r0 = r9.C     // Catch:{ all -> 0x0088 }
            if (r0 == 0) goto L_0x007e
            r0 = 1
            if (r12 == 0) goto L_0x0056
            net.fxgear.a r11 = r9.D     // Catch:{ all -> 0x0088 }
            if (r11 == 0) goto L_0x004e
            net.fxgear.a r11 = r9.D     // Catch:{ all -> 0x0088 }
            boolean r11 = r11.a()     // Catch:{ all -> 0x0088 }
            if (r11 != 0) goto L_0x004e
            if (r13 == 0) goto L_0x0020
            r13.OnStartAsyncWork()     // Catch:{ all -> 0x0088 }
        L_0x0020:
            net.fxgear.AvatarSetting r11 = r9.C     // Catch:{ all -> 0x0088 }
            float[] r5 = net.fxgear.AvatarSetting.a()     // Catch:{ all -> 0x0088 }
            net.fxgear.AvatarSetting r11 = r9.C     // Catch:{ all -> 0x0088 }
            double r11 = r11.GetHeadScale()     // Catch:{ all -> 0x0088 }
            float r4 = (float) r11     // Catch:{ all -> 0x0088 }
            net.fxgear.AvatarSetting r11 = r9.C     // Catch:{ all -> 0x0088 }
            double r11 = r11.GetAvatarHeighWithoutHeadSize()     // Catch:{ all -> 0x0088 }
            float r6 = (float) r11     // Catch:{ all -> 0x0088 }
            net.fxgear.GlobalDefine$Result r11 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x0088 }
            r11.<init>()     // Catch:{ all -> 0x0088 }
            net.fxgear.a r12 = r9.D     // Catch:{ all -> 0x0088 }
            net.fxgear.FittingView$16 r8 = new net.fxgear.FittingView$16     // Catch:{ all -> 0x0088 }
            r1 = r8
            r2 = r9
            r3 = r10
            r7 = r11
            r1.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0088 }
            net.fxgear.FittingView$17 r10 = new net.fxgear.FittingView$17     // Catch:{ all -> 0x0088 }
            r10.<init>(r13, r11, r14)     // Catch:{ all -> 0x0088 }
            r12.a((java.lang.Runnable) r8, (net.fxgear.a.C0022a) r10)     // Catch:{ all -> 0x0088 }
            monitor-exit(r9)
            return r0
        L_0x004e:
            java.lang.String r10 = r9.p     // Catch:{ all -> 0x0088 }
            java.lang.String r11 = "fittingView working."
            android.util.Log.d(r10, r11)     // Catch:{ all -> 0x0088 }
            goto L_0x0085
        L_0x0056:
            net.fxgear.AvatarSetting r12 = r9.C     // Catch:{ all -> 0x0088 }
            double r13 = (double) r11     // Catch:{ all -> 0x0088 }
            int r11 = r12.SetValueOfBodyPart(r10, r13)     // Catch:{ all -> 0x0088 }
            net.fxgear.AvatarSetting r12 = r9.C     // Catch:{ all -> 0x0088 }
            float[] r12 = net.fxgear.AvatarSetting.a()     // Catch:{ all -> 0x0088 }
            net.fxgear.AvatarSetting r13 = r9.C     // Catch:{ all -> 0x0088 }
            double r13 = r13.GetHeadScale()     // Catch:{ all -> 0x0088 }
            float r13 = (float) r13     // Catch:{ all -> 0x0088 }
            net.fxgear.AvatarSetting r14 = r9.C     // Catch:{ all -> 0x0088 }
            double r1 = r14.GetAvatarHeighWithoutHeadSize()     // Catch:{ all -> 0x0088 }
            float r14 = (float) r1     // Catch:{ all -> 0x0088 }
            r1 = 14
            if (r10 != r1) goto L_0x0079
            r9.SetFaceScaleAsync(r13)     // Catch:{ all -> 0x0088 }
            goto L_0x007c
        L_0x0079:
            r9.SetBodyWeightDataAsync(r11, r12, r14)     // Catch:{ all -> 0x0088 }
        L_0x007c:
            monitor-exit(r9)
            return r0
        L_0x007e:
            java.lang.String r10 = r9.p     // Catch:{ all -> 0x0088 }
            java.lang.String r11 = "mAvatarSetting is null."
            android.util.Log.d(r10, r11)     // Catch:{ all -> 0x0088 }
        L_0x0085:
            r10 = 0
            monitor-exit(r9)
            return r10
        L_0x0088:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.SetBodySize(int, float, boolean, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    public synchronized boolean SetBodySizeAll(BodySizeData bodySizeData, final OnFittingViewListener onFittingViewListener, final Runnable runnable) {
        Log.d(this.p, "SetBodySizeAll()+");
        if (this.C == null || bodySizeData == null) {
            Log.d(this.p, "ERROR :: IllegalState or param is null.");
        } else if (this.D == null || this.D.a()) {
            Log.d(this.p, "fittingView working.");
        } else {
            if (onFittingViewListener != null) {
                onFittingViewListener.OnStartAsyncWork();
            }
            a(this.r, this.s, bodySizeData);
            AvatarSetting avatarSetting = this.C;
            final float[] a2 = AvatarSetting.a();
            final float GetHeadScale = (float) this.C.GetHeadScale();
            final float GetAvatarHeighWithoutHeadSize = (float) this.C.GetAvatarHeighWithoutHeadSize();
            final GlobalDefine.Result result = new GlobalDefine.Result();
            final GlobalDefine.Result result2 = result;
            this.D.a((Runnable) new Runnable() {
                public void run() {
                    try {
                        FittingView.this.SetBodyWeightData(a2, GetAvatarHeighWithoutHeadSize);
                        FittingView.this.SetFaceScale(GetHeadScale);
                        result2.resultCode = -1;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        result2.resultCode = -3;
                        result2.resultExtra = th;
                    }
                }
            }, (a.C0022a) new a.C0022a() {
                public void a() {
                    if (onFittingViewListener == null) {
                        return;
                    }
                    if (result.resultCode == -1) {
                        onFittingViewListener.OnFinishAsyncWork(runnable);
                    } else {
                        onFittingViewListener.OnOccurError(result);
                    }
                }
            });
            return true;
        }
        return false;
    }

    public synchronized boolean SetAvatarModeAndWholeHead(int i, int i2, int i3, boolean z2, OnFittingViewListener onFittingViewListener, Runnable runnable) {
        if (i == 0) {
            String str = this.p;
            Log.e(str, "[ERROR] :: illegalState - wrong mode - " + i);
            return false;
        }
        boolean z3 = true;
        boolean z4 = i2 >= 0 && i2 < AvatarSetting.GetHairTypeCount(getContext(), this.r, this.s);
        int GetHeadTypeCount = AvatarSetting.GetHeadTypeCount(getContext(), this.r, this.s);
        if (i3 >= 0 && i3 < GetHeadTypeCount) {
            if (z2) {
                if (a()) {
                }
            }
            if (z4 || !z3) {
                Log.e(this.p, "[ERROR] :: invalid hair or head type");
                String str2 = this.p;
                Log.e(str2, "validHairType: " + z4 + ", hairTypeIndex: " + i2);
                String str3 = this.p;
                Log.e(str3, "validHeadType: " + z3 + ", headTypeIndex: " + i3);
                return false;
            }
            AvatarSetting avatarSetting = this.C;
            return a(i, i3, i2, z2, AvatarSetting.a(), onFittingViewListener, runnable);
        }
        z3 = false;
        if (z4) {
        }
        Log.e(this.p, "[ERROR] :: invalid hair or head type");
        String str22 = this.p;
        Log.e(str22, "validHairType: " + z4 + ", hairTypeIndex: " + i2);
        String str32 = this.p;
        Log.e(str32, "validHeadType: " + z3 + ", headTypeIndex: " + i3);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006d, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean SetAvatarHairType(int r5, final net.fxgear.FittingView.OnFittingViewListener r6, final java.lang.Runnable r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = r4.p     // Catch:{ all -> 0x006e }
            java.lang.String r1 = "SetAvatarHairType()+"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x006e }
            int r0 = r4.q     // Catch:{ all -> 0x006e }
            r1 = 0
            if (r0 == 0) goto L_0x006c
            android.content.Context r0 = r4.getContext()     // Catch:{ all -> 0x006e }
            int r2 = r4.r     // Catch:{ all -> 0x006e }
            int r3 = r4.s     // Catch:{ all -> 0x006e }
            int r0 = net.fxgear.AvatarSetting.GetHairTypeCount(r0, r2, r3)     // Catch:{ all -> 0x006e }
            r2 = 1
            if (r5 < 0) goto L_0x0020
            if (r5 >= r0) goto L_0x0020
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            if (r0 == 0) goto L_0x0056
            net.fxgear.a r0 = r4.D     // Catch:{ all -> 0x006e }
            if (r0 == 0) goto L_0x004e
            net.fxgear.a r0 = r4.D     // Catch:{ all -> 0x006e }
            boolean r0 = r0.a()     // Catch:{ all -> 0x006e }
            if (r0 != 0) goto L_0x004e
            if (r6 == 0) goto L_0x0034
            r6.OnStartAsyncWork()     // Catch:{ all -> 0x006e }
        L_0x0034:
            r4.u = r5     // Catch:{ all -> 0x006e }
            net.fxgear.GlobalDefine$Result r5 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x006e }
            r5.<init>()     // Catch:{ all -> 0x006e }
            r5.resultCode = r1     // Catch:{ all -> 0x006e }
            net.fxgear.a r0 = r4.D     // Catch:{ all -> 0x006e }
            net.fxgear.FittingView$20 r1 = new net.fxgear.FittingView$20     // Catch:{ all -> 0x006e }
            r1.<init>(r5)     // Catch:{ all -> 0x006e }
            net.fxgear.FittingView$21 r3 = new net.fxgear.FittingView$21     // Catch:{ all -> 0x006e }
            r3.<init>(r6, r5, r7)     // Catch:{ all -> 0x006e }
            r0.a((java.lang.Runnable) r1, (net.fxgear.a.C0022a) r3)     // Catch:{ all -> 0x006e }
            monitor-exit(r4)
            return r2
        L_0x004e:
            java.lang.String r5 = r4.p     // Catch:{ all -> 0x006e }
            java.lang.String r6 = "AsyncWorker is working."
            android.util.Log.d(r5, r6)     // Catch:{ all -> 0x006e }
            goto L_0x006c
        L_0x0056:
            java.lang.String r6 = r4.p     // Catch:{ all -> 0x006e }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
            r7.<init>()     // Catch:{ all -> 0x006e }
            java.lang.String r0 = "WARNING :: invalid hair type - "
            r7.append(r0)     // Catch:{ all -> 0x006e }
            r7.append(r5)     // Catch:{ all -> 0x006e }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x006e }
            android.util.Log.e(r6, r5)     // Catch:{ all -> 0x006e }
        L_0x006c:
            monitor-exit(r4)
            return r1
        L_0x006e:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.SetAvatarHairType(int, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0077, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean SetAvatarHeadType(int r5, boolean r6, final net.fxgear.FittingView.OnFittingViewListener r7, final java.lang.Runnable r8) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = r4.p     // Catch:{ all -> 0x0078 }
            java.lang.String r1 = "SetAvatarHeadType()+"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0078 }
            int r0 = r4.q     // Catch:{ all -> 0x0078 }
            r1 = 0
            if (r0 == 0) goto L_0x0076
            android.content.Context r0 = r4.getContext()     // Catch:{ all -> 0x0078 }
            int r2 = r4.r     // Catch:{ all -> 0x0078 }
            int r3 = r4.s     // Catch:{ all -> 0x0078 }
            int r0 = net.fxgear.AvatarSetting.GetHeadTypeCount(r0, r2, r3)     // Catch:{ all -> 0x0078 }
            r2 = 1
            if (r5 < 0) goto L_0x0028
            if (r5 >= r0) goto L_0x0028
            if (r6 == 0) goto L_0x0026
            boolean r0 = r4.a()     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x0028
        L_0x0026:
            r0 = 1
            goto L_0x0029
        L_0x0028:
            r0 = 0
        L_0x0029:
            if (r0 == 0) goto L_0x0060
            net.fxgear.a r0 = r4.D     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x0058
            net.fxgear.a r0 = r4.D     // Catch:{ all -> 0x0078 }
            boolean r0 = r0.a()     // Catch:{ all -> 0x0078 }
            if (r0 != 0) goto L_0x0058
            if (r7 == 0) goto L_0x003c
            r7.OnStartAsyncWork()     // Catch:{ all -> 0x0078 }
        L_0x003c:
            r4.x = r6     // Catch:{ all -> 0x0078 }
            r4.t = r5     // Catch:{ all -> 0x0078 }
            net.fxgear.GlobalDefine$Result r5 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x0078 }
            r5.<init>()     // Catch:{ all -> 0x0078 }
            r5.resultCode = r1     // Catch:{ all -> 0x0078 }
            net.fxgear.a r6 = r4.D     // Catch:{ all -> 0x0078 }
            net.fxgear.FittingView$22 r0 = new net.fxgear.FittingView$22     // Catch:{ all -> 0x0078 }
            r0.<init>(r5)     // Catch:{ all -> 0x0078 }
            net.fxgear.FittingView$24 r1 = new net.fxgear.FittingView$24     // Catch:{ all -> 0x0078 }
            r1.<init>(r7, r5, r8)     // Catch:{ all -> 0x0078 }
            r6.a((java.lang.Runnable) r0, (net.fxgear.a.C0022a) r1)     // Catch:{ all -> 0x0078 }
            monitor-exit(r4)
            return r2
        L_0x0058:
            java.lang.String r5 = r4.p     // Catch:{ all -> 0x0078 }
            java.lang.String r6 = "AsyncWorker is working."
            android.util.Log.d(r5, r6)     // Catch:{ all -> 0x0078 }
            goto L_0x0076
        L_0x0060:
            java.lang.String r6 = r4.p     // Catch:{ all -> 0x0078 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0078 }
            r7.<init>()     // Catch:{ all -> 0x0078 }
            java.lang.String r8 = "WARNING :: invalid head type - "
            r7.append(r8)     // Catch:{ all -> 0x0078 }
            r7.append(r5)     // Catch:{ all -> 0x0078 }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x0078 }
            android.util.Log.e(r6, r5)     // Catch:{ all -> 0x0078 }
        L_0x0076:
            monitor-exit(r4)
            return r1
        L_0x0078:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.SetAvatarHeadType(int, boolean, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    private boolean a(int i, int i2, int i3, boolean z2, final float[] fArr, final OnFittingViewListener onFittingViewListener, final Runnable runnable) {
        Log.d(this.p, "SetAvatarDataWithScene()+");
        if (i == 0 || fArr == null) {
            Log.e(this.p, "WARNING :: illegalState - wrong param");
            return false;
        } else if (this.D == null || this.D.a()) {
            Log.d(this.p, "AsyncWorker is working.");
            return false;
        } else {
            if (onFittingViewListener != null) {
                onFittingViewListener.OnStartAsyncWork();
            }
            this.q = i;
            this.t = i2;
            this.u = i3;
            this.x = z2;
            final GlobalDefine.Result result = new GlobalDefine.Result();
            result.resultCode = 0;
            this.D.a((Runnable) new Runnable() {
                public void run() {
                    try {
                        float GetAvatarHeighWithoutHeadSize = (float) FittingView.this.C.GetAvatarHeighWithoutHeadSize();
                        int unused = FittingView.this.b(FittingView.this.q, FittingView.this.r, FittingView.this.s);
                        g a2 = FittingView.this.a(FittingView.this.q, FittingView.this.r, FittingView.this.s, fArr, GetAvatarHeighWithoutHeadSize, FittingView.this.A);
                        if (a2 == null) {
                            result.resultCode = 3;
                            return;
                        }
                        FittingView.this.SetModeData((net.fxgear.fittingview.data.h) null, FittingView.this.a(FittingView.this.r, FittingView.this.s, FittingView.this.b(a2.c()), FittingView.this.t, FittingView.this.u), FittingView.this.a(FittingView.this.r, FittingView.this.s, FittingView.this.a(a2.c())), a2, (FittingFaceData) null, false);
                        result.resultCode = -1;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        result.resultCode = -3;
                        result.resultExtra = th;
                    }
                }
            }, (a.C0022a) new a.C0022a() {
                public void a() {
                    if (onFittingViewListener == null) {
                        return;
                    }
                    if (result.resultCode == -1) {
                        onFittingViewListener.OnFinishAsyncWork(runnable);
                    } else {
                        onFittingViewListener.OnOccurError(result);
                    }
                }
            });
            return true;
        }
    }

    private boolean a(int i, int i2, int i3, boolean z2, BodySizeData bodySizeData, final OnFittingViewListener onFittingViewListener, final Runnable runnable) {
        Log.d(this.p, "SetAvatarDataWithScene()+");
        if (i == 0 || bodySizeData == null) {
            Log.e(this.p, "WARNING :: illegalState - wrong param");
            return false;
        } else if (this.D == null || this.D.a()) {
            Log.d(this.p, "AsyncWorker is working.");
            return false;
        } else {
            if (onFittingViewListener != null) {
                onFittingViewListener.OnStartAsyncWork();
            }
            this.q = i;
            this.t = i2;
            this.u = i3;
            this.x = z2;
            a(this.r, this.s, bodySizeData);
            final GlobalDefine.Result result = new GlobalDefine.Result();
            result.resultCode = 0;
            this.D.a((Runnable) new Runnable() {
                public void run() {
                    try {
                        AvatarSetting unused = FittingView.this.C;
                        float[] a2 = AvatarSetting.a();
                        float GetAvatarHeighWithoutHeadSize = (float) FittingView.this.C.GetAvatarHeighWithoutHeadSize();
                        int unused2 = FittingView.this.b(FittingView.this.q, FittingView.this.r, FittingView.this.s);
                        g a3 = FittingView.this.a(FittingView.this.q, FittingView.this.r, FittingView.this.s, a2, GetAvatarHeighWithoutHeadSize, FittingView.this.A);
                        if (a3 == null) {
                            result.resultCode = 3;
                            return;
                        }
                        FittingView.this.SetModeData((net.fxgear.fittingview.data.h) null, FittingView.this.a(FittingView.this.r, FittingView.this.s, FittingView.this.b(a3.c()), FittingView.this.t, FittingView.this.u), FittingView.this.a(FittingView.this.r, FittingView.this.s, FittingView.this.a(a3.c())), a3, (FittingFaceData) null, false);
                        result.resultCode = -1;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        result.resultCode = -3;
                        result.resultExtra = th;
                    }
                }
            }, (a.C0022a) new a.C0022a() {
                public void a() {
                    if (onFittingViewListener == null) {
                        return;
                    }
                    if (result.resultCode == -1) {
                        onFittingViewListener.OnFinishAsyncWork(runnable);
                    } else {
                        onFittingViewListener.OnOccurError(result);
                    }
                }
            });
            return true;
        }
    }

    public synchronized boolean SetAvatarHairTypeWithSetAvatarMode(int i, int i2, OnFittingViewListener onFittingViewListener, Runnable runnable) {
        Log.d(this.p, "SetAvatarHairTypeWithSetAvatarMode()+");
        if (i != 0) {
            if (this.q != 0) {
                if (i2 >= 0 && i2 < AvatarSetting.GetHairTypeCount(getContext(), this.r, this.s)) {
                    int i3 = this.t;
                    boolean z2 = this.x;
                    AvatarSetting avatarSetting = this.C;
                    return a(i, i3, i2, z2, AvatarSetting.a(), onFittingViewListener, runnable);
                }
                String str = this.p;
                Log.e(str, "WARNING :: invalid hair type - " + i2);
                return false;
            }
        }
        Log.e(this.p, "WARNING :: illegalState - wrong mode.");
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0041 A[SYNTHETIC, Splitter:B:19:0x0041] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean SetAvatarHeadTypeWithSetAvatarMode(int r10, int r11, boolean r12, net.fxgear.FittingView.OnFittingViewListener r13, java.lang.Runnable r14) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r1 = r9.p     // Catch:{ all -> 0x0062 }
            java.lang.String r2 = "SetAvatarHeadTypeWithSetAvatarMode()+"
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x0062 }
            r1 = 0
            if (r10 == 0) goto L_0x0059
            int r3 = r9.q     // Catch:{ all -> 0x0062 }
            if (r3 != 0) goto L_0x0010
            goto L_0x0059
        L_0x0010:
            android.content.Context r3 = r9.getContext()     // Catch:{ all -> 0x0062 }
            int r4 = r9.r     // Catch:{ all -> 0x0062 }
            int r5 = r9.s     // Catch:{ all -> 0x0062 }
            int r3 = net.fxgear.AvatarSetting.GetHeadTypeCount(r3, r4, r5)     // Catch:{ all -> 0x0062 }
            r4 = 1
            if (r11 < 0) goto L_0x002a
            if (r11 >= r3) goto L_0x002a
            if (r12 == 0) goto L_0x002b
            boolean r3 = r9.a()     // Catch:{ all -> 0x0062 }
            if (r3 == 0) goto L_0x002a
            goto L_0x002b
        L_0x002a:
            r4 = 0
        L_0x002b:
            if (r4 == 0) goto L_0x0041
            int r4 = r9.u     // Catch:{ all -> 0x0062 }
            net.fxgear.AvatarSetting r1 = r9.C     // Catch:{ all -> 0x0062 }
            float[] r6 = net.fxgear.AvatarSetting.a()     // Catch:{ all -> 0x0062 }
            r1 = r9
            r2 = r10
            r3 = r11
            r5 = r12
            r7 = r13
            r8 = r14
            boolean r0 = r1.a((int) r2, (int) r3, (int) r4, (boolean) r5, (float[]) r6, (net.fxgear.FittingView.OnFittingViewListener) r7, (java.lang.Runnable) r8)     // Catch:{ all -> 0x0062 }
            monitor-exit(r9)
            return r0
        L_0x0041:
            java.lang.String r2 = r9.p     // Catch:{ all -> 0x0062 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0062 }
            r3.<init>()     // Catch:{ all -> 0x0062 }
            java.lang.String r4 = "WARNING :: invalid head type - "
            r3.append(r4)     // Catch:{ all -> 0x0062 }
            r3.append(r11)     // Catch:{ all -> 0x0062 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0062 }
            android.util.Log.e(r2, r0)     // Catch:{ all -> 0x0062 }
            monitor-exit(r9)
            return r1
        L_0x0059:
            java.lang.String r0 = r9.p     // Catch:{ all -> 0x0062 }
            java.lang.String r2 = "WARNING :: illegalState - wrong mode."
            android.util.Log.e(r0, r2)     // Catch:{ all -> 0x0062 }
            monitor-exit(r9)
            return r1
        L_0x0062:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.SetAvatarHeadTypeWithSetAvatarMode(int, int, boolean, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:17:0x0030=Splitter:B:17:0x0030, B:13:0x0027=Splitter:B:13:0x0027} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean SetBodySizeAllWithSetAvatarMode(int r11, net.fxgear.BodySizeData r12, net.fxgear.FittingView.OnFittingViewListener r13, java.lang.Runnable r14) {
        /*
            r10 = this;
            monitor-enter(r10)
            java.lang.String r0 = r10.p     // Catch:{ all -> 0x0039 }
            java.lang.String r1 = "SetBodySizeAllWithSetAvatarMode()+"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0039 }
            r0 = 0
            if (r11 == 0) goto L_0x0030
            int r1 = r10.q     // Catch:{ all -> 0x0039 }
            if (r1 != 0) goto L_0x0010
            goto L_0x0030
        L_0x0010:
            net.fxgear.AvatarSetting r1 = r10.C     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0027
            if (r12 == 0) goto L_0x0027
            int r4 = r10.t     // Catch:{ all -> 0x0039 }
            int r5 = r10.u     // Catch:{ all -> 0x0039 }
            boolean r6 = r10.x     // Catch:{ all -> 0x0039 }
            r2 = r10
            r3 = r11
            r7 = r12
            r8 = r13
            r9 = r14
            boolean r11 = r2.a((int) r3, (int) r4, (int) r5, (boolean) r6, (net.fxgear.BodySizeData) r7, (net.fxgear.FittingView.OnFittingViewListener) r8, (java.lang.Runnable) r9)     // Catch:{ all -> 0x0039 }
            monitor-exit(r10)
            return r11
        L_0x0027:
            java.lang.String r11 = r10.p     // Catch:{ all -> 0x0039 }
            java.lang.String r12 = "ERROR :: IllegalState or param is null."
            android.util.Log.d(r11, r12)     // Catch:{ all -> 0x0039 }
            monitor-exit(r10)
            return r0
        L_0x0030:
            java.lang.String r11 = r10.p     // Catch:{ all -> 0x0039 }
            java.lang.String r12 = "WARNING :: illegalState - wrong mode."
            android.util.Log.e(r11, r12)     // Catch:{ all -> 0x0039 }
            monitor-exit(r10)
            return r0
        L_0x0039:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.SetBodySizeAllWithSetAvatarMode(int, net.fxgear.BodySizeData, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x0044=Splitter:B:20:0x0044, B:24:0x004d=Splitter:B:24:0x004d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean CreateCustomfaceData(final java.io.File r4, final int[] r5, final net.fxgear.FittingView.OnFittingViewListener r6, final java.lang.Runnable r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = r3.p     // Catch:{ all -> 0x0056 }
            java.lang.String r1 = "CreateCustomfaceData()+"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0056 }
            r0 = 0
            if (r4 == 0) goto L_0x004d
            boolean r1 = r4.exists()     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x004d
            boolean r1 = r4.isFile()     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x004d
            if (r5 != 0) goto L_0x001a
            goto L_0x004d
        L_0x001a:
            net.fxgear.a r1 = r3.D     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x0044
            net.fxgear.a r1 = r3.D     // Catch:{ all -> 0x0056 }
            boolean r1 = r1.a()     // Catch:{ all -> 0x0056 }
            if (r1 != 0) goto L_0x0044
            if (r6 == 0) goto L_0x002b
            r6.OnStartAsyncWork()     // Catch:{ all -> 0x0056 }
        L_0x002b:
            net.fxgear.GlobalDefine$Result r1 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x0056 }
            r1.<init>()     // Catch:{ all -> 0x0056 }
            r1.resultCode = r0     // Catch:{ all -> 0x0056 }
            net.fxgear.a r0 = r3.D     // Catch:{ all -> 0x0056 }
            net.fxgear.FittingView$29 r2 = new net.fxgear.FittingView$29     // Catch:{ all -> 0x0056 }
            r2.<init>(r4, r5, r1)     // Catch:{ all -> 0x0056 }
            net.fxgear.FittingView$30 r4 = new net.fxgear.FittingView$30     // Catch:{ all -> 0x0056 }
            r4.<init>(r6, r1, r7)     // Catch:{ all -> 0x0056 }
            r0.a((java.lang.Runnable) r2, (net.fxgear.a.C0022a) r4)     // Catch:{ all -> 0x0056 }
            r4 = 1
            monitor-exit(r3)
            return r4
        L_0x0044:
            java.lang.String r4 = r3.p     // Catch:{ all -> 0x0056 }
            java.lang.String r5 = "AsyncWorker is working."
            android.util.Log.d(r4, r5)     // Catch:{ all -> 0x0056 }
            monitor-exit(r3)
            return r0
        L_0x004d:
            java.lang.String r4 = r3.p     // Catch:{ all -> 0x0056 }
            java.lang.String r5 = "WARNING :: param error."
            android.util.Log.e(r4, r5)     // Catch:{ all -> 0x0056 }
            monitor-exit(r3)
            return r0
        L_0x0056:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.CreateCustomfaceData(java.io.File, int[], net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    public synchronized boolean SetDefaultAvatarFace(int i, OnFittingViewListener onFittingViewListener, Runnable runnable) {
        int i2;
        i2 = i;
        return SetAvatarHeadTypeWithSkinValue(i2, false, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, FittingSurfaceView.colorTemperatureToNormalizeValue(new float[]{(float) FXUtil.redFromColor(-1), (float) FXUtil.greenFromColor(-1), (float) FXUtil.blueFromColor(-1)}), onFittingViewListener, runnable);
    }

    public synchronized boolean SetAvatarSkinAuto(final float f, boolean z2, final OnFittingViewListener onFittingViewListener, final Runnable runnable) {
        Log.d(this.p, "SetAvatarSkinAuto()+");
        if (!z2) {
            this.y = f;
            try {
                UpdateCustomfaceTexture(f);
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                if (onFittingViewListener != null) {
                    GlobalDefine.Result result = new GlobalDefine.Result();
                    result.resultCode = -3;
                    result.resultExtra = th;
                    onFittingViewListener.OnOccurError(result);
                }
                return false;
            }
        } else if (this.D == null || this.D.a()) {
            Log.d(this.p, "fittingView working.");
            return false;
        } else {
            if (onFittingViewListener != null) {
                onFittingViewListener.OnStartAsyncWork();
            }
            this.y = f;
            final GlobalDefine.Result result2 = new GlobalDefine.Result();
            this.D.a((Runnable) new Runnable() {
                public void run() {
                    try {
                        FittingView.this.UpdateCustomfaceTexture(f);
                        result2.resultCode = -1;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        result2.resultCode = -3;
                        result2.resultExtra = th;
                    }
                }
            }, (a.C0022a) new a.C0022a() {
                public void a() {
                    if (onFittingViewListener == null) {
                        return;
                    }
                    if (result2.resultCode == -1) {
                        onFittingViewListener.OnFinishAsyncWork(runnable);
                    } else {
                        onFittingViewListener.OnOccurError(result2);
                    }
                }
            });
            return true;
        }
    }

    public synchronized boolean SetAvatarSkinTone(final float f, boolean z2, final OnFittingViewListener onFittingViewListener, final Runnable runnable) {
        Log.d(this.p, "SetAvatarSkinTone()+");
        if (!z2) {
            this.z = f;
            UpdateSkinToneAsync(f);
            return true;
        } else if (this.D == null || this.D.a()) {
            Log.d(this.p, "fittingView working.");
            return false;
        } else {
            if (onFittingViewListener != null) {
                onFittingViewListener.OnStartAsyncWork();
            }
            this.z = f;
            final GlobalDefine.Result result = new GlobalDefine.Result();
            this.D.a((Runnable) new Runnable() {
                public void run() {
                    try {
                        FittingView.this.UpdateSkinTone(f);
                        result.resultCode = -1;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        result.resultCode = -3;
                        result.resultExtra = th;
                    }
                }
            }, (a.C0022a) new a.C0022a() {
                public void a() {
                    if (onFittingViewListener == null) {
                        return;
                    }
                    if (result.resultCode == -1) {
                        onFittingViewListener.OnFinishAsyncWork(runnable);
                    } else {
                        onFittingViewListener.OnOccurError(result);
                    }
                }
            });
            return true;
        }
    }

    public synchronized boolean SetAvatarSkinToneWithAuto(final float f, final float f2, boolean z2, final OnFittingViewListener onFittingViewListener, final Runnable runnable) {
        Log.d(this.p, "SetAvatarSkinToneWithAuto()+");
        if (!z2) {
            try {
                this.z = f;
                this.y = f2;
                UpdateCustomfaceTexture(f2);
                UpdateSkinTone(f);
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                if (onFittingViewListener != null) {
                    GlobalDefine.Result result = new GlobalDefine.Result();
                    result.resultCode = -3;
                    result.resultExtra = th;
                    onFittingViewListener.OnOccurError(result);
                }
                return false;
            }
        } else if (this.D == null || this.D.a()) {
            Log.d(this.p, "fittingView working.");
            return false;
        } else {
            if (onFittingViewListener != null) {
                onFittingViewListener.OnStartAsyncWork();
            }
            this.z = f;
            this.y = f2;
            final GlobalDefine.Result result2 = new GlobalDefine.Result();
            this.D.a((Runnable) new Runnable() {
                public void run() {
                    try {
                        FittingView.this.UpdateCustomfaceTexture(f2);
                        FittingView.this.UpdateSkinTone(f);
                        result2.resultCode = -1;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        result2.resultCode = -3;
                        result2.resultExtra = th;
                    }
                }
            }, (a.C0022a) new a.C0022a() {
                public void a() {
                    if (onFittingViewListener == null) {
                        return;
                    }
                    if (result2.resultCode == -1) {
                        onFittingViewListener.OnFinishAsyncWork(runnable);
                    } else {
                        onFittingViewListener.OnOccurError(result2);
                    }
                }
            });
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean SetAvatarHeadTypeWithSkinValue(int r5, boolean r6, float r7, float r8, final net.fxgear.FittingView.OnFittingViewListener r9, final java.lang.Runnable r10) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = r4.p     // Catch:{ all -> 0x007c }
            java.lang.String r1 = "SetAvatarHeadTypeWithSkinValue()+"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x007c }
            int r0 = r4.q     // Catch:{ all -> 0x007c }
            r1 = 0
            if (r0 == 0) goto L_0x007a
            android.content.Context r0 = r4.getContext()     // Catch:{ all -> 0x007c }
            int r2 = r4.r     // Catch:{ all -> 0x007c }
            int r3 = r4.s     // Catch:{ all -> 0x007c }
            int r0 = net.fxgear.AvatarSetting.GetHeadTypeCount(r0, r2, r3)     // Catch:{ all -> 0x007c }
            r2 = 1
            if (r5 < 0) goto L_0x0028
            if (r5 >= r0) goto L_0x0028
            if (r6 == 0) goto L_0x0026
            boolean r0 = r4.a()     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0028
        L_0x0026:
            r0 = 1
            goto L_0x0029
        L_0x0028:
            r0 = 0
        L_0x0029:
            if (r0 == 0) goto L_0x0064
            net.fxgear.a r0 = r4.D     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x005c
            net.fxgear.a r0 = r4.D     // Catch:{ all -> 0x007c }
            boolean r0 = r0.a()     // Catch:{ all -> 0x007c }
            if (r0 != 0) goto L_0x005c
            if (r9 == 0) goto L_0x003c
            r9.OnStartAsyncWork()     // Catch:{ all -> 0x007c }
        L_0x003c:
            r4.x = r6     // Catch:{ all -> 0x007c }
            r4.t = r5     // Catch:{ all -> 0x007c }
            r4.y = r7     // Catch:{ all -> 0x007c }
            r4.z = r8     // Catch:{ all -> 0x007c }
            net.fxgear.GlobalDefine$Result r5 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x007c }
            r5.<init>()     // Catch:{ all -> 0x007c }
            r5.resultCode = r1     // Catch:{ all -> 0x007c }
            net.fxgear.a r6 = r4.D     // Catch:{ all -> 0x007c }
            net.fxgear.FittingView$38 r7 = new net.fxgear.FittingView$38     // Catch:{ all -> 0x007c }
            r7.<init>(r5)     // Catch:{ all -> 0x007c }
            net.fxgear.FittingView$39 r8 = new net.fxgear.FittingView$39     // Catch:{ all -> 0x007c }
            r8.<init>(r9, r5, r10)     // Catch:{ all -> 0x007c }
            r6.a((java.lang.Runnable) r7, (net.fxgear.a.C0022a) r8)     // Catch:{ all -> 0x007c }
            monitor-exit(r4)
            return r2
        L_0x005c:
            java.lang.String r5 = r4.p     // Catch:{ all -> 0x007c }
            java.lang.String r6 = "AsyncWorker is working."
            android.util.Log.d(r5, r6)     // Catch:{ all -> 0x007c }
            goto L_0x007a
        L_0x0064:
            java.lang.String r6 = r4.p     // Catch:{ all -> 0x007c }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            r7.<init>()     // Catch:{ all -> 0x007c }
            java.lang.String r8 = "WARNING :: invalid head type - "
            r7.append(r8)     // Catch:{ all -> 0x007c }
            r7.append(r5)     // Catch:{ all -> 0x007c }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x007c }
            android.util.Log.e(r6, r5)     // Catch:{ all -> 0x007c }
        L_0x007a:
            monitor-exit(r4)
            return r1
        L_0x007c:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.SetAvatarHeadTypeWithSkinValue(int, boolean, float, float, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    public synchronized boolean GetScreenShot(int i, int i2, boolean z2, boolean z3, boolean z4, OnFittingViewListener onFittingViewListener, Runnable runnable) {
        final OnFittingViewListener onFittingViewListener2 = onFittingViewListener;
        synchronized (this) {
            Log.d(this.p, "GetScreenShot()+");
            if (this.E != null) {
                if (!this.E.isRecycled()) {
                    this.E.recycle();
                }
                this.E = null;
            }
            if (this.D == null || this.D.a()) {
                Log.d(this.p, "fittingView working.");
                return false;
            }
            if (onFittingViewListener2 != null) {
                onFittingViewListener.OnStartAsyncWork();
            }
            final GlobalDefine.Result result = new GlobalDefine.Result();
            final int i3 = i;
            final int i4 = i2;
            final boolean z5 = z3;
            final boolean z6 = z2;
            final boolean z7 = z4;
            final GlobalDefine.Result result2 = result;
            final Runnable runnable2 = runnable;
            this.D.a((Runnable) new Runnable() {
                public void run() {
                    try {
                        Bitmap unused = FittingView.this.E = FittingView.this.GetScreenShot(i3, i4, z5, z6, z7);
                        result2.resultCode = -1;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        result2.resultCode = -3;
                        result2.resultExtra = th;
                    }
                }
            }, (a.C0022a) new a.C0022a() {
                public void a() {
                    if (onFittingViewListener2 == null) {
                        return;
                    }
                    if (result.resultCode == -1) {
                        onFittingViewListener2.OnFinishAsyncWork(runnable2);
                    } else {
                        onFittingViewListener2.OnOccurError(result);
                    }
                }
            });
            return true;
        }
    }

    public synchronized boolean SetAvatarSkinToneWithChangeAvatarMode(int i, float f, float f2, OnFittingViewListener onFittingViewListener, Runnable runnable) {
        Log.d(this.p, "SetAvatarSkinToneWithChangeAvatarMode()+");
        if (i != 0) {
            if (this.q != 0) {
                this.y = f;
                this.z = f2;
                int i2 = this.t;
                int i3 = this.u;
                boolean z2 = this.x;
                AvatarSetting avatarSetting = this.C;
                return a(i, i2, i3, z2, AvatarSetting.a(), onFittingViewListener, runnable);
            }
        }
        Log.e(this.p, "WARNING :: illegalState - wrong mode.");
        return false;
    }

    private void a(int i, int i2, BodySizeData bodySizeData) {
        if (this.C != null && bodySizeData != null) {
            this.C.SetCharacter(i, i2);
            this.C.SetValueOfBodyPart(0, (double) bodySizeData.mTallSize);
            this.C.SetValueOfBodyPart(5, (double) bodySizeData.mUpperSize);
            this.C.SetValueOfBodyPart(6, (double) bodySizeData.mLowerSize);
            this.C.SetValueOfBodyPart(1, (double) bodySizeData.mShoulderSize);
            this.C.SetValueOfBodyPart(7, (double) bodySizeData.mBustSize);
            this.C.SetValueOfBodyPart(8, (double) bodySizeData.mCupSize);
            this.C.SetValueOfBodyPart(9, (double) bodySizeData.mWaistSize);
            this.C.SetValueOfBodyPart(11, (double) bodySizeData.mHipSize);
            this.C.SetValueOfBodyPart(2, (double) bodySizeData.mArmLengthSize);
            this.C.SetValueOfBodyPart(10, (double) bodySizeData.mArmThickSize);
            this.C.SetValueOfBodyPart(3, (double) bodySizeData.mThighLengthSize);
            this.C.SetValueOfBodyPart(12, (double) bodySizeData.mThighThickSize);
            this.C.SetValueOfBodyPart(4, (double) bodySizeData.mCalfLengthSize);
            this.C.SetValueOfBodyPart(14, (double) bodySizeData.mHeadHeight);
        }
    }
}
