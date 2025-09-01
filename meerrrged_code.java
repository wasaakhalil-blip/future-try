

// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\a.java ==========

package net.fxgear.fitnshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/* compiled from: AvatarDataManager */
public class a {
    private static a d;

    /* renamed from: a  reason: collision with root package name */
    private final String f853a = "AvatarDataManager";

    /* renamed from: b  reason: collision with root package name */
    private final String f854b = "%s = ?";
    private C0027a c;

    public static a a(Context context) {
        if (d == null) {
            d = new a(context);
        }
        return d;
    }

    public boolean a() {
        SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
        boolean z = false;
        if (readableDatabase != null && readableDatabase.isOpen()) {
            Cursor query = readableDatabase.query("table_selected_avatar", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query != null) {
                if (query.getCount() > 0) {
                    z = true;
                }
                query.close();
            }
            readableDatabase.close();
        }
        return z;
    }

    public int a(int i, int i2) {
        SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
        int i3 = -1;
        if (readableDatabase != null && readableDatabase.isOpen()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%s = ?", new Object[]{"avatar_gender"}) + " AND ");
            sb.append(String.format("%s = ?", new Object[]{"avatar_age"}) + " AND ");
            sb.append(String.format("%s = ?", new Object[]{"avatar_default"}) + " AND ");
            sb.append(String.format("%s = ?", new Object[]{"avatar_removable"}));
            Cursor query = readableDatabase.query("table_selected_avatar", (String[]) null, sb.toString(), new String[]{String.valueOf(i), String.valueOf(i2), String.valueOf(1), String.valueOf(0)}, (String) null, (String) null, (String) null);
            if (query != null) {
                if (query.moveToFirst()) {
                    i3 = query.getInt(query.getColumnIndex("avatar_id"));
                }
                query.close();
            }
            readableDatabase.close();
        }
        return i3;
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
        if (writableDatabase != null && writableDatabase.isOpen()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("avatar_id", Integer.valueOf(i));
            contentValues.put("avatar_gender", Integer.valueOf(i2));
            contentValues.put("avatar_age", Integer.valueOf(i3));
            contentValues.put("avatar_default", Integer.valueOf(i4));
            contentValues.put("avatar_removable", Integer.valueOf(i5));
            writableDatabase.insert("table_selected_avatar", (String) null, contentValues);
            writableDatabase.close();
        }
    }

    public void a(int i) {
        SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.delete("table_selected_avatar", String.format("%s = ?", new Object[]{"avatar_id"}), new String[]{String.valueOf(i)});
            writableDatabase.close();
        }
    }

    public boolean b(int i) {
        int i2;
        SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
        if (readableDatabase == null || !readableDatabase.isOpen()) {
            i2 = 0;
        } else {
            Cursor query = readableDatabase.query("table_selected_avatar", (String[]) null, String.format("%s = ?", new Object[]{"avatar_id"}), new String[]{String.valueOf(i)}, (String) null, (String) null, (String) null);
            if (query != null) {
                i2 = query.moveToFirst() ? query.getInt(query.getColumnIndex("avatar_default")) : 0;
                query.close();
            } else {
                i2 = 0;
            }
            readableDatabase.close();
        }
        if (i2 == 1) {
            return true;
        }
        return false;
    }

    private a(Context context) {
        this.c = new C0027a(context, "avatar_data.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    /* renamed from: net.fxgear.fitnshop.a$a  reason: collision with other inner class name */
    /* compiled from: AvatarDataManager */
    private class C0027a extends SQLiteOpenHelper {

        /* renamed from: b  reason: collision with root package name */
        private final String f856b = C0027a.class.getSimpleName();
        private final String c = "CREATE TABLE IF NOT EXISTS table_selected_avatar(id INTEGER PRIMARY KEY AUTOINCREMENT, avatar_id INTEGER DEFAULT (-1),avatar_gender INTEGER DEFAULT (-1),avatar_age INTEGER DEFAULT (-1),avatar_default INTEGER DEFAULT (-1),avatar_removable INTEGER DEFAULT (-1));";

        public C0027a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
            String str2 = this.f856b;
            Log.d(str2, "DataBaseHelper()+, name : " + str + ", version : " + i);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Log.d(this.f856b, "onCreate()+");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS table_selected_avatar(id INTEGER PRIMARY KEY AUTOINCREMENT, avatar_id INTEGER DEFAULT (-1),avatar_gender INTEGER DEFAULT (-1),avatar_age INTEGER DEFAULT (-1),avatar_default INTEGER DEFAULT (-1),avatar_removable INTEGER DEFAULT (-1));");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            String str = this.f856b;
            Log.d(str, "onUpgrade()+, oldVersion : " + i + ", newVersion : " + i2);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\ApplicationClass.java ==========

package net.fxgear.fitnshop;

import android.app.Application;
import android.content.Context;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import net.fxgear.fitnshop.e.b;
import net.fxgear.fitnshop.e.f;

public class ApplicationClass extends Application {

    /* renamed from: a  reason: collision with root package name */
    public static Context f763a;

    /* renamed from: b  reason: collision with root package name */
    private final String f764b = ApplicationClass.class.getSimpleName();
    private final int c = 2;
    private int d = 0;
    private LinkedHashMap<String, ArrayList<b.a.C0035a>> e;

    public void onCreate() {
        super.onCreate();
        f763a = getApplicationContext();
        h.a(f763a);
        h.a();
        f.a(f763a, h.f1164b.u);
    }

    public void a(LinkedHashMap<String, ArrayList<b.a.C0035a>> linkedHashMap) {
        this.e = linkedHashMap;
    }

    public LinkedHashMap<String, ArrayList<b.a.C0035a>> a() {
        return this.e;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\AvatarFaceCameraActivity.java ==========

package net.fxgear.fitnshop;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.fxgear.GlobalDefine;
import net.fxgear.fitnshop.d.b;
import net.fxgear.fitnshop.d.d;
import net.fxgear.fitnshop.d.e;

public class AvatarFaceCameraActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public static final String f765a = (Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "FITNSHOP");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f766b = AvatarFaceCameraActivity.class.getSimpleName();
    private final int c = 2131165347;
    private final int d = 11;
    private final int e = 12;
    private Uri f;
    private d.a g = new d.a() {
        public void a(String str) {
            String a2 = AvatarFaceCameraActivity.this.f766b;
            Log.d(a2, "OnSavedImageFile()+, filePath: " + str);
            AvatarFaceCameraActivity avatarFaceCameraActivity = AvatarFaceCameraActivity.this;
            avatarFaceCameraActivity.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + str)));
            a aVar = new a();
            aVar.f769a = str;
            aVar.f770b = 0;
            aVar.c = false;
            AvatarFaceCameraActivity.this.a(-1, (Object) aVar);
        }

        public void a() {
            Log.d(AvatarFaceCameraActivity.this.f766b, "OnGoToGallery");
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            AvatarFaceCameraActivity.this.startActivityForResult(intent, 11);
        }

        public void a(int i, Object obj) {
            Log.d(AvatarFaceCameraActivity.this.f766b, "OnCloseCaptureView");
            AvatarFaceCameraActivity.this.a(i, obj);
        }
    };
    private e.a h = new e.a() {
        public void a(boolean z) {
            String a2 = AvatarFaceCameraActivity.this.f766b;
            Log.d(a2, "OnCloseGuideView()+, neverShowAgain: " + z);
            if (z) {
                SharedPreferences.Editor edit = AvatarFaceCameraActivity.this.getSharedPreferences("Avatar_Face_Preference", 0).edit();
                edit.putBoolean("BOOL_Never_Show_Changing_Face_Guide_Again", true);
                edit.commit();
            }
            AvatarFaceCameraActivity.this.c();
        }
    };

    private class a {

        /* renamed from: a  reason: collision with root package name */
        String f769a;

        /* renamed from: b  reason: collision with root package name */
        int f770b;
        boolean c;

        private a() {
            this.f769a = null;
            this.f770b = 0;
            this.c = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i(this.f766b, "onCreate()+");
        setContentView(2131296256);
        a();
    }

    private void a() {
        a((b) new d(this.g), 1);
        if (!getSharedPreferences("Avatar_Face_Preference", 0).getBoolean("BOOL_Never_Show_Changing_Face_Guide_Again", false)) {
            a((b) new e(this.h), 0);
        }
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra("face_picture_from_gallery", false)) {
            Intent intent2 = new Intent("android.intent.action.PICK");
            intent2.setType("image/*");
            startActivityForResult(intent2, 11);
        }
    }

    private Fragment b() {
        return getFragmentManager().findFragmentById(2131165347);
    }

    /* access modifiers changed from: private */
    public void c() {
        Log.d(this.f766b, "ClearFragmentStack()");
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        if (backStackEntryCount > 0) {
            String str = this.f766b;
            Log.e(str, "Remaing stack size(before) : " + backStackEntryCount);
            for (int i = 0; i < backStackEntryCount; i++) {
                Fragment findFragmentByTag = fragmentManager.findFragmentByTag(fragmentManager.getBackStackEntryAt(0).getName());
                String str2 = this.f766b;
                Log.e(str2, "Remove remaing stackFragment : " + findFragmentByTag.getTag());
                fragmentManager.popBackStackImmediate();
                beginTransaction.remove(findFragmentByTag);
            }
            String str3 = this.f766b;
            Log.e(str3, "Remaing stack size(after) : " + fragmentManager.getBackStackEntryCount());
        }
        beginTransaction.commit();
    }

    private void a(b bVar, int i) {
        String str = this.f766b;
        Log.d(str, "AddFragment()+, fragmentFlag: " + i);
        if (bVar != null) {
            String a2 = bVar.a();
            if (i != 0) {
                c();
                FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
                beginTransaction.setTransition(0);
                beginTransaction.add(2131165347, bVar, a2);
                beginTransaction.commit();
                return;
            }
            FragmentTransaction beginTransaction2 = getFragmentManager().beginTransaction();
            beginTransaction2.setTransition(0);
            Fragment b2 = b();
            if (b2 != null) {
                beginTransaction2.hide(b2);
            }
            beginTransaction2.add(2131165347, bVar, a2);
            beginTransaction2.addToBackStack(a2);
            beginTransaction2.commit();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Log.i(this.f766b, "onResume()+");
        h.b((Activity) this);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        Log.i(this.f766b, "onPause()+");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Log.i(this.f766b, "onDestroy()+");
        super.onDestroy();
    }

    public void onBackPressed() {
        Log.i(this.f766b, "OnBackPressed()+");
        Fragment b2 = b();
        if (b2 == null || !(b2 instanceof d)) {
            super.onBackPressed();
        } else {
            a(0, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i, Object obj) {
        String str = this.f766b;
        Log.i(str, "FinishAvatarFaceCameraActivity(), resultCode: " + i);
        Intent intent = new Intent();
        if (i == -1) {
            if (obj != null && (obj instanceof a)) {
                a aVar = (a) obj;
                intent.putExtra("face_image_file_path", aVar.f769a);
                intent.putExtra("face_image_file_orientation", aVar.f770b);
                intent.putExtra("face_picture_from_gallery", aVar.c);
            }
        } else if (i == 4 && obj != null && (obj instanceof Long)) {
            intent.putExtra("face_image_file_need_space_size", ((Long) obj).longValue());
        }
        setResult(i, intent);
        finish();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        r1 = r1.getPath();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r5, int r6, android.content.Intent r7) {
        /*
            r4 = this;
            r0 = -1
            if (r6 == r0) goto L_0x000b
            java.lang.String r5 = r4.f766b
            java.lang.String r6 = "resultCode != RESILT_OK"
            android.util.Log.e(r5, r6)
            return
        L_0x000b:
            if (r7 == 0) goto L_0x004b
            r1 = 11
            if (r5 != r1) goto L_0x0019
            android.net.Uri r0 = r7.getData()
            r4.a((android.net.Uri) r0)
            goto L_0x004b
        L_0x0019:
            r1 = 12
            if (r5 != r1) goto L_0x004b
            android.net.Uri r1 = r7.getData()
            if (r1 != 0) goto L_0x0025
            android.net.Uri r1 = r4.f
        L_0x0025:
            r2 = 0
            if (r1 == 0) goto L_0x0034
            java.lang.String r1 = r1.getPath()
            if (r1 == 0) goto L_0x0034
            java.io.File r3 = new java.io.File
            r3.<init>(r1)
            goto L_0x0035
        L_0x0034:
            r3 = r2
        L_0x0035:
            net.fxgear.fitnshop.AvatarFaceCameraActivity$a r1 = new net.fxgear.fitnshop.AvatarFaceCameraActivity$a
            r1.<init>()
            if (r3 == 0) goto L_0x0040
            java.lang.String r2 = r3.getAbsolutePath()
        L_0x0040:
            r1.f769a = r2
            r2 = 0
            r1.f770b = r2
            r2 = 1
            r1.c = r2
            r4.a((int) r0, (java.lang.Object) r1)
        L_0x004b:
            super.onActivityResult(r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.AvatarFaceCameraActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    private void a(Uri uri) {
        String str = this.f766b;
        Log.i(str, "RequestCropImage()+, uri : " + uri);
        if (uri != null) {
            File file = new File(f765a);
            if (!file.exists()) {
                file.mkdirs();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            this.f = Uri.fromFile(new File(f765a, simpleDateFormat.format(new Date(System.currentTimeMillis())) + GlobalDefine.EXTENSION_JPG));
            Intent intent = new Intent("com.android.camera.action.CROP");
            intent.setDataAndType(uri, "image/*");
            intent.putExtra("output", this.f);
            intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("scaleUpIfNeeded", true);
            intent.putExtra("scale", true);
            startActivityForResult(intent, 12);
            return;
        }
        Log.e(this.f766b, "RequestCropImage()-, imageUri is null");
        a aVar = new a();
        aVar.f769a = null;
        aVar.f770b = 0;
        aVar.c = true;
        a(-1, (Object) aVar);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\b.java ==========

package net.fxgear.fitnshop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import net.fxgear.GlobalDefine;

/* compiled from: CustomResizeView */
public class b extends View {

    /* renamed from: a  reason: collision with root package name */
    private final String f917a = "CustomResizeView";

    /* renamed from: b  reason: collision with root package name */
    private Context f918b;
    private Object c;
    private final float d = 0.6f;
    private int e;
    private int f;
    private int g;
    private int h;
    private float i;
    private float j;
    private float k;
    private String l;
    private Typeface m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r = false;
    private Bitmap s = null;
    private Bitmap t = null;
    private int u;
    private AbsListView.LayoutParams v;
    private AbsListView.LayoutParams w;

    public b(Context context, int i2, int i3, float f2, boolean z) {
        super(context);
        this.f918b = context;
        i2 = i2 < 1 ? 200 : i2;
        i3 = i3 < 1 ? 100 : i3;
        this.i = (float) i3;
        this.j = (float) i2;
        this.v = new AbsListView.LayoutParams(-1, i2);
        this.w = new AbsListView.LayoutParams(-1, i3);
        this.r = z;
        this.k = f2;
        setLayoutParams(this.r ? this.v : this.w);
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = i5;
    }

    public void a(String str, Typeface typeface) {
        this.l = str;
        if (typeface == null) {
            this.m = Typeface.create(Typeface.DEFAULT, 1);
        } else {
            this.m = typeface;
        }
        this.n = this.f918b.getResources().getDimensionPixelSize(2131034474);
        this.q = this.f918b.getResources().getColor(2130968695);
        this.p = this.f918b.getResources().getDimensionPixelSize(2131034473);
        this.o = this.f918b.getResources().getDimensionPixelSize(2131034472);
    }

    public void a(int i2) {
        this.u = i2;
    }

    public boolean a() {
        return this.r;
    }

    public void a(String str, Bitmap bitmap) {
        if (str != null && bitmap != null) {
            boolean z = true;
            if (str.equals("key_background_url")) {
                if (this.s != null) {
                    if (this.s.equals(bitmap)) {
                        Log.d("CustomResizeView", "skip - same bitmap.");
                        return;
                    } else if (!this.s.isRecycled()) {
                        this.s.recycle();
                        this.s = null;
                    }
                }
                this.s = bitmap;
            } else if (str.equals("key_logo_url")) {
                if (this.t != null) {
                    if (this.t.equals(bitmap)) {
                        Log.d("CustomResizeView", "skip - same bitmap.");
                        return;
                    } else if (!this.t.isRecycled()) {
                        this.t.recycle();
                        this.t = null;
                    }
                }
                this.t = bitmap;
            } else {
                z = false;
            }
            if (z) {
                invalidate();
            }
        }
    }

    public void a(float f2) {
        float f3 = ((this.j - this.i) * f2) + this.i;
        if (f3 < this.i) {
            f3 = this.i;
        } else if (f3 > this.j) {
            f3 = this.j;
        }
        if (Float.compare(f2, 1.0f) == 0) {
            this.r = true;
        } else {
            this.r = false;
        }
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) getLayoutParams();
        if (((float) layoutParams.height) != f3) {
            layoutParams.height = (int) f3;
            setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        float height = 1.0f - ((this.j - ((float) canvas.getHeight())) / (this.j - this.i));
        colorMatrix.setSaturation(height);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        if (this.s != null) {
            Matrix matrix = new Matrix();
            matrix.setTranslate(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, -(((this.j * this.k) - (this.i / 2.0f)) * (1.0f - height)));
            canvas.drawBitmap(this.s, matrix, paint);
            canvas.drawColor(((int) ((0.6f - (height * 0.6f)) * 255.0f)) << 24);
        } else {
            canvas.drawColor(this.u);
        }
        Paint paint2 = new Paint();
        paint2.setTypeface(this.m);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setTextSize((float) this.n);
        paint2.setColor(this.q);
        Rect rect = new Rect();
        paint2.getTextBounds(this.l, 0, this.l.length(), rect);
        int width = (canvas.getWidth() / 2) - (rect.width() / 2);
        int height2 = canvas.getHeight() - this.o;
        if (Float.compare(height, 1.0f) == 0) {
            canvas.drawText(this.l, (float) width, (float) height2, paint2);
        }
        float height3 = (float) (this.o + rect.height() + this.p);
        if (this.t != null) {
            Matrix matrix2 = new Matrix();
            float height4 = (float) this.t.getHeight();
            float f2 = (this.i - height4) / 2.0f;
            matrix2.setTranslate((float) ((canvas.getWidth() - this.g) / 2), (((float) canvas.getHeight()) - height4) - (f2 + ((height3 - f2) * height)));
            canvas.drawBitmap(this.t, matrix2, paint);
        }
        super.onDraw(canvas);
    }

    public void setCacheTask(Object obj) {
        this.c = obj;
    }

    public Object getCacheTask() {
        return this.c;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\c.java ==========

package net.fxgear.fitnshop;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import net.fxgear.GlobalDefine;
import net.fxgear.fitnshop.a.f;
import net.fxgear.fitnshop.e.b;

/* compiled from: CustomResizeViewListAdpter */
public class c extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final String f946a = "CustomResizeViewListAdpter";

    /* renamed from: b  reason: collision with root package name */
    private Context f947b;
    private f c;
    private View.OnClickListener d;
    private ArrayList<a> e;
    private View f;
    private View g;
    private int h = 0;
    private int[] i = {2130968621, 2130968622, 2130968623, 2130968624};

    public long getItemId(int i2) {
        return (long) i2;
    }

    public int getViewTypeCount() {
        return 3;
    }

    public c(Context context, f fVar) {
        this.f947b = context;
        this.c = fVar;
        this.e = new ArrayList<>();
    }

    public void a(int i2, String str, String str2, int i3, int i4, String str3, int i5, int i6, int i7, int i8, float f2, boolean z, String str4, String str5, int i9, int i10) {
        Log.i("CustomResizeViewListAdpter", "AddData()");
        ArrayList<a> arrayList = this.e;
        a aVar = r0;
        a aVar2 = new a(this, i2, str, str2, i3, i4, str3, i5, i6, i7, i8, f2, z, str4, str5, i9, i10);
        arrayList.add(aVar);
    }

    public void a(View view) {
        this.f = view;
    }

    public void b(View view) {
        this.g = view;
    }

    public void a(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    public void a(int i2) {
        this.h = i2;
    }

    public int getCount() {
        if (this.e != null) {
            return this.e.size();
        }
        Log.e("CustomResizeViewListAdpter", "getCount(), DataList is null!");
        return -1;
    }

    public Object getItem(int i2) {
        if (this.e == null) {
            Log.e("CustomResizeViewListAdpter", "getItem(), DataList is null!");
            return null;
        } else if (i2 >= 0 && i2 < this.e.size()) {
            return this.e.get(i2);
        } else {
            Log.e("CustomResizeViewListAdpter", "getItem(), index is wrong, position = " + i2 + ", dataList size = " + this.e.size());
            return null;
        }
    }

    public int getItemViewType(int i2) {
        if (i2 == 0) {
            return 0;
        }
        return i2 == getCount() - 1 ? 1 : 2;
    }

    public float b(int i2) {
        if (this.e == null) {
            Log.e("CustomResizeViewListAdpter", "GetItemMaxHeight(), DataList is null!");
            return GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        } else if (i2 >= 0 && i2 < this.e.size()) {
            return (float) this.e.get(i2).j();
        } else {
            Log.e("CustomResizeViewListAdpter", "GetItemMaxHeight(), index is wrong, index = " + i2 + ", dataList size = " + this.e.size());
            return GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        }
    }

    public int c(int i2) {
        if (this.e == null || i2 <= 0 || i2 >= this.e.size()) {
            return -2;
        }
        return this.e.get(i2).b();
    }

    public String d(int i2) {
        if (this.e == null || i2 <= 0 || i2 >= this.e.size()) {
            return null;
        }
        return this.e.get(i2).c();
    }

    public void a(int i2, b.a aVar) {
        if (aVar != null && this.e != null && i2 > 0 && i2 < this.e.size()) {
            this.e.get(i2).a(aVar);
        }
    }

    public b.a e(int i2) {
        if (this.e == null || i2 <= 0 || i2 >= this.e.size()) {
            return null;
        }
        return this.e.get(i2).o();
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        Log.i("CustomResizeViewListAdpter", "getView(), position = " + i2);
        int itemViewType = getItemViewType(i2);
        if (this.f != null && itemViewType == 0) {
            return this.f;
        }
        if (this.g == null || itemViewType != 1) {
            a aVar = this.e.get(i2);
            if (view == null || !(view instanceof b)) {
                Log.i("CustomResizeViewListAdpter", "getView(), make new view");
                bVar = new b(this.f947b, aVar.j(), aVar.k(), aVar.l(), aVar.m());
            } else {
                Log.i("CustomResizeViewListAdpter", "getView(), recycle view");
                bVar = (b) view;
            }
            if (i2 < this.h) {
                bVar.a(1.0f);
            } else if (i2 > this.h) {
                bVar.a((float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
            }
            bVar.a(aVar.n(), (Typeface) null);
            bVar.a(aVar.e(), aVar.f(), aVar.h(), aVar.i());
            bVar.setOnClickListener(this.d);
            bVar.setTag(Integer.valueOf(i2));
            bVar.a(this.f947b.getResources().getColor(this.i[i2 % this.i.length]));
            HashMap hashMap = new HashMap();
            hashMap.put("key_background_url", aVar.d());
            hashMap.put("key_logo_url", aVar.g());
            this.c.a((HashMap<String, Object>) hashMap, bVar);
            return bVar;
        }
        View view2 = this.g;
        a aVar2 = this.e.get(i2);
        if (i2 <= this.h) {
            return view2;
        }
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.g.getLayoutParams();
        layoutParams.height = aVar2.k() * 2;
        this.g.setLayoutParams(layoutParams);
        return view2;
    }

    public void a() {
        if (this.e != null) {
            int size = this.e.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.e.get(i2).a();
            }
            this.e.clear();
            this.e = null;
        }
        if (this.d != null) {
            this.d = null;
        }
        if (this.f947b != null) {
            this.f947b = null;
        }
    }

    /* compiled from: CustomResizeViewListAdpter */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f948a;

        /* renamed from: b  reason: collision with root package name */
        private int f949b;
        private String c;
        private b.a d;
        private String e;
        private int f;
        private int g;
        private String h;
        private int i;
        private int j;
        private int k;
        private int l;
        private float m;
        private boolean n;
        private String o;
        private String p;
        private int q;
        private int r;

        public a(c cVar, int i2, String str, String str2, int i3, int i4, String str3, int i5, int i6, int i7, int i8, float f2, boolean z, String str4, String str5, int i9, int i10) {
            this.f948a = cVar;
            this.f949b = i2;
            this.c = str;
            this.e = str2;
            this.f = i3;
            this.g = i4;
            this.h = str3;
            this.i = i5;
            this.j = i6;
            this.k = i7;
            this.l = i8;
            this.m = f2;
            this.n = z;
            this.o = str4;
            this.p = str5;
            this.q = i9;
            this.r = i10;
        }

        public void a() {
            this.e = null;
            this.f = 0;
            this.g = 0;
            this.h = null;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.l = 0;
            this.m = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            this.o = null;
            this.p = null;
            this.q = 0;
            this.r = 0;
            this.f949b = 0;
            this.c = null;
            this.d = null;
        }

        public int b() {
            return this.f949b;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.e;
        }

        public int e() {
            return this.f;
        }

        public int f() {
            return this.g;
        }

        public String g() {
            return this.h;
        }

        public int h() {
            return this.i;
        }

        public int i() {
            return this.j;
        }

        public int j() {
            return this.k;
        }

        public int k() {
            return this.l;
        }

        public float l() {
            return this.m;
        }

        public boolean m() {
            return this.n;
        }

        public String n() {
            return this.o;
        }

        public void a(b.a aVar) {
            this.d = aVar;
        }

        public b.a o() {
            return this.d;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\d.java ==========

package net.fxgear.fitnshop;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.CancellationSignal;
import android.util.Log;
import net.fxgear.GlobalDefine;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DataManager */
public class d {
    private static d c;

    /* renamed from: a  reason: collision with root package name */
    private final String f966a = ",";

    /* renamed from: b  reason: collision with root package name */
    private a f967b;

    public static d a(Context context) {
        if (c == null) {
            c = new d(context);
        }
        return c;
    }

    private d(Context context) {
        this.f967b = new a(context, "data.db", (SQLiteDatabase.CursorFactory) null, !h.f1164b.h() ? 3 : 2);
    }

    public String[] a() {
        i.a("DataManager", "GetAllWishlistItemUUIDArray()+");
        SQLiteDatabase readableDatabase = this.f967b.getReadableDatabase();
        String[] strArr = null;
        if (readableDatabase != null && readableDatabase.isOpen()) {
            int i = 0;
            Cursor query = readableDatabase.query(true, "table_wishitem", new String[]{"product_uuid"}, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null, (CancellationSignal) null);
            if (query != null) {
                int count = query.getCount();
                if (count > 0) {
                    String[] strArr2 = new String[count];
                    if (query.moveToFirst()) {
                        do {
                            strArr2[i] = query.getString(query.getColumnIndex("product_uuid"));
                            i.c("DataManager", "[" + i + "] product uuid : " + strArr2[i]);
                            i++;
                        } while (query.moveToNext());
                    }
                    strArr = strArr2;
                }
                query.close();
            }
            readableDatabase.close();
        }
        return strArr;
    }

    public int b() {
        i.a("DataManager", "GetWishlistItemCount()+");
        SQLiteDatabase readableDatabase = this.f967b.getReadableDatabase();
        int i = 0;
        if (readableDatabase != null && readableDatabase.isOpen()) {
            Cursor query = readableDatabase.query(true, "table_wishitem", new String[]{"product_uuid"}, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null, (CancellationSignal) null);
            if (query != null) {
                i = query.getCount();
                query.close();
            }
            readableDatabase.close();
        }
        return i;
    }

    public synchronized boolean a(String str, String[] strArr, String[] strArr2, boolean z) {
        i.a("DataManager", "AddWishItem()+, product uuid : " + str);
        boolean z2 = false;
        if (!(str == null || strArr == null || strArr.length == 0 || strArr2 == null)) {
            if (strArr2.length != 0) {
                if (b(str)) {
                    Log.d("DataManager", "exist item.");
                    return false;
                }
                for (int i = 0; i < strArr.length; i++) {
                    i.a("DataManager", "    td uuid[" + i + "] : " + strArr[i]);
                }
                SQLiteDatabase writableDatabase = this.f967b.getWritableDatabase();
                if (writableDatabase != null && writableDatabase.isOpen()) {
                    writableDatabase.beginTransaction();
                    try {
                        SQLiteStatement compileStatement = writableDatabase.compileStatement(String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES (?, ?, ?, ?)", new Object[]{"table_wishitem", "product_uuid", "td_uuid", "category_id_list", "is_sample"}));
                        for (int i2 = 0; i2 < strArr.length; i2++) {
                            if (strArr[i2] != null) {
                                compileStatement.bindString(1, str);
                                compileStatement.bindString(2, strArr[i2]);
                                compileStatement.bindString(3, a(strArr2));
                                compileStatement.bindString(4, String.valueOf(z ? 1 : 0));
                                compileStatement.execute();
                                compileStatement.clearBindings();
                            }
                        }
                        writableDatabase.setTransactionSuccessful();
                        i.b("DataManager", "AddWishItem() Done");
                        writableDatabase.endTransaction();
                        z2 = true;
                    } catch (Exception e) {
                        try {
                            e.printStackTrace();
                        } finally {
                            writableDatabase.endTransaction();
                        }
                    }
                    writableDatabase.close();
                }
                i.a("DataManager", "result : " + z2);
                return z2;
            }
        }
        i.c("DataManager", "ERROR :: param error.");
        return false;
    }

    public synchronized boolean a(String str, String[] strArr, String[] strArr2, boolean z, int i, int i2) {
        String str2 = str;
        String[] strArr3 = strArr;
        String[] strArr4 = strArr2;
        synchronized (this) {
            i.a("DataManager", "AddWishItem()+, product uuid : " + str2);
            boolean z2 = false;
            if (!(str2 == null || strArr3 == null || strArr3.length == 0 || strArr4 == null)) {
                if (strArr4.length != 0) {
                    if (b(str)) {
                        Log.d("DataManager", "exist item.");
                        return false;
                    }
                    for (int i3 = 0; i3 < strArr3.length; i3++) {
                        i.a("DataManager", "    td uuid[" + i3 + "] : " + strArr3[i3]);
                    }
                    SQLiteDatabase writableDatabase = this.f967b.getWritableDatabase();
                    if (writableDatabase != null && writableDatabase.isOpen()) {
                        writableDatabase.beginTransaction();
                        try {
                            SQLiteStatement compileStatement = writableDatabase.compileStatement(String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?)", new Object[]{"table_wishitem", "product_uuid", "td_uuid", "category_id_list", "is_sample", "gender", "age"}));
                            for (int i4 = 0; i4 < strArr3.length; i4++) {
                                if (strArr3[i4] != null) {
                                    compileStatement.bindString(1, str2);
                                    compileStatement.bindString(2, strArr3[i4]);
                                    compileStatement.bindString(3, a(strArr4));
                                    compileStatement.bindString(4, String.valueOf(z ? 1 : 0));
                                    compileStatement.bindString(5, String.valueOf(i));
                                    compileStatement.bindString(6, String.valueOf(i2));
                                    compileStatement.execute();
                                    compileStatement.clearBindings();
                                }
                            }
                            writableDatabase.setTransactionSuccessful();
                            i.b("DataManager", "AddWishItem() Done");
                            writableDatabase.endTransaction();
                            z2 = true;
                        } catch (Exception e) {
                            try {
                                e.printStackTrace();
                            } finally {
                                writableDatabase.endTransaction();
                            }
                        }
                        writableDatabase.close();
                    }
                    i.a("DataManager", "result : " + z2);
                    return z2;
                }
            }
            i.c("DataManager", "ERROR :: param error.");
            return false;
        }
    }

    public synchronized boolean a(String str) {
        i.a("DataManager", "DeleteWishItem()+, product uuid : " + str);
        boolean z = false;
        if (str == null) {
            return false;
        }
        SQLiteDatabase writableDatabase = this.f967b.getWritableDatabase();
        if (writableDatabase != null && writableDatabase.isOpen()) {
            if (writableDatabase.delete("table_wishitem", String.format("%s = ?", new Object[]{"product_uuid"}), new String[]{str}) > 0) {
                z = true;
            }
            writableDatabase.close();
        }
        i.a("DataManager", "result : " + z);
        return z;
    }

    public boolean b(String str) {
        i.a("DataManager", "IsContainItem()+, product uuid : " + str);
        boolean z = false;
        if (str == null) {
            return false;
        }
        SQLiteDatabase readableDatabase = this.f967b.getReadableDatabase();
        if (readableDatabase != null && readableDatabase.isOpen()) {
            Cursor query = readableDatabase.query("table_wishitem", (String[]) null, String.format("%s = ?", new Object[]{"product_uuid"}), new String[]{str}, (String) null, (String) null, (String) null);
            if (query != null) {
                if (query.getCount() > 0) {
                    z = true;
                }
                query.close();
            }
            readableDatabase.close();
        }
        i.a("DataManager", "result : " + z);
        return z;
    }

    public JSONArray a(String str, boolean z) throws JSONException {
        String str2;
        String str3;
        String str4;
        if (str == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        SQLiteDatabase readableDatabase = this.f967b.getReadableDatabase();
        if (readableDatabase != null && readableDatabase.isOpen()) {
            Cursor query = readableDatabase.query("table_wishitem", (String[]) null, String.format("%s = ?", new Object[]{"product_uuid"}), new String[]{str}, (String) null, (String) null, (String) null);
            if (query != null) {
                if (query.moveToFirst()) {
                    do {
                        if (z) {
                            if (!h.f1164b.h()) {
                                str3 = query.getString(query.getColumnIndex("product_uuid"));
                            } else {
                                str3 = query.getString(query.getColumnIndex("td_uuid"));
                            }
                            String[] c2 = c(query.getString(query.getColumnIndex("category_id_list")));
                            int i = query.getInt(query.getColumnIndex("is_sample"));
                            if (!(str3 == null || c2 == null || c2.length <= 0)) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (String put : c2) {
                                    jSONArray2.put(put);
                                }
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("category_id", jSONArray2);
                                jSONObject.put("uuid", str3);
                                jSONObject.put("sample", String.valueOf(i));
                                if (!h.f1164b.h()) {
                                    int i2 = query.getInt(query.getColumnIndex("gender"));
                                    int i3 = query.getInt(query.getColumnIndex("age"));
                                    switch (i2) {
                                        case 2:
                                            str4 = GlobalDefine.GENDER_MAN_STRING;
                                            break;
                                        case 3:
                                            str4 = GlobalDefine.GENDER_UNISEX_STRING;
                                            break;
                                        default:
                                            str4 = GlobalDefine.GENDER_WOMAN_STRING;
                                            break;
                                    }
                                    jSONObject.put("gender", str4);
                                    jSONObject.put("age", i3 != 1 ? i3 != 3 ? GlobalDefine.AGE_MIDDLE_STRING : GlobalDefine.AGE_LATE_STRING : GlobalDefine.AGE_EARLY_STRING);
                                }
                                jSONArray.put(jSONObject);
                            }
                        } else {
                            if (!h.f1164b.h()) {
                                str2 = query.getString(query.getColumnIndex("product_uuid"));
                            } else {
                                str2 = query.getString(query.getColumnIndex("td_uuid"));
                            }
                            if (str2 != null) {
                                jSONArray.put(str2);
                            }
                        }
                    } while (query.moveToNext());
                }
                query.close();
            }
            readableDatabase.close();
        }
        return jSONArray;
    }

    public JSONArray c() throws JSONException {
        String str;
        String str2;
        JSONArray jSONArray = new JSONArray();
        SQLiteDatabase readableDatabase = this.f967b.getReadableDatabase();
        if (readableDatabase != null && readableDatabase.isOpen()) {
            Cursor query = readableDatabase.query("table_wishitem", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query != null) {
                if (query.moveToFirst()) {
                    do {
                        if (!h.f1164b.h()) {
                            str = query.getString(query.getColumnIndex("product_uuid"));
                        } else {
                            str = query.getString(query.getColumnIndex("td_uuid"));
                        }
                        String[] c2 = c(query.getString(query.getColumnIndex("category_id_list")));
                        int i = query.getInt(query.getColumnIndex("is_sample"));
                        if (!(str == null || c2 == null || c2.length <= 0)) {
                            JSONArray jSONArray2 = new JSONArray();
                            for (String put : c2) {
                                jSONArray2.put(put);
                            }
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("category_id", jSONArray2);
                            jSONObject.put("uuid", str);
                            jSONObject.put("sample", String.valueOf(i));
                            if (!h.f1164b.h()) {
                                int i2 = query.getInt(query.getColumnIndex("gender"));
                                int i3 = query.getInt(query.getColumnIndex("age"));
                                switch (i2) {
                                    case 2:
                                        str2 = GlobalDefine.GENDER_MAN_STRING;
                                        break;
                                    case 3:
                                        str2 = GlobalDefine.GENDER_UNISEX_STRING;
                                        break;
                                    default:
                                        str2 = GlobalDefine.GENDER_WOMAN_STRING;
                                        break;
                                }
                                jSONObject.put("gender", str2);
                                jSONObject.put("age", i3 != 1 ? i3 != 3 ? GlobalDefine.AGE_MIDDLE_STRING : GlobalDefine.AGE_LATE_STRING : GlobalDefine.AGE_EARLY_STRING);
                            }
                            jSONArray.put(jSONObject);
                        }
                    } while (query.moveToNext());
                }
                query.close();
            }
            readableDatabase.close();
        }
        return jSONArray;
    }

    public synchronized boolean d() {
        boolean z;
        int b2;
        int f = h.f1164b.f();
        z = false;
        if (f >= 0 && (b2 = b()) >= f) {
            if (f > 0) {
                b2 = (b2 - f) + 1;
            }
            SQLiteDatabase writableDatabase = this.f967b.getWritableDatabase();
            if (writableDatabase != null && writableDatabase.isOpen()) {
                for (int i = 0; i < b2; i++) {
                    writableDatabase.execSQL("DELETE FROM table_wishitem WHERE product_uuid = (SELECT DISTINCT product_uuid FROM table_wishitem ORDER BY id LIMIT 1);");
                }
                writableDatabase.close();
            }
            if (b() < f) {
                z = true;
            }
        }
        return z;
    }

    private String a(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(str);
        }
        return sb.toString();
    }

    private String[] c(String str) {
        if (str != null) {
            return str.split(",");
        }
        return null;
    }

    /* compiled from: DataManager */
    private class a extends SQLiteOpenHelper {

        /* renamed from: b  reason: collision with root package name */
        private final String f969b;
        private final String c;
        private final String d;

        private a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
            this.f969b = "DataBaseHelper";
            this.c = "CREATE TABLE IF NOT EXISTS table_wishitem(id INTEGER PRIMARY KEY AUTOINCREMENT, product_uuid TEXT DEFAULT (NULL), td_uuid TEXT DEFAULT (NULL), category_id_list TEXT DEFAULT (NULL), is_sample INTEGER DEFAULT (0) );";
            this.d = "CREATE TABLE IF NOT EXISTS table_wishitem(id INTEGER PRIMARY KEY AUTOINCREMENT, product_uuid TEXT DEFAULT (NULL), td_uuid TEXT DEFAULT (NULL), category_id_list TEXT DEFAULT (NULL), is_sample INTEGER DEFAULT (0), gender INTEGER DEFAULT (1), age INTEGER DEFAULT (2) );";
            i.a("DataBaseHelper", "DataBaseHelper()+, name : " + str + ", version : " + i);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            i.a("DataBaseHelper", "onCreate()+");
            if (!h.f1164b.h()) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS table_wishitem(id INTEGER PRIMARY KEY AUTOINCREMENT, product_uuid TEXT DEFAULT (NULL), td_uuid TEXT DEFAULT (NULL), category_id_list TEXT DEFAULT (NULL), is_sample INTEGER DEFAULT (0), gender INTEGER DEFAULT (1), age INTEGER DEFAULT (2) );");
            } else {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS table_wishitem(id INTEGER PRIMARY KEY AUTOINCREMENT, product_uuid TEXT DEFAULT (NULL), td_uuid TEXT DEFAULT (NULL), category_id_list TEXT DEFAULT (NULL), is_sample INTEGER DEFAULT (0) );");
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            i.a("DataBaseHelper", "onUpgrade()+, oldVersion : " + i + ", newVersion : " + i2);
            while (i < i2) {
                switch (i) {
                    case 1:
                        sQLiteDatabase.execSQL(String.format("ALTER TABLE %s ADD %s INTEGER DEFAULT %d;", new Object[]{"table_wishitem", "is_sample", 0}));
                        break;
                    case 2:
                        sQLiteDatabase.execSQL("DELETE FROM table_wishitem;");
                        sQLiteDatabase.execSQL(String.format("ALTER TABLE %s ADD %s INTEGER DEFAULT %d;", new Object[]{"table_wishitem", "gender", 1}));
                        sQLiteDatabase.execSQL(String.format("ALTER TABLE %s ADD %s INTEGER DEFAULT %d;", new Object[]{"table_wishitem", "age", 2}));
                        break;
                }
                i++;
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\e.java ==========

package net.fxgear.fitnshop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.k;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import net.fxgear.fitnshop.c.b;
import net.fxgear.fitnshop.e.c;
import net.fxgear.fitnshop.e.d;

/* compiled from: FNSPagerLayout */
public class e extends LinearLayout {
    /* access modifiers changed from: private */
    public TextView A;
    /* access modifiers changed from: private */
    public LayoutInflater B;
    /* access modifiers changed from: private */
    public b C;
    /* access modifiers changed from: private */
    public d.C0037d D;
    /* access modifiers changed from: private */
    public SwipeRefreshLayout E;
    /* access modifiers changed from: private */
    public ArrayList<c.a> F;
    /* access modifiers changed from: private */
    public int G;
    /* access modifiers changed from: private */
    public int H;
    /* access modifiers changed from: private */
    public View I;
    private final int J;
    private final int K;
    private View L;
    /* access modifiers changed from: private */
    public ViewPager M;
    /* access modifiers changed from: private */
    public f N;
    /* access modifiers changed from: private */
    public RadioGroup O;
    /* access modifiers changed from: private */
    public int P;
    /* access modifiers changed from: private */
    public int Q;
    private ViewPager.f R;
    /* access modifiers changed from: private */
    public View.OnClickListener S;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f1063a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1064b;
    private final int c;
    private final int d;
    private final int e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final float n;
    private final float o;
    /* access modifiers changed from: private */
    public Context p;
    /* access modifiers changed from: private */
    public net.fxgear.fitnshop.a.d q;
    private int r;
    private int s;
    /* access modifiers changed from: private */
    public String t;
    /* access modifiers changed from: private */
    public String u;
    /* access modifiers changed from: private */
    public int v;
    /* access modifiers changed from: private */
    public ListView w;
    /* access modifiers changed from: private */
    public a x;
    /* access modifiers changed from: private */
    public C0038e y;
    private LinearLayout z;

    /* compiled from: FNSPagerLayout */
    public interface b {
        void a();

        void a(int i);

        void a(ListView listView, int i, int i2);

        void a(d.a.b bVar);

        void a(e eVar, int i);

        boolean a(c.a aVar);

        boolean a(c.a aVar, boolean z);

        void b(int i);

        void b(c.a aVar);
    }

    public e(Context context, int i2, net.fxgear.fitnshop.a.d dVar, String str, int i3) {
        this(context, i2, dVar, -2, -2, str, i3);
    }

    public e(Context context, int i2, net.fxgear.fitnshop.a.d dVar, int i3, int i4, String str, int i5) {
        super(context);
        this.f1063a = e.class.getSimpleName();
        this.f1064b = 2;
        this.c = 0;
        this.d = 1;
        this.e = -1;
        this.f = "KRW";
        this.g = "CNY";
        this.h = "UDS";
        this.i = "원";
        this.j = "元";
        this.k = "US $";
        this.l = "%s%s";
        this.m = "sample";
        this.n = 1.0f;
        this.o = 0.5f;
        this.p = null;
        this.q = null;
        this.r = -2;
        this.s = -2;
        this.t = null;
        this.u = null;
        this.v = 0;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = 0;
        this.K = 200;
        this.R = new ViewPager.f() {
            public void a(int i, float f, int i2) {
            }

            public void b(int i) {
            }

            public void a(int i) {
                e.this.a(i);
            }
        };
        this.S = new View.OnClickListener() {
            public void onClick(View view) {
                int intValue;
                int intValue2;
                int intValue3;
                int id = view.getId();
                if (id != 2131165201) {
                    if (id != 2131165341) {
                        if (id == 2131165419 && e.this.C != null && (intValue3 = ((Integer) view.getTag()).intValue()) >= 0 && intValue3 < e.this.F.size()) {
                            if (e.this.C.a((c.a) e.this.F.get(intValue3))) {
                                ViewGroup viewGroup = (ViewGroup) view.getParent();
                                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                                    View childAt = viewGroup.getChildAt(i);
                                    if (childAt.getId() == 2131165201) {
                                        ((CheckBox) childAt).setChecked(true);
                                        return;
                                    }
                                }
                            }
                        }
                    } else if (e.this.C != null && (intValue2 = ((Integer) view.getTag()).intValue()) >= 0 && intValue2 < e.this.F.size()) {
                        e.this.C.b((c.a) e.this.F.get(intValue2));
                    }
                } else if (e.this.C != null && (intValue = ((Integer) view.getTag()).intValue()) >= 0 && intValue < e.this.F.size()) {
                    CheckBox checkBox = (CheckBox) view;
                    if (!e.this.C.a((c.a) e.this.F.get(intValue), checkBox.isChecked())) {
                        checkBox.setChecked(!checkBox.isChecked());
                    }
                }
            }
        };
        this.p = context;
        this.q = dVar;
        this.r = i3;
        this.s = i4;
        this.u = str;
        this.v = i5;
        this.H = i2;
        this.J = i2;
        inflate(context, 2131296263, this);
        k();
    }

    public void a(b bVar) {
        this.C = bVar;
    }

    @SuppressLint({"ResourceAsColor"})
    private void k() {
        this.B = (LayoutInflater) this.p.getSystemService("layout_inflater");
        this.P = getResources().getDimensionPixelSize(2131034367);
        this.Q = getResources().getDimensionPixelSize(2131034355);
        this.F = new ArrayList<>();
        this.E = (SwipeRefreshLayout) findViewById(2131165411);
        this.E.setColorSchemeResources(2130968672);
        this.E.setProgressBackgroundColor(2130968673);
        this.E.a(true, this.J, this.J + 200);
        this.E.setOnRefreshListener(new SwipeRefreshLayout.b() {
            public void a() {
                e.this.E.setRefreshing(true);
                e.this.c();
            }
        });
        this.w = (ListView) findViewById(2131165391);
        this.y = new C0038e(this.w);
        this.w.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (e.this.C != null) {
                    e.this.C.a(e.this, i);
                }
                if (e.this.E != null && e.this.I != null) {
                    if (i == 0 && e.this.I.getTop() == 0 && e.this.I.getLayoutParams().height == e.this.H) {
                        e.this.E.setEnabled(true);
                    } else {
                        e.this.E.setEnabled(false);
                    }
                }
            }

            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!(e.this.y == null || e.this.C == null)) {
                    e.this.C.a(e.this.w, i, e.this.y.a(i, i2));
                }
                if (i3 <= 0 || e.this.G <= e.this.F.size() || i + i2 != i3 || e.this.w.getChildAt(i2 - 1).getBottom() != e.this.w.getHeight() || e.this.D != null) {
                    return;
                }
                if (h.d(e.this.p)) {
                    e.this.a(e.this.F.size(), 20, e.this.u, e.this.v);
                } else {
                    e.this.l();
                }
            }
        });
        this.I = new View(this.p);
        this.I.setLayoutParams(new AbsListView.LayoutParams(-1, this.H));
        this.w.addHeaderView(this.I);
        if (h.f1164b.e() && this.r == -1 && this.s == -1) {
            this.L = LayoutInflater.from(getContext()).inflate(2131296313, (ViewGroup) null);
            this.O = (RadioGroup) this.L.findViewById(2131165399);
            this.M = (ViewPager) this.L.findViewById(2131165428);
            this.M.a(this.R);
            this.M.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                        case 2:
                            e.this.w.requestDisallowInterceptTouchEvent(true);
                            e.this.E.setEnabled(false);
                            break;
                        case 1:
                        case 3:
                            e.this.w.requestDisallowInterceptTouchEvent(false);
                            e.this.E.setEnabled(true);
                            break;
                    }
                    return false;
                }
            });
            this.N = new f();
            this.M.setAdapter(this.N);
            this.L.setLayoutParams(new AbsListView.LayoutParams(-1, this.M.getLayoutParams().height));
            this.w.addHeaderView(this.L);
        }
        this.x = new a();
        this.w.setAdapter(this.x);
        this.A = (TextView) findViewById(2131165390);
        this.A.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        int id;
        String str = this.f1063a;
        Log.d(str, "SetViewPageRadioIndex()+, index : " + i2);
        if (this.O != null && i2 < this.O.getChildCount() && i2 >= 0 && (id = this.O.getChildAt(i2).getId()) != -1) {
            this.O.check(id);
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        if (this.p instanceof FitNShopMainActivity) {
            ((FitNShopMainActivity) this.p).a((b.a) new b.a() {
                public void a(net.fxgear.fitnshop.c.b bVar) {
                    bVar.dismiss();
                    if (h.d(e.this.p)) {
                        e.this.a(e.this.F.size(), 20, e.this.u, e.this.v);
                    } else {
                        e.this.l();
                    }
                }

                public void b(net.fxgear.fitnshop.c.b bVar) {
                    bVar.dismiss();
                }
            });
        }
    }

    public void a() {
        Log.d(this.f1063a, "ClearClothesItem()+");
        if (this.F != null) {
            this.F.clear();
        }
        this.x.notifyDataSetChanged();
    }

    public void b() {
        Log.d(this.f1063a, "RequestClothesItem()+");
        FitNShopMainActivity fitNShopMainActivity = (FitNShopMainActivity) this.p;
        a((String) null, fitNShopMainActivity.e(), fitNShopMainActivity.g());
    }

    public void a(String str, String str2, int i2) {
        Log.d(this.f1063a, "RequestClothesItem()+");
        this.t = str;
        this.u = str2;
        this.v = i2;
        a(0, 20, this.u, this.v);
    }

    public void c() {
        if (this.N != null) {
            this.N.d();
        }
        if (this.O != null) {
            this.O.removeAllViews();
        }
        if (this.F != null) {
            int i2 = 20;
            if (!this.F.isEmpty()) {
                i2 = this.F.size();
                this.F.clear();
                this.x.notifyDataSetChanged();
            }
            a(0, i2, this.u, this.v);
        }
    }

    public void d() {
        Log.d(this.f1063a, "RefreshCurrentItems()+");
        if (this.w != null) {
            int childCount = this.w.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                d dVar = (d) this.w.getChildAt(i2).getTag();
                if (dVar != null) {
                    for (int i3 = 0; i3 < 2; i3++) {
                        c cVar = dVar.f1115b[i3];
                        if (cVar != null && cVar.f1109b.getVisibility() == 0) {
                            int i4 = cVar.f1108a;
                            if (i4 < 0 || i4 >= this.F.size()) {
                                Log.e(this.f1063a, "ERROR :: index out.");
                            } else {
                                c.a aVar = this.F.get(i4);
                                final RelativeLayout b2 = cVar.e.b();
                                b2.setVisibility(0);
                                String h2 = aVar.h();
                                ImageView a2 = cVar.e.a();
                                if (h2 == null || this.q == null) {
                                    a2.setVisibility(4);
                                } else {
                                    a2.setVisibility(0);
                                    this.q.a(a2, h2, this.P, this.Q, new Runnable() {
                                        public void run() {
                                            b2.setVisibility(4);
                                        }
                                    });
                                }
                                boolean b3 = d.a(this.p).b(String.valueOf(aVar.a()));
                                cVar.f.setChecked(b3);
                                if (b3) {
                                    String str = this.f1063a;
                                    i.c(str, "[L] RefreshCurrentItemWishlist : current item product id : " + aVar.a());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* compiled from: FNSPagerLayout */
    private class d {

        /* renamed from: a  reason: collision with root package name */
        LinearLayout f1114a;

        /* renamed from: b  reason: collision with root package name */
        c[] f1115b;

        private d() {
        }
    }

    /* compiled from: FNSPagerLayout */
    private class c {

        /* renamed from: a  reason: collision with root package name */
        int f1108a;

        /* renamed from: b  reason: collision with root package name */
        LinearLayout f1109b;
        RelativeLayout c;
        ImageView d;
        ThumbnailLayout e;
        CheckBox f;
        TextView g;
        TextView h;
        TextView i;

        private c() {
        }
    }

    /* compiled from: FNSPagerLayout */
    private class a extends BaseAdapter {
        public long getItemId(int i) {
            return (long) i;
        }

        public a() {
        }

        public int getCount() {
            if (e.this.F == null) {
                return 0;
            }
            int size = e.this.F.size();
            if (size % 2 == 0) {
                return size / 2;
            }
            return (size / 2) + 1;
        }

        public Object getItem(int i) {
            if (e.this.F == null) {
                return null;
            }
            c.a[] aVarArr = new c.a[2];
            if (e.this.F.size() % 2 == 0) {
                int i2 = i * 2;
                aVarArr[0] = (c.a) e.this.F.get(i2 + 0);
                aVarArr[1] = (c.a) e.this.F.get(i2 + 1);
            } else {
                aVarArr[0] = (c.a) e.this.F.get((i * 2) + 0);
                aVarArr[1] = null;
            }
            return aVarArr;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            int i2 = i * 2;
            int i3 = i2 + 1;
            if (view == null) {
                view = e.this.B.inflate(2131296298, viewGroup, false);
                dVar = new d();
                dVar.f1115b = new c[2];
                dVar.f1115b[0] = new c();
                dVar.f1115b[1] = new c();
                dVar.f1114a = (LinearLayout) view.findViewById(2131165328);
                LinearLayout linearLayout = (LinearLayout) view.findViewById(2131165350);
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(2131165351);
                e.this.B.inflate(2131296295, linearLayout, true);
                e.this.B.inflate(2131296295, linearLayout2, true);
                a(dVar.f1115b[0], (View) linearLayout);
                a(dVar.f1115b[1], (View) linearLayout2);
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            if (dVar != null) {
                a((View) dVar.f1114a, i);
                a(dVar.f1115b[0], i2);
                a(dVar.f1115b[1], i3);
            }
            return view;
        }

        private void a(final c cVar, View view) {
            cVar.f1109b = (LinearLayout) view;
            cVar.e = (ThumbnailLayout) view.findViewById(2131165419);
            cVar.f = (CheckBox) view.findViewById(2131165201);
            cVar.c = (RelativeLayout) view.findViewById(2131165341);
            cVar.d = (ImageView) view.findViewById(2131165283);
            cVar.e.setOnClickListener(e.this.S);
            cVar.f.setOnClickListener(e.this.S);
            cVar.c.setOnClickListener(e.this.S);
            cVar.c.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            cVar.d.setPressed(true);
                            break;
                        case 1:
                        case 3:
                        case 4:
                            cVar.d.setPressed(false);
                            break;
                    }
                    return false;
                }
            });
            cVar.g = (TextView) view.findViewById(2131165327);
            cVar.h = (TextView) view.findViewById(2131165330);
            cVar.i = (TextView) view.findViewById(2131165332);
        }

        private void a(c cVar, int i) {
            if (i < e.this.F.size()) {
                cVar.f1109b.setVisibility(0);
                c.a aVar = (c.a) e.this.F.get(i);
                cVar.f1108a = i;
                String h = aVar.h();
                final RelativeLayout b2 = cVar.e.b();
                b2.setVisibility(0);
                ImageView a2 = cVar.e.a();
                if (h == null || e.this.q == null) {
                    a2.setVisibility(4);
                } else {
                    a2.setVisibility(0);
                    e.this.q.a(a2, h, e.this.P, e.this.Q, new Runnable() {
                        public void run() {
                            b2.setVisibility(4);
                        }
                    });
                }
                boolean b3 = d.a(e.this.p).b(String.valueOf(aVar.a()));
                cVar.f.setChecked(b3);
                if (b3) {
                    String s = e.this.f1063a;
                    i.c(s, "[L] SetDataInView(), product id : " + aVar.a());
                }
                cVar.e.setTag(Integer.valueOf(i));
                cVar.f.setTag(Integer.valueOf(i));
                cVar.c.setTag(Integer.valueOf(i));
                if (aVar.k() == 1) {
                    cVar.c.setEnabled(false);
                    cVar.d.setVisibility(4);
                    cVar.i.setText("sample");
                    cVar.i.setAlpha(0.5f);
                } else {
                    cVar.c.setEnabled(true);
                    cVar.d.setVisibility(0);
                    cVar.i.setText(a(aVar.g(), aVar.f()));
                    cVar.i.setAlpha(1.0f);
                }
                cVar.g.setText(aVar.j().toUpperCase());
                cVar.h.setText(aVar.b());
                return;
            }
            cVar.f1109b.setVisibility(4);
            cVar.f1108a = -1;
            ImageView a3 = cVar.e.a();
            a3.setVisibility(4);
            if (e.this.q != null) {
                e.this.q.a(a3, (String) null, (Runnable) null);
            }
            cVar.e.setTag(-1);
            cVar.f.setTag(-1);
            cVar.c.setTag(-1);
            cVar.c.setEnabled(false);
            cVar.d.setVisibility(4);
            cVar.g.setText("");
            cVar.h.setText("");
            cVar.i.setText("");
        }

        private String a(String str, double d) {
            if (str == null) {
                str = "UDS";
            }
            if (str.equals("KRW")) {
                return String.format("%s%s", new Object[]{new DecimalFormat("#,##0").format(d), "원"});
            } else if (str.equals("CNY")) {
                return String.format("%s%s", new Object[]{new DecimalFormat("#,##0.00").format(d), "元"});
            } else {
                return String.format("%s%s", new Object[]{"US $", new DecimalFormat("#,##0.00").format(d)});
            }
        }

        private void a(View view, int i) {
            int i2;
            int i3 = 0;
            if (i == 0) {
                i3 = e.this.getResources().getDimensionPixelSize(2131034369);
            } else if (e.this.G == e.this.F.size() && i == getCount() - 1) {
                i2 = e.this.getResources().getDimensionPixelSize(2131034368);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                layoutParams.topMargin = i3;
                layoutParams.bottomMargin = i2;
                view.setLayoutParams(layoutParams);
            }
            i2 = 0;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.topMargin = i3;
            layoutParams2.bottomMargin = i2;
            view.setLayoutParams(layoutParams2);
        }
    }

    public void e() {
        Log.d(this.f1063a, "GoToTheTopOfList()");
        if (this.w != null) {
            f();
            this.w.setSelection(0);
        }
        if (this.E != null) {
            this.E.setEnabled(true);
        }
    }

    public void f() {
        Log.d(this.f1063a, "StopScroll()");
        if (this.w != null) {
            this.w.smoothScrollBy(0, 0);
        }
    }

    public void g() {
        Log.d(this.f1063a, "StopTask()");
        if (this.D != null) {
            this.D.a();
            this.D = null;
        }
    }

    public boolean h() {
        return this.D != null;
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3, String str, int i4) {
        String str2 = this.f1063a;
        Log.d(str2, "RequestClothesItem()+, start : " + i2 + ", count : " + i3);
        if (this.D != null) {
            this.D.a();
            this.D = null;
        }
        d.C0037d.a aVar = new d.C0037d.a();
        aVar.d = i2;
        aVar.e = i3;
        aVar.f = str;
        aVar.h = i4;
        if (this.t != null) {
            aVar.f1133a = this.t;
            if (h.f1164b.d()) {
                aVar.f1134b = this.r;
            }
        } else {
            aVar.f1134b = this.r;
            aVar.c = this.s;
        }
        if (h.f1164b.e() && this.r == -1 && this.s == -1 && i2 == 0) {
            aVar.i = true;
        }
        this.D = d.a(aVar, (d.f) new d.f() {
            public void a() {
                if (e.this.C != null) {
                    e.this.C.a();
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:59:0x01ca  */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x01fe  */
            /* JADX WARNING: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void a(int r10, java.lang.Object r11) {
                /*
                    r9 = this;
                    net.fxgear.fitnshop.e r0 = net.fxgear.fitnshop.e.this
                    java.lang.String r0 = r0.f1063a
                    java.lang.String r1 = "onFinishNetworkWorking()+"
                    android.util.Log.d(r0, r1)
                    net.fxgear.fitnshop.e r0 = net.fxgear.fitnshop.e.this
                    java.util.ArrayList r0 = r0.F
                    if (r0 != 0) goto L_0x001f
                    net.fxgear.fitnshop.e r10 = net.fxgear.fitnshop.e.this
                    java.lang.String r10 = r10.f1063a
                    java.lang.String r11 = "ERROR :: Layout destroy."
                    android.util.Log.e(r10, r11)
                    return
                L_0x001f:
                    net.fxgear.fitnshop.e r0 = net.fxgear.fitnshop.e.this
                    r1 = 0
                    net.fxgear.fitnshop.e.d.C0037d unused = r0.D = r1
                    net.fxgear.fitnshop.e r0 = net.fxgear.fitnshop.e.this
                    android.support.v4.widget.SwipeRefreshLayout r0 = r0.E
                    r2 = 0
                    if (r0 == 0) goto L_0x0037
                    net.fxgear.fitnshop.e r0 = net.fxgear.fitnshop.e.this
                    android.support.v4.widget.SwipeRefreshLayout r0 = r0.E
                    r0.setRefreshing(r2)
                L_0x0037:
                    r0 = -2
                    r3 = 1
                    if (r10 != r0) goto L_0x01a9
                    if (r11 == 0) goto L_0x019c
                    boolean r0 = r11 instanceof net.fxgear.fitnshop.e.d.C0037d.b
                    if (r0 == 0) goto L_0x019c
                    net.fxgear.fitnshop.e.d$d$b r11 = (net.fxgear.fitnshop.e.d.C0037d.b) r11
                    net.fxgear.fitnshop.e.c r0 = r11.f1136b
                    net.fxgear.fitnshop.e.d$d$a r4 = r11.f1135a
                    int r4 = r4.d
                    if (r4 != 0) goto L_0x00ff
                    net.fxgear.fitnshop.e r4 = net.fxgear.fitnshop.e.this
                    java.util.ArrayList r4 = r4.F
                    boolean r4 = r4.isEmpty()
                    if (r4 != 0) goto L_0x0060
                    net.fxgear.fitnshop.e r4 = net.fxgear.fitnshop.e.this
                    java.util.ArrayList r4 = r4.F
                    r4.clear()
                L_0x0060:
                    net.fxgear.fitnshop.g r4 = net.fxgear.fitnshop.h.f1164b
                    boolean r4 = r4.e()
                    if (r4 == 0) goto L_0x00ff
                    net.fxgear.fitnshop.e.d$a$a r4 = r11.c
                    if (r4 == 0) goto L_0x00ff
                    net.fxgear.fitnshop.e.d$a$a r11 = r11.c
                    net.fxgear.fitnshop.e.d$a$b[] r11 = r11.f1119a
                    if (r11 == 0) goto L_0x00ff
                    int r4 = r11.length
                    if (r4 <= 0) goto L_0x00ff
                    net.fxgear.fitnshop.e r4 = net.fxgear.fitnshop.e.this
                    net.fxgear.fitnshop.e$f r4 = r4.N
                    r4.a((net.fxgear.fitnshop.e.d.a.b[]) r11)
                    net.fxgear.fitnshop.e r4 = net.fxgear.fitnshop.e.this
                    android.widget.RadioGroup r4 = r4.O
                    if (r4 == 0) goto L_0x00ff
                    net.fxgear.fitnshop.e r4 = net.fxgear.fitnshop.e.this
                    android.widget.RadioGroup r4 = r4.O
                    int r4 = r4.getChildCount()
                    int r5 = r11.length
                    if (r5 == r4) goto L_0x00f0
                    if (r4 <= 0) goto L_0x009e
                    net.fxgear.fitnshop.e r4 = net.fxgear.fitnshop.e.this
                    android.widget.RadioGroup r4 = r4.O
                    r4.removeAllViews()
                L_0x009e:
                    net.fxgear.fitnshop.e r4 = net.fxgear.fitnshop.e.this
                    android.content.res.Resources r4 = r4.getResources()
                    r5 = 2131034163(0x7f050033, float:1.7678836E38)
                    int r6 = r4.getDimensionPixelSize(r5)
                    int r5 = r4.getDimensionPixelSize(r5)
                    r7 = 2131034162(0x7f050032, float:1.7678834E38)
                    int r8 = r4.getDimensionPixelSize(r7)
                    int r4 = r4.getDimensionPixelSize(r7)
                    android.widget.RadioGroup$LayoutParams r7 = new android.widget.RadioGroup$LayoutParams
                    r7.<init>(r6, r5)
                    r7.leftMargin = r8
                    r7.rightMargin = r4
                    r4 = 0
                L_0x00c4:
                    int r5 = r11.length
                    if (r4 >= r5) goto L_0x00f0
                    android.widget.RadioButton r5 = new android.widget.RadioButton
                    net.fxgear.fitnshop.e r6 = net.fxgear.fitnshop.e.this
                    android.content.Context r6 = r6.p
                    r5.<init>(r6)
                    r6 = 2131099847(0x7f0600c7, float:1.7812059E38)
                    r5.setBackgroundResource(r6)
                    r5.setButtonDrawable(r1)
                    r5.setClickable(r2)
                    r5.setFocusable(r2)
                    r5.setId(r4)
                    net.fxgear.fitnshop.e r6 = net.fxgear.fitnshop.e.this
                    android.widget.RadioGroup r6 = r6.O
                    r6.addView(r5, r7)
                    int r4 = r4 + 1
                    goto L_0x00c4
                L_0x00f0:
                    net.fxgear.fitnshop.e r11 = net.fxgear.fitnshop.e.this
                    net.fxgear.fitnshop.e r1 = net.fxgear.fitnshop.e.this
                    android.support.v4.view.ViewPager r1 = r1.M
                    int r1 = r1.getCurrentItem()
                    r11.a((int) r1)
                L_0x00ff:
                    if (r0 == 0) goto L_0x0190
                    net.fxgear.fitnshop.e.c$a[] r11 = r0.d
                    net.fxgear.fitnshop.e r1 = net.fxgear.fitnshop.e.this
                    int r0 = r0.c
                    int unused = r1.G = r0
                    if (r11 == 0) goto L_0x011e
                    r0 = 0
                L_0x010d:
                    int r1 = r11.length
                    if (r0 >= r1) goto L_0x011e
                    net.fxgear.fitnshop.e r1 = net.fxgear.fitnshop.e.this
                    java.util.ArrayList r1 = r1.F
                    r3 = r11[r0]
                    r1.add(r3)
                    int r0 = r0 + 1
                    goto L_0x010d
                L_0x011e:
                    net.fxgear.fitnshop.e r11 = net.fxgear.fitnshop.e.this
                    java.util.ArrayList r11 = r11.F
                    boolean r11 = r11.isEmpty()
                    r0 = 8
                    if (r11 == 0) goto L_0x0174
                    net.fxgear.fitnshop.e r11 = net.fxgear.fitnshop.e.this
                    java.lang.String r11 = r11.t
                    if (r11 != 0) goto L_0x014b
                    net.fxgear.fitnshop.e r11 = net.fxgear.fitnshop.e.this
                    android.widget.TextView r11 = r11.A
                    net.fxgear.fitnshop.e r1 = net.fxgear.fitnshop.e.this
                    android.content.res.Resources r1 = r1.getResources()
                    r3 = 2131361917(0x7f0a007d, float:1.83436E38)
                    java.lang.String r1 = r1.getString(r3)
                    r11.setText(r1)
                    goto L_0x0161
                L_0x014b:
                    net.fxgear.fitnshop.e r11 = net.fxgear.fitnshop.e.this
                    android.widget.TextView r11 = r11.A
                    net.fxgear.fitnshop.e r1 = net.fxgear.fitnshop.e.this
                    android.content.res.Resources r1 = r1.getResources()
                    r3 = 2131361936(0x7f0a0090, float:1.8343638E38)
                    java.lang.String r1 = r1.getString(r3)
                    r11.setText(r1)
                L_0x0161:
                    net.fxgear.fitnshop.e r11 = net.fxgear.fitnshop.e.this
                    android.support.v4.widget.SwipeRefreshLayout r11 = r11.E
                    r11.setVisibility(r0)
                    net.fxgear.fitnshop.e r11 = net.fxgear.fitnshop.e.this
                    android.widget.TextView r11 = r11.A
                    r11.setVisibility(r2)
                    goto L_0x0186
                L_0x0174:
                    net.fxgear.fitnshop.e r11 = net.fxgear.fitnshop.e.this
                    android.support.v4.widget.SwipeRefreshLayout r11 = r11.E
                    r11.setVisibility(r2)
                    net.fxgear.fitnshop.e r11 = net.fxgear.fitnshop.e.this
                    android.widget.TextView r11 = r11.A
                    r11.setVisibility(r0)
                L_0x0186:
                    net.fxgear.fitnshop.e r11 = net.fxgear.fitnshop.e.this
                    net.fxgear.fitnshop.e$a r11 = r11.x
                    r11.notifyDataSetChanged()
                    goto L_0x01c8
                L_0x0190:
                    net.fxgear.fitnshop.e r11 = net.fxgear.fitnshop.e.this
                    java.lang.String r11 = r11.f1063a
                    java.lang.String r0 = "ERROR :: clothesInfo data null."
                    android.util.Log.e(r11, r0)
                    goto L_0x01a7
                L_0x019c:
                    net.fxgear.fitnshop.e r11 = net.fxgear.fitnshop.e.this
                    java.lang.String r11 = r11.f1063a
                    java.lang.String r0 = "ERROR :: invalid data"
                    android.util.Log.e(r11, r0)
                L_0x01a7:
                    r2 = 1
                    goto L_0x01c8
                L_0x01a9:
                    r11 = -1
                    if (r10 != r11) goto L_0x01ad
                    goto L_0x01c8
                L_0x01ad:
                    net.fxgear.fitnshop.e r11 = net.fxgear.fitnshop.e.this
                    java.lang.String r11 = r11.f1063a
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = "ERROR :: network error, code : "
                    r0.append(r1)
                    r0.append(r10)
                    java.lang.String r0 = r0.toString()
                    android.util.Log.e(r11, r0)
                    goto L_0x01a7
                L_0x01c8:
                    if (r2 == 0) goto L_0x01f6
                    net.fxgear.fitnshop.e r11 = net.fxgear.fitnshop.e.this
                    java.util.ArrayList r11 = r11.F
                    if (r11 == 0) goto L_0x01e5
                    net.fxgear.fitnshop.e r11 = net.fxgear.fitnshop.e.this
                    java.util.ArrayList r11 = r11.F
                    boolean r11 = r11.isEmpty()
                    if (r11 == 0) goto L_0x01df
                    goto L_0x01e5
                L_0x01df:
                    net.fxgear.fitnshop.e r10 = net.fxgear.fitnshop.e.this
                    r10.l()
                    goto L_0x01f6
                L_0x01e5:
                    net.fxgear.fitnshop.e r11 = net.fxgear.fitnshop.e.this
                    net.fxgear.fitnshop.e$b r11 = r11.C
                    if (r11 == 0) goto L_0x01f6
                    net.fxgear.fitnshop.e r11 = net.fxgear.fitnshop.e.this
                    net.fxgear.fitnshop.e$b r11 = r11.C
                    r11.b((int) r10)
                L_0x01f6:
                    net.fxgear.fitnshop.e r10 = net.fxgear.fitnshop.e.this
                    net.fxgear.fitnshop.e$b r10 = r10.C
                    if (r10 == 0) goto L_0x020d
                    net.fxgear.fitnshop.e r10 = net.fxgear.fitnshop.e.this
                    net.fxgear.fitnshop.e$b r10 = r10.C
                    net.fxgear.fitnshop.e r11 = net.fxgear.fitnshop.e.this
                    int r11 = r11.G
                    r10.a((int) r11)
                L_0x020d:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.e.AnonymousClass8.a(int, java.lang.Object):void");
            }
        });
    }

    public ListView i() {
        return this.w;
    }

    public void j() {
        Log.d(this.f1063a, "FNSPagerLayout DestroyLayout() +");
        if (this.D != null) {
            this.D.a();
            this.D = null;
        }
        if (this.y != null) {
            this.y.a();
            this.y = null;
        }
        if (this.O != null) {
            this.O.removeAllViews();
            this.O = null;
        }
        if (this.N != null) {
            this.N.e();
            this.N = null;
        }
        if (this.M != null) {
            this.M.b(this.R);
            this.M = null;
        }
        if (this.w != null) {
            if (this.L != null) {
                this.w.removeHeaderView(this.L);
                this.L = null;
            }
            if (this.I != null) {
                this.w.removeHeaderView(this.I);
                this.I = null;
            }
            if (this.z != null) {
                this.w.removeFooterView(this.z);
                this.z = null;
            }
            int childCount = this.w.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.w.getChildAt(i2);
                d dVar = (d) childAt.getTag();
                if (!(dVar == null || dVar.f1115b == null)) {
                    for (int i3 = 0; i3 < 2; i3++) {
                        c cVar = dVar.f1115b[i3];
                        cVar.f1109b = null;
                        cVar.e.setOnClickListener((View.OnClickListener) null);
                        cVar.f.setOnClickListener((View.OnClickListener) null);
                        cVar.c.setOnClickListener((View.OnClickListener) null);
                    }
                }
                childAt.setTag((Object) null);
            }
            this.w.setAdapter((ListAdapter) null);
            this.w.setOnTouchListener((View.OnTouchListener) null);
            this.w = null;
        }
        removeAllViews();
        if (this.F != null) {
            this.F.clear();
            this.F = null;
        }
        this.p = null;
        this.q = null;
        this.B = null;
        this.C = null;
        this.E = null;
        this.x = null;
        this.A = null;
        this.S = null;
    }

    @SuppressLint({"UseSparseArrays"})
    /* renamed from: net.fxgear.fitnshop.e$e  reason: collision with other inner class name */
    /* compiled from: FNSPagerLayout */
    private class C0038e {

        /* renamed from: b  reason: collision with root package name */
        private AbsListView f1146b;
        private SparseArray<Integer> c;

        public C0038e(AbsListView absListView) {
            this.f1146b = absListView;
        }

        public int a(int i, int i2) {
            SparseArray<Integer> sparseArray = this.c;
            this.c = new SparseArray<>();
            for (int i3 = 0; i3 < i2; i3++) {
                this.c.put(i + i3, Integer.valueOf(this.f1146b.getChildAt(i3).getTop()));
            }
            if (sparseArray != null) {
                for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    int intValue = sparseArray.get(keyAt).intValue();
                    Integer num = this.c.get(keyAt);
                    if (num != null) {
                        return num.intValue() - intValue;
                    }
                }
            }
            return 0;
        }

        public void a() {
            if (this.c != null) {
                this.c.clear();
                this.c = null;
            }
            this.f1146b = null;
        }
    }

    /* compiled from: FNSPagerLayout */
    private class f extends k {

        /* renamed from: b  reason: collision with root package name */
        private final String f1154b;
        /* access modifiers changed from: private */
        public ArrayList<d.a.b> c;

        public int a(Object obj) {
            return -2;
        }

        private f() {
            this.f1154b = "ViewPagerAdapter";
        }

        /* access modifiers changed from: private */
        public void a(d.a.b[] bVarArr) {
            if (bVarArr != null && bVarArr.length > 0) {
                if (this.c == null) {
                    this.c = new ArrayList<>();
                } else {
                    this.c.clear();
                }
                for (d.a.b add : bVarArr) {
                    this.c.add(add);
                }
                c();
            }
        }

        public void d() {
            if (this.c != null) {
                this.c.clear();
            }
            c();
        }

        public int a() {
            if (this.c != null) {
                return this.c.size();
            }
            return 0;
        }

        public boolean a(View view, Object obj) {
            return view.equals(obj);
        }

        public Object a(View view, final int i) {
            View inflate = ((LayoutInflater) view.getContext().getSystemService("layout_inflater")).inflate(2131296282, (ViewGroup) null);
            inflate.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (e.this.C != null && f.this.c != null && i < f.this.c.size()) {
                        e.this.C.a((d.a.b) f.this.c.get(i));
                    }
                }
            });
            if (this.c != null && i < this.c.size()) {
                ImageView imageView = (ImageView) inflate.findViewById(2131165317);
                imageView.setBackgroundColor(-1);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                e.this.q.a(imageView, this.c.get(i).f1121a, (Runnable) null);
            }
            ((ViewPager) view).addView(inflate);
            return inflate;
        }

        public void a(ViewGroup viewGroup, int i, Object obj) {
            ((ViewPager) viewGroup).removeView((View) obj);
        }

        public void e() {
            if (this.c != null) {
                this.c.clear();
                this.c = null;
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\f.java ==========

package net.fxgear.fitnshop;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import net.fxgear.GlobalDefine;

/* compiled from: FNSWebViewClient */
public class f extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    private final String f1161a = f.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private Context f1162b = null;
    private a c = null;

    /* compiled from: FNSWebViewClient */
    public interface a {
        void a(int i, String str, String str2);

        void a(String str);

        void a(boolean z, String str);

        void b(String str);

        void c(String str);

        void d(String str);

        void e(String str);

        void f(String str);
    }

    public f(Context context) {
        this.f1162b = context;
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2 = this.f1161a;
        i.b(str2, "shouldOverrideUrlLoading(), url : " + str);
        if (str.startsWith("uniwebview://add_wishlist?data=")) {
            if (this.c != null) {
                this.c.c(str);
            }
            return true;
        } else if (str.startsWith("uniwebview://fitting?data=")) {
            if (this.c != null) {
                this.c.d(str);
            }
            return true;
        } else if (str.startsWith("tel:") || str.startsWith("mailto:") || str.startsWith("smsto:")) {
            if (this.c != null) {
                this.c.e(str);
            }
            return true;
        } else if (!h.d(this.f1162b)) {
            Log.e(this.f1161a, "network error");
            if (this.c != null) {
                this.c.a(false, str);
            }
            return true;
        } else {
            if (this.c != null) {
                this.c.a(true, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        String str2 = this.f1161a;
        i.b(str2, "[L] onPageStarted : " + str);
        super.onPageStarted(webView, str, bitmap);
        if (this.c != null) {
            this.c.a(str);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        String str2 = this.f1161a;
        i.b(str2, "[L] onPageFinished : " + str);
        super.onPageFinished(webView, str);
        if (this.c != null) {
            this.c.b(str);
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (this.c != null) {
            if (!(i == -15 || i == -11)) {
                switch (i) {
                    case -8:
                    case -7:
                    case -6:
                        break;
                    default:
                        switch (i) {
                            case GlobalDefine.RESULT_CODE_CANCEL:
                            case -1:
                                break;
                            default:
                                this.c.a(i, str, str2);
                                return;
                        }
                }
            }
            this.c.f(str2);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\FitNShopMainActivity.java ==========

package net.fxgear.fitnshop;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import net.fxgear.GlobalDefine;
import net.fxgear.a.a;
import net.fxgear.fitnshop.FNSMainMenu;
import net.fxgear.fitnshop.a.c;
import net.fxgear.fitnshop.a.d;
import net.fxgear.fitnshop.a.e;
import net.fxgear.fitnshop.c.b;
import net.fxgear.fitnshop.c.d;
import net.fxgear.fitnshop.d.g;
import net.fxgear.fitnshop.d.h;
import net.fxgear.fitnshop.d.j;
import net.fxgear.fitnshop.d.k;
import net.fxgear.fitnshop.d.l;
import net.fxgear.fitnshop.d.m;
import net.fxgear.fitnshop.e.b;
import net.fxgear.fitnshop.e.d;
import net.fxgear.fitnshop.e.f;
import net.fxgear.fittingmodenative.c;
import org.json.JSONException;
import org.json.JSONObject;

public class FitNShopMainActivity extends Activity implements View.OnClickListener {
    /* access modifiers changed from: private */
    public d A;
    /* access modifiers changed from: private */
    public boolean B = false;
    /* access modifiers changed from: private */
    public c.d C = null;
    private net.fxgear.fitnshop.a.d D = null;
    private Animation.AnimationListener E = new Animation.AnimationListener() {
        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            if (animation != null && animation.equals(FitNShopMainActivity.this.h)) {
                FitNShopMainActivity.this.b(true);
            }
        }
    };
    private FNSMainMenu.b F = new FNSMainMenu.b() {
        public boolean a() {
            if (FitNShopMainActivity.this.o() || !FitNShopMainActivity.this.a()) {
                return false;
            }
            AnonymousClass1 r0 = new Runnable() {
                public void run() {
                    FitNShopMainActivity.this.n();
                }
            };
            f.a("SIDE_HOME_CLI", "");
            FitNShopMainActivity.this.a((Runnable) r0);
            return true;
        }

        public boolean a(final int i) {
            if (FitNShopMainActivity.this.o() || !FitNShopMainActivity.this.a()) {
                return false;
            }
            AnonymousClass2 r0 = null;
            if (i < FitNShopMainActivity.this.u.size()) {
                r0 = new Runnable() {
                    public void run() {
                        b.a aVar = (b.a) FitNShopMainActivity.this.u.get(i);
                        if (aVar == null || aVar.d().length != h.d.length) {
                            if (FitNShopMainActivity.this.q == null || FitNShopMainActivity.this.q.getStatus() == AsyncTask.Status.FINISHED) {
                                b unused = FitNShopMainActivity.this.q = new b(i);
                                FitNShopMainActivity.this.q.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            }
                            Log.e(FitNShopMainActivity.this.f802a, "Task running.");
                        } else if (FitNShopMainActivity.this.b(aVar)) {
                            f.a("SIDE_CLI_PRDVIEW_DONE", "");
                        }
                    }
                };
            }
            f.a("SIDE_BRAND_CLI", "");
            FitNShopMainActivity.this.a((Runnable) r0);
            return true;
        }

        public boolean b() {
            if (!FitNShopMainActivity.this.o() && FitNShopMainActivity.this.a()) {
                boolean z = true;
                if (Build.VERSION.SDK_INT >= 23 && android.support.v4.b.a.a(FitNShopMainActivity.this.getApplicationContext(), "android.permission.CAMERA") == -1) {
                    z = false;
                }
                if (z) {
                    AnonymousClass3 r0 = new Runnable() {
                        public void run() {
                            FitNShopMainActivity.this.a("add_video", (String) null, "FNSMainMenu");
                        }
                    };
                    f.a("SIDE_MIRROR_CLI", "");
                    FitNShopMainActivity.this.a((Runnable) r0);
                } else {
                    net.fxgear.fitnshop.c.b bVar = new net.fxgear.fitnshop.c.b(FitNShopMainActivity.this, 2);
                    bVar.a((String) null);
                    bVar.b(FitNShopMainActivity.this.getResources().getString(a.g.camera_access_required));
                    bVar.c(FitNShopMainActivity.this.getResources().getString(2131361829));
                    bVar.d(FitNShopMainActivity.this.getResources().getString(2131361832));
                    bVar.a((b.a) new b.a() {
                        public void a(net.fxgear.fitnshop.c.b bVar) {
                            bVar.dismiss();
                        }

                        public void b(net.fxgear.fitnshop.c.b bVar) {
                            android.support.v4.a.a.a(FitNShopMainActivity.this, new String[]{"android.permission.CAMERA"}, 0);
                            bVar.dismiss();
                        }
                    });
                    bVar.show();
                }
            }
            return false;
        }

        public void d() {
            Log.d(FitNShopMainActivity.this.f802a, "OnReachBottom()+");
            if (h.d(FitNShopMainActivity.this.getApplicationContext()) && FitNShopMainActivity.this.t > FitNShopMainActivity.this.u.size()) {
                FitNShopMainActivity.this.a(false);
            }
        }

        public boolean c() {
            if (FitNShopMainActivity.this.o() || !FitNShopMainActivity.this.a()) {
                return false;
            }
            FitNShopMainActivity.this.a((Runnable) new Runnable() {
                public void run() {
                    String string = FitNShopMainActivity.this.getResources().getString(2131361945);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("title", string);
                    } catch (JSONException e) {
                        Log.e(FitNShopMainActivity.this.f802a, "[ERROR] :: JSONException, failed to put title");
                        e.printStackTrace();
                    }
                    FitNShopMainActivity.this.a((net.fxgear.fitnshop.d.b) new h(0, jSONObject.toString()), 0);
                }
            });
            return true;
        }

        public void e() {
            if (!FitNShopMainActivity.this.o() && FitNShopMainActivity.this.a()) {
                FitNShopMainActivity.this.a((Runnable) new Runnable() {
                    public void run() {
                    }
                });
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f802a = FitNShopMainActivity.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final int f803b = 0;
    private final int c = 1;
    private final String d = "market://details?id=";
    private final long e = 400;
    private TranslateAnimation f;
    private TranslateAnimation g;
    /* access modifiers changed from: private */
    public TranslateAnimation h;
    private AlphaAnimation i;
    private AlphaAnimation j;
    private float k;
    private net.fxgear.fitnshop.a.f l;
    /* access modifiers changed from: private */
    public FNSMainMenu m;
    private View n;
    /* access modifiers changed from: private */
    public RelativeLayout o;
    /* access modifiers changed from: private */
    public d.e p;
    /* access modifiers changed from: private */
    public b q;
    private net.fxgear.fitnshop.c.b r;
    private net.fxgear.fitnshop.c.a s;
    /* access modifiers changed from: private */
    public int t;
    /* access modifiers changed from: private */
    public ArrayList<b.a> u;
    private ArrayList<a> v;
    private int w = 0;
    private String x = GlobalDefine.GENDER_WOMAN_STRING;
    /* access modifiers changed from: private */
    public boolean y = true;
    /* access modifiers changed from: private */
    public d.c z;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f837a;

        /* renamed from: b  reason: collision with root package name */
        public final String f838b;

        public a(String str, String str2) {
            this.f837a = str;
            this.f838b = str2;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        final net.fxgear.fitnshop.d.b bVar;
        super.onCreate(bundle);
        Log.i(this.f802a, "onCreate()+");
        j();
        h.f1163a = false;
        setContentView(2131296258);
        if (Build.VERSION.SDK_INT >= 23 && android.support.v4.b.a.a(getApplicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
            android.support.v4.a.a.a(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        }
        i();
        if (!h.f1164b.d()) {
            k();
        }
        this.C = c.a((Context) this, (c.b) new c.b() {
            public void a() {
            }

            public void a(boolean z) {
                boolean unused = FitNShopMainActivity.this.B = z;
                c.d unused2 = FitNShopMainActivity.this.C = null;
            }
        });
        long a2 = h.a(e.a((Context) this, "fs_image"));
        if (10485760 > a2) {
            String a3 = h.a(10485760 - a2);
            net.fxgear.fitnshop.c.b bVar2 = new net.fxgear.fitnshop.c.b(this, 1);
            bVar2.a(getResources().getString(2131361835));
            bVar2.b(String.format(getResources().getString(2131361831), new Object[]{a3}));
            bVar2.c(getResources().getString(2131361832));
            bVar2.setCancelable(false);
            bVar2.a((b.a) new b.a() {
                public void b(net.fxgear.fitnshop.c.b bVar) {
                }

                public void a(net.fxgear.fitnshop.c.b bVar) {
                    bVar.dismiss();
                    FitNShopMainActivity.this.finish();
                }
            });
            bVar2.show();
        }
        d.b bVar3 = new d.b();
        bVar3.c = 30;
        bVar3.d = (long) Math.round(((float) Runtime.getRuntime().maxMemory()) * 0.15f);
        bVar3.f899b = new c.a();
        bVar3.f899b.f886a = "FNS_NATIVE_DISK_CACHE";
        bVar3.f899b.f887b = 10485760;
        this.D = new net.fxgear.fitnshop.a.d(this, "FNS_NATIVE", bVar3);
        e.a aVar = new e.a(this, "fs_image");
        aVar.a(0.25f);
        this.l = new net.fxgear.fitnshop.a.f(getApplicationContext(), Integer.MAX_VALUE);
        this.l.a(getFragmentManager(), aVar);
        if (h.f1164b.k()) {
            bVar = new m();
        } else if (h.f1164b.c()) {
            bVar = new net.fxgear.fitnshop.d.c(this.D, (b.a) null);
        } else if (h.f1164b.b()) {
            bVar = new g(this.l);
        } else {
            bVar = new net.fxgear.fitnshop.d.f(this.l);
        }
        a(bVar, 1);
        if (h.d(this)) {
            a(false);
        } else {
            this.o.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    FitNShopMainActivity.this.o.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    bVar.d();
                }
            });
        }
    }

    private void i() {
        this.u = new ArrayList<>();
        this.v = new ArrayList<>();
        this.v.add(new a(GlobalDefine.GENDER_WOMAN_STRING, getResources().getString(2131361892)));
        this.v.add(new a(GlobalDefine.GENDER_MAN_STRING, getResources().getString(2131361890)));
        this.v.add(new a("girl", getResources().getString(2131361889)));
        this.v.add(new a("boy", getResources().getString(2131361888)));
        this.k = getResources().getDimension(2131034465);
        this.f = new TranslateAnimation(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, this.k, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        this.f.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f.setDuration(400);
        this.f.setFillAfter(true);
        this.g = new TranslateAnimation(this.k, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        this.g.setInterpolator(new AccelerateDecelerateInterpolator());
        this.g.setDuration(400);
        this.g.setFillAfter(true);
        this.h = new TranslateAnimation(-this.k, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        this.h.setInterpolator(new AccelerateDecelerateInterpolator());
        this.h.setDuration(400);
        this.h.setAnimationListener(this.E);
        this.i = new AlphaAnimation(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f);
        this.i.setDuration(400);
        this.j = new AlphaAnimation(1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        this.j.setDuration(400);
        this.o = (RelativeLayout) findViewById(2131165347);
        this.m = (FNSMainMenu) findViewById(2131165430);
        this.n = findViewById(2131165431);
        this.m.a(this.F);
        this.n.setOnClickListener(this);
        b(false);
    }

    private void j() {
        GlobalDefine.SetServerInfo(h.f1164b.n, h.f1164b.t, h.f1164b.u, h.f1164b.y, h.f1164b.p, h.f1164b.r, h.f1164b.s);
    }

    private void k() {
        net.fxgear.fitnshop.e.d.a(getApplicationContext(), (d.f) new d.f() {
            public void a() {
            }

            public void a(int i, Object obj) {
                if (i != -2) {
                    String b2 = FitNShopMainActivity.this.f802a;
                    Log.e(b2, "ERROR :: CheckApplicationVersion(), resultCode : " + i);
                } else if (obj != null && (obj instanceof d.b.a)) {
                    try {
                        boolean z = false;
                        PackageInfo packageInfo = FitNShopMainActivity.this.getPackageManager().getPackageInfo(FitNShopMainActivity.this.getPackageName(), 0);
                        d.b.a aVar = (d.b.a) obj;
                        if (aVar != null && packageInfo.versionCode < aVar.d) {
                            FitNShopMainActivity fitNShopMainActivity = FitNShopMainActivity.this;
                            if (packageInfo.versionCode < aVar.e) {
                                z = true;
                            }
                            fitNShopMainActivity.a(z, aVar.c);
                        }
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(boolean z2, final String str) {
        int i2 = z2 ? 1 : 2;
        Resources resources = getResources();
        net.fxgear.fitnshop.c.b bVar = new net.fxgear.fitnshop.c.b(this, i2);
        bVar.a(resources.getString(2131361826));
        bVar.b(resources.getString(2131361825));
        bVar.c(resources.getString(2131361957));
        bVar.d(resources.getString(2131361958));
        bVar.a((b.a) new b.a() {
            public void a(net.fxgear.fitnshop.c.b bVar) {
                String str = str;
                if (str == null) {
                    str = "market://details?id=" + FitNShopMainActivity.this.getPackageName();
                }
                FitNShopMainActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            }

            public void b(net.fxgear.fitnshop.c.b bVar) {
                bVar.dismiss();
            }
        });
        bVar.setCancelable(false);
        bVar.show();
    }

    public void a(boolean z2) {
        Log.i(this.f802a, "RequestBrandList()+");
        if (!h.d(getApplicationContext())) {
            Fragment m2 = m();
            if (m2 instanceof net.fxgear.fitnshop.d.b) {
                ((net.fxgear.fitnshop.d.b) m2).d();
            }
        } else if (this.y) {
            l();
        } else if (!h.f1164b.k()) {
            if (this.p != null) {
                this.p.a();
                this.p = null;
            }
            d.e.a aVar = new d.e.a();
            if (h.f1164b.b() || h.f1164b.c()) {
                if (this.u.isEmpty()) {
                    aVar.e = 0;
                    aVar.f = 20;
                } else {
                    aVar.e = this.u.size() - 1;
                    aVar.f = 20;
                }
            } else if (z2) {
                aVar.f1139a = 0;
                aVar.f1140b = 20;
                aVar.c = 0;
                aVar.d = 20;
            } else if (this.u.isEmpty()) {
                aVar.f1139a = 0;
                aVar.f1140b = 20;
                aVar.c = 0;
                aVar.d = 20;
                aVar.e = 0;
                aVar.f = 20;
            } else {
                aVar.e = this.u.size() - 1;
                aVar.f = 20;
            }
            this.p = net.fxgear.fitnshop.e.d.a(this, aVar, new d.f() {
                public void a() {
                    FitNShopMainActivity.this.q();
                }

                /* JADX WARNING: Removed duplicated region for block: B:22:0x005e  */
                /* JADX WARNING: Removed duplicated region for block: B:62:0x017b  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void a(int r10, java.lang.Object r11) {
                    /*
                        r9 = this;
                        net.fxgear.fitnshop.FitNShopMainActivity r0 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        r0.r()
                        r0 = 0
                        r1 = 1
                        r2 = -2
                        if (r10 != r2) goto L_0x0199
                        if (r11 == 0) goto L_0x018d
                        boolean r10 = r11 instanceof net.fxgear.fitnshop.e.d.e.b
                        if (r10 == 0) goto L_0x018d
                        net.fxgear.fitnshop.e.d$e$b r11 = (net.fxgear.fitnshop.e.d.e.b) r11
                        net.fxgear.fitnshop.e.a r10 = r11.f1142b
                        net.fxgear.fitnshop.e.b r2 = r11.c
                        r3 = 0
                        if (r10 == 0) goto L_0x0029
                        net.fxgear.fitnshop.FitNShopMainActivity r4 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        android.app.Fragment r4 = r4.m()
                        boolean r5 = r4 instanceof net.fxgear.fitnshop.d.f
                        if (r5 == 0) goto L_0x004e
                        net.fxgear.fitnshop.d.f r4 = (net.fxgear.fitnshop.d.f) r4
                        r4.a((net.fxgear.fitnshop.e.a) r10)
                        goto L_0x004e
                    L_0x0029:
                        net.fxgear.fitnshop.g r10 = net.fxgear.fitnshop.h.f1164b
                        boolean r10 = r10.b()
                        if (r10 == 0) goto L_0x0041
                        net.fxgear.fitnshop.FitNShopMainActivity r10 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        android.app.Fragment r10 = r10.m()
                        boolean r4 = r10 instanceof net.fxgear.fitnshop.d.g
                        if (r4 == 0) goto L_0x004e
                        net.fxgear.fitnshop.d.g r10 = (net.fxgear.fitnshop.d.g) r10
                        r10.e()
                        goto L_0x004e
                    L_0x0041:
                        net.fxgear.fitnshop.e.d$e$a r10 = r11.f1141a
                        int r10 = r10.d
                        if (r10 > 0) goto L_0x0050
                        net.fxgear.fitnshop.e.d$e$a r10 = r11.f1141a
                        int r10 = r10.f1140b
                        if (r10 <= 0) goto L_0x004e
                        goto L_0x0050
                    L_0x004e:
                        r10 = 0
                        goto L_0x005c
                    L_0x0050:
                        net.fxgear.fitnshop.FitNShopMainActivity r10 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        java.lang.String r10 = r10.f802a
                        java.lang.String r4 = "AD item response data error."
                        android.util.Log.e(r10, r4)
                        r10 = 1
                    L_0x005c:
                        if (r2 == 0) goto L_0x017b
                        java.util.ArrayList r4 = new java.util.ArrayList
                        r4.<init>()
                        net.fxgear.fitnshop.g r5 = net.fxgear.fitnshop.h.f1164b
                        boolean r5 = r5.l
                        if (r5 == 0) goto L_0x00d7
                        net.fxgear.fitnshop.FitNShopMainActivity r5 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        net.fxgear.fitnshop.ApplicationClass r5 = r5.s()
                        java.util.LinkedHashMap<java.lang.String, java.util.ArrayList<net.fxgear.fitnshop.e.b$a$a>> r6 = r11.d
                        r5.a(r6)
                        net.fxgear.fitnshop.e.b$a[] r2 = r2.d
                        if (r2 == 0) goto L_0x00ca
                    L_0x0078:
                        int r1 = r2.length
                        if (r3 >= r1) goto L_0x0089
                        r1 = r2[r3]
                        int r5 = r1.b()
                        int r6 = net.fxgear.fitnshop.h.c
                        if (r5 != r6) goto L_0x0086
                        goto L_0x008a
                    L_0x0086:
                        int r3 = r3 + 1
                        goto L_0x0078
                    L_0x0089:
                        r1 = r0
                    L_0x008a:
                        if (r1 == 0) goto L_0x00c7
                        java.util.LinkedHashMap<java.lang.String, java.util.ArrayList<net.fxgear.fitnshop.e.b$a$a>> r11 = r11.d
                        r1.a((java.util.LinkedHashMap<java.lang.String, java.util.ArrayList<net.fxgear.fitnshop.e.b.a.C0035a>>) r11)
                        net.fxgear.fitnshop.FitNShopMainActivity r11 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        java.util.ArrayList r11 = r11.u
                        if (r11 == 0) goto L_0x00b8
                        net.fxgear.fitnshop.FitNShopMainActivity r11 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        java.util.ArrayList r11 = r11.u
                        r11.add(r1)
                        java.lang.String r11 = r1.c()
                        r4.add(r11)
                        net.fxgear.fitnshop.FitNShopMainActivity r11 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        net.fxgear.fitnshop.FitNShopMainActivity r2 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        java.util.ArrayList r2 = r2.u
                        int r2 = r2.size()
                        int unused = r11.t = r2
                    L_0x00b8:
                        net.fxgear.fitnshop.FitNShopMainActivity r11 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        android.app.Fragment r11 = r11.m()
                        boolean r2 = r11 instanceof net.fxgear.fitnshop.d.c
                        if (r2 == 0) goto L_0x00c7
                        net.fxgear.fitnshop.d.c r11 = (net.fxgear.fitnshop.d.c) r11
                        r11.a((net.fxgear.fitnshop.e.b.a) r1)
                    L_0x00c7:
                        r1 = r10
                        goto L_0x01a4
                    L_0x00ca:
                        net.fxgear.fitnshop.FitNShopMainActivity r10 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        java.lang.String r10 = r10.f802a
                        java.lang.String r11 = "ERROR :: brand item response data error."
                        android.util.Log.e(r10, r11)
                        goto L_0x01a4
                    L_0x00d7:
                        net.fxgear.fitnshop.FitNShopMainActivity r5 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        int r6 = r2.c
                        int unused = r5.t = r6
                        net.fxgear.fitnshop.FitNShopMainActivity r5 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        java.util.ArrayList r5 = r5.u
                        if (r5 == 0) goto L_0x0126
                        net.fxgear.fitnshop.FitNShopMainActivity r5 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        java.util.ArrayList r5 = r5.u
                        boolean r5 = r5.isEmpty()
                        if (r5 == 0) goto L_0x0126
                        net.fxgear.fitnshop.FitNShopMainActivity r5 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        net.fxgear.fitnshop.ApplicationClass r5 = r5.s()
                        java.util.LinkedHashMap<java.lang.String, java.util.ArrayList<net.fxgear.fitnshop.e.b$a$a>> r6 = r11.d
                        r5.a(r6)
                        net.fxgear.fitnshop.e.b$a r5 = new net.fxgear.fitnshop.e.b$a
                        r6 = -1
                        net.fxgear.fitnshop.FitNShopMainActivity r7 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        android.content.res.Resources r7 = r7.getResources()
                        r8 = 2131361823(0x7f0a001f, float:1.834341E38)
                        java.lang.String r7 = r7.getString(r8)
                        r5.<init>(r6, r7)
                        java.util.LinkedHashMap<java.lang.String, java.util.ArrayList<net.fxgear.fitnshop.e.b$a$a>> r11 = r11.d
                        r5.a((java.util.LinkedHashMap<java.lang.String, java.util.ArrayList<net.fxgear.fitnshop.e.b.a.C0035a>>) r11)
                        net.fxgear.fitnshop.FitNShopMainActivity r11 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        java.util.ArrayList r11 = r11.u
                        r11.add(r5)
                        java.lang.String r11 = r5.c()
                        r4.add(r11)
                        goto L_0x0127
                    L_0x0126:
                        r5 = r0
                    L_0x0127:
                        net.fxgear.fitnshop.e.b$a[] r11 = r2.d
                        if (r11 == 0) goto L_0x016f
                    L_0x012b:
                        int r1 = r11.length
                        if (r3 >= r1) goto L_0x0143
                        r1 = r11[r3]
                        net.fxgear.fitnshop.FitNShopMainActivity r2 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        java.util.ArrayList r2 = r2.u
                        r2.add(r1)
                        java.lang.String r1 = r1.c()
                        r4.add(r1)
                        int r3 = r3 + 1
                        goto L_0x012b
                    L_0x0143:
                        net.fxgear.fitnshop.FitNShopMainActivity r11 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        net.fxgear.fitnshop.FNSMainMenu r11 = r11.m
                        if (r11 == 0) goto L_0x0154
                        net.fxgear.fitnshop.FitNShopMainActivity r11 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        net.fxgear.fitnshop.FNSMainMenu r11 = r11.m
                        r11.a((java.util.ArrayList<java.lang.String>) r4)
                    L_0x0154:
                        net.fxgear.fitnshop.g r11 = net.fxgear.fitnshop.h.f1164b
                        boolean r11 = r11.c()
                        if (r11 == 0) goto L_0x00c7
                        if (r5 == 0) goto L_0x00c7
                        net.fxgear.fitnshop.FitNShopMainActivity r11 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        android.app.Fragment r11 = r11.m()
                        boolean r1 = r11 instanceof net.fxgear.fitnshop.d.c
                        if (r1 == 0) goto L_0x00c7
                        net.fxgear.fitnshop.d.c r11 = (net.fxgear.fitnshop.d.c) r11
                        r11.a((net.fxgear.fitnshop.e.b.a) r5)
                        goto L_0x00c7
                    L_0x016f:
                        net.fxgear.fitnshop.FitNShopMainActivity r10 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        java.lang.String r10 = r10.f802a
                        java.lang.String r11 = "ERROR :: brand item response data error."
                        android.util.Log.e(r10, r11)
                        goto L_0x01a4
                    L_0x017b:
                        net.fxgear.fitnshop.e.d$e$a r11 = r11.f1141a
                        int r11 = r11.f
                        if (r11 <= 0) goto L_0x00c7
                        net.fxgear.fitnshop.FitNShopMainActivity r10 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        java.lang.String r10 = r10.f802a
                        java.lang.String r11 = "ERROR :: brand item response data error."
                        android.util.Log.e(r10, r11)
                        goto L_0x01a4
                    L_0x018d:
                        net.fxgear.fitnshop.FitNShopMainActivity r10 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        java.lang.String r10 = r10.f802a
                        java.lang.String r11 = "ERROR :: invalid data error."
                        android.util.Log.e(r10, r11)
                        goto L_0x01a4
                    L_0x0199:
                        net.fxgear.fitnshop.FitNShopMainActivity r10 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        java.lang.String r10 = r10.f802a
                        java.lang.String r11 = "ERROR :: Network error"
                        android.util.Log.e(r10, r11)
                    L_0x01a4:
                        if (r1 == 0) goto L_0x01b5
                        net.fxgear.fitnshop.FitNShopMainActivity r10 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        android.app.Fragment r10 = r10.m()
                        boolean r11 = r10 instanceof net.fxgear.fitnshop.d.b
                        if (r11 == 0) goto L_0x01b5
                        net.fxgear.fitnshop.d.b r10 = (net.fxgear.fitnshop.d.b) r10
                        r10.d()
                    L_0x01b5:
                        net.fxgear.fitnshop.FitNShopMainActivity r10 = net.fxgear.fitnshop.FitNShopMainActivity.this
                        net.fxgear.fitnshop.e.d.e unused = r10.p = r0
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.FitNShopMainActivity.AnonymousClass15.a(int, java.lang.Object):void");
                }
            });
        }
    }

    private void l() {
        Log.i(this.f802a, "CheckAvailableClothes()+");
        if (this.z != null) {
            this.z.a();
            this.z = null;
        }
        String[] a2 = d.a(getApplicationContext()).a();
        if (a2 != null) {
            this.z = net.fxgear.fitnshop.e.d.a(a2, (d.f) new d.f() {
                public void a() {
                    FitNShopMainActivity.this.q();
                }

                public void a(int i, Object obj) {
                    Fragment e;
                    FitNShopMainActivity.this.r();
                    d.c unused = FitNShopMainActivity.this.z = null;
                    boolean z = true;
                    if (i == -2) {
                        if (obj != null) {
                            if (obj instanceof String[]) {
                                String[] strArr = (String[]) obj;
                                for (String a2 : strArr) {
                                    d.a(FitNShopMainActivity.this.getApplicationContext()).a(a2);
                                }
                                if (strArr.length > 0 && (e = FitNShopMainActivity.this.m()) != null && (e instanceof net.fxgear.fitnshop.d.b)) {
                                    Log.d(FitNShopMainActivity.this.f802a, "Refresh fragment.");
                                    ((net.fxgear.fitnshop.d.b) e).c();
                                }
                            } else {
                                Log.e(FitNShopMainActivity.this.f802a, "ERROR :: invalid data error.");
                            }
                        }
                        z = false;
                    } else {
                        Log.e(FitNShopMainActivity.this.f802a, "ERROR :: Network error");
                    }
                    if (z) {
                        Fragment e2 = FitNShopMainActivity.this.m();
                        if (e2 instanceof net.fxgear.fitnshop.d.b) {
                            ((net.fxgear.fitnshop.d.b) e2).d();
                            return;
                        }
                        return;
                    }
                    boolean unused2 = FitNShopMainActivity.this.y = false;
                    FitNShopMainActivity.this.a(false);
                }
            });
            return;
        }
        this.y = false;
        a(false);
    }

    /* access modifiers changed from: private */
    public Fragment m() {
        return getFragmentManager().findFragmentById(2131165347);
    }

    /* access modifiers changed from: private */
    public void n() {
        Log.d(this.f802a, "ClearFragmentStack");
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        if (backStackEntryCount > 0) {
            String str = this.f802a;
            Log.e(str, "Remaing stack size(before) : " + backStackEntryCount);
            for (int i2 = 0; i2 < backStackEntryCount; i2++) {
                Fragment findFragmentByTag = fragmentManager.findFragmentByTag(fragmentManager.getBackStackEntryAt(0).getName());
                String str2 = this.f802a;
                Log.e(str2, "Remove remaing stackFragment : " + findFragmentByTag.getTag());
                fragmentManager.popBackStackImmediate();
                beginTransaction.remove(findFragmentByTag);
            }
            String str3 = this.f802a;
            Log.e(str3, "Remaing stack size(after) : " + fragmentManager.getBackStackEntryCount());
        }
        beginTransaction.commit();
    }

    /* access modifiers changed from: private */
    public void a(net.fxgear.fitnshop.d.b bVar, int i2) {
        String str = this.f802a;
        Log.d(str, "AddFragment()+, fragmentFlag: " + i2);
        if (bVar != null) {
            String a2 = bVar.a();
            if (i2 != 0) {
                n();
                FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
                beginTransaction.setTransition(0);
                beginTransaction.add(2131165347, bVar, a2);
                beginTransaction.commit();
                return;
            }
            FragmentTransaction beginTransaction2 = getFragmentManager().beginTransaction();
            beginTransaction2.setTransition(0);
            Fragment m2 = m();
            if (m2 != null) {
                beginTransaction2.hide(m2);
            }
            beginTransaction2.add(2131165347, bVar, a2);
            beginTransaction2.addToBackStack(a2);
            beginTransaction2.commit();
        }
    }

    public boolean a() {
        return this.m.getVisibility() != 8;
    }

    /* access modifiers changed from: private */
    public boolean o() {
        return this.m.getAnimation() != null;
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        String str = this.f802a;
        Log.d(str, "SetEnableMainMenu()+, enable : " + z2);
        if (z2) {
            this.m.setVisibility(0);
            this.n.setVisibility(0);
        } else {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
        }
        this.m.setClickable(z2);
    }

    private void p() {
        Log.d(this.f802a, "OpenMenuWithAnimation()+");
        this.m.setVisibility(0);
        this.n.setVisibility(0);
        this.m.startAnimation(this.h);
        this.o.startAnimation(this.f);
        this.n.startAnimation(this.i);
    }

    private void b(Runnable runnable) {
        Log.d(this.f802a, "CloseMenuWithAnimation()+");
        this.m.startAnimation(c(runnable));
        this.o.startAnimation(this.g);
        this.n.startAnimation(this.j);
    }

    private Animation c(final Runnable runnable) {
        final TranslateAnimation translateAnimation = new TranslateAnimation(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, -this.k, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setDuration(400);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (animation.equals(translateAnimation)) {
                    FitNShopMainActivity.this.b(false);
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            }
        });
        return translateAnimation;
    }

    public void b() {
        if (!o()) {
            p();
            f.a("MENUBTN_CLI", "");
        }
    }

    public void a(Runnable runnable) {
        if (!o()) {
            b(runnable);
        }
    }

    public void c() {
        if (this.m != null) {
            this.m.a();
        }
    }

    public void a(String str) {
        if (this.m != null) {
            this.m.a(str);
        }
    }

    public void b(String str) {
        Log.d(this.f802a, "CloseFragment()+");
        if (str != null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            int backStackEntryCount = fragmentManager.getBackStackEntryCount();
            if (backStackEntryCount > 0) {
                Fragment findFragmentByTag = fragmentManager.findFragmentByTag(fragmentManager.getBackStackEntryAt(backStackEntryCount - 1).getName());
                if ((findFragmentByTag instanceof net.fxgear.fitnshop.d.b) && str.equals(((net.fxgear.fitnshop.d.b) findFragmentByTag).a())) {
                    fragmentManager.popBackStackImmediate();
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commit();
        }
    }

    public void a(String str, String str2, String str3) {
        a(str, this.x, str2, str3);
    }

    public void a(String str, String str2, String str3, String str4) {
        Intent intent = new Intent(this, FittingModeActivity.class);
        intent.putExtra("extra_mode", str);
        intent.putExtra("extra_product_uuid", str3);
        intent.putExtra("extra_character", str2);
        intent.putExtra("extra_from", str4);
        a(intent);
    }

    private void a(Intent intent) {
        Log.i(this.f802a, "CheckFittingModeUpdateAndGoToFittingMode()+");
        if (!h.d(getApplicationContext())) {
            c(intent);
        } else if (this.C != null && this.C.getStatus() != AsyncTask.Status.FINISHED) {
            Log.e(this.f802a, "Already running Fitting mode update check.");
        } else if (this.B) {
            b(intent);
        } else {
            startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public void b(final Intent intent) {
        if (!h.d(getApplicationContext())) {
            c(intent);
        } else if (this.A != null) {
            Log.i(this.f802a, "Already running Fitting Initializer Dialog.");
        } else {
            this.A = new net.fxgear.fitnshop.c.d(this);
            this.A.a((d.a) new d.a() {
                public void a() {
                    FitNShopMainActivity.this.c(true);
                }

                public void a(GlobalDefine.Result result) {
                    FitNShopMainActivity.this.c(false);
                    if (result.resultCode == -1) {
                        boolean unused = FitNShopMainActivity.this.B = false;
                        FitNShopMainActivity.this.startActivity(intent);
                    } else {
                        FitNShopMainActivity.this.a(result, intent);
                    }
                    FitNShopMainActivity.this.A.a((d.a) null);
                    net.fxgear.fitnshop.c.d unused2 = FitNShopMainActivity.this.A = null;
                }
            });
            this.A.a();
        }
    }

    private void c(final Intent intent) {
        String string;
        String string2;
        String string3;
        String string4;
        b.a r4;
        if (net.fxgear.fittingmodenative.c.a((Context) this)) {
            string = getResources().getString(2131361834);
            string2 = getResources().getString(2131361964);
            string3 = getResources().getString(2131361966);
            string4 = getResources().getString(a.g.fitting_mode_offline);
            r4 = new b.a() {
                public void a(net.fxgear.fitnshop.c.b bVar) {
                    if (bVar != null) {
                        bVar.dismiss();
                    }
                    FitNShopMainActivity.this.b(intent);
                }

                public void b(net.fxgear.fitnshop.c.b bVar) {
                    if (bVar != null) {
                        bVar.dismiss();
                    }
                    FitNShopMainActivity.this.startActivity(intent);
                }
            };
        } else {
            string = getResources().getString(2131361834);
            string2 = getResources().getString(2131361963);
            string3 = getResources().getString(2131361966);
            string4 = getResources().getString(2131361962);
            r4 = new b.a() {
                public void a(net.fxgear.fitnshop.c.b bVar) {
                    if (bVar != null) {
                        bVar.dismiss();
                    }
                    FitNShopMainActivity.this.b(intent);
                }

                public void b(net.fxgear.fitnshop.c.b bVar) {
                    if (bVar != null) {
                        bVar.dismiss();
                    }
                }
            };
        }
        a(string, string2, 2, string3, string4, r4);
    }

    /* access modifiers changed from: private */
    public void a(GlobalDefine.Result result, final Intent intent) {
        AnonymousClass4 r11;
        String str;
        String str2;
        int i2;
        String str3;
        String str4;
        String string;
        String format;
        String string2;
        b.a r1;
        Resources resources = getResources();
        int i3 = result.resultCode;
        if (i3 != -2) {
            if (i3 != 4) {
                if (i3 != 10) {
                    switch (i3) {
                        case GlobalDefine.RESULT_CODE_ERROR_MALFORMEDURL:
                        case 14:
                            break;
                        default:
                            string = "Unknown";
                            format = "Error code : " + result.resultCode;
                            string2 = resources.getString(a.g.confirm);
                            r1 = new b.a() {
                                public void a(net.fxgear.fitnshop.c.b bVar) {
                                    if (bVar != null) {
                                        bVar.dismiss();
                                    }
                                }

                                public void b(net.fxgear.fitnshop.c.b bVar) {
                                    if (bVar != null) {
                                        bVar.dismiss();
                                    }
                                }
                            };
                            break;
                    }
                }
                c(intent);
                return;
            }
            long j2 = 0;
            if (result.resultExtra != null && (result.resultExtra instanceof Long)) {
                j2 = ((Long) result.resultExtra).longValue();
            }
            String a2 = h.a(j2);
            string = resources.getString(2131361954);
            format = String.format(resources.getString(2131361953), new Object[]{a2});
            string2 = resources.getString(a.g.confirm);
            r1 = new b.a() {
                public void a(net.fxgear.fitnshop.c.b bVar) {
                    if (bVar != null) {
                        bVar.dismiss();
                    }
                }

                public void b(net.fxgear.fitnshop.c.b bVar) {
                    if (bVar != null) {
                        bVar.dismiss();
                    }
                }
            };
            str3 = format;
            str4 = string;
            str2 = string2;
            r11 = r1;
            str = null;
            i2 = 1;
        } else {
            String string3 = getResources().getString(2131361959);
            String string4 = resources.getString(2131361966);
            str4 = string3;
            str = resources.getString(2131361962);
            str2 = string4;
            r11 = new b.a() {
                public void a(net.fxgear.fitnshop.c.b bVar) {
                    if (bVar != null) {
                        bVar.dismiss();
                    }
                    FitNShopMainActivity.this.b(intent);
                }

                public void b(net.fxgear.fitnshop.c.b bVar) {
                    if (bVar != null) {
                        bVar.dismiss();
                    }
                }
            };
            str3 = null;
            i2 = 2;
        }
        a(str4, str3, i2, str2, str, r11);
    }

    /* access modifiers changed from: private */
    public void c(boolean z2) {
        if (z2) {
            getWindow().addFlags(2097152);
        } else {
            getWindow().clearFlags(2097152);
        }
    }

    public Fragment c(String str) {
        Fragment fragment = null;
        if (str == null) {
            return null;
        }
        FragmentManager fragmentManager = getFragmentManager();
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        if (backStackEntryCount > 0) {
            int i2 = backStackEntryCount - 1;
            while (true) {
                if (i2 < 0) {
                    break;
                }
                String name = fragmentManager.getBackStackEntryAt(i2).getName();
                Fragment findFragmentByTag = fragmentManager.findFragmentByTag(name);
                if ((findFragmentByTag instanceof net.fxgear.fitnshop.d.b) && name.equals(str)) {
                    fragment = findFragmentByTag;
                    break;
                }
                i2--;
            }
        }
        return fragment == null ? fragmentManager.findFragmentByTag(str) : fragment;
    }

    public boolean a(b.a aVar) {
        i.a(this.f802a, "OpenClothesList()+, item");
        if (aVar == null) {
            Log.e(this.f802a, "Not found brandID.");
            aVar = this.u.get(0);
        }
        net.fxgear.fitnshop.d.c cVar = new net.fxgear.fitnshop.d.c(this.D, aVar);
        cVar.a(1);
        a((net.fxgear.fitnshop.d.b) cVar, 0);
        return true;
    }

    public void a(int i2, String str) {
        a((net.fxgear.fitnshop.d.b) new h(i2, str), 0);
    }

    public b.a a(int i2) {
        String str = this.f802a;
        i.a(str, "GetBrandItem()+, brandID : " + i2);
        if (this.u != null) {
            Iterator<b.a> it = this.u.iterator();
            while (it.hasNext()) {
                b.a next = it.next();
                if (next.b() == i2) {
                    return next;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public boolean b(b.a aVar) {
        Fragment m2 = m();
        if (m2 instanceof net.fxgear.fitnshop.d.c) {
            ((net.fxgear.fitnshop.d.c) m2).a(aVar);
        } else {
            if (m2 instanceof net.fxgear.fitnshop.d.f) {
                ((net.fxgear.fitnshop.d.f) m2).a(0);
                net.fxgear.fitnshop.d.c cVar = new net.fxgear.fitnshop.d.c(this.D, aVar);
                cVar.a(0);
                a((net.fxgear.fitnshop.d.b) cVar, 0);
            }
            if (m2 instanceof g) {
                ((g) m2).a(0);
                net.fxgear.fitnshop.d.c cVar2 = new net.fxgear.fitnshop.d.c(this.D, aVar);
                cVar2.a(0);
                a((net.fxgear.fitnshop.d.b) cVar2, 0);
            } else {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                int backStackEntryCount = fragmentManager.getBackStackEntryCount();
                if (backStackEntryCount > 0) {
                    int i2 = backStackEntryCount - 1;
                    while (true) {
                        if (i2 < 0) {
                            break;
                        }
                        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(fragmentManager.getBackStackEntryAt(i2).getName());
                        if (findFragmentByTag instanceof net.fxgear.fitnshop.d.c) {
                            ((net.fxgear.fitnshop.d.c) findFragmentByTag).a(aVar);
                            break;
                        }
                        fragmentManager.popBackStackImmediate();
                        beginTransaction.remove(findFragmentByTag);
                        i2--;
                    }
                }
                beginTransaction.commit();
            }
        }
        return true;
    }

    public boolean a(final String str, final boolean z2) {
        if (h.d(getApplicationContext())) {
            a((net.fxgear.fitnshop.d.b) new l(str, z2), 0);
            return true;
        }
        a((b.a) new b.a() {
            public void a(net.fxgear.fitnshop.c.b bVar) {
                bVar.dismiss();
                FitNShopMainActivity.this.a(str, z2);
            }

            public void b(net.fxgear.fitnshop.c.b bVar) {
                bVar.dismiss();
            }
        });
        return false;
    }

    public void d() {
        a((net.fxgear.fitnshop.d.b) new j(), 0);
    }

    public String e() {
        return this.x;
    }

    public void d(String str) {
        this.x = str;
    }

    public String e(String str) {
        Iterator<a> it = this.v.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.f837a.equals(str)) {
                return next.f838b;
            }
        }
        return null;
    }

    public String f(String str) {
        Iterator<a> it = this.v.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.f838b.equals(str)) {
                return next.f837a;
            }
        }
        return GlobalDefine.GENDER_WOMAN_STRING;
    }

    public String f() {
        return e(this.x);
    }

    public void g(String str) {
        Iterator<a> it = this.v.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.f838b.equals(str)) {
                this.x = next.f837a;
                return;
            }
        }
    }

    public int g() {
        return this.w;
    }

    public void b(int i2) {
        this.w = i2;
    }

    public void h(String str) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        if (backStackEntryCount > 0) {
            for (int i2 = backStackEntryCount - 1; i2 >= 0; i2--) {
                Fragment findFragmentByTag = fragmentManager.findFragmentByTag(fragmentManager.getBackStackEntryAt(i2).getName());
                if (findFragmentByTag instanceof k) {
                    ((k) findFragmentByTag).a(0);
                    fragmentManager.popBackStackImmediate();
                    beginTransaction.remove(findFragmentByTag);
                } else if (findFragmentByTag instanceof net.fxgear.fitnshop.d.c) {
                    ((net.fxgear.fitnshop.d.c) findFragmentByTag).a(2);
                }
            }
        }
        if (h.f1164b.c()) {
            Fragment m2 = m();
            if (m2 instanceof net.fxgear.fitnshop.d.c) {
                ((net.fxgear.fitnshop.d.c) m2).a(2);
            }
        }
        beginTransaction.commit();
        k kVar = new k(this.D, str);
        kVar.a(1);
        a((net.fxgear.fitnshop.d.b) kVar, 0);
        f.a("SEARCH_RESULTVIEW_DONE", "");
    }

    public void onClick(View view) {
        if (view.getId() == 2131165431) {
            a((Runnable) null);
        }
    }

    public void onBackPressed() {
        Log.i(this.f802a, "onBackPressed()+");
        if (a()) {
            a((Runnable) null);
            return;
        }
        Fragment m2 = m();
        if (!(m2 instanceof net.fxgear.fitnshop.d.b) || !((net.fxgear.fitnshop.d.b) m2).b()) {
            if (h.f1164b.c()) {
                if (m2 instanceof net.fxgear.fitnshop.d.c) {
                    h.f1163a = true;
                }
            } else if (m2 instanceof net.fxgear.fitnshop.d.f) {
                h.f1163a = true;
            } else if (m2 instanceof g) {
                h.f1163a = true;
            }
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Log.i(this.f802a, "onResume()+");
        h.b((Activity) this);
        if (this.l != null) {
            this.l.a(false);
            if (this.l.g()) {
                this.l.f();
            }
        }
        Fragment m2 = m();
        if (m2 != null && (m2 instanceof net.fxgear.fitnshop.d.b)) {
            Log.d(this.f802a, "Refresh fragment.");
            ((net.fxgear.fitnshop.d.b) m2).c();
        }
        if (h.f1164b.v == null && h.f1164b.u != null) {
            f.a(getApplicationContext(), h.f1164b.u);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        Log.i(this.f802a, "onPause()+");
        if (this.l != null) {
            this.l.b(false);
            this.l.a(true);
            this.l.i();
        }
        if (this.D != null) {
            this.D.a();
        }
        if (this.r != null && this.r.isShowing()) {
            this.r.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Log.i(this.f802a, "onDestroy()+");
        r();
        if (this.A != null) {
            if (this.A.isShowing()) {
                c(false);
                this.A.b();
            }
            this.A.a((d.a) null);
            this.A = null;
        }
        if (this.r != null) {
            if (this.r.isShowing()) {
                this.r.dismiss();
            }
            this.r = null;
        }
        if (this.l != null) {
            this.l.j();
            this.l = null;
        }
        if (this.D != null) {
            this.D.b();
            this.D = null;
        }
        if (this.q != null) {
            this.q.a();
            this.q = null;
        }
        if (this.p != null) {
            this.p.a();
            this.p = null;
        }
        s().a((LinkedHashMap<String, ArrayList<b.a.C0035a>>) null);
        if (this.u != null) {
            int size = this.u.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.u.get(i2).a();
            }
            this.u.clear();
            this.u = null;
        }
        if (this.v != null) {
            this.v.clear();
            this.v = null;
        }
        if (this.m != null) {
            this.m.a((FNSMainMenu.b) null);
            this.m.b();
            this.m = null;
        }
        this.F = null;
        if (this.n != null) {
            this.n.setOnClickListener((View.OnClickListener) null);
            this.n = null;
        }
        this.o = null;
        if (this.h != null) {
            this.h.setAnimationListener((Animation.AnimationListener) null);
            this.h = null;
        }
        this.f = null;
        this.g = null;
        this.i = null;
        this.j = null;
        this.E = null;
        if (this.z != null) {
            this.z.a();
            this.z = null;
        }
        if (this.C != null) {
            this.C.a();
            this.C = null;
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        String str;
        super.onNewIntent(intent);
        Log.i(this.f802a, "onNewIntent()+");
        Fragment m2 = m();
        if (m2 != null && (m2 instanceof net.fxgear.fitnshop.d.b)) {
            Log.d(this.f802a, "Refresh fragment.");
            ((net.fxgear.fitnshop.d.b) m2).c();
        }
        if (intent != null && intent.hasExtra("extra_to_app_mode")) {
            String stringExtra = intent.getStringExtra("extra_to_app_mode");
            String str2 = this.f802a;
            Log.i(str2, "To app mode : " + stringExtra);
            if (stringExtra == null) {
                return;
            }
            if (stringExtra.equals("add_item")) {
                if (intent.hasExtra("extra_sex")) {
                    String stringExtra2 = intent.getStringExtra("extra_sex");
                    String stringExtra3 = intent.getStringExtra("extra_age");
                    String str3 = this.f802a;
                    Log.i(str3, "ADD_Item gender : " + stringExtra2 + ", age : " + stringExtra3);
                    if (stringExtra2 == null || stringExtra3 == null) {
                        str = GlobalDefine.GENDER_WOMAN_STRING;
                    } else {
                        str = stringExtra2.equals(GlobalDefine.GENDER_WOMAN_STRING) ? stringExtra3.equals(GlobalDefine.AGE_EARLY_STRING) ? "girl" : GlobalDefine.GENDER_WOMAN_STRING : stringExtra2.equals(GlobalDefine.GENDER_MAN_STRING) ? stringExtra3.equals(GlobalDefine.AGE_EARLY_STRING) ? "boy" : GlobalDefine.GENDER_MAN_STRING : GlobalDefine.GENDER_WOMAN_STRING;
                    }
                    if (!h.f1164b.k()) {
                        d(str);
                        if (this.u != null && !this.u.isEmpty()) {
                            b(this.u.get(0));
                        }
                    }
                }
            } else if (stringExtra.equals("buy_item") && h.f1164b.k() && intent.hasExtra("extra_url")) {
                String stringExtra4 = intent.getStringExtra("extra_url");
                if (m2 instanceof m) {
                    ((m) m2).a(stringExtra4);
                }
            }
        }
    }

    private void a(String str, String str2, int i2, String str3, String str4, b.a aVar) {
        if (this.r != null) {
            if (this.r.isShowing()) {
                this.r.dismiss();
            }
            this.r.a((b.a) null);
            this.r = null;
        }
        this.r = new net.fxgear.fitnshop.c.b(this, i2);
        this.r.setCanceledOnTouchOutside(false);
        this.r.a(str);
        this.r.b(str2);
        this.r.c(str3);
        if (i2 == 2) {
            this.r.d(str4);
        }
        this.r.a(aVar);
        this.r.show();
    }

    public void a(b.a aVar) {
        a(getResources().getString(2131361834), getResources().getString(2131361830), 2, getResources().getString(2131361833), getResources().getString(2131361829), aVar);
    }

    /* access modifiers changed from: private */
    public void q() {
        if (this.s == null) {
            this.s = new net.fxgear.fitnshop.c.a(this, 0);
        }
        this.s.show();
    }

    /* access modifiers changed from: private */
    public void r() {
        if (this.s != null) {
            if (this.s.isShowing()) {
                this.s.dismiss();
            }
            this.s = null;
        }
    }

    /* access modifiers changed from: private */
    public ApplicationClass s() {
        return (ApplicationClass) getApplicationContext();
    }

    public void c(int i2) {
        if (this.u != null && this.u.size() > 0) {
            int i3 = -1;
            int size = this.u.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    break;
                } else if (this.u.get(i4).b() == i2) {
                    i3 = i4;
                    break;
                } else {
                    i4++;
                }
            }
            if (i3 < 0) {
                return;
            }
            if (this.q == null || this.q.getStatus() == AsyncTask.Status.FINISHED) {
                this.q = new b(i3);
                this.q.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            }
            Log.e(this.f802a, "Task running.");
        }
    }

    public boolean h() {
        return this.u == null || this.u.isEmpty();
    }

    private class b extends AsyncTask<Void, Void, b.a> {

        /* renamed from: b  reason: collision with root package name */
        private final int f840b;
        private boolean c = false;

        public b(int i) {
            this.f840b = i;
        }

        public void a() {
            cancel(true);
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            FitNShopMainActivity.this.q();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public b.a doInBackground(Void... voidArr) {
            try {
                if (isCancelled()) {
                    return null;
                }
                b.a aVar = (b.a) FitNShopMainActivity.this.u.get(this.f840b);
                for (String str : h.d) {
                    if (isCancelled()) {
                        Log.d(FitNShopMainActivity.this.f802a, "Task cancel.");
                        return null;
                    }
                    aVar.a(str, net.fxgear.fitnshop.e.d.a(aVar.b(), str));
                }
                return aVar;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                this.c = true;
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                this.c = true;
                return null;
            } catch (JSONException e3) {
                e3.printStackTrace();
                this.c = true;
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(b.a aVar) {
            FitNShopMainActivity.this.r();
            if (aVar != null) {
                if (FitNShopMainActivity.this.b(aVar)) {
                    f.a("SIDE_CLI_PRDVIEW_DONE", "");
                }
            } else if (!this.c) {
                Log.e(FitNShopMainActivity.this.f802a, "Not found brand info.");
            } else if (FitNShopMainActivity.this.b((b.a) FitNShopMainActivity.this.u.get(this.f840b))) {
                f.a("SIDE_CLI_PRDVIEW_DONE", "");
            }
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        switch (i2) {
            case 0:
                if (iArr.length > 0 && iArr[0] == 0) {
                    if (h.f1164b.k()) {
                        a("add_clothes", (String) null, this.f802a);
                        return;
                    }
                    AnonymousClass10 r1 = new Runnable() {
                        public void run() {
                            FitNShopMainActivity.this.a("add_video", (String) null, "FNSMainMenu");
                        }
                    };
                    f.a("SIDE_MIRROR_CLI", "");
                    a((Runnable) r1);
                    return;
                }
                return;
            case 1:
                return;
            default:
                super.onRequestPermissionsResult(i2, strArr, iArr);
                return;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\FittingModeActivity.java ==========

package net.fxgear.fitnshop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import net.fxgear.GlobalDefine;
import net.fxgear.a.a;
import net.fxgear.fitnshop.c.a;
import net.fxgear.fitnshop.c.b;
import net.fxgear.fitnshop.e.b;
import net.fxgear.fitnshop.e.d;
import net.fxgear.fittingmodenative.FittingActivity;
import net.fxgear.fittingmodenative.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FittingModeActivity extends FittingActivity {
    public static final boolean NEED_UPDATE_FILE = true;
    private final String FORMAT_PURCHASE_URL = "%s&opt=order&size=%s";
    private final String TAG = FittingModeActivity.class.getSimpleName();
    /* access modifiers changed from: private */
    public a mCircleDialog;
    /* access modifiers changed from: private */
    public d.g mProductItemURLTask;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SetStatisticsServerInfo(h.f1164b.o, h.f1164b.v, 1);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Log.i(this.TAG, "onResume()+");
        h.b((Activity) this);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        Log.i(this.TAG, "onPause()+");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (this.mProductItemURLTask != null) {
            this.mProductItemURLTask.a();
            this.mProductItemURLTask = null;
        }
        if (this.mCircleDialog != null) {
            if (this.mCircleDialog.isShowing()) {
                this.mCircleDialog.dismiss();
            }
            this.mCircleDialog = null;
        }
        super.onDestroy();
    }

    public boolean GetFPSMode() {
        return h.f1164b.g();
    }

    public int GetDefaultMirrorVideoID(int i, int i2) {
        return j.a((Context) this).a(i, i2);
    }

    public int GetDefaultAvatarID(int i, int i2) {
        return a.a((Context) this).a(i, i2);
    }

    public void OnShowItemList(int i, String str) {
        int i2;
        Log.i(this.TAG, "OnShowAvatarList()+");
        switch (i) {
            case GlobalDefine.RESULT_CODE_ERROR_FAILED_TO_DETECT_ZERO_FACE:
                i2 = 33;
                break;
            case 21:
                i2 = 30;
                break;
            case 22:
                i2 = 31;
                break;
            default:
                String str2 = this.TAG;
                Log.e(str2, "wrong list type: " + i);
                return;
        }
        Intent intent = new Intent(this, FXListActivity.class);
        intent.putExtra("request_code", i2);
        intent.putExtra("json_selected_items_info", str);
        startActivityForResult(intent, i2);
    }

    public void OnBuyClothes(String str) {
        if (str == null || !str.startsWith("order?data=")) {
            Log.e(this.TAG, "ERROR :: invalid parameter!");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str.substring("order?data=".length()));
            ShowBuyWebPage(h.a(jSONObject), h.b(jSONObject));
        } catch (JSONException e) {
            Log.e(this.TAG, "ERROR :: invalid JSON");
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void ShowBuyWebPage(final String str, final String str2) {
        if (this.mProductItemURLTask != null) {
            this.mProductItemURLTask.a();
            this.mProductItemURLTask = null;
        }
        if (h.d(getApplicationContext())) {
            this.mProductItemURLTask = d.a(Integer.parseInt(str), (d.f) new d.f() {
                public void a() {
                    if (FittingModeActivity.this.mCircleDialog == null) {
                        a unused = FittingModeActivity.this.mCircleDialog = new a(FittingModeActivity.this, 0);
                    }
                    FittingModeActivity.this.mCircleDialog.show();
                }

                public void a(int i, Object obj) {
                    d.g unused = FittingModeActivity.this.mProductItemURLTask = null;
                    if (FittingModeActivity.this.mCircleDialog != null) {
                        if (FittingModeActivity.this.mCircleDialog.isShowing()) {
                            FittingModeActivity.this.mCircleDialog.dismiss();
                        }
                        a unused2 = FittingModeActivity.this.mCircleDialog = null;
                    }
                    if (obj != null && (obj instanceof String)) {
                        String format = String.format("%s&opt=order&size=%s", new Object[]{(String) obj, str2});
                        if (h.f1164b.k()) {
                            Intent intent = new Intent(FittingModeActivity.this, FitNShopMainActivity.class);
                            intent.setFlags(131072);
                            intent.putExtra("extra_to_app_mode", "buy_item");
                            intent.putExtra("extra_url", format);
                            FittingModeActivity.this.startActivity(intent);
                            FittingModeActivity.this.finish();
                            return;
                        }
                        Intent intent2 = new Intent(FittingModeActivity.this, WebActivity.class);
                        intent2.putExtra("extra_url", format);
                        FittingModeActivity.this.startActivity(intent2);
                    }
                }
            });
        } else {
            ShowNetworkErrorDialog(new b.a() {
                public void a(b bVar) {
                    bVar.dismiss();
                    FittingModeActivity.this.ShowBuyWebPage(str, str2);
                }

                public void b(b bVar) {
                    bVar.dismiss();
                }
            });
        }
    }

    public ArrayList<String> OnRemoveClothes(String str) {
        if (str == null || !str.contains("remove_wishlist?data=")) {
            return null;
        }
        Context applicationContext = getApplicationContext();
        try {
            String a2 = h.a(new JSONObject(str.substring("remove_wishlist?data=".length())));
            if (a2 != null) {
                d.a(applicationContext).a(a2);
                return null;
            }
            Log.d(this.TAG, "Not found productUUID.");
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0086  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String OnEnterToFitRoom(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = r6.TAG
            java.lang.String r1 = "onEnterToFitRoom()+"
            android.util.Log.i(r0, r1)
            android.content.Intent r0 = r6.getIntent()
            android.content.Context r1 = r6.getApplicationContext()
            r2 = 0
            if (r0 == 0) goto L_0x007c
            java.lang.String r3 = "extra_mode"
            boolean r3 = r0.hasExtra(r3)
            if (r3 == 0) goto L_0x0074
            java.lang.String r3 = "extra_mode"
            java.lang.String r3 = r0.getStringExtra(r3)
            java.lang.String r4 = "extra_product_uuid"
            java.lang.String r4 = r0.getStringExtra(r4)
            java.lang.String r5 = "extra_character"
            java.lang.String r5 = r0.getStringExtra(r5)
            java.lang.String r4 = net.fxgear.fitnshop.h.a(r1, r3, r4, r5)
            if (r3 == 0) goto L_0x0084
            java.lang.String r5 = "fitting"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0084
            java.lang.String r3 = "extra_from"
            boolean r3 = r0.hasExtra(r3)
            if (r3 == 0) goto L_0x0084
            java.lang.String r3 = "extra_from"
            java.lang.String r0 = r0.getStringExtra(r3)
            if (r0 == 0) goto L_0x0084
            java.lang.String r3 = "SUC_ON_REAL"
            if (r7 == 0) goto L_0x0058
            java.lang.String r5 = "avatar"
            boolean r7 = r7.equals(r5)
            if (r7 == 0) goto L_0x0058
            java.lang.String r3 = "SUC_ON_AVATAR"
        L_0x0058:
            java.lang.String r7 = net.fxgear.fitnshop.d.c.d
            boolean r7 = r0.equals(r7)
            if (r7 == 0) goto L_0x0066
            java.lang.String r7 = "PRD_THUMBNAIL_CLI_STATUS"
            net.fxgear.fitnshop.e.f.a((java.lang.String) r7, (java.lang.String) r3)
            goto L_0x0084
        L_0x0066:
            java.lang.String r7 = net.fxgear.fitnshop.d.k.d
            boolean r7 = r0.equals(r7)
            if (r7 == 0) goto L_0x0084
            java.lang.String r7 = "SEARCH_PRD_THUMBNAIL_CLI_STATUS"
            net.fxgear.fitnshop.e.f.a((java.lang.String) r7, (java.lang.String) r3)
            goto L_0x0084
        L_0x0074:
            java.lang.String r7 = r6.TAG
            java.lang.String r0 = "ERROR :: mode not exist"
            android.util.Log.e(r7, r0)
            goto L_0x0083
        L_0x007c:
            java.lang.String r7 = r6.TAG
            java.lang.String r0 = "ERROR :: intent null"
            android.util.Log.e(r7, r0)
        L_0x0083:
            r4 = r2
        L_0x0084:
            if (r4 != 0) goto L_0x008c
            java.lang.String r7 = "previous_state"
            java.lang.String r4 = net.fxgear.fitnshop.h.a(r1, r7, r2, r2)
        L_0x008c:
            net.fxgear.fitnshop.h.b((java.lang.String) r4)
            r6.setIntent(r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.FittingModeActivity.OnEnterToFitRoom(java.lang.String):java.lang.String");
    }

    public void OnShowProductList(String str, String str2) {
        if (str != null && str2 != null) {
            Intent intent = new Intent(this, FitNShopMainActivity.class);
            intent.setFlags(131072);
            intent.putExtra("extra_to_app_mode", "add_item");
            intent.putExtra("extra_sex", str);
            intent.putExtra("extra_age", str2);
            startActivity(intent);
            finish();
        }
    }

    public String GetCategoryList() {
        String str;
        String str2;
        Log.i(this.TAG, "GetCategoryList()+");
        try {
            LinkedHashMap<String, ArrayList<b.a.C0035a>> a2 = ((ApplicationClass) getApplicationContext()).a();
            if (a2 != null) {
                JSONArray jSONArray = new JSONArray();
                for (String next : a2.keySet()) {
                    if (next.equals(GlobalDefine.GENDER_MAN_STRING)) {
                        str2 = GlobalDefine.GENDER_MAN_STRING;
                        str = GlobalDefine.AGE_MIDDLE_STRING;
                    } else if (next.equals("girl")) {
                        str2 = GlobalDefine.GENDER_WOMAN_STRING;
                        str = GlobalDefine.AGE_EARLY_STRING;
                    } else if (next.equals("boy")) {
                        str2 = GlobalDefine.GENDER_MAN_STRING;
                        str = GlobalDefine.AGE_EARLY_STRING;
                    } else {
                        str2 = GlobalDefine.GENDER_WOMAN_STRING;
                        str = GlobalDefine.AGE_MIDDLE_STRING;
                    }
                    Iterator it = a2.get(next).iterator();
                    while (it.hasNext()) {
                        b.a.C0035a aVar = (b.a.C0035a) it.next();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("gender", str2);
                        jSONObject.put("age", str);
                        jSONObject.put("category_id", aVar.a());
                        jSONObject.put("category_name", aVar.b());
                        jSONArray.put(jSONObject);
                    }
                }
                return jSONArray.toString();
            }
            Log.e(this.TAG, "ERROR :: empty categoryMap");
            return "";
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void OnShowAvatarFaceCameraView(boolean z) {
        String str = this.TAG;
        Log.i(str, "OnShowAvatarFaceCameraView()+, goToGallery: " + z);
        Intent intent = new Intent(this, AvatarFaceCameraActivity.class);
        intent.putExtra("face_picture_from_gallery", z);
        startActivityForResult(intent, 32);
    }

    public void ShowNetworkErrorDialog(b.a aVar) {
        String string = getResources().getString(2131361834);
        String string2 = getResources().getString(2131361830);
        String string3 = getResources().getString(2131361833);
        String string4 = getResources().getString(2131361829);
        net.fxgear.fitnshop.c.b bVar = new net.fxgear.fitnshop.c.b(this, 2);
        bVar.setCanceledOnTouchOutside(false);
        bVar.a(string);
        bVar.b(string2);
        bVar.c(string3);
        bVar.d(string4);
        bVar.a(aVar);
        bVar.show();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        String str = this.TAG;
        Log.d(str, "onActivityResult()+, requestCode: " + i + ", resultCode: " + i2);
        boolean z = false;
        switch (i) {
            case 30:
            case 31:
            case 33:
                if (i2 == -1) {
                    UpdateResultOfList(intent.getIntExtra("set_fitting_mode", 0), intent.getStringExtra("json_selected_items_info"));
                    return;
                } else if (intent.getBooleanExtra("from_home", false)) {
                    finish();
                    return;
                } else {
                    return;
                }
            case 32:
                if (i2 == -1) {
                    ProcessToChangeCustomFace(intent.getBooleanExtra("face_picture_from_gallery", false), intent.getStringExtra("face_image_file_path"), intent.getIntExtra("face_image_file_orientation", 0));
                    return;
                }
                boolean booleanExtra = intent != null ? intent.getBooleanExtra("face_picture_from_gallery", false) : false;
                if (i2 == 4) {
                    long j = 0;
                    if (intent != null) {
                        j = intent.getLongExtra("detecting_face_need_space_size", 0);
                    }
                    ShowNoSpaceErrorDialog(j, new b.a() {
                        public void b(net.fxgear.fitnshop.c.b bVar) {
                        }

                        public void a(net.fxgear.fitnshop.c.b bVar) {
                            bVar.dismiss();
                        }
                    });
                } else if (i2 != 0) {
                    z = true;
                }
                CancelToChangeCustomFace(z, booleanExtra);
                return;
            default:
                super.onActivityResult(i, i2, intent);
                return;
        }
    }

    private void ShowNoSpaceErrorDialog(long j, b.a aVar) {
        Resources resources = getResources();
        String string = resources.getString(2131361835);
        String a2 = f.a(j);
        String format = String.format(resources.getString(2131361831), new Object[]{a2});
        net.fxgear.fitnshop.c.b bVar = new net.fxgear.fitnshop.c.b(this, 1);
        bVar.setCanceledOnTouchOutside(false);
        bVar.a(string);
        bVar.b(format);
        bVar.c(resources.getString(2131361832));
        bVar.a(aVar);
        bVar.show();
    }

    private void ShowErrorDialogToTakePicture(boolean z, b.a aVar) {
        String str;
        String str2;
        net.fxgear.fitnshop.c.b bVar = new net.fxgear.fitnshop.c.b(this, 2);
        Resources resources = getResources();
        if (z) {
            str = resources.getString(a.g.face_config_recog_failed_reselect);
            str2 = resources.getString(a.g.face_config_select_again);
        } else {
            str = resources.getString(a.g.face_config_recog_failed_retake_photo);
            str2 = resources.getString(a.g.face_config_take_photo_again);
        }
        String string = resources.getString(2131361829);
        bVar.a(false);
        bVar.b(str);
        bVar.c(str2);
        bVar.d(string);
        bVar.a(aVar);
        bVar.show();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\FNSMainMenu.java ==========

package net.fxgear.fitnshop;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import net.fxgear.a.a;
import net.fxgear.fittingmodenative.f;

public class FNSMainMenu extends RelativeLayout implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public b f771a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public TextView f772b;
    private TextView c;
    /* access modifiers changed from: private */
    public ListView d;
    private a e;
    private TextView f;
    private final int g = -3;
    /* access modifiers changed from: private */
    public final int h;
    /* access modifiers changed from: private */
    public final int i;
    /* access modifiers changed from: private */
    public int j = -3;
    private View k;
    private TextView l;

    public interface b {
        boolean a();

        boolean a(int i);

        boolean b();

        boolean c();

        void d();

        void e();
    }

    public FNSMainMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Log.i("FNSMainMenu", "FNSMainMenu()+");
        this.h = getResources().getColor(2130968692);
        this.i = getResources().getColor(2130968691);
        this.k = inflate(context, 2131296307, this);
        c();
    }

    private void c() {
        Log.d("FNSMainMenu", "initializeView()+");
        this.f772b = (TextView) findViewById(2131165426);
        this.f772b.setOnClickListener(this);
        this.f772b.setTextColor(this.h);
        if (h.f1164b.c()) {
            this.f772b.setVisibility(4);
        }
        TextView textView = (TextView) findViewById(2131165424);
        SpannableString spannableString = new SpannableString(textView.getText());
        spannableString.setSpan(new UnderlineSpan(), 0, textView.getText().length(), 0);
        textView.setText(spannableString);
        if (h.f1164b.j()) {
            textView.setOnClickListener(this);
        }
        this.c = (TextView) findViewById(2131165425);
        this.c.setOnClickListener(this);
        this.e = new a(getContext());
        this.d = (ListView) findViewById(2131165364);
        this.d.setAdapter(this.e);
        this.d.setSelector(17170445);
        this.d.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (FNSMainMenu.this.d != null && FNSMainMenu.this.d.getChildCount() > 0 && i + i2 == i3 && FNSMainMenu.this.d.getChildAt(i2 - 1).getBottom() == FNSMainMenu.this.d.getHeight() && FNSMainMenu.this.f771a != null) {
                    FNSMainMenu.this.f771a.d();
                }
            }
        });
        this.l = (TextView) findViewById(2131165427);
        a(false);
        d();
        ((Button) findViewById(2131165236)).setOnClickListener(this);
    }

    public void a(b bVar) {
        this.f771a = bVar;
    }

    private void d() {
        String str;
        if (this.f772b.getParent() != null) {
            this.f = new TextView(getContext());
            this.f.setTextColor(-1);
            this.f.setAlpha(0.1f);
            this.f.setTextSize(0, (float) getContext().getResources().getDimensionPixelSize(2131034449));
            switch (h.f1164b.m) {
                case 0:
                    str = "";
                    break;
                case 1:
                    str = "_S";
                    break;
                default:
                    str = "_D";
                    break;
            }
            f.f1467a.getClass();
            this.f.setText(String.format(getResources().getString(2131361947), new Object[]{a(getContext()), h.a(str)}));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(2131034462);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(2131034462);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(2131034461);
            ((ViewGroup) this.f772b.getParent()).addView(this.f, layoutParams);
        }
    }

    public void a(ArrayList<String> arrayList) {
        Log.d("FNSMainMenu", "AddMenuResourceList()+");
        if (arrayList != null) {
            a(true);
            this.e.a(arrayList);
            this.e.notifyDataSetChanged();
        }
    }

    private void a(boolean z) {
        if (z) {
            if (this.l.getVisibility() != 8) {
                this.d.setVisibility(0);
                this.l.setVisibility(8);
            }
        } else if (this.l.getVisibility() != 0) {
            this.d.setVisibility(8);
            this.l.setVisibility(0);
        }
    }

    private String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("FNSMainMenu", "NameNotFoundException");
            return null;
        }
    }

    public void a() {
        this.f772b.setTextColor(this.h);
        int childCount = this.d.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.d.getChildAt(i2);
            if (!(childAt == null || childAt.getTag() == null)) {
                ((a.C0026a) childAt.getTag()).f778a.setTextColor(this.i);
            }
        }
        this.j = -3;
    }

    public void a(String str) {
        a.C0026a aVar;
        if (str != null) {
            this.f772b.setTextColor(this.i);
            int count = this.e.getCount();
            int i2 = 0;
            while (true) {
                if (i2 >= count) {
                    break;
                } else if (str.equals((String) this.e.getItem(i2))) {
                    this.j = i2;
                    break;
                } else {
                    i2++;
                }
            }
            int childCount = this.d.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.d.getChildAt(i3);
                int i4 = this.i;
                if (!(childAt == null || (aVar = (a.C0026a) childAt.getTag()) == null)) {
                    if (aVar.f778a.getText().equals(str)) {
                        i4 = this.h;
                    }
                    aVar.f778a.setTextColor(i4);
                }
            }
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id != 2131165236) {
            switch (id) {
                case 2131165424:
                    if (this.f771a != null) {
                        this.f771a.e();
                        return;
                    }
                    return;
                case 2131165425:
                    Log.d("FNSMainMenu", "Click main menu footer.");
                    if (this.f771a != null) {
                        this.f771a.b();
                        return;
                    }
                    return;
                case 2131165426:
                    Log.d("FNSMainMenu", "Click main menu header.");
                    if (this.f771a != null && this.f771a.a()) {
                        a();
                        return;
                    }
                    return;
                default:
                    Log.e("FNSMainMenu", "Click unknown view id.");
                    return;
            }
        } else if (this.f771a != null) {
            this.f771a.c();
        }
    }

    public void b() {
        this.f771a = null;
        if (this.f772b != null) {
            this.f772b.setOnClickListener((View.OnClickListener) null);
            this.f772b = null;
        }
        if (this.c != null) {
            this.c.setOnClickListener((View.OnClickListener) null);
            this.c = null;
        }
        if (this.d != null) {
            this.d.setOnItemClickListener((AdapterView.OnItemClickListener) null);
            this.d.setAdapter((ListAdapter) null);
            this.d.setOnScrollListener((AbsListView.OnScrollListener) null);
            int childCount = this.d.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.d.getChildAt(i2);
                if (!(childAt == null || childAt.getTag() == null)) {
                    ((a.C0026a) childAt.getTag()).f778a = null;
                }
            }
            this.d = null;
        }
        if (this.e != null) {
            this.e.a();
            this.e = null;
        }
        this.l = null;
        this.k = null;
    }

    private class a extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        private final String f775b = "MenuListAdpter";
        private LayoutInflater c;
        private ArrayList<String> d;

        public long getItemId(int i) {
            return (long) i;
        }

        public a(Context context) {
            Log.i("MenuListAdpter", "SetResourceList()+");
            this.d = new ArrayList<>();
            this.c = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void a() {
            this.c = null;
            this.d.clear();
        }

        public void a(ArrayList<String> arrayList) {
            this.d.addAll(arrayList);
        }

        public int getCount() {
            return this.d.size();
        }

        public Object getItem(int i) {
            return this.d.get(i);
        }

        public View getView(final int i, View view, ViewGroup viewGroup) {
            C0026a aVar;
            if (view == null) {
                view = this.c.inflate(2131296315, viewGroup, false);
                aVar = new C0026a();
                aVar.f778a = (TextView) view.findViewById(a.e.tv_item_title);
                view.setTag(aVar);
            } else {
                aVar = (C0026a) view.getTag();
            }
            if (FNSMainMenu.this.j == i) {
                aVar.f778a.setTextColor(FNSMainMenu.this.h);
            } else {
                aVar.f778a.setTextColor(FNSMainMenu.this.i);
            }
            aVar.f778a.setText(this.d.get(i));
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    C0026a aVar;
                    if (FNSMainMenu.this.f771a != null && FNSMainMenu.this.f771a.a(i)) {
                        FNSMainMenu.this.f772b.setTextColor(FNSMainMenu.this.i);
                        int childCount = FNSMainMenu.this.d.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = FNSMainMenu.this.d.getChildAt(i);
                            int e = FNSMainMenu.this.i;
                            if (!(childAt == null || view == null)) {
                                if (childAt.equals(view)) {
                                    aVar = (C0026a) view.getTag();
                                    e = FNSMainMenu.this.h;
                                } else {
                                    aVar = (C0026a) childAt.getTag();
                                }
                                if (aVar != null) {
                                    aVar.f778a.setTextColor(e);
                                }
                            }
                        }
                    }
                }
            });
            return view;
        }

        /* renamed from: net.fxgear.fitnshop.FNSMainMenu$a$a  reason: collision with other inner class name */
        public class C0026a {

            /* renamed from: a  reason: collision with root package name */
            public TextView f778a;

            public C0026a() {
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\FXListActivity.java ==========

package net.fxgear.fitnshop;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.b.a;
import android.util.Log;
import android.widget.RelativeLayout;
import net.fxgear.GlobalDefine;
import net.fxgear.a.a;
import net.fxgear.fitnshop.a.c;
import net.fxgear.fitnshop.a.d;
import net.fxgear.fitnshop.c.b;
import net.fxgear.fitnshop.d.a;
import net.fxgear.fitnshop.d.i;
import net.fxgear.fittingmodenative.b.c;
import net.fxgear.fittingmodenative.d.d;
import net.fxgear.fittingmodenative.d.g;
import org.json.JSONException;
import org.json.JSONObject;

public class FXListActivity extends Activity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f780a = FXListActivity.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final int f781b = 101;
    private final int c = 2131165357;
    private RelativeLayout d;
    /* access modifiers changed from: private */
    public c e;
    /* access modifiers changed from: private */
    public d f;
    /* access modifiers changed from: private */
    public g g;
    private b h;
    private net.fxgear.fitnshop.a.d i;
    /* access modifiers changed from: private */
    public int j = -1;
    private d.b k = new d.b() {
        public void a(int i) {
            if (FXListActivity.this.e != null) {
                FXListActivity.this.e.a(0);
            }
        }

        public void a(int i, int i2, int i3) {
            if (FXListActivity.this.e != null) {
                FXListActivity.this.e.a(i3);
            }
        }

        public void a(GlobalDefine.Result result) {
            if (FXListActivity.this.e != null) {
                FXListActivity.this.e.dismiss();
                c unused = FXListActivity.this.e = null;
            }
            int i = ((d.c) result.request).f1417a;
            if (result.resultCode == -1) {
                FragmentManager fragmentManager = FXListActivity.this.getFragmentManager();
                Fragment c = FXListActivity.this.b();
                if (c != null && (c instanceof i)) {
                    ((i) fragmentManager.findFragmentByTag(i.d)).c(i);
                }
            } else if (result.resultCode != -2) {
                FXListActivity.this.a(result);
            }
            d unused2 = FXListActivity.this.f = null;
        }
    };
    private i.c l = new i.c() {
        public void a(int i, String str) {
            Log.i(FXListActivity.this.f780a, "OnExitRecyclerViewFragment()");
            switch (i) {
                case 30:
                case 31:
                    FXListActivity.this.a(-1, 0, str, false);
                    return;
                case 33:
                    FXListActivity.this.a(-1, 1, str, false);
                    return;
                default:
                    String d = FXListActivity.this.f780a;
                    Log.e(d, "[ERROR] :: wrong listType: " + i);
                    return;
            }
        }

        public void a(int i, int i2, int i3) {
            Log.i(FXListActivity.this.f780a, "OnAddItem()");
            switch (i) {
                case 30:
                case 31:
                    if (h.d(FXListActivity.this.getApplicationContext())) {
                        boolean z = true;
                        if (Build.VERSION.SDK_INT >= 23 && a.a(FXListActivity.this.getApplicationContext(), "android.permission.CAMERA") == -1) {
                            z = false;
                        }
                        if (z) {
                            net.fxgear.fitnshop.d.a aVar = new net.fxgear.fitnshop.d.a();
                            aVar.a(FXListActivity.this.m);
                            FXListActivity.this.a((net.fxgear.fitnshop.d.b) aVar, 0);
                            return;
                        }
                        b bVar = new b(FXListActivity.this, 2);
                        bVar.a((String) null);
                        bVar.b(FXListActivity.this.getResources().getString(a.g.camera_access_required));
                        bVar.d(FXListActivity.this.getResources().getString(2131361832));
                        bVar.c(FXListActivity.this.getResources().getString(2131361829));
                        bVar.a((b.a) new b.a() {
                            public void a(b bVar) {
                                bVar.dismiss();
                            }

                            public void b(b bVar) {
                                android.support.v4.a.a.a(FXListActivity.this, new String[]{"android.permission.CAMERA"}, 0);
                                bVar.dismiss();
                            }
                        });
                        bVar.show();
                        return;
                    }
                    FXListActivity.this.a(10, (Object) null);
                    return;
                case 33:
                    Fragment c = FXListActivity.this.b();
                    if (c != null && (c instanceof i)) {
                        FXListActivity.this.a(-1, 7, ((i) c).e(), false);
                        return;
                    }
                    return;
                default:
                    String d = FXListActivity.this.f780a;
                    Log.e(d, "[ERROR] :: wrong listType: " + i);
                    return;
            }
        }

        public void a(final int i, final int i2) {
            String str;
            Resources resources = FXListActivity.this.getResources();
            switch (i) {
                case 30:
                case 31:
                    str = resources.getString(2131361912);
                    break;
                case 33:
                    str = resources.getString(2131361816);
                    break;
                default:
                    String d = FXListActivity.this.f780a;
                    Log.e(d, "[ERROR] :: wrong request type: " + i);
                    return;
            }
            b bVar = new b(FXListActivity.this, 2);
            bVar.a((String) null);
            bVar.b(str);
            bVar.c(resources.getString(2131361832));
            bVar.d(resources.getString(2131361829));
            bVar.a((b.a) new b.a() {
                public void a(b bVar) {
                    bVar.dismiss();
                    Fragment c2 = FXListActivity.this.b();
                    if (c2 != null && (c2 instanceof i)) {
                        ((i) c2).a(i, i2);
                    }
                }

                public void b(b bVar) {
                    bVar.dismiss();
                }
            });
            bVar.show();
        }

        public void a(int i) {
            FXListActivity.this.b(i);
        }
    };
    /* access modifiers changed from: private */
    public a.C0033a m = new a.C0033a() {
        public void a(String str, final boolean z) {
            String d = FXListActivity.this.f780a;
            Log.d(d, "OnResultOfDecodingQRCode, result: " + str);
            FXListActivity.this.a();
            if (!h.d(FXListActivity.this)) {
                if (z) {
                    Resources resources = FXListActivity.this.getResources();
                    FXListActivity.this.a(resources.getString(2131361834), resources.getString(2131361830), 2, resources.getString(2131361829), resources.getString(2131361833), new b.a() {
                        public void a(b bVar) {
                            if (bVar != null) {
                                bVar.dismiss();
                                FXListActivity.this.a(0, 0, (String) null, z);
                            }
                        }

                        public void b(b bVar) {
                            if (bVar != null) {
                                bVar.dismiss();
                                net.fxgear.fitnshop.d.a aVar = new net.fxgear.fitnshop.d.a();
                                aVar.a(FXListActivity.this.m);
                                aVar.a(true);
                                FXListActivity.this.a((net.fxgear.fitnshop.d.b) aVar, 0);
                            }
                        }
                    });
                    return;
                }
                FXListActivity.this.a(10, (Object) null);
            } else if (str != null) {
                FXListActivity.this.a(FXListActivity.this.getApplicationContext(), str, (g.b) new g.b() {
                    public void a(String str) {
                        Log.d(FXListActivity.this.f780a, "OnStartQRRealTask()");
                        if (FXListActivity.this.e != null) {
                            FXListActivity.this.e.dismiss();
                            c unused = FXListActivity.this.e = null;
                        }
                        c unused2 = FXListActivity.this.e = new c(FXListActivity.this);
                        FXListActivity.this.e.a(FXListActivity.this.getResources().getString(2131361846));
                        FXListActivity.this.e.a(0);
                        FXListActivity.this.e.a((c.a) new c.a() {
                            public void a() {
                                Log.d(FXListActivity.this.f780a, "OnCancel() - QRRealDataTask");
                                if (FXListActivity.this.g != null) {
                                    FXListActivity.this.g.a();
                                    g unused = FXListActivity.this.g = null;
                                }
                                if (FXListActivity.this.e != null) {
                                    FXListActivity.this.e.dismiss();
                                    c unused2 = FXListActivity.this.e = null;
                                }
                            }
                        });
                        FXListActivity.this.e.show();
                    }

                    public void a(String str, int i, int i2) {
                        if (FXListActivity.this.e != null) {
                            FXListActivity.this.e.a(i2);
                        }
                    }

                    public void a(g.d dVar) {
                        Log.d(FXListActivity.this.f780a, "OnFinishQRRealTask()");
                        if (FXListActivity.this.e != null) {
                            FXListActivity.this.e.dismiss();
                            c unused = FXListActivity.this.e = null;
                        }
                        FXListActivity.this.a(dVar);
                    }
                });
            } else {
                FXListActivity.this.a(3, (Object) null);
            }
        }

        public void a(boolean z) {
            Log.d(FXListActivity.this.f780a, "OnExitAddMirrorVideoView()");
            FXListActivity.this.a();
            if (FXListActivity.this.j == 31) {
                FXListActivity.this.a(0, -1, (String) null, z);
            }
        }

        public void a() {
            Log.d(FXListActivity.this.f780a, "OnGoToGallery()");
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            FXListActivity.this.startActivityForResult(intent, 101);
        }
    };

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.e(this.f780a, "onCreate()");
        setContentView(2131296257);
        Intent intent = getIntent();
        if (intent != null) {
            this.j = intent.getIntExtra("request_code", -1);
            a(this.j);
        }
    }

    public void a(int i2) {
        boolean z;
        this.d = (RelativeLayout) findViewById(2131165357);
        d.b bVar = new d.b();
        bVar.c = 30;
        bVar.d = (long) Math.round(((float) Runtime.getRuntime().maxMemory()) * 0.15f);
        bVar.f899b = new c.a();
        bVar.f899b.f886a = "FNS_NATIVE_DISK_CACHE";
        bVar.f899b.f887b = 10485760;
        this.i = new net.fxgear.fitnshop.a.d(this, "FNS_NATIVE", bVar);
        switch (i2) {
            case 30:
            case 31:
            case 33:
                String str = null;
                Intent intent = getIntent();
                if (intent != null) {
                    str = intent.getStringExtra("json_selected_items_info");
                }
                a((net.fxgear.fitnshop.d.b) new i(i2, this.l, str, this.i), 1);
                if (i2 == 31) {
                    try {
                        z = new JSONObject(str).getBoolean("from_home");
                    } catch (JSONException e2) {
                        Log.e(this.f780a, "[ERROR] :: RecyclerViewFragment(), invalid JSON");
                        e2.printStackTrace();
                        z = false;
                    }
                    net.fxgear.fitnshop.d.a aVar = new net.fxgear.fitnshop.d.a();
                    aVar.a(this.m);
                    aVar.a(z);
                    a((net.fxgear.fitnshop.d.b) aVar, 0);
                    return;
                }
                return;
            default:
                String str2 = this.f780a;
                Log.e(str2, "[ERROR] :: wrong requestCode: " + i2);
                finish();
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Log.e(this.f780a, "onResume()+");
        h.b((Activity) this);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        Log.e(this.f780a, "onPause()+");
    }

    public void onBackPressed() {
        Log.i(this.f780a, "OnBackPressed()");
        Fragment b2 = b();
        if (b2 == null || !(b2 instanceof net.fxgear.fitnshop.d.b) || !((net.fxgear.fitnshop.d.b) b2).b()) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Log.e(this.f780a, "onDestroy()");
        if (this.i != null) {
            this.i.b();
            this.i = null;
        }
    }

    /* access modifiers changed from: private */
    public void a(net.fxgear.fitnshop.d.b bVar, int i2) {
        String str = this.f780a;
        Log.d(str, "AddFragment()+, fragmentFlag: " + i2);
        if (bVar != null) {
            String a2 = bVar.a();
            if (i2 != 0) {
                a();
                FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
                beginTransaction.setTransition(0);
                beginTransaction.add(2131165357, bVar, a2);
                beginTransaction.commit();
                return;
            }
            FragmentTransaction beginTransaction2 = getFragmentManager().beginTransaction();
            beginTransaction2.setTransition(0);
            beginTransaction2.add(2131165357, bVar, a2);
            beginTransaction2.addToBackStack(a2);
            beginTransaction2.commit();
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        Log.d(this.f780a, "ClearFragmentStack");
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        if (backStackEntryCount > 0) {
            String str = this.f780a;
            Log.e(str, "Remaing stack size(before) : " + backStackEntryCount);
            for (int i2 = 0; i2 < backStackEntryCount; i2++) {
                Fragment findFragmentByTag = fragmentManager.findFragmentByTag(fragmentManager.getBackStackEntryAt(0).getName());
                String str2 = this.f780a;
                Log.e(str2, "Remove remaing stackFragment : " + findFragmentByTag.getTag());
                fragmentManager.popBackStackImmediate();
                beginTransaction.remove(findFragmentByTag);
            }
            String str3 = this.f780a;
            Log.e(str3, "Remaing stack size(after) : " + fragmentManager.getBackStackEntryCount());
        }
        beginTransaction.commit();
    }

    /* access modifiers changed from: private */
    public Fragment b() {
        return getFragmentManager().findFragmentById(2131165357);
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3, String str, boolean z) {
        Intent intent = new Intent();
        if (i2 == -1) {
            intent.putExtra("set_fitting_mode", i3);
            intent.putExtra("json_selected_items_info", str);
        } else if (z && this.j == 31) {
            intent.putExtra("from_home", z);
        }
        setResult(i2, intent);
        finish();
    }

    /* access modifiers changed from: private */
    public void b(final int i2) {
        if (h.d(this)) {
            if (this.f != null) {
                this.f.a();
                this.f = null;
            }
            this.e = new net.fxgear.fittingmodenative.b.c(this);
            this.e.a(getResources().getString(2131361846));
            this.e.a(0);
            this.e.a((c.a) new c.a() {
                public void a() {
                    if (FXListActivity.this.f != null) {
                        FXListActivity.this.f.a();
                        net.fxgear.fittingmodenative.d.d unused = FXListActivity.this.f = null;
                    }
                    FXListActivity.this.e.dismiss();
                    net.fxgear.fittingmodenative.b.c unused2 = FXListActivity.this.e = null;
                }
            });
            this.f = a(i2, this.k);
            this.e.show();
            return;
        }
        Resources resources = getResources();
        a(resources.getString(2131361834), resources.getString(2131361830), 2, resources.getString(2131361833), resources.getString(2131361829), new b.a() {
            public void a(b bVar) {
                if (bVar != null) {
                    bVar.dismiss();
                }
                FXListActivity.this.b(i2);
            }

            public void b(b bVar) {
                if (bVar != null) {
                    bVar.dismiss();
                }
            }
        });
    }

    public void a(String str, String str2, int i2, String str3, String str4, b.a aVar) {
        if (this.h != null) {
            if (this.h.isShowing()) {
                this.h.dismiss();
            }
            this.h = null;
        }
        this.h = new b(this, i2);
        this.h.setCanceledOnTouchOutside(false);
        this.h.a(str);
        this.h.b(str2);
        this.h.c(str3);
        if (i2 == 2) {
            this.h.d(str4);
        }
        this.h.a(aVar);
        this.h.show();
    }

    /* access modifiers changed from: private */
    public void a(int i2, Object obj) {
        String str;
        String str2;
        String string;
        String string2;
        String str3 = this.f780a;
        Log.i(str3, "ShowQRCodeDownloadErrorDialog()+, resultCode: " + i2);
        Resources resources = getResources();
        switch (i2) {
            case 2:
            case 3:
                string = resources.getString(2131361933);
                string2 = resources.getString(2131361932);
                break;
            case 4:
                String str4 = null;
                if (obj != null) {
                    str4 = h.a(((Long) obj).longValue());
                }
                String string3 = resources.getString(2131361954);
                str = String.format(resources.getString(2131361953), new Object[]{str4});
                str2 = string3;
                break;
            case 5:
                string = resources.getString(2131361839);
                string2 = resources.getString(2131361793);
                break;
            default:
                switch (i2) {
                    case 10:
                    case 11:
                    case GlobalDefine.RESULT_CODE_ERROR_MALFORMEDURL:
                    case 14:
                        string = resources.getString(2131361834);
                        string2 = resources.getString(2131361830);
                        break;
                    case 12:
                        string = resources.getString(2131361837);
                        string2 = resources.getString(2131361838);
                        break;
                    default:
                        string = resources.getString(2131361839);
                        string2 = resources.getString(2131361840);
                        break;
                }
        }
        str2 = string;
        str = string2;
        a(str2, str, 1, resources.getString(a.g.confirm), (String) null, new b.a() {
            public void b(b bVar) {
            }

            public void a(b bVar) {
                if (bVar != null) {
                    bVar.dismiss();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(GlobalDefine.Result result) {
        AnonymousClass5 r11;
        String str;
        String str2;
        int i2;
        String str3;
        String str4;
        String string;
        String format;
        String string2;
        b.a r2;
        Resources resources = getResources();
        Fragment b2 = b();
        final int i3 = ((d.c) result.request).f1417a;
        if (b2 instanceof i) {
            int i4 = result.resultCode;
            if (i4 != 4) {
                if (i4 != 10) {
                    switch (i4) {
                        case GlobalDefine.RESULT_CODE_ERROR_MALFORMEDURL:
                        case 14:
                            break;
                        default:
                            string = "Unknown";
                            format = "Error code : " + result.resultCode;
                            string2 = resources.getString(a.g.confirm);
                            r2 = new b.a() {
                                public void a(b bVar) {
                                    if (bVar != null) {
                                        bVar.dismiss();
                                    }
                                }

                                public void b(b bVar) {
                                    if (bVar != null) {
                                        bVar.dismiss();
                                    }
                                }
                            };
                            break;
                    }
                }
                String string3 = resources.getString(2131361834);
                String string4 = resources.getString(2131361830);
                String string5 = resources.getString(2131361833);
                str3 = string4;
                str = resources.getString(2131361829);
                str2 = string5;
                str4 = string3;
                r11 = new b.a() {
                    public void a(b bVar) {
                        if (bVar != null) {
                            bVar.dismiss();
                        }
                        FXListActivity.this.b(i3);
                    }

                    public void b(b bVar) {
                        if (bVar != null) {
                            bVar.dismiss();
                        }
                    }
                };
                i2 = 2;
                if (str4 != null && str3 != null && r11 != null) {
                    a(str4, str3, i2, str2, str, r11);
                    return;
                }
                return;
            }
            long j2 = 0;
            if (result.resultExtra != null && (result.resultExtra instanceof Long)) {
                j2 = ((Long) result.resultExtra).longValue();
            }
            String a2 = h.a(j2);
            string = resources.getString(2131361954);
            format = String.format(resources.getString(2131361953), new Object[]{a2});
            string2 = resources.getString(a.g.confirm);
            r2 = new b.a() {
                public void a(b bVar) {
                    if (bVar != null) {
                        bVar.dismiss();
                    }
                }

                public void b(b bVar) {
                    if (bVar != null) {
                        bVar.dismiss();
                    }
                }
            };
            str3 = format;
            str2 = string2;
            str4 = string;
            r11 = r2;
            str = null;
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            r11 = null;
        }
        i2 = 1;
        if (str4 != null) {
        }
    }

    private net.fxgear.fittingmodenative.d.d a(int i2, d.b bVar) {
        net.fxgear.fittingmodenative.d.d dVar = new net.fxgear.fittingmodenative.d.d(this, i2, bVar);
        dVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return dVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.String} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r5, int r6, android.content.Intent r7) {
        /*
            r4 = this;
            r0 = 101(0x65, float:1.42E-43)
            r1 = -1
            if (r6 == r1) goto L_0x001d
            java.lang.String r6 = r4.f780a
            java.lang.String r7 = "onActivityResult(), resultCode != RESULT_OK"
            android.util.Log.e(r6, r7)
            if (r5 != r0) goto L_0x000f
            return
        L_0x000f:
            android.app.Fragment r5 = r4.b()
            if (r5 == 0) goto L_0x001c
            boolean r5 = r5 instanceof net.fxgear.fitnshop.d.a
            if (r5 == 0) goto L_0x001c
            r4.a()
        L_0x001c:
            return
        L_0x001d:
            if (r5 == r0) goto L_0x0020
            goto L_0x006f
        L_0x0020:
            java.lang.String r0 = r4.f780a
            java.lang.String r1 = "onActivityResult(), REQUEST_CODE_GALLERY_IMAGE"
            android.util.Log.d(r0, r1)
            android.app.Fragment r0 = r4.b()
            if (r0 == 0) goto L_0x006f
            boolean r1 = r0 instanceof net.fxgear.fitnshop.d.a
            if (r1 == 0) goto L_0x006f
            net.fxgear.fitnshop.d.a r0 = (net.fxgear.fitnshop.d.a) r0
            r1 = 0
            if (r7 == 0) goto L_0x0043
            android.net.Uri r2 = r7.getData()
            java.lang.String r2 = r0.a((android.net.Uri) r2)
            android.os.Message r0 = r0.a((java.lang.String) r2)
            goto L_0x0044
        L_0x0043:
            r0 = r1
        L_0x0044:
            r4.a()
            if (r0 == 0) goto L_0x0064
            int r2 = r0.what
            r3 = 1
            if (r2 != r3) goto L_0x0064
            java.lang.Object r2 = r0.obj
            if (r2 == 0) goto L_0x0057
            java.lang.Object r0 = r0.obj
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
        L_0x0057:
            android.content.Context r0 = r4.getApplicationContext()
            net.fxgear.fitnshop.FXListActivity$2 r2 = new net.fxgear.fitnshop.FXListActivity$2
            r2.<init>()
            r4.a((android.content.Context) r0, (java.lang.String) r1, (net.fxgear.fittingmodenative.d.g.b) r2)
            goto L_0x006f
        L_0x0064:
            java.lang.String r0 = r4.f780a
            java.lang.String r2 = "[ERROR] :: failed to decode QR code"
            android.util.Log.e(r0, r2)
            r0 = 3
            r4.a((int) r0, (java.lang.Object) r1)
        L_0x006f:
            super.onActivityResult(r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.FXListActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    /* access modifiers changed from: private */
    public void a(Context context, String str, g.b bVar) {
        if (h.d(context)) {
            if (this.g != null) {
                this.g.a();
                this.g = null;
            }
            this.g = g.a(context, str, bVar);
            return;
        }
        a(10, (Object) null);
    }

    /* access modifiers changed from: private */
    public void a(g.d dVar) {
        Log.i(this.f780a, "HandleQRRealDataResult()+");
        String str = null;
        if (dVar == null) {
            a(3, (Object) null);
        } else if (dVar.resultCode == -1) {
            int i2 = dVar.f1446a.f1465a;
            int i3 = dVar.f1446a.f1466b;
            int i4 = dVar.f1446a.c;
            String str2 = this.f780a;
            Log.d(str2, "resultCode == GlobalDefine.RESULT_CODE_SUCCESS, result videoID: " + i2 + ", gender: " + i3);
            Fragment b2 = b();
            if (b2 instanceof i) {
                str = ((i) b2).a(i3, i4, i2, getApplicationContext());
            }
            a(-1, 0, str, false);
        } else if (dVar.resultCode != -2) {
            a(dVar.resultCode, dVar.resultExtra);
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (iArr.length > 0 && iArr[0] == 0) {
            net.fxgear.fitnshop.d.a aVar = new net.fxgear.fitnshop.d.a();
            aVar.a(this.m);
            a((net.fxgear.fitnshop.d.b) aVar, 0);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\g.java ==========

package net.fxgear.fitnshop;

import android.content.Context;
import android.util.Log;
import net.fxgear.fitnshop.h;
import net.fxgear.fittingmodenative.f;

/* compiled from: FXFeatures */
public class g extends h.a {
    private final String A = g.class.getSimpleName();
    private final String B;
    private final String C;
    private final String D;
    private final String E;
    private final String F;
    private final String G;
    private final String H;
    private final String I;
    private final String J;
    private final String K;
    private final String L;
    private final String M;
    private final String N;
    private final String O;
    private final String P;
    private final String Q;
    private final String R;
    private final String S;
    private final String T;
    private final String U;
    private final String V;
    private final String W;
    private final String X;
    private final String Y;
    private final String Z;
    private final String aa;
    private final String ab;
    private final String ac;
    private final String ad;
    private final String ae;
    private boolean af = false;

    public g(Context context) {
        if (this.af) {
            this.V = "http://dev-mall-api.fitnshop.com";
            this.W = "http://dev-log.fitnshop.com:4080/";
            this.X = "http://dev-api.fitnshop.com";
            this.Y = "http://dev-api.fxmirror.net";
            this.Z = "http://dev-old-api.fxmirror.net";
            this.aa = "http://dev-data.fxmirror.net";
            this.ab = null;
            this.ac = "http://dev-mall-app.fitnshop.com";
            this.ad = "http://dev-data.fitnshop.com/";
            this.ae = "http://dev-mall.fitnshop.com/wap";
            this.L = "http://stg-mall-api.fitnshop.com";
            this.M = "http://stg-log.fitnshop.com:4080/";
            this.N = "http://stg-api.fitnshop.com";
            this.O = "http://stg-api.fxmirror.net";
            this.P = "http://stg-old-api.fxmirror.net:8088";
            this.Q = "http://stg-data.fxmirror.net";
            this.R = null;
            this.S = "http://stg-mall-app.fitnshop.com";
            this.T = "http://stg-data.fitnshop.com/";
            this.U = "http://stg-mall.fitnshop.com/wap";
            this.B = "http://prd-mall-api.fitnshop.com";
            this.C = "http://log.fitnshop.com:4080/";
            this.D = "http://api.fitnshop.com";
            this.E = "http://api.fxmirror.net";
            this.F = "http://old-api.fxmirror.net:8088";
            this.G = "http://data.fxmirror.net";
            this.H = null;
            this.I = "http://prd-mall-app.fitnshop.com";
            this.J = "http://bdata.fitnshop.com/";
            this.K = "http://mall.fitnshop.com/wap";
        } else {
            this.V = "http://dev-api.fitnshop.com";
            this.W = "http://dev-log.fitnshop.com:4080/";
            this.X = "http://dev-api.fitnshop.com";
            this.Y = "http://dev-api.fxmirror.net";
            this.Z = "http://dev-old-api.fxmirror.net";
            this.aa = "http://dev-data.fxmirror.net";
            this.ab = "d470ed1a-d50d-40c3-80fa-95857b400ce9";
            this.ac = "http://dev-app.fitnshop.com";
            this.ad = "http://dev-data.fitnshop.com/";
            this.ae = "http://dev-mall.fitnshop.com/wap";
            this.L = "http://stg-api.fitnshop.com";
            this.M = "http://stg-log.fitnshop.com:4080/";
            this.N = "http://stg-api.fitnshop.com";
            this.O = "http://stg-api.fxmirror.net";
            this.P = "http://stg-old-api.fxmirror.net:8088";
            this.Q = "http://stg-data.fxmirror.net";
            this.R = "d2c3b071-985a-4e4d-9775-808629b59203";
            this.S = "http://stg-app.fitnshop.com";
            this.T = "http://stg-data.fitnshop.com/";
            this.U = "http://stg-mall.fitnshop.com/wap";
            this.B = "http://api.fitnshop.com";
            this.C = "http://log.fitnshop.com:4080/";
            this.D = "http://api.fitnshop.com";
            this.E = "http://api.fxmirror.net";
            this.F = "http://old-api.fxmirror.net:8088";
            this.G = "http://data.fxmirror.net";
            this.H = "9d0f4a78-1a0f-42a7-bce6-7c6181983ebb";
            this.I = "http://app.fitnshop.com";
            this.J = "http://bdata.fitnshop.com/";
            this.K = "http://mall.fitnshop.com/wap";
        }
        this.f1166b = true;
        if (this.l) {
            this.d = true;
        }
        switch (0) {
            case 0:
                this.f1165a = false;
                this.f = false;
                if (this.l) {
                    h.c = 15;
                }
                f.a(false);
                break;
            case 1:
                this.f1165a = false;
                this.f = false;
                if (this.l) {
                    h.c = 51;
                }
                f.a(false);
                break;
            default:
                this.f1165a = true;
                this.f = true;
                if (this.l) {
                    h.c = 116;
                }
                f.a(true);
                break;
        }
        a(0);
        a(context);
    }

    public void a(int i) {
        String str;
        Log.d(this.A, "SetNetworkOptions()+");
        if (this.m != i) {
            this.m = i;
            switch (i) {
                case 0:
                    this.n = this.B;
                    this.o = this.C;
                    this.p = this.D;
                    this.q = this.E;
                    this.r = this.F;
                    this.s = this.G;
                    this.t = this.H;
                    this.x = this.H;
                    this.y = this.J;
                    this.w = this.I;
                    this.z = this.K;
                    str = "SERVER_PRODUCTION";
                    break;
                case 1:
                    this.n = this.L;
                    this.o = this.M;
                    this.p = this.N;
                    this.q = this.O;
                    this.r = this.P;
                    this.s = this.Q;
                    this.t = this.R;
                    this.x = this.R;
                    this.y = this.T;
                    this.w = this.S;
                    this.z = this.U;
                    str = "SERVER_STAGING";
                    break;
                default:
                    this.n = this.V;
                    this.o = this.W;
                    this.p = this.X;
                    this.q = this.Y;
                    this.r = this.Z;
                    this.s = this.aa;
                    this.t = this.ab;
                    this.x = this.ab;
                    this.y = this.ad;
                    this.w = this.ac;
                    this.z = this.ae;
                    str = "SERVER_DEVELOPMENT";
                    break;
            }
            if (this.f1165a) {
                String str2 = this.A;
                Log.e(str2, "Target server : " + str);
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\h.java ==========

package net.fxgear.fitnshop;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import java.io.File;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Date;
import net.fxgear.GlobalDefine;
import net.fxgear.util.FXUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FXGlobal */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1163a = false;

    /* renamed from: b  reason: collision with root package name */
    public static g f1164b = null;
    public static int c = -1;
    public static String[] d;

    private static int a(int i) {
        return i | 2 | 1;
    }

    public static void b(String str) {
    }

    public static void a() {
        d = new String[]{GlobalDefine.GENDER_WOMAN_STRING, GlobalDefine.GENDER_MAN_STRING, "girl", "boy"};
    }

    public static String a(JSONObject jSONObject) {
        try {
            return jSONObject.getString("uuid");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b(JSONObject jSONObject) {
        try {
            return jSONObject.getString("bodysize");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void a(Context context) {
        Log.d("FXGlobal", "BuildFeaturs()+");
        if (f1164b == null) {
            f1164b = new g(context);
        }
    }

    public static int b(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @SuppressLint({"NewApi"})
    public static boolean c(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        Log.i("FXGlobal", "[c] CheckScreenRealSize - screen:" + width + "," + height + ", realSize:" + point.x + "," + point.y);
        return height == point.y;
    }

    /* compiled from: FXGlobal */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        protected boolean f1165a = false;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f1166b = false;
        protected boolean c = false;
        protected boolean d = false;
        protected int e = 99;
        protected boolean f = false;
        protected boolean g = false;
        protected boolean h = false;
        protected boolean i = false;
        protected boolean j = false;
        protected boolean k = false;
        protected boolean l = false;
        public int m = -1;
        public String n;
        public String o;
        public String p;
        public String q;
        public String r;
        public String s;
        public String t;
        public String u;
        public String v;
        public String w;
        public String x;
        public String y;
        public String z;

        public void a(Context context) {
            final Object obj = new Object();
            final WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            String f2 = h.f(context);
            if (f2 == null) {
                Log.e("FXGlobal", "try connection wifi");
                if (!wifiManager.isWifiEnabled()) {
                    context.registerReceiver(new BroadcastReceiver() {
                        public void onReceive(Context context, Intent intent) {
                            if (intent.getIntExtra("wifi_state", 4) == 3) {
                                Log.d("FXGlobal", "WIFI_STATE_ENABLED");
                                a.this.b(h.f(context));
                                context.unregisterReceiver(this);
                                wifiManager.setWifiEnabled(false);
                                synchronized (obj) {
                                    Log.d("FXGlobal", "syncLock notify");
                                    obj.notifyAll();
                                }
                            }
                        }
                    }, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
                    wifiManager.setWifiEnabled(true);
                    synchronized (obj) {
                        try {
                            Log.d("FXGlobal", "syncLock start");
                            if (f2 == null) {
                                Log.d("FXGlobal", "syncLock wait");
                                obj.wait(2000);
                            }
                        } catch (InterruptedException e2) {
                            Log.e("FXGlobal", "mSyncLock interrupted.");
                            e2.printStackTrace();
                        }
                        Log.d("FXGlobal", "mSyncLock end");
                    }
                    return;
                }
                return;
            }
            b(f2);
        }

        /* access modifiers changed from: private */
        public void b(String str) {
            String str2 = Build.SERIAL;
            if (str2 != null && str2.equals("unknown")) {
                Log.e("FXGlobal", "deviceSerial is unknown.");
                str2 = null;
            }
            if (str == null && str2 == null) {
                Log.e("Feature", "Generate deviceID fail.");
                return;
            }
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                sb.append(str);
            }
            sb.append("|");
            if (str2 != null) {
                sb.append(str2);
            }
            this.u = sb.toString();
            Log.e("Feature", "Generate deviceID : " + this.u);
        }

        public void a(String str) {
            i.a("FXGlobal", "SetServerID()+, serverID : " + str);
            this.v = str;
        }

        public boolean a() {
            return this.f1165a;
        }

        public boolean b() {
            return this.f1166b;
        }

        public boolean c() {
            return this.d;
        }

        public boolean d() {
            return this.l;
        }

        public boolean e() {
            return this.c;
        }

        public int f() {
            return this.e;
        }

        public boolean g() {
            return this.f;
        }

        public boolean h() {
            return this.h;
        }

        public boolean i() {
            return this.g;
        }

        public boolean j() {
            return this.i;
        }

        public boolean k() {
            return this.j;
        }

        public boolean l() {
            return this.k;
        }
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return b(1548229919411L) + str;
    }

    private static String b(long j) {
        Object obj;
        Object obj2;
        Object obj3;
        Date date = new Date(j);
        int date2 = date.getDate();
        int hours = date.getHours();
        int minutes = date.getMinutes();
        StringBuilder sb = new StringBuilder();
        sb.append(("" + ((char) (((date.getYear() + 1900) - 2000) + 64))) + ((char) (date.getMonth() + 1 + 64)));
        if (date2 < 10) {
            obj = GlobalDefine.REAL_VIDEO_NONE_DATE + date2;
        } else {
            obj = Integer.valueOf(date2);
        }
        sb.append(obj);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        if (hours < 10) {
            obj2 = GlobalDefine.REAL_VIDEO_NONE_DATE + hours;
        } else {
            obj2 = Integer.valueOf(hours);
        }
        sb3.append(obj2);
        String sb4 = sb3.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(sb4);
        if (minutes < 10) {
            obj3 = GlobalDefine.REAL_VIDEO_NONE_DATE + minutes;
        } else {
            obj3 = Integer.valueOf(minutes);
        }
        sb5.append(obj3);
        return sb5.toString();
    }

    public static boolean d(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static float a(Context context, float f) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    @SuppressLint({"NewApi"})
    private static long c(String str) {
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

    public static long a(File file) {
        if (file == null) {
            return 0;
        }
        if (file.exists()) {
            return c(file.getAbsolutePath());
        }
        if (file.getParentFile() != null) {
            return a(file.getParentFile());
        }
        return 0;
    }

    public static String a(long j) {
        String str = "KB";
        long j2 = j / 1024;
        if (j2 >= 1024) {
            str = "MB";
            j2 /= 1024;
        }
        return Long.toString(j2) + str;
    }

    public static boolean e(Context context) {
        return ViewConfiguration.get(context).hasPermanentMenuKey();
    }

    public static String f(Context context) {
        try {
            for (T t : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (t.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = t.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(Activity activity) {
        if (activity == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder("sw");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        sb.append(((int) (((float) displayMetrics.widthPixels) / displayMetrics.density)) + "dp");
        sb.append("-");
        sb.append(a(displayMetrics));
        return sb.toString();
    }

    private static String a(DisplayMetrics displayMetrics) {
        if (displayMetrics == null) {
            return FXUtil.DENSITY_XXHDPI;
        }
        if (displayMetrics.densityDpi <= 240 || displayMetrics.densityDpi > 320) {
            return ((displayMetrics.densityDpi <= 320 || displayMetrics.densityDpi > 480) && displayMetrics.densityDpi > 480 && displayMetrics.densityDpi <= 640) ? FXUtil.DENSITY_XXXHDPI : FXUtil.DENSITY_XXHDPI;
        }
        return FXUtil.DENSITY_XHDPI;
    }

    public static String a(Context context, String str, String str2, String str3) {
        String str4;
        String str5;
        if (str == null) {
            return null;
        }
        if (str3 == null) {
            str4 = GlobalDefine.GENDER_WOMAN_STRING;
            str5 = GlobalDefine.AGE_MIDDLE_STRING;
        } else if (str3.equals(GlobalDefine.GENDER_MAN_STRING)) {
            str4 = GlobalDefine.GENDER_MAN_STRING;
            str5 = GlobalDefine.AGE_MIDDLE_STRING;
        } else if (str3.equals("girl")) {
            str4 = GlobalDefine.GENDER_WOMAN_STRING;
            str5 = GlobalDefine.AGE_EARLY_STRING;
        } else if (str3.equals("boy")) {
            str4 = GlobalDefine.GENDER_MAN_STRING;
            str5 = GlobalDefine.AGE_EARLY_STRING;
        } else {
            str4 = GlobalDefine.GENDER_WOMAN_STRING;
            str5 = GlobalDefine.AGE_MIDDLE_STRING;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("mode", str);
            jSONObject.put("sex", str4);
            jSONObject.put("age", str5);
            if (!str.equals("fitting")) {
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put("");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("category_id", jSONArray2);
                jSONObject2.put("uuid", "");
                jSONObject2.put("sample", "");
                jSONArray.put(jSONObject2);
            } else if (str2 != null) {
                jSONArray = d.a(context).a(str2, true);
            } else {
                Log.e("FXGlobal", "ERROR :: FITTING, param error");
                JSONArray jSONArray3 = new JSONArray();
                jSONArray3.put("");
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("category_id", jSONArray3);
                jSONObject3.put("uuid", "");
                jSONObject3.put("sample", "");
                jSONArray.put(jSONObject3);
            }
            jSONObject.put("fitting", jSONArray);
            jSONObject.put("wishlist", d.a(context).c());
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.e("FXGlobal", "GenerateJsonString() JSONException");
            e.printStackTrace();
            return null;
        }
    }

    public static void a(Context context, TextView textView) {
        if (textView != null) {
            int b2 = d.a(context).b();
            if (b2 <= 0) {
                textView.setVisibility(4);
                return;
            }
            String valueOf = String.valueOf(b2);
            textView.setText(valueOf);
            textView.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            if (valueOf.length() > 1) {
                layoutParams.width = -2;
            } else {
                layoutParams.width = context.getResources().getDimensionPixelSize(2131034125);
            }
            textView.setLayoutParams(layoutParams);
        }
    }

    public static void b(Activity activity) {
        int i;
        if (activity != null) {
            int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
            if (Build.VERSION.SDK_INT < 19) {
                i = a(systemUiVisibility);
            } else {
                i = b(systemUiVisibility);
            }
            activity.getWindow().getDecorView().setSystemUiVisibility(i);
            activity.getWindow().addFlags(128);
        }
    }

    @TargetApi(19)
    private static int b(int i) {
        return a(i) | 4096;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\i.java ==========

package net.fxgear.fitnshop;

/* compiled from: FXLog */
public class i {
    public static void a(String str, String str2) {
    }

    public static void b(String str, String str2) {
    }

    public static void c(String str, String str2) {
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\IntroActivity.java ==========

package net.fxgear.fitnshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.Set;
import net.fxgear.fitnshop.IntroLayout;

public class IntroActivity extends Activity implements IntroLayout.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f846a = "IntroActivity";

    public void a() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131296260);
        IntroLayout introLayout = (IntroLayout) findViewById(2131165429);
        introLayout.a((IntroLayout.a) this);
        Intent intent = getIntent();
        i.c("IntroActivity", "[L] onCreate()+ " + intent);
        Set<String> categories = intent.getCategories();
        if (categories == null || !categories.contains("android.intent.category.LAUNCHER")) {
            intent.setAction("android.intent.action.MAIN");
            intent.setClass(this, FitNShopMainActivity.class);
            intent.setFlags(268468224);
            startActivity(intent);
            finish();
            return;
        }
        introLayout.a(1000);
        introLayout.b(1000);
        introLayout.a();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Log.e("IntroActivity", "[L] Intro onDestroy()+ ");
    }

    public void b() {
        Intent intent = new Intent(this, FitNShopMainActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
        finish();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\IntroLayout.java ==========

package net.fxgear.fitnshop;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import net.fxgear.GlobalDefine;

public class IntroLayout extends RelativeLayout implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    private final String f847a = "IntroLayout";

    /* renamed from: b  reason: collision with root package name */
    private final int f848b = -723724;
    private final float c = 0.6f;
    private final int d = 1000;
    private final float e = 1.0f;
    private final float f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    private long g = 1000;
    /* access modifiers changed from: private */
    public AlphaAnimation h;
    private a i;
    private final int j = 99;
    private Handler k = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message != null && message.what == 99) {
                Log.d("IntroLayout", "mAnimationHandler - MSG_ALPHA_FADE_OUT_ANIMATION");
                IntroLayout.this.startAnimation(IntroLayout.this.h);
            }
        }
    };

    public interface a {
        void a();

        void b();
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public IntroLayout(Context context) {
        super(context);
        a(context);
    }

    public IntroLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        View inflate = inflate(getContext(), 2131296305, this);
        if (h.f1164b.l()) {
            inflate.setBackgroundColor(-723724);
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            ImageView imageView = (ImageView) inflate.findViewById(2131165367);
            Drawable a2 = android.support.v4.b.a.a(context, 2131099863);
            float f2 = ((float) point.x) * 0.6f;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f2, (int) ((((float) a2.getIntrinsicHeight()) * f2) / ((float) a2.getIntrinsicWidth())));
            layoutParams.addRule(13);
            imageView.setLayoutParams(layoutParams);
            imageView.setBackground(a2);
        }
        this.h = new AlphaAnimation(1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        this.h.setDuration(1000);
        this.h.setAnimationListener(this);
        this.h.setFillAfter(true);
    }

    public void a(long j2) {
        Log.d("IntroLayout", "SetDisplayTime : " + j2);
        this.g = j2;
    }

    public void b(long j2) {
        Log.d("IntroLayout", "SetFadeOutTime : " + j2);
        this.h.setDuration(j2);
    }

    public void a(a aVar) {
        this.i = aVar;
    }

    public void a() {
        Log.d("IntroLayout", "StartAnimation");
        this.k.sendEmptyMessageDelayed(99, this.g);
    }

    public void onAnimationStart(Animation animation) {
        if (this.i != null) {
            this.i.a();
        }
    }

    public void onAnimationEnd(Animation animation) {
        Log.d("IntroLayout", "onAnimationEnd");
        if (animation != null && animation.equals(this.h)) {
            setVisibility(8);
            if (this.i != null) {
                this.i.b();
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\j.java ==========

package net.fxgear.fitnshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;

/* compiled from: MirrorDataManager */
public class j {
    private static j d;

    /* renamed from: a  reason: collision with root package name */
    private final String f1169a = j.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final String f1170b = "%s = ?";
    private a c;

    public static j a(Context context) {
        if (d == null) {
            d = new j(context);
        }
        return d;
    }

    public boolean a() {
        SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
        boolean z = false;
        if (readableDatabase != null && readableDatabase.isOpen()) {
            Cursor query = readableDatabase.query("table_selected_mirror_video", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query != null) {
                if (query.getCount() > 0) {
                    z = true;
                }
                query.close();
            }
            readableDatabase.close();
        }
        return z;
    }

    public int a(int i, int i2) {
        SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
        int i3 = -1;
        if (readableDatabase != null && readableDatabase.isOpen()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%s = ?", new Object[]{"mirror_video_gender"}) + " AND ");
            sb.append(String.format("%s = ?", new Object[]{"mirror_video_age"}) + " AND ");
            sb.append(String.format("%s = ?", new Object[]{"mirror_video_default"}) + " AND ");
            sb.append(String.format("%s = ?", new Object[]{"mirror_video_removable"}));
            Cursor query = readableDatabase.query("table_selected_mirror_video", (String[]) null, sb.toString(), new String[]{String.valueOf(i), String.valueOf(i2), String.valueOf(1), String.valueOf(0)}, (String) null, (String) null, (String) null);
            if (query != null) {
                if (query.moveToFirst()) {
                    i3 = query.getInt(query.getColumnIndex("mirror_video_id"));
                }
                query.close();
            }
            readableDatabase.close();
        }
        return i3;
    }

    public ArrayList<Integer> b(int i, int i2) {
        ArrayList<Integer> arrayList = null;
        SQLiteDatabase readableDatabase = this.c != null ? this.c.getReadableDatabase() : null;
        if (readableDatabase != null) {
            if (readableDatabase.isOpen()) {
                StringBuilder sb = new StringBuilder();
                sb.append(String.format("%s = ?", new Object[]{"mirror_video_gender"}) + " AND ");
                sb.append(String.format("%s = ?", new Object[]{"mirror_video_age"}));
                Cursor query = readableDatabase.query("table_selected_mirror_video", (String[]) null, sb.toString(), new String[]{String.valueOf(i), String.valueOf(i2)}, (String) null, (String) null, (String) null);
                if (query != null) {
                    if (query.getCount() > 0) {
                        arrayList = new ArrayList<>();
                        while (query.moveToNext()) {
                            arrayList.add(Integer.valueOf(query.getInt(query.getColumnIndex("mirror_video_id"))));
                        }
                    }
                    query.close();
                }
                readableDatabase.close();
            } else {
                Log.e(this.f1169a, "GetAllMirrorVideoId() failed, DB is closed.");
            }
        }
        return arrayList;
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
        if (writableDatabase != null && writableDatabase.isOpen()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mirror_video_id", Integer.valueOf(i));
            contentValues.put("mirror_video_gender", Integer.valueOf(i2));
            contentValues.put("mirror_video_age", Integer.valueOf(i3));
            contentValues.put("mirror_video_default", Integer.valueOf(i4));
            contentValues.put("mirror_video_removable", Integer.valueOf(i5));
            writableDatabase.insert("table_selected_mirror_video", (String) null, contentValues);
            writableDatabase.close();
        }
    }

    public void a(int i) {
        SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.delete("table_selected_mirror_video", String.format("%s = ?", new Object[]{"mirror_video_id"}), new String[]{String.valueOf(i)});
            writableDatabase.close();
        }
    }

    public boolean b(int i) {
        int i2;
        SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
        if (readableDatabase == null || !readableDatabase.isOpen()) {
            i2 = 0;
        } else {
            Cursor query = readableDatabase.query("table_selected_mirror_video", (String[]) null, String.format("%s = ?", new Object[]{"mirror_video_id"}), new String[]{String.valueOf(i)}, (String) null, (String) null, (String) null);
            if (query != null) {
                i2 = query.moveToFirst() ? query.getInt(query.getColumnIndex("mirror_video_default")) : 0;
                query.close();
            } else {
                i2 = 0;
            }
            readableDatabase.close();
        }
        if (i2 == 1) {
            return true;
        }
        return false;
    }

    public boolean c(int i) {
        int i2;
        SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
        if (readableDatabase == null || !readableDatabase.isOpen()) {
            i2 = 0;
        } else {
            Cursor query = readableDatabase.query("table_selected_mirror_video", (String[]) null, String.format("%s = ?", new Object[]{"mirror_video_id"}), new String[]{String.valueOf(i)}, (String) null, (String) null, (String) null);
            if (query != null) {
                i2 = query.moveToFirst() ? query.getInt(query.getColumnIndex("mirror_video_removable")) : 0;
                query.close();
            } else {
                i2 = 0;
            }
            readableDatabase.close();
        }
        if (i2 == 1) {
            return true;
        }
        return false;
    }

    public void b() {
        SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
        if (readableDatabase != null) {
            readableDatabase.delete("table_selected_mirror_video", (String) null, (String[]) null);
            readableDatabase.close();
        }
    }

    private j(Context context) {
        this.c = new a(context, "mirror_data.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    /* compiled from: MirrorDataManager */
    private class a extends SQLiteOpenHelper {

        /* renamed from: b  reason: collision with root package name */
        private final String f1172b = a.class.getSimpleName();
        private final String c = "CREATE TABLE IF NOT EXISTS table_selected_mirror_video(id INTEGER PRIMARY KEY AUTOINCREMENT, mirror_video_id INTEGER DEFAULT (-1),mirror_video_gender INTEGER DEFAULT (-1),mirror_video_age INTEGER DEFAULT (-1),mirror_video_default INTEGER DEFAULT (-1),mirror_video_removable INTEGER DEFAULT (-1));";

        public a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
            String str2 = this.f1172b;
            Log.d(str2, "DataBaseHelper()+, name : " + str + ", version : " + i);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Log.d(this.f1172b, "onCreate()+");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS table_selected_mirror_video(id INTEGER PRIMARY KEY AUTOINCREMENT, mirror_video_id INTEGER DEFAULT (-1),mirror_video_gender INTEGER DEFAULT (-1),mirror_video_age INTEGER DEFAULT (-1),mirror_video_default INTEGER DEFAULT (-1),mirror_video_removable INTEGER DEFAULT (-1));");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            String str = this.f1172b;
            Log.d(str, "onUpgrade()+, oldVersion : " + i + ", newVersion : " + i2);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\k.java ==========

package net.fxgear.fitnshop;

import android.app.Activity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import net.fxgear.fitnshop.d.g;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ScriptInterface */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private final String f1173a = "id";

    /* renamed from: b  reason: collision with root package name */
    private final String f1174b = "name";
    private final String c = "status";
    private final String d = "loading";
    private final String e = "success";
    private final String f = "fail";
    private Activity g;
    private g.b h;

    public k(Activity activity) {
        Log.i("ScriptInterface", "ScriptInterface");
        this.g = activity;
    }

    public void a(g.b bVar) {
        this.h = bVar;
    }

    @JavascriptInterface
    public void goBrand(String str) {
        Log.d("ScriptInterface", "goBrand()+");
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i = jSONObject.getInt("id");
                String string = jSONObject.getString("name");
                if (this.h != null) {
                    this.h.a(i, string);
                } else {
                    Log.e("ScriptInterface", "mHomeFragmentListener is null");
                }
            } catch (JSONException e2) {
                Log.e("ScriptInterface", "ERROR :: JSONException");
                e2.printStackTrace();
            }
        }
    }

    @JavascriptInterface
    public void dispatchDataLoadingStatus(String str) {
        Log.d("ScriptInterface", "dispatchDataLoadingStatus()+");
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                boolean z = false;
                String string = jSONObject.getString("status");
                if (string != null) {
                    if (!string.equals("loading")) {
                        if (string.equals("success")) {
                            z = true;
                        }
                    } else {
                        return;
                    }
                }
                if (this.h != null) {
                    this.h.a(z);
                } else {
                    Log.e("ScriptInterface", "mHomeFragmentListener is null");
                }
            } catch (JSONException e2) {
                Log.e("ScriptInterface", "ERROR :: JSONException");
                e2.printStackTrace();
            }
        }
    }

    @JavascriptInterface
    public void goInfo(String str) {
        if (this.h != null) {
            this.h.a(str);
        }
    }

    public static void a(final WebView webView) {
        webView.post(new Runnable() {
            public void run() {
                webView.loadUrl("javascript:moveScrollTop()");
            }
        });
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\l.java ==========

package net.fxgear.fitnshop;

import android.os.Message;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

/* compiled from: UriWebChromeClient */
public class l extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    private final String f1176a = "UriWebChromeClient";

    /* renamed from: b  reason: collision with root package name */
    private WebViewClient f1177b;
    private a c;

    /* compiled from: UriWebChromeClient */
    public interface a {
        void a_();
    }

    public l(WebViewClient webViewClient) {
        this.f1177b = webViewClient;
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        Log.d("UriWebChromeClient", "onCreateWindow()");
        WebView webView2 = new WebView(webView.getContext());
        webView2.setVerticalScrollBarEnabled(false);
        webView2.setHorizontalScrollBarEnabled(false);
        webView2.setWebViewClient(this.f1177b);
        webView2.setWebChromeClient(this);
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.getSettings().setSavePassword(false);
        webView2.getSettings().setTextZoom(100);
        webView2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        webView.addView(webView2);
        ((WebView.WebViewTransport) message.obj).setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public void onCloseWindow(WebView webView) {
        Log.d("UriWebChromeClient", "onCloseWindow()");
        super.onCloseWindow(webView);
        ViewGroup viewGroup = (ViewGroup) webView.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(webView);
        }
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        Log.d("UriWebChromeClient", "onJsAlert()");
        if (this.c == null) {
            return true;
        }
        this.c.a_();
        return true;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        Log.d("UriWebChromeClient", "onJsConfirm()");
        return super.onJsConfirm(webView, str, str2, jsResult);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\ThumbnailLayout.java ==========

package net.fxgear.fitnshop;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ThumbnailLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f850a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f851b;
    private ImageView c;

    public ThumbnailLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate(context, 2131296299, this);
        c();
    }

    private void c() {
        this.f850a = (RelativeLayout) findViewById(2131165326);
        this.f851b = (ImageView) findViewById(2131165329);
        this.c = (ImageView) findViewById(2131165331);
    }

    public void setPressed(boolean z) {
        if (z) {
            if (this.c.getVisibility() != 0) {
                this.c.setVisibility(0);
            }
        } else if (this.c.getVisibility() != 8) {
            this.c.setVisibility(8);
        }
        super.setPressed(z);
    }

    public ImageView a() {
        return this.f851b;
    }

    public RelativeLayout b() {
        return this.f850a;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\WebActivity.java ==========

package net.fxgear.fitnshop;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import net.fxgear.fitnshop.d.l;

public class WebActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private final String f852a = WebActivity.class.getSimpleName();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131296261);
        Intent intent = getIntent();
        String stringExtra = (intent == null || !intent.hasExtra("extra_url")) ? "" : intent.getStringExtra("extra_url");
        a();
        l lVar = new l(stringExtra, false);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.setTransition(0);
        beginTransaction.add(2131165347, lVar, lVar.a());
        beginTransaction.commit();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        h.b((Activity) this);
    }

    private void a() {
        Log.d(this.f852a, "ClearFragmentStack");
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        if (backStackEntryCount > 0) {
            String str = this.f852a;
            Log.e(str, "Remaing stack size(before) : " + backStackEntryCount);
            for (int i = 0; i < backStackEntryCount; i++) {
                Fragment findFragmentByTag = fragmentManager.findFragmentByTag(fragmentManager.getBackStackEntryAt(0).getName());
                String str2 = this.f852a;
                Log.e(str2, "Remove remaing stackFragment : " + findFragmentByTag.getTag());
                fragmentManager.popBackStackImmediate();
                beginTransaction.remove(findFragmentByTag);
            }
            String str3 = this.f852a;
            Log.e(str3, "Remaing stack size(after) : " + fragmentManager.getBackStackEntryCount());
        }
        beginTransaction.commit();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\a\a.java ==========

package net.fxgear.fitnshop.a;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: AsyncTask */
public abstract class a<Params, Progress, Result> {

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f857a = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, e, d, new ThreadPoolExecutor.DiscardOldestPolicy());

    /* renamed from: b  reason: collision with root package name */
    public static final Executor f858b;
    public static final Executor c = Executors.newFixedThreadPool(2, d);
    private static final ThreadFactory d = new ThreadFactory() {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f859a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.f859a.getAndIncrement());
        }
    };
    private static final BlockingQueue<Runnable> e = new LinkedBlockingQueue(10);
    private static final b f = new b();
    private static volatile Executor g = f858b;
    private final e<Params, Result> h = new e<Params, Result>() {
        public Result call() throws Exception {
            a.this.l.set(true);
            Process.setThreadPriority(10);
            return a.this.d(a.this.a((Params[]) this.f871b));
        }
    };
    private final FutureTask<Result> i = new FutureTask<Result>(this.h) {
        /* access modifiers changed from: protected */
        public void done() {
            try {
                a.this.c(get());
            } catch (InterruptedException e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException unused) {
                a.this.c(null);
            }
        }
    };
    private volatile d j = d.PENDING;
    private final AtomicBoolean k = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final AtomicBoolean l = new AtomicBoolean();

    /* compiled from: AsyncTask */
    public enum d {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* access modifiers changed from: protected */
    public abstract Result a(Params... paramsArr);

    /* access modifiers changed from: protected */
    public void a() {
    }

    /* access modifiers changed from: protected */
    public void a(Result result) {
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* access modifiers changed from: protected */
    public void b(Progress... progressArr) {
    }

    static {
        Executor executor;
        if (j.c()) {
            executor = new c();
        } else {
            executor = Executors.newSingleThreadExecutor(d);
        }
        f858b = executor;
    }

    @TargetApi(11)
    /* compiled from: AsyncTask */
    private static class c implements Executor {

        /* renamed from: a  reason: collision with root package name */
        final ArrayDeque<Runnable> f865a;

        /* renamed from: b  reason: collision with root package name */
        Runnable f866b;

        private c() {
            this.f865a = new ArrayDeque<>();
        }

        public synchronized void execute(final Runnable runnable) {
            this.f865a.offer(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        c.this.a();
                    }
                }
            });
            if (this.f866b == null) {
                a();
            }
        }

        /* access modifiers changed from: protected */
        public synchronized void a() {
            Runnable poll = this.f865a.poll();
            this.f866b = poll;
            if (poll != null) {
                a.f857a.execute(this.f866b);
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(Result result) {
        if (!this.l.get()) {
            d(result);
        }
    }

    /* access modifiers changed from: private */
    public Result d(Result result) {
        f.obtainMessage(1, new C0028a(this, result)).sendToTarget();
        return result;
    }

    /* access modifiers changed from: protected */
    public void b(Result result) {
        b();
    }

    public final boolean c() {
        return this.k.get();
    }

    public final boolean a(boolean z) {
        this.k.set(true);
        return this.i.cancel(z);
    }

    public final a<Params, Progress, Result> c(Params... paramsArr) {
        return a(g, paramsArr);
    }

    public final a<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.j != d.PENDING) {
            switch (this.j) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.j = d.RUNNING;
        a();
        this.h.f871b = paramsArr;
        executor.execute(this.i);
        return this;
    }

    /* access modifiers changed from: private */
    public void e(Result result) {
        if (c()) {
            b(result);
        } else {
            a(result);
        }
        this.j = d.FINISHED;
    }

    /* compiled from: AsyncTask */
    private static class b extends Handler {
        private b() {
        }

        public void handleMessage(Message message) {
            C0028a aVar = (C0028a) message.obj;
            switch (message.what) {
                case 1:
                    aVar.f863a.e(aVar.f864b[0]);
                    return;
                case 2:
                    aVar.f863a.b((Progress[]) aVar.f864b);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: AsyncTask */
    private static abstract class e<Params, Result> implements Callable<Result> {

        /* renamed from: b  reason: collision with root package name */
        Params[] f871b;

        private e() {
        }
    }

    /* renamed from: net.fxgear.fitnshop.a.a$a  reason: collision with other inner class name */
    /* compiled from: AsyncTask */
    private static class C0028a<Data> {

        /* renamed from: a  reason: collision with root package name */
        final a f863a;

        /* renamed from: b  reason: collision with root package name */
        final Data[] f864b;

        C0028a(a aVar, Data... dataArr) {
            this.f863a = aVar;
            this.f864b = dataArr;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\a\b.java ==========

package net.fxgear.fitnshop.a;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.fxgear.fittingview.data.FittingFaceData;

/* compiled from: DiskLruCache */
public final class b implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f872a = Charset.forName("UTF-8");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final File f873b;
    private final File c;
    private final File d;
    private final int e;
    private final long f;
    /* access modifiers changed from: private */
    public final int g;
    private long h = 0;
    /* access modifiers changed from: private */
    public Writer i;
    private final LinkedHashMap<String, C0030b> j = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */
    public int k;
    private long l = 0;
    private final ExecutorService m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> n = new Callable<Void>() {
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            return null;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r4 = this;
                net.fxgear.fitnshop.a.b r0 = net.fxgear.fitnshop.a.b.this
                monitor-enter(r0)
                net.fxgear.fitnshop.a.b r1 = net.fxgear.fitnshop.a.b.this     // Catch:{ all -> 0x0028 }
                java.io.Writer r1 = r1.i     // Catch:{ all -> 0x0028 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x000e:
                net.fxgear.fitnshop.a.b r1 = net.fxgear.fitnshop.a.b.this     // Catch:{ all -> 0x0028 }
                r1.i()     // Catch:{ all -> 0x0028 }
                net.fxgear.fitnshop.a.b r1 = net.fxgear.fitnshop.a.b.this     // Catch:{ all -> 0x0028 }
                boolean r1 = r1.g()     // Catch:{ all -> 0x0028 }
                if (r1 == 0) goto L_0x0026
                net.fxgear.fitnshop.a.b r1 = net.fxgear.fitnshop.a.b.this     // Catch:{ all -> 0x0028 }
                r1.f()     // Catch:{ all -> 0x0028 }
                net.fxgear.fitnshop.a.b r1 = net.fxgear.fitnshop.a.b.this     // Catch:{ all -> 0x0028 }
                r3 = 0
                int unused = r1.k = r3     // Catch:{ all -> 0x0028 }
            L_0x0026:
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x0028:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.a.b.AnonymousClass1.call():java.lang.Void");
        }
    };

    private static <T> T[] a(T[] tArr, int i2, int i3) {
        int length = tArr.length;
        if (i2 > i3) {
            throw new IllegalArgumentException();
        } else if (i2 < 0 || i2 > length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            int i4 = i3 - i2;
            int min = Math.min(i4, length - i2);
            T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i4);
            System.arraycopy(tArr, i2, tArr2, 0, min);
            return tArr2;
        }
    }

    public static String a(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder(80);
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                throw new EOFException();
            } else if (read == 10) {
                int length = sb.length();
                if (length > 0) {
                    int i2 = length - 1;
                    if (sb.charAt(i2) == 13) {
                        sb.setLength(i2);
                    }
                }
                return sb.toString();
            } else {
                sb.append((char) read);
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void a(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i2 = 0;
            while (i2 < length) {
                File file2 = listFiles[i2];
                if (file2.isDirectory()) {
                    a(file2);
                }
                if (file2.delete()) {
                    i2++;
                } else {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IllegalArgumentException("not a directory: " + file);
    }

    private b(File file, int i2, int i3, long j2) {
        File file2 = file;
        this.f873b = file2;
        this.e = i2;
        this.c = new File(file2, "journal");
        this.d = new File(file2, "journal.tmp");
        this.g = i3;
        this.f = j2;
    }

    public static b a(File file, int i2, int i3, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            b bVar = new b(file, i2, i3, j2);
            if (bVar.c.exists()) {
                try {
                    bVar.d();
                    bVar.e();
                    bVar.i = new BufferedWriter(new FileWriter(bVar.c, true), 8192);
                    return bVar;
                } catch (IOException unused) {
                    bVar.c();
                }
            }
            file.mkdirs();
            b bVar2 = new b(file, i2, i3, j2);
            bVar2.f();
            return bVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private void d() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.c), 8192);
        try {
            String a2 = a((InputStream) bufferedInputStream);
            String a3 = a((InputStream) bufferedInputStream);
            String a4 = a((InputStream) bufferedInputStream);
            String a5 = a((InputStream) bufferedInputStream);
            String a6 = a((InputStream) bufferedInputStream);
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.e).equals(a4) || !Integer.toString(this.g).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + ", " + a3 + ", " + a5 + ", " + a6 + "]");
            }
            while (true) {
                try {
                    d(a((InputStream) bufferedInputStream));
                } catch (EOFException unused) {
                    return;
                }
            }
        } finally {
            a((Closeable) bufferedInputStream);
        }
    }

    private void d(String str) throws IOException {
        String[] split = str.split(" ");
        if (split.length >= 2) {
            String str2 = split[1];
            if (!split[0].equals("REMOVE") || split.length != 2) {
                C0030b bVar = this.j.get(str2);
                if (bVar == null) {
                    bVar = new C0030b(str2);
                    this.j.put(str2, bVar);
                }
                if (split[0].equals("CLEAN") && split.length == this.g + 2) {
                    boolean unused = bVar.d = true;
                    a unused2 = bVar.e = null;
                    bVar.a((String[]) a((T[]) split, 2, split.length));
                } else if (split[0].equals("DIRTY") && split.length == 2) {
                    a unused3 = bVar.e = new a(bVar);
                } else if (!split[0].equals("READ") || split.length != 2) {
                    throw new IOException("unexpected journal line: " + str);
                }
            } else {
                this.j.remove(str2);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void e() throws IOException {
        b(this.d);
        Iterator<C0030b> it = this.j.values().iterator();
        while (it.hasNext()) {
            C0030b next = it.next();
            int i2 = 0;
            if (next.e == null) {
                while (i2 < this.g) {
                    this.h += next.c[i2];
                    i2++;
                }
            } else {
                a unused = next.e = null;
                while (i2 < this.g) {
                    b(next.a(i2));
                    b(next.b(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void f() throws IOException {
        if (this.i != null) {
            this.i.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.d), 8192);
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.e));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.g));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (C0030b next : this.j.values()) {
            if (next.e != null) {
                bufferedWriter.write("DIRTY " + next.f879b + 10);
            } else {
                bufferedWriter.write("CLEAN " + next.f879b + next.a() + 10);
            }
        }
        bufferedWriter.close();
        this.d.renameTo(this.c);
        this.i = new BufferedWriter(new FileWriter(this.c, true), 8192);
    }

    private static void b(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public synchronized c a(String str) throws IOException {
        h();
        e(str);
        C0030b bVar = this.j.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.d) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.g];
        int i2 = 0;
        while (i2 < this.g) {
            try {
                inputStreamArr[i2] = new FileInputStream(bVar.a(i2));
                i2++;
            } catch (FileNotFoundException unused) {
                return null;
            }
        }
        this.k++;
        this.i.append("READ " + str + 10);
        if (g()) {
            this.m.submit(this.n);
        }
        return new c(str, bVar.f, inputStreamArr);
    }

    public a b(String str) throws IOException {
        return a(str, -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized net.fxgear.fitnshop.a.b.a a(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.h()     // Catch:{ all -> 0x0061 }
            r5.e((java.lang.String) r6)     // Catch:{ all -> 0x0061 }
            java.util.LinkedHashMap<java.lang.String, net.fxgear.fitnshop.a.b$b> r0 = r5.j     // Catch:{ all -> 0x0061 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0061 }
            net.fxgear.fitnshop.a.b$b r0 = (net.fxgear.fitnshop.a.b.C0030b) r0     // Catch:{ all -> 0x0061 }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x0022
            if (r0 == 0) goto L_0x0020
            long r1 = r0.f     // Catch:{ all -> 0x0061 }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0022
        L_0x0020:
            monitor-exit(r5)
            return r3
        L_0x0022:
            if (r0 != 0) goto L_0x002f
            net.fxgear.fitnshop.a.b$b r0 = new net.fxgear.fitnshop.a.b$b     // Catch:{ all -> 0x0061 }
            r0.<init>(r6)     // Catch:{ all -> 0x0061 }
            java.util.LinkedHashMap<java.lang.String, net.fxgear.fitnshop.a.b$b> r7 = r5.j     // Catch:{ all -> 0x0061 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0061 }
            goto L_0x0037
        L_0x002f:
            net.fxgear.fitnshop.a.b$a r7 = r0.e     // Catch:{ all -> 0x0061 }
            if (r7 == 0) goto L_0x0037
            monitor-exit(r5)
            return r3
        L_0x0037:
            net.fxgear.fitnshop.a.b$a r7 = new net.fxgear.fitnshop.a.b$a     // Catch:{ all -> 0x0061 }
            r7.<init>(r0)     // Catch:{ all -> 0x0061 }
            net.fxgear.fitnshop.a.b.a unused = r0.e = r7     // Catch:{ all -> 0x0061 }
            java.io.Writer r8 = r5.i     // Catch:{ all -> 0x0061 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            r0.<init>()     // Catch:{ all -> 0x0061 }
            java.lang.String r1 = "DIRTY "
            r0.append(r1)     // Catch:{ all -> 0x0061 }
            r0.append(r6)     // Catch:{ all -> 0x0061 }
            r6 = 10
            r0.append(r6)     // Catch:{ all -> 0x0061 }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x0061 }
            r8.write(r6)     // Catch:{ all -> 0x0061 }
            java.io.Writer r6 = r5.i     // Catch:{ all -> 0x0061 }
            r6.flush()     // Catch:{ all -> 0x0061 }
            monitor-exit(r5)
            return r7
        L_0x0061:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.a.b.a(java.lang.String, long):net.fxgear.fitnshop.a.b$a");
    }

    /* access modifiers changed from: private */
    public synchronized void a(a aVar, boolean z) throws IOException {
        C0030b a2 = aVar.f876b;
        if (a2.e == aVar) {
            if (z && !a2.d) {
                int i2 = 0;
                while (i2 < this.g) {
                    if (a2.b(i2).exists()) {
                        i2++;
                    } else {
                        aVar.b();
                        throw new IllegalStateException("edit didn't create file " + i2);
                    }
                }
            }
            for (int i3 = 0; i3 < this.g; i3++) {
                File b2 = a2.b(i3);
                if (!z) {
                    b(b2);
                } else if (b2.exists()) {
                    File a3 = a2.a(i3);
                    b2.renameTo(a3);
                    long j2 = a2.c[i3];
                    long length = a3.length();
                    a2.c[i3] = length;
                    this.h = (this.h - j2) + length;
                }
            }
            this.k++;
            a unused = a2.e = null;
            if (a2.d || z) {
                boolean unused2 = a2.d = true;
                this.i.write("CLEAN " + a2.f879b + a2.a() + 10);
                if (z) {
                    long j3 = this.l;
                    this.l = 1 + j3;
                    long unused3 = a2.f = j3;
                }
            } else {
                this.j.remove(a2.f879b);
                this.i.write("REMOVE " + a2.f879b + 10);
            }
            if (this.h > this.f || g()) {
                this.m.submit(this.n);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    /* access modifiers changed from: private */
    public boolean g() {
        return this.k >= 2000 && this.k >= this.j.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0089, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean c(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.h()     // Catch:{ all -> 0x008c }
            r7.e((java.lang.String) r8)     // Catch:{ all -> 0x008c }
            java.util.LinkedHashMap<java.lang.String, net.fxgear.fitnshop.a.b$b> r0 = r7.j     // Catch:{ all -> 0x008c }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x008c }
            net.fxgear.fitnshop.a.b$b r0 = (net.fxgear.fitnshop.a.b.C0030b) r0     // Catch:{ all -> 0x008c }
            r1 = 0
            if (r0 == 0) goto L_0x008a
            net.fxgear.fitnshop.a.b$a r2 = r0.e     // Catch:{ all -> 0x008c }
            if (r2 == 0) goto L_0x0019
            goto L_0x008a
        L_0x0019:
            int r2 = r7.g     // Catch:{ all -> 0x008c }
            if (r1 >= r2) goto L_0x0055
            java.io.File r2 = r0.a((int) r1)     // Catch:{ all -> 0x008c }
            boolean r3 = r2.delete()     // Catch:{ all -> 0x008c }
            if (r3 == 0) goto L_0x003e
            long r2 = r7.h     // Catch:{ all -> 0x008c }
            long[] r4 = r0.c     // Catch:{ all -> 0x008c }
            r5 = r4[r1]     // Catch:{ all -> 0x008c }
            r4 = 0
            long r2 = r2 - r5
            r7.h = r2     // Catch:{ all -> 0x008c }
            long[] r2 = r0.c     // Catch:{ all -> 0x008c }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x008c }
            int r1 = r1 + 1
            goto L_0x0019
        L_0x003e:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x008c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x008c }
            r0.<init>()     // Catch:{ all -> 0x008c }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x008c }
            r0.append(r2)     // Catch:{ all -> 0x008c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008c }
            r8.<init>(r0)     // Catch:{ all -> 0x008c }
            throw r8     // Catch:{ all -> 0x008c }
        L_0x0055:
            int r0 = r7.k     // Catch:{ all -> 0x008c }
            r1 = 1
            int r0 = r0 + r1
            r7.k = r0     // Catch:{ all -> 0x008c }
            java.io.Writer r0 = r7.i     // Catch:{ all -> 0x008c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008c }
            r2.<init>()     // Catch:{ all -> 0x008c }
            java.lang.String r3 = "REMOVE "
            r2.append(r3)     // Catch:{ all -> 0x008c }
            r2.append(r8)     // Catch:{ all -> 0x008c }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x008c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x008c }
            r0.append(r2)     // Catch:{ all -> 0x008c }
            java.util.LinkedHashMap<java.lang.String, net.fxgear.fitnshop.a.b$b> r0 = r7.j     // Catch:{ all -> 0x008c }
            r0.remove(r8)     // Catch:{ all -> 0x008c }
            boolean r8 = r7.g()     // Catch:{ all -> 0x008c }
            if (r8 == 0) goto L_0x0088
            java.util.concurrent.ExecutorService r8 = r7.m     // Catch:{ all -> 0x008c }
            java.util.concurrent.Callable<java.lang.Void> r0 = r7.n     // Catch:{ all -> 0x008c }
            r8.submit(r0)     // Catch:{ all -> 0x008c }
        L_0x0088:
            monitor-exit(r7)
            return r1
        L_0x008a:
            monitor-exit(r7)
            return r1
        L_0x008c:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.a.b.c(java.lang.String):boolean");
    }

    public boolean a() {
        return this.i == null;
    }

    private void h() {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void b() throws IOException {
        h();
        i();
        this.i.flush();
    }

    public synchronized void close() throws IOException {
        if (this.i != null) {
            Iterator it = new ArrayList(this.j.values()).iterator();
            while (it.hasNext()) {
                C0030b bVar = (C0030b) it.next();
                if (bVar.e != null) {
                    bVar.e.b();
                }
            }
            i();
            this.i.close();
            this.i = null;
        }
    }

    /* access modifiers changed from: private */
    public void i() throws IOException {
        while (this.h > this.f) {
            c((String) this.j.entrySet().iterator().next().getKey());
        }
    }

    public void c() throws IOException {
        close();
        a(this.f873b);
    }

    private void e(String str) {
        if (str.contains(" ") || str.contains("\n") || str.contains("\r")) {
            throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + str + "\"");
        }
    }

    /* compiled from: DiskLruCache */
    public final class c implements Closeable {

        /* renamed from: b  reason: collision with root package name */
        private final String f881b;
        private final long c;
        private final InputStream[] d;

        private c(String str, long j, InputStream[] inputStreamArr) {
            this.f881b = str;
            this.c = j;
            this.d = inputStreamArr;
        }

        public InputStream a(int i) {
            return this.d[i];
        }

        public void close() {
            for (InputStream a2 : this.d) {
                b.a((Closeable) a2);
            }
        }
    }

    /* compiled from: DiskLruCache */
    public final class a {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final C0030b f876b;
        /* access modifiers changed from: private */
        public boolean c;

        private a(C0030b bVar) {
            this.f876b = bVar;
        }

        public OutputStream a(int i) throws IOException {
            C0029a aVar;
            synchronized (b.this) {
                if (this.f876b.e == this) {
                    aVar = new C0029a(new FileOutputStream(this.f876b.b(i)));
                } else {
                    throw new IllegalStateException();
                }
            }
            return aVar;
        }

        public void a() throws IOException {
            if (this.c) {
                b.this.a(this, false);
                b.this.c(this.f876b.f879b);
                return;
            }
            b.this.a(this, true);
        }

        public void b() throws IOException {
            b.this.a(this, false);
        }

        public void c() throws IOException {
            b.this.c(this.f876b.f879b);
        }

        /* renamed from: net.fxgear.fitnshop.a.b$a$a  reason: collision with other inner class name */
        /* compiled from: DiskLruCache */
        private class C0029a extends FilterOutputStream {
            private C0029a(OutputStream outputStream) {
                super(outputStream);
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    boolean unused2 = a.this.c = true;
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    boolean unused2 = a.this.c = true;
                }
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    boolean unused2 = a.this.c = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    boolean unused2 = a.this.c = true;
                }
            }
        }
    }

    /* renamed from: net.fxgear.fitnshop.a.b$b  reason: collision with other inner class name */
    /* compiled from: DiskLruCache */
    private final class C0030b {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final String f879b;
        /* access modifiers changed from: private */
        public final long[] c;
        /* access modifiers changed from: private */
        public boolean d;
        /* access modifiers changed from: private */
        public a e;
        /* access modifiers changed from: private */
        public long f;

        private C0030b(String str) {
            this.f879b = str;
            this.c = new long[b.this.g];
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.c) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }

        /* access modifiers changed from: private */
        public void a(String[] strArr) throws IOException {
            if (strArr.length == b.this.g) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.c[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        throw b(strArr);
                    }
                }
                return;
            }
            throw b(strArr);
        }

        private IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i) {
            File f2 = b.this.f873b;
            return new File(f2, this.f879b + FittingFaceData.FILE_EXTENSION_DOT + i);
        }

        public File b(int i) {
            File f2 = b.this.f873b;
            return new File(f2, this.f879b + FittingFaceData.FILE_EXTENSION_DOT + i + ".tmp");
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\a\c.java ==========

package net.fxgear.fitnshop.a;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: FXDiskCache */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f882a = "c";

    /* renamed from: b  reason: collision with root package name */
    private final String f883b;
    private final String c;
    private Context d;
    /* access modifiers changed from: private */
    public File e;
    /* access modifiers changed from: private */
    public long f;
    private Handler g;
    private HandlerThread h;
    /* access modifiers changed from: private */
    public Object i;
    private Handler.Callback j;

    /* compiled from: FXDiskCache */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f886a = "FXDiskCache";

        /* renamed from: b  reason: collision with root package name */
        public long f887b = 10485760;
    }

    public c(Context context, String str) {
        this(context, str, (a) null);
    }

    public c(Context context, String str, a aVar) {
        this.i = new Object();
        this.j = new Handler.Callback() {
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 98:
                        c.this.b();
                        return false;
                    case 99:
                        long j = 0;
                        synchronized (c.this.i) {
                            ArrayList a2 = c.this.b(c.this.e);
                            if (a2 != null) {
                                Iterator it = a2.iterator();
                                while (it.hasNext()) {
                                    j += ((File) it.next()).length();
                                }
                            }
                        }
                        if (j < c.this.f) {
                            return false;
                        }
                        c.this.d();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.d = context.getApplicationContext();
        this.f883b = str;
        this.c = f882a + "_" + this.f883b;
        if (aVar == null) {
            this.f = 10485760;
            this.e = a(context, "FXDiskCache");
        } else {
            this.f = aVar.f887b;
            this.e = a(context, aVar.f886a);
        }
        this.h = new HandlerThread(this.c);
        this.h.start();
        this.g = new Handler(this.h.getLooper(), this.j);
        c();
    }

    public void a() {
        Log.d(this.c, "Destroy()+");
        if (this.g != null) {
            this.g.removeCallbacksAndMessages((Object) null);
            this.g = null;
        }
        if (this.h != null) {
            this.h.quitSafely();
            this.h = null;
        }
    }

    private File a(Context context, String str) {
        String str2;
        if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            str2 = a(context);
        } else {
            str2 = context.getCacheDir().getPath();
        }
        return new File(str2, str);
    }

    private String a(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            return externalCacheDir.getAbsolutePath();
        }
        return Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/cache/");
    }

    private void c() {
        Log.d(this.c, "calculateCurrentSize()+");
        if (this.g != null) {
            this.g.removeMessages(99);
            this.g.sendEmptyMessage(99);
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        Log.d(this.c, "removeOldCacheFiles()+");
        synchronized (this.i) {
            ArrayList<File> b2 = b(this.e);
            if (b2 != null && !b2.isEmpty()) {
                Collections.sort(b2, new Comparator<File>() {
                    /* renamed from: a */
                    public int compare(File file, File file2) {
                        if (file.lastModified() > file2.lastModified()) {
                            return -1;
                        }
                        return file.lastModified() < file2.lastModified() ? 1 : 0;
                    }
                });
                int i2 = 0;
                long j2 = 0;
                while (true) {
                    if (i2 >= b2.size()) {
                        break;
                    }
                    File file = b2.get(i2);
                    j2 += file.length();
                    if (this.f == 0) {
                        break;
                    } else if (j2 >= this.f / 2) {
                        break;
                    } else {
                        b2.remove(file);
                        i2++;
                    }
                }
                if (!b2.isEmpty()) {
                    Iterator<File> it = b2.iterator();
                    while (it.hasNext()) {
                        File next = it.next();
                        if (next.exists()) {
                            if (next.isFile()) {
                                if (next.delete()) {
                                    a(next.getParentFile());
                                }
                            } else if (next.isDirectory()) {
                                a(next);
                            }
                        }
                    }
                }
            }
        }
    }

    private void a(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                file.delete();
            }
        }
    }

    /* access modifiers changed from: private */
    public ArrayList<File> b(File file) {
        if (file == null || !file.isDirectory()) {
            return null;
        }
        ArrayList<File> arrayList = new ArrayList<>();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                arrayList.add(file2);
            } else if (file2.isDirectory()) {
                arrayList.addAll(b(file2));
            }
        }
        return arrayList;
    }

    private boolean b(String str) {
        boolean z;
        synchronized (this.i) {
            String c2 = c(str);
            z = c2 != null && new File(c2).exists();
        }
        return z;
    }

    private String c(String str) {
        if (str != null) {
            try {
                StringBuilder sb = new StringBuilder(32);
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(str.getBytes());
                byte[] digest = instance.digest();
                for (int i2 = 0; i2 < 16; i2++) {
                    sb.append(String.format("%02X", new Object[]{Byte.valueOf(digest[i2])}));
                }
                String sb2 = sb.toString();
                return (this.e.getAbsolutePath() + File.separator + sb2.substring(0, 2)) + File.separator + sb2;
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public String a(String str) {
        String c2 = c(str);
        if (!b(str)) {
            synchronized (this.i) {
                File parentFile = new File(c2).getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (a(str, c2)) {
                    c();
                } else {
                    Log.e(this.c, "ERROR :: download file fail.");
                    File file = new File(c2);
                    if (file.exists()) {
                        file.delete();
                    }
                    c2 = null;
                }
            }
        }
        return c2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0187 A[Catch:{ Exception -> 0x0133 }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x018c A[Catch:{ Exception -> 0x0133 }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01a0 A[SYNTHETIC, Splitter:B:110:0x01a0] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01a5 A[Catch:{ Exception -> 0x0133 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01aa A[Catch:{ Exception -> 0x0133 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01b1 A[SYNTHETIC, Splitter:B:118:0x01b1] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01b9 A[Catch:{ Exception -> 0x01b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01be A[Catch:{ Exception -> 0x01b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x016a A[SYNTHETIC, Splitter:B:88:0x016a] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x016f A[Catch:{ Exception -> 0x0133 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0174 A[Catch:{ Exception -> 0x0133 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0182 A[SYNTHETIC, Splitter:B:99:0x0182] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:107:0x0194=Splitter:B:107:0x0194, B:85:0x0165=Splitter:B:85:0x0165, B:96:0x017d=Splitter:B:96:0x017d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r0 = f882a
            java.lang.String r1 = "DownloadFile()+"
            android.util.Log.i(r0, r1)
            r0 = 0
            if (r11 == 0) goto L_0x01ce
            if (r12 != 0) goto L_0x000e
            goto L_0x01ce
        L_0x000e:
            android.content.Context r1 = r10.d
            boolean r1 = net.fxgear.fitnshop.h.d(r1)
            if (r1 == 0) goto L_0x01c6
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            java.lang.Thread r2 = r2.getThread()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0031
            java.lang.String r11 = f882a
            java.lang.String r12 = "ERROR :: illegal state"
            android.util.Log.e(r11, r12)
            goto L_0x01ec
        L_0x0031:
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            boolean r1 = r1.isInterrupted()
            if (r1 == 0) goto L_0x0044
            java.lang.String r11 = f882a
            java.lang.String r12 = "cancel download"
            android.util.Log.e(r11, r12)
            goto L_0x01ec
        L_0x0044:
            java.io.File r1 = new java.io.File
            r1.<init>(r12)
            java.io.File r12 = r1.getParentFile()
            boolean r12 = r12.exists()
            if (r12 != 0) goto L_0x005b
            java.io.File r12 = r1.getParentFile()
            r12.mkdirs()
            goto L_0x0064
        L_0x005b:
            boolean r12 = r1.exists()
            if (r12 == 0) goto L_0x0064
            r1.delete()
        L_0x0064:
            r12 = 0
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ NumberFormatException -> 0x0190, MalformedURLException -> 0x0179, IOException -> 0x0161, all -> 0x015c }
            java.lang.String r3 = "rw"
            r2.<init>(r1, r3)     // Catch:{ NumberFormatException -> 0x0190, MalformedURLException -> 0x0179, IOException -> 0x0161, all -> 0x015c }
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ NumberFormatException -> 0x0158, MalformedURLException -> 0x0154, IOException -> 0x0150, all -> 0x014b }
            boolean r3 = r3.isInterrupted()     // Catch:{ NumberFormatException -> 0x0158, MalformedURLException -> 0x0154, IOException -> 0x0150, all -> 0x014b }
            if (r3 == 0) goto L_0x0080
            java.lang.String r11 = f882a     // Catch:{ NumberFormatException -> 0x0158, MalformedURLException -> 0x0154, IOException -> 0x0150, all -> 0x014b }
            java.lang.String r1 = "cancel download"
            android.util.Log.e(r11, r1)     // Catch:{ NumberFormatException -> 0x0158, MalformedURLException -> 0x0154, IOException -> 0x0150, all -> 0x014b }
            r11 = r12
            goto L_0x012d
        L_0x0080:
            java.net.URL r3 = new java.net.URL     // Catch:{ NumberFormatException -> 0x0158, MalformedURLException -> 0x0154, IOException -> 0x0150, all -> 0x014b }
            r3.<init>(r11)     // Catch:{ NumberFormatException -> 0x0158, MalformedURLException -> 0x0154, IOException -> 0x0150, all -> 0x014b }
            java.net.URLConnection r11 = r3.openConnection()     // Catch:{ NumberFormatException -> 0x0158, MalformedURLException -> 0x0154, IOException -> 0x0150, all -> 0x014b }
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ NumberFormatException -> 0x0158, MalformedURLException -> 0x0154, IOException -> 0x0150, all -> 0x014b }
            r3 = 5000(0x1388, float:7.006E-42)
            r11.setConnectTimeout(r3)     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            r3 = 10000(0x2710, float:1.4013E-41)
            r11.setReadTimeout(r3)     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            r11.connect()     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            java.lang.String r3 = "Content-Length"
            java.lang.String r3 = r11.getHeaderField(r3)     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            long r3 = java.lang.Long.parseLong(r3)     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0117
            java.lang.Thread r7 = java.lang.Thread.currentThread()     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            boolean r7 = r7.isInterrupted()     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            if (r7 == 0) goto L_0x00bb
            java.lang.String r1 = f882a     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            java.lang.String r3 = "cancel download"
            android.util.Log.e(r1, r3)     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            goto L_0x012d
        L_0x00bb:
            long r7 = net.fxgear.fitnshop.h.a((java.io.File) r1)     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x00cc
            java.lang.String r1 = f882a     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            java.lang.String r3 = "ERROR :: insufficient space"
            android.util.Log.e(r1, r3)     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            goto L_0x012d
        L_0x00cc:
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            java.io.InputStream r8 = r11.getInputStream()     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            r7.<init>(r8)     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            r12 = 0
        L_0x00da:
            int r8 = r7.read(r1)     // Catch:{ NumberFormatException -> 0x0112, MalformedURLException -> 0x010d, IOException -> 0x0108, all -> 0x0103 }
            r9 = -1
            if (r8 == r9) goto L_0x0100
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ NumberFormatException -> 0x0112, MalformedURLException -> 0x010d, IOException -> 0x0108, all -> 0x0103 }
            boolean r9 = r9.isInterrupted()     // Catch:{ NumberFormatException -> 0x0112, MalformedURLException -> 0x010d, IOException -> 0x0108, all -> 0x0103 }
            if (r9 == 0) goto L_0x00f3
            java.lang.String r12 = f882a     // Catch:{ NumberFormatException -> 0x0112, MalformedURLException -> 0x010d, IOException -> 0x0108, all -> 0x0103 }
            java.lang.String r1 = "cancel download"
            android.util.Log.e(r12, r1)     // Catch:{ NumberFormatException -> 0x0112, MalformedURLException -> 0x010d, IOException -> 0x0108, all -> 0x0103 }
            goto L_0x0101
        L_0x00f3:
            if (r8 <= 0) goto L_0x00fa
            r2.write(r1, r0, r8)     // Catch:{ NumberFormatException -> 0x0112, MalformedURLException -> 0x010d, IOException -> 0x0108, all -> 0x0103 }
            long r8 = (long) r8
            long r5 = r5 + r8
        L_0x00fa:
            int r8 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x00da
            r12 = 1
            goto L_0x00da
        L_0x0100:
            r0 = r12
        L_0x0101:
            r12 = r7
            goto L_0x012d
        L_0x0103:
            r12 = move-exception
            r0 = r12
            r12 = r7
            goto L_0x01af
        L_0x0108:
            r12 = move-exception
            r1 = r12
            r12 = r7
            goto L_0x0165
        L_0x010d:
            r12 = move-exception
            r1 = r12
            r12 = r7
            goto L_0x017d
        L_0x0112:
            r12 = move-exception
            r1 = r12
            r12 = r7
            goto L_0x0194
        L_0x0117:
            java.lang.String r1 = f882a     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            r5.<init>()     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            java.lang.String r6 = "ERROR :: invalid download file length : "
            r5.append(r6)     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            r5.append(r3)     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            java.lang.String r3 = r5.toString()     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            android.util.Log.e(r1, r3)     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
        L_0x012d:
            if (r12 == 0) goto L_0x0135
            r12.close()     // Catch:{ Exception -> 0x0133 }
            goto L_0x0135
        L_0x0133:
            r11 = move-exception
            goto L_0x013f
        L_0x0135:
            if (r11 == 0) goto L_0x013a
            r11.disconnect()     // Catch:{ Exception -> 0x0133 }
        L_0x013a:
            r2.close()     // Catch:{ Exception -> 0x0133 }
            goto L_0x01ec
        L_0x013f:
            r11.printStackTrace()
            goto L_0x01ec
        L_0x0144:
            r1 = move-exception
            goto L_0x0165
        L_0x0146:
            r1 = move-exception
            goto L_0x017d
        L_0x0148:
            r1 = move-exception
            goto L_0x0194
        L_0x014b:
            r11 = move-exception
            r0 = r11
            r11 = r12
            goto L_0x01af
        L_0x0150:
            r11 = move-exception
            r1 = r11
            r11 = r12
            goto L_0x0165
        L_0x0154:
            r11 = move-exception
            r1 = r11
            r11 = r12
            goto L_0x017d
        L_0x0158:
            r11 = move-exception
            r1 = r11
            r11 = r12
            goto L_0x0194
        L_0x015c:
            r11 = move-exception
            r0 = r11
            r11 = r12
            r2 = r11
            goto L_0x01af
        L_0x0161:
            r11 = move-exception
            r1 = r11
            r11 = r12
            r2 = r11
        L_0x0165:
            r1.printStackTrace()     // Catch:{ all -> 0x01ae }
            if (r12 == 0) goto L_0x016d
            r12.close()     // Catch:{ Exception -> 0x0133 }
        L_0x016d:
            if (r11 == 0) goto L_0x0172
            r11.disconnect()     // Catch:{ Exception -> 0x0133 }
        L_0x0172:
            if (r2 == 0) goto L_0x01ec
            r2.close()     // Catch:{ Exception -> 0x0133 }
            goto L_0x01ec
        L_0x0179:
            r11 = move-exception
            r1 = r11
            r11 = r12
            r2 = r11
        L_0x017d:
            r1.printStackTrace()     // Catch:{ all -> 0x01ae }
            if (r12 == 0) goto L_0x0185
            r12.close()     // Catch:{ Exception -> 0x0133 }
        L_0x0185:
            if (r11 == 0) goto L_0x018a
            r11.disconnect()     // Catch:{ Exception -> 0x0133 }
        L_0x018a:
            if (r2 == 0) goto L_0x01ec
            r2.close()     // Catch:{ Exception -> 0x0133 }
            goto L_0x01ec
        L_0x0190:
            r11 = move-exception
            r1 = r11
            r11 = r12
            r2 = r11
        L_0x0194:
            java.lang.String r3 = f882a     // Catch:{ all -> 0x01ae }
            java.lang.String r4 = "ERROR :: invalid download file length."
            android.util.Log.e(r3, r4)     // Catch:{ all -> 0x01ae }
            r1.printStackTrace()     // Catch:{ all -> 0x01ae }
            if (r12 == 0) goto L_0x01a3
            r12.close()     // Catch:{ Exception -> 0x0133 }
        L_0x01a3:
            if (r11 == 0) goto L_0x01a8
            r11.disconnect()     // Catch:{ Exception -> 0x0133 }
        L_0x01a8:
            if (r2 == 0) goto L_0x01ec
            r2.close()     // Catch:{ Exception -> 0x0133 }
            goto L_0x01ec
        L_0x01ae:
            r0 = move-exception
        L_0x01af:
            if (r12 == 0) goto L_0x01b7
            r12.close()     // Catch:{ Exception -> 0x01b5 }
            goto L_0x01b7
        L_0x01b5:
            r11 = move-exception
            goto L_0x01c2
        L_0x01b7:
            if (r11 == 0) goto L_0x01bc
            r11.disconnect()     // Catch:{ Exception -> 0x01b5 }
        L_0x01bc:
            if (r2 == 0) goto L_0x01c5
            r2.close()     // Catch:{ Exception -> 0x01b5 }
            goto L_0x01c5
        L_0x01c2:
            r11.printStackTrace()
        L_0x01c5:
            throw r0
        L_0x01c6:
            java.lang.String r11 = f882a
            java.lang.String r12 = "ERROR :: network disconnected"
            android.util.Log.e(r11, r12)
            goto L_0x01ec
        L_0x01ce:
            java.lang.String r1 = f882a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "ERROR :: param error, url : "
            r2.append(r3)
            r2.append(r11)
            java.lang.String r11 = ", filePath : "
            r2.append(r11)
            r2.append(r12)
            java.lang.String r11 = r2.toString()
            android.util.Log.e(r1, r11)
        L_0x01ec:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.a.c.a(java.lang.String, java.lang.String):boolean");
    }

    public void b() {
        synchronized (this.i) {
            ArrayList<File> b2 = b(this.e);
            if (b2 != null && !b2.isEmpty()) {
                Iterator<File> it = b2.iterator();
                while (it.hasNext()) {
                    File next = it.next();
                    if (next.exists()) {
                        if (next.isFile()) {
                            if (next.delete()) {
                                a(next.getParentFile());
                            }
                        } else if (next.isDirectory()) {
                            a(next);
                        }
                    }
                }
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\a\d.java ==========

package net.fxgear.fitnshop.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import net.fxgear.fitnshop.a.c;

/* compiled from: FXImageCache */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f888a = "d";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f889b;
    /* access modifiers changed from: private */
    public Context c;
    /* access modifiers changed from: private */
    public Handler d;
    private HandlerThread e;
    private HashMap<String, C0031d> f;
    private Object g = new Object();
    private int h;
    private long i;
    private int j;
    private c k;
    private Bitmap l = null;
    private final int m = 1;
    private final int n = 2;
    private Handler.Callback o = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Object obj = message.obj;
                    if (obj == null || !(obj instanceof c)) {
                        return false;
                    }
                    d.this.b((c) obj);
                    return false;
                case 2:
                    if (d.this.e()) {
                        return false;
                    }
                    d.this.f();
                    return false;
                default:
                    return false;
            }
        }
    };
    private Handler p = new Handler();

    /* compiled from: FXImageCache */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final long f898a = ((long) Math.round(((float) Runtime.getRuntime().maxMemory()) * 0.1f));

        /* renamed from: b  reason: collision with root package name */
        public c.a f899b = new c.a();
        public int c = 30;
        public long d = f898a;
        public int e = 3;
    }

    /* renamed from: net.fxgear.fitnshop.a.d$d  reason: collision with other inner class name */
    /* compiled from: FXImageCache */
    private class C0031d {

        /* renamed from: a  reason: collision with root package name */
        String f902a;

        /* renamed from: b  reason: collision with root package name */
        long f903b;
        BitmapDrawable c;

        C0031d(String str, long j, BitmapDrawable bitmapDrawable) {
            this.f902a = str;
            this.f903b = j;
            this.c = bitmapDrawable;
        }
    }

    /* compiled from: FXImageCache */
    private class c {

        /* renamed from: a  reason: collision with root package name */
        String f900a;

        /* renamed from: b  reason: collision with root package name */
        WeakReference<ImageView> f901b;
        Runnable c;
        int d = Integer.MAX_VALUE;
        int e = Integer.MAX_VALUE;
        boolean f = false;
        int g = 0;

        c(String str, ImageView imageView, Runnable runnable) {
            this.f900a = str;
            this.f901b = new WeakReference<>(imageView);
            this.c = runnable;
        }
    }

    /* compiled from: FXImageCache */
    private class a extends BitmapDrawable {

        /* renamed from: a  reason: collision with root package name */
        c f896a;

        a(Bitmap bitmap) {
            super(d.this.c.getResources(), bitmap);
        }
    }

    public d(Context context, String str, b bVar) {
        this.f889b = f888a + "_" + str;
        this.c = context.getApplicationContext();
        if (bVar == null) {
            this.h = 30;
            this.i = b.f898a;
            this.j = 3;
            this.k = new c(context, str);
        } else {
            this.h = bVar.c;
            this.i = bVar.d;
            this.j = bVar.e;
            this.k = new c(context, str, bVar.f899b);
        }
        this.e = new HandlerThread(this.f889b);
        this.e.start();
        this.d = new Handler(this.e.getLooper(), this.o);
        this.f = new HashMap<>();
    }

    public void a() {
        Log.d(this.f889b, "Pause()+");
        if (this.d != null) {
            this.d.removeMessages(1);
            this.d.removeMessages(2);
        }
    }

    public void b() {
        Log.d(this.f889b, "Destroy()+");
        if (this.p != null) {
            this.p.removeCallbacksAndMessages((Object) null);
            this.p = null;
        }
        if (this.d != null) {
            this.d.removeCallbacksAndMessages((Object) null);
            this.d = null;
        }
        if (this.e != null) {
            this.e.quitSafely();
            this.e = null;
        }
        if (this.k != null) {
            this.k.a();
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.l != null) {
            if (!this.l.isRecycled()) {
                this.l.recycle();
            }
            this.l = null;
        }
    }

    public void a(ImageView imageView, String str, Runnable runnable) {
        a(imageView, str, Integer.MAX_VALUE, Integer.MAX_VALUE, runnable);
    }

    public void a(ImageView imageView, String str, int i2, int i3, Runnable runnable) {
        BitmapDrawable bitmapDrawable;
        if (imageView == null) {
            Log.e(this.f889b, "ERROR :: Image view is null.");
        } else if (str == null || str.isEmpty() || str.equalsIgnoreCase("null")) {
            Log.w(this.f889b, "WRANING :: Image URL is invalid.");
            a(imageView);
            imageView.setImageBitmap(this.l);
        } else {
            if (this.f == null || !this.f.containsKey(str)) {
                bitmapDrawable = null;
            } else {
                C0031d dVar = this.f.get(str);
                dVar.f903b = System.currentTimeMillis();
                bitmapDrawable = dVar.c;
            }
            if (bitmapDrawable != null) {
                Log.i(this.f889b, "Hit Image cache.");
                a(imageView, bitmapDrawable, runnable);
            } else if (a(str, imageView)) {
                a aVar = new a(this.l);
                aVar.f896a = new c(str, imageView, runnable);
                aVar.f896a.d = i2;
                aVar.f896a.e = i3;
                a(imageView, (BitmapDrawable) aVar, (Runnable) null);
                a(aVar.f896a);
            }
        }
    }

    private void a(ImageView imageView) {
        Drawable drawable;
        c cVar;
        if (imageView != null && (drawable = imageView.getDrawable()) != null && (drawable instanceof a) && (cVar = ((a) drawable).f896a) != null) {
            cVar.f = true;
        }
    }

    private boolean a(String str, ImageView imageView) {
        Drawable drawable;
        if (!(str == null || imageView == null || (drawable = imageView.getDrawable()) == null || !(drawable instanceof a))) {
            c cVar = ((a) drawable).f896a;
            if (cVar == null) {
                Log.i(this.f889b, "worker is null.");
            } else if (cVar.f900a.equals(str)) {
                return false;
            } else {
                cVar.f = true;
            }
        }
        return true;
    }

    private void a(final c cVar) {
        this.p.post(new Runnable() {
            public void run() {
                if (d.this.d != null) {
                    d.this.d.obtainMessage(1, cVar).sendToTarget();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(final c cVar) {
        String str;
        if (cVar == null) {
            Log.e(this.f889b, "ERROR :: doCachingProcess, wrong param.");
            return;
        }
        String str2 = this.f889b;
        Log.e(str2, "doCachingProcess()+, key : " + cVar.f900a);
        cVar.g = cVar.g + 1;
        if (cVar.g > this.j && this.j != 0) {
            Log.w(this.f889b, "[WARNING] :: Over try_caching_count.");
        } else if (cVar.f || c()) {
            Log.d(this.f889b, "Cancel cache process.");
        } else if (cVar.f900a != null) {
            if (a(cVar.f900a)) {
                str = cVar.f900a;
            } else if (this.k != null) {
                str = this.k.a(cVar.f900a);
            } else {
                Log.e(this.f889b, "ERROR :: DiskCache is null.");
                return;
            }
            if (cVar.f || c()) {
                Log.d(this.f889b, "Cancel cache process.");
            } else if (str == null || str.isEmpty()) {
                Log.e(f888a, "ERROR :: Fail to download image. File path is invalid");
                a(cVar);
            } else if (cVar.f901b.get() != null) {
                File file = new File(str);
                if (!file.exists()) {
                    Log.e(this.f889b, "ERROR :: Cache file not exists.");
                    a(cVar);
                } else if (file.length() == 0) {
                    Log.e(this.f889b, "ERROR :: Cache file size is 0.");
                    file.delete();
                    a(cVar);
                } else {
                    Bitmap a2 = a(str, cVar.d, cVar.e);
                    if (a2 == null || this.c == null) {
                        Log.e(this.f889b, "ERROR :: Fail to load bitmap.");
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(this.c.getResources(), a2);
                    if (this.p != null) {
                        a(cVar.f900a, bitmapDrawable);
                        this.p.post(new Runnable() {
                            public void run() {
                                Drawable drawable;
                                Runnable runnable = cVar.c;
                                ImageView imageView = (ImageView) cVar.f901b.get();
                                if (imageView != null && (drawable = imageView.getDrawable()) != null && (drawable instanceof a) && ((a) drawable).f896a.f900a.equals(cVar.f900a)) {
                                    if (cVar.f) {
                                        Log.d(d.this.f889b, "Cancel cache process on main thread.");
                                    } else {
                                        d.this.a(imageView, bitmapDrawable, runnable);
                                    }
                                }
                            }
                        });
                    }
                }
            } else {
                Log.w(this.f889b, "WARNING :: Lose image view reference.");
            }
        } else {
            Log.e(this.f889b, "ERROR :: Key is null.");
        }
    }

    private boolean a(String str) {
        File file = new File(str);
        return file.exists() && file.isFile();
    }

    private boolean c() {
        return Thread.currentThread().isInterrupted();
    }

    private void a(String str, BitmapDrawable bitmapDrawable) {
        synchronized (this.g) {
            if (str == null || bitmapDrawable == null) {
                Log.e(f888a, "ERROR :: wrong param");
                return;
            }
            if (this.f.containsKey(str)) {
                this.f.remove(str);
            }
            this.f.put(str, new C0031d(str, System.currentTimeMillis(), bitmapDrawable));
            d();
        }
    }

    /* access modifiers changed from: private */
    public void a(ImageView imageView, BitmapDrawable bitmapDrawable, Runnable runnable) {
        if (imageView == null || bitmapDrawable == null) {
            Log.d(this.f889b, "WARNING :: wrong param.");
            return;
        }
        imageView.setImageDrawable(bitmapDrawable);
        if (runnable != null) {
            runnable.run();
        }
    }

    private Bitmap a(String str, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        if (i2 > 0 && i3 > 0) {
            options.inSampleSize = a(options, i2, i3);
        }
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    private int a(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        int i6 = 1;
        if (i4 > i3 || i5 > i2) {
            int i7 = i4 / 2;
            int i8 = i5 / 2;
            while (i7 / i6 > i3 && i8 / i6 > i2) {
                i6 *= 2;
            }
        }
        return i6;
    }

    private long a(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT < 12) {
            return (long) (bitmap.getRowBytes() * bitmap.getHeight());
        }
        return (long) bitmap.getByteCount();
    }

    private long a(BitmapDrawable bitmapDrawable) {
        if (bitmapDrawable != null) {
            return a(bitmapDrawable.getBitmap());
        }
        return 0;
    }

    private void d() {
        if (this.d != null) {
            this.d.removeMessages(2);
            this.d.sendEmptyMessage(2);
        }
    }

    /* access modifiers changed from: private */
    public boolean e() {
        if (this.f == null) {
            return true;
        }
        if (this.h < this.f.size()) {
            Log.d(this.f889b, "Overflow cache size");
            return false;
        }
        long j2 = 0;
        for (String str : this.f.keySet()) {
            j2 += a(this.f.get(str).c);
            if (j2 > this.i) {
                Log.d(this.f889b, "Overflow memory size");
                return false;
            }
        }
        return true;
    }

    private long a(ArrayList<C0031d> arrayList) {
        long j2 = 0;
        if (arrayList != null) {
            Iterator<C0031d> it = arrayList.iterator();
            while (it.hasNext()) {
                j2 += a(it.next().c);
            }
        }
        return j2;
    }

    /* access modifiers changed from: private */
    public void f() {
        Log.i(this.f889b, "RemoveOldMemoryCache()+");
        synchronized (this.g) {
            if (this.f != null) {
                ArrayList arrayList = new ArrayList();
                for (String str : this.f.keySet()) {
                    arrayList.add(this.f.get(str));
                }
                if (!arrayList.isEmpty()) {
                    Collections.sort(arrayList, new Comparator<C0031d>() {
                        /* renamed from: a */
                        public int compare(C0031d dVar, C0031d dVar2) {
                            if (dVar.f903b > dVar2.f903b) {
                                return 1;
                            }
                            return dVar.f903b < dVar2.f903b ? -1 : 0;
                        }
                    });
                }
                while (true) {
                    if (arrayList.size() <= this.h / 2 && a((ArrayList<C0031d>) arrayList) <= this.i / 2) {
                        break;
                    }
                    C0031d dVar = (C0031d) arrayList.get(0);
                    arrayList.remove(dVar);
                    this.f.remove(dVar.f902a);
                }
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\a\e.java ==========

package net.fxgear.fitnshop.a;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.util.LruCache;
import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import net.fxgear.fitnshop.h;
import net.fxgear.util.FXUtil;

/* compiled from: ImageCache */
public class e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Bitmap.CompressFormat f904a = Bitmap.CompressFormat.PNG;

    /* renamed from: b  reason: collision with root package name */
    private b f905b;
    private LruCache<String, BitmapDrawable> c;
    private a d;
    private final Object e = new Object();
    private boolean f = true;
    /* access modifiers changed from: private */
    public Set<SoftReference<Bitmap>> g;

    private e(a aVar) {
        a(aVar);
    }

    public static e a(FragmentManager fragmentManager, a aVar) {
        b a2 = a(fragmentManager);
        e eVar = (e) a2.a();
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e(aVar);
        a2.a(eVar2);
        return eVar2;
    }

    private void a(a aVar) {
        this.d = aVar;
        if (this.d.f) {
            if (h.f1164b.a()) {
                Log.d("ImageCache", "Memory cache created (size = " + this.d.f907a + ")");
            }
            if (j.c()) {
                this.g = Collections.synchronizedSet(new HashSet());
            }
            this.c = new LruCache<String, BitmapDrawable>(this.d.f907a) {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void entryRemoved(boolean z, String str, BitmapDrawable bitmapDrawable, BitmapDrawable bitmapDrawable2) {
                    if (i.class.isInstance(bitmapDrawable)) {
                        ((i) bitmapDrawable).a(false);
                    } else if (j.c()) {
                        e.this.g.add(new SoftReference(bitmapDrawable.getBitmap()));
                    }
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public int sizeOf(String str, BitmapDrawable bitmapDrawable) {
                    int a2 = e.a(bitmapDrawable) / FXUtil.MAX_CUSTOM_FACE_IMAGE_SIZE;
                    if (a2 == 0) {
                        return 1;
                    }
                    return a2;
                }
            };
        }
        if (aVar.h) {
            a();
        }
    }

    public void a() {
        synchronized (this.e) {
            if (this.f905b == null || this.f905b.a()) {
                File file = this.d.c;
                if (this.d.g && file != null) {
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    if (a(file) > ((long) this.d.f908b)) {
                        try {
                            this.f905b = b.a(file, 1, 1, (long) this.d.f908b);
                            if (h.f1164b.a()) {
                                Log.d("ImageCache", "Disk cache initialized");
                            }
                        } catch (IOException e2) {
                            this.d.c = null;
                            Log.e("ImageCache", "initDiskCache - " + e2);
                        }
                    }
                }
            }
            this.f = false;
            this.e.notifyAll();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:24|25|(2:46|47)|48|49) */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0066, code lost:
        if (r1 != null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009f, code lost:
        if (r1 != null) goto L_0x0068;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x00a7 */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0087 A[Catch:{ IOException -> 0x0088, Exception -> 0x006e, all -> 0x006c }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a4 A[SYNTHETIC, Splitter:B:46:0x00a4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r5, android.graphics.drawable.BitmapDrawable r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x00ad
            if (r6 != 0) goto L_0x0006
            goto L_0x00ad
        L_0x0006:
            android.util.LruCache<java.lang.String, android.graphics.drawable.BitmapDrawable> r0 = r4.c
            if (r0 == 0) goto L_0x001e
            java.lang.Class<net.fxgear.fitnshop.a.i> r0 = net.fxgear.fitnshop.a.i.class
            boolean r0 = r0.isInstance(r6)
            if (r0 == 0) goto L_0x0019
            r0 = r6
            net.fxgear.fitnshop.a.i r0 = (net.fxgear.fitnshop.a.i) r0
            r1 = 1
            r0.a(r1)
        L_0x0019:
            android.util.LruCache<java.lang.String, android.graphics.drawable.BitmapDrawable> r0 = r4.c
            r0.put(r5, r6)
        L_0x001e:
            java.lang.Object r0 = r4.e
            monitor-enter(r0)
            net.fxgear.fitnshop.a.b r1 = r4.f905b     // Catch:{ all -> 0x00aa }
            if (r1 == 0) goto L_0x00a8
            java.lang.String r5 = c(r5)     // Catch:{ all -> 0x00aa }
            r1 = 0
            net.fxgear.fitnshop.a.b r2 = r4.f905b     // Catch:{ IOException -> 0x0088, Exception -> 0x006e }
            net.fxgear.fitnshop.a.b$c r2 = r2.a((java.lang.String) r5)     // Catch:{ IOException -> 0x0088, Exception -> 0x006e }
            r3 = 0
            if (r2 != 0) goto L_0x005f
            net.fxgear.fitnshop.a.b r2 = r4.f905b     // Catch:{ IOException -> 0x0088, Exception -> 0x006e }
            net.fxgear.fitnshop.a.b$a r5 = r2.b((java.lang.String) r5)     // Catch:{ IOException -> 0x0088, Exception -> 0x006e }
            if (r5 == 0) goto L_0x0066
            java.io.OutputStream r2 = r5.a((int) r3)     // Catch:{ IOException -> 0x0088, Exception -> 0x006e }
            android.graphics.Bitmap r6 = r6.getBitmap()     // Catch:{ IOException -> 0x005c, Exception -> 0x0059, all -> 0x0056 }
            net.fxgear.fitnshop.a.e$a r1 = r4.d     // Catch:{ IOException -> 0x005c, Exception -> 0x0059, all -> 0x0056 }
            android.graphics.Bitmap$CompressFormat r1 = r1.d     // Catch:{ IOException -> 0x005c, Exception -> 0x0059, all -> 0x0056 }
            net.fxgear.fitnshop.a.e$a r3 = r4.d     // Catch:{ IOException -> 0x005c, Exception -> 0x0059, all -> 0x0056 }
            int r3 = r3.e     // Catch:{ IOException -> 0x005c, Exception -> 0x0059, all -> 0x0056 }
            r6.compress(r1, r3, r2)     // Catch:{ IOException -> 0x005c, Exception -> 0x0059, all -> 0x0056 }
            r5.a()     // Catch:{ IOException -> 0x005c, Exception -> 0x0059, all -> 0x0056 }
            r2.close()     // Catch:{ IOException -> 0x005c, Exception -> 0x0059, all -> 0x0056 }
            r1 = r2
            goto L_0x0066
        L_0x0056:
            r5 = move-exception
            r1 = r2
            goto L_0x00a2
        L_0x0059:
            r5 = move-exception
            r1 = r2
            goto L_0x006f
        L_0x005c:
            r5 = move-exception
            r1 = r2
            goto L_0x0089
        L_0x005f:
            java.io.InputStream r5 = r2.a(r3)     // Catch:{ IOException -> 0x0088, Exception -> 0x006e }
            r5.close()     // Catch:{ IOException -> 0x0088, Exception -> 0x006e }
        L_0x0066:
            if (r1 == 0) goto L_0x00a8
        L_0x0068:
            r1.close()     // Catch:{ IOException -> 0x00a8 }
            goto L_0x00a8
        L_0x006c:
            r5 = move-exception
            goto L_0x00a2
        L_0x006e:
            r5 = move-exception
        L_0x006f:
            java.lang.String r6 = "ImageCache"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
            r2.<init>()     // Catch:{ all -> 0x006c }
            java.lang.String r3 = "addBitmapToCache - "
            r2.append(r3)     // Catch:{ all -> 0x006c }
            r2.append(r5)     // Catch:{ all -> 0x006c }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x006c }
            android.util.Log.e(r6, r5)     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x00a8
            goto L_0x0068
        L_0x0088:
            r5 = move-exception
        L_0x0089:
            java.lang.String r6 = "ImageCache"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
            r2.<init>()     // Catch:{ all -> 0x006c }
            java.lang.String r3 = "addBitmapToCache - "
            r2.append(r3)     // Catch:{ all -> 0x006c }
            r2.append(r5)     // Catch:{ all -> 0x006c }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x006c }
            android.util.Log.e(r6, r5)     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x00a8
            goto L_0x0068
        L_0x00a2:
            if (r1 == 0) goto L_0x00a7
            r1.close()     // Catch:{ IOException -> 0x00a7 }
        L_0x00a7:
            throw r5     // Catch:{ all -> 0x00aa }
        L_0x00a8:
            monitor-exit(r0)     // Catch:{ all -> 0x00aa }
            return
        L_0x00aa:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00aa }
            throw r5
        L_0x00ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.a.e.a(java.lang.String, android.graphics.drawable.BitmapDrawable):void");
    }

    public BitmapDrawable a(String str) {
        BitmapDrawable bitmapDrawable = this.c != null ? this.c.get(str) : null;
        if (h.f1164b.a() && bitmapDrawable != null) {
            Log.d("ImageCache", "Memory cache hit");
        }
        return bitmapDrawable;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0007 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x007c */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0007 A[LOOP:0: B:2:0x0007->B:53:0x0007, LOOP_START, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0072 A[SYNTHETIC, Splitter:B:39:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0079 A[SYNTHETIC, Splitter:B:43:0x0079] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap b(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r8 = c(r8)
            java.lang.Object r0 = r7.e
            monitor-enter(r0)
        L_0x0007:
            boolean r1 = r7.f     // Catch:{ all -> 0x007f }
            if (r1 == 0) goto L_0x0011
            java.lang.Object r1 = r7.e     // Catch:{ InterruptedException -> 0x0007 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0007 }
            goto L_0x0007
        L_0x0011:
            net.fxgear.fitnshop.a.b r1 = r7.f905b     // Catch:{ all -> 0x007f }
            r2 = 0
            if (r1 == 0) goto L_0x007d
            net.fxgear.fitnshop.a.b r1 = r7.f905b     // Catch:{ IOException -> 0x0058, all -> 0x0055 }
            net.fxgear.fitnshop.a.b$c r8 = r1.a((java.lang.String) r8)     // Catch:{ IOException -> 0x0058, all -> 0x0055 }
            if (r8 == 0) goto L_0x004e
            net.fxgear.fitnshop.g r1 = net.fxgear.fitnshop.h.f1164b     // Catch:{ IOException -> 0x0058, all -> 0x0055 }
            boolean r1 = r1.a()     // Catch:{ IOException -> 0x0058, all -> 0x0055 }
            if (r1 == 0) goto L_0x002d
            java.lang.String r1 = "ImageCache"
            java.lang.String r3 = "Disk cache hit"
            android.util.Log.d(r1, r3)     // Catch:{ IOException -> 0x0058, all -> 0x0055 }
        L_0x002d:
            r1 = 0
            java.io.InputStream r8 = r8.a(r1)     // Catch:{ IOException -> 0x0058, all -> 0x0055 }
            if (r8 == 0) goto L_0x004f
            r1 = r8
            java.io.FileInputStream r1 = (java.io.FileInputStream) r1     // Catch:{ IOException -> 0x0049, all -> 0x0044 }
            java.io.FileDescriptor r1 = r1.getFD()     // Catch:{ IOException -> 0x0049, all -> 0x0044 }
            r3 = 2147483647(0x7fffffff, float:NaN)
            android.graphics.Bitmap r1 = net.fxgear.fitnshop.a.g.a(r1, r3, r3, r7)     // Catch:{ IOException -> 0x0049, all -> 0x0044 }
            r2 = r1
            goto L_0x004f
        L_0x0044:
            r1 = move-exception
            r6 = r1
            r1 = r8
            r8 = r6
            goto L_0x0077
        L_0x0049:
            r1 = move-exception
            r6 = r1
            r1 = r8
            r8 = r6
            goto L_0x005a
        L_0x004e:
            r8 = r2
        L_0x004f:
            if (r8 == 0) goto L_0x007d
            r8.close()     // Catch:{ IOException -> 0x007d }
            goto L_0x007d
        L_0x0055:
            r8 = move-exception
            r1 = r2
            goto L_0x0077
        L_0x0058:
            r8 = move-exception
            r1 = r2
        L_0x005a:
            java.lang.String r3 = "ImageCache"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r4.<init>()     // Catch:{ all -> 0x0076 }
            java.lang.String r5 = "getBitmapFromDiskCache - "
            r4.append(r5)     // Catch:{ all -> 0x0076 }
            r4.append(r8)     // Catch:{ all -> 0x0076 }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x0076 }
            android.util.Log.e(r3, r8)     // Catch:{ all -> 0x0076 }
            if (r1 == 0) goto L_0x007d
            r1.close()     // Catch:{ IOException -> 0x007d }
            goto L_0x007d
        L_0x0076:
            r8 = move-exception
        L_0x0077:
            if (r1 == 0) goto L_0x007c
            r1.close()     // Catch:{ IOException -> 0x007c }
        L_0x007c:
            throw r8     // Catch:{ all -> 0x007f }
        L_0x007d:
            monitor-exit(r0)     // Catch:{ all -> 0x007f }
            return r2
        L_0x007f:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007f }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.a.e.b(java.lang.String):android.graphics.Bitmap");
    }

    /* access modifiers changed from: protected */
    public Bitmap a(BitmapFactory.Options options) {
        Bitmap bitmap = null;
        if (this.g != null && !this.g.isEmpty()) {
            synchronized (this.g) {
                Iterator<SoftReference<Bitmap>> it = this.g.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Bitmap bitmap2 = (Bitmap) it.next().get();
                    if (bitmap2 == null || !bitmap2.isMutable()) {
                        it.remove();
                    } else if (a(bitmap2, options)) {
                        it.remove();
                        bitmap = bitmap2;
                        break;
                    }
                }
            }
        }
        return bitmap;
    }

    /* access modifiers changed from: protected */
    public b b() {
        return this.f905b;
    }

    public void c() {
        if (this.c != null) {
            this.c.evictAll();
            if (h.f1164b.a()) {
                Log.d("ImageCache", "Memory cache cleared");
            }
        }
        synchronized (this.e) {
            this.f = true;
            if (this.f905b != null && !this.f905b.a()) {
                try {
                    this.f905b.c();
                    if (h.f1164b.a()) {
                        Log.d("ImageCache", "Disk cache cleared");
                    }
                } catch (IOException e2) {
                    Log.e("ImageCache", "clearCache - " + e2);
                }
                this.f905b = null;
                a();
            }
        }
    }

    public void d() {
        synchronized (this.e) {
            if (this.f905b != null) {
                try {
                    this.f905b.b();
                    if (h.f1164b.a()) {
                        Log.d("ImageCache", "Disk cache flushed");
                    }
                } catch (IOException e2) {
                    Log.e("ImageCache", "flush - " + e2);
                }
            }
        }
    }

    public void e() {
        synchronized (this.e) {
            if (this.f905b != null) {
                try {
                    if (!this.f905b.a()) {
                        this.f905b.close();
                        this.f905b = null;
                        if (h.f1164b.a()) {
                            Log.d("ImageCache", "Disk cache closed");
                        }
                    }
                } catch (IOException e2) {
                    Log.e("ImageCache", "close - " + e2);
                }
            }
        }
    }

    /* compiled from: ImageCache */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f907a = 5120;

        /* renamed from: b  reason: collision with root package name */
        public int f908b = 10485760;
        public File c;
        public Bitmap.CompressFormat d = e.f904a;
        public int e = 70;
        public boolean f = true;
        public boolean g = true;
        public boolean h = false;

        public a(Context context, String str) {
            this.c = e.a(context, str);
        }

        public void a(float f2) {
            if (f2 < 0.01f || f2 > 0.8f) {
                throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.01 and 0.8 (inclusive)");
            }
            this.f907a = Math.round((f2 * ((float) Runtime.getRuntime().maxMemory())) / 1024.0f);
        }
    }

    @TargetApi(19)
    private static boolean a(Bitmap bitmap, BitmapFactory.Options options) {
        if (!j.e()) {
            if (bitmap.getWidth() == options.outWidth && bitmap.getHeight() == options.outHeight && options.inSampleSize == 1) {
                return true;
            }
            return false;
        } else if ((options.outWidth / options.inSampleSize) * (options.outHeight / options.inSampleSize) * a(bitmap.getConfig()) <= bitmap.getAllocationByteCount()) {
            return true;
        } else {
            return false;
        }
    }

    private static int a(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888) {
            return 4;
        }
        if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) {
            return 2;
        }
        return config == Bitmap.Config.ALPHA_8 ? 1 : 1;
    }

    public static File a(Context context, String str) {
        String path = (("mounted".equals(Environment.getExternalStorageState()) || !f()) ? a(context) : context.getCacheDir()).getPath();
        return new File(path + File.separator + str);
    }

    public static String c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            return a(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    @TargetApi(19)
    public static int a(BitmapDrawable bitmapDrawable) {
        Bitmap bitmap = bitmapDrawable.getBitmap();
        if (j.e()) {
            return bitmap.getAllocationByteCount();
        }
        if (j.d()) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    @TargetApi(9)
    public static boolean f() {
        if (j.b()) {
            return Environment.isExternalStorageRemovable();
        }
        return true;
    }

    @TargetApi(8)
    public static File a(Context context) {
        File externalCacheDir;
        if (j.a() && (externalCacheDir = context.getExternalCacheDir()) != null) {
            return externalCacheDir;
        }
        return new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/cache/"));
    }

    @TargetApi(9)
    public static long a(File file) {
        return h.a(file);
    }

    private static b a(FragmentManager fragmentManager) {
        b bVar = (b) fragmentManager.findFragmentByTag("ImageCache");
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        fragmentManager.beginTransaction().add(bVar2, "ImageCache").commitAllowingStateLoss();
        return bVar2;
    }

    /* compiled from: ImageCache */
    public static class b extends Fragment {

        /* renamed from: a  reason: collision with root package name */
        private Object f909a;

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
        }

        public void a(Object obj) {
            this.f909a = obj;
        }

        public Object a() {
            return this.f909a;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\a\f.java ==========

package net.fxgear.fitnshop.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import net.fxgear.fitnshop.h;

/* compiled from: ImageFetcher */
public class f extends g {
    private b e;
    private File f;
    private boolean g = true;
    private final Object h = new Object();
    private boolean i = false;

    public f(Context context, int i2) {
        super(context, i2);
        a(context);
    }

    private void a(Context context) {
        b(context);
        this.f = e.a(context, "http");
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        k();
    }

    private void k() {
        if (!this.f.exists()) {
            this.f.mkdirs();
        }
        synchronized (this.h) {
            if (e.a(this.f) > 10485760) {
                try {
                    this.e = b.a(this.f, 1, 1, 10485760);
                    if (h.f1164b.a()) {
                        Log.d("ImageFetcher", "HTTP cache initialized");
                    }
                } catch (IOException unused) {
                    this.e = null;
                }
            }
            this.g = false;
            this.h.notifyAll();
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        super.b();
        synchronized (this.h) {
            if (this.e != null && !this.e.a()) {
                try {
                    this.e.c();
                    if (h.f1164b.a()) {
                        Log.d("ImageFetcher", "HTTP cache cleared");
                    }
                } catch (IOException e2) {
                    Log.e("ImageFetcher", "clearCacheInternal - " + e2);
                }
                this.e = null;
                this.g = true;
                k();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
        super.c();
        synchronized (this.h) {
            if (this.e != null) {
                try {
                    this.e.b();
                    if (h.f1164b.a()) {
                        Log.d("ImageFetcher", "HTTP cache flushed");
                    }
                } catch (IOException e2) {
                    Log.e("ImageFetcher", "flush - " + e2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        synchronized (this.h) {
            if (this.e != null) {
                try {
                    if (!this.e.a()) {
                        this.e.close();
                        this.e = null;
                        if (h.f1164b.a()) {
                            Log.d("ImageFetcher", "HTTP cache closed");
                        }
                    }
                } catch (IOException e2) {
                    Log.e("ImageFetcher", "closeCacheInternal - " + e2);
                }
            }
        }
    }

    private void b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            Log.e("ImageFetcher", "checkConnection - no connection found");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: net.fxgear.fitnshop.a.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: net.fxgear.fitnshop.a.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v33, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v34, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: type inference failed for: r2v31 */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d7, code lost:
        if (r2 != null) goto L_0x00d9;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0025 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x00e5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00be A[Catch:{ IOException -> 0x00bf, IllegalStateException -> 0x00a4, all -> 0x00a1, all -> 0x00df }] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0025 A[LOOP:0: B:5:0x0025->B:101:0x0025, LOOP_START, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e2 A[SYNTHETIC, Splitter:B:66:0x00e2] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00eb A[SYNTHETIC, Splitter:B:74:0x00eb] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0112 A[SYNTHETIC, Splitter:B:91:0x0112] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap a(java.lang.String r9) {
        /*
            r8 = this;
            net.fxgear.fitnshop.g r0 = net.fxgear.fitnshop.h.f1164b
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x001e
            java.lang.String r0 = "ImageFetcher"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "processBitmap - "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
        L_0x001e:
            java.lang.String r0 = net.fxgear.fitnshop.a.e.c(r9)
            java.lang.Object r1 = r8.h
            monitor-enter(r1)
        L_0x0025:
            boolean r2 = r8.g     // Catch:{ all -> 0x011e }
            if (r2 == 0) goto L_0x002f
            java.lang.Object r2 = r8.h     // Catch:{ InterruptedException -> 0x0025 }
            r2.wait()     // Catch:{ InterruptedException -> 0x0025 }
            goto L_0x0025
        L_0x002f:
            boolean r2 = r8.i     // Catch:{ all -> 0x011e }
            if (r2 == 0) goto L_0x0036
            net.fxgear.fitnshop.a.b r2 = r8.e     // Catch:{ all -> 0x011e }
            goto L_0x0044
        L_0x0036:
            net.fxgear.fitnshop.a.e r2 = r8.h()     // Catch:{ all -> 0x011e }
            if (r2 == 0) goto L_0x0116
            net.fxgear.fitnshop.a.e r2 = r8.h()     // Catch:{ all -> 0x011e }
            net.fxgear.fitnshop.a.b r2 = r2.b()     // Catch:{ all -> 0x011e }
        L_0x0044:
            r3 = 0
            if (r2 == 0) goto L_0x00e6
            net.fxgear.fitnshop.a.b$c r4 = r2.a((java.lang.String) r0)     // Catch:{ IOException -> 0x00bf, IllegalStateException -> 0x00a4, all -> 0x00a1 }
            r5 = 0
            if (r4 != 0) goto L_0x007b
            net.fxgear.fitnshop.g r4 = net.fxgear.fitnshop.h.f1164b     // Catch:{ IOException -> 0x00bf, IllegalStateException -> 0x00a4, all -> 0x00a1 }
            boolean r4 = r4.a()     // Catch:{ IOException -> 0x00bf, IllegalStateException -> 0x00a4, all -> 0x00a1 }
            if (r4 == 0) goto L_0x005d
            java.lang.String r4 = "ImageFetcher"
            java.lang.String r6 = "processBitmap, not found in http cache, downloading..."
            android.util.Log.d(r4, r6)     // Catch:{ IOException -> 0x00bf, IllegalStateException -> 0x00a4, all -> 0x00a1 }
        L_0x005d:
            net.fxgear.fitnshop.a.b$a r4 = r2.b((java.lang.String) r0)     // Catch:{ IOException -> 0x00bf, IllegalStateException -> 0x00a4, all -> 0x00a1 }
            if (r4 == 0) goto L_0x0077
            java.io.OutputStream r6 = r4.a((int) r5)     // Catch:{ IOException -> 0x00bf, IllegalStateException -> 0x00a4, all -> 0x00a1 }
            boolean r9 = r8.a(r9, r6)     // Catch:{ IOException -> 0x00bf, IllegalStateException -> 0x00a4, all -> 0x00a1 }
            if (r9 == 0) goto L_0x0071
            r4.a()     // Catch:{ IOException -> 0x00bf, IllegalStateException -> 0x00a4, all -> 0x00a1 }
            goto L_0x0077
        L_0x0071:
            r4.b()     // Catch:{ IOException -> 0x00bf, IllegalStateException -> 0x00a4, all -> 0x00a1 }
            r4.c()     // Catch:{ IOException -> 0x00bf, IllegalStateException -> 0x00a4, all -> 0x00a1 }
        L_0x0077:
            net.fxgear.fitnshop.a.b$c r4 = r2.a((java.lang.String) r0)     // Catch:{ IOException -> 0x00bf, IllegalStateException -> 0x00a4, all -> 0x00a1 }
        L_0x007b:
            if (r4 == 0) goto L_0x0097
            java.io.InputStream r9 = r4.a(r5)     // Catch:{ IOException -> 0x00bf, IllegalStateException -> 0x00a4, all -> 0x00a1 }
            java.io.FileInputStream r9 = (java.io.FileInputStream) r9     // Catch:{ IOException -> 0x00bf, IllegalStateException -> 0x00a4, all -> 0x00a1 }
            java.io.FileDescriptor r2 = r9.getFD()     // Catch:{ IOException -> 0x0092, IllegalStateException -> 0x008d, all -> 0x0088 }
            goto L_0x0099
        L_0x0088:
            r0 = move-exception
            r2 = r9
            r9 = r0
            goto L_0x00e0
        L_0x008d:
            r2 = move-exception
            r7 = r2
            r2 = r9
            r9 = r7
            goto L_0x00a6
        L_0x0092:
            r2 = move-exception
            r7 = r2
            r2 = r9
            r9 = r7
            goto L_0x00c1
        L_0x0097:
            r9 = r3
            r2 = r9
        L_0x0099:
            if (r2 != 0) goto L_0x00e8
            if (r9 == 0) goto L_0x00e8
            r9.close()     // Catch:{ IOException -> 0x00e8 }
            goto L_0x00e8
        L_0x00a1:
            r9 = move-exception
            r2 = r3
            goto L_0x00e0
        L_0x00a4:
            r9 = move-exception
            r2 = r3
        L_0x00a6:
            java.lang.String r4 = "ImageFetcher"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00df }
            r5.<init>()     // Catch:{ all -> 0x00df }
            java.lang.String r6 = "processBitmap - "
            r5.append(r6)     // Catch:{ all -> 0x00df }
            r5.append(r9)     // Catch:{ all -> 0x00df }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x00df }
            android.util.Log.e(r4, r9)     // Catch:{ all -> 0x00df }
            if (r2 == 0) goto L_0x00dc
            goto L_0x00d9
        L_0x00bf:
            r9 = move-exception
            r2 = r3
        L_0x00c1:
            java.lang.String r4 = "ImageFetcher"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00df }
            r5.<init>()     // Catch:{ all -> 0x00df }
            java.lang.String r6 = "processBitmap - "
            r5.append(r6)     // Catch:{ all -> 0x00df }
            r5.append(r9)     // Catch:{ all -> 0x00df }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x00df }
            android.util.Log.e(r4, r9)     // Catch:{ all -> 0x00df }
            if (r2 == 0) goto L_0x00dc
        L_0x00d9:
            r2.close()     // Catch:{ IOException -> 0x00dc }
        L_0x00dc:
            r9 = r2
            r2 = r3
            goto L_0x00e8
        L_0x00df:
            r9 = move-exception
        L_0x00e0:
            if (r2 == 0) goto L_0x00e5
            r2.close()     // Catch:{ IOException -> 0x00e5 }
        L_0x00e5:
            throw r9     // Catch:{ all -> 0x011e }
        L_0x00e6:
            r9 = r3
            r2 = r9
        L_0x00e8:
            monitor-exit(r1)     // Catch:{ all -> 0x011e }
            if (r2 == 0) goto L_0x010f
            int r1 = r8.f910a     // Catch:{ IllegalArgumentException -> 0x00f8 }
            int r4 = r8.f911b     // Catch:{ IllegalArgumentException -> 0x00f8 }
            net.fxgear.fitnshop.a.e r5 = r8.h()     // Catch:{ IllegalArgumentException -> 0x00f8 }
            android.graphics.Bitmap r1 = a(r2, r1, r4, r5)     // Catch:{ IllegalArgumentException -> 0x00f8 }
            goto L_0x0110
        L_0x00f8:
            r1 = move-exception
            r1.printStackTrace()
            java.lang.Object r1 = r8.h
            monitor-enter(r1)
            net.fxgear.fitnshop.a.b r2 = r8.e     // Catch:{ IOException -> 0x0107 }
            r2.c((java.lang.String) r0)     // Catch:{ IOException -> 0x0107 }
            goto L_0x010b
        L_0x0105:
            r9 = move-exception
            goto L_0x010d
        L_0x0107:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0105 }
        L_0x010b:
            monitor-exit(r1)     // Catch:{ all -> 0x0105 }
            goto L_0x010f
        L_0x010d:
            monitor-exit(r1)     // Catch:{ all -> 0x0105 }
            throw r9
        L_0x010f:
            r1 = r3
        L_0x0110:
            if (r9 == 0) goto L_0x0115
            r9.close()     // Catch:{ IOException -> 0x0115 }
        L_0x0115:
            return r1
        L_0x0116:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x011e }
            java.lang.String r0 = "imageCache null"
            r9.<init>(r0)     // Catch:{ all -> 0x011e }
            throw r9     // Catch:{ all -> 0x011e }
        L_0x011e:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x011e }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.a.f.a(java.lang.String):android.graphics.Bitmap");
    }

    /* access modifiers changed from: protected */
    public Bitmap a(Object obj) {
        return a(String.valueOf(obj));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.BufferedOutputStream} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x009d A[SYNTHETIC, Splitter:B:51:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a2 A[Catch:{ IOException -> 0x00a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b0 A[SYNTHETIC, Splitter:B:63:0x00b0] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b5 A[Catch:{ IOException -> 0x00b8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r7, java.io.OutputStream r8) {
        /*
            r6 = this;
            e()
            r0 = 0
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x007d, all -> 0x0079 }
            r2.<init>(r7)     // Catch:{ IOException -> 0x007d, all -> 0x0079 }
            java.net.URLConnection r7 = r2.openConnection()     // Catch:{ IOException -> 0x007d, all -> 0x0079 }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ IOException -> 0x007d, all -> 0x0079 }
            int r2 = r7.getResponseCode()     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 1
            if (r2 == r3) goto L_0x0027
            r3 = 302(0x12e, float:4.23E-43)
            if (r2 == r3) goto L_0x0025
            r3 = 301(0x12d, float:4.22E-43)
            if (r2 == r3) goto L_0x0025
            r3 = 303(0x12f, float:4.25E-43)
            if (r2 != r3) goto L_0x0027
        L_0x0025:
            r2 = 1
            goto L_0x0028
        L_0x0027:
            r2 = 0
        L_0x0028:
            if (r2 == 0) goto L_0x0041
            if (r7 == 0) goto L_0x002f
            r7.disconnect()     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
        L_0x002f:
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            java.lang.String r3 = "Location"
            java.lang.String r3 = r7.getHeaderField(r3)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r7 = r2
        L_0x0041:
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            java.io.InputStream r3 = r7.getInputStream()     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r5 = 8192(0x2000, float:1.14794E-41)
            r2.<init>(r3, r5)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            r3.<init>(r8, r5)     // Catch:{ IOException -> 0x006e, all -> 0x006c }
        L_0x0051:
            int r8 = r2.read()     // Catch:{ IOException -> 0x006a, all -> 0x0068 }
            r1 = -1
            if (r8 == r1) goto L_0x005c
            r3.write(r8)     // Catch:{ IOException -> 0x006a, all -> 0x0068 }
            goto L_0x0051
        L_0x005c:
            if (r7 == 0) goto L_0x0061
            r7.disconnect()
        L_0x0061:
            r3.close()     // Catch:{ IOException -> 0x0067 }
            r2.close()     // Catch:{ IOException -> 0x0067 }
        L_0x0067:
            return r4
        L_0x0068:
            r8 = move-exception
            goto L_0x00a8
        L_0x006a:
            r8 = move-exception
            goto L_0x0077
        L_0x006c:
            r8 = move-exception
            goto L_0x00a9
        L_0x006e:
            r8 = move-exception
            r3 = r1
            goto L_0x0077
        L_0x0071:
            r8 = move-exception
            r2 = r1
            goto L_0x00a9
        L_0x0074:
            r8 = move-exception
            r2 = r1
            r3 = r2
        L_0x0077:
            r1 = r7
            goto L_0x0080
        L_0x0079:
            r8 = move-exception
            r7 = r1
            r2 = r7
            goto L_0x00a9
        L_0x007d:
            r8 = move-exception
            r2 = r1
            r3 = r2
        L_0x0080:
            java.lang.String r7 = "ImageFetcher"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r4.<init>()     // Catch:{ all -> 0x00a6 }
            java.lang.String r5 = "Error in downloadBitmap - "
            r4.append(r5)     // Catch:{ all -> 0x00a6 }
            r4.append(r8)     // Catch:{ all -> 0x00a6 }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x00a6 }
            android.util.Log.e(r7, r8)     // Catch:{ all -> 0x00a6 }
            if (r1 == 0) goto L_0x009b
            r1.disconnect()
        L_0x009b:
            if (r3 == 0) goto L_0x00a0
            r3.close()     // Catch:{ IOException -> 0x00a5 }
        L_0x00a0:
            if (r2 == 0) goto L_0x00a5
            r2.close()     // Catch:{ IOException -> 0x00a5 }
        L_0x00a5:
            return r0
        L_0x00a6:
            r8 = move-exception
            r7 = r1
        L_0x00a8:
            r1 = r3
        L_0x00a9:
            if (r7 == 0) goto L_0x00ae
            r7.disconnect()
        L_0x00ae:
            if (r1 == 0) goto L_0x00b3
            r1.close()     // Catch:{ IOException -> 0x00b8 }
        L_0x00b3:
            if (r2 == 0) goto L_0x00b8
            r2.close()     // Catch:{ IOException -> 0x00b8 }
        L_0x00b8:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.a.f.a(java.lang.String, java.io.OutputStream):boolean");
    }

    public static void e() {
        if (Build.VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\a\g.java ==========

package net.fxgear.fitnshop.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;
import java.io.FileDescriptor;
import net.fxgear.fitnshop.h;

/* compiled from: ImageResizer */
public class g extends h {

    /* renamed from: a  reason: collision with root package name */
    protected int f910a;

    /* renamed from: b  reason: collision with root package name */
    protected int f911b;

    public g(Context context, int i) {
        super(context);
        a(i);
    }

    public void a(int i, int i2) {
        this.f910a = i;
        this.f911b = i2;
    }

    public void a(int i) {
        a(i, i);
    }

    private Bitmap b(int i) {
        if (h.f1164b.a()) {
            Log.d("ImageResizer", "processBitmap - " + i);
        }
        return a(this.d, i, this.f910a, this.f911b, h());
    }

    /* access modifiers changed from: protected */
    public Bitmap a(Object obj) {
        return b(Integer.parseInt(String.valueOf(obj)));
    }

    public static Bitmap a(Resources resources, int i, int i2, int i3, e eVar) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = a(options, i2, i3);
        if (j.c()) {
            a(options, eVar);
        }
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    public static Bitmap a(FileDescriptor fileDescriptor, int i, int i2, e eVar) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, (Rect) null, options);
        options.inSampleSize = a(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, (Rect) null, options);
    }

    @TargetApi(11)
    private static void a(BitmapFactory.Options options, e eVar) {
        Bitmap a2;
        options.inMutable = true;
        if (eVar != null && (a2 = eVar.a(options)) != null) {
            options.inBitmap = a2;
        }
    }

    public static int a(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 > i2 && i7 / i5 > i) {
                i5 *= 2;
            }
            for (long j = (long) ((i4 * i3) / i5); j > ((long) (i * i2 * 2)); j /= 2) {
                i5 *= 2;
            }
        }
        return i5;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\a\h.java ==========

package net.fxgear.fitnshop.a;

import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.Log;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import net.fxgear.fitnshop.a.e;

/* compiled from: ImageWorker */
public abstract class h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public e f912a;

    /* renamed from: b  reason: collision with root package name */
    private e.a f913b;
    protected boolean c = false;
    protected Resources d;
    private Bitmap e;
    private Bitmap f;
    private Bitmap g;
    private boolean h = true;
    /* access modifiers changed from: private */
    public boolean i = false;
    /* access modifiers changed from: private */
    public final Object j = new Object();
    /* access modifiers changed from: private */
    public boolean k = false;

    /* compiled from: ImageWorker */
    public interface e {
        void a(ImageView imageView);
    }

    /* access modifiers changed from: protected */
    public abstract Bitmap a(Object obj);

    protected h(Context context) {
        this.d = context.getResources();
    }

    public void a(Object obj, ImageView imageView) {
        a(obj, imageView, (e) null);
    }

    public void a(Object obj, ImageView imageView, e eVar) {
        if (obj != null && imageView != null) {
            BitmapDrawable bitmapDrawable = null;
            if (this.f912a != null) {
                bitmapDrawable = this.f912a.a(String.valueOf(obj));
            }
            if (bitmapDrawable != null) {
                imageView.setImageDrawable(bitmapDrawable);
                if (eVar != null) {
                    eVar.a(imageView);
                }
            } else if (b(obj, imageView)) {
                b bVar = new b(obj, imageView, false, eVar);
                imageView.setImageDrawable(new a(this.d, this.f, bVar));
                bVar.a(a.c, (Params[]) new Void[0]);
            }
        }
    }

    public void a(HashMap<String, Object> hashMap, net.fxgear.fitnshop.b bVar) {
        Bitmap bitmap;
        if (hashMap != null && bVar != null) {
            Iterator<String> it = hashMap.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                BitmapDrawable a2 = this.f912a.a(String.valueOf(hashMap.get(next)));
                if (!(a2 == null || (bitmap = a2.getBitmap()) == null || bitmap.isRecycled())) {
                    if (next.equals("key_logo_url") || next.equals("key_background_url")) {
                        bVar.a(next, bitmap);
                        it.remove();
                    } else {
                        Log.e("ImageWorker", "Unknown key.");
                    }
                }
            }
            if (!hashMap.isEmpty() && b(hashMap, bVar)) {
                d dVar = new d(hashMap, bVar);
                bVar.setCacheTask(dVar);
                if (hashMap.containsKey("key_background_url")) {
                    bVar.a("key_background_url", this.g);
                }
                dVar.a(a.c, (Params[]) new Void[0]);
            }
        }
    }

    private void e() {
        Log.d("ImageWorker", "recycleLoadingBitmap()+");
        if (this.e != null) {
            if (!this.e.isRecycled()) {
                this.e.recycle();
            }
            this.e = null;
        }
        if (this.f != null) {
            if (!this.f.isRecycled()) {
                this.f.recycle();
            }
            this.f = null;
        }
        if (this.g != null) {
            if (!this.g.isRecycled()) {
                this.g.recycle();
            }
            this.g = null;
        }
    }

    public void a(FragmentManager fragmentManager, e.a aVar) {
        this.f913b = aVar;
        this.f912a = e.a(fragmentManager, this.f913b);
        new c().c((Params[]) new Object[]{1});
    }

    public void a(boolean z) {
        this.i = z;
        b(false);
    }

    public void f() {
        this.k = false;
    }

    public boolean g() {
        return this.k;
    }

    /* access modifiers changed from: protected */
    public e h() {
        return this.f912a;
    }

    public static boolean b(Object obj, ImageView imageView) {
        b b2 = b(imageView);
        if (b2 == null || b2.d()) {
            return true;
        }
        Object a2 = b2.e;
        if (a2 != null && a2.equals(obj)) {
            return false;
        }
        b2.a(true);
        if (net.fxgear.fitnshop.h.f1164b.a()) {
            Log.d("ImageWorker", "cancelPotentialWork - cancelled work for " + obj);
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static b b(ImageView imageView) {
        if (imageView == null) {
            return null;
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof a) {
            return ((a) drawable).a();
        }
        return null;
    }

    /* compiled from: ImageWorker */
    private class b extends a<Void, Void, BitmapDrawable> {
        /* access modifiers changed from: private */
        public Object e;
        private boolean f;
        private boolean g = false;
        private final WeakReference<ImageView> h;
        private e i;

        public b(Object obj, ImageView imageView, boolean z, e eVar) {
            this.e = obj;
            this.f = z;
            this.h = new WeakReference<>(imageView);
            this.i = eVar;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001c */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x001c A[LOOP:0: B:5:0x001c->B:48:0x001c, LOOP_START, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.graphics.drawable.BitmapDrawable a(java.lang.Void... r4) {
            /*
                r3 = this;
                net.fxgear.fitnshop.g r4 = net.fxgear.fitnshop.h.f1164b
                boolean r4 = r4.a()
                if (r4 == 0) goto L_0x000f
                java.lang.String r4 = "ImageWorker"
                java.lang.String r0 = "doInBackground - starting work"
                android.util.Log.d(r4, r0)
            L_0x000f:
                java.lang.Object r4 = r3.e
                java.lang.String r4 = java.lang.String.valueOf(r4)
                net.fxgear.fitnshop.a.h r0 = net.fxgear.fitnshop.a.h.this
                java.lang.Object r0 = r0.j
                monitor-enter(r0)
            L_0x001c:
                net.fxgear.fitnshop.a.h r1 = net.fxgear.fitnshop.a.h.this     // Catch:{ all -> 0x00b6 }
                boolean r1 = r1.c     // Catch:{ all -> 0x00b6 }
                if (r1 == 0) goto L_0x0032
                boolean r1 = r3.c()     // Catch:{ all -> 0x00b6 }
                if (r1 != 0) goto L_0x0032
                net.fxgear.fitnshop.a.h r1 = net.fxgear.fitnshop.a.h.this     // Catch:{ InterruptedException -> 0x001c }
                java.lang.Object r1 = r1.j     // Catch:{ InterruptedException -> 0x001c }
                r1.wait()     // Catch:{ InterruptedException -> 0x001c }
                goto L_0x001c
            L_0x0032:
                monitor-exit(r0)     // Catch:{ all -> 0x00b6 }
                net.fxgear.fitnshop.a.h r0 = net.fxgear.fitnshop.a.h.this
                net.fxgear.fitnshop.a.e r0 = r0.f912a
                r1 = 0
                if (r0 == 0) goto L_0x005b
                boolean r0 = r3.c()
                if (r0 != 0) goto L_0x005b
                android.widget.ImageView r0 = r3.e()
                if (r0 == 0) goto L_0x005b
                net.fxgear.fitnshop.a.h r0 = net.fxgear.fitnshop.a.h.this
                boolean r0 = r0.i
                if (r0 != 0) goto L_0x005b
                net.fxgear.fitnshop.a.h r0 = net.fxgear.fitnshop.a.h.this
                net.fxgear.fitnshop.a.e r0 = r0.f912a
                android.graphics.Bitmap r0 = r0.b(r4)
                goto L_0x005c
            L_0x005b:
                r0 = r1
            L_0x005c:
                if (r0 != 0) goto L_0x007a
                boolean r2 = r3.c()
                if (r2 != 0) goto L_0x007a
                android.widget.ImageView r2 = r3.e()
                if (r2 == 0) goto L_0x007a
                net.fxgear.fitnshop.a.h r2 = net.fxgear.fitnshop.a.h.this
                boolean r2 = r2.i
                if (r2 != 0) goto L_0x007a
                net.fxgear.fitnshop.a.h r0 = net.fxgear.fitnshop.a.h.this
                java.lang.Object r2 = r3.e
                android.graphics.Bitmap r0 = r0.a((java.lang.Object) r2)
            L_0x007a:
                if (r0 == 0) goto L_0x00a6
                boolean r1 = net.fxgear.fitnshop.a.j.c()
                if (r1 == 0) goto L_0x008c
                android.graphics.drawable.BitmapDrawable r1 = new android.graphics.drawable.BitmapDrawable
                net.fxgear.fitnshop.a.h r2 = net.fxgear.fitnshop.a.h.this
                android.content.res.Resources r2 = r2.d
                r1.<init>(r2, r0)
                goto L_0x0095
            L_0x008c:
                net.fxgear.fitnshop.a.i r1 = new net.fxgear.fitnshop.a.i
                net.fxgear.fitnshop.a.h r2 = net.fxgear.fitnshop.a.h.this
                android.content.res.Resources r2 = r2.d
                r1.<init>(r2, r0)
            L_0x0095:
                net.fxgear.fitnshop.a.h r0 = net.fxgear.fitnshop.a.h.this
                net.fxgear.fitnshop.a.e r0 = r0.f912a
                if (r0 == 0) goto L_0x00a6
                net.fxgear.fitnshop.a.h r0 = net.fxgear.fitnshop.a.h.this
                net.fxgear.fitnshop.a.e r0 = r0.f912a
                r0.a((java.lang.String) r4, (android.graphics.drawable.BitmapDrawable) r1)
            L_0x00a6:
                net.fxgear.fitnshop.g r4 = net.fxgear.fitnshop.h.f1164b
                boolean r4 = r4.a()
                if (r4 == 0) goto L_0x00b5
                java.lang.String r4 = "ImageWorker"
                java.lang.String r0 = "doInBackground - finished work"
                android.util.Log.d(r4, r0)
            L_0x00b5:
                return r1
            L_0x00b6:
                r4 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00b6 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.a.h.b.a(java.lang.Void[]):android.graphics.drawable.BitmapDrawable");
        }

        /* access modifiers changed from: protected */
        public void a(BitmapDrawable bitmapDrawable) {
            if (c() || h.this.i) {
                this.g = true;
                if (!h.this.k) {
                    boolean unused = h.this.k = true;
                }
                bitmapDrawable = null;
            }
            ImageView e2 = e();
            if (!(bitmapDrawable == null || e2 == null)) {
                if (net.fxgear.fitnshop.h.f1164b.a()) {
                    Log.d("ImageWorker", "onPostExecute - setting bitmap");
                }
                h.this.a(e2, (Drawable) bitmapDrawable, this.f);
                if (this.i != null) {
                    this.i.a(e2);
                }
            }
            this.i = null;
        }

        /* access modifiers changed from: protected */
        public void b(BitmapDrawable bitmapDrawable) {
            super.b(bitmapDrawable);
            this.i = null;
            synchronized (h.this.j) {
                h.this.j.notifyAll();
            }
        }

        /* access modifiers changed from: private */
        public boolean d() {
            return this.g;
        }

        private ImageView e() {
            ImageView imageView = (ImageView) this.h.get();
            if (this == h.b(imageView)) {
                return imageView;
            }
            return null;
        }
    }

    public static boolean b(HashMap<String, Object> hashMap, net.fxgear.fitnshop.b bVar) {
        boolean z;
        d b2 = b(bVar);
        if (hashMap == null || b2 == null || b2.d()) {
            return true;
        }
        HashMap b3 = b2.f;
        if (b3 != null) {
            Iterator<String> it = hashMap.keySet().iterator();
            while (true) {
                if (it != null && it.hasNext()) {
                    if (!b3.containsValue(hashMap.get(it.next()))) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                }
            }
            z = true;
            if (z) {
                Log.e("ImageWorker", "cancelPotentialWork(), return false");
                return false;
            }
        }
        b2.a(true);
        return true;
    }

    /* access modifiers changed from: private */
    public static d b(net.fxgear.fitnshop.b bVar) {
        Object cacheTask;
        if (bVar == null || (cacheTask = bVar.getCacheTask()) == null || !(cacheTask instanceof d)) {
            return null;
        }
        return (d) cacheTask;
    }

    /* compiled from: ImageWorker */
    private class d extends a<Void, Void, Boolean> {
        private boolean e = false;
        /* access modifiers changed from: private */
        public HashMap<String, Object> f;
        private HashMap<String, BitmapDrawable> g;
        private final WeakReference<net.fxgear.fitnshop.b> h;

        public d(HashMap<String, Object> hashMap, net.fxgear.fitnshop.b bVar) {
            this.f = hashMap;
            this.h = new WeakReference<>(bVar);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0016 */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x0016 A[LOOP:0: B:5:0x0016->B:52:0x0016, LOOP_START, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Boolean a(java.lang.Void... r6) {
            /*
                r5 = this;
                net.fxgear.fitnshop.g r6 = net.fxgear.fitnshop.h.f1164b
                boolean r6 = r6.a()
                if (r6 == 0) goto L_0x000f
                java.lang.String r6 = "ImageWorker"
                java.lang.String r0 = "doInBackground - starting work"
                android.util.Log.d(r6, r0)
            L_0x000f:
                net.fxgear.fitnshop.a.h r6 = net.fxgear.fitnshop.a.h.this
                java.lang.Object r6 = r6.j
                monitor-enter(r6)
            L_0x0016:
                net.fxgear.fitnshop.a.h r0 = net.fxgear.fitnshop.a.h.this     // Catch:{ all -> 0x00df }
                boolean r0 = r0.c     // Catch:{ all -> 0x00df }
                if (r0 == 0) goto L_0x002c
                boolean r0 = r5.c()     // Catch:{ all -> 0x00df }
                if (r0 != 0) goto L_0x002c
                net.fxgear.fitnshop.a.h r0 = net.fxgear.fitnshop.a.h.this     // Catch:{ InterruptedException -> 0x0016 }
                java.lang.Object r0 = r0.j     // Catch:{ InterruptedException -> 0x0016 }
                r0.wait()     // Catch:{ InterruptedException -> 0x0016 }
                goto L_0x0016
            L_0x002c:
                monitor-exit(r6)     // Catch:{ all -> 0x00df }
                java.util.HashMap r6 = new java.util.HashMap
                r6.<init>()
                r5.g = r6
                java.util.HashMap<java.lang.String, java.lang.Object> r6 = r5.f
                java.util.Set r6 = r6.keySet()
                java.util.Iterator r6 = r6.iterator()
            L_0x003e:
                r0 = 0
                boolean r1 = r6.hasNext()
                if (r1 == 0) goto L_0x00ca
                java.lang.Object r1 = r6.next()
                java.lang.String r1 = (java.lang.String) r1
                java.util.HashMap<java.lang.String, java.lang.Object> r2 = r5.f
                java.lang.Object r2 = r2.get(r1)
                java.lang.String r3 = java.lang.String.valueOf(r2)
                net.fxgear.fitnshop.a.h r4 = net.fxgear.fitnshop.a.h.this
                net.fxgear.fitnshop.a.e r4 = r4.f912a
                if (r4 == 0) goto L_0x007b
                boolean r4 = r5.c()
                if (r4 != 0) goto L_0x007b
                net.fxgear.fitnshop.b r4 = r5.e()
                if (r4 == 0) goto L_0x007b
                net.fxgear.fitnshop.a.h r4 = net.fxgear.fitnshop.a.h.this
                boolean r4 = r4.i
                if (r4 != 0) goto L_0x007b
                net.fxgear.fitnshop.a.h r0 = net.fxgear.fitnshop.a.h.this
                net.fxgear.fitnshop.a.e r0 = r0.f912a
                android.graphics.Bitmap r0 = r0.b(r3)
            L_0x007b:
                if (r0 != 0) goto L_0x0097
                boolean r4 = r5.c()
                if (r4 != 0) goto L_0x0097
                net.fxgear.fitnshop.b r4 = r5.e()
                if (r4 == 0) goto L_0x0097
                net.fxgear.fitnshop.a.h r4 = net.fxgear.fitnshop.a.h.this
                boolean r4 = r4.i
                if (r4 != 0) goto L_0x0097
                net.fxgear.fitnshop.a.h r0 = net.fxgear.fitnshop.a.h.this
                android.graphics.Bitmap r0 = r0.a((java.lang.Object) r2)
            L_0x0097:
                if (r0 == 0) goto L_0x003e
                boolean r2 = net.fxgear.fitnshop.a.j.c()
                if (r2 == 0) goto L_0x00a9
                android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable
                net.fxgear.fitnshop.a.h r4 = net.fxgear.fitnshop.a.h.this
                android.content.res.Resources r4 = r4.d
                r2.<init>(r4, r0)
                goto L_0x00b2
            L_0x00a9:
                net.fxgear.fitnshop.a.i r2 = new net.fxgear.fitnshop.a.i
                net.fxgear.fitnshop.a.h r4 = net.fxgear.fitnshop.a.h.this
                android.content.res.Resources r4 = r4.d
                r2.<init>(r4, r0)
            L_0x00b2:
                net.fxgear.fitnshop.a.h r0 = net.fxgear.fitnshop.a.h.this
                net.fxgear.fitnshop.a.e r0 = r0.f912a
                if (r0 == 0) goto L_0x00c3
                net.fxgear.fitnshop.a.h r0 = net.fxgear.fitnshop.a.h.this
                net.fxgear.fitnshop.a.e r0 = r0.f912a
                r0.a((java.lang.String) r3, (android.graphics.drawable.BitmapDrawable) r2)
            L_0x00c3:
                java.util.HashMap<java.lang.String, android.graphics.drawable.BitmapDrawable> r0 = r5.g
                r0.put(r1, r2)
                goto L_0x003e
            L_0x00ca:
                net.fxgear.fitnshop.g r6 = net.fxgear.fitnshop.h.f1164b
                boolean r6 = r6.a()
                if (r6 == 0) goto L_0x00d9
                java.lang.String r6 = "ImageWorker"
                java.lang.String r0 = "doInBackground - finished work"
                android.util.Log.d(r6, r0)
            L_0x00d9:
                r6 = 1
                java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
                return r6
            L_0x00df:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x00df }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.a.h.d.a(java.lang.Void[]):java.lang.Boolean");
        }

        /* access modifiers changed from: protected */
        public void a(Boolean bool) {
            if (c() || h.this.i) {
                this.e = true;
                if (!h.this.k) {
                    boolean unused = h.this.k = true;
                }
                bool = null;
            }
            net.fxgear.fitnshop.b e2 = e();
            if (e2 != null) {
                e2.setCacheTask((Object) null);
                if (bool != null && bool.booleanValue()) {
                    if (net.fxgear.fitnshop.h.f1164b.a()) {
                        Log.d("ImageWorker", "onPostExecute - setting bitmap");
                    }
                    for (String next : this.g.keySet()) {
                        Bitmap bitmap = this.g.get(next).getBitmap();
                        if (bitmap != null && !bitmap.isRecycled()) {
                            if (next.equals("key_logo_url") || next.equals("key_background_url")) {
                                e2.a(next, bitmap);
                            } else {
                                Log.e("ImageWorker", "Unknown key.");
                            }
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public void b(Boolean bool) {
            super.b(bool);
            net.fxgear.fitnshop.b e2 = e();
            if (e2 != null) {
                e2.setCacheTask((Object) null);
            }
            synchronized (h.this.j) {
                h.this.j.notifyAll();
            }
        }

        /* access modifiers changed from: private */
        public boolean d() {
            return this.e;
        }

        private net.fxgear.fitnshop.b e() {
            net.fxgear.fitnshop.b bVar = (net.fxgear.fitnshop.b) this.h.get();
            if (equals(h.b(bVar))) {
                return bVar;
            }
            return null;
        }
    }

    /* compiled from: ImageWorker */
    private static class a extends BitmapDrawable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<b> f914a;

        public a(Resources resources, Bitmap bitmap, b bVar) {
            super(resources, bitmap);
            this.f914a = new WeakReference<>(bVar);
        }

        public b a() {
            return (b) this.f914a.get();
        }
    }

    /* access modifiers changed from: private */
    public void a(ImageView imageView, Drawable drawable, boolean z) {
        if (this.h) {
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(17170445), drawable});
            Bitmap c2 = c(z);
            if (c2 != null) {
                imageView.setBackground(new BitmapDrawable(this.d, c2));
            }
            imageView.setImageDrawable(transitionDrawable);
            transitionDrawable.startTransition(200);
            return;
        }
        imageView.setImageDrawable(drawable);
    }

    private Bitmap c(boolean z) {
        return z ? this.e : this.f;
    }

    public void b(boolean z) {
        synchronized (this.j) {
            this.c = z;
            if (!this.c) {
                this.j.notifyAll();
            }
        }
    }

    /* compiled from: ImageWorker */
    protected class c extends a<Object, Void, Void> {
        protected c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public Void a(Object... objArr) {
            switch (objArr[0].intValue()) {
                case 0:
                    h.this.b();
                    return null;
                case 1:
                    h.this.a();
                    return null;
                case 2:
                    h.this.c();
                    return null;
                case 3:
                    h.this.d();
                    return null;
                default:
                    return null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (this.f912a != null) {
            this.f912a.a();
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        if (this.f912a != null) {
            this.f912a.c();
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (this.f912a != null) {
            this.f912a.d();
        }
    }

    /* access modifiers changed from: protected */
    public void d() {
        if (this.f912a != null) {
            this.f912a.e();
            this.f912a = null;
        }
    }

    public void i() {
        new c().c((Params[]) new Object[]{2});
    }

    public void j() {
        e();
        new c().c((Params[]) new Object[]{3});
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\a\i.java ==========

package net.fxgear.fitnshop.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import net.fxgear.fitnshop.h;

/* compiled from: RecyclingBitmapDrawable */
public class i extends BitmapDrawable {

    /* renamed from: a  reason: collision with root package name */
    private int f915a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f916b = 0;
    private boolean c;

    public i(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    public void a(boolean z) {
        synchronized (this) {
            if (z) {
                try {
                    this.f915a++;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            } else {
                this.f915a--;
            }
        }
        a();
    }

    private synchronized void a() {
        if (this.f915a <= 0 && this.f916b <= 0 && this.c && b()) {
            if (h.f1164b.a()) {
                Log.d("CountingBitmapDrawable", "No longer being used or cached so recycling. " + toString());
            }
            getBitmap().recycle();
        }
    }

    private synchronized boolean b() {
        Bitmap bitmap;
        bitmap = getBitmap();
        return bitmap != null && !bitmap.isRecycled();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\a\j.java ==========

package net.fxgear.fitnshop.a;

import android.os.Build;

/* compiled from: Utils */
public class j {
    public static boolean a() {
        return Build.VERSION.SDK_INT >= 8;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 9;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 11;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 12;
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT >= 19;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\b\a.java ==========

package net.fxgear.fitnshop.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;

/* compiled from: AutoFitTextureView */
public class a extends TextureView {

    /* renamed from: a  reason: collision with root package name */
    private int f919a;

    /* renamed from: b  reason: collision with root package name */
    private int f920b;

    public a(Context context) {
        this(context, (AttributeSet) null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f919a = 0;
        this.f920b = 0;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (this.f919a == 0 || this.f920b == 0) {
            setMeasuredDimension(size, size2);
        } else if (size < (this.f919a * size2) / this.f920b) {
            setMeasuredDimension(size, (this.f920b * size) / this.f919a);
        } else {
            setMeasuredDimension((this.f919a * size2) / this.f920b, size2);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\b\b.java ==========

package net.fxgear.fitnshop.b;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: CameraManager */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f921a = b.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private Context f922b;
    private Camera c;
    private boolean d;
    private Camera.Size e;
    /* access modifiers changed from: private */
    public int f;
    private final c g;
    private final C0032b h;

    public b(Context context) {
        this.f922b = context;
        this.g = new c(this);
        this.h = new C0032b(this);
    }

    public Camera.Size a() {
        return this.e;
    }

    public void a(int i, SurfaceHolder surfaceHolder, int i2, int i3) throws IOException {
        int i4;
        int i5;
        Log.i(this.f921a, "openDriver()+");
        Camera camera = this.c;
        int i6 = 0;
        this.f = 0;
        if (camera == null) {
            if (i == 0) {
                this.f = 1;
            } else {
                this.f = 0;
            }
            camera = Camera.open(this.f);
            if (camera != null) {
                this.c = camera;
            } else {
                throw new IOException();
            }
        }
        camera.setPreviewDisplay(surfaceHolder);
        Camera.Parameters parameters = this.c.getParameters();
        this.e = a(parameters.getSupportedPreviewSizes(), (float) i2, (float) i3);
        String str = this.f921a;
        Log.i(str, "mPreviewSize width: " + this.e.width + ", height: " + this.e.height);
        String a2 = a((Collection<String>) parameters.getSupportedFocusModes(), "continuous-picture", "macro");
        if (a2 != null) {
            parameters.setFocusMode(a2);
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.f, cameraInfo);
        switch (((WindowManager) this.f922b.getSystemService("window")).getDefaultDisplay().getRotation()) {
            case 1:
                i6 = 90;
                break;
            case 2:
                i6 = 180;
                break;
            case 3:
                i6 = 270;
                break;
        }
        if (cameraInfo.facing == 1) {
            i5 = (360 - ((cameraInfo.orientation + i6) % 360)) % 360;
            i4 = ((cameraInfo.orientation + 360) + i6) % 360;
        } else {
            i5 = ((cameraInfo.orientation - i6) + 360) % 360;
            i4 = ((cameraInfo.orientation + 360) - i6) % 360;
        }
        String str2 = this.f921a;
        Log.d(str2, "default info.orientation: " + cameraInfo.orientation + ", degress: " + i6);
        String str3 = this.f921a;
        Log.d(str3, "set displayOrientation: " + i5 + ", screenshot rotation: " + i4);
        this.c.setDisplayOrientation(i5);
        parameters.setPreviewSize(this.e.width, this.e.height);
        parameters.setRotation(i4);
        this.c.setParameters(parameters);
    }

    public void b() {
        Log.i(this.f921a, "closeDriver()+");
        if (this.c != null) {
            this.c.cancelAutoFocus();
            this.c.release();
            this.c = null;
        }
    }

    public void c() {
        Camera camera = this.c;
        if (camera != null && !this.d) {
            camera.startPreview();
            this.d = true;
        }
    }

    public void d() {
        if (this.c != null && this.d) {
            this.c.stopPreview();
            this.g.a((Handler) null, 0);
            this.h.a((Handler) null, 0);
            this.d = false;
        }
    }

    public void a(Handler handler, int i) {
        Camera camera = this.c;
        if (camera != null && this.d) {
            this.g.a(handler, i);
            camera.setOneShotPreviewCallback(this.g);
        }
    }

    public void b(Handler handler, int i) {
        if (this.c != null && this.d) {
            this.h.a(handler, i);
            this.c.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, this.h);
        }
    }

    private String a(Collection<String> collection, String... strArr) {
        String str;
        String str2 = this.f921a;
        Log.i(str2, "Supported values: " + collection);
        if (collection != null) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                str = strArr[i];
                if (collection.contains(str)) {
                    break;
                }
                i++;
            }
        }
        str = null;
        String str3 = this.f921a;
        Log.i(str3, "Settable value: " + str);
        return str;
    }

    /* compiled from: CameraManager */
    private class a implements Comparator<Camera.Size> {
        private a() {
        }

        /* renamed from: a */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((((long) size.width) * ((long) size.height)) - (((long) size2.width) * ((long) size2.height)));
        }
    }

    private Camera.Size a(List<Camera.Size> list, float f2, float f3) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        float f4 = (this.f922b == null || this.f922b.getResources().getConfiguration().orientation != 2) ? f3 / f2 : f2 / f3;
        float abs = Math.abs((((float) (list.get(0).width / list.get(0).height)) / f4) - 1.0f);
        for (Camera.Size next : list) {
            if (Math.abs(((((float) next.width) / ((float) next.height)) / f4) - 1.0f) < abs) {
                if (((float) next.width) < f2 || ((float) next.height) < f3) {
                    arrayList2.add(next);
                } else {
                    arrayList.add(next);
                }
            }
        }
        if (arrayList.size() > 0) {
            return (Camera.Size) Collections.min(arrayList, new a());
        }
        if (arrayList2.size() > 0) {
            return (Camera.Size) Collections.max(arrayList2, new a());
        }
        Log.e(this.f921a, "Couldn't find any suitable preview size");
        return list.get(0);
    }

    /* compiled from: CameraManager */
    private final class c implements Camera.PreviewCallback {

        /* renamed from: b  reason: collision with root package name */
        private final String f927b = c.class.getSimpleName();
        private b c;
        private Handler d;
        private int e;

        c(b bVar) {
            this.c = bVar;
        }

        /* access modifiers changed from: package-private */
        public void a(Handler handler, int i) {
            this.d = handler;
            this.e = i;
        }

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            Camera.Size a2 = this.c.a();
            Handler handler = this.d;
            if (handler != null) {
                handler.obtainMessage(this.e, a2.width, a2.height, bArr).sendToTarget();
                this.d = null;
                return;
            }
            Log.d(this.f927b, "Got preview callback, but no handler for it");
        }
    }

    /* renamed from: net.fxgear.fitnshop.b.b$b  reason: collision with other inner class name */
    /* compiled from: CameraManager */
    private final class C0032b implements Camera.PictureCallback {

        /* renamed from: b  reason: collision with root package name */
        private final String f925b = C0032b.class.getSimpleName();
        private b c;
        private Handler d;
        private int e;

        C0032b(b bVar) {
            this.c = bVar;
        }

        /* access modifiers changed from: package-private */
        public void a(Handler handler, int i) {
            this.d = handler;
            this.e = i;
        }

        public void onPictureTaken(byte[] bArr, Camera camera) {
            this.c.a();
            Handler handler = this.d;
            if (handler != null) {
                Message message = new Message();
                message.what = this.e;
                message.obj = bArr;
                int i = 1;
                if (b.this.f == 1) {
                    i = 0;
                }
                message.arg1 = i;
                handler.sendMessage(message);
                this.d = null;
                return;
            }
            Log.e(this.f925b, "[ERROR] :: Got picture callback, but no handler for it");
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\b\c.java ==========

package net.fxgear.fitnshop.b;

import a.a.a.a;
import java.util.Collection;
import java.util.EnumSet;

/* compiled from: DecodeFormatManager */
final class c {

    /* renamed from: a  reason: collision with root package name */
    static final Collection<a> f928a = EnumSet.of(a.UPC_A, a.UPC_E, a.EAN_13, a.EAN_8, a.RSS_14);

    /* renamed from: b  reason: collision with root package name */
    static final Collection<a> f929b = EnumSet.of(a.CODE_39, a.CODE_93, a.CODE_128, a.ITF);
    static final Collection<a> c = EnumSet.of(a.QR_CODE);
    static final Collection<a> d = EnumSet.of(a.DATA_MATRIX);

    static {
        f929b.addAll(f928a);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\b\d.java ==========

package net.fxgear.fitnshop.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;

/* compiled from: FXCameraUtil */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f930a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f931b = true;
    public static boolean c = true;
    private static final String g = "d";
    Context d;
    e e;
    f f;
    private final int h = -1;

    /* compiled from: FXCameraUtil */
    public interface a {
        void a(int i, String str);

        void a(byte[] bArr, int i);
    }

    public d(Context context, a aVar) {
        Log.i(g, "FXCameraUtil()+");
        this.d = context;
        if (Build.VERSION.SDK_INT >= 21) {
            this.f = new f(this.d, aVar);
        } else {
            this.e = new e(this.d, aVar);
        }
    }

    public void a(int i, int i2, int i3) {
        String str = g;
        Log.i(str, "StartCameraForDecodingQRCode(), directionOfCamera: " + i + ", viewWidth: " + i2 + ", viewHeight: " + i3);
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f != null) {
                    this.f.a(i, i2, i3);
                }
            } else if (this.e != null) {
                this.e.a(i);
            }
        } catch (Exception e2) {
            Log.e(g, "[ERROR] :: StartCamera");
            e2.printStackTrace();
        }
    }

    public boolean b(int i, int i2, int i3) {
        String str = g;
        Log.i(str, "SwitchCamera()+, directionOfCamera: " + i);
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f != null) {
                    return this.f.c(i, i2, i3);
                }
                return false;
            } else if (this.e == null) {
                return false;
            } else {
                this.e.a();
                this.e.b(i);
                return true;
            }
        } catch (Exception e2) {
            Log.e(g, "[ERROR] :: SwitchCamera");
            e2.printStackTrace();
            return false;
        }
    }

    public void c(int i, int i2, int i3) {
        String str = g;
        Log.i(str, "StartCamera(), directionOfCamera: " + i + ", viewWidth: " + i2 + ", viewHeight: " + i3);
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f != null) {
                    this.f.b(i, i2, i3);
                }
            } else if (this.e != null) {
                this.e.b(i);
            }
        } catch (Exception e2) {
            Log.e(g, "[ERROR] :: StartCamera");
            e2.printStackTrace();
        }
    }

    public void a() {
        Log.i(g, "StopCamera()+");
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.f != null) {
                this.f.a();
            }
        } else if (this.e != null) {
            this.e.a();
        }
    }

    public Message a(String str) {
        String str2 = g;
        Log.i(str2, "DecodeQRCodeFromFile()+, filePath : " + str);
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.f != null) {
                return this.f.a(str);
            }
            return null;
        } else if (this.e != null) {
            return this.e.a(str);
        } else {
            return null;
        }
    }

    public void b() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.f != null) {
                this.f.c();
            }
        } else if (this.e != null) {
            this.e.b();
        }
    }

    public void a(View view) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            if (this.f == null) {
                return;
            }
            if (view == null || !(view instanceof TextureView)) {
                String str = g;
                Log.e(str, "[ERROR] need to set TextureView, SDK version: " + i);
                return;
            }
            this.f.a((TextureView) view);
        } else if (this.e == null) {
        } else {
            if (view == null || !(view instanceof SurfaceView)) {
                String str2 = g;
                Log.e(str2, "[ERROR] need to set SurfaceView, SDK version: " + i);
                return;
            }
            this.e.a((SurfaceView) view);
        }
    }

    @TargetApi(21)
    public void a(int i, int i2) {
        if (this.f != null) {
            this.f.a(i, i2);
        }
    }

    public void c() {
        Log.i(g, "Finalize()+");
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.f != null) {
                this.f.b();
            }
        } else if (this.e != null) {
            this.e.c();
        }
        this.d = null;
    }

    public String a(Uri uri) {
        String str;
        String str2 = g;
        Log.d(str2, "GetAbsoulteFilePathFromUri()+, uri: " + uri);
        if (this.d != null) {
            Cursor query = this.d.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
            query.moveToFirst();
            int columnIndex = query.getColumnIndex("_data");
            if (columnIndex != -1) {
                str = query.getString(columnIndex);
                String str3 = g;
                Log.d(str3, "GetAbsoulteFilePathFromUri()-, absoluteFilePath: " + str);
                return str;
            }
            Log.e(g, "[ERROR] :: DATA column name does not exist.");
        }
        str = null;
        String str32 = g;
        Log.d(str32, "GetAbsoulteFilePathFromUri()-, absoluteFilePath: " + str);
        return str;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\b\e.java ==========

package net.fxgear.fitnshop.b;

import a.a.a.a;
import a.a.a.h;
import a.a.a.m;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import net.fxgear.fitnshop.b.d;

/* compiled from: FXCameraUtilwithCamera */
public class e implements View.OnKeyListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f932a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private Context f933b;
    private h c = null;
    private SurfaceView d = null;
    private SurfaceHolder e = null;
    /* access modifiers changed from: private */
    public b f = null;
    /* access modifiers changed from: private */
    public d.a g;
    /* access modifiers changed from: private */
    public boolean h = false;
    private final int i = 21;
    private final int j = 22;
    private final int k = 23;
    private final int l = 24;
    private Handler m = new Handler() {
        public void handleMessage(Message message) {
            if (message != null) {
                switch (message.what) {
                    case 21:
                        e.this.a((byte[]) message.obj, message.arg1, message.arg2);
                        return;
                    case 22:
                        if (e.this.f != null) {
                            e.this.f.a((Handler) this, 21);
                            return;
                        }
                        return;
                    case 23:
                        Log.d(e.this.f932a, "Got decode succeeded message");
                        m mVar = (m) message.obj;
                        String a2 = e.this.f932a;
                        Log.e(a2, "result : " + mVar);
                        if (e.this.g != null) {
                            e.this.g.a(1, mVar == null ? null : mVar.toString());
                            return;
                        }
                        return;
                    case 24:
                        Log.d(e.this.f932a, "take a picture");
                        if (e.this.g != null) {
                            e.this.g.a((byte[]) message.obj, message.arg1);
                        }
                        boolean unused = e.this.h = false;
                        return;
                    default:
                        return;
                }
            }
        }
    };

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        return i2 == 80 || i2 == 27;
    }

    public e(Context context, d.a aVar) {
        Log.i(this.f932a, "FXCameraUtilwithCamera()+");
        this.f933b = context;
        this.g = aVar;
        d();
    }

    public void a(SurfaceView surfaceView) {
        Log.d(this.f932a, "SetCameraSurfaceView()+");
        this.d = surfaceView;
        this.e = this.d.getHolder();
    }

    public void a(int i2) throws Exception {
        Log.d(this.f932a, "StartCameraForDecodingQRCode()+");
        if (this.f == null) {
            this.f = new b(this.f933b);
        }
        this.f.a(i2, this.e, this.d.getWidth(), this.d.getHeight());
        this.f.c();
        this.f.a(this.m, 21);
    }

    public void b(int i2) throws Exception {
        Log.d(this.f932a, "StartCamera()+");
        if (this.f == null) {
            this.f = new b(this.f933b);
        }
        this.f.a(i2, this.e, this.d.getWidth(), this.d.getHeight());
        this.f.c();
    }

    public void a() {
        Log.d(this.f932a, "StopCamera()+");
        if (this.m != null) {
            this.m.removeCallbacksAndMessages((Object) null);
        }
        if (this.f != null) {
            this.f.d();
            this.f.b();
        }
        this.h = false;
    }

    public void b() {
        if (this.h) {
            Log.e(this.f932a, "It is taking picture");
            return;
        }
        this.h = true;
        if (this.f != null) {
            this.f.b(this.m, 24);
        }
    }

    private void d() {
        Log.d(this.f932a, "InitMultiFormatReader()+");
        EnumMap enumMap = new EnumMap(a.a.a.e.class);
        EnumSet<E> noneOf = EnumSet.noneOf(a.class);
        if (d.f930a) {
            noneOf.addAll(c.f929b);
        }
        if (d.f931b) {
            noneOf.addAll(c.c);
        }
        if (d.c) {
            noneOf.addAll(c.d);
        }
        enumMap.put(a.a.a.e.POSSIBLE_FORMATS, noneOf);
        this.c = new h();
        this.c.a((Map<a.a.a.e, ?>) enumMap);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0066 A[Catch:{ all -> 0x004a, Exception -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0079 A[Catch:{ all -> 0x004a, Exception -> 0x008d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(byte[] r7, int r8, int r9) {
        /*
            r6 = this;
            java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x008d }
            int r0 = r7.length     // Catch:{ Exception -> 0x008d }
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x008d }
            r1 = 0
            r2 = 0
        L_0x0008:
            if (r2 >= r9) goto L_0x0020
            r3 = 0
        L_0x000b:
            if (r3 >= r8) goto L_0x001d
            int r4 = r3 * r9
            int r4 = r4 + r9
            int r4 = r4 - r2
            int r4 = r4 + -1
            int r5 = r2 * r8
            int r5 = r5 + r3
            byte r5 = r7[r5]     // Catch:{ Exception -> 0x008d }
            r0[r4] = r5     // Catch:{ Exception -> 0x008d }
            int r3 = r3 + 1
            goto L_0x000b
        L_0x001d:
            int r2 = r2 + 1
            goto L_0x0008
        L_0x0020:
            net.fxgear.fitnshop.b.b r7 = r6.f     // Catch:{ Exception -> 0x008d }
            r1 = 0
            if (r7 == 0) goto L_0x002b
            net.fxgear.fitnshop.b.g r7 = new net.fxgear.fitnshop.b.g     // Catch:{ Exception -> 0x008d }
            r7.<init>(r0, r9, r8)     // Catch:{ Exception -> 0x008d }
            goto L_0x002c
        L_0x002b:
            r7 = r1
        L_0x002c:
            r8 = -4
            if (r7 == 0) goto L_0x0064
            a.a.a.c r9 = new a.a.a.c     // Catch:{ Exception -> 0x008d }
            a.a.a.b.j r0 = new a.a.a.b.j     // Catch:{ Exception -> 0x008d }
            r0.<init>(r7)     // Catch:{ Exception -> 0x008d }
            r9.<init>(r0)     // Catch:{ Exception -> 0x008d }
            a.a.a.h r7 = r6.c     // Catch:{ Exception -> 0x008d }
            if (r7 == 0) goto L_0x0064
            a.a.a.h r7 = r6.c     // Catch:{ NotFoundException -> 0x0056, Exception -> 0x004c }
            a.a.a.m r7 = r7.a((a.a.a.c) r9)     // Catch:{ NotFoundException -> 0x0056, Exception -> 0x004c }
            a.a.a.h r9 = r6.c     // Catch:{ Exception -> 0x008d }
            r9.a()     // Catch:{ Exception -> 0x008d }
            r1 = r7
            goto L_0x0064
        L_0x004a:
            r7 = move-exception
            goto L_0x005e
        L_0x004c:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ all -> 0x004a }
            a.a.a.h r7 = r6.c     // Catch:{ Exception -> 0x008d }
        L_0x0052:
            r7.a()     // Catch:{ Exception -> 0x008d }
            goto L_0x0064
        L_0x0056:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ all -> 0x004a }
            r8 = -3
            a.a.a.h r7 = r6.c     // Catch:{ Exception -> 0x008d }
            goto L_0x0052
        L_0x005e:
            a.a.a.h r8 = r6.c     // Catch:{ Exception -> 0x008d }
            r8.a()     // Catch:{ Exception -> 0x008d }
            throw r7     // Catch:{ Exception -> 0x008d }
        L_0x0064:
            if (r1 == 0) goto L_0x0079
            java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x008d }
            android.os.Handler r7 = r6.m     // Catch:{ Exception -> 0x008d }
            if (r7 == 0) goto L_0x0091
            android.os.Handler r7 = r6.m     // Catch:{ Exception -> 0x008d }
            r8 = 23
            android.os.Message r7 = android.os.Message.obtain(r7, r8, r1)     // Catch:{ Exception -> 0x008d }
            r7.sendToTarget()     // Catch:{ Exception -> 0x008d }
            goto L_0x0091
        L_0x0079:
            android.os.Handler r7 = r6.m     // Catch:{ Exception -> 0x008d }
            if (r7 == 0) goto L_0x0091
            android.os.Handler r7 = r6.m     // Catch:{ Exception -> 0x008d }
            r9 = 22
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x008d }
            android.os.Message r7 = android.os.Message.obtain(r7, r9, r8)     // Catch:{ Exception -> 0x008d }
            r7.sendToTarget()     // Catch:{ Exception -> 0x008d }
            goto L_0x0091
        L_0x008d:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.b.e.a(byte[], int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00e8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.os.Message a(java.lang.String r15) {
        /*
            r14 = this;
            java.lang.String r0 = r14.f932a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "DecodeQRCodeFromFile()+, filePath: "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r0, r1)
            android.os.Message r0 = new android.os.Message
            r0.<init>()
            long r1 = java.lang.System.currentTimeMillis()
            android.graphics.Bitmap r15 = android.graphics.BitmapFactory.decodeFile(r15)
            if (r15 != 0) goto L_0x002f
            java.lang.String r15 = r14.f932a
            java.lang.String r1 = "DecodeQRCodeFromFile(), bitmap is null"
            android.util.Log.e(r15, r1)
            r15 = -1
            goto L_0x00f0
        L_0x002f:
            int r11 = r15.getWidth()
            int r12 = r15.getHeight()
            java.lang.String r3 = r14.f932a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "bitmap width: "
            r4.append(r5)
            int r5 = r15.getWidth()
            r4.append(r5)
            java.lang.String r5 = ", height: "
            r4.append(r5)
            int r5 = r15.getHeight()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r3, r4)
            int r3 = r11 * r12
            int[] r13 = new int[r3]
            r5 = 0
            r7 = 0
            r8 = 0
            r3 = r15
            r4 = r13
            r6 = r11
            r9 = r11
            r10 = r12
            r3.getPixels(r4, r5, r6, r7, r8, r9, r10)
            r15.recycle()
            a.a.a.j r15 = new a.a.a.j
            r15.<init>(r11, r12, r13)
            a.a.a.c r3 = new a.a.a.c
            a.a.a.b.j r4 = new a.a.a.b.j
            r4.<init>(r15)
            r3.<init>(r4)
            a.a.a.h r15 = r14.c
            r4 = 0
            if (r15 == 0) goto L_0x00b5
            a.a.a.h r15 = r14.c     // Catch:{ NotFoundException -> 0x009e, Exception -> 0x0092 }
            a.a.a.m r15 = r15.a((a.a.a.c) r3)     // Catch:{ NotFoundException -> 0x009e, Exception -> 0x0092 }
            a.a.a.h r3 = r14.c
            r3.a()
            r4 = r15
            goto L_0x00bc
        L_0x0090:
            r15 = move-exception
            goto L_0x00af
        L_0x0092:
            r15 = move-exception
            java.lang.String r3 = r14.f932a     // Catch:{ all -> 0x0090 }
            java.lang.String r5 = "DecodeQRCodeFromFile(), Exception()"
            android.util.Log.e(r3, r5)     // Catch:{ all -> 0x0090 }
            r15.printStackTrace()     // Catch:{ all -> 0x0090 }
            goto L_0x00a9
        L_0x009e:
            r15 = move-exception
            java.lang.String r3 = r14.f932a     // Catch:{ all -> 0x0090 }
            java.lang.String r5 = "DecodeQRCodeFromFile(), NotFoundException()"
            android.util.Log.e(r3, r5)     // Catch:{ all -> 0x0090 }
            r15.printStackTrace()     // Catch:{ all -> 0x0090 }
        L_0x00a9:
            a.a.a.h r15 = r14.c
            r15.a()
            goto L_0x00bc
        L_0x00af:
            a.a.a.h r0 = r14.c
            r0.a()
            throw r15
        L_0x00b5:
            java.lang.String r15 = r14.f932a
            java.lang.String r3 = "DecodeQRCodeFromFile(), mQRReader is null"
            android.util.Log.e(r15, r3)
        L_0x00bc:
            if (r4 == 0) goto L_0x00e8
            long r5 = java.lang.System.currentTimeMillis()
            java.lang.String r15 = r14.f932a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r7 = "Found barcode in "
            r3.append(r7)
            long r5 = r5 - r1
            r3.append(r5)
            java.lang.String r1 = " ms"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            android.util.Log.d(r15, r1)
            r15 = 1
            r0.what = r15
            java.lang.String r15 = r4.toString()
            r0.obj = r15
            return r0
        L_0x00e8:
            java.lang.String r15 = r14.f932a
            java.lang.String r1 = "DecodeQRCodeFromFile(), rawResult is null"
            android.util.Log.e(r15, r1)
            r15 = 0
        L_0x00f0:
            r0.what = r15
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.b.e.a(java.lang.String):android.os.Message");
    }

    public void c() {
        Log.d(this.f932a, "Finalize()+");
        this.e = null;
        this.d = null;
        this.f933b = null;
        this.g = null;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\b\f.java ==========

package net.fxgear.fitnshop.b;

import a.a.a.e;
import a.a.a.h;
import a.a.a.m;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.view.WindowManager;
import android.widget.Toast;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import net.fxgear.GlobalDefine;
import net.fxgear.fitnshop.b.d;

@TargetApi(21)
/* compiled from: FXCameraUtilwithCamera2 */
public class f {
    /* access modifiers changed from: private */
    public int A = 0;
    /* access modifiers changed from: private */
    public Object B = new Object();
    private ImageReader.OnImageAvailableListener C = new ImageReader.OnImageAvailableListener() {
        public void onImageAvailable(ImageReader imageReader) {
            Image acquireLatestImage;
            if (imageReader != null && (acquireLatestImage = imageReader.acquireLatestImage()) != null) {
                if (f.a(f.this) % 2 == 0) {
                    f.this.a(acquireLatestImage);
                } else {
                    acquireLatestImage.close();
                }
            }
        }
    };
    private final int D = 23;
    private Handler E = new Handler() {
        public void handleMessage(Message message) {
            if (message != null && message.what == 23) {
                Log.d(f.this.f935a, "[j] Got decode succeeded message");
                m mVar = (m) message.obj;
                String b2 = f.this.f935a;
                Log.e(b2, "result : " + mVar);
                if (f.this.u != null) {
                    f.this.u.a(1, mVar == null ? null : mVar.toString());
                }
            }
        }
    };
    private CameraDevice.StateCallback F = new CameraDevice.StateCallback() {
        public void onOpened(CameraDevice cameraDevice) {
            if (f.this.A == 1 || f.this.A == 3) {
                f.this.a(cameraDevice);
                return;
            }
            String b2 = f.this.f935a;
            Log.e(b2, "onOpened(), wrong mCamBusyStatus: " + f.this.A);
            cameraDevice.close();
        }

        public void onClosed(CameraDevice cameraDevice) {
            synchronized (f.this.B) {
                f.this.b(cameraDevice);
                if (f.this.A == 3) {
                    try {
                        ((CameraManager) f.this.n.getSystemService("camera")).openCamera(f.this.h, this, f.this.j);
                    } catch (Exception e) {
                        int unused = f.this.A = 0;
                        Log.e(f.this.f935a, "[ERROR] :: failed to switch - open camera");
                        e.printStackTrace();
                    }
                } else {
                    int unused2 = f.this.A = 0;
                }
            }
        }

        public void onDisconnected(CameraDevice cameraDevice) {
            int unused = f.this.A = 0;
            f.this.c(cameraDevice);
        }

        public void onError(CameraDevice cameraDevice, int i) {
            int unused = f.this.A = 0;
            f.this.a(cameraDevice, i);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f935a = f.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final int f936b = 35;
    private final int c = 256;
    private final int d = 1920;
    private final int e = 1080;
    private final int f = 640;
    private final int g = 480;
    /* access modifiers changed from: private */
    public String h;
    private HandlerThread i;
    /* access modifiers changed from: private */
    public Handler j;
    private Size k;
    /* access modifiers changed from: private */
    public CaptureRequest l;
    private h m = null;
    /* access modifiers changed from: private */
    public Context n;
    private TextureView o = null;
    private ImageReader p;
    private CameraDevice q;
    /* access modifiers changed from: private */
    public CaptureRequest.Builder r;
    /* access modifiers changed from: private */
    public CameraCaptureSession s;
    private int t = 0;
    /* access modifiers changed from: private */
    public d.a u;
    private final int v = 0;
    private final int w = 1;
    private final int x = 2;
    private final int y = 3;
    private final int z = 4;

    static /* synthetic */ int a(f fVar) {
        int i2 = fVar.t + 1;
        fVar.t = i2;
        return i2;
    }

    public f(Context context, d.a aVar) {
        Log.i(this.f935a, "FXCameraUtilwithCamera2()+");
        this.n = context;
        this.u = aVar;
        d();
    }

    private void d() {
        Log.d(this.f935a, "InitMultiFormatReader() start");
        EnumMap enumMap = new EnumMap(e.class);
        EnumSet<E> noneOf = EnumSet.noneOf(a.a.a.a.class);
        if (d.f930a) {
            noneOf.addAll(c.f929b);
        }
        if (d.f931b) {
            noneOf.addAll(c.c);
        }
        if (d.c) {
            noneOf.addAll(c.d);
        }
        enumMap.put(e.POSSIBLE_FORMATS, noneOf);
        this.m = new h();
        this.m.a((Map<e, ?>) enumMap);
    }

    public void a(TextureView textureView) {
        Log.d(this.f935a, "SetCameraTextureView()");
        this.o = textureView;
    }

    public void a(int i2, int i3, int i4) {
        String str = this.f935a;
        Log.i(str, "StartCameraForDecodingQRCode(), directionOfCamera: " + i2 + ", width: " + i3 + ", height: " + i4);
        e();
        this.A = 1;
        a(i2, i3, i4, true);
        a(i3, i4);
        try {
            ((CameraManager) this.n.getSystemService("camera")).openCamera(this.h, this.F, this.j);
        } catch (Exception e2) {
            this.A = 0;
            e2.printStackTrace();
        }
    }

    public void b(int i2, int i3, int i4) {
        String str = this.f935a;
        Log.i(str, "StartCamera(), directionOfCamera: " + i2 + ", width: " + i3 + ", height: " + i4);
        e();
        this.A = 1;
        a(i2, i3, i4, false);
        a(i3, i4);
        try {
            ((CameraManager) this.n.getSystemService("camera")).openCamera(this.h, this.F, this.j);
        } catch (Exception e2) {
            this.A = 0;
            e2.printStackTrace();
        }
    }

    public void a() {
        Log.i(this.f935a, "StopCamera()+");
        synchronized (this.B) {
            this.A = 2;
            if (this.s != null) {
                this.s.close();
                this.s = null;
            }
            if (this.q != null) {
                this.q.close();
                this.q = null;
            }
            if (this.E != null) {
                this.E.removeCallbacksAndMessages((Object) null);
            }
        }
        f();
    }

    public boolean c(int i2, int i3, int i4) {
        if (this.A != 0) {
            String str = this.f935a;
            Log.e(str, "SwitchCamera() - camera is busy, mCamBusyStatus: " + this.A);
            return false;
        }
        this.A = 3;
        if (this.s != null) {
            this.s.close();
            this.s = null;
        }
        if (this.q != null) {
            this.q.close();
            this.q = null;
        }
        if (this.E != null) {
            this.E.removeCallbacksAndMessages((Object) null);
        }
        a(i2, i3, i4, false);
        a(i3, i4);
        return true;
    }

    public void b() {
        Log.d(this.f935a, "Finalize()");
        synchronized (this.B) {
            if (this.i != null) {
                this.i.interrupt();
                this.i = null;
            }
            if (this.j != null) {
                this.j.removeCallbacksAndMessages((Object) null);
                this.j = null;
            }
            this.u = null;
            this.o = null;
            this.n = null;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0082, code lost:
        if (r0 != 180) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008b, code lost:
        if (r0 != 270) goto L_0x008e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r10, int r11, int r12, boolean r13) {
        /*
            r9 = this;
            android.content.Context r0 = r9.n
            java.lang.String r1 = "camera"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.hardware.camera2.CameraManager r0 = (android.hardware.camera2.CameraManager) r0
            r1 = 0
            r2 = 1
            if (r10 != 0) goto L_0x0019
            java.lang.String r3 = java.lang.String.valueOf(r2)     // Catch:{ CameraAccessException -> 0x0017, Exception -> 0x0015 }
            r9.h = r3     // Catch:{ CameraAccessException -> 0x0017, Exception -> 0x0015 }
            goto L_0x001f
        L_0x0015:
            r0 = move-exception
            goto L_0x0026
        L_0x0017:
            r0 = move-exception
            goto L_0x002a
        L_0x0019:
            java.lang.String r3 = java.lang.String.valueOf(r1)     // Catch:{ CameraAccessException -> 0x0017, Exception -> 0x0015 }
            r9.h = r3     // Catch:{ CameraAccessException -> 0x0017, Exception -> 0x0015 }
        L_0x001f:
            java.lang.String r3 = r9.h     // Catch:{ CameraAccessException -> 0x0017, Exception -> 0x0015 }
            android.hardware.camera2.CameraCharacteristics r0 = r0.getCameraCharacteristics(r3)     // Catch:{ CameraAccessException -> 0x0017, Exception -> 0x0015 }
            goto L_0x002e
        L_0x0026:
            r0.printStackTrace()
            goto L_0x002d
        L_0x002a:
            r0.printStackTrace()
        L_0x002d:
            r0 = 0
        L_0x002e:
            android.hardware.camera2.CameraCharacteristics$Key r3 = android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP
            java.lang.Object r3 = r0.get(r3)
            android.hardware.camera2.params.StreamConfigurationMap r3 = (android.hardware.camera2.params.StreamConfigurationMap) r3
            android.content.Context r4 = r9.n
            java.lang.String r5 = "window"
            java.lang.Object r4 = r4.getSystemService(r5)
            android.view.WindowManager r4 = (android.view.WindowManager) r4
            android.graphics.Point r5 = new android.graphics.Point
            r5.<init>()
            android.view.Display r6 = r4.getDefaultDisplay()
            r6.getSize(r5)
            int r6 = r5.x
            int r7 = r5.y
            android.view.Display r4 = r4.getDefaultDisplay()
            int r4 = r4.getRotation()
            android.hardware.camera2.CameraCharacteristics$Key r8 = android.hardware.camera2.CameraCharacteristics.SENSOR_ORIENTATION
            java.lang.Object r0 = r0.get(r8)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            switch(r4) {
                case 0: goto L_0x0085;
                case 1: goto L_0x007e;
                case 2: goto L_0x0085;
                case 3: goto L_0x007e;
                default: goto L_0x0067;
            }
        L_0x0067:
            java.lang.String r0 = r9.f935a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r8 = "Display rotation is invalid: "
            r2.append(r8)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r0, r2)
            goto L_0x008e
        L_0x007e:
            if (r0 == 0) goto L_0x008f
            r4 = 180(0xb4, float:2.52E-43)
            if (r0 != r4) goto L_0x008e
            goto L_0x008f
        L_0x0085:
            r4 = 90
            if (r0 == r4) goto L_0x008f
            r4 = 270(0x10e, float:3.78E-43)
            if (r0 != r4) goto L_0x008e
            goto L_0x008f
        L_0x008e:
            r2 = 0
        L_0x008f:
            if (r2 == 0) goto L_0x0098
            int r6 = r5.y
            int r7 = r5.x
            r4 = r11
            r0 = r12
            goto L_0x009a
        L_0x0098:
            r0 = r11
            r4 = r12
        L_0x009a:
            r2 = 1920(0x780, float:2.69E-42)
            r2 = 1080(0x438, float:1.513E-42)
            java.lang.Class<android.graphics.SurfaceTexture> r2 = android.graphics.SurfaceTexture.class
            android.util.Size[] r2 = r3.getOutputSizes(r2)
            r1 = r2[r1]
            r9.k = r1
            if (r13 == 0) goto L_0x014f
            java.lang.String r1 = r9.f935a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "Build.BRAND : "
            r2.append(r5)
            java.lang.String r5 = android.os.Build.BRAND
            r2.append(r5)
            java.lang.String r5 = ", DEVICE: "
            r2.append(r5)
            java.lang.String r5 = android.os.Build.DEVICE
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r1, r2)
            java.lang.String r1 = android.os.Build.BRAND
            java.lang.String r2 = "lge"
            boolean r1 = r1.equals(r2)
            r2 = 480(0x1e0, float:6.73E-43)
            r5 = 640(0x280, float:8.97E-43)
            if (r1 == 0) goto L_0x00fa
            java.lang.String r1 = android.os.Build.DEVICE
            java.lang.String r6 = "g2"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x00fa
            android.util.Size r1 = r9.k
            int r1 = r1.getWidth()
            int r1 = r1 / 2
            android.util.Size r2 = r9.k
            int r2 = r2.getHeight()
            int r2 = r2 / 2
            android.util.Size r5 = r9.k
            r6 = r2
            r7 = r5
            r5 = r1
            goto L_0x0102
        L_0x00fa:
            android.util.Size r1 = new android.util.Size
            r1.<init>(r5, r2)
            r7 = r1
            r6 = 480(0x1e0, float:6.73E-43)
        L_0x0102:
            java.lang.Class<android.graphics.SurfaceTexture> r1 = android.graphics.SurfaceTexture.class
            android.util.Size[] r2 = r3.getOutputSizes(r1)
            r1 = r9
            r3 = r0
            android.util.Size r0 = r1.a(r2, r3, r4, r5, r6, r7)
            java.lang.String r1 = r9.f935a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "imageReaderSize w: "
            r2.append(r3)
            int r3 = r0.getWidth()
            r2.append(r3)
            java.lang.String r3 = ", h: "
            r2.append(r3)
            int r3 = r0.getHeight()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r1, r2)
            int r1 = r0.getWidth()
            int r0 = r0.getHeight()
            r2 = 35
            r3 = 20
            android.media.ImageReader r0 = android.media.ImageReader.newInstance(r1, r0, r2, r3)
            r9.p = r0
            android.media.ImageReader r0 = r9.p
            android.media.ImageReader$OnImageAvailableListener r1 = r9.C
            android.os.Handler r2 = r9.j
            r0.setOnImageAvailableListener(r1, r2)
        L_0x014f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.b.f.a(int, int, int, boolean):void");
    }

    public void a(int i2, int i3) {
        String str = this.f935a;
        Log.i(str, "configureTransform()+, viewWidth: " + i2 + ", viewHeight: " + i3);
        if (this.o != null && this.k != null) {
            Matrix matrix = new Matrix();
            float f2 = (float) i2;
            float f3 = (float) i3;
            RectF rectF = new RectF(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, f2, f3);
            float centerX = rectF.centerX();
            float centerY = rectF.centerY();
            float height = ((float) this.k.getHeight()) / ((float) this.k.getWidth());
            if (f2 / f3 < height) {
                int i4 = (int) (f2 / height);
                int i5 = (i3 - i4) / 2;
                i3 = i4;
            } else {
                int i6 = (int) (height * f3);
                int i7 = (i2 - i6) / 2;
                i2 = i6;
            }
            float f4 = (float) i2;
            float f5 = f2 / f4;
            float f6 = (float) i3;
            float f7 = f3 / f6;
            if (f7 >= f5) {
                f5 = f7;
            }
            RectF rectF2 = new RectF(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, f4 * f5, f6 * f5);
            rectF2.offset(centerX - rectF2.centerX(), centerY - rectF2.centerY());
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            int rotation = ((WindowManager) this.n.getSystemService("window")).getDefaultDisplay().getRotation();
            if (rotation == 1 || rotation == 3) {
                matrix.postRotate((float) ((rotation - 2) * 90), centerX, centerY);
            } else if (rotation == 2) {
                matrix.postRotate(180.0f, centerX, centerY);
            }
            this.o.setTransform(matrix);
        }
    }

    private Size a(Size[] sizeArr, int i2, int i3, int i4, int i5, Size size) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int width = size.getWidth();
        int height = size.getHeight();
        for (Size size2 : sizeArr) {
            if (size2.getWidth() <= i4 && size2.getHeight() <= i5 && size2.getHeight() == (size2.getWidth() * height) / width) {
                if (size2.getWidth() < i2 || size2.getHeight() < i3) {
                    arrayList2.add(size2);
                } else {
                    arrayList.add(size2);
                }
            }
        }
        if (arrayList.size() > 0) {
            return (Size) Collections.min(arrayList, new a());
        }
        if (arrayList2.size() > 0) {
            return (Size) Collections.max(arrayList2, new a());
        }
        Log.e("FXCameraUtilwithCamera2", "Couldn't find any suitable preview size");
        return sizeArr[0];
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00e8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.os.Message a(java.lang.String r15) {
        /*
            r14 = this;
            java.lang.String r0 = r14.f935a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "DecodeQRCodeFromFile(), filePath = "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r0, r1)
            android.os.Message r0 = new android.os.Message
            r0.<init>()
            long r1 = java.lang.System.currentTimeMillis()
            android.graphics.Bitmap r15 = android.graphics.BitmapFactory.decodeFile(r15)
            if (r15 != 0) goto L_0x002f
            java.lang.String r15 = r14.f935a
            java.lang.String r1 = "DecodeQRCodeFromFile(), bitmap is null"
            android.util.Log.e(r15, r1)
            r15 = -1
            goto L_0x00f0
        L_0x002f:
            int r11 = r15.getWidth()
            int r12 = r15.getHeight()
            java.lang.String r3 = r14.f935a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "bitmap width: "
            r4.append(r5)
            int r5 = r15.getWidth()
            r4.append(r5)
            java.lang.String r5 = ", height: "
            r4.append(r5)
            int r5 = r15.getHeight()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r3, r4)
            int r3 = r11 * r12
            int[] r13 = new int[r3]
            r5 = 0
            r7 = 0
            r8 = 0
            r3 = r15
            r4 = r13
            r6 = r11
            r9 = r11
            r10 = r12
            r3.getPixels(r4, r5, r6, r7, r8, r9, r10)
            r15.recycle()
            a.a.a.j r15 = new a.a.a.j
            r15.<init>(r11, r12, r13)
            a.a.a.c r3 = new a.a.a.c
            a.a.a.b.j r4 = new a.a.a.b.j
            r4.<init>(r15)
            r3.<init>(r4)
            a.a.a.h r15 = r14.m
            r4 = 0
            if (r15 == 0) goto L_0x00b5
            a.a.a.h r15 = r14.m     // Catch:{ i -> 0x009e, Exception -> 0x0092 }
            a.a.a.m r15 = r15.a((a.a.a.c) r3)     // Catch:{ i -> 0x009e, Exception -> 0x0092 }
            a.a.a.h r3 = r14.m
            r3.a()
            r4 = r15
            goto L_0x00bc
        L_0x0090:
            r15 = move-exception
            goto L_0x00af
        L_0x0092:
            r15 = move-exception
            java.lang.String r3 = r14.f935a     // Catch:{ all -> 0x0090 }
            java.lang.String r5 = "DecodeQRCodeFromFile(), Exception()"
            android.util.Log.e(r3, r5)     // Catch:{ all -> 0x0090 }
            r15.printStackTrace()     // Catch:{ all -> 0x0090 }
            goto L_0x00a9
        L_0x009e:
            r15 = move-exception
            java.lang.String r3 = r14.f935a     // Catch:{ all -> 0x0090 }
            java.lang.String r5 = "DecodeQRCodeFromFile(), NotFoundException()"
            android.util.Log.e(r3, r5)     // Catch:{ all -> 0x0090 }
            r15.printStackTrace()     // Catch:{ all -> 0x0090 }
        L_0x00a9:
            a.a.a.h r15 = r14.m
            r15.a()
            goto L_0x00bc
        L_0x00af:
            a.a.a.h r0 = r14.m
            r0.a()
            throw r15
        L_0x00b5:
            java.lang.String r15 = r14.f935a
            java.lang.String r3 = "DecodeQRCodeFromFile(), mQRReader is null"
            android.util.Log.e(r15, r3)
        L_0x00bc:
            if (r4 == 0) goto L_0x00e8
            long r5 = java.lang.System.currentTimeMillis()
            java.lang.String r15 = r14.f935a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r7 = "Found barcode in "
            r3.append(r7)
            long r5 = r5 - r1
            r3.append(r5)
            java.lang.String r1 = " ms"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            android.util.Log.d(r15, r1)
            r15 = 1
            r0.what = r15
            java.lang.String r15 = r4.toString()
            r0.obj = r15
            return r0
        L_0x00e8:
            java.lang.String r15 = r14.f935a
            java.lang.String r1 = "DecodeQRCodeFromFile(), rawResult is null"
            android.util.Log.e(r15, r1)
            r15 = 0
        L_0x00f0:
            r0.what = r15
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.b.f.a(java.lang.String):android.os.Message");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0048, code lost:
        if (r6 == null) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005b, code lost:
        if (r6 == null) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005d, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0071, code lost:
        if (r6 != null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0074, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0076, code lost:
        r6 = r5.f935a;
        android.util.Log.e(r6, "CaptureOutput(), Decoding successful!, rawResult: " + r0.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0092, code lost:
        if (r5.E == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0094, code lost:
        android.os.Message.obtain(r5.E, 23, r0).sendToTarget();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.media.Image r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x006c
            android.media.Image$Plane[] r1 = r6.getPlanes()     // Catch:{ i -> 0x004b, Exception -> 0x0038 }
            r2 = 0
            r1 = r1[r2]     // Catch:{ i -> 0x004b, Exception -> 0x0038 }
            java.nio.ByteBuffer r1 = r1.getBuffer()     // Catch:{ i -> 0x004b, Exception -> 0x0038 }
            int r2 = r1.remaining()     // Catch:{ i -> 0x004b, Exception -> 0x0038 }
            byte[] r2 = new byte[r2]     // Catch:{ i -> 0x004b, Exception -> 0x0038 }
            r1.get(r2)     // Catch:{ i -> 0x004b, Exception -> 0x0038 }
            int r1 = r6.getWidth()     // Catch:{ i -> 0x004b, Exception -> 0x0038 }
            int r3 = r6.getHeight()     // Catch:{ i -> 0x004b, Exception -> 0x0038 }
            net.fxgear.fitnshop.b.g r4 = new net.fxgear.fitnshop.b.g     // Catch:{ i -> 0x004b, Exception -> 0x0038 }
            r4.<init>(r2, r1, r3)     // Catch:{ i -> 0x004b, Exception -> 0x0038 }
            a.a.a.c r1 = new a.a.a.c     // Catch:{ i -> 0x004b, Exception -> 0x0038 }
            a.a.a.b.j r2 = new a.a.a.b.j     // Catch:{ i -> 0x004b, Exception -> 0x0038 }
            r2.<init>(r4)     // Catch:{ i -> 0x004b, Exception -> 0x0038 }
            r1.<init>(r2)     // Catch:{ i -> 0x004b, Exception -> 0x0038 }
            a.a.a.h r2 = r5.m     // Catch:{ i -> 0x004b, Exception -> 0x0038 }
            a.a.a.m r1 = r2.a((a.a.a.c) r1)     // Catch:{ i -> 0x004b, Exception -> 0x0038 }
            r0 = r1
            goto L_0x006c
        L_0x0036:
            r0 = move-exception
            goto L_0x0061
        L_0x0038:
            r1 = move-exception
            java.lang.String r2 = r5.f935a     // Catch:{ all -> 0x0036 }
            java.lang.String r3 = "CaptureOutput(), Exception"
            android.util.Log.e(r2, r3)     // Catch:{ all -> 0x0036 }
            r1.printStackTrace()     // Catch:{ all -> 0x0036 }
            a.a.a.h r1 = r5.m
            r1.a()
            if (r6 == 0) goto L_0x0074
            goto L_0x005d
        L_0x004b:
            r1 = move-exception
            java.lang.String r2 = r5.f935a     // Catch:{ all -> 0x0036 }
            java.lang.String r3 = "CaptureOutput(), NotFoundException"
            android.util.Log.e(r2, r3)     // Catch:{ all -> 0x0036 }
            r1.printStackTrace()     // Catch:{ all -> 0x0036 }
            a.a.a.h r1 = r5.m
            r1.a()
            if (r6 == 0) goto L_0x0074
        L_0x005d:
            r6.close()
            goto L_0x0074
        L_0x0061:
            a.a.a.h r1 = r5.m
            r1.a()
            if (r6 == 0) goto L_0x006b
            r6.close()
        L_0x006b:
            throw r0
        L_0x006c:
            a.a.a.h r1 = r5.m
            r1.a()
            if (r6 == 0) goto L_0x0074
            goto L_0x005d
        L_0x0074:
            if (r0 == 0) goto L_0x009f
            java.lang.String r6 = r5.f935a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "CaptureOutput(), Decoding successful!, rawResult: "
            r1.append(r2)
            java.lang.String r2 = r0.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r6, r1)
            android.os.Handler r6 = r5.E
            if (r6 == 0) goto L_0x009f
            android.os.Handler r6 = r5.E
            r1 = 23
            android.os.Message r6 = android.os.Message.obtain(r6, r1, r0)
            r6.sendToTarget()
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.b.f.a(android.media.Image):void");
    }

    public void c() {
        CameraCharacteristics cameraCharacteristics;
        int i2;
        int i3;
        int i4;
        int i5;
        Log.i(this.f935a, "TakePicture()+");
        if (this.q == null) {
            Log.e(this.f935a, "mCameraDevice is null");
        } else if (this.A != 0) {
            Log.e(this.f935a, "TakePicture() - camera is busy, mCamBusyStatus: " + this.A);
        } else {
            this.A = 4;
            try {
                cameraCharacteristics = ((CameraManager) this.n.getSystemService("camera")).getCameraCharacteristics(this.h);
            } catch (CameraAccessException e2) {
                Log.e(this.f935a, "[ERROR] :: getCameraCharacteristics CameraAccessException");
                e2.printStackTrace();
                cameraCharacteristics = null;
            }
            if (cameraCharacteristics != null) {
                Size a2 = a(((StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(256), this.k.getWidth(), this.k.getHeight(), 1920, 1080, this.k);
                i2 = a2.getWidth();
                i3 = a2.getHeight();
            } else {
                i2 = this.k.getWidth();
                i3 = this.k.getHeight();
            }
            Log.i(this.f935a, "[JE] TakePicture(), imageReader width: " + i2 + ", height: " + i3);
            ImageReader newInstance = ImageReader.newInstance(i2, i3, 256, 1);
            newInstance.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() {
                public void onImageAvailable(ImageReader imageReader) {
                    Image acquireLatestImage = imageReader.acquireLatestImage();
                    if (acquireLatestImage != null) {
                        ByteBuffer buffer = acquireLatestImage.getPlanes()[0].getBuffer();
                        byte[] bArr = new byte[buffer.capacity()];
                        buffer.get(bArr);
                        if (f.this.u != null) {
                            int i = 1;
                            if (f.this.h != null && f.this.h.equals(String.valueOf(1))) {
                                i = 0;
                            }
                            f.this.u.a(bArr, i);
                        }
                        acquireLatestImage.close();
                        int unused = f.this.A = 0;
                    }
                }
            }, this.j);
            synchronized (this.B) {
                try {
                    final CaptureRequest.Builder createCaptureRequest = this.q.createCaptureRequest(2);
                    createCaptureRequest.addTarget(newInstance.getSurface());
                    createCaptureRequest.set(CaptureRequest.CONTROL_MODE, 1);
                    Integer num = (Integer) createCaptureRequest.get(CaptureRequest.NOISE_REDUCTION_MODE);
                    if (num != null && num.intValue() == 2) {
                        createCaptureRequest.set(CaptureRequest.NOISE_REDUCTION_MODE, 1);
                    }
                    Integer num2 = (Integer) createCaptureRequest.get(CaptureRequest.EDGE_MODE);
                    if (num2 != null && num2.intValue() == 2) {
                        createCaptureRequest.set(CaptureRequest.EDGE_MODE, 1);
                    }
                    switch (((WindowManager) this.n.getSystemService("window")).getDefaultDisplay().getRotation()) {
                        case 1:
                            i4 = 90;
                            break;
                        case 2:
                            i4 = 180;
                            break;
                        case 3:
                            i4 = 270;
                            break;
                        default:
                            i4 = 0;
                            break;
                    }
                    int b2 = b(this.h);
                    if (((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 1) {
                        i5 = ((b2 + 360) + i4) % 360;
                    } else {
                        i5 = ((b2 + 360) - i4) % 360;
                    }
                    createCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(i5));
                    Log.d(this.f935a, "sensorOrientation: " + b2 + ", degrees: " + i4);
                    String str = this.f935a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("jpg rotation: ");
                    sb.append(i5);
                    Log.d(str, sb.toString());
                    this.q.createCaptureSession(Arrays.asList(new Surface[]{newInstance.getSurface()}), new CameraCaptureSession.StateCallback() {
                        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                            try {
                                cameraCaptureSession.capture(createCaptureRequest.build(), (CameraCaptureSession.CaptureCallback) null, f.this.j);
                                cameraCaptureSession.close();
                            } catch (CameraAccessException e) {
                                int unused = f.this.A = 0;
                                Log.e(f.this.f935a, "TakePicture(), error to capture");
                                e.printStackTrace();
                            }
                        }

                        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                            int unused = f.this.A = 0;
                            Log.e(f.this.f935a, "TakePicture(), onConfigureFailed");
                        }
                    }, this.j);
                } catch (CameraAccessException e3) {
                    this.A = 0;
                    Log.e(this.f935a, "TakePicture(), CameraAccessException error");
                    e3.printStackTrace();
                }
            }
        }
    }

    private int b(String str) {
        try {
            return ((Integer) ((CameraManager) this.n.getSystemService("camera")).getCameraCharacteristics(str).get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        } catch (CameraAccessException e2) {
            Log.e(this.f935a, "[ERROR] :: GetSensorOrientation(), CameraAccessException");
            e2.printStackTrace();
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public void a(CameraDevice cameraDevice) {
        List list;
        Log.i(this.f935a, "onOpenedFunc()+");
        if (Thread.currentThread().isInterrupted()) {
            Log.e(this.f935a, "current camera thread is interrupted");
            cameraDevice.close();
            this.A = 0;
            return;
        }
        try {
            synchronized (this.B) {
                this.q = cameraDevice;
                SurfaceTexture surfaceTexture = this.o != null ? this.o.getSurfaceTexture() : null;
                if (!(this.q == null || this.o == null)) {
                    if (surfaceTexture != null) {
                        surfaceTexture.setDefaultBufferSize(this.k.getWidth(), this.k.getHeight());
                        Surface surface = new Surface(surfaceTexture);
                        this.r = this.q.createCaptureRequest(1);
                        this.r.addTarget(surface);
                        if (this.p != null) {
                            this.r.addTarget(this.p.getSurface());
                            list = Arrays.asList(new Surface[]{surface, this.p.getSurface()});
                        } else {
                            list = Arrays.asList(new Surface[]{surface});
                        }
                        if (Thread.currentThread().isInterrupted()) {
                            Log.e(this.f935a, "current camera thread is interrupted");
                            cameraDevice.close();
                            this.A = 0;
                            return;
                        }
                        this.q.createCaptureSession(list, new CameraCaptureSession.StateCallback() {
                            public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                                Log.d(f.this.f935a, "createCaptureSession(), onConfigured()+");
                                if (f.this.A == 2) {
                                    Log.e(f.this.f935a, "onConfigured(), camera is stoping");
                                    cameraCaptureSession.close();
                                    return;
                                }
                                CameraCaptureSession unused = f.this.s = cameraCaptureSession;
                                try {
                                    f.this.r.set(CaptureRequest.CONTROL_AF_MODE, 4);
                                    f.this.r.set(CaptureRequest.CONTROL_AE_MODE, 2);
                                    CaptureRequest unused2 = f.this.l = f.this.r.build();
                                    f.this.s.setRepeatingRequest(f.this.l, (CameraCaptureSession.CaptureCallback) null, f.this.j);
                                    int unused3 = f.this.A = 0;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    throw new AssertionError("createCaptureSession(), Exception");
                                } catch (Throwable th) {
                                    int unused4 = f.this.A = 0;
                                    throw th;
                                }
                            }

                            public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                                Log.d(f.this.f935a, "createCaptureSession(), onConfigureFailed()+");
                                Toast.makeText(f.this.n, "Error", 0).show();
                                int unused = f.this.A = 0;
                            }
                        }, (Handler) null);
                        return;
                    }
                }
                Log.e(this.f935a, "mCameraDevice or mTextureView or texture is null");
                this.A = 0;
            }
        } catch (Exception e2) {
            this.A = 0;
            e2.printStackTrace();
            throw new AssertionError("onOpened()-, Exception");
        }
    }

    /* access modifiers changed from: private */
    public void b(CameraDevice cameraDevice) {
        Log.i(this.f935a, "onClosedFunc()+");
        if (this.r != null) {
            if (this.p != null) {
                this.r.removeTarget(this.p.getSurface());
                this.p.close();
                this.p = null;
            }
            this.r = null;
        }
    }

    /* access modifiers changed from: private */
    public void c(CameraDevice cameraDevice) {
        Log.i(this.f935a, "onDisconnectedFunc()+");
        cameraDevice.close();
        this.q = null;
    }

    /* access modifiers changed from: private */
    public void a(CameraDevice cameraDevice, int i2) {
        String str = this.f935a;
        Log.i(str, "onErrorFunc()+, error = " + i2);
        cameraDevice.close();
        this.q = null;
    }

    private void e() {
        Log.d(this.f935a, "startBackgroundThread()+");
        if (this.i == null) {
            this.i = new HandlerThread("CameraBackground");
            this.i.start();
            this.j = new Handler(this.i.getLooper());
        }
    }

    private void f() {
        Log.d(this.f935a, "stopBackgroundThread()+");
        try {
            if (this.i != null) {
                this.i.quitSafely();
                this.i.join();
                this.i = null;
            }
            if (this.j != null) {
                this.j.removeCallbacksAndMessages((Object) null);
                this.j = null;
            }
        } catch (InterruptedException e2) {
            Log.e(this.f935a, "[ERROR] :: stopBackgroundThread() InterruptedException");
            e2.printStackTrace();
        }
    }

    /* compiled from: FXCameraUtilwithCamera2 */
    static class a implements Comparator<Size> {
        a() {
        }

        /* renamed from: a */
        public int compare(Size size, Size size2) {
            return Long.signum((((long) size.getWidth()) * ((long) size.getHeight())) - (((long) size2.getWidth()) * ((long) size2.getHeight())));
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\b\g.java ==========

package net.fxgear.fitnshop.b;

/* compiled from: PlanarYUVLuminanceSource */
public final class g extends a.a.a.g {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f944a;

    /* renamed from: b  reason: collision with root package name */
    private final int f945b;
    private final int c;
    private final int d = 0;
    private final int e = 0;

    public g(byte[] bArr, int i, int i2) {
        super(i, i2);
        this.f944a = bArr;
        this.f945b = i;
        this.c = i2;
    }

    public byte[] a(int i, byte[] bArr) {
        if (i < 0 || i >= c()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int b2 = b();
        if (bArr == null || bArr.length < b2) {
            bArr = new byte[b2];
        }
        System.arraycopy(this.f944a, ((i + this.e) * this.f945b) + this.d, bArr, 0, b2);
        return bArr;
    }

    public byte[] a() {
        int b2 = b();
        int c2 = c();
        if (b2 == this.f945b && c2 == this.c) {
            return this.f944a;
        }
        int i = b2 * c2;
        byte[] bArr = new byte[i];
        int i2 = (this.e * this.f945b) + this.d;
        if (b2 == this.f945b) {
            System.arraycopy(this.f944a, i2, bArr, 0, i);
            return bArr;
        }
        byte[] bArr2 = this.f944a;
        for (int i3 = 0; i3 < c2; i3++) {
            System.arraycopy(bArr2, i2, bArr, i3 * b2, b2);
            i2 += this.f945b;
        }
        return bArr;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\c\a.java ==========

package net.fxgear.fitnshop.c;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.ContextThemeWrapper;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import net.fxgear.GlobalDefine;
import net.fxgear.a.a;

/* compiled from: CircleDialog */
public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private final float f950a = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;

    /* renamed from: b  reason: collision with root package name */
    private TextView f951b;

    public a(Activity activity, int i) {
        super(activity);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (i == 1) {
            setContentView(a.f.dialog_circle_message);
            this.f951b = (TextView) findViewById(a.e.progress_message);
        } else {
            setContentView(new ProgressBar(new ContextThemeWrapper(activity, 16974126)), new WindowManager.LayoutParams(-2, -2));
        }
        setCanceledOnTouchOutside(false);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.dimAmount = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        getWindow().setAttributes(attributes);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\c\b.java ==========

package net.fxgear.fitnshop.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import net.fxgear.a.a;

/* compiled from: ConfirmDialog */
public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private final String f952a = "ConfirmDialog";

    /* renamed from: b  reason: collision with root package name */
    private final float f953b = 0.7f;
    private final int c = 2;
    private final int d = 1;
    private RelativeLayout e;
    private LinearLayout f;
    private TextView g;
    private TextView h;
    private Button i;
    private Button j;
    /* access modifiers changed from: private */
    public a k;

    /* compiled from: ConfirmDialog */
    public interface a {
        void a(b bVar);

        void b(b bVar);
    }

    public b(Activity activity, int i2) {
        super(activity);
        requestWindowFeature(1);
        setContentView(a.f.dialog_confirm);
        a(i2);
        Window window = getWindow();
        window.setBackgroundDrawableResource(17170445);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.7f;
        window.setAttributes(attributes);
    }

    private void a(int i2) {
        Log.i("ConfirmDialog", "InitializeDialog()+, buttonType : " + i2);
        this.e = (RelativeLayout) findViewById(a.e.layout_title_container);
        this.f = (LinearLayout) findViewById(a.e.layout_button_container);
        this.g = (TextView) findViewById(a.e.dialog_title_text);
        this.h = (TextView) findViewById(a.e.dialog_message);
        this.e.setVisibility(8);
        if (i2 == 1 || i2 == 2) {
            Context context = getContext();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0f);
            this.f.setVisibility(0);
            this.j = a(context);
            this.j.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (b.this.k != null) {
                        b.this.k.a(b.this);
                    }
                }
            });
            this.f.addView(this.j, layoutParams);
            if (i2 == 2) {
                View view = new View(context);
                view.setBackgroundResource(a.b.dialog_divider);
                this.f.addView(view, new LinearLayout.LayoutParams(context.getResources().getDimensionPixelSize(a.c.confirm_dialog_divider_width), -1));
                this.i = a(context);
                this.i.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (b.this.k != null) {
                            b.this.k.b(b.this);
                        }
                    }
                });
                this.f.addView(this.i, layoutParams);
            }
        }
    }

    private Button a(Context context) {
        Button button = new Button(context);
        button.setBackgroundResource(a.d.btn_dialog_background);
        button.setTextColor(context.getResources().getColor(a.b.dialog_text_color));
        button.setLines(2);
        button.setEllipsize(TextUtils.TruncateAt.END);
        button.setTextSize(0, (float) context.getResources().getDimensionPixelSize(a.c.confirm_dialog_button_text_size));
        return button;
    }

    public void a(a aVar) {
        Log.i("ConfirmDialog", "SetDialogButtonListener()+");
        this.k = aVar;
    }

    public void a(boolean z) {
        Log.i("ConfirmDialog", "SetTitleVisible()+, visible : " + z);
        if (z) {
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
    }

    public void a(String str) {
        Log.i("ConfirmDialog", "SetTitleText()+, title : " + str);
        if (str != null) {
            this.e.setVisibility(0);
            this.g.setText(str);
            return;
        }
        this.e.setVisibility(8);
    }

    public void b(String str) {
        Log.i("ConfirmDialog", "SetMessage()+, message : " + str);
        if (str != null) {
            this.h.setText(str);
        }
    }

    public void c(String str) {
        if (this.j != null && str != null) {
            this.j.setText(str);
        }
    }

    public void d(String str) {
        if (this.i != null && str != null) {
            this.i.setText(str);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\c\c.java ==========

package net.fxgear.fitnshop.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.view.Window;

/* compiled from: FXDialog */
public class c extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private int f956a;

    private int a(int i) {
        return i | 2 | 1;
    }

    public c(Activity activity) {
        super(activity);
        this.f956a = activity.getWindow().getDecorView().getSystemUiVisibility();
        if (Build.VERSION.SDK_INT < 19) {
            this.f956a = a(this.f956a);
        } else {
            this.f956a = b(this.f956a);
        }
    }

    @TargetApi(19)
    private int b(int i) {
        return a(i) | 4096;
    }

    private void a(boolean z) {
        Window window = getWindow();
        if (z) {
            window.clearFlags(8);
        } else {
            window.setFlags(8, 8);
        }
    }

    public void show() {
        a(false);
        super.show();
        getWindow().getDecorView().setSystemUiVisibility(this.f956a);
        a(true);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\c\d.java ==========

package net.fxgear.fitnshop.c;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
import net.fxgear.AvatarData;
import net.fxgear.GlobalDefine;
import net.fxgear.a.a;
import net.fxgear.fitnshop.j;
import net.fxgear.fittingmodenative.c;
import net.fxgear.fittingmodenative.e;
import net.fxgear.fittingmodenative.f;
import net.fxgear.util.FXDataManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FittingInitializerDialog */
public class d extends c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final String f957a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final String f958b = "%";
    private TextView c;
    private TextView d;
    private ProgressBar e;
    private Button f;
    /* access modifiers changed from: private */
    public c.e g;
    /* access modifiers changed from: private */
    public a h;

    /* compiled from: FittingInitializerDialog */
    public interface a {
        void a();

        void a(GlobalDefine.Result result);
    }

    public d(Activity activity) {
        super(activity);
        Log.i(this.f957a, "FittingInitializeDialog()");
        requestWindowFeature(1);
        setContentView(2131296267);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        this.c = (TextView) findViewById(a.e.dialog_title_text);
        this.d = (TextView) findViewById(a.e.dialog_progressvalue_text);
        this.e = (ProgressBar) findViewById(a.e.dialog_progressbar);
        this.f = (Button) findViewById(a.e.cancel_button);
        this.f.setOnClickListener(this);
        this.c.setText(getContext().getResources().getString(2131361960));
        this.f.setVisibility(0);
        a(0);
    }

    public void a(String str) {
        this.c.setText(str);
    }

    public void a(a aVar) {
        this.h = aVar;
    }

    /* access modifiers changed from: private */
    public void a(int i) {
        TextView textView = this.d;
        textView.setText(i + "%");
        this.e.setProgress(i);
    }

    public void a() {
        this.g = c.a(getContext(), (c.C0044c) new c.C0044c() {
            public void a() {
                if (d.this.h != null) {
                    d.this.h.a();
                }
            }

            public void a(int i, int i2, int i3) {
                Resources resources = d.this.getContext().getResources();
                String string = resources.getString(2131361960);
                switch (i) {
                    case 0:
                        string = resources.getString(2131361960);
                        break;
                    case 1:
                        string = resources.getString(2131361965);
                        break;
                    case 2:
                    case 3:
                        string = resources.getString(2131361967);
                        break;
                }
                d.this.a(string);
                d.this.a(i3);
            }

            public void a(GlobalDefine.Result result) {
                if (result.resultCode == -1) {
                    Context context = d.this.getContext();
                    d.this.d();
                    d.this.e();
                    d.this.a(context);
                    f.d(context);
                    d.this.c();
                }
                if (d.this.h != null) {
                    d.this.h.a(result);
                }
                c.e unused = d.this.g = null;
                d.this.dismiss();
            }
        });
        show();
    }

    public void b() {
        if (this.g != null) {
            this.g.a();
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        Context context = getContext();
        if (GlobalDefine.GetChangeDefaultRealVideoState(context) == 1) {
            j.a(getContext()).b();
            d();
            GlobalDefine.SetChangeDefaultRealVideoState(context, 2);
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        int i;
        int i2;
        int i3;
        int i4;
        j a2 = j.a(getContext());
        e a3 = e.a(getContext());
        if (!a2.a()) {
            ArrayList<e.c> c2 = a3.c();
            int size = c2.size();
            for (int i5 = 0; i5 < size; i5++) {
                e.c cVar = c2.get(i5);
                if (cVar.d == 1) {
                    if (cVar.f.equals(GlobalDefine.REAL_VIDEO_BODY_SIZE_CUSTOM)) {
                        i4 = 0;
                        i3 = 1;
                        a2.a(cVar.f1465a, cVar.f1466b, cVar.c, i4, i3);
                    } else if (cVar.f1466b != 1 ? !(cVar.f1466b != 2 || (cVar.c != 1 ? cVar.c != 2 || !cVar.f.equals(GlobalDefine.REAL_VIDEO_DEFAULT_SIZE_MAN) : !cVar.f.equals(GlobalDefine.REAL_VIDEO_DEFAULT_SIZE_BOY))) : !(cVar.c != 1 ? cVar.c != 2 || !cVar.f.equals(GlobalDefine.REAL_VIDEO_DEFAULT_SIZE_WOMAN) : !cVar.f.equals(GlobalDefine.REAL_VIDEO_DEFAULT_SIZE_GIRL))) {
                        i4 = 1;
                        i3 = 0;
                        a2.a(cVar.f1465a, cVar.f1466b, cVar.c, i4, i3);
                    }
                }
                i4 = 1;
                i3 = 1;
                a2.a(cVar.f1465a, cVar.f1466b, cVar.c, i4, i3);
            }
            return;
        }
        if (!(a2.a(1, 1) > 0 && a2.a(2, 1) > 0)) {
            ArrayList<e.c> c3 = a3.c();
            int size2 = c3.size();
            for (int i6 = 0; i6 < size2; i6++) {
                e.c cVar2 = c3.get(i6);
                if (cVar2.c == 1) {
                    if (cVar2.d == 1) {
                        if (cVar2.f.equals(GlobalDefine.REAL_VIDEO_BODY_SIZE_CUSTOM)) {
                            i2 = 0;
                            i = 1;
                            a2.a(cVar2.f1465a, cVar2.f1466b, cVar2.c, i2, i);
                        } else if (cVar2.f1466b != 1 ? !(cVar2.f1466b != 2 || !cVar2.f.equals(GlobalDefine.REAL_VIDEO_DEFAULT_SIZE_BOY)) : cVar2.f.equals(GlobalDefine.REAL_VIDEO_DEFAULT_SIZE_GIRL)) {
                            i2 = 1;
                            i = 0;
                            a2.a(cVar2.f1465a, cVar2.f1466b, cVar2.c, i2, i);
                        }
                    }
                    i2 = 1;
                    i = 1;
                    a2.a(cVar2.f1465a, cVar2.f1466b, cVar2.c, i2, i);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            j a2 = j.a(context);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("gender", 1);
            jSONObject2.put("age", 2);
            jSONObject2.put("real_id", a2.a(1, 2));
            jSONArray.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("gender", 2);
            jSONObject3.put("age", 2);
            jSONObject3.put("real_id", a2.a(2, 2));
            jSONArray.put(jSONObject3);
            jSONObject.put("character_info", jSONArray);
            f.a(context, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        FXDataManager GetInstance = FXDataManager.GetInstance(getContext());
        net.fxgear.fitnshop.a a2 = net.fxgear.fitnshop.a.a(getContext());
        if (!a2.a()) {
            ArrayList<AvatarData> GetAllAvatarDataList = GetInstance.GetAllAvatarDataList();
            if (GetAllAvatarDataList == null || GetAllAvatarDataList.isEmpty()) {
                f();
            }
            ArrayList<AvatarData> GetAllAvatarDataList2 = GetInstance.GetAllAvatarDataList();
            int size = GetAllAvatarDataList2.size();
            for (int i = 0; i < size; i++) {
                AvatarData avatarData = GetAllAvatarDataList2.get(i);
                a2.a(avatarData.mAvatarID, avatarData.mGender, avatarData.mAge, 1, 0);
            }
            return;
        }
        if (!(a2.a(1, 1) > 0 && a2.a(2, 1) > 0)) {
            ArrayList<AvatarData> GetAvatarDataList = GetInstance.GetAvatarDataList(1, 1);
            ArrayList<AvatarData> GetAvatarDataList2 = GetInstance.GetAvatarDataList(2, 1);
            if ((GetAvatarDataList == null || GetAvatarDataList.isEmpty()) && (GetAvatarDataList2 == null || GetAvatarDataList2.isEmpty())) {
                g();
            }
            ArrayList<AvatarData> GetAllAvatarDataList3 = GetInstance.GetAllAvatarDataList();
            int size2 = GetAllAvatarDataList3.size();
            for (int i2 = 0; i2 < size2; i2++) {
                AvatarData avatarData2 = GetAllAvatarDataList3.get(i2);
                if (avatarData2.mAge == 1) {
                    a2.a(avatarData2.mAvatarID, avatarData2.mGender, avatarData2.mAge, 1, 0);
                }
            }
        }
    }

    private void f() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("gender", 1);
            jSONObject2.put("age", 2);
            jSONArray.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("gender", 2);
            jSONObject3.put("age", 2);
            jSONArray.put(jSONObject3);
            jSONObject.put("character_info", jSONArray);
            f.b(getContext(), jSONObject);
            g();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void g() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("gender", 1);
            jSONObject2.put("age", 1);
            jSONArray.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("gender", 2);
            jSONObject3.put("age", 1);
            jSONArray.put(jSONObject3);
            jSONObject.put("character_info", jSONArray);
            f.b(getContext(), jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void onClick(View view) {
        if (view.getId() == 2131165240 && this.g != null) {
            this.g.a();
            this.g = null;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\c\e.java ==========

package net.fxgear.fitnshop.c;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import net.fxgear.a.a;

/* compiled from: ListDialog */
public class e extends c {

    /* renamed from: a  reason: collision with root package name */
    private final String f960a = "ListDialog";

    /* renamed from: b  reason: collision with root package name */
    private final float f961b = 0.7f;
    private RelativeLayout c;
    private TextView d;
    private ListView e;
    private b f;
    /* access modifiers changed from: private */
    public ArrayList<String> g;
    /* access modifiers changed from: private */
    public int h;
    /* access modifiers changed from: private */
    public c i;

    /* compiled from: ListDialog */
    public interface c {
        void a(int i, String str);
    }

    public e(Activity activity) {
        super(activity);
        requestWindowFeature(1);
        setContentView(2131296268);
        a();
        Window window = getWindow();
        window.setBackgroundDrawableResource(17170445);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.7f;
        window.setAttributes(attributes);
    }

    private void a() {
        Log.i("ListDialog", "InitializeDialog()+");
        this.f = new b();
        this.g = new ArrayList<>();
        this.c = (RelativeLayout) findViewById(a.e.layout_title_container);
        this.d = (TextView) findViewById(a.e.dialog_title_text);
        this.e = (ListView) findViewById(2131165358);
        this.e.setAdapter(this.f);
        this.e.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.h != i) {
                    int unused = e.this.h = i;
                    int childCount = adapterView.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        a aVar = (a) adapterView.getChildAt(i2);
                        if (i2 == i) {
                            aVar.b(true);
                        } else {
                            aVar.b(false);
                        }
                    }
                    if (e.this.i != null) {
                        e.this.i.a(i, (String) e.this.g.get(i));
                        return;
                    }
                    return;
                }
                ((a) view).b(true);
                e.this.dismiss();
            }
        });
    }

    public void a(c cVar) {
        this.i = cVar;
    }

    public void a(String[] strArr, int i2) {
        this.h = i2;
        this.g.clear();
        this.g.addAll(Arrays.asList(strArr));
        this.f.notifyDataSetChanged();
    }

    public void a(String str) {
        Log.i("ListDialog", "SetTitleText()+, title : " + str);
        if (str != null) {
            if (this.c.getVisibility() != 0) {
                this.c.setVisibility(0);
            }
            this.d.setText(str);
        }
    }

    /* compiled from: ListDialog */
    private class a extends RelativeLayout {

        /* renamed from: b  reason: collision with root package name */
        private final int f964b;
        private final int c;
        private final int d;
        private final int e;
        private TextView f = ((TextView) findViewById(a.e.tv_item_title));
        private boolean g;

        public a(Context context) {
            super(context);
            this.c = context.getResources().getColor(2130968630);
            this.f964b = context.getResources().getColor(2130968629);
            this.d = context.getResources().getColor(2130968645);
            this.e = context.getResources().getColor(2130968646);
            inflate(getContext(), 2131296302, this);
            b(false);
        }

        public void setPressed(boolean z) {
            if (!this.g) {
                a(z);
            }
            if (z) {
                setBackgroundColor(this.e);
            } else {
                setBackgroundColor(this.d);
            }
        }

        public void a(String str) {
            this.f.setText(str);
        }

        /* access modifiers changed from: private */
        public void b(boolean z) {
            this.g = z;
            a(this.g);
        }

        public void a(boolean z) {
            if (z) {
                this.f.setTextColor(this.c);
                this.f.setPaintFlags(this.f.getPaintFlags() | 32);
                setBackgroundColor(this.e);
                return;
            }
            this.f.setTextColor(this.f964b);
            this.f.setPaintFlags(this.f.getPaintFlags() & -33);
            setBackgroundColor(this.d);
        }
    }

    /* compiled from: ListDialog */
    private class b extends BaseAdapter {
        public long getItemId(int i) {
            return (long) i;
        }

        private b() {
        }

        public int getCount() {
            return e.this.g.size();
        }

        public Object getItem(int i) {
            return e.this.g.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = new a(e.this.getContext());
            }
            a aVar = (a) view;
            boolean z = e.this.h == i;
            aVar.a((String) e.this.g.get(i));
            aVar.b(z);
            return view;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\d\a.java ==========

package net.fxgear.fitnshop.d;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import net.fxgear.fitnshop.b.d;

/* compiled from: AddMirrorVideoFragment */
public class a extends b implements View.OnClickListener {
    private final String d = "AddMirrorVideoFragment";
    /* access modifiers changed from: private */
    public C0033a e;
    private RelativeLayout f;
    /* access modifiers changed from: private */
    public View g;
    /* access modifiers changed from: private */
    public d h;
    /* access modifiers changed from: private */
    public boolean i = false;
    /* access modifiers changed from: private */
    public boolean j = false;
    private d.a k = new d.a() {
        public void a(byte[] bArr, int i) {
        }

        public void a(int i, String str) {
            if (a.this.e != null) {
                a.this.e.a(str, a.this.j);
            }
        }
    };
    private SurfaceHolder.Callback l = new SurfaceHolder.Callback() {
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Log.d("AddMirrorVideoFragment", "surfaceCreated()+, mIsForeground: " + a.this.i);
            if (Build.VERSION.SDK_INT < 21 && a.this.i && a.this.h != null) {
                a.this.h.a((View) (SurfaceView) a.this.g);
                a.this.h.a(1, a.this.g.getWidth(), a.this.g.getHeight());
            }
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            Log.d("AddMirrorVideoFragment", "surfaceChanged()+");
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Log.d("AddMirrorVideoFragment", "surfaceDestroyed()+");
            Log.d("AddMirrorVideoFragment", "holder.removeCallback");
            surfaceHolder.removeCallback(this);
        }
    };
    private TextureView.SurfaceTextureListener m = new TextureView.SurfaceTextureListener() {
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            Log.d("AddMirrorVideoFragment", "onSurfaceTextureAvailable()+, mIsForeground: " + a.this.i);
            if (Build.VERSION.SDK_INT >= 21 && a.this.i && a.this.h != null) {
                a.this.h.a((View) (net.fxgear.fitnshop.b.a) a.this.g);
                a.this.h.a(1, i, i2);
            }
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            Log.d("AddMirrorVideoFragment", "onSurfaceTextureSizeChanged()+");
            if (Build.VERSION.SDK_INT >= 21 && a.this.h != null) {
                a.this.h.a(i, i2);
            }
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            Log.d("AddMirrorVideoFragment", "onSurfaceTextureDestroyed()+");
            if (a.this.g == null) {
                return true;
            }
            Log.d("AddMirrorVideoFragment", "remove SurfaceTextureListener");
            ((net.fxgear.fitnshop.b.a) a.this.g).setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
            return true;
        }
    };

    /* renamed from: net.fxgear.fitnshop.d.a$a  reason: collision with other inner class name */
    /* compiled from: AddMirrorVideoFragment */
    public interface C0033a {
        void a();

        void a(String str, boolean z);

        void a(boolean z);
    }

    public String a() {
        return "AddMirrorVideoFragment";
    }

    public void c() {
    }

    public void d() {
    }

    public a() {
        Log.i("AddMirrorVideoFragment", "AddMirrorVideoFragment()+");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i("AddMirrorVideoFragment", "onCreate()+");
        getActivity().getWindow().addFlags(128);
        if (Build.VERSION.SDK_INT >= 21) {
            this.g = new net.fxgear.fitnshop.b.a(getActivity());
        } else {
            this.g = new SurfaceView(getActivity());
        }
        this.g.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.h = new d(this.f974b, this.k);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Log.i("AddMirrorVideoFragment", "onCreateView()+");
        if (layoutInflater == null) {
            return null;
        }
        View inflate = layoutInflater.inflate(2131296270, viewGroup, false);
        ((Button) inflate.findViewById(2131165198)).setOnClickListener(this);
        ((Button) inflate.findViewById(2131165199)).setOnClickListener(this);
        this.f = (RelativeLayout) inflate.findViewById(2131165397);
        if (this.g == null) {
            return inflate;
        }
        this.f.addView(this.g);
        return inflate;
    }

    public void onDestroyView() {
        Log.i("AddMirrorVideoFragment", "onDestroyView()+");
        if (this.f != null) {
            this.f.removeAllViews();
        }
        super.onDestroyView();
    }

    public void onResume() {
        Log.i("AddMirrorVideoFragment", "onResume()");
        super.onResume();
        this.i = true;
        try {
            if (this.h == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                boolean isAvailable = ((net.fxgear.fitnshop.b.a) this.g).isAvailable();
                Log.d("AddMirrorVideoFragment", "textureView.isAvailable: " + isAvailable);
                if (isAvailable) {
                    this.h.a(1, this.g.getWidth(), this.g.getHeight());
                    return;
                }
                Log.d("AddMirrorVideoFragment", "setSurfaceTextureListener");
                ((net.fxgear.fitnshop.b.a) this.g).setSurfaceTextureListener(this.m);
                return;
            }
            SurfaceHolder holder = ((SurfaceView) this.g).getHolder();
            Surface surface = holder.getSurface();
            boolean isValid = surface != null ? surface.isValid() : false;
            Log.d("AddMirrorVideoFragment", "surface.isValid: " + isValid);
            if (isValid) {
                this.h.a(1, this.g.getWidth(), this.g.getHeight());
                return;
            }
            Log.d("AddMirrorVideoFragment", "cameraSurfaceHolder.addCallback");
            holder.addCallback(this.l);
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new AssertionError("[ERROR] :: Exception caused by StartCamera()");
        }
    }

    public void onPause() {
        Log.i("AddMirrorVideoFragment", "onPause()");
        this.i = false;
        if (this.h != null) {
            this.h.a();
        }
        super.onPause();
    }

    public void onDestroy() {
        Log.i("AddMirrorVideoFragment", "onDestroy()");
        if (this.h != null) {
            this.h.c();
            this.h = null;
        }
        if (this.f != null) {
            this.f.removeAllViews();
        }
        if (this.g != null) {
            if (this.g instanceof SurfaceView) {
                ((SurfaceView) this.g).getHolder().removeCallback(this.l);
            }
            this.g = null;
        }
        super.onDestroy();
    }

    public Message a(String str) {
        if (this.h != null) {
            return this.h.a(str);
        }
        return null;
    }

    public String a(Uri uri) {
        if (this.h != null) {
            return this.h.a(uri);
        }
        return null;
    }

    public boolean b() {
        if (this.e == null) {
            return true;
        }
        this.e.a(this.j);
        return true;
    }

    public void onClick(View view) {
        if (view != null) {
            switch (view.getId()) {
                case 2131165198:
                    if (this.e != null) {
                        this.e.a(this.j);
                        return;
                    }
                    return;
                case 2131165199:
                    if (this.e != null) {
                        this.e.a();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void a(boolean z) {
        this.j = z;
    }

    public void a(C0033a aVar) {
        this.e = aVar;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\d\b.java ==========

package net.fxgear.fitnshop.d;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import java.util.ArrayList;
import net.fxgear.GlobalDefine;
import net.fxgear.fitnshop.ApplicationClass;

/* compiled from: BaseFragment */
public abstract class b extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    protected int f973a = 0;

    /* renamed from: b  reason: collision with root package name */
    protected Context f974b = ApplicationClass.f763a;
    protected View c;
    private final String d = "BaseFragment";
    private int e;

    public abstract String a();

    public abstract boolean b();

    public abstract void c();

    public abstract void d();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Display defaultDisplay = getActivity().getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.e = point.x;
    }

    public void onDestroy() {
        this.c = null;
        super.onDestroy();
    }

    public void a(int i) {
        this.f973a = i;
    }

    /* access modifiers changed from: protected */
    public Animator b(int i) {
        ObjectAnimator objectAnimator;
        switch (i) {
            case 1:
                objectAnimator = ObjectAnimator.ofFloat(this, "translationX", new float[]{(float) this.e, 0.0f});
                break;
            case 2:
                objectAnimator = ObjectAnimator.ofFloat(this, "translationX", new float[]{0.0f, (float) (-this.e)});
                break;
            case 3:
                objectAnimator = ObjectAnimator.ofFloat(this, "translationX", new float[]{(float) (-this.e), 0.0f});
                break;
            case 4:
                objectAnimator = ObjectAnimator.ofFloat(this, "translationX", new float[]{0.0f, (float) this.e});
                break;
            default:
                objectAnimator = null;
                break;
        }
        if (objectAnimator == null) {
            return null;
        }
        objectAnimator.setDuration(400);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        ArrayList arrayList = new ArrayList();
        arrayList.add(objectAnimator);
        if (i == 2) {
            arrayList.add(ObjectAnimator.ofFloat(this, "translationX", new float[]{GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE}).setDuration(0));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(arrayList);
        return animatorSet;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\d\c.java ==========

package net.fxgear.fitnshop.d;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.k;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import net.fxgear.GlobalDefine;
import net.fxgear.a.a;
import net.fxgear.fitnshop.FitNShopMainActivity;
import net.fxgear.fitnshop.c.b;
import net.fxgear.fitnshop.c.e;
import net.fxgear.fitnshop.d;
import net.fxgear.fitnshop.e;
import net.fxgear.fitnshop.e.b;
import net.fxgear.fitnshop.e.c;
import net.fxgear.fitnshop.e.d;
import net.fxgear.fitnshop.e.f;
import net.fxgear.fitnshop.h;
import net.fxgear.fitnshop.i;

/* compiled from: ClothesListFragment */
public class c extends b implements View.OnClickListener {
    public static final String d = "c";
    /* access modifiers changed from: private */
    public b.a A;
    /* access modifiers changed from: private */
    public b.a.C0035a B;
    /* access modifiers changed from: private */
    public net.fxgear.fitnshop.c.a C;
    private String[] D;
    /* access modifiers changed from: private */
    public int E = 0;
    /* access modifiers changed from: private */
    public int F = 0;
    /* access modifiers changed from: private */
    public Button G;
    private ViewPager.f H = new ViewPager.f() {
        public void a(int i, float f, int i2) {
        }

        public void a(int i) {
            c.this.d(i);
            if (!h.d(c.this.getActivity().getApplicationContext())) {
                c.this.t.setVisibility(0);
                c.this.y.setVisibility(8);
            }
        }

        public void b(int i) {
            if (i == 1 && c.this.E != 0) {
                c.this.h();
            }
        }
    };
    private e.b I = new e.b() {
        public boolean a(c.a aVar, boolean z) {
            boolean z2;
            boolean z3;
            int i;
            String str = c.d;
            i.c(str, "OnClickClothesInWishList() brandID : " + aVar.i() + ", brand : " + aVar.j() + ", wishlist : " + z);
            String str2 = "w";
            if (c.this.getActivity() instanceof FitNShopMainActivity) {
                String e = ((FitNShopMainActivity) c.this.getActivity()).e();
                if (e.equals(GlobalDefine.GENDER_MAN_STRING)) {
                    str2 = m.d;
                } else if (e.equals("girl")) {
                    str2 = "kw";
                } else if (e.equals("boy")) {
                    str2 = "km";
                }
            }
            if (z) {
                f.a("WISH_ADD_CLI", str2 + aVar.a());
                d a2 = d.a(c.this.getActivity().getApplicationContext());
                int f = h.f1164b.f();
                if (f >= 0) {
                    a2.d();
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (f != 0) {
                    boolean z4 = aVar.k() == 1;
                    if (!h.f1164b.h()) {
                        if (aVar.c().equals(GlobalDefine.GENDER_WOMAN_STRING)) {
                            i = 1;
                        } else {
                            i = aVar.c().equals(GlobalDefine.GENDER_MAN_STRING) ? 2 : 3;
                        }
                        z3 = a2.a(String.valueOf(aVar.a()), aVar.l(), aVar.m(), z4, i, aVar.d() ? 1 : 2);
                    } else {
                        z3 = a2.a(String.valueOf(aVar.a()), aVar.l(), aVar.m(), z4);
                    }
                    if (!z3) {
                        Log.e(c.d, "ERROR :: add item fail.");
                        return false;
                    }
                }
            } else {
                f.a("WISH_REM_CLI", str2 + aVar.a());
                if (!d.a(c.this.getActivity().getApplicationContext()).a(String.valueOf(aVar.a()))) {
                    Log.e(c.d, "ERROR :: remove item fail.");
                    return false;
                }
                z2 = false;
            }
            c.this.g();
            if (z2) {
                c.this.e();
            }
            return true;
        }

        public boolean a(c.a aVar) {
            boolean z;
            int i;
            int i2;
            int i3;
            String str = c.d;
            i.c(str, "OnClickClothesImage() product_uuid : " + aVar.a());
            if (!(c.this.getActivity() instanceof FitNShopMainActivity)) {
                return false;
            }
            FitNShopMainActivity fitNShopMainActivity = (FitNShopMainActivity) c.this.getActivity();
            String e = fitNShopMainActivity.e();
            String str2 = "w";
            if (e.equals(GlobalDefine.GENDER_MAN_STRING)) {
                str2 = m.d;
            } else if (e.equals("girl")) {
                str2 = "kw";
            } else if (e.equals("boy")) {
                str2 = "km";
            }
            f.a("PRD_THUMBNAIL_CLI", str2 + aVar.a());
            String valueOf = String.valueOf(aVar.a());
            d a2 = d.a((Context) fitNShopMainActivity);
            if (!a2.b(valueOf)) {
                a2.d();
                boolean z2 = aVar.k() == 1;
                if (!h.f1164b.h()) {
                    if (aVar.c().equals(GlobalDefine.GENDER_WOMAN_STRING)) {
                        if (aVar.d()) {
                            i2 = 1;
                        } else {
                            i3 = 1;
                            i = 2;
                            z = a2.a(valueOf, aVar.l(), aVar.m(), z2, i2, i);
                        }
                    } else if (aVar.c().equals(GlobalDefine.GENDER_MAN_STRING)) {
                        if (aVar.d()) {
                            i2 = 2;
                        } else {
                            i3 = 2;
                            i = 2;
                            z = a2.a(valueOf, aVar.l(), aVar.m(), z2, i2, i);
                        }
                    } else if (aVar.d()) {
                        i2 = 3;
                    } else {
                        i3 = 3;
                        i = 2;
                        z = a2.a(valueOf, aVar.l(), aVar.m(), z2, i2, i);
                    }
                    i = 1;
                    z = a2.a(valueOf, aVar.l(), aVar.m(), z2, i2, i);
                } else {
                    z = a2.a(valueOf, aVar.l(), aVar.m(), z2);
                }
                if (!z) {
                    Log.e(c.d, "ERROR :: add item fail.");
                    return false;
                }
            }
            c.this.g();
            fitNShopMainActivity.a("fitting", valueOf, c.d);
            return true;
        }

        public void b(c.a aVar) {
            String str = c.d;
            i.c(str, "OnClickClothesDescription() item_url : " + aVar.e());
            if (c.this.getActivity() instanceof FitNShopMainActivity) {
                FitNShopMainActivity fitNShopMainActivity = (FitNShopMainActivity) c.this.getActivity();
                String e = fitNShopMainActivity.e();
                String str2 = "w";
                if (e.equals(GlobalDefine.GENDER_MAN_STRING)) {
                    str2 = m.d;
                } else if (e.equals("girl")) {
                    str2 = "kw";
                } else if (e.equals("boy")) {
                    str2 = "km";
                }
                f.a("PRD_DETAIL_CLI", str2 + aVar.a());
                if (fitNShopMainActivity.a(aVar.e(), false)) {
                    f.a("PRD_DETAIL_CLI_STATUS", "SUC");
                } else {
                    f.a("PRD_DETAIL_CLI_STATUS", "NETERR");
                }
            }
        }

        public void a(d.a.b bVar) {
            if (bVar != null && (c.this.getActivity() instanceof FitNShopMainActivity)) {
                ((FitNShopMainActivity) c.this.getActivity()).a(bVar.c, false);
            }
        }

        public void a() {
            if (c.this.C == null) {
                net.fxgear.fitnshop.c.a unused = c.this.C = new net.fxgear.fitnshop.c.a(c.this.getActivity(), 0);
            }
            c.this.C.show();
        }

        public void a(int i) {
            if (c.this.C != null) {
                if (c.this.C.isShowing()) {
                    c.this.C.dismiss();
                }
                net.fxgear.fitnshop.c.a unused = c.this.C = null;
            }
        }

        public void b(int i) {
            if (i != -2 && i != -1) {
                c.this.t.setVisibility(0);
                c.this.y.setVisibility(8);
            }
        }

        public void a(ListView listView, int i, int i2) {
            if (i2 < 0) {
                if (c.this.E > (-c.this.F)) {
                    if (c.this.E + i2 < (-c.this.F)) {
                        int unused = c.this.E = -c.this.F;
                    } else {
                        int unused2 = c.this.E = c.this.E + i2;
                    }
                } else if (c.this.E < (-c.this.F)) {
                    int unused3 = c.this.E = -c.this.F;
                }
            } else if (i2 > 0) {
                if (i <= 0) {
                    if (c.this.E < 0) {
                        if (c.this.E + i2 >= 0) {
                            int unused4 = c.this.E = 0;
                        } else {
                            int unused5 = c.this.E = c.this.E + i2;
                        }
                    } else if (c.this.E >= 0) {
                        int unused6 = c.this.E = 0;
                    }
                } else {
                    return;
                }
            }
            if (i == 0) {
                int top = listView.getChildAt(0).getTop();
                if (!((top != 0 && top != c.this.E) || c.this.G == null || c.this.G.getVisibility() == 8)) {
                    c.this.G.setVisibility(8);
                }
            } else if (!(c.this.G == null || c.this.G.getVisibility() == 0)) {
                c.this.G.setVisibility(0);
            }
            if (c.this.g != null) {
                c.this.g.setTranslationY((float) c.this.E);
            }
        }

        public void a(e eVar, int i) {
            View findViewWithTag = c.this.y.findViewWithTag(c.this.z.b(c.this.y.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof e) && findViewWithTag.equals(eVar) && i == 0) {
                c.this.a(eVar.i());
            }
        }
    };
    private final int e = 0;
    /* access modifiers changed from: private */
    public net.fxgear.fitnshop.a.d f;
    /* access modifiers changed from: private */
    public LinearLayout g;
    private RelativeLayout h;
    private RelativeLayout i;
    private RelativeLayout j;
    private RelativeLayout k;
    private TextView l;
    private TextView m;
    private ImageView n;
    private ImageView o;
    private ImageView p;
    private TextView q;
    private TextView r;
    private ImageView s;
    /* access modifiers changed from: private */
    public LinearLayout t;
    private Button u;
    private HorizontalScrollView v;
    private LinearLayout w;
    private LinearLayout.LayoutParams x;
    /* access modifiers changed from: private */
    public ViewPager y;
    /* access modifiers changed from: private */
    public a z;

    public c() {
    }

    public c(net.fxgear.fitnshop.a.d dVar, b.a aVar) {
        this.f = dVar;
        this.A = aVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i(d, "onCreate()+");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        Log.i(d, "onCreateView()+");
        if (this.c == null) {
            this.c = layoutInflater.inflate(2131296271, viewGroup, false);
            this.x = new LinearLayout.LayoutParams(-2, -1);
            this.x.gravity = 17;
            this.g = (LinearLayout) this.c.findViewById(2131165282);
            this.h = (RelativeLayout) this.c.findViewById(2131165276);
            this.i = (RelativeLayout) this.c.findViewById(2131165277);
            this.j = (RelativeLayout) this.c.findViewById(2131165278);
            this.k = (RelativeLayout) this.c.findViewById(2131165279);
            this.j.setOnClickListener(this);
            this.k.setOnClickListener(this);
            String str = GlobalDefine.GENDER_WOMAN_STRING;
            if (getActivity() instanceof FitNShopMainActivity) {
                FitNShopMainActivity fitNShopMainActivity = (FitNShopMainActivity) getActivity();
                i2 = fitNShopMainActivity.g();
                str = fitNShopMainActivity.f();
            } else {
                i2 = 0;
            }
            View inflate = layoutInflater.inflate(2131296293, this.j);
            this.l = (TextView) inflate.findViewById(2131165417);
            this.n = (ImageView) inflate.findViewById(2131165318);
            this.l.setText(str);
            this.D = getResources().getStringArray(2130771973);
            this.m = (TextView) layoutInflater.inflate(2131296293, this.k).findViewById(2131165417);
            this.m.setText(this.D[i2]);
            this.o = (ImageView) this.c.findViewById(2131165186);
            this.p = (ImageView) this.c.findViewById(2131165185);
            this.q = (TextView) this.c.findViewById(2131165188);
            this.r = (TextView) this.c.findViewById(a.e.action_title);
            this.s = (ImageView) this.c.findViewById(2131165187);
            this.c.findViewById(2131165193).setVisibility(8);
            this.o.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.s.setOnClickListener(this);
            if (h.f1164b.d()) {
                this.o.setVisibility(8);
            } else {
                this.o.setVisibility(0);
            }
            this.t = (LinearLayout) this.c.findViewById(2131165342);
            this.u = (Button) this.c.findViewById(2131165231);
            this.u.setOnClickListener(this);
            this.v = (HorizontalScrollView) this.c.findViewById(2131165405);
            this.w = (LinearLayout) this.c.findViewById(2131165348);
            this.y = (ViewPager) this.c.findViewById(2131165428);
            this.z = new a(getActivity());
            this.y.setAdapter(this.z);
            this.y.a(this.H);
            this.y.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    c.this.y.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    if (c.this.f973a == 0 && c.this.A != null) {
                        c.this.a(c.this.A);
                    }
                }
            });
            Button button = (Button) this.c.findViewById(2131165230);
            if (h.f1164b.c()) {
                button.setVisibility(8);
            } else {
                button.setOnClickListener(this);
            }
            this.G = (Button) this.c.findViewById(2131165235);
            this.G.setOnClickListener(this);
            this.G.setVisibility(8);
            Resources resources = getResources();
            this.F = resources.getDimensionPixelSize(2131034132) + resources.getDimensionPixelSize(2131034192);
            this.E = 0;
            g();
        }
        return this.c;
    }

    public void onHiddenChanged(boolean z2) {
        String str = d;
        Log.i(str, "onHiddenChanged()+ " + z2);
        if (!z2) {
            g();
            e();
            if (getActivity() instanceof FitNShopMainActivity) {
                ((FitNShopMainActivity) getActivity()).a(this.A.c());
            }
        }
        super.onHiddenChanged(z2);
    }

    public Animator onCreateAnimator(int i2, boolean z2, int i3) {
        String str = d;
        Log.e(str, "onCreateAnimator()+ enter : " + z2 + ", state : " + this.f973a);
        if (this.f973a == 0) {
            return super.onCreateAnimator(i2, z2, i3);
        }
        final int i4 = this.f973a;
        Animator b2 = b(i4);
        if (b2 != null) {
            b2.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    animator.removeListener(this);
                    if (i4 == 1) {
                        c.this.a(c.this.A);
                    }
                    c.this.f973a = 0;
                }
            });
        }
        return b2;
    }

    public void onResume() {
        super.onResume();
        Log.i(d, "onResume()+");
    }

    public void onPause() {
        Log.i(d, "onPause()+");
        super.onPause();
        View findViewWithTag = this.y.findViewWithTag(this.z.b(this.y.getCurrentItem()));
        if (findViewWithTag != null && (findViewWithTag instanceof e)) {
            e eVar = (e) findViewWithTag;
            eVar.f();
            eVar.g();
        }
    }

    public void onDestroy() {
        if (this.C != null) {
            if (this.C.isShowing()) {
                this.C.dismiss();
            }
            this.C = null;
        }
        this.g = null;
        this.h = null;
        if (this.j != null) {
            this.j.setOnClickListener((View.OnClickListener) null);
            this.j = null;
        }
        if (this.k != null) {
            this.k.setOnClickListener((View.OnClickListener) null);
            this.k = null;
        }
        this.i = null;
        this.l = null;
        this.m = null;
        if (this.o != null) {
            this.o.setOnClickListener((View.OnClickListener) null);
            this.o = null;
        }
        if (this.p != null) {
            this.p.setOnClickListener((View.OnClickListener) null);
            this.p = null;
        }
        if (this.q != null) {
            this.q.setOnClickListener((View.OnClickListener) null);
            this.q = null;
        }
        if (this.s != null) {
            this.s.setOnClickListener((View.OnClickListener) null);
            this.s = null;
        }
        this.r = null;
        if (this.G != null) {
            this.G.setOnClickListener((View.OnClickListener) null);
            this.G = null;
        }
        if (this.u != null) {
            this.u.setOnClickListener((View.OnClickListener) null);
            this.u = null;
        }
        this.t = null;
        if (this.w != null) {
            int childCount = this.w.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.w.getChildAt(i2);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setOnClickListener((View.OnClickListener) null);
                }
            }
            this.w.removeAllViews();
            this.w = null;
        }
        this.x = null;
        this.v = null;
        if (this.y != null) {
            int childCount2 = this.y.getChildCount();
            for (int i3 = 0; i3 < childCount2; i3++) {
                ((e) this.y.getChildAt(i3)).j();
            }
            this.y.b((ViewPager.f) null);
            this.y = null;
        }
        this.I = null;
        this.H = null;
        if (this.z != null) {
            this.z.d();
            this.z = null;
        }
        this.A = null;
        this.B = null;
        this.f = null;
        super.onDestroy();
    }

    public String a() {
        return d;
    }

    public boolean b() {
        if (h.f1164b.c()) {
            return false;
        }
        this.f973a = 4;
        if (!(getActivity() instanceof FitNShopMainActivity)) {
            return false;
        }
        if (h.f1164b.b()) {
            ((g) ((FitNShopMainActivity) getActivity()).c(g.d)).a(3);
            return false;
        }
        ((f) ((FitNShopMainActivity) getActivity()).c(f.d)).a(3);
        return false;
    }

    public void c() {
        g();
        e();
    }

    public void d() {
        this.t.setVisibility(0);
        this.i.setVisibility(8);
        this.v.setVisibility(8);
        this.y.setVisibility(8);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case 2131165185:
            case 2131165188:
                if (getActivity() instanceof FitNShopMainActivity) {
                    ((FitNShopMainActivity) getActivity()).a("wishlist", (String) null, d);
                    f.a("FITBTN_CLI", "");
                    return;
                }
                return;
            case 2131165186:
                if (getActivity() instanceof FitNShopMainActivity) {
                    ((FitNShopMainActivity) getActivity()).b();
                    return;
                }
                return;
            case 2131165187:
                View findViewWithTag = this.y.findViewWithTag(this.z.b(this.y.getCurrentItem()));
                if (findViewWithTag != null && (findViewWithTag instanceof e)) {
                    e eVar = (e) findViewWithTag;
                    eVar.f();
                    if (!eVar.h()) {
                        this.f973a = 0;
                        if (getActivity() instanceof FitNShopMainActivity) {
                            ((FitNShopMainActivity) getActivity()).d();
                            f.a("SEARCH_BTN_CLI", "");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 2131165230:
                this.f973a = 4;
                if (getActivity() instanceof FitNShopMainActivity) {
                    FitNShopMainActivity fitNShopMainActivity = (FitNShopMainActivity) getActivity();
                    if (h.f1164b.b()) {
                        ((g) fitNShopMainActivity.c(g.d)).a(3);
                    } else {
                        ((f) fitNShopMainActivity.c(f.d)).a(3);
                    }
                    fitNShopMainActivity.b(d);
                    return;
                }
                return;
            case 2131165231:
                if (h.d(getActivity())) {
                    this.t.setVisibility(8);
                    if (!h.f1164b.c() || this.A != null) {
                        if (this.A != null && this.A.d().length == h.d.length) {
                            if (this.i.getVisibility() != 0) {
                                this.i.setVisibility(0);
                            }
                            if (this.v.getVisibility() != 0) {
                                this.v.setVisibility(0);
                            }
                            if (this.y.getVisibility() != 0) {
                                this.y.setVisibility(0);
                            }
                            View findViewWithTag2 = this.y.findViewWithTag(this.z.b(this.y.getCurrentItem()));
                            if (findViewWithTag2 != null && (findViewWithTag2 instanceof e)) {
                                ((e) findViewWithTag2).c();
                                return;
                            }
                            return;
                        } else if (getActivity() instanceof FitNShopMainActivity) {
                            ((FitNShopMainActivity) getActivity()).c(this.A.b());
                            return;
                        } else {
                            return;
                        }
                    } else if (getActivity() instanceof FitNShopMainActivity) {
                        ((FitNShopMainActivity) getActivity()).a(true);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case 2131165235:
                View findViewWithTag3 = this.y.findViewWithTag(this.z.b(this.y.getCurrentItem()));
                if (findViewWithTag3 != null && (findViewWithTag3 instanceof e)) {
                    ((e) findViewWithTag3).e();
                    h();
                    return;
                }
                return;
            case 2131165278:
                c(0);
                return;
            case 2131165279:
                c(1);
                return;
            default:
                return;
        }
    }

    private void c(final int i2) {
        if (getActivity() instanceof FitNShopMainActivity) {
            final net.fxgear.fitnshop.c.e eVar = new net.fxgear.fitnshop.c.e(getActivity());
            FitNShopMainActivity fitNShopMainActivity = (FitNShopMainActivity) getActivity();
            if (i2 == 0) {
                String[] d2 = this.A.d();
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                for (int i4 = 0; i4 < d2.length; i4++) {
                    String str = d2[i4];
                    if (str.equals(fitNShopMainActivity.e())) {
                        i3 = i4;
                    }
                    arrayList.add(fitNShopMainActivity.e(str));
                }
                eVar.a(getActivity().getResources().getString(2131361893));
                eVar.a((String[]) arrayList.toArray(new String[arrayList.size()]), i3);
            } else {
                eVar.a(getActivity().getResources().getString(2131361836));
                eVar.a(this.D, fitNShopMainActivity.g());
            }
            eVar.a((e.c) new e.c() {
                public void a(int i, String str) {
                    String str2 = "SEX_CLI";
                    if (i2 != 0) {
                        str2 = "SORT_CLI";
                    }
                    f.a(str2, "");
                    eVar.dismiss();
                    c.this.a(i2, i, str);
                }
            });
            eVar.show();
        }
    }

    /* access modifiers changed from: private */
    public void a(final int i2, final int i3, final String str) {
        if (getActivity() instanceof FitNShopMainActivity) {
            FitNShopMainActivity fitNShopMainActivity = (FitNShopMainActivity) getActivity();
            if (h.d(fitNShopMainActivity.getApplicationContext())) {
                if (i2 == 0) {
                    if (this.t.getVisibility() != 8) {
                        this.t.setVisibility(8);
                        if (this.i.getVisibility() != 0) {
                            this.i.setVisibility(0);
                        }
                        if (this.v.getVisibility() != 0) {
                            this.v.setVisibility(0);
                        }
                        this.y.setVisibility(0);
                    }
                    fitNShopMainActivity.g(str);
                    this.l.setText(str);
                    String e2 = fitNShopMainActivity.e();
                    a(this.A.a(e2));
                    this.z.a(this.A.b(), this.A.a(e2));
                    this.z.c();
                    this.y.a(0, false);
                    e(0);
                } else {
                    fitNShopMainActivity.b(i3);
                    this.m.setText(str);
                }
                View findViewWithTag = this.y.findViewWithTag(this.z.b(this.y.getCurrentItem()));
                if (findViewWithTag != null && (findViewWithTag instanceof net.fxgear.fitnshop.e)) {
                    int childCount = this.y.getChildCount();
                    for (int i4 = 0; i4 < childCount; i4++) {
                        View childAt = this.y.getChildAt(i4);
                        if (childAt != null && (childAt instanceof net.fxgear.fitnshop.e)) {
                            net.fxgear.fitnshop.e eVar = (net.fxgear.fitnshop.e) childAt;
                            if (childAt.equals(findViewWithTag)) {
                                eVar.a(this.I);
                                eVar.a();
                                eVar.b();
                                ListView i5 = eVar.i();
                                if (i5 != null && i5.getChildCount() > 0) {
                                    if (i5.getFirstVisiblePosition() == 0 && i5.getChildAt(0).getTop() == 0) {
                                        if (!(this.G == null || this.G.getVisibility() == 8)) {
                                            this.G.setVisibility(8);
                                        }
                                    } else if (!(this.G == null || this.G.getVisibility() == 0)) {
                                        this.G.setVisibility(0);
                                    }
                                }
                            } else {
                                eVar.a((e.b) null);
                            }
                        }
                    }
                    return;
                }
                return;
            }
            a((Runnable) new Runnable() {
                public void run() {
                    c.this.a(i2, i3, str);
                }
            });
        }
    }

    private void a(final Runnable runnable) {
        if (getActivity() instanceof FitNShopMainActivity) {
            ((FitNShopMainActivity) getActivity()).a((b.a) new b.a() {
                public void a(net.fxgear.fitnshop.c.b bVar) {
                    bVar.dismiss();
                    if (runnable != null) {
                        runnable.run();
                    }
                }

                public void b(net.fxgear.fitnshop.c.b bVar) {
                    bVar.dismiss();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        View findViewWithTag = this.y.findViewWithTag(this.z.b(this.y.getCurrentItem()));
        if (findViewWithTag != null && (findViewWithTag instanceof net.fxgear.fitnshop.e)) {
            ((net.fxgear.fitnshop.e) findViewWithTag).d();
        }
    }

    public void a(b.a aVar) {
        Log.i(d, "LoadBrandItem()+ ");
        if (aVar == null) {
            Log.d(d, "brandItem is null, check param");
            return;
        }
        this.A = aVar;
        if (this.r != null) {
            this.r.setText(aVar.c());
        }
        this.E = 0;
        this.g.setTranslationY((float) this.E);
        String str = GlobalDefine.GENDER_WOMAN_STRING;
        if (getActivity() instanceof FitNShopMainActivity) {
            FitNShopMainActivity fitNShopMainActivity = (FitNShopMainActivity) getActivity();
            fitNShopMainActivity.a(aVar.c());
            String[] d2 = aVar.d();
            if (d2.length == 1) {
                this.j.setEnabled(false);
                this.l.setEnabled(false);
                this.n.setVisibility(8);
                str = d2[0];
                fitNShopMainActivity.d(str);
            } else if (d2.length > 1) {
                this.j.setEnabled(true);
                this.l.setEnabled(true);
                this.n.setVisibility(0);
                str = fitNShopMainActivity.e();
                if (!aVar.b(str)) {
                    str = d2[0];
                    fitNShopMainActivity.d(str);
                }
            }
            this.l.setText(fitNShopMainActivity.e(str));
        }
        if (!h.d(getActivity().getApplicationContext())) {
            this.t.setVisibility(0);
            this.i.setVisibility(8);
            this.v.setVisibility(8);
            this.y.setVisibility(8);
        } else {
            if (this.i.getVisibility() != 0) {
                this.i.setVisibility(0);
            }
            if (this.v.getVisibility() != 0) {
                this.v.setVisibility(0);
            }
            if (this.y.getVisibility() != 0) {
                this.y.setVisibility(0);
            }
        }
        a(aVar.a(str));
        this.z.a(aVar.b(), aVar.a(str));
        this.z.c();
        this.y.a(0, false);
        d(0);
    }

    private void a(ArrayList<b.a.C0035a> arrayList) {
        int childCount = this.w.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.w.getChildAt(i2);
            if (childAt instanceof TextView) {
                ((TextView) childAt).setOnClickListener((View.OnClickListener) null);
            }
        }
        this.w.removeAllViews();
        if (this.B == null) {
            this.B = new b.a.C0035a(-1, getResources().getString(a.g.category_name_all));
        }
        TextView f2 = f();
        f2.setTag(0);
        f2.setText(this.B.b().toUpperCase());
        Resources resources = getResources();
        this.x.leftMargin = resources.getDimensionPixelSize(2131034185);
        this.x.rightMargin = resources.getDimensionPixelSize(2131034195);
        this.w.addView(f2, this.x);
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            this.x.leftMargin = resources.getDimensionPixelSize(2131034194);
            this.x.rightMargin = resources.getDimensionPixelSize(2131034195);
            int i3 = 0;
            while (i3 < size) {
                TextView f3 = f();
                int i4 = i3 + 1;
                f3.setTag(Integer.valueOf(i4));
                f3.setText(arrayList.get(i3).b().toUpperCase());
                if (i3 == size - 1) {
                    this.x.leftMargin = resources.getDimensionPixelSize(2131034194);
                    this.x.rightMargin = resources.getDimensionPixelSize(2131034191);
                }
                this.w.addView(f3, this.x);
                i3 = i4;
            }
        }
        this.v.scrollTo(0, 0);
    }

    private TextView f() {
        TextView textView = new TextView(getActivity());
        textView.setTextSize(0, (float) getResources().getDimensionPixelSize(2131034193));
        textView.setTypeface(textView.getTypeface(), 1);
        textView.setGravity(17);
        a(textView, false);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                c.this.h();
                c.this.a(view);
            }
        });
        return textView;
    }

    private void a(TextView textView, boolean z2) {
        if (textView == null) {
            return;
        }
        if (z2) {
            textView.setTextColor(getResources().getColor(2130968586));
            textView.setBackgroundResource(2131099772);
            return;
        }
        textView.setTextColor(getResources().getColor(2130968587));
        textView.setBackgroundColor(0);
    }

    /* access modifiers changed from: private */
    public void a(final View view) {
        if (h.d(getActivity().getApplicationContext())) {
            if (this.t.getVisibility() != 8) {
                this.t.setVisibility(8);
                if (this.i.getVisibility() != 0) {
                    this.i.setVisibility(0);
                }
                if (this.v.getVisibility() != 0) {
                    this.v.setVisibility(0);
                }
                this.y.setVisibility(0);
            }
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof Integer)) {
                Log.e(d, "ERROR :: Category click... wrong tag type!!!");
                return;
            }
            int intValue = ((Integer) tag).intValue();
            if (intValue >= 0) {
                this.y.a(intValue, false);
            } else {
                Log.e(d, "ERROR :: Invalid index!!!");
            }
        } else {
            a((Runnable) new Runnable() {
                public void run() {
                    c.this.a(view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void d(int i2) {
        String str = d;
        Log.d(str, "LoadPageLayoutWithFocusCategory()+, pageIndex : " + i2);
        e(i2);
        View findViewWithTag = this.y.findViewWithTag(this.z.b(i2));
        if (findViewWithTag != null && (findViewWithTag instanceof net.fxgear.fitnshop.e)) {
            int childCount = this.y.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.y.getChildAt(i3);
                if (childAt != null && (childAt instanceof net.fxgear.fitnshop.e)) {
                    net.fxgear.fitnshop.e eVar = (net.fxgear.fitnshop.e) childAt;
                    if (childAt.equals(findViewWithTag)) {
                        eVar.a(this.I);
                        eVar.b();
                        ListView i4 = eVar.i();
                        if (i4 != null && i4.getChildCount() > 0) {
                            if (i4.getFirstVisiblePosition() == 0 && i4.getChildAt(0).getTop() == 0) {
                                if (!(this.G == null || this.G.getVisibility() == 8)) {
                                    this.G.setVisibility(8);
                                }
                            } else if (!(this.G == null || this.G.getVisibility() == 0)) {
                                this.G.setVisibility(0);
                            }
                        }
                    } else {
                        eVar.a((e.b) null);
                    }
                }
            }
        }
    }

    private void e(int i2) {
        Log.d(d, "FocusCategoryScrollView()+");
        int childCount = this.w.getChildCount();
        if (i2 < 0 || i2 >= childCount) {
            String str = d;
            Log.e(str, "ERROR :: IllegalArgumentException, index : " + i2);
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i3 = displayMetrics.widthPixels / 2;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = this.w.getChildAt(i4);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (i4 == i2) {
                    a(textView, true);
                    int left = (textView.getLeft() + (textView.getWidth() / 2)) - i3;
                    String str2 = d;
                    Log.i(str2, "FocusCategoryScrollView() move scroll to " + left);
                    this.v.smoothScrollTo(left, this.v.getScrollY());
                } else {
                    a(textView, false);
                }
            } else {
                Log.e(d, "ERROR :: not TextView!!!");
            }
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        if (this.q != null) {
            h.a((Context) getActivity(), this.q);
        }
    }

    /* access modifiers changed from: private */
    public void a(final ListView listView) {
        int i2;
        int i3;
        int i4;
        if (this.E != (-this.F) && this.E != 0) {
            int i5 = 0;
            if ((-this.E) < this.F / 2) {
                i4 = listView.getChildAt(0).getTop();
                i3 = this.E;
                i2 = 0;
            } else {
                i4 = listView.getChildAt(0).getTop();
                int i6 = -this.F;
                i3 = this.E;
                i2 = i6;
                i5 = -this.F;
            }
            a(i3, i5, 500, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int unused = c.this.E = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (c.this.g != null) {
                        c.this.g.setTranslationY((float) c.this.E);
                    }
                }
            }).start();
            final int firstVisiblePosition = listView.getFirstVisiblePosition();
            a(i4, i2, 500, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    listView.setSelectionFromTop(firstVisiblePosition, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }).start();
        }
    }

    private ValueAnimator a(int i2, int i3, int i4, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i2, i3});
        ofInt.addUpdateListener(animatorUpdateListener);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration((long) i4);
        return ofInt;
    }

    /* access modifiers changed from: private */
    public void h() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.E, 0});
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(250);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = c.this.E = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (c.this.g != null) {
                    c.this.g.setTranslationY((float) c.this.E);
                }
            }
        });
        ofInt.start();
    }

    /* compiled from: ClothesListFragment */
    private class a extends k {

        /* renamed from: b  reason: collision with root package name */
        private final String f994b = a.class.getSimpleName();
        private Context c;
        private int d;
        private ArrayList<b.a.C0035a> e;

        public int a(Object obj) {
            return -2;
        }

        public a(Context context) {
            this.c = context;
            this.e = new ArrayList<>();
        }

        public void a(int i, ArrayList<b.a.C0035a> arrayList) {
            if (!this.e.isEmpty()) {
                this.e.clear();
            }
            this.d = i;
            this.e.add(c.this.B);
            if (arrayList != null && !arrayList.isEmpty()) {
                this.e.addAll(arrayList);
            }
        }

        public void d() {
            this.c = null;
            if (this.e != null) {
                this.e.clear();
                this.e = null;
            }
        }

        public int a() {
            return this.e.size();
        }

        public boolean a(View view, Object obj) {
            return view.equals(obj);
        }

        public Object a(ViewGroup viewGroup, int i) {
            int i2;
            String str;
            String str2 = this.f994b;
            Log.e(str2, "instantiateItem : " + i);
            if (c.this.getActivity() instanceof FitNShopMainActivity) {
                FitNShopMainActivity fitNShopMainActivity = (FitNShopMainActivity) c.this.getActivity();
                String e2 = fitNShopMainActivity.e();
                i2 = fitNShopMainActivity.g();
                str = e2;
            } else {
                str = GlobalDefine.GENDER_WOMAN_STRING;
                i2 = 0;
            }
            net.fxgear.fitnshop.e eVar = new net.fxgear.fitnshop.e(this.c, c.this.F, c.this.f, this.d, this.e.get(i).a(), str, i2);
            ((ViewPager) viewGroup).addView(eVar);
            eVar.setTag(b(i));
            return eVar;
        }

        public void a(ViewGroup viewGroup, int i, Object obj) {
            String str = this.f994b;
            Log.e(str, "destroyItem : " + i);
            net.fxgear.fitnshop.e eVar = (net.fxgear.fitnshop.e) obj;
            eVar.a((e.b) null);
            ((ViewPager) viewGroup).removeView(eVar);
            eVar.j();
        }

        public String b(int i) {
            return this.f994b + i;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\d\d.java ==========

package net.fxgear.fitnshop.d;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import net.fxgear.fitnshop.b.d;

/* compiled from: FaceCaptureFragment */
public class d extends b implements View.OnClickListener {
    /* access modifiers changed from: private */
    public final String d;
    private RelativeLayout e;
    /* access modifiers changed from: private */
    public View f;
    /* access modifiers changed from: private */
    public net.fxgear.fitnshop.b.d g;
    /* access modifiers changed from: private */
    public boolean h;
    /* access modifiers changed from: private */
    public boolean i;
    private a j;
    private d.a k;
    private SurfaceHolder.Callback l;
    private TextureView.SurfaceTextureListener m;

    /* compiled from: FaceCaptureFragment */
    public interface a {
        void a();

        void a(int i, Object obj);

        void a(String str);
    }

    public boolean b() {
        return false;
    }

    public void c() {
    }

    public void d() {
    }

    public d() {
        this((a) null);
    }

    public d(a aVar) {
        this.d = d.class.getSimpleName();
        this.h = false;
        this.i = true;
        this.k = new d.a() {
            public void a(int i, String str) {
            }

            public void a(byte[] bArr, int i) {
                d.this.a(bArr, i);
            }
        };
        this.l = new SurfaceHolder.Callback() {
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                String a2 = d.this.d;
                Log.d(a2, "surfaceCreated()+, mIsForeground: " + d.this.h);
                if (Build.VERSION.SDK_INT < 21 && d.this.h && d.this.g != null) {
                    d.this.g.a((View) (SurfaceView) d.this.f);
                    d.this.g.c(d.this.i ^ true ? 1 : 0, d.this.f.getWidth(), d.this.f.getHeight());
                }
            }

            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                Log.d(d.this.d, "surfaceChanged()+");
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                Log.d(d.this.d, "surfaceDestroyed()+");
                Log.d(d.this.d, "holder.removeCallback");
                surfaceHolder.removeCallback(this);
            }
        };
        this.m = new TextureView.SurfaceTextureListener() {
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                String a2 = d.this.d;
                Log.d(a2, "onSurfaceTextureAvailable()+, mIsForeground: " + d.this.h);
                if (Build.VERSION.SDK_INT >= 21 && d.this.h && d.this.g != null) {
                    d.this.g.a((View) (net.fxgear.fitnshop.b.a) d.this.f);
                    d.this.g.c(d.this.i ^ true ? 1 : 0, i, i2);
                }
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                Log.d(d.this.d, "onSurfaceTextureSizeChanged()+");
                if (Build.VERSION.SDK_INT >= 21 && d.this.g != null) {
                    d.this.g.a(i, i2);
                }
            }

            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                Log.d(d.this.d, "onSurfaceTextureDestroyed()+");
                if (d.this.f == null) {
                    return true;
                }
                Log.d(d.this.d, "remove SurfaceTextureListener");
                ((net.fxgear.fitnshop.b.a) d.this.f).setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
                return true;
            }
        };
        this.j = aVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i(this.d, "onCreate()+");
        getActivity().getWindow().addFlags(128);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f = new net.fxgear.fitnshop.b.a(getActivity());
        } else {
            this.f = new SurfaceView(getActivity());
        }
        this.f.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.g = new net.fxgear.fitnshop.b.d(this.f974b, this.k);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Log.i(this.d, "onCreateView()+");
        if (layoutInflater == null) {
            return null;
        }
        View inflate = layoutInflater.inflate(2131296272, viewGroup, false);
        ((Button) inflate.findViewById(2131165298)).setOnClickListener(this);
        ((Button) inflate.findViewById(2131165295)).setOnClickListener(this);
        ((Button) inflate.findViewById(2131165297)).setOnClickListener(this);
        ((Button) inflate.findViewById(2131165296)).setOnClickListener(this);
        this.e = (RelativeLayout) inflate.findViewById(2131165345);
        if (this.f == null) {
            return inflate;
        }
        this.e.addView(this.f);
        return inflate;
    }

    public void onResume() {
        super.onResume();
        Log.i(this.d, "onResume()+");
        this.h = true;
        if (this.f == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            boolean isAvailable = ((net.fxgear.fitnshop.b.a) this.f).isAvailable();
            String str = this.d;
            Log.d(str, "textureView.isAvailable: " + isAvailable);
            if (!isAvailable) {
                Log.d(this.d, "setSurfaceTextureListener");
                ((net.fxgear.fitnshop.b.a) this.f).setSurfaceTextureListener(this.m);
            } else if (this.g != null) {
                this.g.c(true ^ this.i ? 1 : 0, this.f.getWidth(), this.f.getHeight());
            }
        } else {
            SurfaceHolder holder = ((SurfaceView) this.f).getHolder();
            Surface surface = holder.getSurface();
            boolean isValid = surface != null ? surface.isValid() : false;
            String str2 = this.d;
            Log.d(str2, "surface.isValid: " + isValid);
            if (!isValid) {
                Log.d(this.d, "cameraSurfaceHolder.addCallback");
                holder.addCallback(this.l);
            } else if (this.g != null) {
                this.g.c(true ^ this.i ? 1 : 0, this.f.getWidth(), this.f.getHeight());
            }
        }
    }

    public void onPause() {
        Log.i(this.d, "onPause()+");
        this.h = false;
        if (this.g != null) {
            this.g.a();
        }
        super.onPause();
    }

    public void onDestroyView() {
        Log.i(this.d, "onDestroyView()+");
        if (this.e != null) {
            this.e.removeAllViews();
        }
        super.onDestroyView();
    }

    public void onDestroy() {
        Log.i(this.d, "onDestroy()+");
        this.j = null;
        if (this.g != null) {
            this.g.c();
            this.g = null;
        }
        if (this.e != null) {
            this.e.removeAllViews();
        }
        if (this.f != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                ((net.fxgear.fitnshop.b.a) this.f).setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
            } else {
                ((SurfaceView) this.f).getHolder().removeCallback(this.l);
            }
            this.f = null;
        }
        super.onDestroy();
    }

    public String a() {
        return this.d;
    }

    public void onClick(View view) {
        if (view != null) {
            switch (view.getId()) {
                case 2131165295:
                    Log.i(this.d, "onClick(), close current view");
                    if (this.j != null) {
                        this.j.a(0, (Object) null);
                        return;
                    }
                    return;
                case 2131165296:
                    Log.i(this.d, "onClick(), go to gallery");
                    if (this.j != null) {
                        this.j.a();
                        return;
                    }
                    return;
                case 2131165297:
                    Log.i(this.d, "onClick(), take a picture");
                    if (this.g != null) {
                        this.g.b();
                        return;
                    }
                    return;
                case 2131165298:
                    Log.i(this.d, "onClick(), switch camera front or back");
                    boolean z = this.i;
                    if (this.g.b(z ? 1 : 0, this.f.getWidth(), this.f.getHeight())) {
                        this.i = !this.i;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v18, types: [java.lang.Long] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(byte[] r23, int r24) {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            r2 = r24
            java.lang.String r3 = r1.d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "SaveFaceImageFile()+, directionOfCamera: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            android.util.Log.i(r3, r4)
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyyMMdd_HHmmss"
            r3.<init>(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.util.Date r5 = new java.util.Date
            long r6 = java.lang.System.currentTimeMillis()
            r5.<init>(r6)
            java.lang.String r3 = r3.format(r5)
            r4.append(r3)
            java.lang.String r3 = ".jpg"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.io.File r4 = new java.io.File
            java.lang.String r5 = net.fxgear.fitnshop.AvatarFaceCameraActivity.f765a
            r4.<init>(r5)
            boolean r5 = r4.exists()
            if (r5 != 0) goto L_0x0051
            r4.mkdirs()
        L_0x0051:
            java.lang.String r5 = r4.getAbsolutePath()
            r6 = 1
            r7 = 0
            r8 = -1
            if (r0 == 0) goto L_0x0162
            if (r5 == 0) goto L_0x0162
            java.io.File r9 = r4.getAbsoluteFile()
            long r9 = net.fxgear.fitnshop.h.a((java.io.File) r9)
            int r11 = r0.length
            long r11 = (long) r11
            r13 = 4
            int r14 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r14 > 0) goto L_0x0159
            java.io.File r9 = r1.a((byte[]) r0, (java.lang.String) r5, (java.lang.String) r3)
            if (r9 == 0) goto L_0x014d
            boolean r0 = r9.exists()
            if (r0 == 0) goto L_0x014d
            java.lang.String r10 = r9.getAbsolutePath()
            r11 = 3
            r12 = 0
            android.media.ExifInterface r0 = new android.media.ExifInterface     // Catch:{ IOException -> 0x00bc }
            r0.<init>(r10)     // Catch:{ IOException -> 0x00bc }
            java.lang.String r14 = "Orientation"
            int r0 = r0.getAttributeInt(r14, r6)     // Catch:{ IOException -> 0x00bc }
            java.lang.String r6 = r1.d     // Catch:{ IOException -> 0x00bc }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00bc }
            r14.<init>()     // Catch:{ IOException -> 0x00bc }
            java.lang.String r15 = "SaveFaceImageFile(), exifOrientation: "
            r14.append(r15)     // Catch:{ IOException -> 0x00bc }
            r14.append(r0)     // Catch:{ IOException -> 0x00bc }
            java.lang.String r15 = " (0: ORIENTATION_UNDEFINED, 3: ORIENTATION_ROTATE_180, 6: ORIENTATION_ROTATE_90, 8: ORIENTATION_ROTATE_270"
            r14.append(r15)     // Catch:{ IOException -> 0x00bc }
            java.lang.String r14 = r14.toString()     // Catch:{ IOException -> 0x00bc }
            android.util.Log.e(r6, r14)     // Catch:{ IOException -> 0x00bc }
            if (r0 == r11) goto L_0x00b7
            r6 = 6
            if (r0 == r6) goto L_0x00b2
            r6 = 8
            if (r0 == r6) goto L_0x00ad
            goto L_0x00c7
        L_0x00ad:
            r0 = 270(0x10e, float:3.78E-43)
            r12 = 270(0x10e, float:3.78E-43)
            goto L_0x00c7
        L_0x00b2:
            r0 = 90
            r12 = 90
            goto L_0x00c7
        L_0x00b7:
            r0 = 180(0xb4, float:2.52E-43)
            r12 = 180(0xb4, float:2.52E-43)
            goto L_0x00c7
        L_0x00bc:
            r0 = move-exception
            java.lang.String r6 = r1.d
            java.lang.String r14 = "[ERROR] :: ExifInterface IOException"
            android.util.Log.e(r6, r14)
            r0.printStackTrace()
        L_0x00c7:
            java.lang.String r0 = r1.d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r14 = "SaveFaceImageFile(), rotateDegree: "
            r6.append(r14)
            r6.append(r12)
            java.lang.String r6 = r6.toString()
            android.util.Log.i(r0, r6)
            if (r12 != 0) goto L_0x00eb
            if (r2 != 0) goto L_0x00e2
            goto L_0x00eb
        L_0x00e2:
            java.lang.String r0 = r1.d
            java.lang.String r2 = "rotateDegree is 0"
            android.util.Log.d(r0, r2)
            r13 = -1
            goto L_0x0149
        L_0x00eb:
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r10)
            android.graphics.Bitmap r14 = net.fxgear.customface.BitmapUtil.GetRotatedBitmap(r0, r12)
            if (r14 == 0) goto L_0x0116
            if (r2 != 0) goto L_0x0116
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            r6 = 1065353216(0x3f800000, float:1.0)
            r0.preScale(r2, r6)
            r15 = 0
            r16 = 0
            int r17 = r14.getWidth()
            int r18 = r14.getHeight()
            r20 = 1
            r19 = r0
            android.graphics.Bitmap r14 = android.graphics.Bitmap.createBitmap(r14, r15, r16, r17, r18, r19, r20)
        L_0x0116:
            java.io.File r0 = r4.getAbsoluteFile()
            long r15 = net.fxgear.fitnshop.h.a((java.io.File) r0)
            int r0 = net.fxgear.customface.BitmapUtil.GetBitmapFileSize(r14)
            long r11 = (long) r0
            int r0 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r0 > 0) goto L_0x0142
            java.io.File r0 = r1.a((android.graphics.Bitmap) r14, (java.lang.String) r5, (java.lang.String) r3)
            if (r0 == 0) goto L_0x0136
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x0136
            r21 = -1
            goto L_0x013f
        L_0x0136:
            java.lang.String r0 = r1.d
            java.lang.String r2 = "[ERROR] :: failed to save rotated bitmap file."
            android.util.Log.e(r0, r2)
            r21 = 3
        L_0x013f:
            r13 = r21
            goto L_0x0149
        L_0x0142:
            r0 = 0
            long r11 = r11 - r15
            java.lang.Long r0 = java.lang.Long.valueOf(r11)
            r7 = r0
        L_0x0149:
            r0 = r7
            r7 = r9
            r6 = r13
            goto L_0x016a
        L_0x014d:
            java.lang.String r0 = r1.d
            java.lang.String r2 = "[ERROR] :: faceImageFile is not exist."
            android.util.Log.e(r0, r2)
            r0 = 2
            r0 = r7
            r7 = r9
            r6 = 2
            goto L_0x016a
        L_0x0159:
            int r0 = r0.length
            long r2 = (long) r0
            long r2 = r2 - r9
            java.lang.Long r0 = java.lang.Long.valueOf(r2)
            r6 = 4
            goto L_0x016a
        L_0x0162:
            java.lang.String r0 = r1.d
            java.lang.String r2 = "[ERROR] :: data is null"
            android.util.Log.e(r0, r2)
            r0 = r7
        L_0x016a:
            net.fxgear.fitnshop.d.d$a r2 = r1.j
            if (r2 == 0) goto L_0x0181
            if (r6 != r8) goto L_0x017c
            if (r7 == 0) goto L_0x017c
            net.fxgear.fitnshop.d.d$a r0 = r1.j
            java.lang.String r2 = r7.getAbsolutePath()
            r0.a(r2)
            goto L_0x0181
        L_0x017c:
            net.fxgear.fitnshop.d.d$a r2 = r1.j
            r2.a(r6, r0)
        L_0x0181:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.d.d.a(byte[], int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007a, code lost:
        r7 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007b, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007d, code lost:
        r7 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007e, code lost:
        r8 = null;
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0090, code lost:
        r8.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0094, code lost:
        r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009b, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009f, code lost:
        r6.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a3, code lost:
        android.util.Log.e(r5.d, "[ERROR] :: failed to close FileOutputStream for saving bitmap.");
        r6.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ae, code lost:
        r7 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00af, code lost:
        r8 = null;
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c1, code lost:
        r8.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c5, code lost:
        r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00cd, code lost:
        r6.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:2:0x0021] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0090 A[Catch:{ all -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0097 A[SYNTHETIC, Splitter:B:38:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009f A[Catch:{ IOException -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c1 A[Catch:{ all -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c8 A[SYNTHETIC, Splitter:B:53:0x00c8] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00cd A[Catch:{ IOException -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d4 A[SYNTHETIC, Splitter:B:59:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00dc A[Catch:{ IOException -> 0x00d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x0080=Splitter:B:32:0x0080, B:47:0x00b1=Splitter:B:47:0x00b1} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.File a(android.graphics.Bitmap r6, java.lang.String r7, java.lang.String r8) {
        /*
            r5 = this;
            java.lang.String r0 = r5.d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "SaveBitmapFile()+, fileDirectoryPath: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = ", fileName: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
            r0 = 0
            if (r6 == 0) goto L_0x00eb
            java.io.File r1 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00ae, Exception -> 0x007d, all -> 0x007a }
            r1.<init>(r7)     // Catch:{ FileNotFoundException -> 0x00ae, Exception -> 0x007d, all -> 0x007a }
            boolean r7 = r1.exists()     // Catch:{ FileNotFoundException -> 0x00ae, Exception -> 0x007d, all -> 0x007a }
            if (r7 != 0) goto L_0x002f
            r1.mkdirs()     // Catch:{ FileNotFoundException -> 0x00ae, Exception -> 0x007d, all -> 0x007a }
        L_0x002f:
            java.io.File r7 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00ae, Exception -> 0x007d, all -> 0x007a }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ FileNotFoundException -> 0x00ae, Exception -> 0x007d, all -> 0x007a }
            r7.<init>(r1, r8)     // Catch:{ FileNotFoundException -> 0x00ae, Exception -> 0x007d, all -> 0x007a }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0074, Exception -> 0x006e, all -> 0x007a }
            r8.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0074, Exception -> 0x006e, all -> 0x007a }
            r8.flush()     // Catch:{ FileNotFoundException -> 0x0068, Exception -> 0x0062, all -> 0x005e }
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ FileNotFoundException -> 0x0068, Exception -> 0x0062, all -> 0x005e }
            r2 = 100
            r6.compress(r1, r2, r8)     // Catch:{ FileNotFoundException -> 0x0068, Exception -> 0x0062, all -> 0x005e }
            r8.close()     // Catch:{ IOException -> 0x0050 }
            if (r6 == 0) goto L_0x005b
            r6.recycle()     // Catch:{ IOException -> 0x0050 }
            goto L_0x005b
        L_0x0050:
            r6 = move-exception
            java.lang.String r8 = r5.d
            java.lang.String r0 = "[ERROR] :: failed to close FileOutputStream for saving bitmap."
            android.util.Log.e(r8, r0)
            r6.printStackTrace()
        L_0x005b:
            r0 = r7
            goto L_0x00eb
        L_0x005e:
            r7 = move-exception
            r1 = r8
            goto L_0x00d2
        L_0x0062:
            r1 = move-exception
            r4 = r8
            r8 = r7
            r7 = r1
            r1 = r4
            goto L_0x0080
        L_0x0068:
            r1 = move-exception
            r4 = r8
            r8 = r7
            r7 = r1
            r1 = r4
            goto L_0x00b1
        L_0x006e:
            r8 = move-exception
            r1 = r0
            r4 = r8
            r8 = r7
            r7 = r4
            goto L_0x0080
        L_0x0074:
            r8 = move-exception
            r1 = r0
            r4 = r8
            r8 = r7
            r7 = r4
            goto L_0x00b1
        L_0x007a:
            r7 = move-exception
            r1 = r0
            goto L_0x00d2
        L_0x007d:
            r7 = move-exception
            r8 = r0
            r1 = r8
        L_0x0080:
            java.lang.String r2 = r5.d     // Catch:{ all -> 0x00d1 }
            java.lang.String r3 = "[ERROR] :: IOException for saving bitmap."
            android.util.Log.e(r2, r3)     // Catch:{ all -> 0x00d1 }
            r7.printStackTrace()     // Catch:{ all -> 0x00d1 }
            boolean r7 = r8.exists()     // Catch:{ all -> 0x00d1 }
            if (r7 == 0) goto L_0x0094
            r8.delete()     // Catch:{ all -> 0x00d1 }
            goto L_0x0095
        L_0x0094:
            r0 = r8
        L_0x0095:
            if (r1 == 0) goto L_0x009d
            r1.close()     // Catch:{ IOException -> 0x009b }
            goto L_0x009d
        L_0x009b:
            r6 = move-exception
            goto L_0x00a3
        L_0x009d:
            if (r6 == 0) goto L_0x00eb
            r6.recycle()     // Catch:{ IOException -> 0x009b }
            goto L_0x00eb
        L_0x00a3:
            java.lang.String r7 = r5.d
            java.lang.String r8 = "[ERROR] :: failed to close FileOutputStream for saving bitmap."
            android.util.Log.e(r7, r8)
            r6.printStackTrace()
            goto L_0x00eb
        L_0x00ae:
            r7 = move-exception
            r8 = r0
            r1 = r8
        L_0x00b1:
            java.lang.String r2 = r5.d     // Catch:{ all -> 0x00d1 }
            java.lang.String r3 = "[ERROR] :: FileNotFoundException for saving bitmap."
            android.util.Log.e(r2, r3)     // Catch:{ all -> 0x00d1 }
            r7.printStackTrace()     // Catch:{ all -> 0x00d1 }
            boolean r7 = r8.exists()     // Catch:{ all -> 0x00d1 }
            if (r7 == 0) goto L_0x00c5
            r8.delete()     // Catch:{ all -> 0x00d1 }
            goto L_0x00c6
        L_0x00c5:
            r0 = r8
        L_0x00c6:
            if (r1 == 0) goto L_0x00cb
            r1.close()     // Catch:{ IOException -> 0x009b }
        L_0x00cb:
            if (r6 == 0) goto L_0x00eb
            r6.recycle()     // Catch:{ IOException -> 0x009b }
            goto L_0x00eb
        L_0x00d1:
            r7 = move-exception
        L_0x00d2:
            if (r1 == 0) goto L_0x00da
            r1.close()     // Catch:{ IOException -> 0x00d8 }
            goto L_0x00da
        L_0x00d8:
            r6 = move-exception
            goto L_0x00e0
        L_0x00da:
            if (r6 == 0) goto L_0x00ea
            r6.recycle()     // Catch:{ IOException -> 0x00d8 }
            goto L_0x00ea
        L_0x00e0:
            java.lang.String r8 = r5.d
            java.lang.String r0 = "[ERROR] :: failed to close FileOutputStream for saving bitmap."
            android.util.Log.e(r8, r0)
            r6.printStackTrace()
        L_0x00ea:
            throw r7
        L_0x00eb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.d.d.a(android.graphics.Bitmap, java.lang.String, java.lang.String):java.io.File");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068 A[Catch:{ all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006d A[SYNTHETIC, Splitter:B:25:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080 A[SYNTHETIC, Splitter:B:31:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.File a(byte[] r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            java.lang.String r0 = r3.d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "SaveImageFile()+, fileDirectoryPath: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = ", fileName: "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
            r0 = 0
            if (r4 == 0) goto L_0x0090
            java.io.File r1 = new java.io.File
            r1.<init>(r5)
            boolean r5 = r1.exists()
            if (r5 != 0) goto L_0x002f
            r1.mkdirs()
        L_0x002f:
            java.io.File r5 = new java.io.File
            java.lang.String r1 = r1.getAbsolutePath()
            r5.<init>(r1, r6)
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0056, all -> 0x0053 }
            r6.<init>(r5)     // Catch:{ IOException -> 0x0056, all -> 0x0053 }
            r6.write(r4)     // Catch:{ IOException -> 0x0051 }
            r6.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x004f
        L_0x0044:
            r4 = move-exception
            java.lang.String r6 = r3.d
            java.lang.String r0 = "[ERROR] :: failed to close FileOutputStream for image file."
            android.util.Log.e(r6, r0)
            r4.printStackTrace()
        L_0x004f:
            r0 = r5
            goto L_0x0097
        L_0x0051:
            r4 = move-exception
            goto L_0x0058
        L_0x0053:
            r4 = move-exception
            r6 = r0
            goto L_0x007e
        L_0x0056:
            r4 = move-exception
            r6 = r0
        L_0x0058:
            java.lang.String r1 = r3.d     // Catch:{ all -> 0x007d }
            java.lang.String r2 = "[ERROR] :: failed to write image file"
            android.util.Log.e(r1, r2)     // Catch:{ all -> 0x007d }
            r4.printStackTrace()     // Catch:{ all -> 0x007d }
            boolean r4 = r5.exists()     // Catch:{ all -> 0x007d }
            if (r4 == 0) goto L_0x006b
            r5.delete()     // Catch:{ all -> 0x007d }
        L_0x006b:
            if (r6 == 0) goto L_0x0097
            r6.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x0097
        L_0x0071:
            r4 = move-exception
            java.lang.String r5 = r3.d
            java.lang.String r6 = "[ERROR] :: failed to close FileOutputStream for image file."
            android.util.Log.e(r5, r6)
            r4.printStackTrace()
            goto L_0x0097
        L_0x007d:
            r4 = move-exception
        L_0x007e:
            if (r6 == 0) goto L_0x008f
            r6.close()     // Catch:{ IOException -> 0x0084 }
            goto L_0x008f
        L_0x0084:
            r5 = move-exception
            java.lang.String r6 = r3.d
            java.lang.String r0 = "[ERROR] :: failed to close FileOutputStream for image file."
            android.util.Log.e(r6, r0)
            r5.printStackTrace()
        L_0x008f:
            throw r4
        L_0x0090:
            java.lang.String r4 = r3.d
            java.lang.String r5 = "[ERROR] :: data is null"
            android.util.Log.e(r4, r5)
        L_0x0097:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.d.d.a(byte[], java.lang.String, java.lang.String):java.io.File");
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\d\e.java ==========

package net.fxgear.fitnshop.d;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

/* compiled from: FaceCaptureGuideFragment */
public class e extends b implements View.OnClickListener {
    private final String d;
    private CheckBox e;
    private a f;

    /* compiled from: FaceCaptureGuideFragment */
    public interface a {
        void a(boolean z);
    }

    public boolean b() {
        return false;
    }

    public void c() {
    }

    public void d() {
    }

    public e() {
        this((a) null);
    }

    public e(a aVar) {
        this.d = e.class.getSimpleName();
        this.f = aVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i(this.d, "onCreate()+");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Log.i(this.d, "onCreateView()+");
        if (layoutInflater == null) {
            return null;
        }
        View inflate = layoutInflater.inflate(2131296273, viewGroup, false);
        this.e = (CheckBox) inflate.findViewById(2131165382);
        this.e.setOnClickListener(this);
        this.e.setChecked(true);
        ((Button) inflate.findViewById(2131165204)).setOnClickListener(this);
        return inflate;
    }

    public void onResume() {
        super.onResume();
        Log.i(this.d, "onResume()+");
    }

    public void onPause() {
        super.onPause();
        Log.i(this.d, "onPause()+");
    }

    public void onDestroyView() {
        Log.i(this.d, "onDestroyView()+");
        super.onDestroyView();
    }

    public void onDestroy() {
        Log.i(this.d, "onDestroy()+");
        super.onDestroy();
    }

    public String a() {
        return this.d;
    }

    public void onClick(View view) {
        if (view == null) {
            return;
        }
        if (view.getId() == 2131165204) {
            if (this.f != null) {
                this.f.a(this.e != null ? this.e.isChecked() : false);
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\d\f.java ==========

package net.fxgear.fitnshop.d;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.view.k;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import net.fxgear.GlobalDefine;
import net.fxgear.a.a;
import net.fxgear.fitnshop.FitNShopMainActivity;
import net.fxgear.fitnshop.c;
import net.fxgear.fitnshop.c.b;
import net.fxgear.fitnshop.e.a;
import net.fxgear.fitnshop.e.b;
import net.fxgear.fitnshop.e.d;
import net.fxgear.fitnshop.h;
import org.json.JSONException;

/* compiled from: HomeFragment */
public class f extends b implements View.OnClickListener {
    public static final String d = "f";
    private int A;
    private View B;
    /* access modifiers changed from: private */
    public View C;
    private ViewPager D;
    private c E;
    private net.fxgear.fitnshop.c.a F;
    private RadioGroup G;
    /* access modifiers changed from: private */
    public int H = 0;
    private final float I = 16.666666f;
    /* access modifiers changed from: private */
    public boolean J = false;
    /* access modifiers changed from: private */
    public a K;
    /* access modifiers changed from: private */
    public net.fxgear.fitnshop.a.f e;
    private ImageView f;
    private ImageView g;
    private TextView h;
    private RelativeLayout i;
    /* access modifiers changed from: private */
    public ImageView j;
    private LinearLayout k;
    private Button l;
    /* access modifiers changed from: private */
    public SwipeRefreshLayout m;
    /* access modifiers changed from: private */
    public b n;
    /* access modifiers changed from: private */
    public net.fxgear.fitnshop.c o;
    /* access modifiers changed from: private */
    public VelocityTracker p;
    private final float q = 2.0f;
    /* access modifiers changed from: private */
    public float r = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    /* access modifiers changed from: private */
    public float s = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    /* access modifiers changed from: private */
    public boolean t = false;
    /* access modifiers changed from: private */
    public boolean u = false;
    private View v;
    /* access modifiers changed from: private */
    public int w;
    /* access modifiers changed from: private */
    public int x;
    private int y;
    private int z;

    public boolean b() {
        return false;
    }

    public f() {
    }

    public f(net.fxgear.fitnshop.a.f fVar) {
        this.e = fVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @SuppressLint({"ResourceAsColor"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str = d;
        Log.i(str, "onCreateView()+, savedInstanceState : " + bundle);
        if (this.c == null) {
            this.c = layoutInflater.inflate(2131296274, viewGroup, false);
            this.f = (ImageView) this.c.findViewById(2131165186);
            this.g = (ImageView) this.c.findViewById(2131165185);
            this.h = (TextView) this.c.findViewById(2131165188);
            this.c.findViewById(2131165187).setVisibility(8);
            this.c.findViewById(a.e.action_title).setVisibility(8);
            this.c.findViewById(2131165276).setBackgroundResource(2131099651);
            ((ImageView) this.c.findViewById(2131165193)).setOnClickListener(this);
            this.f.setOnClickListener(this);
            this.g.setOnClickListener(this);
            this.h.setOnClickListener(this);
            this.i = (RelativeLayout) this.c.findViewById(2131165368);
            this.j = (ImageView) this.c.findViewById(2131165308);
            this.m = (SwipeRefreshLayout) this.c.findViewById(2131165366);
            this.m.setColorSchemeResources(2130968672);
            this.m.setProgressBackgroundColor(2130968673);
            this.n = new b(getActivity().getApplicationContext());
            this.n.setLayoutParams(this.m.getLayoutParams());
            this.n.setDividerHeight(0);
            this.n.setSelector(17170445);
            this.n.setHorizontalScrollBarEnabled(false);
            this.n.setVerticalScrollBarEnabled(false);
            this.n.setSmoothScrollbarEnabled(true);
            this.m.addView(this.n);
            this.m.setEnabled(true);
            this.m.setOnRefreshListener(new SwipeRefreshLayout.b() {
                public void a() {
                    if (f.this.o != null) {
                        f.this.o.a();
                        f.this.o.notifyDataSetChanged();
                    }
                    if (!h.d(f.this.getActivity())) {
                        f.this.m.setRefreshing(false);
                        f.this.a(true);
                    } else if (f.this.getActivity() instanceof FitNShopMainActivity) {
                        ((FitNShopMainActivity) f.this.getActivity()).a(true);
                    }
                }
            });
            this.k = (LinearLayout) this.c.findViewById(2131165342);
            this.l = (Button) this.c.findViewById(2131165231);
            this.l.setOnClickListener(this);
            f();
        }
        return this.c;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case 2131165185:
            case 2131165188:
                if (getActivity() instanceof FitNShopMainActivity) {
                    ((FitNShopMainActivity) getActivity()).a("wishlist", (String) null, d);
                    net.fxgear.fitnshop.e.f.a("FITBTN_CLI", "");
                    return;
                }
                return;
            case 2131165186:
                if (getActivity() instanceof FitNShopMainActivity) {
                    ((FitNShopMainActivity) getActivity()).b();
                    return;
                }
                return;
            case 2131165193:
                if (this.n != null && this.n.getVisibility() == 0 && this.n.getCount() > 0) {
                    for (int i2 = 1; i2 < this.n.getCount(); i2++) {
                        View c2 = c(i2);
                        if (c2 != null && (c2 instanceof net.fxgear.fitnshop.b)) {
                            ((net.fxgear.fitnshop.b) c2).a((float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
                        }
                    }
                    this.o.a(0);
                    this.n.setSelection(0);
                    return;
                }
                return;
            case 2131165231:
                if (h.d(getActivity())) {
                    a(false);
                    if (this.o == null) {
                        if (getActivity() instanceof FitNShopMainActivity) {
                            ((FitNShopMainActivity) getActivity()).a(false);
                            return;
                        }
                        return;
                    } else if (getActivity() instanceof FitNShopMainActivity) {
                        ((FitNShopMainActivity) getActivity()).a(true);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void onHiddenChanged(boolean z2) {
        String str = d;
        Log.i(str, "onHiddenChanged()+ " + z2);
        if (!z2 && this.h != null && (getActivity() instanceof FitNShopMainActivity)) {
            ((FitNShopMainActivity) getActivity()).c();
            f();
        }
        super.onHiddenChanged(z2);
    }

    public Animator onCreateAnimator(int i2, boolean z2, int i3) {
        String str = d;
        Log.e(str, "onCreateAnimator()+ enter : " + z2 + ", state : " + this.f973a);
        if (this.f973a == 0) {
            return super.onCreateAnimator(i2, z2, i3);
        }
        Animator b2 = b(this.f973a);
        this.f973a = 0;
        if (b2 != null) {
            b2.addListener(new Animator.AnimatorListener() {
                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    animator.removeListener(this);
                    boolean unused = f.this.J = false;
                }

                public void onAnimationCancel(Animator animator) {
                    animator.removeListener(this);
                    boolean unused = f.this.J = false;
                }
            });
        }
        this.J = true;
        return b2;
    }

    public void onResume() {
        super.onResume();
        Log.i(d, "onResume()+");
    }

    public void onPause() {
        super.onPause();
        Log.i(d, "onPause()+");
        if (this.K != null) {
            this.K.a();
            this.K = null;
        }
        if (this.o != null) {
            int firstVisiblePosition = this.n.getFirstVisiblePosition();
            View childAt = this.n.getChildAt(0);
            if (childAt != null && childAt.getBottom() <= 0) {
                firstVisiblePosition++;
            }
            this.o.a(firstVisiblePosition);
        }
    }

    public void onDestroy() {
        if (this.F != null) {
            if (this.F.isShowing()) {
                this.F.dismiss();
            }
            this.F = null;
        }
        if (this.f != null) {
            this.f.setOnClickListener((View.OnClickListener) null);
            this.f = null;
        }
        if (this.g != null) {
            this.g.setOnClickListener((View.OnClickListener) null);
            this.g = null;
        }
        if (this.h != null) {
            this.h.setOnClickListener((View.OnClickListener) null);
            this.h = null;
        }
        this.i = null;
        this.j = null;
        if (this.l != null) {
            this.l.setOnClickListener((View.OnClickListener) null);
            this.l = null;
        }
        this.k = null;
        if (this.n != null) {
            this.n.setOnTouchListener((View.OnTouchListener) null);
            this.n.setAdapter((ListAdapter) null);
            this.n = null;
        }
        if (this.o != null) {
            this.o.a();
            this.o = null;
        }
        if (this.E != null) {
            this.E.e();
            this.E = null;
        }
        if (this.D != null) {
            this.D.setAdapter((k) null);
            this.D.setOnTouchListener((View.OnTouchListener) null);
            this.D.setOnPageChangeListener((ViewPager.f) null);
            this.D = null;
        }
        if (this.m != null) {
            this.m.setOnRefreshListener((SwipeRefreshLayout.b) null);
            this.m = null;
        }
        if (this.p != null) {
            this.p.recycle();
            this.p = null;
        }
        if (this.G != null) {
            this.G.removeAllViews();
            this.G = null;
        }
        this.v = null;
        this.B = null;
        if (this.C != null) {
            ((RelativeLayout) this.C).removeAllViews();
            this.C = null;
        }
        this.e = null;
        super.onDestroy();
    }

    public String a() {
        return d;
    }

    public void c() {
        f();
        e();
    }

    public void d() {
        a(true);
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        if (z2) {
            if (!(this.i == null || this.i.getVisibility() == 8)) {
                this.i.setVisibility(8);
            }
            if (!(this.m == null || this.m.getVisibility() == 8)) {
                this.m.setVisibility(8);
            }
            if (this.k != null && this.k.getVisibility() != 0) {
                this.k.setVisibility(0);
                return;
            }
            return;
        }
        if (!(this.i == null || this.i.getVisibility() == 0)) {
            this.i.setVisibility(0);
        }
        if (!(this.m == null || this.m.getVisibility() == 0)) {
            this.m.setVisibility(0);
        }
        if (this.k != null && this.k.getVisibility() != 8) {
            this.k.setVisibility(8);
        }
    }

    public void a(net.fxgear.fitnshop.e.a aVar) {
        if (aVar != null) {
            a(aVar, false);
        }
    }

    private void a(final net.fxgear.fitnshop.e.a aVar, boolean z2) {
        if (z2) {
            this.n.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    f.this.n.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    f.this.b(aVar);
                    f.this.a(false);
                }
            });
            return;
        }
        b(aVar);
        a(false);
    }

    /* access modifiers changed from: private */
    public void b(net.fxgear.fitnshop.e.a aVar) {
        int i2;
        ArrayList arrayList;
        a.q[] b2;
        a.g[] b3;
        Log.d(d, "AddItemInfoData()+");
        if (this.o != null) {
            this.o.a();
            this.o = null;
        }
        if (this.m != null) {
            this.m.setRefreshing(false);
        }
        a(false);
        this.o = new net.fxgear.fitnshop.c(getActivity(), this.e);
        this.o.a((View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                if (f.this.J) {
                    Log.d(f.d, "Animation work.");
                } else if (view != null && (view instanceof net.fxgear.fitnshop.b)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (!((net.fxgear.fitnshop.b) view).a()) {
                        f.this.a(intValue, 300);
                    } else if (!(f.this.getActivity() instanceof FitNShopMainActivity)) {
                    } else {
                        if (f.this.K == null || f.this.K.getStatus() == AsyncTask.Status.FINISHED) {
                            net.fxgear.fitnshop.e.f.a("BANNER_CLI_CNT", "");
                            FitNShopMainActivity fitNShopMainActivity = (FitNShopMainActivity) f.this.getActivity();
                            b.a e = f.this.o.e(intValue);
                            if (e == null) {
                                f.this.a(fitNShopMainActivity, intValue);
                                return;
                            }
                            f.this.f973a = 2;
                            if (fitNShopMainActivity.a(e)) {
                                net.fxgear.fitnshop.e.f.a("BANNER_CLI_PRDVIEW_DONE", "");
                                return;
                            }
                            return;
                        }
                        Log.e(f.d, "Task running.");
                    }
                }
            }
        });
        a.e a2 = aVar.a();
        if (a2 == null || (b3 = a2.b()) == null) {
            arrayList = null;
            i2 = 0;
        } else {
            arrayList = new ArrayList();
            int a3 = a2.a();
            i2 = 0;
            for (int i3 = 0; i3 < a3; i3++) {
                arrayList.add(b3[i3].e().a());
                i2++;
            }
        }
        int c2 = a2.b()[0].e().c();
        this.B = getActivity().getLayoutInflater().inflate(2131296314, (ViewGroup) null);
        this.B.setBackgroundColor(getResources().getColor(2130968621));
        this.D = (ViewPager) this.B.findViewById(2131165428);
        ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
        layoutParams.height = c2;
        this.D.setLayoutParams(layoutParams);
        this.E = new c();
        this.E.a(arrayList);
        this.D.setAdapter(this.E);
        this.D.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        f.this.n.requestDisallowInterceptTouchEvent(true);
                        break;
                    case 1:
                    case 3:
                        f.this.n.requestDisallowInterceptTouchEvent(false);
                        break;
                }
                return false;
            }
        });
        this.D.setOnPageChangeListener(new ViewPager.f() {
            public void a(int i, float f, int i2) {
            }

            public void b(int i) {
            }

            public void a(int i) {
                f.this.d(i);
            }
        });
        this.G = (RadioGroup) this.B.findViewById(2131165399);
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(2131034427);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(2131034427);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(2131034424);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(2131034425);
        RadioGroup.LayoutParams layoutParams2 = new RadioGroup.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
        layoutParams2.leftMargin = dimensionPixelSize3;
        layoutParams2.rightMargin = dimensionPixelSize4;
        for (int i4 = 0; i4 < i2; i4++) {
            RadioButton radioButton = new RadioButton(getActivity());
            radioButton.setBackgroundResource(2131099847);
            radioButton.setButtonDrawable((Drawable) null);
            radioButton.setClickable(false);
            radioButton.setFocusable(false);
            radioButton.setId(i4);
            this.G.addView(radioButton, layoutParams2);
        }
        d(0);
        int dimension = (int) getResources().getDimension(2131034339);
        int dimension2 = (int) getResources().getDimension(2131034326);
        getResources().getDimension(2131034371);
        getResources().getDimension(2131034370);
        getResources().getDimension(2131034326);
        getResources().getDimension(2131034327);
        this.o.a(-2, (String) null, (String) null, dimension, dimension2, (String) null, 0, 0, c2, c2, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, true, "Header", (String) null, -1, -1);
        a.o b4 = aVar.b();
        if (!(b4 == null || (b2 = b4.b()) == null)) {
            int a4 = b4.a();
            for (int i5 = 0; i5 < a4; i5++) {
                String c3 = b2[i5].c();
                if (c3 == null || !c3.equals("deleted")) {
                    this.o.a(b2[i5].e(), b2[i5].a(), b2[i5].f().a(), b2[i5].f().b(), b2[i5].f().c(), b2[i5].g().a(), b2[i5].g().b(), b2[i5].g().c(), b2[i5].f().f(), b2[i5].f().e(), b2[i5].f().d(), false, b2[i5].b(), b2[i5].d(), -1, -1);
                } else {
                    Log.d(d, b2[i5].a() + " Brand skip");
                }
            }
        }
        int dimension3 = (int) getResources().getDimension(2131034331);
        if (!(this.n == null || this.n.getHeight() <= 0 || b4 == null)) {
            a.q[] b5 = b4.b();
            dimension3 = this.n.getHeight() - b5[b5.length - 1].f().c();
            if (!h.e(getActivity().getApplicationContext()) && !h.c(getActivity().getApplicationContext())) {
                dimension3 += h.b(getActivity().getApplicationContext());
            }
        }
        int i6 = dimension3;
        RelativeLayout relativeLayout = new RelativeLayout(getActivity());
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, i6));
        ImageView imageView = new ImageView(getActivity());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) getResources().getDimension(2131034335)));
        imageView.setBackgroundResource(2131099868);
        relativeLayout.addView(imageView);
        this.C = relativeLayout;
        this.o.a(-2, (String) null, (String) null, i6, i6, (String) null, 0, 0, i6, i6, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, true, (String) null, (String) null, -1, -1);
        this.o.a(this.B);
        this.o.b(this.C);
        this.n.setAdapter(this.o);
        this.n.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float f;
                if (f.this.u || f.this.o == null || f.this.o.getCount() == 0 || f.this.n.getChildAt(0) == null) {
                    String str = f.d;
                    Log.d(str, "onTouch()+, mIsAutoScrolling : " + f.this.u);
                    return true;
                }
                float y = motionEvent.getY();
                switch (motionEvent.getAction()) {
                    case 0:
                        if (!f.this.t) {
                            float unused = f.this.s = y;
                            float unused2 = f.this.r = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                            boolean unused3 = f.this.t = true;
                            f.this.a(y);
                            if (f.this.p == null) {
                                VelocityTracker unused4 = f.this.p = VelocityTracker.obtain();
                                break;
                            }
                        }
                        break;
                    case 1:
                    case 3:
                        float a2 = h.a(f.this.getActivity().getApplicationContext(), 15.0f);
                        if (f.this.p != null) {
                            f.this.p.computeCurrentVelocity(1);
                            f = f.this.p.getYVelocity();
                        } else {
                            f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                        }
                        if (f < -2.0f && f.this.r != GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                            f.this.a(f.this.w + 1, 200);
                        } else if (f > 2.0f && f.this.r != GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                            f.this.a(f.this.w, 200);
                        } else if (f.this.r > a2) {
                            f.this.a(f.this.w + 1, 200);
                        } else if (f.this.r < (-a2)) {
                            f.this.a(f.this.w, 200);
                        } else if (f.this.r > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                            f.this.a(f.this.w, 100);
                        } else if (f.this.r < GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                            f.this.a(f.this.w + 1, 100);
                        } else {
                            f.this.a(f.this.w, 200);
                        }
                        float unused5 = f.this.s = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                        float unused6 = f.this.r = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                        boolean unused7 = f.this.t = false;
                        if (f.this.p != null) {
                            f.this.p.recycle();
                            VelocityTracker unused8 = f.this.p = null;
                            break;
                        }
                        break;
                    case 2:
                        if (!f.this.t) {
                            float unused9 = f.this.s = y;
                            float unused10 = f.this.r = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                            boolean unused11 = f.this.t = true;
                            f.this.a(y);
                            if (f.this.p == null) {
                                VelocityTracker unused12 = f.this.p = VelocityTracker.obtain();
                            }
                            return true;
                        }
                        if (f.this.p != null) {
                            f.this.p.addMovement(motionEvent);
                        }
                        if (f.this.b(y) == 0) {
                            return true;
                        }
                        break;
                }
                if (f.this.w == f.this.n.getCount() - 2 && f.this.C.getBottom() == f.this.n.getHeight()) {
                    f.this.j.setVisibility(0);
                } else {
                    f.this.j.setVisibility(8);
                }
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3) {
        float f2;
        float f3;
        int i4;
        int i5 = i2;
        this.H = 0;
        int firstVisiblePosition = this.n.getFirstVisiblePosition();
        View childAt = this.n.getChildAt(0);
        int i6 = 1;
        if (childAt.getBottom() <= 0) {
            childAt = this.n.getChildAt(1);
            firstVisiblePosition++;
        }
        int i7 = firstVisiblePosition;
        if (i7 < i5) {
            f3 = ((float) childAt.getHeight()) + childAt.getY();
            f2 = f3;
            for (int i8 = i7 + 1; i8 < i5; i8++) {
                f2 += this.o.b(i8);
            }
        } else {
            f3 = childAt.getY();
            float f4 = f3;
            for (int i9 = i7 - 1; i9 > i5; i9--) {
                f4 = f2 - this.o.b(i9);
            }
        }
        float f5 = f3;
        float f6 = f2;
        if (f6 != GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
            int i10 = (int) (((float) i3) / 16.666666f);
            if (i10 > 0) {
                this.u = true;
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.C.getLayoutParams();
                layoutParams.height *= 2;
                this.C.setLayoutParams(layoutParams);
            }
            int i11 = 0;
            while (i11 < i10) {
                int i12 = i10 - 1;
                final int i13 = i11 == i12 ? (int) (f6 - ((float) (((int) (f6 / ((float) i10))) * i12))) : (int) (f6 / ((float) i10));
                if (i13 <= -1 || i13 >= i6) {
                    final int i14 = i7;
                    final int i15 = i2;
                    AnonymousClass8 r10 = r0;
                    final float f7 = f5;
                    Handler handler = new Handler();
                    final int i16 = i11;
                    i4 = i11;
                    final int i17 = i10;
                    AnonymousClass8 r0 = new Runnable() {
                        @SuppressLint({"NewApi"})
                        public void run() {
                            float f2;
                            int i = i14;
                            int m = f.this.H;
                            if (i14 < i15) {
                                while (((float) f.this.H) > f7) {
                                    float f3 = (float) m;
                                    if (f3 - f7 <= GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                                        break;
                                    }
                                    i++;
                                    m = (int) (f3 - f.this.o.b(i));
                                }
                                f2 = ((float) (-(((int) (((float) m) - f7)) + i13))) / f.this.o.b(i);
                                if (f2 < GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                                    i++;
                                    View c2 = f.this.c(i);
                                    if (c2 != null && (c2 instanceof net.fxgear.fitnshop.b)) {
                                        ((net.fxgear.fitnshop.b) c2).a(1.0f);
                                    }
                                    f2 += 1.0f;
                                }
                            } else {
                                while (((float) f.this.H) < f7) {
                                    float f4 = (float) m;
                                    if (f4 - f7 >= GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                                        break;
                                    }
                                    i--;
                                    m = (int) (f4 + f.this.o.b(i));
                                }
                                f2 = 1.0f - (((float) (((int) (((float) m) - f7)) + i13)) / f.this.o.b(i));
                                if (f2 > 1.0f) {
                                    View c3 = f.this.c(i + 1);
                                    if (c3 != null && (c3 instanceof net.fxgear.fitnshop.b)) {
                                        ((net.fxgear.fitnshop.b) c3).a((float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
                                    }
                                    i--;
                                    f2 -= 1.0f;
                                }
                            }
                            View c4 = f.this.c(i);
                            View c5 = f.this.c(i + 1);
                            if (!(f.this.o == null || c4 == null)) {
                                if (c5 != null && (c5 instanceof net.fxgear.fitnshop.b)) {
                                    ((net.fxgear.fitnshop.b) c5).a(1.0f - f2);
                                }
                                int unused = f.this.H = f.this.H + i13;
                                f.this.n.scrollListBy(i13);
                            }
                            if (i16 == i17 - 1) {
                                boolean unused2 = f.this.u = false;
                                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) f.this.C.getLayoutParams();
                                layoutParams.height /= 2;
                                f.this.C.setLayoutParams(layoutParams);
                                if (i15 == f.this.n.getCount() - 2) {
                                    f.this.j.setVisibility(0);
                                } else {
                                    f.this.j.setVisibility(8);
                                }
                                new Handler().post(new Runnable() {
                                    public void run() {
                                        boolean unused = f.this.u = false;
                                        if (f.this.o != null) {
                                            f.this.o.a(i15);
                                        }
                                    }
                                });
                            }
                        }
                    };
                    handler.postDelayed(r10, (long) (((float) (i4 + 0)) * 16.666666f));
                } else {
                    i4 = i11;
                }
                i11 = i4 + 1;
                i6 = 1;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public View c(int i2) {
        int firstVisiblePosition = this.n.getFirstVisiblePosition();
        if (i2 < firstVisiblePosition || i2 >= this.n.getChildCount() + firstVisiblePosition) {
            return null;
        }
        return this.n.getChildAt(i2 - firstVisiblePosition);
    }

    /* compiled from: HomeFragment */
    private class c extends k {

        /* renamed from: b  reason: collision with root package name */
        private final String f1015b;
        private ArrayList<String> c;
        private ArrayList<Integer> d;

        private c() {
            this.f1015b = "ViewPagerAdapter";
        }

        /* access modifiers changed from: private */
        public void a(ArrayList<String> arrayList) {
            this.c = arrayList;
        }

        public ArrayList<String> d() {
            return this.c;
        }

        public int a() {
            if (this.c != null) {
                return this.c.size();
            }
            if (this.d != null) {
                return this.d.size();
            }
            return 0;
        }

        public boolean a(View view, Object obj) {
            return view.equals(obj);
        }

        public Object a(View view, final int i) {
            View inflate = ((LayoutInflater) view.getContext().getSystemService("layout_inflater")).inflate(2131296282, (ViewGroup) null);
            inflate.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Log.e("ViewPagerAdapter", "onClick()+, position : " + i);
                }
            });
            ImageView imageView = (ImageView) inflate.findViewById(2131165317);
            if (this.c != null) {
                f.this.e.a((Object) this.c.get(i), imageView);
            } else {
                imageView.setBackgroundResource(this.d.get(i).intValue());
            }
            ((ViewPager) view).addView(inflate);
            return inflate;
        }

        public void a(ViewGroup viewGroup, int i, Object obj) {
            ((ViewPager) viewGroup).removeView((View) obj);
        }

        public void e() {
            if (this.c != null) {
                this.c.clear();
                this.c = null;
            }
            if (this.d != null) {
                this.d.clear();
                this.d = null;
            }
        }
    }

    /* compiled from: HomeFragment */
    private class b extends ListView {

        /* renamed from: a  reason: collision with root package name */
        float f1012a;

        /* renamed from: b  reason: collision with root package name */
        float f1013b;
        boolean c;
        private final String e = "MainListView";
        private final String f = "trackMotionScroll";
        private Method g;
        private final boolean h;

        public b(Context context) {
            super(context);
            int i = 0;
            this.c = false;
            if (Build.VERSION.SDK_INT < 19) {
                this.h = true;
                Method[] declaredMethods = AbsListView.class.getDeclaredMethods();
                if (declaredMethods != null) {
                    int length = declaredMethods.length;
                    while (i < length) {
                        Method method = declaredMethods[i];
                        if (!method.getName().equals("trackMotionScroll") || method.getParameterTypes().length != 2) {
                            i++;
                        } else {
                            this.g = method;
                            this.g.setAccessible(true);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            this.h = false;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            float f2;
            if (f.this.u || f.this.o == null || f.this.o.getCount() == 0 || f.this.n.getChildAt(0) == null) {
                Log.d("MainListView", "[j] onInterceptTouchEvent()+, mIsAutoScrolling : " + f.this.u);
                return true;
            }
            float y = motionEvent.getY();
            float x = motionEvent.getX();
            int action = motionEvent.getAction();
            float f3 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            switch (action) {
                case 0:
                    if (!f.this.t || this.c) {
                        float unused = f.this.s = y;
                        float unused2 = f.this.r = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                        boolean unused3 = f.this.t = true;
                        this.f1012a = x;
                        this.f1013b = y;
                        this.c = false;
                        f.this.a(y);
                        if (f.this.p == null) {
                            VelocityTracker unused4 = f.this.p = VelocityTracker.obtain();
                            break;
                        }
                    }
                    break;
                case 1:
                case 3:
                    f.this.n.scrollListBy((int) (-f.this.r));
                    int unused5 = f.this.w = f.this.x;
                    View c2 = f.this.c(f.this.w);
                    if (c2 != null && (c2 instanceof net.fxgear.fitnshop.b)) {
                        ((net.fxgear.fitnshop.b) c2).a(1.0f);
                    }
                    for (int j = f.this.w + 1; j < f.this.n.getCount(); j++) {
                        View childAt = f.this.n.getChildAt(j);
                        if (childAt != null && (childAt instanceof net.fxgear.fitnshop.b)) {
                            ((net.fxgear.fitnshop.b) childAt).a((float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
                        }
                    }
                    float unused6 = f.this.s = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                    float unused7 = f.this.r = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                    boolean unused8 = f.this.t = false;
                    if (f.this.p != null) {
                        f.this.p.recycle();
                        VelocityTracker unused9 = f.this.p = null;
                        break;
                    }
                    break;
                case 2:
                    if (f.this.p != null) {
                        f.this.p.addMovement(motionEvent);
                        f.this.p.computeCurrentVelocity(1);
                        f3 = Math.abs(f.this.p.getYVelocity());
                        f2 = Math.abs(f.this.p.getXVelocity());
                    } else {
                        f2 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                    }
                    float a2 = h.a(f.this.getActivity().getApplicationContext(), 8.0f);
                    float abs = Math.abs(this.f1012a - x);
                    float abs2 = Math.abs(this.f1013b - y);
                    if (!this.c) {
                        if (f2 > f3 || (f2 == f3 && abs > abs2)) {
                            if (abs > a2) {
                                this.c = true;
                            } else if (abs2 > a2) {
                                this.c = true;
                                return true;
                            }
                        } else if (f2 < f3 || (f2 == f3 && abs <= abs2)) {
                            if (abs2 > a2) {
                                this.c = true;
                                return true;
                            } else if (abs > a2) {
                                this.c = true;
                            }
                        }
                    }
                    if (!this.c) {
                        int unused10 = f.this.b(y);
                    }
                    return false;
            }
            if (f.this.w == f.this.n.getCount() - 2 && f.this.C.getBottom() == f.this.n.getHeight()) {
                f.this.j.setVisibility(0);
            } else {
                f.this.j.setVisibility(8);
            }
            return false;
        }

        @SuppressLint({"NewApi"})
        public void scrollListBy(int i) {
            if (!this.h) {
                super.scrollListBy(i);
            } else if (this.g != null) {
                try {
                    int i2 = -i;
                    this.g.invoke(this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i2)});
                } catch (Exception e2) {
                    Log.e("MainListView", "ERROR[exception description] : " + e2.getLocalizedMessage());
                    e2.printStackTrace();
                }
            } else {
                Log.e("MainListView", "ERROR :: Not found target method.");
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(float f2) {
        c.a aVar;
        Log.d(d, "TouchInit()+");
        this.x = this.n.getFirstVisiblePosition();
        if (this.n.getChildAt(0).getBottom() <= 0) {
            this.x++;
        }
        this.v = c(this.x);
        this.w = this.x;
        this.y = this.v.getBottom();
        this.z = this.y;
        for (int i2 = 0; i2 <= this.x; i2++) {
            this.z -= (int) this.o.b(i2);
        }
        this.A = 0;
        if (this.x < this.o.getCount() - 2) {
            this.A = this.y;
            int i3 = this.x;
            while (true) {
                i3++;
                if (i3 >= this.o.getCount() - 2) {
                    break;
                }
                this.A += (int) this.o.b(i3);
            }
        }
        if (this.w == this.o.getCount() - 2 && (aVar = (c.a) this.o.getItem(this.o.getCount() - 1)) != null && this.C.getHeight() != aVar.k()) {
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.C.getLayoutParams();
            layoutParams.height = aVar.k();
            this.C.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public int b(float f2) {
        float f3;
        int i2 = (int) (this.s - f2);
        this.s = f2;
        int i3 = (int) this.r;
        if (((float) this.z) >= this.r + ((float) i2)) {
            i2 = (int) (((float) this.z) - this.r);
        }
        if (((float) this.A) <= this.r + ((float) i2)) {
            i2 = (int) (((float) this.A) - this.r);
        }
        if (i2 == 0) {
            return i2;
        }
        this.w = this.x;
        if (this.r > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
            int i4 = this.y;
            while (this.r > ((float) i4) && i3 - i4 > 0) {
                this.w++;
                i3 = (int) (((float) i3) - this.o.b(this.w));
            }
            f3 = ((float) (-((i3 - i4) + i2))) / this.o.b(this.w);
            if (f3 < GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                View c2 = c(this.w + 1);
                if (c2 != null && (c2 instanceof net.fxgear.fitnshop.b)) {
                    ((net.fxgear.fitnshop.b) c2).a(1.0f);
                }
                this.w++;
                f3 += 1.0f;
            }
        } else {
            int b2 = (int) (((float) this.y) - this.o.b(this.x));
            while (this.r < ((float) b2) && i3 - b2 < 0) {
                this.w--;
                i3 = (int) (((float) i3) + this.o.b(this.w));
            }
            f3 = 1.0f - (((float) ((i3 - b2) + i2)) / this.o.b(this.w));
            if (f3 > 1.0f) {
                View c3 = c(this.w + 1);
                if (c3 != null && (c3 instanceof net.fxgear.fitnshop.b)) {
                    ((net.fxgear.fitnshop.b) c3).a((float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
                }
                this.w--;
                f3 -= 1.0f;
            }
        }
        View c4 = c(this.w + 1);
        if (c4 instanceof net.fxgear.fitnshop.b) {
            ((net.fxgear.fitnshop.b) c4).a(1.0f - f3);
        }
        this.r += (float) i2;
        this.n.scrollListBy(i2);
        return i2;
    }

    private void f() {
        if (this.h != null) {
            h.a((Context) getActivity(), this.h);
        }
    }

    public void e() {
        boolean z2 = true;
        int i2 = 0;
        while (z2) {
            View childAt = this.n.getChildAt(i2);
            if (childAt == null) {
                z2 = false;
            } else {
                if (childAt instanceof RelativeLayout) {
                    ArrayList<String> d2 = this.E.d();
                    boolean z3 = true;
                    int i3 = 0;
                    while (z3) {
                        View childAt2 = this.D.getChildAt(i3);
                        if (childAt2 != null) {
                            this.e.a((Object) d2.get(i3), (ImageView) childAt2.findViewById(2131165317));
                        } else {
                            z3 = false;
                        }
                        i3++;
                    }
                } else if ((childAt instanceof net.fxgear.fitnshop.b) && this.o != null) {
                    net.fxgear.fitnshop.b bVar = (net.fxgear.fitnshop.b) childAt;
                    c.a aVar = (c.a) this.o.getItem(((Integer) bVar.getTag()).intValue());
                    HashMap hashMap = new HashMap();
                    hashMap.put("key_background_url", aVar.d());
                    hashMap.put("key_logo_url", aVar.g());
                    this.e.a((HashMap<String, Object>) hashMap, bVar);
                }
                i2++;
            }
        }
    }

    /* access modifiers changed from: private */
    public void d(int i2) {
        if (i2 >= 0 && i2 < this.G.getChildCount()) {
            int id = this.G.getChildAt(i2).getId();
            if (this.G != null && id != -1) {
                this.G.check(id);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(FitNShopMainActivity fitNShopMainActivity, int i2) {
        this.K = new a(fitNShopMainActivity, i2);
        this.K.execute(new Void[0]);
    }

    /* compiled from: HomeFragment */
    public class a extends AsyncTask<Void, Void, b.a> {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f1010b;
        /* access modifiers changed from: private */
        public FitNShopMainActivity c;
        private net.fxgear.fitnshop.c.a d;
        private int e = 0;

        public a(FitNShopMainActivity fitNShopMainActivity, int i) {
            this.c = fitNShopMainActivity;
            this.f1010b = i;
        }

        public void a() {
            cancel(true);
            c();
            this.c = null;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            b();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public b.a doInBackground(Void... voidArr) {
            try {
                if (!isCancelled()) {
                    int c2 = f.this.o.c(this.f1010b);
                    if (c2 != -2) {
                        String d2 = f.this.o.d(this.f1010b);
                        b.a a2 = this.c.a(c2);
                        if (a2 != null) {
                            if (a2.d().length == h.d.length) {
                                this.e = -2;
                                return a2;
                            }
                        }
                        if (isCancelled()) {
                            this.e = -1;
                            Log.d(f.d, "Task cancel.");
                            return null;
                        }
                        if (d2 != null) {
                            if (a2 == null) {
                                a2 = new b.a(c2, d2);
                            }
                            for (String str : h.d) {
                                if (isCancelled()) {
                                    this.e = -1;
                                    Log.d(f.d, "Task cancel.");
                                    return null;
                                }
                                a2.a(str, d.a(c2, str));
                                f.this.o.a(this.f1010b, a2);
                                this.e = -2;
                            }
                        }
                        return a2;
                    }
                    Log.e(f.d, "ERROR :: Wrong brand id.");
                    this.e = 0;
                    return null;
                }
                this.e = -1;
                Log.d(f.d, "Task cancel.");
                return null;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                this.e = 1;
                return null;
            } catch (IOException e3) {
                e3.printStackTrace();
                this.e = 2;
                return null;
            } catch (JSONException e4) {
                e4.printStackTrace();
                this.e = 3;
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(b.a aVar) {
            c();
            if (this.e != -2) {
                this.c.a((b.a) new b.a() {
                    public void a(net.fxgear.fitnshop.c.b bVar) {
                        if (bVar != null) {
                            bVar.dismiss();
                        }
                        f.this.a(a.this.c, a.this.f1010b);
                    }

                    public void b(net.fxgear.fitnshop.c.b bVar) {
                        if (bVar != null) {
                            bVar.dismiss();
                        }
                    }
                });
            } else if (aVar != null) {
                f.this.f973a = 2;
                if (this.c.a(aVar)) {
                    net.fxgear.fitnshop.e.f.a("BANNER_CLI_PRDVIEW_DONE", "");
                }
            } else {
                Log.e(f.d, "Not found brand info.");
            }
        }

        private void b() {
            if (this.d == null) {
                this.d = new net.fxgear.fitnshop.c.a(this.c, 0);
            }
            this.d.show();
        }

        private void c() {
            if (this.d != null) {
                if (this.d.isShowing()) {
                    this.d.dismiss();
                }
                this.d = null;
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\d\g.java ==========

package net.fxgear.fitnshop.d;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.IOException;
import java.util.HashMap;
import net.fxgear.a.a;
import net.fxgear.fitnshop.FitNShopMainActivity;
import net.fxgear.fitnshop.c.b;
import net.fxgear.fitnshop.e.b;
import net.fxgear.fitnshop.e.d;
import net.fxgear.fitnshop.f;
import net.fxgear.fitnshop.h;
import net.fxgear.fitnshop.i;
import net.fxgear.fitnshop.k;
import net.fxgear.fitnshop.l;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HomeWebFragment */
public class g extends b implements View.OnClickListener, f.a, l.a {
    public static final String d = "g";
    private final String e = "/app/home_menu?ad_status=%s&brand_status=%s";
    private final String f = "app_ver=%d";
    private final String g = "activated";
    private final String h = "all";
    private final int i = 1;
    private final int j = 2;
    private net.fxgear.fitnshop.a.f k;
    private ImageView l;
    private ImageView m;
    private TextView n;
    private LinearLayout o;
    private Button p;
    /* access modifiers changed from: private */
    public net.fxgear.fitnshop.c.a q;
    private a r;
    private WebView s;
    private f t;
    private l u;
    private k v;
    /* access modifiers changed from: private */
    public HashMap<Integer, b.a> w = new HashMap<>();
    /* access modifiers changed from: private */
    public Handler x = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                g.this.a(false);
                if (g.this.q != null && g.this.q.isShowing()) {
                    g.this.q.dismiss();
                }
            } else if (message.what == 2) {
                g.this.a(true);
            }
        }
    };
    private b y = new b() {
        public void a(int i, String str) {
            net.fxgear.fitnshop.e.f.a("BANNER_CLI_CNT", "");
            FitNShopMainActivity fitNShopMainActivity = (FitNShopMainActivity) g.this.getActivity();
            b.a aVar = (b.a) g.this.w.get(Integer.valueOf(i));
            if (aVar == null) {
                g.this.a(fitNShopMainActivity, i, str);
                return;
            }
            g.this.f973a = 2;
            if (fitNShopMainActivity.a(aVar)) {
                net.fxgear.fitnshop.e.f.a("BANNER_CLI_PRDVIEW_DONE", "");
            }
        }

        public void a(boolean z) {
            if (!z) {
                g.this.x.sendEmptyMessage(2);
            } else {
                g.this.x.sendEmptyMessage(1);
            }
        }

        public void a(String str) {
            String str2 = g.d;
            i.a(str2, "goInfo()+, jsonData: " + str);
            if (str != null) {
                try {
                    String string = new JSONObject(str).getString("info_type");
                    if (string != null) {
                        FitNShopMainActivity fitNShopMainActivity = (FitNShopMainActivity) g.this.getActivity();
                        if (string.equals("privacy")) {
                            fitNShopMainActivity.a(1, str);
                        } else if (string.equals("terms")) {
                            fitNShopMainActivity.a(2, str);
                        }
                    }
                } catch (JSONException e) {
                    Log.e(g.d, "[ERROR] :: JSONException");
                    e.printStackTrace();
                }
            }
        }
    };

    /* compiled from: HomeWebFragment */
    public interface b {
        void a(int i, String str);

        void a(String str);

        void a(boolean z);
    }

    public boolean b() {
        return false;
    }

    public g() {
    }

    public g(net.fxgear.fitnshop.a.f fVar) {
        this.k = fVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @SuppressLint({"ResourceAsColor"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str = d;
        Log.i(str, "onCreateView()+, savedInstanceState : " + bundle);
        if (this.c == null) {
            this.c = layoutInflater.inflate(2131296275, viewGroup, false);
            this.l = (ImageView) this.c.findViewById(2131165186);
            this.m = (ImageView) this.c.findViewById(2131165185);
            this.n = (TextView) this.c.findViewById(2131165188);
            this.c.findViewById(2131165187).setVisibility(8);
            this.c.findViewById(a.e.action_title).setVisibility(8);
            this.c.findViewById(2131165276).setBackgroundResource(2131099651);
            ((ImageView) this.c.findViewById(2131165193)).setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.t = new f(getActivity());
            this.t.a(this);
            this.v = new k(getActivity());
            this.v.a(this.y);
            this.s = (WebView) this.c.findViewById(2131165433);
            this.s.setWebViewClient(this.t);
            this.s.addJavascriptInterface(this.v, "AndroidFitnshop");
            this.s.getSettings().setJavaScriptEnabled(true);
            this.s.getSettings().setTextZoom(100);
            this.s.getSettings().setCacheMode(2);
            if (18 <= Build.VERSION.SDK_INT) {
                this.s.setLayerType(2, (Paint) null);
            }
            this.u = new l(this.t);
            this.u.a(this);
            this.s.setWebChromeClient(this.u);
            this.s.getSettings().setSupportMultipleWindows(true);
            this.s.setScrollBarStyle(33554432);
            this.s.setScrollbarFadingEnabled(false);
            this.o = (LinearLayout) this.c.findViewById(2131165342);
            this.p = (Button) this.c.findViewById(2131165231);
            this.p.setOnClickListener(this);
            if (!h.d(getActivity().getApplicationContext())) {
                a(true);
            }
            f();
        }
        return this.c;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case 2131165185:
            case 2131165188:
                if (getActivity() instanceof FitNShopMainActivity) {
                    ((FitNShopMainActivity) getActivity()).a("wishlist", (String) null, d);
                    net.fxgear.fitnshop.e.f.a("FITBTN_CLI", "");
                    return;
                }
                return;
            case 2131165186:
                if (getActivity() instanceof FitNShopMainActivity) {
                    ((FitNShopMainActivity) getActivity()).b();
                    return;
                }
                return;
            case 2131165193:
                if (this.s != null) {
                    k.a(this.s);
                    return;
                }
                return;
            case 2131165231:
                if (!h.d(getActivity())) {
                    return;
                }
                if (((FitNShopMainActivity) getActivity()).h()) {
                    a(false);
                    if (getActivity() instanceof FitNShopMainActivity) {
                        ((FitNShopMainActivity) getActivity()).a(false);
                        return;
                    }
                    return;
                }
                if (this.q == null) {
                    this.q = new net.fxgear.fitnshop.c.a(getActivity(), 0);
                }
                if (this.q != null && !this.q.isShowing()) {
                    this.q.show();
                }
                if (!(this.s == null || this.s.getVisibility() == 8)) {
                    this.s.setVisibility(8);
                }
                if (!(this.o == null || this.o.getVisibility() == 8)) {
                    this.o.setVisibility(8);
                }
                e();
                return;
            default:
                return;
        }
    }

    public void onHiddenChanged(boolean z) {
        String str = d;
        Log.i(str, "onHiddenChanged()+ " + z);
        if (!z && this.n != null && (getActivity() instanceof FitNShopMainActivity)) {
            ((FitNShopMainActivity) getActivity()).c();
            f();
        }
        super.onHiddenChanged(z);
    }

    public Animator onCreateAnimator(int i2, boolean z, int i3) {
        String str = d;
        Log.e(str, "onCreateAnimator()+ enter : " + z + ", state : " + this.f973a);
        if (this.f973a == 0) {
            return super.onCreateAnimator(i2, z, i3);
        }
        Animator b2 = b(this.f973a);
        this.f973a = 0;
        if (b2 != null) {
            b2.addListener(new Animator.AnimatorListener() {
                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    animator.removeListener(this);
                }

                public void onAnimationCancel(Animator animator) {
                    animator.removeListener(this);
                }
            });
        }
        return b2;
    }

    public void onResume() {
        super.onResume();
        Log.i(d, "onResume()+");
    }

    public void onPause() {
        super.onPause();
        Log.i(d, "onPause()+");
        if (this.r != null) {
            this.r.a();
            this.r = null;
        }
    }

    public void onDestroy() {
        if (this.q != null) {
            if (this.q.isShowing()) {
                this.q.dismiss();
            }
            this.q = null;
        }
        if (this.l != null) {
            this.l.setOnClickListener((View.OnClickListener) null);
            this.l = null;
        }
        if (this.m != null) {
            this.m.setOnClickListener((View.OnClickListener) null);
            this.m = null;
        }
        if (this.n != null) {
            this.n.setOnClickListener((View.OnClickListener) null);
            this.n = null;
        }
        if (this.p != null) {
            this.p.setOnClickListener((View.OnClickListener) null);
            this.p = null;
        }
        this.o = null;
        if (this.t != null) {
            this.t = null;
        }
        if (this.u != null) {
            this.u = null;
        }
        if (this.w != null) {
            this.w.clear();
            this.w = null;
        }
        this.s = null;
        this.v = null;
        this.k = null;
        super.onDestroy();
    }

    public String a() {
        return d;
    }

    public void c() {
        f();
    }

    public void d() {
        a(true);
    }

    public void e() {
        String str;
        int i2;
        if (this.s != null && h.d(this.f974b)) {
            if (h.f1164b.i()) {
                str = String.format(h.f1164b.w + "/app/home_menu?ad_status=%s&brand_status=%s", new Object[]{"all", "all"});
            } else {
                str = String.format(h.f1164b.w + "/app/home_menu?ad_status=%s&brand_status=%s", new Object[]{"activated", "activated"});
            }
            try {
                i2 = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                i2 = 0;
            }
            String str2 = str + "&" + String.format("app_ver=%d", new Object[]{Integer.valueOf(i2)});
            if (h.f1164b.a()) {
                Log.d(d, "Load page : " + str2);
            }
            this.s.loadUrl(str2);
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            if (!(this.s == null || this.s.getVisibility() == 8)) {
                this.s.setVisibility(8);
            }
            if (this.o != null && this.o.getVisibility() != 0) {
                this.o.setVisibility(0);
                return;
            }
            return;
        }
        if (!(this.s == null || this.s.getVisibility() == 0)) {
            this.s.setVisibility(0);
        }
        if (this.o != null && this.o.getVisibility() != 8) {
            this.o.setVisibility(8);
        }
    }

    private void f() {
        if (this.n != null) {
            h.a((Context) getActivity(), this.n);
        }
    }

    /* access modifiers changed from: private */
    public void a(FitNShopMainActivity fitNShopMainActivity, int i2, String str) {
        this.r = new a(fitNShopMainActivity, i2, str);
        this.r.execute(new Void[0]);
    }

    /* compiled from: HomeWebFragment */
    public class a extends AsyncTask<Void, Void, b.a> {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f1022b;
        /* access modifiers changed from: private */
        public final String c;
        /* access modifiers changed from: private */
        public FitNShopMainActivity d;
        private int e = 0;

        public a(FitNShopMainActivity fitNShopMainActivity, int i, String str) {
            this.d = fitNShopMainActivity;
            this.f1022b = i;
            this.c = str;
        }

        public void a() {
            cancel(true);
            c();
            this.d = null;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            b();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public b.a doInBackground(Void... voidArr) {
            try {
                if (!isCancelled()) {
                    b.a a2 = this.d.a(this.f1022b);
                    if (a2 != null) {
                        if (a2.d().length == h.d.length) {
                            this.e = -2;
                            return a2;
                        }
                    }
                    if (isCancelled()) {
                        this.e = -1;
                        Log.d(g.d, "Task cancel.");
                        return null;
                    }
                    if (this.c != null) {
                        if (a2 == null) {
                            a2 = new b.a(this.f1022b, this.c);
                        }
                        for (String str : h.d) {
                            if (isCancelled()) {
                                this.e = -1;
                                Log.d(g.d, "Task cancel.");
                                return null;
                            }
                            a2.a(str, d.a(this.f1022b, str));
                            g.this.w.put(Integer.valueOf(this.f1022b), a2);
                            this.e = -2;
                        }
                    }
                    return a2;
                }
                this.e = -1;
                Log.d(g.d, "Task cancel.");
                return null;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                this.e = 1;
                return null;
            } catch (IOException e3) {
                e3.printStackTrace();
                this.e = 2;
                return null;
            } catch (JSONException e4) {
                e4.printStackTrace();
                this.e = 3;
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(b.a aVar) {
            c();
            if (this.e != -2) {
                this.d.a((b.a) new b.a() {
                    public void a(net.fxgear.fitnshop.c.b bVar) {
                        if (bVar != null) {
                            bVar.dismiss();
                        }
                        g.this.a(a.this.d, a.this.f1022b, a.this.c);
                    }

                    public void b(net.fxgear.fitnshop.c.b bVar) {
                        if (bVar != null) {
                            bVar.dismiss();
                        }
                    }
                });
            } else if (aVar != null) {
                g.this.f973a = 2;
                if (this.d.a(aVar)) {
                    net.fxgear.fitnshop.e.f.a("BANNER_CLI_PRDVIEW_DONE", "");
                }
            } else {
                Log.e(g.d, "Not found brand info.");
            }
        }

        private void b() {
            if (g.this.q == null) {
                net.fxgear.fitnshop.c.a unused = g.this.q = new net.fxgear.fitnshop.c.a(this.d, 0);
            }
            g.this.q.show();
        }

        private void c() {
            if (g.this.q != null) {
                if (g.this.q.isShowing()) {
                    g.this.q.dismiss();
                }
                net.fxgear.fitnshop.c.a unused = g.this.q = null;
            }
        }
    }

    public void a(String str) {
        Log.e(d, "OnPageStarted()");
    }

    public void b(String str) {
        String str2 = d;
        Log.e(str2, "OnPageFinished(), url = " + str);
        if (this.q != null && this.q.isShowing()) {
            this.q.dismiss();
        }
    }

    public void a(int i2, String str, String str2) {
        Log.e(d, "OnReceivedError()");
        if (this.x != null) {
            this.x.sendEmptyMessage(2);
        }
    }

    public void f(String str) {
        String str2 = d;
        Log.e(str2, "OnLoadPageFail(), url : " + str);
        if (this.x != null) {
            this.x.sendEmptyMessage(2);
        }
    }

    public void c(String str) {
        Log.e(d, "OnAddFittingWishlist()");
    }

    public void d(String str) {
        Log.e(d, "OnFitting()");
    }

    public void a(boolean z, String str) {
        Log.e(d, "OnNetworkState()");
    }

    public void e(String str) {
        Log.e(d, "OnStartActivityWithIntent()");
    }

    public void a_() {
        if (!h.d(getActivity().getApplicationContext()) && this.x != null) {
            this.x.sendEmptyMessage(2);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\d\h.java ==========

package net.fxgear.fitnshop.d;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import net.fxgear.fitnshop.FitNShopMainActivity;
import net.fxgear.fitnshop.i;
import net.fxgear.util.FXUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InfoFragment */
public class h extends b implements View.OnClickListener {
    public static final String d = "h";
    private final String e = "file:///android_asset/info/license.html";
    private final String f = "/%s/view/%s?type=mobile";
    private int g = -1;
    private String h = null;
    private TextView i;
    private net.fxgear.fitnshop.c.a j;
    private a k;
    /* access modifiers changed from: private */
    public WebView l;

    public void c() {
    }

    public void d() {
    }

    public h() {
        Log.i(d, "InfoFragment()+");
    }

    public h(int i2, String str) {
        String str2 = d;
        Log.i(str2, "InfoFragment()+, infoType: " + i2);
        this.g = i2;
        this.h = str;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i(d, "onCreate()+");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Log.i(d, "onCreateView()+");
        if (layoutInflater == null) {
            return null;
        }
        View inflate = layoutInflater.inflate(2131296276, viewGroup, false);
        if (inflate == null) {
            return inflate;
        }
        this.i = (TextView) inflate.findViewById(2131165321);
        ((Button) inflate.findViewById(2131165320)).setOnClickListener(this);
        ((Button) inflate.findViewById(2131165232)).setOnClickListener(this);
        this.k = new a();
        this.l = (WebView) inflate.findViewById(2131165322);
        this.l.setWebViewClient(this.k);
        this.l.getSettings().setJavaScriptEnabled(true);
        c(this.g);
        return inflate;
    }

    private void c(int i2) {
        String str;
        Log.i(d, "LoadPage()+, infoType: " + i2);
        if (i2 != -1) {
            String GetCurrentLanguageCode = FXUtil.GetCurrentLanguageCode(getActivity());
            String str2 = null;
            switch (i2) {
                case 0:
                    str = "file:///android_asset/info/license.html";
                    break;
                case 1:
                    str = net.fxgear.fitnshop.h.f1164b.w + String.format("/%s/view/%s?type=mobile", new Object[]{GetCurrentLanguageCode, "privacy"});
                    break;
                case 2:
                    str = net.fxgear.fitnshop.h.f1164b.w + String.format("/%s/view/%s?type=mobile", new Object[]{GetCurrentLanguageCode, "terms"});
                    break;
                default:
                    Log.e(d, "wrong infoType: " + i2);
                    return;
            }
            if (this.h != null) {
                try {
                    str2 = new JSONObject(this.h).getString("title");
                } catch (JSONException e2) {
                    Log.e(d, "[ERROR] :: JSONException");
                    e2.printStackTrace();
                }
            }
            if (this.i != null) {
                this.i.setText(str2);
            }
            if (this.l == null) {
                return;
            }
            if (i2 == 0 || net.fxgear.fitnshop.h.d(getActivity())) {
                this.l.setVisibility(0);
                this.l.loadUrl(str);
                return;
            }
            this.l.setVisibility(8);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        Log.i(d, "ondestroy()+");
        a(false);
        this.k = null;
        this.l = null;
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            if (this.j == null) {
                this.j = new net.fxgear.fitnshop.c.a(getActivity(), 0);
            }
            this.j.show();
        } else if (this.j != null) {
            this.j.dismiss();
            this.j = null;
        }
    }

    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == 2131165232) {
                c(this.g);
            } else if (id == 2131165320) {
                Activity activity = getActivity();
                if (activity instanceof FitNShopMainActivity) {
                    ((FitNShopMainActivity) activity).b(d);
                }
            }
        }
    }

    public String a() {
        return d;
    }

    public boolean b() {
        Log.i(d, "OnBackPressed()+");
        Activity activity = getActivity();
        if (!(activity instanceof FitNShopMainActivity)) {
            return true;
        }
        ((FitNShopMainActivity) activity).b(d);
        return true;
    }

    /* compiled from: InfoFragment */
    private class a extends WebViewClient {
        private a() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String str2 = h.d;
            i.a(str2, "shouldOverrideUrlLoading()+, url: " + str);
            if (!net.fxgear.fitnshop.h.d(h.this.getActivity())) {
                h.this.a(false);
                if (h.this.l != null) {
                    h.this.l.setVisibility(8);
                    return true;
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            String str2 = h.d;
            i.a(str2, "onPageStarted()+, url: " + str);
            super.onPageStarted(webView, str, bitmap);
            h.this.a(true);
        }

        public void onPageFinished(WebView webView, String str) {
            String str2 = h.d;
            i.a(str2, "onPageFinished()+, url: " + str);
            super.onPageFinished(webView, str);
            h.this.a(false);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            String str3 = h.d;
            i.a(str3, "onReceivedError()+, errorCode: " + i + ", description: " + str + ", failingUrl: " + str2);
            super.onReceivedError(webView, i, str, str2);
            h.this.a(false);
            if (h.this.l != null) {
                h.this.l.setVisibility(8);
            }
        }

        @TargetApi(23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            String str = h.d;
            i.a(str, "M, onReceivedError()+, errorCode: " + webResourceError.getErrorCode() + ", description: " + webResourceError.getDescription().toString() + ", failingUrl: " + webResourceRequest.getUrl().toString());
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            h.this.a(false);
            if (h.this.l != null) {
                h.this.l.setVisibility(8);
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\d\i.java ==========

package net.fxgear.fitnshop.d;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import net.fxgear.AvatarData;
import net.fxgear.AvatarSetting;
import net.fxgear.fitnshop.a.d;
import net.fxgear.fitnshop.j;
import net.fxgear.fittingmodenative.e;
import net.fxgear.util.FXDataManager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RecyclerViewFragment */
public class i extends b implements View.OnClickListener {
    public static final String d = "i";
    /* access modifiers changed from: private */
    public SimpleDateFormat A;
    private RelativeLayout B;
    private RelativeLayout C;
    private RelativeLayout D;
    private RelativeLayout E;
    private TextView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final String k;
    private final String l;
    private RecyclerView m;
    private a n;
    /* access modifiers changed from: private */
    public ArrayList<e.c> o;
    /* access modifiers changed from: private */
    public ArrayList<AvatarData> p;
    /* access modifiers changed from: private */
    public c q;
    /* access modifiers changed from: private */
    public int r;
    private final int s;
    private final int t;
    private final int u;
    private final int v;
    /* access modifiers changed from: private */
    public HashMap<Integer, Integer> w;
    /* access modifiers changed from: private */
    public int x;
    /* access modifiers changed from: private */
    public int y;
    /* access modifiers changed from: private */
    public d z;

    /* compiled from: RecyclerViewFragment */
    public interface c {
        void a(int i);

        void a(int i, int i2);

        void a(int i, int i2, int i3);

        void a(int i, String str);
    }

    public void c() {
    }

    public void d() {
    }

    public i() {
        this(-1, (c) null, (String) null, (d) null);
    }

    public i(int i2, c cVar, String str, d dVar) {
        this.e = 0;
        this.f = 1;
        this.g = 2;
        this.h = 2;
        this.i = 0;
        this.j = -1;
        this.k = "yyyy.MM.dd HH:mm";
        this.l = "%s %s";
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = -1;
        this.s = 0;
        this.t = 1;
        this.u = 2;
        this.v = 3;
        this.w = new HashMap<>();
        this.r = i2;
        this.q = cVar;
        this.z = dVar;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.x = jSONObject.getInt("gender");
                this.y = jSONObject.getInt("age");
                JSONObject jSONObject2 = jSONObject.getJSONObject("selected_items_id");
                if (jSONObject2 != null) {
                    this.w.put(0, Integer.valueOf(jSONObject2.getInt("woman_item_id")));
                    this.w.put(1, Integer.valueOf(jSONObject2.getInt("man_item_id")));
                    this.w.put(2, Integer.valueOf(jSONObject2.getInt("girl_item_id")));
                    this.w.put(3, Integer.valueOf(jSONObject2.getInt("boy_item_id")));
                }
            } catch (JSONException e2) {
                Log.e(d, "[ERROR] :: RecyclerViewFragment(), invalid JSON");
                e2.printStackTrace();
                this.x = 1;
                this.y = 2;
                this.w.put(0, -1);
                this.w.put(1, -1);
                this.w.put(2, -1);
                this.w.put(3, -1);
            }
        } else {
            this.x = 1;
            this.y = 2;
            this.w.put(0, -1);
            this.w.put(1, -1);
            this.w.put(2, -1);
            this.w.put(3, -1);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i(d, "onCreate()");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Log.i(d, "onCreateView()");
        if (layoutInflater == null) {
            return null;
        }
        View inflate = layoutInflater.inflate(2131296277, viewGroup, false);
        if (inflate == null) {
            return inflate;
        }
        this.c = inflate;
        ((Button) inflate.findViewById(2131165311)).setOnClickListener(this);
        Button button = (Button) inflate.findViewById(2131165310);
        button.setOnClickListener(this);
        TextView textView = (TextView) inflate.findViewById(2131165312);
        ((LinearLayout) inflate.findViewById(2131165339)).setVisibility(8);
        this.B = (RelativeLayout) inflate.findViewById(2131165251);
        this.C = (RelativeLayout) inflate.findViewById(2131165250);
        this.D = (RelativeLayout) inflate.findViewById(2131165249);
        this.E = (RelativeLayout) inflate.findViewById(2131165248);
        this.F = (TextView) inflate.findViewById(2131165247);
        this.G = (TextView) inflate.findViewById(2131165246);
        this.H = (TextView) inflate.findViewById(2131165245);
        this.I = (TextView) inflate.findViewById(2131165244);
        this.B.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
        f();
        this.m = (RecyclerView) inflate.findViewById(2131165334);
        this.n = new a();
        this.m.setAdapter(this.n);
        this.m.setItemViewCacheSize(0);
        this.m.setHasFixedSize(true);
        this.m.setItemAnimator(new android.support.v7.widget.c());
        this.m.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        this.m.a((RecyclerView.g) new RecyclerView.g() {
            public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.t tVar) {
                if (rect != null && view != null && recyclerView != null) {
                    int f = recyclerView.f(view);
                    int dimension = (int) i.this.getResources().getDimension(2131034378);
                    int i = f % 2;
                    rect.top = 0;
                    rect.bottom = dimension;
                    if (i == 0) {
                        rect.left = 0;
                        rect.right = dimension / 2;
                        return;
                    }
                    rect.left = dimension / 2;
                    rect.right = 0;
                }
            }
        });
        this.A = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        switch (this.r) {
            case 30:
            case 31:
                if (a(this.r, this.x, this.y) == -1) {
                    a(this.r, this.x, this.y, j.a((Context) getActivity()).a(this.x, this.y));
                }
                textView.setText(2131361914);
                button.setBackgroundResource(2131099822);
                b(e.a(this.f974b).a(this.x, this.y));
                return inflate;
            case 33:
                if (a(this.r, this.x, this.y) == -1) {
                    a(this.r, this.x, this.y, net.fxgear.fitnshop.a.a((Context) getActivity()).a(this.x, this.y));
                }
                textView.setText(2131361818);
                button.setBackgroundResource(2131099661);
                a(FXDataManager.GetInstance(this.f974b).GetAvatarDataList(this.x, this.y));
                return inflate;
            default:
                String str = d;
                Log.e(str, "[ERROR] :: wrong requestCode: " + this.r);
                return inflate;
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onClick(View view) {
        if (view != null) {
            boolean z2 = false;
            int id = view.getId();
            switch (id) {
                case 2131165248:
                    if (!(this.x == 2 && this.y == 1)) {
                        this.x = 2;
                        this.y = 1;
                        z2 = true;
                    }
                    f();
                    break;
                case 2131165249:
                    if (!(this.x == 1 && this.y == 1)) {
                        this.x = 1;
                        this.y = 1;
                        z2 = true;
                    }
                    f();
                    break;
                case 2131165250:
                    if (!(this.x == 2 && this.y == 2)) {
                        this.x = 2;
                        this.y = 2;
                        z2 = true;
                    }
                    f();
                    break;
                case 2131165251:
                    if (!(this.x == 1 && this.y == 2)) {
                        this.x = 1;
                        this.y = 2;
                        z2 = true;
                    }
                    f();
                    break;
                default:
                    switch (id) {
                        case 2131165310:
                            if (this.q != null) {
                                this.q.a(this.r, this.x, this.y);
                                break;
                            }
                            break;
                        case 2131165311:
                            if (this.q != null) {
                                this.q.a(this.r, a(this.r, this.x, this.y, this.w));
                                break;
                            }
                            break;
                    }
            }
            if (!z2) {
                return;
            }
            if (this.r == 30 || this.r == 31) {
                b(e.a(this.f974b).a(this.x, this.y));
                if (this.n != null) {
                    this.n.c();
                }
            } else if (this.r == 33) {
                a(FXDataManager.GetInstance(this.f974b).GetAvatarDataList(this.x, this.y));
                if (this.n != null) {
                    this.n.c();
                }
            }
        }
    }

    private void a(ArrayList<AvatarData> arrayList) {
        if (arrayList != null) {
            if (this.p != null) {
                this.p.clear();
                this.p = null;
            }
            this.p = new ArrayList<>();
            this.p.addAll(arrayList);
            Collections.sort(this.p, new Comparator<AvatarData>() {
                /* renamed from: a */
                public int compare(AvatarData avatarData, AvatarData avatarData2) {
                    long j;
                    long j2;
                    try {
                        j = Long.parseLong(avatarData.mFolderName);
                    } catch (Exception unused) {
                        j = 0;
                    }
                    try {
                        j2 = Long.parseLong(avatarData2.mFolderName);
                    } catch (Exception unused2) {
                        j2 = 0;
                    }
                    if (j > j2) {
                        return 1;
                    }
                    return j < j2 ? -1 : 0;
                }
            });
            if (this.n != null) {
                this.n.c();
            }
        }
    }

    public String e() {
        int GetHairTypeByIndex = AvatarSetting.GetHairTypeByIndex(getActivity(), 0, this.x, this.y);
        int i2 = 2;
        if (!AvatarSetting.IsExistHeadType(getActivity(), 2, this.x, this.y)) {
            i2 = AvatarSetting.GetHeadTypeByIndex(getActivity(), 0, this.x, this.y);
        }
        int AddAvatarData = FXDataManager.GetInstance(this.f974b).AddAvatarData(this.x, this.y, GetHairTypeByIndex, i2);
        if (AddAvatarData == -1) {
            return null;
        }
        net.fxgear.fitnshop.a.a((Context) getActivity()).a(AddAvatarData, this.x, this.y, 0, 1);
        a(this.r, this.x, this.y, AddAvatarData);
        return a(this.r, this.x, this.y, this.w);
    }

    private void b(ArrayList<e.c> arrayList) {
        if (arrayList != null) {
            j a2 = j.a((Context) getActivity());
            ArrayList<Integer> b2 = a2.b(this.x, this.y);
            if (b2 != null) {
                Iterator<Integer> it = b2.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    boolean z2 = true;
                    Iterator<e.c> it2 = arrayList.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (it2.next().f1465a == intValue) {
                                break;
                            }
                            z2 = false;
                        } else if (!z2) {
                            a2.a(intValue);
                        }
                    }
                }
            }
            if (this.o != null) {
                this.o.clear();
                this.o = null;
            }
            this.o = new ArrayList<>();
            this.o.addAll(arrayList);
            Collections.sort(this.o, new Comparator<e.c>() {
                /* renamed from: a */
                public int compare(e.c cVar, e.c cVar2) {
                    int i;
                    long j;
                    long j2;
                    int i2 = Integer.MAX_VALUE;
                    try {
                        i = Integer.parseInt(cVar.f);
                    } catch (Exception unused) {
                        i = Integer.MAX_VALUE;
                    }
                    try {
                        i2 = Integer.parseInt(cVar2.f);
                    } catch (Exception unused2) {
                    }
                    if (i <= i2) {
                        if (i < i2) {
                            return -1;
                        }
                        try {
                            j = Long.parseLong(cVar.e);
                        } catch (Exception unused3) {
                            j = 0;
                        }
                        try {
                            j2 = Long.parseLong(cVar2.e);
                        } catch (Exception unused4) {
                            j2 = 0;
                        }
                        if (j <= j2) {
                            if (j < j2) {
                                return -1;
                            }
                            return 0;
                        }
                    }
                    return 1;
                }
            });
            if (this.n != null) {
                this.n.c();
            }
        }
    }

    public String a(int i2, int i3, int i4, Context context) {
        j.a(context).a(i4, i2, i3, 0, 1);
        a(this.r, i2, i3, i4);
        return a(this.r, i2, i3, this.w);
    }

    public void c(int i2) {
        if (this.r == 30 || this.r == 31) {
            int size = this.o.size();
            for (int i3 = 0; i3 < size; i3++) {
                e.c cVar = this.o.get(i3);
                if (i2 == cVar.f1465a) {
                    cVar.d = 1;
                    a(this.r, cVar.f1465a, false);
                    if (this.q != null) {
                        this.q.a(this.r, a(this.r, this.x, this.y, this.w));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        String str = d;
        Log.e(str, "NotifyDownloadComplete(), wrong requestCode: " + this.r);
    }

    private void a(int i2, int i3, int i4, int i5) {
        if (this.w != null) {
            int i6 = 2;
            if (i3 == 2) {
                i6 = i4 == 1 ? 3 : 1;
            } else if (i4 != 1) {
                i6 = 0;
            }
            this.w.put(Integer.valueOf(i6), Integer.valueOf(i5));
        }
    }

    /* access modifiers changed from: private */
    public int a(int i2, int i3, int i4) {
        if (this.w == null) {
            return -1;
        }
        int i5 = 2;
        if (i3 == 2) {
            i5 = i4 == 1 ? 3 : 1;
        } else if (i4 != 1) {
            i5 = 0;
        }
        if (this.w.get(Integer.valueOf(i5)) != null) {
            return this.w.get(Integer.valueOf(i5)).intValue();
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3, boolean z2) {
        e.c cVar;
        e.c cVar2;
        e.c cVar3;
        AvatarData avatarData;
        AvatarData avatarData2;
        AvatarData avatarData3;
        int i4 = -1;
        AvatarData avatarData4 = null;
        switch (i2) {
            case 30:
            case 31:
                if (this.o != null && this.m != null) {
                    j a2 = j.a((Context) getActivity());
                    Iterator<e.c> it = this.o.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            cVar = it.next();
                            if (cVar != null && cVar.f1465a == i3) {
                                i4 = this.o.indexOf(cVar);
                            }
                        } else {
                            cVar = null;
                        }
                    }
                    b bVar = (b) this.m.b(i4);
                    if (bVar != null) {
                        a(bVar, 1);
                        bVar.r.setVisibility(8);
                        if (!a2.b(cVar.f1465a) || a2.c(cVar.f1465a)) {
                            bVar.q.setVisibility(0);
                        } else {
                            bVar.q.setVisibility(8);
                        }
                    }
                    int i5 = 0;
                    while (true) {
                        if (i5 < this.o.size()) {
                            if (i5 == i4) {
                                cVar3 = avatarData4;
                            } else {
                                e.c cVar4 = this.o.get(i5);
                                if (cVar4.f1465a == a(i2, this.x, this.y)) {
                                    cVar2 = cVar4;
                                } else {
                                    cVar3 = cVar4;
                                }
                            }
                            i5++;
                            avatarData4 = cVar3;
                        } else {
                            i5 = 0;
                            cVar2 = avatarData4;
                        }
                    }
                    b bVar2 = (b) this.m.b(i5);
                    if (bVar2 != null) {
                        if (z2) {
                            bVar2.q.setVisibility(8);
                            bVar2.r.setVisibility(0);
                            a(bVar2, 0);
                        } else {
                            a(bVar2, 2);
                            if (cVar2 != null) {
                                if (!a2.b(cVar2.f1465a) || a2.c(cVar2.f1465a)) {
                                    bVar2.q.setVisibility(0);
                                } else {
                                    bVar2.q.setVisibility(8);
                                }
                            }
                        }
                    }
                    a(i2, this.x, this.y, cVar.f1465a);
                    return;
                }
                return;
            case 33:
                if (this.p != null && this.m != null) {
                    net.fxgear.fitnshop.a a3 = net.fxgear.fitnshop.a.a((Context) getActivity());
                    Iterator<AvatarData> it2 = this.p.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            avatarData = it2.next();
                            if (avatarData != null && avatarData.mAvatarID == i3) {
                                i4 = this.p.indexOf(avatarData);
                            }
                        } else {
                            avatarData = null;
                        }
                    }
                    b bVar3 = (b) this.m.b(i4);
                    if (bVar3 != null) {
                        a(bVar3, 1);
                        if (a3.b(avatarData.mAvatarID)) {
                            bVar3.q.setVisibility(8);
                        } else {
                            bVar3.q.setVisibility(0);
                        }
                    }
                    int i6 = 0;
                    while (true) {
                        if (i6 < this.p.size()) {
                            if (i6 == i4) {
                                avatarData3 = avatarData4;
                            } else {
                                AvatarData avatarData5 = this.p.get(i6);
                                if (avatarData5.mAvatarID == a(i2, this.x, this.y)) {
                                    avatarData2 = avatarData5;
                                } else {
                                    avatarData3 = avatarData5;
                                }
                            }
                            i6++;
                            avatarData4 = avatarData3;
                        } else {
                            i6 = 0;
                            avatarData2 = avatarData4;
                        }
                    }
                    b bVar4 = (b) this.m.b(i6);
                    if (bVar4 != null) {
                        a(bVar4, 2);
                        if (avatarData2 != null) {
                            if (a3.b(avatarData2.mAvatarID)) {
                                bVar4.q.setVisibility(8);
                            } else {
                                bVar4.q.setVisibility(0);
                            }
                        }
                    }
                    a(i2, this.x, this.y, avatarData.mAvatarID);
                    return;
                }
                return;
            default:
                Log.e(d, "[ERROR] :: wrong requestCode: " + i2);
                return;
        }
    }

    private void d(int i2) {
        switch (i2) {
            case 30:
            case 31:
                if (this.o != null) {
                    int a2 = j.a((Context) getActivity()).a(this.x, this.y);
                    Iterator<e.c> it = this.o.iterator();
                    while (it.hasNext()) {
                        e.c next = it.next();
                        if (next != null && a2 == next.f1465a) {
                            a(i2, next.f1465a, true);
                            return;
                        }
                    }
                    return;
                }
                return;
            case 33:
                if (this.p != null) {
                    int a3 = net.fxgear.fitnshop.a.a((Context) getActivity()).a(this.x, this.y);
                    Iterator<AvatarData> it2 = this.p.iterator();
                    while (it2.hasNext()) {
                        AvatarData next2 = it2.next();
                        if (next2 != null && a3 == next2.mAvatarID) {
                            a(i2, next2.mAvatarID, true);
                            return;
                        }
                    }
                    return;
                }
                return;
            default:
                String str = d;
                Log.e(str, "[ERROR] :: wrong requestCode: " + i2);
                return;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: net.fxgear.fittingmodenative.e$c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: net.fxgear.AvatarData} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r5, int r6) {
        /*
            r4 = this;
            r0 = 0
            switch(r5) {
                case 30: goto L_0x008a;
                case 31: goto L_0x008a;
                case 32: goto L_0x0004;
                case 33: goto L_0x001c;
                default: goto L_0x0004;
            }
        L_0x0004:
            java.lang.String r6 = d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "[ERROR] :: wrong requestCode: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            android.util.Log.e(r6, r5)
            goto L_0x0136
        L_0x001c:
            java.util.ArrayList<net.fxgear.AvatarData> r1 = r4.p
            if (r1 == 0) goto L_0x0136
            java.util.ArrayList<net.fxgear.AvatarData> r1 = r4.p
            java.util.Iterator r1 = r1.iterator()
        L_0x0026:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0037
            java.lang.Object r2 = r1.next()
            net.fxgear.AvatarData r2 = (net.fxgear.AvatarData) r2
            int r3 = r2.mAvatarID
            if (r3 != r6) goto L_0x0026
            r0 = r2
        L_0x0037:
            if (r0 == 0) goto L_0x0081
            android.app.Activity r6 = r4.getActivity()
            net.fxgear.fitnshop.a r6 = net.fxgear.fitnshop.a.a((android.content.Context) r6)
            int r1 = r0.mAvatarID
            boolean r1 = r6.b(r1)
            if (r1 != 0) goto L_0x0078
            java.util.ArrayList<net.fxgear.AvatarData> r1 = r4.p
            r1.remove(r0)
            int r1 = r4.x
            int r2 = r4.y
            int r1 = r4.a((int) r5, (int) r1, (int) r2)
            int r2 = r0.mAvatarID
            if (r1 != r2) goto L_0x005d
            r4.d((int) r5)
        L_0x005d:
            int r5 = r0.mAvatarID
            r6.a((int) r5)
            android.content.Context r5 = r4.f974b
            net.fxgear.util.FXDataManager r5 = net.fxgear.util.FXDataManager.GetInstance(r5)
            int r6 = r0.mAvatarID
            r5.RemoveAvatarData(r6)
            net.fxgear.fitnshop.d.i$a r5 = r4.n
            if (r5 == 0) goto L_0x0136
            net.fxgear.fitnshop.d.i$a r5 = r4.n
            r5.c()
            goto L_0x0136
        L_0x0078:
            java.lang.String r5 = d
            java.lang.String r6 = "DeleteAvatarData(), [ERROR] :: can not delete default avatar"
            android.util.Log.e(r5, r6)
            goto L_0x0136
        L_0x0081:
            java.lang.String r5 = d
            java.lang.String r6 = "DeleteAvatarData(), [ERROR] :: avatarData is null"
            android.util.Log.e(r5, r6)
            goto L_0x0136
        L_0x008a:
            java.util.ArrayList<net.fxgear.fittingmodenative.e$c> r1 = r4.o
            if (r1 == 0) goto L_0x0136
            java.util.ArrayList<net.fxgear.fittingmodenative.e$c> r1 = r4.o
            java.util.Iterator r1 = r1.iterator()
        L_0x0094:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00a5
            java.lang.Object r2 = r1.next()
            net.fxgear.fittingmodenative.e$c r2 = (net.fxgear.fittingmodenative.e.c) r2
            int r3 = r2.f1465a
            if (r3 != r6) goto L_0x0094
            r0 = r2
        L_0x00a5:
            if (r0 == 0) goto L_0x012f
            android.app.Activity r6 = r4.getActivity()
            net.fxgear.fitnshop.j r6 = net.fxgear.fitnshop.j.a((android.content.Context) r6)
            int r1 = r0.f1465a
            boolean r1 = r6.c(r1)
            if (r1 == 0) goto L_0x0136
            int r1 = r0.f1465a
            boolean r1 = r6.b(r1)
            r2 = 0
            if (r1 == 0) goto L_0x0101
            android.content.Context r6 = r4.f974b
            net.fxgear.fittingmodenative.e r6 = net.fxgear.fittingmodenative.e.a((android.content.Context) r6)
            int r1 = r0.f1465a
            r3 = 1
            r6.a((int) r1, (boolean) r3)
            r0.d = r2
            int r6 = r4.x
            int r1 = r4.y
            int r6 = r4.a((int) r5, (int) r6, (int) r1)
            int r1 = r0.f1465a
            if (r6 != r1) goto L_0x00de
            r4.d((int) r5)
            goto L_0x0136
        L_0x00de:
            java.util.ArrayList<net.fxgear.fittingmodenative.e$c> r5 = r4.o
            int r5 = r5.indexOf(r0)
            r6 = -1
            if (r5 == r6) goto L_0x0136
            android.support.v7.widget.RecyclerView r6 = r4.m
            android.support.v7.widget.RecyclerView$w r5 = r6.b((int) r5)
            net.fxgear.fitnshop.d.i$b r5 = (net.fxgear.fitnshop.d.i.b) r5
            if (r5 == 0) goto L_0x0136
            android.widget.Button r6 = r5.q
            r0 = 8
            r6.setVisibility(r0)
            android.view.View r6 = r5.r
            r6.setVisibility(r2)
            r4.a((net.fxgear.fitnshop.d.i.b) r5, (int) r2)
            goto L_0x0136
        L_0x0101:
            java.util.ArrayList<net.fxgear.fittingmodenative.e$c> r1 = r4.o
            r1.remove(r0)
            int r1 = r4.x
            int r3 = r4.y
            int r1 = r4.a((int) r5, (int) r1, (int) r3)
            int r3 = r0.f1465a
            if (r1 != r3) goto L_0x0115
            r4.d((int) r5)
        L_0x0115:
            int r5 = r0.f1465a
            r6.a((int) r5)
            android.content.Context r5 = r4.f974b
            net.fxgear.fittingmodenative.e r5 = net.fxgear.fittingmodenative.e.a((android.content.Context) r5)
            int r6 = r0.f1465a
            r5.a((int) r6, (boolean) r2)
            net.fxgear.fitnshop.d.i$a r5 = r4.n
            if (r5 == 0) goto L_0x0136
            net.fxgear.fitnshop.d.i$a r5 = r4.n
            r5.c()
            goto L_0x0136
        L_0x012f:
            java.lang.String r5 = d
            java.lang.String r6 = "DeleteMirrorVideoData(), [ERROR] :: videoData is null"
            android.util.Log.e(r5, r6)
        L_0x0136:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.d.i.a(int, int):void");
    }

    public String a(int i2, int i3, int i4, HashMap<Integer, Integer> hashMap) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        JSONObject jSONObject = new JSONObject();
        String str = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (hashMap != null) {
                switch (i2) {
                    case 30:
                    case 31:
                        if (hashMap.get(0).intValue() != -1) {
                            i5 = hashMap.get(0).intValue();
                        } else {
                            i5 = j.a((Context) getActivity()).a(1, 2);
                        }
                        jSONObject2.put("woman_item_id", i5);
                        if (hashMap.get(1).intValue() != -1) {
                            i6 = hashMap.get(1).intValue();
                        } else {
                            i6 = j.a((Context) getActivity()).a(2, 2);
                        }
                        jSONObject2.put("man_item_id", i6);
                        if (hashMap.get(2).intValue() != -1) {
                            i7 = hashMap.get(2).intValue();
                        } else {
                            i7 = j.a((Context) getActivity()).a(1, 1);
                        }
                        jSONObject2.put("girl_item_id", i7);
                        if (hashMap.get(3).intValue() != -1) {
                            i8 = hashMap.get(3).intValue();
                        } else {
                            i8 = j.a((Context) getActivity()).a(2, 1);
                        }
                        jSONObject2.put("boy_item_id", i8);
                        break;
                    case 33:
                        if (hashMap.get(0).intValue() != -1) {
                            i9 = hashMap.get(0).intValue();
                        } else {
                            i9 = net.fxgear.fitnshop.a.a((Context) getActivity()).a(1, 2);
                        }
                        jSONObject2.put("woman_item_id", i9);
                        if (hashMap.get(1).intValue() != -1) {
                            i10 = hashMap.get(1).intValue();
                        } else {
                            i10 = net.fxgear.fitnshop.a.a((Context) getActivity()).a(2, 2);
                        }
                        jSONObject2.put("man_item_id", i10);
                        if (hashMap.get(2).intValue() != -1) {
                            i11 = hashMap.get(2).intValue();
                        } else {
                            i11 = net.fxgear.fitnshop.a.a((Context) getActivity()).a(1, 1);
                        }
                        jSONObject2.put("girl_item_id", i11);
                        if (hashMap.get(3).intValue() != -1) {
                            i12 = hashMap.get(3).intValue();
                        } else {
                            i12 = net.fxgear.fitnshop.a.a((Context) getActivity()).a(2, 1);
                        }
                        jSONObject2.put("boy_item_id", i12);
                        break;
                    default:
                        String str2 = d;
                        Log.e(str2, "wrong requestCode: " + i2);
                        return null;
                }
            }
            jSONObject.put("gender", i3);
            jSONObject.put("age", i4);
            jSONObject.put("selected_items_id", jSONObject2);
            String jSONObject3 = jSONObject.toString();
            try {
                String str3 = d;
                Log.e(str3, "GetStringJsonDataInfo(), jsonDataInfo: " + jSONObject.toString());
                return jSONObject3;
            } catch (JSONException e2) {
                str = jSONObject3;
                e = e2;
            }
        } catch (JSONException e3) {
            e = e3;
            Log.e(d, "[ERROR] :: GetStringJsonDataInfo(), JSONException");
            e.printStackTrace();
            return str;
        }
    }

    private void f() {
        if (this.x == 2) {
            if (this.y == 1) {
                this.B.setBackgroundColor(0);
                this.C.setBackgroundColor(0);
                this.D.setBackgroundColor(0);
                this.E.setBackgroundResource(2131099859);
                this.F.setTextColor(getResources().getColor(2130968605));
                this.G.setTextColor(getResources().getColor(2130968605));
                this.H.setTextColor(getResources().getColor(2130968605));
                this.I.setTextColor(getResources().getColor(2130968604));
                return;
            }
            this.B.setBackgroundColor(0);
            this.C.setBackgroundResource(2131099859);
            this.D.setBackgroundColor(0);
            this.E.setBackgroundColor(0);
            this.F.setTextColor(getResources().getColor(2130968605));
            this.G.setTextColor(getResources().getColor(2130968604));
            this.H.setTextColor(getResources().getColor(2130968605));
            this.I.setTextColor(getResources().getColor(2130968605));
        } else if (this.y == 1) {
            this.B.setBackgroundColor(0);
            this.C.setBackgroundColor(0);
            this.D.setBackgroundResource(2131099859);
            this.E.setBackgroundColor(0);
            this.F.setTextColor(getResources().getColor(2130968605));
            this.G.setTextColor(getResources().getColor(2130968605));
            this.H.setTextColor(getResources().getColor(2130968604));
            this.I.setTextColor(getResources().getColor(2130968605));
        } else {
            this.B.setBackgroundResource(2131099859);
            this.C.setBackgroundColor(0);
            this.D.setBackgroundColor(0);
            this.E.setBackgroundColor(0);
            this.F.setTextColor(getResources().getColor(2130968604));
            this.G.setTextColor(getResources().getColor(2130968605));
            this.H.setTextColor(getResources().getColor(2130968605));
            this.I.setTextColor(getResources().getColor(2130968605));
        }
    }

    /* compiled from: RecyclerViewFragment */
    private class b extends RecyclerView.w implements View.OnClickListener {
        ImageView n;
        Button o;
        TextView p;
        Button q;
        View r;
        View s;

        public b(View view) {
            super(view);
            this.n = (ImageView) view.findViewById(2131165362);
            this.o = (Button) view.findViewById(2131165360);
            this.p = (TextView) view.findViewById(2131165363);
            this.q = (Button) view.findViewById(2131165359);
            this.r = view.findViewById(2131165361);
            this.s = view.findViewById(2131165406);
            this.n.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.q.setOnClickListener(this);
        }

        public void onClick(View view) {
            if (view != null) {
                int e = e();
                switch (view.getId()) {
                    case 2131165359:
                        if (i.this.r == 30 || i.this.r == 31) {
                            if (i.this.q != null && i.this.o != null) {
                                i.this.q.a(i.this.r, ((e.c) i.this.o.get(e)).f1465a);
                                return;
                            }
                            return;
                        } else if (i.this.r == 33 && i.this.q != null && i.this.p != null) {
                            i.this.q.a(i.this.r, ((AvatarData) i.this.p.get(e)).mAvatarID);
                            return;
                        } else {
                            return;
                        }
                    case 2131165360:
                        if (i.this.r == 30 || i.this.r == 31) {
                            if (i.this.o != null) {
                                e.c cVar = (e.c) i.this.o.get(e);
                                if (cVar.d == 1) {
                                    if (cVar.f1465a != i.this.a(i.this.r, i.this.x, i.this.y)) {
                                        i.this.a(i.this.r, cVar.f1465a, false);
                                        if (i.this.q != null) {
                                            i.this.q.a(i.this.r, i.this.a(i.this.r, i.this.x, i.this.y, (HashMap<Integer, Integer>) i.this.w));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                } else if (i.this.q != null) {
                                    i.this.q.a(cVar.f1465a);
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else if (i.this.r == 33 && i.this.p != null) {
                            AvatarData avatarData = (AvatarData) i.this.p.get(e);
                            if (avatarData.mAvatarID != i.this.a(i.this.r, i.this.x, i.this.y)) {
                                i.this.a(i.this.r, avatarData.mAvatarID, false);
                                if (i.this.q != null) {
                                    i.this.q.a(i.this.r, i.this.a(i.this.r, i.this.x, i.this.y, (HashMap<Integer, Integer>) i.this.w));
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 2131165362:
                        if (i.this.r == 30 || i.this.r == 31) {
                            if (i.this.o != null) {
                                e.c cVar2 = (e.c) i.this.o.get(e);
                                if (cVar2.d == 1) {
                                    String str = i.d;
                                    Log.d(str, "select videoID : " + cVar2.f1465a);
                                    if (cVar2.f1465a != i.this.a(i.this.r, i.this.x, i.this.y)) {
                                        i.this.a(i.this.r, cVar2.f1465a, false);
                                        if (i.this.q != null) {
                                            i.this.q.a(i.this.r, i.this.a(i.this.r, i.this.x, i.this.y, (HashMap<Integer, Integer>) i.this.w));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (i.this.r == 33 && i.this.p != null) {
                            AvatarData avatarData2 = (AvatarData) i.this.p.get(e);
                            String str2 = i.d;
                            Log.d(str2, "select avatarID : " + avatarData2.mAvatarID);
                            if (avatarData2.mAvatarID != i.this.a(i.this.r, i.this.x, i.this.y)) {
                                i.this.a(i.this.r, avatarData2.mAvatarID, false);
                                if (i.this.q != null) {
                                    i.this.q.a(i.this.r, i.this.a(i.this.r, i.this.x, i.this.y, (HashMap<Integer, Integer>) i.this.w));
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(b bVar, int i2) {
        String str = d;
        Log.i(str, "SetItemSelectIconType()+, buttonType: " + i2);
        if (bVar != null) {
            switch (i2) {
                case 0:
                    bVar.o.setBackgroundResource(2131099824);
                    bVar.s.setVisibility(8);
                    return;
                case 1:
                    bVar.o.setBackgroundColor(0);
                    bVar.s.setVisibility(0);
                    return;
                case 2:
                    bVar.o.setBackgroundResource(2131099744);
                    bVar.s.setVisibility(8);
                    return;
                default:
                    String str2 = d;
                    Log.e(str2, "wrong button type: " + i2);
                    bVar.o.setBackgroundColor(0);
                    bVar.s.setVisibility(8);
                    return;
            }
        }
    }

    /* compiled from: RecyclerViewFragment */
    private class a extends RecyclerView.a<b> {
        private a() {
        }

        public int a() {
            switch (i.this.r) {
                case 30:
                case 31:
                    if (i.this.o != null) {
                        return i.this.o.size();
                    }
                    return 0;
                case 33:
                    if (i.this.p != null) {
                        return i.this.p.size();
                    }
                    return 0;
                default:
                    String str = i.d;
                    Log.e(str, "wrong requestCode: " + i.this.r);
                    return 0;
            }
        }

        public void a(b bVar, int i) {
            String str = i.d;
            Log.e(str, "onBindViewHolder() " + i);
            int i2 = 2;
            switch (i.this.r) {
                case 30:
                case 31:
                    if (i.this.o != null) {
                        e.c cVar = (e.c) i.this.o.get(i);
                        if (i.this.z != null) {
                            i.this.z.a(bVar.n, cVar.g, (Runnable) null);
                        }
                        j a2 = j.a((Context) i.this.getActivity());
                        if (a2.b(cVar.f1465a)) {
                            bVar.p.setText(String.format("%s %s", new Object[]{i.this.getResources().getString(2131361913), cVar.f}));
                        } else {
                            bVar.p.setText(i.this.A.format(new Date(Long.parseLong(cVar.e))));
                        }
                        if (cVar.f1465a == i.this.a(i.this.r, i.this.x, i.this.y)) {
                            bVar.r.setVisibility(8);
                            i.this.a(bVar, 1);
                            if (!a2.b(cVar.f1465a) || a2.c(cVar.f1465a)) {
                                bVar.q.setVisibility(0);
                                return;
                            } else {
                                bVar.q.setVisibility(8);
                                return;
                            }
                        } else if (cVar.d == 1) {
                            bVar.r.setVisibility(8);
                            i.this.a(bVar, 2);
                            if (!a2.b(cVar.f1465a) || a2.c(cVar.f1465a)) {
                                bVar.q.setVisibility(0);
                                return;
                            } else {
                                bVar.q.setVisibility(8);
                                return;
                            }
                        } else {
                            bVar.q.setVisibility(8);
                            bVar.r.setVisibility(0);
                            i.this.a(bVar, 0);
                            return;
                        }
                    } else {
                        return;
                    }
                case 33:
                    if (i.this.p != null) {
                        AvatarData avatarData = (AvatarData) i.this.p.get(i);
                        if (avatarData.mAvatarID == i.this.a(i.this.r, i.this.x, i.this.y)) {
                            i2 = 1;
                        }
                        i.this.a(bVar, i2);
                        if (net.fxgear.fitnshop.a.a((Context) i.this.getActivity()).b(avatarData.mAvatarID)) {
                            if (i.this.z != null) {
                                i.this.z.a(bVar.n, avatarData.mThumbnailPath, (Runnable) null);
                            }
                            bVar.p.setText(2131361817);
                            bVar.q.setVisibility(8);
                        } else {
                            if (i.this.z != null) {
                                i.this.z.a(bVar.n, avatarData.mThumbnailPath, (Runnable) null);
                            }
                            bVar.p.setText(i.this.A.format(new Date(Long.parseLong(avatarData.mFolderName))));
                            bVar.q.setVisibility(0);
                        }
                        bVar.r.setVisibility(8);
                        return;
                    }
                    return;
                default:
                    String str2 = i.d;
                    Log.e(str2, "wrong requestCode: " + i.this.r);
                    return;
            }
        }

        /* renamed from: c */
        public b a(ViewGroup viewGroup, int i) {
            String str = i.d;
            Log.e(str, "onCreateViewHolder() " + i);
            return new b(LayoutInflater.from(i.this.getActivity()).inflate(2131296309, viewGroup, false));
        }
    }

    public String a() {
        return d;
    }

    public boolean b() {
        Log.i(d, "OnBackPressed()");
        if (this.q == null) {
            return true;
        }
        this.q.a(this.r, a(this.r, this.x, this.y, this.w));
        return true;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\d\j.java ==========

package net.fxgear.fitnshop.d;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import net.fxgear.fitnshop.FitNShopMainActivity;
import net.fxgear.fitnshop.e.f;

/* compiled from: SearchFragment */
public class j extends b implements View.OnClickListener {
    /* access modifiers changed from: private */
    public final String d = j.class.getSimpleName();
    private Button e;
    /* access modifiers changed from: private */
    public Button f;
    /* access modifiers changed from: private */
    public EditText g;
    /* access modifiers changed from: private */
    public InputMethodManager h;
    private final int i = 97;
    private final int j = 98;
    private final int k = 99;
    /* access modifiers changed from: private */
    public Handler l = new Handler() {
        public void handleMessage(Message message) {
            boolean z = false;
            switch (message.what) {
                case 97:
                    if (j.this.h != null && j.this.g != null) {
                        j.this.g.requestFocus();
                        j.this.h.showSoftInput(j.this.g, 0);
                        return;
                    }
                    return;
                case 98:
                    if (!(j.this.h == null || j.this.g == null)) {
                        final Object obj = message.obj;
                        z = j.this.h.hideSoftInputFromWindow(j.this.g.getApplicationWindowToken(), 0, new ResultReceiver((Handler) null) {
                            /* access modifiers changed from: protected */
                            public void onReceiveResult(int i, Bundle bundle) {
                                if (i == 3) {
                                    Log.d(j.this.d, "MSG_FINISH_FRAGMENT, SoftKeyboard hide success - close fragment");
                                    AnonymousClass1.this.obtainMessage(99, obj).sendToTarget();
                                }
                            }
                        });
                    }
                    if (!z) {
                        Log.d(j.this.d, "MSG_FINISH_FRAGMENT, SoftKeyboard state off - close fragment");
                        obtainMessage(99, message.obj).sendToTarget();
                        return;
                    }
                    return;
                case 99:
                    if (j.this.getActivity() instanceof FitNShopMainActivity) {
                        FitNShopMainActivity fitNShopMainActivity = (FitNShopMainActivity) j.this.getActivity();
                        fitNShopMainActivity.b(j.this.d);
                        if (message.obj != null) {
                            fitNShopMainActivity.h((String) message.obj);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private TextWatcher m = new TextWatcher() {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.toString().getBytes().length > 0) {
                j.this.f.setVisibility(0);
            } else {
                j.this.f.setVisibility(4);
            }
        }
    };
    private TextView.OnEditorActionListener n = new TextView.OnEditorActionListener() {
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 3) {
                return false;
            }
            String charSequence = textView.getText().toString();
            if (charSequence.getBytes().length <= 0) {
                return false;
            }
            j.this.l.obtainMessage(98, charSequence).sendToTarget();
            f.a("SEARCH_CLI", "");
            return true;
        }
    };

    public void c() {
    }

    public void d() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i(this.d, "onCreate()+");
        this.h = (InputMethodManager) getActivity().getSystemService("input_method");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Log.i(this.d, "onCreateView()+");
        if (this.c == null) {
            this.c = layoutInflater.inflate(2131296278, viewGroup, false);
            this.e = (Button) this.c.findViewById(2131165233);
            this.f = (Button) this.c.findViewById(2131165234);
            this.g = (EditText) this.c.findViewById(2131165293);
            this.e.setOnClickListener(this);
            this.f.setOnClickListener(this);
            this.f.setVisibility(4);
            this.g.setOnEditorActionListener(this.n);
            this.g.addTextChangedListener(this.m);
            e();
        }
        return this.c;
    }

    private void e() {
        Log.d(this.d, "ShowSoftKeyborad()+");
        c(97);
    }

    private void f() {
        Log.d(this.d, "ShowSoftKeyborad()+");
        c(98);
    }

    private void c(int i2) {
        if (this.l != null && !this.l.hasMessages(i2)) {
            this.l.sendEmptyMessage(i2);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case 2131165233:
                f();
                return;
            case 2131165234:
                this.g.setText("");
                this.f.setVisibility(4);
                return;
            default:
                return;
        }
    }

    public void onResume() {
        super.onResume();
        Log.i(this.d, "onResume()+");
    }

    public void onPause() {
        super.onPause();
        Log.i(this.d, "onPause()+");
    }

    public void onDestroy() {
        Log.i(this.d, "onDestroy()+");
        if (this.l != null) {
            this.l.removeCallbacksAndMessages((Object) null);
            this.l = null;
        }
        if (this.e != null) {
            this.e.setOnClickListener((View.OnClickListener) null);
            this.e = null;
        }
        if (this.f != null) {
            this.f.setOnClickListener((View.OnClickListener) null);
            this.f = null;
        }
        if (this.g != null) {
            this.g.setOnEditorActionListener((TextView.OnEditorActionListener) null);
            this.g.removeTextChangedListener(this.m);
            this.g = null;
        }
        this.n = null;
        this.m = null;
        this.h = null;
        super.onDestroy();
    }

    public String a() {
        return this.d;
    }

    public boolean b() {
        Log.i(this.d, "OnBackPressed()+");
        return false;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\d\k.java ==========

package net.fxgear.fitnshop.d;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.text.NumberFormat;
import net.fxgear.GlobalDefine;
import net.fxgear.a.a;
import net.fxgear.fitnshop.FitNShopMainActivity;
import net.fxgear.fitnshop.a.d;
import net.fxgear.fitnshop.c.a;
import net.fxgear.fitnshop.c.b;
import net.fxgear.fitnshop.c.e;
import net.fxgear.fitnshop.e;
import net.fxgear.fitnshop.e.c;
import net.fxgear.fitnshop.e.d;
import net.fxgear.fitnshop.e.f;
import net.fxgear.fitnshop.h;
import net.fxgear.fitnshop.i;

/* compiled from: SearchResultFragment */
public class k extends b implements View.OnClickListener {
    public static final String d = "k";
    /* access modifiers changed from: private */
    public int A = 0;
    /* access modifiers changed from: private */
    public Button B;
    private d C;
    private e.b D = new e.b() {
        public boolean a(c.a aVar, boolean z) {
            boolean z2;
            boolean z3;
            int i;
            String str = k.d;
            i.c(str, "OnClickClothesInWishList() brandID : " + aVar.i() + ", brand : " + aVar.j() + ", wishlist : " + z);
            String str2 = "w";
            if (k.this.getActivity() instanceof FitNShopMainActivity) {
                String e = ((FitNShopMainActivity) k.this.getActivity()).e();
                if (e.equals(GlobalDefine.GENDER_MAN_STRING)) {
                    str2 = m.d;
                } else if (e.equals("girl")) {
                    str2 = "kw";
                } else if (e.equals("boy")) {
                    str2 = "km";
                }
            }
            if (z) {
                f.a("SEARCH_WISH_ADD_CLI", str2 + aVar.a());
                net.fxgear.fitnshop.d a2 = net.fxgear.fitnshop.d.a(k.this.getActivity().getApplicationContext());
                int f = h.f1164b.f();
                if (f >= 0) {
                    a2.d();
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (f != 0) {
                    boolean z4 = aVar.k() == 1;
                    if (!h.f1164b.h()) {
                        if (aVar.c().equals(GlobalDefine.GENDER_WOMAN_STRING)) {
                            i = 1;
                        } else {
                            i = aVar.c().equals(GlobalDefine.GENDER_MAN_STRING) ? 2 : 3;
                        }
                        z3 = a2.a(String.valueOf(aVar.a()), aVar.l(), aVar.m(), z4, i, aVar.d() ? 1 : 2);
                    } else {
                        z3 = a2.a(String.valueOf(aVar.a()), aVar.l(), aVar.m(), z4);
                    }
                    if (!z3) {
                        Log.e(k.d, "ERROR :: add item fail.");
                        return false;
                    }
                }
            } else {
                f.a("SEARCH_WISH_REM_CLI", str2 + aVar.a());
                if (!net.fxgear.fitnshop.d.a(k.this.getActivity().getApplicationContext()).a(String.valueOf(aVar.a()))) {
                    Log.e(k.d, "ERROR :: remove item fail.");
                    return false;
                }
                z2 = false;
            }
            k.this.e();
            if (z2) {
                k.this.f();
            }
            return true;
        }

        public boolean a(c.a aVar) {
            boolean z;
            int i;
            String str = k.d;
            i.c(str, "OnClickClothesImage() product_code : " + aVar.a());
            if (!(k.this.getActivity() instanceof FitNShopMainActivity)) {
                return false;
            }
            FitNShopMainActivity fitNShopMainActivity = (FitNShopMainActivity) k.this.getActivity();
            String d = k.this.x;
            String str2 = "w";
            if (d.equals(GlobalDefine.GENDER_MAN_STRING)) {
                str2 = m.d;
            } else if (d.equals("girl")) {
                str2 = "kw";
            } else if (d.equals("boy")) {
                str2 = "km";
            }
            f.a("SEARCH_PRD_THUMBNAIL_CLI", str2 + aVar.a());
            String valueOf = String.valueOf(aVar.a());
            net.fxgear.fitnshop.d a2 = net.fxgear.fitnshop.d.a((Context) fitNShopMainActivity);
            if (!a2.b(valueOf)) {
                a2.d();
                boolean z2 = aVar.k() == 1;
                if (!h.f1164b.h()) {
                    if (aVar.c().equals(GlobalDefine.GENDER_WOMAN_STRING)) {
                        i = 1;
                    } else {
                        i = aVar.c().equals(GlobalDefine.GENDER_MAN_STRING) ? 2 : 3;
                    }
                    z = a2.a(valueOf, aVar.l(), aVar.m(), z2, i, aVar.d() ? 1 : 2);
                } else {
                    z = a2.a(valueOf, aVar.l(), aVar.m(), z2);
                }
                if (!z) {
                    Log.e(k.d, "ERROR :: add item fail.");
                    return false;
                }
            }
            k.this.e();
            fitNShopMainActivity.a("fitting", k.this.x, valueOf, k.d);
            return true;
        }

        public void b(c.a aVar) {
            String str = k.d;
            i.c(str, "OnClickClothesDescription() item_url : " + aVar.e());
            if (k.this.getActivity() instanceof FitNShopMainActivity) {
                FitNShopMainActivity fitNShopMainActivity = (FitNShopMainActivity) k.this.getActivity();
                String e = fitNShopMainActivity.e();
                String str2 = "w";
                if (e.equals(GlobalDefine.GENDER_MAN_STRING)) {
                    str2 = m.d;
                } else if (e.equals("girl")) {
                    str2 = "kw";
                } else if (e.equals("boy")) {
                    str2 = "km";
                }
                f.a("SEARCH_PRD_DETAIL_CLI", str2 + aVar.a());
                if (fitNShopMainActivity.a(aVar.e(), false)) {
                    f.a("SEARCH_PRD_DETAIL_CLI_STATUS", "SUC");
                } else {
                    f.a("SEARCH_PRD_DETAIL_CLI_STATUS", "NETERR");
                }
            }
        }

        public void a(d.a.b bVar) {
            if (bVar != null && (k.this.getActivity() instanceof FitNShopMainActivity)) {
                ((FitNShopMainActivity) k.this.getActivity()).a(bVar.c, false);
            }
        }

        public void a() {
            if (k.this.u == null) {
                a unused = k.this.u = new a(k.this.getActivity(), 0);
            }
            k.this.u.show();
        }

        public void a(int i) {
            String str;
            if (k.this.u != null) {
                if (k.this.u.isShowing()) {
                    k.this.u.dismiss();
                }
                a unused = k.this.u = null;
            }
            if (i > 9999) {
                str = NumberFormat.getInstance().format(9999) + "+";
            } else {
                str = NumberFormat.getInstance().format((long) i);
            }
            String str2 = k.this.v.toUpperCase() + " (" + str + ")";
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new ForegroundColorSpan(k.this.getResources().getColor(2130968681)), 0, k.this.v.length(), 0);
            spannableString.setSpan(new ForegroundColorSpan(k.this.getResources().getColor(2130968679)), k.this.v.length(), str2.length(), 0);
            k.this.q.setText(spannableString);
        }

        public void b(int i) {
            if (i != -2 && i != -1) {
                k.this.r.setVisibility(0);
                k.this.g.setVisibility(8);
                k.this.t.setVisibility(8);
            }
        }

        public void a(ListView listView, int i, int i2) {
            if (i2 < 0) {
                if (k.this.z > (-k.this.A)) {
                    if (k.this.z + i2 < (-k.this.A)) {
                        int unused = k.this.z = -k.this.A;
                    } else {
                        int unused2 = k.this.z = k.this.z + i2;
                    }
                } else if (k.this.z < (-k.this.A)) {
                    int unused3 = k.this.z = -k.this.A;
                }
            } else if (i2 > 0) {
                if (i <= 0) {
                    if (k.this.z < 0) {
                        if (k.this.z + i2 >= 0) {
                            int unused4 = k.this.z = 0;
                        } else {
                            int unused5 = k.this.z = k.this.z + i2;
                        }
                    } else if (k.this.z >= 0) {
                        int unused6 = k.this.z = 0;
                    }
                } else {
                    return;
                }
            }
            if (i == 0) {
                int top = listView.getChildAt(0).getTop();
                if (!((top != 0 && top != k.this.z) || k.this.B == null || k.this.B.getVisibility() == 8)) {
                    k.this.B.setVisibility(8);
                }
            } else if (!(k.this.B == null || k.this.B.getVisibility() == 0)) {
                k.this.B.setVisibility(0);
            }
            if (k.this.e != null) {
                k.this.e.setTranslationY((float) k.this.z);
            }
        }

        public void a(e eVar, int i) {
            if (k.this.t.equals(eVar) && i == 0) {
                k.this.a(k.this.t.i());
            }
        }
    };
    /* access modifiers changed from: private */
    public LinearLayout e;
    private RelativeLayout f;
    /* access modifiers changed from: private */
    public RelativeLayout g;
    private RelativeLayout h;
    private RelativeLayout i;
    private TextView j;
    private TextView k;
    private ImageView l;
    private ImageView m;
    private TextView n;
    private TextView o;
    private ImageView p;
    /* access modifiers changed from: private */
    public TextView q;
    /* access modifiers changed from: private */
    public LinearLayout r;
    private Button s;
    /* access modifiers changed from: private */
    public e t;
    /* access modifiers changed from: private */
    public a u;
    /* access modifiers changed from: private */
    public String v;
    private String[] w;
    /* access modifiers changed from: private */
    public String x;
    private int y;
    /* access modifiers changed from: private */
    public int z = 0;

    public k() {
    }

    public k(net.fxgear.fitnshop.a.d dVar, String str) {
        this.C = dVar;
        this.v = str;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i(d, "onCreate()+");
        this.y = 0;
        this.x = GlobalDefine.GENDER_WOMAN_STRING;
        if (getActivity() instanceof FitNShopMainActivity) {
            FitNShopMainActivity fitNShopMainActivity = (FitNShopMainActivity) getActivity();
            this.y = fitNShopMainActivity.g();
            this.x = fitNShopMainActivity.e();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LayoutInflater layoutInflater2 = layoutInflater;
        Log.i(d, "onCreateView()+");
        if (this.c == null) {
            this.c = layoutInflater2.inflate(2131296279, viewGroup, false);
            this.e = (LinearLayout) this.c.findViewById(2131165282);
            this.f = (RelativeLayout) this.c.findViewById(2131165276);
            this.g = (RelativeLayout) this.c.findViewById(2131165277);
            this.h = (RelativeLayout) this.c.findViewById(2131165278);
            this.i = (RelativeLayout) this.c.findViewById(2131165279);
            this.h.setOnClickListener(this);
            this.i.setOnClickListener(this);
            this.j = (TextView) layoutInflater2.inflate(2131296293, this.h).findViewById(2131165417);
            this.j.setText(b(this.x));
            this.w = getResources().getStringArray(2130771973);
            this.k = (TextView) layoutInflater2.inflate(2131296293, this.i).findViewById(2131165417);
            this.k.setText(this.w[this.y]);
            this.q = (TextView) this.c.findViewById(2131165418);
            this.q.setText(this.v);
            this.l = (ImageView) this.c.findViewById(2131165186);
            this.m = (ImageView) this.c.findViewById(2131165185);
            this.n = (TextView) this.c.findViewById(2131165188);
            this.o = (TextView) this.c.findViewById(a.e.action_title);
            this.p = (ImageView) this.c.findViewById(2131165187);
            this.c.findViewById(2131165193).setVisibility(8);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.o.setText(getResources().getString(2131361937));
            if (h.f1164b.d()) {
                this.l.setVisibility(8);
            } else {
                this.l.setVisibility(0);
            }
            this.r = (LinearLayout) this.c.findViewById(2131165342);
            this.s = (Button) this.c.findViewById(2131165231);
            this.s.setOnClickListener(this);
            Resources resources = getResources();
            this.A = resources.getDimensionPixelSize(2131034132) + resources.getDimensionPixelSize(2131034444) + resources.getDimensionPixelSize(2131034197);
            this.z = 0;
            if (h.f1164b.d()) {
                this.t = new e(getActivity(), this.A, this.C, h.c, -2, this.x, this.y);
            } else {
                this.t = new e(getActivity(), this.A, this.C, this.x, this.y);
            }
            this.t.a(this.D);
            ((RelativeLayout) this.c.findViewById(2131165281)).addView(this.t, -1, -1);
            ((Button) this.c.findViewById(2131165230)).setOnClickListener(this);
            this.B = (Button) this.c.findViewById(2131165235);
            this.B.setOnClickListener(this);
            this.B.setVisibility(8);
            e();
        }
        return this.c;
    }

    public void onHiddenChanged(boolean z2) {
        String str = d;
        Log.i(str, "onHiddenChanged()+ " + z2);
        if (!z2) {
            e();
            f();
        }
        super.onHiddenChanged(z2);
    }

    public Animator onCreateAnimator(int i2, boolean z2, int i3) {
        String str = d;
        Log.e(str, "onCreateAnimator()+ enter : " + z2 + ", state : " + this.f973a);
        if (this.f973a == 0) {
            return super.onCreateAnimator(i2, z2, i3);
        }
        final int i4 = this.f973a;
        Animator b2 = b(i4);
        this.f973a = 0;
        if (b2 != null) {
            b2.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    animator.removeListener(this);
                    if (i4 == 1) {
                        k.this.a(k.this.v);
                    }
                }
            });
        }
        return b2;
    }

    public void onResume() {
        super.onResume();
        Log.i(d, "onResume()+");
    }

    public void onPause() {
        Log.i(d, "onPause()+");
        super.onPause();
        if (this.t != null) {
            this.t.f();
            this.t.g();
        }
    }

    public void onDestroy() {
        if (this.u != null) {
            if (this.u.isShowing()) {
                this.u.dismiss();
            }
            this.u = null;
        }
        this.f = null;
        if (this.h != null) {
            this.h.setOnClickListener((View.OnClickListener) null);
            this.h = null;
        }
        if (this.i != null) {
            this.i.setOnClickListener((View.OnClickListener) null);
            this.i = null;
        }
        this.g = null;
        this.j = null;
        this.k = null;
        if (this.l != null) {
            this.l.setOnClickListener((View.OnClickListener) null);
            this.l = null;
        }
        if (this.m != null) {
            this.m.setOnClickListener((View.OnClickListener) null);
            this.m = null;
        }
        if (this.n != null) {
            this.n.setOnClickListener((View.OnClickListener) null);
            this.n = null;
        }
        if (this.p != null) {
            this.p.setOnClickListener((View.OnClickListener) null);
            this.p = null;
        }
        this.o = null;
        this.q = null;
        if (this.B != null) {
            this.B.setOnClickListener((View.OnClickListener) null);
            this.B = null;
        }
        if (this.s != null) {
            this.s.setOnClickListener((View.OnClickListener) null);
            this.s = null;
        }
        this.r = null;
        if (this.t != null) {
            this.t.j();
            this.t = null;
        }
        this.D = null;
        this.v = null;
        this.C = null;
        super.onDestroy();
    }

    public String a() {
        return d;
    }

    public boolean b() {
        this.f973a = 4;
        if (!(getActivity() instanceof FitNShopMainActivity)) {
            return false;
        }
        ((c) ((FitNShopMainActivity) getActivity()).c(c.d)).a(3);
        return false;
    }

    public void c() {
        f();
        e();
    }

    public void d() {
        this.r.setVisibility(0);
        this.g.setVisibility(8);
        this.t.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        if (h.d(getActivity().getApplicationContext())) {
            this.r.setVisibility(8);
            this.g.setVisibility(0);
            this.t.setVisibility(0);
            this.t.a(str, this.x, this.y);
            return;
        }
        this.r.setVisibility(0);
        this.g.setVisibility(8);
        this.t.setVisibility(8);
    }

    private void c(final int i2) {
        if (getActivity() instanceof FitNShopMainActivity) {
            final net.fxgear.fitnshop.c.e eVar = new net.fxgear.fitnshop.c.e(getActivity());
            if (i2 == 0) {
                String b2 = b(this.x);
                String[] stringArray = getResources().getStringArray(2130771972);
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    if (i4 >= stringArray.length) {
                        break;
                    } else if (stringArray[i4].equals(b2)) {
                        i3 = i4;
                        break;
                    } else {
                        i4++;
                    }
                }
                eVar.a(getActivity().getResources().getString(2131361893));
                eVar.a(stringArray, i3);
            } else {
                eVar.a(getActivity().getResources().getString(2131361836));
                eVar.a(this.w, this.y);
            }
            eVar.a((e.c) new e.c() {
                public void a(int i, String str) {
                    String str2 = "SEARCH_SEX_CLI";
                    if (i2 != 0) {
                        str2 = "SEARCH_SORT_CLI";
                    }
                    f.a(str2, "");
                    eVar.dismiss();
                    k.this.a(i2, i, str);
                }
            });
            eVar.show();
        }
    }

    /* access modifiers changed from: private */
    public void a(final int i2, final int i3, final String str) {
        if (getActivity() instanceof FitNShopMainActivity) {
            FitNShopMainActivity fitNShopMainActivity = (FitNShopMainActivity) getActivity();
            if (h.d(fitNShopMainActivity.getApplicationContext())) {
                if (this.r.getVisibility() != 8) {
                    this.r.setVisibility(8);
                    if (this.g.getVisibility() != 0) {
                        this.g.setVisibility(0);
                    }
                    if (this.t.getVisibility() != 0) {
                        this.t.setVisibility(0);
                    }
                }
                if (i2 == 0) {
                    this.x = fitNShopMainActivity.f(str);
                    this.j.setText(b(this.x));
                } else {
                    this.y = i3;
                    this.k.setText(str);
                }
                this.t.a();
                this.t.a(this.v, this.x, this.y);
                return;
            }
            a((Runnable) new Runnable() {
                public void run() {
                    k.this.a(i2, i3, str);
                }
            });
        }
    }

    private String b(String str) {
        return getActivity() instanceof FitNShopMainActivity ? ((FitNShopMainActivity) getActivity()).e(str) : getResources().getStringArray(2130771971)[0];
    }

    private void a(final Runnable runnable) {
        if (getActivity() instanceof FitNShopMainActivity) {
            ((FitNShopMainActivity) getActivity()).a((b.a) new b.a() {
                public void a(b bVar) {
                    bVar.dismiss();
                    if (runnable != null) {
                        runnable.run();
                    }
                }

                public void b(b bVar) {
                    bVar.dismiss();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        if (this.n != null) {
            h.a((Context) getActivity(), this.n);
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        if (this.t != null) {
            this.t.d();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case 2131165185:
            case 2131165188:
                if (getActivity() instanceof FitNShopMainActivity) {
                    ((FitNShopMainActivity) getActivity()).a("wishlist", this.x, (String) null, d);
                    f.a("FITBTN_CLI", "");
                    return;
                }
                return;
            case 2131165186:
                if (getActivity() instanceof FitNShopMainActivity) {
                    ((FitNShopMainActivity) getActivity()).b();
                    return;
                }
                return;
            case 2131165187:
                if (this.t != null) {
                    this.t.f();
                    if (!this.t.h()) {
                        this.f973a = 0;
                        if (getActivity() instanceof FitNShopMainActivity) {
                            ((FitNShopMainActivity) getActivity()).d();
                            f.a("SEARCH_BTN_CLI", "");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 2131165230:
                this.f973a = 4;
                if (getActivity() instanceof FitNShopMainActivity) {
                    FitNShopMainActivity fitNShopMainActivity = (FitNShopMainActivity) getActivity();
                    ((c) fitNShopMainActivity.c(c.d)).a(3);
                    fitNShopMainActivity.b(d);
                    return;
                }
                return;
            case 2131165231:
                a(this.v);
                return;
            case 2131165235:
                if (this.t != null) {
                    this.t.e();
                    g();
                    return;
                }
                return;
            case 2131165278:
                c(0);
                return;
            case 2131165279:
                c(1);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public void a(final ListView listView) {
        int i2;
        int i3;
        int i4;
        if (this.z != (-this.A) && this.z != 0) {
            int i5 = 0;
            if ((-this.z) < this.A / 2) {
                i4 = listView.getChildAt(0).getTop();
                i3 = this.z;
                i2 = 0;
            } else {
                i4 = listView.getChildAt(0).getTop();
                int i6 = -this.A;
                i3 = this.z;
                i2 = i6;
                i5 = -this.A;
            }
            a(i3, i5, 500, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int unused = k.this.z = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (k.this.e != null) {
                        k.this.e.setTranslationY((float) k.this.z);
                    }
                }
            }).start();
            final int firstVisiblePosition = listView.getFirstVisiblePosition();
            a(i4, i2, 500, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    listView.setSelectionFromTop(firstVisiblePosition, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }).start();
        }
    }

    private ValueAnimator a(int i2, int i3, int i4, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i2, i3});
        ofInt.addUpdateListener(animatorUpdateListener);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration((long) i4);
        return ofInt;
    }

    private void g() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.z, 0});
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(250);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = k.this.z = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (k.this.e != null) {
                    k.this.e.setTranslationY((float) k.this.z);
                }
            }
        });
        ofInt.start();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\d\l.java ==========

package net.fxgear.fitnshop.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Iterator;
import net.fxgear.fitnshop.FitNShopMainActivity;
import net.fxgear.fitnshop.WebActivity;
import net.fxgear.fitnshop.c.b;
import net.fxgear.fitnshop.f;
import net.fxgear.fitnshop.h;
import net.fxgear.fitnshop.i;

@SuppressLint({"SetJavaScriptEnabled"})
/* compiled from: WebViewFragment */
public class l extends b implements View.OnClickListener {
    /* access modifiers changed from: private */
    public final String d = l.class.getSimpleName();
    /* access modifiers changed from: private */
    public String e;
    private boolean f;
    /* access modifiers changed from: private */
    public WebView g;
    /* access modifiers changed from: private */
    public f h;
    /* access modifiers changed from: private */
    public ArrayList<WebView> i;
    private ImageView j;
    private ImageView k;
    /* access modifiers changed from: private */
    public ImageView l;
    private ImageView m;
    private WebChromeClient n = new WebChromeClient() {
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            Log.d(l.this.d, "mWebChromeClient onCreateWindow()+");
            if (l.this.g == null) {
                Log.e(l.this.d, "mWebView is null");
                return false;
            }
            WebView webView2 = new WebView(l.this.g.getContext());
            webView2.setWebViewClient(l.this.h);
            webView2.setWebChromeClient(this);
            webView2.getSettings().setJavaScriptEnabled(true);
            webView2.setLayoutParams(l.this.g.getLayoutParams());
            webView2.setY((float) l.this.g.getScrollY());
            l.this.i.add(webView2);
            int size = l.this.i.size() - 1;
            String a2 = l.this.d;
            Log.d(a2, "latestPopupWebViewIndex: " + size);
            l.this.g.addView((View) l.this.i.get(size));
            String a3 = l.this.d;
            Log.e(a3, "resultMsg.obj: " + message.obj);
            ((WebView.WebViewTransport) message.obj).setWebView((WebView) l.this.i.get(size));
            message.sendToTarget();
            return true;
        }

        public void onCloseWindow(WebView webView) {
            Log.d(l.this.d, "mWebChromeClient onCloseWindow()+");
            super.onCloseWindow(webView);
            if (l.this.g == null) {
                Log.e(l.this.d, "mWebView is null");
            } else if (l.this.i != null) {
                for (int i = 0; i < l.this.i.size(); i++) {
                    WebView webView2 = (WebView) l.this.i.get(i);
                    if (webView2 != null && webView2.equals(webView)) {
                        String a2 = l.this.d;
                        Log.d(a2, "onCloseWindow(), remove popupWebView index: " + i);
                        l.this.g.removeView(webView2);
                        l.this.i.remove(webView2);
                        l.this.f();
                    }
                }
            }
        }
    };
    private f.a o = new f.a() {
        public void f(String str) {
        }

        public void a(int i, String str, String str2) {
            String a2 = l.this.d;
            Log.e(a2, "OnReceivedError::errorCode : " + i + ", description : " + str + ", failingUrl : " + str2);
        }

        public void a(String str) {
            if (l.this.g == null) {
                Log.e(l.this.d, "mWebView is null");
                return;
            }
            l.this.l.setEnabled(false);
            l.this.f();
        }

        public void b(String str) {
            if (l.this.g == null) {
                Log.e(l.this.d, "ERROR :: webview is null.");
                return;
            }
            l.this.l.setEnabled(true);
            l.this.f();
        }

        public void a(boolean z, String str) {
            if (!z) {
                l.this.b(str);
            }
        }

        public void c(String str) {
            String a2 = l.this.d;
            i.c(a2, "[WARNING - not use] OnAddFittingWishlist : " + str);
        }

        public void d(String str) {
            String a2 = l.this.d;
            i.c(a2, "[WARNING - not use] Fitting : " + str);
        }

        public void e(String str) {
            Intent intent;
            String a2 = l.this.d;
            i.a(a2, "OnStartActivityWithIntent()+, " + str);
            if (str.startsWith("tel:")) {
                intent = new Intent("android.intent.action.DIAL", Uri.parse(str));
            } else if (str.startsWith("mailto:") || str.startsWith("smsto:")) {
                intent = new Intent("android.intent.action.SENDTO", Uri.parse(str));
            } else {
                intent = null;
            }
            if (intent != null) {
                l.this.startActivity(intent);
            }
        }
    };

    public void c() {
    }

    public void d() {
    }

    public l() {
    }

    public l(String str, boolean z) {
        this.e = str;
        this.f = z;
        this.i = new ArrayList<>();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i(this.d, "onCreate()+");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Log.i(this.d, "onCreateView()+");
        if (this.c == null) {
            this.c = layoutInflater.inflate(2131296280, viewGroup, false);
            this.g = (WebView) this.c.findViewById(2131165432);
            this.j = (ImageView) this.c.findViewById(2131165378);
            this.k = (ImageView) this.c.findViewById(2131165375);
            this.l = (ImageView) this.c.findViewById(2131165379);
            this.m = (ImageView) this.c.findViewById(2131165376);
            this.j.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.h = new f(this.f974b);
            this.h.a(this.o);
            this.g.setWebViewClient(this.h);
            this.g.setWebChromeClient(this.n);
            WebSettings settings = this.g.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
            settings.setDomStorageEnabled(true);
            settings.setSupportMultipleWindows(true);
            a(this.e);
        }
        return this.c;
    }

    private void a(String str) {
        if (str != null) {
            e();
            this.e = str;
            this.g.loadUrl(str);
        }
    }

    private void e() {
        Log.d(this.d, "ClearWebHistory()+");
        if (this.i != null) {
            Log.d(this.d, "BuyItemOnWebView(), remove all popupWebView");
            Iterator<WebView> it = this.i.iterator();
            while (it.hasNext()) {
                this.g.removeView(it.next());
            }
            this.i.clear();
            f();
        }
    }

    /* access modifiers changed from: private */
    public void b(final String str) {
        if (getActivity() instanceof FitNShopMainActivity) {
            ((FitNShopMainActivity) getActivity()).a((b.a) new b.a() {
                public void a(b bVar) {
                    bVar.dismiss();
                    if (!h.d(l.this.getActivity().getApplicationContext())) {
                        l.this.b(str);
                    } else if (l.this.g.getUrl() == null) {
                        Log.e(l.this.d, "url is wrong");
                        l.this.g.loadUrl(l.this.e);
                    } else if (l.this.i == null || l.this.i.size() <= 0) {
                        l.this.g.loadUrl(str);
                    } else {
                        int size = l.this.i.size() - 1;
                        Log.d(l.this.d, "onClick()+ navi_btn_refresh(reload), latestPopupWebViewIndex: " + size);
                        ((WebView) l.this.i.get(size)).loadUrl(str);
                    }
                }

                public void b(b bVar) {
                    bVar.dismiss();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        if (this.g == null) {
            return;
        }
        if (this.i == null || this.i.size() <= 0) {
            if (this.g.canGoBack()) {
                this.k.setEnabled(true);
            } else {
                this.k.setEnabled(false);
            }
            if (this.g.canGoForward()) {
                this.j.setEnabled(true);
            } else {
                this.j.setEnabled(false);
            }
        } else {
            this.k.setEnabled(true);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case 2131165375:
                if (h.d(this.f974b) && this.g != null) {
                    if (this.i != null && this.i.size() > 0) {
                        int size = this.i.size() - 1;
                        WebView webView = this.i.get(size);
                        if (webView == null) {
                            return;
                        }
                        if (webView.canGoBack()) {
                            Log.d(this.d, "onClick()+ navi_btn_go_back, latestPopupWebView goBack, latestPopupWebViewIndex: " + size);
                            webView.goBack();
                            return;
                        }
                        Log.d(this.d, "onClick()+ navi_btn_go_back, remove latestPopupWebView, latestPopupWebViewIndex: " + size);
                        this.g.removeView(webView);
                        this.i.remove(webView);
                        f();
                        return;
                    } else if (this.g.canGoBack()) {
                        this.g.goBack();
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case 2131165376:
                Activity activity = getActivity();
                if (activity instanceof FitNShopMainActivity) {
                    FitNShopMainActivity fitNShopMainActivity = (FitNShopMainActivity) activity;
                    fitNShopMainActivity.b(this.d);
                    if (this.f) {
                        fitNShopMainActivity.a("previous_state", (String) null, this.d);
                        return;
                    }
                    return;
                } else if (activity instanceof WebActivity) {
                    activity.finish();
                    return;
                } else {
                    return;
                }
            case 2131165378:
                if (h.d(this.f974b) && this.g != null) {
                    if (this.i != null && this.i.size() > 0) {
                        int size2 = this.i.size() - 1;
                        WebView webView2 = this.i.get(size2);
                        if (webView2 != null && webView2.canGoForward()) {
                            Log.d(this.d, "onClick()+ navi_btn_go_back, latestPopupWebView goBack, latestPopupWebViewIndex: " + size2);
                            webView2.goForward();
                            return;
                        }
                        return;
                    } else if (this.g.canGoForward()) {
                        this.g.goForward();
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case 2131165379:
                if (h.d(this.f974b) && this.g != null) {
                    if (this.g.getUrl() == null) {
                        Log.e(this.d, "url is wrong");
                        this.g.loadUrl(this.e);
                        return;
                    } else if (this.i == null || this.i.size() <= 0) {
                        this.g.reload();
                        return;
                    } else {
                        int size3 = this.i.size() - 1;
                        Log.d(this.d, "onClick()+ navi_btn_refresh(reload), latestPopupWebViewIndex: " + size3);
                        this.i.get(size3).reload();
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void onResume() {
        super.onResume();
        Log.i(this.d, "onResume()+");
    }

    public void onPause() {
        super.onPause();
        Log.i(this.d, "onPause()+");
    }

    public void onDestroy() {
        Log.i(this.d, "onDestroy()+");
        if (this.g != null) {
            if (this.i != null) {
                Iterator<WebView> it = this.i.iterator();
                while (it.hasNext()) {
                    WebView next = it.next();
                    next.setWebViewClient((WebViewClient) null);
                    next.setWebChromeClient((WebChromeClient) null);
                    this.g.removeView(next);
                }
            } else {
                this.g.removeAllViews();
            }
            this.g.setWebViewClient((WebViewClient) null);
            this.g.setWebChromeClient((WebChromeClient) null);
            if (this.h != null) {
                this.h.a((f.a) null);
                this.o = null;
                this.h = null;
            }
            this.n = null;
            this.g = null;
        }
        if (this.i != null) {
            this.i.clear();
            this.i = null;
        }
        if (this.j != null) {
            this.j.setOnClickListener((View.OnClickListener) null);
            this.j = null;
        }
        if (this.k != null) {
            this.k.setOnClickListener((View.OnClickListener) null);
            this.k = null;
        }
        if (this.l != null) {
            this.l.setOnClickListener((View.OnClickListener) null);
            this.l = null;
        }
        if (this.m != null) {
            this.m.setOnClickListener((View.OnClickListener) null);
            this.m = null;
        }
        this.e = null;
        super.onDestroy();
    }

    public String a() {
        return this.d;
    }

    public boolean b() {
        Log.i(this.d, "OnBackPressed()+");
        if (this.i != null && this.i.size() > 0) {
            int size = this.i.size() - 1;
            WebView webView = this.i.get(size);
            if (webView == null) {
                return false;
            }
            if (webView.canGoBack()) {
                String str = this.d;
                Log.d(str, "onClick()+ navi_btn_go_back, latestPopupWebView goBack, latestPopupWebViewIndex: " + size);
                webView.goBack();
            } else {
                String str2 = this.d;
                Log.d(str2, "onClick()+ navi_btn_go_back, remove latestPopupWebView, latestPopupWebViewIndex: " + size);
                this.g.removeView(webView);
                this.i.remove(webView);
                f();
            }
            return true;
        } else if (!this.g.canGoBack()) {
            return false;
        } else {
            this.g.goBack();
            return true;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\d\m.java ==========

package net.fxgear.fitnshop.d;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import net.fxgear.GlobalDefine;
import net.fxgear.a.a;
import net.fxgear.fitnshop.ApplicationClass;
import net.fxgear.fitnshop.FitNShopMainActivity;
import net.fxgear.fitnshop.c.b;
import net.fxgear.fitnshop.d;
import net.fxgear.fitnshop.e.b;
import net.fxgear.fitnshop.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"SetJavaScriptEnabled"})
/* compiled from: WebViewInterfaceFragment */
public class m extends b implements View.OnClickListener {
    public static final String d = "m";
    private final String A;
    private final String B;
    private final String C;
    private final String D;
    private final String E;
    private final int F;
    private final int G;
    private final String H;
    private Handler I;
    private String J;
    /* access modifiers changed from: private */
    public WebView K;
    /* access modifiers changed from: private */
    public a L;
    /* access modifiers changed from: private */
    public ArrayList<WebView> M;
    private boolean N;
    private Button O;
    private LinearLayout P;
    private Button Q;
    private ImageView R;
    private ImageView S;
    /* access modifiers changed from: private */
    public ImageView T;
    private ImageView U;
    private WebChromeClient V;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private final String q;
    private final String r;
    private final String s;
    private final String t;
    private final String u;
    private final String v;
    private final String w;
    private final String x;
    private final String y;
    private final String z;

    public m() {
        this.e = "app_ver=%d";
        this.f = "";
        this.g = "%s/tmpl/product_first_categroy.html?%s";
        this.h = "mode=app";
        this.i = "javascript:%s(%s)";
        this.j = "onFinishedGetWishListId";
        this.k = "onFinishedSetWishItem";
        this.l = "requestAllCategory";
        this.m = "dispatch_no";
        this.n = "regist";
        this.o = "doFitting";
        this.p = "data";
        this.q = "id";
        this.r = "rep_td_id";
        this.s = "category_id";
        this.t = "item_sex";
        this.u = "item_kids";
        this.v = "sample";
        this.w = "ids";
        this.x = "result";
        this.y = "category_list";
        this.z = "category_id";
        this.A = "category_name";
        this.B = GlobalDefine.GENDER_WOMAN_STRING;
        this.C = GlobalDefine.GENDER_MAN_STRING;
        this.D = "woman_kids";
        this.E = "man_kids";
        this.F = 1;
        this.G = 0;
        this.H = "FNSMall";
        this.I = new Handler();
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = false;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.V = new WebChromeClient() {
            public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
                Log.d(m.d, "mWebChromeClient onCreateWindow()+");
                if (m.this.K == null) {
                    Log.e(m.d, "mWebView is null");
                    return false;
                }
                WebView webView2 = new WebView(m.this.K.getContext());
                webView2.setWebViewClient(m.this.L);
                webView2.setWebChromeClient(this);
                webView2.getSettings().setJavaScriptEnabled(true);
                webView2.setLayoutParams(m.this.K.getLayoutParams());
                webView2.setY((float) m.this.K.getScrollY());
                m.this.M.add(webView2);
                int size = m.this.M.size() - 1;
                String str = m.d;
                Log.d(str, "latestPopupWebViewIndex: " + size);
                m.this.K.addView((View) m.this.M.get(size));
                String str2 = m.d;
                Log.e(str2, "resultMsg.obj: " + message.obj);
                ((WebView.WebViewTransport) message.obj).setWebView((WebView) m.this.M.get(size));
                message.sendToTarget();
                return true;
            }

            public void onCloseWindow(WebView webView) {
                Log.d(m.d, "mWebChromeClient onCloseWindow()+");
                super.onCloseWindow(webView);
                if (m.this.K == null) {
                    Log.e(m.d, "mWebView is null");
                } else if (m.this.M != null) {
                    for (int i = 0; i < m.this.M.size(); i++) {
                        WebView webView2 = (WebView) m.this.M.get(i);
                        if (webView2 != null && webView2.equals(webView)) {
                            String str = m.d;
                            Log.d(str, "onCloseWindow(), remove popupWebView index: " + i);
                            m.this.K.removeView(webView2);
                            m.this.M.remove(webView2);
                            m.this.h();
                        }
                    }
                }
            }
        };
        this.M = new ArrayList<>();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.c == null) {
            this.c = layoutInflater.inflate(2131296281, viewGroup, false);
            this.K = (WebView) this.c.findViewById(2131165324);
            this.L = new a();
            this.K.setWebViewClient(this.L);
            this.K.setWebChromeClient(this.V);
            this.K.addJavascriptInterface(this, "FNSMall");
            WebSettings settings = this.K.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
            settings.setDomStorageEnabled(true);
            settings.setSupportMultipleWindows(true);
            this.P = (LinearLayout) this.c.findViewById(2131165342);
            this.Q = (Button) this.c.findViewById(2131165231);
            this.Q.setOnClickListener(this);
            this.R = (ImageView) this.c.findViewById(2131165378);
            this.S = (ImageView) this.c.findViewById(2131165375);
            this.T = (ImageView) this.c.findViewById(2131165379);
            this.U = (ImageView) this.c.findViewById(2131165377);
            this.R.setOnClickListener(this);
            this.S.setOnClickListener(this);
            this.T.setOnClickListener(this);
            this.U.setOnClickListener(this);
            this.J = f();
            if (h.d(getActivity().getApplicationContext())) {
                a(this.J);
            } else {
                a(true);
            }
            this.O = (Button) this.c.findViewById(2131165412);
            this.O.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    m.this.j();
                }
            });
            this.O.setVisibility(8);
        }
        return this.c;
    }

    public void onDestroy() {
        e();
        super.onDestroy();
    }

    public void e() {
        if (this.I != null) {
            this.I.removeCallbacksAndMessages((Object) null);
            this.I = null;
        }
        if (this.K != null) {
            if (this.M != null) {
                Iterator<WebView> it = this.M.iterator();
                while (it.hasNext()) {
                    WebView next = it.next();
                    next.setWebViewClient((WebViewClient) null);
                    next.setWebChromeClient((WebChromeClient) null);
                    this.K.removeView(next);
                }
            } else {
                this.K.removeAllViews();
            }
            this.K.setWebViewClient((WebViewClient) null);
            this.L = null;
            this.K.setWebChromeClient((WebChromeClient) null);
            this.V = null;
            this.K.removeJavascriptInterface("FNSMall");
            this.K = null;
        }
        if (this.M != null) {
            this.M.clear();
            this.M = null;
        }
        if (this.R != null) {
            this.R.setOnClickListener((View.OnClickListener) null);
            this.R = null;
        }
        if (this.S != null) {
            this.S.setOnClickListener((View.OnClickListener) null);
            this.S = null;
        }
        if (this.T != null) {
            this.T.setOnClickListener((View.OnClickListener) null);
            this.T = null;
        }
        if (this.U != null) {
            this.U.setOnClickListener((View.OnClickListener) null);
            this.U = null;
        }
    }

    public String a() {
        return d;
    }

    public boolean b() {
        if (this.M != null && this.M.size() > 0) {
            int size = this.M.size() - 1;
            WebView webView = this.M.get(size);
            if (webView == null) {
                return false;
            }
            if (webView.canGoBack()) {
                String str = d;
                Log.d(str, "OnBackPressed(), latestPopupWebView goBack, latestPopupWebViewIndex: " + size);
                webView.goBack();
            } else {
                String str2 = d;
                Log.d(str2, "OnBackPressed(), remove latestPopupWebView, latestPopupWebViewIndex: " + size);
                this.K.removeView(webView);
                this.M.remove(webView);
                h();
            }
            return true;
        } else if (!this.K.canGoBack()) {
            return false;
        } else {
            this.K.goBack();
            return true;
        }
    }

    public void c() {
        if (this.N && this.K != null) {
            i();
        }
    }

    public void d() {
        a(true);
    }

    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id != 2131165231) {
                if (id != 2131165375) {
                    switch (id) {
                        case 2131165377:
                            this.J = f();
                            if (h.d(getActivity().getApplicationContext())) {
                                a(this.J);
                                return;
                            } else {
                                a(true);
                                return;
                            }
                        case 2131165378:
                            if (h.d(this.f974b) && this.K != null) {
                                if (this.M != null && this.M.size() > 0) {
                                    int size = this.M.size() - 1;
                                    WebView webView = this.M.get(size);
                                    if (webView != null && webView.canGoForward()) {
                                        String str = d;
                                        Log.d(str, "onClick()+ navi_btn_go_back, latestPopupWebView goBack, latestPopupWebViewIndex: " + size);
                                        webView.goForward();
                                        return;
                                    }
                                    return;
                                } else if (this.K.canGoForward()) {
                                    this.K.goForward();
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        case 2131165379:
                            if (h.d(this.f974b) && this.K != null) {
                                if (this.K.getUrl() == null) {
                                    Log.e(d, "url is wrong");
                                    this.K.loadUrl(this.J);
                                    return;
                                } else if (this.M == null || this.M.size() <= 0) {
                                    this.K.reload();
                                    return;
                                } else {
                                    int size2 = this.M.size() - 1;
                                    String str2 = d;
                                    Log.d(str2, "onClick()+ navi_btn_refresh(reload), latestPopupWebViewIndex: " + size2);
                                    this.M.get(size2).reload();
                                    return;
                                }
                            } else {
                                return;
                            }
                        default:
                            return;
                    }
                } else if (h.d(this.f974b) && this.K != null) {
                    if (this.M != null && this.M.size() > 0) {
                        int size3 = this.M.size() - 1;
                        WebView webView2 = this.M.get(size3);
                        if (webView2 == null) {
                            return;
                        }
                        if (webView2.canGoBack()) {
                            String str3 = d;
                            Log.d(str3, "onClick()+ navi_btn_go_back, latestPopupWebView goBack, latestPopupWebViewIndex: " + size3);
                            webView2.goBack();
                            return;
                        }
                        String str4 = d;
                        Log.d(str4, "onClick()+ navi_btn_go_back, remove latestPopupWebView, latestPopupWebViewIndex: " + size3);
                        this.K.removeView(webView2);
                        this.M.remove(webView2);
                        h();
                    } else if (this.K.canGoBack()) {
                        this.K.goBack();
                    }
                }
            } else if (h.d(getActivity()) && this.K != null) {
                a(false);
                if (this.K.getUrl() == null) {
                    a(this.J);
                } else if (this.M != null && this.M.size() > 0) {
                    int size4 = this.M.size() - 1;
                    String str5 = d;
                    Log.d(str5, "onClick()+ btn_disconnect_refresh, latestPopupWebViewIndex: " + size4);
                    this.M.get(size4).reload();
                } else if (this.K != null) {
                    this.K.reload();
                }
            }
        }
    }

    private String f() {
        int i2;
        try {
            i2 = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(h.f1164b.z);
        sb.append("?mode=app");
        sb.append("&" + String.format("app_ver=%d", new Object[]{Integer.valueOf(i2)}));
        return sb.toString();
    }

    public void a(String str) {
        if (this.K != null && str != null) {
            this.J = str;
            g();
            this.K.loadUrl(str);
        }
    }

    private void g() {
        Log.d(d, "ClearPopupWebView()+");
        if (this.M != null) {
            Iterator<WebView> it = this.M.iterator();
            while (it.hasNext()) {
                this.K.removeView(it.next());
            }
            this.M.clear();
            h();
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        if (this.K == null) {
            return;
        }
        if (this.M == null || this.M.size() <= 0) {
            if (this.K.canGoBack()) {
                this.S.setEnabled(true);
            } else {
                this.S.setEnabled(false);
            }
            if (this.K.canGoForward()) {
                this.R.setEnabled(true);
            } else {
                this.R.setEnabled(false);
            }
        } else {
            this.S.setEnabled(true);
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        if (z2) {
            if (!(this.K == null || this.K.getVisibility() == 8)) {
                this.K.setVisibility(8);
            }
            if (this.P != null && this.P.getVisibility() != 0) {
                this.P.setVisibility(0);
                return;
            }
            return;
        }
        if (!(this.K == null || this.K.getVisibility() == 0)) {
            this.K.setVisibility(0);
        }
        if (this.P != null && this.P.getVisibility() != 8) {
            this.P.setVisibility(8);
        }
    }

    /* compiled from: WebViewInterfaceFragment */
    private class a extends WebViewClient {
        private a() {
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (!h.d(m.this.getActivity())) {
                m.this.a(true);
            }
            super.onPageStarted(webView, str, bitmap);
            if (m.this.K == null) {
                Log.e(m.d, "mWebView is null");
                return;
            }
            m.this.T.setEnabled(false);
            m.this.h();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (m.this.K == null) {
                Log.e(m.d, "ERROR :: webview is null.");
                return;
            }
            m.this.T.setEnabled(true);
            m.this.h();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!h.d(m.this.getActivity())) {
                m.this.a(true);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    @JavascriptInterface
    public void onLoadAppview(String str) {
        String str2 = d;
        Log.d(str2, "onLoadAppview() " + str);
        this.N = true;
        if (((ApplicationClass) getActivity().getApplicationContext()).a() == null && this.I != null) {
            this.I.post(new Runnable() {
                public void run() {
                    if (m.this.K != null) {
                        String format = String.format("javascript:%s(%s)", new Object[]{"requestAllCategory", ""});
                        String str = m.d;
                        Log.i(str, "onLoadAppview send json : " + format);
                        m.this.K.loadUrl(format);
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void onUnloadAppview(String str) {
        String str2 = d;
        Log.d(str2, "onUnloadAppview() " + str);
        this.N = false;
    }

    @JavascriptInterface
    public void getWishListId(String str) {
        String str2 = d;
        Log.d(str2, "getWishListId() " + str);
        i();
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d0 A[Catch:{ JSONException -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0100 A[Catch:{ JSONException -> 0x022e }] */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setWishItem(java.lang.String r23) {
        /*
            r22 = this;
            r7 = r22
            r0 = r23
            java.lang.String r1 = d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "setWishItem()+ "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r1, r2)
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x022e }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x022e }
            java.lang.String r0 = "dispatch_no"
            int r2 = r1.getInt(r0)     // Catch:{ JSONException -> 0x022e }
            java.lang.String r0 = "regist"
            int r3 = r1.getInt(r0)     // Catch:{ JSONException -> 0x022e }
            java.lang.String r0 = "doFitting"
            int r4 = r1.getInt(r0)     // Catch:{ JSONException -> 0x022e }
            java.lang.String r0 = "data"
            boolean r0 = r1.has(r0)     // Catch:{ JSONException -> 0x022e }
            r5 = 0
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = "data"
            org.json.JSONObject r0 = r1.getJSONObject(r0)     // Catch:{ JSONException -> 0x022e }
            goto L_0x0042
        L_0x0041:
            r0 = r5
        L_0x0042:
            java.lang.String r1 = "woman"
            r6 = -1
            r8 = 0
            r9 = 1
            if (r0 == 0) goto L_0x00bb
            java.lang.String r10 = "id"
            boolean r10 = r0.has(r10)     // Catch:{ Exception -> 0x00b1 }
            if (r10 == 0) goto L_0x0058
            java.lang.String r10 = "id"
            int r10 = r0.getInt(r10)     // Catch:{ Exception -> 0x00b1 }
            goto L_0x0059
        L_0x0058:
            r10 = -1
        L_0x0059:
            java.lang.String r11 = "rep_td_id"
            boolean r11 = r0.has(r11)     // Catch:{ Exception -> 0x00af }
            if (r11 == 0) goto L_0x0068
            java.lang.String r11 = "rep_td_id"
            int r11 = r0.getInt(r11)     // Catch:{ Exception -> 0x00af }
            goto L_0x0069
        L_0x0068:
            r11 = -1
        L_0x0069:
            java.lang.String r12 = "category_id"
            boolean r12 = r0.has(r12)     // Catch:{ Exception -> 0x00ad }
            if (r12 == 0) goto L_0x0078
            java.lang.String r12 = "category_id"
            int r12 = r0.getInt(r12)     // Catch:{ Exception -> 0x00ad }
            goto L_0x0079
        L_0x0078:
            r12 = -1
        L_0x0079:
            java.lang.String r13 = "item_sex"
            boolean r13 = r0.has(r13)     // Catch:{ Exception -> 0x00ab }
            if (r13 == 0) goto L_0x0088
            java.lang.String r13 = "item_sex"
            java.lang.String r13 = r0.getString(r13)     // Catch:{ Exception -> 0x00ab }
            r5 = r13
        L_0x0088:
            java.lang.String r13 = "item_kids"
            boolean r13 = r0.has(r13)     // Catch:{ Exception -> 0x00ab }
            if (r13 == 0) goto L_0x0097
            java.lang.String r13 = "item_kids"
            int r13 = r0.getInt(r13)     // Catch:{ Exception -> 0x00ab }
            goto L_0x0098
        L_0x0097:
            r13 = -1
        L_0x0098:
            java.lang.String r14 = "sample"
            boolean r14 = r0.has(r14)     // Catch:{ Exception -> 0x00a9 }
            if (r14 == 0) goto L_0x00a7
            java.lang.String r14 = "sample"
            int r0 = r0.getInt(r14)     // Catch:{ Exception -> 0x00a9 }
            r6 = r0
        L_0x00a7:
            r0 = 0
            goto L_0x00c0
        L_0x00a9:
            r0 = move-exception
            goto L_0x00b6
        L_0x00ab:
            r0 = move-exception
            goto L_0x00b5
        L_0x00ad:
            r0 = move-exception
            goto L_0x00b4
        L_0x00af:
            r0 = move-exception
            goto L_0x00b3
        L_0x00b1:
            r0 = move-exception
            r10 = -1
        L_0x00b3:
            r11 = -1
        L_0x00b4:
            r12 = -1
        L_0x00b5:
            r13 = -1
        L_0x00b6:
            r0.printStackTrace()     // Catch:{ JSONException -> 0x022e }
            r0 = 1
            goto L_0x00c0
        L_0x00bb:
            r0 = 1
            r10 = -1
            r11 = -1
            r12 = -1
            r13 = -1
        L_0x00c0:
            if (r10 < 0) goto L_0x00cc
            if (r11 < 0) goto L_0x00cc
            if (r12 < 0) goto L_0x00cc
            if (r5 == 0) goto L_0x00cc
            if (r13 < 0) goto L_0x00cc
            if (r6 >= 0) goto L_0x00cd
        L_0x00cc:
            r0 = 1
        L_0x00cd:
            r14 = 2
            if (r0 == 0) goto L_0x0100
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x022e }
            r0.<init>()     // Catch:{ JSONException -> 0x022e }
            java.lang.String r1 = "dispatch_no"
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x022e }
            java.lang.String r1 = "result"
            r0.put(r1, r8)     // Catch:{ JSONException -> 0x022e }
            java.lang.String r1 = "javascript:%s(%s)"
            java.lang.Object[] r2 = new java.lang.Object[r14]     // Catch:{ JSONException -> 0x022e }
            java.lang.String r3 = "onFinishedSetWishItem"
            r2[r8] = r3     // Catch:{ JSONException -> 0x022e }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x022e }
            r2[r9] = r0     // Catch:{ JSONException -> 0x022e }
            java.lang.String r0 = java.lang.String.format(r1, r2)     // Catch:{ JSONException -> 0x022e }
            android.os.Handler r1 = r7.I     // Catch:{ JSONException -> 0x022e }
            if (r1 == 0) goto L_0x00ff
            android.os.Handler r1 = r7.I     // Catch:{ JSONException -> 0x022e }
            net.fxgear.fitnshop.d.m$4 r2 = new net.fxgear.fitnshop.d.m$4     // Catch:{ JSONException -> 0x022e }
            r2.<init>(r0)     // Catch:{ JSONException -> 0x022e }
            r1.post(r2)     // Catch:{ JSONException -> 0x022e }
        L_0x00ff:
            return
        L_0x0100:
            if (r3 != r9) goto L_0x01cd
            android.app.Activity r0 = r22.getActivity()     // Catch:{ JSONException -> 0x022e }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ JSONException -> 0x022e }
            net.fxgear.fitnshop.d r15 = net.fxgear.fitnshop.d.a((android.content.Context) r0)     // Catch:{ JSONException -> 0x022e }
            net.fxgear.fitnshop.g r0 = net.fxgear.fitnshop.h.f1164b     // Catch:{ JSONException -> 0x022e }
            int r0 = r0.f()     // Catch:{ JSONException -> 0x022e }
            java.lang.String r3 = java.lang.String.valueOf(r10)     // Catch:{ JSONException -> 0x022e }
            boolean r3 = r15.b(r3)     // Catch:{ JSONException -> 0x022e }
            if (r3 == 0) goto L_0x0137
            java.lang.String r0 = d     // Catch:{ JSONException -> 0x022e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x022e }
            r3.<init>()     // Catch:{ JSONException -> 0x022e }
            java.lang.String r5 = "Already contain clothes id "
            r3.append(r5)     // Catch:{ JSONException -> 0x022e }
            r3.append(r10)     // Catch:{ JSONException -> 0x022e }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x022e }
            android.util.Log.i(r0, r3)     // Catch:{ JSONException -> 0x022e }
            r0 = 1
            goto L_0x01ea
        L_0x0137:
            if (r0 < 0) goto L_0x013c
            r15.d()     // Catch:{ JSONException -> 0x022e }
        L_0x013c:
            if (r0 == 0) goto L_0x01cb
            if (r6 != r9) goto L_0x0142
            r0 = 1
            goto L_0x0143
        L_0x0142:
            r0 = 0
        L_0x0143:
            net.fxgear.fitnshop.g r3 = net.fxgear.fitnshop.h.f1164b     // Catch:{ JSONException -> 0x022e }
            boolean r3 = r3.h()     // Catch:{ JSONException -> 0x022e }
            if (r3 != 0) goto L_0x01a9
            java.lang.String r3 = "woman"
            boolean r3 = r5.equals(r3)     // Catch:{ JSONException -> 0x022e }
            if (r3 == 0) goto L_0x0156
            r20 = 1
            goto L_0x0164
        L_0x0156:
            java.lang.String r3 = "man"
            boolean r3 = r5.equals(r3)     // Catch:{ JSONException -> 0x022e }
            if (r3 == 0) goto L_0x0161
            r20 = 2
            goto L_0x0164
        L_0x0161:
            r3 = 3
            r20 = 3
        L_0x0164:
            if (r13 != r9) goto L_0x0168
            r3 = 1
            goto L_0x0169
        L_0x0168:
            r3 = 2
        L_0x0169:
            if (r3 != r14) goto L_0x0179
            java.lang.String r1 = "man"
            boolean r1 = r5.equals(r1)     // Catch:{ JSONException -> 0x022e }
            if (r1 == 0) goto L_0x0176
            java.lang.String r1 = "man"
            goto L_0x0188
        L_0x0176:
            java.lang.String r1 = "woman"
            goto L_0x0188
        L_0x0179:
            if (r3 != r9) goto L_0x0188
            java.lang.String r1 = "man"
            boolean r1 = r5.equals(r1)     // Catch:{ JSONException -> 0x022e }
            if (r1 == 0) goto L_0x0186
            java.lang.String r1 = "boy"
            goto L_0x0188
        L_0x0186:
            java.lang.String r1 = "girl"
        L_0x0188:
            java.lang.String r16 = java.lang.String.valueOf(r10)     // Catch:{ JSONException -> 0x022e }
            java.lang.String[] r5 = new java.lang.String[r9]     // Catch:{ JSONException -> 0x022e }
            java.lang.String r6 = java.lang.String.valueOf(r11)     // Catch:{ JSONException -> 0x022e }
            r5[r8] = r6     // Catch:{ JSONException -> 0x022e }
            java.lang.String[] r6 = new java.lang.String[r9]     // Catch:{ JSONException -> 0x022e }
            java.lang.String r11 = java.lang.String.valueOf(r12)     // Catch:{ JSONException -> 0x022e }
            r6[r8] = r11     // Catch:{ JSONException -> 0x022e }
            r17 = r5
            r18 = r6
            r19 = r0
            r21 = r3
            boolean r0 = r15.a(r16, r17, r18, r19, r20, r21)     // Catch:{ JSONException -> 0x022e }
            goto L_0x01c1
        L_0x01a9:
            java.lang.String r3 = java.lang.String.valueOf(r10)     // Catch:{ JSONException -> 0x022e }
            java.lang.String[] r5 = new java.lang.String[r9]     // Catch:{ JSONException -> 0x022e }
            java.lang.String r6 = java.lang.String.valueOf(r11)     // Catch:{ JSONException -> 0x022e }
            r5[r8] = r6     // Catch:{ JSONException -> 0x022e }
            java.lang.String[] r6 = new java.lang.String[r9]     // Catch:{ JSONException -> 0x022e }
            java.lang.String r11 = java.lang.String.valueOf(r12)     // Catch:{ JSONException -> 0x022e }
            r6[r8] = r11     // Catch:{ JSONException -> 0x022e }
            boolean r0 = r15.a(r3, r5, r6, r0)     // Catch:{ JSONException -> 0x022e }
        L_0x01c1:
            if (r0 != 0) goto L_0x01ea
            java.lang.String r3 = d     // Catch:{ JSONException -> 0x022e }
            java.lang.String r5 = "ERROR :: add item fail."
            android.util.Log.e(r3, r5)     // Catch:{ JSONException -> 0x022e }
            goto L_0x01ea
        L_0x01cb:
            r0 = 0
            goto L_0x01ea
        L_0x01cd:
            android.app.Activity r0 = r22.getActivity()     // Catch:{ JSONException -> 0x022e }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ JSONException -> 0x022e }
            net.fxgear.fitnshop.d r0 = net.fxgear.fitnshop.d.a((android.content.Context) r0)     // Catch:{ JSONException -> 0x022e }
            java.lang.String r3 = java.lang.String.valueOf(r10)     // Catch:{ JSONException -> 0x022e }
            boolean r0 = r0.a((java.lang.String) r3)     // Catch:{ JSONException -> 0x022e }
            if (r0 != 0) goto L_0x01ea
            java.lang.String r3 = d     // Catch:{ JSONException -> 0x022e }
            java.lang.String r5 = "ERROR :: remove item fail."
            android.util.Log.e(r3, r5)     // Catch:{ JSONException -> 0x022e }
        L_0x01ea:
            r5 = r1
            if (r0 == 0) goto L_0x01f1
            if (r4 != r9) goto L_0x01f1
            r4 = 1
            goto L_0x01f2
        L_0x01f1:
            r4 = 0
        L_0x01f2:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x022e }
            r1.<init>()     // Catch:{ JSONException -> 0x022e }
            java.lang.String r3 = "dispatch_no"
            r1.put(r3, r2)     // Catch:{ JSONException -> 0x022e }
            java.lang.String r2 = "result"
            if (r0 == 0) goto L_0x0202
            r0 = 1
            goto L_0x0203
        L_0x0202:
            r0 = 0
        L_0x0203:
            r1.put(r2, r0)     // Catch:{ JSONException -> 0x022e }
            java.lang.String r0 = "javascript:%s(%s)"
            java.lang.Object[] r2 = new java.lang.Object[r14]     // Catch:{ JSONException -> 0x022e }
            java.lang.String r3 = "onFinishedSetWishItem"
            r2[r8] = r3     // Catch:{ JSONException -> 0x022e }
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x022e }
            r2[r9] = r1     // Catch:{ JSONException -> 0x022e }
            java.lang.String r3 = java.lang.String.format(r0, r2)     // Catch:{ JSONException -> 0x022e }
            android.os.Handler r0 = r7.I     // Catch:{ JSONException -> 0x022e }
            if (r0 == 0) goto L_0x0232
            java.lang.String r6 = java.lang.String.valueOf(r10)     // Catch:{ JSONException -> 0x022e }
            android.os.Handler r0 = r7.I     // Catch:{ JSONException -> 0x022e }
            net.fxgear.fitnshop.d.m$5 r8 = new net.fxgear.fitnshop.d.m$5     // Catch:{ JSONException -> 0x022e }
            r1 = r8
            r2 = r22
            r1.<init>(r3, r4, r5, r6)     // Catch:{ JSONException -> 0x022e }
            r0.post(r8)     // Catch:{ JSONException -> 0x022e }
            goto L_0x0232
        L_0x022e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0232:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.d.m.setWishItem(java.lang.String):void");
    }

    @JavascriptInterface
    public void onResponseAllCategory(String str) {
        String str2 = d;
        Log.d(str2, "onResponseAllCategory() " + str);
        try {
            JSONObject jSONObject = new JSONArray(str).getJSONObject(0);
            JSONObject jSONObject2 = jSONObject.getJSONObject(GlobalDefine.GENDER_WOMAN_STRING);
            JSONObject jSONObject3 = jSONObject.getJSONObject(GlobalDefine.GENDER_MAN_STRING);
            ArrayList<b.a.C0035a> a2 = a(jSONObject2);
            ArrayList<b.a.C0035a> a3 = a(jSONObject3);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(GlobalDefine.GENDER_WOMAN_STRING, a2);
            linkedHashMap.put(GlobalDefine.GENDER_MAN_STRING, a3);
            JSONObject jSONObject4 = jSONObject.getJSONObject("woman_kids");
            JSONObject jSONObject5 = jSONObject.getJSONObject("man_kids");
            ArrayList<b.a.C0035a> a4 = a(jSONObject4);
            ArrayList<b.a.C0035a> a5 = a(jSONObject5);
            linkedHashMap.put("girl", a4);
            linkedHashMap.put("boy", a5);
            ((ApplicationClass) getActivity().getApplicationContext()).a(linkedHashMap);
            Log.i(d, "Complete json parsing");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @JavascriptInterface
    public void goFittingRoom(String str) {
        String str2 = d;
        Log.d(str2, "goFittingRoom() " + str);
        if (this.I != null) {
            this.I.post(new Runnable() {
                public void run() {
                    if (m.this.getActivity() instanceof FitNShopMainActivity) {
                        ((FitNShopMainActivity) m.this.getActivity()).a("wishlist", (String) null, m.d);
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void login(String str) {
        String str2 = d;
        Log.d(str2, "login() " + str);
        CookieManager.getInstance().flush();
    }

    @JavascriptInterface
    public void logout(String str) {
        String str2 = d;
        Log.d(str2, "logout() " + str);
        CookieManager.getInstance().removeAllCookies((ValueCallback) null);
    }

    private ArrayList<b.a.C0035a> a(JSONObject jSONObject) throws JSONException {
        ArrayList<b.a.C0035a> arrayList = new ArrayList<>();
        JSONArray jSONArray = jSONObject.getJSONArray("category_list");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            arrayList.add(new b.a.C0035a(jSONObject2.getInt("category_id"), jSONObject2.getString("category_name")));
        }
        return arrayList;
    }

    private void i() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            String[] a2 = d.a(getActivity().getApplicationContext()).a();
            if (a2 != null) {
                for (String parseInt : a2) {
                    jSONArray.put(Integer.valueOf(Integer.parseInt(parseInt)));
                }
            }
            jSONObject.put("ids", jSONArray);
            jSONObject.put("result", 1);
            final String format = String.format("javascript:%s(%s)", new Object[]{"onFinishedGetWishListId", jSONObject.toString()});
            if (this.I != null) {
                this.I.post(new Runnable() {
                    public void run() {
                        if (m.this.K != null) {
                            String str = m.d;
                            Log.i(str, "ResponseWishlist send json : " + format);
                            m.this.K.loadUrl(format);
                        }
                    }
                });
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        if (!(Build.VERSION.SDK_INT < 23 || android.support.v4.b.a.a(getActivity().getApplicationContext(), "android.permission.CAMERA") != -1)) {
            net.fxgear.fitnshop.c.b bVar = new net.fxgear.fitnshop.c.b(getActivity(), 2);
            bVar.a((String) null);
            bVar.b(getResources().getString(a.g.camera_access_required));
            bVar.c(getResources().getString(2131361829));
            bVar.d(getResources().getString(2131361832));
            bVar.a((b.a) new b.a() {
                public void a(net.fxgear.fitnshop.c.b bVar) {
                    bVar.dismiss();
                }

                public void b(net.fxgear.fitnshop.c.b bVar) {
                    android.support.v4.a.a.a(m.this.getActivity(), new String[]{"android.permission.CAMERA"}, 0);
                    bVar.dismiss();
                }
            });
            bVar.show();
        } else if (getActivity() instanceof FitNShopMainActivity) {
            ((FitNShopMainActivity) getActivity()).a("add_clothes", (String) null, d);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\e\a.java ==========

package net.fxgear.fitnshop.e;

import net.fxgear.GlobalDefine;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ADItemInfo */
public class a {

    /* renamed from: a  reason: collision with root package name */
    e f1075a;

    /* renamed from: b  reason: collision with root package name */
    o f1076b;

    public e a() {
        return this.f1075a;
    }

    public o b() {
        return this.f1076b;
    }

    /* compiled from: ADItemInfo */
    static class k {

        /* renamed from: a  reason: collision with root package name */
        private final int f1095a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f1096b;
        private final int c;

        k(int i, int i2, int i3) {
            this.f1095a = i;
            this.f1096b = i2;
            this.c = i3;
        }
    }

    /* renamed from: net.fxgear.fitnshop.e.a$a  reason: collision with other inner class name */
    /* compiled from: ADItemInfo */
    static abstract class C0034a {

        /* renamed from: a  reason: collision with root package name */
        k f1081a;

        C0034a() {
        }

        public int a() {
            return this.f1081a.f1096b;
        }
    }

    /* compiled from: ADItemInfo */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        String f1084a;

        /* renamed from: b  reason: collision with root package name */
        String f1085b;
        String c;
        String d;
        int e;
        String f;
        String g;
        String h;

        public String a() {
            return this.f1085b;
        }

        public String b() {
            return this.c;
        }

        public String c() {
            return this.d;
        }

        public String d() {
            return this.f;
        }
    }

    /* compiled from: ADItemInfo */
    public static class e extends C0034a {

        /* renamed from: b  reason: collision with root package name */
        g[] f1088b;

        public /* bridge */ /* synthetic */ int a() {
            return super.a();
        }

        public g[] b() {
            return this.f1088b;
        }
    }

    /* compiled from: ADItemInfo */
    public static class g extends c {
        /* access modifiers changed from: private */
        public i i;

        public i e() {
            return this.i;
        }
    }

    /* compiled from: ADItemInfo */
    public static class o extends C0034a {

        /* renamed from: b  reason: collision with root package name */
        q[] f1099b;

        public /* bridge */ /* synthetic */ int a() {
            return super.a();
        }

        public q[] b() {
            return this.f1099b;
        }
    }

    /* compiled from: ADItemInfo */
    public static class q extends c {
        /* access modifiers changed from: private */
        public int i;
        /* access modifiers changed from: private */
        public m j;
        /* access modifiers changed from: private */
        public i k;

        public int e() {
            return this.i;
        }

        public m f() {
            return this.j;
        }

        public i g() {
            return this.k;
        }
    }

    /* compiled from: ADItemInfo */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        String f1091a;

        /* renamed from: b  reason: collision with root package name */
        int f1092b;
        int c;
        String d;
        String e;
        String f;

        public String a() {
            return this.f1091a;
        }

        public int b() {
            return this.f1092b;
        }

        public int c() {
            return this.c;
        }
    }

    /* compiled from: ADItemInfo */
    public static class m extends i {
        /* access modifiers changed from: private */
        public float g;
        /* access modifiers changed from: private */
        public float h;
        /* access modifiers changed from: private */
        public int i;
        /* access modifiers changed from: private */
        public int j;

        public float d() {
            return this.h;
        }

        public int e() {
            return this.i;
        }

        public int f() {
            return this.j;
        }
    }

    /* compiled from: ADItemInfo */
    static class l {

        /* renamed from: a  reason: collision with root package name */
        private final String f1097a = "start";

        /* renamed from: b  reason: collision with root package name */
        private final String f1098b = "count";
        private final String c = "total";
        private final int d;
        private final int e;
        private final int f;

        public l(JSONObject jSONObject) throws JSONException {
            int i = 0;
            this.d = jSONObject.has("start") ? jSONObject.getInt("start") : 0;
            this.e = jSONObject.has("count") ? jSONObject.getInt("count") : 0;
            this.f = jSONObject.has("total") ? jSONObject.getInt("total") : i;
        }

        public k a() {
            return new k(this.d, this.e, this.f);
        }
    }

    /* compiled from: ADItemInfo */
    static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f1082a = "info";

        /* renamed from: b  reason: collision with root package name */
        private l f1083b;

        public b(JSONObject jSONObject) throws JSONException {
            this.f1083b = new l(jSONObject.getJSONObject("info"));
        }

        public k a() {
            return this.f1083b.a();
        }
    }

    /* compiled from: ADItemInfo */
    static abstract class d {

        /* renamed from: a  reason: collision with root package name */
        final String f1086a;

        /* renamed from: b  reason: collision with root package name */
        final String f1087b;
        final String c;
        final String d;
        final int e;
        final String f;
        final String g;
        final String h;
        private final String i = "code";
        private final String j = "name";
        private final String k = "description";
        private final String l = "state";
        private final String m = "priority";
        private final String n = "official_site_url";
        private final String o = "registerd_date";
        private final String p = "updated_date";

        public d(JSONObject jSONObject) throws JSONException {
            String str = null;
            this.f1086a = jSONObject.has("code") ? jSONObject.getString("code") : null;
            this.f1087b = jSONObject.has("name") ? jSONObject.getString("name") : null;
            this.c = jSONObject.has("description") ? jSONObject.getString("description") : null;
            this.d = jSONObject.has("state") ? jSONObject.getString("state") : null;
            this.e = jSONObject.has("priority") ? jSONObject.getInt("priority") : 0;
            this.f = jSONObject.has("official_site_url") ? jSONObject.getString("official_site_url") : null;
            this.g = jSONObject.has("registerd_date") ? jSONObject.getString("registerd_date") : null;
            this.h = jSONObject.has("updated_date") ? jSONObject.getString("updated_date") : str;
        }
    }

    /* compiled from: ADItemInfo */
    static class f extends b {

        /* renamed from: a  reason: collision with root package name */
        h[] f1089a;

        /* renamed from: b  reason: collision with root package name */
        private final String f1090b = "data";

        public f(JSONObject jSONObject) throws JSONException {
            super(jSONObject);
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            int length = jSONArray.length();
            this.f1089a = new h[length];
            for (int i = 0; i < length; i++) {
                this.f1089a[i] = new h(jSONArray.getJSONObject(i));
            }
        }
    }

    /* compiled from: ADItemInfo */
    static class h extends d {
        private final String i = "images";
        private final String j = "cover";
        private final j k;

        public h(JSONObject jSONObject) throws JSONException {
            super(jSONObject);
            this.k = new j(jSONObject.getJSONObject("images").getJSONArray("cover").getJSONObject(0));
        }

        public g a() {
            g gVar = new g();
            gVar.f1084a = this.f1086a;
            gVar.f1085b = this.f1087b;
            gVar.c = this.c;
            gVar.d = this.d;
            gVar.e = this.e;
            gVar.f = this.f;
            gVar.g = this.g;
            gVar.h = this.h;
            i unused = gVar.i = this.k.a();
            return gVar;
        }
    }

    /* compiled from: ADItemInfo */
    static class p extends b {

        /* renamed from: a  reason: collision with root package name */
        r[] f1100a;

        /* renamed from: b  reason: collision with root package name */
        private final String f1101b = "data";

        public p(JSONObject jSONObject) throws JSONException {
            super(jSONObject);
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            int length = jSONArray.length();
            this.f1100a = new r[length];
            for (int i = 0; i < length; i++) {
                this.f1100a[i] = new r(jSONArray.getJSONObject(i));
            }
        }
    }

    /* compiled from: ADItemInfo */
    static class r extends d {
        private final String i = "images";
        private final String j = "cover";
        private final String k = "bi";
        private final String l = "id";
        private final int m;
        private final n n;
        private final j o;

        public r(JSONObject jSONObject) throws JSONException {
            super(jSONObject);
            this.m = jSONObject.getInt("id");
            JSONObject jSONObject2 = jSONObject.getJSONObject("images");
            this.n = new n(jSONObject2.getJSONArray("cover").getJSONObject(0));
            this.o = new j(jSONObject2.getJSONArray("bi").getJSONObject(0));
        }

        public q a() {
            q qVar = new q();
            int unused = qVar.i = this.m;
            qVar.f1084a = this.f1086a;
            qVar.f1085b = this.f1087b;
            qVar.c = this.c;
            qVar.d = this.d;
            qVar.e = this.e;
            qVar.f = this.f;
            qVar.g = this.g;
            qVar.h = this.h;
            m unused2 = qVar.j = this.n.b();
            i unused3 = qVar.k = this.o.a();
            return qVar;
        }
    }

    /* compiled from: ADItemInfo */
    static class j {

        /* renamed from: a  reason: collision with root package name */
        final String f1093a;

        /* renamed from: b  reason: collision with root package name */
        final int f1094b;
        final int c;
        final String d;
        final String e;
        final String f;
        private final String g = "contact_url";
        private final String h = "width";
        private final String i = "height";
        private final String j = "registerd_date";
        private final String k = "updated_date";
        private final String l = "device_type";

        public j(JSONObject jSONObject) throws JSONException {
            String str = null;
            this.f1093a = jSONObject.has("contact_url") ? jSONObject.getString("contact_url") : null;
            int i2 = 0;
            this.f1094b = jSONObject.has("width") ? jSONObject.getInt("width") : 0;
            this.c = jSONObject.has("height") ? jSONObject.getInt("height") : i2;
            this.d = jSONObject.has("registerd_date") ? jSONObject.getString("registerd_date") : null;
            this.e = jSONObject.has("updated_date") ? jSONObject.getString("updated_date") : null;
            this.f = jSONObject.has("device_type") ? jSONObject.getString("device_type") : str;
        }

        public i a() {
            i iVar = new i();
            iVar.f1091a = this.f1093a;
            iVar.f1092b = this.f1094b;
            iVar.c = this.c;
            iVar.d = this.d;
            iVar.e = this.e;
            iVar.f = this.f;
            return iVar;
        }
    }

    /* compiled from: ADItemInfo */
    static class n extends j {
        private final String g = "center";
        private final String h = "x";
        private final String i = "y";
        private final String j = "height_range";
        private final String k = "min";
        private final String l = "max";
        private final float m;
        private final float n;
        private final int o;
        private final int p;

        public n(JSONObject jSONObject) throws JSONException {
            super(jSONObject);
            JSONObject jSONObject2 = jSONObject.getJSONObject("center");
            boolean has = jSONObject2.has("x");
            float f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            this.m = has ? Float.parseFloat(jSONObject2.getString("x")) : GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            this.n = jSONObject2.has("y") ? Float.parseFloat(jSONObject2.getString("y")) : f;
            JSONObject jSONObject3 = jSONObject.getJSONObject("height_range");
            int i2 = 0;
            this.o = jSONObject3.has("min") ? jSONObject3.getInt("min") : 0;
            this.p = jSONObject3.has("max") ? jSONObject3.getInt("max") : i2;
        }

        public i a() {
            return b();
        }

        public m b() {
            m mVar = new m();
            mVar.f1091a = this.f1093a;
            mVar.f1092b = this.f1094b;
            mVar.c = this.c;
            mVar.d = this.d;
            mVar.e = this.e;
            mVar.f = this.f;
            float unused = mVar.g = this.m;
            float unused2 = mVar.h = this.n;
            int unused3 = mVar.i = this.o;
            int unused4 = mVar.j = this.p;
            return mVar;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\e\b.java ==========

package net.fxgear.fitnshop.e;

import android.util.Log;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BrandInfo */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f1102a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1103b;
    public final int c;
    public final a[] d;
    private final String e = "info";
    private final String f = "start";
    private final String g = "count";
    private final String h = "total";
    private final String i = "results";

    public b(String str) throws JSONException {
        if (str != null) {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("info");
            this.f1102a = jSONObject2.getInt("start");
            this.f1103b = jSONObject2.getInt("count");
            this.c = jSONObject2.getInt("total");
            JSONArray jSONArray = jSONObject.getJSONArray("results");
            if (jSONArray == null || jSONArray.length() <= 0) {
                this.d = null;
                return;
            }
            this.d = new a[jSONArray.length()];
            for (int i2 = 0; i2 < this.d.length; i2++) {
                this.d[i2] = new a(jSONArray.getJSONObject(i2));
            }
            return;
        }
        this.d = null;
        this.c = 0;
        this.f1103b = 0;
        this.f1102a = 0;
    }

    /* compiled from: BrandInfo */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f1104a = "id";

        /* renamed from: b  reason: collision with root package name */
        private final String f1105b = "uuid";
        private final String c = "name";
        private final String d = "account_id";
        private final String e = "status";
        private final String f = "reg_date";
        private final int g;
        private String h;
        private final String i;
        private int j;
        private String k;
        private String l;
        private LinkedHashMap<String, ArrayList<C0035a>> m;

        public a(JSONObject jSONObject) throws JSONException {
            this.g = jSONObject.getInt("id");
            this.h = jSONObject.getString("uuid");
            this.i = jSONObject.getString("name");
            this.j = jSONObject.getInt("account_id");
            this.k = jSONObject.getString("status");
            this.l = jSONObject.getString("reg_date");
            this.m = new LinkedHashMap<>();
        }

        public a(int i2, String str) {
            this.g = i2;
            this.i = str;
            this.m = new LinkedHashMap<>();
        }

        public void a() {
            if (this.m != null) {
                this.m.clear();
                this.m = null;
            }
        }

        public void a(LinkedHashMap<String, ArrayList<C0035a>> linkedHashMap) {
            this.m.clear();
            this.m = linkedHashMap;
        }

        public void a(String str, String str2) throws JSONException {
            Log.d("BrandItem", "GenerateCategoryInfo()+");
            if (str == null || str2 == null) {
                Log.e("BrandItem", "ERROR :: param is null.");
                return;
            }
            if (this.m.containsKey(str)) {
                this.m.remove(str);
            }
            this.m.put(str, C0035a.a(str2));
        }

        public int b() {
            return this.g;
        }

        public String c() {
            return this.i;
        }

        public ArrayList<C0035a> a(String str) {
            if (str == null || !this.m.containsKey(str)) {
                return null;
            }
            return this.m.get(str);
        }

        public String[] d() {
            return (String[]) this.m.keySet().toArray(new String[this.m.size()]);
        }

        public boolean b(String str) {
            return this.m.containsKey(str);
        }

        /* renamed from: net.fxgear.fitnshop.e.b$a$a  reason: collision with other inner class name */
        /* compiled from: BrandInfo */
        public static class C0035a {

            /* renamed from: a  reason: collision with root package name */
            private final String f1106a = "id";

            /* renamed from: b  reason: collision with root package name */
            private final String f1107b = "name";
            private final String c = "status";
            private final String d = "priority";
            private final int e;
            private final String f;
            private String g;
            private int h;

            static ArrayList<C0035a> a(String str) throws JSONException {
                ArrayList<C0035a> arrayList = new ArrayList<>();
                JSONArray jSONArray = new JSONObject(str).getJSONArray("results");
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(new C0035a(jSONArray.getJSONObject(i)));
                    }
                }
                return arrayList;
            }

            public C0035a(int i, String str) {
                this.e = i;
                this.f = str;
            }

            public C0035a(JSONObject jSONObject) throws JSONException {
                this.e = jSONObject.getInt("id");
                this.f = jSONObject.getString("name");
                this.g = jSONObject.getString("status");
                this.h = jSONObject.getInt("priority");
            }

            public int a() {
                return this.e;
            }

            public String b() {
                return this.f;
            }

            public boolean equals(Object obj) {
                if (obj == null || !(obj instanceof C0035a)) {
                    return false;
                }
                C0035a aVar = (C0035a) obj;
                return aVar.a() == this.e && aVar.b().equals(this.f);
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\e\c.java ==========

package net.fxgear.fitnshop.e;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ClothesInfo */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f1110a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1111b;
    public final int c;
    public a[] d;
    private final String e = "info";
    private final String f = "start";
    private final String g = "count";
    private final String h = "total";
    private final String i = "results";

    public c(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("info");
        this.f1110a = jSONObject2.getInt("start");
        this.f1111b = jSONObject2.getInt("count");
        this.c = jSONObject2.getInt("total");
        JSONArray jSONArray = jSONObject.getJSONArray("results");
        if (jSONArray == null || jSONArray.length() <= 0) {
            this.d = null;
            return;
        }
        this.d = new a[jSONArray.length()];
        for (int i2 = 0; i2 < this.d.length; i2++) {
            this.d[i2] = new a(jSONArray.getJSONObject(i2));
        }
    }

    /* compiled from: ClothesInfo */
    public class a {
        private final int A;
        private final String[] B;
        private final String[] C;

        /* renamed from: b  reason: collision with root package name */
        private final String f1113b = "id";
        private final String c = "name";
        private final String d = "item_sex";
        private final String e = "item_kids";
        private final String f = "purchase_url";
        private final String g = "item_price";
        private final String h = "currency";
        private final String i = "item_thumbnail_url";
        private final String j = "brand_id";
        private final String k = "brand_name";
        private final String l = "sale_type";
        private final String m = "td_list";
        private final String n = "rep_yn";
        private final String o = "category_list";
        private final String p = "id";
        private final int q;
        private final String r;
        private final String s;
        private final boolean t;
        private final String u;
        private final double v;
        private final String w;
        private final String x;
        private final int y;
        private final String z;

        public a(JSONObject jSONObject) throws JSONException {
            this.q = jSONObject.getInt("id");
            this.r = jSONObject.getString("name");
            this.s = jSONObject.getString("item_sex");
            boolean z2 = false;
            if (jSONObject.has("item_kids")) {
                this.t = jSONObject.getInt("item_kids") == 1 ? true : z2;
            } else {
                this.t = false;
            }
            this.u = jSONObject.getString("purchase_url");
            this.v = jSONObject.getDouble("item_price");
            this.w = jSONObject.getString("currency");
            this.x = jSONObject.getString("item_thumbnail_url");
            this.y = jSONObject.getInt("brand_id");
            this.z = jSONObject.getString("brand_name");
            this.A = jSONObject.getInt("sale_type");
            this.B = a(jSONObject.get("td_list"));
            this.C = b(jSONObject.get("category_list"));
        }

        private String[] a(Object obj) throws JSONException {
            JSONArray jSONArray;
            String[] strArr = null;
            if (obj != null && (obj instanceof JSONArray) && (jSONArray = (JSONArray) obj) != null && jSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                String str = null;
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject != null && jSONObject.getInt("rep_yn") == 1) {
                        str = jSONObject.getString("id");
                    }
                }
                if (str != null) {
                    arrayList.add(str);
                }
                if (!arrayList.isEmpty()) {
                    strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                }
                arrayList.clear();
            }
            return strArr;
        }

        private String[] b(Object obj) throws JSONException {
            JSONArray jSONArray;
            String[] strArr = null;
            if (obj != null && (obj instanceof JSONArray) && (jSONArray = (JSONArray) obj) != null && jSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject != null) {
                        arrayList.add(jSONObject.getString("id"));
                    }
                }
                if (!arrayList.isEmpty()) {
                    strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                }
                arrayList.clear();
            }
            return strArr;
        }

        public int a() {
            return this.q;
        }

        public String b() {
            return this.r;
        }

        public String c() {
            return this.s;
        }

        public boolean d() {
            return this.t;
        }

        public String e() {
            return this.u;
        }

        public double f() {
            return this.v;
        }

        public String g() {
            return this.w;
        }

        public String h() {
            return this.x;
        }

        public int i() {
            return this.y;
        }

        public String j() {
            return this.z;
        }

        public int k() {
            return this.A;
        }

        public String[] l() {
            return this.B;
        }

        public String[] m() {
            return this.C;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\e\d.java ==========

package net.fxgear.fitnshop.e;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.util.Log;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import net.fxgear.GlobalDefine;
import net.fxgear.fitnshop.e.b;
import net.fxgear.fitnshop.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NetworkManager */
public class d {

    /* renamed from: a  reason: collision with root package name */
    static final String f1116a = ("&" + System.currentTimeMillis());

    /* compiled from: NetworkManager */
    public interface f {
        void a();

        void a(int i, Object obj);
    }

    public static b a(Context context, f fVar) {
        b bVar = new b(context, fVar);
        bVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return bVar;
    }

    /* compiled from: NetworkManager */
    public static class b extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        private final String f1125a = "%s/v2/package/chkInfo?";

        /* renamed from: b  reason: collision with root package name */
        private final String f1126b = "&pkg_name=%s";
        private final String c = "&os=%s";
        private final String d = "&version=%s";
        private final String e = "os";
        private final String f = "app_link";
        private final String g = "version";
        private final String h = "required_version";
        private final String i = "sdk_permission";
        private Context j;
        private f k;
        private a l = new a();

        /* compiled from: NetworkManager */
        public class a {

            /* renamed from: a  reason: collision with root package name */
            public int f1127a = 0;

            /* renamed from: b  reason: collision with root package name */
            public String f1128b;
            public String c;
            public int d;
            public int e;
            public boolean f;

            public a() {
            }
        }

        public b(Context context, f fVar) {
            this.j = context;
            this.k = fVar;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (this.k != null) {
                this.k.a();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            if (this.j != null) {
                try {
                    PackageInfo packageInfo = this.j.getPackageManager().getPackageInfo(this.j.getPackageName(), 0);
                    StringBuilder sb = new StringBuilder(String.format("%s/v2/package/chkInfo?", new Object[]{h.f1164b.n}));
                    sb.append(String.format("&pkg_name=%s", new Object[]{packageInfo.packageName}));
                    sb.append(String.format("&os=%s", new Object[]{"android"}));
                    sb.append(String.format("&version=%s", new Object[]{Integer.valueOf(packageInfo.versionCode)}));
                    String a2 = new e().a(sb.toString(), "GET", (HashMap<String, String>) null);
                    Log.d("NetworkManager", "FitNshop doInBackground()+" + sb.toString());
                    if (a2 != null) {
                        h.b(a2);
                        JSONObject jSONObject = new JSONObject(a2);
                        this.l.f1128b = jSONObject.getString("os");
                        this.l.c = jSONObject.getString("app_link");
                        this.l.d = jSONObject.getInt("version");
                        this.l.e = jSONObject.getInt("required_version");
                        this.l.f = jSONObject.getBoolean("sdk_permission");
                        this.l.f1127a = -2;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    this.l.f1127a = 1;
                    e2.printStackTrace();
                } catch (IllegalArgumentException e3) {
                    this.l.f1127a = 2;
                    e3.printStackTrace();
                } catch (IOException e4) {
                    this.l.f1127a = 2;
                    e4.printStackTrace();
                } catch (JSONException e5) {
                    this.l.f1127a = 3;
                    e5.printStackTrace();
                }
            } else {
                this.l.f1127a = 1;
                Log.e("NetworkManager", "ERROR :: wrong param.");
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            int i2 = this.l.f1127a;
            if (i2 != -2) {
                this.l.f1128b = null;
                this.l.c = null;
                this.l.e = 0;
                this.l.d = 0;
                this.l.f = false;
            }
            if (this.k != null) {
                this.k.a(i2, this.l);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onCancelled(Void voidR) {
            Log.d("NetworkManager", "onCancelled()+");
            if (this.k != null) {
                this.k.a(-1, (Object) null);
            }
        }
    }

    public static e a(Activity activity, e.a aVar, f fVar) {
        e eVar = new e(activity, aVar, fVar);
        eVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return eVar;
    }

    /* compiled from: NetworkManager */
    public static class e extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        private Activity f1137a;

        /* renamed from: b  reason: collision with root package name */
        private final b f1138b = new b();
        private e c = null;
        private f d = null;

        /* compiled from: NetworkManager */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public int f1139a = -1;

            /* renamed from: b  reason: collision with root package name */
            public int f1140b = -1;
            public int c = -1;
            public int d = -1;
            public int e = -1;
            public int f = -1;
        }

        /* compiled from: NetworkManager */
        public class b {

            /* renamed from: a  reason: collision with root package name */
            public a f1141a;

            /* renamed from: b  reason: collision with root package name */
            public a f1142b;
            public b c;
            public LinkedHashMap<String, ArrayList<b.a.C0035a>> d;
            public int e = 0;

            public b() {
            }
        }

        public e(Activity activity, a aVar, f fVar) {
            Log.d("NetworkManager", "MultiBrandItemTask()+");
            this.f1137a = activity;
            this.d = fVar;
            this.f1138b.f1141a = aVar;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (this.d != null) {
                this.d.a();
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0276, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
            r2.printStackTrace();
            r14.f1138b.e = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x027e, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x038d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x038e, code lost:
            r0.printStackTrace();
            r14.f1138b.e = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x0396, code lost:
            r15 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x0397, code lost:
            r15.printStackTrace();
            r14.f1138b.e = 2;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x0396 A[ExcHandler: IOException (r15v3 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:1:0x000a] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void doInBackground(java.lang.Void... r15) {
            /*
                r14 = this;
                java.lang.String r15 = "NetworkManager"
                java.lang.String r0 = "doInBackground()+"
                android.util.Log.d(r15, r0)
                r15 = 3
                r0 = 2
                r1 = 0
                net.fxgear.fitnshop.e.e r2 = new net.fxgear.fitnshop.e.e     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r2.<init>()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r14.c = r2     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                android.app.Activity r2 = r14.f1137a     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = net.fxgear.fitnshop.h.a((android.app.Activity) r2)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r3 = "NetworkManager"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r4.<init>()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r5 = "Check resolution : "
                r4.append(r5)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r4.append(r2)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                android.util.Log.d(r3, r4)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$b r3 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$a r3 = r3.f1141a     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                int r3 = r3.f1139a     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r4 = 5
                r5 = 4
                r6 = -1
                r7 = 1
                r8 = 0
                if (r3 < 0) goto L_0x0140
                net.fxgear.fitnshop.e.d$e$b r3 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$a r3 = r3.f1141a     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                int r3 = r3.f1140b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                if (r3 <= 0) goto L_0x0140
                java.lang.String r3 = "%s?start=%d&count=%d&device_model=%s&device_os=%s"
                java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r10.<init>()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.g r11 = net.fxgear.fitnshop.h.f1164b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r11 = r11.q     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r10.append(r11)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r11 = "/AD/all"
                r10.append(r11)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r10 = r10.toString()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r9[r8] = r10     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$b r10 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$a r10 = r10.f1141a     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                int r10 = r10.f1139a     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r9[r7] = r10     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$b r10 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$a r10 = r10.f1141a     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                int r10 = r10.f1140b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r9[r0] = r10     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r9[r15] = r2     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r10 = "android"
                r9[r5] = r10     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r3 = java.lang.String.format(r3, r9)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.g r9 = net.fxgear.fitnshop.h.f1164b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                boolean r9 = r9.i()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                if (r9 == 0) goto L_0x00a3
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r9.<init>()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r9.append(r3)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r3 = "&state=%s"
                java.lang.Object[] r10 = new java.lang.Object[r7]     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r11 = "all"
                r10[r8] = r11     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r3 = java.lang.String.format(r3, r10)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r9.append(r3)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r3 = r9.toString()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                goto L_0x00be
            L_0x00a3:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r9.<init>()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r9.append(r3)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r3 = "&state=%s"
                java.lang.Object[] r10 = new java.lang.Object[r7]     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r11 = "activated"
                r10[r8] = r11     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r3 = java.lang.String.format(r3, r10)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r9.append(r3)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r3 = r9.toString()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
            L_0x00be:
                net.fxgear.fitnshop.e.e r9 = r14.c     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r10.<init>()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r10.append(r3)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r3 = net.fxgear.fitnshop.e.d.f1116a     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r10.append(r3)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r3 = r10.toString()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r10 = "GET"
                java.lang.String r3 = r9.a(r3, r10, r1)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                if (r3 == 0) goto L_0x013b
                net.fxgear.fitnshop.h.b((java.lang.String) r3)     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                r9.<init>(r3)     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.a$f r3 = new net.fxgear.fitnshop.e.a$f     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                r3.<init>(r9)     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.a$e r9 = new net.fxgear.fitnshop.e.a$e     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                r9.<init>()     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.a$k r10 = r3.a()     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                r9.f1081a = r10     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.a$h[] r10 = r3.f1089a     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                int r10 = r10.length     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.a$g[] r11 = new net.fxgear.fitnshop.e.a.g[r10]     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                r9.f1088b = r11     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                r11 = 0
            L_0x00f9:
                if (r11 >= r10) goto L_0x011c
                boolean r12 = r14.isCancelled()     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                if (r12 == 0) goto L_0x010d
                java.lang.String r2 = "NetworkManager"
                java.lang.String r3 = "Cancel task."
                android.util.Log.e(r2, r3)     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.d$e$b r2 = r14.f1138b     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                r2.e = r6     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                return r1
            L_0x010d:
                net.fxgear.fitnshop.e.a$h[] r12 = r3.f1089a     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                r12 = r12[r11]     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.a$g r12 = r12.a()     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.a$g[] r13 = r9.f1088b     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                r13[r11] = r12     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                int r11 = r11 + 1
                goto L_0x00f9
            L_0x011c:
                net.fxgear.fitnshop.e.d$e$b r3 = r14.f1138b     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.a r3 = r3.f1142b     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                if (r3 != 0) goto L_0x012b
                net.fxgear.fitnshop.e.d$e$b r3 = r14.f1138b     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.a r10 = new net.fxgear.fitnshop.e.a     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                r10.<init>()     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                r3.f1142b = r10     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
            L_0x012b:
                net.fxgear.fitnshop.e.d$e$b r3 = r14.f1138b     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.a r3 = r3.f1142b     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                r3.f1075a = r9     // Catch:{ JSONException -> 0x0132, IOException -> 0x0396 }
                goto L_0x0140
            L_0x0132:
                r2 = move-exception
                r2.printStackTrace()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$b r2 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r2.e = r15     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                return r1
            L_0x013b:
                net.fxgear.fitnshop.e.d$e$b r2 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r2.e = r0     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                return r1
            L_0x0140:
                boolean r3 = r14.isCancelled()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                if (r3 == 0) goto L_0x0152
                java.lang.String r2 = "NetworkManager"
                java.lang.String r3 = "Cancel task."
                android.util.Log.e(r2, r3)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$b r2 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r2.e = r6     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                return r1
            L_0x0152:
                net.fxgear.fitnshop.e.d$e$b r3 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$a r3 = r3.f1141a     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                int r3 = r3.c     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r9 = -2
                if (r3 < 0) goto L_0x0284
                net.fxgear.fitnshop.e.d$e$b r3 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$a r3 = r3.f1141a     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                int r3 = r3.d     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                if (r3 <= 0) goto L_0x0284
                java.lang.String r3 = "%s?start=%d&count=%d&device_model=%s&device_os=%s"
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r10.<init>()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.g r11 = net.fxgear.fitnshop.h.f1164b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r11 = r11.q     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r10.append(r11)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r11 = "/Brand/all"
                r10.append(r11)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r10 = r10.toString()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r4[r8] = r10     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$b r10 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$a r10 = r10.f1141a     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                int r10 = r10.c     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r4[r7] = r10     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$b r10 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$a r10 = r10.f1141a     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                int r10 = r10.d     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r4[r0] = r10     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r4[r15] = r2     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = "android"
                r4[r5] = r2     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = java.lang.String.format(r3, r4)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.g r3 = net.fxgear.fitnshop.h.f1164b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                boolean r3 = r3.i()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                if (r3 == 0) goto L_0x01c4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3.<init>()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3.append(r2)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = "&state=%s"
                java.lang.Object[] r4 = new java.lang.Object[r7]     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r10 = "all"
                r4[r8] = r10     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = java.lang.String.format(r2, r4)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3.append(r2)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = r3.toString()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                goto L_0x01df
            L_0x01c4:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3.<init>()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3.append(r2)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = "&state=%s"
                java.lang.Object[] r4 = new java.lang.Object[r7]     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r10 = "activated"
                r4[r8] = r10     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = java.lang.String.format(r2, r4)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3.append(r2)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = r3.toString()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
            L_0x01df:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3.<init>()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3.append(r2)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = "&order=%s&order_type=%s"
                java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r10 = "priority"
                r4[r8] = r10     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r10 = "desc"
                r4[r7] = r10     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = java.lang.String.format(r2, r4)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3.append(r2)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = r3.toString()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.e r3 = r14.c     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r4.<init>()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r4.append(r2)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = net.fxgear.fitnshop.e.d.f1116a     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r4.append(r2)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = r4.toString()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r4 = "GET"
                java.lang.String r2 = r3.a(r2, r4, r1)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                if (r2 == 0) goto L_0x027f
                net.fxgear.fitnshop.h.b((java.lang.String) r2)     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                r3.<init>(r2)     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.a$p r2 = new net.fxgear.fitnshop.e.a$p     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                r2.<init>(r3)     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.a$o r3 = new net.fxgear.fitnshop.e.a$o     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                r3.<init>()     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.a$k r4 = r2.a()     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                r3.f1081a = r4     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.a$r[] r4 = r2.f1100a     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                int r4 = r4.length     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.a$q[] r10 = new net.fxgear.fitnshop.e.a.q[r4]     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                r3.f1099b = r10     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                r10 = 0
            L_0x0239:
                if (r10 >= r4) goto L_0x025c
                boolean r11 = r14.isCancelled()     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                if (r11 == 0) goto L_0x024d
                java.lang.String r2 = "NetworkManager"
                java.lang.String r3 = "Cancel task."
                android.util.Log.e(r2, r3)     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.d$e$b r2 = r14.f1138b     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                r2.e = r6     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                return r1
            L_0x024d:
                net.fxgear.fitnshop.e.a$r[] r11 = r2.f1100a     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                r11 = r11[r10]     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.a$q r11 = r11.a()     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.a$q[] r12 = r3.f1099b     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                r12[r10] = r11     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                int r10 = r10 + 1
                goto L_0x0239
            L_0x025c:
                net.fxgear.fitnshop.e.d$e$b r2 = r14.f1138b     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.a r2 = r2.f1142b     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                if (r2 != 0) goto L_0x026b
                net.fxgear.fitnshop.e.d$e$b r2 = r14.f1138b     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.a r4 = new net.fxgear.fitnshop.e.a     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                r4.<init>()     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                r2.f1142b = r4     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
            L_0x026b:
                net.fxgear.fitnshop.e.d$e$b r2 = r14.f1138b     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.a r2 = r2.f1142b     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                r2.f1076b = r3     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                net.fxgear.fitnshop.e.d$e$b r2 = r14.f1138b     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                r2.e = r9     // Catch:{ JSONException -> 0x0276, IOException -> 0x0396 }
                goto L_0x0284
            L_0x0276:
                r2 = move-exception
                r2.printStackTrace()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$b r2 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r2.e = r15     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                return r1
            L_0x027f:
                net.fxgear.fitnshop.e.d$e$b r2 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r2.e = r0     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                return r1
            L_0x0284:
                net.fxgear.fitnshop.e.d$e$b r2 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$a r2 = r2.f1141a     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                int r2 = r2.e     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                if (r2 < 0) goto L_0x0388
                net.fxgear.fitnshop.e.d$e$b r2 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$a r2 = r2.f1141a     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                int r2 = r2.f     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                if (r2 <= 0) goto L_0x0388
                net.fxgear.fitnshop.g r2 = net.fxgear.fitnshop.h.f1164b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = r2.t     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                if (r2 == 0) goto L_0x02c7
                java.lang.String r2 = "%s/brand/list?account_uuid=%s&start=%d&count=%d&order=priority"
                java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.g r4 = net.fxgear.fitnshop.h.f1164b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r4 = r4.n     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3[r8] = r4     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.g r4 = net.fxgear.fitnshop.h.f1164b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r4 = r4.t     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3[r7] = r4     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$b r4 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$a r4 = r4.f1141a     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                int r4 = r4.e     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3[r0] = r4     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$b r4 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$a r4 = r4.f1141a     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                int r4 = r4.f     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3[r15] = r4     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = java.lang.String.format(r2, r3)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                goto L_0x02ed
            L_0x02c7:
                java.lang.String r2 = "%s/brand/list?start=%d&count=%d&order=priority"
                java.lang.Object[] r3 = new java.lang.Object[r15]     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.g r4 = net.fxgear.fitnshop.h.f1164b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r4 = r4.n     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3[r8] = r4     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$b r4 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$a r4 = r4.f1141a     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                int r4 = r4.e     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3[r7] = r4     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$b r4 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$a r4 = r4.f1141a     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                int r4 = r4.f     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3[r0] = r4     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = java.lang.String.format(r2, r3)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
            L_0x02ed:
                net.fxgear.fitnshop.g r3 = net.fxgear.fitnshop.h.f1164b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                boolean r3 = r3.i()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                if (r3 == 0) goto L_0x0311
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3.<init>()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3.append(r2)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = "&status=%s"
                java.lang.Object[] r4 = new java.lang.Object[r7]     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r5 = "all"
                r4[r8] = r5     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = java.lang.String.format(r2, r4)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3.append(r2)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = r3.toString()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                goto L_0x032c
            L_0x0311:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3.<init>()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3.append(r2)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = "&status=%s"
                java.lang.Object[] r4 = new java.lang.Object[r7]     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r5 = "activated"
                r4[r8] = r5     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = java.lang.String.format(r2, r4)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3.append(r2)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r2 = r3.toString()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
            L_0x032c:
                net.fxgear.fitnshop.e.e r3 = new net.fxgear.fitnshop.e.e     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3.<init>()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r4 = "GET"
                java.lang.String r2 = r3.a(r2, r4, r1)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                if (r2 == 0) goto L_0x0383
                net.fxgear.fitnshop.h.b((java.lang.String) r2)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$b r3 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.b r4 = new net.fxgear.fitnshop.e.b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r4.<init>(r2)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3.c = r4     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$b r2 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$a r2 = r2.f1141a     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                int r2 = r2.e     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                if (r2 != 0) goto L_0x0388
                net.fxgear.fitnshop.e.d$e$b r2 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.b r2 = r2.c     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                int r2 = r2.c     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                if (r2 <= 0) goto L_0x0388
                net.fxgear.fitnshop.e.d$e$b r2 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.util.LinkedHashMap r3 = new java.util.LinkedHashMap     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r3.<init>()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r2.d = r3     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.g r2 = net.fxgear.fitnshop.h.f1164b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                boolean r2 = r2.d()     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                if (r2 == 0) goto L_0x0368
                int r6 = net.fxgear.fitnshop.h.c     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
            L_0x0368:
                java.lang.String[] r2 = net.fxgear.fitnshop.h.d     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                int r2 = r2.length     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                if (r8 >= r2) goto L_0x0388
                java.lang.String[] r2 = net.fxgear.fitnshop.h.d     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r2 = r2[r8]     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.lang.String r3 = net.fxgear.fitnshop.e.d.a((int) r6, (java.lang.String) r2)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                net.fxgear.fitnshop.e.d$e$b r4 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.util.LinkedHashMap<java.lang.String, java.util.ArrayList<net.fxgear.fitnshop.e.b$a$a>> r4 = r4.d     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                java.util.ArrayList r3 = net.fxgear.fitnshop.e.b.a.C0035a.a(r3)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r4.put(r2, r3)     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                int r8 = r8 + 1
                goto L_0x0368
            L_0x0383:
                net.fxgear.fitnshop.e.d$e$b r2 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r2.e = r0     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                return r1
            L_0x0388:
                net.fxgear.fitnshop.e.d$e$b r2 = r14.f1138b     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                r2.e = r9     // Catch:{ IOException -> 0x0396, JSONException -> 0x038d }
                goto L_0x039e
            L_0x038d:
                r0 = move-exception
                r0.printStackTrace()
                net.fxgear.fitnshop.e.d$e$b r0 = r14.f1138b
                r0.e = r15
                goto L_0x039e
            L_0x0396:
                r15 = move-exception
                r15.printStackTrace()
                net.fxgear.fitnshop.e.d$e$b r15 = r14.f1138b
                r15.e = r0
            L_0x039e:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fitnshop.e.d.e.doInBackground(java.lang.Void[]):java.lang.Void");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            int i = this.f1138b.e;
            if (i != -2) {
                this.f1138b.f1142b = null;
                this.f1138b.c = null;
            }
            if (this.d != null) {
                this.d.a(i, this.f1138b);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onCancelled(Void voidR) {
            if (this.d != null) {
                this.d.a(-1, (Object) null);
            }
        }

        public void a() {
            if (this.c != null) {
                this.c.a();
            }
            if (getStatus() != AsyncTask.Status.FINISHED) {
                cancel(true);
            }
        }
    }

    public static String a(int i, String str) throws IllegalArgumentException, IOException {
        boolean z;
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder(String.format("%s/category/list?", new Object[]{h.f1164b.n}));
        if (h.f1164b.t != null) {
            sb.append(String.format("account_uuid=%s", new Object[]{h.f1164b.t}));
            z = true;
        } else {
            z = false;
        }
        if (!(i == -1 || i == -2)) {
            if (z) {
                sb.append("&");
            } else {
                z = true;
            }
            sb.append(String.format("brand_id=%d", new Object[]{Integer.valueOf(i)}));
        }
        if (z) {
            sb.append("&");
        }
        if (str == null) {
            str3 = GlobalDefine.GENDER_WOMAN_STRING;
            str2 = GlobalDefine.REAL_VIDEO_NONE_DATE;
        } else if (str.equals(GlobalDefine.GENDER_MAN_STRING)) {
            str3 = GlobalDefine.GENDER_MAN_STRING;
            str2 = GlobalDefine.REAL_VIDEO_NONE_DATE;
        } else if (str.equals("girl")) {
            str3 = GlobalDefine.GENDER_WOMAN_STRING;
            str2 = "1";
        } else if (str.equals("boy")) {
            str3 = GlobalDefine.GENDER_MAN_STRING;
            str2 = "1";
        } else {
            str3 = GlobalDefine.GENDER_WOMAN_STRING;
            str2 = GlobalDefine.REAL_VIDEO_NONE_DATE;
        }
        sb.append(String.format("sex=%s", new Object[]{str3}));
        sb.append(String.format("&", new Object[0]));
        sb.append(String.format("kids_yn=%s", new Object[]{str2}));
        if (h.f1164b.i()) {
            sb.append(String.format("&status=%s", new Object[]{"all"}));
        } else {
            sb.append(String.format("&status=%s", new Object[]{"activated"}));
        }
        return new e().a(sb.toString(), "GET", (HashMap<String, String>) null);
    }

    public static C0037d a(C0037d.a aVar, f fVar) {
        C0037d dVar = new C0037d(aVar, fVar);
        dVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return dVar;
    }

    /* renamed from: net.fxgear.fitnshop.e.d$d  reason: collision with other inner class name */
    /* compiled from: NetworkManager */
    public static class C0037d extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        private final String f1131a = "%s/item/list?";

        /* renamed from: b  reason: collision with root package name */
        private final String f1132b = "item_status=%s";
        private final String c = "&item_cate_status=%s";
        private final String d = "&sale_type=%s";
        private final String e = "&from=%s";
        private final String f = "&include_cate_family_flag=%s";
        private final String g = "&include_cate_unassigned_flag=%s";
        private final String h = "activated";
        private final String i = "ready,activated";
        private final String j = "ready,activated,disabled";
        private final String k = "&item_name=%s";
        private final String l = "&brand_id=%s";
        private final String m = "&item_cate_id=%s";
        private final String n = "&start=%s&count=%s";
        private final String o = "&item_sex=%s&item_kids=%s&order=%s&order_type=%s";
        private final String p = "&show=thumbnail,td_list,categories";
        private final String q = "asc";
        private final String r = "desc";
        private final String s = "price";
        private final String t = "registerd_date";
        private b u = new b();
        private f v;

        /* renamed from: net.fxgear.fitnshop.e.d$d$a */
        /* compiled from: NetworkManager */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public String f1133a = null;

            /* renamed from: b  reason: collision with root package name */
            public int f1134b = -2;
            public int c = -2;
            public int d = -1;
            public int e = -1;
            public String f = GlobalDefine.GENDER_WOMAN_STRING;
            public String g = Integer.toString(2);
            public int h = 0;
            public boolean i = false;
        }

        /* renamed from: net.fxgear.fitnshop.e.d$d$b */
        /* compiled from: NetworkManager */
        public class b {

            /* renamed from: a  reason: collision with root package name */
            public a f1135a;

            /* renamed from: b  reason: collision with root package name */
            public c f1136b;
            public a.C0036a c;
            public int d = 0;

            public b() {
            }
        }

        public C0037d(a aVar, f fVar) {
            this.u.f1135a = aVar;
            this.v = fVar;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            Log.d("NetworkManager", "ClothesInfoTask, onPreExecute()+");
            if (this.v != null) {
                this.v.a();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            boolean z;
            Log.d("NetworkManager", "ClothesInfoTask, doInBackground()+");
            try {
                e eVar = new e();
                if (this.u.f1135a.i) {
                    this.u.c = a.a();
                    if (this.u.c == null) {
                        this.u.d = 3;
                        return null;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(String.format("%s/item/list?", new Object[]{h.f1164b.n}));
                if (h.f1164b.t != null) {
                    sb.append(String.format("account_uuid=%s", new Object[]{h.f1164b.t}));
                    z = true;
                } else {
                    z = false;
                }
                if (h.f1164b.i()) {
                    if (z) {
                        sb.append("&");
                    }
                    sb.append(String.format("item_status=%s", new Object[]{"ready,activated,disabled"}));
                    sb.append(String.format("&item_cate_status=%s", new Object[]{"ready,activated,disabled"}));
                } else {
                    if (z) {
                        sb.append("&");
                    }
                    sb.append(String.format("item_status=%s", new Object[]{"activated"}));
                    sb.append(String.format("&item_cate_status=%s", new Object[]{"activated"}));
                }
                if (this.u.f1135a.f1133a != null) {
                    sb.append(String.format("&item_name=%s", new Object[]{URLEncoder.encode(this.u.f1135a.f1133a, "UTF-8")}));
                    if (h.f1164b.d()) {
                        sb.append(String.format("&brand_id=%s", new Object[]{String.valueOf(this.u.f1135a.f1134b)}));
                    }
                } else {
                    if (!(this.u.f1135a.f1134b == -1 || this.u.f1135a.f1134b == -2)) {
                        sb.append(String.format("&brand_id=%s", new Object[]{String.valueOf(this.u.f1135a.f1134b)}));
                    }
                    if (!(this.u.f1135a.c == -1 || this.u.f1135a.c == -2)) {
                        sb.append(String.format("&item_cate_id=%s", new Object[]{String.valueOf(this.u.f1135a.c)}));
                    }
                }
                sb.append(a(this.u.f1135a.f, this.u.f1135a.h));
                sb.append(String.format("&start=%s&count=%s", new Object[]{Integer.valueOf(this.u.f1135a.d), Integer.valueOf(this.u.f1135a.e)}));
                sb.append("&show=thumbnail,td_list,categories");
                String a2 = eVar.a(sb.toString(), "GET", (HashMap<String, String>) null);
                if (a2 != null) {
                    h.b(a2);
                    JSONObject jSONObject = new JSONObject(a2);
                    this.u.f1136b = new c(jSONObject);
                    this.u.d = -2;
                }
            } catch (IllegalArgumentException e2) {
                this.u.d = 2;
                e2.printStackTrace();
            } catch (IOException e3) {
                this.u.d = 2;
                e3.printStackTrace();
            } catch (JSONException e4) {
                this.u.d = 3;
                e4.printStackTrace();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            Log.d("NetworkManager", "ClothesInfoTask, onPostExecute()+");
            int i2 = this.u.d;
            if (i2 != -2) {
                this.u.f1136b = null;
                this.u.c = null;
            }
            if (this.v != null) {
                this.v.a(i2, this.u);
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            Log.e("NetworkManager", "ClothesInfoTask, onCancelled()+");
            if (this.v != null) {
                this.v.a(-1, (Object) null);
            }
        }

        public void a() {
            Log.d("NetworkManager", "ClothesInfoTask, stopTask()+");
            if (getStatus() != AsyncTask.Status.FINISHED) {
                cancel(true);
            }
        }

        private String a(String str, int i2) {
            String str2;
            String str3;
            String str4;
            String str5;
            switch (i2) {
                case 1:
                    str2 = "price";
                    str3 = "desc";
                    break;
                case 2:
                    str2 = "price";
                    str3 = "asc";
                    break;
                default:
                    str2 = "registerd_date";
                    str3 = "desc";
                    break;
            }
            if (str == null) {
                str4 = GlobalDefine.GENDER_WOMAN_STRING;
                str5 = GlobalDefine.REAL_VIDEO_NONE_DATE;
            } else if (str.equals(GlobalDefine.GENDER_MAN_STRING)) {
                str4 = GlobalDefine.GENDER_MAN_STRING;
                str5 = GlobalDefine.REAL_VIDEO_NONE_DATE;
            } else if (str.equals("girl")) {
                str4 = GlobalDefine.GENDER_WOMAN_STRING;
                str5 = "1";
            } else if (str.equals("boy")) {
                str4 = GlobalDefine.GENDER_MAN_STRING;
                str5 = "1";
            } else {
                str4 = GlobalDefine.GENDER_WOMAN_STRING;
                str5 = GlobalDefine.REAL_VIDEO_NONE_DATE;
            }
            return String.format("&item_sex=%s&item_kids=%s&order=%s&order_type=%s", new Object[]{str4, str5, str2, str3});
        }
    }

    public static c a(String[] strArr, f fVar) {
        c cVar = new c(strArr, fVar);
        cVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return cVar;
    }

    /* compiled from: NetworkManager */
    public static class c extends AsyncTask<Void, Void, Integer> {

        /* renamed from: a  reason: collision with root package name */
        private final String f1129a = "CheckWishListTask";

        /* renamed from: b  reason: collision with root package name */
        private final String f1130b = "/item/chkAvailability";
        private final String c = "item_ids";
        private final String d = "not_available_item_ids";
        private final String e = "item_id";
        private final String f = ",";
        private String[] g;
        private String[] h;
        private f i;

        public c(String[] strArr, f fVar) {
            this.g = strArr;
            this.i = fVar;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            Log.d("CheckWishListTask", "onPreExecute()+");
            if (this.i != null) {
                this.i.a();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Integer doInBackground(Void... voidArr) {
            int i2;
            Log.d("CheckWishListTask", "doInBackground()+");
            if (this.g == null || this.g.length <= 0) {
                i2 = 1;
            } else {
                StringBuilder sb = new StringBuilder();
                for (String str : this.g) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(str);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("item_ids", sb.toString());
                i2 = 2;
                try {
                    String a2 = new e().a(h.f1164b.n + "/item/chkAvailability", "POST", hashMap);
                    if (a2 != null) {
                        h.b(a2);
                        JSONArray jSONArray = new JSONObject(a2).getJSONArray("not_available_item_ids");
                        if (jSONArray != null && jSONArray.length() > 0) {
                            this.h = new String[jSONArray.length()];
                            for (int i3 = 0; i3 < this.h.length; i3++) {
                                this.h[i3] = jSONArray.getJSONObject(i3).getString("item_id");
                            }
                        }
                        i2 = -2;
                    } else {
                        i2 = 0;
                    }
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                } catch (IOException e3) {
                    e3.printStackTrace();
                } catch (JSONException e4) {
                    e4.printStackTrace();
                    i2 = 3;
                }
            }
            return Integer.valueOf(i2);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Integer num) {
            int i2;
            Log.d("CheckWishListTask", "onPostExecute()+");
            String[] strArr = null;
            if (num != null) {
                i2 = num.intValue();
                if (i2 == -2) {
                    strArr = this.h;
                }
            } else {
                i2 = 0;
            }
            if (this.i != null) {
                this.i.a(i2, strArr);
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            Log.e("CheckWishListTask", "onCancelled()+");
            if (this.i != null) {
                this.i.a(-1, (Object) null);
            }
        }

        public void a() {
            Log.d("CheckWishListTask", "stopTask()+");
            if (getStatus() != AsyncTask.Status.FINISHED) {
                cancel(true);
            }
        }
    }

    public static g a(int i, f fVar) {
        g gVar = new g(i, fVar);
        gVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return gVar;
    }

    /* compiled from: NetworkManager */
    public static class g extends AsyncTask<Void, Void, Integer> {

        /* renamed from: a  reason: collision with root package name */
        private final String f1143a = "ProductItemTask";

        /* renamed from: b  reason: collision with root package name */
        private final String f1144b = "%s/item/%s?account_uuid=%s";
        private final String c = "%s/item/%s";
        private final String d = "results";
        private final String e = "id";
        private final String f = "purchase_url";
        private final int g;
        private String h;
        private f i;

        public g(int i2, f fVar) {
            this.g = i2;
            this.i = fVar;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            Log.d("ProductItemTask", "onPreExecute()+");
            if (this.i != null) {
                this.i.a();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Integer doInBackground(Void... voidArr) {
            String str;
            Log.d("ProductItemTask", "doInBackground()+");
            e eVar = new e();
            int i2 = 3;
            try {
                int i3 = 0;
                if (h.f1164b.t != null) {
                    str = String.format("%s/item/%s?account_uuid=%s", new Object[]{h.f1164b.n, String.valueOf(this.g), h.f1164b.t});
                } else {
                    str = String.format("%s/item/%s", new Object[]{h.f1164b.n, String.valueOf(this.g)});
                }
                String a2 = eVar.a(str, "GET", (HashMap<String, String>) null);
                if (a2 != null) {
                    h.b(a2);
                    JSONArray jSONArray = new JSONObject(a2).getJSONArray("results");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        JSONObject jSONObject = jSONArray.getJSONObject(0);
                        if (jSONObject != null && this.g == jSONObject.getInt("id")) {
                            this.h = jSONObject.getString("purchase_url");
                            i3 = -2;
                        }
                        i2 = i3;
                    }
                } else {
                    i2 = 0;
                }
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                i2 = 2;
            } catch (IOException e3) {
                e3.printStackTrace();
                i2 = 2;
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            return Integer.valueOf(i2);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Integer num) {
            int i2;
            Log.d("ProductItemTask", "onPostExecute()+");
            String str = null;
            if (num != null) {
                i2 = num.intValue();
                if (i2 == -2) {
                    str = this.h;
                }
            } else {
                i2 = 0;
            }
            if (this.i != null) {
                this.i.a(i2, str);
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            Log.e("ProductItemTask", "onCancelled()+");
            if (this.i != null) {
                this.i.a(-1, (Object) null);
            }
        }

        public void a() {
            Log.d("ProductItemTask", "stopTask()+");
            if (getStatus() != AsyncTask.Status.FINISHED) {
                cancel(true);
            }
        }
    }

    /* compiled from: NetworkManager */
    public static class a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        private c f1117a;

        /* renamed from: b  reason: collision with root package name */
        private f f1118b;

        /* renamed from: net.fxgear.fitnshop.e.d$a$a  reason: collision with other inner class name */
        /* compiled from: NetworkManager */
        public static class C0036a {

            /* renamed from: a  reason: collision with root package name */
            public final b[] f1119a;

            /* renamed from: b  reason: collision with root package name */
            private final String f1120b = "datas";
            private final String c = "adv_list";
            private final String d = "item";

            public C0036a(String str) throws JSONException {
                if (str != null) {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("datas")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("datas");
                        if (jSONObject2.has("adv_list")) {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject("adv_list");
                            if (jSONObject3.has("item")) {
                                JSONArray jSONArray = jSONObject3.getJSONArray("item");
                                this.f1119a = new b[jSONArray.length()];
                                for (int i = 0; i < this.f1119a.length; i++) {
                                    this.f1119a[i] = new b(jSONArray.getJSONObject(i));
                                }
                                return;
                            }
                            throw new JSONException("ERROR :: Wrong response data, not found item");
                        }
                        throw new JSONException("ERROR :: Wrong response data, not found datas");
                    }
                    throw new JSONException("ERROR :: Wrong response data, not found datas");
                }
                throw new JSONException("ERROR :: Wrong response data, param is null");
            }
        }

        /* compiled from: NetworkManager */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public final String f1121a;

            /* renamed from: b  reason: collision with root package name */
            public final String f1122b;
            public final String c;
            private final String d = "image";
            private final String e = "type";
            private final String f = "data";

            public b(JSONObject jSONObject) throws JSONException {
                if (jSONObject != null) {
                    this.f1121a = jSONObject.getString("image");
                    this.f1122b = jSONObject.getString("type");
                    this.c = jSONObject.getString("data");
                    return;
                }
                throw new JSONException("ERROR :: Wrong response data, param is null");
            }
        }

        /* compiled from: NetworkManager */
        public class c {

            /* renamed from: a  reason: collision with root package name */
            public int f1123a = 0;

            /* renamed from: b  reason: collision with root package name */
            public C0036a f1124b;

            public c() {
            }
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            Log.d("BannerInfoTask", "onPreExecute()+");
            if (this.f1118b != null) {
                this.f1118b.a();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            Log.d("BannerInfoTask", "doInBackground()+");
            try {
                String a2 = new e().a(String.format("%s/mobile/adv_list", new Object[]{h.f1164b.n}), "GET", (HashMap<String, String>) null);
                if (a2 != null) {
                    h.b(a2);
                    this.f1117a.f1124b = new C0036a(a2);
                    this.f1117a.f1123a = -2;
                } else {
                    this.f1117a.f1123a = 3;
                }
            } catch (IllegalArgumentException e) {
                this.f1117a.f1123a = 2;
                e.printStackTrace();
            } catch (IOException e2) {
                this.f1117a.f1123a = 2;
                e2.printStackTrace();
            } catch (JSONException e3) {
                this.f1117a.f1123a = 3;
                e3.printStackTrace();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            Log.d("BannerInfoTask", "onPostExecute()+");
            c cVar = new c();
            cVar.f1123a = this.f1117a.f1123a;
            if (cVar.f1123a == -2) {
                cVar.f1124b = this.f1117a.f1124b;
            }
            this.f1117a = null;
            if (this.f1118b != null) {
                this.f1118b.a(cVar.f1123a, cVar);
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            Log.e("BannerInfoTask", "onCancelled()+");
            this.f1117a = null;
            if (this.f1118b != null) {
                this.f1118b.a(-1, (Object) null);
            }
        }

        public static C0036a a() throws IllegalArgumentException, IOException, JSONException {
            String a2 = new e().a(String.format("%s/mobile/adv_list", new Object[]{h.f1164b.n}), "GET", (HashMap<String, String>) null);
            if (a2 != null) {
                h.b(a2);
                return new C0036a(a2);
            }
            throw new JSONException("ERROR :: Wrong response data.");
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\e\e.java ==========

package net.fxgear.fitnshop.e;

import android.os.Looper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* compiled from: RequestMessenger */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static int f1147a = 10000;

    /* renamed from: b  reason: collision with root package name */
    private static int f1148b = 10000;
    private final String c = "UTF-8";
    private final String d = "http";
    private final String e = "https";
    private HttpURLConnection f;
    private BufferedReader g;
    private final HostnameVerifier h = new HostnameVerifier() {
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    };

    public String a(String str, String str2, HashMap<String, String> hashMap) throws IOException, IllegalArgumentException {
        InputStreamReader inputStreamReader;
        String readLine;
        URL url = new URL(str);
        if (url.getProtocol().toLowerCase().equals("https")) {
            c();
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setHostnameVerifier(this.h);
            this.f = httpsURLConnection;
        } else {
            this.f = (HttpURLConnection) url.openConnection();
        }
        this.f.setRequestMethod(str2);
        this.f.setReadTimeout(f1148b);
        this.f.setConnectTimeout(f1147a);
        this.f.setUseCaches(false);
        this.f.setDoInput(true);
        if (str2 != null && str2.equals("POST")) {
            this.f.setDoOutput(true);
            OutputStream outputStream = this.f.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            if (hashMap != null) {
                String a2 = a(hashMap);
                if (a2 != null) {
                    bufferedWriter.write(a2);
                } else {
                    throw new IllegalArgumentException("ERROR :: urlQuery is null.");
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
        }
        this.f.connect();
        StringBuilder sb = new StringBuilder();
        if (this.f.getResponseCode() == 200) {
            inputStreamReader = new InputStreamReader(this.f.getInputStream());
        } else {
            inputStreamReader = new InputStreamReader(this.f.getErrorStream());
        }
        this.g = new BufferedReader(inputStreamReader);
        while (this.g != null && (readLine = this.g.readLine()) != null) {
            sb.append(readLine + 10);
        }
        if (this.g != null) {
            this.g.close();
            this.g = null;
        }
        inputStreamReader.close();
        this.f.disconnect();
        this.f = null;
        return sb.toString();
    }

    public void a() {
        if (this.f == null) {
            return;
        }
        if (Looper.getMainLooper().getThread().equals(Thread.currentThread())) {
            new Thread(new Runnable() {
                public void run() {
                    e.this.b();
                }
            }).start();
        } else {
            b();
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        if (this.g != null) {
            try {
                this.g.close();
                this.g = null;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        if (this.f != null) {
            this.f.disconnect();
        }
    }

    private void c() {
        TrustManager[] trustManagerArr = {new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String a(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String next : hashMap.keySet()) {
            String str = hashMap.get(next);
            if (sb.length() > 0) {
                sb.append("&");
            }
            try {
                sb.append(URLEncoder.encode(next, "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(str, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return sb.toString();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fitnshop\e\f.java ==========

package net.fxgear.fitnshop.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import java.io.IOException;
import java.util.HashMap;
import net.fxgear.fitnshop.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Statistics */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1152a = "f";

    public static void a(String str, String str2) {
        if (h.f1164b.v != null) {
            final long a2 = a();
            final String str3 = h.f1164b.v;
            final String str4 = str;
            final String str5 = str2;
            new Thread(new Runnable() {
                public void run() {
                    f.b(str4, str5, str3, a2);
                }
            }).start();
        }
    }

    public static void a(final Context context, final String str) {
        if (context != null) {
            final long a2 = a();
            new Thread(new Runnable() {
                public void run() {
                    f.b(context, str, a2);
                }
            }).start();
            return;
        }
        Log.e(f1152a, "SendAsyncDeviceData(), ERROR :: context is null.");
    }

    private static long a() {
        return System.currentTimeMillis() / 1000;
    }

    /* access modifiers changed from: private */
    public static void b(String str, String str2, String str3, long j) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("data", c(str, str2, str3, j));
            e eVar = new e();
            eVar.a(h.f1164b.o + "log/setLogData", "POST", hashMap);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    private static String c(String str, String str2, String str3, long j) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("key", str);
        jSONObject2.put("value", str2);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject2);
        jSONObject.put("log", jSONArray);
        jSONObject.put("version", 1);
        jSONObject.put("sid", str3);
        jSONObject.put("unixtime", j);
        return jSONObject.toString();
    }

    /* access modifiers changed from: private */
    public static void b(Context context, String str, long j) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            HashMap hashMap = new HashMap();
            hashMap.put("data", a(context, str, j, displayMetrics.widthPixels, displayMetrics.heightPixels));
            e eVar = new e();
            String a2 = eVar.a(h.f1164b.o + "log/setDeviceData", "POST", hashMap);
            if (a2 != null) {
                JSONObject jSONObject = new JSONObject(a2);
                if (jSONObject.has("sid")) {
                    h.f1164b.a(jSONObject.getString("sid"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    private static String a(Context context, String str, long j, int i, int i2) throws JSONException, PackageManager.NameNotFoundException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("os", "android");
        jSONObject.put("os_version", Build.VERSION.RELEASE);
        jSONObject.put("service", "app");
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        jSONObject.put("package", packageInfo.packageName);
        jSONObject.put("package_version", packageInfo.versionName);
        if (str == null) {
            str = "";
        }
        jSONObject.put("device_uuid", str);
        String str2 = Build.MODEL;
        if (str2 == null) {
            str2 = "";
        }
        jSONObject.put("device_model", str2);
        String a2 = a(context);
        if (a2 == null) {
            a2 = "";
        }
        jSONObject.put("net_provider", a2);
        jSONObject.put("unixtime", j);
        jSONObject.put("screen_width", i);
        jSONObject.put("screen_height", i2);
        return jSONObject.toString();
    }

    private static String a(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
    }
}


