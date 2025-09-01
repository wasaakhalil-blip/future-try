

// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\util\FXDataManager.java ==========

package net.fxgear.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import net.fxgear.AvatarData;
import net.fxgear.AvatarSetting;
import net.fxgear.BodySizeData;
import net.fxgear.GlobalDefine;

public class FXDataManager {
    public static final int TABLE_TYPE_CLOTH = 10;
    public static final int TABLE_TYPE_REAL = 11;
    public static final String TAG = "FXDataManager";
    private static FXDataManager d;
    /* access modifiers changed from: private */
    public static Object e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final String f1518a = "%s = ?";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f1519b;
    private a c;

    private FXDataManager(Context context) {
        Log.i(TAG, "FXDataManager()");
        this.f1519b = context;
        this.c = new a(context, "fxDatadb.db", (SQLiteDatabase.CursorFactory) null, 3);
    }

    public static FXDataManager GetInstance(Context context) {
        synchronized (e) {
            if (d == null || d.f1519b == null) {
                d = new FXDataManager(context);
            }
        }
        return d;
    }

    public void Destroy() {
        synchronized (e) {
            if (this.c != null) {
                this.c.close();
                this.c = null;
            }
        }
        this.f1519b = null;
    }

    public int AddAvatarData(AvatarData avatarData) {
        if (this.c != null) {
            return this.c.a(this.c.getWritableDatabase(), avatarData);
        }
        Log.i(TAG, "AddAvatarData(), mFXDataDBHelper is null");
        return -1;
    }

    public int AddAvatarData(int i, int i2, int i3, int i4) {
        if (this.c != null) {
            AvatarData avatarData = new AvatarData();
            avatarData.mGender = i;
            avatarData.mAge = i2;
            avatarData.mFolderName = System.currentTimeMillis() + "";
            avatarData.mHairType = i3;
            avatarData.mHeadType = i4;
            avatarData.mIsCustomFace = false;
            avatarData.mAutoNormalizedColor = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            avatarData.mHueRGBColor = -1;
            avatarData.mBodyData = AvatarSetting.GetBodySizeData(this.f1519b, i, i2, AvatarSetting.NO_VALUE, AvatarSetting.NO_VALUE, (float[]) null, AvatarSetting.NO_VALUE);
            return this.c.a(this.c.getWritableDatabase(), avatarData);
        }
        Log.i(TAG, "AddAvatarData(), mFXDataDBHelper is null");
        return -1;
    }

    public boolean UpdateAvatarData(AvatarData avatarData) {
        if (this.c != null) {
            return this.c.b(this.c.getWritableDatabase(), avatarData);
        }
        Log.i(TAG, "UpdateAvatarData(), mFXDataDBHelper is null");
        return false;
    }

    public void RemoveAvatarData(int i) {
        Log.i(TAG, "RemoveAvatarData(), avatarId = " + i);
        if (this.c != null) {
            AvatarData GetAvatarData = GetAvatarData(i);
            if (!this.c.a(this.c.getWritableDatabase(), i) || GetAvatarData == null) {
                Log.i(TAG, "RemoveAvatarData(), avatarData is null");
            } else {
                GlobalDefine.DeleteDirectoryRecursive(GlobalDefine.GetAvatarDataDirectory(this.f1519b, GetAvatarData.mGender, GetAvatarData.mAge, GetAvatarData.mFolderName).getAbsolutePath());
            }
        } else {
            Log.i(TAG, "RemoveAvatarData(), mFXDataDBHelper is null");
        }
    }

    public ArrayList<AvatarData> GetAllAvatarDataList() {
        if (this.c != null) {
            return this.c.a(this.c.getWritableDatabase());
        }
        Log.i(TAG, "GetAllAvatarDataList(), mFXDataDBHelper is null");
        return null;
    }

    public ArrayList<AvatarData> GetAvatarDataList(int i, int i2) {
        if (this.c != null) {
            return this.c.a(this.c.getWritableDatabase(), i, i2);
        }
        Log.i(TAG, "GetAvatarDataList(), mFXDataDBHelper is null");
        return null;
    }

    public AvatarData GetAvatarData(int i) {
        if (this.c != null) {
            return this.c.b(this.c.getWritableDatabase(), i);
        }
        Log.i(TAG, "GetAvatarData(), mFXDataDBHelper is null");
        return null;
    }

    public boolean HasThumbnailFile(int i) {
        return new File(GetAvatarData(i).mThumbnailPath).exists();
    }

    public String GetFXDBPath() {
        return this.c.getWritableDatabase().getPath();
    }

    public String GetTableName(int i) {
        String str;
        switch (i) {
            case 10:
                str = "cloth";
                break;
            case 11:
                str = "real";
                break;
            default:
                Log.e(TAG, "wrong table type: " + i);
                return null;
        }
        if (this.c != null) {
            return this.c.a(this.c.getWritableDatabase(), str);
        }
        return null;
    }

    public void DropTable(int i) {
        String str;
        switch (i) {
            case 10:
                str = "cloth";
                break;
            case 11:
                str = "real";
                break;
            default:
                Log.e(TAG, "wrong table type: " + i);
                return;
        }
        if (this.c != null) {
            this.c.b(this.c.getWritableDatabase(), str);
        }
    }

    private class a extends SQLiteOpenHelper {
        private final String A = "body_hip";
        private final String B = "body_arm_length";
        private final String C = "body_arm_thick";
        private final String D = "body_tight_length";
        private final String E = "body_tight_thick";
        private final String F = "body_calf_length";
        private final String G = "body_head_height";
        private final int H = 0;
        private final int I = 1;
        private final int J = 2;
        private final int K = 3;
        private final int L = 4;
        private final int M = 5;
        private final int N = 6;
        private final int O = 7;
        private final int P = 8;
        private final int Q = 9;
        private final int R = 10;
        private final int S = 11;
        private final int T = 12;
        private final int U = 13;
        private final int V = 14;
        private final int W = 15;
        private final int X = 16;
        private final int Y = 17;
        private final int Z = 18;
        private final int aa = 19;
        private final int ab = 20;
        private final int ac = 21;
        private final int ad = 22;
        private final String ae = "CREATE TABLE avatar(id INTEGER PRIMARY KEY AUTOINCREMENT, gender INTEGER, age INTEGER, folder_name TEXT, hair_type INTEGER, head_type INTEGER, is_custom_face INTEGER, auto_normalized_color REAL, hue_rgb_color INTEGER, body_tall REAL, body_upper REAL, body_lower REAL, body_shoulder REAL, body_bust REAL, body_cup REAL, body_waist REAL, body_hip REAL, body_arm_length REAL, body_arm_thick REAL, body_tight_length REAL, body_tight_thick REAL, body_calf_length REAL, body_head_height REAL);";

        /* renamed from: b  reason: collision with root package name */
        private final String f1521b = "FXDataDBHelper";
        private final String c = "ASC";
        private final String d = "DESC";
        private final String e = "id";
        private final String f = "animation_url";
        private final String g = "video_url";
        private final String h = "capture_url";
        private final String i = "background_url";
        private final String j = "avatar";
        private final String k = "id";
        private final String l = "gender";
        private final String m = "age";
        private final String n = "folder_name";
        private final String o = "hair_type";
        private final String p = "head_type";
        private final String q = "is_custom_face";
        private final String r = "auto_normalized_color";
        private final String s = "hue_rgb_color";
        private final String t = "body_tall";
        private final String u = "body_upper";
        private final String v = "body_lower";
        private final String w = "body_shoulder";
        private final String x = "body_bust";
        private final String y = "body_cup";
        private final String z = "body_waist";

        public a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
            super(context, str, cursorFactory, i2);
            Log.d("FXDataDBHelper", "FXDataDBHelper name : " + str + ", version : " + i2);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Log.d("FXDataDBHelper", "onCreate");
            sQLiteDatabase.execSQL("CREATE TABLE avatar(id INTEGER PRIMARY KEY AUTOINCREMENT, gender INTEGER, age INTEGER, folder_name TEXT, hair_type INTEGER, head_type INTEGER, is_custom_face INTEGER, auto_normalized_color REAL, hue_rgb_color INTEGER, body_tall REAL, body_upper REAL, body_lower REAL, body_shoulder REAL, body_bust REAL, body_cup REAL, body_waist REAL, body_hip REAL, body_arm_length REAL, body_arm_thick REAL, body_tight_length REAL, body_tight_thick REAL, body_calf_length REAL, body_head_height REAL);");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Log.d("FXDataDBHelper", "onUpgrade(), oldVersion : " + i2 + ", newVersion : " + i3);
            while (i2 < i3) {
                switch (i2) {
                    case 1:
                        sQLiteDatabase.execSQL("CREATE TABLE avatar(id INTEGER PRIMARY KEY AUTOINCREMENT, gender INTEGER, age INTEGER, folder_name TEXT, hair_type INTEGER, head_type INTEGER, is_custom_face INTEGER, auto_normalized_color REAL, hue_rgb_color INTEGER, body_tall REAL, body_upper REAL, body_lower REAL, body_shoulder REAL, body_bust REAL, body_cup REAL, body_waist REAL, body_hip REAL, body_arm_length REAL, body_arm_thick REAL, body_tight_length REAL, body_tight_thick REAL, body_calf_length REAL, body_head_height REAL);");
                        break;
                    case 2:
                        b(sQLiteDatabase);
                        break;
                }
                i2++;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x0067  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0087  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0094  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00b4  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00c1  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x00e1  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x00fa  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0026 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void b(android.database.sqlite.SQLiteDatabase r15) {
            /*
                r14 = this;
                java.lang.Object r0 = net.fxgear.util.FXDataManager.e
                monitor-enter(r0)
                java.lang.String r1 = "release"
                java.lang.String r2 = "release"
                boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x018c }
                if (r1 == 0) goto L_0x018a
                if (r15 == 0) goto L_0x0183
                boolean r1 = r15.isOpen()     // Catch:{ all -> 0x018c }
                if (r1 == 0) goto L_0x0183
                java.lang.String r1 = "SELECT * FROM real;"
                r2 = 0
                android.database.Cursor r1 = r15.rawQuery(r1, r2)     // Catch:{ all -> 0x018c }
                if (r1 == 0) goto L_0x018a
                int r3 = r1.getCount()     // Catch:{ all -> 0x018c }
                if (r3 <= 0) goto L_0x017f
            L_0x0026:
                boolean r3 = r1.moveToNext()     // Catch:{ all -> 0x018c }
                if (r3 == 0) goto L_0x017f
                java.lang.String r3 = "animation_url"
                int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x018c }
                java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x018c }
                r4 = 0
                r5 = 1
                if (r3 == 0) goto L_0x0059
                java.lang.String r6 = net.fxgear.GlobalDefine.GetDataServerUrl()     // Catch:{ all -> 0x018c }
                boolean r6 = r3.startsWith(r6)     // Catch:{ all -> 0x018c }
                if (r6 == 0) goto L_0x0046
                r6 = r3
                goto L_0x005a
            L_0x0046:
                java.lang.String r6 = "http://data.fitnshop.com/"
                java.lang.String r7 = net.fxgear.GlobalDefine.GetDataServerUrl()     // Catch:{ all -> 0x018c }
                java.lang.String r6 = r3.replace(r6, r7)     // Catch:{ all -> 0x018c }
                boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x018c }
                if (r3 == 0) goto L_0x0057
                r6 = r2
            L_0x0057:
                r3 = 1
                goto L_0x005b
            L_0x0059:
                r6 = r2
            L_0x005a:
                r3 = 0
            L_0x005b:
                java.lang.String r7 = "video_url"
                int r7 = r1.getColumnIndex(r7)     // Catch:{ all -> 0x018c }
                java.lang.String r7 = r1.getString(r7)     // Catch:{ all -> 0x018c }
                if (r7 == 0) goto L_0x0087
                java.lang.String r8 = net.fxgear.GlobalDefine.GetDataServerUrl()     // Catch:{ all -> 0x018c }
                boolean r8 = r7.startsWith(r8)     // Catch:{ all -> 0x018c }
                if (r8 == 0) goto L_0x0072
                goto L_0x0088
            L_0x0072:
                java.lang.String r3 = "http://data.fitnshop.com/"
                java.lang.String r8 = net.fxgear.GlobalDefine.GetDataServerUrl()     // Catch:{ all -> 0x018c }
                java.lang.String r3 = r7.replace(r3, r8)     // Catch:{ all -> 0x018c }
                boolean r7 = r3.equals(r7)     // Catch:{ all -> 0x018c }
                if (r7 == 0) goto L_0x0084
                r7 = r2
                goto L_0x0085
            L_0x0084:
                r7 = r3
            L_0x0085:
                r3 = 1
                goto L_0x0088
            L_0x0087:
                r7 = r2
            L_0x0088:
                java.lang.String r8 = "capture_url"
                int r8 = r1.getColumnIndex(r8)     // Catch:{ all -> 0x018c }
                java.lang.String r8 = r1.getString(r8)     // Catch:{ all -> 0x018c }
                if (r8 == 0) goto L_0x00b4
                java.lang.String r9 = net.fxgear.GlobalDefine.GetDataServerUrl()     // Catch:{ all -> 0x018c }
                boolean r9 = r8.startsWith(r9)     // Catch:{ all -> 0x018c }
                if (r9 == 0) goto L_0x009f
                goto L_0x00b5
            L_0x009f:
                java.lang.String r3 = "http://data.fitnshop.com/"
                java.lang.String r9 = net.fxgear.GlobalDefine.GetDataServerUrl()     // Catch:{ all -> 0x018c }
                java.lang.String r3 = r8.replace(r3, r9)     // Catch:{ all -> 0x018c }
                boolean r8 = r3.equals(r8)     // Catch:{ all -> 0x018c }
                if (r8 == 0) goto L_0x00b1
                r8 = r2
                goto L_0x00b2
            L_0x00b1:
                r8 = r3
            L_0x00b2:
                r3 = 1
                goto L_0x00b5
            L_0x00b4:
                r8 = r2
            L_0x00b5:
                java.lang.String r9 = "background_url"
                int r9 = r1.getColumnIndex(r9)     // Catch:{ all -> 0x018c }
                java.lang.String r9 = r1.getString(r9)     // Catch:{ all -> 0x018c }
                if (r9 == 0) goto L_0x00e1
                java.lang.String r10 = net.fxgear.GlobalDefine.GetDataServerUrl()     // Catch:{ all -> 0x018c }
                boolean r10 = r9.startsWith(r10)     // Catch:{ all -> 0x018c }
                if (r10 == 0) goto L_0x00cc
                goto L_0x00e2
            L_0x00cc:
                java.lang.String r3 = "http://data.fitnshop.com/"
                java.lang.String r10 = net.fxgear.GlobalDefine.GetDataServerUrl()     // Catch:{ all -> 0x018c }
                java.lang.String r3 = r9.replace(r3, r10)     // Catch:{ all -> 0x018c }
                boolean r9 = r3.equals(r9)     // Catch:{ all -> 0x018c }
                if (r9 == 0) goto L_0x00de
                r9 = r2
                goto L_0x00df
            L_0x00de:
                r9 = r3
            L_0x00df:
                r3 = 1
                goto L_0x00e2
            L_0x00e1:
                r9 = r2
            L_0x00e2:
                java.lang.String r10 = "id"
                int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x018c }
                int r10 = r1.getInt(r10)     // Catch:{ all -> 0x018c }
                java.lang.String r11 = "%s = ?"
                java.lang.Object[] r12 = new java.lang.Object[r5]     // Catch:{ all -> 0x018c }
                java.lang.String r13 = "id"
                r12[r4] = r13     // Catch:{ all -> 0x018c }
                java.lang.String r11 = java.lang.String.format(r11, r12)     // Catch:{ all -> 0x018c }
                if (r3 == 0) goto L_0x0026
                if (r6 == 0) goto L_0x015a
                if (r7 == 0) goto L_0x015a
                if (r8 == 0) goto L_0x015a
                if (r9 == 0) goto L_0x015a
                android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ all -> 0x018c }
                r3.<init>()     // Catch:{ all -> 0x018c }
                java.lang.String r12 = "animation_url"
                r3.put(r12, r6)     // Catch:{ all -> 0x018c }
                java.lang.String r6 = "video_url"
                r3.put(r6, r7)     // Catch:{ all -> 0x018c }
                java.lang.String r6 = "capture_url"
                r3.put(r6, r8)     // Catch:{ all -> 0x018c }
                java.lang.String r6 = "background_url"
                r3.put(r6, r9)     // Catch:{ all -> 0x018c }
                java.lang.String r6 = "real"
                java.lang.String[] r7 = new java.lang.String[r5]     // Catch:{ all -> 0x018c }
                java.lang.String r8 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x018c }
                r7[r4] = r8     // Catch:{ all -> 0x018c }
                int r3 = r15.update(r6, r3, r11, r7)     // Catch:{ all -> 0x018c }
                if (r3 <= 0) goto L_0x012d
                goto L_0x0026
            L_0x012d:
                java.lang.String r6 = "FXDataDBHelper"
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x018c }
                r7.<init>()     // Catch:{ all -> 0x018c }
                java.lang.String r8 = "[ERROR] :: realId = "
                r7.append(r8)     // Catch:{ all -> 0x018c }
                r7.append(r10)     // Catch:{ all -> 0x018c }
                java.lang.String r8 = ", update error = "
                r7.append(r8)     // Catch:{ all -> 0x018c }
                r7.append(r3)     // Catch:{ all -> 0x018c }
                java.lang.String r3 = r7.toString()     // Catch:{ all -> 0x018c }
                android.util.Log.e(r6, r3)     // Catch:{ all -> 0x018c }
                java.lang.String r3 = "real"
                java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ all -> 0x018c }
                java.lang.String r6 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x018c }
                r5[r4] = r6     // Catch:{ all -> 0x018c }
                r15.delete(r3, r11, r5)     // Catch:{ all -> 0x018c }
                goto L_0x0026
            L_0x015a:
                java.lang.String r3 = "FXDataDBHelper"
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x018c }
                r6.<init>()     // Catch:{ all -> 0x018c }
                java.lang.String r7 = "[ERROR] :: existing url is wrong, realId = "
                r6.append(r7)     // Catch:{ all -> 0x018c }
                r6.append(r10)     // Catch:{ all -> 0x018c }
                java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x018c }
                android.util.Log.e(r3, r6)     // Catch:{ all -> 0x018c }
                java.lang.String r3 = "real"
                java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ all -> 0x018c }
                java.lang.String r6 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x018c }
                r5[r4] = r6     // Catch:{ all -> 0x018c }
                r15.delete(r3, r11, r5)     // Catch:{ all -> 0x018c }
                goto L_0x0026
            L_0x017f:
                r1.close()     // Catch:{ all -> 0x018c }
                goto L_0x018a
            L_0x0183:
                java.lang.String r15 = "FXDataDBHelper"
                java.lang.String r1 = "UpgradeDBFromVer2ToVer3() failed, DB is closed."
                android.util.Log.e(r15, r1)     // Catch:{ all -> 0x018c }
            L_0x018a:
                monitor-exit(r0)     // Catch:{ all -> 0x018c }
                return
            L_0x018c:
                r15 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x018c }
                throw r15
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.util.FXDataManager.a.b(android.database.sqlite.SQLiteDatabase):void");
        }

        /* access modifiers changed from: private */
        public String a(SQLiteDatabase sQLiteDatabase, String str) {
            String str2;
            synchronized (FXDataManager.e) {
                str2 = null;
                Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name ='" + str + "';", (String[]) null);
                if (rawQuery != null) {
                    if (rawQuery.getCount() > 0) {
                        rawQuery.moveToFirst();
                        str2 = rawQuery.getString(0);
                    }
                    rawQuery.close();
                }
            }
            Log.d("FXDataDBHelper", "name: " + str2);
            return str2;
        }

        /* access modifiers changed from: private */
        public void b(SQLiteDatabase sQLiteDatabase, String str) {
            synchronized (FXDataManager.e) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x01d7, code lost:
            return r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int a(android.database.sqlite.SQLiteDatabase r11, net.fxgear.AvatarData r12) {
            /*
                r10 = this;
                java.lang.Object r0 = net.fxgear.util.FXDataManager.e
                monitor-enter(r0)
                boolean r1 = r11.isOpen()     // Catch:{ all -> 0x01d8 }
                r2 = -1
                if (r1 == 0) goto L_0x01cf
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d8 }
                r1.<init>()     // Catch:{ all -> 0x01d8 }
                java.lang.String r3 = "SELECT id FROM avatar WHERE gender="
                r1.append(r3)     // Catch:{ all -> 0x01d8 }
                int r3 = r12.mGender     // Catch:{ all -> 0x01d8 }
                r1.append(r3)     // Catch:{ all -> 0x01d8 }
                java.lang.String r3 = " AND "
                r1.append(r3)     // Catch:{ all -> 0x01d8 }
                java.lang.String r3 = "age"
                r1.append(r3)     // Catch:{ all -> 0x01d8 }
                java.lang.String r3 = "="
                r1.append(r3)     // Catch:{ all -> 0x01d8 }
                int r3 = r12.mAge     // Catch:{ all -> 0x01d8 }
                r1.append(r3)     // Catch:{ all -> 0x01d8 }
                java.lang.String r3 = " AND "
                r1.append(r3)     // Catch:{ all -> 0x01d8 }
                java.lang.String r3 = "folder_name"
                r1.append(r3)     // Catch:{ all -> 0x01d8 }
                java.lang.String r3 = " ='"
                r1.append(r3)     // Catch:{ all -> 0x01d8 }
                java.lang.String r3 = r12.mFolderName     // Catch:{ all -> 0x01d8 }
                r1.append(r3)     // Catch:{ all -> 0x01d8 }
                java.lang.String r3 = "';"
                r1.append(r3)     // Catch:{ all -> 0x01d8 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01d8 }
                r3 = 0
                android.database.Cursor r4 = r11.rawQuery(r1, r3)     // Catch:{ all -> 0x01d8 }
                if (r4 == 0) goto L_0x007c
                int r5 = r4.getCount()     // Catch:{ all -> 0x01d8 }
                if (r5 <= 0) goto L_0x0079
                java.lang.String r1 = "FXDataDBHelper"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d8 }
                r3.<init>()     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "[ERROR] :: It already exists, avatar folder name : "
                r3.append(r5)     // Catch:{ all -> 0x01d8 }
                java.lang.String r12 = r12.mFolderName     // Catch:{ all -> 0x01d8 }
                r3.append(r12)     // Catch:{ all -> 0x01d8 }
                java.lang.String r12 = r3.toString()     // Catch:{ all -> 0x01d8 }
                android.util.Log.e(r1, r12)     // Catch:{ all -> 0x01d8 }
                r4.close()     // Catch:{ all -> 0x01d8 }
                r11.close()     // Catch:{ all -> 0x01d8 }
                monitor-exit(r0)     // Catch:{ all -> 0x01d8 }
                return r2
            L_0x0079:
                r4.close()     // Catch:{ all -> 0x01d8 }
            L_0x007c:
                android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ all -> 0x01d8 }
                r4.<init>()     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "gender"
                int r6 = r12.mGender     // Catch:{ all -> 0x01d8 }
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x01d8 }
                r4.put(r5, r6)     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "age"
                int r6 = r12.mAge     // Catch:{ all -> 0x01d8 }
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x01d8 }
                r4.put(r5, r6)     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "folder_name"
                java.lang.String r6 = r12.mFolderName     // Catch:{ all -> 0x01d8 }
                r4.put(r5, r6)     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "hair_type"
                int r6 = r12.mHairType     // Catch:{ all -> 0x01d8 }
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x01d8 }
                r4.put(r5, r6)     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "head_type"
                int r6 = r12.mHeadType     // Catch:{ all -> 0x01d8 }
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x01d8 }
                r4.put(r5, r6)     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "is_custom_face"
                boolean r6 = r12.mIsCustomFace     // Catch:{ all -> 0x01d8 }
                r7 = 0
                r8 = 1
                if (r6 != r8) goto L_0x00bd
                goto L_0x00be
            L_0x00bd:
                r8 = 0
            L_0x00be:
                java.lang.Integer r6 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x01d8 }
                r4.put(r5, r6)     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "auto_normalized_color"
                float r6 = r12.mAutoNormalizedColor     // Catch:{ all -> 0x01d8 }
                java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ all -> 0x01d8 }
                r4.put(r5, r6)     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "hue_rgb_color"
                int r6 = r12.mHueRGBColor     // Catch:{ all -> 0x01d8 }
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x01d8 }
                r4.put(r5, r6)     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "body_tall"
                net.fxgear.BodySizeData r6 = r12.mBodyData     // Catch:{ all -> 0x01d8 }
                float r6 = r6.mTallSize     // Catch:{ all -> 0x01d8 }
                java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ all -> 0x01d8 }
                r4.put(r5, r6)     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "body_upper"
                net.fxgear.BodySizeData r6 = r12.mBodyData     // Catch:{ all -> 0x01d8 }
                float r6 = r6.mUpperSize     // Catch:{ all -> 0x01d8 }
                java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ all -> 0x01d8 }
                r4.put(r5, r6)     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "body_lower"
                net.fxgear.BodySizeData r6 = r12.mBodyData     // Catch:{ all -> 0x01d8 }
                float r6 = r6.mLowerSize     // Catch:{ all -> 0x01d8 }
                java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ all -> 0x01d8 }
                r4.put(r5, r6)     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "body_shoulder"
                net.fxgear.BodySizeData r6 = r12.mBodyData     // Catch:{ all -> 0x01d8 }
                float r6 = r6.mShoulderSize     // Catch:{ all -> 0x01d8 }
                java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ all -> 0x01d8 }
                r4.put(r5, r6)     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "body_bust"
                net.fxgear.BodySizeData r6 = r12.mBodyData     // Catch:{ all -> 0x01d8 }
                float r6 = r6.mBustSize     // Catch:{ all -> 0x01d8 }
                java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ all -> 0x01d8 }
                r4.put(r5, r6)     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "body_cup"
                net.fxgear.BodySizeData r6 = r12.mBodyData     // Catch:{ all -> 0x01d8 }
                float r6 = r6.mCupSize     // Catch:{ all -> 0x01d8 }
                java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ all -> 0x01d8 }
                r4.put(r5, r6)     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "body_waist"
                net.fxgear.BodySizeData r6 = r12.mBodyData     // Catch:{ all -> 0x01d8 }
                float r6 = r6.mWaistSize     // Catch:{ all -> 0x01d8 }
                java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ all -> 0x01d8 }
                r4.put(r5, r6)     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "body_hip"
                net.fxgear.BodySizeData r6 = r12.mBodyData     // Catch:{ all -> 0x01d8 }
                float r6 = r6.mHipSize     // Catch:{ all -> 0x01d8 }
                java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ all -> 0x01d8 }
                r4.put(r5, r6)     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "body_arm_length"
                net.fxgear.BodySizeData r6 = r12.mBodyData     // Catch:{ all -> 0x01d8 }
                float r6 = r6.mArmLengthSize     // Catch:{ all -> 0x01d8 }
                java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ all -> 0x01d8 }
                r4.put(r5, r6)     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "body_arm_thick"
                net.fxgear.BodySizeData r6 = r12.mBodyData     // Catch:{ all -> 0x01d8 }
                float r6 = r6.mArmThickSize     // Catch:{ all -> 0x01d8 }
                java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ all -> 0x01d8 }
                r4.put(r5, r6)     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "body_tight_length"
                net.fxgear.BodySizeData r6 = r12.mBodyData     // Catch:{ all -> 0x01d8 }
                float r6 = r6.mThighLengthSize     // Catch:{ all -> 0x01d8 }
                java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ all -> 0x01d8 }
                r4.put(r5, r6)     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "body_tight_thick"
                net.fxgear.BodySizeData r6 = r12.mBodyData     // Catch:{ all -> 0x01d8 }
                float r6 = r6.mThighThickSize     // Catch:{ all -> 0x01d8 }
                java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ all -> 0x01d8 }
                r4.put(r5, r6)     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "body_calf_length"
                net.fxgear.BodySizeData r6 = r12.mBodyData     // Catch:{ all -> 0x01d8 }
                float r6 = r6.mCalfLengthSize     // Catch:{ all -> 0x01d8 }
                java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ all -> 0x01d8 }
                r4.put(r5, r6)     // Catch:{ all -> 0x01d8 }
                java.lang.String r5 = "body_head_height"
                net.fxgear.BodySizeData r12 = r12.mBodyData     // Catch:{ all -> 0x01d8 }
                float r12 = r12.mHeadHeight     // Catch:{ all -> 0x01d8 }
                java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x01d8 }
                r4.put(r5, r12)     // Catch:{ all -> 0x01d8 }
                java.lang.String r12 = "avatar"
                long r4 = r11.insert(r12, r3, r4)     // Catch:{ all -> 0x01d8 }
                r8 = -1
                int r12 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r12 <= 0) goto L_0x01b5
                android.database.Cursor r12 = r11.rawQuery(r1, r3)     // Catch:{ all -> 0x01d8 }
                if (r12 == 0) goto L_0x01cb
                int r1 = r12.getCount()     // Catch:{ all -> 0x01d8 }
                if (r1 <= 0) goto L_0x01b1
                r12.moveToFirst()     // Catch:{ all -> 0x01d8 }
                int r1 = r12.getInt(r7)     // Catch:{ all -> 0x01d8 }
                r2 = r1
            L_0x01b1:
                r12.close()     // Catch:{ all -> 0x01d8 }
                goto L_0x01cb
            L_0x01b5:
                java.lang.String r12 = "FXDataDBHelper"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d8 }
                r1.<init>()     // Catch:{ all -> 0x01d8 }
                java.lang.String r3 = "AddAvatarData() is fail, error = "
                r1.append(r3)     // Catch:{ all -> 0x01d8 }
                r1.append(r4)     // Catch:{ all -> 0x01d8 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01d8 }
                android.util.Log.e(r12, r1)     // Catch:{ all -> 0x01d8 }
            L_0x01cb:
                r11.close()     // Catch:{ all -> 0x01d8 }
                goto L_0x01d6
            L_0x01cf:
                java.lang.String r11 = "FXDataDBHelper"
                java.lang.String r12 = "AddAvatarData() is fail, DB is closed."
                android.util.Log.e(r11, r12)     // Catch:{ all -> 0x01d8 }
            L_0x01d6:
                monitor-exit(r0)     // Catch:{ all -> 0x01d8 }
                return r2
            L_0x01d8:
                r11 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x01d8 }
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.util.FXDataManager.a.a(android.database.sqlite.SQLiteDatabase, net.fxgear.AvatarData):int");
        }

        public boolean b(SQLiteDatabase sQLiteDatabase, AvatarData avatarData) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hair_type", Integer.valueOf(avatarData.mHairType));
            contentValues.put("head_type", Integer.valueOf(avatarData.mHeadType));
            boolean z2 = false;
            contentValues.put("is_custom_face", Integer.valueOf(avatarData.mIsCustomFace ? 1 : 0));
            contentValues.put("auto_normalized_color", Float.valueOf(avatarData.mAutoNormalizedColor));
            contentValues.put("hue_rgb_color", Integer.valueOf(avatarData.mHueRGBColor));
            contentValues.put("body_tall", Float.valueOf(avatarData.mBodyData.mTallSize));
            contentValues.put("body_upper", Float.valueOf(avatarData.mBodyData.mUpperSize));
            contentValues.put("body_lower", Float.valueOf(avatarData.mBodyData.mLowerSize));
            contentValues.put("body_shoulder", Float.valueOf(avatarData.mBodyData.mShoulderSize));
            contentValues.put("body_bust", Float.valueOf(avatarData.mBodyData.mBustSize));
            contentValues.put("body_cup", Float.valueOf(avatarData.mBodyData.mCupSize));
            contentValues.put("body_waist", Float.valueOf(avatarData.mBodyData.mWaistSize));
            contentValues.put("body_hip", Float.valueOf(avatarData.mBodyData.mHipSize));
            contentValues.put("body_arm_length", Float.valueOf(avatarData.mBodyData.mArmLengthSize));
            contentValues.put("body_arm_thick", Float.valueOf(avatarData.mBodyData.mArmThickSize));
            contentValues.put("body_tight_length", Float.valueOf(avatarData.mBodyData.mThighLengthSize));
            contentValues.put("body_tight_thick", Float.valueOf(avatarData.mBodyData.mThighThickSize));
            contentValues.put("body_calf_length", Float.valueOf(avatarData.mBodyData.mCalfLengthSize));
            contentValues.put("body_head_height", Float.valueOf(avatarData.mBodyData.mHeadHeight));
            synchronized (FXDataManager.e) {
                if (sQLiteDatabase.isOpen()) {
                    int update = sQLiteDatabase.update("avatar", contentValues, "id=?", new String[]{avatarData.mAvatarID + ""});
                    if (update > 0) {
                        z2 = true;
                    } else {
                        Log.e("FXDataDBHelper", "UpdateAvatarData() is fail, error = " + update);
                    }
                } else {
                    Log.e("FXDataDBHelper", "UpdateAvatarData() is fail, DB is closed.");
                }
            }
            return z2;
        }

        public boolean a(SQLiteDatabase sQLiteDatabase, int i2) {
            boolean z2;
            synchronized (FXDataManager.e) {
                z2 = false;
                if (sQLiteDatabase.isOpen()) {
                    int delete = sQLiteDatabase.delete("avatar", "id=?", new String[]{i2 + ""});
                    if (delete < 1) {
                        Log.e("FXDataDBHelper", "RemoveAvatarData() is fail, error = " + delete);
                    } else {
                        z2 = true;
                    }
                } else {
                    Log.e("FXDataDBHelper", "RemoveAvatarData() is fail, DB is closed.");
                }
            }
            return z2;
        }

        public ArrayList<AvatarData> a(SQLiteDatabase sQLiteDatabase) {
            ArrayList<AvatarData> arrayList;
            Log.i("FXDataDBHelper", "GetAllAvatarDataList()");
            synchronized (FXDataManager.e) {
                arrayList = null;
                if (sQLiteDatabase.isOpen()) {
                    Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM avatar ORDER BY id DESC;", (String[]) null);
                    if (rawQuery != null) {
                        if (rawQuery.getCount() > 0) {
                            ArrayList<AvatarData> arrayList2 = new ArrayList<>();
                            while (rawQuery.moveToNext()) {
                                AvatarData avatarData = new AvatarData();
                                boolean z2 = false;
                                avatarData.mAvatarID = rawQuery.getInt(0);
                                avatarData.mGender = rawQuery.getInt(1);
                                avatarData.mAge = rawQuery.getInt(2);
                                avatarData.mFolderName = rawQuery.getString(3);
                                avatarData.mThumbnailPath = GlobalDefine.GetAvatarDataDirectory(FXDataManager.this.f1519b, avatarData.mGender, avatarData.mAge, avatarData.mFolderName).getAbsolutePath() + File.separator + GlobalDefine.FILE_NAME_AVATAR_THUMBNAIL;
                                avatarData.mHairType = rawQuery.getInt(4);
                                avatarData.mHeadType = rawQuery.getInt(5);
                                if (rawQuery.getInt(6) == 1) {
                                    z2 = true;
                                }
                                avatarData.mIsCustomFace = z2;
                                avatarData.mAutoNormalizedColor = rawQuery.getFloat(7);
                                avatarData.mHueRGBColor = rawQuery.getInt(8);
                                avatarData.mBodyData = new BodySizeData();
                                avatarData.mBodyData.mTallSize = rawQuery.getFloat(9);
                                avatarData.mBodyData.mUpperSize = rawQuery.getFloat(10);
                                avatarData.mBodyData.mLowerSize = rawQuery.getFloat(11);
                                avatarData.mBodyData.mShoulderSize = rawQuery.getFloat(12);
                                avatarData.mBodyData.mBustSize = rawQuery.getFloat(13);
                                avatarData.mBodyData.mCupSize = rawQuery.getFloat(14);
                                avatarData.mBodyData.mWaistSize = rawQuery.getFloat(15);
                                avatarData.mBodyData.mHipSize = rawQuery.getFloat(16);
                                avatarData.mBodyData.mArmLengthSize = rawQuery.getFloat(17);
                                avatarData.mBodyData.mArmThickSize = rawQuery.getFloat(18);
                                avatarData.mBodyData.mThighLengthSize = rawQuery.getFloat(19);
                                avatarData.mBodyData.mThighThickSize = rawQuery.getFloat(20);
                                avatarData.mBodyData.mCalfLengthSize = rawQuery.getFloat(21);
                                avatarData.mBodyData.mHeadHeight = rawQuery.getFloat(22);
                                AvatarSetting.ConvertThicknessToCircumference(FXDataManager.this.f1519b, avatarData.mGender, avatarData.mAge, avatarData.mBodyData);
                                arrayList2.add(avatarData);
                            }
                            arrayList = arrayList2;
                        }
                        rawQuery.close();
                    }
                } else {
                    Log.e("FXDataDBHelper", "GetAllAvatarDataList() is fail, DB is closed.");
                }
            }
            return arrayList;
        }

        public ArrayList<AvatarData> a(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            ArrayList<AvatarData> arrayList;
            Log.i("FXDataDBHelper", "GetAvatarDataList(), gender : " + i2 + ", age : " + i3);
            synchronized (FXDataManager.e) {
                arrayList = null;
                if (sQLiteDatabase.isOpen()) {
                    Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM avatar WHERE gender=" + i2 + " AND " + "age" + "=" + i3 + " ORDER BY " + "id" + " " + "DESC" + ";", (String[]) null);
                    if (rawQuery != null) {
                        if (rawQuery.getCount() > 0) {
                            arrayList = new ArrayList<>();
                            while (rawQuery.moveToNext()) {
                                AvatarData avatarData = new AvatarData();
                                boolean z2 = false;
                                avatarData.mAvatarID = rawQuery.getInt(0);
                                avatarData.mGender = rawQuery.getInt(1);
                                avatarData.mAge = rawQuery.getInt(2);
                                avatarData.mFolderName = rawQuery.getString(3);
                                avatarData.mThumbnailPath = GlobalDefine.GetAvatarDataDirectory(FXDataManager.this.f1519b, avatarData.mGender, avatarData.mAge, avatarData.mFolderName).getAbsolutePath() + File.separator + GlobalDefine.FILE_NAME_AVATAR_THUMBNAIL;
                                avatarData.mHairType = rawQuery.getInt(4);
                                avatarData.mHeadType = rawQuery.getInt(5);
                                if (rawQuery.getInt(6) == 1) {
                                    z2 = true;
                                }
                                avatarData.mIsCustomFace = z2;
                                avatarData.mAutoNormalizedColor = rawQuery.getFloat(7);
                                avatarData.mHueRGBColor = rawQuery.getInt(8);
                                avatarData.mBodyData = new BodySizeData();
                                avatarData.mBodyData.mTallSize = rawQuery.getFloat(9);
                                avatarData.mBodyData.mUpperSize = rawQuery.getFloat(10);
                                avatarData.mBodyData.mLowerSize = rawQuery.getFloat(11);
                                avatarData.mBodyData.mShoulderSize = rawQuery.getFloat(12);
                                avatarData.mBodyData.mBustSize = rawQuery.getFloat(13);
                                avatarData.mBodyData.mCupSize = rawQuery.getFloat(14);
                                avatarData.mBodyData.mWaistSize = rawQuery.getFloat(15);
                                avatarData.mBodyData.mHipSize = rawQuery.getFloat(16);
                                avatarData.mBodyData.mArmLengthSize = rawQuery.getFloat(17);
                                avatarData.mBodyData.mArmThickSize = rawQuery.getFloat(18);
                                avatarData.mBodyData.mThighLengthSize = rawQuery.getFloat(19);
                                avatarData.mBodyData.mThighThickSize = rawQuery.getFloat(20);
                                avatarData.mBodyData.mCalfLengthSize = rawQuery.getFloat(21);
                                avatarData.mBodyData.mHeadHeight = rawQuery.getFloat(22);
                                AvatarSetting.ConvertThicknessToCircumference(FXDataManager.this.f1519b, avatarData.mGender, avatarData.mAge, avatarData.mBodyData);
                                arrayList.add(avatarData);
                            }
                        }
                        rawQuery.close();
                    }
                } else {
                    Log.e("FXDataDBHelper", "GetAvatarDataList() is fail, DB is closed.");
                }
            }
            return arrayList;
        }

        public AvatarData b(SQLiteDatabase sQLiteDatabase, int i2) {
            AvatarData avatarData;
            Log.i("FXDataDBHelper", "GetAvatarData(), id : " + i2);
            synchronized (FXDataManager.e) {
                avatarData = null;
                if (sQLiteDatabase.isOpen()) {
                    Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM avatar WHERE id=" + i2 + ";", (String[]) null);
                    if (rawQuery != null) {
                        if (rawQuery.getCount() > 0) {
                            rawQuery.moveToNext();
                            avatarData = new AvatarData();
                            boolean z2 = false;
                            avatarData.mAvatarID = rawQuery.getInt(0);
                            avatarData.mGender = rawQuery.getInt(1);
                            avatarData.mAge = rawQuery.getInt(2);
                            avatarData.mFolderName = rawQuery.getString(3);
                            avatarData.mThumbnailPath = GlobalDefine.GetAvatarDataDirectory(FXDataManager.this.f1519b, avatarData.mGender, avatarData.mAge, avatarData.mFolderName).getAbsolutePath() + File.separator + GlobalDefine.FILE_NAME_AVATAR_THUMBNAIL;
                            avatarData.mHairType = rawQuery.getInt(4);
                            avatarData.mHeadType = rawQuery.getInt(5);
                            if (rawQuery.getInt(6) == 1) {
                                z2 = true;
                            }
                            avatarData.mIsCustomFace = z2;
                            avatarData.mAutoNormalizedColor = rawQuery.getFloat(7);
                            avatarData.mHueRGBColor = rawQuery.getInt(8);
                            avatarData.mBodyData = new BodySizeData();
                            avatarData.mBodyData.mTallSize = rawQuery.getFloat(9);
                            avatarData.mBodyData.mUpperSize = rawQuery.getFloat(10);
                            avatarData.mBodyData.mLowerSize = rawQuery.getFloat(11);
                            avatarData.mBodyData.mShoulderSize = rawQuery.getFloat(12);
                            avatarData.mBodyData.mBustSize = rawQuery.getFloat(13);
                            avatarData.mBodyData.mCupSize = rawQuery.getFloat(14);
                            avatarData.mBodyData.mWaistSize = rawQuery.getFloat(15);
                            avatarData.mBodyData.mHipSize = rawQuery.getFloat(16);
                            avatarData.mBodyData.mArmLengthSize = rawQuery.getFloat(17);
                            avatarData.mBodyData.mArmThickSize = rawQuery.getFloat(18);
                            avatarData.mBodyData.mThighLengthSize = rawQuery.getFloat(19);
                            avatarData.mBodyData.mThighThickSize = rawQuery.getFloat(20);
                            avatarData.mBodyData.mCalfLengthSize = rawQuery.getFloat(21);
                            avatarData.mBodyData.mHeadHeight = rawQuery.getFloat(22);
                            AvatarSetting.ConvertThicknessToCircumference(FXDataManager.this.f1519b, avatarData.mGender, avatarData.mAge, avatarData.mBodyData);
                        }
                        rawQuery.close();
                    }
                } else {
                    Log.e("FXDataDBHelper", "GetAvatarData() is fail, DB is closed.");
                }
            }
            return avatarData;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\util\FXUtil.java ==========

package net.fxgear.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import net.fxgear.GlobalDefine;
import net.fxgear.customface.CustomFaceInterface;
import net.fxgear.fittingview.FittingSurfaceView;
import net.fxgear.fittingview.data.FittingFaceData;

public class FXUtil {
    public static final String DEFAULT_LANGUAGE_CODE = "en";
    public static final int DEFAULT_RATIO_CUSTOM_FACE_IMAGE_SIZE = 1;
    public static final String DENSITY_XHDPI = "xhdpi";
    public static final String DENSITY_XXHDPI = "xxhdpi";
    public static final String DENSITY_XXXHDPI = "xxxhdpi";
    public static final int FACE_AREA_BOTTOM_INDEX = 3;
    public static final int FACE_AREA_LEFT_INDEX = 0;
    public static final int FACE_AREA_LENGTH = 4;
    public static final int FACE_AREA_RIGHT_INDEX = 2;
    public static final int FACE_AREA_TOP_INDEX = 1;
    public static final String FILE_NAME_TEMP_BITMAP = "temp_bitmap.bmp";
    public static final String LANGUAGE_CODE_CHINESE = "zh";
    public static final int MAX_CUSTOM_FACE_IMAGE_SIZE = 1024;
    public static final String TEMP_FACE_IMAGE_DICETORY_NAME = "FACE_TEMP";

    /* renamed from: a  reason: collision with root package name */
    private static final String f1522a = "FXUtil";

    public static int blueFromColor(int i) {
        return i & 255;
    }

    public static int colorFromRGB(int i, int i2, int i3) {
        return (i << 16) | -16777216 | (i2 << 8) | i3;
    }

    public static int greenFromColor(int i) {
        return (i >> 8) & 255;
    }

    public static int redFromColor(int i) {
        return (i >> 16) & 255;
    }

    @SuppressLint({"NewApi"})
    private static long a(String str) {
        long j;
        long j2;
        if (str == null || !new File(str).exists()) {
            return 0;
        }
        StatFs statFs = new StatFs(str);
        if (Build.VERSION.SDK_INT >= 18) {
            j2 = statFs.getBlockSizeLong();
            j = statFs.getAvailableBlocksLong();
        } else {
            j2 = (long) statFs.getBlockSize();
            j = (long) statFs.getAvailableBlocks();
        }
        return j2 * j;
    }

    public static long GetAvailableSpaceSize(File file) {
        if (file == null) {
            return 0;
        }
        if (file.exists()) {
            return a(file.getAbsolutePath());
        }
        if (file.getParentFile() != null) {
            return GetAvailableSpaceSize(file.getParentFile());
        }
        return 0;
    }

    public static long GetInternalAvailableSpaceSize(Context context) {
        return GetAvailableSpaceSize(context.getFilesDir());
    }

    public static boolean IsMainThread() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    public static void LineMessage(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String[] split = str.split("\n");
        if (split != null && stackTraceElement != null) {
            Log.d(f1522a, String.format("[%s][%d] :: %s", new Object[]{stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber()), "Start"}));
            for (String d : split) {
                Log.d(f1522a, d);
            }
            Log.d(f1522a, String.format("[%s][%d] :: %s", new Object[]{stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber()), "End"}));
        }
    }

    public static void PrintFileListFromDirectory(File file, String str) {
        File[] listFiles;
        if (file != null && file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            String str2 = str != null ? str : "[FX] ";
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    PrintFileListFromDirectory(file2, str);
                }
                Log.e(f1522a, str2 + file2.getAbsolutePath());
            }
        }
    }

    public static void DeleteEmptyDirectories(File file) {
        File[] listFiles;
        if (file != null && file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    DeleteEmptyDirectories(file2);
                }
            }
            file.delete();
        }
    }

    public static void DeleteDirectoryRecursive(File file) {
        if (file != null && file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        DeleteDirectoryRecursive(file2);
                    } else {
                        file2.delete();
                    }
                }
            }
            file.delete();
        }
    }

    public static int GetClothType(String str) {
        if (str.contains("Top")) {
            return 0;
        }
        if (str.contains(GlobalDefine.CLOTH_KEYWORD_BOTTOM)) {
            return 1;
        }
        if (str.contains(GlobalDefine.CLOTH_KEYWORD_ONEPIECE)) {
            return 2;
        }
        if (str.contains(GlobalDefine.CLOTH_KEYWORD_JACKET)) {
            return 3;
        }
        if (str.contains(GlobalDefine.CLOTH_KEYWORD_COAT)) {
            return 4;
        }
        return str.contains(GlobalDefine.CLOTH_KEYWORD_SHOES) ? 5 : -1;
    }

    public static void OccurRunTimeException(File file) {
        String str;
        if (file != null) {
            str = "ERROR :: Not found file : " + file.getName();
        } else {
            str = "ERROR :: Not found file";
        }
        OccurRunTimeException(str);
    }

    public static void OccurRunTimeException(String str) {
        if (str == null) {
            throw new RuntimeException("ERROR :: unknown error.");
        }
        throw new RuntimeException(str);
    }

    public static String GetCurrentCustomFaceImageFilePath(Context context) {
        String str = FittingFaceData.GetCustomFaceFile(GlobalDefine.GetAvatarRuntimeDirectory(context).getAbsolutePath())[1];
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        return file.getAbsolutePath();
    }

    public static int[] GetCurrentCustomFacDetectPositions(Context context) {
        IntBuffer LoadFeaturePosition;
        String str = FittingFaceData.GetCustomFaceFile(GlobalDefine.GetAvatarRuntimeDirectory(context).getAbsolutePath())[0];
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile() || (LoadFeaturePosition = CustomFaceInterface.LoadFeaturePosition(file.getAbsolutePath())) == null) {
            return null;
        }
        int[] iArr = new int[LoadFeaturePosition.capacity()];
        LoadFeaturePosition.get(iArr);
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr2.length; i++) {
            iArr2[i] = iArr[i];
        }
        return iArr2;
    }

    public static int CalculateRatioForCustomFaceImage(int i, int i2, int i3, int i4) {
        String str = f1522a;
        Log.i(str, "CalculateRatioForCustomFaceImage()+, imgWidth: " + i + ", imgHeight: " + i2 + ", maxWidth: " + i3 + ", maxHeight: " + i4);
        int i5 = 1;
        if (i2 >= i4 || i >= i3) {
            int i6 = i2 / 2;
            int i7 = i / 2;
            while (i6 / i5 > i4 && i7 / i5 > i3) {
                i5 *= 2;
            }
        }
        String str2 = f1522a;
        Log.i(str2, "CalculateRatioForCustomFaceImage()-, ratio: " + i5);
        return i5;
    }

    public static int[] GetFaceAreaDetecPositions(Context context, File file, int i, int i2) {
        FittingFaceData.a aVar;
        Log.d(f1522a, "GetFaceAreaDetecPositions()+");
        if (file == null || !file.isFile() || !file.exists()) {
            return null;
        }
        File GetAvatarFaceCommonDirectory = GlobalDefine.GetAvatarFaceCommonDirectory(context, i, i2);
        File GetAvatarFaceDirectory = GlobalDefine.GetAvatarFaceDirectory(context, i, i2);
        if (!GetAvatarFaceCommonDirectory.exists() || !GetAvatarFaceCommonDirectory.isDirectory()) {
            Log.e(f1522a, "WARNING :: Not found faceCommon directory.");
            return null;
        }
        String str = GetAvatarFaceCommonDirectory.getAbsolutePath() + File.separator;
        String str2 = GetAvatarFaceDirectory.getAbsolutePath() + File.separator;
        int i3 = 2;
        if (i == 2) {
            aVar = FittingFaceData.a.MALE;
        } else {
            aVar = FittingFaceData.a.FEMALE;
        }
        FittingFaceData.a aVar2 = aVar;
        if (i != 2) {
            i3 = (i == 1 && i2 == 1) ? 3 : 1;
        } else if (i2 != 1) {
            i3 = 0;
        }
        FittingFaceData fittingFaceData = new FittingFaceData(0, file.getAbsolutePath(), (int[]) null, aVar2, i3, str2, str, (String) null);
        fittingFaceData.SetModelGender(i3);
        return FittingSurfaceView.GetFaceAreaDetectPositions(fittingFaceData);
    }

    public static int[] GetFaceDetectPositions(Context context, File file, int i, int i2, int[] iArr) {
        FittingFaceData.a aVar;
        boolean z;
        int[] iArr2;
        Context context2 = context;
        int i3 = i;
        int i4 = i2;
        Log.d(f1522a, "GetFaceDetectPositions()+");
        if (file == null || !file.isFile() || !file.exists()) {
            return null;
        }
        File GetAvatarFaceCommonDirectory = GlobalDefine.GetAvatarFaceCommonDirectory(context2, i3, i4);
        File GetAvatarFaceDirectory = GlobalDefine.GetAvatarFaceDirectory(context2, i3, i4);
        if (!GetAvatarFaceCommonDirectory.exists() || !GetAvatarFaceCommonDirectory.isDirectory()) {
            Log.e(f1522a, "WARNING :: Not found faceCommon directory.");
            return null;
        }
        String str = GetAvatarFaceCommonDirectory.getAbsolutePath() + File.separator;
        String str2 = GetAvatarFaceDirectory.getAbsolutePath() + File.separator;
        if (i3 == 2) {
            aVar = FittingFaceData.a.MALE;
        } else {
            aVar = FittingFaceData.a.FEMALE;
        }
        FittingFaceData.a aVar2 = aVar;
        int i5 = i3 == 2 ? i4 == 1 ? 2 : 0 : (i3 == 1 && i4 == 1) ? 3 : 1;
        FittingFaceData fittingFaceData = new FittingFaceData(0, file.getAbsolutePath(), (int[]) null, aVar2, i5, str2, str, (String) null);
        fittingFaceData.SetModelGender(i5);
        if (iArr == null) {
            iArr2 = new int[]{0, 0, 0, 0};
            z = false;
        } else {
            iArr2 = iArr;
            z = true;
        }
        return FittingSurfaceView.GetFaceDetectPositions(fittingFaceData, z, iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
    }

    public static long GetFileSize(File file) {
        long j;
        long j2 = 0;
        if (file == null || !file.exists()) {
            return 0;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    j = GetFileSize(file2);
                } else {
                    j = file2.length();
                }
                j2 += j;
            }
        }
        return j2 + file.length();
    }

    public static GlobalDefine.Result CopyFileRecursive(File file, File file2, ArrayList<String> arrayList) {
        boolean z;
        GlobalDefine.Result result = new GlobalDefine.Result();
        result.resultCode = 0;
        if (file == null || file2 == null || !file.exists()) {
            result.resultCode = 3;
            return result;
        }
        long GetFileSize = GetFileSize(file);
        if (GetFileSize > GetAvailableSpaceSize(file2)) {
            result.resultCode = 4;
            result.resultExtra = Long.valueOf(GetFileSize);
            return result;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file3 : listFiles) {
                if (file3.isDirectory()) {
                    GlobalDefine.Result CopyFileRecursive = CopyFileRecursive(file3, new File(file2, file3.getName()), arrayList);
                    if (CopyFileRecursive.resultCode != -1) {
                        return CopyFileRecursive;
                    }
                } else {
                    if (arrayList != null && !arrayList.isEmpty()) {
                        Iterator<String> it = arrayList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (file3.getName().toLowerCase().endsWith(it.next().toLowerCase())) {
                                    z = true;
                                    break;
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                        if (z) {
                        }
                    }
                    File file4 = new File(file2, file3.getName());
                    if (!file4.getParentFile().exists()) {
                        file4.getParentFile().mkdirs();
                    }
                    CopyFile(file3, file4);
                }
            }
        }
        result.resultCode = -1;
        return result;
    }

    public static boolean CopyFile(File file, File file2) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (file2 != null && file2.getAbsolutePath().equals(file.getAbsolutePath())) {
            return true;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[MAX_CUSTOM_FACE_IMAGE_SIZE];
            while (true) {
                int read = fileInputStream.read(bArr, 0, MAX_CUSTOM_FACE_IMAGE_SIZE);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    fileInputStream.close();
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static File getFilesDir(Context context) {
        String str;
        if ("mounted".equals(Environment.getExternalStorageState()) || !a()) {
            str = a(context).getPath();
        } else {
            str = context.getFilesDir().getPath();
        }
        return new File(str);
    }

    @TargetApi(9)
    private static boolean a() {
        if (Build.VERSION.SDK_INT >= 9) {
            return Environment.isExternalStorageRemovable();
        }
        return true;
    }

    @TargetApi(8)
    private static File a(Context context) {
        File externalFilesDir;
        if (Build.VERSION.SDK_INT >= 8 && (externalFilesDir = context.getExternalFilesDir((String) null)) != null) {
            return externalFilesDir;
        }
        return new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/files/"));
    }

    public static String GetDensityName(Context context) {
        if (context == null) {
            return DENSITY_XXHDPI;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        if (displayMetrics.densityDpi <= 240 || displayMetrics.densityDpi > 320) {
            return ((displayMetrics.densityDpi <= 320 || displayMetrics.densityDpi > 480) && displayMetrics.densityDpi > 480 && displayMetrics.densityDpi <= 640) ? DENSITY_XXXHDPI : DENSITY_XXHDPI;
        }
        return DENSITY_XHDPI;
    }

    public static String GetCurrentLanguageCode(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        String str = f1522a;
        Log.e(str, "current lang : " + locale.toString());
        String language = locale.getLanguage();
        if (language.equals(LANGUAGE_CODE_CHINESE)) {
            language = locale.toString();
        }
        String str2 = f1522a;
        Log.e(str2, "return current lang : " + language);
        return language;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\util\LUDecomposition.java ==========

package net.fxgear.util;

public class LUDecomposition {

    /* renamed from: a  reason: collision with root package name */
    private double[][] f1523a;

    /* renamed from: b  reason: collision with root package name */
    private int f1524b;
    private int c;
    private int d;
    private int[] e = new int[this.f1524b];

    public LUDecomposition(Matrix matrix) {
        this.f1523a = matrix.getArrayCopy();
        this.f1524b = matrix.getRowDimension();
        this.c = matrix.getColumnDimension();
        for (int i = 0; i < this.f1524b; i++) {
            this.e[i] = i;
        }
        this.d = 1;
        double[] dArr = new double[this.f1524b];
        int i2 = 0;
        while (i2 < this.c) {
            for (int i3 = 0; i3 < this.f1524b; i3++) {
                dArr[i3] = this.f1523a[i3][i2];
            }
            for (int i4 = 0; i4 < this.f1524b; i4++) {
                double[] dArr2 = this.f1523a[i4];
                int min = Math.min(i4, i2);
                double d2 = 0.0d;
                for (int i5 = 0; i5 < min; i5++) {
                    d2 += dArr2[i5] * dArr[i5];
                }
                double d3 = dArr[i4] - d2;
                dArr[i4] = d3;
                dArr2[i2] = d3;
            }
            int i6 = i2 + 1;
            int i7 = i2;
            for (int i8 = i6; i8 < this.f1524b; i8++) {
                if (Math.abs(dArr[i8]) > Math.abs(dArr[i7])) {
                    i7 = i8;
                }
            }
            if (i7 != i2) {
                for (int i9 = 0; i9 < this.c; i9++) {
                    double d4 = this.f1523a[i7][i9];
                    this.f1523a[i7][i9] = this.f1523a[i2][i9];
                    this.f1523a[i2][i9] = d4;
                }
                int i10 = this.e[i7];
                this.e[i7] = this.e[i2];
                this.e[i2] = i10;
                this.d = -this.d;
            }
            if ((i2 < this.f1524b) && (this.f1523a[i2][i2] != 0.0d)) {
                for (int i11 = i6; i11 < this.f1524b; i11++) {
                    double[] dArr3 = this.f1523a[i11];
                    dArr3[i2] = dArr3[i2] / this.f1523a[i2][i2];
                }
            }
            i2 = i6;
        }
    }

    public boolean isNonsingular() {
        for (int i = 0; i < this.c; i++) {
            if (this.f1523a[i][i] == 0.0d) {
                return false;
            }
        }
        return true;
    }

    public Matrix getL() {
        Matrix matrix = new Matrix(this.f1524b, this.c);
        double[][] array = matrix.getArray();
        for (int i = 0; i < this.f1524b; i++) {
            for (int i2 = 0; i2 < this.c; i2++) {
                if (i > i2) {
                    array[i][i2] = this.f1523a[i][i2];
                } else if (i == i2) {
                    array[i][i2] = 1.0d;
                } else {
                    array[i][i2] = 0.0d;
                }
            }
        }
        return matrix;
    }

    public Matrix getU() {
        Matrix matrix = new Matrix(this.c, this.c);
        double[][] array = matrix.getArray();
        for (int i = 0; i < this.c; i++) {
            for (int i2 = 0; i2 < this.c; i2++) {
                if (i <= i2) {
                    array[i][i2] = this.f1523a[i][i2];
                } else {
                    array[i][i2] = 0.0d;
                }
            }
        }
        return matrix;
    }

    public Matrix solve(Matrix matrix) {
        if (matrix.getRowDimension() != this.f1524b) {
            throw new IllegalArgumentException("Matrix row dimensions must agree.");
        } else if (isNonsingular()) {
            int columnDimension = matrix.getColumnDimension();
            Matrix matrix2 = matrix.getMatrix(this.e, 0, columnDimension - 1);
            double[][] array = matrix2.getArray();
            int i = 0;
            while (i < this.c) {
                int i2 = i + 1;
                for (int i3 = i2; i3 < this.c; i3++) {
                    for (int i4 = 0; i4 < columnDimension; i4++) {
                        double[] dArr = array[i3];
                        dArr[i4] = dArr[i4] - (array[i][i4] * this.f1523a[i3][i]);
                    }
                }
                i = i2;
            }
            for (int i5 = this.c - 1; i5 >= 0; i5--) {
                for (int i6 = 0; i6 < columnDimension; i6++) {
                    double[] dArr2 = array[i5];
                    dArr2[i6] = dArr2[i6] / this.f1523a[i5][i5];
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    for (int i8 = 0; i8 < columnDimension; i8++) {
                        double[] dArr3 = array[i7];
                        dArr3[i8] = dArr3[i8] - (array[i5][i8] * this.f1523a[i7][i5]);
                    }
                }
            }
            return matrix2;
        } else {
            throw new RuntimeException("Matrix is singular.");
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\util\Matrix.java ==========

package net.fxgear.util;

import java.io.Serializable;
import java.lang.reflect.Array;

public class Matrix implements Serializable, Cloneable {
    public double[][] A;

    /* renamed from: a  reason: collision with root package name */
    private int f1525a;

    /* renamed from: b  reason: collision with root package name */
    private int f1526b;

    public Matrix(int i, int i2) {
        this.f1525a = i;
        this.f1526b = i2;
        this.A = (double[][]) Array.newInstance(double.class, new int[]{i, i2});
    }

    public Matrix(int i, int i2, double d) {
        this.f1525a = i;
        this.f1526b = i2;
        this.A = (double[][]) Array.newInstance(double.class, new int[]{i, i2});
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                this.A[i3][i4] = d;
            }
        }
    }

    public Matrix copy() {
        Matrix matrix = new Matrix(this.f1525a, this.f1526b);
        double[][] array = matrix.getArray();
        for (int i = 0; i < this.f1525a; i++) {
            for (int i2 = 0; i2 < this.f1526b; i2++) {
                array[i][i2] = this.A[i][i2];
            }
        }
        return matrix;
    }

    public Object clone() {
        return copy();
    }

    public double[][] getArray() {
        return this.A;
    }

    public double[][] getArrayCopy() {
        double[][] dArr = (double[][]) Array.newInstance(double.class, new int[]{this.f1525a, this.f1526b});
        for (int i = 0; i < this.f1525a; i++) {
            for (int i2 = 0; i2 < this.f1526b; i2++) {
                dArr[i][i2] = this.A[i][i2];
            }
        }
        return dArr;
    }

    public int getRowDimension() {
        return this.f1525a;
    }

    public int getColumnDimension() {
        return this.f1526b;
    }

    public double get(int i, int i2) {
        return this.A[i][i2];
    }

    public Matrix getMatrix(int[] iArr, int i, int i2) {
        Matrix matrix = new Matrix(iArr.length, (i2 - i) + 1);
        double[][] array = matrix.getArray();
        int i3 = 0;
        while (i3 < iArr.length) {
            try {
                for (int i4 = i; i4 <= i2; i4++) {
                    array[i3][i4 - i] = this.A[iArr[i3]][i4];
                }
                i3++;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ArrayIndexOutOfBoundsException("Submatrix indices");
            }
        }
        return matrix;
    }

    public void set(int i, int i2, double d) {
        this.A[i][i2] = d;
    }

    public Matrix times(double d) {
        Matrix matrix = new Matrix(this.f1525a, this.f1526b);
        double[][] array = matrix.getArray();
        for (int i = 0; i < this.f1525a; i++) {
            for (int i2 = 0; i2 < this.f1526b; i2++) {
                array[i][i2] = this.A[i][i2] * d;
            }
        }
        return matrix;
    }

    public Matrix times(Matrix matrix) {
        if (matrix.f1525a == this.f1526b) {
            Matrix matrix2 = new Matrix(this.f1525a, matrix.f1526b);
            double[][] array = matrix2.getArray();
            double[] dArr = new double[this.f1526b];
            for (int i = 0; i < matrix.f1526b; i++) {
                for (int i2 = 0; i2 < this.f1526b; i2++) {
                    dArr[i2] = matrix.A[i2][i];
                }
                for (int i3 = 0; i3 < this.f1525a; i3++) {
                    double[] dArr2 = this.A[i3];
                    double d = 0.0d;
                    for (int i4 = 0; i4 < this.f1526b; i4++) {
                        d += dArr2[i4] * dArr[i4];
                    }
                    array[i3][i] = d;
                }
            }
            return matrix2;
        }
        throw new IllegalArgumentException("Matrix inner dimensions must agree.");
    }

    public static Matrix identity(int i, int i2) {
        Matrix matrix = new Matrix(i, i2);
        double[][] array = matrix.getArray();
        int i3 = 0;
        while (i3 < i) {
            int i4 = 0;
            while (i4 < i2) {
                array[i3][i4] = i3 == i4 ? 1.0d : 0.0d;
                i4++;
            }
            i3++;
        }
        return matrix;
    }

    public Matrix solve(Matrix matrix) {
        return this.f1525a == this.f1526b ? new LUDecomposition(this).solve(matrix) : new Matrix(this.f1525a, this.f1526b, 0.0d);
    }

    public Matrix inverse() {
        return solve(identity(this.f1525a, this.f1525a));
    }
}


