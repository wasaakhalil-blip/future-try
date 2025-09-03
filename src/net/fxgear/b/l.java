package net.fxgear.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import net.fxgear.GlobalDefine;
import net.fxgear.b.h;

/* compiled from: FXNativeImporter */
public class l {

    /* compiled from: FXNativeImporter */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f699a;

        /* renamed from: b  reason: collision with root package name */
        public int f700b;
        public byte[] c;
        public byte[] d;
        public byte[] e;
        public byte[] f;
        public Bitmap g;
        public Bitmap h;
    }

    public static int a(int i) {
        switch (i) {
            case 0:
                return 66;
            case 1:
                return 61;
            case 2:
                return 89;
            case 3:
                return 75;
            case 4:
                return 71;
            case 5:
                return 24;
            case 6:
                return 26;
            case 7:
                return 27;
            case 8:
                return 70;
            case 9:
                return 0;
            case 10:
                return 2;
            case 11:
                return 3;
            case 12:
                return 68;
            case GlobalDefine.RESULT_CODE_ERROR_MALFORMEDURL:
                return 55;
            case 14:
                return 52;
            case GlobalDefine.RESULT_CODE_ERROR_OUT_OF_MEMORY:
                return 53;
            case GlobalDefine.RESULT_CODE_ERROR_NOT_FOUND_FILE:
                return 67;
            case GlobalDefine.RESULT_CODE_ERROR_FAILED_TO_SAVE_BITMAP:
                return 51;
            case GlobalDefine.RESULT_CODE_ERROR_FAILED_TO_DETECT:
                return 48;
            case GlobalDefine.RESULT_CODE_ERROR_FAILED_TO_DETECT_WITH_LOW_SCROE:
                return 49;
            case GlobalDefine.RESULT_CODE_ERROR_FAILED_TO_DETECT_ZERO_FACE:
                return 72;
            case 21:
                return -1;
            case 22:
                return -1;
            case 23:
                return -1;
            case 24:
                return -1;
            default:
                return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0086 A[SYNTHETIC, Splitter:B:40:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008b A[Catch:{ IOException -> 0x0049 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x009e A[SYNTHETIC, Splitter:B:50:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a3 A[Catch:{ IOException -> 0x0049 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00b6 A[SYNTHETIC, Splitter:B:60:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00bb A[Catch:{ IOException -> 0x0049 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ce A[SYNTHETIC, Splitter:B:70:0x00ce] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d3 A[Catch:{ IOException -> 0x0049 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00da A[Catch:{ IOException -> 0x0049 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00df A[Catch:{ IOException -> 0x0049 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:47:0x0092=Splitter:B:47:0x0092, B:67:0x00c2=Splitter:B:67:0x00c2, B:37:0x007a=Splitter:B:37:0x007a, B:57:0x00aa=Splitter:B:57:0x00aa} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int[] a(java.lang.String r8) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00bf, IOException -> 0x00a7, OutOfMemoryError -> 0x008f, Exception -> 0x0077, all -> 0x0073 }
            r1.<init>(r8)     // Catch:{ FileNotFoundException -> 0x00bf, IOException -> 0x00a7, OutOfMemoryError -> 0x008f, Exception -> 0x0077, all -> 0x0073 }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00bf, IOException -> 0x00a7, OutOfMemoryError -> 0x008f, Exception -> 0x0077, all -> 0x0073 }
            r8.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0070, IOException -> 0x006d, OutOfMemoryError -> 0x006a, Exception -> 0x0067, all -> 0x0063 }
            java.nio.channels.FileChannel r2 = r8.getChannel()     // Catch:{ FileNotFoundException -> 0x0070, IOException -> 0x006d, OutOfMemoryError -> 0x006a, Exception -> 0x0067, all -> 0x0063 }
            long r3 = r1.length()     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            int r1 = (int) r3     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            r1.order(r3)     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            r2.read(r1)     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            r1.rewind()     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            int r3 = r1.getInt()     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            int[] r4 = new int[r3]     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            r5 = 0
        L_0x002a:
            if (r5 >= r3) goto L_0x0043
            int r6 = r1.getInt()     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            byte[] r6 = new byte[r6]     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            r1.get(r6)     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            java.lang.String r7 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            r7.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            int r6 = d(r7)     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            r4[r5] = r6     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            int r5 = r5 + 1
            goto L_0x002a
        L_0x0043:
            if (r2 == 0) goto L_0x004b
            r2.close()     // Catch:{ IOException -> 0x0049 }
            goto L_0x004b
        L_0x0049:
            r8 = move-exception
            goto L_0x004f
        L_0x004b:
            r8.close()     // Catch:{ IOException -> 0x0049 }
            return r4
        L_0x004f:
            r8.printStackTrace()
            java.lang.String r8 = "FXNativeImporter : "
            java.lang.String r1 = "BoneLoader - Load io xxception"
            android.util.Log.w(r8, r1)
            return r0
        L_0x005a:
            r1 = move-exception
            goto L_0x007a
        L_0x005c:
            r1 = move-exception
            goto L_0x0092
        L_0x005e:
            r1 = move-exception
            goto L_0x00aa
        L_0x0060:
            r1 = move-exception
            goto L_0x00c2
        L_0x0063:
            r1 = move-exception
            r2 = r0
            goto L_0x00d8
        L_0x0067:
            r1 = move-exception
            r2 = r0
            goto L_0x007a
        L_0x006a:
            r1 = move-exception
            r2 = r0
            goto L_0x0092
        L_0x006d:
            r1 = move-exception
            r2 = r0
            goto L_0x00aa
        L_0x0070:
            r1 = move-exception
            r2 = r0
            goto L_0x00c2
        L_0x0073:
            r1 = move-exception
            r8 = r0
            r2 = r8
            goto L_0x00d8
        L_0x0077:
            r1 = move-exception
            r8 = r0
            r2 = r8
        L_0x007a:
            r1.printStackTrace()     // Catch:{ all -> 0x00d7 }
            java.lang.String r1 = "FXNativeImporter : "
            java.lang.String r3 = "BoneLoader - Error unknow"
            android.util.Log.w(r1, r3)     // Catch:{ all -> 0x00d7 }
            if (r2 == 0) goto L_0x0089
            r2.close()     // Catch:{ IOException -> 0x0049 }
        L_0x0089:
            if (r8 == 0) goto L_0x008e
            r8.close()     // Catch:{ IOException -> 0x0049 }
        L_0x008e:
            return r0
        L_0x008f:
            r1 = move-exception
            r8 = r0
            r2 = r8
        L_0x0092:
            r1.printStackTrace()     // Catch:{ all -> 0x00d7 }
            java.lang.String r1 = "FXNativeImporter : "
            java.lang.String r3 = "BoneLoader - Out of memory"
            android.util.Log.w(r1, r3)     // Catch:{ all -> 0x00d7 }
            if (r2 == 0) goto L_0x00a1
            r2.close()     // Catch:{ IOException -> 0x0049 }
        L_0x00a1:
            if (r8 == 0) goto L_0x00a6
            r8.close()     // Catch:{ IOException -> 0x0049 }
        L_0x00a6:
            return r0
        L_0x00a7:
            r1 = move-exception
            r8 = r0
            r2 = r8
        L_0x00aa:
            r1.printStackTrace()     // Catch:{ all -> 0x00d7 }
            java.lang.String r1 = "FXNativeImporter : "
            java.lang.String r3 = "BoneLoader - Load io xxception"
            android.util.Log.w(r1, r3)     // Catch:{ all -> 0x00d7 }
            if (r2 == 0) goto L_0x00b9
            r2.close()     // Catch:{ IOException -> 0x0049 }
        L_0x00b9:
            if (r8 == 0) goto L_0x00be
            r8.close()     // Catch:{ IOException -> 0x0049 }
        L_0x00be:
            return r0
        L_0x00bf:
            r1 = move-exception
            r8 = r0
            r2 = r8
        L_0x00c2:
            r1.printStackTrace()     // Catch:{ all -> 0x00d7 }
            java.lang.String r1 = "FXNativeImporter : "
            java.lang.String r3 = "BoneLoader - File not found"
            android.util.Log.w(r1, r3)     // Catch:{ all -> 0x00d7 }
            if (r2 == 0) goto L_0x00d1
            r2.close()     // Catch:{ IOException -> 0x0049 }
        L_0x00d1:
            if (r8 == 0) goto L_0x00d6
            r8.close()     // Catch:{ IOException -> 0x0049 }
        L_0x00d6:
            return r0
        L_0x00d7:
            r1 = move-exception
        L_0x00d8:
            if (r2 == 0) goto L_0x00dd
            r2.close()     // Catch:{ IOException -> 0x0049 }
        L_0x00dd:
            if (r8 == 0) goto L_0x00e2
            r8.close()     // Catch:{ IOException -> 0x0049 }
        L_0x00e2:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.b.l.a(java.lang.String):int[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x008e A[SYNTHETIC, Splitter:B:42:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0093 A[Catch:{ IOException -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a6 A[SYNTHETIC, Splitter:B:52:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ab A[Catch:{ IOException -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00be A[SYNTHETIC, Splitter:B:62:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c3 A[Catch:{ IOException -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00d6 A[SYNTHETIC, Splitter:B:72:0x00d6] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00db A[Catch:{ IOException -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e2 A[Catch:{ IOException -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e7 A[Catch:{ IOException -> 0x0051 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:39:0x0082=Splitter:B:39:0x0082, B:59:0x00b2=Splitter:B:59:0x00b2, B:49:0x009a=Splitter:B:49:0x009a, B:69:0x00ca=Splitter:B:69:0x00ca} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<java.lang.String> b(java.lang.String r8) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00c7, IOException -> 0x00af, OutOfMemoryError -> 0x0097, Exception -> 0x007f, all -> 0x007b }
            r2.<init>(r8)     // Catch:{ FileNotFoundException -> 0x00c7, IOException -> 0x00af, OutOfMemoryError -> 0x0097, Exception -> 0x007f, all -> 0x007b }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00c7, IOException -> 0x00af, OutOfMemoryError -> 0x0097, Exception -> 0x007f, all -> 0x007b }
            r8.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x0075, OutOfMemoryError -> 0x0072, Exception -> 0x006f, all -> 0x006b }
            java.nio.channels.FileChannel r3 = r8.getChannel()     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x0075, OutOfMemoryError -> 0x0072, Exception -> 0x006f, all -> 0x006b }
            long r4 = r2.length()     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            int r2 = (int) r4     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r2)     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            r2.order(r4)     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            r3.read(r2)     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            r2.rewind()     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            int r4 = r2.getInt()     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            r5 = 0
        L_0x002d:
            if (r5 >= r4) goto L_0x004b
            int r6 = r2.getInt()     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            byte[] r6 = new byte[r6]     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            r2.get(r6)     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            java.lang.String r7 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            r7.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            java.lang.String r6 = "zHairAni"
            boolean r6 = r7.contains(r6)     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            if (r6 == 0) goto L_0x0048
            r0.add(r7)     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
        L_0x0048:
            int r5 = r5 + 1
            goto L_0x002d
        L_0x004b:
            if (r3 == 0) goto L_0x0053
            r3.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0053
        L_0x0051:
            r8 = move-exception
            goto L_0x0057
        L_0x0053:
            r8.close()     // Catch:{ IOException -> 0x0051 }
            return r0
        L_0x0057:
            r8.printStackTrace()
            java.lang.String r8 = "FXNativeImporter : "
            java.lang.String r0 = "BoneLoader - Load io xxception"
            android.util.Log.w(r8, r0)
            return r1
        L_0x0062:
            r0 = move-exception
            goto L_0x0082
        L_0x0064:
            r0 = move-exception
            goto L_0x009a
        L_0x0066:
            r0 = move-exception
            goto L_0x00b2
        L_0x0068:
            r0 = move-exception
            goto L_0x00ca
        L_0x006b:
            r0 = move-exception
            r3 = r1
            goto L_0x00e0
        L_0x006f:
            r0 = move-exception
            r3 = r1
            goto L_0x0082
        L_0x0072:
            r0 = move-exception
            r3 = r1
            goto L_0x009a
        L_0x0075:
            r0 = move-exception
            r3 = r1
            goto L_0x00b2
        L_0x0078:
            r0 = move-exception
            r3 = r1
            goto L_0x00ca
        L_0x007b:
            r0 = move-exception
            r8 = r1
            r3 = r8
            goto L_0x00e0
        L_0x007f:
            r0 = move-exception
            r8 = r1
            r3 = r8
        L_0x0082:
            r0.printStackTrace()     // Catch:{ all -> 0x00df }
            java.lang.String r0 = "FXNativeImporter : "
            java.lang.String r2 = "BoneLoader - Error unknow"
            android.util.Log.w(r0, r2)     // Catch:{ all -> 0x00df }
            if (r3 == 0) goto L_0x0091
            r3.close()     // Catch:{ IOException -> 0x0051 }
        L_0x0091:
            if (r8 == 0) goto L_0x0096
            r8.close()     // Catch:{ IOException -> 0x0051 }
        L_0x0096:
            return r1
        L_0x0097:
            r0 = move-exception
            r8 = r1
            r3 = r8
        L_0x009a:
            r0.printStackTrace()     // Catch:{ all -> 0x00df }
            java.lang.String r0 = "FXNativeImporter : "
            java.lang.String r2 = "BoneLoader - Out of memory"
            android.util.Log.w(r0, r2)     // Catch:{ all -> 0x00df }
            if (r3 == 0) goto L_0x00a9
            r3.close()     // Catch:{ IOException -> 0x0051 }
        L_0x00a9:
            if (r8 == 0) goto L_0x00ae
            r8.close()     // Catch:{ IOException -> 0x0051 }
        L_0x00ae:
            return r1
        L_0x00af:
            r0 = move-exception
            r8 = r1
            r3 = r8
        L_0x00b2:
            r0.printStackTrace()     // Catch:{ all -> 0x00df }
            java.lang.String r0 = "FXNativeImporter : "
            java.lang.String r2 = "BoneLoader - Load io xxception"
            android.util.Log.w(r0, r2)     // Catch:{ all -> 0x00df }
            if (r3 == 0) goto L_0x00c1
            r3.close()     // Catch:{ IOException -> 0x0051 }
        L_0x00c1:
            if (r8 == 0) goto L_0x00c6
            r8.close()     // Catch:{ IOException -> 0x0051 }
        L_0x00c6:
            return r1
        L_0x00c7:
            r0 = move-exception
            r8 = r1
            r3 = r8
        L_0x00ca:
            r0.printStackTrace()     // Catch:{ all -> 0x00df }
            java.lang.String r0 = "FXNativeImporter : "
            java.lang.String r2 = "BoneLoader - File not found"
            android.util.Log.w(r0, r2)     // Catch:{ all -> 0x00df }
            if (r3 == 0) goto L_0x00d9
            r3.close()     // Catch:{ IOException -> 0x0051 }
        L_0x00d9:
            if (r8 == 0) goto L_0x00de
            r8.close()     // Catch:{ IOException -> 0x0051 }
        L_0x00de:
            return r1
        L_0x00df:
            r0 = move-exception
        L_0x00e0:
            if (r3 == 0) goto L_0x00e5
            r3.close()     // Catch:{ IOException -> 0x0051 }
        L_0x00e5:
            if (r8 == 0) goto L_0x00ea
            r8.close()     // Catch:{ IOException -> 0x0051 }
        L_0x00ea:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.b.l.b(java.lang.String):java.util.ArrayList");
    }

    public static p a(String str, String str2, int i, int[] iArr) {
        p pVar = new p();
        ArrayList arrayList = new ArrayList();
        i iVar = new i();
        for (int i2 = 0; i2 < iArr.length; i2++) {
            arrayList.add(iVar);
        }
        a((ArrayList<i>) arrayList, str, iArr);
        b(arrayList, str2, iArr);
        pVar.b((ArrayList<i>) arrayList);
        pVar.c(i);
        return pVar;
    }

    public static p a(String str, String str2, int i, ArrayList<String> arrayList) {
        p pVar = new p();
        ArrayList arrayList2 = new ArrayList();
        i iVar = new i();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(iVar);
        }
        a((ArrayList<i>) arrayList2, str, str2, arrayList);
        pVar.b((ArrayList<i>) arrayList2);
        pVar.c(i);
        return pVar;
    }

    public static d a(String str, int i, p pVar, boolean z) {
        d dVar = new d();
        a(dVar, str, i, pVar, z);
        return dVar;
    }

    public static k a(ArrayList<i> arrayList, String str, p pVar, int[] iArr, float[] fArr, short[] sArr, float[] fArr2, Bitmap bitmap, h.d dVar) {
        k kVar = new k();
        a(kVar, arrayList, str, pVar, iArr, fArr, sArr, fArr2, bitmap, dVar);
        return kVar;
    }

    public static f c(String str) {
        f fVar = new f();
        a(fVar, str);
        return fVar;
    }

    public static f a(String str, int[] iArr) {
        f fVar = new f();
        if (iArr == null) {
            Log.e("FXNativeImporter : ", "Converting Table is required when loading bone blend targets. convertingTable : " + iArr);
        }
        a(fVar, str, iArr);
        return fVar;
    }

    public static Bitmap a(Bitmap bitmap) {
        Bitmap.Config config;
        if (bitmap == null || (config = bitmap.getConfig()) == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444 || config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.ALPHA_8) {
            return bitmap;
        }
        Log.i("FXNativeImporter : ", "[c] CheckBitmapNConvert convert " + config);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(bitmap, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, new Paint());
        bitmap.recycle();
        return createBitmap;
    }

    public static Bitmap a(String str, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = a(options, i);
        options.inJustDecodeBounds = false;
        options.inScaled = true;
        options.inPreferQualityOverSpeed = true;
        return a(BitmapFactory.decodeFile(str, options));
    }

    private static int a(BitmapFactory.Options options, int i) {
        int max = Math.max(options.outWidth, options.outHeight);
        int i2 = 1;
        if (max > i) {
            while (i < max / i2) {
                i2 *= 2;
            }
        }
        Log.i("FXNativeImporter : ", "calculateInSampleSize : " + i2);
        return i2;
    }

    public static a b(String str, int i) {
        GLES20.glGenTextures(1, new int[1], 0);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferQualityOverSpeed = true;
        options.inScaled = true;
        options.inSampleSize = 1;
        a e = e(str);
        e.g = BitmapFactory.decodeByteArray(e.d, 0, e.d.length, options);
        int max = Math.max(e.g.getWidth(), e.g.getHeight());
        if (max > i) {
            int i2 = 2;
            while (i < max / i2) {
                i2 *= 2;
            }
            e.g.recycle();
            e.g = null;
            options.inScaled = true;
            options.inSampleSize = i2;
            Log.i("FXNativeImporter : ", "SamplingRate is modified to : " + i2);
            e.g = BitmapFactory.decodeByteArray(e.d, 0, e.d.length, options);
        }
        if (e.e != null) {
            e.h = BitmapFactory.decodeByteArray(e.e, 0, e.e.length, options);
            if (!(e.g.getWidth() == e.h.getWidth() && e.g.getHeight() == e.h.getHeight())) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(e.h, e.g.getWidth(), e.g.getHeight(), false);
                e.h.recycle();
                e.h = null;
                e.h = createScaledBitmap;
            }
        }
        return e;
    }

    public static int a(Bitmap bitmap, int i) {
        int max = Math.max(bitmap.getWidth(), bitmap.getHeight());
        if (max > i) {
            int i2 = 2;
            while (i < max / i2) {
                i2 *= 2;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / i2, bitmap.getHeight() / i2, false);
            bitmap.recycle();
            bitmap = createScaledBitmap;
        }
        Bitmap a2 = a(bitmap);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLUtils.texImage2D(3553, 0, a2, 0);
        GLES20.glBindTexture(3553, 0);
        Log.i("FXNativeImporter : ", "Texture is generated : " + iArr[0]);
        return iArr[0];
    }

    public static int a() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        if (iArr[0] >= 0) {
            return iArr[0];
        }
        Log.e("FXNativeImporter : ", "Generating video texture is failed");
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:112:? A[Catch:{ IOException -> 0x014c }, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0186 A[SYNTHETIC, Splitter:B:59:0x0186] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x018b A[Catch:{ IOException -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x019d A[SYNTHETIC, Splitter:B:68:0x019d] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01a2 A[Catch:{ IOException -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01b4 A[SYNTHETIC, Splitter:B:77:0x01b4] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01b9 A[Catch:{ IOException -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01cb A[SYNTHETIC, Splitter:B:86:0x01cb] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01d0 A[Catch:{ IOException -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01d8 A[Catch:{ IOException -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01dd A[Catch:{ IOException -> 0x014c }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:65:0x0191=Splitter:B:65:0x0191, B:74:0x01a8=Splitter:B:74:0x01a8, B:56:0x017a=Splitter:B:56:0x017a, B:83:0x01bf=Splitter:B:83:0x01bf} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.util.ArrayList<net.fxgear.b.i> r11, java.lang.String r12, int[] r13) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ FileNotFoundException -> 0x01bd, IOException -> 0x01a6, OutOfMemoryError -> 0x018f, Exception -> 0x0178, all -> 0x0174 }
            r1.<init>(r12)     // Catch:{ FileNotFoundException -> 0x01bd, IOException -> 0x01a6, OutOfMemoryError -> 0x018f, Exception -> 0x0178, all -> 0x0174 }
            java.io.FileInputStream r12 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x01bd, IOException -> 0x01a6, OutOfMemoryError -> 0x018f, Exception -> 0x0178, all -> 0x0174 }
            r12.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0172, IOException -> 0x0170, OutOfMemoryError -> 0x016e, Exception -> 0x016c }
            java.nio.channels.FileChannel r2 = r12.getChannel()     // Catch:{ FileNotFoundException -> 0x0172, IOException -> 0x0170, OutOfMemoryError -> 0x016e, Exception -> 0x016c }
            long r0 = r1.length()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            int r0 = (int) r0     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r0)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.nio.ByteOrder r1 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r0.order(r1)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r2.read(r0)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r0.rewind()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            int r1 = r0.getInt()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r3 = 0
            r4 = 0
        L_0x0029:
            if (r4 >= r1) goto L_0x0049
            r5 = r13[r4]     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            net.fxgear.b.i r6 = new net.fxgear.b.i     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r6.<init>()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            int r7 = r0.getInt()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            byte[] r7 = new byte[r7]     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r0.get(r7)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.lang.String r8 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r8.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r6.a((java.lang.String) r8)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r11.set(r5, r6)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            int r4 = r4 + 1
            goto L_0x0029
        L_0x0049:
            r4 = 0
        L_0x004a:
            if (r4 >= r1) goto L_0x008f
            r5 = r13[r4]     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            int r6 = r0.getInt()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            byte[] r6 = new byte[r6]     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r0.get(r6)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.lang.String r7 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r7.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            int r6 = a((java.util.ArrayList<net.fxgear.b.i>) r11, (java.lang.String) r7)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.lang.Object r7 = r11.get(r5)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            net.fxgear.b.i r7 = (net.fxgear.b.i) r7     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r7.a((int) r6)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r7 = -1
            if (r6 == r7) goto L_0x0076
            java.lang.Object r6 = r11.get(r6)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            net.fxgear.b.i r6 = (net.fxgear.b.i) r6     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r6.b((int) r5)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            goto L_0x008c
        L_0x0076:
            java.lang.String r6 = "FXNativeImporter : "
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r7.<init>()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.lang.String r8 = "Find Root : "
            r7.append(r8)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r7.append(r5)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.lang.String r5 = r7.toString()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            android.util.Log.i(r6, r5)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
        L_0x008c:
            int r4 = r4 + 1
            goto L_0x004a
        L_0x008f:
            r4 = 0
        L_0x0090:
            r5 = 2
            r6 = 3
            r7 = 1
            if (r4 >= r1) goto L_0x00c4
            r8 = r13[r4]     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float[] r6 = new float[r6]     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float r9 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r6[r3] = r9     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float r9 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r6[r7] = r9     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float r7 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r6[r5] = r7     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.lang.Object r5 = r11.get(r8)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            net.fxgear.b.i r5 = (net.fxgear.b.i) r5     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r5.b((float[]) r6)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            net.fxgear.b.q r5 = a((float[]) r6)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.lang.Object r6 = r11.get(r8)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            net.fxgear.b.i r6 = (net.fxgear.b.i) r6     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r6.b((net.fxgear.b.q) r5)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            int r4 = r4 + 1
            goto L_0x0090
        L_0x00c4:
            r4 = 0
        L_0x00c5:
            if (r4 >= r1) goto L_0x00e9
            r8 = r13[r4]     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float[] r9 = new float[r6]     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float r10 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r9[r3] = r10     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float r10 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r9[r7] = r10     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float r10 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r9[r5] = r10     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.lang.Object r8 = r11.get(r8)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            net.fxgear.b.i r8 = (net.fxgear.b.i) r8     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r8.c((float[]) r9)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            int r4 = r4 + 1
            goto L_0x00c5
        L_0x00e9:
            r12 = move-exception
            goto L_0x00f7
        L_0x00eb:
            r12 = move-exception
            goto L_0x010e
        L_0x00ed:
            r12 = move-exception
            goto L_0x0125
        L_0x00ef:
            r12 = move-exception
            goto L_0x013c
        L_0x00f1:
            r12 = move-exception
            r13 = r0
            r2 = r13
            goto L_0x0153
        L_0x00f5:
            r12 = move-exception
            r13 = r0
        L_0x00f7:
            r12.printStackTrace()     // Catch:{ all -> 0x0151 }
            java.lang.String r12 = "FXNativeImporter : "
            java.lang.String r14 = "BoneLoader - Error unknow"
            android.util.Log.w(r12, r14)     // Catch:{ all -> 0x0151 }
            if (r0 == 0) goto L_0x0106
            r0.close()     // Catch:{ IOException -> 0x00c9 }
        L_0x0106:
            if (r13 == 0) goto L_0x010b
            r13.close()     // Catch:{ IOException -> 0x00c9 }
        L_0x010b:
            return
        L_0x010c:
            r12 = move-exception
            r13 = r0
        L_0x010e:
            r12.printStackTrace()     // Catch:{ all -> 0x0151 }
            java.lang.String r12 = "FXNativeImporter : "
            java.lang.String r14 = "BoneLoader - Out of memory"
            android.util.Log.w(r12, r14)     // Catch:{ all -> 0x0151 }
            if (r0 == 0) goto L_0x011d
            r0.close()     // Catch:{ IOException -> 0x00c9 }
        L_0x011d:
            if (r13 == 0) goto L_0x0122
            r13.close()     // Catch:{ IOException -> 0x00c9 }
        L_0x0122:
            return
        L_0x0123:
            r12 = move-exception
            r13 = r0
        L_0x0125:
            r12.printStackTrace()     // Catch:{ all -> 0x0151 }
            java.lang.String r12 = "FXNativeImporter : "
            java.lang.String r14 = "BoneLoader - Load io xxception"
            android.util.Log.w(r12, r14)     // Catch:{ all -> 0x0151 }
            if (r0 == 0) goto L_0x0134
            r0.close()     // Catch:{ IOException -> 0x00c9 }
        L_0x0134:
            if (r13 == 0) goto L_0x0139
            r13.close()     // Catch:{ IOException -> 0x00c9 }
        L_0x0139:
            return
        L_0x013a:
            r12 = move-exception
            r13 = r0
        L_0x013c:
            r12.printStackTrace()     // Catch:{ all -> 0x0151 }
            java.lang.String r12 = "FXNativeImporter : "
            java.lang.String r14 = "BoneLoader - File not found"
            android.util.Log.w(r12, r14)     // Catch:{ all -> 0x0151 }
            if (r0 == 0) goto L_0x014b
            r0.close()     // Catch:{ IOException -> 0x00c9 }
        L_0x014b:
            if (r13 == 0) goto L_0x0150
            r13.close()     // Catch:{ IOException -> 0x00c9 }
        L_0x0150:
            return
        L_0x0151:
            r12 = move-exception
            r2 = r0
        L_0x0153:
            if (r2 == 0) goto L_0x0158
            r2.close()     // Catch:{ IOException -> 0x00c9 }
        L_0x0158:
            if (r13 == 0) goto L_0x015d
            r13.close()     // Catch:{ IOException -> 0x00c9 }
        L_0x015d:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.b.l.a(net.fxgear.b.f, java.lang.String, int[]):void");
    }
}
