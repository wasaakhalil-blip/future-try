

// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\a.java ==========

package net.fxgear.fittingmodenative;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import net.fxgear.AvatarData;
import net.fxgear.AvatarSetting;
import net.fxgear.BodySizeData;
import net.fxgear.FittingView;
import net.fxgear.GlobalDefine;
import net.fxgear.fittingview.FittingSurfaceView;
import net.fxgear.fittingview.data.FittingFaceData;
import net.fxgear.util.FXDataManager;
import net.fxgear.util.FXUtil;

/* compiled from: BaseFittingActivity */
public abstract class a extends Activity implements FittingView.OnFittingViewListener, FittingSurfaceView.IFittingSurfaceViewEventListener {
    private final String BACK_UP_FILE_SUFFFIX = "_backup";
    private final String TAG = a.class.getSimpleName();
    protected FittingView mFittingView;
    private FittingView.OnFittingViewListener mFittingViewListener;

    public void OnBodySlide(boolean z) {
    }

    public void OnDoubleClick() {
    }

    public void OnOneClick() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Log.i(this.TAG, "onCreate()+");
        super.onCreate(bundle);
        this.mFittingViewListener = this;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        Log.i(this.TAG, "onResume()+");
        if (this.mFittingView != null) {
            this.mFittingView.onResume();
        }
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        Log.i(this.TAG, "onPause()+");
        if (this.mFittingView != null) {
            this.mFittingView.onPause();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Log.i(this.TAG, "onDestroy()+");
        if (this.mFittingView != null) {
            this.mFittingView.onDestroy();
            this.mFittingView = null;
        }
        if (this.mFittingViewListener != null) {
            this.mFittingViewListener = null;
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public View GetFittingView() {
        if (this.mFittingView == null) {
            this.mFittingView = new FittingView(this, this.mFittingViewListener);
            this.mFittingView.SetIFittingSurfaceViewEventListener(this);
        }
        return this.mFittingView;
    }

    /* access modifiers changed from: protected */
    public boolean SetBackgroundBGBitmap(Bitmap bitmap) {
        if (this.mFittingView != null) {
            return this.mFittingView.SetBackgroundBGBitmap(bitmap);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean InitFittingView(int i, int i2, int i3, int i4, int i5, FittingView.ClothesFileInfo[] clothesFileInfoArr, Runnable runnable) {
        int i6 = i2;
        int i7 = i3;
        if (this.mFittingView == null) {
            FXUtil.OccurRunTimeException("ERROR :: illegal state error - fittingView is null.");
        } else if (!this.mFittingView.IsWorkingRenderer()) {
            FittingView.RealVideoFileInfo h = e.a((Context) this).h(i4);
            AvatarData GetAvatarData = FXDataManager.GetInstance(this).GetAvatarData(i5);
            int GetIndexOfHeadType = AvatarSetting.GetIndexOfHeadType(this, GetAvatarData.mHeadType, i6, i7);
            int GetIndexOfHairType = AvatarSetting.GetIndexOfHairType(this, GetAvatarData.mHairType, i6, i7);
            if (GetAvatarData.mIsCustomFace && !GlobalDefine.CopyDirectory(this, GlobalDefine.GetAvatarDataDirectory(this, i6, i7, GetAvatarData.mFolderName).getAbsolutePath(), GlobalDefine.GetAvatarRuntimeDirectory(this).getAbsolutePath())) {
                GetAvatarData.mIsCustomFace = false;
            }
            return this.mFittingView.Initialize(i, i2, i3, GetIndexOfHeadType, GetIndexOfHairType, h, i5, GetAvatarData.mIsCustomFace, clothesFileInfoArr, GetAvatarData.mBodyData, GetAvatarData.mHueRGBColor, GetAvatarData.mAutoNormalizedColor, this.mFittingViewListener, runnable);
        } else {
            Log.d(this.TAG, "FittingView working.");
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean IsWorkingFittingView() {
        if (this.mFittingView != null) {
            return this.mFittingView.IsWorkingRenderer();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public int GetCurrentMode() {
        if (this.mFittingView != null) {
            return this.mFittingView.GetCurrentMode();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public boolean SetMode(int i, Runnable runnable) {
        String str = this.TAG;
        Log.d(str, "SetMode()+, mode : " + i);
        if (this.mFittingView == null) {
            Log.e(this.TAG, "WARNING :: fittingView was destroy.");
            return false;
        } else if (i != this.mFittingView.GetCurrentMode()) {
            return this.mFittingView.SetMode(i, this.mFittingViewListener, runnable);
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean SetModeAndCharacter(int i, int i2, int i3, int i4, int i5, FittingView.ClothesFileInfo[] clothesFileInfoArr, Runnable runnable) {
        int i6 = i2;
        int i7 = i3;
        Log.d(this.TAG, "SetModeAndCharacter()+");
        if (this.mFittingView == null) {
            Log.e(this.TAG, "WARNING :: fittingView was destroy.");
        } else if (!this.mFittingView.IsWorkingRenderer()) {
            FittingView.RealVideoFileInfo h = e.a((Context) this).h(i4);
            AvatarData GetAvatarData = FXDataManager.GetInstance(this).GetAvatarData(i5);
            int GetIndexOfHeadType = AvatarSetting.GetIndexOfHeadType(this, GetAvatarData.mHeadType, i6, i7);
            int GetIndexOfHairType = AvatarSetting.GetIndexOfHairType(this, GetAvatarData.mHairType, i6, i7);
            if (GetAvatarData.mIsCustomFace && !GlobalDefine.CopyDirectory(this, GlobalDefine.GetAvatarDataDirectory(this, i6, i7, GetAvatarData.mFolderName).getAbsolutePath(), GlobalDefine.GetAvatarRuntimeDirectory(this).getAbsolutePath())) {
                GetAvatarData.mIsCustomFace = false;
            }
            return this.mFittingView.SetModeAndCharacter(i, i2, i3, GetIndexOfHeadType, GetIndexOfHairType, h, i5, GetAvatarData.mIsCustomFace, clothesFileInfoArr, GetAvatarData.mBodyData, GetAvatarData.mHueRGBColor, GetAvatarData.mAutoNormalizedColor, this.mFittingViewListener, runnable);
        } else {
            Log.d(this.TAG, "FittingView working.");
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public int GetCurrentGender() {
        if (this.mFittingView != null) {
            return this.mFittingView.GetCurrentGender();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public boolean SetCharacter(int i, int i2, int i3, int i4, FittingView.ClothesFileInfo[] clothesFileInfoArr, Runnable runnable) {
        int i5 = i;
        int i6 = i2;
        String str = this.TAG;
        Log.d(str, "SetCharacter()+, gender : " + i5);
        if (this.mFittingView == null) {
            Log.e(this.TAG, "WARNING :: fittingView was destroy.");
        } else if (this.mFittingView.IsWorkingRenderer()) {
            Log.d(this.TAG, "FittingView working.");
        } else if (!(i5 == this.mFittingView.GetCurrentGender() && i6 == this.mFittingView.GetCurrentAge())) {
            FittingView.RealVideoFileInfo h = e.a((Context) this).h(i3);
            AvatarData GetAvatarData = FXDataManager.GetInstance(this).GetAvatarData(i4);
            int GetIndexOfHeadType = AvatarSetting.GetIndexOfHeadType(this, GetAvatarData.mHeadType, i5, i6);
            int GetIndexOfHairType = AvatarSetting.GetIndexOfHairType(this, GetAvatarData.mHairType, i5, i6);
            if (GetAvatarData.mIsCustomFace && !GlobalDefine.CopyDirectory(this, GlobalDefine.GetAvatarDataDirectory(this, i5, i6, GetAvatarData.mFolderName).getAbsolutePath(), GlobalDefine.GetAvatarRuntimeDirectory(this).getAbsolutePath())) {
                GetAvatarData.mIsCustomFace = false;
            }
            FittingView fittingView = this.mFittingView;
            boolean z = GetAvatarData.mIsCustomFace;
            return fittingView.SetCharacter(i, i2, GetIndexOfHeadType, GetIndexOfHairType, h, i4, z, clothesFileInfoArr, GetAvatarData.mBodyData, GetAvatarData.mHueRGBColor, GetAvatarData.mAutoNormalizedColor, this.mFittingViewListener, runnable);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean ResetCamera(Runnable runnable) {
        if (this.mFittingView != null) {
            return this.mFittingView.ResetCamera(this.mFittingViewListener, runnable);
        }
        Log.e(this.TAG, "WARNING :: fittingView was destroy.");
        return false;
    }

    /* access modifiers changed from: protected */
    public int GetCurrentAge() {
        Log.d(this.TAG, "GetCurrentAge()+");
        if (this.mFittingView != null) {
            return this.mFittingView.GetCurrentAge();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public int GetCurrentHeadTypeIndex() {
        Log.d(this.TAG, "GetCurrentHeadTypeIndex()+");
        if (this.mFittingView != null) {
            return this.mFittingView.GetCurrentHeadTypeIndex();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public int GetCurrentHairTypeIndex() {
        Log.d(this.TAG, "GetCurrentHairTypeIndex()+");
        if (this.mFittingView != null) {
            return this.mFittingView.GetCurrentHairTypeIndex();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public boolean RemoveClothItem(int i) {
        Log.d(this.TAG, "RemoveClothItem()+");
        e a2 = e.a((Context) this);
        FittingView.ClothesFileInfo e = a2.e(i);
        if (e == null) {
            return false;
        }
        File parentFile = new File(e.mPackageFilePath).getParentFile();
        if (parentFile.exists()) {
            FXUtil.DeleteDirectoryRecursive(parentFile);
        }
        return a2.a(i);
    }

    /* access modifiers changed from: protected */
    public void SetClothesSize(HashMap<Integer, GlobalDefine.ClothesSize> hashMap, Runnable runnable) {
        Log.d(this.TAG, "SetClothesSize()+");
        if (this.mFittingView != null) {
            this.mFittingView.SetClothesSize(hashMap, this.mFittingViewListener, runnable);
        } else {
            Log.e(this.TAG, "WARNING :: fittingView was destroy.");
        }
    }

    /* access modifiers changed from: protected */
    public boolean SetClothes(FittingView.ClothesFileInfo clothesFileInfo, Runnable runnable) {
        Log.d(this.TAG, "SetClothes()+");
        if (this.mFittingView != null) {
            return this.mFittingView.SetClothes(clothesFileInfo, this.mFittingViewListener, runnable);
        }
        Log.e(this.TAG, "WARNING :: fittingView was destroy.");
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean SetClothes(FittingView.ClothesFileInfo clothesFileInfo, GlobalDefine.ClothesSize clothesSize, Runnable runnable) {
        Log.d(this.TAG, "SetClothes()+");
        if (this.mFittingView != null) {
            return this.mFittingView.SetClothes(clothesFileInfo, clothesSize, this.mFittingViewListener, runnable);
        }
        Log.e(this.TAG, "WARNING :: fittingView was destroy.");
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean SetClothes(FittingView.ClothesFileInfo[] clothesFileInfoArr, Runnable runnable) {
        Log.d(this.TAG, "SetClothes()+");
        if (this.mFittingView != null) {
            return this.mFittingView.SetClothes(clothesFileInfoArr, this.mFittingViewListener, runnable);
        }
        Log.e(this.TAG, "WARNING :: fittingView was destroy.");
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean SetClothes(FittingView.ClothesFileInfo[] clothesFileInfoArr, GlobalDefine.ClothesSize[] clothesSizeArr, Runnable runnable) {
        Log.d(this.TAG, "SetClothes()+");
        if (this.mFittingView != null) {
            return this.mFittingView.SetClothes(clothesFileInfoArr, clothesSizeArr, this.mFittingViewListener, runnable);
        }
        Log.e(this.TAG, "WARNING :: fittingView was destroy.");
        return false;
    }

    /* access modifiers changed from: protected */
    public BodySizeData GetCurrentBodySizeAll() {
        if (this.mFittingView != null) {
            return this.mFittingView.GetCurrentBodySizeAll();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean SetBodySize(int i, float f, boolean z, Runnable runnable) {
        Log.d(this.TAG, "SetBodySize()+");
        if (this.mFittingView == null) {
            return false;
        }
        return this.mFittingView.SetBodySize(i, f, z, this.mFittingViewListener, runnable);
    }

    /* access modifiers changed from: protected */
    public boolean SetBodySizeAll(BodySizeData bodySizeData, Runnable runnable) {
        Log.d(this.TAG, "SetBodySizeAll()+");
        if (this.mFittingView != null) {
            return this.mFittingView.SetBodySizeAll(bodySizeData, this.mFittingViewListener, runnable);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public double GetCurrentBodyThresHoldMaxValue(int i) {
        if (this.mFittingView != null) {
            return this.mFittingView.GetCurrentBodyThresHoldMaxValue(i);
        }
        return (double) AvatarSetting.NO_VALUE;
    }

    /* access modifiers changed from: protected */
    public double GetCurrentBodyThresHoldMinValue(int i) {
        if (this.mFittingView != null) {
            return this.mFittingView.GetCurrentBodyThresHoldMinValue(i);
        }
        return (double) AvatarSetting.NO_VALUE;
    }

    /* access modifiers changed from: protected */
    public boolean SetAvatarModeAndWholeHead(int i, int i2, int i3, boolean z, Runnable runnable) {
        if (this.mFittingView == null) {
            return false;
        }
        this.mFittingView.SetAvatarModeAndWholeHead(i, i2, i3, z, this.mFittingViewListener, runnable);
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean SetAvatarHairType(int i, Runnable runnable) {
        if (this.mFittingView != null) {
            return this.mFittingView.SetAvatarHairType(i, this.mFittingViewListener, runnable);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean SetAvatarHairTypeWithChangeAvatarMode(int i, int i2, Runnable runnable) {
        if (this.mFittingView != null) {
            return this.mFittingView.SetAvatarHairTypeWithSetAvatarMode(i, i2, this.mFittingViewListener, runnable);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean SetBodySizeAllWithChangeAvatarMode(int i, BodySizeData bodySizeData, Runnable runnable) {
        if (this.mFittingView != null) {
            return this.mFittingView.SetBodySizeAllWithSetAvatarMode(i, bodySizeData, this.mFittingViewListener, runnable);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean SetAvatarHeadType(int i, boolean z, Runnable runnable) {
        if (this.mFittingView != null) {
            return this.mFittingView.SetAvatarHeadType(i, z, this.mFittingViewListener, runnable);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean SetAvatarHeadTypeWithChangeAvatarMode(int i, int i2, boolean z, Runnable runnable) {
        if (this.mFittingView == null) {
            return false;
        }
        return this.mFittingView.SetAvatarHeadTypeWithSetAvatarMode(i, i2, z, this.mFittingViewListener, runnable);
    }

    /* access modifiers changed from: protected */
    public boolean CreateCustomFaceData(File file, int[] iArr, Runnable runnable) {
        if (this.mFittingView != null) {
            return this.mFittingView.CreateCustomfaceData(file, iArr, this.mFittingViewListener, runnable);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean SetDefaultAvatarFace(int i, Runnable runnable) {
        if (this.mFittingView != null) {
            return this.mFittingView.SetDefaultAvatarFace(i, this.mFittingViewListener, runnable);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean SetAvatarSkinAuto(float f, boolean z, Runnable runnable) {
        if (this.mFittingView != null) {
            return this.mFittingView.SetAvatarSkinAuto(f, z, this.mFittingViewListener, runnable);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean SetAvatarSkinTone(float f, boolean z, Runnable runnable) {
        if (this.mFittingView != null) {
            return this.mFittingView.SetAvatarSkinTone(f, z, this.mFittingViewListener, runnable);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean SetAvatarSkinToneWithAuto(float f, float f2, boolean z, Runnable runnable) {
        if (this.mFittingView == null) {
            return false;
        }
        return this.mFittingView.SetAvatarSkinToneWithAuto(f, f2, z, this.mFittingViewListener, runnable);
    }

    /* access modifiers changed from: protected */
    public boolean SetAvatarSkinToneWithChangeAvatarMode(int i, float f, float f2, Runnable runnable) {
        if (this.mFittingView == null) {
            return false;
        }
        return this.mFittingView.SetAvatarSkinToneWithChangeAvatarMode(i, f, f2, this.mFittingViewListener, runnable);
    }

    public synchronized boolean SetAvatarHeadTypeWithSkinValue(int i, boolean z, float f, float f2, Runnable runnable) {
        if (this.mFittingView == null) {
            return false;
        }
        return this.mFittingView.SetAvatarHeadTypeWithSkinValue(i, z, f, f2, this.mFittingViewListener, runnable);
    }

    private File FindCustomFaceMeshFile(String[] strArr, int i) {
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

    /* access modifiers changed from: protected */
    public boolean HasCustomFaceData(int i, int i2) {
        File GetAvatarRuntimeDirectory = GlobalDefine.GetAvatarRuntimeDirectory(this);
        if (!GetAvatarRuntimeDirectory.exists() || !GetAvatarRuntimeDirectory.isDirectory()) {
            Log.w(this.TAG, "[WARNING] :: Not found avatar runtime directory.");
        } else {
            String[] GetCustomFaceFile = FittingFaceData.GetCustomFaceFile(GetAvatarRuntimeDirectory.getAbsolutePath());
            if (GetCustomFaceFile == null || GetCustomFaceFile.length <= 0) {
                Log.w(this.TAG, "[WARNING] :: Not found custom face files.");
            } else {
                String str = GetCustomFaceFile[3];
                if (str != null) {
                    File file = new File(str);
                    if (!file.exists() || !file.isFile()) {
                        Log.e(this.TAG, "[ERROR] :: Not found custom texture file.");
                        return false;
                    }
                    int GetHeadTypeCount = AvatarSetting.GetHeadTypeCount(this, i, i2);
                    int i3 = 0;
                    while (i3 < GetHeadTypeCount) {
                        int i4 = AvatarSetting.GetHeadTypeInfoByIndex(this, i3, i, i2).mTypeID;
                        File FindCustomFaceMeshFile = FindCustomFaceMeshFile(GetCustomFaceFile, i4);
                        if (FindCustomFaceMeshFile == null) {
                            String str2 = this.TAG;
                            Log.e(str2, "[ERROR] :: Custom mesh file path is null.(type : " + i4 + ")");
                            return false;
                        } else if (!FindCustomFaceMeshFile.exists() || !FindCustomFaceMeshFile.isFile()) {
                            String str3 = this.TAG;
                            Log.e(str3, "[ERROR] :: Not found custom mesh file.(type : " + i4 + ")");
                            return false;
                        } else {
                            i3++;
                        }
                    }
                    return true;
                }
                Log.e(this.TAG, "[ERROR] :: Custom texture file path is null.");
                return false;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void ClearCustomFaceFiles() {
        File GetAvatarRuntimeDirectory = GlobalDefine.GetAvatarRuntimeDirectory(this);
        if (!GetAvatarRuntimeDirectory.exists() || !GetAvatarRuntimeDirectory.isDirectory()) {
            Log.w(this.TAG, "[WARNING] :: Not found avatar runtime directory.");
            return;
        }
        String[] GetCustomFaceFile = FittingFaceData.GetCustomFaceFile(GetAvatarRuntimeDirectory.getAbsolutePath());
        if (GetCustomFaceFile == null || GetCustomFaceFile.length <= 0) {
            Log.w(this.TAG, "[WARNING] :: Not found custom face files.");
            return;
        }
        for (String str : GetCustomFaceFile) {
            if (str != null) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean BackupCurrentCustomFaceData(Context context, String str) {
        Log.i(this.TAG, "BackupCurrentCustomFaceData()+, uuid: " + str);
        if (str == null || str.length() <= 0) {
            Log.e(this.TAG, "[ERROR] :: uuid is null");
            return false;
        }
        File GetAvatarRuntimeDirectory = GlobalDefine.GetAvatarRuntimeDirectory(this);
        File file = new File(new File(GetAvatarRuntimeDirectory.getAbsolutePath(), GlobalDefine.DIRECTORY_NAME_TEMP).getAbsolutePath(), str);
        if (file.exists()) {
            GlobalDefine.DeleteDirectoryRecursive(file.getAbsolutePath());
        }
        file.mkdirs();
        String[] GetCustomFaceFile = FittingFaceData.GetCustomFaceFile(GetAvatarRuntimeDirectory.getAbsolutePath());
        if (GetCustomFaceFile == null || GetCustomFaceFile.length <= 0) {
            Log.w(this.TAG, "[WARNING] :: Not found custom face files.");
            return false;
        }
        for (String str2 : GetCustomFaceFile) {
            if (str2 != null) {
                File file2 = new File(str2);
                try {
                    GlobalDefine.CopyFile(file2.getAbsolutePath(), new File(file, file2.getName()).getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean RestoreBackupCustomFaceData(Context context, String str) {
        String str2 = this.TAG;
        Log.i(str2, "RestoreBackupCustomFaceData()+, uuid: " + str);
        boolean z = false;
        if (str == null || str.length() <= 0) {
            Log.e(this.TAG, "[ERROR] :: uuid is null");
            return false;
        }
        File GetAvatarRuntimeDirectory = GlobalDefine.GetAvatarRuntimeDirectory(this);
        File file = new File(new File(GetAvatarRuntimeDirectory.getAbsolutePath(), GlobalDefine.DIRECTORY_NAME_TEMP).getAbsolutePath(), str);
        if (!file.exists()) {
            Log.i(this.TAG, "[ERROR] :: backup directory doesn't exist");
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            int length = listFiles.length;
            int i = 0;
            boolean z2 = false;
            while (i < length) {
                try {
                    String absolutePath = listFiles[i].getAbsolutePath();
                    z2 = GlobalDefine.CopyFile(absolutePath, GetAvatarRuntimeDirectory.getAbsolutePath() + File.separator + listFiles[i].getName());
                    i++;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            z = z2;
        }
        GlobalDefine.DeleteDirectoryRecursive(file.getAbsolutePath());
        return z;
    }

    /* access modifiers changed from: protected */
    public boolean HasBackupCustomFaceData(Context context) {
        Log.i(this.TAG, "HasBackupCustomFaceData()+");
        return new File(GlobalDefine.GetAvatarRuntimeDirectory(context).getAbsolutePath(), GlobalDefine.DIRECTORY_NAME_TEMP).exists();
    }

    /* access modifiers changed from: protected */
    public boolean HasBackupCustomFaceData(Context context, String str) {
        String str2 = this.TAG;
        Log.i(str2, "HasBackupCustomFaceData()+, uuid: " + str);
        if (str != null && str.length() > 0) {
            return new File(new File(GlobalDefine.GetAvatarRuntimeDirectory(context).getAbsolutePath(), GlobalDefine.DIRECTORY_NAME_TEMP).getAbsolutePath(), str).exists();
        }
        Log.e(this.TAG, "[ERROR] :: uuid is null");
        return false;
    }

    /* access modifiers changed from: protected */
    public String GetRuntimeCustomFaceDataUUID(int i, int i2) {
        String[] GetCustomFaceFile;
        String str;
        if (HasCustomFaceData(i, i2)) {
            File GetAvatarRuntimeDirectory = GlobalDefine.GetAvatarRuntimeDirectory(this);
            if (GetAvatarRuntimeDirectory.exists() && GetAvatarRuntimeDirectory.isDirectory() && (GetCustomFaceFile = FittingFaceData.GetCustomFaceFile(GetAvatarRuntimeDirectory.getAbsolutePath())) != null && GetCustomFaceFile.length > 0 && (str = GetCustomFaceFile[3]) != null) {
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    String substring = str.substring(str.lastIndexOf("_") + 1, str.lastIndexOf(FittingFaceData.FILE_EXTENSION_DOT));
                    String str2 = this.TAG;
                    Log.d(str2, "GetRuntimeCustomFaceDataUUID()-, uuid: " + substring);
                    return substring;
                }
            }
        }
        Log.d(this.TAG, "GetRuntimeCustomFaceDataUUID()-, uuid: null");
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean DeleteBackupCustomFaceData(Context context, String str) {
        String str2 = this.TAG;
        Log.i(str2, "DeleteBackupCustomFaceData()+, uuid: " + str);
        if (str == null || str.length() <= 0) {
            Log.e(this.TAG, "[ERROR] :: uuid is null");
            return false;
        }
        File file = new File(new File(GlobalDefine.GetAvatarRuntimeDirectory(context).getAbsolutePath(), GlobalDefine.DIRECTORY_NAME_TEMP).getAbsolutePath(), str);
        if (file.exists()) {
            return GlobalDefine.DeleteDirectoryRecursive(file.getAbsolutePath());
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean DeleteAllBackupCustomFaceData(Context context) {
        File file = new File(GlobalDefine.GetAvatarRuntimeDirectory(context).getAbsolutePath(), GlobalDefine.DIRECTORY_NAME_TEMP);
        if (file.exists()) {
            return GlobalDefine.DeleteDirectoryRecursive(file.getAbsolutePath());
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean GetScreenShot(boolean z, boolean z2, boolean z3, Runnable runnable) {
        return GetScreenShot(GlobalDefine.THUMBNAIL_WIDTH, GlobalDefine.THUMBNAIL_HEIGHT, z, z2, z3, runnable);
    }

    private boolean GetScreenShot(int i, int i2, boolean z, boolean z2, boolean z3, Runnable runnable) {
        if (this.mFittingView == null) {
            return false;
        }
        return this.mFittingView.GetScreenShot(i <= 0 ? GlobalDefine.THUMBNAIL_WIDTH : i, i2 <= 0 ? GlobalDefine.THUMBNAIL_HEIGHT : i2, z, z2, z3, this.mFittingViewListener, runnable);
    }

    private boolean SaveAvatarThumbanilFile(int i) {
        Bitmap GetScreenShotImage = this.mFittingView.GetScreenShotImage();
        if (GetScreenShotImage == null) {
            return false;
        }
        File file = new File(FXDataManager.GetInstance(this).GetAvatarData(i).mThumbnailPath);
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                GetScreenShotImage.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                try {
                    fileOutputStream2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = fileOutputStream2;
                try {
                    e.printStackTrace();
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                fileOutputStream.close();
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            e.printStackTrace();
            fileOutputStream.close();
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean HasAvatarThumbnailFile(int i) {
        return new File(FXDataManager.GetInstance(this).GetAvatarData(i).mThumbnailPath).exists();
    }

    /* access modifiers changed from: protected */
    public void RemoveAvatarThumbnailFile(int i) {
        File file = new File(FXDataManager.GetInstance(this).GetAvatarData(i).mThumbnailPath);
        if (file.exists()) {
            file.delete();
        }
    }

    /* access modifiers changed from: protected */
    public boolean SaveAvatarThumbnailFileAndUpdateDB(AvatarData avatarData) {
        Log.i(this.TAG, "SaveAvatarThumbnailFileAndUpdateDB()+");
        boolean z = false;
        if (avatarData != null) {
            String str = null;
            File file = new File(avatarData.mThumbnailPath);
            if (file.exists()) {
                str = file.getAbsolutePath() + "_backup";
                file.renameTo(new File(str));
            }
            if (SaveAvatarThumbanilFile(avatarData.mAvatarID)) {
                z = FXDataManager.GetInstance(getApplicationContext()).UpdateAvatarData(avatarData);
            }
            if (!z) {
                Log.e(this.TAG, "[ERROR] :: failed to SaveAvatarThumbnailFileAndUpdateDB, Resotred thumbnail file");
                if (str != null) {
                    File file2 = new File(str);
                    if (file2.exists()) {
                        if (file.exists()) {
                            file.delete();
                        }
                        file2.renameTo(file);
                    }
                }
            } else if (str != null) {
                File file3 = new File(str);
                if (file3.exists()) {
                    file3.delete();
                }
            }
        } else {
            Log.e(this.TAG, "[ERROR] :: avataData is null");
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public boolean SaveAllAvatarDataFilesAndUpdateDB(AvatarData avatarData) {
        Log.i(this.TAG, "SaveAllAvatarDataFilesAndUpdateDB()+");
        boolean z = false;
        if (avatarData != null) {
            Context applicationContext = getApplicationContext();
            String absolutePath = GlobalDefine.GetAvatarDataDirectory(applicationContext, avatarData.mGender, avatarData.mAge, avatarData.mFolderName).getAbsolutePath();
            String absolutePath2 = GlobalDefine.GetAvatarRuntimeDirectory(applicationContext).getAbsolutePath();
            String str = null;
            File file = new File(absolutePath);
            if (file.exists()) {
                str = file.getAbsolutePath() + "_backup";
                file.renameTo(new File(str));
            }
            if (!GlobalDefine.CopyCustomFaceFiles(applicationContext, absolutePath2, absolutePath) || !SaveAvatarThumbanilFile(avatarData.mAvatarID)) {
                Log.e(this.TAG, "[ERROR] :: failed to copy custom face files or save avatar thumbnail");
            } else {
                z = FXDataManager.GetInstance(applicationContext).UpdateAvatarData(avatarData);
            }
            if (!z) {
                Log.e(this.TAG, "[ERROR] :: failed to SaveAvatarThumbnailFileAndUpdateDB, Resotred avataData file");
                if (str != null) {
                    File file2 = new File(str);
                    if (file2.exists()) {
                        if (file.exists()) {
                            GlobalDefine.DeleteDirectoryRecursive(file.getAbsolutePath());
                        }
                        file2.renameTo(file);
                    }
                }
            } else if (str != null) {
                File file3 = new File(str);
                if (file3.exists()) {
                    GlobalDefine.DeleteDirectoryRecursive(file3.getAbsolutePath());
                }
            }
        } else {
            Log.e(this.TAG, "[ERROR] :: avataData is null");
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public boolean ClearAllAvatarDataFilesAndUpdateDB(AvatarData avatarData) {
        Log.i(this.TAG, "ClearAllAvatarDataFilesAndUpdateDB()+");
        if (avatarData == null) {
            return false;
        }
        File file = new File(GlobalDefine.GetAvatarDataDirectory(this, avatarData.mGender, avatarData.mAge, avatarData.mFolderName).getAbsolutePath());
        if (!file.exists() || !file.isDirectory()) {
            Log.w(this.TAG, "[ERROR] :: Not found avatar data directory.");
        } else {
            String[] GetCustomFaceFile = FittingFaceData.GetCustomFaceFile(file.getAbsolutePath());
            if (GetCustomFaceFile == null || GetCustomFaceFile.length <= 0) {
                Log.w(this.TAG, "[ERROR] :: Not found custom face files.");
            } else {
                for (String str : GetCustomFaceFile) {
                    if (str != null) {
                        File file2 = new File(str);
                        if (file2.exists()) {
                            file2.delete();
                        }
                    }
                }
            }
        }
        if (SaveAvatarThumbanilFile(avatarData.mAvatarID)) {
            return FXDataManager.GetInstance(getApplicationContext()).UpdateAvatarData(avatarData);
        }
        return false;
    }

    public void OnStartAsyncWork() {
        Log.i(this.TAG, "OnStartAsyncWork()+");
    }

    public void OnFinishAsyncWork(Runnable runnable) {
        Log.i(this.TAG, "OnFinishAsyncWork()+");
    }

    public void OnResultCustomFace(GlobalDefine.Result result) {
        Log.i(this.TAG, "OnResultCustomFace()+");
    }

    public void OnOccurError(GlobalDefine.Result result) {
        Log.i(this.TAG, "OnOccurError()+");
    }

    public void OnClothChange(FittingView.ClothesFileInfo[] clothesFileInfoArr) {
        Log.i(this.TAG, "OnClothChange()+");
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\b.java ==========

package net.fxgear.fittingmodenative;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.nio.ByteBuffer;
import net.fxgear.AvatarData;
import net.fxgear.BodySizeData;
import net.fxgear.GlobalDefine;
import net.fxgear.util.FXDataManager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CharacterData */
public class b {
    private static final String l = "b";

    /* renamed from: a  reason: collision with root package name */
    int f1309a = -1;

    /* renamed from: b  reason: collision with root package name */
    int f1310b = -1;
    int c = -1;
    int d = -1;
    int e = 0;
    int f = 2;
    boolean g = false;
    float h = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    int i = -1;
    BodySizeData j = null;
    AvatarData k = null;

    /* compiled from: CharacterData */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        int f1311a;

        /* renamed from: b  reason: collision with root package name */
        long f1312b;
        private final int c;

        private a(int i, long j) {
            this.c = 256;
            this.f1311a = i;
            this.f1312b = j;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0042 A[SYNTHETIC, Splitter:B:22:0x0042] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x004d A[SYNTHETIC, Splitter:B:27:0x004d] */
        /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private a(java.io.File r4) {
            /*
                r3 = this;
                r3.<init>()
                r0 = 256(0x100, float:3.59E-43)
                r3.c = r0
                if (r4 == 0) goto L_0x0056
                boolean r1 = r4.exists()
                if (r1 == 0) goto L_0x0056
                boolean r1 = r4.isFile()
                if (r1 == 0) goto L_0x0056
                r1 = 0
                byte[] r0 = new byte[r0]
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x003c }
                r2.<init>(r4)     // Catch:{ Exception -> 0x003c }
                r2.read(r0)     // Catch:{ Exception -> 0x0036, all -> 0x0034 }
                java.nio.ByteBuffer r4 = java.nio.ByteBuffer.wrap(r0)     // Catch:{ Exception -> 0x0036, all -> 0x0034 }
                int r0 = r4.getInt()     // Catch:{ Exception -> 0x0036, all -> 0x0034 }
                r3.f1311a = r0     // Catch:{ Exception -> 0x0036, all -> 0x0034 }
                long r0 = r4.getLong()     // Catch:{ Exception -> 0x0036, all -> 0x0034 }
                r3.f1312b = r0     // Catch:{ Exception -> 0x0036, all -> 0x0034 }
                r2.close()     // Catch:{ IOException -> 0x0046 }
                goto L_0x0056
            L_0x0034:
                r4 = move-exception
                goto L_0x004b
            L_0x0036:
                r4 = move-exception
                r1 = r2
                goto L_0x003d
            L_0x0039:
                r4 = move-exception
                r2 = r1
                goto L_0x004b
            L_0x003c:
                r4 = move-exception
            L_0x003d:
                r4.printStackTrace()     // Catch:{ all -> 0x0039 }
                if (r1 == 0) goto L_0x0056
                r1.close()     // Catch:{ IOException -> 0x0046 }
                goto L_0x0056
            L_0x0046:
                r4 = move-exception
                r4.printStackTrace()
                goto L_0x0056
            L_0x004b:
                if (r2 == 0) goto L_0x0055
                r2.close()     // Catch:{ IOException -> 0x0051 }
                goto L_0x0055
            L_0x0051:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0055:
                throw r4
            L_0x0056:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.b.a.<init>(java.io.File):void");
        }

        /* access modifiers changed from: private */
        public byte[] a() {
            ByteBuffer allocate = ByteBuffer.allocate(256);
            allocate.putInt(this.f1311a);
            allocate.putLong(this.f1312b);
            return allocate.array();
        }
    }

    static int a(Context context, File file) {
        return new a(file).f1311a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0081, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0082, code lost:
        r2 = r6;
        r9 = r11;
        r11 = r10;
        r10 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0087, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a8, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a9, code lost:
        r11.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0087 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:14:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0097 A[SYNTHETIC, Splitter:B:38:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a4 A[SYNTHETIC, Splitter:B:45:0x00a4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static net.fxgear.fittingmodenative.b b(android.content.Context r10, java.io.File r11) {
        /*
            java.lang.String r0 = l
            java.lang.String r1 = "LoadFromFile()+"
            android.util.Log.d(r0, r1)
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 0
            if (r11 == 0) goto L_0x00bd
            boolean r3 = r11.exists()
            if (r3 == 0) goto L_0x00b5
            boolean r3 = r11.isFile()
            if (r3 == 0) goto L_0x00b5
            net.fxgear.fittingmodenative.b$a r3 = new net.fxgear.fittingmodenative.b$a
            r3.<init>((java.io.File) r11)
            int r4 = r3.f1311a
            r5 = 2
            if (r4 != r5) goto L_0x00ad
            long r4 = r3.f1312b
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x00ad
            long r4 = r3.f1312b
            int r4 = (int) r4
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocate(r4)
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0090 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0090 }
            r6.<init>(r11)     // Catch:{ Exception -> 0x0090 }
            r7 = 256(0x100, double:1.265E-321)
            r6.skip(r7)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
        L_0x0041:
            int r11 = r6.read(r5)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r7 = -1
            if (r11 == r7) goto L_0x004d
            r7 = 0
            r4.put(r5, r7, r11)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            goto L_0x0041
        L_0x004d:
            java.lang.String r11 = new java.lang.String     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            byte[] r4 = r4.array()     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r11.<init>(r4)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            int r3 = r3.f1311a     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            net.fxgear.fittingmodenative.b r10 = a(r10, r11, r3)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            java.lang.String r11 = l     // Catch:{ Exception -> 0x0081, all -> 0x0087 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0081, all -> 0x0087 }
            r2.<init>()     // Catch:{ Exception -> 0x0081, all -> 0x0087 }
            java.lang.String r3 = "[L] loading time : "
            r2.append(r3)     // Catch:{ Exception -> 0x0081, all -> 0x0087 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0081, all -> 0x0087 }
            r5 = 0
            long r3 = r3 - r0
            r2.append(r3)     // Catch:{ Exception -> 0x0081, all -> 0x0087 }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0081, all -> 0x0087 }
            android.util.Log.e(r11, r0)     // Catch:{ Exception -> 0x0081, all -> 0x0087 }
            r6.close()     // Catch:{ IOException -> 0x007c }
            goto L_0x00a0
        L_0x007c:
            r11 = move-exception
            r11.printStackTrace()
            goto L_0x00a0
        L_0x0081:
            r11 = move-exception
            r2 = r6
            r9 = r11
            r11 = r10
            r10 = r9
            goto L_0x0092
        L_0x0087:
            r10 = move-exception
            goto L_0x00a2
        L_0x0089:
            r10 = move-exception
            r11 = r2
            r2 = r6
            goto L_0x0092
        L_0x008d:
            r10 = move-exception
            r6 = r2
            goto L_0x00a2
        L_0x0090:
            r10 = move-exception
            r11 = r2
        L_0x0092:
            r10.printStackTrace()     // Catch:{ all -> 0x008d }
            if (r2 == 0) goto L_0x009f
            r2.close()     // Catch:{ IOException -> 0x009b }
            goto L_0x009f
        L_0x009b:
            r10 = move-exception
            r10.printStackTrace()
        L_0x009f:
            r10 = r11
        L_0x00a0:
            r2 = r10
            goto L_0x00c4
        L_0x00a2:
            if (r6 == 0) goto L_0x00ac
            r6.close()     // Catch:{ IOException -> 0x00a8 }
            goto L_0x00ac
        L_0x00a8:
            r11 = move-exception
            r11.printStackTrace()
        L_0x00ac:
            throw r10
        L_0x00ad:
            java.lang.String r10 = l
            java.lang.String r11 = "ERROR :: wrong file"
            android.util.Log.e(r10, r11)
            goto L_0x00c4
        L_0x00b5:
            java.lang.String r10 = l
            java.lang.String r11 = "ERROR :: not found file or wrong file"
            android.util.Log.e(r10, r11)
            goto L_0x00c4
        L_0x00bd:
            java.lang.String r10 = l
            java.lang.String r11 = "ERROR :: param error."
            android.util.Log.e(r10, r11)
        L_0x00c4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.b.b(android.content.Context, java.io.File):net.fxgear.fittingmodenative.b");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0081, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0082, code lost:
        r2 = r6;
        r9 = r11;
        r11 = r10;
        r10 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0087, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a8, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a9, code lost:
        r11.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0087 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:14:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0097 A[SYNTHETIC, Splitter:B:38:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a4 A[SYNTHETIC, Splitter:B:45:0x00a4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.fxgear.fittingmodenative.b c(android.content.Context r10, java.io.File r11) {
        /*
            java.lang.String r0 = l
            java.lang.String r1 = "LoadFromFile()+"
            android.util.Log.d(r0, r1)
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 0
            if (r11 == 0) goto L_0x00bd
            boolean r3 = r11.exists()
            if (r3 == 0) goto L_0x00b5
            boolean r3 = r11.isFile()
            if (r3 == 0) goto L_0x00b5
            net.fxgear.fittingmodenative.b$a r3 = new net.fxgear.fittingmodenative.b$a
            r3.<init>((java.io.File) r11)
            int r4 = r3.f1311a
            r5 = 1
            if (r4 != r5) goto L_0x00ad
            long r4 = r3.f1312b
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x00ad
            long r4 = r3.f1312b
            int r4 = (int) r4
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocate(r4)
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0090 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0090 }
            r6.<init>(r11)     // Catch:{ Exception -> 0x0090 }
            r7 = 256(0x100, double:1.265E-321)
            r6.skip(r7)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
        L_0x0041:
            int r11 = r6.read(r5)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r7 = -1
            if (r11 == r7) goto L_0x004d
            r7 = 0
            r4.put(r5, r7, r11)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            goto L_0x0041
        L_0x004d:
            java.lang.String r11 = new java.lang.String     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            byte[] r4 = r4.array()     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r11.<init>(r4)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            int r3 = r3.f1311a     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            net.fxgear.fittingmodenative.b r10 = a(r10, r11, r3)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            java.lang.String r11 = l     // Catch:{ Exception -> 0x0081, all -> 0x0087 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0081, all -> 0x0087 }
            r2.<init>()     // Catch:{ Exception -> 0x0081, all -> 0x0087 }
            java.lang.String r3 = "[L] loading time : "
            r2.append(r3)     // Catch:{ Exception -> 0x0081, all -> 0x0087 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0081, all -> 0x0087 }
            r5 = 0
            long r3 = r3 - r0
            r2.append(r3)     // Catch:{ Exception -> 0x0081, all -> 0x0087 }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0081, all -> 0x0087 }
            android.util.Log.e(r11, r0)     // Catch:{ Exception -> 0x0081, all -> 0x0087 }
            r6.close()     // Catch:{ IOException -> 0x007c }
            goto L_0x00a0
        L_0x007c:
            r11 = move-exception
            r11.printStackTrace()
            goto L_0x00a0
        L_0x0081:
            r11 = move-exception
            r2 = r6
            r9 = r11
            r11 = r10
            r10 = r9
            goto L_0x0092
        L_0x0087:
            r10 = move-exception
            goto L_0x00a2
        L_0x0089:
            r10 = move-exception
            r11 = r2
            r2 = r6
            goto L_0x0092
        L_0x008d:
            r10 = move-exception
            r6 = r2
            goto L_0x00a2
        L_0x0090:
            r10 = move-exception
            r11 = r2
        L_0x0092:
            r10.printStackTrace()     // Catch:{ all -> 0x008d }
            if (r2 == 0) goto L_0x009f
            r2.close()     // Catch:{ IOException -> 0x009b }
            goto L_0x009f
        L_0x009b:
            r10 = move-exception
            r10.printStackTrace()
        L_0x009f:
            r10 = r11
        L_0x00a0:
            r2 = r10
            goto L_0x00c4
        L_0x00a2:
            if (r6 == 0) goto L_0x00ac
            r6.close()     // Catch:{ IOException -> 0x00a8 }
            goto L_0x00ac
        L_0x00a8:
            r11 = move-exception
            r11.printStackTrace()
        L_0x00ac:
            throw r10
        L_0x00ad:
            java.lang.String r10 = l
            java.lang.String r11 = "ERROR :: wrong file"
            android.util.Log.e(r10, r11)
            goto L_0x00c4
        L_0x00b5:
            java.lang.String r10 = l
            java.lang.String r11 = "ERROR :: not found file or wrong file"
            android.util.Log.e(r10, r11)
            goto L_0x00c4
        L_0x00bd:
            java.lang.String r10 = l
            java.lang.String r11 = "ERROR :: param error."
            android.util.Log.e(r10, r11)
        L_0x00c4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.b.c(android.content.Context, java.io.File):net.fxgear.fittingmodenative.b");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.io.File} */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v2, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a7 A[SYNTHETIC, Splitter:B:40:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ba A[SYNTHETIC, Splitter:B:49:0x00ba] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d1 A[SYNTHETIC, Splitter:B:60:0x00d1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.io.File r10, int r11) {
        /*
            r9 = this;
            java.lang.String r0 = l
            java.lang.String r1 = "SaveToFile()+"
            android.util.Log.d(r0, r1)
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 0
            if (r10 == 0) goto L_0x00ed
            java.io.File r3 = r10.getParentFile()
            boolean r4 = r3.exists()
            if (r4 != 0) goto L_0x001b
            r3.mkdirs()
        L_0x001b:
            java.lang.String r4 = r9.a(r11)
            if (r4 == 0) goto L_0x00e6
            int r5 = r4.length()
            if (r5 <= 0) goto L_0x00e6
            r5 = 0
            byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
            net.fxgear.fittingmodenative.b$a r6 = new net.fxgear.fittingmodenative.b$a     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
            int r7 = r4.length     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
            long r7 = (long) r7     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
            r6.<init>(r11, r7)     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
            java.io.File r11 = new java.io.File     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
            r7.<init>()     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
            java.lang.String r8 = r10.getName()     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
            r7.append(r8)     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
            java.lang.String r8 = "_tmp"
            r7.append(r8)     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
            r11.<init>(r3, r7)     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x009c, all -> 0x009a }
            r3.<init>(r11)     // Catch:{ IOException -> 0x009c, all -> 0x009a }
            byte[] r5 = r6.a()     // Catch:{ IOException -> 0x0098, all -> 0x0096 }
            r3.write(r5)     // Catch:{ IOException -> 0x0098, all -> 0x0096 }
            r3.write(r4)     // Catch:{ IOException -> 0x0098, all -> 0x0096 }
            r3.close()     // Catch:{ IOException -> 0x0088 }
            boolean r2 = r10.exists()
            if (r2 == 0) goto L_0x0068
            r10.delete()
        L_0x0068:
            r11.renameTo(r10)
            java.lang.String r10 = l
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r2 = "[L] save time : "
            r11.append(r2)
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r0
            r11.append(r2)
            java.lang.String r11 = r11.toString()
            android.util.Log.e(r10, r11)
            r10 = 1
            return r10
        L_0x0088:
            r10 = move-exception
            boolean r0 = r11.exists()
            if (r0 == 0) goto L_0x0092
            r11.delete()
        L_0x0092:
            r10.printStackTrace()
            return r2
        L_0x0096:
            r10 = move-exception
            goto L_0x00b3
        L_0x0098:
            r10 = move-exception
            goto L_0x009e
        L_0x009a:
            r10 = move-exception
            goto L_0x00cf
        L_0x009c:
            r10 = move-exception
            r3 = r5
        L_0x009e:
            r5 = r11
            goto L_0x00a5
        L_0x00a0:
            r10 = move-exception
            r11 = r5
            goto L_0x00cf
        L_0x00a3:
            r10 = move-exception
            r3 = r5
        L_0x00a5:
            if (r5 == 0) goto L_0x00b5
            boolean r11 = r5.exists()     // Catch:{ all -> 0x00b1 }
            if (r11 == 0) goto L_0x00b5
            r5.delete()     // Catch:{ all -> 0x00b1 }
            goto L_0x00b5
        L_0x00b1:
            r10 = move-exception
            r11 = r5
        L_0x00b3:
            r5 = r3
            goto L_0x00cf
        L_0x00b5:
            r10.printStackTrace()     // Catch:{ all -> 0x00b1 }
            if (r3 == 0) goto L_0x00ce
            r3.close()     // Catch:{ IOException -> 0x00be }
            goto L_0x00ce
        L_0x00be:
            r10 = move-exception
            if (r5 == 0) goto L_0x00ca
            boolean r11 = r5.exists()
            if (r11 == 0) goto L_0x00ca
            r5.delete()
        L_0x00ca:
            r10.printStackTrace()
            return r2
        L_0x00ce:
            return r2
        L_0x00cf:
            if (r5 == 0) goto L_0x00e5
            r5.close()     // Catch:{ IOException -> 0x00d5 }
            goto L_0x00e5
        L_0x00d5:
            r10 = move-exception
            if (r11 == 0) goto L_0x00e1
            boolean r0 = r11.exists()
            if (r0 == 0) goto L_0x00e1
            r11.delete()
        L_0x00e1:
            r10.printStackTrace()
            return r2
        L_0x00e5:
            throw r10
        L_0x00e6:
            java.lang.String r10 = l
            java.lang.String r11 = "ERROR :: data is wrong."
            android.util.Log.e(r10, r11)
        L_0x00ed:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.b.a(java.io.File, int):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.io.File} */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v2, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a8 A[SYNTHETIC, Splitter:B:40:0x00a8] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00bb A[SYNTHETIC, Splitter:B:49:0x00bb] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d2 A[SYNTHETIC, Splitter:B:60:0x00d2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d(android.content.Context r10, java.io.File r11) {
        /*
            r9 = this;
            java.lang.String r10 = l
            java.lang.String r0 = "SaveDataFiles()+"
            android.util.Log.d(r10, r0)
            long r0 = java.lang.System.currentTimeMillis()
            r10 = 0
            if (r11 == 0) goto L_0x00ee
            java.io.File r2 = r11.getParentFile()
            boolean r3 = r2.exists()
            if (r3 != 0) goto L_0x001b
            r2.mkdirs()
        L_0x001b:
            r3 = 2
            java.lang.String r4 = r9.a(r3)
            if (r4 == 0) goto L_0x00e7
            int r5 = r4.length()
            if (r5 <= 0) goto L_0x00e7
            r5 = 0
            byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x00a4, all -> 0x00a1 }
            net.fxgear.fittingmodenative.b$a r6 = new net.fxgear.fittingmodenative.b$a     // Catch:{ IOException -> 0x00a4, all -> 0x00a1 }
            int r7 = r4.length     // Catch:{ IOException -> 0x00a4, all -> 0x00a1 }
            long r7 = (long) r7     // Catch:{ IOException -> 0x00a4, all -> 0x00a1 }
            r6.<init>(r3, r7)     // Catch:{ IOException -> 0x00a4, all -> 0x00a1 }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x00a4, all -> 0x00a1 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a4, all -> 0x00a1 }
            r7.<init>()     // Catch:{ IOException -> 0x00a4, all -> 0x00a1 }
            java.lang.String r8 = r11.getName()     // Catch:{ IOException -> 0x00a4, all -> 0x00a1 }
            r7.append(r8)     // Catch:{ IOException -> 0x00a4, all -> 0x00a1 }
            java.lang.String r8 = "_tmp"
            r7.append(r8)     // Catch:{ IOException -> 0x00a4, all -> 0x00a1 }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x00a4, all -> 0x00a1 }
            r3.<init>(r2, r7)     // Catch:{ IOException -> 0x00a4, all -> 0x00a1 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            r2.<init>(r3)     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            byte[] r5 = r6.a()     // Catch:{ IOException -> 0x0099, all -> 0x0097 }
            r2.write(r5)     // Catch:{ IOException -> 0x0099, all -> 0x0097 }
            r2.write(r4)     // Catch:{ IOException -> 0x0099, all -> 0x0097 }
            r2.close()     // Catch:{ IOException -> 0x0089 }
            boolean r10 = r11.exists()
            if (r10 == 0) goto L_0x0069
            r11.delete()
        L_0x0069:
            r3.renameTo(r11)
            java.lang.String r10 = l
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r2 = "[L] save time : "
            r11.append(r2)
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r0
            r11.append(r2)
            java.lang.String r11 = r11.toString()
            android.util.Log.e(r10, r11)
            r10 = 1
            return r10
        L_0x0089:
            r11 = move-exception
            boolean r0 = r3.exists()
            if (r0 == 0) goto L_0x0093
            r3.delete()
        L_0x0093:
            r11.printStackTrace()
            return r10
        L_0x0097:
            r11 = move-exception
            goto L_0x00b4
        L_0x0099:
            r11 = move-exception
            goto L_0x009f
        L_0x009b:
            r11 = move-exception
            goto L_0x00d0
        L_0x009d:
            r11 = move-exception
            r2 = r5
        L_0x009f:
            r5 = r3
            goto L_0x00a6
        L_0x00a1:
            r11 = move-exception
            r3 = r5
            goto L_0x00d0
        L_0x00a4:
            r11 = move-exception
            r2 = r5
        L_0x00a6:
            if (r5 == 0) goto L_0x00b6
            boolean r0 = r5.exists()     // Catch:{ all -> 0x00b2 }
            if (r0 == 0) goto L_0x00b6
            r5.delete()     // Catch:{ all -> 0x00b2 }
            goto L_0x00b6
        L_0x00b2:
            r11 = move-exception
            r3 = r5
        L_0x00b4:
            r5 = r2
            goto L_0x00d0
        L_0x00b6:
            r11.printStackTrace()     // Catch:{ all -> 0x00b2 }
            if (r2 == 0) goto L_0x00cf
            r2.close()     // Catch:{ IOException -> 0x00bf }
            goto L_0x00cf
        L_0x00bf:
            r11 = move-exception
            if (r5 == 0) goto L_0x00cb
            boolean r0 = r5.exists()
            if (r0 == 0) goto L_0x00cb
            r5.delete()
        L_0x00cb:
            r11.printStackTrace()
            return r10
        L_0x00cf:
            return r10
        L_0x00d0:
            if (r5 == 0) goto L_0x00e6
            r5.close()     // Catch:{ IOException -> 0x00d6 }
            goto L_0x00e6
        L_0x00d6:
            r11 = move-exception
            if (r3 == 0) goto L_0x00e2
            boolean r0 = r3.exists()
            if (r0 == 0) goto L_0x00e2
            r3.delete()
        L_0x00e2:
            r11.printStackTrace()
            return r10
        L_0x00e6:
            throw r11
        L_0x00e7:
            java.lang.String r11 = l
            java.lang.String r0 = "ERROR :: data is wrong."
            android.util.Log.e(r11, r0)
        L_0x00ee:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.b.d(android.content.Context, java.io.File):boolean");
    }

    private static b a(Context context, String str, int i2) {
        Log.d(l, "GenerateData()+");
        if (str == null) {
            return null;
        }
        try {
            b bVar = new b();
            switch (i2) {
                case 1:
                    bVar.j = new BodySizeData();
                    JSONObject jSONObject = new JSONObject(str);
                    bVar.f1309a = jSONObject.getInt("age");
                    bVar.f1310b = jSONObject.getInt("gender");
                    bVar.e = jSONObject.getInt("hair_type");
                    bVar.f = jSONObject.getInt("head_type");
                    bVar.c = jSONObject.getInt("real_id");
                    bVar.g = jSONObject.getBoolean("is_custom_face");
                    bVar.h = Float.valueOf(jSONObject.getString("auto_normalized_color")).floatValue();
                    bVar.i = jSONObject.getInt("hue_rgb_color");
                    JSONObject jSONObject2 = jSONObject.getJSONObject("body_data");
                    bVar.j.mTallSize = Float.valueOf(jSONObject2.getString("body_tall")).floatValue();
                    bVar.j.mUpperSize = Float.valueOf(jSONObject2.getString("body_upper")).floatValue();
                    bVar.j.mLowerSize = Float.valueOf(jSONObject2.getString("body_lower")).floatValue();
                    bVar.j.mShoulderSize = Float.valueOf(jSONObject2.getString("body_shoulder")).floatValue();
                    bVar.j.mBustSize = Float.valueOf(jSONObject2.getString("body_bust")).floatValue();
                    bVar.j.mCupSize = Float.valueOf(jSONObject2.getString("body_cup")).floatValue();
                    bVar.j.mWaistSize = Float.valueOf(jSONObject2.getString("body_waist")).floatValue();
                    bVar.j.mHipSize = Float.valueOf(jSONObject2.getString("body_hip")).floatValue();
                    bVar.j.mArmLengthSize = Float.valueOf(jSONObject2.getString("body_arm_length")).floatValue();
                    bVar.j.mArmThickSize = Float.valueOf(jSONObject2.getString("body_arm_thick")).floatValue();
                    bVar.j.mThighLengthSize = Float.valueOf(jSONObject2.getString("body_thigh_length")).floatValue();
                    bVar.j.mThighThickSize = Float.valueOf(jSONObject2.getString("body_thigh_thick")).floatValue();
                    bVar.j.mCalfLengthSize = Float.valueOf(jSONObject2.getString("body_calf_length")).floatValue();
                    bVar.j.mHeadHeight = Float.valueOf(jSONObject2.getString("body_head_height")).floatValue();
                    break;
                case 2:
                    bVar.j = new BodySizeData();
                    JSONObject jSONObject3 = new JSONObject(str);
                    bVar.f1309a = jSONObject3.getInt("age");
                    bVar.f1310b = jSONObject3.getInt("gender");
                    bVar.c = jSONObject3.getInt("real_id");
                    bVar.d = jSONObject3.getInt("avatar_id");
                    bVar.k = FXDataManager.GetInstance(context).GetAvatarData(bVar.d);
                    break;
            }
            return bVar;
        } catch (JSONException e2) {
            Log.e(l, "ERROR :: JSON format exception");
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(int r5) {
        /*
            r4 = this;
            java.lang.String r0 = l
            java.lang.String r1 = "GenerateContentsData()+"
            android.util.Log.d(r0, r1)
            r0 = 0
            switch(r5) {
                case 1: goto L_0x0030;
                case 2: goto L_0x000d;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0137
        L_0x000d:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0133 }
            r5.<init>()     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r1 = "age"
            int r2 = r4.f1309a     // Catch:{ JSONException -> 0x0133 }
            r5.put(r1, r2)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r1 = "gender"
            int r2 = r4.f1310b     // Catch:{ JSONException -> 0x0133 }
            r5.put(r1, r2)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r1 = "real_id"
            int r2 = r4.c     // Catch:{ JSONException -> 0x0133 }
            r5.put(r1, r2)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r1 = "avatar_id"
            int r2 = r4.d     // Catch:{ JSONException -> 0x0133 }
            r5.put(r1, r2)     // Catch:{ JSONException -> 0x0133 }
            goto L_0x0138
        L_0x0030:
            net.fxgear.BodySizeData r5 = r4.j     // Catch:{ JSONException -> 0x0133 }
            if (r5 == 0) goto L_0x0137
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0133 }
            r5.<init>()     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r1 = "age"
            int r2 = r4.f1309a     // Catch:{ JSONException -> 0x0133 }
            r5.put(r1, r2)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r1 = "gender"
            int r2 = r4.f1310b     // Catch:{ JSONException -> 0x0133 }
            r5.put(r1, r2)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r1 = "hair_type"
            int r2 = r4.e     // Catch:{ JSONException -> 0x0133 }
            r5.put(r1, r2)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r1 = "head_type"
            int r2 = r4.f     // Catch:{ JSONException -> 0x0133 }
            r5.put(r1, r2)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r1 = "real_id"
            int r2 = r4.c     // Catch:{ JSONException -> 0x0133 }
            r5.put(r1, r2)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r1 = "is_custom_face"
            boolean r2 = r4.g     // Catch:{ JSONException -> 0x0133 }
            r5.put(r1, r2)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r1 = "auto_normalized_color"
            float r2 = r4.h     // Catch:{ JSONException -> 0x0133 }
            double r2 = (double) r2     // Catch:{ JSONException -> 0x0133 }
            r5.put(r1, r2)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r1 = "hue_rgb_color"
            int r2 = r4.i     // Catch:{ JSONException -> 0x0133 }
            r5.put(r1, r2)     // Catch:{ JSONException -> 0x0133 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0133 }
            r1.<init>()     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r2 = "body_tall"
            net.fxgear.BodySizeData r3 = r4.j     // Catch:{ JSONException -> 0x0133 }
            float r3 = r3.mTallSize     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ JSONException -> 0x0133 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r2 = "body_upper"
            net.fxgear.BodySizeData r3 = r4.j     // Catch:{ JSONException -> 0x0133 }
            float r3 = r3.mUpperSize     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ JSONException -> 0x0133 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r2 = "body_lower"
            net.fxgear.BodySizeData r3 = r4.j     // Catch:{ JSONException -> 0x0133 }
            float r3 = r3.mLowerSize     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ JSONException -> 0x0133 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r2 = "body_shoulder"
            net.fxgear.BodySizeData r3 = r4.j     // Catch:{ JSONException -> 0x0133 }
            float r3 = r3.mShoulderSize     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ JSONException -> 0x0133 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r2 = "body_bust"
            net.fxgear.BodySizeData r3 = r4.j     // Catch:{ JSONException -> 0x0133 }
            float r3 = r3.mBustSize     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ JSONException -> 0x0133 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r2 = "body_cup"
            net.fxgear.BodySizeData r3 = r4.j     // Catch:{ JSONException -> 0x0133 }
            float r3 = r3.mCupSize     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ JSONException -> 0x0133 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r2 = "body_waist"
            net.fxgear.BodySizeData r3 = r4.j     // Catch:{ JSONException -> 0x0133 }
            float r3 = r3.mWaistSize     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ JSONException -> 0x0133 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r2 = "body_hip"
            net.fxgear.BodySizeData r3 = r4.j     // Catch:{ JSONException -> 0x0133 }
            float r3 = r3.mHipSize     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ JSONException -> 0x0133 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r2 = "body_arm_length"
            net.fxgear.BodySizeData r3 = r4.j     // Catch:{ JSONException -> 0x0133 }
            float r3 = r3.mArmLengthSize     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ JSONException -> 0x0133 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r2 = "body_arm_thick"
            net.fxgear.BodySizeData r3 = r4.j     // Catch:{ JSONException -> 0x0133 }
            float r3 = r3.mArmThickSize     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ JSONException -> 0x0133 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r2 = "body_thigh_length"
            net.fxgear.BodySizeData r3 = r4.j     // Catch:{ JSONException -> 0x0133 }
            float r3 = r3.mThighLengthSize     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ JSONException -> 0x0133 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r2 = "body_thigh_thick"
            net.fxgear.BodySizeData r3 = r4.j     // Catch:{ JSONException -> 0x0133 }
            float r3 = r3.mThighThickSize     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ JSONException -> 0x0133 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r2 = "body_calf_length"
            net.fxgear.BodySizeData r3 = r4.j     // Catch:{ JSONException -> 0x0133 }
            float r3 = r3.mCalfLengthSize     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ JSONException -> 0x0133 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r2 = "body_head_height"
            net.fxgear.BodySizeData r3 = r4.j     // Catch:{ JSONException -> 0x0133 }
            float r3 = r3.mHeadHeight     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ JSONException -> 0x0133 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0133 }
            java.lang.String r2 = "body_data"
            r5.put(r2, r1)     // Catch:{ JSONException -> 0x0133 }
            goto L_0x0138
        L_0x0133:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0137:
            r5 = r0
        L_0x0138:
            if (r5 == 0) goto L_0x013f
            java.lang.String r5 = r5.toString()
            return r5
        L_0x013f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.b.a(int):java.lang.String");
    }

    public void a(Context context, int i2) {
        this.k = FXDataManager.GetInstance(context).GetAvatarData(i2);
        this.d = this.k.mAvatarID;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\c.java ==========

package net.fxgear.fittingmodenative;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import net.fxgear.AvatarData;
import net.fxgear.GlobalDefine;
import net.fxgear.fittingmodenative.d.c;
import net.fxgear.fittingmodenative.d.e;
import net.fxgear.fittingmodenative.d.h;
import net.fxgear.fittingmodenative.e;
import net.fxgear.util.FXDataManager;
import net.fxgear.util.FXUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FXUpdater */
public class c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f1328a = "c";

    /* compiled from: FXUpdater */
    public interface b {
        void a();

        void a(boolean z);
    }

    /* renamed from: net.fxgear.fittingmodenative.c$c  reason: collision with other inner class name */
    /* compiled from: FXUpdater */
    public interface C0044c {
        void a();

        void a(int i, int i2, int i3);

        void a(GlobalDefine.Result result);
    }

    public static e a(Context context, C0044c cVar) {
        e eVar = new e(context, cVar);
        eVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return eVar;
    }

    public static boolean a(Context context) {
        if (context != null) {
            a aVar = new a(new File(GlobalDefine.GetRootDirectory(context), GlobalDefine.VERIFICATION_FILE_NAME));
            boolean NeedDefaultRealData = GlobalDefine.NeedDefaultRealData(context);
            boolean h = !NeedDefaultRealData ? h(context) : false;
            boolean j = j(context);
            boolean z = GlobalDefine.GetChangeDefaultRealVideoState(context) == 2;
            if (!aVar.a(context) || GlobalDefine.NeedMigrationUnityData(context) || g(context) || f(context) || NeedDefaultRealData || !h || !j || !z) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean f(Context context) {
        return new File(FXUtil.getFilesDir(context), GlobalDefine.UNITY_CLOTH_DATA_DIRECTORY_NAME).exists();
    }

    /* access modifiers changed from: private */
    public static boolean g(Context context) {
        return new File(FXUtil.getFilesDir(context), GlobalDefine.UNITY_REAL_VIDEO_DATA_DIRECTORY_NAME).exists();
    }

    private static boolean h(Context context) {
        boolean z;
        boolean z2;
        ArrayList<e.c> c = e.a(context).c();
        if (c != null) {
            Iterator<e.c> it = c.iterator();
            z2 = false;
            z = false;
            while (it.hasNext()) {
                e.c next = it.next();
                if (next.f1466b == 1) {
                    if (next.c == 2 && next.f.equals(GlobalDefine.REAL_VIDEO_DEFAULT_SIZE_WOMAN)) {
                        z = true;
                    }
                } else if (next.f1466b == 2 && next.c == 2 && next.f.equals(GlobalDefine.REAL_VIDEO_DEFAULT_SIZE_MAN)) {
                    z2 = true;
                }
            }
        } else {
            z2 = false;
            z = false;
        }
        if (!(z2 && z) || !i(context)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static boolean i(Context context) {
        boolean z;
        boolean z2;
        ArrayList<e.c> c = e.a(context).c();
        if (c != null) {
            Iterator<e.c> it = c.iterator();
            z2 = false;
            z = false;
            while (it.hasNext()) {
                e.c next = it.next();
                if (next.f1466b == 1) {
                    if (next.c == 1 && next.f.equals(GlobalDefine.REAL_VIDEO_DEFAULT_SIZE_GIRL)) {
                        z = true;
                    }
                } else if (next.f1466b == 2 && next.c == 1 && next.f.equals(GlobalDefine.REAL_VIDEO_DEFAULT_SIZE_BOY)) {
                    z2 = true;
                }
            }
        } else {
            z2 = false;
            z = false;
        }
        if (!z2 || !z) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static boolean j(Context context) {
        boolean z;
        boolean z2;
        ArrayList<AvatarData> GetAllAvatarDataList = FXDataManager.GetInstance(context).GetAllAvatarDataList();
        if (GetAllAvatarDataList != null) {
            Iterator<AvatarData> it = GetAllAvatarDataList.iterator();
            z2 = false;
            z = false;
            while (it.hasNext()) {
                AvatarData next = it.next();
                if (next.mGender == 1) {
                    if (next.mAge == 1) {
                        z = true;
                    }
                } else if (next.mGender == 2 && next.mAge == 1) {
                    z2 = true;
                }
            }
        } else {
            z2 = false;
            z = false;
        }
        if (!z2 || !z) {
            return false;
        }
        return true;
    }

    /* compiled from: FXUpdater */
    public static class e extends AsyncTask<Void, Integer, Integer> implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private Context f1358a;

        /* renamed from: b  reason: collision with root package name */
        private GlobalDefine.Result f1359b = new GlobalDefine.Result();
        private C0044c c;
        private ArrayList<C0047c> d;
        private ArrayList<b> e;
        private ArrayList<Long> f;
        private int g;
        private long h;
        private long i;
        private long j;
        private net.fxgear.fittingmodenative.d.b k;
        private final int l = 0;
        private final int m = 1;
        private final int n = 2;
        private final int o = 3;
        private final int p = 0;
        private final int q = 1;
        private final int r = 2;
        private final int s = 3;
        private int t = 0;
        private ArrayList<a> u;

        /* renamed from: net.fxgear.fittingmodenative.c$e$c  reason: collision with other inner class name */
        /* compiled from: FXUpdater */
        private class C0047c {

            /* renamed from: a  reason: collision with root package name */
            String f1372a;

            /* renamed from: b  reason: collision with root package name */
            String f1373b;
            String c;
            long d;

            public C0047c(String str, String str2, long j) {
                this.f1372a = str;
                this.f1373b = str2;
                this.c = str2 + GlobalDefine.SYMBOL_TEMP;
                this.d = j;
            }
        }

        /* compiled from: FXUpdater */
        private class b {

            /* renamed from: a  reason: collision with root package name */
            String f1368a;

            /* renamed from: b  reason: collision with root package name */
            String f1369b;
            String c;
            String d;
            String e;
            String f;
            long g;
            int h;
            boolean i;

            b(int i2, String str, String str2, String str3, String str4, long j2, boolean z) {
                this.h = i2;
                this.f1368a = str;
                this.f1369b = str3;
                this.c = str3 + GlobalDefine.SYMBOL_TEMP;
                this.d = str2;
                this.e = str4;
                this.f = str4 + GlobalDefine.SYMBOL_TEMP;
                this.g = j2;
                this.i = z;
            }
        }

        /* compiled from: FXUpdater */
        private class a {

            /* renamed from: a  reason: collision with root package name */
            String f1364a;

            /* renamed from: b  reason: collision with root package name */
            String f1365b;
            String c;
            int d;

            private a() {
            }
        }

        public e(Context context, C0044c cVar) {
            this.f1358a = context;
            this.c = cVar;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (this.c != null) {
                this.c.a();
            }
        }

        public void a() {
            Log.d(c.f1328a, "stopTask()+");
            if (getStatus() != AsyncTask.Status.FINISHED) {
                cancel(true);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onCancelled(Integer num) {
            Log.d(c.f1328a, "onCancelled()+");
            this.f1359b.resultCode = -2;
            if (this.c != null) {
                this.c.a(this.f1359b);
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:247:0x079b  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Integer doInBackground(java.lang.Void... r22) {
            /*
                r21 = this;
                r0 = r21
                android.content.Context r1 = r0.f1358a
                r2 = 1
                if (r1 == 0) goto L_0x0808
                r1 = 3
                java.lang.Integer[] r3 = new java.lang.Integer[r1]
                r4 = 0
                java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
                r3[r4] = r5
                java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
                r3[r2] = r5
                java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
                r6 = 2
                r3[r6] = r5
                r0.publishProgress(r3)
                r3 = 0
                r0.k = r3
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                r0.f = r5
                r0.g = r4
                r7 = 0
                r0.h = r7
                r0.i = r7
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                java.io.File r9 = new java.io.File
                android.content.Context r10 = r0.f1358a
                java.io.File r10 = net.fxgear.GlobalDefine.GetRootDirectory(r10)
                java.lang.String r11 = "vDATA.fx"
                r9.<init>(r10, r11)
                net.fxgear.fittingmodenative.c$a r10 = new net.fxgear.fittingmodenative.c$a
                r10.<init>(r9)
                net.fxgear.fittingmodenative.d.b r11 = net.fxgear.fittingmodenative.d.e.a()
                r0.k = r11
                net.fxgear.fittingmodenative.d.b r11 = r0.k
                java.lang.String r11 = r11.f1411a
                if (r11 == 0) goto L_0x0801
                net.fxgear.fittingmodenative.d.b r11 = r0.k
                java.lang.String r11 = r11.c
                if (r11 == 0) goto L_0x0801
                net.fxgear.fittingmodenative.d.b r11 = r0.k
                java.lang.String r11 = r11.e
                if (r11 == 0) goto L_0x0801
                net.fxgear.fittingmodenative.d.b r11 = r0.k
                java.lang.String r11 = r11.f1411a
                int r11 = r11.length()
                if (r11 <= 0) goto L_0x0801
                net.fxgear.fittingmodenative.d.b r11 = r0.k
                java.lang.String r11 = r11.c
                int r11 = r11.length()
                if (r11 <= 0) goto L_0x0801
                net.fxgear.fittingmodenative.d.b r11 = r0.k
                java.lang.String r11 = r11.e
                int r11 = r11.length()
                if (r11 > 0) goto L_0x0082
                goto L_0x0801
            L_0x0082:
                android.content.Context r11 = r0.f1358a
                boolean r11 = net.fxgear.fittingmodenative.f.a((android.content.Context) r11)
                if (r11 == 0) goto L_0x0161
                net.fxgear.fittingmodenative.c$a$b r11 = r10.a()
                if (r11 == 0) goto L_0x013a
                int r12 = r11.f1335a
                if (r12 >= r6) goto L_0x0096
                goto L_0x013a
            L_0x0096:
                int r12 = r11.d
                java.util.ArrayList r9 = r10.a((java.io.File) r9, (int) r12)
                if (r9 == 0) goto L_0x0113
                int r12 = r9.size()
                int r13 = r11.d
                if (r12 == r13) goto L_0x00a7
                goto L_0x0113
            L_0x00a7:
                net.fxgear.fittingmodenative.f$a r12 = net.fxgear.fittingmodenative.f.f1467a
                r12.getClass()
                net.fxgear.fittingmodenative.d.b r12 = r0.k
                if (r12 == 0) goto L_0x010e
                net.fxgear.fittingmodenative.d.b r12 = r0.k
                java.lang.String r12 = r12.f1411a
                if (r12 == 0) goto L_0x010e
                r12 = 0
            L_0x00b7:
                int r13 = r11.d
                if (r12 >= r13) goto L_0x0161
                java.lang.Object r13 = r9.get(r12)
                net.fxgear.fittingmodenative.c$a$a r13 = (net.fxgear.fittingmodenative.c.a.C0041a) r13
                net.fxgear.fittingmodenative.d.b r14 = r0.k
                java.lang.String r14 = r14.b(r12)
                boolean r14 = net.fxgear.fittingmodenative.c.c((java.lang.String) r14)
                if (r14 != 0) goto L_0x00d4
                r1 = 14
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                return r1
            L_0x00d4:
                android.content.Context r14 = r0.f1358a
                net.fxgear.fittingmodenative.d.b r15 = r0.k
                java.lang.String r15 = r15.a((int) r12)
                long r14 = net.fxgear.fittingmodenative.d.c.a((android.content.Context) r14, (java.lang.String) r15)
                long r7 = r13.d
                int r17 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
                if (r17 != 0) goto L_0x00f4
                net.fxgear.fittingmodenative.d.b r7 = r0.k
                java.lang.String r7 = r7.b(r12)
                java.lang.String r8 = r13.c
                boolean r7 = net.fxgear.fittingmodenative.c.b(r7, r8)
                if (r7 == 0) goto L_0x0109
            L_0x00f4:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r12)
                r5.add(r7)
                java.util.ArrayList<java.lang.Long> r7 = r0.f
                java.lang.Long r8 = java.lang.Long.valueOf(r14)
                r7.add(r8)
                long r7 = r0.h
                long r7 = r7 + r14
                r0.h = r7
            L_0x0109:
                int r12 = r12 + 1
                r7 = 0
                goto L_0x00b7
            L_0x010e:
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
                return r1
            L_0x0113:
                r7 = 0
            L_0x0114:
                if (r7 >= r1) goto L_0x0161
                java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
                r5.add(r8)
                android.content.Context r8 = r0.f1358a
                net.fxgear.fittingmodenative.d.b r9 = r0.k
                java.lang.String r9 = r9.a((int) r7)
                long r8 = net.fxgear.fittingmodenative.d.c.a((android.content.Context) r8, (java.lang.String) r9)
                java.util.ArrayList<java.lang.Long> r11 = r0.f
                java.lang.Long r12 = java.lang.Long.valueOf(r8)
                r11.add(r12)
                long r11 = r0.h
                long r11 = r11 + r8
                r0.h = r11
                int r7 = r7 + 1
                goto L_0x0114
            L_0x013a:
                r7 = 0
            L_0x013b:
                if (r7 >= r1) goto L_0x0161
                java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
                r5.add(r8)
                android.content.Context r8 = r0.f1358a
                net.fxgear.fittingmodenative.d.b r9 = r0.k
                java.lang.String r9 = r9.a((int) r7)
                long r8 = net.fxgear.fittingmodenative.d.c.a((android.content.Context) r8, (java.lang.String) r9)
                java.util.ArrayList<java.lang.Long> r11 = r0.f
                java.lang.Long r12 = java.lang.Long.valueOf(r8)
                r11.add(r12)
                long r11 = r0.h
                long r11 = r11 + r8
                r0.h = r11
                int r7 = r7 + 1
                goto L_0x013b
            L_0x0161:
                net.fxgear.fittingmodenative.f$a r7 = net.fxgear.fittingmodenative.f.f1467a
                r7.getClass()
                android.content.Context r7 = r0.f1358a
                java.util.ArrayList r7 = r10.b(r7)
                if (r7 == 0) goto L_0x01b3
                int r8 = r7.size()
                if (r8 <= 0) goto L_0x01b3
                r8 = 0
            L_0x0175:
                int r9 = r7.size()
                if (r8 >= r9) goto L_0x01b3
                java.lang.Object r9 = r7.get(r8)
                java.lang.Integer r9 = (java.lang.Integer) r9
                int r9 = r9.intValue()
                java.lang.Integer r11 = java.lang.Integer.valueOf(r9)
                boolean r11 = r5.contains(r11)
                if (r11 != 0) goto L_0x01b0
                java.lang.Integer r11 = java.lang.Integer.valueOf(r9)
                r5.add(r11)
                android.content.Context r11 = r0.f1358a
                net.fxgear.fittingmodenative.d.b r12 = r0.k
                java.lang.String r9 = r12.a((int) r9)
                long r11 = net.fxgear.fittingmodenative.d.c.a((android.content.Context) r11, (java.lang.String) r9)
                java.util.ArrayList<java.lang.Long> r9 = r0.f
                java.lang.Long r13 = java.lang.Long.valueOf(r11)
                r9.add(r13)
                long r13 = r0.h
                long r13 = r13 + r11
                r0.h = r13
            L_0x01b0:
                int r8 = r8 + 1
                goto L_0x0175
            L_0x01b3:
                int r7 = r5.size()
                r8 = 100
                r9 = 4
                r11 = -2
                r12 = -1
                if (r7 <= 0) goto L_0x0312
                boolean r7 = r21.isCancelled()
                if (r7 == 0) goto L_0x01d2
                java.lang.String r1 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.String r2 = "Cancel task"
                android.util.Log.d(r1, r2)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
                return r1
            L_0x01d2:
                java.lang.Integer[] r7 = new java.lang.Integer[r6]
                java.lang.Integer r13 = java.lang.Integer.valueOf(r2)
                r7[r4] = r13
                java.lang.Integer r13 = java.lang.Integer.valueOf(r4)
                r7[r2] = r13
                r0.publishProgress(r7)
                r7 = 0
                r13 = 0
            L_0x01e5:
                int r14 = r5.size()
                if (r7 >= r14) goto L_0x026b
                java.util.ArrayList<java.lang.Long> r13 = r0.f
                int r14 = r0.g
                java.lang.Object r13 = r13.get(r14)
                java.lang.Long r13 = (java.lang.Long) r13
                long r13 = r13.longValue()
                r0.j = r13
                net.fxgear.fittingmodenative.d.b r13 = r0.k
                java.lang.Object r14 = r5.get(r7)
                java.lang.Integer r14 = (java.lang.Integer) r14
                int r14 = r14.intValue()
                java.lang.String r13 = r13.a((int) r14)
                java.io.File r14 = new java.io.File
                android.content.Context r15 = r0.f1358a
                java.io.File r15 = net.fxgear.GlobalDefine.GetRootDirectory(r15)
                java.lang.Object r17 = r5.get(r7)
                java.lang.Integer r17 = (java.lang.Integer) r17
                int r17 = r17.intValue()
                java.lang.String r3 = net.fxgear.GlobalDefine.GetFittingDataFileName(r17)
                r14.<init>(r15, r3)
                android.content.Context r3 = r0.f1358a
                java.lang.String r14 = r14.getAbsolutePath()
                int r3 = net.fxgear.fittingmodenative.d.c.a(r3, r13, r14, r4, r0)
                if (r3 == r12) goto L_0x024b
                java.lang.String r7 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.String r14 = "ERROR :: download data file fail."
                android.util.Log.e(r7, r14)
                if (r3 != r9) goto L_0x0249
                android.content.Context r7 = r0.f1358a
                long r13 = net.fxgear.fittingmodenative.d.c.a((android.content.Context) r7, (java.lang.String) r13)
                net.fxgear.GlobalDefine$Result r7 = r0.f1359b
                java.lang.Long r13 = java.lang.Long.valueOf(r13)
                r7.resultExtra = r13
            L_0x0249:
                r7 = r3
                goto L_0x026d
            L_0x024b:
                long r13 = r0.i
                java.util.ArrayList<java.lang.Long> r15 = r0.f
                int r9 = r0.g
                java.lang.Object r9 = r15.get(r9)
                java.lang.Long r9 = (java.lang.Long) r9
                long r19 = r9.longValue()
                long r13 = r13 + r19
                r0.i = r13
                int r9 = r0.g
                int r9 = r9 + r2
                r0.g = r9
                int r7 = r7 + 1
                r13 = r3
                r3 = 0
                r9 = 4
                goto L_0x01e5
            L_0x026b:
                r3 = r13
                r7 = 0
            L_0x026d:
                java.lang.Integer[] r9 = new java.lang.Integer[r6]
                java.lang.Integer r13 = java.lang.Integer.valueOf(r1)
                r9[r4] = r13
                java.lang.Integer r13 = java.lang.Integer.valueOf(r8)
                r9[r2] = r13
                r0.publishProgress(r9)
                if (r3 != r12) goto L_0x02e6
                android.content.Context r3 = r0.f1358a
                r10.a((android.content.Context) r3, (java.util.ArrayList<java.lang.Integer>) r5)
                r3 = 0
            L_0x0286:
                int r9 = r5.size()
                if (r3 >= r9) goto L_0x02b1
                java.lang.Object r7 = r5.get(r3)
                java.lang.Integer r7 = (java.lang.Integer) r7
                int r7 = r7.intValue()
                java.io.File r9 = new java.io.File
                android.content.Context r13 = r0.f1358a
                java.io.File r13 = net.fxgear.GlobalDefine.GetRootDirectory(r13)
                java.lang.String r7 = net.fxgear.GlobalDefine.GetFittingDataFileName(r7)
                r9.<init>(r13, r7)
                android.content.Context r7 = r0.f1358a
                int r7 = r0.a((android.content.Context) r7, (java.io.File) r9)
                if (r7 == r12) goto L_0x02ae
                goto L_0x02b1
            L_0x02ae:
                int r3 = r3 + 1
                goto L_0x0286
            L_0x02b1:
                if (r7 != r12) goto L_0x02e6
                android.content.Context r3 = r0.f1358a
                net.fxgear.fittingmodenative.d.b r9 = r0.k
                boolean r3 = r10.a(r3, r5, r9)
                if (r3 == 0) goto L_0x02d9
                android.content.Context r3 = r0.f1358a
                boolean r3 = r10.a((android.content.Context) r3)
                if (r3 == 0) goto L_0x02cf
                java.lang.String r3 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.String r9 = "Verify alright!"
                android.util.Log.i(r3, r9)
                goto L_0x02e3
            L_0x02cf:
                java.lang.String r3 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.String r7 = "ERROR :: verify error"
                android.util.Log.e(r3, r7)
                goto L_0x02e2
            L_0x02d9:
                java.lang.String r3 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.String r7 = "ERROR :: verification file error"
                android.util.Log.e(r3, r7)
            L_0x02e2:
                r7 = 3
            L_0x02e3:
                net.fxgear.AvatarSetting.ClearData()
            L_0x02e6:
                r3 = 0
            L_0x02e7:
                int r9 = r5.size()
                if (r3 >= r9) goto L_0x0313
                java.io.File r9 = new java.io.File
                android.content.Context r10 = r0.f1358a
                java.io.File r10 = net.fxgear.GlobalDefine.GetRootDirectory(r10)
                java.lang.Object r13 = r5.get(r3)
                java.lang.Integer r13 = (java.lang.Integer) r13
                int r13 = r13.intValue()
                java.lang.String r13 = net.fxgear.GlobalDefine.GetFittingDataFileName(r13)
                r9.<init>(r10, r13)
                boolean r10 = r9.exists()
                if (r10 == 0) goto L_0x030f
                r9.delete()
            L_0x030f:
                int r3 = r3 + 1
                goto L_0x02e7
            L_0x0312:
                r7 = -1
            L_0x0313:
                if (r7 == r12) goto L_0x031a
                java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
                return r1
            L_0x031a:
                boolean r3 = r21.isCancelled()
                if (r3 == 0) goto L_0x032e
                java.lang.String r1 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.String r2 = "Cancel task"
                android.util.Log.d(r1, r2)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
                return r1
            L_0x032e:
                java.util.ArrayList<java.lang.Long> r3 = r0.f
                if (r3 == 0) goto L_0x033a
                java.util.ArrayList<java.lang.Long> r3 = r0.f
                r3.clear()
                r3 = 0
                r0.f = r3
            L_0x033a:
                r0.g = r4
                r9 = 0
                r0.h = r9
                r0.i = r9
                r0.j = r9
                android.content.Context r3 = r0.f1358a
                boolean r3 = net.fxgear.GlobalDefine.NeedDefaultRealData(r3)
                java.lang.Integer[] r5 = new java.lang.Integer[r1]
                java.lang.Integer r9 = java.lang.Integer.valueOf(r4)
                r5[r4] = r9
                java.lang.Integer r9 = java.lang.Integer.valueOf(r4)
                r5[r2] = r9
                java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
                r5[r6] = r9
                r0.publishProgress(r5)
                if (r3 == 0) goto L_0x0381
                android.content.Context r3 = r0.f1358a
                net.fxgear.GlobalDefine$Result r3 = r0.a((android.content.Context) r3)
                int r5 = r3.resultCode
                int r7 = r3.resultCode
                if (r7 != r12) goto L_0x037a
                android.content.Context r3 = r0.f1358a
                net.fxgear.GlobalDefine.SetDefaultRealData(r3, r4)
                android.content.Context r3 = r0.f1358a
                net.fxgear.GlobalDefine.SetChangeDefaultRealVideoState(r3, r6)
                goto L_0x03de
            L_0x037a:
                net.fxgear.GlobalDefine$Result r7 = r0.f1359b
                java.lang.Object r3 = r3.resultExtra
                r7.resultExtra = r3
                goto L_0x03de
            L_0x0381:
                android.content.Context r3 = r0.f1358a
                int r3 = net.fxgear.GlobalDefine.GetChangeDefaultRealVideoState(r3)
                if (r3 != 0) goto L_0x03aa
                r21.b()
                android.content.Context r3 = r0.f1358a
                net.fxgear.GlobalDefine$Result r3 = r0.a((android.content.Context) r3)
                int r7 = r3.resultCode
                int r5 = r3.resultCode
                if (r5 != r12) goto L_0x039f
                android.content.Context r3 = r0.f1358a
                net.fxgear.GlobalDefine.SetChangeDefaultRealVideoState(r3, r2)
                r3 = 0
                goto L_0x03ab
            L_0x039f:
                net.fxgear.GlobalDefine$Result r1 = r0.f1359b
                java.lang.Object r2 = r3.resultExtra
                r1.resultExtra = r2
                java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
                return r1
            L_0x03aa:
                r3 = 1
            L_0x03ab:
                android.content.Context r5 = r0.f1358a
                boolean r5 = net.fxgear.fittingmodenative.c.i(r5)
                if (r5 != 0) goto L_0x03cb
                android.content.Context r5 = r0.f1358a
                net.fxgear.GlobalDefine$Result r5 = r0.b((android.content.Context) r5)
                int r7 = r5.resultCode
                int r9 = r5.resultCode
                if (r9 != r12) goto L_0x03c0
                goto L_0x03cb
            L_0x03c0:
                net.fxgear.GlobalDefine$Result r1 = r0.f1359b
                java.lang.Object r2 = r5.resultExtra
                r1.resultExtra = r2
                java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
                return r1
            L_0x03cb:
                r5 = r7
                if (r3 == 0) goto L_0x03de
                net.fxgear.GlobalDefine$Result r3 = r21.c()
                int r5 = r3.resultCode
                int r7 = r3.resultCode
                if (r7 == r12) goto L_0x03de
                net.fxgear.GlobalDefine$Result r7 = r0.f1359b
                java.lang.Object r3 = r3.resultExtra
                r7.resultExtra = r3
            L_0x03de:
                if (r5 == r12) goto L_0x03e5
                java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
                return r1
            L_0x03e5:
                boolean r3 = r21.isCancelled()
                if (r3 == 0) goto L_0x03f9
                java.lang.String r1 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.String r2 = "Cancel task"
                android.util.Log.d(r1, r2)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
                return r1
            L_0x03f9:
                java.lang.Integer[] r3 = new java.lang.Integer[r6]
                java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
                r3[r4] = r7
                java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
                r3[r2] = r7
                r0.publishProgress(r3)
                android.content.Context r3 = r0.f1358a
                boolean r3 = net.fxgear.GlobalDefine.NeedMigrationUnityData(r3)
                if (r3 == 0) goto L_0x0482
                android.content.Context r3 = r0.f1358a
                boolean r3 = net.fxgear.fittingmodenative.c.g(r3)
                if (r3 == 0) goto L_0x0446
                net.fxgear.GlobalDefine$Result r3 = r21.g()
                int r5 = r3.resultCode
                int r7 = r3.resultCode
                if (r7 != r12) goto L_0x0438
                r21.h()
                java.io.File r3 = new java.io.File
                android.content.Context r7 = r0.f1358a
                java.io.File r7 = net.fxgear.util.FXUtil.getFilesDir(r7)
                java.lang.String r9 = "REC"
                r3.<init>(r7, r9)
                net.fxgear.util.FXUtil.DeleteDirectoryRecursive(r3)
                goto L_0x0446
            L_0x0438:
                r21.i()
                net.fxgear.GlobalDefine$Result r1 = r0.f1359b
                java.lang.Object r2 = r3.resultExtra
                r1.resultExtra = r2
                java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
                return r1
            L_0x0446:
                android.content.Context r3 = r0.f1358a
                boolean r3 = net.fxgear.fittingmodenative.c.f(r3)
                if (r3 == 0) goto L_0x047d
                net.fxgear.GlobalDefine$Result r3 = r21.f()
                int r5 = r3.resultCode
                int r7 = r3.resultCode
                if (r7 != r12) goto L_0x0469
                java.io.File r3 = new java.io.File
                android.content.Context r7 = r0.f1358a
                java.io.File r7 = net.fxgear.util.FXUtil.getFilesDir(r7)
                java.lang.String r9 = "DAT"
                r3.<init>(r7, r9)
                net.fxgear.util.FXUtil.DeleteDirectoryRecursive(r3)
                goto L_0x047d
            L_0x0469:
                android.content.Context r1 = r0.f1358a
                java.io.File r1 = net.fxgear.GlobalDefine.GetClothDirectory(r1)
                net.fxgear.util.FXUtil.DeleteDirectoryRecursive(r1)
                net.fxgear.GlobalDefine$Result r1 = r0.f1359b
                java.lang.Object r2 = r3.resultExtra
                r1.resultExtra = r2
                java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
                return r1
            L_0x047d:
                android.content.Context r3 = r0.f1358a
                net.fxgear.GlobalDefine.SetMigrationUnityData(r3, r4)
            L_0x0482:
                if (r5 == r12) goto L_0x0489
                java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
                return r1
            L_0x0489:
                boolean r3 = r21.isCancelled()
                if (r3 == 0) goto L_0x049d
                java.lang.String r1 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.String r2 = "Cancel task"
                android.util.Log.d(r1, r2)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
                return r1
            L_0x049d:
                java.lang.Integer[] r3 = new java.lang.Integer[r1]
                java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
                r3[r4] = r7
                java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
                r3[r2] = r7
                java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
                r3[r6] = r7
                r0.publishProgress(r3)
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                r0.u = r3
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                r0.f = r3
                r0.g = r4
                r9 = 0
                r0.h = r9
                r0.i = r9
                r0.j = r9
                android.content.Context r3 = r0.f1358a
                net.fxgear.fittingmodenative.e r3 = net.fxgear.fittingmodenative.e.a((android.content.Context) r3)
                java.util.ArrayList r3 = r3.b()
                int r7 = r3.size()
                if (r7 <= 0) goto L_0x07ec
                android.content.Context r7 = r0.f1358a
                net.fxgear.GlobalDefine$Result r7 = net.fxgear.fittingmodenative.d.e.a((android.content.Context) r7, (java.util.ArrayList<java.lang.String>) r3)
                int r9 = r7.resultCode
                if (r9 != r12) goto L_0x07da
                java.lang.Object r9 = r7.resultExtra
                if (r9 == 0) goto L_0x07da
                java.lang.Object r7 = r7.resultExtra
                java.util.HashMap r7 = (java.util.HashMap) r7
                java.util.Iterator r3 = r3.iterator()
            L_0x04f2:
                boolean r9 = r3.hasNext()
                if (r9 == 0) goto L_0x05b9
                java.lang.Object r9 = r3.next()
                java.lang.String r9 = (java.lang.String) r9
                java.lang.Object r10 = r7.get(r9)
                java.lang.String r10 = (java.lang.String) r10
                if (r10 == 0) goto L_0x0595
                java.lang.String r13 = r10.substring(r6)
                r14 = 16
                int r13 = java.lang.Integer.parseInt(r13, r14)
                android.content.Context r15 = r0.f1358a
                net.fxgear.fittingmodenative.e r15 = net.fxgear.fittingmodenative.e.a((android.content.Context) r15)
                int r15 = r15.b((java.lang.String) r9)
                java.lang.String r10 = r10.substring(r4, r6)
                byte r10 = java.lang.Byte.parseByte(r10, r14)
                r14 = 70
                if (r10 != r14) goto L_0x0528
                r10 = 1
                goto L_0x0529
            L_0x0528:
                r10 = 0
            L_0x0529:
                if (r10 == 0) goto L_0x0592
                if (r13 <= r15) goto L_0x0592
                android.content.Context r10 = r0.f1358a
                net.fxgear.fittingmodenative.e r10 = net.fxgear.fittingmodenative.e.a((android.content.Context) r10)
                java.lang.String r10 = r10.d((java.lang.String) r9)
                java.io.File r14 = new java.io.File
                r14.<init>(r10)
                boolean r14 = r14.exists()
                if (r14 == 0) goto L_0x0592
                net.fxgear.fittingmodenative.c$e$a r14 = new net.fxgear.fittingmodenative.c$e$a
                r15 = 0
                r14.<init>()
                r14.f1364a = r9
                r14.f1365b = r10
                r14.d = r13
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                java.lang.String r13 = net.fxgear.GlobalDefine.GetDataURL()
                r10.append(r13)
                java.lang.String r13 = java.io.File.separator
                r10.append(r13)
                r10.append(r9)
                java.lang.String r13 = java.io.File.separator
                r10.append(r13)
                r10.append(r9)
                java.lang.String r9 = ".zip"
                r10.append(r9)
                java.lang.String r9 = r10.toString()
                r14.c = r9
                java.util.ArrayList<net.fxgear.fittingmodenative.c$e$a> r9 = r0.u
                r9.add(r14)
                android.content.Context r9 = r0.f1358a
                java.lang.String r10 = r14.c
                long r9 = net.fxgear.fittingmodenative.d.c.a((android.content.Context) r9, (java.lang.String) r10)
                java.util.ArrayList<java.lang.Long> r13 = r0.f
                java.lang.Long r14 = java.lang.Long.valueOf(r9)
                r13.add(r14)
                long r13 = r0.h
                long r13 = r13 + r9
                r0.h = r13
                goto L_0x04f2
            L_0x0592:
                r15 = 0
                goto L_0x04f2
            L_0x0595:
                r15 = 0
                android.content.Context r10 = r0.f1358a
                net.fxgear.fittingmodenative.e r10 = net.fxgear.fittingmodenative.e.a((android.content.Context) r10)
                r10.c((java.lang.String) r9)
                java.lang.String r10 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>()
                java.lang.String r14 = "Remove base category : "
                r13.append(r14)
                r13.append(r9)
                java.lang.String r9 = r13.toString()
                android.util.Log.i(r10, r9)
                goto L_0x04f2
            L_0x05b9:
                java.util.ArrayList<net.fxgear.fittingmodenative.c$e$a> r3 = r0.u
                if (r3 == 0) goto L_0x07ec
                java.util.ArrayList<net.fxgear.fittingmodenative.c$e$a> r3 = r0.u
                boolean r3 = r3.isEmpty()
                if (r3 != 0) goto L_0x07ec
                java.lang.Integer[] r3 = new java.lang.Integer[r6]
                java.lang.Integer r7 = java.lang.Integer.valueOf(r2)
                r3[r4] = r7
                java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
                r3[r2] = r7
                r0.publishProgress(r3)
                java.util.ArrayList<net.fxgear.fittingmodenative.c$e$a> r3 = r0.u
                java.util.Iterator r3 = r3.iterator()
            L_0x05dc:
                boolean r7 = r3.hasNext()
                if (r7 == 0) goto L_0x07c6
                java.lang.Object r7 = r3.next()
                net.fxgear.fittingmodenative.c$e$a r7 = (net.fxgear.fittingmodenative.c.e.a) r7
                java.util.ArrayList<java.lang.Long> r9 = r0.f
                int r10 = r0.g
                java.lang.Object r9 = r9.get(r10)
                java.lang.Long r9 = (java.lang.Long) r9
                long r9 = r9.longValue()
                r0.j = r9
                java.io.File r9 = new java.io.File
                java.lang.String r10 = r7.f1365b
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>()
                java.lang.String r14 = r7.f1364a
                r13.append(r14)
                java.lang.String r14 = ".zip"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r9.<init>(r10, r13)
                android.content.Context r10 = r0.f1358a
                java.lang.String r13 = r7.c
                java.lang.String r14 = r9.getAbsolutePath()
                int r10 = net.fxgear.fittingmodenative.d.c.a(r10, r13, r14, r4, r0)
                if (r10 == r12) goto L_0x0665
                java.lang.String r13 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                r14.<init>()
                java.lang.String r15 = "ERROR :: download data file fail.("
                r14.append(r15)
                r14.append(r10)
                java.lang.String r15 = ", "
                r14.append(r15)
                java.lang.String r7 = r7.f1364a
                r14.append(r7)
                java.lang.String r7 = ")"
                r14.append(r7)
                java.lang.String r7 = r14.toString()
                android.util.Log.e(r13, r7)
                r7 = 4
                if (r10 != r7) goto L_0x0661
                java.util.ArrayList<java.lang.Long> r5 = r0.f
                int r7 = r0.g
                java.lang.Object r5 = r5.get(r7)
                java.lang.Long r5 = (java.lang.Long) r5
                long r13 = r5.longValue()
                net.fxgear.GlobalDefine$Result r5 = r0.f1359b
                java.lang.Long r7 = java.lang.Long.valueOf(r13)
                r5.resultExtra = r7
                r5 = r10
            L_0x0661:
                r11 = 0
                goto L_0x0795
            L_0x0665:
                byte r10 = net.fxgear.fittingmodenative.f.f(r9)
                int r13 = r7.d
                if (r10 != r13) goto L_0x0773
                boolean r10 = net.fxgear.fittingmodenative.f.e((java.io.File) r9)
                if (r10 == 0) goto L_0x0773
                java.io.File r10 = new java.io.File
                android.content.Context r13 = r0.f1358a
                java.io.File r13 = net.fxgear.GlobalDefine.GetTempDirectory(r13)
                long r14 = java.lang.System.currentTimeMillis()
                java.lang.String r14 = java.lang.String.valueOf(r14)
                r10.<init>(r13, r14)
                boolean r13 = r10.exists()
                if (r13 == 0) goto L_0x068f
                net.fxgear.util.FXUtil.DeleteDirectoryRecursive(r10)
            L_0x068f:
                long r13 = net.fxgear.fittingmodenative.f.b((java.io.File) r9)
                long r17 = net.fxgear.util.FXUtil.GetAvailableSpaceSize(r10)
                int r15 = (r13 > r17 ? 1 : (r13 == r17 ? 0 : -1))
                if (r15 >= 0) goto L_0x073f
                long r13 = net.fxgear.fittingmodenative.f.a((java.io.File) r9, (java.io.File) r10)
                r15 = 0
                int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
                if (r17 != 0) goto L_0x0724
                boolean r15 = r21.isCancelled()
                if (r15 != 0) goto L_0x0724
                java.io.File r13 = new java.io.File
                java.lang.String r14 = r7.f1365b
                r13.<init>(r14)
                boolean r14 = r13.exists()
                if (r14 != 0) goto L_0x06bb
                r13.mkdirs()
            L_0x06bb:
                java.io.File[] r14 = r10.listFiles()
                if (r14 == 0) goto L_0x06ff
                int r15 = r14.length
                if (r15 <= 0) goto L_0x06ff
                int r10 = r14.length
                r15 = 0
            L_0x06c6:
                if (r15 >= r10) goto L_0x06f0
                r11 = r14[r15]
                java.io.File r12 = new java.io.File
                java.lang.String r8 = r11.getName()
                r12.<init>(r13, r8)
                boolean r8 = r12.exists()
                if (r8 == 0) goto L_0x06e6
                boolean r8 = r12.isDirectory()
                if (r8 == 0) goto L_0x06e3
                net.fxgear.util.FXUtil.DeleteDirectoryRecursive(r12)
                goto L_0x06e6
            L_0x06e3:
                r12.delete()
            L_0x06e6:
                r11.renameTo(r12)
                int r15 = r15 + 1
                r8 = 100
                r11 = -2
                r12 = -1
                goto L_0x06c6
            L_0x06f0:
                android.content.Context r8 = r0.f1358a
                net.fxgear.fittingmodenative.e r8 = net.fxgear.fittingmodenative.e.a((android.content.Context) r8)
                java.lang.String r10 = r7.f1364a
                int r7 = r7.d
                r8.a((java.lang.String) r10, (int) r7)
                goto L_0x0661
            L_0x06ff:
                java.lang.String r5 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r11 = "ERROR :: empty zip file or wrong file.("
                r8.append(r11)
                java.lang.String r7 = r7.f1364a
                r8.append(r7)
                java.lang.String r7 = ")"
                r8.append(r7)
                java.lang.String r7 = r8.toString()
                android.util.Log.e(r5, r7)
                net.fxgear.util.FXUtil.DeleteDirectoryRecursive(r10)
                r5 = 3
                goto L_0x0661
            L_0x0724:
                r11 = 0
                int r5 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                if (r5 != 0) goto L_0x072c
                r5 = -2
                goto L_0x073b
            L_0x072c:
                int r5 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                if (r5 <= 0) goto L_0x073a
                net.fxgear.GlobalDefine$Result r5 = r0.f1359b
                java.lang.Long r7 = java.lang.Long.valueOf(r13)
                r5.resultExtra = r7
                r5 = 4
                goto L_0x073b
            L_0x073a:
                r5 = 3
            L_0x073b:
                net.fxgear.util.FXUtil.DeleteDirectoryRecursive(r10)
                goto L_0x0795
            L_0x073f:
                r11 = 0
                java.lang.String r5 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r13 = "ERROR :: INSUFFICIENT_SPACE("
                r8.append(r13)
                java.lang.String r7 = r7.f1364a
                r8.append(r7)
                java.lang.String r7 = ")"
                r8.append(r7)
                java.lang.String r7 = r8.toString()
                android.util.Log.e(r5, r7)
                net.fxgear.GlobalDefine$Result r5 = r0.f1359b
                long r7 = net.fxgear.fittingmodenative.f.b((java.io.File) r9)
                long r13 = net.fxgear.util.FXUtil.GetAvailableSpaceSize(r10)
                long r7 = r7 - r13
                java.lang.Long r7 = java.lang.Long.valueOf(r7)
                r5.resultExtra = r7
                r5 = 4
                goto L_0x0795
            L_0x0773:
                r11 = 0
                java.lang.String r5 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r10 = "ERROR :: Wrong base category zip file.("
                r8.append(r10)
                java.lang.String r7 = r7.f1364a
                r8.append(r7)
                java.lang.String r7 = ")"
                r8.append(r7)
                java.lang.String r7 = r8.toString()
                android.util.Log.e(r5, r7)
                r5 = 3
            L_0x0795:
                boolean r7 = r9.exists()
                if (r7 == 0) goto L_0x079e
                r9.delete()
            L_0x079e:
                r7 = 4
                if (r5 == r7) goto L_0x07c6
                boolean r8 = r21.isCancelled()
                if (r8 == 0) goto L_0x07a8
                goto L_0x07c6
            L_0x07a8:
                long r8 = r0.i
                java.util.ArrayList<java.lang.Long> r10 = r0.f
                int r13 = r0.g
                java.lang.Object r10 = r10.get(r13)
                java.lang.Long r10 = (java.lang.Long) r10
                long r13 = r10.longValue()
                long r8 = r8 + r13
                r0.i = r8
                int r8 = r0.g
                int r8 = r8 + r2
                r0.g = r8
                r8 = 100
                r11 = -2
                r12 = -1
                goto L_0x05dc
            L_0x07c6:
                java.lang.Integer[] r3 = new java.lang.Integer[r6]
                java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
                r3[r4] = r7
                r7 = 100
                java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
                r3[r2] = r8
                r0.publishProgress(r3)
                goto L_0x07ec
            L_0x07da:
                java.lang.String r3 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.String r5 = "ERROR :: Get base category network api fail."
                android.util.Log.e(r3, r5)
                int r3 = r7.resultCode
                net.fxgear.GlobalDefine$Result r5 = r0.f1359b
                java.lang.Object r7 = r7.resultExtra
                r5.resultExtra = r7
                r5 = r3
            L_0x07ec:
                java.lang.Integer[] r3 = new java.lang.Integer[r6]
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                r3[r4] = r1
                r1 = 100
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                r3[r2] = r1
                r0.publishProgress(r3)
                r2 = r5
                goto L_0x0811
            L_0x0801:
                r1 = 11
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                return r1
            L_0x0808:
                java.lang.String r1 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.String r3 = "ERROR :: param is null."
                android.util.Log.e(r1, r3)
            L_0x0811:
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.c.e.doInBackground(java.lang.Void[]):java.lang.Integer");
        }

        private void b() {
            e a2 = e.a(this.f1358a);
            ArrayList<e.c> c2 = a2.c();
            if (c2 != null) {
                Iterator<e.c> it = c2.iterator();
                while (it.hasNext()) {
                    e.c next = it.next();
                    if (!next.f.equals(GlobalDefine.REAL_VIDEO_BODY_SIZE_CUSTOM)) {
                        a2.a(next.f1465a, false);
                    }
                }
            }
        }

        private GlobalDefine.Result a(Context context) {
            ArrayList<e.c> c2;
            h.a[] aVarArr;
            int i2;
            int i3;
            int i4;
            e eVar = this;
            GlobalDefine.Result result = new GlobalDefine.Result();
            char c3 = 0;
            result.resultCode = 0;
            ArrayList arrayList = new ArrayList();
            e a2 = e.a(eVar.f1358a);
            e.f.b a3 = e.f.a("all", "all");
            if (a3 == null || a3.resultCode != -1) {
                result.resultCode = 10;
            } else if (a3.f1435a == null || a3.f1435a.f1448a == null) {
                result.resultCode = 3;
            } else {
                h.a[] aVarArr2 = a3.f1435a.f1448a;
                int length = aVarArr2.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    h.a aVar = aVarArr2[i5];
                    if (aVar.c != null) {
                        String a4 = c.b(aVar);
                        if (a4 == null || aVar.f1450a == null || aVar.f1450a.length() <= 0) {
                            result.resultCode = 3;
                        } else {
                            if (aVar.f1450a.equals(GlobalDefine.GENDER_WOMAN_STRING)) {
                                i4 = 1;
                            } else if (aVar.f1450a.equals(GlobalDefine.GENDER_MAN_STRING)) {
                                i4 = 2;
                            } else {
                                i3 = i5;
                                i2 = length;
                                aVarArr = aVarArr2;
                                String a5 = c.f1328a;
                                Log.e(a5, "[ERROR] :: Wrong value in InitDefaultRealData(), item.gender : " + aVar.f1450a);
                            }
                            int i6 = aVar.f1451b ? 1 : 2;
                            Object[] objArr = new Object[1];
                            objArr[c3] = a4;
                            String format = String.format(GlobalDefine.FILE_NAME_FORMAT_VIDEO, objArr);
                            Object[] objArr2 = new Object[1];
                            objArr2[c3] = a4;
                            String format2 = String.format(GlobalDefine.FILE_NAME_FORMAT_ANIMATION, objArr2);
                            File GetRealDirectory = GlobalDefine.GetRealDirectory(eVar.f1358a, i4, i6);
                            String valueOf = (!new File(GetRealDirectory, format).exists() || !new File(GetRealDirectory, format2).exists()) ? GlobalDefine.REAL_VIDEO_NONE_DATE : String.valueOf(System.currentTimeMillis());
                            String str = aVar.d;
                            String str2 = aVar.c;
                            int i7 = i6;
                            int i8 = i4;
                            String str3 = a4;
                            String str4 = a4;
                            String str5 = str;
                            i3 = i5;
                            String str6 = str2;
                            i2 = length;
                            String str7 = aVar.e;
                            aVarArr = aVarArr2;
                            int a6 = a2.a(i4, i7, valueOf, str3, str5, str6, str7, aVar.f);
                            if (i8 == 2) {
                                int i9 = i7;
                                if (i9 != 1) {
                                    String str8 = str4;
                                    if (i9 != 2) {
                                        String a7 = c.f1328a;
                                        Log.e(a7, "[ERROR] :: Wrong value in InitDefaultRealData(), gender : " + i8 + ", age : " + i9);
                                    } else if (str8.equals(GlobalDefine.REAL_VIDEO_DEFAULT_SIZE_MAN)) {
                                        arrayList.add(Integer.valueOf(a6));
                                    }
                                } else if (str4.equals(GlobalDefine.REAL_VIDEO_DEFAULT_SIZE_BOY)) {
                                    arrayList.add(Integer.valueOf(a6));
                                }
                            } else {
                                int i10 = i7;
                                String str9 = str4;
                                if (i8 != 1) {
                                    String a8 = c.f1328a;
                                    Log.e(a8, "[ERROR] :: Wrong value in InitDefaultRealData(), gender : " + i8 + ", age : " + i10);
                                } else if (i10 == 1) {
                                    if (str9.equals(GlobalDefine.REAL_VIDEO_DEFAULT_SIZE_GIRL)) {
                                        arrayList.add(Integer.valueOf(a6));
                                    }
                                } else if (i10 != 2) {
                                    String a9 = c.f1328a;
                                    Log.e(a9, "[ERROR] :: Wrong value in InitDefaultRealData(), gender : " + i8 + ", age : " + i10);
                                } else if (str9.equals(GlobalDefine.REAL_VIDEO_DEFAULT_SIZE_WOMAN)) {
                                    arrayList.add(Integer.valueOf(a6));
                                }
                            }
                        }
                    } else {
                        i3 = i5;
                        i2 = length;
                        aVarArr = aVarArr2;
                    }
                    i5 = i3 + 1;
                    length = i2;
                    aVarArr2 = aVarArr;
                    eVar = this;
                    c3 = 0;
                }
                result.resultCode = 3;
                if (isCancelled() || Thread.currentThread().isInterrupted()) {
                    result.resultCode = -2;
                } else if (!arrayList.isEmpty()) {
                    GlobalDefine.Result a10 = a(a2, (ArrayList<Integer>) arrayList);
                    if (a10.resultCode == -1) {
                        this.g = 0;
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            e.c g2 = a2.g(((Integer) it.next()).intValue());
                            GlobalDefine.Result a11 = a(g2, g2.j, g2.g);
                            result.resultCode = a11.resultCode;
                            if (a11.resultCode != -1) {
                                result.resultExtra = a11.resultExtra;
                                break;
                            }
                        }
                    } else {
                        result = a10;
                    }
                } else {
                    result.resultCode = 3;
                }
            }
            if (!(result.resultCode == -1 || (c2 = a2.c()) == null)) {
                Iterator<e.c> it2 = c2.iterator();
                while (it2.hasNext()) {
                    e.c next = it2.next();
                    if (!next.f.equals(GlobalDefine.REAL_VIDEO_BODY_SIZE_CUSTOM)) {
                        a2.f(next.f1465a);
                    }
                }
            }
            return result;
        }

        private GlobalDefine.Result b(Context context) {
            ArrayList<e.c> c2;
            int i2;
            h.a[] aVarArr;
            int i3;
            int i4;
            int i5;
            GlobalDefine.Result result = new GlobalDefine.Result();
            result.resultCode = 0;
            ArrayList arrayList = new ArrayList();
            e a2 = e.a(this.f1358a);
            e.f.b a3 = e.f.a("all", "1");
            if (a3 == null || a3.resultCode != -1) {
                result.resultCode = 10;
            } else if (a3.f1435a == null || a3.f1435a.f1448a == null) {
                result.resultCode = 3;
            } else {
                h.a[] aVarArr2 = a3.f1435a.f1448a;
                int length = aVarArr2.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        i2 = 3;
                        break;
                    }
                    h.a aVar = aVarArr2[i6];
                    if (aVar.c != null) {
                        String a4 = c.b(aVar);
                        if (a4 == null || aVar.f1450a == null || aVar.f1450a.length() <= 0) {
                            i2 = 3;
                            result.resultCode = 3;
                        } else {
                            if (aVar.f1450a.equals(GlobalDefine.GENDER_WOMAN_STRING)) {
                                i5 = 1;
                            } else if (aVar.f1450a.equals(GlobalDefine.GENDER_MAN_STRING)) {
                                i5 = 2;
                            } else {
                                i4 = i6;
                                i3 = length;
                                aVarArr = aVarArr2;
                                String a5 = c.f1328a;
                                Log.e(a5, "[ERROR] :: Wrong value in DownloadKidsDefaultRealVideo(), item.gender : " + aVar.f1450a);
                            }
                            String str = aVar.d;
                            String str2 = str;
                            int i7 = i5;
                            String str3 = a4;
                            i4 = i6;
                            i3 = length;
                            aVarArr = aVarArr2;
                            int a6 = a2.a(i5, 1, GlobalDefine.REAL_VIDEO_NONE_DATE, a4, str2, aVar.c, aVar.e, aVar.f);
                            if (i7 != 2) {
                                String str4 = str3;
                                if (i7 != 1) {
                                    String a7 = c.f1328a;
                                    Log.e(a7, "[ERROR] :: Wrong value in DownloadKidsDefaultRealVideo(), gender : " + i7 + ", age : " + 1);
                                } else if (str4.equals(GlobalDefine.REAL_VIDEO_DEFAULT_SIZE_GIRL)) {
                                    arrayList.add(Integer.valueOf(a6));
                                }
                            } else if (str3.equals(GlobalDefine.REAL_VIDEO_DEFAULT_SIZE_BOY)) {
                                arrayList.add(Integer.valueOf(a6));
                            }
                        }
                    } else {
                        i4 = i6;
                        i3 = length;
                        aVarArr = aVarArr2;
                    }
                    i6 = i4 + 1;
                    length = i3;
                    aVarArr2 = aVarArr;
                }
                if (isCancelled() || Thread.currentThread().isInterrupted()) {
                    result.resultCode = -2;
                } else if (!arrayList.isEmpty()) {
                    GlobalDefine.Result a8 = a(a2, (ArrayList<Integer>) arrayList);
                    if (a8.resultCode == -1) {
                        this.g = 0;
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            e.c g2 = a2.g(((Integer) it.next()).intValue());
                            GlobalDefine.Result a9 = a(g2, g2.j, g2.g);
                            result.resultCode = a9.resultCode;
                            if (a9.resultCode != -1) {
                                result.resultExtra = a9.resultExtra;
                                break;
                            }
                        }
                    } else {
                        result = a8;
                    }
                } else {
                    result.resultCode = i2;
                }
            }
            if (!(result.resultCode == -1 || (c2 = a2.c()) == null)) {
                Iterator<e.c> it2 = c2.iterator();
                while (it2.hasNext()) {
                    e.c next = it2.next();
                    if (next.c == 1) {
                        a2.f(next.f1465a);
                    }
                }
            }
            return result;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onProgressUpdate(Integer... numArr) {
            if (this.c != null) {
                int intValue = numArr[0].intValue();
                int intValue2 = numArr[1].intValue();
                if (numArr.length == 3) {
                    this.t = numArr[2].intValue();
                }
                this.c.a(intValue, 100, ((int) ((((float) this.t) / 3.0f) * 100.0f)) + ((int) (((float) intValue2) / 3.0f)));
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Integer num) {
            this.f1359b.resultCode = num.intValue();
            if (this.c != null) {
                this.c.a(this.f1359b);
            }
        }

        public void a(int i2) {
            if (this.f != null && this.f.size() > 0) {
                publishProgress(new Integer[]{1, Integer.valueOf((int) (((this.i + ((this.j * ((long) i2)) / 100)) * 100) / this.h))});
            } else if (i2 < 0) {
                publishProgress(new Integer[]{1, 0});
            } else if (i2 >= 100) {
                publishProgress(new Integer[]{1, 100});
            } else {
                publishProgress(new Integer[]{1, Integer.valueOf(i2)});
            }
        }

        private int a(Context context, File file) {
            Log.d(c.f1328a, "InitializeFittingFiles()+");
            if (context == null || file == null || !file.exists()) {
                Log.e(c.f1328a, "ERROR :: param is wrong.");
                return 1;
            }
            File GetTempDirectory = GlobalDefine.GetTempDirectory(context);
            if (GetTempDirectory.exists()) {
                FXUtil.DeleteDirectoryRecursive(GetTempDirectory);
            }
            long a2 = f.a(file, GetTempDirectory);
            int i2 = 3;
            if (a2 == 0) {
                File GetRootDirectory = GlobalDefine.GetRootDirectory(context);
                ArrayList<String> c2 = f.c(file);
                if (c2 != null) {
                    Iterator<String> it = c2.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        File file2 = new File(GetTempDirectory, next);
                        if (file2.exists() && file2.isFile()) {
                            File file3 = new File(GetRootDirectory, next);
                            if (file3.exists()) {
                                file3.delete();
                            } else if (!file3.getParentFile().exists()) {
                                file3.getParentFile().mkdirs();
                            }
                            file2.renameTo(file3);
                        }
                    }
                    i2 = -1;
                } else {
                    Log.e(c.f1328a, "ERROR :: wrong zip file.");
                }
            } else {
                Log.e(c.f1328a, "ERROR :: unzip fail.");
                if (a2 > 0) {
                    this.f1359b.resultExtra = Long.valueOf(a2);
                    i2 = 4;
                }
            }
            FXUtil.DeleteDirectoryRecursive(GetTempDirectory);
            return i2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a4, code lost:
            if (r8.f > r10.j) goto L_0x00e8;
         */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x00ea  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x0163 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private net.fxgear.GlobalDefine.Result c() {
            /*
                r15 = this;
                java.lang.String r0 = "all"
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.lang.String r3 = "all"
                net.fxgear.fittingmodenative.d.e$f$b r0 = net.fxgear.fittingmodenative.d.e.f.a((java.lang.String) r3, (java.lang.String) r0)
                net.fxgear.GlobalDefine$Result r3 = new net.fxgear.GlobalDefine$Result
                r3.<init>()
                int r4 = r0.resultCode
                r3.resultCode = r4
                if (r0 == 0) goto L_0x01c7
                int r4 = r0.resultCode
                r5 = -1
                if (r4 != r5) goto L_0x01c7
                net.fxgear.fittingmodenative.d.h r4 = r0.f1435a
                if (r4 == 0) goto L_0x01c7
                net.fxgear.fittingmodenative.d.h r4 = r0.f1435a
                net.fxgear.fittingmodenative.d.h$a[] r4 = r4.f1448a
                if (r4 == 0) goto L_0x01c7
                net.fxgear.fittingmodenative.d.h r0 = r0.f1435a
                net.fxgear.fittingmodenative.d.h$a[] r0 = r0.f1448a
                int r4 = r0.length
                r6 = 0
                r7 = 0
            L_0x0033:
                if (r7 >= r4) goto L_0x0167
                r8 = r0[r7]
                java.lang.String r9 = r8.c
                if (r9 == 0) goto L_0x015a
                java.lang.String r9 = net.fxgear.fittingmodenative.c.b((net.fxgear.fittingmodenative.d.h.a) r8)
                if (r9 == 0) goto L_0x0150
                java.lang.String r10 = r8.f1450a
                if (r10 == 0) goto L_0x0150
                java.lang.String r10 = r8.f1450a
                boolean r10 = r10.isEmpty()
                if (r10 != 0) goto L_0x0150
                android.content.Context r10 = r15.f1358a
                java.lang.String r11 = r8.f1450a
                boolean r12 = r8.f1451b
                net.fxgear.fittingmodenative.e$c r10 = net.fxgear.fittingmodenative.c.b(r10, r11, r12, r9)
                if (r10 == 0) goto L_0x0128
                int r11 = r10.f1466b
                r12 = 2
                r13 = 1
                if (r11 != r13) goto L_0x007a
                int r11 = r10.c
                if (r11 != r13) goto L_0x006d
                java.lang.String r11 = "130"
                boolean r9 = r9.equals(r11)
                if (r9 == 0) goto L_0x0098
            L_0x006b:
                r9 = 1
                goto L_0x0099
            L_0x006d:
                int r11 = r10.c
                if (r11 != r12) goto L_0x0098
                java.lang.String r11 = "44"
                boolean r9 = r9.equals(r11)
                if (r9 == 0) goto L_0x0098
                goto L_0x006b
            L_0x007a:
                int r11 = r10.f1466b
                if (r11 != r12) goto L_0x0098
                int r11 = r10.c
                if (r11 != r13) goto L_0x008b
                java.lang.String r11 = "160"
                boolean r9 = r9.equals(r11)
                if (r9 == 0) goto L_0x0098
                goto L_0x006b
            L_0x008b:
                int r11 = r10.c
                if (r11 != r12) goto L_0x0098
                java.lang.String r11 = "105"
                boolean r9 = r9.equals(r11)
                if (r9 == 0) goto L_0x0098
                goto L_0x006b
            L_0x0098:
                r9 = 0
            L_0x0099:
                if (r9 == 0) goto L_0x00a7
                int r9 = r10.d
                if (r9 == r13) goto L_0x00a0
                goto L_0x00e8
            L_0x00a0:
                int r9 = r8.f
                int r11 = r10.j
                if (r9 <= r11) goto L_0x00e7
                goto L_0x00e8
            L_0x00a7:
                java.lang.String r9 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                java.lang.String r12 = "Local Video Version : "
                r11.append(r12)
                int r12 = r10.j
                r11.append(r12)
                java.lang.String r12 = ", newest Version : "
                r11.append(r12)
                int r12 = r8.f
                r11.append(r12)
                java.lang.String r11 = r11.toString()
                android.util.Log.i(r9, r11)
                int r9 = r8.f
                int r11 = r10.j
                if (r9 <= r11) goto L_0x00e7
                int r9 = r10.d
                if (r9 != r13) goto L_0x00d6
                goto L_0x00e8
            L_0x00d6:
                android.content.Context r9 = r15.f1358a
                net.fxgear.fittingmodenative.e r9 = net.fxgear.fittingmodenative.e.a((android.content.Context) r9)
                int r11 = r10.f1465a
                java.lang.String r12 = r10.e
                int r13 = r8.f
                java.lang.String r14 = r8.e
                r9.a((int) r11, (java.lang.String) r12, (int) r13, (java.lang.String) r14)
            L_0x00e7:
                r13 = 0
            L_0x00e8:
                if (r13 == 0) goto L_0x0163
                java.lang.String r9 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                java.lang.String r12 = "Download new video file : "
                r11.append(r12)
                int r12 = r10.f1465a
                r11.append(r12)
                java.lang.String r11 = r11.toString()
                android.util.Log.i(r9, r11)
                android.content.Context r9 = r15.f1358a
                net.fxgear.fittingmodenative.e r9 = net.fxgear.fittingmodenative.e.a((android.content.Context) r9)
                int r11 = r10.f1465a
                java.lang.String r12 = r10.e
                int r13 = r10.j
                java.lang.String r14 = r8.e
                r9.a((int) r11, (java.lang.String) r12, (int) r13, (java.lang.String) r14)
                int r9 = r10.f1465a
                java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
                r1.add(r9)
                int r8 = r8.f
                java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
                r2.add(r8)
                goto L_0x0163
            L_0x0128:
                java.lang.String r10 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                java.lang.String r12 = "Real data is null(gender : "
                r11.append(r12)
                java.lang.String r8 = r8.f1450a
                r11.append(r8)
                java.lang.String r8 = ", body size : "
                r11.append(r8)
                r11.append(r9)
                java.lang.String r8 = ")"
                r11.append(r8)
                java.lang.String r8 = r11.toString()
                android.util.Log.d(r10, r8)
                goto L_0x0163
            L_0x0150:
                java.lang.String r8 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.String r9 = "Wrong size & gender"
                android.util.Log.d(r8, r9)
                goto L_0x0163
            L_0x015a:
                java.lang.String r8 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.String r9 = "video url is null."
                android.util.Log.d(r8, r9)
            L_0x0163:
                int r7 = r7 + 1
                goto L_0x0033
            L_0x0167:
                boolean r0 = r15.isCancelled()
                if (r0 != 0) goto L_0x01c4
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                boolean r0 = r0.isInterrupted()
                if (r0 == 0) goto L_0x0178
                goto L_0x01c4
            L_0x0178:
                boolean r0 = r1.isEmpty()
                if (r0 != 0) goto L_0x01c7
                android.content.Context r0 = r15.f1358a
                net.fxgear.fittingmodenative.e r0 = net.fxgear.fittingmodenative.e.a((android.content.Context) r0)
                net.fxgear.GlobalDefine$Result r4 = r15.a((net.fxgear.fittingmodenative.e) r0, (java.util.ArrayList<java.lang.Integer>) r1)
                int r7 = r4.resultCode
                if (r7 == r5) goto L_0x018e
                r3 = r4
                goto L_0x01c7
            L_0x018e:
                r15.g = r6
            L_0x0190:
                int r4 = r1.size()
                if (r6 >= r4) goto L_0x01c7
                java.lang.Object r4 = r1.get(r6)
                java.lang.Integer r4 = (java.lang.Integer) r4
                int r4 = r4.intValue()
                java.lang.Object r7 = r2.get(r6)
                java.lang.Integer r7 = (java.lang.Integer) r7
                int r7 = r7.intValue()
                net.fxgear.fittingmodenative.e$c r4 = r0.g(r4)
                java.lang.String r8 = r4.g
                net.fxgear.GlobalDefine$Result r4 = r15.a((net.fxgear.fittingmodenative.e.c) r4, (int) r7, (java.lang.String) r8)
                int r7 = r4.resultCode
                r3.resultCode = r7
                int r7 = r4.resultCode
                if (r7 == r5) goto L_0x01c1
                java.lang.Object r0 = r4.resultExtra
                r3.resultExtra = r0
                goto L_0x01c7
            L_0x01c1:
                int r6 = r6 + 1
                goto L_0x0190
            L_0x01c4:
                r0 = -2
                r3.resultCode = r0
            L_0x01c7:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.c.e.c():net.fxgear.GlobalDefine$Result");
        }

        private GlobalDefine.Result a(e eVar, ArrayList<Integer> arrayList) {
            Log.d(c.f1328a, "GenerateDownloadVideoInfo()+");
            GlobalDefine.Result result = new GlobalDefine.Result();
            result.resultCode = -1;
            if (eVar == null || arrayList == null) {
                Log.e(c.f1328a, "[ERROR] :: wrong param");
                result.resultCode = 1;
                return result;
            }
            this.f = new ArrayList<>();
            this.h = 0;
            Iterator<Integer> it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    int intValue = it.next().intValue();
                    e.c g2 = eVar.g(intValue);
                    if (g2 == null) {
                        Log.e(c.f1328a, "[ERROR] :: realData is null, realVideoID: " + intValue);
                        break;
                    }
                    long a2 = net.fxgear.fittingmodenative.d.c.a(this.f1358a, g2.h);
                    if (a2 <= 0) {
                        Log.e(c.f1328a, "[ERROR] :: file size is wrong, url - " + g2.h);
                        result.resultCode = 3;
                        break;
                    }
                    this.h += a2;
                    this.f.add(Long.valueOf(a2));
                    long a3 = net.fxgear.fittingmodenative.d.c.a(this.f1358a, g2.i);
                    if (a3 <= 0) {
                        Log.e(c.f1328a, "[ERROR] :: file size is wrong, url - " + g2.i);
                        result.resultCode = 3;
                        break;
                    }
                    this.h += a3;
                    this.f.add(Long.valueOf(a3));
                } else {
                    break;
                }
            }
            if (result.resultCode != -1) {
                if (this.f != null) {
                    this.f.clear();
                    this.f = null;
                }
                this.h = 0;
            }
            return result;
        }

        private GlobalDefine.Result a(e.c cVar, int i2, String str) {
            e.c cVar2 = cVar;
            GlobalDefine.Result result = new GlobalDefine.Result();
            result.resultCode = 0;
            e a2 = e.a(this.f1358a);
            if (a2 != null) {
                if (cVar2 != null) {
                    String absolutePath = GlobalDefine.GetRealDirectory(this.f1358a, cVar2.f1466b, cVar2.c).getAbsolutePath();
                    long GetAvailableSpaceSize = FXUtil.GetAvailableSpaceSize(new File(absolutePath));
                    if (this.h < GetAvailableSpaceSize) {
                        String str2 = null;
                        if (this.d != null && !this.d.isEmpty()) {
                            this.d.clear();
                            this.d = null;
                        }
                        this.d = new ArrayList<>();
                        String[] split = cVar2.h.split("/");
                        int i3 = 1;
                        while (true) {
                            if (i3 >= split.length) {
                                break;
                            } else if (split[i3].contains(GlobalDefine.EXTENSION_BIN)) {
                                str2 = split[i3 - 1];
                                break;
                            } else {
                                i3++;
                            }
                        }
                        String str3 = str2;
                        String str4 = absolutePath + File.separator + String.format(GlobalDefine.FILE_NAME_FORMAT_ANIMATION, new Object[]{str3});
                        C0047c cVar3 = r0;
                        C0047c cVar4 = new C0047c(cVar2.h, str4, net.fxgear.fittingmodenative.d.c.a(this.f1358a, cVar2.h));
                        this.d.add(cVar3);
                        this.d.add(new C0047c(cVar2.i, absolutePath + File.separator + String.format(GlobalDefine.FILE_NAME_FORMAT_VIDEO, new Object[]{str3}), net.fxgear.fittingmodenative.d.c.a(this.f1358a, cVar2.i)));
                        if (!this.d.isEmpty()) {
                            Iterator<C0047c> it = this.d.iterator();
                            while (it.hasNext()) {
                                C0047c next = it.next();
                                this.j = this.f.get(this.g).longValue();
                                int a3 = net.fxgear.fittingmodenative.d.c.a(this.f1358a, next.f1372a, next.c, false, this);
                                if (a3 != -1) {
                                    if (a3 == 4) {
                                        result.resultExtra = Long.valueOf(next.d);
                                    }
                                    e();
                                    result.resultCode = a3;
                                    return result;
                                }
                                this.i += this.j;
                                this.g++;
                            }
                            result.resultCode = -1;
                        } else {
                            result.resultCode = 2;
                        }
                    } else {
                        result.resultCode = 4;
                        result.resultExtra = Long.valueOf(this.h - GetAvailableSpaceSize);
                    }
                } else {
                    result.resultCode = 2;
                }
            }
            if (result.resultCode == -1) {
                d();
                a2.a(cVar2.f1465a, String.valueOf(System.currentTimeMillis()), i2, str);
                if (this.f1359b.resultCode != -2) {
                    FXUtil.PrintFileListFromDirectory(GlobalDefine.GetRealDirectory(this.f1358a), "[J] ");
                }
            } else {
                e();
            }
            return result;
        }

        private void d() {
            Log.d(c.f1328a, "MoveTempDownFileToOriginPath()+");
            if (this.d != null) {
                Iterator<C0047c> it = this.d.iterator();
                while (it.hasNext()) {
                    C0047c next = it.next();
                    File file = new File(next.f1373b);
                    if (file.exists()) {
                        file.delete();
                    }
                    new File(next.c).renameTo(file);
                }
            }
        }

        private void e() {
            Log.d(c.f1328a, "DeleteDownloadFiles()+");
            if (this.d != null) {
                Iterator<C0047c> it = this.d.iterator();
                while (it.hasNext()) {
                    File file = new File(it.next().c);
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }
        }

        private GlobalDefine.Result f() {
            int GetClothType;
            File file;
            GlobalDefine.Result result = new GlobalDefine.Result();
            result.resultCode = 0;
            File file2 = new File(FXUtil.getFilesDir(this.f1358a), GlobalDefine.UNITY_CLOTH_DATA_DIRECTORY_NAME);
            if (!file2.exists() || !file2.isDirectory()) {
                Log.i(c.f1328a, "DAT directory is not exists or not directory");
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(GlobalDefine.EXTENSION_ZIP);
                arrayList.add(GlobalDefine.EXTENSION_PNG);
                File[] listFiles = file2.listFiles();
                for (File file3 : listFiles) {
                    if (isCancelled() || Thread.currentThread().isInterrupted()) {
                        result.resultCode = -2;
                        return result;
                    }
                    if (file3.isDirectory() && ((file3.getName().startsWith("WomClo") || file3.getName().startsWith("ManClo")) && (GetClothType = FXUtil.GetClothType(file3.getName())) != -1)) {
                        int i2 = file3.getName().startsWith("ManClo") ? 2 : 1;
                        if (file3.getName().length() > 12) {
                            file = GlobalDefine.GetClothTypeDirectory(this.f1358a, i2, 2, GetClothType);
                        } else {
                            file = GlobalDefine.GetClothTypeBaseDirectory(this.f1358a, i2, 2, GetClothType);
                        }
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        GlobalDefine.Result CopyFileRecursive = FXUtil.CopyFileRecursive(file3, new File(file, file3.getName()), arrayList);
                        if (CopyFileRecursive.resultCode != -1) {
                            return CopyFileRecursive;
                        }
                    }
                }
            }
            result.resultCode = -1;
            return result;
        }

        private boolean a(String str, String str2, int i2) {
            SharedPreferences sharedPreferences = this.f1358a.getSharedPreferences(GlobalDefine.UNITY_PREFERENCE_NAME, 0);
            String format = String.format(GlobalDefine.UNITY_REAL_VIDEO_VERSION_PERFERENCE_FORMAT, new Object[]{str, str2});
            if (!sharedPreferences.contains(format) || Integer.parseInt(sharedPreferences.getString(format, GlobalDefine.REAL_VIDEO_NONE_DATE)) < i2) {
                return false;
            }
            return true;
        }

        private GlobalDefine.Result a(b bVar) {
            GlobalDefine.Result result = new GlobalDefine.Result();
            result.resultCode = 0;
            File file = new File(bVar.f1368a);
            File file2 = new File(bVar.d);
            File file3 = new File(bVar.c);
            File file4 = new File(bVar.f);
            long GetFileSize = FXUtil.GetFileSize(file) + FXUtil.GetFileSize(file2);
            File parentFile = file3.getParentFile();
            if (GetFileSize > FXUtil.GetAvailableSpaceSize(parentFile)) {
                result.resultCode = 4;
                result.resultExtra = Long.valueOf(GetFileSize);
                return result;
            }
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            FXUtil.CopyFile(file, file3);
            FXUtil.CopyFile(file2, file4);
            result.resultCode = -1;
            return result;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0121, code lost:
            return r11;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private net.fxgear.GlobalDefine.Result g() {
            /*
                r25 = this;
                r10 = r25
                net.fxgear.GlobalDefine$Result r11 = new net.fxgear.GlobalDefine$Result
                r11.<init>()
                r12 = 0
                r11.resultCode = r12
                java.util.ArrayList<net.fxgear.fittingmodenative.c$e$b> r0 = r10.e
                r13 = 0
                if (r0 == 0) goto L_0x0016
                java.util.ArrayList<net.fxgear.fittingmodenative.c$e$b> r0 = r10.e
                r0.clear()
                r10.e = r13
            L_0x0016:
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                r10.e = r0
                android.content.Context r0 = r10.f1358a
                net.fxgear.fittingmodenative.e r0 = net.fxgear.fittingmodenative.e.a((android.content.Context) r0)
                java.util.ArrayList r0 = r0.c()
                java.util.Iterator r14 = r0.iterator()
            L_0x002b:
                boolean r0 = r14.hasNext()
                r15 = -2
                r7 = 2
                r8 = 1
                if (r0 == 0) goto L_0x0122
                java.lang.Object r0 = r14.next()
                net.fxgear.fittingmodenative.e$c r0 = (net.fxgear.fittingmodenative.e.c) r0
                java.lang.String r1 = r0.f
                java.lang.String r2 = "44"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x002b
                java.lang.String r1 = r0.f
                java.lang.String r2 = "105"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x004f
                goto L_0x002b
            L_0x004f:
                boolean r1 = r25.isCancelled()
                if (r1 != 0) goto L_0x011f
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                boolean r1 = r1.isInterrupted()
                if (r1 == 0) goto L_0x0061
                goto L_0x011f
            L_0x0061:
                java.lang.String r1 = "woman"
                int r2 = r0.f1466b
                if (r2 != r7) goto L_0x0069
                java.lang.String r1 = "man"
            L_0x0069:
                net.fxgear.FittingView$RealVideoFileInfo r2 = r0.k
                java.lang.String r2 = r2.mVideoFilePath
                if (r2 == 0) goto L_0x0079
                java.io.File r2 = new java.io.File
                net.fxgear.FittingView$RealVideoFileInfo r3 = r0.k
                java.lang.String r3 = r3.mVideoFilePath
                r2.<init>(r3)
                goto L_0x007a
            L_0x0079:
                r2 = r13
            L_0x007a:
                net.fxgear.FittingView$RealVideoFileInfo r3 = r0.k
                java.lang.String r3 = r3.mAnimationFilePath
                if (r3 == 0) goto L_0x008a
                java.io.File r3 = new java.io.File
                net.fxgear.FittingView$RealVideoFileInfo r4 = r0.k
                java.lang.String r4 = r4.mAnimationFilePath
                r3.<init>(r4)
                goto L_0x008b
            L_0x008a:
                r3 = r13
            L_0x008b:
                java.lang.String r4 = r0.f
                int r5 = r0.j
                boolean r4 = r10.a((java.lang.String) r1, (java.lang.String) r4, (int) r5)
                if (r4 == 0) goto L_0x011b
                java.io.File r4 = new java.io.File
                android.content.Context r5 = r10.f1358a
                java.io.File r5 = net.fxgear.util.FXUtil.getFilesDir(r5)
                java.lang.String r6 = "REC"
                r4.<init>(r5, r6)
                java.lang.String r5 = "%s_%s_Video.mp4"
                java.lang.Object[] r6 = new java.lang.Object[r7]
                r6[r12] = r1
                java.lang.String r9 = r0.f
                r6[r8] = r9
                java.lang.String r5 = java.lang.String.format(r5, r6)
                java.lang.String r6 = "%s_%s_Animation.bin"
                java.lang.Object[] r9 = new java.lang.Object[r7]
                r9[r12] = r1
                java.lang.String r1 = r0.f
                r9[r8] = r1
                java.lang.String r1 = java.lang.String.format(r6, r9)
                java.io.File r6 = new java.io.File
                r6.<init>(r4, r5)
                java.io.File r5 = new java.io.File
                r5.<init>(r4, r1)
                boolean r1 = r6.exists()
                if (r1 == 0) goto L_0x002b
                boolean r1 = r5.exists()
                if (r1 != 0) goto L_0x00d6
                goto L_0x002b
            L_0x00d6:
                net.fxgear.fittingmodenative.c$e$b r9 = new net.fxgear.fittingmodenative.c$e$b
                int r4 = r0.f1465a
                java.lang.String r17 = r6.getAbsolutePath()
                java.lang.String r5 = r5.getAbsolutePath()
                java.lang.String r18 = r2.getAbsolutePath()
                java.lang.String r19 = r3.getAbsolutePath()
                long r20 = r6.lastModified()
                r22 = 0
                r0 = r9
                r1 = r25
                r2 = r4
                r3 = r17
                r4 = r5
                r5 = r18
                r6 = r19
                r13 = 1
                r7 = r20
                r13 = r9
                r12 = -1
                r9 = r22
                r0.<init>(r2, r3, r4, r5, r6, r7, r9)
                java.util.ArrayList<net.fxgear.fittingmodenative.c$e$b> r0 = r10.e
                r0.add(r13)
                net.fxgear.GlobalDefine$Result r0 = r10.a((net.fxgear.fittingmodenative.c.e.b) r13)
                int r1 = r0.resultCode
                r11.resultCode = r1
                int r1 = r0.resultCode
                if (r1 == r12) goto L_0x011b
                java.lang.Object r0 = r0.resultExtra
                r11.resultExtra = r0
                goto L_0x0123
            L_0x011b:
                r12 = 0
                r13 = 0
                goto L_0x002b
            L_0x011f:
                r11.resultCode = r15
                return r11
            L_0x0122:
                r12 = -1
            L_0x0123:
                java.util.ArrayList<net.fxgear.fittingmodenative.c$e$b> r0 = r10.e
                if (r0 == 0) goto L_0x013d
                java.util.ArrayList<net.fxgear.fittingmodenative.c$e$b> r0 = r10.e
                boolean r0 = r0.isEmpty()
                if (r0 != 0) goto L_0x013d
                int r0 = r11.resultCode
                if (r0 == r12) goto L_0x0134
                return r11
            L_0x0134:
                boolean r0 = r25.isCancelled()
                if (r0 == 0) goto L_0x013f
                r11.resultCode = r15
                return r11
            L_0x013d:
                r11.resultCode = r12
            L_0x013f:
                java.io.File r0 = new java.io.File
                android.content.Context r1 = r10.f1358a
                java.io.File r1 = net.fxgear.util.FXUtil.getFilesDir(r1)
                java.lang.String r2 = "REC"
                r0.<init>(r1, r2)
                java.io.File r13 = new java.io.File
                java.lang.String r1 = "USER"
                r13.<init>(r0, r1)
                boolean r0 = r13.exists()
                if (r0 == 0) goto L_0x02bc
                boolean r0 = r13.isDirectory()
                if (r0 == 0) goto L_0x02bc
                java.util.ArrayList r14 = new java.util.ArrayList
                r14.<init>()
                java.lang.String[] r9 = r13.list()
                if (r9 == 0) goto L_0x02bc
                int r0 = r9.length
                if (r0 <= 0) goto L_0x02bc
                int r7 = r9.length
                r8 = 0
            L_0x016f:
                if (r8 >= r7) goto L_0x02bc
                r0 = r9[r8]
                boolean r1 = r25.isCancelled()
                if (r1 != 0) goto L_0x02b8
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                boolean r1 = r1.isInterrupted()
                if (r1 == 0) goto L_0x0185
                goto L_0x02b8
            L_0x0185:
                java.lang.String r1 = "_"
                java.lang.String[] r1 = r0.split(r1)
                if (r1 == 0) goto L_0x028c
                int r2 = r1.length
                r3 = 3
                if (r2 != r3) goto L_0x028c
                r2 = 0
                r0 = r1[r2]
                r3 = 1
                r1 = r1[r3]
                boolean r4 = r14.contains(r1)
                if (r4 != 0) goto L_0x0280
                r14.add(r1)
                java.lang.String r4 = "%s_%s_Video.mp4"
                r6 = 2
                java.lang.Object[] r5 = new java.lang.Object[r6]
                r5[r2] = r0
                r5[r3] = r1
                java.lang.String r4 = java.lang.String.format(r4, r5)
                java.lang.String r5 = "%s_%s_Animation.bin"
                java.lang.Object[] r15 = new java.lang.Object[r6]
                r15[r2] = r0
                r15[r3] = r1
                java.lang.String r1 = java.lang.String.format(r5, r15)
                java.io.File r2 = new java.io.File
                r2.<init>(r13, r4)
                java.io.File r3 = new java.io.File
                r3.<init>(r13, r1)
                long r15 = r2.lastModified()
                boolean r1 = r2.exists()
                if (r1 == 0) goto L_0x0258
                boolean r1 = r3.exists()
                if (r1 == 0) goto L_0x0258
                java.lang.String r1 = "Video_%s.mp4"
                r5 = 1
                java.lang.Object[] r4 = new java.lang.Object[r5]
                java.lang.String r17 = java.lang.String.valueOf(r15)
                r18 = 0
                r4[r18] = r17
                java.lang.String r1 = java.lang.String.format(r1, r4)
                java.lang.String r4 = "Animation_%s.bin"
                java.lang.Object[] r12 = new java.lang.Object[r5]
                java.lang.String r17 = java.lang.String.valueOf(r15)
                r12[r18] = r17
                java.lang.String r4 = java.lang.String.format(r4, r12)
                java.lang.String r12 = "man"
                boolean r0 = r0.equals(r12)
                if (r0 == 0) goto L_0x01fc
                r0 = 2
                goto L_0x01fd
            L_0x01fc:
                r0 = 1
            L_0x01fd:
                android.content.Context r12 = r10.f1358a
                java.io.File r0 = net.fxgear.GlobalDefine.GetRealDirectory(r12, r0, r6)
                java.io.File r12 = new java.io.File
                r12.<init>(r0, r1)
                java.io.File r1 = new java.io.File
                r1.<init>(r0, r4)
                net.fxgear.fittingmodenative.c$e$b r4 = new net.fxgear.fittingmodenative.c$e$b
                r17 = 0
                java.lang.String r19 = r2.getAbsolutePath()
                java.lang.String r20 = r3.getAbsolutePath()
                java.lang.String r12 = r12.getAbsolutePath()
                java.lang.String r21 = r1.getAbsolutePath()
                r22 = 1
                r0 = r4
                r1 = r25
                r2 = r17
                r3 = r19
                r24 = r4
                r4 = r20
                r17 = 1
                r5 = r12
                r12 = 2
                r6 = r21
                r19 = r7
                r23 = r8
                r7 = r15
                r15 = r9
                r9 = r22
                r0.<init>(r2, r3, r4, r5, r6, r7, r9)
                java.util.ArrayList<net.fxgear.fittingmodenative.c$e$b> r0 = r10.e
                r1 = r24
                r0.add(r1)
                net.fxgear.GlobalDefine$Result r0 = r10.a((net.fxgear.fittingmodenative.c.e.b) r1)
                int r1 = r0.resultCode
                r11.resultCode = r1
                int r1 = r0.resultCode
                r3 = -1
                if (r1 == r3) goto L_0x02af
                java.lang.Object r0 = r0.resultExtra
                r11.resultExtra = r0
                goto L_0x02bc
            L_0x0258:
                r19 = r7
                r23 = r8
                r15 = r9
                r3 = -1
                r12 = 2
                r17 = 1
                r18 = 0
                java.lang.String r0 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r4 = "Not exist file : "
                r1.append(r4)
                java.lang.String r2 = r2.getName()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                android.util.Log.w(r0, r1)
                goto L_0x02af
            L_0x0280:
                r19 = r7
                r23 = r8
                r15 = r9
                r3 = -1
                r12 = 2
                r17 = 1
                r18 = 0
                goto L_0x02af
            L_0x028c:
                r19 = r7
                r23 = r8
                r15 = r9
                r3 = -1
                r12 = 2
                r17 = 1
                r18 = 0
                java.lang.String r1 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r4 = "File name is invalid : "
                r2.append(r4)
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                android.util.Log.w(r1, r0)
            L_0x02af:
                int r8 = r23 + 1
                r9 = r15
                r7 = r19
                r12 = -1
                r15 = -2
                goto L_0x016f
            L_0x02b8:
                r0 = -2
                r11.resultCode = r0
                return r11
            L_0x02bc:
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.c.e.g():net.fxgear.GlobalDefine$Result");
        }

        private void h() {
            Log.d(c.f1328a, "RenameCopiedFiles()");
            if (this.e != null && !this.e.isEmpty()) {
                e a2 = e.a(this.f1358a);
                Iterator<b> it = this.e.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    File file = new File(next.f1369b);
                    File file2 = new File(next.e);
                    if (file.exists()) {
                        file.delete();
                    }
                    if (file2.exists()) {
                        file2.delete();
                    }
                    new File(next.c).renameTo(file);
                    new File(next.f).renameTo(file2);
                    if (next.i) {
                        String[] split = next.f1368a.substring(next.f1368a.lastIndexOf(File.separator) + 1).split("_");
                        if (split != null && split.length == 3) {
                            String str = split[0];
                            String str2 = split[1];
                            int i2 = str.equals(GlobalDefine.GENDER_MAN_STRING) ? 2 : 1;
                            a2.a(i2, 2, String.valueOf(next.g), GlobalDefine.REAL_VIDEO_BODY_SIZE_CUSTOM, String.format(GlobalDefine.FORMAT_QR_ANIMATION_URL, new Object[]{GlobalDefine.GetLegacyMirrorDataUrl(), str, str2}), String.format(GlobalDefine.FORMAT_QR_VIDEO_URL, new Object[]{GlobalDefine.GetLegacyMirrorDataUrl(), str, str2}), String.format(GlobalDefine.FORMAT_QR_CAPTURE_URL, new Object[]{GlobalDefine.GetLegacyMirrorDataUrl(), str, str2}), -1);
                        }
                    } else {
                        a2.a(next.h, String.valueOf(next.g));
                    }
                }
                this.e.clear();
                this.e = null;
            }
        }

        private void i() {
            Log.d(c.f1328a, "DeleteCopiedTempFiles()");
            if (this.e != null && !this.e.isEmpty()) {
                Iterator<b> it = this.e.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    File file = new File(next.c);
                    if (file.exists()) {
                        file.delete();
                    }
                    File file2 = new File(next.f);
                    if (file2.exists()) {
                        file2.delete();
                    }
                }
                this.e.clear();
                this.e = null;
            }
        }
    }

    public static d a(Context context, b bVar) {
        d dVar = new d(context, bVar);
        dVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return dVar;
    }

    /* compiled from: FXUpdater */
    public static class d extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        Context f1351a;

        /* renamed from: b  reason: collision with root package name */
        private b f1352b;

        public d(Context context, b bVar) {
            this.f1351a = context;
            this.f1352b = bVar;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            if (this.f1352b != null) {
                this.f1352b.a();
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00b1  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00b3  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00b6  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00bb  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Boolean doInBackground(java.lang.Void... r14) {
            /*
                r13 = this;
                net.fxgear.fittingmodenative.f$a r14 = net.fxgear.fittingmodenative.f.f1467a
                r14.getClass()
                java.io.File r14 = new java.io.File
                android.content.Context r0 = r13.f1351a
                java.io.File r0 = net.fxgear.GlobalDefine.GetRootDirectory(r0)
                java.lang.String r1 = "vDATA.fx"
                r14.<init>(r0, r1)
                net.fxgear.fittingmodenative.c$a r0 = new net.fxgear.fittingmodenative.c$a
                r0.<init>(r14)
                android.content.Context r1 = r13.f1351a
                boolean r1 = net.fxgear.fittingmodenative.f.a((android.content.Context) r1)
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L_0x00a5
                net.fxgear.fittingmodenative.c$a$b r1 = r0.a()
                if (r1 == 0) goto L_0x00a3
                int r5 = r1.f1335a
                if (r5 >= r2) goto L_0x002e
                goto L_0x00a3
            L_0x002e:
                int r5 = r1.d
                java.util.ArrayList r14 = r0.a((java.io.File) r14, (int) r5)
                if (r14 == 0) goto L_0x00a3
                int r5 = r14.size()
                int r6 = r1.d
                if (r5 == r6) goto L_0x003f
                goto L_0x00a3
            L_0x003f:
                net.fxgear.fittingmodenative.f$a r5 = net.fxgear.fittingmodenative.f.f1467a
                r5.getClass()
                net.fxgear.fittingmodenative.d.b r5 = net.fxgear.fittingmodenative.d.e.a()
                if (r5 == 0) goto L_0x0084
                java.lang.String r6 = r5.f1411a
                if (r6 == 0) goto L_0x0084
                r6 = 0
            L_0x004f:
                int r7 = r1.d
                if (r6 >= r7) goto L_0x00a5
                java.lang.String r7 = r5.b(r6)
                boolean r7 = net.fxgear.fittingmodenative.c.c((java.lang.String) r7)
                if (r7 != 0) goto L_0x005e
                goto L_0x00a3
            L_0x005e:
                java.lang.Object r7 = r14.get(r6)
                net.fxgear.fittingmodenative.c$a$a r7 = (net.fxgear.fittingmodenative.c.a.C0041a) r7
                long r8 = r7.d
                android.content.Context r10 = r13.f1351a
                java.lang.String r11 = r5.a((int) r6)
                long r10 = net.fxgear.fittingmodenative.d.c.a((android.content.Context) r10, (java.lang.String) r11)
                int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r12 != 0) goto L_0x00a3
                java.lang.String r8 = r5.b(r6)
                java.lang.String r7 = r7.c
                boolean r7 = net.fxgear.fittingmodenative.c.b(r8, r7)
                if (r7 == 0) goto L_0x0081
                goto L_0x00a3
            L_0x0081:
                int r6 = r6 + 1
                goto L_0x004f
            L_0x0084:
                r6 = 0
            L_0x0085:
                int r7 = r1.d
                if (r6 >= r7) goto L_0x00a5
                java.lang.Object r7 = r14.get(r6)
                net.fxgear.fittingmodenative.c$a$a r7 = (net.fxgear.fittingmodenative.c.a.C0041a) r7
                long r7 = r7.d
                android.content.Context r9 = r13.f1351a
                java.lang.String r10 = r5.a((int) r6)
                long r9 = net.fxgear.fittingmodenative.d.c.a((android.content.Context) r9, (java.lang.String) r10)
                int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r11 == 0) goto L_0x00a0
                goto L_0x00a3
            L_0x00a0:
                int r6 = r6 + 1
                goto L_0x0085
            L_0x00a3:
                r14 = 1
                goto L_0x00a6
            L_0x00a5:
                r14 = 0
            L_0x00a6:
                if (r14 != 0) goto L_0x00b3
                android.content.Context r14 = r13.f1351a
                boolean r14 = r0.a((android.content.Context) r14)
                if (r14 != 0) goto L_0x00b1
                goto L_0x00b3
            L_0x00b1:
                r14 = 0
                goto L_0x00b4
            L_0x00b3:
                r14 = 1
            L_0x00b4:
                if (r14 == 0) goto L_0x00bb
                java.lang.Boolean r14 = java.lang.Boolean.valueOf(r14)
                return r14
            L_0x00bb:
                android.content.Context r14 = r13.f1351a
                boolean r14 = net.fxgear.GlobalDefine.NeedMigrationUnityData(r14)
                if (r14 != 0) goto L_0x00d6
                android.content.Context r14 = r13.f1351a
                boolean r14 = net.fxgear.fittingmodenative.c.g(r14)
                if (r14 != 0) goto L_0x00d6
                android.content.Context r14 = r13.f1351a
                boolean r14 = net.fxgear.fittingmodenative.c.f(r14)
                if (r14 == 0) goto L_0x00d4
                goto L_0x00d6
            L_0x00d4:
                r14 = 0
                goto L_0x00d7
            L_0x00d6:
                r14 = 1
            L_0x00d7:
                if (r14 == 0) goto L_0x00de
                java.lang.Boolean r14 = java.lang.Boolean.valueOf(r14)
                return r14
            L_0x00de:
                android.content.Context r0 = r13.f1351a
                net.fxgear.fittingmodenative.e r0 = net.fxgear.fittingmodenative.e.a((android.content.Context) r0)
                java.util.ArrayList r0 = r0.b()
                int r1 = r0.size()
                r5 = -1
                if (r1 <= 0) goto L_0x0180
                android.content.Context r1 = r13.f1351a
                net.fxgear.GlobalDefine$Result r1 = net.fxgear.fittingmodenative.d.e.a((android.content.Context) r1, (java.util.ArrayList<java.lang.String>) r0)
                int r6 = r1.resultCode
                if (r6 != r5) goto L_0x0179
                java.lang.Object r6 = r1.resultExtra
                if (r6 == 0) goto L_0x0179
                java.lang.Object r1 = r1.resultExtra
                java.util.HashMap r1 = (java.util.HashMap) r1
                java.util.Iterator r0 = r0.iterator()
            L_0x0105:
                boolean r6 = r0.hasNext()
                if (r6 == 0) goto L_0x0179
                java.lang.Object r6 = r0.next()
                java.lang.String r6 = (java.lang.String) r6
                java.lang.Object r7 = r1.get(r6)
                java.lang.String r7 = (java.lang.String) r7
                if (r7 == 0) goto L_0x0157
                java.lang.String r8 = r7.substring(r2)
                r9 = 16
                int r8 = java.lang.Integer.parseInt(r8, r9)
                android.content.Context r10 = r13.f1351a
                net.fxgear.fittingmodenative.e r10 = net.fxgear.fittingmodenative.e.a((android.content.Context) r10)
                int r10 = r10.b((java.lang.String) r6)
                java.lang.String r7 = r7.substring(r3, r2)
                byte r7 = java.lang.Byte.parseByte(r7, r9)
                r9 = 70
                if (r7 != r9) goto L_0x013b
                r7 = 1
                goto L_0x013c
            L_0x013b:
                r7 = 0
            L_0x013c:
                if (r7 == 0) goto L_0x0105
                if (r8 <= r10) goto L_0x0105
                android.content.Context r7 = r13.f1351a
                net.fxgear.fittingmodenative.e r7 = net.fxgear.fittingmodenative.e.a((android.content.Context) r7)
                java.lang.String r6 = r7.d((java.lang.String) r6)
                java.io.File r7 = new java.io.File
                r7.<init>(r6)
                boolean r6 = r7.exists()
                if (r6 == 0) goto L_0x0105
                r14 = 1
                goto L_0x0179
            L_0x0157:
                android.content.Context r7 = r13.f1351a
                net.fxgear.fittingmodenative.e r7 = net.fxgear.fittingmodenative.e.a((android.content.Context) r7)
                r7.c((java.lang.String) r6)
                java.lang.String r7 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r9 = "Remove base category : "
                r8.append(r9)
                r8.append(r6)
                java.lang.String r6 = r8.toString()
                android.util.Log.i(r7, r6)
                goto L_0x0105
            L_0x0179:
                if (r14 == 0) goto L_0x0180
                java.lang.Boolean r14 = java.lang.Boolean.valueOf(r14)
                return r14
            L_0x0180:
                android.content.Context r0 = r13.f1351a
                boolean r0 = net.fxgear.GlobalDefine.NeedDefaultRealData(r0)
                r0 = r0 ^ r4
                if (r0 == 0) goto L_0x024e
                android.content.Context r0 = r13.f1351a
                int r0 = net.fxgear.GlobalDefine.GetChangeDefaultRealVideoState(r0)
                if (r0 == r2) goto L_0x0196
                java.lang.Boolean r14 = java.lang.Boolean.valueOf(r4)
                return r14
            L_0x0196:
                android.content.Context r0 = r13.f1351a
                boolean r0 = net.fxgear.fittingmodenative.c.i(r0)
                if (r0 == 0) goto L_0x0249
                java.lang.String r0 = "all"
                java.lang.String r1 = "all"
                net.fxgear.fittingmodenative.d.e$f$b r0 = net.fxgear.fittingmodenative.d.e.f.a((java.lang.String) r1, (java.lang.String) r0)
                if (r0 == 0) goto L_0x0247
                int r1 = r0.resultCode
                if (r1 != r5) goto L_0x0247
                net.fxgear.fittingmodenative.d.h r1 = r0.f1435a
                if (r1 == 0) goto L_0x0247
                net.fxgear.fittingmodenative.d.h r1 = r0.f1435a
                net.fxgear.fittingmodenative.d.h$a[] r1 = r1.f1448a
                if (r1 == 0) goto L_0x0247
                net.fxgear.fittingmodenative.d.h r0 = r0.f1435a
                net.fxgear.fittingmodenative.d.h$a[] r0 = r0.f1448a
                int r1 = r0.length
                r5 = r14
                r14 = 0
            L_0x01bd:
                if (r14 >= r1) goto L_0x024f
                r6 = r0[r14]
                java.lang.String r7 = r6.c
                if (r7 == 0) goto L_0x0243
                java.lang.String r7 = net.fxgear.fittingmodenative.c.b((net.fxgear.fittingmodenative.d.h.a) r6)
                if (r7 == 0) goto L_0x023a
                java.lang.String r8 = r6.f1450a
                if (r8 == 0) goto L_0x023a
                java.lang.String r8 = r6.f1450a
                boolean r8 = r8.isEmpty()
                if (r8 != 0) goto L_0x023a
                android.content.Context r8 = r13.f1351a
                java.lang.String r9 = r6.f1450a
                boolean r10 = r6.f1451b
                net.fxgear.fittingmodenative.e$c r8 = net.fxgear.fittingmodenative.c.b(r8, r9, r10, r7)
                if (r8 == 0) goto L_0x0243
                int r9 = r8.f1466b
                if (r9 != r4) goto L_0x0202
                int r9 = r8.c
                if (r9 != r4) goto L_0x01f5
                java.lang.String r9 = "130"
                boolean r7 = r7.equals(r9)
                if (r7 == 0) goto L_0x0220
            L_0x01f3:
                r7 = 1
                goto L_0x0221
            L_0x01f5:
                int r9 = r8.c
                if (r9 != r2) goto L_0x0220
                java.lang.String r9 = "44"
                boolean r7 = r7.equals(r9)
                if (r7 == 0) goto L_0x0220
                goto L_0x01f3
            L_0x0202:
                int r9 = r8.f1466b
                if (r9 != r2) goto L_0x0220
                int r9 = r8.c
                if (r9 != r4) goto L_0x0213
                java.lang.String r9 = "160"
                boolean r7 = r7.equals(r9)
                if (r7 == 0) goto L_0x0220
                goto L_0x01f3
            L_0x0213:
                int r9 = r8.c
                if (r9 != r2) goto L_0x0220
                java.lang.String r9 = "105"
                boolean r7 = r7.equals(r9)
                if (r7 == 0) goto L_0x0220
                goto L_0x01f3
            L_0x0220:
                r7 = 0
            L_0x0221:
                if (r7 == 0) goto L_0x0230
                int r7 = r8.d
                if (r7 == r4) goto L_0x0229
            L_0x0227:
                r5 = 1
                goto L_0x0237
            L_0x0229:
                int r6 = r6.f
                int r7 = r8.j
                if (r6 <= r7) goto L_0x0237
                goto L_0x0227
            L_0x0230:
                int r6 = r6.f
                int r7 = r8.j
                if (r6 <= r7) goto L_0x0237
                goto L_0x0227
            L_0x0237:
                if (r5 == 0) goto L_0x0243
                goto L_0x024f
            L_0x023a:
                java.lang.String r6 = net.fxgear.fittingmodenative.c.f1328a
                java.lang.String r7 = "Wrong size & gender"
                android.util.Log.d(r6, r7)
            L_0x0243:
                int r14 = r14 + 1
                goto L_0x01bd
            L_0x0247:
                r5 = r14
                goto L_0x024f
            L_0x0249:
                java.lang.Boolean r14 = java.lang.Boolean.valueOf(r4)
                return r14
            L_0x024e:
                r5 = 1
            L_0x024f:
                android.content.Context r14 = r13.f1351a
                net.fxgear.util.FXDataManager r14 = net.fxgear.util.FXDataManager.GetInstance(r14)
                java.util.ArrayList r14 = r14.GetAllAvatarDataList()
                if (r14 == 0) goto L_0x0261
                int r14 = r14.size()
                if (r14 > 0) goto L_0x0262
            L_0x0261:
                r5 = 1
            L_0x0262:
                if (r5 == 0) goto L_0x0269
                java.lang.Boolean r14 = java.lang.Boolean.valueOf(r5)
                return r14
            L_0x0269:
                android.content.Context r14 = r13.f1351a
                boolean r14 = net.fxgear.fittingmodenative.c.j(r14)
                if (r14 != 0) goto L_0x0272
                goto L_0x0273
            L_0x0272:
                r4 = r5
            L_0x0273:
                java.lang.Boolean r14 = java.lang.Boolean.valueOf(r4)
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.c.d.doInBackground(java.lang.Void[]):java.lang.Boolean");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (this.f1352b != null) {
                this.f1352b.a(bool.booleanValue());
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            if (this.f1352b != null) {
                this.f1352b.a(false);
            }
        }

        public void a() {
            if (getStatus() != AsyncTask.Status.FINISHED) {
                cancel(true);
                this.f1352b = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public static e.c b(Context context, String str, boolean z, String str2) {
        if (str == null || str2 == null) {
            Log.e(f1328a, "GetRealVideoData() ERROR :: Wrong params");
            return null;
        }
        Iterator<e.c> it = e.a(context).c().iterator();
        while (it.hasNext()) {
            e.c next = it.next();
            if (next != null) {
                int i = 1;
                int i2 = str.equals(GlobalDefine.GENDER_MAN_STRING) ? 2 : 1;
                if (!z) {
                    i = 2;
                }
                if (str2.equals(next.f) && i2 == next.f1466b && i == next.c) {
                    return next;
                }
            } else {
                Log.d(f1328a, "Video data is null");
            }
        }
        return null;
    }

    /* compiled from: FXUpdater */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f1329a = a.class.getSimpleName();

        /* renamed from: b  reason: collision with root package name */
        private final int f1330b = FXUtil.MAX_CUSTOM_FACE_IMAGE_SIZE;
        private final int c = 256;
        private final int d = 256;
        private final int e = FXUtil.MAX_CUSTOM_FACE_IMAGE_SIZE;
        private final String f = "file_list";
        private final String g = "file_name";
        private final String h = "file_length";
        private File i;

        public a(File file) {
            this.i = file;
        }

        /* compiled from: FXUpdater */
        class b {

            /* renamed from: a  reason: collision with root package name */
            int f1335a = -1;

            /* renamed from: b  reason: collision with root package name */
            long f1336b = -1;
            long c = -1;
            int d = -1;

            /* JADX WARNING: Removed duplicated region for block: B:25:0x0060 A[SYNTHETIC, Splitter:B:25:0x0060] */
            /* JADX WARNING: Removed duplicated region for block: B:31:0x006c A[SYNTHETIC, Splitter:B:31:0x006c] */
            /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            b(java.io.File r6) {
                /*
                    r4 = this;
                    net.fxgear.fittingmodenative.c.a.this = r5
                    r4.<init>()
                    r5 = -1
                    r4.f1335a = r5
                    r0 = -1
                    r4.f1336b = r0
                    r4.c = r0
                    r4.d = r5
                    if (r6 == 0) goto L_0x0075
                    boolean r5 = r6.exists()
                    if (r5 == 0) goto L_0x0075
                    boolean r5 = r6.isFile()
                    if (r5 == 0) goto L_0x0075
                    r5 = 0
                    r0 = 1024(0x400, float:1.435E-42)
                    byte[] r0 = new byte[r0]
                    java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0058, all -> 0x0054 }
                    r1.<init>(r6)     // Catch:{ Exception -> 0x0058, all -> 0x0054 }
                    r1.read(r0)     // Catch:{ Exception -> 0x0052 }
                    java.nio.ByteBuffer r5 = java.nio.ByteBuffer.wrap(r0)     // Catch:{ Exception -> 0x0052 }
                    int r6 = r5.getInt()     // Catch:{ Exception -> 0x0052 }
                    r4.f1335a = r6     // Catch:{ Exception -> 0x0052 }
                    int r6 = r4.f1335a     // Catch:{ Exception -> 0x0052 }
                    switch(r6) {
                        case 1: goto L_0x0042;
                        case 2: goto L_0x003b;
                        default: goto L_0x003a;
                    }     // Catch:{ Exception -> 0x0052 }
                L_0x003a:
                    goto L_0x004e
                L_0x003b:
                    int r5 = r5.getInt()     // Catch:{ Exception -> 0x0052 }
                    r4.d = r5     // Catch:{ Exception -> 0x0052 }
                    goto L_0x004e
                L_0x0042:
                    long r2 = r5.getLong()     // Catch:{ Exception -> 0x0052 }
                    r4.f1336b = r2     // Catch:{ Exception -> 0x0052 }
                    long r5 = r5.getLong()     // Catch:{ Exception -> 0x0052 }
                    r4.c = r5     // Catch:{ Exception -> 0x0052 }
                L_0x004e:
                    r1.close()     // Catch:{ IOException -> 0x0064 }
                    goto L_0x0075
                L_0x0052:
                    r5 = move-exception
                    goto L_0x005b
                L_0x0054:
                    r6 = move-exception
                    r1 = r5
                    r5 = r6
                    goto L_0x006a
                L_0x0058:
                    r6 = move-exception
                    r1 = r5
                    r5 = r6
                L_0x005b:
                    r5.printStackTrace()     // Catch:{ all -> 0x0069 }
                    if (r1 == 0) goto L_0x0075
                    r1.close()     // Catch:{ IOException -> 0x0064 }
                    goto L_0x0075
                L_0x0064:
                    r5 = move-exception
                    r5.printStackTrace()
                    goto L_0x0075
                L_0x0069:
                    r5 = move-exception
                L_0x006a:
                    if (r1 == 0) goto L_0x0074
                    r1.close()     // Catch:{ IOException -> 0x0070 }
                    goto L_0x0074
                L_0x0070:
                    r6 = move-exception
                    r6.printStackTrace()
                L_0x0074:
                    throw r5
                L_0x0075:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.c.a.b.<init>(net.fxgear.fittingmodenative.c$a, java.io.File):void");
            }

            /* access modifiers changed from: package-private */
            public byte[] a() {
                ByteBuffer byteBuffer;
                switch (this.f1335a) {
                    case 1:
                        byteBuffer = ByteBuffer.allocate(FXUtil.MAX_CUSTOM_FACE_IMAGE_SIZE);
                        byteBuffer.putInt(this.f1335a);
                        byteBuffer.putLong(this.f1336b);
                        byteBuffer.putLong(this.c);
                        break;
                    case 2:
                        byteBuffer = ByteBuffer.allocate(256);
                        byteBuffer.putInt(this.f1335a);
                        byteBuffer.putInt(this.d);
                        break;
                    default:
                        byteBuffer = null;
                        break;
                }
                return byteBuffer.array();
            }
        }

        /* renamed from: net.fxgear.fittingmodenative.c$a$a  reason: collision with other inner class name */
        /* compiled from: FXUpdater */
        class C0041a {

            /* renamed from: a  reason: collision with root package name */
            int f1333a = -1;

            /* renamed from: b  reason: collision with root package name */
            int f1334b = -1;
            String c = null;
            long d = -1;
            long e = -1;

            C0041a() {
            }

            /* access modifiers changed from: package-private */
            public byte[] a() {
                ByteBuffer allocate = ByteBuffer.allocate(256);
                allocate.putInt(this.f1333a);
                allocate.putInt(this.f1334b);
                allocate.put(this.c.getBytes());
                allocate.putLong(this.d);
                allocate.putLong(this.e);
                return allocate.array();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0064, code lost:
            r7 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x006f, code lost:
            r7 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            r0.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            return r1;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x006f A[ExcHandler: all (th java.lang.Throwable), Splitter:B:11:0x001c] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x007f A[SYNTHETIC, Splitter:B:35:0x007f] */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0085 A[SYNTHETIC, Splitter:B:38:0x0085] */
        /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.ArrayList<net.fxgear.fittingmodenative.c.a.C0041a> a(java.io.File r7, int r8) {
            /*
                r6 = this;
                r0 = 0
                if (r7 == 0) goto L_0x008e
                boolean r1 = r7.exists()
                if (r1 == 0) goto L_0x008e
                boolean r1 = r7.isFile()
                if (r1 == 0) goto L_0x008e
                if (r8 <= 0) goto L_0x008e
                int r1 = r8 * 256
                byte[] r1 = new byte[r1]
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0078 }
                r2.<init>(r7)     // Catch:{ Exception -> 0x0078 }
                r3 = 256(0x100, double:1.265E-321)
                r2.skip(r3)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
                r2.read(r1)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
                java.nio.ByteBuffer r7 = java.nio.ByteBuffer.wrap(r1)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0071, all -> 0x006f }
                r1.<init>()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
                r0 = 0
            L_0x002c:
                if (r0 >= r8) goto L_0x0066
                int r3 = r0 * 256
                r7.position(r3)     // Catch:{ Exception -> 0x0064, all -> 0x006f }
                net.fxgear.fittingmodenative.c$a$a r3 = new net.fxgear.fittingmodenative.c$a$a     // Catch:{ Exception -> 0x0064, all -> 0x006f }
                r3.<init>()     // Catch:{ Exception -> 0x0064, all -> 0x006f }
                int r4 = r7.getInt()     // Catch:{ Exception -> 0x0064, all -> 0x006f }
                r3.f1333a = r4     // Catch:{ Exception -> 0x0064, all -> 0x006f }
                int r4 = r7.getInt()     // Catch:{ Exception -> 0x0064, all -> 0x006f }
                r3.f1334b = r4     // Catch:{ Exception -> 0x0064, all -> 0x006f }
                int r4 = r3.f1334b     // Catch:{ Exception -> 0x0064, all -> 0x006f }
                byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x0064, all -> 0x006f }
                r7.get(r4)     // Catch:{ Exception -> 0x0064, all -> 0x006f }
                java.lang.String r5 = new java.lang.String     // Catch:{ Exception -> 0x0064, all -> 0x006f }
                r5.<init>(r4)     // Catch:{ Exception -> 0x0064, all -> 0x006f }
                r3.c = r5     // Catch:{ Exception -> 0x0064, all -> 0x006f }
                long r4 = r7.getLong()     // Catch:{ Exception -> 0x0064, all -> 0x006f }
                r3.d = r4     // Catch:{ Exception -> 0x0064, all -> 0x006f }
                long r4 = r7.getLong()     // Catch:{ Exception -> 0x0064, all -> 0x006f }
                r3.e = r4     // Catch:{ Exception -> 0x0064, all -> 0x006f }
                r1.add(r3)     // Catch:{ Exception -> 0x0064, all -> 0x006f }
                int r0 = r0 + 1
                goto L_0x002c
            L_0x0064:
                r7 = move-exception
                goto L_0x0073
            L_0x0066:
                r2.close()     // Catch:{ IOException -> 0x006a }
                goto L_0x008f
            L_0x006a:
                r7 = move-exception
                r7.printStackTrace()
                goto L_0x008f
            L_0x006f:
                r7 = move-exception
                goto L_0x0083
            L_0x0071:
                r7 = move-exception
                r1 = r0
            L_0x0073:
                r0 = r2
                goto L_0x007a
            L_0x0075:
                r7 = move-exception
                r2 = r0
                goto L_0x0083
            L_0x0078:
                r7 = move-exception
                r1 = r0
            L_0x007a:
                r7.printStackTrace()     // Catch:{ all -> 0x0075 }
                if (r0 == 0) goto L_0x008f
                r0.close()     // Catch:{ IOException -> 0x006a }
                goto L_0x008f
            L_0x0083:
                if (r2 == 0) goto L_0x008d
                r2.close()     // Catch:{ IOException -> 0x0089 }
                goto L_0x008d
            L_0x0089:
                r8 = move-exception
                r8.printStackTrace()
            L_0x008d:
                throw r7
            L_0x008e:
                r1 = r0
            L_0x008f:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.c.a.a(java.io.File, int):java.util.ArrayList");
        }

        private String b(Context context, ArrayList<String> arrayList) {
            if (!(context == null || arrayList == null || arrayList.size() <= 0)) {
                JSONArray jSONArray = new JSONArray();
                File GetRootDirectory = GlobalDefine.GetRootDirectory(context);
                try {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        String str = arrayList.get(i2);
                        File file = new File(GetRootDirectory, str);
                        if (!file.exists()) {
                            String str2 = this.f1329a;
                            Log.e(str2, "ERROR :: Not found file - " + str);
                            return null;
                        }
                        if (file.isFile()) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("file_name", str);
                            jSONObject.put("file_length", file.length());
                            jSONArray.put(jSONObject);
                        }
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("file_list", jSONArray);
                    return jSONObject2.toString();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x0066 A[SYNTHETIC, Splitter:B:31:0x0066] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0072 A[SYNTHETIC, Splitter:B:37:0x0072] */
        /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String b() {
            /*
                r7 = this;
                java.io.File r0 = r7.i
                r1 = 0
                if (r0 == 0) goto L_0x0083
                java.io.File r0 = r7.i
                boolean r0 = r0.exists()
                if (r0 == 0) goto L_0x0083
                java.io.File r0 = r7.i
                boolean r0 = r0.isFile()
                if (r0 == 0) goto L_0x0083
                net.fxgear.fittingmodenative.c$a$b r0 = new net.fxgear.fittingmodenative.c$a$b
                java.io.File r2 = r7.i
                r0.<init>(r2)
                long r2 = r0.c
                r4 = 0
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 <= 0) goto L_0x007b
                long r2 = r0.c
                int r0 = (int) r2
                java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r0)
                r2 = 1024(0x400, float:1.435E-42)
                byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                java.io.File r4 = r7.i     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                r3.<init>(r4)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                r4 = 1024(0x400, double:5.06E-321)
                r3.skip(r4)     // Catch:{ Exception -> 0x005a }
            L_0x003b:
                int r4 = r3.read(r2)     // Catch:{ Exception -> 0x005a }
                r5 = -1
                if (r4 == r5) goto L_0x0047
                r5 = 0
                r0.put(r2, r5, r4)     // Catch:{ Exception -> 0x005a }
                goto L_0x003b
            L_0x0047:
                java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x005a }
                byte[] r0 = r0.array()     // Catch:{ Exception -> 0x005a }
                r2.<init>(r0)     // Catch:{ Exception -> 0x005a }
                r3.close()     // Catch:{ IOException -> 0x0054 }
                goto L_0x0058
            L_0x0054:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0058:
                r1 = r2
                goto L_0x008a
            L_0x005a:
                r0 = move-exception
                goto L_0x0061
            L_0x005c:
                r0 = move-exception
                r3 = r1
                goto L_0x0070
            L_0x005f:
                r0 = move-exception
                r3 = r1
            L_0x0061:
                r0.printStackTrace()     // Catch:{ all -> 0x006f }
                if (r3 == 0) goto L_0x008a
                r3.close()     // Catch:{ IOException -> 0x006a }
                goto L_0x008a
            L_0x006a:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x008a
            L_0x006f:
                r0 = move-exception
            L_0x0070:
                if (r3 == 0) goto L_0x007a
                r3.close()     // Catch:{ IOException -> 0x0076 }
                goto L_0x007a
            L_0x0076:
                r1 = move-exception
                r1.printStackTrace()
            L_0x007a:
                throw r0
            L_0x007b:
                java.lang.String r0 = r7.f1329a
                java.lang.String r2 = "ERROR :: Wrong verification file."
                android.util.Log.e(r0, r2)
                goto L_0x008a
            L_0x0083:
                java.lang.String r0 = r7.f1329a
                java.lang.String r2 = "ERROR :: Not found verification file"
                android.util.Log.e(r0, r2)
            L_0x008a:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.c.a.b():java.lang.String");
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x0052 A[SYNTHETIC, Splitter:B:27:0x0052] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x005e A[SYNTHETIC, Splitter:B:33:0x005e] */
        /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String a(java.io.File r6) {
            /*
                r5 = this;
                java.io.File r0 = r5.i
                r1 = 0
                if (r0 == 0) goto L_0x0067
                java.io.File r0 = r5.i
                boolean r0 = r0.exists()
                if (r0 == 0) goto L_0x0067
                java.io.File r0 = r5.i
                boolean r0 = r0.isFile()
                if (r0 == 0) goto L_0x0067
                long r2 = r6.length()
                int r0 = (int) r2
                java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r0)
                r2 = 1024(0x400, float:1.435E-42)
                byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x004b, all -> 0x0048 }
                java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x004b, all -> 0x0048 }
                r3.<init>(r6)     // Catch:{ Exception -> 0x004b, all -> 0x0048 }
            L_0x0027:
                int r6 = r3.read(r2)     // Catch:{ Exception -> 0x0046 }
                r4 = -1
                if (r6 == r4) goto L_0x0033
                r4 = 0
                r0.put(r2, r4, r6)     // Catch:{ Exception -> 0x0046 }
                goto L_0x0027
            L_0x0033:
                java.lang.String r6 = new java.lang.String     // Catch:{ Exception -> 0x0046 }
                byte[] r0 = r0.array()     // Catch:{ Exception -> 0x0046 }
                r6.<init>(r0)     // Catch:{ Exception -> 0x0046 }
                r3.close()     // Catch:{ IOException -> 0x0040 }
                goto L_0x0044
            L_0x0040:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0044:
                r1 = r6
                goto L_0x006e
            L_0x0046:
                r6 = move-exception
                goto L_0x004d
            L_0x0048:
                r6 = move-exception
                r3 = r1
                goto L_0x005c
            L_0x004b:
                r6 = move-exception
                r3 = r1
            L_0x004d:
                r6.printStackTrace()     // Catch:{ all -> 0x005b }
                if (r3 == 0) goto L_0x006e
                r3.close()     // Catch:{ IOException -> 0x0056 }
                goto L_0x006e
            L_0x0056:
                r6 = move-exception
                r6.printStackTrace()
                goto L_0x006e
            L_0x005b:
                r6 = move-exception
            L_0x005c:
                if (r3 == 0) goto L_0x0066
                r3.close()     // Catch:{ IOException -> 0x0062 }
                goto L_0x0066
            L_0x0062:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0066:
                throw r6
            L_0x0067:
                java.lang.String r6 = r5.f1329a
                java.lang.String r0 = "ERROR :: Not found verification file"
                android.util.Log.e(r6, r0)
            L_0x006e:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.c.a.a(java.io.File):java.lang.String");
        }

        public void a(Context context, ArrayList<Integer> arrayList) {
            boolean z;
            b bVar = new b(this.i);
            File GetRootDirectory = GlobalDefine.GetRootDirectory(context);
            if (bVar.f1335a < 2) {
                if (bVar.f1335a == 1) {
                    String b2 = b();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < 3; i2++) {
                        ArrayList<String> c2 = f.c(new File(GetRootDirectory, GlobalDefine.GetFittingDataFileName(i2)));
                        for (int i3 = 0; i3 < c2.size(); i3++) {
                            arrayList2.add(c2.get(i3));
                        }
                    }
                    if (b2 != null && arrayList2.size() > 0) {
                        try {
                            JSONArray jSONArray = new JSONObject(b2).getJSONArray("file_list");
                            int length = jSONArray.length();
                            for (int i4 = 0; i4 < length; i4++) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                                if (jSONObject == null || jSONObject.getString("file_name") == null) {
                                    Log.e(this.f1329a, "ERROR :: wrong data file.");
                                } else {
                                    String string = jSONObject.getString("file_name");
                                    int i5 = 0;
                                    while (true) {
                                        if (i5 >= arrayList2.size()) {
                                            z = true;
                                            break;
                                        } else if (string.equals(arrayList2.get(i5))) {
                                            arrayList2.remove(i5);
                                            z = false;
                                            break;
                                        } else {
                                            i5++;
                                        }
                                    }
                                    if (z) {
                                        new File(GetRootDirectory, string).delete();
                                    }
                                }
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            } else if (arrayList != null && arrayList.size() > 0) {
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    a(context, arrayList.get(i6).intValue());
                }
            }
            FXUtil.DeleteEmptyDirectories(GlobalDefine.GetRootDirectory(context));
        }

        public void a(Context context, int i2) {
            boolean z;
            if (i2 < 0) {
                String str = this.f1329a;
                Log.e(str, "ERROR :: Invalid contentsFileIndex " + i2);
                return;
            }
            File GetRootDirectory = GlobalDefine.GetRootDirectory(context);
            File file = new File(GetRootDirectory, GlobalDefine.GetFittingDataFileName(i2));
            String a2 = a(new File(GetRootDirectory, String.format(GlobalDefine.FORMAT_VERIFICATION_CONTENTS_FILE_NAME, new Object[]{Integer.valueOf(i2)})));
            ArrayList<String> c2 = f.c(file);
            if (a2 != null && c2 != null && c2.size() > 0) {
                try {
                    JSONArray jSONArray = new JSONObject(a2).getJSONArray("file_list");
                    int length = jSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        if (jSONObject == null || jSONObject.getString("file_name") == null) {
                            Log.e(this.f1329a, "ERROR :: wrong data file.");
                        } else {
                            String string = jSONObject.getString("file_name");
                            int i4 = 0;
                            while (true) {
                                if (i4 >= c2.size()) {
                                    z = true;
                                    break;
                                } else if (string.equals(c2.get(i4))) {
                                    c2.remove(i4);
                                    z = false;
                                    break;
                                } else {
                                    i4++;
                                }
                            }
                            if (z) {
                                new File(GetRootDirectory, string).delete();
                            }
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:139:0x0246 A[SYNTHETIC, Splitter:B:139:0x0246] */
        /* JADX WARNING: Removed duplicated region for block: B:147:0x0257 A[SYNTHETIC, Splitter:B:147:0x0257] */
        /* JADX WARNING: Removed duplicated region for block: B:159:0x026f A[SYNTHETIC, Splitter:B:159:0x026f] */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x017c A[SYNTHETIC, Splitter:B:68:0x017c] */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x018e A[SYNTHETIC, Splitter:B:76:0x018e] */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x01a6 A[SYNTHETIC, Splitter:B:88:0x01a6] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(android.content.Context r19, java.util.ArrayList<java.lang.Integer> r20, net.fxgear.fittingmodenative.d.b r21) {
            /*
                r18 = this;
                r1 = r18
                r0 = r19
                r2 = r20
                r3 = r21
                r4 = 0
                if (r0 == 0) goto L_0x0285
                if (r2 == 0) goto L_0x0285
                int r5 = r20.size()
                if (r5 <= 0) goto L_0x0285
                java.io.File r5 = r1.i
                java.io.File r5 = r5.getParentFile()
                net.fxgear.fittingmodenative.c$a$b r6 = new net.fxgear.fittingmodenative.c$a$b
                java.io.File r7 = r1.i
                r6.<init>(r7)
                java.io.File r7 = r1.i
                int r8 = r6.d
                java.util.ArrayList r7 = r1.a((java.io.File) r7, (int) r8)
                int r8 = r6.f1335a
                r9 = 3
                r10 = 2
                if (r8 < r10) goto L_0x0075
                if (r7 != 0) goto L_0x0031
                goto L_0x0075
            L_0x0031:
                r8 = 0
            L_0x0032:
                int r11 = r20.size()
                if (r8 >= r11) goto L_0x00b9
                java.lang.Object r11 = r2.get(r8)
                java.lang.Integer r11 = (java.lang.Integer) r11
                int r11 = r11.intValue()
                java.lang.Object r12 = r7.get(r11)
                net.fxgear.fittingmodenative.c$a$a r12 = (net.fxgear.fittingmodenative.c.a.C0041a) r12
                if (r3 == 0) goto L_0x0059
                java.lang.String r13 = r3.b(r11)
                r12.c = r13
                java.lang.String r13 = r12.c
                int r13 = r13.length()
                r12.f1334b = r13
                goto L_0x005f
            L_0x0059:
                java.lang.String r13 = ""
                r12.c = r13
                r12.f1334b = r4
            L_0x005f:
                java.io.File r13 = new java.io.File
                java.io.File r14 = net.fxgear.GlobalDefine.GetRootDirectory(r19)
                java.lang.String r11 = net.fxgear.GlobalDefine.GetFittingDataFileName(r11)
                r13.<init>(r14, r11)
                long r13 = r13.length()
                r12.d = r13
                int r8 = r8 + 1
                goto L_0x0032
            L_0x0075:
                if (r7 == 0) goto L_0x007a
                r7.clear()
            L_0x007a:
                java.util.ArrayList r7 = new java.util.ArrayList
                r7.<init>()
                r8 = 0
            L_0x0080:
                if (r8 >= r9) goto L_0x00b9
                net.fxgear.fittingmodenative.c$a$a r11 = new net.fxgear.fittingmodenative.c$a$a
                r11.<init>()
                r11.f1333a = r8
                if (r3 == 0) goto L_0x009a
                java.lang.String r12 = r3.b(r8)
                r11.c = r12
                java.lang.String r12 = r11.c
                int r12 = r12.length()
                r11.f1334b = r12
                goto L_0x00a0
            L_0x009a:
                java.lang.String r12 = ""
                r11.c = r12
                r11.f1334b = r4
            L_0x00a0:
                java.io.File r12 = new java.io.File
                java.io.File r13 = net.fxgear.GlobalDefine.GetRootDirectory(r19)
                java.lang.String r14 = net.fxgear.GlobalDefine.GetFittingDataFileName(r8)
                r12.<init>(r13, r14)
                long r12 = r12.length()
                r11.d = r12
                r7.add(r11)
                int r8 = r8 + 1
                goto L_0x0080
            L_0x00b9:
                r3 = 0
            L_0x00ba:
                int r8 = r20.size()
                r12 = 1
                if (r3 >= r8) goto L_0x01bc
                java.lang.Object r8 = r2.get(r3)
                java.lang.Integer r8 = (java.lang.Integer) r8
                int r8 = r8.intValue()
                java.io.File r13 = new java.io.File
                java.io.File r14 = net.fxgear.GlobalDefine.GetRootDirectory(r19)
                java.lang.String r15 = net.fxgear.GlobalDefine.GetFittingDataFileName(r8)
                r13.<init>(r14, r15)
                java.util.ArrayList r13 = net.fxgear.fittingmodenative.f.c((java.io.File) r13)
                java.lang.String r13 = r1.b(r0, r13)
                if (r13 != 0) goto L_0x00ea
                java.lang.String r0 = r1.f1329a
                java.lang.String r2 = "ERROR :: verification data string is null"
                android.util.Log.e(r0, r2)
                return r4
            L_0x00ea:
                boolean r14 = r5.exists()
                if (r14 != 0) goto L_0x00f3
                r5.mkdirs()
            L_0x00f3:
                java.io.File r14 = new java.io.File
                java.lang.String r15 = "ContentsData_%d.dat"
                java.lang.Object[] r11 = new java.lang.Object[r12]
                java.lang.Integer r17 = java.lang.Integer.valueOf(r8)
                r11[r4] = r17
                java.lang.String r11 = java.lang.String.format(r15, r11)
                r14.<init>(r5, r11)
                byte[] r11 = r13.getBytes()     // Catch:{ IOException -> 0x0176, all -> 0x0171 }
                java.io.File r13 = new java.io.File     // Catch:{ IOException -> 0x0176, all -> 0x0171 }
                java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0176, all -> 0x0171 }
                r15.<init>()     // Catch:{ IOException -> 0x0176, all -> 0x0171 }
                java.lang.String r9 = "ContentsData_%d.dat"
                java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ IOException -> 0x0176, all -> 0x0171 }
                java.lang.Integer r17 = java.lang.Integer.valueOf(r8)     // Catch:{ IOException -> 0x0176, all -> 0x0171 }
                r12[r4] = r17     // Catch:{ IOException -> 0x0176, all -> 0x0171 }
                java.lang.String r9 = java.lang.String.format(r9, r12)     // Catch:{ IOException -> 0x0176, all -> 0x0171 }
                r15.append(r9)     // Catch:{ IOException -> 0x0176, all -> 0x0171 }
                java.lang.String r9 = "_tmp"
                r15.append(r9)     // Catch:{ IOException -> 0x0176, all -> 0x0171 }
                java.lang.String r9 = r15.toString()     // Catch:{ IOException -> 0x0176, all -> 0x0171 }
                r13.<init>(r5, r9)     // Catch:{ IOException -> 0x0176, all -> 0x0171 }
                java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x016e, all -> 0x016c }
                r9.<init>(r13)     // Catch:{ IOException -> 0x016e, all -> 0x016c }
                r9.write(r11)     // Catch:{ IOException -> 0x0167, all -> 0x0163 }
                java.lang.Object r8 = r7.get(r8)     // Catch:{ IOException -> 0x0167, all -> 0x0163 }
                net.fxgear.fittingmodenative.c$a$a r8 = (net.fxgear.fittingmodenative.c.a.C0041a) r8     // Catch:{ IOException -> 0x0167, all -> 0x0163 }
                int r11 = r11.length     // Catch:{ IOException -> 0x0167, all -> 0x0163 }
                long r11 = (long) r11     // Catch:{ IOException -> 0x0167, all -> 0x0163 }
                r8.e = r11     // Catch:{ IOException -> 0x0167, all -> 0x0163 }
                r9.close()     // Catch:{ IOException -> 0x0154 }
                boolean r8 = r14.exists()
                if (r8 == 0) goto L_0x014c
                r14.delete()
            L_0x014c:
                r13.renameTo(r14)
                int r3 = r3 + 1
                r9 = 3
                goto L_0x00ba
            L_0x0154:
                r0 = move-exception
                r2 = r0
                boolean r0 = r13.exists()
                if (r0 == 0) goto L_0x015f
                r13.delete()
            L_0x015f:
                r2.printStackTrace()
                return r4
            L_0x0163:
                r0 = move-exception
                r16 = r9
                goto L_0x01a4
            L_0x0167:
                r0 = move-exception
                r16 = r9
                r11 = r13
                goto L_0x017a
            L_0x016c:
                r0 = move-exception
                goto L_0x0173
            L_0x016e:
                r0 = move-exception
                r11 = r13
                goto L_0x0178
            L_0x0171:
                r0 = move-exception
                r13 = 0
            L_0x0173:
                r16 = 0
                goto L_0x01a4
            L_0x0176:
                r0 = move-exception
                r11 = 0
            L_0x0178:
                r16 = 0
            L_0x017a:
                if (r11 == 0) goto L_0x0189
                boolean r2 = r11.exists()     // Catch:{ all -> 0x0186 }
                if (r2 == 0) goto L_0x0189
                r11.delete()     // Catch:{ all -> 0x0186 }
                goto L_0x0189
            L_0x0186:
                r0 = move-exception
                r13 = r11
                goto L_0x01a4
            L_0x0189:
                r0.printStackTrace()     // Catch:{ all -> 0x0186 }
                if (r16 == 0) goto L_0x01a3
                r16.close()     // Catch:{ IOException -> 0x0192 }
                goto L_0x01a3
            L_0x0192:
                r0 = move-exception
                r2 = r0
                if (r11 == 0) goto L_0x019f
                boolean r0 = r11.exists()
                if (r0 == 0) goto L_0x019f
                r11.delete()
            L_0x019f:
                r2.printStackTrace()
                return r4
            L_0x01a3:
                return r4
            L_0x01a4:
                if (r16 == 0) goto L_0x01bb
                r16.close()     // Catch:{ IOException -> 0x01aa }
                goto L_0x01bb
            L_0x01aa:
                r0 = move-exception
                r2 = r0
                if (r13 == 0) goto L_0x01b7
                boolean r0 = r13.exists()
                if (r0 == 0) goto L_0x01b7
                r13.delete()
            L_0x01b7:
                r2.printStackTrace()
                return r4
            L_0x01bb:
                throw r0
            L_0x01bc:
                java.io.File r11 = new java.io.File     // Catch:{ IOException -> 0x0240, all -> 0x023b }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0240, all -> 0x023b }
                r0.<init>()     // Catch:{ IOException -> 0x0240, all -> 0x023b }
                java.io.File r2 = r1.i     // Catch:{ IOException -> 0x0240, all -> 0x023b }
                java.lang.String r2 = r2.getName()     // Catch:{ IOException -> 0x0240, all -> 0x023b }
                r0.append(r2)     // Catch:{ IOException -> 0x0240, all -> 0x023b }
                java.lang.String r2 = "_tmp"
                r0.append(r2)     // Catch:{ IOException -> 0x0240, all -> 0x023b }
                java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0240, all -> 0x023b }
                r11.<init>(r5, r0)     // Catch:{ IOException -> 0x0240, all -> 0x023b }
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0239, all -> 0x0237 }
                r2.<init>(r11)     // Catch:{ IOException -> 0x0239, all -> 0x0237 }
                int r0 = r6.f1335a     // Catch:{ IOException -> 0x0233, all -> 0x022f }
                if (r0 > 0) goto L_0x01e7
                r6.f1335a = r10     // Catch:{ IOException -> 0x0233, all -> 0x022f }
                r0 = 3
                r6.d = r0     // Catch:{ IOException -> 0x0233, all -> 0x022f }
                goto L_0x01ec
            L_0x01e7:
                r6.f1335a = r10     // Catch:{ IOException -> 0x0233, all -> 0x022f }
                r0 = 3
                r6.d = r0     // Catch:{ IOException -> 0x0233, all -> 0x022f }
            L_0x01ec:
                byte[] r0 = r6.a()     // Catch:{ IOException -> 0x0233, all -> 0x022f }
                r2.write(r0)     // Catch:{ IOException -> 0x0233, all -> 0x022f }
                r0 = 0
            L_0x01f4:
                int r3 = r7.size()     // Catch:{ IOException -> 0x0233, all -> 0x022f }
                if (r0 >= r3) goto L_0x020a
                java.lang.Object r3 = r7.get(r0)     // Catch:{ IOException -> 0x0233, all -> 0x022f }
                net.fxgear.fittingmodenative.c$a$a r3 = (net.fxgear.fittingmodenative.c.a.C0041a) r3     // Catch:{ IOException -> 0x0233, all -> 0x022f }
                byte[] r3 = r3.a()     // Catch:{ IOException -> 0x0233, all -> 0x022f }
                r2.write(r3)     // Catch:{ IOException -> 0x0233, all -> 0x022f }
                int r0 = r0 + 1
                goto L_0x01f4
            L_0x020a:
                r2.close()     // Catch:{ IOException -> 0x0220 }
                java.io.File r0 = r1.i
                boolean r0 = r0.exists()
                if (r0 == 0) goto L_0x021a
                java.io.File r0 = r1.i
                r0.delete()
            L_0x021a:
                java.io.File r0 = r1.i
                r11.renameTo(r0)
                return r12
            L_0x0220:
                r0 = move-exception
                r2 = r0
                boolean r0 = r11.exists()
                if (r0 == 0) goto L_0x022b
                r11.delete()
            L_0x022b:
                r2.printStackTrace()
                return r4
            L_0x022f:
                r0 = move-exception
                r16 = r2
                goto L_0x026d
            L_0x0233:
                r0 = move-exception
                r16 = r2
                goto L_0x0244
            L_0x0237:
                r0 = move-exception
                goto L_0x023d
            L_0x0239:
                r0 = move-exception
                goto L_0x0242
            L_0x023b:
                r0 = move-exception
                r11 = 0
            L_0x023d:
                r16 = 0
                goto L_0x026d
            L_0x0240:
                r0 = move-exception
                r11 = 0
            L_0x0242:
                r16 = 0
            L_0x0244:
                if (r11 == 0) goto L_0x0252
                boolean r2 = r11.exists()     // Catch:{ all -> 0x0250 }
                if (r2 == 0) goto L_0x0252
                r11.delete()     // Catch:{ all -> 0x0250 }
                goto L_0x0252
            L_0x0250:
                r0 = move-exception
                goto L_0x026d
            L_0x0252:
                r0.printStackTrace()     // Catch:{ all -> 0x0250 }
                if (r16 == 0) goto L_0x026c
                r16.close()     // Catch:{ IOException -> 0x025b }
                goto L_0x026c
            L_0x025b:
                r0 = move-exception
                r2 = r0
                if (r11 == 0) goto L_0x0268
                boolean r0 = r11.exists()
                if (r0 == 0) goto L_0x0268
                r11.delete()
            L_0x0268:
                r2.printStackTrace()
                return r4
            L_0x026c:
                return r4
            L_0x026d:
                if (r16 == 0) goto L_0x0284
                r16.close()     // Catch:{ IOException -> 0x0273 }
                goto L_0x0284
            L_0x0273:
                r0 = move-exception
                r2 = r0
                if (r11 == 0) goto L_0x0280
                boolean r0 = r11.exists()
                if (r0 == 0) goto L_0x0280
                r11.delete()
            L_0x0280:
                r2.printStackTrace()
                return r4
            L_0x0284:
                throw r0
            L_0x0285:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.c.a.a(android.content.Context, java.util.ArrayList, net.fxgear.fittingmodenative.d.b):boolean");
        }

        public b a() {
            if (this.i == null || !this.i.exists()) {
                return null;
            }
            return new b(this.i);
        }

        public boolean a(Context context) {
            f.f1467a.getClass();
            if (context == null || this.i == null || !this.i.exists()) {
                Log.e(this.f1329a, "ERROR :: param error.");
            } else if (new b(this.i).f1335a < 2) {
                return false;
            } else {
                switch (2) {
                    case 1:
                        String b2 = b();
                        if (b2 != null) {
                            try {
                                File GetRootDirectory = GlobalDefine.GetRootDirectory(context);
                                JSONArray jSONArray = new JSONObject(b2).getJSONArray("file_list");
                                int length = jSONArray.length();
                                int i2 = 0;
                                while (i2 < length) {
                                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                                    if (jSONObject == null || jSONObject.getString("file_name") == null) {
                                        Log.e(this.f1329a, "ERROR :: wrong data file.");
                                        return false;
                                    } else if (new File(GetRootDirectory, jSONObject.getString("file_name")).length() != jSONObject.getLong("file_length")) {
                                        Log.e(this.f1329a, "ERROR :: wrong data file.");
                                        return false;
                                    } else {
                                        i2++;
                                    }
                                }
                                return true;
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                                break;
                            }
                        }
                        break;
                    case 2:
                        File parentFile = this.i.getParentFile();
                        for (int i3 = 0; i3 < 3; i3++) {
                            String a2 = a(new File(parentFile, String.format(GlobalDefine.FORMAT_VERIFICATION_CONTENTS_FILE_NAME, new Object[]{Integer.valueOf(i3)})));
                            if (a2 != null) {
                                try {
                                    File GetRootDirectory2 = GlobalDefine.GetRootDirectory(context);
                                    JSONArray jSONArray2 = new JSONObject(a2).getJSONArray("file_list");
                                    int length2 = jSONArray2.length();
                                    int i4 = 0;
                                    while (i4 < length2) {
                                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i4);
                                        if (jSONObject2 == null || jSONObject2.getString("file_name") == null) {
                                            Log.e(this.f1329a, "ERROR :: wrong data file.");
                                            return false;
                                        }
                                        File file = new File(GetRootDirectory2, jSONObject2.getString("file_name"));
                                        if (!file.exists()) {
                                            Log.e(this.f1329a, "ERROR :: Not exists file.");
                                            return false;
                                        } else if (file.length() != jSONObject2.getLong("file_length")) {
                                            Log.e(this.f1329a, "ERROR :: Wrong file length.");
                                            return false;
                                        } else {
                                            i4++;
                                        }
                                    }
                                    continue;
                                } catch (JSONException e3) {
                                    e3.printStackTrace();
                                    return false;
                                }
                            }
                        }
                        return true;
                }
            }
            return false;
        }

        public ArrayList<Integer> b(Context context) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            if (context == null || this.i == null || !this.i.exists()) {
                Log.e(this.f1329a, "ERROR :: param error.");
            } else {
                switch (2) {
                    case 1:
                        String b2 = b();
                        if (b2 != null) {
                            try {
                                File GetRootDirectory = GlobalDefine.GetRootDirectory(context);
                                JSONArray jSONArray = new JSONObject(b2).getJSONArray("file_list");
                                int length = jSONArray.length();
                                int i2 = 0;
                                while (i2 < length) {
                                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                                    if (jSONObject == null || jSONObject.getString("file_name") == null) {
                                        Log.e(this.f1329a, "ERROR :: wrong data file.");
                                        arrayList.add(0);
                                        return arrayList;
                                    } else if (new File(GetRootDirectory, jSONObject.getString("file_name")).length() != jSONObject.getLong("file_length")) {
                                        Log.e(this.f1329a, "ERROR :: wrong data file.");
                                        arrayList.add(0);
                                        return arrayList;
                                    } else {
                                        i2++;
                                    }
                                }
                                return arrayList;
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                                break;
                            }
                        }
                        break;
                    case 2:
                        File parentFile = this.i.getParentFile();
                        for (int i3 = 0; i3 < 3; i3++) {
                            String a2 = a(new File(parentFile, String.format(GlobalDefine.FORMAT_VERIFICATION_CONTENTS_FILE_NAME, new Object[]{Integer.valueOf(i3)})));
                            if (a2 != null) {
                                try {
                                    File GetRootDirectory2 = GlobalDefine.GetRootDirectory(context);
                                    JSONArray jSONArray2 = new JSONObject(a2).getJSONArray("file_list");
                                    int length2 = jSONArray2.length();
                                    int i4 = 0;
                                    while (true) {
                                        if (i4 < length2) {
                                            JSONObject jSONObject2 = jSONArray2.getJSONObject(i4);
                                            if (jSONObject2 == null || jSONObject2.getString("file_name") == null) {
                                                Log.e(this.f1329a, "ERROR :: wrong data file.");
                                                arrayList.add(Integer.valueOf(i3));
                                                break;
                                            } else {
                                                File file = new File(GetRootDirectory2, jSONObject2.getString("file_name"));
                                                if (!file.exists()) {
                                                    Log.e(this.f1329a, "ERROR :: Not exists file.");
                                                    arrayList.add(Integer.valueOf(i3));
                                                } else if (file.length() != jSONObject2.getLong("file_length")) {
                                                    Log.e(this.f1329a, "ERROR :: Wrong file length.");
                                                    arrayList.add(Integer.valueOf(i3));
                                                } else {
                                                    i4++;
                                                }
                                            }
                                        }
                                    }
                                } catch (JSONException e3) {
                                    e3.printStackTrace();
                                    arrayList.add(Integer.valueOf(i3));
                                }
                            }
                        }
                        return arrayList;
                }
            }
            return arrayList;
        }
    }

    /* access modifiers changed from: private */
    public static String b(h.a aVar) {
        String[] split = aVar.c.split("/");
        if (split != null) {
            for (String str : split) {
                if (!str.isEmpty() && b(str)) {
                    return str;
                }
            }
            return null;
        }
        Log.d(f1328a, "GetBodySize() ERROR :: Not found tagName");
        return null;
    }

    private static boolean b(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static boolean b(String str, String str2) {
        if (str2 != null && Integer.parseInt(str.substring(1, str.length())) <= Integer.parseInt(str2.substring(1, str2.length()))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static boolean c(String str) {
        try {
            return Integer.parseInt(str.substring(1, str.length())) > 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            String str2 = f1328a;
            Log.i(str2, "wrong serverVersion = " + str);
            return false;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\d.java ==========

package net.fxgear.fittingmodenative;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import net.fxgear.a.a;

/* compiled from: FittingModeActionBar */
public class d extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final String f1403a = "FittingModeActionBar";

    /* renamed from: b  reason: collision with root package name */
    private int f1404b;
    private int c;
    private Button d;
    private Button e;
    private RelativeLayout f;
    private RelativeLayout g;
    private RelativeLayout h;
    private TextView i;
    private LinearLayout j;
    private Button k;
    private Button l;
    private a m;
    private boolean n;

    /* compiled from: FittingModeActionBar */
    public interface a {
        void OnClickActionNavigationButton(int i);

        void OnClickActionOptionButton(int i);

        void OnClickFittingModeButton(int i);
    }

    public d(Context context) {
        super(context);
        inflate(context, a.f.layout_fitting_mode_actionbar, this);
        this.d = (Button) findViewById(a.e.btn_action_navigation);
        this.d.setOnClickListener(this);
        this.e = (Button) findViewById(a.e.btn_action_option);
        this.e.setOnClickListener(this);
        this.f = (RelativeLayout) findViewById(a.e.actoin_option_gender_layout);
        this.g = (RelativeLayout) findViewById(a.e.option_view_for_man);
        this.h = (RelativeLayout) findViewById(a.e.option_view_for_woman);
        this.f.setOnClickListener(this);
        this.f.setVisibility(4);
        this.e.setVisibility(0);
        this.e.setBackgroundResource(a.d.fitting_actionbar_option_btn);
        this.f.setVisibility(8);
        this.i = (TextView) findViewById(a.e.action_title);
        this.j = (LinearLayout) findViewById(a.e.action_fitting_mode_layout);
        this.k = (Button) findViewById(a.e.real_fitting_mode_button);
        this.k.setOnClickListener(this);
        this.k.setSelected(true);
        this.l = (Button) findViewById(a.e.avatar_fitting_mode_button);
        this.l.setOnClickListener(this);
        this.k.setSelected(false);
    }

    public void a(int i2, String str, int i3, boolean z) {
        this.f1404b = i2;
        if (this.f1404b == 1 || this.f1404b == 2) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(4);
        }
        if (str != null) {
            this.i.setVisibility(0);
            this.i.setText(str);
        } else {
            this.i.setVisibility(4);
        }
        this.c = i3;
        if (this.c == 1) {
            this.e.setVisibility(0);
            this.e.setBackgroundResource(a.d.fitting_actionbar_option_btn);
        } else if (this.c == 2) {
            this.e.setVisibility(0);
            this.e.setBackgroundResource(a.d.change_face_camera_btn);
        } else {
            this.e.setVisibility(4);
        }
        this.n = z;
        if (this.n) {
            this.j.setVisibility(0);
            a(false);
            return;
        }
        this.j.setVisibility(4);
    }

    public void a(boolean z) {
        Log.d("FittingModeActionBar", "SwitchFittingModeRadioButtonForAvatar, isAvatarFittingMode : " + z);
        if (!this.n) {
            Log.e("FittingModeActionBar", "It is NOT RootView");
        } else if (this.j == null) {
        } else {
            if (z) {
                this.l.setSelected(true);
                this.k.setSelected(false);
                return;
            }
            this.l.setSelected(false);
            this.k.setSelected(true);
        }
    }

    public void b(boolean z) {
        Log.d("FittingModeActionBar", "SwitchFittingModeGenderButton, isFittingModeForMan : " + z);
        if (this.c != 1) {
            Log.e("FittingModeActionBar", "mCurrentActionOption is wrong: " + this.c);
        }
    }

    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == a.e.btn_action_navigation) {
                if (this.m != null) {
                    this.m.OnClickActionNavigationButton(this.f1404b);
                }
            } else if (id == a.e.btn_action_option) {
                if (this.m != null) {
                    this.m.OnClickActionOptionButton(this.c);
                }
            } else if (id != a.e.actoin_option_gender_layout) {
                if (id == a.e.avatar_fitting_mode_button) {
                    if (this.m != null) {
                        this.m.OnClickFittingModeButton(1);
                    }
                } else if (id == a.e.real_fitting_mode_button && this.m != null) {
                    this.m.OnClickFittingModeButton(0);
                }
            }
        }
    }

    public void a(a aVar) {
        this.m = aVar;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\e.java ==========

package net.fxgear.fittingmodenative;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import net.fxgear.FittingView;
import net.fxgear.GlobalDefine;
import net.fxgear.fitnshop.d.m;
import net.fxgear.util.FXDataManager;
import net.fxgear.util.FXUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FittingModeDataManager */
public class e {
    private static e L;
    private final String A = "version";
    private final String B = "%s = ?";
    private final String C = "%s %s";
    private final String D = "ASC";
    private final String E = "DESC";
    private final String F = ",";
    private ArrayList<a> G = new ArrayList<>();
    private ArrayList<FittingView.ClothesFileInfo> H = new ArrayList<>();
    /* access modifiers changed from: private */
    public Context I;
    /* access modifiers changed from: private */
    public boolean J;
    private b K;
    private final String M = "clothes";
    private final String N = "baseCategory";
    private final String O = "thumbnail.png";
    private final String P = GlobalDefine.FILE_NAME_PACKAGE;
    private final String Q = "ProductInfo.json";
    private final String R = "ProductInfo";
    private final String S = "make_category_name";
    private final String T = "Kid";
    private final String U = "Man";

    /* renamed from: a  reason: collision with root package name */
    private final String f1459a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final String f1460b = "clothes";
    private final String c = "id";
    private final String d = "gender";
    private final String e = "age";
    private final String f = "cloth_type";
    private final String g = "base_folder";
    private final String h = "cloth_folder";
    private final String i = "thumbnail_url";
    private final String j = "package_file_url";
    private final String k = "base_category_version";
    private final String l = "table_category";
    private final String m = "id";
    private final String n = "category_id";
    private final String o = "category_name";
    private final String p = "category_gender";
    private final String q = "category_age";
    private final String r = "real_video";
    private final String s = "id";
    private final String t = "gender";
    private final String u = "age";
    private final String v = "date";
    private final String w = "body_size";
    private final String x = "animation_url";
    private final String y = "video_url";
    private final String z = "capture_url";

    /* compiled from: FittingModeDataManager */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f1461a;

        /* renamed from: b  reason: collision with root package name */
        public int f1462b;
        public int c;
        public int d;
        public int e;
        public String f;
    }

    /* compiled from: FittingModeDataManager */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public int f1465a;

        /* renamed from: b  reason: collision with root package name */
        public int f1466b;
        public int c;
        public int d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public int j;
        public FittingView.RealVideoFileInfo k = new FittingView.RealVideoFileInfo();

        public c() {
        }
    }

    public static e a(Context context) {
        if (L == null) {
            L = new e(context);
        }
        return L;
    }

    private e(Context context) {
        this.I = context;
        this.J = true;
        this.K = new b(context, "fitting_mode_data.db", (SQLiteDatabase.CursorFactory) null, 5);
    }

    public synchronized String a() {
        String str;
        str = null;
        SQLiteDatabase readableDatabase = this.K != null ? this.K.getReadableDatabase() : null;
        if (readableDatabase != null && readableDatabase.isOpen()) {
            Cursor query = readableDatabase.query("table_category", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, String.format("%s %s", new Object[]{"id", "ASC"}));
            if (query != null) {
                if (query.getCount() > 0 && query.moveToFirst()) {
                    JSONArray jSONArray = new JSONArray();
                    do {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            int i2 = query.getInt(query.getColumnIndex("category_id"));
                            String string = query.getString(query.getColumnIndex("category_name"));
                            String string2 = query.getString(query.getColumnIndex("category_gender"));
                            String string3 = query.getString(query.getColumnIndex("category_age"));
                            jSONObject.put("category_id", i2);
                            jSONObject.put("category_name", string);
                            jSONObject.put("gender", string2);
                            jSONObject.put("age", string3);
                            jSONArray.put(jSONObject);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    } while (query.moveToNext());
                    str = jSONArray.toString();
                }
                query.close();
            }
            readableDatabase.close();
        }
        return str;
    }

    public synchronized void a(String str) {
        String str2 = str;
        synchronized (this) {
            if (str2 != null) {
                if (!str.isEmpty()) {
                    SQLiteDatabase readableDatabase = this.K != null ? this.K.getReadableDatabase() : null;
                    if (readableDatabase != null && readableDatabase.isOpen()) {
                        Cursor query = readableDatabase.query("table_category", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, String.format("%s %s", new Object[]{"id", "ASC"}));
                        if (query != null) {
                            try {
                                int count = query.getCount();
                                JSONArray jSONArray = new JSONArray(str2);
                                int length = jSONArray.length();
                                if (count > length) {
                                    count = length;
                                }
                                int i2 = 0;
                                while (i2 < count) {
                                    query.moveToPosition(i2);
                                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                                    int i3 = query.getInt(query.getColumnIndex("id"));
                                    int i4 = query.getInt(query.getColumnIndex("category_id"));
                                    String string = query.getString(query.getColumnIndex("category_name"));
                                    String string2 = query.getString(query.getColumnIndex("category_gender"));
                                    String string3 = query.getString(query.getColumnIndex("category_age"));
                                    int i5 = jSONObject.getInt("category_id");
                                    String string4 = jSONObject.getString("category_name");
                                    String string5 = jSONObject.getString("gender");
                                    JSONArray jSONArray2 = jSONArray;
                                    String string6 = jSONObject.getString("age");
                                    if (i4 != i5 || !string.equals(string4) || !string2.equals(string5) || !string3.equals(string6)) {
                                        ContentValues contentValues = new ContentValues();
                                        contentValues.put("category_id", Integer.valueOf(i5));
                                        contentValues.put("category_name", string4);
                                        contentValues.put("category_gender", string5);
                                        contentValues.put("category_age", string6);
                                        readableDatabase.update("table_category", contentValues, String.format("%s = ?", new Object[]{"id"}), new String[]{String.valueOf(i3)});
                                    }
                                    i2++;
                                    jSONArray = jSONArray2;
                                }
                                JSONArray jSONArray3 = jSONArray;
                                if (count == length) {
                                    while (query.moveToNext()) {
                                        readableDatabase.delete("table_category", String.format("%s = ?", new Object[]{"id"}), new String[]{String.valueOf(query.getInt(query.getColumnIndex("id")))});
                                    }
                                } else {
                                    while (count < length) {
                                        JSONArray jSONArray4 = jSONArray3;
                                        JSONObject jSONObject2 = jSONArray4.getJSONObject(count);
                                        int i6 = jSONObject2.getInt("category_id");
                                        String string7 = jSONObject2.getString("category_name");
                                        String string8 = jSONObject2.getString("gender");
                                        String string9 = jSONObject2.getString("age");
                                        ContentValues contentValues2 = new ContentValues();
                                        contentValues2.put("category_id", Integer.valueOf(i6));
                                        contentValues2.put("category_name", string7);
                                        contentValues2.put("category_gender", string8);
                                        contentValues2.put("category_age", string9);
                                        readableDatabase.insert("table_category", (String) null, contentValues2);
                                        count++;
                                        jSONArray3 = jSONArray4;
                                    }
                                }
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            query.close();
                        }
                        readableDatabase.close();
                    }
                }
            }
        }
    }

    public synchronized boolean a(int i2, int i3, int i4, int i5, String str, String str2, String str3, String str4) {
        boolean z2;
        Log.i(this.f1459a, "AddClothData()");
        z2 = false;
        SQLiteDatabase writableDatabase = this.K != null ? this.K.getWritableDatabase() : null;
        if (writableDatabase != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(i2));
            contentValues.put("gender", Integer.valueOf(i3));
            contentValues.put("age", Integer.valueOf(i4));
            contentValues.put("cloth_type", Integer.valueOf(i5));
            contentValues.put("base_folder", str);
            contentValues.put("cloth_folder", str2);
            contentValues.put("thumbnail_url", str3);
            contentValues.put("package_file_url", str4);
            if (writableDatabase.isOpen()) {
                long insert = writableDatabase.insert("clothes", (String) null, contentValues);
                if (insert > -1) {
                    z2 = true;
                } else {
                    String str5 = this.f1459a;
                    Log.e(str5, "AddClothData() is fail, error = " + insert);
                }
                writableDatabase.close();
            } else {
                Log.e(this.f1459a, "AddClothData() is fail, DB is closed.");
            }
        }
        return z2;
    }

    public synchronized boolean b(int i2, int i3, int i4, int i5, String str, String str2, String str3, String str4) {
        boolean z2;
        Log.i(this.f1459a, "UpdateClothData()");
        SQLiteDatabase writableDatabase = this.K != null ? this.K.getWritableDatabase() : null;
        z2 = false;
        if (writableDatabase != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("gender", Integer.valueOf(i3));
            contentValues.put("age", Integer.valueOf(i4));
            contentValues.put("cloth_type", Integer.valueOf(i5));
            contentValues.put("base_folder", str);
            contentValues.put("cloth_folder", str2);
            contentValues.put("thumbnail_url", str3);
            contentValues.put("package_file_url", str4);
            if (writableDatabase.isOpen()) {
                long update = (long) writableDatabase.update("clothes", contentValues, "id = ?", new String[]{String.valueOf(i2)});
                if (update > -1) {
                    z2 = true;
                } else {
                    String str5 = this.f1459a;
                    Log.e(str5, "UpdateClothData() is fail, error = " + update);
                }
                writableDatabase.close();
            } else {
                Log.e(this.f1459a, "UpdateClothData() is fail, DB is closed.");
            }
        }
        return z2;
    }

    public synchronized boolean a(int i2) {
        boolean z2;
        String str = this.f1459a;
        Log.i(str, "RemoveClothData(), id = " + i2);
        SQLiteDatabase writableDatabase = this.K != null ? this.K.getWritableDatabase() : null;
        z2 = false;
        if (writableDatabase != null) {
            if (writableDatabase.isOpen()) {
                int delete = writableDatabase.delete("clothes", String.format("%s = ?", new Object[]{"id"}), new String[]{String.valueOf(i2)});
                if (delete < 1) {
                    String str2 = this.f1459a;
                    Log.e(str2, "RemoveClothData() is fail, error = " + delete);
                } else {
                    z2 = true;
                }
                writableDatabase.close();
            } else {
                Log.e(this.f1459a, "RemoveClothData() is fail, DB is closed.");
            }
        }
        return z2;
    }

    public synchronized a b(int i2) {
        a aVar;
        String str = this.f1459a;
        Log.i(str, "GetClothData(), id = " + i2);
        aVar = null;
        SQLiteDatabase writableDatabase = this.K != null ? this.K.getWritableDatabase() : null;
        if (writableDatabase != null) {
            if (writableDatabase.isOpen()) {
                Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM clothes WHERE id=" + i2 + ";", (String[]) null);
                if (rawQuery != null) {
                    if (rawQuery.getCount() == 1) {
                        rawQuery.moveToNext();
                        aVar = new a();
                        aVar.f1461a = rawQuery.getInt(rawQuery.getColumnIndex("id"));
                        aVar.f1462b = rawQuery.getInt(rawQuery.getColumnIndex("gender"));
                        aVar.c = rawQuery.getInt(rawQuery.getColumnIndex("age"));
                        aVar.d = rawQuery.getInt(rawQuery.getColumnIndex("cloth_type"));
                        FittingView.ClothesFileInfo clothesFileInfo = new FittingView.ClothesFileInfo();
                        clothesFileInfo.mClothType = aVar.d;
                        String string = rawQuery.getString(rawQuery.getColumnIndex("base_folder"));
                        clothesFileInfo.mBaseDirectoryPath = GlobalDefine.GetRootDirectory(this.I) + File.separator + string;
                        clothesFileInfo.mPackageFilePath = f.b(this.I, rawQuery.getString(rawQuery.getColumnIndex("package_file_url")));
                        if (a(clothesFileInfo)) {
                            aVar.e = 1;
                        } else {
                            aVar.e = 0;
                        }
                        aVar.f = rawQuery.getString(rawQuery.getColumnIndex("thumbnail_url"));
                    }
                    rawQuery.close();
                }
                writableDatabase.close();
            } else {
                Log.e(this.f1459a, "GetClothData() is fail, DB is closed.");
            }
        }
        return aVar;
    }

    public synchronized boolean c(int i2) {
        boolean z2;
        String str = this.f1459a;
        Log.i(str, "ExistClothData(), id = " + i2);
        z2 = false;
        SQLiteDatabase writableDatabase = this.K != null ? this.K.getWritableDatabase() : null;
        if (writableDatabase != null) {
            if (writableDatabase.isOpen()) {
                Cursor rawQuery = writableDatabase.rawQuery("SELECT id FROM clothes WHERE id=" + i2 + ";", (String[]) null);
                if (rawQuery != null) {
                    if (rawQuery.getCount() == 1) {
                        rawQuery.moveToNext();
                        if (rawQuery.getInt(rawQuery.getColumnIndex("id")) == i2) {
                            z2 = true;
                        }
                    }
                    rawQuery.close();
                }
                writableDatabase.close();
            } else {
                Log.e(this.f1459a, "IsExistClothData() is fail, DB is closed.");
            }
        }
        return z2;
    }

    public synchronized String d(int i2) {
        String str;
        String str2 = this.f1459a;
        Log.i(str2, "GetPackageFileUrl(), id = " + i2);
        str = null;
        SQLiteDatabase writableDatabase = this.K != null ? this.K.getWritableDatabase() : null;
        if (writableDatabase != null) {
            if (writableDatabase.isOpen()) {
                Cursor rawQuery = writableDatabase.rawQuery("SELECT package_file_url FROM clothes WHERE id=" + i2 + ";", (String[]) null);
                if (rawQuery != null) {
                    if (rawQuery.getCount() == 1) {
                        rawQuery.moveToNext();
                        str = rawQuery.getString(rawQuery.getColumnIndex("package_file_url"));
                    }
                    rawQuery.close();
                }
                writableDatabase.close();
            } else {
                Log.e(this.f1459a, "GetPackageFileUrl() is fail, DB is closed.");
            }
        }
        return str;
    }

    public synchronized FittingView.ClothesFileInfo e(int i2) {
        FittingView.ClothesFileInfo clothesFileInfo;
        String str = this.f1459a;
        Log.i(str, "GetClothesFileInfo(), id = " + i2);
        f.f1467a.getClass();
        clothesFileInfo = null;
        SQLiteDatabase writableDatabase = this.K != null ? this.K.getWritableDatabase() : null;
        if (writableDatabase != null) {
            if (writableDatabase.isOpen()) {
                Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM clothes WHERE id=" + i2 + ";", (String[]) null);
                if (rawQuery != null) {
                    if (rawQuery.getCount() == 1) {
                        rawQuery.moveToNext();
                        if (rawQuery.getInt(rawQuery.getColumnIndex("id")) == i2) {
                            clothesFileInfo = new FittingView.ClothesFileInfo();
                            clothesFileInfo.mClothType = rawQuery.getInt(rawQuery.getColumnIndex("cloth_type"));
                            String string = rawQuery.getString(rawQuery.getColumnIndex("base_folder"));
                            clothesFileInfo.mBaseDirectoryPath = GlobalDefine.GetRootDirectory(this.I) + File.separator + string;
                            clothesFileInfo.mPackageFilePath = f.b(this.I, rawQuery.getString(rawQuery.getColumnIndex("package_file_url")));
                        }
                    }
                    rawQuery.close();
                }
                writableDatabase.close();
            } else {
                Log.e(this.f1459a, "GetClothesFileInfo() is fail, DB is closed.");
            }
        }
        return clothesFileInfo;
    }

    public boolean a(FittingView.ClothesFileInfo clothesFileInfo) {
        if (clothesFileInfo == null) {
            Log.d(this.f1459a, "Not found cloth ID");
            return false;
        } else if (!b(clothesFileInfo) || !c(clothesFileInfo)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean b(FittingView.ClothesFileInfo clothesFileInfo) {
        if (clothesFileInfo == null || clothesFileInfo.mBaseDirectoryPath == null) {
            return false;
        }
        File file = new File(clothesFileInfo.mBaseDirectoryPath);
        String name = file.getName();
        String GetClothTargetName = GlobalDefine.GetClothTargetName(name);
        for (int i2 = 1; i2 <= 26; i2++) {
            File file2 = new File(file, String.format(GlobalDefine.FILE_NAME_FORMAT_CLOTH_BLEND_TARGET, new Object[]{GetClothTargetName, String.format("%03d", new Object[]{Integer.valueOf(i2)})}));
            if (!file2.exists()) {
                String str = this.f1459a;
                Log.e(str, "[" + name + "] Not found file : " + file2.getAbsolutePath());
                return false;
            }
        }
        File file3 = new File(file, String.format(GlobalDefine.FILE_NAME_FORMAT_CLOTH_BASE_MESH, new Object[]{GetClothTargetName}));
        if (!file3.exists()) {
            String str2 = this.f1459a;
            Log.e(str2, "[" + name + "] Not found file : " + file3.getAbsolutePath());
            return false;
        }
        if (GlobalDefine.GetClothesCategoryType(name) == GlobalDefine.CLOTHES_CATEGORY_TYPE.TuckIn) {
            for (int i3 = 1; i3 <= 8; i3++) {
                File file4 = new File(file, String.format(GlobalDefine.FILE_NAME_FORMAT_CLOTH_TUCKIN_TARGET, new Object[]{GetClothTargetName, String.format("%03d", new Object[]{Integer.valueOf(i3)})}));
                if (!file4.exists()) {
                    String str3 = this.f1459a;
                    Log.e(str3, "[" + name + "] Not found file : " + file4.getAbsolutePath());
                    return false;
                }
            }
        }
        return true;
    }

    public boolean c(FittingView.ClothesFileInfo clothesFileInfo) {
        if (!(clothesFileInfo == null || clothesFileInfo.mPackageFilePath == null)) {
            if (new File(clothesFileInfo.mPackageFilePath).exists()) {
                return true;
            }
            Log.e(this.f1459a, "[ERROR] :: packageFile doesn't exist");
        }
        return false;
    }

    public synchronized ArrayList<String> b() {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        SQLiteDatabase writableDatabase = this.K != null ? this.K.getWritableDatabase() : null;
        if (writableDatabase != null) {
            if (writableDatabase.isOpen()) {
                Cursor rawQuery = writableDatabase.rawQuery("SELECT DISTINCT base_folder FROM clothes;", (String[]) null);
                if (rawQuery != null) {
                    if (rawQuery.getCount() > 0) {
                        while (rawQuery.moveToNext()) {
                            String string = rawQuery.getString(rawQuery.getColumnIndex("base_folder"));
                            arrayList.add(string.substring(string.lastIndexOf("/") + 1));
                        }
                    }
                    rawQuery.close();
                }
                writableDatabase.close();
            } else {
                Log.e(this.f1459a, "GetAllBaseCategoryNames() is fail, DB is closed.");
            }
        }
        return arrayList;
    }

    public synchronized int b(String str) {
        int i2;
        i2 = -1;
        SQLiteDatabase writableDatabase = this.K != null ? this.K.getWritableDatabase() : null;
        if (writableDatabase != null) {
            if (writableDatabase.isOpen()) {
                Cursor rawQuery = writableDatabase.rawQuery("SELECT base_category_version FROM clothes WHERE base_folder LIKE '%" + str + "';", (String[]) null);
                if (rawQuery != null) {
                    if (rawQuery.getCount() > 0) {
                        rawQuery.moveToFirst();
                        i2 = rawQuery.getInt(rawQuery.getColumnIndex("base_category_version"));
                    }
                    rawQuery.close();
                }
                writableDatabase.close();
            } else {
                Log.e(this.f1459a, "GetAllBaseCategoryNames() is fail, DB is closed.");
            }
        }
        return i2;
    }

    public synchronized boolean a(String str, int i2) {
        boolean z2;
        SQLiteDatabase writableDatabase = this.K != null ? this.K.getWritableDatabase() : null;
        z2 = false;
        if (writableDatabase != null) {
            if (writableDatabase.isOpen()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("base_category_version", Integer.valueOf(i2));
                long update = (long) writableDatabase.update("clothes", contentValues, "base_folder LIKE ?", new String[]{"%" + str});
                if (update > -1) {
                    z2 = true;
                } else {
                    String str2 = this.f1459a;
                    Log.e(str2, "SetBaseCategoryVersion() is fail, error = " + update);
                }
                writableDatabase.close();
            } else {
                Log.e(this.f1459a, "SetBaseCategoryVersion() is fail, DB is closed.");
            }
        }
        return z2;
    }

    public synchronized void c(String str) {
        SQLiteDatabase writableDatabase = this.K != null ? this.K.getWritableDatabase() : null;
        if (writableDatabase != null) {
            if (writableDatabase.isOpen()) {
                Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM clothes WHERE base_folder LIKE ?", new String[]{"%" + str});
                if (rawQuery != null && rawQuery.getCount() > 0) {
                    while (rawQuery.moveToNext()) {
                        int i2 = rawQuery.getInt(rawQuery.getColumnIndex("id"));
                        String b2 = f.b(this.I, rawQuery.getString(rawQuery.getColumnIndex("package_file_url")));
                        writableDatabase.delete("clothes", "id = ?", new String[]{String.valueOf(i2)});
                        FXUtil.DeleteDirectoryRecursive(new File(GlobalDefine.GetRootDirectory(this.I) + File.separator + rawQuery.getString(rawQuery.getColumnIndex("base_folder"))));
                        FXUtil.DeleteDirectoryRecursive(new File(b2));
                    }
                }
                writableDatabase.close();
            } else {
                Log.e(this.f1459a, "DeleteBaseCategory() is fail, DB is closed.");
            }
        }
    }

    public synchronized String d(String str) {
        String str2;
        str2 = null;
        SQLiteDatabase writableDatabase = this.K != null ? this.K.getWritableDatabase() : null;
        if (writableDatabase != null) {
            if (writableDatabase.isOpen()) {
                Cursor rawQuery = writableDatabase.rawQuery("SELECT base_folder FROM clothes WHERE base_folder LIKE '%" + str + "';", (String[]) null);
                if (rawQuery != null) {
                    if (rawQuery.getCount() > 0) {
                        rawQuery.moveToFirst();
                        str2 = new File(GlobalDefine.GetRootDirectory(this.I), rawQuery.getString(rawQuery.getColumnIndex("base_folder"))).getAbsolutePath();
                    }
                    rawQuery.close();
                }
                writableDatabase.close();
            } else {
                Log.e(this.f1459a, "GetAllBaseCategoryNames() is fail, DB is closed.");
            }
        }
        return str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00df, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int a(int r7, int r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, int r14) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = -1
            net.fxgear.fittingmodenative.e$b r1 = r6.K     // Catch:{ all -> 0x00e0 }
            r2 = 0
            if (r1 == 0) goto L_0x000e
            net.fxgear.fittingmodenative.e$b r1 = r6.K     // Catch:{ all -> 0x00e0 }
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ all -> 0x00e0 }
            goto L_0x000f
        L_0x000e:
            r1 = r2
        L_0x000f:
            if (r1 == 0) goto L_0x00de
            boolean r3 = r1.isOpen()     // Catch:{ all -> 0x00e0 }
            if (r3 == 0) goto L_0x00d7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e0 }
            r3.<init>()     // Catch:{ all -> 0x00e0 }
            java.lang.String r4 = "SELECT id FROM real_video WHERE capture_url='"
            r3.append(r4)     // Catch:{ all -> 0x00e0 }
            r3.append(r13)     // Catch:{ all -> 0x00e0 }
            java.lang.String r4 = "';"
            r3.append(r4)     // Catch:{ all -> 0x00e0 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00e0 }
            android.database.Cursor r4 = r1.rawQuery(r3, r2)     // Catch:{ all -> 0x00e0 }
            if (r4 == 0) goto L_0x005a
            int r5 = r4.getCount()     // Catch:{ all -> 0x00e0 }
            if (r5 <= 0) goto L_0x0057
            java.lang.String r7 = r6.f1459a     // Catch:{ all -> 0x00e0 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e0 }
            r8.<init>()     // Catch:{ all -> 0x00e0 }
            java.lang.String r9 = "[ERROR] :: real video already exists, captureURL : "
            r8.append(r9)     // Catch:{ all -> 0x00e0 }
            r8.append(r13)     // Catch:{ all -> 0x00e0 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00e0 }
            android.util.Log.e(r7, r8)     // Catch:{ all -> 0x00e0 }
            r4.close()     // Catch:{ all -> 0x00e0 }
            r1.close()     // Catch:{ all -> 0x00e0 }
            monitor-exit(r6)
            return r0
        L_0x0057:
            r4.close()     // Catch:{ all -> 0x00e0 }
        L_0x005a:
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ all -> 0x00e0 }
            r4.<init>()     // Catch:{ all -> 0x00e0 }
            java.lang.String r5 = "gender"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x00e0 }
            r4.put(r5, r7)     // Catch:{ all -> 0x00e0 }
            java.lang.String r7 = "age"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x00e0 }
            r4.put(r7, r8)     // Catch:{ all -> 0x00e0 }
            java.lang.String r7 = "date"
            r4.put(r7, r9)     // Catch:{ all -> 0x00e0 }
            java.lang.String r7 = "body_size"
            r4.put(r7, r10)     // Catch:{ all -> 0x00e0 }
            java.lang.String r7 = "animation_url"
            r4.put(r7, r11)     // Catch:{ all -> 0x00e0 }
            java.lang.String r7 = "video_url"
            r4.put(r7, r12)     // Catch:{ all -> 0x00e0 }
            java.lang.String r7 = "capture_url"
            r4.put(r7, r13)     // Catch:{ all -> 0x00e0 }
            java.lang.String r7 = "version"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x00e0 }
            r4.put(r7, r8)     // Catch:{ all -> 0x00e0 }
            java.lang.String r7 = "real_video"
            long r7 = r1.insert(r7, r2, r4)     // Catch:{ all -> 0x00e0 }
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 <= 0) goto L_0x00bd
            android.database.Cursor r7 = r1.rawQuery(r3, r2)     // Catch:{ all -> 0x00e0 }
            if (r7 == 0) goto L_0x00d3
            int r8 = r7.getCount()     // Catch:{ all -> 0x00e0 }
            if (r8 <= 0) goto L_0x00b9
            r7.moveToFirst()     // Catch:{ all -> 0x00e0 }
            java.lang.String r8 = "id"
            int r8 = r7.getColumnIndex(r8)     // Catch:{ all -> 0x00e0 }
            int r8 = r7.getInt(r8)     // Catch:{ all -> 0x00e0 }
            r0 = r8
        L_0x00b9:
            r7.close()     // Catch:{ all -> 0x00e0 }
            goto L_0x00d3
        L_0x00bd:
            java.lang.String r9 = r6.f1459a     // Catch:{ all -> 0x00e0 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e0 }
            r10.<init>()     // Catch:{ all -> 0x00e0 }
            java.lang.String r11 = "AddRealVideoData() failed, error = "
            r10.append(r11)     // Catch:{ all -> 0x00e0 }
            r10.append(r7)     // Catch:{ all -> 0x00e0 }
            java.lang.String r7 = r10.toString()     // Catch:{ all -> 0x00e0 }
            android.util.Log.e(r9, r7)     // Catch:{ all -> 0x00e0 }
        L_0x00d3:
            r1.close()     // Catch:{ all -> 0x00e0 }
            goto L_0x00de
        L_0x00d7:
            java.lang.String r7 = r6.f1459a     // Catch:{ all -> 0x00e0 }
            java.lang.String r8 = "AddRealVideoData() failed, DB is closed."
            android.util.Log.e(r7, r8)     // Catch:{ all -> 0x00e0 }
        L_0x00de:
            monitor-exit(r6)
            return r0
        L_0x00e0:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.e.a(int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int):int");
    }

    public synchronized boolean a(int i2, String str) {
        boolean z2;
        SQLiteDatabase writableDatabase = this.K != null ? this.K.getWritableDatabase() : null;
        z2 = false;
        if (writableDatabase != null) {
            if (writableDatabase.isOpen()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("date", str);
                int update = writableDatabase.update("real_video", contentValues, String.format("%s = ?", new Object[]{"id"}), new String[]{String.valueOf(i2)});
                if (update > 0) {
                    z2 = true;
                } else {
                    String str2 = this.f1459a;
                    Log.e(str2, "UpdateRealVideoData() failed, error = " + update);
                }
                writableDatabase.close();
            } else {
                Log.e(this.f1459a, "UpdateRealVideoData() failed, DB is closed.");
            }
        }
        return z2;
    }

    public synchronized boolean a(int i2, String str, int i3, String str2) {
        boolean z2;
        SQLiteDatabase writableDatabase = this.K != null ? this.K.getWritableDatabase() : null;
        z2 = false;
        if (writableDatabase != null) {
            if (writableDatabase.isOpen()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("date", str);
                contentValues.put("version", Integer.valueOf(i3));
                contentValues.put("capture_url", str2);
                int update = writableDatabase.update("real_video", contentValues, String.format("%s = ?", new Object[]{"id"}), new String[]{String.valueOf(i2)});
                if (update > 0) {
                    z2 = true;
                } else {
                    String str3 = this.f1459a;
                    Log.e(str3, "UpdateRealVideoVersion() failed, error = " + update);
                }
                writableDatabase.close();
            } else {
                Log.e(this.f1459a, "UpdateRealVideoVersion() failed, DB is closed.");
            }
        }
        return z2;
    }

    public void a(int i2, boolean z2) {
        boolean z3;
        String str = this.f1459a;
        Log.i(str, "RemoveRealVideoFile(), id : " + i2 + ", removeOnlyFile : " + z2);
        if (z2) {
            z3 = a(i2, GlobalDefine.REAL_VIDEO_NONE_DATE);
        } else {
            z3 = f(i2);
        }
        c g2 = g(i2);
        if (!z3 || g2 == null || g2.k == null) {
            Log.i(this.f1459a, "[ERROR] :: fail to delete real video files");
            return;
        }
        File file = null;
        File file2 = g2.k.mAnimationFilePath != null ? new File(g2.k.mAnimationFilePath) : null;
        if (g2.k.mVideoFilePath != null) {
            file = new File(g2.k.mVideoFilePath);
        }
        if (file2 != null && file2.exists()) {
            file2.delete();
        }
        if (file != null && file.exists()) {
            file.delete();
        }
    }

    public synchronized boolean f(int i2) {
        boolean z2;
        SQLiteDatabase writableDatabase = this.K != null ? this.K.getWritableDatabase() : null;
        z2 = false;
        if (writableDatabase != null) {
            if (writableDatabase.isOpen()) {
                int delete = writableDatabase.delete("real_video", String.format("%s = ?", new Object[]{"id"}), new String[]{String.valueOf(i2)});
                if (delete > 0) {
                    z2 = true;
                } else {
                    String str = this.f1459a;
                    Log.e(str, "RemoveRealVideoData() failed, error = " + delete);
                }
                writableDatabase.close();
            } else {
                Log.e(this.f1459a, "RemoveRealVideoData() failed, DB is closed.");
            }
        }
        return z2;
    }

    public synchronized ArrayList<c> c() {
        ArrayList<c> arrayList;
        String str;
        String str2;
        arrayList = null;
        SQLiteDatabase writableDatabase = this.K != null ? this.K.getWritableDatabase() : null;
        if (writableDatabase != null) {
            if (writableDatabase.isOpen()) {
                Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM real_video;", (String[]) null);
                if (rawQuery != null) {
                    if (rawQuery.getCount() > 0) {
                        arrayList = new ArrayList<>();
                        while (rawQuery.moveToNext()) {
                            c cVar = new c();
                            cVar.f1465a = rawQuery.getInt(rawQuery.getColumnIndex("id"));
                            cVar.f1466b = rawQuery.getInt(rawQuery.getColumnIndex("gender"));
                            cVar.c = rawQuery.getInt(rawQuery.getColumnIndex("age"));
                            cVar.e = rawQuery.getString(rawQuery.getColumnIndex("date"));
                            cVar.f = rawQuery.getString(rawQuery.getColumnIndex("body_size"));
                            cVar.h = rawQuery.getString(rawQuery.getColumnIndex("animation_url"));
                            cVar.i = rawQuery.getString(rawQuery.getColumnIndex("video_url"));
                            cVar.g = rawQuery.getString(rawQuery.getColumnIndex("capture_url"));
                            cVar.j = rawQuery.getInt(rawQuery.getColumnIndex("version"));
                            if (cVar.f.equals(GlobalDefine.REAL_VIDEO_BODY_SIZE_CUSTOM)) {
                                str2 = String.format(GlobalDefine.FILE_NAME_FORMAT_ANIMATION, new Object[]{cVar.e});
                                str = String.format(GlobalDefine.FILE_NAME_FORMAT_VIDEO, new Object[]{cVar.e});
                            } else {
                                str2 = String.format(GlobalDefine.FILE_NAME_FORMAT_ANIMATION, new Object[]{cVar.f});
                                str = String.format(GlobalDefine.FILE_NAME_FORMAT_VIDEO, new Object[]{cVar.f});
                            }
                            File GetRealDirectory = GlobalDefine.GetRealDirectory(this.I, cVar.f1466b, cVar.c);
                            File file = new File(GetRealDirectory, str2);
                            File file2 = new File(GetRealDirectory, str);
                            cVar.k.mAnimationFilePath = file.getAbsolutePath();
                            cVar.k.mVideoFilePath = file2.getAbsolutePath();
                            cVar.d = a(cVar.k);
                            arrayList.add(cVar);
                        }
                    }
                    rawQuery.close();
                }
                writableDatabase.close();
            } else {
                Log.e(this.f1459a, "GetAllRealVideoDataList() failed, DB is closed.");
            }
        }
        return arrayList;
    }

    public synchronized ArrayList<c> a(int i2, int i3) {
        ArrayList<c> arrayList;
        String str;
        String str2;
        arrayList = null;
        SQLiteDatabase writableDatabase = this.K != null ? this.K.getWritableDatabase() : null;
        if (writableDatabase != null) {
            if (writableDatabase.isOpen()) {
                Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM real_video WHERE gender=" + i2 + " AND " + "age" + "=" + i3 + ";", (String[]) null);
                if (rawQuery != null) {
                    if (rawQuery.getCount() > 0) {
                        arrayList = new ArrayList<>();
                        while (rawQuery.moveToNext()) {
                            c cVar = new c();
                            cVar.f1465a = rawQuery.getInt(rawQuery.getColumnIndex("id"));
                            cVar.f1466b = rawQuery.getInt(rawQuery.getColumnIndex("gender"));
                            cVar.c = rawQuery.getInt(rawQuery.getColumnIndex("age"));
                            cVar.e = rawQuery.getString(rawQuery.getColumnIndex("date"));
                            cVar.f = rawQuery.getString(rawQuery.getColumnIndex("body_size"));
                            cVar.h = rawQuery.getString(rawQuery.getColumnIndex("animation_url"));
                            cVar.i = rawQuery.getString(rawQuery.getColumnIndex("video_url"));
                            cVar.g = rawQuery.getString(rawQuery.getColumnIndex("capture_url"));
                            cVar.j = rawQuery.getInt(rawQuery.getColumnIndex("version"));
                            if (cVar.f.equals(GlobalDefine.REAL_VIDEO_BODY_SIZE_CUSTOM)) {
                                str2 = String.format(GlobalDefine.FILE_NAME_FORMAT_ANIMATION, new Object[]{cVar.e});
                                str = String.format(GlobalDefine.FILE_NAME_FORMAT_VIDEO, new Object[]{cVar.e});
                            } else {
                                str2 = String.format(GlobalDefine.FILE_NAME_FORMAT_ANIMATION, new Object[]{cVar.f});
                                str = String.format(GlobalDefine.FILE_NAME_FORMAT_VIDEO, new Object[]{cVar.f});
                            }
                            File GetRealDirectory = GlobalDefine.GetRealDirectory(this.I, cVar.f1466b, cVar.c);
                            File file = new File(GetRealDirectory, str2);
                            File file2 = new File(GetRealDirectory, str);
                            cVar.k.mAnimationFilePath = file.getAbsolutePath();
                            cVar.k.mVideoFilePath = file2.getAbsolutePath();
                            cVar.d = a(cVar.k);
                            arrayList.add(cVar);
                        }
                    }
                    rawQuery.close();
                }
                writableDatabase.close();
            } else {
                Log.e(this.f1459a, "GetRealVideoDataList() failed, DB is closed.");
            }
        }
        return arrayList;
    }

    public synchronized c g(int i2) {
        c cVar;
        String str;
        String str2;
        cVar = null;
        SQLiteDatabase writableDatabase = this.K != null ? this.K.getWritableDatabase() : null;
        if (writableDatabase != null) {
            if (writableDatabase.isOpen()) {
                Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM real_video WHERE id=" + i2 + ";", (String[]) null);
                if (rawQuery != null) {
                    if (rawQuery.getCount() == 1) {
                        cVar = new c();
                        rawQuery.moveToNext();
                        cVar.f1465a = rawQuery.getInt(rawQuery.getColumnIndex("id"));
                        cVar.f1466b = rawQuery.getInt(rawQuery.getColumnIndex("gender"));
                        cVar.c = rawQuery.getInt(rawQuery.getColumnIndex("age"));
                        cVar.e = rawQuery.getString(rawQuery.getColumnIndex("date"));
                        cVar.f = rawQuery.getString(rawQuery.getColumnIndex("body_size"));
                        cVar.h = rawQuery.getString(rawQuery.getColumnIndex("animation_url"));
                        cVar.i = rawQuery.getString(rawQuery.getColumnIndex("video_url"));
                        cVar.g = rawQuery.getString(rawQuery.getColumnIndex("capture_url"));
                        cVar.j = rawQuery.getInt(rawQuery.getColumnIndex("version"));
                        if (cVar.f.equals(GlobalDefine.REAL_VIDEO_BODY_SIZE_CUSTOM)) {
                            str2 = String.format(GlobalDefine.FILE_NAME_FORMAT_ANIMATION, new Object[]{cVar.e});
                            str = String.format(GlobalDefine.FILE_NAME_FORMAT_VIDEO, new Object[]{cVar.e});
                        } else {
                            str2 = String.format(GlobalDefine.FILE_NAME_FORMAT_ANIMATION, new Object[]{cVar.f});
                            str = String.format(GlobalDefine.FILE_NAME_FORMAT_VIDEO, new Object[]{cVar.f});
                        }
                        File GetRealDirectory = GlobalDefine.GetRealDirectory(this.I, cVar.f1466b, cVar.c);
                        File file = new File(GetRealDirectory, str2);
                        File file2 = new File(GetRealDirectory, str);
                        cVar.k.mAnimationFilePath = file.getAbsolutePath();
                        cVar.k.mVideoFilePath = file2.getAbsolutePath();
                        cVar.d = a(cVar.k);
                    }
                    rawQuery.close();
                }
                writableDatabase.close();
            } else {
                Log.e(this.f1459a, "GetRealVideoInnerData() failed, DB is closed.");
            }
        }
        return cVar;
    }

    public synchronized FittingView.RealVideoFileInfo h(int i2) {
        FittingView.RealVideoFileInfo realVideoFileInfo;
        String str;
        String str2;
        realVideoFileInfo = null;
        SQLiteDatabase writableDatabase = this.K != null ? this.K.getWritableDatabase() : null;
        if (writableDatabase != null) {
            if (writableDatabase.isOpen()) {
                Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM real_video WHERE id=" + i2 + ";", (String[]) null);
                if (rawQuery != null) {
                    if (rawQuery.getCount() == 1) {
                        realVideoFileInfo = new FittingView.RealVideoFileInfo();
                        rawQuery.moveToNext();
                        int i3 = rawQuery.getInt(rawQuery.getColumnIndex("gender"));
                        int i4 = rawQuery.getInt(rawQuery.getColumnIndex("age"));
                        String string = rawQuery.getString(rawQuery.getColumnIndex("date"));
                        String string2 = rawQuery.getString(rawQuery.getColumnIndex("body_size"));
                        if (string2.equals(GlobalDefine.REAL_VIDEO_BODY_SIZE_CUSTOM)) {
                            String format = String.format(GlobalDefine.FILE_NAME_FORMAT_ANIMATION, new Object[]{string});
                            str2 = String.format(GlobalDefine.FILE_NAME_FORMAT_VIDEO, new Object[]{string});
                            str = format;
                        } else {
                            str = String.format(GlobalDefine.FILE_NAME_FORMAT_ANIMATION, new Object[]{string2});
                            str2 = String.format(GlobalDefine.FILE_NAME_FORMAT_VIDEO, new Object[]{string2});
                        }
                        File GetRealDirectory = GlobalDefine.GetRealDirectory(this.I, i3, i4);
                        File file = new File(GetRealDirectory, str);
                        File file2 = new File(GetRealDirectory, str2);
                        realVideoFileInfo.mAnimationFilePath = file.getAbsolutePath();
                        realVideoFileInfo.mVideoFilePath = file2.getAbsolutePath();
                    }
                    rawQuery.close();
                }
                writableDatabase.close();
            } else {
                Log.e(this.f1459a, "GetRealVideoFileInfo() failed, DB is closed.");
            }
        }
        return realVideoFileInfo;
    }

    private int a(FittingView.RealVideoFileInfo realVideoFileInfo) {
        if (realVideoFileInfo == null) {
            return -1;
        }
        return (!new File(realVideoFileInfo.mAnimationFilePath).exists() || !new File(realVideoFileInfo.mVideoFilePath).exists()) ? 0 : 1;
    }

    public synchronized boolean a(int i2, int i3, String str, String str2) {
        boolean z2;
        z2 = false;
        SQLiteDatabase readableDatabase = this.K != null ? this.K.getReadableDatabase() : null;
        if (readableDatabase != null) {
            if (readableDatabase.isOpen()) {
                Cursor rawQuery = readableDatabase.rawQuery("SELECT * FROM real_video WHERE gender=" + i2 + " AND " + "age" + "=" + i3 + " AND " + "date" + "='" + str + "' AND " + "body_size" + "='" + str2 + "';", (String[]) null);
                if (rawQuery != null) {
                    if (rawQuery.getCount() > 0) {
                        z2 = true;
                    }
                    rawQuery.close();
                }
                readableDatabase.close();
            } else {
                Log.e(this.f1459a, "GetRealVideoData() failed, DB is closed.");
            }
        }
        return z2;
    }

    public synchronized boolean e(String str) {
        boolean z2;
        z2 = false;
        SQLiteDatabase readableDatabase = this.K != null ? this.K.getReadableDatabase() : null;
        if (readableDatabase != null) {
            if (readableDatabase.isOpen()) {
                Cursor rawQuery = readableDatabase.rawQuery("SELECT id FROM real_video WHERE capture_url='" + str + "';", (String[]) null);
                if (rawQuery != null) {
                    if (rawQuery.getCount() > 0) {
                        z2 = true;
                    }
                    rawQuery.close();
                }
                readableDatabase.close();
            } else {
                Log.e(this.f1459a, "ExistRealVideoData() failed, DB is closed.");
            }
        }
        return z2;
    }

    public boolean i(int i2) {
        c g2 = g(i2);
        if (g2 != null && g2.d == 1) {
            return true;
        }
        String str = this.f1459a;
        Log.e(str, "[ERROR] :: invalid real video data, videoID: " + i2);
        return false;
    }

    /* compiled from: FittingModeDataManager */
    private class b extends SQLiteOpenHelper {

        /* renamed from: b  reason: collision with root package name */
        private final String f1464b = b.class.getSimpleName();
        private final String c = "CREATE TABLE IF NOT EXISTS clothes(id INTEGER PRIMARY KEY, gender INTEGER, age INTEGER, cloth_type INTEGER, base_folder TEXT, cloth_folder TEXT, thumbnail_url TEXT, package_file_url TEXT,base_category_version INTEGER DEFAULT 1);";
        private final String d = "CREATE TABLE IF NOT EXISTS table_category(id INTEGER PRIMARY KEY AUTOINCREMENT, category_id INTEGER DEFAULT (-1),category_name TEXT,category_gender TEXT,category_age TEXT);";
        private final String e = "CREATE TABLE IF NOT EXISTS real_video(id INTEGER PRIMARY KEY AUTOINCREMENT, gender INTEGER, age INTEGER, date TEXT, body_size TEXT, animation_url TEXT, video_url TEXT, capture_url TEXT, version INTEGER);";

        public b(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
            String str2 = this.f1464b;
            Log.d(str2, "DataBaseHelper()+, name : " + str + ", version : " + i);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Log.d(this.f1464b, "onCreate()+");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS table_category(id INTEGER PRIMARY KEY AUTOINCREMENT, category_id INTEGER DEFAULT (-1),category_name TEXT,category_gender TEXT,category_age TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS clothes(id INTEGER PRIMARY KEY, gender INTEGER, age INTEGER, cloth_type INTEGER, base_folder TEXT, cloth_folder TEXT, thumbnail_url TEXT, package_file_url TEXT,base_category_version INTEGER DEFAULT 1);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS real_video(id INTEGER PRIMARY KEY AUTOINCREMENT, gender INTEGER, age INTEGER, date TEXT, body_size TEXT, animation_url TEXT, video_url TEXT, capture_url TEXT, version INTEGER);");
            boolean unused = e.this.J = false;
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            String str = this.f1464b;
            Log.d(str, "onUpgrade()+, oldVersion : " + i + ", newVersion : " + i2);
            while (i < i2) {
                switch (i) {
                    case 1:
                        a(sQLiteDatabase);
                        break;
                    case 2:
                        b(sQLiteDatabase);
                        break;
                    case 3:
                        c(sQLiteDatabase);
                        break;
                    case 4:
                        d(sQLiteDatabase);
                        break;
                }
                i++;
            }
        }

        private synchronized void a(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase != null) {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("table_category", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, String.format("%s %s", new Object[]{"id", "ASC"}));
                if (query != null) {
                    if (query.getCount() > 0 && query.moveToFirst()) {
                        JSONArray jSONArray = new JSONArray();
                        do {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                int i = query.getInt(query.getColumnIndex("category_id"));
                                String string = query.getString(query.getColumnIndex("category_name"));
                                String string2 = query.getString(query.getColumnIndex("category_gender"));
                                String string3 = query.getString(query.getColumnIndex("category_age"));
                                jSONObject.put("category_id", i);
                                jSONObject.put("category_name", string);
                                jSONObject.put("gender", string2);
                                jSONObject.put("age", string3);
                                jSONArray.put(jSONObject);
                                sQLiteDatabase.delete("table_category", String.format("%s = ?", new Object[]{"category_id"}), new String[]{String.valueOf(i)});
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        } while (query.moveToNext());
                        int length = jSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                            int i3 = jSONObject2.getInt("category_id");
                            String string4 = jSONObject2.getString("category_name");
                            String string5 = jSONObject2.getString("gender");
                            String string6 = jSONObject2.getString("age");
                            if (string5.contains(",")) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("category_id", Integer.valueOf(i3));
                                contentValues.put("category_name", string4);
                                contentValues.put("category_gender", GlobalDefine.GENDER_WOMAN_STRING);
                                contentValues.put("category_age", string6);
                                ContentValues contentValues2 = new ContentValues();
                                contentValues2.put("category_id", Integer.valueOf(i3));
                                contentValues2.put("category_name", string4);
                                contentValues2.put("category_gender", GlobalDefine.GENDER_MAN_STRING);
                                contentValues2.put("category_age", string6);
                                sQLiteDatabase.insert("table_category", (String) null, contentValues);
                                sQLiteDatabase.insert("table_category", (String) null, contentValues2);
                            } else if (string5.equals(m.d)) {
                                ContentValues contentValues3 = new ContentValues();
                                contentValues3.put("category_id", Integer.valueOf(i3));
                                contentValues3.put("category_name", string4);
                                contentValues3.put("category_gender", GlobalDefine.GENDER_MAN_STRING);
                                contentValues3.put("category_age", string6);
                                sQLiteDatabase.insert("table_category", (String) null, contentValues3);
                            } else {
                                ContentValues contentValues4 = new ContentValues();
                                contentValues4.put("category_id", Integer.valueOf(i3));
                                contentValues4.put("category_name", string4);
                                contentValues4.put("category_gender", GlobalDefine.GENDER_WOMAN_STRING);
                                contentValues4.put("category_age", string6);
                                sQLiteDatabase.insert("table_category", (String) null, contentValues4);
                            }
                        }
                    }
                    query.close();
                }
            }
        }

        private synchronized void b(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS main.clothes");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS clothes(id INTEGER PRIMARY KEY, gender INTEGER, age INTEGER, cloth_type INTEGER, base_folder TEXT, cloth_folder TEXT, thumbnail_url TEXT, package_file_url TEXT);");
            FXDataManager GetInstance = FXDataManager.GetInstance(e.this.I);
            if (GetInstance != null) {
                String GetTableName = GetInstance.GetTableName(10);
                String GetFXDBPath = GetInstance.GetFXDBPath();
                if (GetTableName == null || GetFXDBPath == null) {
                    Log.e(this.f1464b, "[ERROR] :: UpgradeDBFromVer2ToVer3 - wrong values");
                } else {
                    try {
                        sQLiteDatabase.setTransactionSuccessful();
                        sQLiteDatabase.endTransaction();
                        sQLiteDatabase.execSQL("ATTACH DATABASE '" + GetFXDBPath + "' AS tempDb");
                        sQLiteDatabase.beginTransaction();
                        sQLiteDatabase.execSQL("INSERT INTO main.clothes SELECT * FROM tempDb." + GetTableName);
                        sQLiteDatabase.setTransactionSuccessful();
                        sQLiteDatabase.endTransaction();
                        sQLiteDatabase.execSQL("DETACH tempDb");
                        sQLiteDatabase.beginTransaction();
                        e(sQLiteDatabase);
                        GetInstance.DropTable(10);
                    } catch (Exception e2) {
                        Log.e(this.f1464b, "[ERROR] :: UpgradeDBFromVer2ToVer3");
                        e2.printStackTrace();
                    }
                }
            }
            boolean unused = e.this.J = false;
        }

        private synchronized void c(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE clothes ADD COLUMN base_category_version INTEGER DEFAULT 1");
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                Log.e(this.f1464b, "ERROR :: database is null.");
            }
        }

        private synchronized void d(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS main.real_video");
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS real_video(id INTEGER PRIMARY KEY AUTOINCREMENT, gender INTEGER, age INTEGER, date TEXT, body_size TEXT, animation_url TEXT, video_url TEXT, capture_url TEXT, version INTEGER);");
                    FXDataManager GetInstance = FXDataManager.GetInstance(e.this.I);
                    if (GetInstance != null) {
                        String GetTableName = GetInstance.GetTableName(11);
                        String GetFXDBPath = GetInstance.GetFXDBPath();
                        if (GetTableName == null || GetFXDBPath == null) {
                            Log.e(this.f1464b, "[ERROR] :: UpgradeDBFromVer4ToVer5 - wrong values");
                        } else {
                            sQLiteDatabase.setTransactionSuccessful();
                            sQLiteDatabase.endTransaction();
                            sQLiteDatabase.execSQL("ATTACH DATABASE '" + GetFXDBPath + "' AS tempDb");
                            sQLiteDatabase.beginTransaction();
                            sQLiteDatabase.execSQL("INSERT INTO main.real_video SELECT id, gender, age, date, body_size, animation_url, video_url, capture_url, version FROM tempDb." + GetTableName);
                            sQLiteDatabase.setTransactionSuccessful();
                            sQLiteDatabase.endTransaction();
                            sQLiteDatabase.execSQL("DETACH tempDb");
                            sQLiteDatabase.beginTransaction();
                            GetInstance.DropTable(11);
                        }
                    }
                    if (e.this.J) {
                        sQLiteDatabase.execSQL("CREATE TABLE " + "tmp_clothes" + " AS SELECT * FROM " + "clothes");
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS clothes");
                        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS clothes(id INTEGER PRIMARY KEY, gender INTEGER, age INTEGER, cloth_type INTEGER, base_folder TEXT, cloth_folder TEXT, thumbnail_url TEXT, package_file_url TEXT,base_category_version INTEGER DEFAULT 1);");
                        sQLiteDatabase.execSQL("INSERT INTO clothes SELECT * FROM " + "tmp_clothes");
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "tmp_clothes");
                    }
                } catch (Exception e2) {
                    Log.e(this.f1464b, "[ERROR] :: UpgradeDBFromVer4ToVer5");
                    e2.printStackTrace();
                }
            }
            boolean unused = e.this.J = false;
        }

        private synchronized void e(SQLiteDatabase sQLiteDatabase) {
            String str;
            String str2;
            Log.i(this.f1464b, "UpdateDirectoryPath()+");
            if (sQLiteDatabase != null) {
                if (sQLiteDatabase.isOpen()) {
                    Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM clothes;", (String[]) null);
                    if (rawQuery != null) {
                        if (rawQuery.getCount() > 0) {
                            while (rawQuery.moveToNext()) {
                                int i = rawQuery.getInt(rawQuery.getColumnIndex("gender"));
                                int i2 = rawQuery.getInt(rawQuery.getColumnIndex("age"));
                                int i3 = rawQuery.getInt(rawQuery.getColumnIndex("cloth_type"));
                                String string = rawQuery.getString(rawQuery.getColumnIndex("base_folder"));
                                if (string != null) {
                                    String[] split = new File(GlobalDefine.GetClothTypeBaseDirectory(e.this.I, i, i2, i3), string).getAbsolutePath().split(GlobalDefine.DIRECTORY_NAME_ROOT + File.separator);
                                    str = split[split.length - 1];
                                } else {
                                    str = null;
                                }
                                String string2 = rawQuery.getString(rawQuery.getColumnIndex("cloth_folder"));
                                if (string2 != null) {
                                    String[] split2 = new File(GlobalDefine.GetClothTypeDirectory(e.this.I, i, i2, i3), string2).getAbsolutePath().split(GlobalDefine.DIRECTORY_NAME_ROOT + File.separator);
                                    str2 = split2[split2.length - 1];
                                } else {
                                    str2 = null;
                                }
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("base_folder", str);
                                contentValues.put("cloth_folder", str2);
                                int i4 = rawQuery.getInt(rawQuery.getColumnIndex("id"));
                                String format = String.format("%s = ?", new Object[]{"id"});
                                int update = sQLiteDatabase.update("clothes", contentValues, format, new String[]{String.valueOf(i4)});
                                if (update <= 0) {
                                    Log.e(this.f1464b, "[ERROR] :: clothesId: " + i4 + ", update error = " + update);
                                    sQLiteDatabase.delete("clothes", format, new String[]{String.valueOf(i4)});
                                }
                            }
                        }
                        rawQuery.close();
                    }
                } else {
                    Log.e(this.f1464b, "UpdateDirectoryPath() is fail, DB is closed.");
                }
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\f.java ==========

package net.fxgear.fittingmodenative;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import android.util.TypedValue;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.a.a.a.b;
import net.fxgear.AvatarData;
import net.fxgear.AvatarSetting;
import net.fxgear.GlobalDefine;
import net.fxgear.fittingmodenative.e;
import net.fxgear.fittingview.data.FittingFaceData;
import net.fxgear.util.FXDataManager;
import net.fxgear.util.FXUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NativeGlobal */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static a f1467a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final String f1468b = "f";
    private static final byte[] c = {80, 75};
    private static boolean d = false;

    /* compiled from: NativeGlobal */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1469a = true;

        /* renamed from: b  reason: collision with root package name */
        public String f1470b = null;
        public String c = null;
        public int d = 0;
        public final boolean e = true;
        public final boolean f = false;
        public final boolean g = false;
        public final boolean h = false;
    }

    public static float a(Context context, float f) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
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

    public static long a(File file) {
        if (file == null) {
            return 0;
        }
        if (file.exists()) {
            return a(file.getAbsolutePath());
        }
        if (file.getParentFile() != null) {
            return a(file.getParentFile());
        }
        return 0;
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static void a(String str, String str2, int i) {
        f1467a.f1470b = str;
        f1467a.c = str2;
        f1467a.d = i;
    }

    static boolean b(Context context) {
        if (context != null) {
            return context.getSharedPreferences("preference_fitting_mode", 0).getBoolean("convert_avatar_value", true);
        }
        return false;
    }

    static void a(Context context, boolean z) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("preference_fitting_mode", 0).edit();
            edit.putBoolean("convert_avatar_value", z);
            edit.commit();
        }
    }

    public static boolean c(Context context) {
        if (context != null) {
            return context.getSharedPreferences("preference_fitting_mode", 0).getBoolean("BOOL_IsDetailedBodySizeSettingMenu", false);
        }
        return false;
    }

    public static void b(Context context, boolean z) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("preference_fitting_mode", 0).edit();
            edit.putBoolean("BOOL_IsDetailedBodySizeSettingMenu", z);
            edit.commit();
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        if (context == null) {
            Log.e(f1468b, "[ERROR] :: Invalid param - context.");
        } else if (b(context)) {
            Log.i(f1468b, "Start convert from unity.");
            if (jSONObject == null) {
                Log.e(f1468b, "[ERROR] :: Invalid param - json object.");
            } else if (jSONObject.has("character_info")) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("character_info");
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        a(context, jSONObject2.getInt("gender"), jSONObject2.getInt("age"), jSONObject2.getInt("real_id"));
                    }
                    a(context, false);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e(f1468b, "[WARNING] :: Invalid param - json object key.");
            }
        } else {
            Log.i(f1468b, "Already complete convert from unity.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0074, code lost:
        r0 = a((r0 = r1.getString(r6, (java.lang.String) null)), ",");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.content.Context r16, int r17, int r18, int r19) {
        /*
            r7 = r16
            r8 = r17
            r9 = r18
            r0 = r19
            java.lang.String r1 = "net.fxgear.fitnshop.v2.playerprefs"
            r10 = 0
            android.content.SharedPreferences r1 = r7.getSharedPreferences(r1, r10)
            float r2 = net.fxgear.AvatarSetting.NO_VALUE
            float r3 = net.fxgear.AvatarSetting.NO_VALUE
            float r4 = net.fxgear.AvatarSetting.NO_VALUE
            int r11 = a(r7, r1, r8, r9, r0)
            r12 = 2
            if (r8 != r12) goto L_0x0023
            java.lang.String r5 = "ManSimplySlider"
            java.lang.String r6 = "ManDetailSlider"
            java.lang.String r13 = "ManBodySize"
            goto L_0x0029
        L_0x0023:
            java.lang.String r5 = "WomanSimplySlider"
            java.lang.String r6 = "WomanDetailSlider"
            java.lang.String r13 = "WomanBodySize"
        L_0x0029:
            boolean r14 = r1.contains(r5)
            if (r14 != 0) goto L_0x003e
            boolean r14 = r1.contains(r6)
            if (r14 != 0) goto L_0x003e
            boolean r14 = r1.contains(r13)
            if (r14 != 0) goto L_0x003e
            if (r11 != r0) goto L_0x003e
            return
        L_0x003e:
            boolean r0 = r1.contains(r5)
            r14 = 1
            r15 = 0
            if (r0 == 0) goto L_0x0066
            java.lang.String r0 = r1.getString(r5, r15)
            if (r0 == 0) goto L_0x0066
            java.lang.String r5 = ","
            java.lang.String[] r0 = a((java.lang.String) r0, (java.lang.String) r5)
            if (r0 == 0) goto L_0x0066
            int r5 = r0.length
            r10 = 3
            if (r5 != r10) goto L_0x0066
            r2 = r0[r14]
            float r2 = java.lang.Float.parseFloat(r2)
            r0 = r0[r12]
            float r0 = java.lang.Float.parseFloat(r0)
            r5 = r0
            goto L_0x0067
        L_0x0066:
            r5 = r3
        L_0x0067:
            r3 = r2
            boolean r0 = r1.contains(r6)
            if (r0 == 0) goto L_0x0089
            java.lang.String r0 = r1.getString(r6, r15)
            if (r0 == 0) goto L_0x0089
            java.lang.String r2 = ","
            java.lang.String[] r0 = a((java.lang.String) r0, (java.lang.String) r2)
            if (r0 == 0) goto L_0x0089
            int r2 = r0.length
            r6 = 12
            if (r2 != r6) goto L_0x0089
            r0 = r0[r14]
            float r0 = java.lang.Float.parseFloat(r0)
            r6 = r0
            goto L_0x008a
        L_0x0089:
            r6 = r4
        L_0x008a:
            boolean r0 = r1.contains(r13)
            if (r0 == 0) goto L_0x00b1
            java.lang.String r0 = r1.getString(r13, r15)
            if (r0 == 0) goto L_0x00b1
            java.lang.String r1 = ","
            java.lang.String[] r0 = a((java.lang.String) r0, (java.lang.String) r1)
            int r1 = r0.length
            float[] r1 = new float[r1]
            if (r0 == 0) goto L_0x00b0
            r2 = 0
        L_0x00a2:
            int r4 = r0.length
            if (r2 >= r4) goto L_0x00b0
            r4 = r0[r2]
            float r4 = java.lang.Float.parseFloat(r4)
            r1[r2] = r4
            int r2 = r2 + 1
            goto L_0x00a2
        L_0x00b0:
            r15 = r1
        L_0x00b1:
            r0 = r16
            r1 = r17
            r2 = r18
            r4 = r5
            r5 = r15
            net.fxgear.BodySizeData r0 = net.fxgear.AvatarSetting.GetBodySizeData(r0, r1, r2, r3, r4, r5, r6)
            net.fxgear.fittingmodenative.b r1 = new net.fxgear.fittingmodenative.b
            r1.<init>()
            r1.f1310b = r8
            r1.f1309a = r9
            r1.c = r11
            r2 = 0
            int r3 = net.fxgear.AvatarSetting.GetHairTypeByIndex(r7, r2, r8, r9)
            r1.e = r3
            boolean r3 = net.fxgear.AvatarSetting.IsExistHeadType(r7, r12, r8, r9)
            if (r3 != 0) goto L_0x00d9
            int r12 = net.fxgear.AvatarSetting.GetHeadTypeByIndex(r7, r2, r8, r9)
        L_0x00d9:
            r1.f = r12
            r1.j = r0
            java.io.File r0 = new java.io.File
            java.io.File r2 = net.fxgear.GlobalDefine.GetCharacterDataDirectory(r16)
            java.lang.String r3 = net.fxgear.GlobalDefine.GetCharacterDataFileName(r17, r18)
            r0.<init>(r2, r3)
            r1.a((java.io.File) r0, (int) r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.f.a(android.content.Context, int, int, int):void");
    }

    private static int a(Context context, SharedPreferences sharedPreferences, int i, int i2, int i3) {
        String str = i == 1 ? "DefaultVideoWoman" : "DefaultVideoMan";
        if (!sharedPreferences.contains(str)) {
            return i3;
        }
        String str2 = null;
        String string = sharedPreferences.getString(str, (String) null);
        if (string == null) {
            return i3;
        }
        boolean contains = string.contains(GlobalDefine.UNITY_REAL_VIDEO_QR_DATA_DIRECTORY_NAME);
        String[] a2 = a(string, File.separator);
        if (a2 != null) {
            if (contains) {
                if (a2.length == 4) {
                    str2 = a2[3];
                } else {
                    String str3 = f1468b;
                    Log.w(str3, "File path is invalid : " + string);
                }
            } else if (a2.length == 3) {
                str2 = a2[2];
            } else {
                String str4 = f1468b;
                Log.w(str4, "File path is not invalid : " + string);
            }
            if (str2 == null) {
                return i3;
            }
            String[] split = str2.split("_");
            if (split == null || split.length != 3) {
                String str5 = f1468b;
                Log.w(str5, "File Name format is invalid : " + str2);
                return i3;
            }
            String str6 = split[1];
            Iterator<e.c> it = e.a(context).a(i, 2).iterator();
            while (it.hasNext()) {
                e.c next = it.next();
                if (contains) {
                    if (next.i.contains(str6)) {
                        return next.f1465a;
                    }
                } else if (next.f.equals(str6)) {
                    return next.f1465a;
                }
            }
            return i3;
        }
        String str7 = f1468b;
        Log.w(str7, "Preference value is invalid : " + string);
        return i3;
    }

    public static void d(Context context) {
        if (context != null) {
            File GetCharacterDataDirectory = GlobalDefine.GetCharacterDataDirectory(context);
            if (!GetCharacterDataDirectory.exists() || !GetCharacterDataDirectory.isDirectory()) {
                Log.e(f1468b, "[WARNING] :: Character data directory is not exist.");
                return;
            }
            File[] listFiles = GetCharacterDataDirectory.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (!file.getName().startsWith("CharacterData") || !file.getName().endsWith(GlobalDefine.EXTENSION_DAT)) {
                        Log.w(f1468b, "[WARNING] :: Unknown file - " + file.getName() + FittingFaceData.FILE_EXTENSION_DOT);
                    } else if (b.a(context, file) == 1) {
                        b c2 = b.c(context, file);
                        AvatarData avatarData = FXDataManager.GetInstance(context).GetAvatarDataList(c2.f1310b, c2.f1309a).get(0);
                        avatarData.mGender = c2.f1310b;
                        avatarData.mAge = c2.f1309a;
                        avatarData.mFolderName = GlobalDefine.DEFAULT_FOLDER_NAME;
                        avatarData.mHairType = c2.e;
                        avatarData.mHeadType = c2.f;
                        avatarData.mIsCustomFace = c2.g;
                        avatarData.mAutoNormalizedColor = c2.h;
                        avatarData.mHueRGBColor = c2.i;
                        avatarData.mBodyData = c2.j;
                        File file2 = new File(String.format(GlobalDefine.FORMAT_PATH_DEPTH_1, new Object[]{GlobalDefine.GetAvatarDirectory(context).getAbsoluteFile(), avatarData.mGender == 2 ? "Man" : GlobalDefine.DIRECTORY_NAME_WOMAN}), GlobalDefine.DIRECTORY_NAME_HEAD);
                        File GetAvatarDataDirectory = GlobalDefine.GetAvatarDataDirectory(context, avatarData.mGender, avatarData.mAge, avatarData.mFolderName);
                        if (GetAvatarDataDirectory.exists()) {
                            GlobalDefine.DeleteDirectoryRecursive(GetAvatarDataDirectory.getAbsolutePath());
                        }
                        GetAvatarDataDirectory.mkdirs();
                        if (avatarData.mIsCustomFace) {
                            try {
                                String[] GetCustomFaceFile = FittingFaceData.GetCustomFaceFile(file2.getAbsolutePath());
                                if (GetCustomFaceFile == null || GetCustomFaceFile.length <= 0) {
                                    Log.e(f1468b, "[ERROR] :: Not found custom face files.");
                                    avatarData.mIsCustomFace = false;
                                } else {
                                    for (String str : GetCustomFaceFile) {
                                        if (str != null) {
                                            File file3 = new File(str);
                                            GlobalDefine.CopyFile(file3.getAbsolutePath(), new File(GetAvatarDataDirectory, file3.getName()).getAbsolutePath());
                                        }
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                                avatarData.mIsCustomFace = false;
                            }
                        }
                        FXDataManager.GetInstance(context).UpdateAvatarData(avatarData);
                        c2.d = avatarData.mAvatarID;
                        c2.a(file, 2);
                    } else {
                        Log.d(f1468b, "Character data version is not 1.(" + file.getName() + ")");
                    }
                }
                return;
            }
            Log.e(f1468b, "CharacterData file list is null.");
            return;
        }
        Log.e(f1468b, "[ERROR] :: Invalid param.");
    }

    public static void b(Context context, JSONObject jSONObject) {
        if (context == null) {
            Log.e(f1468b, "[ERROR] :: Invalid param - context.");
        } else if (jSONObject == null) {
            Log.e(f1468b, "[ERROR] :: Invalid param - json object.");
        } else if (jSONObject.has("character_info")) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("character_info");
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    int i2 = jSONObject2.getInt("gender");
                    int i3 = jSONObject2.getInt("age");
                    FXDataManager GetInstance = FXDataManager.GetInstance(context);
                    ArrayList<AvatarData> GetAvatarDataList = GetInstance.GetAvatarDataList(i2, i3);
                    if (GetAvatarDataList != null) {
                        if (!GetAvatarDataList.isEmpty()) {
                            String str = f1468b;
                            Log.i(str, "Already exist avatar data. gender : " + i2 + ", age : " + i3);
                        }
                    }
                    GetInstance.AddAvatarData(a(context, i2, i3));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Log.e(f1468b, "[WARNING] :: Invalid param - json object key.");
        }
    }

    private static AvatarData a(Context context, int i, int i2) {
        AvatarData avatarData = new AvatarData();
        avatarData.mGender = i;
        avatarData.mAge = i2;
        avatarData.mFolderName = GlobalDefine.DEFAULT_FOLDER_NAME;
        avatarData.mHairType = AvatarSetting.GetHairTypeByIndex(context, 0, i, i2);
        int i3 = 2;
        if (!AvatarSetting.IsExistHeadType(context, 2, i, i2)) {
            i3 = AvatarSetting.GetHeadTypeByIndex(context, 0, i, i2);
        }
        avatarData.mHeadType = i3;
        avatarData.mIsCustomFace = false;
        avatarData.mAutoNormalizedColor = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        avatarData.mHueRGBColor = -1;
        avatarData.mBodyData = AvatarSetting.GetBodySizeData(context, i, i2, AvatarSetting.NO_VALUE, AvatarSetting.NO_VALUE, (float[]) null, AvatarSetting.NO_VALUE);
        File GetAvatarDataDirectory = GlobalDefine.GetAvatarDataDirectory(context, avatarData.mGender, avatarData.mAge, avatarData.mFolderName);
        if (GetAvatarDataDirectory.exists()) {
            GlobalDefine.DeleteDirectoryRecursive(GetAvatarDataDirectory.getAbsolutePath());
        }
        GetAvatarDataDirectory.mkdirs();
        return avatarData;
    }

    private static String[] a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            String decode = URLDecoder.decode(str, "UTF-8");
            if (decode != null) {
                return decode.split(str2);
            }
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(long j) {
        String str = "KB";
        long j2 = j / 1024;
        if (j2 >= 1024) {
            str = "MB";
            j2 /= 1024;
        }
        if (j2 == 0) {
            j2 = 1;
        }
        return Long.toString(j2) + str;
    }

    public static File a(Context context, String str) {
        String str2;
        if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            str2 = e(context);
        } else {
            str2 = context.getCacheDir().getPath();
        }
        return new File(str2, "FXCache");
    }

    private static String e(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            return externalCacheDir.getAbsolutePath();
        }
        return Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/cache/");
    }

    public static String b(Context context, String str) {
        if (str != null) {
            try {
                StringBuilder sb = new StringBuilder(32);
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(str.getBytes());
                byte[] digest = instance.digest();
                for (int i = 0; i < 16; i++) {
                    sb.append(String.format("%02X", new Object[]{Byte.valueOf(digest[i])}));
                }
                String sb2 = sb.toString();
                String substring = sb2.substring(0, 2);
                File a2 = a(context, "FXCache");
                return (a2.getAbsolutePath() + File.separator + substring) + File.separator + sb2;
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static long a(File file, File file2) {
        if (!(file == null || file2 == null)) {
            try {
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                b bVar = new b(file);
                if (bVar.b()) {
                    return -1;
                }
                List a2 = bVar.a();
                int size = a2.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    j += ((net.a.a.e.f) a2.get(i)).e();
                }
                long GetAvailableSpaceSize = FXUtil.GetAvailableSpaceSize(file2);
                if (GetAvailableSpaceSize < j) {
                    Log.e(f1468b, "ERROR :: insufficient storage.");
                    FXUtil.DeleteDirectoryRecursive(file2);
                    return j - GetAvailableSpaceSize;
                }
                bVar.a(file2.getAbsolutePath());
            } catch (net.a.a.c.a e) {
                e.printStackTrace();
                return -1;
            }
        }
        return 0;
    }

    public static long b(File file) {
        long j = 0;
        if (file == null || !file.exists()) {
            return 0;
        }
        try {
            b bVar = new b(file);
            if (bVar.b()) {
                bVar.b("12345678");
            }
            List a2 = bVar.a();
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                j += ((net.a.a.e.f) a2.get(i)).e();
            }
            return j;
        } catch (net.a.a.c.a e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static ArrayList<String> c(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            b bVar = new b(file);
            if (bVar.b()) {
                bVar.b("12345678");
            }
            List a2 = bVar.a();
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(((net.a.a.e.f) a2.get(i)).j());
            }
            return arrayList;
        } catch (net.a.a.c.a e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        r2 = r2.getName().substring((r0 = r2.getName().lastIndexOf(46)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean d(java.io.File r2) {
        /*
            if (r2 == 0) goto L_0x0032
            boolean r0 = r2.exists()
            if (r0 == 0) goto L_0x0032
            java.lang.String r0 = r2.getName()
            r1 = 46
            int r0 = r0.lastIndexOf(r1)
            if (r0 <= 0) goto L_0x0032
            java.lang.String r2 = r2.getName()
            java.lang.String r2 = r2.substring(r0)
            if (r2 == 0) goto L_0x0032
            int r0 = r2.length()
            if (r0 <= 0) goto L_0x0032
            java.lang.String r2 = r2.toLowerCase()
            java.lang.String r0 = ".zip"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0032
            r2 = 1
            return r2
        L_0x0032:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.f.d(java.io.File):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0045 A[SYNTHETIC, Splitter:B:30:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x004f A[SYNTHETIC, Splitter:B:36:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x005a A[SYNTHETIC, Splitter:B:41:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x0040=Splitter:B:27:0x0040, B:33:0x004a=Splitter:B:33:0x004a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean e(java.io.File r5) {
        /*
            if (r5 == 0) goto L_0x0063
            boolean r0 = r5.exists()
            if (r0 == 0) goto L_0x0063
            boolean r0 = r5.isFile()
            if (r0 == 0) goto L_0x0063
            long r0 = r5.length()
            r2 = 2
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0063
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x0049, IOException -> 0x003f }
            java.lang.String r2 = "rw"
            r1.<init>(r5, r2)     // Catch:{ FileNotFoundException -> 0x0049, IOException -> 0x003f }
            r2 = 0
            r1.seek(r2)     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x0037, all -> 0x0034 }
            byte[] r5 = c     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x0037, all -> 0x0034 }
            r1.write(r5)     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x0037, all -> 0x0034 }
            r5 = 1
            r1.close()     // Catch:{ IOException -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0033:
            return r5
        L_0x0034:
            r5 = move-exception
            r0 = r1
            goto L_0x0058
        L_0x0037:
            r5 = move-exception
            r0 = r1
            goto L_0x0040
        L_0x003a:
            r5 = move-exception
            r0 = r1
            goto L_0x004a
        L_0x003d:
            r5 = move-exception
            goto L_0x0058
        L_0x003f:
            r5 = move-exception
        L_0x0040:
            r5.printStackTrace()     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x0063
            r0.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0063
        L_0x0049:
            r5 = move-exception
        L_0x004a:
            r5.printStackTrace()     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x0063
            r0.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0063
        L_0x0053:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x0063
        L_0x0058:
            if (r0 == 0) goto L_0x0062
            r0.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0062:
            throw r5
        L_0x0063:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.f.e(java.io.File):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0050 A[SYNTHETIC, Splitter:B:32:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005a A[SYNTHETIC, Splitter:B:38:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0060 A[SYNTHETIC, Splitter:B:41:0x0060] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:35:0x0055=Splitter:B:35:0x0055, B:29:0x004b=Splitter:B:29:0x004b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte f(java.io.File r6) {
        /*
            r0 = 0
            if (r6 == 0) goto L_0x0069
            boolean r1 = r6.exists()
            if (r1 == 0) goto L_0x0069
            boolean r1 = r6.isFile()
            if (r1 == 0) goto L_0x0069
            long r1 = r6.length()
            r3 = 2
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0069
            r1 = 0
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x004a }
            java.lang.String r3 = "rw"
            r2.<init>(r6, r3)     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x004a }
            r6 = 2
            byte[] r6 = new byte[r6]     // Catch:{ FileNotFoundException -> 0x0045, IOException -> 0x0042, all -> 0x003f }
            r3 = 0
            r2.seek(r3)     // Catch:{ FileNotFoundException -> 0x0045, IOException -> 0x0042, all -> 0x003f }
            r2.read(r6)     // Catch:{ FileNotFoundException -> 0x0045, IOException -> 0x0042, all -> 0x003f }
            byte r1 = r6[r0]     // Catch:{ FileNotFoundException -> 0x0045, IOException -> 0x0042, all -> 0x003f }
            r3 = 70
            if (r1 != r3) goto L_0x0036
            r1 = 1
            byte r6 = r6[r1]     // Catch:{ FileNotFoundException -> 0x0045, IOException -> 0x0042, all -> 0x003f }
            r0 = r6
        L_0x0036:
            r2.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x0069
        L_0x003a:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x0069
        L_0x003f:
            r6 = move-exception
            r1 = r2
            goto L_0x005e
        L_0x0042:
            r6 = move-exception
            r1 = r2
            goto L_0x004b
        L_0x0045:
            r6 = move-exception
            r1 = r2
            goto L_0x0055
        L_0x0048:
            r6 = move-exception
            goto L_0x005e
        L_0x004a:
            r6 = move-exception
        L_0x004b:
            r6.printStackTrace()     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x0069
            r1.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x0069
        L_0x0054:
            r6 = move-exception
        L_0x0055:
            r6.printStackTrace()     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x0069
            r1.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x0069
        L_0x005e:
            if (r1 == 0) goto L_0x0068
            r1.close()     // Catch:{ IOException -> 0x0064 }
            goto L_0x0068
        L_0x0064:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0068:
            throw r6
        L_0x0069:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.f.f(java.io.File):byte");
    }

    public static void a(boolean z) {
        d = z;
    }

    public static boolean a() {
        return d;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\FittingActivity.java ==========

package net.fxgear.fittingmodenative;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import net.fxgear.AvatarSetting;
import net.fxgear.BodySizeData;
import net.fxgear.ClothesSizeProvider;
import net.fxgear.FittingView;
import net.fxgear.GlobalDefine;
import net.fxgear.a.a;
import net.fxgear.customface.DetectCustomFacePoints;
import net.fxgear.fitnshop.d.m;
import net.fxgear.fittingmodenative.a.a;
import net.fxgear.fittingmodenative.a.b;
import net.fxgear.fittingmodenative.b.b;
import net.fxgear.fittingmodenative.b.e;
import net.fxgear.fittingmodenative.c.a;
import net.fxgear.fittingmodenative.c.b;
import net.fxgear.fittingmodenative.c.c;
import net.fxgear.fittingmodenative.c.d;
import net.fxgear.fittingmodenative.c.e;
import net.fxgear.fittingmodenative.c.f;
import net.fxgear.fittingmodenative.c.g;
import net.fxgear.fittingmodenative.c.h;
import net.fxgear.fittingmodenative.customface.AvatarFaceSettingActivity;
import net.fxgear.fittingmodenative.d;
import net.fxgear.fittingmodenative.d.e;
import net.fxgear.fittingmodenative.d.j;
import net.fxgear.fittingmodenative.e;
import net.fxgear.fittingview.FittingSurfaceView;
import net.fxgear.util.FXDataManager;
import net.fxgear.util.FXUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"InflateParams"})
public abstract class FittingActivity extends a implements View.OnClickListener, a.C0042a, b.c, c.d, d.C0046d, e.g, f.a, g.a, d.a {
    public static final int AVATAR_SETTING_VIEW_TAPE_ADD_AVATAR = 1;
    public static final int AVATAR_SETTING_VIEW_TAPE_CLOTHES_SIZE = 2;
    public static final int AVATAR_SETTING_VIEW_TYPE_DEFAULT = 0;
    private static final int DELAY_OFFLINE_TEXT_OFF = 3000;
    private static final int DELAY_TIME_FPS = 1000;
    private static final int HANDLER_ARG_OFFLINE_MODE_VIEW_OFF = 0;
    private static final int HANDLER_ARG_OFFLINE_MODE_VIEW_ON = 1;
    private static final int MSG_CREATE_CUSTOM_FILE = 96;
    private static final int MSG_OFFLINE_MODE_RENEW = 97;
    private static final int MSG_PROCESS_GET_SCREENSHOT = 94;
    private static final int MSG_PUT_ON_CLOTH = 99;
    private static final int MSG_SET_CHARACTER = 95;
    private static final int MSG_UPDATE_FPS = 98;
    private static final String SCREENSHOT_KEY_IS_CURRENT_POSE = "SCREENSHOT_KEY_IS_CURRENT_POSE";
    private static final String SCREENSHOT_KEY_WITH_BG = "SCREENSHOT_KEY_WITH_BG";
    private static final String SCREENSHOT_KEY_WITH_CLOTHES = "SCREENSHOT_KEY_WITH_CLOTHES";
    public static final int SELECTED_ITEM_TYPE_AVATAR = 10;
    public static final int SELECTED_ITEM_TYPE_REAL_VIDEO = 11;
    /* access modifiers changed from: private */
    public static final String TAG = "FittingActivity";
    private static int mBackgroundImageIndex;
    private static int sFittingRoomMode;
    private final int GRANT_PERMISSION_CAMERA = 0;
    private final int GRANT_PERMISSION_CAMERA_AND_CALL_CAMERA = 1;
    private final int GRANT_PERMISSION_CAMERA_AND_CALL_CAMERA_BY_GALLERY = 2;
    private final int SELECT_CHARACTER_BOY_INDEX = 3;
    private final int SELECT_CHARACTER_GIRL_INDEX = 2;
    private final int SELECT_CHARACTER_MAN_INDEX = 1;
    private final int SELECT_CHARACTER_WOMAN_INDEX = 0;
    /* access modifiers changed from: private */
    public d mActionBar;
    private RelativeLayout mActionBarContainer;
    /* access modifiers changed from: private */
    public RelativeLayout mActivityRootView;
    /* access modifiers changed from: private */
    public int mAvatarSettingViewType = 0;
    private int[] mBackgroundImageResArray = {a.d.fitting_room_bg, a.d.fitting_room_bg_1, a.d.fitting_room_bg_2, a.d.fitting_room_bg_3, a.d.fitting_room_bg_4, a.d.fitting_room_bg_5};
    /* access modifiers changed from: private */
    public RelativeLayout mBottomContainer;
    private LinearLayout mCheckingClothesLayout;
    /* access modifiers changed from: private */
    public net.fxgear.fittingmodenative.b.a mCircleDialog;
    /* access modifiers changed from: private */
    public e.a mClothDataTask;
    /* access modifiers changed from: private */
    public net.fxgear.fittingmodenative.b.b mConfirmDialog;
    /* access modifiers changed from: private */
    public int mCurrentViewType;
    /* access modifiers changed from: private */
    public Thread mCustomFaceWorker = null;
    /* access modifiers changed from: private */
    public e.c mDownloadClothDataTask;
    /* access modifiers changed from: private */
    public File mFaceBitmapFile = null;
    /* access modifiers changed from: private */
    public Button mFirstROptionButton;
    private RadioButton mFirstRadioButton;
    /* access modifiers changed from: private */
    public ArrayList<c> mFittingDataList;
    private LinearLayout mFittingRoomLayout;
    /* access modifiers changed from: private */
    public FittingView mFittingView;
    private RelativeLayout mFittingViewContainer;
    /* access modifiers changed from: private */
    public d mHandler = new d(this);
    private net.fxgear.fittingmodenative.a.b mImageCache;
    private boolean mIsShowingAllFittingTools;
    private Button mLeftOptionButton;
    /* access modifiers changed from: private */
    public h mMainClothesAndCategoryListView;
    private boolean mNeedDisplayFPS = false;
    /* access modifiers changed from: private */
    public LinearLayout mNoticeToTakeFacePictureLayout;
    /* access modifiers changed from: private */
    public RelativeLayout mOfflineModeContainer;
    /* access modifiers changed from: private */
    public f mRequestInfoForCustomFace;
    private Button mSecondROptionButton;
    private RadioButton mSecondRadioButton;
    /* access modifiers changed from: private */
    public boolean mSetCustomFaceWithSkinValue = false;
    private Button mTakeOffAllClothesButton;
    private TextView mTextFPS;
    private Button mThirdROptionButton;
    private RadioButton mThirdRadioButton;

    public interface e {
        void a();

        void a(int i, Object obj);
    }

    public abstract String GetCategoryList();

    public abstract int GetDefaultAvatarID(int i, int i2);

    public abstract int GetDefaultMirrorVideoID(int i, int i2);

    public abstract boolean GetFPSMode();

    /* access modifiers changed from: protected */
    public int GetFittingDataListIndexForCharacter(int i, int i2) {
        return ((i - 1) * 3) + (i2 - 1);
    }

    public abstract void OnBuyClothes(String str);

    public abstract String OnEnterToFitRoom(String str);

    public abstract ArrayList<String> OnRemoveClothes(String str);

    public abstract void OnShowAvatarFaceCameraView(boolean z);

    public abstract void OnShowItemList(int i, String str);

    public abstract void OnShowProductList(String str, String str2);

    private class f {

        /* renamed from: a  reason: collision with root package name */
        int f1285a;

        /* renamed from: b  reason: collision with root package name */
        String f1286b;
        boolean c;

        private f() {
            this.f1285a = 1;
            this.f1286b = null;
            this.c = false;
        }

        /* synthetic */ f(FittingActivity fittingActivity, AnonymousClass1 r2) {
            this();
        }
    }

    public class a {

        /* renamed from: a  reason: collision with root package name */
        int f1278a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f1279b = 0;

        public a() {
        }
    }

    /* access modifiers changed from: protected */
    public void InitializeFittingDataList() {
        if (this.mFittingDataList != null) {
            this.mFittingDataList.clear();
            this.mFittingDataList = null;
        }
        this.mFittingDataList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            this.mFittingDataList.add((Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public void SetFittingDataInfo(c cVar, int i, int i2) {
        int GetFittingDataListIndexForCharacter;
        if (this.mFittingDataList == null) {
            InitializeFittingDataList();
        }
        if (cVar != null && (GetFittingDataListIndexForCharacter = GetFittingDataListIndexForCharacter(i, i2)) >= 0) {
            this.mFittingDataList.set(GetFittingDataListIndexForCharacter, cVar);
        }
    }

    /* access modifiers changed from: protected */
    public c GetFittingData(int i, int i2) {
        int GetFittingDataListIndexForCharacter;
        if (this.mFittingDataList == null || (GetFittingDataListIndexForCharacter = GetFittingDataListIndexForCharacter(i, i2)) < 0) {
            return null;
        }
        return this.mFittingDataList.get(GetFittingDataListIndexForCharacter);
    }

    /* access modifiers changed from: private */
    public void ProcessGetScreenShot(boolean z, boolean z2, boolean z3, Runnable runnable) {
        if (IsWorkingFittingView()) {
            Message message = new Message();
            message.what = MSG_PROCESS_GET_SCREENSHOT;
            message.obj = runnable;
            Bundle bundle = new Bundle();
            bundle.putBoolean(SCREENSHOT_KEY_WITH_CLOTHES, false);
            bundle.putBoolean(SCREENSHOT_KEY_IS_CURRENT_POSE, false);
            bundle.putBoolean(SCREENSHOT_KEY_WITH_BG, false);
            message.setData(bundle);
            this.mHandler.sendMessage(message);
            return;
        }
        GetScreenShot(z, z2, z3, runnable);
    }

    private static final class d extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<FittingActivity> f1284a;

        public d(FittingActivity fittingActivity) {
            this.f1284a = new WeakReference<>(fittingActivity);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: boolean} */
        /* JADX WARNING: type inference failed for: r3v0 */
        /* JADX WARNING: type inference failed for: r3v3, types: [int] */
        /* JADX WARNING: type inference failed for: r3v9 */
        /* JADX WARNING: type inference failed for: r3v10 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r9) {
            /*
                r8 = this;
                java.lang.ref.WeakReference<net.fxgear.fittingmodenative.FittingActivity> r0 = r8.f1284a
                java.lang.Object r0 = r0.get()
                r1 = r0
                net.fxgear.fittingmodenative.FittingActivity r1 = (net.fxgear.fittingmodenative.FittingActivity) r1
                if (r1 == 0) goto L_0x01c4
                int r0 = r9.what
                r2 = 97
                r3 = 0
                if (r0 != r2) goto L_0x003f
                int r9 = r9.arg1
                if (r9 != 0) goto L_0x0027
                android.widget.RelativeLayout r9 = r1.mOfflineModeContainer
                if (r9 == 0) goto L_0x01c4
                android.widget.RelativeLayout r9 = r1.mOfflineModeContainer
                r0 = 8
                r9.setVisibility(r0)
                goto L_0x01c4
            L_0x0027:
                android.widget.RelativeLayout r9 = r1.mOfflineModeContainer
                if (r9 == 0) goto L_0x01c4
                android.widget.RelativeLayout r9 = r1.mOfflineModeContainer
                r9.setVisibility(r3)
                android.os.Message r9 = r8.obtainMessage(r2, r3, r3)
                r0 = 3000(0xbb8, double:1.482E-320)
                r8.sendMessageDelayed(r9, r0)
                goto L_0x01c4
            L_0x003f:
                int r0 = r9.what
                r2 = 98
                if (r0 != r2) goto L_0x0055
                net.fxgear.FittingView r9 = r1.mFittingView
                if (r9 == 0) goto L_0x01c4
                r1.UpdateFPS()
                r0 = 1000(0x3e8, double:4.94E-321)
                r8.sendEmptyMessageDelayed(r2, r0)
                goto L_0x01c4
            L_0x0055:
                int r0 = r9.what
                r2 = 99
                r4 = 0
                if (r0 != r2) goto L_0x00b6
                java.lang.Object r0 = r9.obj
                if (r0 == 0) goto L_0x01c4
                java.lang.Object r0 = r9.obj
                boolean r0 = r0 instanceof net.fxgear.fittingmodenative.c.e.a
                if (r0 == 0) goto L_0x01c4
                boolean r0 = r1.IsWorkingFittingView()
                if (r0 == 0) goto L_0x0077
                java.lang.Object r9 = r9.obj
                android.os.Message r9 = r8.obtainMessage(r2, r9)
                r9.sendToTarget()
                goto L_0x01c4
            L_0x0077:
                net.fxgear.FittingView r0 = r1.mFittingView
                if (r0 == 0) goto L_0x01c4
                java.lang.Object r9 = r9.obj
                net.fxgear.fittingmodenative.c.e$a r9 = (net.fxgear.fittingmodenative.c.e.a) r9
                net.fxgear.fittingmodenative.e$a r0 = r9.i
                int r0 = r0.e
                r2 = 1
                if (r0 == r2) goto L_0x008d
                r1.DownloadClothesData(r9)
                goto L_0x01c4
            L_0x008d:
                int r0 = r1.GetCurrentGender()
                int r2 = r1.GetCurrentAge()
                int[] r0 = r1.GetFittingClotehsArray(r0, r2)
                if (r0 == 0) goto L_0x00a5
                net.fxgear.fittingmodenative.e$a r2 = r9.i
                int r2 = r2.d
                net.fxgear.fittingmodenative.e$a r3 = r9.i
                int r3 = r3.f1461a
                r0[r2] = r3
            L_0x00a5:
                net.fxgear.fittingmodenative.e r0 = net.fxgear.fittingmodenative.e.a((android.content.Context) r1)
                net.fxgear.fittingmodenative.e$a r9 = r9.i
                int r9 = r9.f1461a
                net.fxgear.FittingView$ClothesFileInfo r9 = r0.e((int) r9)
                r1.SetClothes((net.fxgear.FittingView.ClothesFileInfo) r9, (java.lang.Runnable) r4)
                goto L_0x01c4
            L_0x00b6:
                int r0 = r9.what
                r2 = 96
                if (r0 != r2) goto L_0x0124
                boolean r0 = r1.IsWorkingFittingView()
                if (r0 == 0) goto L_0x00cd
                java.lang.Object r9 = r9.obj
                android.os.Message r9 = r8.obtainMessage(r2, r9)
                r9.sendToTarget()
                goto L_0x01c4
            L_0x00cd:
                net.fxgear.FittingView r0 = r1.mFittingView
                if (r0 == 0) goto L_0x01c4
                java.lang.Object r9 = r9.obj
                net.fxgear.fittingmodenative.FittingActivity$b r9 = (net.fxgear.fittingmodenative.FittingActivity.b) r9
                if (r9 == 0) goto L_0x0119
                java.io.File r0 = r1.mFaceBitmapFile
                if (r0 == 0) goto L_0x0103
                int[] r0 = r9.f1280a
                if (r0 == 0) goto L_0x0103
                java.io.File r0 = r1.mFaceBitmapFile
                int[] r2 = r9.f1280a
                boolean r0 = r1.CreateCustomFaceData(r0, r2, r4)
                if (r0 != 0) goto L_0x01c4
                java.lang.String r0 = net.fxgear.fittingmodenative.FittingActivity.TAG
                java.lang.String r1 = "[ERROR] :: mHandler - MSG_CREATE_CUSTOM_FILE, failed to CreateCustomFaceData"
                android.util.Log.e(r0, r1)
                net.fxgear.fittingmodenative.FittingActivity$e r0 = r9.f1281b
                if (r0 == 0) goto L_0x01c4
                net.fxgear.fittingmodenative.FittingActivity$e r9 = r9.f1281b
                r9.a(r3, r4)
                goto L_0x01c4
            L_0x0103:
                java.lang.String r0 = net.fxgear.fittingmodenative.FittingActivity.TAG
                java.lang.String r1 = "[ERROR] :: mHandler - MSG_CREATE_CUSTOM_FILE, wrong data for CreateCustomFaceData"
                android.util.Log.e(r0, r1)
                net.fxgear.fittingmodenative.FittingActivity$e r0 = r9.f1281b
                if (r0 == 0) goto L_0x01c4
                net.fxgear.fittingmodenative.FittingActivity$e r9 = r9.f1281b
                r0 = 16
                r9.a(r0, r4)
                goto L_0x01c4
            L_0x0119:
                java.lang.String r9 = net.fxgear.fittingmodenative.FittingActivity.TAG
                java.lang.String r0 = "ERROR :: Illegal state"
                android.util.Log.e(r9, r0)
                goto L_0x01c4
            L_0x0124:
                int r0 = r9.what
                r2 = 95
                if (r0 != r2) goto L_0x019c
                boolean r0 = r1.IsWorkingFittingView()
                if (r0 == 0) goto L_0x013f
                int r0 = r9.arg1
                int r1 = r9.arg2
                java.lang.Object r9 = r9.obj
                android.os.Message r9 = r8.obtainMessage(r2, r0, r1, r9)
                r9.sendToTarget()
                goto L_0x01c4
            L_0x013f:
                net.fxgear.FittingView r0 = r1.mFittingView
                if (r0 == 0) goto L_0x01c4
                int r2 = r9.arg1
                int r0 = r9.arg2
                java.lang.Object r9 = r9.obj
                r7 = r9
                java.lang.Runnable r7 = (java.lang.Runnable) r7
                net.fxgear.fittingmodenative.FittingActivity$c r9 = r1.GetFittingData(r2, r0)
                net.fxgear.fittingmodenative.b r4 = r9.f
                net.fxgear.AvatarData r4 = r4.k
                boolean r4 = r4.mIsCustomFace
                if (r4 == 0) goto L_0x0167
                boolean r4 = r1.HasCustomFaceData(r2, r0)
                if (r4 == 0) goto L_0x0161
                goto L_0x0167
            L_0x0161:
                net.fxgear.fittingmodenative.b r4 = r9.f
                net.fxgear.AvatarData r4 = r4.k
                r4.mIsCustomFace = r3
            L_0x0167:
                r4 = 5
                net.fxgear.FittingView$ClothesFileInfo[] r6 = new net.fxgear.FittingView.ClothesFileInfo[r4]
            L_0x016a:
                int[] r4 = r9.d
                int r4 = r4.length
                if (r3 >= r4) goto L_0x018d
                int[] r4 = r9.d
                r4 = r4[r3]
                r5 = -1
                if (r4 != r5) goto L_0x0180
                net.fxgear.FittingView$ClothesFileInfo r4 = new net.fxgear.FittingView$ClothesFileInfo
                r4.<init>()
                r4.mClothType = r3
                r6[r3] = r4
                goto L_0x018a
            L_0x0180:
                net.fxgear.fittingmodenative.e r5 = net.fxgear.fittingmodenative.e.a((android.content.Context) r1)
                net.fxgear.FittingView$ClothesFileInfo r4 = r5.e((int) r4)
                r6[r3] = r4
            L_0x018a:
                int r3 = r3 + 1
                goto L_0x016a
            L_0x018d:
                net.fxgear.fittingmodenative.b r3 = r9.f
                int r4 = r3.c
                net.fxgear.fittingmodenative.b r9 = r9.f
                net.fxgear.AvatarData r9 = r9.k
                int r5 = r9.mAvatarID
                r3 = r0
                r1.SetCharacter(r2, r3, r4, r5, r6, r7)
                goto L_0x01c4
            L_0x019c:
                int r0 = r9.what
                r2 = 94
                if (r0 != r2) goto L_0x01c4
                android.os.Bundle r0 = r9.getData()
                if (r0 == 0) goto L_0x01bb
                java.lang.String r2 = "SCREENSHOT_KEY_WITH_CLOTHES"
                boolean r3 = r0.getBoolean(r2)
                java.lang.String r2 = "SCREENSHOT_KEY_IS_CURRENT_POSE"
                boolean r2 = r0.getBoolean(r2)
                java.lang.String r4 = "SCREENSHOT_KEY_WITH_BG"
                boolean r0 = r0.getBoolean(r4)
                goto L_0x01bd
            L_0x01bb:
                r0 = 0
                r2 = 0
            L_0x01bd:
                java.lang.Object r9 = r9.obj
                java.lang.Runnable r9 = (java.lang.Runnable) r9
                r1.ProcessGetScreenShot(r3, r2, r0, r9)
            L_0x01c4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.FittingActivity.d.handleMessage(android.os.Message):void");
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        int i;
        String str;
        JSONException e2;
        JSONArray jSONArray;
        super.onCreate(bundle);
        Log.d(TAG, "onCreate()+");
        int[] iArr = null;
        this.mActivityRootView = (RelativeLayout) LayoutInflater.from(this).inflate(a.f.activity_main_fitting_activity, (ViewGroup) null);
        setContentView(this.mActivityRootView);
        int i2 = -1;
        int i3 = 2;
        try {
            JSONObject jSONObject = new JSONObject(OnEnterToFitRoom(sFittingRoomMode == 0 ? "real" : "avatar"));
            String string = jSONObject.getString("sex");
            String string2 = jSONObject.getString("age");
            i = (string == null || !string.equals(GlobalDefine.GENDER_MAN_STRING)) ? 1 : 2;
            if (string2 != null) {
                try {
                    if (string2.equals(GlobalDefine.AGE_EARLY_STRING)) {
                        i3 = 1;
                    }
                } catch (JSONException e3) {
                    e2 = e3;
                    str = null;
                    FXUtil.OccurRunTimeException("ERROR :: fittingJSONData is wrong.");
                    e2.printStackTrace();
                    InitializeActivity(sFittingRoomMode, i, i3, GetFittingData(i, i3).f);
                    RequestWishList(iArr, i2, str);
                    this.mNeedDisplayFPS = GetFPSMode();
                }
            }
            str = jSONObject.getString("mode");
            if (str != null) {
                try {
                    if (str.equals("fitting") && (jSONArray = jSONObject.getJSONArray("fitting")) != null && jSONArray.length() > 0) {
                        i2 = jSONArray.getJSONObject(0).getInt("uuid");
                    }
                } catch (JSONException e4) {
                    e2 = e4;
                    FXUtil.OccurRunTimeException("ERROR :: fittingJSONData is wrong.");
                    e2.printStackTrace();
                    InitializeActivity(sFittingRoomMode, i, i3, GetFittingData(i, i3).f);
                    RequestWishList(iArr, i2, str);
                    this.mNeedDisplayFPS = GetFPSMode();
                }
            }
            f.f1467a.getClass();
            int[] GenerateFittingModeData = GenerateFittingModeData(GetCategoryList(), jSONObject.getJSONArray("wishlist"));
            try {
                if (this.mFittingDataList == null || this.mFittingDataList.size() == 0) {
                    FXUtil.OccurRunTimeException("ERROR :: IllegalState - data is wrong.");
                }
                iArr = GenerateFittingModeData;
            } catch (JSONException e5) {
                int[] iArr2 = GenerateFittingModeData;
                e2 = e5;
                iArr = iArr2;
                FXUtil.OccurRunTimeException("ERROR :: fittingJSONData is wrong.");
                e2.printStackTrace();
                InitializeActivity(sFittingRoomMode, i, i3, GetFittingData(i, i3).f);
                RequestWishList(iArr, i2, str);
                this.mNeedDisplayFPS = GetFPSMode();
            }
        } catch (JSONException e6) {
            e2 = e6;
            str = null;
            i = 1;
            FXUtil.OccurRunTimeException("ERROR :: fittingJSONData is wrong.");
            e2.printStackTrace();
            InitializeActivity(sFittingRoomMode, i, i3, GetFittingData(i, i3).f);
            RequestWishList(iArr, i2, str);
            this.mNeedDisplayFPS = GetFPSMode();
        }
        InitializeActivity(sFittingRoomMode, i, i3, GetFittingData(i, i3).f);
        RequestWishList(iArr, i2, str);
        this.mNeedDisplayFPS = GetFPSMode();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        Log.d(TAG, "onStop()+");
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Log.d(TAG, "onDestory()+");
        if (this.mCustomFaceWorker != null) {
            this.mCustomFaceWorker.interrupt();
            this.mCustomFaceWorker = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages((Object) null);
            this.mHandler = null;
        }
        if (this.mCircleDialog != null) {
            if (this.mCircleDialog.isShowing()) {
                this.mCircleDialog.dismiss();
            }
            this.mCircleDialog = null;
        }
        if (this.mConfirmDialog != null) {
            if (this.mConfirmDialog.isShowing()) {
                this.mConfirmDialog.dismiss();
            }
            this.mConfirmDialog = null;
        }
        if (this.mDownloadClothDataTask != null) {
            this.mDownloadClothDataTask.b();
            this.mDownloadClothDataTask = null;
        }
        if (this.mClothDataTask != null) {
            this.mClothDataTask.a();
            this.mClothDataTask = null;
        }
        if (this.mFittingViewContainer != null) {
            this.mFittingViewContainer.removeAllViews();
        }
        this.mFittingView = null;
        if (this.mActionBarContainer != null) {
            this.mActionBarContainer.removeAllViews();
            this.mActionBarContainer = null;
        }
        if (this.mBottomContainer != null) {
            this.mBottomContainer.removeAllViews();
            this.mBottomContainer = null;
        }
        if (this.mActivityRootView != null) {
            this.mActivityRootView.removeAllViews();
            this.mActivityRootView = null;
        }
        if (this.mFaceBitmapFile != null) {
            if (this.mFaceBitmapFile.exists()) {
                this.mFaceBitmapFile.delete();
            }
            this.mFaceBitmapFile = null;
        }
        if (this.mImageCache != null) {
            this.mImageCache.b();
            this.mImageCache = null;
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r7, int r8, android.content.Intent r9) {
        /*
            r6 = this;
            java.lang.String r0 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onActivityResult()+, requestCode: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = ", resultCode: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
            r0 = 3
            r1 = -1
            if (r8 == r1) goto L_0x0031
            java.lang.String r8 = TAG
            java.lang.String r9 = "resultCode != RESULT_OK"
            android.util.Log.e(r8, r9)
            if (r7 != r0) goto L_0x0030
            net.fxgear.fittingmodenative.f$a r7 = net.fxgear.fittingmodenative.f.f1467a
            r7.getClass()
        L_0x0030:
            return
        L_0x0031:
            if (r7 == r0) goto L_0x0035
            goto L_0x00b4
        L_0x0035:
            r0 = 0
            if (r9 == 0) goto L_0x004a
            net.fxgear.fittingmodenative.f$a r1 = net.fxgear.fittingmodenative.f.f1467a
            r1.getClass()
            java.lang.String r1 = "detecting_face_file_path"
            java.lang.String r1 = r9.getStringExtra(r1)
            java.lang.String r2 = "detecting_face_points"
            int[] r2 = r9.getIntArrayExtra(r2)
            goto L_0x004c
        L_0x004a:
            r1 = r0
            r2 = r1
        L_0x004c:
            java.lang.String r3 = TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "faceImageFilePath: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r5 = ", faceDetectPoints: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r3, r4)
            r3 = 0
            if (r1 == 0) goto L_0x0092
            if (r2 == 0) goto L_0x0092
            java.io.File r4 = new java.io.File
            r4.<init>(r1)
            boolean r1 = r4.exists()
            if (r1 == 0) goto L_0x008a
            boolean r1 = r4.isFile()
            if (r1 == 0) goto L_0x008a
            net.fxgear.fittingmodenative.f$a r1 = net.fxgear.fittingmodenative.f.f1467a
            r1.getClass()
            boolean r0 = r6.CreateCustomFaceData(r4, r2, r0)
            goto L_0x009a
        L_0x008a:
            java.lang.String r0 = TAG
            java.lang.String r1 = "[ERROR] :: custom face image file is wrong"
            android.util.Log.e(r0, r1)
            goto L_0x0099
        L_0x0092:
            java.lang.String r0 = TAG
            java.lang.String r1 = "[ERROR] :: faceImageFilePath or faceDetectPoints is null"
            android.util.Log.e(r0, r1)
        L_0x0099:
            r0 = 0
        L_0x009a:
            if (r0 != 0) goto L_0x00b4
            int r0 = r6.mCurrentViewType
            r1 = 6
            if (r0 == r1) goto L_0x00a4
            r6.CancelToChangeCustomFace()
        L_0x00a4:
            net.fxgear.fittingmodenative.FittingActivity$f r0 = r6.mRequestInfoForCustomFace
            if (r0 == 0) goto L_0x00ac
            net.fxgear.fittingmodenative.FittingActivity$f r0 = r6.mRequestInfoForCustomFace
            boolean r3 = r0.c
        L_0x00ac:
            net.fxgear.fittingmodenative.FittingActivity$31 r0 = new net.fxgear.fittingmodenative.FittingActivity$31
            r0.<init>(r3)
            r6.ShowErrorDialogToDectectFacePoint(r3, r0)
        L_0x00b4:
            super.onActivityResult(r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.FittingActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    /* renamed from: net.fxgear.fittingmodenative.FittingActivity$1  reason: invalid class name */
    class AnonymousClass1 implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f1178a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1179b;
        final /* synthetic */ FittingActivity c;

        public void a(net.fxgear.fittingmodenative.b.b bVar) {
            android.support.v4.a.a.a(this.c, (String[]) this.f1178a.toArray(new String[0]), this.f1179b);
            bVar.dismiss();
        }

        public void b(net.fxgear.fittingmodenative.b.b bVar) {
            bVar.dismiss();
        }
    }

    private void InitializeActivity(int i, int i2, int i3, b bVar) {
        Log.d(TAG, "InitializeActivity()+");
        this.mCurrentViewType = 0;
        this.mFittingView = (FittingView) GetFittingView();
        f.f1467a.getClass();
        SetBackgroundBGBitmap(BitmapFactory.decodeResource(getResources(), a.d.fitting_room_bg));
        InitFittingView(i, i2, i3, bVar.c, bVar.d, FittingView.EMPTY_CLOTHES, (Runnable) null);
        this.mFittingViewContainer = (RelativeLayout) findViewById(a.e.fitting_room_fitting_view_container);
        this.mFittingViewContainer.addView(this.mFittingView, new RelativeLayout.LayoutParams(-1, -1));
        this.mActionBarContainer = (RelativeLayout) findViewById(a.e.fitting_room_action_bar_container);
        this.mActionBar = new d(this);
        this.mActionBar.a((d.a) this);
        this.mActionBarContainer.addView(this.mActionBar, new RelativeLayout.LayoutParams(-1, (int) getResources().getDimension(a.c.actionBar_height)));
        this.mLeftOptionButton = (Button) findViewById(a.e.fitting_room_left_option_button);
        this.mLeftOptionButton.setOnClickListener(this);
        this.mLeftOptionButton.setVisibility(0);
        this.mFittingRoomLayout = (LinearLayout) findViewById(a.e.layout_fitting_room_option_button);
        this.mCheckingClothesLayout = (LinearLayout) findViewById(a.e.layout_checking_size_option_button);
        this.mFirstROptionButton = (Button) findViewById(a.e.fitting_room_first_option_button);
        this.mFirstROptionButton.setOnClickListener(this);
        this.mSecondROptionButton = (Button) findViewById(a.e.fitting_room_second_option_button);
        this.mSecondROptionButton.setOnClickListener(this);
        this.mThirdROptionButton = (Button) findViewById(a.e.fitting_room_third_option_button);
        this.mThirdROptionButton.setOnClickListener(this);
        this.mFirstRadioButton = (RadioButton) findViewById(a.e.checking_size_first_radio_button);
        this.mFirstRadioButton.setOnClickListener(this);
        this.mSecondRadioButton = (RadioButton) findViewById(a.e.checking_size_second_radio_button);
        this.mSecondRadioButton.setOnClickListener(this);
        this.mThirdRadioButton = (RadioButton) findViewById(a.e.checking_size_third_radio_button);
        this.mThirdRadioButton.setOnClickListener(this);
        this.mTakeOffAllClothesButton = (Button) findViewById(a.e.fitting_room_take_off_all_clothes_button);
        this.mTakeOffAllClothesButton.setOnClickListener(this);
        this.mBottomContainer = (RelativeLayout) findViewById(a.e.main_container_bottom);
        this.mTextFPS = (TextView) findViewById(a.e.tv_fps);
        this.mOfflineModeContainer = (RelativeLayout) findViewById(a.e.fitting_room_offline_mode_container);
        b.C0040b bVar2 = new b.C0040b();
        bVar2.c = 30;
        bVar2.d = (long) Math.round(((float) Runtime.getRuntime().maxMemory()) * 0.15f);
        bVar2.f1304b = new a.C0039a();
        bVar2.f1304b.f1291a = "FITTING_MODE_DISK_CACHE";
        bVar2.f1304b.f1292b = 10485760;
        this.mImageCache = new net.fxgear.fittingmodenative.a.b(this, "FITTING_MODE", bVar2);
        ShowAllFittingTools(true);
        SwitchCurrentUIView();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!f.a(getApplicationContext()) && this.mHandler != null) {
            ShowOfflineModeView();
        }
        if (this.mImageCache != null && HasClothesItemForRequest()) {
            UpdateClothesAndCategoryList();
        }
        if (this.mNeedDisplayFPS && this.mHandler != null) {
            this.mHandler.obtainMessage(MSG_UPDATE_FPS).sendToTarget();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.mNeedDisplayFPS && this.mHandler != null) {
            this.mHandler.removeMessages(MSG_UPDATE_FPS);
        }
        if (this.mImageCache != null) {
            this.mImageCache.a();
        }
    }

    /* access modifiers changed from: private */
    public void UpdateFPS() {
        if (this.mNeedDisplayFPS && this.mTextFPS != null && this.mFittingView != null) {
            if (this.mTextFPS.getVisibility() != 0) {
                this.mTextFPS.setVisibility(0);
            }
            this.mTextFPS.setText(String.format("FPS :: %.2f", new Object[]{Float.valueOf(this.mFittingView.GetFPS())}));
        }
    }

    private void RequestWishList(int[] iArr, final int i, final String str) {
        Log.d(TAG, "RequestWishList()+");
        if (this.mClothDataTask != null) {
            Log.e(TAG, "Exist cloth list working");
        } else {
            this.mClothDataTask = net.fxgear.fittingmodenative.d.e.a((Context) this, iArr, (e.a.C0051a) new e.a.C0051a() {
                public void a(ArrayList<e.a> arrayList) {
                    e.a aVar;
                    int GetCurrentGender = FittingActivity.this.GetCurrentGender();
                    int GetCurrentAge = FittingActivity.this.GetCurrentAge();
                    boolean z = false;
                    if (arrayList != null) {
                        FittingActivity.this.BindClothesStructure(arrayList);
                        FittingActivity.this.UpdateClothesAndCategoryList();
                        c GetFittingData = FittingActivity.this.GetFittingData(GetCurrentGender, GetCurrentAge);
                        if (!(i == -1 || GetFittingData == null)) {
                            ArrayList arrayList2 = GetFittingData.e.get(Integer.valueOf(GetFittingData.f1283b.get(GetFittingData.f1282a).f1355a));
                            if (arrayList2 != null) {
                                Iterator it = arrayList2.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        aVar = null;
                                        break;
                                    }
                                    aVar = (e.a) it.next();
                                    if (i == aVar.i.f1461a) {
                                        break;
                                    }
                                }
                                if (aVar != null) {
                                    if (FittingActivity.this.mMainClothesAndCategoryListView != null) {
                                        FittingActivity.this.mMainClothesAndCategoryListView.b(i);
                                    }
                                    if (FittingActivity.this.IsWorkingFittingView()) {
                                        FittingActivity.this.mHandler.obtainMessage(FittingActivity.MSG_PUT_ON_CLOTH, aVar).sendToTarget();
                                        z = true;
                                    } else if (aVar.i.e != 1) {
                                        FittingActivity.this.DownloadClothesData(aVar);
                                    } else {
                                        int[] GetFittingClotehsArray = FittingActivity.this.GetFittingClotehsArray(FittingActivity.this.GetCurrentGender(), FittingActivity.this.GetCurrentAge());
                                        if (GetFittingClotehsArray != null) {
                                            GetFittingClotehsArray[aVar.i.d] = aVar.i.f1461a;
                                        }
                                        FittingActivity.this.SetClothes(e.a((Context) FittingActivity.this).e(aVar.i.f1461a), (Runnable) null);
                                    }
                                }
                            } else {
                                Log.e(FittingActivity.TAG, "ERROR :: Unkown categoryID");
                            }
                        }
                    } else {
                        Iterator it2 = FittingActivity.this.mFittingDataList.iterator();
                        while (it2.hasNext()) {
                            c cVar = (c) it2.next();
                            if (cVar != null) {
                                ArrayList<d.a> arrayList3 = cVar.f1283b;
                                for (int i = 0; i < arrayList3.size(); i++) {
                                    cVar.e.get(Integer.valueOf(arrayList3.get(i).f1355a)).clear();
                                }
                            }
                        }
                    }
                    if (str != null && str.equals("add_video")) {
                        FittingActivity.this.OnShowItemList(22, FittingActivity.this.GetStringJsonDataInfoForSelectedItems(22, true));
                    }
                    if (!z && !FittingActivity.this.IsWorkingFittingView()) {
                        FittingActivity.this.DismissCircleDialog();
                    }
                    e.a unused = FittingActivity.this.mClothDataTask = null;
                }

                public void a() {
                    FittingActivity.this.ShowCircleDialog();
                }
            });
        }
    }

    private int[] GenerateWishItems(JSONArray jSONArray) {
        JSONArray jSONArray2 = jSONArray;
        Log.d(TAG, "GenerateWishItems()+");
        if (jSONArray2 == null || jSONArray.length() <= 0) {
            return null;
        }
        int[] iArr = new int[jSONArray.length()];
        int i = 2;
        c GetFittingData = GetFittingData(2, 2);
        int i2 = 1;
        c GetFittingData2 = GetFittingData(1, 2);
        c GetFittingData3 = GetFittingData(1, 1);
        c GetFittingData4 = GetFittingData(2, 1);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < jSONArray.length()) {
            try {
                JSONObject jSONObject = jSONArray2.getJSONObject(i3);
                e.a aVar = new e.a();
                aVar.f1366a = jSONObject.getInt("uuid");
                aVar.h = jSONObject.getInt("sample") == i2;
                if (jSONObject.getString("gender").equals(GlobalDefine.GENDER_MAN_STRING)) {
                    aVar.c = i;
                    if (jSONObject.getString("age").equals(GlobalDefine.AGE_EARLY_STRING)) {
                        aVar.d = i2;
                        arrayList.add(GetFittingData4);
                    } else if (jSONObject.getString("age").equals(GlobalDefine.AGE_MIDDLE_STRING)) {
                        aVar.d = i;
                        arrayList.add(GetFittingData);
                    }
                } else if (jSONObject.getString("gender").equals(GlobalDefine.GENDER_WOMAN_STRING)) {
                    aVar.c = i2;
                    if (jSONObject.getString("age").equals(GlobalDefine.AGE_EARLY_STRING)) {
                        aVar.d = i2;
                        arrayList.add(GetFittingData3);
                    } else if (jSONObject.getString("age").equals(GlobalDefine.AGE_MIDDLE_STRING)) {
                        aVar.d = i;
                        arrayList.add(GetFittingData2);
                    }
                } else {
                    aVar.c = 3;
                    if (jSONObject.getString("age").equals(GlobalDefine.AGE_EARLY_STRING)) {
                        aVar.d = i2;
                        arrayList.add(GetFittingData3);
                        arrayList.add(GetFittingData4);
                    } else if (jSONObject.getString("age").equals(GlobalDefine.AGE_MIDDLE_STRING)) {
                        Log.e(TAG, "ERROR :: IllegalState - unisex only kids.");
                    }
                }
                if (!arrayList.isEmpty()) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        c cVar = (c) it.next();
                        if (cVar != null) {
                            JSONArray jSONArray3 = jSONObject.getJSONArray("category_id");
                            int i4 = 0;
                            while (i4 < jSONArray3.length()) {
                                int i5 = jSONArray3.getInt(i4);
                                JSONObject jSONObject2 = jSONObject;
                                aVar.f1367b.add(Integer.valueOf(i5));
                                if (cVar.e.containsKey(Integer.valueOf(i5)) && !cVar.e.get(Integer.valueOf(i5)).contains(aVar)) {
                                    try {
                                        cVar.e.get(Integer.valueOf(i5)).add(0, aVar);
                                    } catch (JSONException e2) {
                                        e = e2;
                                        e.printStackTrace();
                                        i3++;
                                        i = 2;
                                        i2 = 1;
                                    }
                                }
                                if (!cVar.e.get(-1).contains(aVar)) {
                                    cVar.e.get(-1).add(0, aVar);
                                }
                                i4++;
                                jSONObject = jSONObject2;
                            }
                        }
                        jSONObject = jSONObject;
                    }
                    arrayList.clear();
                } else {
                    FXUtil.OccurRunTimeException("ERROR :: wrong json data.");
                }
                iArr[i3] = aVar.f1366a;
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
                i3++;
                i = 2;
                i2 = 1;
            }
            i3++;
            i = 2;
            i2 = 1;
        }
        return iArr;
    }

    private int[] GenerateFittingModeData(String str, JSONArray jSONArray) {
        Log.d(TAG, "GenerateFittingModeData()+");
        String str2 = jSONArray == null ? "ERROR :: param error." : null;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        d.a aVar = new d.a();
        aVar.f1355a = -1;
        aVar.f1356b = getResources().getString(a.g.category_name_all);
        arrayList.add(aVar);
        arrayList2.add(aVar);
        arrayList3.add(aVar);
        arrayList4.add(aVar);
        e a2 = e.a((Context) this);
        if (str == null || str.isEmpty()) {
            str = a2.a();
        } else {
            a2.a(str);
        }
        if (str != null) {
            try {
                JSONArray jSONArray2 = new JSONArray(str);
                for (int i = 0; i < jSONArray2.length(); i++) {
                    JSONObject jSONObject = (JSONObject) jSONArray2.get(i);
                    String string = jSONObject.getString("gender");
                    String string2 = jSONObject.getString("age");
                    d.a aVar2 = new d.a();
                    aVar2.f1355a = Integer.parseInt(jSONObject.getString("category_id"));
                    aVar2.f1356b = jSONObject.getString("category_name");
                    if (string.equals(GlobalDefine.GENDER_MAN_STRING)) {
                        if (string2.equals(GlobalDefine.AGE_EARLY_STRING)) {
                            arrayList4.add(aVar2);
                        } else {
                            arrayList.add(aVar2);
                        }
                    } else if (string2.equals(GlobalDefine.AGE_EARLY_STRING)) {
                        arrayList3.add(aVar2);
                    } else {
                        arrayList2.add(aVar2);
                    }
                }
            } catch (JSONException e2) {
                str2 = "ERROR :: wrong json data.";
                e2.printStackTrace();
            }
        } else {
            Log.e(TAG, "Category json string is null.");
        }
        if (!arrayList.isEmpty() || !arrayList2.isEmpty() || !arrayList3.isEmpty() || !arrayList4.isEmpty()) {
            InitializeFittingDataList();
            if (!arrayList2.isEmpty()) {
                SetFittingDataInfo((ArrayList<d.a>) arrayList2, 1, 2);
            } else {
                Log.d(TAG, "WARNING :: woman category data empty");
            }
            if (!arrayList.isEmpty()) {
                SetFittingDataInfo((ArrayList<d.a>) arrayList, 2, 2);
            } else {
                Log.d(TAG, "WARNING :: man category data empty");
            }
            if (!arrayList3.isEmpty()) {
                SetFittingDataInfo((ArrayList<d.a>) arrayList3, 1, 1);
            } else {
                Log.d(TAG, "WARNING :: girl category data empty");
            }
            if (!arrayList4.isEmpty()) {
                SetFittingDataInfo((ArrayList<d.a>) arrayList4, 2, 1);
            } else {
                Log.d(TAG, "WARNING :: boy category data empty");
            }
            Iterator<c> it = this.mFittingDataList.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    ArrayList<d.a> arrayList5 = next.f1283b;
                    for (int i2 = 0; i2 < arrayList5.size(); i2++) {
                        next.e.put(Integer.valueOf(arrayList5.get(i2).f1355a), new ArrayList());
                    }
                }
            }
        }
        if (str2 != null) {
            FXUtil.OccurRunTimeException(str2);
        }
        return GenerateWishItems(jSONArray);
    }

    private void SetFittingDataInfo(ArrayList<d.a> arrayList, int i, int i2) {
        boolean z;
        c cVar = new c();
        File GetCharacterDataDirectory = GlobalDefine.GetCharacterDataDirectory(getApplicationContext());
        String GetCharacterDataFileName = GlobalDefine.GetCharacterDataFileName(i, i2);
        b b2 = b.b(this, new File(GetCharacterDataDirectory, GetCharacterDataFileName));
        if (b2 == null) {
            b2 = new b();
            b2.f1310b = i;
            b2.f1309a = i2;
            b2.c = GetDefaultMirrorVideoID(i, i2);
            b2.d = GetDefaultAvatarID(i, i2);
            b2.k = FXDataManager.GetInstance(this).GetAvatarData(b2.d);
            if (b2.k == null) {
                FXUtil.OccurRunTimeException("Not exist default avatar data.(gender : " + i + ", age : " + i2 + ")");
            }
            b2.d(this, new File(GetCharacterDataDirectory, GetCharacterDataFileName));
        } else {
            FXDataManager GetInstance = FXDataManager.GetInstance(getApplicationContext());
            if (GetInstance.GetAvatarData(b2.d) == null) {
                b2.d = GetDefaultAvatarID(i, i2);
                b2.k = FXDataManager.GetInstance(this).GetAvatarData(b2.d);
                if (b2.k == null) {
                    FXUtil.OccurRunTimeException("Not exist default avatar data.(gender : " + i + ", age : " + i2 + ")");
                }
                z = true;
            } else {
                z = false;
            }
            if (!e.a(getApplicationContext()).i(b2.c)) {
                b2.c = GetDefaultMirrorVideoID(b2.f1310b, b2.f1309a);
                z = true;
            }
            if (!IsValidAvatarData(b2)) {
                z = true;
            }
            if (z) {
                GetInstance.UpdateAvatarData(b2.k);
                RemoveAvatarThumbnailFile(b2.d);
                b2.d(this, new File(GetCharacterDataDirectory, GetCharacterDataFileName));
            }
        }
        cVar.f = b2;
        int i3 = 0;
        while (true) {
            if (i3 >= arrayList.size()) {
                break;
            }
            d.a aVar = arrayList.get(i3);
            if (aVar.f1355a == -1) {
                cVar.f1283b.add(0, aVar);
                arrayList.remove(aVar);
                break;
            }
            i3++;
        }
        cVar.f1283b.addAll(arrayList);
        cVar.f1282a = 0;
        SetFittingDataInfo(cVar, i, i2);
    }

    /* access modifiers changed from: private */
    public e.a FindClothesData(ArrayList<e.a> arrayList, int i) {
        if (arrayList == null) {
            return null;
        }
        Iterator<e.a> it = arrayList.iterator();
        while (it.hasNext()) {
            e.a next = it.next();
            if (next != null && next.f1461a == i) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void BindClothesStructure(ArrayList<e.a> arrayList) {
        Log.d(TAG, "BindClothesStructure()+");
        if (arrayList == null) {
            Log.e(TAG, "ERROR :: param is wrong.");
            return;
        }
        Iterator<c> it = this.mFittingDataList.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null) {
                ArrayList<d.a> arrayList2 = next.f1283b;
                for (int i = 0; i < arrayList2.size(); i++) {
                    ArrayList arrayList3 = next.e.get(Integer.valueOf(arrayList2.get(i).f1355a));
                    if (arrayList3 != null) {
                        int i2 = 0;
                        while (i2 < arrayList3.size()) {
                            e.a aVar = (e.a) arrayList3.get(i2);
                            aVar.i = FindClothesData(arrayList, aVar.f1366a);
                            if (aVar.i != null) {
                                if (aVar.i.e == 1) {
                                    aVar.f = 1;
                                } else {
                                    aVar.f = 0;
                                }
                                i2++;
                            } else {
                                Log.e(TAG, "ERROR :: Not found cloth id.");
                                arrayList3.remove(aVar);
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void SetOptionButtonsVisibility() {
        int i;
        if (this.mLeftOptionButton != null && this.mFirstROptionButton != null && this.mSecondROptionButton != null && this.mThirdROptionButton != null && this.mFirstRadioButton != null && this.mSecondRadioButton != null && this.mThirdRadioButton != null && this.mTakeOffAllClothesButton != null) {
            switch (this.mCurrentViewType) {
                case 0:
                    this.mFittingRoomLayout.setVisibility(0);
                    this.mCheckingClothesLayout.setVisibility(8);
                    this.mFirstROptionButton.setVisibility(0);
                    this.mSecondROptionButton.setVisibility(8);
                    if (GetCurrentMode() == 0) {
                        this.mLeftOptionButton.setVisibility(8);
                        this.mFirstROptionButton.setBackgroundResource(a.d.right_top_video_setting_btn);
                        this.mThirdROptionButton.setVisibility(8);
                    } else {
                        if (GetCurrentAge() == 1) {
                            this.mLeftOptionButton.setVisibility(8);
                        } else {
                            this.mLeftOptionButton.setVisibility(0);
                            this.mLeftOptionButton.setBackgroundResource(a.d.btn_clothes_check_size);
                        }
                        this.mThirdROptionButton.setVisibility(0);
                        if (this.mFittingView.GetAnimationPause()) {
                            this.mThirdROptionButton.setBackgroundResource(a.d.btn_avatar_resume);
                        } else {
                            this.mThirdROptionButton.setBackgroundResource(a.d.btn_avatar_pause);
                        }
                        this.mFirstROptionButton.setBackgroundResource(a.d.right_top_avatar_list_btn);
                        this.mSecondROptionButton.setVisibility(0);
                        this.mSecondROptionButton.setBackgroundResource(a.d.right_top_avatar_setting_btn);
                    }
                    this.mTakeOffAllClothesButton.setVisibility(0);
                    break;
                case 1:
                    this.mLeftOptionButton.setVisibility(8);
                    this.mFittingRoomLayout.setVisibility(0);
                    this.mCheckingClothesLayout.setVisibility(8);
                    if (GetFittingData(GetCurrentGender(), GetCurrentAge()).f.k.mIsCustomFace) {
                        this.mFirstROptionButton.setVisibility(0);
                        this.mFirstROptionButton.setBackgroundResource(a.d.right_top_reset_btn);
                    } else {
                        this.mFirstROptionButton.setVisibility(8);
                    }
                    this.mSecondROptionButton.setVisibility(8);
                    this.mThirdROptionButton.setVisibility(8);
                    this.mTakeOffAllClothesButton.setVisibility(8);
                    break;
                case 4:
                    this.mLeftOptionButton.setVisibility(8);
                    this.mFittingRoomLayout.setVisibility(0);
                    this.mCheckingClothesLayout.setVisibility(8);
                    this.mFirstROptionButton.setVisibility(0);
                    this.mFirstROptionButton.setBackgroundResource(a.d.right_top_reset_btn);
                    this.mSecondROptionButton.setVisibility(8);
                    this.mThirdROptionButton.setVisibility(8);
                    this.mTakeOffAllClothesButton.setVisibility(8);
                    break;
                case 5:
                    this.mLeftOptionButton.setVisibility(8);
                    this.mFittingRoomLayout.setVisibility(0);
                    this.mCheckingClothesLayout.setVisibility(8);
                    this.mFirstROptionButton.setVisibility(0);
                    this.mFirstROptionButton.setBackgroundResource(a.d.right_top_reset_btn);
                    this.mSecondROptionButton.setVisibility(8);
                    this.mThirdROptionButton.setVisibility(8);
                    this.mTakeOffAllClothesButton.setVisibility(8);
                    break;
                case 7:
                    this.mLeftOptionButton.setVisibility(0);
                    this.mLeftOptionButton.setBackgroundResource(a.d.right_top_avatar_setting_btn);
                    this.mFittingRoomLayout.setVisibility(8);
                    this.mCheckingClothesLayout.setVisibility(0);
                    SetSelectedButtonForClothesVisualization(GlobalDefine.ClothesVisualizationOption.Color);
                    this.mTakeOffAllClothesButton.setVisibility(0);
                    break;
                default:
                    this.mFittingRoomLayout.setVisibility(0);
                    this.mCheckingClothesLayout.setVisibility(8);
                    this.mLeftOptionButton.setVisibility(8);
                    this.mFirstROptionButton.setVisibility(8);
                    this.mSecondROptionButton.setVisibility(8);
                    this.mThirdROptionButton.setVisibility(8);
                    this.mTakeOffAllClothesButton.setVisibility(8);
                    break;
            }
            if (this.mTakeOffAllClothesButton.getVisibility() == 0) {
                Resources resources = getResources();
                int dimension = (int) resources.getDimension(a.c.right_top_option_button_width);
                int dimension2 = (int) resources.getDimension(a.c.right_top_option_button_margin_right);
                if (this.mCurrentViewType == 7) {
                    i = (int) resources.getDimension(a.c.take_off_all_clothes_button_margin_bottom);
                } else {
                    i = (int) resources.getDimension(a.c.default_take_off_all_clothes_button_margin_bottom);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimension, dimension);
                layoutParams.addRule(11);
                layoutParams.addRule(12);
                layoutParams.setMargins(0, 0, dimension2, i);
                this.mTakeOffAllClothesButton.setLayoutParams(layoutParams);
            }
        }
    }

    private void GoToAddAvatarView() {
        RemoveBottomMenuView();
        Resources resources = getResources();
        if (this.mActionBar != null) {
            this.mActionBar.setVisibility(0);
            this.mActionBar.a(1, resources.getString(a.g.avatar_setting_title), 2, false);
        }
        net.fxgear.fittingmodenative.c.b bVar = new net.fxgear.fittingmodenative.c.b(this);
        bVar.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) resources.getDimension(a.c.avatar_setting_mode_menu_height)));
        bVar.a((b.c) this);
        bVar.a(new ArrayList(Arrays.asList(getResources().getStringArray(a.C0023a.avatar_setting_mode_view))), false);
        if (this.mBottomContainer != null) {
            if (this.mBottomContainer.getVisibility() != 0) {
                this.mBottomContainer.setVisibility(0);
            }
            this.mBottomContainer.addView(bVar);
        }
        this.mLeftOptionButton.setVisibility(8);
        this.mCheckingClothesLayout.setVisibility(8);
        this.mFirstROptionButton.setVisibility(8);
        this.mSecondROptionButton.setVisibility(8);
        this.mThirdROptionButton.setVisibility(8);
        this.mTakeOffAllClothesButton.setVisibility(8);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: net.fxgear.fittingmodenative.c.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: net.fxgear.fittingmodenative.c.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: net.fxgear.fittingmodenative.c.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: net.fxgear.fittingmodenative.c.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: net.fxgear.fittingmodenative.c.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: net.fxgear.fittingmodenative.c.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: net.fxgear.fittingmodenative.c.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: net.fxgear.fittingmodenative.c.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: net.fxgear.fittingmodenative.c.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: net.fxgear.fittingmodenative.c.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: net.fxgear.fittingmodenative.c.g} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: net.fxgear.fittingmodenative.c.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: net.fxgear.fittingmodenative.c.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v24, resolved type: net.fxgear.fittingmodenative.c.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v25, resolved type: net.fxgear.fittingmodenative.c.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: net.fxgear.fittingmodenative.c.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v27, resolved type: net.fxgear.fittingmodenative.c.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v28, resolved type: net.fxgear.fittingmodenative.c.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: net.fxgear.fittingmodenative.c.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: net.fxgear.fittingmodenative.c.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: net.fxgear.fittingmodenative.c.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v33, resolved type: net.fxgear.fittingmodenative.c.h} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0163, code lost:
        r8 = r1;
        r0 = true;
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0258, code lost:
        if (r10.mActionBar == null) goto L_0x028d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x025a, code lost:
        if (r0 == false) goto L_0x0286;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x025c, code lost:
        r10.mActionBar.setVisibility(0);
        r10.mActionBar.a(r1, r2, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0268, code lost:
        if (r10.mCurrentViewType != 0) goto L_0x028d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x026e, code lost:
        if (GetCurrentMode() != 0) goto L_0x0272;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x002a, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0270, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0272, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0273, code lost:
        r10.mActionBar.a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x027c, code lost:
        if (GetCurrentGender() != 2) goto L_0x027f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x027f, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0280, code lost:
        r10.mActionBar.b(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0286, code lost:
        r10.mActionBar.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x028d, code lost:
        if (r8 == null) goto L_0x02a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0291, code lost:
        if (r10.mBottomContainer == null) goto L_0x02a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x002b, code lost:
        r1 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0299, code lost:
        if (r10.mBottomContainer.getVisibility() == 0) goto L_0x02a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x029b, code lost:
        r10.mBottomContainer.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x02a0, code lost:
        r10.mBottomContainer.addView(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x02a5, code lost:
        SetOptionButtonsVisibility();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x02a8, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002c, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002d, code lost:
        r7 = false;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void SwitchCurrentUIView() {
        /*
            r10 = this;
            java.lang.String r0 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "SwitchCurrentUIView(), mCurrentViewType :"
            r1.append(r2)
            int r2 = r10.mCurrentViewType
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
            r10.RemoveBottomMenuView()
            android.content.res.Resources r0 = r10.getResources()
            int r1 = r10.mCurrentViewType
            r2 = 0
            r3 = 2
            r4 = -1
            r5 = 1
            r6 = 0
            switch(r1) {
                case 0: goto L_0x0207;
                case 1: goto L_0x01bc;
                case 2: goto L_0x0168;
                case 3: goto L_0x011b;
                case 4: goto L_0x00ae;
                case 5: goto L_0x006b;
                case 6: goto L_0x0044;
                case 7: goto L_0x0030;
                default: goto L_0x0029;
            }
        L_0x0029:
            r8 = r2
        L_0x002a:
            r0 = 1
        L_0x002b:
            r1 = 1
        L_0x002c:
            r4 = 0
        L_0x002d:
            r7 = 0
            goto L_0x0256
        L_0x0030:
            android.content.res.Resources r0 = r10.getResources()
            int r1 = net.fxgear.a.a.g.checking_clothes_size_title
            java.lang.String r2 = r0.getString(r1)
            net.fxgear.fittingmodenative.c.h r0 = r10.mMainClothesAndCategoryListView
            r1 = 7
            r0.a((int) r1)
            net.fxgear.fittingmodenative.c.h r0 = r10.mMainClothesAndCategoryListView
            r8 = r0
            goto L_0x002a
        L_0x0044:
            net.fxgear.fittingmodenative.c.g r1 = new net.fxgear.fittingmodenative.c.g
            r1.<init>(r10)
            android.widget.RelativeLayout$LayoutParams r7 = new android.widget.RelativeLayout$LayoutParams
            int r8 = net.fxgear.a.a.c.avatar_setting_mode_menu_height
            float r0 = r0.getDimension(r8)
            int r0 = (int) r0
            r7.<init>(r4, r0)
            r1.setLayoutParams(r7)
            r1.a((net.fxgear.fittingmodenative.c.g.a) r10)
            net.fxgear.fittingmodenative.FittingActivity$f r0 = r10.mRequestInfoForCustomFace
            if (r0 == 0) goto L_0x0064
            net.fxgear.fittingmodenative.FittingActivity$f r0 = r10.mRequestInfoForCustomFace
            boolean r0 = r0.c
            goto L_0x0065
        L_0x0064:
            r0 = 0
        L_0x0065:
            r1.a((boolean) r0)
            r8 = r1
            r0 = 0
            goto L_0x002b
        L_0x006b:
            int r1 = net.fxgear.a.a.g.avatar_body_size
            java.lang.String r2 = r0.getString(r1)
            net.fxgear.fittingmodenative.c.c r1 = new net.fxgear.fittingmodenative.c.c
            r1.<init>(r10)
            android.widget.RelativeLayout$LayoutParams r7 = new android.widget.RelativeLayout$LayoutParams
            int r8 = net.fxgear.a.a.c.body_size_setting_mode_menu_height
            float r0 = r0.getDimension(r8)
            int r0 = (int) r0
            r7.<init>(r4, r0)
            r1.setLayoutParams(r7)
            r1.a((net.fxgear.fittingmodenative.c.c.d) r10)
            int r0 = r10.GetCurrentGender()
            int r4 = r10.GetCurrentAge()
            net.fxgear.fittingmodenative.FittingActivity$c r0 = r10.GetFittingData(r0, r4)
            net.fxgear.fittingmodenative.b r0 = r0.f
            int r4 = r10.GetCurrentGender()
            int r7 = r10.GetCurrentAge()
            net.fxgear.AvatarData r0 = r0.k
            net.fxgear.BodySizeData r0 = r0.mBodyData
            r1.a(r4, r7, r0)
            boolean r0 = net.fxgear.fittingmodenative.f.c((android.content.Context) r10)
            r1.a((boolean) r0, (boolean) r6)
            goto L_0x0163
        L_0x00ae:
            int r1 = net.fxgear.a.a.g.face_config_correction
            java.lang.String r2 = r0.getString(r1)
            net.fxgear.fittingmodenative.c.f r1 = new net.fxgear.fittingmodenative.c.f
            r1.<init>(r10)
            android.widget.RelativeLayout$LayoutParams r7 = new android.widget.RelativeLayout$LayoutParams
            int r8 = net.fxgear.a.a.c.color_calibration_setting_mode_menu_height
            float r0 = r0.getDimension(r8)
            int r0 = (int) r0
            r7.<init>(r4, r0)
            r1.setLayoutParams(r7)
            r1.a((net.fxgear.fittingmodenative.c.f.a) r10)
            int r0 = r10.GetCurrentGender()
            int r4 = r10.GetCurrentAge()
            net.fxgear.fittingmodenative.FittingActivity$c r0 = r10.GetFittingData(r0, r4)
            net.fxgear.fittingmodenative.b r0 = r0.f
            net.fxgear.AvatarData r4 = r0.k
            boolean r4 = r4.mIsCustomFace
            if (r4 == 0) goto L_0x010c
            net.fxgear.AvatarData r4 = r0.k
            float r4 = r4.mAutoNormalizedColor
            r7 = 3
            float[] r7 = new float[r7]
            net.fxgear.AvatarData r8 = r0.k
            int r8 = r8.mHueRGBColor
            int r8 = net.fxgear.util.FXUtil.redFromColor(r8)
            float r8 = (float) r8
            r7[r6] = r8
            net.fxgear.AvatarData r8 = r0.k
            int r8 = r8.mHueRGBColor
            int r8 = net.fxgear.util.FXUtil.greenFromColor(r8)
            float r8 = (float) r8
            r7[r5] = r8
            net.fxgear.AvatarData r0 = r0.k
            int r0 = r0.mHueRGBColor
            int r0 = net.fxgear.util.FXUtil.blueFromColor(r0)
            float r0 = (float) r0
            r7[r3] = r0
            float r0 = net.fxgear.fittingview.FittingSurfaceView.colorTemperatureToNormalizeValue(r7)
            goto L_0x0110
        L_0x010c:
            r4 = 1056964608(0x3f000000, float:0.5)
            float r0 = net.fxgear.fittingmodenative.c.f.f1379a
        L_0x0110:
            r7 = 10
            r1.a(r7, r4)
            r4 = 11
            r1.a(r4, r0)
            goto L_0x0163
        L_0x011b:
            int r1 = net.fxgear.a.a.g.face_config_hair
            java.lang.String r2 = r0.getString(r1)
            net.fxgear.fittingmodenative.c.a r1 = new net.fxgear.fittingmodenative.c.a
            r1.<init>(r10)
            android.widget.RelativeLayout$LayoutParams r7 = new android.widget.RelativeLayout$LayoutParams
            int r8 = net.fxgear.a.a.c.avatar_recycler_horizontal_setting_mode_menu_height
            float r0 = r0.getDimension(r8)
            int r0 = (int) r0
            r7.<init>(r4, r0)
            r1.setLayoutParams(r7)
            r1.a((net.fxgear.fittingmodenative.c.a.C0042a) r10)
            int r0 = r10.GetCurrentGender()
            int r4 = r10.GetCurrentAge()
            net.fxgear.fittingmodenative.FittingActivity$c r0 = r10.GetFittingData(r0, r4)
            net.fxgear.fittingmodenative.b r0 = r0.f
            net.fxgear.AvatarData r0 = r0.k
            int r0 = r0.mHairType
            int r4 = r10.GetCurrentGender()
            int r7 = r10.GetCurrentAge()
            int r0 = r10.GetHairIndexByType(r0, r4, r7)
            int r4 = r10.mCurrentViewType
            int r7 = r10.GetCurrentGender()
            int r8 = r10.GetCurrentAge()
            r1.a(r4, r7, r8, r0)
        L_0x0163:
            r8 = r1
            r0 = 1
            r1 = 0
            goto L_0x002c
        L_0x0168:
            int r1 = net.fxgear.a.a.g.face_config_face_shape
            java.lang.String r2 = r0.getString(r1)
            net.fxgear.fittingmodenative.c.a r1 = new net.fxgear.fittingmodenative.c.a
            r1.<init>(r10)
            android.widget.RelativeLayout$LayoutParams r7 = new android.widget.RelativeLayout$LayoutParams
            int r8 = net.fxgear.a.a.c.avatar_recycler_horizontal_setting_mode_menu_height
            float r0 = r0.getDimension(r8)
            int r0 = (int) r0
            r7.<init>(r4, r0)
            r1.setLayoutParams(r7)
            r1.a((net.fxgear.fittingmodenative.c.a.C0042a) r10)
            int r0 = r10.GetCurrentGender()
            int r4 = r10.GetCurrentAge()
            net.fxgear.fittingmodenative.FittingActivity$c r0 = r10.GetFittingData(r0, r4)
            net.fxgear.fittingmodenative.b r0 = r0.f
            net.fxgear.AvatarData r4 = r0.k
            boolean r4 = r4.mIsCustomFace
            if (r4 == 0) goto L_0x01a6
            net.fxgear.AvatarData r4 = r0.k
            int r4 = r4.mHeadType
            int r7 = r0.f1310b
            int r0 = r0.f1309a
            int r0 = r10.GetHeadIndexByType(r4, r7, r0)
            goto L_0x01ae
        L_0x01a6:
            int r4 = r0.f1310b
            int r0 = r0.f1309a
            int r0 = r10.GetDefaultHeadTypeIndex(r4, r0)
        L_0x01ae:
            int r4 = r10.mCurrentViewType
            int r7 = r10.GetCurrentGender()
            int r8 = r10.GetCurrentAge()
            r1.a(r4, r7, r8, r0)
            goto L_0x0163
        L_0x01bc:
            int r1 = net.fxgear.a.a.g.avatar_setting_title
            java.lang.String r2 = r0.getString(r1)
            net.fxgear.fittingmodenative.c.b r1 = new net.fxgear.fittingmodenative.c.b
            r1.<init>(r10)
            android.widget.RelativeLayout$LayoutParams r7 = new android.widget.RelativeLayout$LayoutParams
            int r8 = net.fxgear.a.a.c.avatar_setting_mode_menu_height
            float r0 = r0.getDimension(r8)
            int r0 = (int) r0
            r7.<init>(r4, r0)
            r1.setLayoutParams(r7)
            r1.a((net.fxgear.fittingmodenative.c.b.c) r10)
            int r0 = r10.GetCurrentGender()
            int r4 = r10.GetCurrentAge()
            net.fxgear.fittingmodenative.FittingActivity$c r0 = r10.GetFittingData(r0, r4)
            net.fxgear.fittingmodenative.b r0 = r0.f
            java.util.ArrayList r4 = new java.util.ArrayList
            android.content.res.Resources r7 = r10.getResources()
            int r8 = net.fxgear.a.a.C0023a.avatar_setting_mode_view
            java.lang.String[] r7 = r7.getStringArray(r8)
            java.util.List r7 = java.util.Arrays.asList(r7)
            r4.<init>(r7)
            net.fxgear.AvatarData r0 = r0.k
            boolean r0 = r0.mIsCustomFace
            r1.a(r4, r0)
            r8 = r1
            r0 = 1
            r1 = 1
            r4 = 2
            goto L_0x002d
        L_0x0207:
            net.fxgear.fittingmodenative.c.h r0 = r10.mMainClothesAndCategoryListView
            if (r0 != 0) goto L_0x024a
            net.fxgear.fittingmodenative.c.h r0 = new net.fxgear.fittingmodenative.c.h
            net.fxgear.fittingmodenative.a.b r1 = r10.mImageCache
            r0.<init>(r10, r1)
            r10.mMainClothesAndCategoryListView = r0
            net.fxgear.fittingmodenative.c.h r0 = r10.mMainClothesAndCategoryListView
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            android.content.res.Resources r7 = r10.getResources()
            int r8 = net.fxgear.a.a.c.main_clothes_and_category_horizontal_list_view_height
            float r7 = r7.getDimension(r8)
            int r7 = (int) r7
            r1.<init>(r4, r7)
            r0.setLayoutParams(r1)
            net.fxgear.fittingmodenative.c.h r0 = r10.mMainClothesAndCategoryListView
            r0.a((net.fxgear.fittingmodenative.c.d.C0046d) r10)
            net.fxgear.fittingmodenative.c.h r0 = r10.mMainClothesAndCategoryListView
            r0.a((net.fxgear.fittingmodenative.c.e.g) r10)
            int r0 = r10.GetCurrentGender()
            int r1 = r10.GetCurrentAge()
            net.fxgear.fittingmodenative.FittingActivity$c r0 = r10.GetFittingData(r0, r1)
            if (r0 == 0) goto L_0x024a
            net.fxgear.fittingmodenative.c.h r1 = r10.mMainClothesAndCategoryListView
            java.util.ArrayList<net.fxgear.fittingmodenative.c.d$a> r4 = r0.f1283b
            int r0 = r0.f1282a
            r1.a((java.util.ArrayList<net.fxgear.fittingmodenative.c.d.a>) r4, (int) r0)
        L_0x024a:
            net.fxgear.fittingmodenative.c.h r0 = r10.mMainClothesAndCategoryListView
            r0.a((int) r6)
            net.fxgear.fittingmodenative.c.h r0 = r10.mMainClothesAndCategoryListView
            r8 = r0
            r0 = 1
            r1 = 1
            r4 = 1
            r7 = 1
        L_0x0256:
            net.fxgear.fittingmodenative.d r9 = r10.mActionBar
            if (r9 == 0) goto L_0x028d
            if (r0 == 0) goto L_0x0286
            net.fxgear.fittingmodenative.d r0 = r10.mActionBar
            r0.setVisibility(r6)
            net.fxgear.fittingmodenative.d r0 = r10.mActionBar
            r0.a(r1, r2, r4, r7)
            int r0 = r10.mCurrentViewType
            if (r0 != 0) goto L_0x028d
            int r0 = r10.GetCurrentMode()
            if (r0 != 0) goto L_0x0272
            r0 = 0
            goto L_0x0273
        L_0x0272:
            r0 = 1
        L_0x0273:
            net.fxgear.fittingmodenative.d r1 = r10.mActionBar
            r1.a((boolean) r0)
            int r0 = r10.GetCurrentGender()
            if (r0 != r3) goto L_0x027f
            goto L_0x0280
        L_0x027f:
            r5 = 0
        L_0x0280:
            net.fxgear.fittingmodenative.d r0 = r10.mActionBar
            r0.b(r5)
            goto L_0x028d
        L_0x0286:
            net.fxgear.fittingmodenative.d r0 = r10.mActionBar
            r1 = 8
            r0.setVisibility(r1)
        L_0x028d:
            if (r8 == 0) goto L_0x02a5
            android.widget.RelativeLayout r0 = r10.mBottomContainer
            if (r0 == 0) goto L_0x02a5
            android.widget.RelativeLayout r0 = r10.mBottomContainer
            int r0 = r0.getVisibility()
            if (r0 == 0) goto L_0x02a0
            android.widget.RelativeLayout r0 = r10.mBottomContainer
            r0.setVisibility(r6)
        L_0x02a0:
            android.widget.RelativeLayout r0 = r10.mBottomContainer
            r0.addView(r8)
        L_0x02a5:
            r10.SetOptionButtonsVisibility()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.FittingActivity.SwitchCurrentUIView():void");
    }

    /* access modifiers changed from: private */
    public void SwitchCurrentModeAndUIwithViewType(final int i, final Runnable runnable) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("SwitchCurrentModeAndUIwithViewType()+, viewType : ");
        sb.append(i);
        sb.append(", has runnable : ");
        int i2 = 0;
        sb.append(runnable != null);
        Log.d(str, sb.toString());
        int GetCurrentMode = GetCurrentMode();
        switch (i) {
            case 0:
                if (GetCurrentMode != 0) {
                    i2 = 1;
                    break;
                }
                break;
            case 1:
            case 5:
                i2 = 2;
                break;
            case 2:
                i2 = 4;
                break;
            case 3:
                i2 = 3;
                break;
            case 4:
                i2 = 5;
                break;
            case 6:
                i2 = 6;
                break;
            case 7:
                i2 = 8;
                break;
            default:
                i2 = -1;
                break;
        }
        if (i2 == -1) {
            String str2 = TAG;
            Log.e(str2, "[ERROR] :: fail to switch Mode and UI, currentMode: " + GetCurrentMode + ", viewType: viewType");
            net.fxgear.fittingmodenative.b.b bVar = new net.fxgear.fittingmodenative.b.b(this, 1);
            bVar.a("Unknown Error");
            bVar.b("viewType: " + i);
            bVar.c(getResources().getString(a.g.confirm));
            bVar.a((b.a) new b.a() {
                public void b(net.fxgear.fittingmodenative.b.b bVar) {
                }

                public void a(net.fxgear.fittingmodenative.b.b bVar) {
                    bVar.dismiss();
                }
            });
            bVar.show();
        } else if (GetCurrentMode == i2) {
            this.mCurrentViewType = i;
            if (this.mActivityRootView != null) {
                SwitchCurrentUIView();
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            }
            Log.w(TAG, "Activity may be destroyed.");
        } else if (!SetMode(i2, new Runnable() {
            public void run() {
                int unused = FittingActivity.this.mCurrentViewType = i;
                if (FittingActivity.this.mActivityRootView != null) {
                    FittingActivity.this.SwitchCurrentUIView();
                    if (runnable != null) {
                        runnable.run();
                        return;
                    }
                    return;
                }
                Log.w(FittingActivity.TAG, "Activity may be destroyed.");
            }
        })) {
            Log.w(TAG, "Fail SetMode().");
        }
    }

    private void RemoveBottomMenuView() {
        if (this.mBottomContainer != null) {
            int childCount = this.mBottomContainer.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.mBottomContainer.getChildAt(i);
                if (childAt != null) {
                    int i2 = this.mCurrentViewType;
                    if (i2 != 7) {
                        switch (i2) {
                            case 0:
                                break;
                            case 1:
                                if (childAt instanceof net.fxgear.fittingmodenative.c.b) {
                                    ((net.fxgear.fittingmodenative.c.b) childAt).a();
                                    break;
                                }
                                break;
                            case 2:
                            case 3:
                                if (childAt instanceof net.fxgear.fittingmodenative.c.a) {
                                    ((net.fxgear.fittingmodenative.c.a) childAt).a();
                                    break;
                                }
                                break;
                            case 4:
                                if (childAt instanceof net.fxgear.fittingmodenative.c.f) {
                                    ((net.fxgear.fittingmodenative.c.f) childAt).a();
                                    break;
                                }
                                break;
                            case 5:
                                if (childAt instanceof net.fxgear.fittingmodenative.c.c) {
                                    ((net.fxgear.fittingmodenative.c.c) childAt).a();
                                    break;
                                }
                                break;
                        }
                    }
                    boolean z = childAt instanceof h;
                    this.mBottomContainer.removeView(childAt);
                    continue;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void CancelToChangeCustomFace(boolean z, boolean z2) {
        if (z) {
            if (this.mCurrentViewType != 6) {
                CancelToChangeCustomFace();
            }
            if (this.mRequestInfoForCustomFace != null) {
                this.mRequestInfoForCustomFace.c = z2;
            }
            final boolean z3 = this.mRequestInfoForCustomFace != null ? this.mRequestInfoForCustomFace.c : false;
            ShowErrorDialogToDectectFacePoint(z3, new b.a() {
                public void a(net.fxgear.fittingmodenative.b.b bVar) {
                    bVar.dismiss();
                    if (FittingActivity.this.mCurrentViewType != 6) {
                        f unused = FittingActivity.this.mRequestInfoForCustomFace = null;
                    }
                }

                public void b(net.fxgear.fittingmodenative.b.b bVar) {
                    bVar.dismiss();
                    FittingActivity.this.OnShowAvatarFaceCameraView(z3);
                }
            });
            return;
        }
        CancelToChangeCustomFace();
        this.mRequestInfoForCustomFace = null;
    }

    /* access modifiers changed from: private */
    public void CancelToChangeCustomFace() {
        Context applicationContext = getApplicationContext();
        int GetCurrentGender = GetCurrentGender();
        int GetCurrentAge = GetCurrentAge();
        if (!HasCustomFace(GetCurrentGender, GetCurrentAge)) {
            f.f1467a.getClass();
            if (this.mCurrentViewType == 6) {
                ClearCustomFaceFiles();
                AnonymousClass53 r3 = new Runnable() {
                    public void run() {
                        int unused = FittingActivity.this.mCurrentViewType = 1;
                        FittingActivity.this.SwitchCurrentUIView();
                    }
                };
                if (!SetAvatarHeadTypeWithChangeAvatarMode(2, GetDefaultHeadTypeIndex(GetCurrentGender, GetCurrentAge), false, r3)) {
                    Log.e(TAG, "failed to set avatar head type without custom face.");
                    r3.run();
                }
            } else if (this.mCurrentViewType != 1) {
                SwitchCurrentModeAndUIwithViewType(1, (Runnable) null);
            }
        } else {
            String str = this.mRequestInfoForCustomFace != null ? this.mRequestInfoForCustomFace.f1286b : null;
            if (HasBackupCustomFaceData(applicationContext, str)) {
                ClearCustomFaceFiles();
                if (!RestoreBackupCustomFaceData(applicationContext, str)) {
                    Log.e(TAG, "[JE] Failed to restore backup custom face data!");
                    AnonymousClass2 r32 = new Runnable() {
                        public void run() {
                            int unused = FittingActivity.this.mCurrentViewType = 1;
                            FittingActivity.this.SwitchCurrentUIView();
                        }
                    };
                    if (!SetAvatarHeadTypeWithChangeAvatarMode(2, GetDefaultHeadTypeIndex(GetCurrentGender, GetCurrentAge), false, r32)) {
                        Log.e(TAG, "failed to set avatar head type without custom face.");
                        r32.run();
                    }
                } else if (this.mCurrentViewType != 1) {
                    SwitchCurrentModeAndUIwithViewType(1, (Runnable) null);
                }
            } else if (this.mCurrentViewType != 1) {
                SwitchCurrentModeAndUIwithViewType(1, (Runnable) null);
            }
        }
        if (HasBackupCustomFaceData(applicationContext) && !DeleteAllBackupCustomFaceData(applicationContext)) {
            Log.e(TAG, "[JE] Failed to delete all backup custom face data!");
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void UpdateResultOfList(int r12, java.lang.String r13) {
        /*
            r11 = this;
            java.lang.String r2 = TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "UpdateResultOfAvatarList()+, mode: "
            r3.append(r4)
            r3.append(r12)
            java.lang.String r4 = ", jsonDataInfo: "
            r3.append(r4)
            r3.append(r13)
            java.lang.String r3 = r3.toString()
            android.util.Log.i(r2, r3)
            int r9 = r11.mCurrentViewType
            r2 = 0
            if (r13 == 0) goto L_0x00e6
            r3 = 7
            r4 = 2
            r5 = 1
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0070 }
            r6.<init>(r13)     // Catch:{ JSONException -> 0x0070 }
            java.lang.String r0 = "gender"
            int r7 = r6.getInt(r0)     // Catch:{ JSONException -> 0x0070 }
            java.lang.String r0 = "age"
            int r8 = r6.getInt(r0)     // Catch:{ JSONException -> 0x006e }
            java.lang.String r0 = "selected_items_id"
            org.json.JSONObject r0 = r6.getJSONObject(r0)     // Catch:{ JSONException -> 0x006c }
            if (r12 == r5) goto L_0x0045
            if (r12 != r3) goto L_0x0042
            goto L_0x0045
        L_0x0042:
            r6 = 11
            goto L_0x0047
        L_0x0045:
            r6 = 10
        L_0x0047:
            java.lang.String r10 = "woman_item_id"
            int r10 = r0.getInt(r10)     // Catch:{ JSONException -> 0x006c }
            r11.SetSelectedItemID(r6, r5, r4, r10)     // Catch:{ JSONException -> 0x006c }
            java.lang.String r10 = "man_item_id"
            int r10 = r0.getInt(r10)     // Catch:{ JSONException -> 0x006c }
            r11.SetSelectedItemID(r6, r4, r4, r10)     // Catch:{ JSONException -> 0x006c }
            java.lang.String r10 = "girl_item_id"
            int r10 = r0.getInt(r10)     // Catch:{ JSONException -> 0x006c }
            r11.SetSelectedItemID(r6, r5, r5, r10)     // Catch:{ JSONException -> 0x006c }
            java.lang.String r10 = "boy_item_id"
            int r0 = r0.getInt(r10)     // Catch:{ JSONException -> 0x006c }
            r11.SetSelectedItemID(r6, r4, r5, r0)     // Catch:{ JSONException -> 0x006c }
            goto L_0x007d
        L_0x006c:
            r0 = move-exception
            goto L_0x0073
        L_0x006e:
            r0 = move-exception
            goto L_0x0072
        L_0x0070:
            r0 = move-exception
            r7 = 1
        L_0x0072:
            r8 = 2
        L_0x0073:
            java.lang.String r4 = TAG
            java.lang.String r6 = "[ERROR] :: UpdateResultOfAvatarList(), JSONException"
            android.util.Log.e(r4, r6)
            r0.printStackTrace()
        L_0x007d:
            r4 = r8
            if (r12 != r3) goto L_0x0089
            r11.mAvatarSettingViewType = r5
            r11.mCurrentViewType = r5
            r11.GoToAddAvatarView()
            r0 = r12
            goto L_0x008e
        L_0x0089:
            if (r12 != r5) goto L_0x008d
            r0 = 1
            goto L_0x008e
        L_0x008d:
            r0 = 0
        L_0x008e:
            net.fxgear.fittingmodenative.FittingActivity$3 r8 = new net.fxgear.fittingmodenative.FittingActivity$3
            r8.<init>(r0)
            net.fxgear.fittingmodenative.FittingActivity$c r1 = r11.GetFittingData(r7, r4)
            net.fxgear.fittingmodenative.b r3 = r1.f
            r5 = 5
            net.fxgear.FittingView$ClothesFileInfo[] r10 = new net.fxgear.FittingView.ClothesFileInfo[r5]
        L_0x009c:
            int[] r5 = r1.d
            int r5 = r5.length
            if (r2 >= r5) goto L_0x00bf
            int[] r5 = r1.d
            r5 = r5[r2]
            r6 = -1
            if (r5 != r6) goto L_0x00b2
            net.fxgear.FittingView$ClothesFileInfo r5 = new net.fxgear.FittingView$ClothesFileInfo
            r5.<init>()
            r5.mClothType = r2
            r10[r2] = r5
            goto L_0x00bc
        L_0x00b2:
            net.fxgear.fittingmodenative.e r6 = net.fxgear.fittingmodenative.e.a((android.content.Context) r11)
            net.fxgear.FittingView$ClothesFileInfo r5 = r6.e((int) r5)
            r10[r2] = r5
        L_0x00bc:
            int r2 = r2 + 1
            goto L_0x009c
        L_0x00bf:
            int r5 = r3.c
            net.fxgear.AvatarData r1 = r3.k
            int r6 = r1.mAvatarID
            r1 = r11
            r2 = r0
            r3 = r7
            r7 = r10
            boolean r2 = r1.SetModeAndCharacter(r2, r3, r4, r5, r6, r7, r8)
            if (r2 != 0) goto L_0x00ed
            java.lang.String r1 = TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "[ERROR] :: UpdateResultOfList(), failed to set mode and charcter, mode: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            android.util.Log.e(r1, r0)
            goto L_0x00ed
        L_0x00e6:
            java.lang.String r0 = TAG
            java.lang.String r1 = "[ERROR] :: UpdateResultOfList(), jsonDataInfo is null"
            android.util.Log.e(r0, r1)
        L_0x00ed:
            if (r2 != 0) goto L_0x0117
            int r0 = r11.mCurrentViewType
            if (r0 == r9) goto L_0x00f7
            r0 = 0
            r11.SwitchCurrentModeAndUIwithViewType(r9, r0)
        L_0x00f7:
            r2 = 0
            android.content.res.Resources r0 = r11.getResources()
            int r1 = net.fxgear.a.a.g.occurred_error_message
            java.lang.String r3 = r0.getString(r1)
            r4 = 1
            android.content.res.Resources r0 = r11.getResources()
            int r1 = net.fxgear.a.a.g.confirm
            java.lang.String r5 = r0.getString(r1)
            r6 = 0
            net.fxgear.fittingmodenative.FittingActivity$4 r7 = new net.fxgear.fittingmodenative.FittingActivity$4
            r7.<init>()
            r1 = r11
            r1.ShowConfirmDialog(r2, r3, r4, r5, r6, r7)
        L_0x0117:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.FittingActivity.UpdateResultOfList(int, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public String GetStringJsonDataInfoForSelectedItems(int i, boolean z) {
        int i2;
        try {
            JSONObject jSONObject = new JSONObject();
            switch (i) {
                case GlobalDefine.RESULT_CODE_ERROR_FAILED_TO_DETECT_ZERO_FACE:
                    i2 = 10;
                    break;
                case 21:
                case 22:
                    i2 = 11;
                    break;
                default:
                    String str = TAG;
                    Log.e(str, "[ERROR] :: wrong listType: " + i);
                    return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("woman_item_id", GetSelectedItemID(i2, 1, 2));
            jSONObject2.put("man_item_id", GetSelectedItemID(i2, 2, 2));
            jSONObject2.put("girl_item_id", GetSelectedItemID(i2, 1, 1));
            jSONObject2.put("boy_item_id", GetSelectedItemID(i2, 2, 1));
            jSONObject.put("gender", GetCurrentGender());
            jSONObject.put("age", GetCurrentAge());
            jSONObject.put("selected_items_id", jSONObject2);
            jSONObject.put("from_home", z);
            String str2 = TAG;
            Log.e(str2, "GetStringJsonDataInfoForSelectedItems(), jsonString: " + jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException e2) {
            Log.e(TAG, "[ERROR] :: GetStringJsonDataInfoForSelectedItems(), JSONException");
            e2.printStackTrace();
            return null;
        }
    }

    private void SetSelectedItemID(int i, int i2, int i3, int i4) {
        String str = TAG;
        Log.d(str, "SetSelectedItemID()+, selectedItemType: " + i + ", gender: " + i2 + ", age: " + i3 + ", selectedID: " + i4);
        Context applicationContext = getApplicationContext();
        b bVar = GetFittingData(i2, i3).f;
        switch (i) {
            case 10:
                if (FXDataManager.GetInstance(applicationContext).GetAvatarData(i4) == null) {
                    FXUtil.OccurRunTimeException("[NullException] :: avatarData is null, (selectedId: " + i4 + ", gender: " + i2 + ", age: " + i3 + ")");
                }
                bVar.a((Context) this, i4);
                if (!IsValidAvatarData(bVar)) {
                    FXDataManager.GetInstance(applicationContext).UpdateAvatarData(bVar.k);
                    RemoveAvatarThumbnailFile(bVar.d);
                    break;
                }
                break;
            case 11:
                if (!e.a(applicationContext).i(i4)) {
                    FXUtil.OccurRunTimeException("[InvalidException] :: real video id is invalid, (selectedId: " + i4 + ", gender: " + i2 + ", age: " + i3 + ")");
                }
                bVar.c = i4;
                break;
            default:
                String str2 = TAG;
                Log.e(str2, "wrong item type: " + i);
                return;
        }
        bVar.d(this, new File(GlobalDefine.GetCharacterDataDirectory(applicationContext), GlobalDefine.GetCharacterDataFileName(i2, i3)));
    }

    private int GetSelectedItemID(int i, int i2, int i3) {
        switch (i) {
            case 10:
                return GetFittingData(i2, i3).f.k.mAvatarID;
            case 11:
                return GetFittingData(i2, i3).f.c;
            default:
                String str = TAG;
                Log.e(str, "wrong item type: " + i);
                return -1;
        }
    }

    private class b {

        /* renamed from: a  reason: collision with root package name */
        int[] f1280a;

        /* renamed from: b  reason: collision with root package name */
        e f1281b;

        private b() {
        }

        /* synthetic */ b(FittingActivity fittingActivity, AnonymousClass1 r2) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public void AsyncProcessToChangeCustomFace(String str, int i, final e eVar) {
        Log.d(TAG, "AsyncProcessToChangeCustomFace()+");
        if (this.mCustomFaceWorker == null) {
            this.mCustomFaceWorker = new DetectCustomFacePoints.DetectFacePointsThread(this, str, i, GetCurrentGender(), GetCurrentAge(), new DetectCustomFacePoints.OnDetectCustomFaceListener() {
                public void OnStartToDetectCustomFace() {
                    if (eVar != null) {
                        eVar.a();
                    }
                    FittingActivity.this.ShowCircleDialog();
                }

                public void OnFinishToDetectCustomFace(String str, int[] iArr, float[] fArr, int i) {
                    FittingActivity.this.DismissCircleDialog();
                    Thread unused = FittingActivity.this.mCustomFaceWorker = null;
                    if (str != null) {
                        File unused2 = FittingActivity.this.mFaceBitmapFile = new File(str);
                    } else {
                        Log.e(FittingActivity.TAG, "OnFinishToDetectCustomFace(), faceBitmapFilePath is null");
                        File unused3 = FittingActivity.this.mFaceBitmapFile = null;
                    }
                    if (FittingActivity.this.mHandler != null) {
                        b bVar = new b(FittingActivity.this, (AnonymousClass1) null);
                        bVar.f1280a = iArr;
                        bVar.f1281b = eVar;
                        FittingActivity.this.mHandler.obtainMessage(FittingActivity.MSG_CREATE_CUSTOM_FILE, bVar).sendToTarget();
                    }
                }

                public void OnErrorToDetectCustomFace(int i, Object obj) {
                    FittingActivity.this.DismissCircleDialog();
                    Thread unused = FittingActivity.this.mCustomFaceWorker = null;
                    if (eVar != null) {
                        eVar.a(i, obj);
                    }
                }
            });
            this.mCustomFaceWorker.start();
        } else if (eVar != null) {
            eVar.a(2, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public void ProcessToChangeCustomFace(boolean z, String str, int i) {
        String str2 = TAG;
        Log.i(str2, "ProcessToChangeCustomFace()+, fromGallery: " + z + ", imageFilePath: " + str + ", imageOrientation: " + i);
        if (this.mRequestInfoForCustomFace != null) {
            this.mRequestInfoForCustomFace.c = z;
        } else {
            Log.e(TAG, "[ERROR] :: ProcessToChangeCustomFace(), mRequestInfoForCustomFace is null");
        }
        final boolean z2 = this.mRequestInfoForCustomFace != null ? this.mRequestInfoForCustomFace.c : false;
        f.f1467a.getClass();
        int GetCurrentGender = GetCurrentGender();
        int GetCurrentAge = GetCurrentAge();
        if (HasCustomFaceData(GetCurrentGender, GetCurrentAge)) {
            String GetRuntimeCustomFaceDataUUID = GetRuntimeCustomFaceDataUUID(GetCurrentGender, GetCurrentAge);
            if (HasCustomFace(GetCurrentGender, GetCurrentAge) && this.mRequestInfoForCustomFace != null && this.mRequestInfoForCustomFace.f1286b == null) {
                this.mRequestInfoForCustomFace.f1286b = GetRuntimeCustomFaceDataUUID;
            }
            if (!BackupCurrentCustomFaceData(getApplicationContext(), GetRuntimeCustomFaceDataUUID)) {
                Log.e(TAG, "[JE] Failed to back up current custom face data!");
            }
        }
        AsyncProcessToChangeCustomFace(str, i, new e() {
            public void a() {
            }

            public void a(int i, Object obj) {
                if (i != -1) {
                    if (FittingActivity.this.mCurrentViewType != 6) {
                        FittingActivity.this.CancelToChangeCustomFace();
                    } else if (FittingActivity.this.mBottomContainer != null) {
                        int childCount = FittingActivity.this.mBottomContainer.getChildCount();
                        int i2 = 0;
                        while (true) {
                            if (i2 < childCount) {
                                View childAt = FittingActivity.this.mBottomContainer.getChildAt(i2);
                                if (childAt != null && (childAt instanceof g)) {
                                    ((g) childAt).a(z2);
                                    break;
                                }
                                i2++;
                            } else {
                                break;
                            }
                        }
                    }
                    if (i == 4) {
                        long j = 0;
                        if (obj != null && (obj instanceof Long)) {
                            j = ((Long) obj).longValue();
                        }
                        FittingActivity.this.ShowNoSpaceErrorDialog(j, new b.a() {
                            public void b(net.fxgear.fittingmodenative.b.b bVar) {
                            }

                            public void a(net.fxgear.fittingmodenative.b.b bVar) {
                                if (FittingActivity.this.mConfirmDialog != null) {
                                    FittingActivity.this.mConfirmDialog.dismiss();
                                    net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                                }
                            }
                        });
                        if (FittingActivity.this.mCurrentViewType != 6) {
                            f unused = FittingActivity.this.mRequestInfoForCustomFace = null;
                            return;
                        }
                        return;
                    }
                    FittingActivity.this.ShowErrorDialogToDectectFacePoint(z2, new b.a() {
                        public void a(net.fxgear.fittingmodenative.b.b bVar) {
                            bVar.dismiss();
                            if (FittingActivity.this.mCurrentViewType != 6) {
                                f unused = FittingActivity.this.mRequestInfoForCustomFace = null;
                            }
                        }

                        public void b(net.fxgear.fittingmodenative.b.b bVar) {
                            bVar.dismiss();
                            FittingActivity.this.OnShowAvatarFaceCameraView(z2);
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void ShowNoSpaceErrorDialog(long j, b.a aVar) {
        Resources resources = getResources();
        String string = resources.getString(a.g.out_of_memory_title);
        String a2 = f.a(j);
        ShowConfirmDialog(string, String.format(getResources().getString(a.g.out_of_memory_message), new Object[]{a2}), 1, resources.getString(a.g.confirm), (String) null, aVar);
    }

    /* access modifiers changed from: private */
    public void ShowErrorDialogToDectectFacePoint(boolean z, b.a aVar) {
        String str;
        String str2;
        net.fxgear.fittingmodenative.b.b bVar = new net.fxgear.fittingmodenative.b.b(this, 2);
        Resources resources = getResources();
        if (z) {
            str = resources.getString(a.g.face_config_recog_failed_reselect);
            str2 = resources.getString(a.g.face_config_select_again);
        } else {
            str = resources.getString(a.g.face_config_recog_failed_retake_photo);
            str2 = resources.getString(a.g.face_config_take_photo_again);
        }
        String string = resources.getString(a.g.cancel);
        bVar.a(false);
        bVar.b(str);
        bVar.d(str2);
        bVar.c(string);
        bVar.a(aVar);
        bVar.show();
    }

    private boolean HasClothesItemForRequest() {
        c GetFittingData;
        ArrayList arrayList;
        Log.d(TAG, "HasClothesItemForRequest()+");
        if (!(this.mFittingDataList == null || (GetFittingData = GetFittingData(GetCurrentGender(), GetCurrentAge())) == null)) {
            if (GetFittingData.f1282a == 0) {
                arrayList = GetFittingData.e.get(-1);
            } else {
                arrayList = GetFittingData.e.get(Integer.valueOf(GetFittingData.f1283b.get(GetFittingData.f1282a).f1355a));
            }
            for (int i = 0; i < arrayList.size(); i++) {
                e.a aVar = (e.a) arrayList.get(i);
                if (aVar.i != null && aVar.i.e == -1) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void UpdateClothesAndCategoryList() {
        ArrayList arrayList;
        if (this.mFittingDataList != null) {
            c GetFittingData = GetFittingData(GetCurrentGender(), GetCurrentAge());
            if (GetFittingData != null) {
                this.mMainClothesAndCategoryListView.a(GetFittingData.f1283b, GetFittingData.f1282a);
                int i = GetFittingData.f1283b.get(GetFittingData.f1282a).f1355a;
                if (GetFittingData.f1282a == 0) {
                    arrayList = GetFittingData.e.get(-1);
                } else {
                    arrayList = GetFittingData.e.get(Integer.valueOf(i));
                }
                SetClothesListViewItems(arrayList, GetFittingData.d);
                return;
            }
            Log.e(TAG, "ERROR :: Not found fittingData.");
        }
    }

    private void SetClothesListViewItems(final ArrayList<e.a> arrayList, int[] iArr) {
        boolean z;
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                e.a aVar = arrayList.get(i);
                if (aVar != null) {
                    if (iArr != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= iArr.length) {
                                break;
                            } else if (aVar.i.f1461a == iArr[i2]) {
                                z = true;
                                break;
                            } else {
                                i2++;
                            }
                        }
                        aVar.g = z;
                    }
                    z = false;
                    aVar.g = z;
                }
            }
            if (f.a(getApplicationContext())) {
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    e.a aVar2 = arrayList.get(i3);
                    if (aVar2.i.e == -1) {
                        arrayList2.add(Integer.valueOf(aVar2.f1366a));
                    }
                }
                if (!arrayList2.isEmpty()) {
                    int[] iArr2 = new int[arrayList2.size()];
                    for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                        iArr2[i4] = ((Integer) arrayList2.get(i4)).intValue();
                    }
                    net.fxgear.fittingmodenative.d.e.a((Context) this, iArr2, (e.a.C0051a) new e.a.C0051a() {
                        public void a(ArrayList<e.a> arrayList) {
                            if (FittingActivity.this.mCircleDialog != null) {
                                if (FittingActivity.this.mCircleDialog.isShowing()) {
                                    FittingActivity.this.mCircleDialog.dismiss();
                                }
                                net.fxgear.fittingmodenative.b.a unused = FittingActivity.this.mCircleDialog = null;
                            }
                            for (int i = 0; i < arrayList.size(); i++) {
                                e.a aVar = (e.a) arrayList.get(i);
                                if (aVar.i.e == -1) {
                                    aVar.i = FittingActivity.this.FindClothesData(arrayList, aVar.f1366a);
                                }
                            }
                            FittingActivity.this.mMainClothesAndCategoryListView.a((ArrayList<e.a>) arrayList);
                        }

                        public void a() {
                            if (FittingActivity.this.mCircleDialog == null) {
                                net.fxgear.fittingmodenative.b.a unused = FittingActivity.this.mCircleDialog = new net.fxgear.fittingmodenative.b.a(FittingActivity.this, 0);
                            }
                            if (FittingActivity.this.mCircleDialog != null) {
                                FittingActivity.this.mCircleDialog.show();
                            }
                        }
                    });
                    return;
                }
                this.mMainClothesAndCategoryListView.a(arrayList);
                return;
            }
            this.mMainClothesAndCategoryListView.a(arrayList);
            return;
        }
        Log.e(TAG, "SetClothesList(), [ERROR] :: clothesList is null");
    }

    /* access modifiers changed from: private */
    public void ShowAllFittingTools(boolean z) {
        if (z) {
            if (this.mLeftOptionButton != null) {
                int i = this.mCurrentViewType;
                if (i != 0) {
                    if (i != 7) {
                        this.mLeftOptionButton.setVisibility(8);
                    } else {
                        this.mLeftOptionButton.setVisibility(0);
                        this.mCheckingClothesLayout.setVisibility(0);
                    }
                } else if (GetCurrentMode() != 1) {
                    this.mLeftOptionButton.setVisibility(8);
                } else if (GetCurrentAge() == 1) {
                    this.mLeftOptionButton.setVisibility(8);
                } else {
                    this.mLeftOptionButton.setVisibility(0);
                }
            }
            if (this.mFirstROptionButton != null) {
                int i2 = this.mCurrentViewType;
                if (i2 == 0 || i2 == 7) {
                    this.mFirstROptionButton.setVisibility(0);
                } else {
                    this.mFirstROptionButton.setVisibility(8);
                }
            }
            if (this.mSecondROptionButton != null) {
                int i3 = this.mCurrentViewType;
                if (i3 != 0) {
                    if (i3 != 7) {
                        this.mSecondROptionButton.setVisibility(8);
                    } else {
                        this.mSecondROptionButton.setVisibility(0);
                    }
                } else if (GetCurrentMode() == 1) {
                    this.mSecondROptionButton.setVisibility(0);
                } else {
                    this.mSecondROptionButton.setVisibility(8);
                }
            }
            if (this.mThirdROptionButton != null) {
                int i4 = this.mCurrentViewType;
                if (i4 != 0) {
                    if (i4 != 7) {
                        this.mThirdROptionButton.setVisibility(8);
                    } else {
                        this.mThirdROptionButton.setVisibility(0);
                    }
                } else if (GetCurrentMode() == 1) {
                    this.mThirdROptionButton.setVisibility(0);
                } else {
                    this.mThirdROptionButton.setVisibility(8);
                }
            }
            if (this.mTakeOffAllClothesButton != null) {
                int i5 = this.mCurrentViewType;
                if (i5 == 0 || i5 == 7) {
                    this.mTakeOffAllClothesButton.setVisibility(0);
                } else {
                    this.mTakeOffAllClothesButton.setVisibility(8);
                }
            }
            if (this.mBottomContainer != null) {
                this.mBottomContainer.setVisibility(0);
            }
            this.mIsShowingAllFittingTools = true;
            return;
        }
        if (this.mCheckingClothesLayout != null) {
            this.mCheckingClothesLayout.setVisibility(8);
        }
        if (this.mLeftOptionButton != null) {
            this.mLeftOptionButton.setVisibility(8);
        }
        if (this.mFirstROptionButton != null) {
            this.mFirstROptionButton.setVisibility(8);
        }
        if (this.mSecondROptionButton != null) {
            this.mSecondROptionButton.setVisibility(8);
        }
        if (this.mThirdROptionButton != null) {
            this.mThirdROptionButton.setVisibility(8);
        }
        if (this.mTakeOffAllClothesButton != null) {
            this.mTakeOffAllClothesButton.setVisibility(8);
        }
        if (this.mBottomContainer != null) {
            this.mBottomContainer.setVisibility(8);
        }
        this.mIsShowingAllFittingTools = false;
    }

    public void onClick(View view) {
        if (this.mConfirmDialog != null || this.mCircleDialog != null || IsWorkingFittingView()) {
            Log.e(TAG, "onClick - FittingView is working");
        } else if ((this.mDownloadClothDataTask == null || this.mDownloadClothDataTask.getStatus() != AsyncTask.Status.RUNNING) && view != null) {
            int id = view.getId();
            if (id == a.e.fitting_room_left_option_button) {
                int i = this.mCurrentViewType;
                if (i != 0) {
                    if (i == 7) {
                        this.mAvatarSettingViewType = 2;
                        SwitchCurrentModeAndUIwithViewType(1, (Runnable) null);
                    }
                } else if (GetCurrentMode() == 1) {
                    ResetClothesSize();
                    SwitchCurrentModeAndUIwithViewType(7, new Runnable() {
                        public void run() {
                            FittingActivity.this.SetClosestSizeToFittingClothes();
                        }
                    });
                }
            } else if (id == a.e.fitting_room_first_option_button) {
                switch (this.mCurrentViewType) {
                    case 0:
                        if (GetCurrentMode() == 0) {
                            GoToMirrorVideoList();
                            return;
                        } else {
                            GoToAvatarList();
                            return;
                        }
                    case 1:
                        Resources resources = getResources();
                        ShowConfirmDialog((String) null, resources.getString(a.g.face_config_alert_initialize), 2, resources.getString(a.g.confirm), resources.getString(a.g.cancel), new b.a() {
                            public void a(net.fxgear.fittingmodenative.b.b bVar) {
                                if (FittingActivity.this.mConfirmDialog != null) {
                                    FittingActivity.this.mConfirmDialog.dismiss();
                                    net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                                }
                                final int GetCurrentGender = FittingActivity.this.GetCurrentGender();
                                final int GetCurrentAge = FittingActivity.this.GetCurrentAge();
                                final int access$3000 = FittingActivity.this.GetDefaultHeadTypeIndex(GetCurrentGender, GetCurrentAge);
                                if (!FittingActivity.this.SetDefaultAvatarFace(access$3000, new Runnable() {
                                    public void run() {
                                        FittingActivity.this.mFirstROptionButton.setVisibility(8);
                                        FittingActivity.this.ProcessGetScreenShot(false, false, false, new Runnable() {
                                            public void run() {
                                                FittingActivity.this.ClearCustomFaceFiles();
                                                b bVar = FittingActivity.this.GetFittingData(GetCurrentGender, GetCurrentAge).f;
                                                bVar.k.mIsCustomFace = false;
                                                bVar.k.mHeadType = FittingActivity.this.GetHeadTypeByIndex(access$3000, bVar.f1310b, bVar.f1309a);
                                                bVar.k.mAutoNormalizedColor = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                                                bVar.k.mHueRGBColor = -1;
                                                if (!FittingActivity.this.ClearAllAvatarDataFilesAndUpdateDB(bVar.k)) {
                                                    Log.e(FittingActivity.TAG, "[ERROR] :: onClick - init custom face, ClearAllAvatarDataFilesAndUpdateDB");
                                                }
                                            }
                                        });
                                    }
                                })) {
                                    Log.e(FittingActivity.TAG, "failed to set avatar head type without custom face.");
                                }
                            }

                            public void b(net.fxgear.fittingmodenative.b.b bVar) {
                                if (FittingActivity.this.mConfirmDialog != null) {
                                    FittingActivity.this.mConfirmDialog.dismiss();
                                    net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                                }
                            }
                        });
                        return;
                    case 4:
                        Log.d(TAG, "onClick - Reset skin tone");
                        int childCount = this.mBottomContainer.getChildCount();
                        for (int i2 = 0; i2 < childCount; i2++) {
                            View childAt = this.mBottomContainer.getChildAt(i2);
                            if (childAt != null && (childAt instanceof net.fxgear.fittingmodenative.c.f)) {
                                SetAvatarSkinToneWithAuto(net.fxgear.fittingmodenative.c.f.f1379a, 0.5f, true, (Runnable) null);
                                net.fxgear.fittingmodenative.c.f fVar = (net.fxgear.fittingmodenative.c.f) childAt;
                                fVar.a(10, 0.5f);
                                fVar.a(11, net.fxgear.fittingmodenative.c.f.f1379a);
                            }
                        }
                        return;
                    case 5:
                        Log.d(TAG, "onClick - Reset body size");
                        int childCount2 = this.mBottomContainer.getChildCount();
                        int i3 = 0;
                        while (i3 < childCount2) {
                            View childAt2 = this.mBottomContainer.getChildAt(i3);
                            if (childAt2 == null || !(childAt2 instanceof net.fxgear.fittingmodenative.c.c)) {
                                i3++;
                            } else if (SetBodySizeAll(GetDefaultBodySizeData(GetCurrentGender(), GetCurrentAge()), (Runnable) null)) {
                                net.fxgear.fittingmodenative.c.c cVar = (net.fxgear.fittingmodenative.c.c) childAt2;
                                cVar.a(false, -1);
                                cVar.a(GetCurrentBodySizeAll());
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    default:
                        return;
                }
            } else if (id == a.e.fitting_room_second_option_button) {
                if (this.mCurrentViewType == 0 && GetCurrentMode() == 1) {
                    SwitchCurrentModeAndUIwithViewType(1, (Runnable) null);
                }
            } else if (id == a.e.fitting_room_third_option_button) {
                if (this.mCurrentViewType == 0) {
                    boolean GetAnimationPause = this.mFittingView.GetAnimationPause();
                    this.mFittingView.SetAnimationPause(!GetAnimationPause);
                    if (GetAnimationPause) {
                        this.mThirdROptionButton.setBackgroundResource(a.d.btn_avatar_pause);
                    } else {
                        this.mThirdROptionButton.setBackgroundResource(a.d.btn_avatar_resume);
                    }
                }
            } else if (id == a.e.checking_size_first_radio_button) {
                if (this.mCurrentViewType == 7) {
                    SetSelectedButtonForClothesVisualization(GlobalDefine.ClothesVisualizationOption.Color);
                    if (this.mFittingView != null) {
                        this.mFittingView.SetClothesRenderingOption(GlobalDefine.ClothesVisualizationOption.Color);
                    }
                }
            } else if (id == a.e.checking_size_second_radio_button) {
                if (this.mCurrentViewType == 7) {
                    SetSelectedButtonForClothesVisualization(GlobalDefine.ClothesVisualizationOption.Tension);
                    if (this.mFittingView != null) {
                        this.mFittingView.SetClothesRenderingOption(GlobalDefine.ClothesVisualizationOption.Tension);
                    }
                }
            } else if (id == a.e.checking_size_third_radio_button) {
                if (this.mCurrentViewType == 7) {
                    SetSelectedButtonForClothesVisualization(GlobalDefine.ClothesVisualizationOption.Pressure);
                    if (this.mFittingView != null) {
                        this.mFittingView.SetClothesRenderingOption(GlobalDefine.ClothesVisualizationOption.Pressure);
                    }
                }
            } else if (id == a.e.fitting_room_take_off_all_clothes_button) {
                SetClothes(FittingView.EMPTY_CLOTHES, (Runnable) null);
            }
        }
    }

    private void SetSelectedButtonForClothesVisualization(GlobalDefine.ClothesVisualizationOption clothesVisualizationOption) {
        if (this.mFirstRadioButton != null && this.mSecondRadioButton != null && this.mThirdRadioButton != null) {
            if (clothesVisualizationOption == GlobalDefine.ClothesVisualizationOption.Tension) {
                this.mSecondRadioButton.setChecked(true);
            } else if (clothesVisualizationOption == GlobalDefine.ClothesVisualizationOption.Pressure) {
                this.mThirdRadioButton.setChecked(true);
            } else {
                this.mFirstRadioButton.setChecked(true);
            }
        }
    }

    private void ShowNoticeToTakeFacePicture(final int i) {
        Log.d(TAG, "ShowNoticeToTakeFacePicture()+");
        String str = null;
        if (this.mNoticeToTakeFacePictureLayout == null) {
            this.mNoticeToTakeFacePictureLayout = (LinearLayout) LayoutInflater.from(this).inflate(a.f.layout_need_to_take_face_picture, (ViewGroup) null);
            ((Button) this.mNoticeToTakeFacePictureLayout.findViewById(a.e.cancel_to_take_pic_btn)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (FittingActivity.this.mNoticeToTakeFacePictureLayout != null) {
                        if (FittingActivity.this.mActivityRootView != null) {
                            FittingActivity.this.mActivityRootView.removeView(FittingActivity.this.mNoticeToTakeFacePictureLayout);
                        }
                        LinearLayout unused = FittingActivity.this.mNoticeToTakeFacePictureLayout = null;
                    }
                }
            });
            ((Button) this.mNoticeToTakeFacePictureLayout.findViewById(a.e.ok_to_take_pic_btn)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    boolean z;
                    final ArrayList arrayList = new ArrayList();
                    if (Build.VERSION.SDK_INT >= 23) {
                        if (android.support.v4.b.a.a(FittingActivity.this.getApplicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
                            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                            z = false;
                        } else {
                            z = true;
                        }
                        if (android.support.v4.b.a.a(FittingActivity.this.getApplicationContext(), "android.permission.CAMERA") == -1) {
                            arrayList.add("android.permission.CAMERA");
                            z = false;
                        }
                    } else {
                        z = true;
                    }
                    if (z) {
                        if (FittingActivity.this.mNoticeToTakeFacePictureLayout != null) {
                            if (FittingActivity.this.mActivityRootView != null) {
                                FittingActivity.this.mActivityRootView.removeView(FittingActivity.this.mNoticeToTakeFacePictureLayout);
                            }
                            LinearLayout unused = FittingActivity.this.mNoticeToTakeFacePictureLayout = null;
                        }
                        f unused2 = FittingActivity.this.mRequestInfoForCustomFace = new f(FittingActivity.this, (AnonymousClass1) null);
                        FittingActivity.this.mRequestInfoForCustomFace.f1285a = i;
                        FittingActivity.this.mRequestInfoForCustomFace.c = false;
                        FittingActivity.this.OnShowAvatarFaceCameraView(FittingActivity.this.mRequestInfoForCustomFace.c);
                        return;
                    }
                    FittingActivity.this.SwitchCurrentModeAndUIwithViewType(1, new Runnable() {
                        public void run() {
                            if (FittingActivity.this.mNoticeToTakeFacePictureLayout != null) {
                                if (FittingActivity.this.mActivityRootView != null) {
                                    FittingActivity.this.mActivityRootView.removeView(FittingActivity.this.mNoticeToTakeFacePictureLayout);
                                }
                                LinearLayout unused = FittingActivity.this.mNoticeToTakeFacePictureLayout = null;
                            }
                        }
                    });
                    net.fxgear.fittingmodenative.b.b bVar = new net.fxgear.fittingmodenative.b.b(FittingActivity.this, 2);
                    bVar.a((String) null);
                    bVar.b(FittingActivity.this.getResources().getString(a.g.camera_access_required));
                    bVar.c(FittingActivity.this.getResources().getString(a.g.confirm));
                    bVar.d(FittingActivity.this.getResources().getString(a.g.cancel));
                    bVar.a((b.a) new b.a() {
                        public void a(net.fxgear.fittingmodenative.b.b bVar) {
                            android.support.v4.a.a.a(FittingActivity.this, (String[]) arrayList.toArray(new String[0]), 0);
                            bVar.dismiss();
                        }

                        public void b(net.fxgear.fittingmodenative.b.b bVar) {
                            bVar.dismiss();
                        }
                    });
                    bVar.show();
                }
            });
        }
        if (i == 2) {
            str = getResources().getString(a.g.face_config_before_change_shape);
        } else if (i == 4) {
            str = getResources().getString(a.g.face_config_before_change_skin);
        }
        ((TextView) this.mNoticeToTakeFacePictureLayout.findViewById(a.e.need_to_take_face_pic_first_text_view)).setText(str);
        if (this.mActivityRootView != null) {
            this.mNoticeToTakeFacePictureLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mActivityRootView.addView(this.mNoticeToTakeFacePictureLayout);
        }
    }

    public void onBackPressed() {
        boolean z;
        if (this.mCircleDialog != null || IsWorkingFittingView()) {
            Log.e(TAG, "onBackPressed - FittingView is working");
        } else if (this.mCurrentViewType == 2 || this.mCurrentViewType == 3 || this.mCurrentViewType == 4 || this.mCurrentViewType == 5) {
            CancelAvatarSettingMenuItem(this.mCurrentViewType);
        } else {
            final int i = 1;
            boolean z2 = false;
            if (this.mCurrentViewType == 6) {
                boolean z3 = this.mRequestInfoForCustomFace != null ? this.mRequestInfoForCustomFace.c : false;
                final ArrayList arrayList = new ArrayList();
                if (Build.VERSION.SDK_INT >= 23) {
                    if (android.support.v4.b.a.a(getApplicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
                        arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                        z = false;
                    } else {
                        z = true;
                    }
                    if (android.support.v4.b.a.a(getApplicationContext(), "android.permission.CAMERA") == -1) {
                        arrayList.add("android.permission.CAMERA");
                    } else {
                        z2 = z;
                    }
                } else {
                    z2 = true;
                }
                if (z2) {
                    OnShowAvatarFaceCameraView(z3);
                    return;
                }
                if (z3) {
                    i = 2;
                }
                net.fxgear.fittingmodenative.b.b bVar = new net.fxgear.fittingmodenative.b.b(this, 2);
                bVar.a((String) null);
                bVar.b(getResources().getString(a.g.camera_access_required));
                bVar.c(getResources().getString(a.g.confirm));
                bVar.d(getResources().getString(a.g.cancel));
                bVar.a((b.a) new b.a() {
                    public void a(net.fxgear.fittingmodenative.b.b bVar) {
                        android.support.v4.a.a.a(FittingActivity.this, (String[]) arrayList.toArray(new String[0]), i);
                        bVar.dismiss();
                    }

                    public void b(net.fxgear.fittingmodenative.b.b bVar) {
                        bVar.dismiss();
                    }
                });
                bVar.show();
            } else if (this.mCurrentViewType == 1) {
                final int GetCurrentGender = GetCurrentGender();
                final int GetCurrentAge = GetCurrentAge();
                if (!HasAvatarThumbnailFile(GetFittingData(GetCurrentGender, GetCurrentAge).f.k.mAvatarID)) {
                    ProcessGetScreenShot(false, false, false, new Runnable() {
                        public void run() {
                            if (!FittingActivity.this.SaveAvatarThumbnailFileAndUpdateDB(FittingActivity.this.GetFittingData(GetCurrentGender, GetCurrentAge).f.k)) {
                                Log.e(FittingActivity.TAG, "[ERROR] :: onBackPressed, SaveAvatarThumbnailFileAndUpdateDB");
                                FittingActivity.this.ShowConfirmDialog((String) null, FittingActivity.this.getResources().getString(a.g.occurred_error_message), 1, FittingActivity.this.getResources().getString(a.g.confirm), (String) null, new b.a() {
                                    public void b(net.fxgear.fittingmodenative.b.b bVar) {
                                    }

                                    public void a(net.fxgear.fittingmodenative.b.b bVar) {
                                        if (FittingActivity.this.mConfirmDialog != null) {
                                            FittingActivity.this.mConfirmDialog.dismiss();
                                            net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                                        }
                                    }
                                });
                            } else if (FittingActivity.this.mAvatarSettingViewType == 1) {
                                FittingActivity.this.OnShowItemList(20, FittingActivity.this.GetStringJsonDataInfoForSelectedItems(20, false));
                                int unused = FittingActivity.this.mAvatarSettingViewType = 0;
                            } else {
                                FittingActivity.this.SwitchCurrentModeAndUIwithViewType(0, (Runnable) null);
                                int unused2 = FittingActivity.this.mAvatarSettingViewType = 0;
                            }
                        }
                    });
                } else if (this.mAvatarSettingViewType == 1) {
                    OnShowItemList(20, GetStringJsonDataInfoForSelectedItems(20, false));
                    this.mAvatarSettingViewType = 0;
                } else {
                    SwitchCurrentModeAndUIwithViewType(0, (Runnable) null);
                    this.mAvatarSettingViewType = 0;
                }
            } else {
                super.onBackPressed();
            }
        }
    }

    private void GoToMirrorVideoList() {
        if (f.a(getApplicationContext())) {
            OnShowItemList(21, GetStringJsonDataInfoForSelectedItems(21, false));
            return;
        }
        ShowConfirmDialog(getResources().getString(a.g.network_error_title), getResources().getString(a.g.network_error_message), 1, getResources().getString(a.g.confirm), (String) null, new b.a() {
            public void a(net.fxgear.fittingmodenative.b.b bVar) {
                if (FittingActivity.this.mConfirmDialog != null) {
                    FittingActivity.this.mConfirmDialog.dismiss();
                    net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                }
            }

            public void b(net.fxgear.fittingmodenative.b.b bVar) {
                if (FittingActivity.this.mConfirmDialog != null) {
                    FittingActivity.this.mConfirmDialog.dismiss();
                    net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                }
            }
        });
    }

    private void GoToAvatarList() {
        final int GetCurrentGender = GetCurrentGender();
        final int GetCurrentAge = GetCurrentAge();
        if (!HasAvatarThumbnailFile(GetFittingData(GetCurrentGender, GetCurrentAge).f.k.mAvatarID)) {
            ProcessGetScreenShot(false, false, false, new Runnable() {
                public void run() {
                    if (FittingActivity.this.SaveAvatarThumbnailFileAndUpdateDB(FittingActivity.this.GetFittingData(GetCurrentGender, GetCurrentAge).f.k)) {
                        FittingActivity.this.OnShowItemList(20, FittingActivity.this.GetStringJsonDataInfoForSelectedItems(20, false));
                        return;
                    }
                    Log.e(FittingActivity.TAG, "[ERROR] :: GoToAvatarList, SaveAvatarThumbnailFileAndUpdateDB");
                    FittingActivity.this.ShowConfirmDialog((String) null, FittingActivity.this.getResources().getString(a.g.occurred_error_message), 1, FittingActivity.this.getResources().getString(a.g.confirm), (String) null, new b.a() {
                        public void b(net.fxgear.fittingmodenative.b.b bVar) {
                        }

                        public void a(net.fxgear.fittingmodenative.b.b bVar) {
                            if (FittingActivity.this.mConfirmDialog != null) {
                                FittingActivity.this.mConfirmDialog.dismiss();
                                net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                            }
                        }
                    });
                }
            });
        } else {
            OnShowItemList(20, GetStringJsonDataInfoForSelectedItems(20, false));
        }
    }

    private BodySizeData GetDefaultBodySizeData(int i, int i2) {
        BodySizeData bodySizeData = new BodySizeData();
        bodySizeData.mTallSize = (float) AvatarSetting.GetDefaultOfBodyPart(this, i, i2, 0);
        bodySizeData.mUpperSize = (float) AvatarSetting.GetDefaultOfBodyPart(this, i, i2, 5);
        bodySizeData.mLowerSize = (float) AvatarSetting.GetDefaultOfBodyPart(this, i, i2, 6);
        bodySizeData.mShoulderSize = (float) AvatarSetting.GetDefaultOfBodyPart(this, i, i2, 1);
        bodySizeData.mBustSize = (float) AvatarSetting.GetDefaultOfBodyPart(this, i, i2, 7);
        bodySizeData.mCupSize = (float) AvatarSetting.GetDefaultOfBodyPart(this, i, i2, 8);
        bodySizeData.mWaistSize = (float) AvatarSetting.GetDefaultOfBodyPart(this, i, i2, 9);
        bodySizeData.mHipSize = (float) AvatarSetting.GetDefaultOfBodyPart(this, i, i2, 11);
        bodySizeData.mArmLengthSize = (float) AvatarSetting.GetDefaultOfBodyPart(this, i, i2, 2);
        bodySizeData.mArmThickSize = (float) AvatarSetting.GetDefaultOfBodyPart(this, i, i2, 10);
        bodySizeData.mThighLengthSize = (float) AvatarSetting.GetDefaultOfBodyPart(this, i, i2, 3);
        bodySizeData.mThighThickSize = (float) AvatarSetting.GetDefaultOfBodyPart(this, i, i2, 12);
        bodySizeData.mCalfLengthSize = (float) AvatarSetting.GetDefaultOfBodyPart(this, i, i2, 4);
        bodySizeData.mHeadHeight = 20.0f;
        return bodySizeData;
    }

    /* access modifiers changed from: protected */
    public int[] GetFittingClotehsArray(int i, int i2) {
        return GetFittingData(i, i2).d;
    }

    private void RequestClothData(int[] iArr, e.a.C0051a aVar) {
        if (this.mClothDataTask == null || this.mClothDataTask.getStatus() != AsyncTask.Status.RUNNING) {
            this.mClothDataTask = net.fxgear.fittingmodenative.d.e.a((Context) this, iArr, aVar);
        }
    }

    /* access modifiers changed from: private */
    public void DownloadClothesData(final e.a aVar) {
        if (!f.a(getApplicationContext())) {
            ShowOfflineModeView();
            Resources resources = getResources();
            ShowConfirmDialog(resources.getString(a.g.network_error_title), resources.getString(a.g.network_error_message), 2, resources.getString(a.g.retry), resources.getString(a.g.cancel), new b.a() {
                public void a(net.fxgear.fittingmodenative.b.b bVar) {
                    if (FittingActivity.this.mConfirmDialog != null) {
                        FittingActivity.this.mConfirmDialog.dismiss();
                        net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                    }
                    FittingActivity.this.DownloadClothesData(aVar);
                }

                public void b(net.fxgear.fittingmodenative.b.b bVar) {
                    if (FittingActivity.this.mConfirmDialog != null) {
                        FittingActivity.this.mConfirmDialog.dismiss();
                        net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                    }
                    if (FittingActivity.this.mMainClothesAndCategoryListView != null) {
                        FittingActivity.this.mMainClothesAndCategoryListView.b(aVar);
                    }
                }
            });
        } else if (this.mDownloadClothDataTask != null && this.mDownloadClothDataTask.getStatus() == AsyncTask.Status.RUNNING) {
        } else {
            if (!IsWorkingFittingView()) {
                final AnonymousClass16 r0 = new e.C0053e() {
                    public void a(int i) {
                        if (FittingActivity.this.mMainClothesAndCategoryListView != null) {
                            FittingActivity.this.mMainClothesAndCategoryListView.a(aVar, 0);
                        }
                    }

                    public void a(int i, int i2, int i3) {
                        if (FittingActivity.this.mMainClothesAndCategoryListView != null) {
                            FittingActivity.this.mMainClothesAndCategoryListView.a(aVar, i3);
                        }
                    }

                    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003e, code lost:
                        r9 = 1;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void a(net.fxgear.GlobalDefine.Result r14) {
                        /*
                            r13 = this;
                            net.fxgear.fittingmodenative.FittingActivity r0 = net.fxgear.fittingmodenative.FittingActivity.this
                            net.fxgear.fittingmodenative.c.h r0 = r0.mMainClothesAndCategoryListView
                            r1 = 0
                            if (r0 == 0) goto L_0x009a
                            int r0 = r14.resultCode
                            r2 = -1
                            if (r0 != r2) goto L_0x001b
                            net.fxgear.fittingmodenative.FittingActivity r14 = net.fxgear.fittingmodenative.FittingActivity.this
                            net.fxgear.fittingmodenative.c.h r14 = r14.mMainClothesAndCategoryListView
                            net.fxgear.fittingmodenative.c.e$a r0 = r10
                            r14.a((net.fxgear.fittingmodenative.c.e.a) r0)
                            goto L_0x009a
                        L_0x001b:
                            net.fxgear.fittingmodenative.FittingActivity r0 = net.fxgear.fittingmodenative.FittingActivity.this
                            net.fxgear.fittingmodenative.c.h r0 = r0.mMainClothesAndCategoryListView
                            net.fxgear.fittingmodenative.c.e$a r2 = r10
                            r0.b((net.fxgear.fittingmodenative.c.e.a) r2)
                            net.fxgear.fittingmodenative.FittingActivity r0 = net.fxgear.fittingmodenative.FittingActivity.this
                            android.content.res.Resources r0 = r0.getResources()
                            int r2 = r14.resultCode
                            r3 = 10
                            r4 = 1
                            if (r2 == r3) goto L_0x0066
                            switch(r2) {
                                case 0: goto L_0x0040;
                                case 1: goto L_0x0040;
                                case 2: goto L_0x0040;
                                case 3: goto L_0x0040;
                                case 4: goto L_0x0040;
                                default: goto L_0x0036;
                            }
                        L_0x0036:
                            switch(r2) {
                                case 13: goto L_0x0066;
                                case 14: goto L_0x0066;
                                default: goto L_0x0039;
                            }
                        L_0x0039:
                            r7 = r1
                            r8 = r7
                            r10 = r8
                            r11 = r10
                            r12 = r11
                        L_0x003e:
                            r9 = 1
                            goto L_0x008f
                        L_0x0040:
                            java.lang.String r2 = "Unknown Error"
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder
                            r3.<init>()
                            java.lang.String r5 = "Error code : "
                            r3.append(r5)
                            int r14 = r14.resultCode
                            r3.append(r14)
                            java.lang.String r14 = r3.toString()
                            int r3 = net.fxgear.a.a.g.confirm
                            java.lang.String r0 = r0.getString(r3)
                            net.fxgear.fittingmodenative.FittingActivity$16$2 r3 = new net.fxgear.fittingmodenative.FittingActivity$16$2
                            r3.<init>()
                            r8 = r14
                            r10 = r0
                            r11 = r1
                            r7 = r2
                            r12 = r3
                            goto L_0x003e
                        L_0x0066:
                            net.fxgear.fittingmodenative.FittingActivity r14 = net.fxgear.fittingmodenative.FittingActivity.this
                            r14.ShowOfflineModeView()
                            int r14 = net.fxgear.a.a.g.network_error_title
                            java.lang.String r14 = r0.getString(r14)
                            int r2 = net.fxgear.a.a.g.network_error_message
                            java.lang.String r2 = r0.getString(r2)
                            r4 = 2
                            int r3 = net.fxgear.a.a.g.retry
                            java.lang.String r3 = r0.getString(r3)
                            int r5 = net.fxgear.a.a.g.cancel
                            java.lang.String r0 = r0.getString(r5)
                            net.fxgear.fittingmodenative.FittingActivity$16$1 r5 = new net.fxgear.fittingmodenative.FittingActivity$16$1
                            r5.<init>()
                            r7 = r14
                            r11 = r0
                            r8 = r2
                            r10 = r3
                            r12 = r5
                            r9 = 2
                        L_0x008f:
                            if (r7 == 0) goto L_0x009a
                            if (r8 == 0) goto L_0x009a
                            if (r12 == 0) goto L_0x009a
                            net.fxgear.fittingmodenative.FittingActivity r6 = net.fxgear.fittingmodenative.FittingActivity.this
                            r6.ShowConfirmDialog(r7, r8, r9, r10, r11, r12)
                        L_0x009a:
                            net.fxgear.fittingmodenative.FittingActivity r14 = net.fxgear.fittingmodenative.FittingActivity.this
                            net.fxgear.fittingmodenative.d.e.c unused = r14.mDownloadClothDataTask = r1
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.FittingActivity.AnonymousClass16.a(net.fxgear.GlobalDefine$Result):void");
                    }
                };
                if (aVar.i.e == -1) {
                    RequestClothData(new int[]{aVar.f1366a}, new e.a.C0051a() {
                        public void a(ArrayList<e.a> arrayList) {
                            e.a unused = FittingActivity.this.mClothDataTask = null;
                            if (FittingActivity.this.mCircleDialog != null) {
                                if (FittingActivity.this.mCircleDialog.isShowing()) {
                                    FittingActivity.this.mCircleDialog.dismiss();
                                }
                                net.fxgear.fittingmodenative.b.a unused2 = FittingActivity.this.mCircleDialog = null;
                            }
                            aVar.i = FittingActivity.this.FindClothesData(arrayList, aVar.f1366a);
                            e.c unused3 = FittingActivity.this.mDownloadClothDataTask = net.fxgear.fittingmodenative.d.e.a((Context) FittingActivity.this, aVar.i.f1461a, r0);
                        }

                        public void a() {
                            if (FittingActivity.this.mCircleDialog == null) {
                                net.fxgear.fittingmodenative.b.a unused = FittingActivity.this.mCircleDialog = new net.fxgear.fittingmodenative.b.a(FittingActivity.this, 0);
                            }
                            if (FittingActivity.this.mCircleDialog != null) {
                                FittingActivity.this.mCircleDialog.show();
                            }
                        }
                    });
                    return;
                }
                this.mDownloadClothDataTask = net.fxgear.fittingmodenative.d.e.a((Context) this, aVar.i.f1461a, (e.C0053e) r0);
            } else if (this.mMainClothesAndCategoryListView != null) {
                this.mMainClothesAndCategoryListView.b(aVar);
            }
        }
    }

    /* access modifiers changed from: private */
    public void ShowConfirmDialog(String str, String str2, int i, String str3, String str4, b.a aVar) {
        if (this.mConfirmDialog != null) {
            if (this.mConfirmDialog.isShowing()) {
                this.mConfirmDialog.dismiss();
            }
            this.mConfirmDialog = null;
        }
        this.mConfirmDialog = new net.fxgear.fittingmodenative.b.b(this, i);
        this.mConfirmDialog.setCanceledOnTouchOutside(false);
        this.mConfirmDialog.a(str);
        this.mConfirmDialog.b(str2);
        this.mConfirmDialog.c(str3);
        if (i == 2) {
            this.mConfirmDialog.d(str4);
        }
        this.mConfirmDialog.a(aVar);
        this.mConfirmDialog.show();
    }

    /* access modifiers changed from: private */
    public void ShowOfflineModeView() {
        if (this.mOfflineModeContainer != null && this.mOfflineModeContainer.getVisibility() != 0) {
            this.mHandler.obtainMessage(MSG_OFFLINE_MODE_RENEW, 1, 0).sendToTarget();
        }
    }

    public void OnClickActionNavigationButton(int i) {
        String str = TAG;
        Log.d(str, "OnClickActionNavigationButton, actionNavigation : " + i);
        if (this.mCircleDialog != null || IsWorkingFittingView()) {
            Log.e(TAG, "OnClickActionNavigationButton - FittingView is working");
        } else if (i == 1) {
            int i2 = this.mCurrentViewType;
            int i3 = 7;
            AnonymousClass20 r2 = null;
            if (i2 != 7) {
                switch (i2) {
                    case 0:
                        finish();
                        return;
                    case 1:
                        final int GetCurrentGender = GetCurrentGender();
                        final int GetCurrentAge = GetCurrentAge();
                        if (!HasAvatarThumbnailFile(GetFittingData(GetCurrentGender, GetCurrentAge).f.k.mAvatarID)) {
                            ProcessGetScreenShot(false, false, false, new Runnable() {
                                public void run() {
                                    int i;
                                    if (!FittingActivity.this.SaveAvatarThumbnailFileAndUpdateDB(FittingActivity.this.GetFittingData(GetCurrentGender, GetCurrentAge).f.k)) {
                                        Log.e(FittingActivity.TAG, "[ERROR] :: OnClickActionNavigationButton - back, SaveAvatarThumbnailFileAndUpdateDB");
                                        FittingActivity.this.ShowConfirmDialog((String) null, FittingActivity.this.getResources().getString(a.g.occurred_error_message), 1, FittingActivity.this.getResources().getString(a.g.confirm), (String) null, new b.a() {
                                            public void b(net.fxgear.fittingmodenative.b.b bVar) {
                                            }

                                            public void a(net.fxgear.fittingmodenative.b.b bVar) {
                                                if (FittingActivity.this.mConfirmDialog != null) {
                                                    FittingActivity.this.mConfirmDialog.dismiss();
                                                    net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                                                }
                                            }
                                        });
                                    } else if (FittingActivity.this.mAvatarSettingViewType == 1) {
                                        FittingActivity.this.OnShowItemList(20, FittingActivity.this.GetStringJsonDataInfoForSelectedItems(20, false));
                                        int unused = FittingActivity.this.mAvatarSettingViewType = 0;
                                    } else {
                                        AnonymousClass1 r0 = null;
                                        if (FittingActivity.this.mAvatarSettingViewType == 2) {
                                            FittingActivity.this.ResetClothesSize();
                                            r0 = new Runnable() {
                                                public void run() {
                                                    FittingActivity.this.SetClosestSizeToFittingClothes();
                                                }
                                            };
                                            i = 7;
                                        } else {
                                            i = 0;
                                        }
                                        FittingActivity.this.SwitchCurrentModeAndUIwithViewType(i, r0);
                                        int unused2 = FittingActivity.this.mAvatarSettingViewType = 0;
                                    }
                                }
                            });
                            return;
                        } else if (this.mAvatarSettingViewType == 1) {
                            OnShowItemList(20, GetStringJsonDataInfoForSelectedItems(20, false));
                            this.mAvatarSettingViewType = 0;
                            return;
                        } else {
                            if (this.mAvatarSettingViewType == 2) {
                                ResetClothesSize();
                                r2 = new Runnable() {
                                    public void run() {
                                        FittingActivity.this.SetClosestSizeToFittingClothes();
                                    }
                                };
                            } else {
                                i3 = 0;
                            }
                            SwitchCurrentModeAndUIwithViewType(i3, r2);
                            this.mAvatarSettingViewType = 0;
                            return;
                        }
                    default:
                        SwitchCurrentModeAndUIwithViewType(0, (Runnable) null);
                        return;
                }
            } else {
                SwitchCurrentModeAndUIwithViewType(0, (Runnable) null);
            }
        }
    }

    public void OnClickActionOptionButton(int i) {
        String str = TAG;
        Log.d(str, "OnClickActionOptionButton, actionOption : " + i);
        if (this.mConfirmDialog != null) {
            Log.e(TAG, "OnClickActionOptionButton, dialog is showing");
        } else if (this.mDownloadClothDataTask == null || this.mDownloadClothDataTask.getStatus() != AsyncTask.Status.RUNNING) {
            boolean z = true;
            if (i == 1) {
                ShowSelectCharacterDialog();
            } else if (i == 2) {
                final ArrayList arrayList = new ArrayList();
                if (Build.VERSION.SDK_INT >= 23) {
                    if (android.support.v4.b.a.a(getApplicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
                        arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                        z = false;
                    }
                    if (android.support.v4.b.a.a(getApplicationContext(), "android.permission.CAMERA") == -1) {
                        arrayList.add("android.permission.CAMERA");
                        z = false;
                    }
                }
                if (z) {
                    this.mRequestInfoForCustomFace = new f(this, (AnonymousClass1) null);
                    this.mRequestInfoForCustomFace.f1285a = this.mCurrentViewType;
                    this.mRequestInfoForCustomFace.c = false;
                    OnShowAvatarFaceCameraView(this.mRequestInfoForCustomFace.c);
                    return;
                }
                net.fxgear.fittingmodenative.b.b bVar = new net.fxgear.fittingmodenative.b.b(this, 2);
                bVar.a((String) null);
                bVar.b(getResources().getString(a.g.camera_access_required));
                bVar.c(getResources().getString(a.g.confirm));
                bVar.d(getResources().getString(a.g.cancel));
                bVar.a((b.a) new b.a() {
                    public void a(net.fxgear.fittingmodenative.b.b bVar) {
                        f unused = FittingActivity.this.mRequestInfoForCustomFace = new f(FittingActivity.this, (AnonymousClass1) null);
                        FittingActivity.this.mRequestInfoForCustomFace.f1285a = FittingActivity.this.mCurrentViewType;
                        FittingActivity.this.mRequestInfoForCustomFace.c = false;
                        android.support.v4.a.a.a(FittingActivity.this, (String[]) arrayList.toArray(new String[0]), 1);
                        bVar.dismiss();
                    }

                    public void b(net.fxgear.fittingmodenative.b.b bVar) {
                        bVar.dismiss();
                    }
                });
                bVar.show();
            }
        }
    }

    private void ChangeGender() {
        int GetCurrentGender = GetCurrentGender();
        int GetCurrentAge = GetCurrentAge();
        int i = GetCurrentGender == 1 ? 2 : 1;
        GetDefaultMirrorVideoID(GetCurrentGender, GetCurrentAge);
        GetDefaultAvatarID(GetCurrentGender, GetCurrentAge);
        b bVar = GetFittingData(i, GetCurrentAge).f;
        int i2 = bVar.c;
        int i3 = bVar.k.mAvatarID;
        if (bVar.k.mIsCustomFace && !HasCustomFaceData(i, GetCurrentAge)) {
            bVar.k.mIsCustomFace = false;
        }
        int[] GetFittingClotehsArray = GetFittingClotehsArray(i, GetCurrentAge);
        FittingView.ClothesFileInfo[] clothesFileInfoArr = new FittingView.ClothesFileInfo[5];
        for (int i4 = 0; i4 < GetFittingClotehsArray.length; i4++) {
            int i5 = GetFittingClotehsArray[i4];
            if (i5 == -1) {
                FittingView.ClothesFileInfo clothesFileInfo = new FittingView.ClothesFileInfo();
                clothesFileInfo.mClothType = i4;
                clothesFileInfoArr[i4] = clothesFileInfo;
            } else {
                clothesFileInfoArr[i4] = e.a((Context) this).e(i5);
            }
        }
        if (!SetCharacter(i, GetCurrentAge, i2, i3, clothesFileInfoArr, new Runnable() {
            public void run() {
                int GetCurrentGender = FittingActivity.this.GetCurrentGender();
                if (FittingActivity.this.mActionBar != null) {
                    FittingActivity.this.mActionBar.b(GetCurrentGender == 2);
                }
                FittingActivity.this.ShowAllFittingTools(true);
                FittingActivity.this.UpdateClothesAndCategoryList();
            }
        })) {
            Log.e(TAG, "Fail To SetGender");
        }
    }

    private void ShowSelectCharacterDialog() {
        int i;
        final net.fxgear.fittingmodenative.b.e eVar = new net.fxgear.fittingmodenative.b.e(this);
        Resources resources = getResources();
        int i2 = 0;
        String[] strArr = {resources.getString(a.g.fitting_mode_sex_female), resources.getString(a.g.fitting_mode_sex_male), resources.getString(a.g.fitting_mode_sex_girl), resources.getString(a.g.fitting_mode_sex_boy)};
        int GetCurrentGender = GetCurrentGender();
        int GetCurrentAge = GetCurrentAge();
        if (GetCurrentMode() == 0) {
            i = a.g.fitting_mode_title_change_model;
        } else {
            i = a.g.fitting_mode_title_change_avatar;
        }
        String string = resources.getString(i);
        if (GetCurrentGender == 1) {
            if (GetCurrentAge == 1) {
                i2 = 2;
            }
        } else if (GetCurrentGender == 2) {
            i2 = GetCurrentAge == 1 ? 3 : 1;
        }
        eVar.a(string);
        eVar.a(strArr, i2);
        eVar.a((e.c) new e.c() {
            public void a(int i, String str) {
                a aVar = new a();
                switch (i) {
                    case 0:
                        aVar.f1279b = 2;
                        aVar.f1278a = 1;
                        break;
                    case 1:
                        aVar.f1279b = 2;
                        aVar.f1278a = 2;
                        break;
                    case 2:
                        aVar.f1279b = 1;
                        aVar.f1278a = 1;
                        break;
                    case 3:
                        aVar.f1279b = 1;
                        aVar.f1278a = 2;
                        break;
                    default:
                        String access$500 = FittingActivity.TAG;
                        Log.e(access$500, "[ERROR] :: ShowSelectCharacterDialog(), wrong position: " + i);
                        return;
                }
                if (FittingActivity.this.GetCurrentGender() == aVar.f1278a && FittingActivity.this.GetCurrentAge() == aVar.f1279b) {
                    String access$5002 = FittingActivity.TAG;
                    Log.d(access$5002, "ShowSelectCharacterDialog(), selected same character as now,gender: " + aVar.f1278a + ", age: " + aVar.f1279b);
                } else {
                    b bVar = FittingActivity.this.GetFittingData(aVar.f1278a, aVar.f1279b).f;
                    int[] GetFittingClotehsArray = FittingActivity.this.GetFittingClotehsArray(aVar.f1278a, aVar.f1279b);
                    FittingView.ClothesFileInfo[] clothesFileInfoArr = new FittingView.ClothesFileInfo[5];
                    for (int i2 = 0; i2 < GetFittingClotehsArray.length; i2++) {
                        int i3 = GetFittingClotehsArray[i2];
                        if (i3 == -1) {
                            FittingView.ClothesFileInfo clothesFileInfo = new FittingView.ClothesFileInfo();
                            clothesFileInfo.mClothType = i2;
                            clothesFileInfoArr[i2] = clothesFileInfo;
                        } else {
                            clothesFileInfoArr[i2] = e.a((Context) FittingActivity.this).e(i3);
                        }
                    }
                    if (!FittingActivity.this.SetCharacter(aVar.f1278a, aVar.f1279b, bVar.c, bVar.k.mAvatarID, clothesFileInfoArr, new Runnable() {
                        public void run() {
                            FittingActivity.this.ShowAllFittingTools(true);
                            FittingActivity.this.UpdateClothesAndCategoryList();
                        }
                    })) {
                        String access$5003 = FittingActivity.TAG;
                        Log.e(access$5003, "[ERROR] :: failed to SetCharacter, gender: " + aVar.f1278a + ", age: " + aVar.f1279b);
                    }
                }
                eVar.dismiss();
            }
        });
        eVar.show();
    }

    public void OnClickFittingModeButton(int i) {
        String str = TAG;
        Log.d(str, "OnClickFittingModeButton, buttonType : " + i);
        if (this.mCircleDialog != null || IsWorkingFittingView()) {
            Log.e(TAG, "OnClickFittingModeButton, FittingView is working");
        } else if (this.mDownloadClothDataTask == null || this.mDownloadClothDataTask.getStatus() != AsyncTask.Status.RUNNING) {
            int GetCurrentMode = GetCurrentMode();
            if (GetCurrentMode == 0 || GetCurrentMode == 1) {
                if (i == 0) {
                    sFittingRoomMode = 0;
                } else {
                    sFittingRoomMode = 1;
                }
                if (GetCurrentMode != sFittingRoomMode && !SetMode(sFittingRoomMode, new Runnable() {
                    public void run() {
                        if (FittingActivity.this.mActionBar != null) {
                            FittingActivity.this.mActionBar.a(FittingActivity.this.GetCurrentMode() != 0);
                        }
                        FittingActivity.this.ShowAllFittingTools(true);
                        FittingActivity.this.SetOptionButtonsVisibility();
                    }
                })) {
                    Log.e(TAG, "Fail to SetMode");
                    return;
                }
                return;
            }
            String str2 = TAG;
            Log.e(str2, "wrong mode for changing fitting mode, currentMode: " + GetCurrentMode);
        }
    }

    public void OnClickAvatarSettingButton(int i) {
        int i2;
        String str = TAG;
        Log.d(str, "OnClickAvatarSettingButton, settingMode : " + i);
        if (this.mCircleDialog != null || IsWorkingFittingView()) {
            Log.e(TAG, "OnClickAvatarSettingButton, FittingView is working");
            return;
        }
        switch (i) {
            case 0:
                i2 = 2;
                break;
            case 1:
                i2 = 3;
                break;
            case 2:
                i2 = 4;
                break;
            case 3:
                i2 = 5;
                break;
            default:
                String str2 = TAG;
                Log.e(str2, "wrong settingMode : " + i);
                return;
        }
        if ((i2 == 2 || i2 == 4) && !GetFittingData(GetCurrentGender(), GetCurrentAge()).f.k.mIsCustomFace) {
            ShowNoticeToTakeFacePicture(i2);
        } else {
            SwitchCurrentModeAndUIwithViewType(i2, (Runnable) null);
        }
    }

    /* access modifiers changed from: private */
    public void CancelAvatarSettingMenuItem(int i) {
        String str = TAG;
        Log.i(str, "CancelAvatarSettingMenuItem()+, viewType: " + i);
        switch (i) {
            case 2:
                int GetHeadIndexByType = GetHeadIndexByType(GetFittingData(GetCurrentGender(), GetCurrentAge()).f.k.mHeadType, GetCurrentGender(), GetCurrentAge());
                if (GetHeadIndexByType != GetCurrentHeadTypeIndex()) {
                    AnonymousClass25 r2 = new Runnable() {
                        public void run() {
                            int unused = FittingActivity.this.mCurrentViewType = 1;
                            FittingActivity.this.SwitchCurrentUIView();
                            if (FittingActivity.this.mNoticeToTakeFacePictureLayout != null) {
                                if (FittingActivity.this.mActivityRootView != null) {
                                    FittingActivity.this.mActivityRootView.removeView(FittingActivity.this.mNoticeToTakeFacePictureLayout);
                                }
                                LinearLayout unused2 = FittingActivity.this.mNoticeToTakeFacePictureLayout = null;
                            }
                        }
                    };
                    if (!SetAvatarHeadTypeWithChangeAvatarMode(2, GetHeadIndexByType, true, r2)) {
                        Log.e(TAG, "[ERROR] :: failed to set avater face shape type with changing avatar mode.");
                        r2.run();
                        return;
                    }
                    return;
                }
                SwitchCurrentModeAndUIwithViewType(1, new Runnable() {
                    public void run() {
                        if (FittingActivity.this.mNoticeToTakeFacePictureLayout != null) {
                            if (FittingActivity.this.mActivityRootView != null) {
                                FittingActivity.this.mActivityRootView.removeView(FittingActivity.this.mNoticeToTakeFacePictureLayout);
                            }
                            LinearLayout unused = FittingActivity.this.mNoticeToTakeFacePictureLayout = null;
                        }
                    }
                });
                return;
            case 3:
                int GetHairIndexByType = GetHairIndexByType(GetFittingData(GetCurrentGender(), GetCurrentAge()).f.k.mHairType, GetCurrentGender(), GetCurrentAge());
                if (GetHairIndexByType != GetCurrentHairTypeIndex()) {
                    AnonymousClass27 r0 = new Runnable() {
                        public void run() {
                            int unused = FittingActivity.this.mCurrentViewType = 1;
                            FittingActivity.this.SwitchCurrentUIView();
                        }
                    };
                    if (!SetAvatarHairTypeWithChangeAvatarMode(2, GetHairIndexByType, r0)) {
                        Log.e(TAG, "[ERROR] :: failed to set avater hair type with changing avatar mode.");
                        r0.run();
                        return;
                    }
                    return;
                }
                SwitchCurrentModeAndUIwithViewType(1, (Runnable) null);
                return;
            case 4:
                AnonymousClass28 r7 = new Runnable() {
                    public void run() {
                        int unused = FittingActivity.this.mCurrentViewType = 1;
                        FittingActivity.this.SwitchCurrentUIView();
                        if (FittingActivity.this.mNoticeToTakeFacePictureLayout != null) {
                            if (FittingActivity.this.mActivityRootView != null) {
                                FittingActivity.this.mActivityRootView.removeView(FittingActivity.this.mNoticeToTakeFacePictureLayout);
                            }
                            LinearLayout unused2 = FittingActivity.this.mNoticeToTakeFacePictureLayout = null;
                        }
                    }
                };
                b bVar = GetFittingData(GetCurrentGender(), GetCurrentAge()).f;
                if (!SetAvatarSkinToneWithChangeAvatarMode(2, bVar.k.mAutoNormalizedColor, FittingSurfaceView.colorTemperatureToNormalizeValue(new float[]{(float) FXUtil.redFromColor(bVar.k.mHueRGBColor), (float) FXUtil.greenFromColor(bVar.k.mHueRGBColor), (float) FXUtil.blueFromColor(bVar.k.mHueRGBColor)}), r7)) {
                    Log.e(TAG, "[ERROR] :: failed to set avater skin tone with changing avatar mode.");
                    r7.run();
                    return;
                }
                return;
            case 5:
                AnonymousClass29 r72 = new Runnable() {
                    public void run() {
                        int unused = FittingActivity.this.mCurrentViewType = 1;
                        FittingActivity.this.SwitchCurrentUIView();
                    }
                };
                if (!SetBodySizeAllWithChangeAvatarMode(2, GetFittingData(GetCurrentGender(), GetCurrentAge()).f.k.mBodyData, r72)) {
                    Log.e(TAG, "[ERROR] :: failed to set body size all with changing avatar mode.");
                    r72.run();
                    return;
                }
                return;
            default:
                String str2 = TAG;
                Log.e(str2, "wrong viewType: " + i);
                return;
        }
    }

    public void OnColorCalibrationProgressChanged(int i, float f2) {
        String str = TAG;
        Log.d(str, "OnColorCalibrationProgressChanged, seekBarType : " + i + ", currentValue : " + f2);
        if (i != 10 && i == 11) {
            SetAvatarSkinTone(f2, false, (Runnable) null);
        }
    }

    public void OnColorCalibrationStopTracking(int i, float f2) {
        String str = TAG;
        Log.d(str, "OnColorCalibrationStopTracking, seekBarType : " + i + ", currentValue : " + f2);
        if (i == 10) {
            SetAvatarSkinAuto(f2, true, (Runnable) null);
        } else if (i == 11) {
            SetAvatarSkinTone(f2, true, (Runnable) null);
        }
    }

    public void OnClickColorCalibrationSettingButton(int i) {
        String str = TAG;
        Log.d(str, "OnClickColorCalibrationSettingButton, buttonType : " + i);
        if (this.mCircleDialog != null || IsWorkingFittingView()) {
            Log.e(TAG, "OnClickColorCalibrationSettingButton, FittingView is working");
        } else if (i == 1) {
            final int GetCurrentGender = GetCurrentGender();
            final int GetCurrentAge = GetCurrentAge();
            ProcessGetScreenShot(false, false, false, new Runnable() {
                public void run() {
                    b bVar = FittingActivity.this.GetFittingData(GetCurrentGender, GetCurrentAge).f;
                    if (FittingActivity.this.mBottomContainer != null) {
                        int childCount = FittingActivity.this.mBottomContainer.getChildCount();
                        int i = 0;
                        while (true) {
                            if (i < childCount) {
                                View childAt = FittingActivity.this.mBottomContainer.getChildAt(i);
                                if (childAt != null && (childAt instanceof net.fxgear.fittingmodenative.c.f)) {
                                    net.fxgear.fittingmodenative.c.f fVar = (net.fxgear.fittingmodenative.c.f) childAt;
                                    bVar.k.mAutoNormalizedColor = fVar.c();
                                    bVar.k.mHueRGBColor = fVar.b();
                                    break;
                                }
                                i++;
                            } else {
                                break;
                            }
                        }
                    }
                    if (FittingActivity.this.SaveAvatarThumbnailFileAndUpdateDB(bVar.k)) {
                        FittingActivity.this.SwitchCurrentModeAndUIwithViewType(1, (Runnable) null);
                        return;
                    }
                    Log.e(FittingActivity.TAG, "[ERROR] :: OnClickColorCalibrationSettingButton - confirm, SaveAvatarThumbnailFileAndUpdateDB");
                    FittingActivity.this.CancelAvatarSettingMenuItem(FittingActivity.this.mCurrentViewType);
                    FittingActivity.this.ShowConfirmDialog((String) null, FittingActivity.this.getResources().getString(a.g.occurred_error_message), 1, FittingActivity.this.getResources().getString(a.g.confirm), (String) null, new b.a() {
                        public void b(net.fxgear.fittingmodenative.b.b bVar) {
                        }

                        public void a(net.fxgear.fittingmodenative.b.b bVar) {
                            if (FittingActivity.this.mConfirmDialog != null) {
                                FittingActivity.this.mConfirmDialog.dismiss();
                                net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                            }
                        }
                    });
                }
            });
        } else {
            CancelAvatarSettingMenuItem(this.mCurrentViewType);
        }
    }

    public void OnClickAvatarRecyclerHorizontalSettingItem(int i, int i2) {
        String str = TAG;
        Log.d(str, "OnClickSettingButton, settingViewType: " + i + ", selectedItemType: " + i2);
        switch (i) {
            case 2:
                SetAvatarHeadType(i2, true, (Runnable) null);
                return;
            case 3:
                SetAvatarHairType(i2, (Runnable) null);
                return;
            default:
                return;
        }
    }

    public void OnClickAvatarRecyclerHorizontalSettingButton(int i, int i2, int i3) {
        String str = TAG;
        Log.d(str, "OnClickAvatarRecyclerHorizontalSettingButton, settingViewType: " + i + ", buttonType: " + i2 + ", selectedItemType: " + i3);
        if (this.mCircleDialog != null || IsWorkingFittingView()) {
            Log.e(TAG, "OnClickAvatarRecyclerHorizontalSettingButton, FittingView is working");
        } else if (i2 == 1) {
            final int GetCurrentGender = GetCurrentGender();
            final int GetCurrentAge = GetCurrentAge();
            switch (i) {
                case 2:
                    final int i4 = i3;
                    final int i5 = i;
                    ProcessGetScreenShot(false, false, false, new Runnable() {
                        public void run() {
                            int access$3200 = FittingActivity.this.GetHeadTypeByIndex(i4, GetCurrentGender, GetCurrentAge);
                            b bVar = FittingActivity.this.GetFittingData(GetCurrentGender, GetCurrentAge).f;
                            bVar.k.mHeadType = access$3200;
                            if (FittingActivity.this.SaveAvatarThumbnailFileAndUpdateDB(bVar.k)) {
                                FittingActivity.this.SwitchCurrentModeAndUIwithViewType(1, (Runnable) null);
                                return;
                            }
                            Log.e(FittingActivity.TAG, "[ERROR] :: OnClickAvatarRecyclerHorizontalSettingButton - confirm, SaveAvatarThumbnailFileAndUpdateDB");
                            FittingActivity.this.CancelAvatarSettingMenuItem(i5);
                            FittingActivity.this.ShowConfirmDialog((String) null, FittingActivity.this.getResources().getString(a.g.occurred_error_message), 1, FittingActivity.this.getResources().getString(a.g.confirm), (String) null, new b.a() {
                                public void b(net.fxgear.fittingmodenative.b.b bVar) {
                                }

                                public void a(net.fxgear.fittingmodenative.b.b bVar) {
                                    if (FittingActivity.this.mConfirmDialog != null) {
                                        FittingActivity.this.mConfirmDialog.dismiss();
                                        net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                                    }
                                }
                            });
                        }
                    });
                    return;
                case 3:
                    final int i6 = i3;
                    final int i7 = i;
                    ProcessGetScreenShot(false, false, false, new Runnable() {
                        public void run() {
                            int access$4500 = FittingActivity.this.GetHairTypeByIndex(i6, GetCurrentGender, GetCurrentAge);
                            b bVar = FittingActivity.this.GetFittingData(GetCurrentGender, GetCurrentAge).f;
                            bVar.k.mHairType = access$4500;
                            if (FittingActivity.this.SaveAvatarThumbnailFileAndUpdateDB(bVar.k)) {
                                FittingActivity.this.SwitchCurrentModeAndUIwithViewType(1, (Runnable) null);
                                return;
                            }
                            Log.e(FittingActivity.TAG, "[ERROR] :: OnClickAvatarRecyclerHorizontalSettingButton - confirm, SaveAvatarThumbnailFileAndUpdateDB");
                            FittingActivity.this.CancelAvatarSettingMenuItem(i7);
                            FittingActivity.this.ShowConfirmDialog((String) null, FittingActivity.this.getResources().getString(a.g.occurred_error_message), 1, FittingActivity.this.getResources().getString(a.g.confirm), (String) null, new b.a() {
                                public void b(net.fxgear.fittingmodenative.b.b bVar) {
                                }

                                public void a(net.fxgear.fittingmodenative.b.b bVar) {
                                    if (FittingActivity.this.mConfirmDialog != null) {
                                        FittingActivity.this.mConfirmDialog.dismiss();
                                        net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                                    }
                                }
                            });
                        }
                    });
                    return;
                default:
                    return;
            }
        } else {
            CancelAvatarSettingMenuItem(i);
        }
    }

    public void OnClickCustomFaceRetryButton() {
        boolean z;
        final ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        final int i = 1;
        if (Build.VERSION.SDK_INT >= 23) {
            if (android.support.v4.b.a.a(getApplicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
                arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                z = false;
            } else {
                z = true;
            }
            if (android.support.v4.b.a.a(getApplicationContext(), "android.permission.CAMERA") == -1) {
                arrayList.add("android.permission.CAMERA");
                z = false;
            }
        } else {
            z = true;
        }
        if (this.mRequestInfoForCustomFace != null) {
            z2 = this.mRequestInfoForCustomFace.c;
        }
        if (z) {
            OnShowAvatarFaceCameraView(z2);
            return;
        }
        if (z2) {
            i = 2;
        }
        net.fxgear.fittingmodenative.b.b bVar = new net.fxgear.fittingmodenative.b.b(this, 2);
        bVar.a((String) null);
        bVar.b(getResources().getString(a.g.camera_access_required));
        bVar.c(getResources().getString(a.g.confirm));
        bVar.d(getResources().getString(a.g.cancel));
        bVar.a((b.a) new b.a() {
            public void a(net.fxgear.fittingmodenative.b.b bVar) {
                android.support.v4.a.a.a(FittingActivity.this, (String[]) arrayList.toArray(new String[0]), i);
                bVar.dismiss();
            }

            public void b(net.fxgear.fittingmodenative.b.b bVar) {
                bVar.dismiss();
            }
        });
        bVar.show();
    }

    public void OnClickCustomFaceDetailSettingButton() {
        Context applicationContext = getApplicationContext();
        String GetCurrentCustomFaceImageFilePath = FXUtil.GetCurrentCustomFaceImageFilePath(applicationContext);
        if (GetCurrentCustomFaceImageFilePath != null) {
            int[] GetCurrentCustomFacDetectPositions = FXUtil.GetCurrentCustomFacDetectPositions(applicationContext);
            if (GetCurrentCustomFacDetectPositions != null) {
                Intent intent = new Intent(this, AvatarFaceSettingActivity.class);
                intent.putExtra("detecting_face_file_path", GetCurrentCustomFaceImageFilePath);
                intent.putExtra("detecting_face_points", GetCurrentCustomFacDetectPositions);
                startActivityForResult(intent, 3);
                return;
            }
            Log.e(TAG, "OnClickCustomFaceDetailSettingButton(), detectPoints is null");
            return;
        }
        Log.e(TAG, "OnClickCustomFaceDetailSettingButton(), imageFilePath is null");
    }

    public void OnClickCustomFaceApplyButton() {
        final int GetCurrentGender = GetCurrentGender();
        final int GetCurrentAge = GetCurrentAge();
        b bVar = GetFittingData(GetCurrentGender, GetCurrentAge).f;
        final boolean z = bVar.k.mIsCustomFace;
        final int i = bVar.k.mHeadType;
        final float f2 = bVar.k.mAutoNormalizedColor;
        final int i2 = bVar.k.mHueRGBColor;
        bVar.k.mIsCustomFace = true;
        if (this.mSetCustomFaceWithSkinValue) {
            bVar.k.mHeadType = GetDefaultHeadTypeID(GetCurrentGender, GetCurrentAge);
            bVar.k.mAutoNormalizedColor = 0.5f;
            bVar.k.mHueRGBColor = FXUtil.colorFromRGB(255, 255, 255);
        }
        this.mSetCustomFaceWithSkinValue = false;
        ProcessGetScreenShot(false, false, false, new Runnable() {
            public void run() {
                int i;
                b bVar = FittingActivity.this.GetFittingData(GetCurrentGender, GetCurrentAge).f;
                Context applicationContext = FittingActivity.this.getApplicationContext();
                if (FittingActivity.this.SaveAllAvatarDataFilesAndUpdateDB(bVar.k)) {
                    if (FittingActivity.this.HasBackupCustomFaceData(applicationContext) && !FittingActivity.this.DeleteAllBackupCustomFaceData(applicationContext)) {
                        Log.e(FittingActivity.TAG, "[JE] Failed to delete all backup custom face data!");
                    }
                    if (FittingActivity.this.mRequestInfoForCustomFace != null) {
                        i = FittingActivity.this.mRequestInfoForCustomFace.f1285a;
                    } else {
                        Log.e(FittingActivity.TAG, "[ERROR] :: OnClickCustomFaceApplyButton(), mRequestInfoForCustomFace is null");
                        i = 1;
                    }
                    String access$500 = FittingActivity.TAG;
                    Log.d(access$500, "OnClickCustomFaceApplyButton()-, switch to viewType: " + i);
                    FittingActivity.this.SwitchCurrentModeAndUIwithViewType(i, new Runnable() {
                        public void run() {
                            f unused = FittingActivity.this.mRequestInfoForCustomFace = null;
                        }
                    });
                    return;
                }
                Log.e(FittingActivity.TAG, "[ERROR] :: OnClickCustomFaceApplyButton - SaveAllAvatarDataFilesAndUpdateDB");
                bVar.k.mIsCustomFace = z;
                bVar.k.mHeadType = i;
                bVar.k.mAutoNormalizedColor = f2;
                bVar.k.mHueRGBColor = i2;
                FittingActivity.this.CancelToChangeCustomFace();
                FittingActivity.this.ShowConfirmDialog((String) null, FittingActivity.this.getResources().getString(a.g.occurred_error_message), 1, FittingActivity.this.getResources().getString(a.g.confirm), (String) null, new b.a() {
                    public void b(net.fxgear.fittingmodenative.b.b bVar) {
                    }

                    public void a(net.fxgear.fittingmodenative.b.b bVar) {
                        if (FittingActivity.this.mConfirmDialog != null) {
                            FittingActivity.this.mConfirmDialog.dismiss();
                            net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                        }
                    }
                });
                f unused = FittingActivity.this.mRequestInfoForCustomFace = null;
            }
        });
    }

    public boolean OnSelectCategory(int i) {
        ArrayList arrayList;
        int i2 = 0;
        if (this.mDownloadClothDataTask != null && this.mDownloadClothDataTask.getStatus() == AsyncTask.Status.RUNNING) {
            Log.e(TAG, "mDownloadClothDataTask is running");
            return false;
        } else if (this.mMainClothesAndCategoryListView != null) {
            c GetFittingData = GetFittingData(GetCurrentGender(), GetCurrentAge());
            while (true) {
                if (i2 >= GetFittingData.f1283b.size()) {
                    break;
                } else if (GetFittingData.f1283b.get(i2).f1355a == i) {
                    GetFittingData.f1282a = i2;
                    break;
                } else {
                    i2++;
                }
            }
            if (GetFittingData.f1282a == 0) {
                arrayList = GetFittingData.e.get(-1);
            } else {
                arrayList = GetFittingData.e.get(Integer.valueOf(i));
            }
            SetClothesListViewItems(arrayList, GetFittingData.d);
            return true;
        } else {
            Log.e(TAG, "OnSelectCategory(), mMainClothesAndCategoryListView is null");
            return false;
        }
    }

    public void OnAddClothes() {
        OnShowProductList(GetCurrentGender() == 2 ? GlobalDefine.GENDER_MAN_STRING : GlobalDefine.GENDER_WOMAN_STRING, GetCurrentAge() == 1 ? GlobalDefine.AGE_EARLY_STRING : GlobalDefine.AGE_MIDDLE_STRING);
    }

    public void OnDownloadStartClothesData(e.a aVar) {
        DownloadClothesData(aVar);
    }

    public void OnDownloadCancelClothesData(e.a aVar) {
        if (this.mDownloadClothDataTask != null && this.mDownloadClothDataTask.c() == aVar.i.f1461a) {
            this.mDownloadClothDataTask.b();
        }
    }

    public void OnFittingClothesItem(e.a aVar, e.b bVar) {
        String str;
        int i = aVar.i.d;
        c GetFittingData = GetFittingData(GetCurrentGender(), GetCurrentAge());
        if (bVar == e.b.CheckSize) {
            GlobalDefine.ClothesSize clothesSize = aVar.e;
            if (clothesSize == null) {
                clothesSize = ClothesSizeProvider.GetClosestClothSize(aVar.c, aVar.d, i, false);
                aVar.e = clothesSize;
            }
            if (this.mMainClothesAndCategoryListView != null) {
                GetFittingData.a(aVar.i.f1461a);
                this.mMainClothesAndCategoryListView.a(aVar.i.f1461a, clothesSize);
                this.mMainClothesAndCategoryListView.a(clothesSize);
                return;
            }
            return;
        }
        if (bVar == e.b.PutOn) {
            int[] GetFittingClotehsArray = GetFittingClotehsArray(GetCurrentGender(), GetCurrentAge());
            GetFittingData.b(GetFittingClotehsArray[i]);
            GetFittingClotehsArray[i] = aVar.i.f1461a;
            GetFittingData.a(aVar.i.f1461a);
            FittingView.ClothesFileInfo e2 = e.a((Context) this).e(aVar.i.f1461a);
            if (f.a(getApplicationContext())) {
                String str2 = sFittingRoomMode == 0 ? "REAL_THUMB_CLI" : "AVATAR_THUMB_CLI";
                if (GetCurrentGender() == 2) {
                    str = m.d;
                    if (GetCurrentAge() == 1) {
                        str = "km";
                    }
                } else {
                    str = "w";
                    if (GetCurrentAge() == 1) {
                        str = "kw";
                    }
                }
                j.a(str2, str + aVar.f1366a);
            }
            if (aVar.e == null) {
                aVar.e = ClothesSizeProvider.GetClosestClothSize(aVar.c, aVar.d, i, false);
            }
            SetClothes(e2, aVar.e, (Runnable) null);
            return;
        }
        GetFittingData.b(aVar.i.f1461a);
        FittingView.ClothesFileInfo clothesFileInfo = new FittingView.ClothesFileInfo();
        clothesFileInfo.mClothType = i;
        SetClothes(clothesFileInfo, (Runnable) null);
    }

    public void OnBuyClothesItem(e.a aVar) {
        GoToBuyClothesView(aVar.i.f1461a);
    }

    public void OnDeleteClothesItem(e.a aVar) {
        c cVar;
        ArrayList arrayList = new ArrayList();
        int GetCurrentGender = GetCurrentGender();
        int GetCurrentAge = GetCurrentAge();
        arrayList.add(GetFittingData(GetCurrentGender, GetCurrentAge));
        if (aVar.c == 3) {
            if (GetCurrentGender == 2) {
                cVar = GetFittingData(1, GetCurrentAge);
            } else {
                cVar = GetFittingData(2, GetCurrentAge);
            }
            arrayList.add(cVar);
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            c cVar2 = (c) arrayList.get(i);
            if (cVar2 != null) {
                int i2 = aVar.i.d;
                if (aVar.i.f1461a == cVar2.d[i2]) {
                    FittingView.ClothesFileInfo clothesFileInfo = new FittingView.ClothesFileInfo();
                    clothesFileInfo.mClothType = i2;
                    SetClothes(clothesFileInfo, (Runnable) null);
                }
                RemoveClothItem(aVar.i.f1461a);
                ArrayList<Integer> arrayList2 = aVar.f1367b;
                int size2 = arrayList2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    ArrayList arrayList3 = cVar2.e.get(Integer.valueOf(arrayList2.get(i3).intValue()));
                    if (arrayList3 != null && arrayList3.contains(aVar)) {
                        arrayList3.remove(aVar);
                    }
                }
                ArrayList arrayList4 = cVar2.e.get(-1);
                if (arrayList4 != null && arrayList4.contains(aVar)) {
                    arrayList4.remove(aVar);
                }
            } else {
                Log.e(TAG, "ERROR :: Not found data");
            }
        }
        OnRemoveClothes(MakeRemoveItemJson(aVar.i.f1461a));
    }

    private String MakeBuyItemJson(int i) {
        String str;
        try {
            int i2 = GetFittingData(GetCurrentGender(), GetCurrentAge()).f.c;
            e a2 = e.a((Context) this);
            e.c g = a2.g(i2);
            if (g.f.equals(GlobalDefine.REAL_VIDEO_BODY_SIZE_CUSTOM)) {
                str = a2.g(GetDefaultMirrorVideoID(GetCurrentGender(), GetCurrentAge())).f;
            } else {
                str = g.f;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uuid", String.valueOf(i));
            jSONObject.put("bodysize", str);
            return "order?data=" + jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private String MakeRemoveItemJson(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uuid", String.valueOf(i));
            return "remove_wishlist?data=" + jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void GoToBuyClothesView(final int i) {
        String str;
        if (f.a((Context) this)) {
            OnBuyClothes(MakeBuyItemJson(i));
            String str2 = sFittingRoomMode == 0 ? "REAL_BUY_CLI" : "AVATAR_BUY_CLI";
            if (GetCurrentGender() == 2) {
                str = m.d;
                if (GetCurrentAge() == 1) {
                    str = "km";
                }
            } else {
                str = "w";
                if (GetCurrentAge() == 1) {
                    str = "kw";
                }
            }
            j.a(str2, str + i);
            return;
        }
        ShowOfflineModeView();
        ShowConfirmDialog(getResources().getString(a.g.network_error_title), getResources().getString(a.g.network_error_message), 2, getResources().getString(a.g.retry), getResources().getString(a.g.cancel), new b.a() {
            public void a(net.fxgear.fittingmodenative.b.b bVar) {
                if (FittingActivity.this.mConfirmDialog != null) {
                    FittingActivity.this.mConfirmDialog.dismiss();
                    net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                }
                FittingActivity.this.GoToBuyClothesView(i);
            }

            public void b(net.fxgear.fittingmodenative.b.b bVar) {
                if (FittingActivity.this.mConfirmDialog != null) {
                    FittingActivity.this.mConfirmDialog.dismiss();
                    net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                }
            }
        });
    }

    public void OnClickClothesSize(GlobalDefine.ClothesSize clothesSize) {
        e.a a2;
        if (this.mFittingView != null && (a2 = GetFittingData(GetCurrentGender(), GetCurrentAge()).a()) != null && a2.e != clothesSize) {
            a2.e = clothesSize;
            HashMap hashMap = new HashMap();
            hashMap.put(Integer.valueOf(a2.i.d), a2.e);
            SetClothesSize(hashMap, (Runnable) null);
        }
    }

    public void OnBodySizeSettingProgressChanged(int i, float f2) {
        SetBodySize(i, f2, false, (Runnable) null);
    }

    public BodySizeData OnBodySizeSettingStopTracking(int i, float f2) {
        String str = TAG;
        Log.d(str, "OnBodySizeSettingStopTracking, bodyPart: " + i + ", currentValue: " + f2);
        if (SetBodySize(i, f2, true, (Runnable) null)) {
            return GetCurrentBodySizeAll();
        }
        return null;
    }

    public double GetBodySizeMinThresholdValue(int i) {
        return GetCurrentBodyThresHoldMinValue(i);
    }

    public double GetBodySizeMaxThresholdValue(int i) {
        return GetCurrentBodyThresHoldMaxValue(i);
    }

    public BodySizeData OnClickGoToDetailedBodySizeSettingMenuButton() {
        return GetCurrentBodySizeAll();
    }

    public void OnClickBodySizeSettingButton(int i, final BodySizeData bodySizeData) {
        String str = TAG;
        Log.d(str, "OnClickBodySizeSettingButton, buttonType: " + i);
        if (this.mCircleDialog != null || IsWorkingFittingView()) {
            Log.e(TAG, "OnClickBodySizeSettingButton - FittingView is working");
        } else if (i == 1) {
            final int GetCurrentGender = GetCurrentGender();
            final int GetCurrentAge = GetCurrentAge();
            ProcessGetScreenShot(false, false, false, new Runnable() {
                public void run() {
                    b bVar = FittingActivity.this.GetFittingData(GetCurrentGender, GetCurrentAge).f;
                    bVar.k.mBodyData = bodySizeData;
                    if (FittingActivity.this.SaveAvatarThumbnailFileAndUpdateDB(bVar.k)) {
                        FittingActivity.this.SwitchCurrentModeAndUIwithViewType(1, (Runnable) null);
                        return;
                    }
                    Log.e(FittingActivity.TAG, "[ERROR] :: OnClickBodySizeSettingButton - confirm, SaveAvatarThumbnailFileAndUpdateDB");
                    FittingActivity.this.CancelAvatarSettingMenuItem(FittingActivity.this.mCurrentViewType);
                    FittingActivity.this.ShowConfirmDialog((String) null, FittingActivity.this.getResources().getString(a.g.occurred_error_message), 1, FittingActivity.this.getResources().getString(a.g.confirm), (String) null, new b.a() {
                        public void b(net.fxgear.fittingmodenative.b.b bVar) {
                        }

                        public void a(net.fxgear.fittingmodenative.b.b bVar) {
                            if (FittingActivity.this.mConfirmDialog != null) {
                                FittingActivity.this.mConfirmDialog.dismiss();
                                net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                            }
                        }
                    });
                }
            });
        } else {
            CancelAvatarSettingMenuItem(this.mCurrentViewType);
        }
    }

    /* access modifiers changed from: private */
    public void ShowCircleDialog() {
        if (this.mCircleDialog == null) {
            this.mCircleDialog = new net.fxgear.fittingmodenative.b.a(this, 0);
        }
        if (this.mCircleDialog != null) {
            this.mCircleDialog.setCancelable(false);
            this.mCircleDialog.show();
        }
    }

    /* access modifiers changed from: private */
    public void DismissCircleDialog() {
        if (this.mCircleDialog != null) {
            if (this.mCircleDialog.isShowing()) {
                this.mCircleDialog.dismiss();
            }
            this.mCircleDialog = null;
        }
    }

    public void OnStartAsyncWork() {
        super.OnStartAsyncWork();
        ShowCircleDialog();
    }

    public void OnFinishAsyncWork(Runnable runnable) {
        super.OnFinishAsyncWork(runnable);
        if (this.mClothDataTask == null) {
            DismissCircleDialog();
        }
        if (this.mActivityRootView == null) {
            Log.w(TAG, "[L] Activity destroy.");
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public void OnResultCustomFace(GlobalDefine.Result result) {
        int i;
        Log.d(TAG, "OnResultCustomFace()+");
        boolean z = true;
        if (result == null || this.mFittingView == null) {
            Log.e(TAG, "[ERROR] :: result is null");
        } else if (result.resultCode == -1) {
            int GetCurrentGender = GetCurrentGender();
            int GetCurrentAge = GetCurrentAge();
            if (HasCustomFaceData(GetCurrentGender, GetCurrentAge)) {
                b bVar = GetFittingData(GetCurrentGender, GetCurrentAge).f;
                if (bVar.k.mIsCustomFace) {
                    this.mSetCustomFaceWithSkinValue = false;
                    i = GetHeadIndexByType(bVar.k.mHeadType, GetCurrentGender, GetCurrentAge);
                } else {
                    this.mSetCustomFaceWithSkinValue = true;
                    i = GetDefaultHeadTypeIndex(GetCurrentGender, GetCurrentAge);
                }
                f.f1467a.getClass();
                if (this.mCurrentViewType != 6) {
                    if (!SetAvatarHeadTypeWithChangeAvatarMode(6, i, true, new Runnable() {
                        public void run() {
                            int unused = FittingActivity.this.mCurrentViewType = 6;
                            FittingActivity.this.SwitchCurrentUIView();
                        }
                    })) {
                        Log.e(TAG, "[ERROR] :: failed to SetAvatarHeadTypeWithChangeAvatarMode");
                    }
                } else if (!SetAvatarHeadType(i, true, new Runnable() {
                    public void run() {
                        if (FittingActivity.this.mBottomContainer != null) {
                            int childCount = FittingActivity.this.mBottomContainer.getChildCount();
                            boolean z = false;
                            int i = 0;
                            while (i < childCount) {
                                View childAt = FittingActivity.this.mBottomContainer.getChildAt(i);
                                if (childAt == null || !(childAt instanceof g)) {
                                    i++;
                                } else {
                                    g gVar = (g) childAt;
                                    if (FittingActivity.this.mRequestInfoForCustomFace != null) {
                                        z = FittingActivity.this.mRequestInfoForCustomFace.c;
                                    }
                                    gVar.a(z);
                                    return;
                                }
                            }
                        }
                    }
                })) {
                    Log.e(TAG, "[ERROR] :: failed to SetAvatarHeadType");
                }
                z = false;
            } else {
                Log.e(TAG, "[ERROR] :: NOT found custom face data.");
            }
        } else {
            String str = TAG;
            Log.e(str, "[ERROR] :: resultCode - " + result.resultCode);
        }
        if (z) {
            CancelToChangeCustomFace();
            if (result.resultCode == 4) {
                long j = 0;
                if (result.resultExtra != null && (result.resultExtra instanceof Long)) {
                    j = ((Long) result.resultExtra).longValue();
                }
                ShowNoSpaceErrorDialog(j, new b.a() {
                    public void b(net.fxgear.fittingmodenative.b.b bVar) {
                    }

                    public void a(net.fxgear.fittingmodenative.b.b bVar) {
                        if (FittingActivity.this.mConfirmDialog != null) {
                            FittingActivity.this.mConfirmDialog.dismiss();
                            net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                        }
                    }
                });
            } else {
                ShowConfirmDialog((String) null, getResources().getString(a.g.occurred_error_message), 1, getResources().getString(a.g.confirm), (String) null, new b.a() {
                    public void b(net.fxgear.fittingmodenative.b.b bVar) {
                    }

                    public void a(net.fxgear.fittingmodenative.b.b bVar) {
                        if (FittingActivity.this.mConfirmDialog != null) {
                            FittingActivity.this.mConfirmDialog.dismiss();
                            net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                        }
                    }
                });
            }
            this.mRequestInfoForCustomFace = null;
        }
        if (this.mFaceBitmapFile != null) {
            if (this.mFaceBitmapFile.exists()) {
                this.mFaceBitmapFile.delete();
            }
            this.mFaceBitmapFile = null;
        }
        this.mCustomFaceWorker = null;
    }

    public void OnOccurError(GlobalDefine.Result result) {
        b.a aVar;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        b.a aVar2;
        String str6;
        DismissCircleDialog();
        Resources resources = getResources();
        int i = result.resultCode;
        if (i != -3) {
            if (i != 10) {
                switch (i) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        str5 = "Unknown Error";
                        str4 = "Error code : " + result.resultCode;
                        str6 = resources.getString(a.g.confirm);
                        aVar2 = new b.a() {
                            public void b(net.fxgear.fittingmodenative.b.b bVar) {
                            }

                            public void a(net.fxgear.fittingmodenative.b.b bVar) {
                                if (FittingActivity.this.mConfirmDialog != null) {
                                    FittingActivity.this.mConfirmDialog.dismiss();
                                    net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                                }
                            }
                        };
                        break;
                    case 4:
                        str5 = resources.getString(a.g.out_of_memory_title);
                        String str7 = GlobalDefine.REAL_VIDEO_NONE_DATE;
                        if (result.resultExtra != null && (result.resultExtra instanceof Long)) {
                            str7 = f.a(((Long) result.resultExtra).longValue());
                        }
                        str4 = String.format(getResources().getString(a.g.out_of_memory_message), new Object[]{str7});
                        str6 = resources.getString(a.g.confirm);
                        aVar2 = new b.a() {
                            public void b(net.fxgear.fittingmodenative.b.b bVar) {
                            }

                            public void a(net.fxgear.fittingmodenative.b.b bVar) {
                                if (FittingActivity.this.mConfirmDialog != null) {
                                    FittingActivity.this.mConfirmDialog.dismiss();
                                    net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                                }
                            }
                        };
                        break;
                    default:
                        switch (i) {
                            case GlobalDefine.RESULT_CODE_ERROR_MALFORMEDURL:
                            case 14:
                                break;
                            default:
                                str3 = null;
                                str2 = null;
                                str = null;
                                aVar = null;
                                break;
                        }
                }
            }
            ShowOfflineModeView();
            str5 = resources.getString(a.g.network_error_title);
            str4 = resources.getString(a.g.network_error_message);
            str6 = resources.getString(a.g.confirm);
            aVar2 = new b.a() {
                public void b(net.fxgear.fittingmodenative.b.b bVar) {
                }

                public void a(net.fxgear.fittingmodenative.b.b bVar) {
                    if (FittingActivity.this.mConfirmDialog != null) {
                        FittingActivity.this.mConfirmDialog.dismiss();
                        net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                    }
                }
            };
        } else {
            str5 = "Occured critical error";
            str4 = "Error code : " + result.resultCode;
            str6 = resources.getString(a.g.confirm);
            aVar2 = new b.a() {
                public void b(net.fxgear.fittingmodenative.b.b bVar) {
                }

                public void a(net.fxgear.fittingmodenative.b.b bVar) {
                    if (FittingActivity.this.mConfirmDialog != null) {
                        FittingActivity.this.mConfirmDialog.dismiss();
                        net.fxgear.fittingmodenative.b.b unused = FittingActivity.this.mConfirmDialog = null;
                        FittingActivity.this.finish();
                    }
                }
            };
        }
        str2 = str4;
        str = str6;
        aVar = aVar2;
        str3 = str5;
        if (str3 != null && str2 != null && aVar != null) {
            ShowConfirmDialog(str3, str2, 1, str, (String) null, aVar);
        }
    }

    public void OnClothChange(FittingView.ClothesFileInfo[] clothesFileInfoArr) {
        c GetFittingData;
        int i;
        if (clothesFileInfoArr == null) {
            Log.e(TAG, "OnClothChange(), [ERROR] :: clothesIDArray is null");
        } else if (this.mMainClothesAndCategoryListView != null && this.mFittingDataList != null && (GetFittingData = GetFittingData(GetCurrentGender(), GetCurrentAge())) != null) {
            int i2 = 0;
            while (true) {
                i = -1;
                if (i2 >= clothesFileInfoArr.length) {
                    break;
                }
                FittingView.ClothesFileInfo clothesFileInfo = clothesFileInfoArr[i2];
                if (clothesFileInfo != null && (clothesFileInfo.mPackageFilePath == null || clothesFileInfo.mBaseDirectoryPath == null)) {
                    GetFittingData.b(GetFittingData.d[i2]);
                    GetFittingData.d[i2] = -1;
                }
                i2++;
            }
            this.mMainClothesAndCategoryListView.a(GetFittingData.d);
            if (GetCurrentMode() == 8) {
                GlobalDefine.ClothesSize clothesSize = null;
                e.a a2 = GetFittingData.a();
                if (a2 != null) {
                    clothesSize = a2.e;
                    i = a2.i.f1461a;
                }
                this.mMainClothesAndCategoryListView.a(i, clothesSize);
                this.mMainClothesAndCategoryListView.a(clothesSize);
            }
        }
    }

    public void OnOneClick() {
        Log.i(TAG, "OnOneClick()");
        super.OnOneClick();
        if (this.mMainClothesAndCategoryListView == null || !this.mMainClothesAndCategoryListView.a()) {
            f.f1467a.getClass();
            if (this.mCurrentViewType == 0 || this.mCurrentViewType == 7) {
                ShowAllFittingTools(!this.mIsShowingAllFittingTools);
                return;
            }
            return;
        }
        this.mMainClothesAndCategoryListView.a(false);
    }

    public void OnDoubleClick() {
        Log.i(TAG, "OnDoubleClick()");
        super.OnDoubleClick();
        if ((this.mCurrentViewType == 0 || this.mCurrentViewType == 1 || this.mCurrentViewType == 5 || this.mCurrentViewType == 7) && sFittingRoomMode != 0) {
            ResetCamera((Runnable) null);
        }
    }

    public void OnBodySlide(boolean z) {
        Log.i(TAG, "OnBodySlide()");
        super.OnBodySlide(z);
        if ("release".equals("debug")) {
            net.fxgear.fittingmodenative.b.b bVar = new net.fxgear.fittingmodenative.b.b(this, 1);
            bVar.a(false);
            if (z) {
                bVar.b("Body Slide Up");
            } else {
                bVar.b("Body Slide Down");
            }
            bVar.c("Ok");
            bVar.a((b.a) new b.a() {
                public void b(net.fxgear.fittingmodenative.b.b bVar) {
                }

                public void a(net.fxgear.fittingmodenative.b.b bVar) {
                    bVar.dismiss();
                }
            });
            bVar.show();
        }
    }

    public boolean HasCustomFace(int i, int i2) {
        return GetFittingData(i, i2).f.k.mIsCustomFace;
    }

    public void SetStatisticsServerInfo(String str, String str2, int i) {
        f.a(str, str2, i);
    }

    private class c {

        /* renamed from: a  reason: collision with root package name */
        int f1282a = 0;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<d.a> f1283b = new ArrayList<>();
        ArrayList<e.a> c = new ArrayList<>();
        int[] d = {-1, -1, -1, -1, -1};
        LinkedHashMap<Integer, ArrayList<e.a>> e = new LinkedHashMap<>();
        b f = null;

        public c() {
        }

        public e.a a() {
            synchronized (this.c) {
                ArrayList arrayList = this.e.get(Integer.valueOf(this.f1283b.get(this.f1282a).f1355a));
                int size = this.c.size();
                if (size > 0) {
                    for (int i = size - 1; i >= 0; i--) {
                        e.a aVar = this.c.get(i);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            if (aVar.i.f1461a == ((e.a) it.next()).i.f1461a) {
                                return aVar;
                            }
                        }
                    }
                }
                return null;
            }
        }

        public void a(int i) {
            synchronized (this.c) {
                b(i);
                Iterator it = this.e.get(Integer.valueOf(this.f1283b.get(this.f1282a).f1355a)).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    e.a aVar = (e.a) it.next();
                    if (aVar.i.f1461a == i) {
                        this.c.add(aVar);
                        break;
                    }
                }
            }
        }

        public void b(int i) {
            synchronized (this.c) {
                Iterator<e.a> it = this.c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    e.a next = it.next();
                    if (next.i.f1461a == i) {
                        this.c.remove(next);
                        break;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public int GetHeadTypeByIndex(int i, int i2, int i3) {
        return AvatarSetting.GetHeadTypeByIndex(this, i, i2, i3);
    }

    /* access modifiers changed from: private */
    public int GetHairTypeByIndex(int i, int i2, int i3) {
        return AvatarSetting.GetHairTypeByIndex(this, i, i2, i3);
    }

    private int GetHeadIndexByType(int i, int i2, int i3) {
        return AvatarSetting.GetIndexOfHeadType(this, i, i2, i3);
    }

    private int GetHairIndexByType(int i, int i2, int i3) {
        return AvatarSetting.GetIndexOfHairType(this, i, i2, i3);
    }

    /* access modifiers changed from: private */
    public int GetDefaultHeadTypeIndex(int i, int i2) {
        if (AvatarSetting.IsExistHeadType(this, 2, i, i2)) {
            return GetHeadIndexByType(2, i, i2);
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public int GetDefaultHeadTypeID(int i, int i2) {
        if (AvatarSetting.IsExistHeadType(this, 2, i, i2)) {
            return 2;
        }
        return GetHeadTypeByIndex(0, i, i2);
    }

    private boolean IsValidAvatarData(b bVar) {
        boolean z;
        if (!AvatarSetting.IsExistHairType(this, bVar.k.mHairType, bVar.f1310b, bVar.f1309a)) {
            bVar.k.mHairType = GetHairTypeByIndex(0, bVar.f1310b, bVar.f1309a);
            z = false;
        } else {
            z = true;
        }
        if (AvatarSetting.IsExistHeadType(this, bVar.k.mHeadType, bVar.f1310b, bVar.f1309a)) {
            return z;
        }
        bVar.k.mHeadType = GetDefaultHeadTypeID(bVar.f1310b, bVar.f1309a);
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (strArr.length == iArr.length) {
            int length = strArr.length < iArr.length ? strArr.length : iArr.length;
            boolean z = false;
            boolean z2 = true;
            boolean z3 = true;
            for (int i2 = 0; i2 < length; i2++) {
                String str = strArr[i2];
                if (iArr[i2] != 0) {
                    if (!android.support.v4.a.a.a(this, str)) {
                        net.fxgear.fittingmodenative.b.b bVar = new net.fxgear.fittingmodenative.b.b(this, 2);
                        bVar.a((String) null);
                        bVar.b(getResources().getString(a.g.camera_access_required));
                        bVar.c(getResources().getString(a.g.confirm));
                        bVar.d(getResources().getString(a.g.cancel));
                        bVar.a((b.a) new b.a() {
                            public void a(net.fxgear.fittingmodenative.b.b bVar) {
                                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                                intent.setData(Uri.fromParts("package", FittingActivity.this.getPackageName(), (String) null));
                                FittingActivity.this.startActivity(intent);
                                bVar.dismiss();
                            }

                            public void b(net.fxgear.fittingmodenative.b.b bVar) {
                                bVar.dismiss();
                            }
                        });
                        bVar.show();
                        return;
                    }
                    z3 = false;
                }
            }
            if (z3) {
                switch (i) {
                    case 0:
                        return;
                    case 1:
                        if (this.mRequestInfoForCustomFace != null) {
                            z = this.mRequestInfoForCustomFace.c;
                        }
                        OnShowAvatarFaceCameraView(z);
                        return;
                    case 2:
                        if (this.mRequestInfoForCustomFace != null) {
                            z2 = this.mRequestInfoForCustomFace.c;
                        }
                        OnShowAvatarFaceCameraView(z2);
                        return;
                    default:
                        super.onRequestPermissionsResult(i, strArr, iArr);
                        return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void ResetClothesSize() {
        ArrayList arrayList = GetFittingData(GetCurrentGender(), GetCurrentAge()).e.get(-1);
        for (int i = 0; i < arrayList.size(); i++) {
            ((e.a) arrayList.get(i)).e = null;
        }
    }

    /* access modifiers changed from: private */
    public void SetClosestSizeToFittingClothes() {
        ArrayList arrayList;
        c GetFittingData = GetFittingData(GetCurrentGender(), GetCurrentAge());
        if (GetFittingData.f1282a == 0) {
            arrayList = GetFittingData.e.get(-1);
        } else {
            arrayList = GetFittingData.e.get(Integer.valueOf(GetFittingData.f1283b.get(GetFittingData.f1282a).f1355a));
        }
        HashMap hashMap = new HashMap();
        if (!(arrayList == null || GetFittingData.d == null)) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                e.a aVar = (e.a) it.next();
                for (int i : GetFittingData.d) {
                    if (aVar.i.f1461a == i) {
                        aVar.e = ClothesSizeProvider.GetClosestClothSize(GetCurrentGender(), GetCurrentAge(), aVar.i.d, false);
                        hashMap.put(Integer.valueOf(aVar.i.d), aVar.e);
                    }
                }
            }
        }
        SetClothesSize(hashMap, new Runnable() {
            public void run() {
                int i;
                GlobalDefine.ClothesSize clothesSize;
                if (FittingActivity.this.mMainClothesAndCategoryListView != null) {
                    e.a a2 = FittingActivity.this.GetFittingData(FittingActivity.this.GetCurrentGender(), FittingActivity.this.GetCurrentAge()).a();
                    if (a2 != null) {
                        i = a2.i.f1461a;
                        clothesSize = a2.e;
                    } else {
                        i = -1;
                        clothesSize = null;
                    }
                    FittingActivity.this.mMainClothesAndCategoryListView.a(i, clothesSize);
                    FittingActivity.this.mMainClothesAndCategoryListView.b(i, clothesSize);
                }
            }
        });
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\a\a.java ==========

package net.fxgear.fittingmodenative.a;

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
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1287a = "a";

    /* renamed from: b  reason: collision with root package name */
    private final String f1288b;
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

    /* renamed from: net.fxgear.fittingmodenative.a.a$a  reason: collision with other inner class name */
    /* compiled from: FXDiskCache */
    public static class C0039a {

        /* renamed from: a  reason: collision with root package name */
        public String f1291a = "FXDiskCache";

        /* renamed from: b  reason: collision with root package name */
        public long f1292b = 10485760;
    }

    public a(Context context, String str) {
        this(context, str, (C0039a) null);
    }

    public a(Context context, String str, C0039a aVar) {
        this.i = new Object();
        this.j = new Handler.Callback() {
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 98:
                        a.this.b();
                        return false;
                    case 99:
                        long j = 0;
                        synchronized (a.this.i) {
                            ArrayList a2 = a.this.b(a.this.e);
                            if (a2 != null) {
                                Iterator it = a2.iterator();
                                while (it.hasNext()) {
                                    j += ((File) it.next()).length();
                                }
                            }
                        }
                        if (j < a.this.f) {
                            return false;
                        }
                        a.this.d();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.d = context.getApplicationContext();
        this.f1288b = str;
        this.c = f1287a + "_" + this.f1288b;
        if (aVar == null) {
            this.f = 10485760;
            this.e = a(context, "FXDiskCache");
        } else {
            this.f = aVar.f1292b;
            this.e = a(context, aVar.f1291a);
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
            java.lang.String r0 = f1287a
            java.lang.String r1 = "DownloadFile()+"
            android.util.Log.i(r0, r1)
            r0 = 0
            if (r11 == 0) goto L_0x01ce
            if (r12 != 0) goto L_0x000e
            goto L_0x01ce
        L_0x000e:
            android.content.Context r1 = r10.d
            boolean r1 = net.fxgear.fittingmodenative.f.a((android.content.Context) r1)
            if (r1 == 0) goto L_0x01c6
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            java.lang.Thread r2 = r2.getThread()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0031
            java.lang.String r11 = f1287a
            java.lang.String r12 = "ERROR :: illegal state"
            android.util.Log.e(r11, r12)
            goto L_0x01ec
        L_0x0031:
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            boolean r1 = r1.isInterrupted()
            if (r1 == 0) goto L_0x0044
            java.lang.String r11 = f1287a
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
            java.lang.String r11 = f1287a     // Catch:{ NumberFormatException -> 0x0158, MalformedURLException -> 0x0154, IOException -> 0x0150, all -> 0x014b }
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
            java.lang.String r1 = f1287a     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            java.lang.String r3 = "cancel download"
            android.util.Log.e(r1, r3)     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            goto L_0x012d
        L_0x00bb:
            long r7 = net.fxgear.fittingmodenative.f.a((java.io.File) r1)     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x00cc
            java.lang.String r1 = f1287a     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
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
            java.lang.String r12 = f1287a     // Catch:{ NumberFormatException -> 0x0112, MalformedURLException -> 0x010d, IOException -> 0x0108, all -> 0x0103 }
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
            java.lang.String r1 = f1287a     // Catch:{ NumberFormatException -> 0x0148, MalformedURLException -> 0x0146, IOException -> 0x0144 }
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
            java.lang.String r3 = f1287a     // Catch:{ all -> 0x01ae }
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
            java.lang.String r11 = f1287a
            java.lang.String r12 = "ERROR :: network disconnected"
            android.util.Log.e(r11, r12)
            goto L_0x01ec
        L_0x01ce:
            java.lang.String r1 = f1287a
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
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.a.a.a(java.lang.String, java.lang.String):boolean");
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




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\a\b.java ==========

package net.fxgear.fittingmodenative.a;

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
import net.fxgear.fittingmodenative.a.a;

/* compiled from: FXImageCache */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1293a = "b";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f1294b;
    /* access modifiers changed from: private */
    public Context c;
    /* access modifiers changed from: private */
    public Handler d;
    private HandlerThread e;
    private HashMap<String, d> f;
    private Object g = new Object();
    private int h;
    private long i;
    private int j;
    private a k;
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
                    b.this.b((c) obj);
                    return false;
                case 2:
                    if (b.this.e()) {
                        return false;
                    }
                    b.this.f();
                    return false;
                default:
                    return false;
            }
        }
    };
    private Handler p = new Handler();

    /* renamed from: net.fxgear.fittingmodenative.a.b$b  reason: collision with other inner class name */
    /* compiled from: FXImageCache */
    public static class C0040b {

        /* renamed from: a  reason: collision with root package name */
        public static final long f1303a = ((long) Math.round(((float) Runtime.getRuntime().maxMemory()) * 0.1f));

        /* renamed from: b  reason: collision with root package name */
        public a.C0039a f1304b = new a.C0039a();
        public int c = 30;
        public long d = f1303a;
        public int e = 3;
    }

    /* compiled from: FXImageCache */
    private class d {

        /* renamed from: a  reason: collision with root package name */
        String f1307a;

        /* renamed from: b  reason: collision with root package name */
        long f1308b;
        BitmapDrawable c;

        d(String str, long j, BitmapDrawable bitmapDrawable) {
            this.f1307a = str;
            this.f1308b = j;
            this.c = bitmapDrawable;
        }
    }

    /* compiled from: FXImageCache */
    private class c {

        /* renamed from: a  reason: collision with root package name */
        String f1305a;

        /* renamed from: b  reason: collision with root package name */
        WeakReference<ImageView> f1306b;
        Runnable c;
        int d = Integer.MAX_VALUE;
        int e = Integer.MAX_VALUE;
        boolean f = false;
        int g = 0;

        c(String str, ImageView imageView, Runnable runnable) {
            this.f1305a = str;
            this.f1306b = new WeakReference<>(imageView);
            this.c = runnable;
        }
    }

    /* compiled from: FXImageCache */
    private class a extends BitmapDrawable {

        /* renamed from: a  reason: collision with root package name */
        c f1301a;

        a(Bitmap bitmap) {
            super(b.this.c.getResources(), bitmap);
        }
    }

    public b(Context context, String str, C0040b bVar) {
        this.f1294b = f1293a + "_" + str;
        this.c = context.getApplicationContext();
        if (bVar == null) {
            this.h = 30;
            this.i = C0040b.f1303a;
            this.j = 3;
            this.k = new a(context, str);
        } else {
            this.h = bVar.c;
            this.i = bVar.d;
            this.j = bVar.e;
            this.k = new a(context, str, bVar.f1304b);
        }
        this.e = new HandlerThread(this.f1294b);
        this.e.start();
        this.d = new Handler(this.e.getLooper(), this.o);
        this.f = new HashMap<>();
    }

    public void a() {
        Log.d(this.f1294b, "Pause()+");
        if (this.d != null) {
            this.d.removeMessages(1);
            this.d.removeMessages(2);
        }
    }

    public void b() {
        Log.d(this.f1294b, "Destroy()+");
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
            Log.e(this.f1294b, "ERROR :: Image view is null.");
        } else if (str == null || str.isEmpty() || str.equalsIgnoreCase("null")) {
            Log.w(this.f1294b, "WRANING :: Image URL is invalid.");
            a(imageView);
            imageView.setImageBitmap(this.l);
        } else {
            if (this.f == null || !this.f.containsKey(str)) {
                bitmapDrawable = null;
            } else {
                d dVar = this.f.get(str);
                dVar.f1308b = System.currentTimeMillis();
                bitmapDrawable = dVar.c;
            }
            if (bitmapDrawable != null) {
                Log.i(this.f1294b, "Hit Image cache.");
                a(imageView, bitmapDrawable, runnable);
            } else if (a(str, imageView)) {
                a aVar = new a(this.l);
                aVar.f1301a = new c(str, imageView, runnable);
                aVar.f1301a.d = i2;
                aVar.f1301a.e = i3;
                a(imageView, (BitmapDrawable) aVar, (Runnable) null);
                a(aVar.f1301a);
            }
        }
    }

    private void a(ImageView imageView) {
        Drawable drawable;
        c cVar;
        if (imageView != null && (drawable = imageView.getDrawable()) != null && (drawable instanceof a) && (cVar = ((a) drawable).f1301a) != null) {
            cVar.f = true;
        }
    }

    private boolean a(String str, ImageView imageView) {
        Drawable drawable;
        if (!(str == null || imageView == null || (drawable = imageView.getDrawable()) == null || !(drawable instanceof a))) {
            c cVar = ((a) drawable).f1301a;
            if (cVar == null) {
                Log.i(this.f1294b, "worker is null.");
            } else if (cVar.f1305a.equals(str)) {
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
                if (b.this.d != null) {
                    b.this.d.obtainMessage(1, cVar).sendToTarget();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(final c cVar) {
        String str;
        if (cVar == null) {
            Log.e(this.f1294b, "ERROR :: doCachingProcess, wrong param.");
            return;
        }
        String str2 = this.f1294b;
        Log.e(str2, "doCachingProcess()+, key : " + cVar.f1305a);
        cVar.g = cVar.g + 1;
        if (cVar.g > this.j && this.j != 0) {
            Log.w(this.f1294b, "[WARNING] :: Over try_caching_count.");
        } else if (cVar.f || c()) {
            Log.d(this.f1294b, "Cancel cache process.");
        } else if (cVar.f1305a != null) {
            if (a(cVar.f1305a)) {
                str = cVar.f1305a;
            } else if (this.k != null) {
                str = this.k.a(cVar.f1305a);
            } else {
                Log.e(this.f1294b, "ERROR :: DiskCache is null.");
                return;
            }
            if (cVar.f || c()) {
                Log.d(this.f1294b, "Cancel cache process.");
            } else if (str == null || str.isEmpty()) {
                Log.e(f1293a, "ERROR :: Fail to download image. File path is invalid");
                a(cVar);
            } else if (cVar.f1306b.get() != null) {
                File file = new File(str);
                if (!file.exists()) {
                    Log.e(this.f1294b, "ERROR :: Cache file not exists.");
                    a(cVar);
                } else if (file.length() == 0) {
                    Log.e(this.f1294b, "ERROR :: Cache file size is 0.");
                    file.delete();
                    a(cVar);
                } else {
                    Bitmap a2 = a(str, cVar.d, cVar.e);
                    if (a2 == null || this.c == null) {
                        Log.e(this.f1294b, "ERROR :: Fail to load bitmap.");
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(this.c.getResources(), a2);
                    if (this.p != null) {
                        a(cVar.f1305a, bitmapDrawable);
                        this.p.post(new Runnable() {
                            public void run() {
                                Drawable drawable;
                                Runnable runnable = cVar.c;
                                ImageView imageView = (ImageView) cVar.f1306b.get();
                                if (imageView != null && (drawable = imageView.getDrawable()) != null && (drawable instanceof a) && ((a) drawable).f1301a.f1305a.equals(cVar.f1305a)) {
                                    if (cVar.f) {
                                        Log.d(b.this.f1294b, "Cancel cache process on main thread.");
                                    } else {
                                        b.this.a(imageView, bitmapDrawable, runnable);
                                    }
                                }
                            }
                        });
                    }
                }
            } else {
                Log.w(this.f1294b, "WARNING :: Lose image view reference.");
            }
        } else {
            Log.e(this.f1294b, "ERROR :: Key is null.");
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
                Log.e(f1293a, "ERROR :: wrong param");
                return;
            }
            if (this.f.containsKey(str)) {
                this.f.remove(str);
            }
            this.f.put(str, new d(str, System.currentTimeMillis(), bitmapDrawable));
            d();
        }
    }

    /* access modifiers changed from: private */
    public void a(ImageView imageView, BitmapDrawable bitmapDrawable, Runnable runnable) {
        if (imageView == null || bitmapDrawable == null) {
            Log.d(this.f1294b, "WARNING :: wrong param.");
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
            Log.d(this.f1294b, "Overflow cache size");
            return false;
        }
        long j2 = 0;
        for (String str : this.f.keySet()) {
            j2 += a(this.f.get(str).c);
            if (j2 > this.i) {
                Log.d(this.f1294b, "Overflow memory size");
                return false;
            }
        }
        return true;
    }

    private long a(ArrayList<d> arrayList) {
        long j2 = 0;
        if (arrayList != null) {
            Iterator<d> it = arrayList.iterator();
            while (it.hasNext()) {
                j2 += a(it.next().c);
            }
        }
        return j2;
    }

    /* access modifiers changed from: private */
    public void f() {
        Log.i(this.f1294b, "RemoveOldMemoryCache()+");
        synchronized (this.g) {
            if (this.f != null) {
                ArrayList arrayList = new ArrayList();
                for (String str : this.f.keySet()) {
                    arrayList.add(this.f.get(str));
                }
                if (!arrayList.isEmpty()) {
                    Collections.sort(arrayList, new Comparator<d>() {
                        /* renamed from: a */
                        public int compare(d dVar, d dVar2) {
                            if (dVar.f1308b > dVar2.f1308b) {
                                return 1;
                            }
                            return dVar.f1308b < dVar2.f1308b ? -1 : 0;
                        }
                    });
                }
                while (true) {
                    if (arrayList.size() <= this.h / 2 && a((ArrayList<d>) arrayList) <= this.i / 2) {
                        break;
                    }
                    d dVar = (d) arrayList.get(0);
                    arrayList.remove(dVar);
                    this.f.remove(dVar.f1307a);
                }
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\b\a.java ==========

package net.fxgear.fittingmodenative.b;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.ContextThemeWrapper;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import net.fxgear.GlobalDefine;
import net.fxgear.a.a;

/* compiled from: CircleDialog */
public class a extends d {

    /* renamed from: a  reason: collision with root package name */
    private final float f1313a = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;

    /* renamed from: b  reason: collision with root package name */
    private TextView f1314b;

    public a(Activity activity, int i) {
        super(activity);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (i == 1) {
            setContentView(a.f.dialog_circle_message);
            this.f1314b = (TextView) findViewById(a.e.progress_message);
        } else {
            setContentView(new ProgressBar(new ContextThemeWrapper(activity, 16974126)), new WindowManager.LayoutParams(-2, -2));
        }
        setCanceledOnTouchOutside(false);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.dimAmount = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        getWindow().setAttributes(attributes);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\b\b.java ==========

package net.fxgear.fittingmodenative.b;

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
public class b extends d {

    /* renamed from: a  reason: collision with root package name */
    private final String f1315a = "ConfirmDialog";

    /* renamed from: b  reason: collision with root package name */
    private final float f1316b = 0.7f;
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
            if (i2 == 2) {
                this.i = a(context);
                this.i.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (b.this.k != null) {
                            b.this.k.b(b.this);
                        }
                    }
                });
                this.f.addView(this.i, layoutParams);
                View view = new View(context);
                view.setBackgroundResource(a.b.dialog_divider);
                this.f.addView(view, new LinearLayout.LayoutParams(context.getResources().getDimensionPixelSize(a.c.confirm_dialog_divider_width), -1));
            }
            this.j = a(context);
            this.j.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (b.this.k != null) {
                        b.this.k.a(b.this);
                    }
                }
            });
            this.f.addView(this.j, layoutParams);
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




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\b\c.java ==========

package net.fxgear.fittingmodenative.b;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import net.fxgear.a.a;

/* compiled from: CustomProgressDialog */
public class c extends d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final String f1319a = "CustomProgressDialog";

    /* renamed from: b  reason: collision with root package name */
    private final String f1320b = "%";
    private TextView c;
    private TextView d;
    private ProgressBar e;
    private Button f;
    private a g;

    /* compiled from: CustomProgressDialog */
    public interface a {
        void a();
    }

    public c(Activity activity) {
        super(activity);
        Log.i("CustomProgressDialog", "CustomProgressDialog()");
        requestWindowFeature(1);
        setContentView(a.f.dialog_custom_progress);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        this.c = (TextView) findViewById(a.e.dialog_title_text);
        this.d = (TextView) findViewById(a.e.dialog_progressvalue_text);
        this.e = (ProgressBar) findViewById(a.e.dialog_progressbar);
        this.f = (Button) findViewById(a.e.cancel_button);
        this.f.setOnClickListener(this);
        this.c.setText("TEST");
        this.f.setVisibility(0);
    }

    public void a(String str) {
        this.c.setText(str);
    }

    public void a(a aVar) {
        this.g = aVar;
    }

    public void a(int i) {
        Log.d("CustomProgressDialog", "SetProgress : " + i);
        TextView textView = this.d;
        textView.setText(i + "%");
        this.e.setProgress(i);
    }

    public void onClick(View view) {
        if (view.getId() == a.e.cancel_button && this.g != null) {
            this.g.a();
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\b\d.java ==========

package net.fxgear.fittingmodenative.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.view.Window;

/* compiled from: FXDialog */
public class d extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private int f1321a;

    private int a(int i) {
        return i | 2 | 1;
    }

    public d(Activity activity) {
        super(activity);
        this.f1321a = activity.getWindow().getDecorView().getSystemUiVisibility();
        if (Build.VERSION.SDK_INT < 19) {
            this.f1321a = a(this.f1321a);
        } else {
            this.f1321a = b(this.f1321a);
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
        getWindow().getDecorView().setSystemUiVisibility(this.f1321a);
        a(true);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\b\e.java ==========

package net.fxgear.fittingmodenative.b;

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

/* compiled from: ModeListDialog */
public class e extends d {

    /* renamed from: a  reason: collision with root package name */
    private final String f1322a = "ModeListDialog";

    /* renamed from: b  reason: collision with root package name */
    private final float f1323b = 0.7f;
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

    /* compiled from: ModeListDialog */
    public interface c {
        void a(int i, String str);
    }

    public e(Activity activity) {
        super(activity);
        requestWindowFeature(1);
        setContentView(a.f.dialog_mode_list);
        a();
        Window window = getWindow();
        window.setBackgroundDrawableResource(17170445);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.7f;
        window.setAttributes(attributes);
    }

    private void a() {
        Log.i("ModeListDialog", "InitializeDialog()+");
        this.f = new b();
        this.g = new ArrayList<>();
        this.c = (RelativeLayout) findViewById(a.e.layout_title_container);
        this.d = (TextView) findViewById(a.e.dialog_title_text);
        this.e = (ListView) findViewById(a.e.mode_list_contents);
        this.e.setAdapter(this.f);
        this.e.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.h != i) {
                    int unused = e.this.h = i;
                    int childCount = adapterView.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        a aVar = (a) view;
                        if (i2 == i) {
                            aVar.a(true);
                        } else {
                            aVar.a(false);
                        }
                    }
                    if (e.this.i != null) {
                        e.this.i.a(i, (String) e.this.g.get(i));
                        return;
                    }
                    return;
                }
                ((a) view).a(true);
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
        Log.i("ModeListDialog", "SetTitleText()+, title : " + str);
        if (str != null) {
            if (this.c.getVisibility() != 0) {
                this.c.setVisibility(0);
            }
            this.d.setText(str);
        }
    }

    /* compiled from: ModeListDialog */
    private class a extends RelativeLayout {

        /* renamed from: b  reason: collision with root package name */
        private final int f1326b;
        private final int c;
        private final int d;
        private final int e;
        private TextView f = ((TextView) findViewById(a.e.tv_item_title));
        private boolean g;

        public a(Context context) {
            super(context);
            this.c = context.getResources().getColor(a.b.dialog_text_color);
            this.f1326b = context.getResources().getColor(a.b.dialog_text_color);
            this.d = context.getResources().getColor(a.b.dialog_btn_background_normal);
            this.e = context.getResources().getColor(a.b.dialog_btn_background_pressed);
            inflate(getContext(), a.f.layout_dialog_mode_list_item, this);
        }

        public void setPressed(boolean z) {
            if (!this.g) {
                b(z);
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

        public void a(boolean z) {
            this.g = z;
            b(this.g);
        }

        public void b(boolean z) {
            if (z) {
                this.f.setTextColor(this.c);
                this.f.setPaintFlags(this.f.getPaintFlags() | 32);
                setBackgroundColor(this.e);
                return;
            }
            this.f.setTextColor(this.f1326b);
            this.f.setPaintFlags(this.f.getPaintFlags() & -33);
            setBackgroundColor(this.d);
        }
    }

    /* compiled from: ModeListDialog */
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
            aVar.a(z);
            return view;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\c\a.java ==========

package net.fxgear.fittingmodenative.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import net.fxgear.AvatarSetting;
import net.fxgear.a.a;

/* compiled from: AvatarRecyclerHorizontalSettingView */
public class a extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final String f1331a = "AvatarRecyclerHorizontalSettingView";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f1332b;
    private b c;
    private Button d;
    private Button e;
    private final int f = -1;
    private final int g = -1;
    /* access modifiers changed from: private */
    public int h = -1;
    private int i = 1;
    /* access modifiers changed from: private */
    public int j;
    /* access modifiers changed from: private */
    public int k;
    /* access modifiers changed from: private */
    public C0042a l;

    /* renamed from: net.fxgear.fittingmodenative.c.a$a  reason: collision with other inner class name */
    /* compiled from: AvatarRecyclerHorizontalSettingView */
    public interface C0042a {
        void OnClickAvatarRecyclerHorizontalSettingButton(int i, int i2, int i3);

        void OnClickAvatarRecyclerHorizontalSettingItem(int i, int i2);
    }

    /* compiled from: AvatarRecyclerHorizontalSettingView */
    private class d {

        /* renamed from: a  reason: collision with root package name */
        Drawable f1339a;

        /* renamed from: b  reason: collision with root package name */
        String f1340b;

        private d() {
        }
    }

    public a(Context context) {
        super(context);
        Log.d("AvatarRecyclerHorizontalSettingView", "AvatarRecyclerHorizontalSettingView()+");
        a(context);
    }

    private void a(Context context) {
        Log.i("AvatarRecyclerHorizontalSettingView", "Initialize()+");
        View inflate = inflate(getContext(), a.f.layout_avatar_recycler_horizontal_setting_view, this);
        this.f1332b = (RecyclerView) inflate.findViewById(a.e.setting_menu_recycler_view);
        this.c = new b();
        this.f1332b.setAdapter(this.c);
        this.f1332b.setItemViewCacheSize(0);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.b(0);
        this.f1332b.setLayoutManager(linearLayoutManager);
        this.d = (Button) inflate.findViewById(a.e.button_negative);
        this.d.setText(getResources().getString(a.g.cancel));
        this.d.setOnClickListener(this);
        this.e = (Button) inflate.findViewById(a.e.button_positive);
        this.e.setText(getResources().getString(a.g.confirm));
        this.e.setOnClickListener(this);
    }

    /* compiled from: AvatarRecyclerHorizontalSettingView */
    private class b extends RecyclerView.a<c> {

        /* renamed from: b  reason: collision with root package name */
        private final String f1338b = "RecyclerHorizontalSettingViewAdapter";
        private final int c = 3;
        private ArrayList<d> d = null;

        public b() {
            Log.i("RecyclerHorizontalSettingViewAdapter", "RecyclerHorizontalSettingViewAdapter()+");
        }

        public void a(ArrayList<d> arrayList, int i) {
            if (arrayList != null) {
                this.d = arrayList;
                int unused = a.this.j = i;
                int unused2 = a.this.k = i;
                c();
            }
        }

        public int a() {
            if (this.d != null) {
                return this.d.size();
            }
            return 0;
        }

        public void a(c cVar, int i) {
            int i2;
            int i3;
            if (cVar != null && this.d != null) {
                Resources resources = a.this.getResources();
                if (a.this.h == 2) {
                    cVar.q.setImageDrawable(this.d.get(i).f1339a);
                    cVar.r.setText(this.d.get(i).f1340b);
                } else {
                    cVar.q.setImageDrawable(this.d.get(i).f1339a);
                }
                if (cVar.f413a != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) resources.getDimension(a.c.avatar_recycler_horizontal_setting_mode_item_width), (int) resources.getDimension(a.c.avatar_recycler_horizontal_setting_mode_item_height));
                    if (this.d == null || this.d.size() <= 3) {
                        i2 = (int) resources.getDimension(a.c.avatar_recycler_horizontal_setting_mode_item_margin);
                    } else {
                        i2 = (int) resources.getDimension(a.c.avatar_man_hair_item_margin);
                    }
                    if (i == 0) {
                        i3 = (int) resources.getDimension(a.c.avatar_recycler_horizontal_setting_mode_item_edge_of_left_margin);
                    } else {
                        if (i == this.d.size() - 1) {
                            i2 = (int) resources.getDimension(a.c.avatar_recycler_horizontal_setting_mode_item_edge_of_right_margin);
                        }
                        i3 = 0;
                    }
                    layoutParams.setMargins(i3, 0, i2, 0);
                    cVar.f413a.setLayoutParams(layoutParams);
                }
                if (i == a.this.k) {
                    cVar.p.setVisibility(0);
                    cVar.q.setSelected(true);
                    return;
                }
                cVar.p.setVisibility(4);
                cVar.q.setSelected(false);
            }
        }

        /* renamed from: c */
        public c a(ViewGroup viewGroup, int i) {
            View view;
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            if (a.this.h == 2) {
                view = from.inflate(a.f.layout_avatar_recycler_setting_item_image_with_text, viewGroup, false);
            } else {
                view = from.inflate(a.f.layout_avatar_recycler_setting_item_image, viewGroup, false);
            }
            return new c(view);
        }
    }

    /* compiled from: AvatarRecyclerHorizontalSettingView */
    private class c extends RecyclerView.w implements View.OnClickListener {
        private final String o = "RecyclerSettingViewHolder";
        /* access modifiers changed from: private */
        public ImageView p;
        /* access modifiers changed from: private */
        public ImageView q;
        /* access modifiers changed from: private */
        public TextView r;

        public c(View view) {
            super(view);
            if (view != null) {
                Resources resources = a.this.getResources();
                this.p = new ImageView(view.getContext());
                int dimension = (int) resources.getDimension(a.c.avatar_recycler_horizontal_setting_mode_selected_icon_width);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimension, dimension);
                int dimension2 = (int) resources.getDimension(a.c.avatar_recycler_horizontal_setting_mode_selected_icon_margin);
                layoutParams.setMargins(0, dimension2, dimension2, 0);
                layoutParams.addRule(11);
                this.p.setLayoutParams(layoutParams);
                this.p.setImageDrawable(resources.getDrawable(a.d.ic_selected));
                ((ViewGroup) view).addView(this.p);
                this.q = (ImageView) view.findViewById(a.e.avatar_setting_item_image_view);
                this.q.setOnClickListener(this);
                if (a.this.h == 2) {
                    this.r = (TextView) view.findViewById(a.e.avatar_setting_item_text_view);
                    this.r.setVisibility(0);
                }
            }
        }

        public void onClick(View view) {
            if (view != null && a.this.l != null && view.getId() == a.e.avatar_setting_item_image_view) {
                int e = e();
                if (e != -1) {
                    int b2 = a.this.k;
                    int unused = a.this.k = e;
                    if (a.this.f1332b != null) {
                        c cVar = (c) a.this.f1332b.b(b2);
                        if (cVar != null) {
                            cVar.p.setVisibility(4);
                            cVar.q.setSelected(false);
                        }
                        c cVar2 = (c) a.this.f1332b.b(a.this.k);
                        if (cVar2 != null) {
                            cVar2.p.setVisibility(0);
                            cVar2.q.setSelected(true);
                        }
                    }
                    if (a.this.l != null) {
                        a.this.l.OnClickAvatarRecyclerHorizontalSettingItem(a.this.h, a.this.k);
                        return;
                    }
                    return;
                }
                Log.e("RecyclerSettingViewHolder", "[ERROR] onClick - NO_POSITION");
            }
        }
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.h = i2;
        this.i = i3;
        ArrayList arrayList = new ArrayList();
        switch (this.h) {
            case 2:
                ArrayList<AvatarSetting.TypeResource> GetHeadTypeResources = AvatarSetting.GetHeadTypeResources(getContext(), i3, i4);
                for (int i6 = 0; i6 < GetHeadTypeResources.size(); i6++) {
                    AvatarSetting.TypeResource typeResource = GetHeadTypeResources.get(i6);
                    StateListDrawable stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{-16842913}, new BitmapDrawable(getResources(), BitmapFactory.decodeFile(typeResource.mNormalThumbnailPath)));
                    stateListDrawable.addState(new int[]{16842913}, new BitmapDrawable(getResources(), BitmapFactory.decodeFile(typeResource.mSelectedThumbnailPath)));
                    d dVar = new d();
                    dVar.f1339a = stateListDrawable;
                    dVar.f1340b = typeResource.mDescriptionText;
                    arrayList.add(dVar);
                }
                break;
            case 3:
                ArrayList<AvatarSetting.TypeResource> GetHairTypeResources = AvatarSetting.GetHairTypeResources(getContext(), i3, i4);
                for (int i7 = 0; i7 < GetHairTypeResources.size(); i7++) {
                    d dVar2 = new d();
                    dVar2.f1339a = new BitmapDrawable(getResources(), BitmapFactory.decodeFile(GetHairTypeResources.get(i7).mNormalThumbnailPath));
                    dVar2.f1340b = null;
                    arrayList.add(dVar2);
                }
                break;
            default:
                Log.e("AvatarRecyclerHorizontalSettingView", "[ERROR] :: viewType is wrong, viewType: " + i2);
                return;
        }
        if (this.c != null) {
            this.c.a((ArrayList<d>) arrayList, i5);
        }
    }

    public void a() {
        Log.d("AvatarRecyclerHorizontalSettingView", "Finalize()+");
        if (this.f1332b != null) {
            this.f1332b.removeAllViews();
            this.f1332b = null;
        }
        this.c = null;
        if (this.e != null) {
            this.e.setOnClickListener((View.OnClickListener) null);
            this.e = null;
        }
        if (this.d != null) {
            this.d.setOnClickListener((View.OnClickListener) null);
            this.d = null;
        }
        this.l = null;
    }

    public void onClick(View view) {
        int i2;
        if (view != null) {
            int id = view.getId();
            if (id == a.e.button_negative) {
                i2 = 0;
            } else if (id == a.e.button_positive) {
                i2 = 1;
            } else {
                Log.e("AvatarRecyclerHorizontalSettingView", "wrong click");
                return;
            }
            if (this.l != null) {
                this.l.OnClickAvatarRecyclerHorizontalSettingButton(this.h, i2, this.k);
            }
        }
    }

    public void a(C0042a aVar) {
        this.l = aVar;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\c\b.java ==========

package net.fxgear.fittingmodenative.c;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import net.fxgear.a.a;

/* compiled from: AvatarSettingModeView */
public class b extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private final String f1341a = "AvatarSettingModeView";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public c f1342b;
    private RecyclerView c;
    private a d;
    private boolean e;
    /* access modifiers changed from: private */
    public Context f;

    /* compiled from: AvatarSettingModeView */
    public interface c {
        void OnClickAvatarSettingButton(int i);
    }

    public b(Context context) {
        super(context);
        Log.i("AvatarSettingModeView", "AvatarSettingModeView()+");
        this.f = context;
        b();
    }

    private void b() {
        Log.i("AvatarSettingModeView", "Initialize()+");
        this.c = (RecyclerView) inflate(getContext(), a.f.layout_recycler_view_horizontal, this).findViewById(a.e.recycler_view);
        this.d = new a();
        this.c.setAdapter(this.d);
        this.c.setItemViewCacheSize(0);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f);
        linearLayoutManager.b(0);
        this.c.setLayoutManager(linearLayoutManager);
    }

    /* compiled from: AvatarSettingModeView */
    private class a extends RecyclerView.a<C0043b> {

        /* renamed from: b  reason: collision with root package name */
        private final String f1344b = "AvatarSettingModeRecyclerViewAdapter";
        private final float c = 0.25f;
        private ArrayList<String> d;

        public a() {
            Log.i("AvatarSettingModeRecyclerViewAdapter", "AvatarSettingModeRecyclerViewAdapter()+");
            this.d = new ArrayList<>();
        }

        public void a(ArrayList<String> arrayList) {
            if (this.d != null) {
                this.d.clear();
                this.d.addAll(arrayList);
            }
            c();
        }

        public int a() {
            if (this.d != null) {
                return this.d.size();
            }
            return 0;
        }

        public void a(C0043b bVar, int i) {
            if (bVar != null) {
                bVar.p.setText(this.d.get(i));
            }
        }

        /* renamed from: c */
        public C0043b a(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(b.this.f).inflate(a.f.layout_avatar_setting_mode_view_recycler_item, viewGroup, false);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) b.this.f.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            inflate.setLayoutParams(new RelativeLayout.LayoutParams((int) (((float) displayMetrics.widthPixels) * 0.25f), -1));
            return new C0043b(inflate);
        }
    }

    /* renamed from: net.fxgear.fittingmodenative.c.b$b  reason: collision with other inner class name */
    /* compiled from: AvatarSettingModeView */
    private class C0043b extends RecyclerView.w implements View.OnClickListener {
        private final String o = "AvatarSettingModeViewHolder";
        /* access modifiers changed from: private */
        public TextView p;

        public C0043b(View view) {
            super(view);
            if (view != null) {
                this.p = (TextView) view.findViewById(a.e.avatar_setting_mode_item_textView);
                this.p.setOnClickListener(this);
            }
        }

        public void onClick(View view) {
            if (view != null && view.getId() == a.e.avatar_setting_mode_item_textView) {
                int e = e();
                if (e == -1) {
                    Log.e("AvatarSettingModeViewHolder", "[ERROR] onClick - NO_POSITION");
                } else if (b.this.f1342b != null) {
                    b.this.f1342b.OnClickAvatarSettingButton(e);
                }
            }
        }
    }

    public void a(ArrayList<String> arrayList, boolean z) {
        if (this.d != null) {
            this.e = z;
            this.d.a(arrayList);
            this.d.c();
        }
    }

    public void a() {
        Log.d("AvatarSettingModeView", "Finalize()+");
        if (this.c != null) {
            this.c.removeAllViews();
            this.c = null;
        }
        this.d = null;
        this.f1342b = null;
        this.f = null;
    }

    public void a(c cVar) {
        this.f1342b = cVar;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\c\c.java ==========

package net.fxgear.fittingmodenative.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import net.fxgear.AvatarSetting;
import net.fxgear.BodySizeData;
import net.fxgear.GlobalDefine;
import net.fxgear.a.a;
import net.fxgear.fittingmodenative.f;

/* compiled from: BodySizeSettingView */
public class c extends RelativeLayout implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f1345a = "c";
    private TextView A;
    private TextView B;
    private LinearLayout C;
    private TextView D;
    private d E;

    /* renamed from: b  reason: collision with root package name */
    private final String f1346b = "%1$s\n(%2$s)";
    private final String c = "cm";
    private final float d = ((float) Math.pow(10.0d, 6.0d));
    private boolean e;
    private Context f;
    private Button g;
    private Button h;
    private HashMap<Integer, a> i;
    /* access modifiers changed from: private */
    public HashMap<Integer, a> j;
    /* access modifiers changed from: private */
    public int k;
    private int l;
    private int m;
    private RelativeLayout n;
    private LinearLayout o;
    private CheckBox p;
    private CheckBox q;
    private CheckBox r;
    private ArrayList<String> s;
    private RelativeLayout t;
    private RecyclerView u;
    private b v;
    private View w;
    private TextView x;
    private SeekBar y;
    private TextView z;

    /* compiled from: BodySizeSettingView */
    public interface d {
        double GetBodySizeMaxThresholdValue(int i);

        double GetBodySizeMinThresholdValue(int i);

        void OnBodySizeSettingProgressChanged(int i, float f);

        BodySizeData OnBodySizeSettingStopTracking(int i, float f);

        void OnClickBodySizeSettingButton(int i, BodySizeData bodySizeData);

        BodySizeData OnClickGoToDetailedBodySizeSettingMenuButton();
    }

    public c(Context context) {
        super(context);
        Log.i(f1345a, "BodySizeSettingView()+");
        a(context);
    }

    public void a(Context context) {
        Log.i(f1345a, "Initialize()+");
        this.f = context;
        View inflate = LayoutInflater.from(this.f).inflate(a.f.layout_body_size_setting_view, this);
        this.i = new HashMap<>();
        this.j = new HashMap<>();
        this.k = -1;
        this.l = 1;
        this.m = 2;
        this.n = (RelativeLayout) inflate.findViewById(a.e.body_size_setting_menu_easy_setting_layout);
        this.o = (LinearLayout) inflate.findViewById(a.e.body_size_setting_menu_checkbox_layout);
        this.p = (CheckBox) inflate.findViewById(a.e.body_size_setting_menu_tall_checkbox);
        this.p.setTag(0);
        this.p.setOnClickListener(this);
        this.q = (CheckBox) inflate.findViewById(a.e.body_size_setting_menu_upper_body_checkbox);
        this.q.setTag(1);
        this.q.setOnClickListener(this);
        this.r = (CheckBox) inflate.findViewById(a.e.body_size_setting_menu_lower_body_checkbox);
        this.r.setTag(2);
        this.r.setOnClickListener(this);
        ((Button) inflate.findViewById(a.e.go_to_detailed_body_setting_menu_btn)).setOnClickListener(this);
        this.t = (RelativeLayout) inflate.findViewById(a.e.body_size_setting_menu_detailed_setting_layout);
        ((Button) this.t.findViewById(a.e.back_to_easy_body_setting_menu_btn)).setOnClickListener(this);
        this.u = (RecyclerView) inflate.findViewById(a.e.body_setting_menu_recycler_view);
        this.v = new b();
        this.u.setAdapter(this.v);
        this.u.setItemViewCacheSize(0);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f);
        linearLayoutManager.b(0);
        this.u.setLayoutManager(linearLayoutManager);
        this.w = (RelativeLayout) inflate.findViewById(a.e.body_size_set_up_seekbar_layout);
        this.x = (TextView) inflate.findViewById(a.e.body_size_setting_menu_title);
        this.y = (SeekBar) inflate.findViewById(a.e.body_size_setting_menu_seekbar);
        this.y.setOnSeekBarChangeListener(this);
        this.z = (TextView) inflate.findViewById(a.e.body_size_setting_menu_seekbar_min_tv);
        this.B = (TextView) inflate.findViewById(a.e.body_size_setting_menu_seekbar_max_tv);
        this.A = (TextView) inflate.findViewById(a.e.body_size_setting_menu_seekbar_middle_tv);
        this.C = (LinearLayout) inflate.findViewById(a.e.body_size_setting_menu_seekbar_point_layout);
        this.D = (TextView) inflate.findViewById(a.e.body_size_setting_menu_current_value);
        this.g = (Button) inflate.findViewById(a.e.button_negative);
        this.g.setText(getResources().getString(a.g.cancel));
        this.g.setOnClickListener(this);
        this.h = (Button) inflate.findViewById(a.e.button_positive);
        this.h.setText(getResources().getString(a.g.confirm));
        this.h.setOnClickListener(this);
    }

    /* compiled from: BodySizeSettingView */
    private class b extends RecyclerView.a<C0045c> {

        /* renamed from: b  reason: collision with root package name */
        private final String f1350b = b.class.getSimpleName();
        private final float c = 0.33f;
        private float d;

        public b() {
            Log.i(this.f1350b, "DetailedBodySizeSettingRecyclerViewAdapter()+");
        }

        public int a() {
            if (c.this.j != null) {
                return c.this.j.size() - 2;
            }
            return 0;
        }

        public void a(C0045c cVar, int i) {
            if (cVar != null && c.this.j != null) {
                ViewGroup.LayoutParams layoutParams = cVar.f413a.getLayoutParams();
                if (i == (c.this.j.size() - 2) - 1) {
                    layoutParams.width = (int) (this.d - 1.0f);
                } else {
                    layoutParams.width = (int) this.d;
                }
                cVar.f413a.setLayoutParams(layoutParams);
                int a2 = c.this.e(i);
                a aVar = (a) c.this.j.get(Integer.valueOf(a2));
                if (aVar != null) {
                    cVar.p.setTag(Integer.valueOf(a2));
                    String.valueOf(Math.round(aVar.c));
                    if (aVar.f1347a == 14) {
                        cVar.p.setText(String.format("%1$s\n(%2$s)", new Object[]{aVar.f1348b, c.this.a(aVar.c)}));
                    } else {
                        String valueOf = String.valueOf(Math.round(aVar.c));
                        CheckBox a3 = cVar.p;
                        a3.setText(String.format("%1$s\n(%2$s)", new Object[]{aVar.f1348b, valueOf + "cm"}));
                    }
                    if (a2 == c.this.k) {
                        cVar.p.setChecked(true);
                    } else {
                        cVar.p.setChecked(false);
                    }
                }
            }
        }

        /* renamed from: c */
        public C0045c a(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(a.f.layout_body_size_recycler_setting_item_checkbox, viewGroup, false);
            Resources resources = c.this.getResources();
            this.d = (resources.getDimension(a.c.device_screen_width) - resources.getDimension(a.c.body_size_setting_mode_go_to_detailed_btn_width)) * 0.33f;
            inflate.setLayoutParams(new RecyclerView.i((int) this.d, -1));
            return new C0045c(inflate);
        }
    }

    /* renamed from: net.fxgear.fittingmodenative.c.c$c  reason: collision with other inner class name */
    /* compiled from: BodySizeSettingView */
    private class C0045c extends RecyclerView.w implements View.OnClickListener {
        private final String o = C0045c.class.getSimpleName();
        /* access modifiers changed from: private */
        public CheckBox p;

        public C0045c(View view) {
            super(view);
            if (view != null) {
                this.p = (CheckBox) view.findViewById(a.e.body_size_setting_item_checkbox);
                this.p.setOnClickListener(this);
            }
        }

        public void onClick(View view) {
            if (view != null && view.getId() == a.e.body_size_setting_item_checkbox) {
                int e = e();
                if (e != -1) {
                    int a2 = c.this.e(e);
                    a aVar = (a) c.this.j.get(Integer.valueOf(a2));
                    if (aVar == null) {
                        return;
                    }
                    if (a2 == c.this.k) {
                        c.this.a(false, -1);
                        return;
                    }
                    c.this.a(aVar.f1347a);
                    c.this.a(true, aVar.f1347a);
                    return;
                }
                Log.e(this.o, "[ERROR] onClick - NO_POSITION");
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        if (this.j != null && this.u != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.u.getLayoutManager();
            int m2 = linearLayoutManager.m();
            for (int l2 = linearLayoutManager.l(); l2 <= m2; l2++) {
                C0045c cVar = (C0045c) this.u.b(l2);
                if (cVar != null) {
                    Object tag = cVar.p.getTag();
                    if (tag != null) {
                        int intValue = ((Integer) tag).intValue();
                        a aVar = this.j.get(Integer.valueOf(intValue));
                        if (aVar == null || aVar.f1347a != i2) {
                            cVar.p.setChecked(false);
                        } else {
                            this.k = intValue;
                            cVar.p.setChecked(true);
                        }
                    } else {
                        Log.e(f1345a, "SetDetailedBodySizeItemCheckBoxChecked(), holderTag is null");
                    }
                }
            }
        }
    }

    public void a() {
        Log.d(f1345a, "Finalize()+");
        if (this.u != null) {
            this.u.removeAllViews();
            this.u = null;
        }
        this.v = null;
        if (this.p != null) {
            this.p.setOnClickListener((View.OnClickListener) null);
            this.p = null;
        }
        if (this.q != null) {
            this.q.setOnClickListener((View.OnClickListener) null);
            this.q = null;
        }
        if (this.r != null) {
            this.r.setOnClickListener((View.OnClickListener) null);
            this.r = null;
        }
        if (this.y != null) {
            this.y.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) null);
            this.y = null;
        }
        if (this.h != null) {
            this.h.setOnClickListener((View.OnClickListener) null);
            this.h = null;
        }
        if (this.g != null) {
            this.g.setOnClickListener((View.OnClickListener) null);
            this.g = null;
        }
        this.E = null;
        this.f = null;
    }

    /* compiled from: BodySizeSettingView */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f1347a;

        /* renamed from: b  reason: collision with root package name */
        public String f1348b;
        public float c;
        public float d;
        public float e;

        public a() {
            this.f1347a = -1;
            this.f1348b = null;
            this.c = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            this.d = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            this.e = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        }

        public a(a aVar) {
            if (aVar != null) {
                this.f1347a = aVar.f1347a;
                this.f1348b = aVar.f1348b;
                this.c = aVar.c;
                this.d = aVar.d;
                this.e = aVar.e;
                return;
            }
            Log.e(c.f1345a, "BodySizeMenuInfo(BodySizeMenuInfo sourceInfo), sourceInfo is null");
        }
    }

    public void a(int i2, int i3, BodySizeData bodySizeData) {
        String str = f1345a;
        Log.i(str, "InitBodySizeMenu()+, gender: " + i2 + ", age: " + i3);
        this.l = i2;
        this.m = i3;
        if (this.s == null) {
            this.s = new ArrayList<>();
        }
        this.s.clear();
        this.s = AvatarSetting.GetBodySizeTextList(getContext(), i2, i3);
        if (this.i != null) {
            this.i.clear();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(Arrays.asList(getResources().getStringArray(a.C0023a.avatar_body_size_setting_menu)));
            a aVar = new a();
            aVar.f1347a = 0;
            aVar.f1348b = (String) arrayList.get(0);
            aVar.c = bodySizeData.mTallSize;
            aVar.d = (float) AvatarSetting.GetMinimumOfBodyPart(this.f, this.l, this.m, aVar.f1347a);
            aVar.e = (float) AvatarSetting.GetMaximumOfBodyPart(this.f, this.l, this.m, aVar.f1347a);
            this.i.put(0, aVar);
            a aVar2 = new a();
            aVar2.f1347a = 5;
            aVar2.f1348b = (String) arrayList.get(1);
            aVar2.c = bodySizeData.mUpperSize;
            aVar2.d = (float) AvatarSetting.GetMinimumOfBodyPart(this.f, this.l, this.m, aVar2.f1347a);
            aVar2.e = (float) AvatarSetting.GetMaximumOfBodyPart(this.f, this.l, this.m, aVar2.f1347a);
            this.i.put(1, aVar2);
            a aVar3 = new a();
            aVar3.f1347a = 6;
            aVar3.f1348b = (String) arrayList.get(2);
            aVar3.c = bodySizeData.mLowerSize;
            aVar3.d = (float) AvatarSetting.GetMinimumOfBodyPart(this.f, this.l, this.m, aVar3.f1347a);
            aVar3.e = (float) AvatarSetting.GetMaximumOfBodyPart(this.f, this.l, this.m, aVar3.f1347a);
            this.i.put(2, aVar3);
            a aVar4 = new a();
            aVar4.f1347a = 14;
            aVar4.f1348b = (String) arrayList.get(3);
            aVar4.c = bodySizeData.mHeadHeight;
            aVar4.d = (float) AvatarSetting.GetMinimumOfBodyPart(this.f, this.l, this.m, aVar4.f1347a);
            aVar4.e = (float) AvatarSetting.GetMaximumOfBodyPart(this.f, this.l, this.m, aVar4.f1347a);
            this.i.put(3, aVar4);
            a aVar5 = new a();
            aVar5.f1347a = 1;
            aVar5.f1348b = (String) arrayList.get(4);
            aVar5.c = bodySizeData.mShoulderSize;
            aVar5.d = (float) AvatarSetting.GetMinimumOfBodyPart(this.f, this.l, this.m, aVar5.f1347a);
            aVar5.e = (float) AvatarSetting.GetMaximumOfBodyPart(this.f, this.l, this.m, aVar5.f1347a);
            this.i.put(4, aVar5);
            a aVar6 = new a();
            aVar6.f1347a = 7;
            aVar6.f1348b = (String) arrayList.get(5);
            aVar6.c = bodySizeData.mBustSize;
            aVar6.d = (float) AvatarSetting.GetMinimumOfBodyPart(this.f, this.l, this.m, aVar6.f1347a);
            aVar6.e = (float) AvatarSetting.GetMaximumOfBodyPart(this.f, this.l, this.m, aVar6.f1347a);
            this.i.put(5, aVar6);
            if (this.l == 1 && this.m == 2) {
                a aVar7 = new a();
                aVar7.f1347a = 8;
                aVar7.f1348b = (String) arrayList.get(6);
                aVar7.c = bodySizeData.mCupSize;
                aVar7.d = (float) AvatarSetting.GetMinimumOfBodyPart(this.f, this.l, this.m, aVar7.f1347a);
                aVar7.e = (float) AvatarSetting.GetMaximumOfBodyPart(this.f, this.l, this.m, aVar7.f1347a);
                this.i.put(6, aVar7);
            }
            a aVar8 = new a();
            aVar8.f1347a = 9;
            aVar8.f1348b = (String) arrayList.get(7);
            aVar8.c = bodySizeData.mWaistSize;
            aVar8.d = (float) AvatarSetting.GetMinimumOfBodyPart(this.f, this.l, this.m, aVar8.f1347a);
            aVar8.e = (float) AvatarSetting.GetMaximumOfBodyPart(this.f, this.l, this.m, aVar8.f1347a);
            this.i.put(7, aVar8);
            a aVar9 = new a();
            aVar9.f1347a = 11;
            aVar9.f1348b = (String) arrayList.get(8);
            aVar9.c = bodySizeData.mHipSize;
            aVar9.d = (float) AvatarSetting.GetMinimumOfBodyPart(this.f, this.l, this.m, aVar9.f1347a);
            aVar9.e = (float) AvatarSetting.GetMaximumOfBodyPart(this.f, this.l, this.m, aVar9.f1347a);
            this.i.put(8, aVar9);
            a aVar10 = new a();
            aVar10.f1347a = 2;
            aVar10.f1348b = (String) arrayList.get(9);
            aVar10.c = bodySizeData.mArmLengthSize;
            aVar10.d = (float) AvatarSetting.GetMinimumOfBodyPart(this.f, this.l, this.m, aVar10.f1347a);
            aVar10.e = (float) AvatarSetting.GetMaximumOfBodyPart(this.f, this.l, this.m, aVar10.f1347a);
            this.i.put(9, aVar10);
            a aVar11 = new a();
            aVar11.f1347a = 10;
            aVar11.f1348b = (String) arrayList.get(10);
            aVar11.c = bodySizeData.mArmThickSize;
            aVar11.d = (float) AvatarSetting.GetMinimumOfBodyPart(this.f, this.l, this.m, aVar11.f1347a);
            aVar11.e = (float) AvatarSetting.GetMaximumOfBodyPart(this.f, this.l, this.m, aVar11.f1347a);
            this.i.put(10, aVar11);
            a aVar12 = new a();
            aVar12.f1347a = 3;
            aVar12.f1348b = (String) arrayList.get(11);
            aVar12.c = bodySizeData.mThighLengthSize;
            aVar12.d = (float) AvatarSetting.GetMinimumOfBodyPart(this.f, this.l, this.m, aVar12.f1347a);
            aVar12.e = (float) AvatarSetting.GetMaximumOfBodyPart(this.f, this.l, this.m, aVar12.f1347a);
            this.i.put(11, aVar12);
            a aVar13 = new a();
            aVar13.f1347a = 12;
            aVar13.f1348b = (String) arrayList.get(12);
            aVar13.c = bodySizeData.mThighThickSize;
            aVar13.d = (float) AvatarSetting.GetMinimumOfBodyPart(this.f, this.l, this.m, aVar13.f1347a);
            aVar13.e = (float) AvatarSetting.GetMaximumOfBodyPart(this.f, this.l, this.m, aVar13.f1347a);
            this.i.put(12, aVar13);
            a aVar14 = new a();
            aVar14.f1347a = 4;
            aVar14.f1348b = (String) arrayList.get(13);
            aVar14.c = bodySizeData.mCalfLengthSize;
            aVar14.d = (float) AvatarSetting.GetMinimumOfBodyPart(this.f, this.l, this.m, aVar14.f1347a);
            aVar14.e = (float) AvatarSetting.GetMaximumOfBodyPart(this.f, this.l, this.m, aVar14.f1347a);
            this.i.put(13, aVar14);
            if (this.j != null) {
                this.j.clear();
                for (Integer intValue : this.i.keySet()) {
                    int intValue2 = intValue.intValue();
                    this.j.put(Integer.valueOf(intValue2), new a(this.i.get(Integer.valueOf(intValue2))));
                }
                c();
                if (this.v != null) {
                    this.v.c();
                }
            }
        }
    }

    private void c() {
        String str;
        if (this.j != null && this.o != null) {
            int childCount = this.o.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.o.getChildAt(i2);
                if (childAt != null && (childAt instanceof CheckBox)) {
                    CheckBox checkBox = (CheckBox) childAt;
                    Object tag = checkBox.getTag();
                    if (tag != null) {
                        int intValue = ((Integer) tag).intValue();
                        a aVar = this.j.get(Integer.valueOf(intValue));
                        if (aVar != null) {
                            int round = Math.round(aVar.c);
                            if (aVar.f1347a == 0) {
                                str = String.valueOf(round) + "cm";
                            } else {
                                str = b(round);
                            }
                            checkBox.setText(String.format("%1$s\n(%2$s)", new Object[]{aVar.f1348b, str}));
                            if (intValue == this.k) {
                                checkBox.setChecked(true);
                            } else {
                                checkBox.setChecked(false);
                            }
                        }
                    } else {
                        Log.e(f1345a, "UpdateEasySettingBodySizeMenu(), subViewTag is null");
                    }
                }
            }
        }
    }

    public void a(BodySizeData bodySizeData) {
        if (bodySizeData == null) {
            Log.e(f1345a, "[ERROR] :: UpdateBodySizeMenuData(), bodySizeData is null");
        } else if (this.j != null) {
            this.j.get(0).c = bodySizeData.mTallSize;
            this.j.get(1).c = bodySizeData.mUpperSize;
            this.j.get(2).c = bodySizeData.mLowerSize;
            this.j.get(3).c = bodySizeData.mHeadHeight;
            this.j.get(4).c = bodySizeData.mShoulderSize;
            this.j.get(5).c = bodySizeData.mBustSize;
            if (this.l == 1 && this.m == 2) {
                this.j.get(6).c = bodySizeData.mCupSize;
            }
            this.j.get(7).c = bodySizeData.mWaistSize;
            this.j.get(8).c = bodySizeData.mHipSize;
            this.j.get(9).c = bodySizeData.mArmLengthSize;
            this.j.get(10).c = bodySizeData.mArmThickSize;
            this.j.get(11).c = bodySizeData.mThighLengthSize;
            this.j.get(12).c = bodySizeData.mThighThickSize;
            this.j.get(13).c = bodySizeData.mCalfLengthSize;
            if (!this.e) {
                c();
            } else if (this.v != null) {
                this.v.c();
            }
        }
    }

    private BodySizeData a(HashMap<Integer, a> hashMap) {
        if (hashMap == null) {
            return null;
        }
        BodySizeData bodySizeData = new BodySizeData();
        bodySizeData.mTallSize = hashMap.get(0).c;
        bodySizeData.mUpperSize = hashMap.get(1).c;
        bodySizeData.mLowerSize = hashMap.get(2).c;
        bodySizeData.mHeadHeight = hashMap.get(3).c;
        bodySizeData.mShoulderSize = hashMap.get(4).c;
        bodySizeData.mBustSize = hashMap.get(5).c;
        if (this.l == 1 && this.m == 2) {
            bodySizeData.mCupSize = hashMap.get(6).c;
        } else {
            bodySizeData.mCupSize = (float) AvatarSetting.GetDefaultOfBodyPart(this.f, this.l, this.m, 8);
        }
        bodySizeData.mWaistSize = hashMap.get(7).c;
        bodySizeData.mHipSize = hashMap.get(8).c;
        bodySizeData.mArmLengthSize = hashMap.get(9).c;
        bodySizeData.mArmThickSize = hashMap.get(10).c;
        bodySizeData.mThighLengthSize = hashMap.get(11).c;
        bodySizeData.mThighThickSize = hashMap.get(12).c;
        bodySizeData.mCalfLengthSize = hashMap.get(13).c;
        return bodySizeData;
    }

    private String b(int i2) {
        return this.s.get(i2);
    }

    /* access modifiers changed from: private */
    public String a(float f2) {
        String str = f1345a;
        Log.d(str, "GetHeadSizeStringValue " + f2);
        a aVar = this.j.get(3);
        float f3 = aVar.e;
        float f4 = aVar.d;
        float f5 = (f3 - f4) / 4.0f;
        if (f2 <= f4 + f5) {
            return "S";
        }
        return f2 > f3 - f5 ? "L" : "M";
    }

    public void a(boolean z2, boolean z3) {
        String str = f1345a;
        Log.e(str, "SwitchBodySizeSettingMenu()+, isDetailedSettingMenu: " + z2 + ", animated: " + z3);
        if (this.n != null && this.t != null) {
            this.e = z2;
            if (this.e) {
                c(-1);
                a(false, -1);
                this.n.setVisibility(4);
                this.t.setVisibility(0);
                return;
            }
            a(-1);
            a(false, -1);
            this.t.setVisibility(4);
            this.n.setVisibility(0);
        }
    }

    public void a(boolean z2, int i2) {
        String str;
        String str2;
        if (this.w == null) {
            return;
        }
        if (z2) {
            this.w.setVisibility(0);
            if (this.C != null) {
                if (i2 == 5 || i2 == 6) {
                    this.C.setVisibility(0);
                } else {
                    this.C.setVisibility(4);
                }
            }
            if (this.j != null) {
                for (Integer intValue : this.j.keySet()) {
                    a aVar = this.j.get(Integer.valueOf(intValue.intValue()));
                    if (aVar != null && i2 == aVar.f1347a) {
                        if (this.x != null) {
                            this.x.setText(aVar.f1348b);
                        }
                        if (this.E != null) {
                            float GetBodySizeMinThresholdValue = (float) this.E.GetBodySizeMinThresholdValue(i2);
                            float GetBodySizeMaxThresholdValue = (float) this.E.GetBodySizeMaxThresholdValue(i2);
                            if (aVar.c < GetBodySizeMinThresholdValue) {
                                aVar.c = GetBodySizeMinThresholdValue;
                            } else if (aVar.c > GetBodySizeMaxThresholdValue) {
                                aVar.c = GetBodySizeMaxThresholdValue;
                            }
                        }
                        if (this.y != null) {
                            this.y.setMax((int) ((aVar.e - aVar.d) * this.d));
                            this.y.setProgress((int) ((aVar.c - aVar.d) * this.d));
                        }
                        if (this.z != null) {
                            int round = Math.round(aVar.d);
                            if (i2 == 14) {
                                str2 = a((float) round);
                            } else if (this.e || i2 == 0) {
                                float f2 = aVar.d;
                                str2 = String.valueOf(Math.round(f2)) + "cm";
                            } else {
                                str2 = b(round);
                            }
                            this.z.setText(str2);
                        }
                        if (this.A == null || i2 != 14) {
                            this.A.setVisibility(8);
                        } else {
                            this.A.setVisibility(0);
                            this.A.setText("M");
                        }
                        if (this.B != null) {
                            int round2 = Math.round(aVar.e);
                            if (i2 == 14) {
                                str = a((float) round2);
                            } else if (this.e || i2 == 0) {
                                float f3 = aVar.e;
                                str = String.valueOf(Math.round(f3)) + "cm";
                            } else {
                                str = b(round2);
                            }
                            this.B.setText(str);
                        }
                        a(aVar, aVar.c);
                        return;
                    }
                }
                return;
            }
            return;
        }
        this.k = -1;
        this.w.setVisibility(4);
    }

    private void a(a aVar, float f2) {
        String str;
        boolean z2 = true;
        boolean z3 = this.D != null;
        if (this.y == null) {
            z2 = false;
        }
        if (z3 && z2) {
            Rect bounds = this.y.getThumb().getBounds();
            Resources resources = getResources();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) resources.getDimension(a.c.body_size_setting_mode_current_size_value_view_width), (int) resources.getDimension(a.c.body_size_setting_mode_current_size_value_view_height));
            layoutParams.addRule(2, a.e.body_size_setting_menu_seekbar);
            layoutParams.setMargins(bounds.centerX(), 0, 0, 0);
            this.D.setLayoutParams(layoutParams);
            int round = Math.round(f2);
            if (aVar != null && aVar.f1347a == 14) {
                str = a((float) round);
            } else if (aVar == null || (!this.e && aVar.f1347a != 0)) {
                str = b(round);
            } else {
                str = String.valueOf(Math.round(f2));
            }
            this.D.setText(str);
        }
    }

    private void c(int i2) {
        String str = f1345a;
        Log.d(str, "OnEasySettingMenuItemClick, bodySizeMenuKey: " + i2);
        if (this.p != null && this.q != null && this.r != null) {
            switch (i2) {
                case 0:
                    if (this.e) {
                        Log.e(f1345a, "[ERROR] It is NOT easy setting menu - tall");
                        return;
                    } else if (this.p.isChecked()) {
                        this.k = 0;
                        this.q.setChecked(false);
                        this.r.setChecked(false);
                        a(true, 0);
                        return;
                    } else {
                        a(false, -1);
                        return;
                    }
                case 1:
                    if (this.q.isChecked()) {
                        this.k = 1;
                        this.p.setChecked(false);
                        this.r.setChecked(false);
                        a(true, 5);
                        return;
                    }
                    a(false, -1);
                    return;
                case 2:
                    if (this.r.isChecked()) {
                        this.k = 2;
                        this.p.setChecked(false);
                        this.q.setChecked(false);
                        a(true, 6);
                        return;
                    }
                    a(false, -1);
                    return;
                default:
                    this.k = -1;
                    this.p.setChecked(false);
                    this.q.setChecked(false);
                    this.r.setChecked(false);
                    return;
            }
        }
    }

    private int d(int i2) {
        if (i2 == 0) {
            return i2;
        }
        int i3 = i2 - 2;
        return (!(this.l == 1 && this.m == 2) && i2 >= 6) ? i3 - 1 : i3;
    }

    /* access modifiers changed from: private */
    public int e(int i2) {
        if (i2 == 0) {
            return i2;
        }
        int i3 = i2 + 2;
        return (!(this.l == 1 && this.m == 2) && i3 >= 6) ? i3 + 1 : i3;
    }

    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == a.e.button_negative) {
                if (this.E != null) {
                    this.E.OnClickBodySizeSettingButton(0, a(this.i));
                }
            } else if (id == a.e.button_positive) {
                f.b(this.f, this.e);
                if (this.E != null) {
                    this.E.OnClickBodySizeSettingButton(1, a(this.j));
                }
            } else if (id == a.e.go_to_detailed_body_setting_menu_btn) {
                if (this.E != null) {
                    BodySizeData OnClickGoToDetailedBodySizeSettingMenuButton = this.E.OnClickGoToDetailedBodySizeSettingMenuButton();
                    a(true, true);
                    a(OnClickGoToDetailedBodySizeSettingMenuButton);
                }
            } else if (id == a.e.back_to_easy_body_setting_menu_btn) {
                a(false, true);
                c();
            } else if (id == a.e.body_size_setting_menu_tall_checkbox || id == a.e.body_size_setting_menu_upper_body_checkbox || id == a.e.body_size_setting_menu_lower_body_checkbox) {
                c(((Integer) view.getTag()).intValue());
            }
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        if (seekBar != null && this.D != null) {
            this.D.setVisibility(0);
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        a aVar;
        float f2;
        if (seekBar != null && z2 && this.j != null && this.k != -1 && (aVar = this.j.get(Integer.valueOf(this.k))) != null) {
            if (i2 > 0) {
                f2 = aVar.d + (((float) i2) / this.d);
            } else {
                f2 = aVar.d;
            }
            if (this.E != null) {
                float GetBodySizeMinThresholdValue = (float) this.E.GetBodySizeMinThresholdValue(aVar.f1347a);
                float GetBodySizeMaxThresholdValue = (float) this.E.GetBodySizeMaxThresholdValue(aVar.f1347a);
                if (f2 < GetBodySizeMinThresholdValue || f2 > GetBodySizeMaxThresholdValue) {
                    if (f2 < GetBodySizeMinThresholdValue) {
                        i2 = (int) ((GetBodySizeMinThresholdValue - aVar.d) * this.d);
                        f2 = GetBodySizeMinThresholdValue;
                    } else if (f2 > GetBodySizeMaxThresholdValue) {
                        i2 = (int) ((GetBodySizeMaxThresholdValue - aVar.d) * this.d);
                        f2 = GetBodySizeMaxThresholdValue;
                    }
                    seekBar.setProgress(i2);
                } else {
                    this.E.OnBodySizeSettingProgressChanged(aVar.f1347a, f2);
                }
            }
            a(aVar, f2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStopTrackingTouch(android.widget.SeekBar r8) {
        /*
            r7 = this;
            if (r8 == 0) goto L_0x00f1
            android.widget.TextView r0 = r7.D
            if (r0 == 0) goto L_0x000c
            android.widget.TextView r0 = r7.D
            r1 = 4
            r0.setVisibility(r1)
        L_0x000c:
            java.util.HashMap<java.lang.Integer, net.fxgear.fittingmodenative.c.c$a> r0 = r7.j
            if (r0 == 0) goto L_0x00f1
            int r0 = r7.k
            r1 = -1
            if (r0 == r1) goto L_0x00f1
            java.util.HashMap<java.lang.Integer, net.fxgear.fittingmodenative.c.c$a> r0 = r7.j
            int r1 = r7.k
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r0 = r0.get(r1)
            net.fxgear.fittingmodenative.c.c$a r0 = (net.fxgear.fittingmodenative.c.c.a) r0
            if (r0 == 0) goto L_0x00f1
            int r8 = r8.getProgress()
            if (r8 <= 0) goto L_0x0033
            float r1 = r0.d
            float r8 = (float) r8
            float r2 = r7.d
            float r8 = r8 / r2
            float r1 = r1 + r8
            goto L_0x0035
        L_0x0033:
            float r1 = r0.d
        L_0x0035:
            net.fxgear.fittingmodenative.c.c$d r8 = r7.E
            if (r8 == 0) goto L_0x0056
            net.fxgear.fittingmodenative.c.c$d r8 = r7.E
            int r2 = r0.f1347a
            double r2 = r8.GetBodySizeMinThresholdValue(r2)
            float r8 = (float) r2
            net.fxgear.fittingmodenative.c.c$d r2 = r7.E
            int r3 = r0.f1347a
            double r2 = r2.GetBodySizeMaxThresholdValue(r3)
            float r2 = (float) r2
            int r3 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x0050
            goto L_0x0057
        L_0x0050:
            int r8 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x0056
            r8 = r2
            goto L_0x0057
        L_0x0056:
            r8 = r1
        L_0x0057:
            r0.c = r8
            boolean r8 = r7.e
            if (r8 == 0) goto L_0x006d
            net.fxgear.fittingmodenative.c.c$b r8 = r7.v
            if (r8 == 0) goto L_0x006d
            int r8 = r7.k
            int r8 = r7.d(r8)
            net.fxgear.fittingmodenative.c.c$b r1 = r7.v
            r1.c((int) r8)
            goto L_0x00e0
        L_0x006d:
            float r8 = r0.c
            int r8 = java.lang.Math.round(r8)
            int r1 = r7.k
            r2 = 1
            r3 = 0
            r4 = 2
            switch(r1) {
                case 0: goto L_0x00b4;
                case 1: goto L_0x0098;
                case 2: goto L_0x007c;
                default: goto L_0x007b;
            }
        L_0x007b:
            goto L_0x00e0
        L_0x007c:
            java.lang.String r8 = r7.b((int) r8)
            android.widget.CheckBox r1 = r7.r
            if (r1 == 0) goto L_0x00e0
            android.widget.CheckBox r1 = r7.r
            java.lang.String r5 = "%1$s\n(%2$s)"
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r6 = r0.f1348b
            r4[r3] = r6
            r4[r2] = r8
            java.lang.String r8 = java.lang.String.format(r5, r4)
            r1.setText(r8)
            goto L_0x00e0
        L_0x0098:
            java.lang.String r8 = r7.b((int) r8)
            android.widget.CheckBox r1 = r7.q
            if (r1 == 0) goto L_0x00e0
            android.widget.CheckBox r1 = r7.q
            java.lang.String r5 = "%1$s\n(%2$s)"
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r6 = r0.f1348b
            r4[r3] = r6
            r4[r2] = r8
            java.lang.String r8 = java.lang.String.format(r5, r4)
            r1.setText(r8)
            goto L_0x00e0
        L_0x00b4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r1.append(r8)
            java.lang.String r8 = "cm"
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            android.widget.CheckBox r1 = r7.p
            if (r1 == 0) goto L_0x00e0
            android.widget.CheckBox r1 = r7.p
            java.lang.String r5 = "%1$s\n(%2$s)"
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r6 = r0.f1348b
            r4[r3] = r6
            r4[r2] = r8
            java.lang.String r8 = java.lang.String.format(r5, r4)
            r1.setText(r8)
        L_0x00e0:
            net.fxgear.fittingmodenative.c.c$d r8 = r7.E
            if (r8 == 0) goto L_0x00f1
            net.fxgear.fittingmodenative.c.c$d r8 = r7.E
            int r1 = r0.f1347a
            float r0 = r0.c
            net.fxgear.BodySizeData r8 = r8.OnBodySizeSettingStopTracking(r1, r0)
            r7.a((net.fxgear.BodySizeData) r8)
        L_0x00f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.c.c.onStopTrackingTouch(android.widget.SeekBar):void");
    }

    public void a(d dVar) {
        this.E = dVar;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\c\d.java ==========

package net.fxgear.fittingmodenative.c;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import net.fxgear.a.a;

/* compiled from: CategoryHorizontalListView */
public class d extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private final String f1353a = d.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f1354b = null;
    private b c = null;
    /* access modifiers changed from: private */
    public ArrayList<a> d = null;
    /* access modifiers changed from: private */
    public C0046d e = null;
    /* access modifiers changed from: private */
    public int f = 0;

    /* compiled from: CategoryHorizontalListView */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f1355a;

        /* renamed from: b  reason: collision with root package name */
        public String f1356b;
    }

    /* renamed from: net.fxgear.fittingmodenative.c.d$d  reason: collision with other inner class name */
    /* compiled from: CategoryHorizontalListView */
    public interface C0046d {
        boolean OnSelectCategory(int i);
    }

    public d(Context context) {
        super(context);
        a();
    }

    private void a() {
        inflate(getContext(), a.f.layout_category_horizontal_list_view, this);
        this.f1354b = (RecyclerView) findViewById(a.e.category_horizontal_recycler_view);
        this.f1354b.setItemAnimator((RecyclerView.e) null);
        this.f1354b.setItemViewCacheSize(0);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.b(0);
        this.f1354b.setLayoutManager(linearLayoutManager);
        this.c = new b();
        this.f1354b.setAdapter(this.c);
    }

    public void a(ArrayList<a> arrayList, int i) {
        if (arrayList != null) {
            if (this.d != null) {
                this.d.clear();
                this.d = null;
            }
            this.d = new ArrayList<>();
            this.d.addAll(arrayList);
            this.f = i;
            if (this.c != null) {
                this.c.c();
            }
        }
    }

    public void a(C0046d dVar) {
        this.e = dVar;
    }

    /* compiled from: CategoryHorizontalListView */
    private class c extends RecyclerView.w implements View.OnClickListener {
        /* access modifiers changed from: private */
        public TextView o = null;
        private RelativeLayout p = null;

        public c(View view) {
            super(view);
            if (view != null) {
                this.o = (TextView) view.findViewById(a.e.category_list_item_category_title);
                this.o.setOnClickListener(this);
            }
        }

        public void onClick(View view) {
            c cVar;
            int e = e();
            if (e != -1 && view.getId() == a.e.category_list_item_category_title && d.this.e != null && d.this.e.OnSelectCategory(((a) d.this.d.get(e)).f1355a)) {
                int c = d.this.f;
                int unused = d.this.f = e;
                if (d.this.f != c) {
                    Resources resources = d.this.getResources();
                    if (!(d.this.f1354b == null || (cVar = (c) d.this.f1354b.b(c)) == null)) {
                        cVar.o.setBackgroundColor(0);
                        cVar.o.setTextColor(resources.getColor(a.b.color_white_opacity_60));
                    }
                    this.o.setBackgroundResource(a.d.selected_category_item_bg);
                    this.o.setTextColor(resources.getColor(a.b.main_color));
                }
            }
        }
    }

    /* compiled from: CategoryHorizontalListView */
    private class b extends RecyclerView.a<c> {
        public b() {
        }

        public int a() {
            if (d.this.d != null) {
                return d.this.d.size();
            }
            return 0;
        }

        public void a(c cVar, int i) {
            int i2;
            if (cVar != null && i >= 0 && i < d.this.d.size()) {
                Resources resources = d.this.getResources();
                if (cVar.f413a != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, (int) resources.getDimension(a.c.category_horizontal_item_height));
                    int dimension = (int) resources.getDimension(a.c.category_horizontal_item_margin);
                    if (i == 0) {
                        i2 = (int) resources.getDimension(a.c.category_horizontal_item_edge_of_left_margin);
                    } else {
                        if (i == d.this.d.size() - 1) {
                            dimension = (int) resources.getDimension(a.c.category_horizontal_item_edge_of_left_margin);
                        }
                        i2 = 0;
                    }
                    layoutParams.setMargins(i2, 0, dimension, 0);
                    cVar.f413a.setLayoutParams(layoutParams);
                }
                cVar.o.setText(((a) d.this.d.get(i)).f1356b);
                if (d.this.f == i) {
                    cVar.o.setBackgroundResource(a.d.selected_category_item_bg);
                    cVar.o.setTextColor(resources.getColor(a.b.main_color));
                    return;
                }
                cVar.o.setBackgroundColor(0);
                cVar.o.setTextColor(resources.getColor(a.b.color_white_opacity_60));
            }
        }

        /* renamed from: c */
        public c a(ViewGroup viewGroup, int i) {
            return new c(LayoutInflater.from(d.this.getContext()).inflate(a.f.layout_category_list_item, viewGroup, false));
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\c\e.java ==========

package net.fxgear.fittingmodenative.c;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import net.fxgear.GlobalDefine;
import net.fxgear.a.a;
import net.fxgear.fittingmodenative.b.b;
import net.fxgear.fittingmodenative.c.i;
import net.fxgear.fittingmodenative.e;

/* compiled from: ClothesHorizontalListView */
public class e extends RelativeLayout implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f1360a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final int f1361b = -1;
    private RelativeLayout c = null;
    private i d = null;
    private RecyclerView e = null;
    /* access modifiers changed from: private */
    public c f = null;
    /* access modifiers changed from: private */
    public ArrayList<a> g = null;
    /* access modifiers changed from: private */
    public g h = null;
    /* access modifiers changed from: private */
    public net.fxgear.fittingmodenative.a.b i = null;
    /* access modifiers changed from: private */
    public int j = 0;
    /* access modifiers changed from: private */
    public int k = Integer.MIN_VALUE;
    /* access modifiers changed from: private */
    public boolean l = false;
    /* access modifiers changed from: private */
    public net.fxgear.fittingmodenative.b.b m;

    /* compiled from: ClothesHorizontalListView */
    public enum b {
        PutOn,
        TakeOff,
        CheckSize
    }

    /* compiled from: ClothesHorizontalListView */
    public interface g {
        void OnAddClothes();

        void OnBuyClothesItem(a aVar);

        void OnClickClothesSize(GlobalDefine.ClothesSize clothesSize);

        void OnDeleteClothesItem(a aVar);

        void OnDownloadCancelClothesData(a aVar);

        void OnDownloadStartClothesData(a aVar);

        void OnFittingClothesItem(a aVar, b bVar);
    }

    public e(Context context, net.fxgear.fittingmodenative.a.b bVar) {
        super(context);
        this.i = bVar;
        b();
    }

    private void b() {
        inflate(getContext(), a.f.layout_clothes_horizontal_list_view, this);
        this.c = (RelativeLayout) findViewById(a.e.size_of_clothes_list_container);
        this.d = new i(getContext());
        this.d.setSizeOfClothesListener(this);
        this.c.addView(this.d, new RelativeLayout.LayoutParams(-1, -1));
        this.e = (RecyclerView) findViewById(a.e.clothes_horizontal_recycler_view);
        this.e.setHasFixedSize(true);
        this.e.setItemAnimator((RecyclerView.e) null);
        this.e.setItemViewCacheSize(0);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.b(0);
        this.e.setLayoutManager(linearLayoutManager);
        this.f = new c();
        this.e.setAdapter(this.f);
    }

    public void a(g gVar) {
        this.h = gVar;
    }

    public void a(ArrayList<a> arrayList) {
        if (arrayList != null) {
            if (this.g != null) {
                this.g.clear();
                this.g = null;
            }
            this.g = new ArrayList<>();
            this.g.addAll(arrayList);
            if (this.f != null) {
                this.f.c();
            }
        }
    }

    public void a(GlobalDefine.ClothesSize clothesSize) {
        if (this.h != null) {
            this.h.OnClickClothesSize(clothesSize);
        }
    }

    public void a(int[] iArr) {
        boolean z;
        if (this.g != null) {
            int size = this.g.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.g.get(i2);
                if (aVar != null) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= iArr.length) {
                            z = false;
                            break;
                        } else if (aVar.i.f1461a == iArr[i3]) {
                            z = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    aVar.g = z;
                }
            }
            if (this.f != null) {
                this.f.c();
            }
        }
    }

    public void a(a aVar) {
        if (!(aVar == null || this.g == null)) {
            int indexOf = this.g.indexOf(aVar);
            if (indexOf != -1) {
                aVar.f = 1;
                if (this.e != null) {
                    f fVar = (f) this.e.b(indexOf);
                    if (fVar != null) {
                        fVar.C();
                    }
                    if (this.h != null) {
                        this.h.OnFittingClothesItem(aVar, b.PutOn);
                    }
                }
            } else {
                Log.e(this.f1360a, "[ERROR]: itemIndex is Not founded");
            }
        }
        this.l = false;
    }

    public void a(a aVar, int i2) {
        f fVar;
        if (aVar != null && this.g != null) {
            int indexOf = this.g.indexOf(aVar);
            if (indexOf == -1) {
                Log.e(this.f1360a, "[ERROR]: itemIndex is Not founded");
            } else if (this.e != null && (fVar = (f) this.e.b(indexOf)) != null) {
                if (fVar.w.getVisibility() != 0) {
                    fVar.B();
                }
                fVar.y.setProgress(i2);
            }
        }
    }

    public void b(a aVar) {
        f fVar;
        if (!(aVar == null || this.g == null)) {
            int indexOf = this.g.indexOf(aVar);
            if (indexOf != -1) {
                aVar.f = 0;
                if (!(this.e == null || (fVar = (f) this.e.b(indexOf)) == null)) {
                    fVar.A();
                }
            } else {
                Log.e(this.f1360a, "[ERROR]: itemIndex is Not founded");
            }
        }
        this.l = false;
    }

    public void a(int i2) {
        if (this.g != null) {
            int i3 = 0;
            while (i3 < this.g.size()) {
                a aVar = this.g.get(i3);
                if (aVar == null || aVar.i.f1461a != i2) {
                    i3++;
                } else if (this.e != null) {
                    int width = getRootView().getWidth();
                    ((LinearLayoutManager) this.e.getLayoutManager()).b(i3, (width - ((int) getResources().getDimension(a.c.clothes_horizontal_item_width))) / 2);
                    return;
                } else {
                    return;
                }
            }
        }
    }

    public boolean a() {
        if (this.f != null) {
            return this.f.d();
        }
        return false;
    }

    public void a(boolean z) {
        if (this.f != null) {
            this.f.a(z);
        }
    }

    public void a(b.a aVar) {
        if (this.m != null) {
            if (this.m.isShowing()) {
                this.m.dismiss();
            }
            this.m = null;
        }
        Resources resources = getResources();
        this.m = new net.fxgear.fittingmodenative.b.b((Activity) getContext(), 2);
        this.m.setCanceledOnTouchOutside(false);
        this.m.a(resources.getString(a.g.network_error_title));
        this.m.b(resources.getString(a.g.network_error_message));
        this.m.c(resources.getString(a.g.retry));
        this.m.d(resources.getString(a.g.cancel));
        this.m.a(aVar);
        this.m.show();
    }

    /* access modifiers changed from: private */
    public void c(final a aVar) {
        if (!net.fxgear.fittingmodenative.f.a(getContext())) {
            a((b.a) new b.a() {
                public void a(net.fxgear.fittingmodenative.b.b bVar) {
                    if (e.this.m != null) {
                        e.this.m.dismiss();
                        net.fxgear.fittingmodenative.b.b unused = e.this.m = null;
                        e.this.c(aVar);
                    }
                }

                public void b(net.fxgear.fittingmodenative.b.b bVar) {
                    if (e.this.m != null) {
                        e.this.m.dismiss();
                        net.fxgear.fittingmodenative.b.b unused = e.this.m = null;
                    }
                }
            });
        } else if (aVar == null) {
            Log.e(this.f1360a, "DownloadClothesData(), [ERROR] :: clothesItem is null");
        } else if (this.g != null && this.g.indexOf(aVar) != -1) {
            aVar.f = 2;
            this.l = true;
            if (this.h != null) {
                this.h.OnDownloadStartClothesData(aVar);
            }
        }
    }

    /* renamed from: net.fxgear.fittingmodenative.c.e$e  reason: collision with other inner class name */
    /* compiled from: ClothesHorizontalListView */
    private abstract class C0048e extends RecyclerView.w {
        public C0048e(View view) {
            super(view);
        }
    }

    /* compiled from: ClothesHorizontalListView */
    private class d extends C0048e implements View.OnClickListener {
        private Button p;

        public d(View view) {
            super(view);
            if (view != null) {
                this.p = (Button) view.findViewById(a.e.clothes_list_header_btn_add);
                this.p.setOnClickListener(this);
            }
        }

        public void onClick(View view) {
            if (!e.this.l && view.getId() == a.e.clothes_list_header_btn_add && e.this.h != null) {
                e.this.h.OnAddClothes();
            }
        }
    }

    /* compiled from: ClothesHorizontalListView */
    private class f extends C0048e implements View.OnClickListener, View.OnLongClickListener {
        private Button A = null;
        private final int p = 100;
        private final float q = 1.0f;
        private final float r = 0.5f;
        private RelativeLayout s = null;
        /* access modifiers changed from: private */
        public ImageView t = null;
        private Button u = null;
        /* access modifiers changed from: private */
        public ImageView v = null;
        /* access modifiers changed from: private */
        public RelativeLayout w = null;
        private Button x = null;
        /* access modifiers changed from: private */
        public ProgressBar y = null;
        /* access modifiers changed from: private */
        public Button z = null;

        public f(View view) {
            super(view);
            if (view != null) {
                this.s = (RelativeLayout) view.findViewById(a.e.clothes_list_item_root);
                this.t = (ImageView) view.findViewById(a.e.clothes_list_item_default_image);
                this.u = (Button) view.findViewById(a.e.clothes_list_item_btn_download_datas);
                this.v = (ImageView) view.findViewById(a.e.clothes_list_item_clothes_thumbnial);
                this.w = (RelativeLayout) view.findViewById(a.e.clothes_list_item_container_download_data_progress);
                this.x = (Button) view.findViewById(a.e.clothes_list_item_btn_cancel_download_data);
                this.y = (ProgressBar) view.findViewById(a.e.clothes_list_item_progress_download_data);
                this.z = (Button) view.findViewById(a.e.clothes_list_item_btn_delete_clothes);
                this.A = (Button) view.findViewById(a.e.clothes_list_item_btn_buy);
                this.y.setMax(100);
                this.s.setOnClickListener(this);
                this.s.setOnLongClickListener(this);
                this.u.setOnClickListener(this);
                this.x.setOnClickListener(this);
                this.z.setOnClickListener(this);
                this.A.setOnClickListener(this);
            }
        }

        public void onClick(View view) {
            a aVar;
            b bVar;
            int id = view.getId();
            int e = e();
            if (e >= 0 && e < e.this.g.size() && (aVar = (a) e.this.g.get(e)) != null) {
                if (e.this.l) {
                    if (aVar.f == 2) {
                        if (id == a.e.clothes_list_item_btn_cancel_download_data || id == a.e.clothes_list_item_btn_delete_clothes) {
                            if (e.this.h != null) {
                                e.this.h.OnDownloadCancelClothesData(aVar);
                            }
                            boolean unused = e.this.l = false;
                        }
                    } else if (id == a.e.clothes_list_item_btn_delete_clothes) {
                        if (e.this.h != null) {
                            e.this.h.OnDeleteClothesItem(aVar);
                        }
                        if (e.this.g != null) {
                            e.this.g.remove(e);
                        }
                        if (e.this.f != null) {
                            e.this.f.c();
                        }
                    }
                } else if (e.this.f != null && e.this.f.d() && id != a.e.clothes_list_item_btn_delete_clothes) {
                    e.this.f.a(false);
                } else if (id == a.e.clothes_list_item_root) {
                    if (aVar != null) {
                        switch (aVar.f) {
                            case 0:
                                e.this.c(aVar);
                                return;
                            case 1:
                                if (e.this.h != null) {
                                    if (!aVar.g) {
                                        bVar = b.PutOn;
                                    } else if (e.this.k == aVar.i.f1461a || e.this.j != 7) {
                                        bVar = b.TakeOff;
                                    } else {
                                        bVar = b.CheckSize;
                                    }
                                    e.this.h.OnFittingClothesItem(aVar, bVar);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                } else if (id == a.e.clothes_list_item_btn_download_datas) {
                    e.this.c(aVar);
                } else if (id == a.e.clothes_list_item_btn_cancel_download_data) {
                    if (aVar != null && aVar.f != 1) {
                        aVar.f = 0;
                        if (e.this.h != null) {
                            e.this.h.OnDownloadCancelClothesData(aVar);
                        }
                        A();
                        boolean unused2 = e.this.l = false;
                    }
                } else if (id == a.e.clothes_list_item_btn_delete_clothes) {
                    if (e.this.h != null) {
                        e.this.h.OnDeleteClothesItem(aVar);
                    }
                    if (e.this.g != null) {
                        e.this.g.remove(e);
                    }
                    if (e.this.f != null) {
                        e.this.f.c();
                    }
                } else if (id == a.e.clothes_list_item_btn_buy && e.this.h != null && aVar != null) {
                    e.this.h.OnBuyClothesItem(aVar);
                }
            }
        }

        public boolean onLongClick(View view) {
            int e = e();
            if (e < 0 || e >= e.this.g.size() || view.getId() != a.e.clothes_list_item_root) {
                return false;
            }
            if (e.this.f == null || e.this.f.d()) {
                return true;
            }
            e.this.f.a(true);
            return true;
        }

        /* access modifiers changed from: private */
        public void y() {
            if (e.this.j == 7) {
                this.A.setVisibility(8);
                return;
            }
            a aVar = (a) e.this.g.get(e());
            if (aVar.g) {
                this.A.setVisibility(0);
                this.A.setEnabled(!aVar.h);
                return;
            }
            this.A.setVisibility(8);
        }

        /* access modifiers changed from: private */
        public void z() {
            a aVar = (a) e.this.g.get(e());
            if (e.this.j == 7) {
                if (aVar != null && aVar.i.f1461a == e.this.k) {
                    this.s.setBackgroundColor(e.this.getResources().getColor(a.b.main_color_opacity_50));
                } else if (aVar.g) {
                    this.s.setBackgroundColor(e.this.getResources().getColor(a.b.color_white_opacity_29));
                } else {
                    this.s.setBackgroundResource(a.d.clothes_item_for_checking_size_bg);
                }
            } else if (aVar.g) {
                this.s.setBackgroundColor(e.this.getResources().getColor(a.b.color_white_opacity_65));
            } else {
                this.s.setBackgroundResource(a.d.clothes_item_selection_bg);
            }
        }

        /* access modifiers changed from: private */
        public void A() {
            a aVar = (a) e.this.g.get(e());
            if (aVar != null) {
                this.t.setVisibility(0);
                this.u.setVisibility(0);
                this.v.setVisibility(8);
                this.v.setAlpha(0.5f);
                if (!(aVar.i.f == null || e.this.i == null)) {
                    e.this.i.a(this.v, ((a) e.this.g.get(e())).i.f, (Runnable) new Runnable() {
                        public void run() {
                            f.this.t.setVisibility(8);
                            f.this.v.setVisibility(0);
                        }
                    });
                }
                this.w.setVisibility(8);
            }
        }

        /* access modifiers changed from: private */
        public void B() {
            a aVar = (a) e.this.g.get(e());
            if (aVar != null) {
                this.t.setVisibility(0);
                this.u.setVisibility(8);
                this.v.setVisibility(8);
                this.v.setAlpha(0.5f);
                if (!(aVar.i.f == null || e.this.i == null)) {
                    e.this.i.a(this.v, ((a) e.this.g.get(e())).i.f, (Runnable) new Runnable() {
                        public void run() {
                            f.this.t.setVisibility(8);
                            f.this.v.setVisibility(0);
                        }
                    });
                }
                this.w.setVisibility(0);
                this.x.setVisibility(0);
                this.y.setVisibility(0);
                this.y.setProgress(0);
            }
        }

        /* access modifiers changed from: private */
        public void C() {
            a aVar = (a) e.this.g.get(e());
            if (aVar != null) {
                this.t.setVisibility(0);
                this.u.setVisibility(8);
                this.v.setVisibility(8);
                this.v.setAlpha(1.0f);
                if (!(aVar.i.f == null || e.this.i == null)) {
                    e.this.i.a(this.v, ((a) e.this.g.get(e())).i.f, (Runnable) new Runnable() {
                        public void run() {
                            f.this.t.setVisibility(8);
                            f.this.v.setVisibility(0);
                        }
                    });
                }
                this.w.setVisibility(8);
            }
        }
    }

    /* compiled from: ClothesHorizontalListView */
    private class c extends RecyclerView.a<C0048e> {

        /* renamed from: b  reason: collision with root package name */
        private boolean f1375b = false;

        public c() {
        }

        public int a(int i) {
            if (e.this.g == null || i == e.this.g.size()) {
                return 1;
            }
            return 2;
        }

        public int a() {
            if (e.this.j == 7) {
                if (e.this.g != null) {
                    return e.this.g.size();
                }
                return 0;
            } else if (e.this.g != null) {
                return e.this.g.size() + 1;
            } else {
                return 1;
            }
        }

        public void a(C0048e eVar, int i) {
            if (eVar == null) {
                return;
            }
            if (e.this.g == null || e.this.g.isEmpty() || i >= e.this.g.size()) {
                d dVar = (d) eVar;
                if (e.this.j == 7) {
                    dVar.f413a.setVisibility(8);
                } else {
                    dVar.f413a.setVisibility(0);
                }
            } else {
                Resources resources = e.this.getResources();
                if (eVar.f413a != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) resources.getDimension(a.c.clothes_horizontal_item_width), (int) resources.getDimension(a.c.clothes_horizontal_item_with_buy_btn_height));
                    layoutParams.setMargins(i == 0 ? (int) resources.getDimension(a.c.clothes_horizontal_item_margin) : 0, 0, (int) resources.getDimension(a.c.clothes_horizontal_item_margin), 0);
                    eVar.f413a.setLayoutParams(layoutParams);
                }
                f fVar = (f) eVar;
                switch (((a) e.this.g.get(i)).f) {
                    case 0:
                        fVar.A();
                        break;
                    case 1:
                        fVar.C();
                        break;
                    case 2:
                        fVar.B();
                        break;
                }
                fVar.y();
                fVar.z();
                if (this.f1375b) {
                    fVar.z.setVisibility(0);
                } else {
                    fVar.z.setVisibility(8);
                }
            }
        }

        /* renamed from: c */
        public C0048e a(ViewGroup viewGroup, int i) {
            LayoutInflater from = LayoutInflater.from(e.this.getContext());
            if (i == 1) {
                return new d(from.inflate(a.f.layout_clothes_list_footer, viewGroup, false));
            }
            return new f(from.inflate(a.f.layout_clothes_list_item, viewGroup, false));
        }

        /* access modifiers changed from: private */
        public void a(boolean z) {
            if (this.f1375b != z) {
                this.f1375b = z;
                e.this.b(z);
            }
        }

        /* access modifiers changed from: private */
        public boolean d() {
            return this.f1375b;
        }
    }

    public void b(int i2) {
        if (i2 != 7) {
            this.j = 0;
            if (this.c != null) {
                this.c.setVisibility(8);
            }
        } else {
            this.j = 7;
            if (this.c != null) {
                this.c.setVisibility(0);
            }
        }
        if (this.f != null) {
            this.f.c();
        }
    }

    public void a(int i2, GlobalDefine.ClothesSize clothesSize) {
        c(i2);
        if (this.d != null) {
            this.d.setClothesSize(clothesSize);
        }
    }

    public void b(GlobalDefine.ClothesSize clothesSize) {
        if (this.d != null && clothesSize != null) {
            this.d.a(clothesSize);
        }
    }

    private void c(int i2) {
        LinearLayoutManager linearLayoutManager;
        this.k = i2;
        if (this.e != null && (linearLayoutManager = (LinearLayoutManager) this.e.getLayoutManager()) != null) {
            int m2 = linearLayoutManager.m();
            for (int l2 = linearLayoutManager.l(); l2 <= m2; l2++) {
                RecyclerView.w b2 = this.e.b(l2);
                if (b2 != null && (b2 instanceof f)) {
                    ((f) b2).z();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(boolean z) {
        LinearLayoutManager linearLayoutManager;
        if (this.e != null && (linearLayoutManager = (LinearLayoutManager) this.e.getLayoutManager()) != null) {
            int m2 = linearLayoutManager.m();
            for (int l2 = linearLayoutManager.l(); l2 <= m2; l2++) {
                RecyclerView.w b2 = this.e.b(l2);
                if (b2 != null && (b2 instanceof f)) {
                    f fVar = (f) b2;
                    if (z) {
                        fVar.z.setVisibility(0);
                    } else {
                        fVar.z.setVisibility(8);
                    }
                }
            }
        }
    }

    /* compiled from: ClothesHorizontalListView */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f1366a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<Integer> f1367b = new ArrayList<>();
        public int c;
        public int d;
        public GlobalDefine.ClothesSize e = null;
        public int f = 0;
        public boolean g = false;
        public boolean h = false;
        public e.a i;

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return this.f1366a == ((a) obj).f1366a;
            }
            return super.equals(obj);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\c\f.java ==========

package net.fxgear.fittingmodenative.c;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import java.util.ArrayList;
import net.fxgear.GlobalDefine;
import net.fxgear.a.a;
import net.fxgear.fittingview.FittingSurfaceView;
import net.fxgear.util.FXUtil;

/* compiled from: ColorCalibrationSettingView */
public class f extends RelativeLayout implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public static final float f1379a = FittingSurfaceView.colorTemperatureToNormalizeValue(new float[]{255.0f, 255.0f, 255.0f});

    /* renamed from: b  reason: collision with root package name */
    private final String f1380b = "ColorCalibrationSettingView";
    private final int c = 100;
    private SeekBar d;
    private SeekBar e;
    private final float f = 0.1f;
    private final int g = 0;
    private final int h = 1;
    private final int i = 2;
    private Button j;
    private Button k;
    private GradientDrawable l;
    private a m;

    /* compiled from: ColorCalibrationSettingView */
    public interface a {
        void OnClickColorCalibrationSettingButton(int i);

        void OnColorCalibrationProgressChanged(int i, float f);

        void OnColorCalibrationStopTracking(int i, float f);
    }

    public f(Context context) {
        super(context);
        Log.d("ColorCalibrationSettingView", "ColorCalibrationSettingView()+");
        a(context);
    }

    private void a(Context context) {
        Log.d("ColorCalibrationSettingView", "Initialize()+");
        View inflate = LayoutInflater.from(context).inflate(a.f.layout_color_calibration_setting_view, this);
        this.d = (SeekBar) inflate.findViewById(a.e.color_calibration_setting_auto_seekbar);
        this.d.setOnSeekBarChangeListener(this);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 <= 100; i2++) {
            float[] computeColorTemperature = FittingSurfaceView.computeColorTemperature(((float) i2) / 100.0f);
            arrayList.add(Integer.valueOf(Color.argb(255, (int) computeColorTemperature[0], (int) computeColorTemperature[1], (int) computeColorTemperature[2])));
        }
        int[] iArr = new int[arrayList.size()];
        int i3 = 0;
        for (Integer intValue : arrayList) {
            iArr[i3] = intValue.intValue();
            i3++;
        }
        this.e = (SeekBar) inflate.findViewById(a.e.color_calibration_setting_hue_seekbar);
        this.l = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr);
        this.l.setGradientType(0);
        this.e.setProgressDrawable(this.l);
        this.e.setOnSeekBarChangeListener(this);
        this.j = (Button) inflate.findViewById(a.e.button_negative);
        this.j.setText(getResources().getString(a.g.cancel));
        this.j.setOnClickListener(this);
        this.k = (Button) inflate.findViewById(a.e.button_positive);
        this.k.setText(getResources().getString(a.g.confirm));
        this.k.setOnClickListener(this);
    }

    public void a() {
        Log.d("ColorCalibrationSettingView", "Finalize()+");
        if (this.d != null) {
            this.d.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) null);
            this.d = null;
        }
        if (this.e != null) {
            this.e.setProgressDrawable((Drawable) null);
            this.e.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) null);
            this.e = null;
        }
        if (this.l != null) {
            this.l.clearColorFilter();
            this.l = null;
        }
        if (this.k != null) {
            this.k.setOnClickListener((View.OnClickListener) null);
            this.k = null;
        }
        if (this.j != null) {
            this.j.setOnClickListener((View.OnClickListener) null);
            this.j = null;
        }
        this.m = null;
    }

    public int b() {
        SeekBar seekBar = this.e;
        float f2 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        if (seekBar != null) {
            float progress = (float) this.e.getProgress();
            if (progress > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                f2 = progress / ((float) this.e.getMax());
            }
        }
        float[] computeColorTemperature = FittingSurfaceView.computeColorTemperature(f2);
        int i2 = (int) computeColorTemperature[0];
        int i3 = (int) computeColorTemperature[1];
        int i4 = (int) computeColorTemperature[2];
        Log.d("ColorCalibrationSettingView", "[JE] GetCurrentHueRGBColor, seekBarValue: " + f2 + ", r: " + i2 + ", g: " + i3 + ", b: " + i4);
        return FXUtil.colorFromRGB(i2, i3, i4);
    }

    public float c() {
        SeekBar seekBar = this.d;
        float f2 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        if (seekBar != null) {
            float progress = (float) this.d.getProgress();
            if (progress > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                f2 = progress / ((float) this.d.getMax());
            }
        }
        Log.d("ColorCalibrationSettingView", "[JE] GetCurrentAutoValue, seekBarValue: " + f2);
        return f2;
    }

    public void a(int i2, float f2) {
        Log.d("ColorCalibrationSettingView", "SetColorCalibrationSeekBarProgress()+, seekBarType: " + i2 + ", currentValue: " + f2);
        if (i2 == 10 && this.d != null) {
            this.d.setProgress((int) (f2 * ((float) this.d.getMax())));
        } else if (i2 != 11 || this.e == null) {
            Log.e("ColorCalibrationSettingView", "wrong seekbarType");
        } else {
            this.e.setProgress((int) (f2 * ((float) this.e.getMax())));
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        Log.d("ColorCalibrationSettingView", "onStartTrackingTouch");
    }

    public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        int i3;
        if (seekBar != null && z) {
            int max = seekBar.getMax();
            int id = seekBar.getId();
            if (id == a.e.color_calibration_setting_auto_seekbar) {
                i3 = 10;
            } else if (id == a.e.color_calibration_setting_hue_seekbar) {
                float width = (float) seekBar.getWidth();
                float f2 = width / 2.0f;
                if (Math.abs(f2 - ((width / ((float) seekBar.getMax())) * ((float) i2))) <= f2 * 0.1f) {
                    seekBar.setProgress(max / 2);
                    Log.i("ColorCalibrationSettingView", "set progress to center");
                }
                i3 = 11;
            } else {
                Log.e("ColorCalibrationSettingView", "wrong seekbarType");
                return;
            }
            if (this.m != null) {
                float progress = (float) seekBar.getProgress();
                float f3 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                if (progress > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                    f3 = progress / ((float) max);
                }
                this.m.OnColorCalibrationProgressChanged(i3, f3);
            }
        }
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        int i2;
        Log.d("ColorCalibrationSettingView", "onStopTrackingTouch");
        if (seekBar != null) {
            int id = seekBar.getId();
            if (id == a.e.color_calibration_setting_auto_seekbar) {
                i2 = 10;
            } else if (id == a.e.color_calibration_setting_hue_seekbar) {
                i2 = 11;
            } else {
                Log.e("ColorCalibrationSettingView", "wrong seekbarType");
                return;
            }
            if (this.m != null) {
                float progress = (float) seekBar.getProgress();
                float f2 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                if (progress > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                    f2 = progress / ((float) seekBar.getMax());
                }
                this.m.OnColorCalibrationStopTracking(i2, f2);
            }
        }
    }

    public void onClick(View view) {
        int i2;
        if (view != null) {
            int id = view.getId();
            if (id == a.e.button_negative) {
                i2 = 0;
            } else if (id == a.e.button_positive) {
                i2 = 1;
            } else {
                Log.e("ColorCalibrationSettingView", "wrong click");
                return;
            }
            if (this.m != null) {
                this.m.OnClickColorCalibrationSettingButton(i2);
            }
        }
    }

    public void a(a aVar) {
        this.m = aVar;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\c\g.java ==========

package net.fxgear.fittingmodenative.c;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import net.fxgear.a.a;

/* compiled from: CustomFaceSettingView */
public class g extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final String f1381a = g.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private Button f1382b;
    private a c;

    /* compiled from: CustomFaceSettingView */
    public interface a {
        void OnClickCustomFaceApplyButton();

        void OnClickCustomFaceDetailSettingButton();

        void OnClickCustomFaceRetryButton();
    }

    public g(Context context) {
        super(context);
        Log.i(this.f1381a, "CustomFaceSettingView()+");
        a(context);
    }

    private void a(Context context) {
        Log.i(this.f1381a, "Initialize()+");
        View inflate = inflate(context, a.f.layout_custom_face_setting_view, this);
        this.f1382b = (Button) inflate.findViewById(a.e.retry_button);
        this.f1382b.setOnClickListener(this);
        ((Button) inflate.findViewById(a.e.detail_setting_button)).setOnClickListener(this);
        ((Button) inflate.findViewById(a.e.apply_button)).setOnClickListener(this);
    }

    public void a(boolean z) {
        if (this.f1382b != null) {
            Resources resources = getResources();
            if (z) {
                this.f1382b.setText(resources.getString(a.g.face_config_select_again));
            } else {
                this.f1382b.setText(resources.getString(a.g.face_config_take_photo_again));
            }
        }
    }

    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == a.e.retry_button) {
                Log.d(this.f1381a, "onClick - retry button");
                if (this.c != null) {
                    this.c.OnClickCustomFaceRetryButton();
                }
            } else if (id == a.e.detail_setting_button) {
                Log.d(this.f1381a, "onClick - detail setting button");
                if (this.c != null) {
                    this.c.OnClickCustomFaceDetailSettingButton();
                }
            } else if (id == a.e.apply_button) {
                Log.d(this.f1381a, "onClick - confirm button");
                if (this.c != null) {
                    this.c.OnClickCustomFaceApplyButton();
                }
            }
        }
    }

    public void a(a aVar) {
        this.c = aVar;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\c\h.java ==========

package net.fxgear.fittingmodenative.c;

import android.content.Context;
import android.util.Log;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import net.fxgear.GlobalDefine;
import net.fxgear.a.a;
import net.fxgear.fittingmodenative.a.b;
import net.fxgear.fittingmodenative.c.d;
import net.fxgear.fittingmodenative.c.e;

/* compiled from: MainClothesAndCategoryHorizontalListView */
public class h extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private final String f1383a = h.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f1384b = null;
    private RelativeLayout c = null;
    private e d = null;
    private d e = null;

    public h(Context context, b bVar) {
        super(context);
        a(bVar);
    }

    private void a(b bVar) {
        inflate(getContext(), a.f.layout_main_clothes_category_horizontal_list_view, this);
        this.f1384b = (RelativeLayout) findViewById(a.e.main_clothes_category_list_clothes_list_container);
        this.c = (RelativeLayout) findViewById(a.e.main_clothes_category_list_category_list_container);
        this.d = new e(getContext(), bVar);
        this.e = new d(getContext());
        this.f1384b.addView(this.d, new RelativeLayout.LayoutParams(-1, -1));
        this.c.addView(this.e, new RelativeLayout.LayoutParams(-1, -1));
    }

    public void a(int i) {
        if (this.d != null) {
            this.d.b(i);
        }
    }

    public void a(d.C0046d dVar) {
        if (this.e != null) {
            this.e.a(dVar);
        }
    }

    public void a(ArrayList<d.a> arrayList, int i) {
        if (this.e != null) {
            this.e.a(arrayList, i);
        }
    }

    public void a(e.g gVar) {
        if (this.d != null) {
            this.d.a(gVar);
        }
    }

    public void a(int i, GlobalDefine.ClothesSize clothesSize) {
        if (this.d != null) {
            this.d.a(i, clothesSize);
        }
    }

    public void a(GlobalDefine.ClothesSize clothesSize) {
        if (this.d != null) {
            this.d.b(clothesSize);
        }
    }

    public void b(int i, GlobalDefine.ClothesSize clothesSize) {
        if (this.d != null) {
            this.d.b(clothesSize);
            b(i);
        }
    }

    public void a(ArrayList<e.a> arrayList) {
        if (this.d != null) {
            this.d.a(arrayList);
        }
    }

    public void a(int[] iArr) {
        if (iArr == null) {
            Log.e(this.f1383a, "UpdateClothesList(), fittingClothesIDArray is null");
        } else if (this.d != null) {
            this.d.a(iArr);
        }
    }

    public void a(e.a aVar) {
        if (this.d != null) {
            this.d.a(aVar);
        }
    }

    public void a(e.a aVar, int i) {
        if (this.d != null) {
            this.d.a(aVar, i);
        }
    }

    public void b(e.a aVar) {
        if (this.d != null) {
            this.d.b(aVar);
        }
    }

    public void b(int i) {
        if (this.d != null) {
            this.d.a(i);
        }
    }

    public boolean a() {
        if (this.d != null) {
            return this.d.a();
        }
        return false;
    }

    public void a(boolean z) {
        if (this.d != null) {
            this.d.a(z);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\c\i.java ==========

package net.fxgear.fittingmodenative.c;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import net.fxgear.GlobalDefine;
import net.fxgear.a.a;

/* compiled from: SizeOfClothesListView.kt */
public final class i extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f1385a = Integer.MIN_VALUE;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f1386b;
    /* access modifiers changed from: private */
    public a c;

    /* compiled from: SizeOfClothesListView.kt */
    public interface a {
        void a(GlobalDefine.ClothesSize clothesSize);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(Context context) {
        super(context);
        b.a.a.a.b(context, "context");
        this.f1386b = (RecyclerView) LayoutInflater.from(context).inflate(a.f.layout_size_of_clothes_list_view, this).findViewById(a.e.size_of_clothes_recyclerview);
        RecyclerView recyclerView = this.f1386b;
        if (recyclerView != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.b(0);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(new b());
        }
    }

    public final void setSizeOfClothesListener(a aVar) {
        b.a.a.a.b(aVar, "listener");
        this.c = aVar;
    }

    public final void setClothesSize(GlobalDefine.ClothesSize clothesSize) {
        RecyclerView.a adapter;
        if (clothesSize == null) {
            this.f1385a = Integer.MIN_VALUE;
        } else {
            this.f1385a = clothesSize.ordinal();
        }
        RecyclerView recyclerView = this.f1386b;
        if (recyclerView != null && (adapter = recyclerView.getAdapter()) != null) {
            adapter.c();
        }
    }

    public final void a(GlobalDefine.ClothesSize clothesSize) {
        b.a.a.a.b(clothesSize, "size");
        View rootView = getRootView();
        b.a.a.a.a((Object) rootView, "rootView");
        int width = (rootView.getWidth() - ((int) getResources().getDimension(a.c.size_of_clothes_list_item_width))) / 2;
        RecyclerView recyclerView = this.f1386b;
        RecyclerView.h layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        if (layoutManager != null) {
            ((LinearLayoutManager) layoutManager).b(clothesSize.ordinal(), width);
            return;
        }
        throw new b.a("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
    }

    /* compiled from: SizeOfClothesListView.kt */
    public final class b extends RecyclerView.a<a> {
        public b() {
        }

        /* renamed from: c */
        public a a(ViewGroup viewGroup, int i) {
            return new a(LayoutInflater.from(i.this.getContext()).inflate(a.f.layout_size_of_clothes_list_item, viewGroup, false));
        }

        public int a() {
            return GlobalDefine.ClothesSize.values().length;
        }

        public void a(a aVar, int i) {
            RadioButton y;
            if (aVar != null && (y = aVar.y()) != null) {
                y.setText(GlobalDefine.ClothesSize.getClothesSizeName(GlobalDefine.ClothesSize.values()[i]));
                y.setChecked(i == i.this.f1385a);
            }
        }

        /* compiled from: SizeOfClothesListView.kt */
        public final class a extends RecyclerView.w {
            private RadioButton o;

            public a(View view) {
                super(view);
                this.o = view != null ? (RadioButton) view.findViewById(a.e.item_radio_button) : null;
                RadioButton radioButton = this.o;
                if (radioButton != null) {
                    radioButton.setOnClickListener(new View.OnClickListener(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ a f1388a;

                        {
                            this.f1388a = r1;
                        }

                        public final void onClick(View view) {
                            i.this.f1385a = this.f1388a.e();
                            b.this.c();
                            a b2 = i.this.c;
                            if (b2 != null) {
                                b2.a(GlobalDefine.ClothesSize.values()[i.this.f1385a]);
                            }
                        }
                    });
                }
            }

            public final RadioButton y() {
                return this.o;
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\customface\AvatarFaceSettingActivity.java ==========

package net.fxgear.fittingmodenative.customface;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import net.fxgear.a.a;
import net.fxgear.customface.DetectCustomFacePoints;
import net.fxgear.fittingmodenative.f;

public class AvatarFaceSettingActivity extends Activity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f1389a = AvatarFaceSettingActivity.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public DetectingFaceView f1390b;
    /* access modifiers changed from: private */
    public DetectCustomFacePoints.DetectFacePointsThread c;
    private net.fxgear.fittingmodenative.b.a d;
    private DetectCustomFacePoints.OnDetectCustomFaceListener e = new DetectCustomFacePoints.OnDetectCustomFaceListener() {
        public void OnStartToDetectCustomFace() {
            AvatarFaceSettingActivity.this.a();
        }

        public void OnFinishToDetectCustomFace(String str, int[] iArr, float[] fArr, int i) {
            AvatarFaceSettingActivity.this.b();
            DetectCustomFacePoints.DetectFacePointsThread unused = AvatarFaceSettingActivity.this.c = null;
            if (AvatarFaceSettingActivity.this.f1390b != null) {
                AvatarFaceSettingActivity.this.f1390b.a(str, iArr);
            } else {
                Log.e(AvatarFaceSettingActivity.this.f1389a, "mDetectingFaceView is null");
            }
        }

        public void OnErrorToDetectCustomFace(int i, Object obj) {
            AvatarFaceSettingActivity.this.b();
            DetectCustomFacePoints.DetectFacePointsThread unused = AvatarFaceSettingActivity.this.c = null;
            AvatarFaceSettingActivity.this.a(i, obj);
        }
    };
    private View.OnClickListener f = new View.OnClickListener() {
        public void onClick(View view) {
            a aVar;
            if (view != null) {
                int id = view.getId();
                if (id == a.e.button_negative) {
                    Log.i(AvatarFaceSettingActivity.this.f1389a, "onClick - cancel button");
                    AvatarFaceSettingActivity.this.a(0, (Object) null);
                } else if (id == a.e.button_positive) {
                    Log.i(AvatarFaceSettingActivity.this.f1389a, "onClick - confirm button");
                    if (AvatarFaceSettingActivity.this.f1390b != null) {
                        aVar = new a();
                        aVar.f1395a = AvatarFaceSettingActivity.this.f1390b.a();
                        aVar.f1396b = AvatarFaceSettingActivity.this.f1390b.b();
                    } else {
                        aVar = null;
                    }
                    AvatarFaceSettingActivity.this.a(-1, (Object) aVar);
                }
            }
        }
    };

    private class a {

        /* renamed from: a  reason: collision with root package name */
        String f1395a;

        /* renamed from: b  reason: collision with root package name */
        int[] f1396b;

        private a() {
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i(this.f1389a, "onCreate()+");
        setContentView(a.f.avatar_face_setting_activity);
        this.f1390b = (DetectingFaceView) findViewById(a.e.detacting_face_view);
        Resources resources = getResources();
        f.f1467a.getClass();
        Button button = (Button) findViewById(a.e.button_negative);
        button.setText(resources.getString(a.g.cancel));
        button.setOnClickListener(this.f);
        Button button2 = (Button) findViewById(a.e.button_positive);
        button2.setText(resources.getString(a.g.confirm));
        button2.setOnClickListener(this.f);
        Intent intent = getIntent();
        if (intent != null) {
            final String stringExtra = intent.getStringExtra("detecting_face_file_path");
            final int[] intArrayExtra = intent.getIntArrayExtra("detecting_face_points");
            this.f1390b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (stringExtra == null || intArrayExtra == null) {
                        Log.e(AvatarFaceSettingActivity.this.f1389a, "[ERROR] :: wrong info for detecting face view");
                        AvatarFaceSettingActivity.this.a(16, (Object) null);
                    } else {
                        AvatarFaceSettingActivity.this.f1390b.a(stringExtra, intArrayExtra);
                    }
                    AvatarFaceSettingActivity.this.f1390b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
            return;
        }
        Log.e(this.f1389a, "[ERROR] :: wrong info for detecting face view");
        a(0, (Object) null);
    }

    /* access modifiers changed from: private */
    public void a() {
        if (this.d == null) {
            this.d = new net.fxgear.fittingmodenative.b.a(this, 0);
        }
        if (this.d != null && !this.d.isShowing()) {
            this.d.show();
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        if (this.d != null) {
            if (this.d.isShowing()) {
                this.d.dismiss();
            }
            this.d = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Log.i(this.f1389a, "onResume()+");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        Log.i(this.f1389a, "onPause()+");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Log.i(this.f1389a, "onDestroy()+");
        if (this.c != null) {
            this.c.interrupt();
            this.c = null;
        }
        b();
        if (this.f1390b != null) {
            this.f1390b.c();
            this.f1390b = null;
        }
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public void a(int i, Object obj) {
        String str = this.f1389a;
        Log.i(str, "FinishAvatarFaceSettingActivity(), resultCode: " + i);
        Intent intent = new Intent();
        f.f1467a.getClass();
        if (i == -1) {
            if (obj != null && (obj instanceof a)) {
                a aVar = (a) obj;
                intent.putExtra("detecting_face_file_path", aVar.f1395a);
                intent.putExtra("detecting_face_points", aVar.f1396b);
            }
        } else if (i == 4 && obj != null && (obj instanceof Long)) {
            intent.putExtra("detecting_face_need_space_size", ((Long) obj).longValue());
        }
        setResult(i, intent);
        finish();
    }

    public void onBackPressed() {
        Log.i(this.f1389a, "onBackPressed()+");
        a(0, (Object) null);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\customface\DetectingFaceView.java ==========

package net.fxgear.fittingmodenative.customface;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import java.util.ArrayList;
import net.fxgear.GlobalDefine;
import net.fxgear.a.a;
import net.fxgear.fittingmodenative.f;

public class DetectingFaceView extends View implements View.OnTouchListener {
    /* access modifiers changed from: private */
    public float A = 1.0f;
    /* access modifiers changed from: private */
    public Matrix B;
    private final float C = 0.75f;
    private final int D = 3;
    private ScaleGestureDetector E;
    private GestureDetector F;
    private Drawable G = null;
    private int H;
    private int I;
    private final int J = 0;
    private final int K = 0;
    private final int L = 2;
    private Paint M;
    private PathDashPathEffect N;
    private Paint O;
    private PathDashPathEffect P;
    private final float Q = getResources().getDimension(a.c.face_setting_rect_small_point_width);
    private final float R = (getResources().getDimension(a.c.face_setting_rect_small_point_width) / 2.0f);
    private final float S = (getResources().getDimension(a.c.face_setting_rect_small_point_interval) + getResources().getDimension(a.c.face_setting_rect_small_point_width));
    private final float T = (getResources().getDimension(a.c.face_setting_rect_large_point_width) / 2.0f);
    private ArrayList<a> U;
    private int V = -1;
    private final int W = 5;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f1397a = DetectingFaceView.class.getSimpleName();
    private final int aa = 5;
    private ArrayList<c> ab;
    private int ac = -1;
    private int ad;
    private int ae;
    private final int af = 40;
    private final int ag = 128;
    private final int ah = 77;
    private final int ai;
    private final int aj;
    private final int ak;
    /* access modifiers changed from: private */
    public boolean al = false;
    private final int am = 0;
    private final int an = 1;
    private final int ao = 2;
    private final int ap = 3;
    private final int aq = 4;
    private final int ar = 5;
    /* access modifiers changed from: private */
    public int as = 0;
    /* access modifiers changed from: private */
    public int at;
    /* access modifiers changed from: private */
    public int au;
    private String av = null;
    private Bitmap aw;
    private Canvas ax;
    private ScaleGestureDetector.OnScaleGestureListener ay = new ScaleGestureDetector.OnScaleGestureListener() {
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            int unused = DetectingFaceView.this.as = 0;
            String a2 = DetectingFaceView.this.f1397a;
            Log.d(a2, "[JE] onScaleEnd(), mScaleFactor: " + DetectingFaceView.this.A);
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            int unused = DetectingFaceView.this.as = 4;
            if (!DetectingFaceView.this.al) {
                return true;
            }
            boolean unused2 = DetectingFaceView.this.al = false;
            DetectingFaceView.this.invalidate();
            return true;
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float b2 = DetectingFaceView.this.A;
            int d = DetectingFaceView.this.t;
            int e = DetectingFaceView.this.u;
            float unused = DetectingFaceView.this.A = DetectingFaceView.this.A * scaleGestureDetector.getScaleFactor();
            float unused2 = DetectingFaceView.this.A = Math.max(DetectingFaceView.this.z, Math.min(DetectingFaceView.this.A, DetectingFaceView.this.z * 3.0f));
            float g = (float) (DetectingFaceView.this.at / 2);
            int unused3 = DetectingFaceView.this.t = Math.round(g - (((g - ((float) DetectingFaceView.this.t)) * DetectingFaceView.this.A) / b2));
            if (((float) DetectingFaceView.this.v) * DetectingFaceView.this.A < ((float) DetectingFaceView.this.at)) {
                if (DetectingFaceView.this.t > DetectingFaceView.this.x) {
                    int unused4 = DetectingFaceView.this.t = DetectingFaceView.this.x;
                } else if (((float) DetectingFaceView.this.t) + (((float) DetectingFaceView.this.v) * DetectingFaceView.this.A) < ((float) DetectingFaceView.this.x) + (((float) DetectingFaceView.this.v) * DetectingFaceView.this.z)) {
                    int unused5 = DetectingFaceView.this.t = (int) ((((float) DetectingFaceView.this.x) + (((float) DetectingFaceView.this.v) * DetectingFaceView.this.z)) - (((float) DetectingFaceView.this.v) * DetectingFaceView.this.A));
                }
            } else if (DetectingFaceView.this.t > 0) {
                int unused6 = DetectingFaceView.this.t = 0;
            } else if (((float) DetectingFaceView.this.t) + (((float) DetectingFaceView.this.v) * DetectingFaceView.this.A) < ((float) DetectingFaceView.this.at)) {
                int unused7 = DetectingFaceView.this.t = (int) (((float) DetectingFaceView.this.at) - (((float) DetectingFaceView.this.v) * DetectingFaceView.this.A));
            }
            float j = (float) (DetectingFaceView.this.au / 2);
            int unused8 = DetectingFaceView.this.u = Math.round(j - (((j - ((float) DetectingFaceView.this.u)) * DetectingFaceView.this.A) / b2));
            if (((float) DetectingFaceView.this.w) * DetectingFaceView.this.A < ((float) DetectingFaceView.this.au)) {
                if (DetectingFaceView.this.u > DetectingFaceView.this.y) {
                    int unused9 = DetectingFaceView.this.u = DetectingFaceView.this.y;
                } else if (((float) DetectingFaceView.this.u) + (((float) DetectingFaceView.this.w) * DetectingFaceView.this.A) < ((float) DetectingFaceView.this.y) + (((float) DetectingFaceView.this.w) * DetectingFaceView.this.z)) {
                    int unused10 = DetectingFaceView.this.u = (int) ((((float) DetectingFaceView.this.y) + (((float) DetectingFaceView.this.w) * DetectingFaceView.this.z)) - (((float) DetectingFaceView.this.w) * DetectingFaceView.this.A));
                }
            } else if (DetectingFaceView.this.u > 0) {
                int unused11 = DetectingFaceView.this.u = 0;
            } else if (((float) DetectingFaceView.this.u) + (((float) DetectingFaceView.this.w) * DetectingFaceView.this.A) < ((float) DetectingFaceView.this.au)) {
                int unused12 = DetectingFaceView.this.u = (int) (((float) DetectingFaceView.this.au) - (((float) DetectingFaceView.this.w) * DetectingFaceView.this.A));
            }
            if (DetectingFaceView.this.B != null) {
                DetectingFaceView.this.B.reset();
                DetectingFaceView.this.B.postScale(DetectingFaceView.this.A, DetectingFaceView.this.A);
                DetectingFaceView.this.B.postTranslate((float) DetectingFaceView.this.t, (float) DetectingFaceView.this.u);
            }
            DetectingFaceView.this.a(d, e, b2);
            DetectingFaceView.this.invalidate();
            return true;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final int f1398b = -1;
    private int c = -1;
    private final int d = 0;
    private final int e = 1;
    private final int f = 2;
    private final int g = 3;
    private final int h = 4;
    private final int i = 5;
    private final int j = 6;
    private final int k = 7;
    private final int l = 8;
    private final int m = 4;
    private final int n = 5;
    private int[] o = null;
    private final int p = 8;
    private final int q = 5;
    private final int r = 2;
    private Bitmap s = null;
    /* access modifiers changed from: private */
    public int t = 0;
    /* access modifiers changed from: private */
    public int u = 0;
    /* access modifiers changed from: private */
    public int v = 0;
    /* access modifiers changed from: private */
    public int w = 0;
    /* access modifiers changed from: private */
    public int x = 0;
    /* access modifiers changed from: private */
    public int y = 0;
    /* access modifiers changed from: private */
    public float z = 1.0f;

    private class a {

        /* renamed from: a  reason: collision with root package name */
        public int f1400a;

        /* renamed from: b  reason: collision with root package name */
        public Rect f1401b;

        private a() {
            this.f1400a = -1;
            this.f1401b = null;
        }
    }

    private class c extends a {
        public Point d;

        private c() {
            super();
            this.d = null;
        }
    }

    public DetectingFaceView(Context context) {
        super(context);
        Log.i(this.f1397a, "DetectingFaceView()+");
        this.ai = (int) f.a(context, 40.0f);
        this.aj = (int) f.a(context, 128.0f);
        this.ak = (int) f.a(context, 77.0f);
    }

    public DetectingFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Log.i(this.f1397a, "DetectingFaceView()+");
        this.ai = (int) f.a(context, 40.0f);
        this.aj = (int) f.a(context, 128.0f);
        this.ak = (int) f.a(context, 77.0f);
    }

    public void a(String str, int[] iArr) {
        ArrayList arrayList;
        int i2;
        Log.i(this.f1397a, "Initialize()+, faceFilePath: " + str + ", faceDetectingPoints: " + iArr);
        this.at = getMeasuredWidth();
        this.au = getMeasuredHeight();
        this.B = new Matrix();
        this.aw = Bitmap.createBitmap(this.at, this.au, Bitmap.Config.ARGB_8888);
        this.ax = new Canvas(this.aw);
        this.s = BitmapFactory.decodeFile(str);
        if (this.s != null) {
            this.av = str;
            this.v = this.s.getWidth();
            this.w = this.s.getHeight();
            float f2 = ((float) this.v) / ((float) this.w);
            if (((float) this.at) / ((float) this.au) < f2) {
                i2 = this.at;
                int i3 = (int) (((float) this.at) / f2);
                this.x = 0;
                this.y = (this.au - i3) / 2;
            } else {
                i2 = (int) (((float) this.au) * f2);
                int i4 = this.au;
                this.x = (this.at - i2) / 2;
                this.y = 0;
            }
            this.z = ((float) i2) / ((float) this.v);
            Log.i(this.f1397a, "[JE] mInitFaceBitmapOffsetX: " + this.x + ",  mInitFaceBitmapOffsetY: " + this.y + ", mInitFaceBitmapScale: " + this.z);
            this.t = this.x;
            this.u = this.y;
            this.A = this.z;
            this.B.postScale(this.A, this.A);
            this.B.postTranslate((float) this.t, (float) this.u);
        } else {
            Log.e(this.f1397a, "[ERROR] :: bitmap is null");
        }
        if (iArr != null) {
            this.o = (int[]) iArr.clone();
            this.O = new Paint();
            Path path = new Path();
            path.addCircle(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, this.R, Path.Direction.CW);
            this.P = new PathDashPathEffect(path, this.S, this.S, PathDashPathEffect.Style.ROTATE);
            this.M = new Paint();
            this.M.setColor(getResources().getColor(a.b.color_white_opacity_40));
            this.M.setStyle(Paint.Style.FILL_AND_STROKE);
            this.M.setStrokeWidth(this.Q);
            Path path2 = new Path();
            path2.addCircle(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 2.0f, this.R, Path.Direction.CW);
            this.N = new PathDashPathEffect(path2, this.S, this.S, PathDashPathEffect.Style.TRANSLATE);
            this.G = getResources().getDrawable(a.d.btn_size_control);
            this.H = this.G.getIntrinsicWidth();
            this.I = this.G.getIntrinsicHeight();
            this.U = new ArrayList<>();
            for (int i5 = 0; i5 < 4; i5++) {
                int i6 = i5 * 8;
                int i7 = i6 + 5;
                int i8 = i6 + 2;
                int i9 = i7 + 2;
                int round = Math.round((((float) iArr[i6]) * this.A) + ((float) this.t));
                int round2 = Math.round((((float) iArr[i7]) * this.A) + ((float) this.u));
                int round3 = Math.round((((float) iArr[i8]) * this.A) + ((float) this.t));
                int round4 = Math.round((((float) iArr[i9]) * this.A) + ((float) this.u));
                a aVar = new a();
                aVar.f1400a = i5;
                aVar.f1401b = new Rect(round, round2, round3, round4);
                this.U.add(aVar);
            }
            arrayList = new ArrayList();
            this.ab = new ArrayList<>();
            arrayList.add(new Point(iArr[32], iArr[33]));
            int round5 = Math.round((((float) iArr[32]) * this.A) + ((float) this.t));
            int round6 = Math.round((((float) iArr[33]) * this.A) + ((float) this.u));
            c cVar = new c();
            cVar.f1400a = 4;
            cVar.d = new Point(round5, round6);
            this.ab.add(cVar);
            arrayList.add(new Point(iArr[36], iArr[37]));
            int round7 = Math.round((((float) iArr[36]) * this.A) + ((float) this.t));
            int round8 = Math.round((((float) iArr[37]) * this.A) + ((float) this.u));
            c cVar2 = new c();
            cVar2.f1400a = 5;
            cVar2.d = new Point(round7, round8);
            this.ab.add(cVar2);
            arrayList.add(new Point(iArr[40], iArr[41]));
            int round9 = Math.round((((float) iArr[40]) * this.A) + ((float) this.t));
            int round10 = Math.round((((float) iArr[41]) * this.A) + ((float) this.u));
            c cVar3 = new c();
            cVar3.f1400a = 6;
            cVar3.d = new Point(round9, round10);
            this.ab.add(cVar3);
            arrayList.add(new Point(iArr[38], iArr[39]));
            int round11 = Math.round((((float) iArr[38]) * this.A) + ((float) this.t));
            int round12 = Math.round((((float) iArr[39]) * this.A) + ((float) this.u));
            c cVar4 = new c();
            cVar4.f1400a = 7;
            cVar4.d = new Point(round11, round12);
            this.ab.add(cVar4);
            arrayList.add(new Point(iArr[34], iArr[35]));
            int round13 = Math.round((((float) iArr[34]) * this.A) + ((float) this.t));
            int round14 = Math.round((((float) iArr[35]) * this.A) + ((float) this.u));
            c cVar5 = new c();
            cVar5.f1400a = 8;
            cVar5.d = new Point(round13, round14);
            this.ab.add(cVar5);
            for (int i10 = 0; i10 < this.ab.size(); i10++) {
                c cVar6 = this.ab.get(i10);
                cVar6.f1401b = new Rect(cVar6.d.x - (this.H / 2), cVar6.d.y - (this.I / 2), cVar6.d.x + (this.H / 2), cVar6.d.y + (this.I / 2));
            }
        } else {
            Log.e(this.f1397a, "[ERROR] :: faceDetectingPoints is null");
            arrayList = null;
        }
        a((ArrayList<Point>) arrayList, this.t, this.u, this.A);
        this.E = new ScaleGestureDetector(getContext(), this.ay);
        this.F = new GestureDetector(getContext(), new b());
        setOnTouchListener(this);
        Log.d(this.f1397a, "[JE] Initialize()-, mScaleFactor: " + this.A + ", mFaceBitmapOffsetX: " + this.t + ", mFaceBitmapOffsetY: " + this.u);
    }

    private void a(ArrayList<Point> arrayList, int i2, int i3, float f2) {
        float f3;
        String str = this.f1397a;
        Log.e(str, "[JE] ScaleAndTraslateInitView()+, preOffsetX: " + i2 + ", preOffsetY: " + i3 + ", preScaleFactor: " + f2);
        if (arrayList != null && arrayList.size() == 5) {
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < 5; i8++) {
                Point point = arrayList.get(i8);
                if (i8 == 0) {
                    i4 = point.x;
                    i5 = point.y;
                    i6 = point.x;
                    i7 = point.y;
                } else {
                    i4 = Math.min(i4, point.x);
                    i5 = Math.min(i5, point.y);
                    i6 = Math.max(i6, point.x);
                    i7 = Math.max(i7, point.y);
                }
            }
            Rect rect = new Rect(i4, i5, i6, i7);
            int width = rect.width();
            int height = rect.height();
            float f4 = ((float) this.au) * 0.75f;
            float f5 = (float) width;
            if (f5 < ((float) this.at) * 0.75f || ((float) height) < f4) {
                float f6 = (float) height;
                if (f5 / ((float) this.at) < f6 / ((float) this.au)) {
                    f3 = (((float) this.au) * 0.75f) / f6;
                } else {
                    f3 = (((float) this.at) * 0.75f) / f5;
                }
                this.A = Math.min(f3, this.z * 3.0f);
                float f7 = (float) (this.at / 2);
                float f8 = (float) (this.au / 2);
                float f9 = (float) i2;
                float f10 = (float) i3;
                float centerY = f8 - ((((float) rect.centerY()) * f2) + f10);
                this.t = Math.round(f7 - (((f7 - (f9 + (f7 - ((((float) rect.centerX()) * f2) + f9)))) * this.A) / f2));
                if (((float) this.v) * this.A < ((float) this.at)) {
                    this.t = (int) ((((float) this.at) - (((float) this.v) * this.A)) / 2.0f);
                } else if (this.t > 0) {
                    this.t = 0;
                } else if (((float) this.t) + (((float) this.v) * this.A) < ((float) this.at)) {
                    this.t = (int) (((float) this.at) - (((float) this.v) * this.A));
                }
                this.u = Math.round(f8 - (((f8 - (f10 + centerY)) * this.A) / f2));
                if (((float) this.w) * this.A < ((float) this.au)) {
                    this.u = (int) ((((float) this.au) - (((float) this.w) * this.A)) / 2.0f);
                } else if (this.u > 0) {
                    this.u = 0;
                } else if (((float) this.u) + (((float) this.w) * this.A) < ((float) this.au)) {
                    this.u = (int) (((float) this.au) - (((float) this.w) * this.A));
                }
                if (this.B != null) {
                    this.B.reset();
                    this.B.postScale(this.A, this.A);
                    this.B.postTranslate((float) this.t, (float) this.u);
                }
                a(i2, i3, f2);
            }
        }
        invalidate();
    }

    public String a() {
        return this.av;
    }

    public int[] b() {
        if (this.o == null || this.U == null || this.ab == null) {
            Log.e(this.f1397a, "[JE] GetFaceDetectPoints()-, detectPoints is null");
            return null;
        }
        int size = this.U.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < size; i4++) {
                if (this.U.get(i2).f1400a > this.U.get(i4).f1400a) {
                    this.U.set(i2, this.U.get(i4));
                    this.U.set(i4, this.U.get(i2));
                }
            }
            i2 = i3;
        }
        int[] iArr = new int[this.o.length];
        for (int i5 = 0; i5 < size; i5++) {
            a aVar = this.U.get(i5);
            int i6 = i5 * 8;
            int i7 = i6 + 5;
            int i8 = i6 + 2;
            int i9 = i7 + 2;
            int round = Math.round(((float) (aVar.f1401b.left - this.t)) / this.A);
            int round2 = Math.round(((float) (aVar.f1401b.right - this.t)) / this.A);
            int round3 = Math.round(((float) (aVar.f1401b.top - this.u)) / this.A);
            int round4 = Math.round(((float) (aVar.f1401b.bottom - this.u)) / this.A);
            iArr[i6] = round;
            int i10 = i6 + 1;
            float f2 = (float) round4;
            iArr[i10] = Math.round((((float) this.o[i10]) / ((float) this.o[i9])) * f2);
            iArr[i8] = round2;
            int i11 = i8 + 1;
            iArr[i11] = Math.round(f2 * (((float) this.o[i11]) / ((float) this.o[i9])));
            int i12 = i7 - 1;
            float f3 = (float) round2;
            iArr[i12] = Math.round((((float) this.o[i12]) / ((float) this.o[i8])) * f3);
            iArr[i7] = round3;
            int i13 = i9 - 1;
            iArr[i13] = Math.round(f3 * (((float) this.o[i13]) / ((float) this.o[i8])));
            iArr[i9] = round4;
        }
        int size2 = this.ab.size();
        int i14 = 0;
        while (i14 < size2) {
            int i15 = i14 + 1;
            for (int i16 = i15; i16 < size2; i16++) {
                if (this.ab.get(i14).f1400a > this.ab.get(i16).f1400a) {
                    this.ab.set(i14, this.ab.get(i16));
                    this.ab.set(i16, this.ab.get(i14));
                }
            }
            i14 = i15;
        }
        int i17 = size * 8;
        iArr[i17] = Math.round(((float) (this.ab.get(0).d.x - this.t)) / this.A);
        int i18 = i17 + 1;
        iArr[i18] = Math.round(((float) (this.ab.get(0).d.y - this.u)) / this.A);
        int i19 = i18 + 1;
        iArr[i19] = Math.round(((float) (this.ab.get(4).d.x - this.t)) / this.A);
        int i20 = i19 + 1;
        iArr[i20] = Math.round(((float) (this.ab.get(4).d.y - this.u)) / this.A);
        int i21 = i20 + 1;
        iArr[i21] = Math.round(((float) (this.ab.get(1).d.x - this.t)) / this.A);
        int i22 = i21 + 1;
        iArr[i22] = Math.round(((float) (this.ab.get(1).d.y - this.u)) / this.A);
        int i23 = i22 + 1;
        iArr[i23] = Math.round(((float) (this.ab.get(3).d.x - this.t)) / this.A);
        int i24 = i23 + 1;
        iArr[i24] = Math.round(((float) (this.ab.get(3).d.y - this.u)) / this.A);
        int i25 = i24 + 1;
        iArr[i25] = Math.round(((float) (this.ab.get(2).d.x - this.t)) / this.A);
        iArr[i25 + 1] = Math.round(((float) (this.ab.get(2).d.y - this.u)) / this.A);
        Log.e(this.f1397a, "[JE] GetFaceDetectPoints()-");
        for (int i26 = 0; i26 < iArr.length; i26++) {
            Log.e(this.f1397a, "[JE] detectPoints[" + i26 + "]: " + iArr[i26]);
        }
        return iArr;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2;
        c cVar;
        a aVar;
        int i3 = 0;
        boolean z2 = this.al && this.c != -1;
        Canvas canvas2 = z2 ? this.ax : canvas;
        canvas2.drawColor(-16777216);
        if (this.s != null) {
            canvas2.drawBitmap(this.s, this.B, (Paint) null);
        }
        if (this.O != null) {
            a(canvas2, this.O);
            if (this.U != null) {
                for (int i4 = 0; i4 < this.U.size(); i4++) {
                    a aVar2 = this.U.get(i4);
                    a(aVar2, canvas2, this.O);
                    if (this.G != null && aVar2.f1400a == this.c) {
                        int i5 = aVar2.f1401b.right + 0;
                        int i6 = aVar2.f1401b.bottom + 0;
                        this.G.setBounds(i5, i6, this.H + i5, this.I + i6);
                        this.G.draw(canvas2);
                    }
                }
            }
        }
        if (z2) {
            canvas.drawBitmap(this.aw, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, (Paint) null);
            if (this.c < 4) {
                if (!(this.U == null || this.V == -1 || (aVar = this.U.get(this.V)) == null)) {
                    int centerX = aVar.f1401b.centerX();
                    i2 = aVar.f1401b.centerY();
                    i3 = centerX;
                    a(i3, i2, canvas);
                }
            } else if (!(this.ab == null || this.ac == -1 || (cVar = this.ab.get(this.ac)) == null)) {
                i3 = cVar.d.x;
                i2 = cVar.d.y;
                a(i3, i2, canvas);
            }
            i2 = 0;
            a(i3, i2, canvas);
        }
        super.onDraw(canvas);
    }

    private Bitmap a(Bitmap bitmap, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8 = i4;
        int i9 = i5;
        if (bitmap == null || i8 < 0 || i9 < 0) {
            return null;
        }
        if (i2 < 0) {
            i6 = 0;
        } else {
            i6 = i2 + i8 > bitmap.getWidth() ? bitmap.getWidth() - i8 : i2;
        }
        if (i3 < 0) {
            i7 = 0;
        } else {
            i7 = i3 + i9 > bitmap.getHeight() ? bitmap.getHeight() - i9 : i3;
        }
        int[] iArr = new int[(i8 * i9)];
        int i10 = i4;
        int i11 = i4;
        int i12 = i5;
        bitmap.getPixels(iArr, 0, i10, i6, i7, i11, i12);
        Bitmap createBitmap = Bitmap.createBitmap(i8, i9, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, i10, 0, 0, i11, i12);
        return createBitmap;
    }

    private void a(int i2, int i3, Canvas canvas) {
        int i4 = i2 - (this.aj / 2);
        if (i4 < this.t) {
            i4 = this.t;
        } else if (((float) (this.aj + i4)) > ((float) this.t) + (((float) this.v) * this.A)) {
            i4 = (int) ((((float) this.t) + (((float) this.v) * this.A)) - ((float) this.aj));
        }
        int i5 = i4;
        int i6 = i3 - (this.ak / 2);
        if (i6 < this.u) {
            i6 = this.u;
        } else if (((float) (this.ak + i6)) > ((float) this.u) + (((float) this.w) * this.A)) {
            i6 = (int) ((((float) this.u) + (((float) this.w) * this.A)) - ((float) this.ak));
        }
        Bitmap a2 = a(this.aw, i5, i6, this.aj, this.ak);
        if (a2 != null) {
            float f2 = (float) (i2 - (this.aj / 2));
            if (f2 < ((float) Math.min(this.t, 0))) {
                f2 = (float) Math.min(this.t, 0);
            } else if (((float) this.aj) + f2 > ((float) this.t) + (((float) this.v) * this.A)) {
                f2 = (((float) this.t) + (((float) this.v) * this.A)) - ((float) this.aj);
            }
            float f3 = f2;
            float f4 = (float) ((i3 - this.ai) - this.ak);
            if (f4 < ((float) Math.min(this.u, 0))) {
                f4 = (float) (i3 + this.ai + this.ak);
            } else if (f4 > (((float) this.u) + (((float) this.w) * this.A)) - ((float) (this.ai + this.ak))) {
                f4 = (((float) this.u) + (((float) this.w) * this.A)) - ((float) (this.ai + this.ak));
            }
            float f5 = f4;
            canvas.drawBitmap(a2, f3, f5, (Paint) null);
            this.O.setColor(-1);
            this.O.setStyle(Paint.Style.STROKE);
            this.O.setStrokeWidth(this.Q);
            this.O.setPathEffect((PathEffect) null);
            canvas.drawRect(f3, f5, f3 + ((float) this.aj), f5 + ((float) this.ak), this.O);
            if (a2 != null && !a2.isRecycled()) {
                a2.recycle();
            }
        }
    }

    private Point a(Point point, Point point2) {
        return new Point((point.x - point2.x) / 2, (point.y - point2.y) / 2);
    }

    private void a(Canvas canvas, Point[] pointArr, float f2, Paint paint) {
        Canvas canvas2 = canvas;
        Point[] pointArr2 = pointArr;
        Paint paint2 = paint;
        if (canvas2 == null || pointArr2 == null || paint2 == null) {
            Log.e(this.f1397a, "DrawCatmullCurve()+, wrong param");
            return;
        }
        Path path = new Path();
        int i2 = 0;
        path.moveTo((float) pointArr2[0].x, (float) pointArr2[0].y);
        int length = pointArr2.length;
        while (i2 < length) {
            float f3 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            while (f3 < 1.0f) {
                float f4 = f3 * f3;
                float f5 = 1.0f - f3;
                float f6 = 2.0f * f3;
                float f7 = (f6 + 1.0f) * f5 * f5;
                float f8 = f3 * f5 * f5;
                float f9 = (3.0f - f6) * f4;
                float f10 = f4 * (f3 - 1.0f);
                if (i2 == 0) {
                    int i3 = i2 + 1;
                    Point a2 = a(pointArr2[i3], pointArr2[i2]);
                    Point a3 = a(pointArr2[i2 + 2], pointArr2[i2]);
                    path.lineTo((((float) pointArr2[i2].x) * f7) + (((float) a2.x) * f8) + (((float) pointArr2[i3].x) * f9) + (((float) a3.x) * f10), (f7 * ((float) pointArr2[i2].y)) + (f8 * ((float) a2.y)) + (f9 * ((float) pointArr2[i3].y)) + (f10 * ((float) a3.y)));
                } else if (i2 < length - 2) {
                    int i4 = i2 + 1;
                    Point a4 = a(pointArr2[i4], pointArr2[i2 - 1]);
                    Point a5 = a(pointArr2[i2 + 2], pointArr2[i2]);
                    path.lineTo((((float) pointArr2[i2].x) * f7) + (((float) a4.x) * f8) + (((float) pointArr2[i4].x) * f9) + (((float) a5.x) * f10), (f7 * ((float) pointArr2[i2].y)) + (f8 * ((float) a4.y)) + (f9 * ((float) pointArr2[i4].y)) + (f10 * ((float) a5.y)));
                } else if (i2 == length - 1) {
                    Point a6 = a(pointArr2[i2], pointArr2[i2 - 2]);
                    int i5 = i2 - 1;
                    Point a7 = a(pointArr2[i2], pointArr2[i5]);
                    path.lineTo((((float) pointArr2[i5].x) * f7) + (((float) a6.x) * f8) + (((float) pointArr2[i2].x) * f9) + (((float) a7.x) * f10), (f7 * ((float) pointArr2[i5].y)) + (f8 * ((float) a6.y)) + (f9 * ((float) pointArr2[i2].y)) + (f10 * ((float) a7.y)));
                }
                f3 += f2;
                Paint paint3 = paint;
            }
            i2++;
            Paint paint4 = paint;
        }
        int i6 = length - 1;
        path.lineTo((float) pointArr2[i6].x, (float) pointArr2[i6].y);
        canvas2.drawPath(path, this.M);
        canvas2.drawPath(path, paint);
    }

    private void a(Canvas canvas, Paint paint) {
        if (canvas == null || paint == null) {
            Log.e(this.f1397a, "DrawFaceLine()+ wrong param");
        } else if (this.ab != null) {
            paint.setColor(-1);
            paint.setStyle(Paint.Style.STROKE);
            if (this.P != null) {
                paint.setPathEffect(this.P);
                paint.setStrokeWidth(this.Q);
            }
            if (this.M != null) {
                this.M.setPathEffect(this.N);
                this.M.setStrokeWidth(this.Q);
            }
            ArrayList arrayList = (ArrayList) this.ab.clone();
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = i2 + 1;
                for (int i4 = i3; i4 < size; i4++) {
                    if (((c) arrayList.get(i2)).f1400a > ((c) arrayList.get(i4)).f1400a) {
                        arrayList.set(i2, arrayList.get(i4));
                        arrayList.set(i4, (c) arrayList.get(i2));
                    }
                }
                i2 = i3;
            }
            a(canvas, new Point[]{((c) arrayList.get(0)).d, ((c) arrayList.get(1)).d, ((c) arrayList.get(2)).d, ((c) arrayList.get(3)).d, ((c) arrayList.get(4)).d}, 0.1f, paint);
            if (this.M != null) {
                this.M.setPathEffect((PathEffect) null);
                this.M.setStrokeWidth(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
                for (int i5 = 0; i5 < this.ab.size(); i5++) {
                    c cVar = this.ab.get(i5);
                    canvas.drawCircle((float) cVar.d.x, (float) (cVar.d.y + 2), this.T, this.M);
                }
            }
            paint.setPathEffect((PathEffect) null);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setStrokeWidth(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
            Resources resources = getResources();
            for (int i6 = 0; i6 < this.ab.size(); i6++) {
                c cVar2 = this.ab.get(i6);
                paint.setColor(cVar2.f1400a == this.c ? resources.getColor(a.b.main_color) : -1);
                canvas.drawCircle((float) cVar2.d.x, (float) cVar2.d.y, this.T, paint);
            }
        } else {
            Log.e(this.f1397a, "mPointForFaceLine is null");
        }
    }

    private void a(a aVar, Canvas canvas, Paint paint) {
        if (aVar == null || canvas == null || paint == null) {
            Log.e(this.f1397a, "DrawFaceLine()+ wrong param");
            return;
        }
        paint.setColor(aVar.f1400a == this.c ? getResources().getColor(a.b.main_color) : -1);
        paint.setStrokeWidth(this.Q);
        int centerX = aVar.f1401b.centerX();
        int centerY = aVar.f1401b.centerY();
        if (aVar.f1400a == 2) {
            Path path = new Path();
            if (this.M != null) {
                if (this.N != null) {
                    this.M.setPathEffect(this.N);
                    this.M.setStrokeWidth(this.Q);
                }
                float f2 = (float) centerX;
                path.moveTo(f2, (float) aVar.f1401b.top);
                path.lineTo(f2, (float) aVar.f1401b.bottom);
                canvas.drawPath(path, this.M);
                path.moveTo((float) aVar.f1401b.left, (float) aVar.f1401b.bottom);
                path.lineTo((float) aVar.f1401b.right, (float) aVar.f1401b.bottom);
                canvas.drawPath(path, this.M);
            }
            paint.setStyle(Paint.Style.STROKE);
            if (this.P != null) {
                paint.setPathEffect(this.P);
                paint.setStrokeWidth(this.Q);
            }
            float f3 = (float) centerX;
            path.moveTo(f3, (float) aVar.f1401b.top);
            path.lineTo(f3, (float) aVar.f1401b.bottom);
            canvas.drawPath(path, paint);
            path.moveTo((float) aVar.f1401b.left, (float) aVar.f1401b.bottom);
            path.lineTo((float) aVar.f1401b.right, (float) aVar.f1401b.bottom);
            canvas.drawPath(path, paint);
            if (this.M != null) {
                this.M.setPathEffect((PathEffect) null);
                this.M.setStrokeWidth(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
                canvas.drawCircle((float) aVar.f1401b.left, (float) (aVar.f1401b.bottom + 2), this.T, this.M);
                canvas.drawCircle(f3, (float) (aVar.f1401b.top + 2), this.T, this.M);
                canvas.drawCircle((float) aVar.f1401b.right, (float) (aVar.f1401b.bottom + 2), this.T, this.M);
                canvas.drawCircle(f3, (float) (aVar.f1401b.bottom + 2), this.T, this.M);
            }
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setPathEffect((PathEffect) null);
            paint.setStrokeWidth(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
            canvas.drawCircle((float) aVar.f1401b.left, (float) aVar.f1401b.bottom, this.T, paint);
            canvas.drawCircle(f3, (float) aVar.f1401b.top, this.T, paint);
            canvas.drawCircle((float) aVar.f1401b.right, (float) aVar.f1401b.bottom, this.T, paint);
            canvas.drawCircle(f3, (float) aVar.f1401b.bottom, this.T, paint);
            return;
        }
        if (this.M != null) {
            if (this.N != null) {
                this.M.setPathEffect(this.N);
                this.M.setStrokeWidth(this.Q);
            }
            canvas.drawRect(aVar.f1401b, this.M);
        }
        paint.setStyle(Paint.Style.STROKE);
        if (this.P != null) {
            paint.setPathEffect(this.P);
            paint.setStrokeWidth(this.Q);
        }
        canvas.drawRect(aVar.f1401b, paint);
        if (this.M != null) {
            this.M.setPathEffect((PathEffect) null);
            this.M.setStrokeWidth(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
            float f4 = (float) (centerY + 2);
            canvas.drawCircle((float) aVar.f1401b.left, f4, this.T, this.M);
            float f5 = (float) centerX;
            canvas.drawCircle(f5, (float) (aVar.f1401b.top + 2), this.T, this.M);
            canvas.drawCircle((float) aVar.f1401b.right, f4, this.T, this.M);
            canvas.drawCircle(f5, (float) (aVar.f1401b.bottom + 2), this.T, this.M);
        }
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setPathEffect((PathEffect) null);
        paint.setStrokeWidth(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        float f6 = (float) centerY;
        canvas.drawCircle((float) aVar.f1401b.left, f6, this.T, paint);
        float f7 = (float) centerX;
        canvas.drawCircle(f7, (float) aVar.f1401b.top, this.T, paint);
        canvas.drawCircle((float) aVar.f1401b.right, f6, this.T, paint);
        canvas.drawCircle(f7, (float) aVar.f1401b.bottom, this.T, paint);
    }

    public void c() {
        if (this.s != null) {
            if (!this.s.isRecycled()) {
                this.s.recycle();
            }
            this.s = null;
        }
        if (this.U != null) {
            this.U.clear();
            this.U = null;
        }
        this.o = null;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (this.F != null) {
            this.F.onTouchEvent(motionEvent);
        }
        if (this.E != null) {
            this.E.onTouchEvent(motionEvent);
        }
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                Log.i(this.f1397a, "onTouch - ACTION_DOWN");
                this.ad = x2;
                this.ae = y2;
                if (this.c == -1 || this.c >= 4 || this.G == null || !this.G.getBounds().contains(x2, y2)) {
                    if (this.U != null) {
                        for (int size = this.U.size() - 1; size >= 0; size--) {
                            a aVar = this.U.get(size);
                            if (aVar.f1401b.width() < this.H) {
                                i3 = aVar.f1401b.centerX() - (this.H / 2);
                                i2 = aVar.f1401b.centerX() + (this.H / 2);
                            } else {
                                i3 = aVar.f1401b.left;
                                i2 = aVar.f1401b.right;
                            }
                            if (aVar.f1401b.height() < this.I) {
                                i5 = aVar.f1401b.centerY() - (this.I / 2);
                                i4 = aVar.f1401b.centerY() + (this.I / 2);
                            } else {
                                i5 = aVar.f1401b.top;
                                i4 = aVar.f1401b.bottom;
                            }
                            if (new Rect(i3, i5, i2, i4).contains(x2, y2)) {
                                this.as = 2;
                                this.V = size;
                                this.c = aVar.f1400a;
                                Log.e(this.f1397a, "[JE] mCurrentMode: " + this.as + ", mFocusedPart: " + this.c);
                                invalidate();
                                return true;
                            }
                            if (this.c != -1) {
                                this.c = -1;
                                invalidate();
                            }
                        }
                    }
                    if (this.ab != null) {
                        for (int size2 = this.ab.size() - 1; size2 >= 0; size2--) {
                            c cVar = this.ab.get(size2);
                            if (Math.pow((double) (x2 - cVar.d.x), 2.0d) + Math.pow((double) (y2 - cVar.d.y), 2.0d) <= Math.pow((double) this.T, 2.0d) || cVar.f1401b.contains(x2, y2)) {
                                this.as = 3;
                                this.ac = size2;
                                this.c = cVar.f1400a;
                                Log.e(this.f1397a, "[JE] mCurrentMode: " + this.as + ", mFocusedPart: " + this.c);
                                invalidate();
                                return true;
                            }
                            if (this.c != -1) {
                                this.c = -1;
                                invalidate();
                            }
                        }
                    }
                    this.as = 5;
                    break;
                } else {
                    this.as = 1;
                    Log.e(this.f1397a, "[JE] mCurrentMode: " + this.as + ", mFocusedPart: " + this.c);
                    if (this.U != null) {
                        int size3 = this.U.size() - 1;
                        while (true) {
                            if (size3 >= 0) {
                                if (this.U.get(size3).f1400a == this.c) {
                                    this.V = size3;
                                } else {
                                    size3--;
                                }
                            }
                        }
                    }
                    return true;
                }
                break;
            case 1:
            case 3:
                Log.i(this.f1397a, "onTouch - ACTION_UP or ACTION_CANCEL");
                if (this.as == 2 || this.as == 1) {
                    if (!(this.U == null || this.V == -1)) {
                        this.U.remove(this.V);
                        this.U.add(this.U.get(this.V));
                        this.V = -1;
                    }
                } else if (!(this.as != 3 || this.ab == null || this.ac == -1)) {
                    this.ab.remove(this.ac);
                    this.ab.add(this.ab.get(this.ac));
                    this.ac = -1;
                }
                this.as = 0;
                if (this.al) {
                    this.al = false;
                    invalidate();
                }
                this.ad = 0;
                this.ae = 0;
                break;
            case 2:
                if (this.E == null || !this.E.isInProgress()) {
                    int i6 = x2 - this.ad;
                    int i7 = y2 - this.ae;
                    if (this.as == 5 && this.A > this.z) {
                        Log.i(this.f1397a, "onTouch - ACTION_MOVE, mFaceBitmapOffsetX: " + this.t + ", mFaceBitmapOffsetY: " + this.u);
                        int i8 = this.t;
                        int i9 = this.u;
                        if (((float) this.v) * this.A > ((float) this.at)) {
                            this.t += i6;
                            if (this.t > 0) {
                                this.t = 0;
                            } else if (((float) this.t) + (((float) this.v) * this.A) < ((float) this.at)) {
                                this.t = (int) (((float) this.at) - (((float) this.v) * this.A));
                            }
                        }
                        if (((float) this.w) * this.A > ((float) this.au)) {
                            this.u += i7;
                            if (this.u > 0) {
                                this.u = 0;
                            } else if (((float) this.u) + (((float) this.w) * this.A) < ((float) this.au)) {
                                this.u = (int) (((float) this.au) - (((float) this.w) * this.A));
                            }
                        }
                        if (((float) this.v) * this.A > ((float) this.at) || ((float) this.w) * this.A > ((float) this.au)) {
                            if (this.B != null) {
                                this.B.reset();
                                this.B.postScale(this.A, this.A);
                                this.B.postTranslate((float) this.t, (float) this.u);
                            }
                            a(i8, i9, this.A);
                        }
                    } else if (this.c != -1) {
                        if (this.as == 1) {
                            a(i6, i7);
                        } else if (this.as == 2) {
                            if (!(this.U == null || this.V == -1)) {
                                if (this.c != 2) {
                                    this.al = true;
                                }
                                a aVar2 = this.U.get(this.V);
                                int width = aVar2.f1401b.width();
                                int height = aVar2.f1401b.height();
                                int i10 = aVar2.f1401b.left + i6;
                                int i11 = aVar2.f1401b.top + i7;
                                if (i10 < this.t) {
                                    i10 = this.t;
                                } else if (((float) (i10 + width + 0 + this.H)) > ((float) this.t) + (((float) this.v) * this.A)) {
                                    i10 = (int) ((((float) this.t) + (((float) this.v) * this.A)) - ((float) ((this.H + 0) + width)));
                                }
                                if (i11 < this.u) {
                                    i11 = this.u;
                                } else if (((float) (i11 + height + 0 + this.I)) > ((float) this.u) + (((float) this.w) * this.A)) {
                                    i11 = (int) ((((float) this.u) + (((float) this.w) * this.A)) - ((float) ((this.I + 0) + height)));
                                }
                                aVar2.f1401b.left = i10;
                                aVar2.f1401b.top = i11;
                                aVar2.f1401b.right = aVar2.f1401b.left + width;
                                aVar2.f1401b.bottom = aVar2.f1401b.top + height;
                            }
                        } else if (!(this.as != 3 || this.ab == null || this.ac == -1)) {
                            this.al = true;
                            c cVar2 = this.ab.get(this.ac);
                            int i12 = cVar2.d.x + i6;
                            float f2 = (float) i12;
                            if (f2 - this.T < ((float) this.t)) {
                                cVar2.d.x = (int) (((float) this.t) + this.T);
                            } else if (f2 + this.T > ((float) this.t) + (((float) this.v) * this.A)) {
                                cVar2.d.x = (int) ((((float) this.t) + (((float) this.v) * this.A)) - this.T);
                            } else {
                                cVar2.d.x = i12;
                            }
                            int i13 = cVar2.d.y + i7;
                            float f3 = (float) i13;
                            if (f3 - this.T < ((float) this.u)) {
                                cVar2.d.y = (int) (((float) this.u) + this.T);
                            } else if (f3 + this.T > ((float) this.u) + (((float) this.w) * this.A)) {
                                cVar2.d.y = (int) ((((float) this.u) + (((float) this.w) * this.A)) - this.T);
                            } else {
                                cVar2.d.y = i13;
                            }
                            cVar2.f1401b.left = cVar2.d.x - (this.H / 2);
                            cVar2.f1401b.top = cVar2.d.y - (this.I / 2);
                            cVar2.f1401b.right = cVar2.d.x + (this.H / 2);
                            cVar2.f1401b.bottom = cVar2.d.y + (this.I / 2);
                        }
                    }
                    this.ad = x2;
                    this.ae = y2;
                    invalidate();
                    break;
                } else {
                    return false;
                }
                break;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3, float f2) {
        if (this.ab != null) {
            for (int i4 = 0; i4 < this.ab.size(); i4++) {
                c cVar = this.ab.get(i4);
                cVar.d.x = Math.round(((((float) (cVar.d.x - i2)) * this.A) / f2) + ((float) this.t));
                cVar.d.y = Math.round(((((float) (cVar.d.y - i3)) * this.A) / f2) + ((float) this.u));
                cVar.f1401b.set(cVar.d.x - (this.H / 2), cVar.d.y - (this.I / 2), cVar.d.x + (this.H / 2), cVar.d.y + (this.I / 2));
            }
        }
        if (this.U != null) {
            for (int i5 = 0; i5 < this.U.size(); i5++) {
                a aVar = this.U.get(i5);
                aVar.f1401b.set(Math.round(((((float) (aVar.f1401b.left - i2)) * this.A) / f2) + ((float) this.t)), Math.round(((((float) (aVar.f1401b.top - i3)) * this.A) / f2) + ((float) this.u)), Math.round(((((float) (aVar.f1401b.right - i2)) * this.A) / f2) + ((float) this.t)), Math.round(((((float) (aVar.f1401b.bottom - i3)) * this.A) / f2) + ((float) this.u)));
            }
        }
    }

    private void a(int i2, int i3) {
        if (this.U == null || this.V == -1) {
            Log.e(this.f1397a, "ResizeAppearanceRect, mRectsForAppearance is null or mTouchedAppearanceIndex is NONE_VALUE");
            return;
        }
        a aVar = this.U.get(this.V);
        int centerX = aVar.f1401b.centerX();
        int centerY = aVar.f1401b.centerY();
        int width = aVar.f1401b.width();
        int height = aVar.f1401b.height();
        int i4 = width / 2;
        int i5 = (centerX - i4) - i2;
        int i6 = i4 + centerX + i2;
        if (i6 - i5 < 5) {
            i5 = centerX - 2;
            i6 = centerX + 2;
        } else if (((float) (i6 + 0 + this.H)) > ((float) this.t) + (((float) this.v) * this.A)) {
            i6 = (int) ((((float) this.t) + (((float) this.v) * this.A)) - ((float) (this.H + 0)));
            i5 = centerX - (i6 - centerX);
        } else if (i5 < this.t) {
            i5 = this.t;
            i6 = centerX + (centerX - i5);
        }
        int i7 = height / 2;
        int i8 = (centerY - i7) - i3;
        int i9 = i7 + centerY + i3;
        if (i9 - i8 < 5) {
            i8 = centerY - 2;
            i9 = centerY + 2;
        } else if (((float) (i9 + 0 + this.I)) > ((float) this.u) + (((float) this.w) * this.A)) {
            i9 = (int) ((((float) this.u) + (((float) this.w) * this.A)) - ((float) (this.I + 0)));
            i8 = centerY - (i9 - centerY);
        } else if (i8 < this.u) {
            i8 = this.u;
            i9 = centerY + (centerY - i8);
        }
        aVar.f1401b.left = i5;
        aVar.f1401b.top = i8;
        aVar.f1401b.right = i6;
        aVar.f1401b.bottom = i9;
    }

    private class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            Log.d(DetectingFaceView.this.f1397a, "[JE] onDoubleTap");
            int d = DetectingFaceView.this.t;
            int e = DetectingFaceView.this.u;
            float b2 = DetectingFaceView.this.A;
            int unused = DetectingFaceView.this.t = DetectingFaceView.this.x;
            int unused2 = DetectingFaceView.this.u = DetectingFaceView.this.y;
            float unused3 = DetectingFaceView.this.A = DetectingFaceView.this.z;
            if (DetectingFaceView.this.B != null) {
                DetectingFaceView.this.B.reset();
                DetectingFaceView.this.B.postScale(DetectingFaceView.this.A, DetectingFaceView.this.A);
                DetectingFaceView.this.B.postTranslate((float) DetectingFaceView.this.t, (float) DetectingFaceView.this.u);
            }
            DetectingFaceView.this.a(d, e, b2);
            DetectingFaceView.this.invalidate();
            return false;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\d\a.java ==========

package net.fxgear.fittingmodenative.d;

import android.util.Log;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ClothInfo */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f1405a;

    /* renamed from: b  reason: collision with root package name */
    public int f1406b;
    public int c;
    public C0049a[] d;
    private final String e = "info";
    private final String f = "results";
    private final String g = "start";
    private final String h = "count";
    private final String i = "total";

    public a(String str) throws JSONException {
        if (str != null) {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("info")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("info");
                if (!jSONObject2.isNull("start")) {
                    this.f1405a = jSONObject2.getInt("start");
                }
                this.f1406b = jSONObject2.getInt("count");
                this.c = jSONObject2.getInt("total");
                if (!jSONObject.isNull("results")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("results");
                    int length = jSONArray.length();
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < length; i2++) {
                        C0049a aVar = new C0049a(jSONArray.getJSONObject(i2));
                        if (aVar.a()) {
                            arrayList.add(aVar);
                        }
                    }
                    this.d = new C0049a[arrayList.size()];
                    for (int i3 = 0; i3 < this.d.length; i3++) {
                        this.d[i3] = (C0049a) arrayList.get(i3);
                    }
                    return;
                }
                throw new JSONException("ERROR :: No results data.");
            }
            throw new JSONException("ERROR :: No info data.");
        }
        throw new JSONException("ERROR :: json data is null.");
    }

    /* renamed from: net.fxgear.fittingmodenative.d.a$a  reason: collision with other inner class name */
    /* compiled from: ClothInfo */
    public class C0049a {

        /* renamed from: a  reason: collision with root package name */
        public int f1407a;

        /* renamed from: b  reason: collision with root package name */
        public String f1408b;
        public boolean c;
        public String d;
        public String e;
        public C0050a f;
        public C0050a g;
        private final String i = "id";
        private final String j = "item_sex";
        private final String k = "item_kids";
        private final String l = "td_list";
        private final String m = "code";
        private final String n = "make_category_name";
        private final String o = "rep_yn";
        private final String p = "td_fitting_files";
        private final String q = "package";
        private final String r = "thumbnail";
        private boolean s;

        public C0049a(JSONObject jSONObject) throws JSONException {
            this.s = false;
            this.f1407a = jSONObject.getInt("id");
            this.f1408b = jSONObject.getString("item_sex");
            if (jSONObject.has("item_kids")) {
                this.c = jSONObject.getInt("item_kids") == 1;
            } else {
                this.c = false;
            }
            if (!jSONObject.isNull("td_list")) {
                JSONArray jSONArray = jSONObject.getJSONArray("td_list");
                if (jSONArray == null || jSONArray.length() <= 0) {
                    Log.e("ClothItem", "ERROR :: Wrong json data.");
                    return;
                }
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    if (jSONObject2 != null && jSONObject2.getInt("rep_yn") == 1) {
                        this.d = jSONObject2.getString("code");
                        this.e = jSONObject2.getString("make_category_name");
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("td_fitting_files");
                        this.f = new C0050a(jSONObject3.getJSONObject("package"));
                        this.g = new C0050a(jSONObject3.getJSONObject("thumbnail"));
                        this.s = true;
                    }
                }
                if (this.d == null || this.e == null || this.f == null || this.g == null) {
                    Log.e("ClothItem", "ERROR :: Wrong json data.");
                    return;
                }
                return;
            }
            Log.e("ClothItem", "ERROR :: Not found fitting data info.");
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.s;
        }

        /* renamed from: net.fxgear.fittingmodenative.d.a$a$a  reason: collision with other inner class name */
        /* compiled from: ClothInfo */
        public class C0050a {

            /* renamed from: a  reason: collision with root package name */
            public String f1409a;

            /* renamed from: b  reason: collision with root package name */
            public String f1410b;
            private final String d = "hash";
            private final String e = "url";

            public C0050a(JSONObject jSONObject) throws JSONException {
                this.f1409a = jSONObject.getString("hash");
                this.f1410b = jSONObject.getString("url");
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\d\b.java ==========

package net.fxgear.fittingmodenative.d;

import android.util.Log;
import net.fxgear.GlobalDefine;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DataZipInfo */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f1411a;

    /* renamed from: b  reason: collision with root package name */
    public String f1412b;
    public String c;
    public String d;
    public String e;
    public String f;
    private final String g;
    private final int h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;

    public b() {
        this.g = b.class.getSimpleName();
        this.h = 5;
        this.i = "results";
        this.j = GlobalDefine.JSON_KEY_UPDATE_DATE_BASE;
        this.k = GlobalDefine.JSON_KEY_UPDATE_DATE_HAIR;
        this.l = GlobalDefine.JSON_KEY_UPDATE_DATE_HEAD;
        this.m = "version";
        this.n = "url";
        this.f1411a = "";
        this.f1412b = null;
        this.c = "";
        this.d = null;
        this.e = "";
        this.f = null;
    }

    public b(String str) {
        this.g = b.class.getSimpleName();
        this.h = 5;
        this.i = "results";
        this.j = GlobalDefine.JSON_KEY_UPDATE_DATE_BASE;
        this.k = GlobalDefine.JSON_KEY_UPDATE_DATE_HAIR;
        this.l = GlobalDefine.JSON_KEY_UPDATE_DATE_HEAD;
        this.m = "version";
        this.n = "url";
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("results")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("results");
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(GlobalDefine.JSON_KEY_UPDATE_DATE_BASE);
                    this.f1411a = jSONObject3.getString("version");
                    this.f1412b = jSONObject3.getString("url");
                    JSONObject jSONObject4 = jSONObject2.getJSONObject(GlobalDefine.JSON_KEY_UPDATE_DATE_HAIR);
                    this.c = jSONObject4.getString("version");
                    this.d = jSONObject4.getString("url");
                    JSONObject jSONObject5 = jSONObject2.getJSONObject(GlobalDefine.JSON_KEY_UPDATE_DATE_HEAD);
                    this.e = jSONObject5.getString("version");
                    this.f = jSONObject5.getString("url");
                    if (!a(this.f1411a) || !a(this.c) || !a(this.e)) {
                        Log.e(this.g, "ERROR :: INVALID data version!!");
                        this.f1411a = "";
                        this.f1412b = null;
                        this.c = "";
                        this.d = null;
                        this.e = "";
                        this.f = null;
                    }
                }
            } catch (JSONException e2) {
                Log.e(this.g, "ERROR :: INVALID data info!!");
                e2.printStackTrace();
                this.f1411a = "";
                this.f1412b = null;
                this.c = "";
                this.d = null;
                this.e = "";
                this.f = null;
            }
        }
    }

    private boolean a(String str) {
        if (str == null || str.length() != 5) {
            return false;
        }
        try {
            if (Integer.parseInt(str.substring(1, str.length())) > 0) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public String a(int i2) {
        switch (i2) {
            case 0:
                switch (0) {
                    case 1:
                        return "https://dl.dropboxusercontent.com/s/i3th4ubnd8tvatj/DATA_BASE.zip";
                    case 2:
                        return "https://dl.dropboxusercontent.com/s/1n380s9ediq9tv0/DATA_BASE.zip";
                    default:
                        return this.f1412b;
                }
            case 1:
                switch (0) {
                    case 1:
                        return "https://dl.dropboxusercontent.com/s/gdzt2g6i5vnbjcj/DATA_HAIR.zip";
                    case 2:
                        return "https://dl.dropboxusercontent.com/s/pykbb72aixt77dx/DATA_HAIR.zip";
                    default:
                        return this.d;
                }
            case 2:
                switch (0) {
                    case 1:
                        return "https://dl.dropboxusercontent.com/s/jeg6q82xna6lay9/DATA_HEAD.zip";
                    case 2:
                        return "https://dl.dropboxusercontent.com/s/qrrn2aok3jdb8v5/DATA_HEAD.zip";
                    default:
                        return this.f;
                }
            default:
                return null;
        }
    }

    public String b(int i2) {
        switch (i2) {
            case 0:
                return this.f1411a;
            case 1:
                return this.c;
            case 2:
                return this.e;
            default:
                return null;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\d\c.java ==========

package net.fxgear.fittingmodenative.d;

import android.content.Context;
import android.util.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import net.fxgear.GlobalDefine;
import net.fxgear.fittingmodenative.f;
import net.fxgear.util.FXUtil;

/* compiled from: DownloadManager */
public class c {

    /* compiled from: DownloadManager */
    public interface a {
        void a(int i);
    }

    /* JADX WARNING: type inference failed for: r0v25, types: [java.net.URLConnection] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01f5 A[SYNTHETIC, Splitter:B:122:0x01f5] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01fd A[Catch:{ Exception -> 0x01f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0202 A[Catch:{ Exception -> 0x01f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0219 A[SYNTHETIC, Splitter:B:139:0x0219] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0221 A[Catch:{ Exception -> 0x021d }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0226 A[Catch:{ Exception -> 0x021d }] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x023a A[SYNTHETIC, Splitter:B:152:0x023a] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0242 A[Catch:{ Exception -> 0x023e }] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0247 A[Catch:{ Exception -> 0x023e }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01af A[SYNTHETIC, Splitter:B:90:0x01af] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01b7 A[Catch:{ Exception -> 0x01b3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(android.content.Context r22, java.lang.String r23, java.lang.String r24, boolean r25, net.fxgear.fittingmodenative.d.c.a r26) {
        /*
            r0 = r23
            r1 = r24
            r3 = r26
            java.lang.String r4 = "DownloadManager"
            java.lang.String r5 = "DownloadFile()+"
            android.util.Log.i(r4, r5)
            r4 = 2
            r5 = 1
            if (r0 == 0) goto L_0x0259
            if (r1 != 0) goto L_0x0015
            goto L_0x0259
        L_0x0015:
            boolean r7 = net.fxgear.fittingmodenative.f.a((android.content.Context) r22)
            if (r7 == 0) goto L_0x024f
            boolean r7 = net.fxgear.util.FXUtil.IsMainThread()
            if (r7 == 0) goto L_0x002a
            java.lang.String r0 = "DownloadManager"
            java.lang.String r1 = "ERROR :: illegal state"
            android.util.Log.e(r0, r1)
            goto L_0x0278
        L_0x002a:
            java.lang.Thread r7 = java.lang.Thread.currentThread()
            boolean r7 = r7.isInterrupted()
            if (r7 == 0) goto L_0x003e
            java.lang.String r0 = "DownloadManager"
            java.lang.String r1 = "cancel download"
            android.util.Log.e(r0, r1)
            r4 = -2
            goto L_0x0278
        L_0x003e:
            java.io.File r7 = new java.io.File
            r7.<init>(r1)
            java.io.File r1 = r7.getParentFile()
            boolean r1 = r1.exists()
            if (r1 != 0) goto L_0x0055
            java.io.File r1 = r7.getParentFile()
            r1.mkdirs()
            goto L_0x0060
        L_0x0055:
            if (r25 != 0) goto L_0x0060
            boolean r1 = r7.exists()
            if (r1 == 0) goto L_0x0060
            r7.delete()
        L_0x0060:
            java.io.RandomAccessFile r8 = new java.io.RandomAccessFile     // Catch:{ MalformedURLException -> 0x020d, IOException -> 0x01e9, all -> 0x01e2 }
            java.lang.String r9 = "rw"
            r8.<init>(r7, r9)     // Catch:{ MalformedURLException -> 0x020d, IOException -> 0x01e9, all -> 0x01e2 }
            long r9 = r8.length()     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
            r11 = 0
            if (r25 == 0) goto L_0x008c
            int r2 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r2 <= 0) goto L_0x008c
            java.lang.String r2 = "DownloadManager"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
            r13.<init>()     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
            java.lang.String r14 = "exist file size : "
            r13.append(r14)     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
            r13.append(r9)     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
            java.lang.String r13 = r13.toString()     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
            android.util.Log.d(r2, r13)     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
            r8.seek(r9)     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
        L_0x008c:
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
            boolean r2 = r2.isInterrupted()     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
            r13 = 3
            if (r2 == 0) goto L_0x00a4
            java.lang.String r0 = "DownloadManager"
            java.lang.String r2 = "cancel download"
            android.util.Log.e(r0, r2)     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
            r1 = 0
        L_0x009f:
            r6 = -2
        L_0x00a0:
            r16 = 0
            goto L_0x01ad
        L_0x00a4:
            boolean r2 = net.fxgear.fittingmodenative.f.a()     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
            r14 = 0
            if (r2 == 0) goto L_0x00d3
            java.lang.String r2 = "?"
            boolean r2 = r0.contains(r2)     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
            if (r2 == 0) goto L_0x00b6
            java.lang.String r2 = "&"
            goto L_0x00b8
        L_0x00b6:
            java.lang.String r2 = "?"
        L_0x00b8:
            java.lang.String r15 = "%s%sno_cache=%d"
            java.lang.Object[] r1 = new java.lang.Object[r13]     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
            r1[r14] = r0     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
            r1[r5] = r2     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
            long r17 = java.lang.System.currentTimeMillis()     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
            r19 = 60000(0xea60, double:2.9644E-319)
            long r17 = r17 / r19
            java.lang.Long r0 = java.lang.Long.valueOf(r17)     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
            r1[r4] = r0     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
            java.lang.String r0 = java.lang.String.format(r15, r1)     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
        L_0x00d3:
            java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
            r1.<init>(r0)     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
            java.net.URLConnection r0 = r1.openConnection()     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
            r1 = r0
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ MalformedURLException -> 0x01df, IOException -> 0x01dc, all -> 0x01d8 }
            r0 = 10000(0x2710, float:1.4013E-41)
            r1.setConnectTimeout(r0)     // Catch:{ MalformedURLException -> 0x01d3, IOException -> 0x01ce, all -> 0x01c4 }
            r1.setReadTimeout(r0)     // Catch:{ MalformedURLException -> 0x01d3, IOException -> 0x01ce, all -> 0x01c4 }
            r1.connect()     // Catch:{ MalformedURLException -> 0x01d3, IOException -> 0x01ce, all -> 0x01c4 }
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r1.getHeaderField(r0)     // Catch:{ MalformedURLException -> 0x01d3, IOException -> 0x01ce, all -> 0x01c4 }
            if (r0 == 0) goto L_0x00f7
            long r4 = java.lang.Long.parseLong(r0)     // Catch:{ MalformedURLException -> 0x01d3, IOException -> 0x01ce, all -> 0x01c4 }
            goto L_0x00f9
        L_0x00f7:
            r4 = -1
        L_0x00f9:
            int r0 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r0 <= 0) goto L_0x0194
            long r14 = r4 + r9
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ MalformedURLException -> 0x01d3, IOException -> 0x01ce, all -> 0x01c4 }
            boolean r0 = r0.isInterrupted()     // Catch:{ MalformedURLException -> 0x01d3, IOException -> 0x01ce, all -> 0x01c4 }
            if (r0 == 0) goto L_0x0111
            java.lang.String r0 = "DownloadManager"
            java.lang.String r2 = "cancel download"
            android.util.Log.e(r0, r2)     // Catch:{ MalformedURLException -> 0x01d3, IOException -> 0x01ce, all -> 0x01c4 }
            goto L_0x009f
        L_0x0111:
            long r17 = net.fxgear.util.FXUtil.GetAvailableSpaceSize(r7)     // Catch:{ MalformedURLException -> 0x01d3, IOException -> 0x01ce, all -> 0x01c4 }
            int r0 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r0 <= 0) goto L_0x0124
            java.lang.String r0 = "DownloadManager"
            java.lang.String r2 = "ERROR :: insufficient space"
            android.util.Log.e(r0, r2)     // Catch:{ MalformedURLException -> 0x01d3, IOException -> 0x01ce, all -> 0x01c4 }
            r0 = 4
            r6 = 4
            goto L_0x00a0
        L_0x0124:
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 <= 0) goto L_0x012d
            int r0 = a((long) r9, (long) r14)     // Catch:{ MalformedURLException -> 0x01d3, IOException -> 0x01ce, all -> 0x01c4 }
            goto L_0x012e
        L_0x012d:
            r0 = 0
        L_0x012e:
            if (r3 == 0) goto L_0x0133
            r3.a(r0)     // Catch:{ MalformedURLException -> 0x01d3, IOException -> 0x01ce, all -> 0x01c4 }
        L_0x0133:
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ MalformedURLException -> 0x01d3, IOException -> 0x01ce, all -> 0x01c4 }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ MalformedURLException -> 0x01d3, IOException -> 0x01ce, all -> 0x01c4 }
            java.io.InputStream r5 = r1.getInputStream()     // Catch:{ MalformedURLException -> 0x01d3, IOException -> 0x01ce, all -> 0x01c4 }
            r4.<init>(r5)     // Catch:{ MalformedURLException -> 0x01d3, IOException -> 0x01ce, all -> 0x01c4 }
            r5 = -1
            r7 = 0
        L_0x0142:
            int r13 = r4.read(r2)     // Catch:{ MalformedURLException -> 0x018e, IOException -> 0x0188, all -> 0x0184 }
            if (r13 == r5) goto L_0x0180
            java.lang.Thread r16 = java.lang.Thread.currentThread()     // Catch:{ MalformedURLException -> 0x018e, IOException -> 0x0188, all -> 0x0184 }
            boolean r16 = r16.isInterrupted()     // Catch:{ MalformedURLException -> 0x018e, IOException -> 0x0188, all -> 0x0184 }
            if (r16 == 0) goto L_0x015d
            java.lang.String r0 = "DownloadManager"
            java.lang.String r2 = "cancel download"
            android.util.Log.e(r0, r2)     // Catch:{ MalformedURLException -> 0x018e, IOException -> 0x0188, all -> 0x0184 }
            r16 = r4
            r6 = -2
            goto L_0x01ad
        L_0x015d:
            if (r13 <= 0) goto L_0x0165
            r5 = 0
            r8.write(r2, r5, r13)     // Catch:{ MalformedURLException -> 0x018e, IOException -> 0x0188, all -> 0x0184 }
            long r5 = (long) r13     // Catch:{ MalformedURLException -> 0x018e, IOException -> 0x0188, all -> 0x0184 }
            long r11 = r11 + r5
        L_0x0165:
            r5 = 0
            long r5 = r11 + r9
            int r13 = a((long) r5, (long) r14)     // Catch:{ MalformedURLException -> 0x018e, IOException -> 0x0188, all -> 0x0184 }
            if (r0 == r13) goto L_0x0177
            int r0 = a((long) r5, (long) r14)     // Catch:{ MalformedURLException -> 0x018e, IOException -> 0x0188, all -> 0x0184 }
            if (r3 == 0) goto L_0x0177
            r3.a(r0)     // Catch:{ MalformedURLException -> 0x018e, IOException -> 0x0188, all -> 0x0184 }
        L_0x0177:
            int r13 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r13 != 0) goto L_0x017e
            r5 = -1
            r7 = -1
            goto L_0x0142
        L_0x017e:
            r5 = -1
            goto L_0x0142
        L_0x0180:
            r16 = r4
            r6 = r7
            goto L_0x01ad
        L_0x0184:
            r0 = move-exception
            r16 = r4
            goto L_0x01c7
        L_0x0188:
            r0 = move-exception
            r16 = r1
            r1 = r4
            goto L_0x01ee
        L_0x018e:
            r0 = move-exception
            r16 = r1
            r1 = r4
            goto L_0x0212
        L_0x0194:
            java.lang.String r0 = "DownloadManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x01d3, IOException -> 0x01ce, all -> 0x01c4 }
            r2.<init>()     // Catch:{ MalformedURLException -> 0x01d3, IOException -> 0x01ce, all -> 0x01c4 }
            java.lang.String r3 = "[ERROR] :: invalid download file length : "
            r2.append(r3)     // Catch:{ MalformedURLException -> 0x01d3, IOException -> 0x01ce, all -> 0x01c4 }
            r2.append(r4)     // Catch:{ MalformedURLException -> 0x01d3, IOException -> 0x01ce, all -> 0x01c4 }
            java.lang.String r2 = r2.toString()     // Catch:{ MalformedURLException -> 0x01d3, IOException -> 0x01ce, all -> 0x01c4 }
            android.util.Log.e(r0, r2)     // Catch:{ MalformedURLException -> 0x01d3, IOException -> 0x01ce, all -> 0x01c4 }
            r6 = 3
            goto L_0x00a0
        L_0x01ad:
            if (r16 == 0) goto L_0x01b5
            r16.close()     // Catch:{ Exception -> 0x01b3 }
            goto L_0x01b5
        L_0x01b3:
            r0 = move-exception
            goto L_0x01be
        L_0x01b5:
            if (r1 == 0) goto L_0x01ba
            r1.disconnect()     // Catch:{ Exception -> 0x01b3 }
        L_0x01ba:
            r8.close()     // Catch:{ Exception -> 0x01b3 }
            goto L_0x01c1
        L_0x01be:
            r0.printStackTrace()
        L_0x01c1:
            r4 = r6
            goto L_0x0278
        L_0x01c4:
            r0 = move-exception
            r16 = 0
        L_0x01c7:
            r21 = r1
            r1 = r0
            r0 = r21
            goto L_0x0238
        L_0x01ce:
            r0 = move-exception
            r16 = r1
            r1 = 0
            goto L_0x01ee
        L_0x01d3:
            r0 = move-exception
            r16 = r1
            r1 = 0
            goto L_0x0212
        L_0x01d8:
            r0 = move-exception
            r1 = r0
            r0 = 0
            goto L_0x01e6
        L_0x01dc:
            r0 = move-exception
            r1 = 0
            goto L_0x01ec
        L_0x01df:
            r0 = move-exception
            r1 = 0
            goto L_0x0210
        L_0x01e2:
            r0 = move-exception
            r1 = r0
            r0 = 0
            r8 = 0
        L_0x01e6:
            r16 = 0
            goto L_0x0238
        L_0x01e9:
            r0 = move-exception
            r1 = 0
            r8 = 0
        L_0x01ec:
            r16 = 0
        L_0x01ee:
            r2 = 14
            r0.printStackTrace()     // Catch:{ all -> 0x0230 }
            if (r1 == 0) goto L_0x01fb
            r1.close()     // Catch:{ Exception -> 0x01f9 }
            goto L_0x01fb
        L_0x01f9:
            r0 = move-exception
            goto L_0x0206
        L_0x01fb:
            if (r16 == 0) goto L_0x0200
            r16.disconnect()     // Catch:{ Exception -> 0x01f9 }
        L_0x0200:
            if (r8 == 0) goto L_0x0209
            r8.close()     // Catch:{ Exception -> 0x01f9 }
            goto L_0x0209
        L_0x0206:
            r0.printStackTrace()
        L_0x0209:
            r4 = 14
            goto L_0x0278
        L_0x020d:
            r0 = move-exception
            r1 = 0
            r8 = 0
        L_0x0210:
            r16 = 0
        L_0x0212:
            r2 = 13
            r0.printStackTrace()     // Catch:{ all -> 0x0230 }
            if (r1 == 0) goto L_0x021f
            r1.close()     // Catch:{ Exception -> 0x021d }
            goto L_0x021f
        L_0x021d:
            r0 = move-exception
            goto L_0x022a
        L_0x021f:
            if (r16 == 0) goto L_0x0224
            r16.disconnect()     // Catch:{ Exception -> 0x021d }
        L_0x0224:
            if (r8 == 0) goto L_0x022d
            r8.close()     // Catch:{ Exception -> 0x021d }
            goto L_0x022d
        L_0x022a:
            r0.printStackTrace()
        L_0x022d:
            r4 = 13
            goto L_0x0278
        L_0x0230:
            r0 = move-exception
            r21 = r1
            r1 = r0
            r0 = r16
            r16 = r21
        L_0x0238:
            if (r16 == 0) goto L_0x0240
            r16.close()     // Catch:{ Exception -> 0x023e }
            goto L_0x0240
        L_0x023e:
            r0 = move-exception
            goto L_0x024b
        L_0x0240:
            if (r0 == 0) goto L_0x0245
            r0.disconnect()     // Catch:{ Exception -> 0x023e }
        L_0x0245:
            if (r8 == 0) goto L_0x024e
            r8.close()     // Catch:{ Exception -> 0x023e }
            goto L_0x024e
        L_0x024b:
            r0.printStackTrace()
        L_0x024e:
            throw r1
        L_0x024f:
            java.lang.String r0 = "DownloadManager"
            java.lang.String r1 = "ERROR :: network disconnected"
            android.util.Log.e(r0, r1)
            r4 = 10
            goto L_0x0278
        L_0x0259:
            java.lang.String r2 = "DownloadManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "ERROR :: param error, url : "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = ", filePath : "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            android.util.Log.e(r2, r0)
            r4 = 1
        L_0x0278:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.d.c.a(android.content.Context, java.lang.String, java.lang.String, boolean, net.fxgear.fittingmodenative.d.c$a):int");
    }

    public static long a(Context context, String str) {
        long j = 0;
        if (context == null || str == null) {
            Log.e("DownloadManager", "ERROR :: param is null");
        } else if (!f.a(context)) {
            Log.e("DownloadManager", "ERROR :: disconnected network.");
        } else if (!FXUtil.IsMainThread()) {
            try {
                if (f.a()) {
                    str = String.format("%s%sno_cache=%d", new Object[]{str, str.contains("?") ? "&" : "?", Long.valueOf(System.currentTimeMillis() / 60000)});
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setRequestProperty("Range", String.format("bytes=%s-%s", new Object[]{GlobalDefine.REAL_VIDEO_NONE_DATE, "1"}));
                String headerField = httpURLConnection.getHeaderField("Content-Range");
                if (headerField != null) {
                    j = Long.parseLong(headerField.substring(headerField.lastIndexOf("/") + 1));
                }
                httpURLConnection.disconnect();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } else {
            Log.e("DownloadManager", "ERROR :: illegal state");
        }
        return j;
    }

    private static int a(long j, long j2) {
        return (int) ((j * 100) / j2);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\d\d.java ==========

package net.fxgear.fittingmodenative.d;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import net.fxgear.GlobalDefine;
import net.fxgear.fittingmodenative.d.c;
import net.fxgear.fittingmodenative.e;
import net.fxgear.util.FXUtil;

/* compiled from: DownloadRealDataTask */
public class d extends AsyncTask<Void, Integer, Integer> implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f1413a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private Context f1414b;
    private int c;
    private GlobalDefine.Result d = new GlobalDefine.Result();
    private e e;
    private b f;
    private ArrayList<a> g;
    private long h;
    private int i;

    /* compiled from: DownloadRealDataTask */
    public interface b {
        void a(int i);

        void a(int i, int i2, int i3);

        void a(GlobalDefine.Result result);
    }

    /* compiled from: DownloadRealDataTask */
    public class c extends GlobalDefine.Request {

        /* renamed from: a  reason: collision with root package name */
        public final int f1417a;

        c(int i) {
            this.f1417a = i;
        }
    }

    /* compiled from: DownloadRealDataTask */
    private class a {

        /* renamed from: a  reason: collision with root package name */
        String f1415a;

        /* renamed from: b  reason: collision with root package name */
        String f1416b;
        long c;

        public a(String str, String str2, long j) {
            this.f1415a = str;
            this.f1416b = str2;
            this.c = j;
        }
    }

    public d(Context context, int i2, b bVar) {
        this.f1414b = context;
        this.c = i2;
        this.e = e.a(this.f1414b);
        this.f = bVar;
    }

    public void a() {
        Log.d(this.f1413a, "StopTask()+");
        if (getStatus() != AsyncTask.Status.FINISHED) {
            cancel(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        if (this.f != null) {
            Log.i(this.f1413a, "OnStartDownload()");
            this.f.a(this.c);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Integer doInBackground(Void... voidArr) {
        File file;
        String str;
        long j;
        this.d.request = new c(this.c);
        this.d.resultCode = 0;
        if (this.e != null) {
            e.c g2 = this.e.g(this.c);
            if (g2 != null) {
                this.g = new ArrayList<>();
                String absolutePath = GlobalDefine.GetRealDirectory(this.f1414b, g2.f1466b, g2.c).getAbsolutePath();
                String[] split = g2.h.split("/");
                int i2 = 1;
                while (true) {
                    file = null;
                    if (i2 >= split.length) {
                        str = null;
                        break;
                    } else if (split[i2].contains(GlobalDefine.EXTENSION_BIN)) {
                        str = split[i2 - 1];
                        break;
                    } else {
                        i2++;
                    }
                }
                File file2 = g2.k.mAnimationFilePath != null ? new File(g2.k.mAnimationFilePath) : null;
                if (g2.k.mVideoFilePath != null) {
                    file = new File(g2.k.mAnimationFilePath);
                }
                File file3 = file;
                if (file2 == null || !file2.exists()) {
                    long a2 = c.a(this.f1414b, g2.h);
                    j = a2 + 0;
                    a aVar = r0;
                    a aVar2 = new a(g2.h, absolutePath + File.separator + String.format(GlobalDefine.FILE_NAME_FORMAT_ANIMATION, new Object[]{str}), a2);
                    this.g.add(aVar);
                } else {
                    j = 0;
                }
                if (file3 == null || !file3.exists()) {
                    long a3 = c.a(this.f1414b, g2.i);
                    j += a3;
                    this.g.add(new a(g2.i, absolutePath + File.separator + String.format(GlobalDefine.FILE_NAME_FORMAT_VIDEO, new Object[]{str}), a3));
                }
                long j2 = j;
                long GetAvailableSpaceSize = FXUtil.GetAvailableSpaceSize(new File(absolutePath));
                if (j2 >= GetAvailableSpaceSize) {
                    this.d.resultCode = 4;
                    this.d.resultExtra = Long.valueOf(j2 - GetAvailableSpaceSize);
                } else if (!this.g.isEmpty()) {
                    this.h = j2;
                    this.i = 0;
                    Iterator<a> it = this.g.iterator();
                    while (it.hasNext()) {
                        a next = it.next();
                        int a4 = c.a(this.f1414b, next.f1415a, next.f1416b, false, this);
                        if (a4 != -1) {
                            if (a4 == 4) {
                                this.d.resultExtra = Long.valueOf(next.c);
                            }
                            b();
                            this.d.resultCode = a4;
                            return Integer.valueOf(this.d.resultCode);
                        }
                        this.i++;
                    }
                    this.d.resultCode = -1;
                } else {
                    this.d.resultCode = 2;
                }
            } else {
                this.d.resultCode = 2;
            }
        }
        if (this.d.resultCode == -1) {
            this.e.a(this.c, String.valueOf(System.currentTimeMillis()));
            if (this.d.resultCode != -2) {
                FXUtil.PrintFileListFromDirectory(GlobalDefine.GetRealDirectory(this.f1414b), "[J] ");
            }
        } else {
            b();
        }
        return Integer.valueOf(this.d.resultCode);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        if (this.f != null) {
            String str = this.f1413a;
            Log.i(str, "OnRepeatDownload() = " + numArr[0].intValue());
            this.f.a(this.c, 100, numArr[0].intValue());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onCancelled(Integer num) {
        this.d.resultCode = -2;
        if (this.f != null) {
            this.f.a(this.d);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(Integer num) {
        if (this.f != null) {
            Log.i(this.f1413a, "OnFinishDownload()");
            this.f.a(this.d);
        }
    }

    public void a(int i2) {
        if (i2 > 0) {
            long j = 0;
            for (int i3 = 0; i3 < this.i; i3++) {
                j += this.g.get(i3).c;
            }
            int i4 = (int) (((j + ((this.g.get(this.i).c * ((long) i2)) / 100)) * 100) / this.h);
            if (i4 < 100) {
                publishProgress(new Integer[]{Integer.valueOf(i4)});
                return;
            }
            publishProgress(new Integer[]{100});
        }
    }

    private void b() {
        Log.d(this.f1413a, "DeleteDownloadFiles()+");
        if (this.g != null) {
            Iterator<a> it = this.g.iterator();
            while (it.hasNext()) {
                File file = new File(it.next().f1416b);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\d\e.java ==========

package net.fxgear.fittingmodenative.d;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.fxgear.GlobalDefine;
import net.fxgear.fittingmodenative.d.c;
import net.fxgear.fittingmodenative.e;
import net.fxgear.util.FXUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FittingModeNetworkManager */
public class e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f1419a = "e";

    /* compiled from: FittingModeNetworkManager */
    public interface d {
        void a();

        void a(GlobalDefine.Result result);
    }

    /* renamed from: net.fxgear.fittingmodenative.d.e$e  reason: collision with other inner class name */
    /* compiled from: FittingModeNetworkManager */
    public interface C0053e {
        void a(int i);

        void a(int i, int i2, int i3);

        void a(GlobalDefine.Result result);
    }

    /* compiled from: FittingModeNetworkManager */
    public static class b extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        private String f1422a;

        /* renamed from: b  reason: collision with root package name */
        private String f1423b;
        private d c;
        private i d;
        private C0052b e;

        /* compiled from: FittingModeNetworkManager */
        public static class a extends GlobalDefine.Request {

            /* renamed from: a  reason: collision with root package name */
            public int[] f1424a;
        }

        /* renamed from: net.fxgear.fittingmodenative.d.e$b$b  reason: collision with other inner class name */
        /* compiled from: FittingModeNetworkManager */
        public static class C0052b extends GlobalDefine.Result {

            /* renamed from: a  reason: collision with root package name */
            public a f1425a;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (this.c != null) {
                this.c.a();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            String str;
            this.e.resultCode = 0;
            a aVar = (a) this.e.request;
            if (aVar == null || aVar.f1424a == null) {
                this.e.resultCode = 1;
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (int i : aVar.f1424a) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(i);
            }
            try {
                if (this.f1423b != null) {
                    str = String.format("%s/item/list?account_uuid=%s&show=td_list,td_fitting&item_kids=all&td_status=activated&item_ids=%s", new Object[]{this.f1422a, this.f1423b, sb.toString()});
                } else {
                    str = String.format("%s/item/list?show=td_list,td_fitting&item_kids=all&td_status=activated&item_ids=%s", new Object[]{this.f1422a, sb.toString()});
                }
                this.d = new i();
                String a2 = this.d.a(str, "GET", (HashMap<String, String>) null);
                if (a2 != null) {
                    this.e.f1425a = new a(a2);
                    this.e.resultCode = -1;
                } else {
                    this.e.resultCode = 11;
                }
            } catch (IllegalArgumentException e2) {
                this.e.resultCode = 10;
                e2.printStackTrace();
            } catch (IOException e3) {
                this.e.resultCode = 10;
                e3.printStackTrace();
            } catch (JSONException e4) {
                this.e.resultCode = 11;
                e4.printStackTrace();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            if (this.e.resultCode != -1) {
                this.e.f1425a = null;
            }
            if (this.c != null) {
                this.c.a(this.e);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onCancelled(Void voidR) {
            Log.d(e.f1419a, "onCancelled()+");
            this.e.resultCode = -2;
            this.e.f1425a = null;
            if (this.c != null) {
                this.c.a(this.e);
            }
        }

        public static C0052b a(int[] iArr, String str, String str2) {
            String str3;
            a aVar = new a();
            aVar.f1424a = iArr;
            C0052b bVar = new C0052b();
            bVar.resultCode = 0;
            bVar.request = aVar;
            if (aVar.f1424a == null) {
                bVar.resultCode = 1;
                return bVar;
            }
            StringBuilder sb = new StringBuilder();
            for (int i : aVar.f1424a) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(i);
            }
            if (str2 != null) {
                try {
                    str3 = String.format("%s/item/list?account_uuid=%s&show=td_list,td_fitting&item_kids=all&td_status=activated&item_ids=%s", new Object[]{str, str2, sb.toString()});
                } catch (IllegalArgumentException e2) {
                    bVar.resultCode = 10;
                    e2.printStackTrace();
                } catch (IOException e3) {
                    bVar.resultCode = 10;
                    e3.printStackTrace();
                } catch (JSONException e4) {
                    bVar.resultCode = 11;
                    e4.printStackTrace();
                }
            } else {
                str3 = String.format("%s/item/list?show=td_list,td_fitting&item_kids=all&td_status=activated&item_ids=%s", new Object[]{str, sb.toString()});
            }
            String a2 = new i().a(str3, "GET", (HashMap<String, String>) null);
            if (a2 != null) {
                a aVar2 = new a(a2);
                if (iArr.length == aVar2.c) {
                    bVar.f1425a = aVar2;
                    bVar.resultCode = -1;
                } else {
                    bVar.resultCode = 11;
                }
            } else {
                bVar.resultCode = 11;
            }
            return bVar;
        }
    }

    public static a a(Context context, int[] iArr, a.C0051a aVar) {
        a aVar2 = new a(context, iArr, aVar);
        aVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return aVar2;
    }

    /* compiled from: FittingModeNetworkManager */
    public static class a extends AsyncTask<Void, Void, ArrayList<e.a>> {

        /* renamed from: a  reason: collision with root package name */
        private final String f1420a = a.class.getSimpleName();

        /* renamed from: b  reason: collision with root package name */
        private Context f1421b;
        private int[] c;
        private C0051a d;

        /* renamed from: net.fxgear.fittingmodenative.d.e$a$a  reason: collision with other inner class name */
        /* compiled from: FittingModeNetworkManager */
        public interface C0051a {
            void a();

            void a(ArrayList<e.a> arrayList);
        }

        public a(Context context, int[] iArr, C0051a aVar) {
            this.f1421b = context;
            this.c = iArr;
            this.d = aVar;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (this.d != null) {
                this.d.a();
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x0185  */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x01cd  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.ArrayList<net.fxgear.fittingmodenative.e.a> doInBackground(java.lang.Void... r18) {
            /*
                r17 = this;
                r0 = r17
                int[] r1 = r0.c
                r2 = 0
                if (r1 == 0) goto L_0x01e5
                int[] r1 = r0.c
                int r1 = r1.length
                if (r1 <= 0) goto L_0x01e5
                boolean r1 = r17.isCancelled()
                if (r1 != 0) goto L_0x01dd
                android.content.Context r1 = r0.f1421b
                if (r1 != 0) goto L_0x0018
                goto L_0x01dd
            L_0x0018:
                android.content.Context r1 = r0.f1421b
                net.fxgear.fittingmodenative.e r1 = net.fxgear.fittingmodenative.e.a((android.content.Context) r1)
                if (r1 == 0) goto L_0x01d5
                net.fxgear.fittingmodenative.f$a r3 = net.fxgear.fittingmodenative.f.f1467a
                r3.getClass()
                android.content.Context r3 = r0.f1421b
                boolean r3 = net.fxgear.fittingmodenative.f.a((android.content.Context) r3)
                r12 = -1
                if (r3 == 0) goto L_0x0172
                int[] r3 = r0.c
                java.lang.String r4 = net.fxgear.GlobalDefine.GetApiURL()
                java.lang.String r5 = net.fxgear.GlobalDefine.GetAccountUUID()
                net.fxgear.fittingmodenative.d.e$b$b r3 = net.fxgear.fittingmodenative.d.e.b.a(r3, r4, r5)
                int r4 = r3.resultCode
                if (r4 != r12) goto L_0x0159
                net.fxgear.fittingmodenative.d.a r3 = r3.f1425a
                net.fxgear.fittingmodenative.d.a$a[] r14 = r3.d
                if (r14 == 0) goto L_0x0151
                int r15 = r14.length
                r11 = 0
            L_0x0048:
                r3 = 1
                if (r11 >= r15) goto L_0x0122
                r4 = r14[r11]
                boolean r5 = r17.isCancelled()
                if (r5 != 0) goto L_0x011a
                android.content.Context r5 = r0.f1421b
                if (r5 != 0) goto L_0x0059
                goto L_0x011a
            L_0x0059:
                java.lang.String r5 = r4.f1408b
                java.lang.String r6 = "man"
                boolean r5 = r5.equals(r6)
                r6 = 2
                if (r5 == 0) goto L_0x0066
                r5 = 2
                goto L_0x0073
            L_0x0066:
                java.lang.String r5 = r4.f1408b
                java.lang.String r7 = "unisex"
                boolean r5 = r5.equals(r7)
                if (r5 == 0) goto L_0x0072
                r5 = 3
                goto L_0x0073
            L_0x0072:
                r5 = 1
            L_0x0073:
                boolean r7 = r4.c
                if (r7 == 0) goto L_0x0078
                r6 = 1
            L_0x0078:
                java.lang.String r7 = r4.e
                int r7 = net.fxgear.util.FXUtil.GetClothType(r7)
                java.lang.String r8 = r4.e
                if (r8 == 0) goto L_0x00af
                java.io.File r8 = new java.io.File
                android.content.Context r9 = r0.f1421b
                java.io.File r9 = net.fxgear.GlobalDefine.GetClothTypeBaseDirectory(r9, r5, r6, r7)
                java.lang.String r10 = r4.e
                r8.<init>(r9, r10)
                java.lang.String r8 = r8.getAbsolutePath()
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r10 = "Data"
                r9.append(r10)
                java.lang.String r10 = java.io.File.separator
                r9.append(r10)
                java.lang.String r9 = r9.toString()
                java.lang.String[] r8 = r8.split(r9)
                int r9 = r8.length
                int r9 = r9 - r3
                r8 = r8[r9]
                goto L_0x00b0
            L_0x00af:
                r8 = r2
            L_0x00b0:
                java.lang.String r9 = r4.d
                if (r9 == 0) goto L_0x00e2
                java.io.File r9 = new java.io.File
                android.content.Context r10 = r0.f1421b
                java.io.File r10 = net.fxgear.GlobalDefine.GetClothTypeDirectory(r10, r5, r6, r7)
                java.lang.String r13 = r4.d
                r9.<init>(r10, r13)
                java.lang.String r9 = r9.getAbsolutePath()
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                java.lang.String r13 = "Data"
                r10.append(r13)
                java.lang.String r13 = java.io.File.separator
                r10.append(r13)
                java.lang.String r10 = r10.toString()
                java.lang.String[] r9 = r9.split(r10)
                int r10 = r9.length
                int r10 = r10 - r3
                r3 = r9[r10]
                r9 = r3
                goto L_0x00e3
            L_0x00e2:
                r9 = r2
            L_0x00e3:
                int r3 = r4.f1407a
                boolean r3 = r1.c((int) r3)
                if (r3 == 0) goto L_0x0101
                int r10 = r4.f1407a
                net.fxgear.fittingmodenative.d.a$a$a r3 = r4.g
                java.lang.String r13 = r3.f1410b
                net.fxgear.fittingmodenative.d.a$a$a r3 = r4.f
                java.lang.String r4 = r3.f1410b
                r3 = r1
                r16 = r4
                r4 = r10
                r10 = r13
                r13 = r11
                r11 = r16
                r3.b(r4, r5, r6, r7, r8, r9, r10, r11)
                goto L_0x0116
            L_0x0101:
                r13 = r11
                int r10 = r4.f1407a
                net.fxgear.fittingmodenative.d.a$a$a r3 = r4.g
                java.lang.String r11 = r3.f1410b
                net.fxgear.fittingmodenative.d.a$a$a r3 = r4.f
                java.lang.String r4 = r3.f1410b
                r3 = r1
                r16 = r4
                r4 = r10
                r10 = r11
                r11 = r16
                r3.a((int) r4, (int) r5, (int) r6, (int) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11)
            L_0x0116:
                int r11 = r13 + 1
                goto L_0x0048
            L_0x011a:
                java.lang.String r1 = r0.f1420a
                java.lang.String r3 = "WARNING :: task cancel"
                android.util.Log.e(r1, r3)
                return r2
            L_0x0122:
                int r4 = r14.length
                int[] r5 = r0.c
                int r5 = r5.length
                if (r5 == r4) goto L_0x0179
                if (r5 <= r4) goto L_0x0179
                int r5 = r5 - r4
                int[] r4 = new int[r5]
                r5 = 0
                r6 = 0
            L_0x012f:
                int[] r7 = r0.c
                int r7 = r7.length
                if (r5 >= r7) goto L_0x017a
                int[] r7 = r0.c
                r7 = r7[r5]
                r8 = 0
            L_0x0139:
                int r9 = r14.length
                if (r8 >= r9) goto L_0x0147
                r9 = r14[r8]
                int r9 = r9.f1407a
                if (r7 != r9) goto L_0x0144
                r8 = 0
                goto L_0x0148
            L_0x0144:
                int r8 = r8 + 1
                goto L_0x0139
            L_0x0147:
                r8 = 1
            L_0x0148:
                if (r8 == 0) goto L_0x014e
                r4[r6] = r7
                int r6 = r6 + 1
            L_0x014e:
                int r5 = r5 + 1
                goto L_0x012f
            L_0x0151:
                java.lang.String r3 = r0.f1420a
                java.lang.String r4 = "WARNING :: clothItem is null"
                android.util.Log.d(r3, r4)
                goto L_0x0179
            L_0x0159:
                java.lang.String r4 = r0.f1420a
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "ERROR :: error code - "
                r5.append(r6)
                int r3 = r3.resultCode
                r5.append(r3)
                java.lang.String r3 = r5.toString()
                android.util.Log.e(r4, r3)
                goto L_0x0179
            L_0x0172:
                java.lang.String r3 = r0.f1420a
                java.lang.String r4 = "[WARNIG] :: Network disconect."
                android.util.Log.w(r3, r4)
            L_0x0179:
                r4 = r2
            L_0x017a:
                boolean r3 = r17.isCancelled()
                if (r3 != 0) goto L_0x01cd
                android.content.Context r3 = r0.f1421b
                if (r3 != 0) goto L_0x0185
                goto L_0x01cd
            L_0x0185:
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                int[] r3 = r0.c
                int r5 = r3.length
                r6 = 0
            L_0x018e:
                if (r6 >= r5) goto L_0x01a7
                r7 = r3[r6]
                net.fxgear.fittingmodenative.e$a r8 = r1.b((int) r7)
                if (r8 != 0) goto L_0x01a1
                net.fxgear.fittingmodenative.e$a r8 = new net.fxgear.fittingmodenative.e$a
                r8.<init>()
                r8.f1461a = r7
                r8.e = r12
            L_0x01a1:
                r2.add(r8)
                int r6 = r6 + 1
                goto L_0x018e
            L_0x01a7:
                if (r4 == 0) goto L_0x01ec
                int r1 = r4.length
                if (r1 <= 0) goto L_0x01ec
                int r1 = r4.length
                r3 = 0
            L_0x01ae:
                if (r3 >= r1) goto L_0x01ec
                r5 = r4[r3]
                r6 = 0
            L_0x01b3:
                int r7 = r2.size()
                if (r6 >= r7) goto L_0x01ca
                java.lang.Object r7 = r2.get(r6)
                net.fxgear.fittingmodenative.e$a r7 = (net.fxgear.fittingmodenative.e.a) r7
                int r8 = r7.f1461a
                if (r5 != r8) goto L_0x01c7
                r2.remove(r7)
                goto L_0x01b3
            L_0x01c7:
                int r6 = r6 + 1
                goto L_0x01b3
            L_0x01ca:
                int r3 = r3 + 1
                goto L_0x01ae
            L_0x01cd:
                java.lang.String r1 = r0.f1420a
                java.lang.String r3 = "WARNING :: task cancel"
                android.util.Log.e(r1, r3)
                return r2
            L_0x01d5:
                java.lang.String r1 = r0.f1420a
                java.lang.String r3 = "[ERROR] :: FittingModeDataManager is null"
                android.util.Log.e(r1, r3)
                goto L_0x01ec
            L_0x01dd:
                java.lang.String r1 = r0.f1420a
                java.lang.String r3 = "WARNING :: task cancel"
                android.util.Log.e(r1, r3)
                return r2
            L_0x01e5:
                java.lang.String r1 = r0.f1420a
                java.lang.String r3 = "WARNING :: wrong param."
                android.util.Log.e(r1, r3)
            L_0x01ec:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.d.e.a.doInBackground(java.lang.Void[]):java.util.ArrayList");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(ArrayList<e.a> arrayList) {
            if (this.d != null) {
                this.d.a(arrayList);
            }
        }

        public void a() {
            Log.d(this.f1420a, "StopTask()+");
            if (getStatus() != AsyncTask.Status.FINISHED) {
                cancel(true);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onCancelled(ArrayList<e.a> arrayList) {
            Log.d(this.f1420a, "onCancelled()+");
            if (this.d != null) {
                this.d.a((ArrayList<e.a>) null);
            }
        }
    }

    public static c a(Context context, int i, C0053e eVar) {
        c cVar = new c(context, i, eVar);
        cVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return cVar;
    }

    /* compiled from: FittingModeNetworkManager */
    public static class c extends AsyncTask<Void, Integer, Integer> implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private final String f1426a = c.class.getSimpleName();

        /* renamed from: b  reason: collision with root package name */
        private Context f1427b;
        private int c;
        private GlobalDefine.Result d = new GlobalDefine.Result();
        private C0053e e;
        private ArrayList<b> f;
        private long g;
        private int h;
        private boolean i;
        private int j;

        /* compiled from: FittingModeNetworkManager */
        public class a extends GlobalDefine.Request {

            /* renamed from: a  reason: collision with root package name */
            public final int f1428a;

            a(int i) {
                this.f1428a = i;
            }
        }

        /* compiled from: FittingModeNetworkManager */
        private class b {

            /* renamed from: a  reason: collision with root package name */
            String f1430a;

            /* renamed from: b  reason: collision with root package name */
            String f1431b;
            long c;

            public b(String str, String str2, long j) {
                this.f1430a = str;
                this.f1431b = str2;
                this.c = j;
            }
        }

        public c(Context context, int i2, C0053e eVar) {
            Log.d(this.f1426a, "DownloadClothDataTask()+");
            this.f1427b = context;
            this.c = i2;
            this.e = eVar;
            this.j = 0;
            this.d.request = new a(i2);
        }

        public void a() {
            Log.d(this.f1426a, "StopTask()+");
            if (getStatus() != AsyncTask.Status.FINISHED) {
                cancel(true);
            }
        }

        public void b() {
            Log.d(this.f1426a, "StopTaskImmediately()+");
            this.i = true;
            this.d.resultCode = -2;
            a();
            d();
            if (this.e != null) {
                this.e.a(this.d);
            }
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (this.e != null) {
                this.e.a(this.c);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onProgressUpdate(Integer... numArr) {
            if (!isCancelled() && this.e != null) {
                this.e.a(this.c, 100, numArr[0].intValue());
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x0233, code lost:
            if (r16 != r3) goto L_0x0238;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0235, code lost:
            r20 = -2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x023a, code lost:
            if (r16 <= r3) goto L_0x0247;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x023c, code lost:
            r6.d.resultExtra = java.lang.Long.valueOf(r16);
            r20 = 4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0247, code lost:
            r20 = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x0249, code lost:
            net.fxgear.util.FXUtil.DeleteDirectoryRecursive(r1);
            r10 = r20;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x028b, code lost:
            if (r10 != -1) goto L_0x028f;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Integer doInBackground(java.lang.Void... r23) {
            /*
                r22 = this;
                r6 = r22
                android.content.Context r0 = r6.f1427b
                net.fxgear.fittingmodenative.e r7 = net.fxgear.fittingmodenative.e.a((android.content.Context) r0)
                if (r7 == 0) goto L_0x02dd
                int r0 = r6.c
                net.fxgear.FittingView$ClothesFileInfo r9 = r7.e((int) r0)
                if (r9 == 0) goto L_0x02c1
                boolean r0 = r22.isCancelled()
                r11 = -2
                if (r0 == 0) goto L_0x0025
                java.lang.String r0 = r6.f1426a
                java.lang.String r1 = "Cancel download task."
                android.util.Log.d(r0, r1)
                java.lang.Integer r0 = java.lang.Integer.valueOf(r11)
                return r0
            L_0x0025:
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                r6.f = r0
                java.io.File r0 = new java.io.File
                java.lang.String r1 = r9.mBaseDirectoryPath
                r0.<init>(r1)
                java.lang.String r12 = r0.getName()
                android.content.Context r1 = r6.f1427b
                int r1 = net.fxgear.fittingmodenative.d.e.a((android.content.Context) r1, (java.lang.String) r12)
                r6.j = r1
                android.content.Context r1 = r6.f1427b
                net.fxgear.fittingmodenative.e r1 = net.fxgear.fittingmodenative.e.a((android.content.Context) r1)
                int r1 = r1.b((java.lang.String) r12)
                boolean r2 = r7.b((net.fxgear.FittingView.ClothesFileInfo) r9)
                r13 = 0
                if (r2 == 0) goto L_0x0058
                int r2 = r6.j
                if (r2 <= r1) goto L_0x0056
                goto L_0x0058
            L_0x0056:
                r0 = r13
                goto L_0x00b0
            L_0x0058:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = net.fxgear.GlobalDefine.GetDataURL()
                r1.append(r2)
                java.lang.String r2 = java.io.File.separator
                r1.append(r2)
                r1.append(r12)
                java.lang.String r2 = java.io.File.separator
                r1.append(r2)
                r1.append(r12)
                java.lang.String r2 = ".zip"
                r1.append(r2)
                java.lang.String r2 = r1.toString()
                android.content.Context r1 = r6.f1427b
                long r4 = net.fxgear.fittingmodenative.d.c.a((android.content.Context) r1, (java.lang.String) r2)
                long r15 = r4 + r13
                java.io.File r1 = new java.io.File
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r12)
                java.lang.String r10 = ".zip"
                r3.append(r10)
                java.lang.String r3 = r3.toString()
                r1.<init>(r0, r3)
                java.util.ArrayList<net.fxgear.fittingmodenative.d.e$c$b> r10 = r6.f
                net.fxgear.fittingmodenative.d.e$c$b r3 = new net.fxgear.fittingmodenative.d.e$c$b
                java.lang.String r18 = r1.getAbsolutePath()
                r0 = r3
                r1 = r22
                r8 = r3
                r3 = r18
                r0.<init>(r2, r3, r4)
                r10.add(r8)
                r0 = r15
            L_0x00b0:
                boolean r2 = r22.isCancelled()
                if (r2 == 0) goto L_0x00c2
                java.lang.String r0 = r6.f1426a
                java.lang.String r1 = "Cancel download task."
                android.util.Log.d(r0, r1)
                java.lang.Integer r0 = java.lang.Integer.valueOf(r11)
                return r0
            L_0x00c2:
                boolean r2 = r7.c((net.fxgear.FittingView.ClothesFileInfo) r9)
                r10 = 4
                if (r2 != 0) goto L_0x0114
                int r2 = r6.c
                java.lang.String r2 = r7.d((int) r2)
                android.content.Context r3 = r6.f1427b
                net.fxgear.fittingmodenative.d.f r3 = net.fxgear.fittingmodenative.d.f.a((android.content.Context) r3)
                long r3 = r3.a()
                int r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
                if (r5 <= 0) goto L_0x010b
                boolean r2 = r6.i
                if (r2 != 0) goto L_0x0114
                net.fxgear.GlobalDefine$Result r0 = r6.d
                java.lang.Long r1 = java.lang.Long.valueOf(r3)
                r0.resultExtra = r1
                java.lang.String r0 = r6.f1426a
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "[ERROR] :: need more cache storage size "
                r1.append(r2)
                net.fxgear.GlobalDefine$Result r2 = r6.d
                java.lang.Object r2 = r2.resultExtra
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                android.util.Log.e(r0, r1)
                r22.d()
                java.lang.Integer r0 = java.lang.Integer.valueOf(r10)
                return r0
            L_0x010b:
                android.content.Context r3 = r6.f1427b
                net.fxgear.fittingmodenative.d.f r3 = net.fxgear.fittingmodenative.d.f.a((android.content.Context) r3)
                r3.b((java.lang.String) r2)
            L_0x0114:
                android.content.Context r2 = r6.f1427b
                java.io.File r2 = net.fxgear.GlobalDefine.GetClothDirectory(r2)
                long r2 = net.fxgear.util.FXUtil.GetAvailableSpaceSize(r2)
                r4 = -1
                int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r5 >= 0) goto L_0x02a3
                java.util.ArrayList<net.fxgear.fittingmodenative.d.e$c$b> r2 = r6.f
                boolean r2 = r2.isEmpty()
                if (r2 != 0) goto L_0x0299
                r2 = 0
                r6.h = r2
                r6.g = r0
                java.util.ArrayList<net.fxgear.fittingmodenative.d.e$c$b> r0 = r6.f
                java.util.Iterator r0 = r0.iterator()
                r1 = 0
            L_0x0137:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x0283
                java.lang.Object r1 = r0.next()
                net.fxgear.fittingmodenative.d.e$c$b r1 = (net.fxgear.fittingmodenative.d.e.c.b) r1
                android.content.Context r2 = r6.f1427b
                java.lang.String r5 = r1.f1430a
                java.lang.String r8 = r1.f1431b
                r15 = 0
                int r2 = net.fxgear.fittingmodenative.d.c.a(r2, r5, r8, r15, r6)
                if (r2 == r4) goto L_0x0179
                if (r2 == r11) goto L_0x016a
                java.lang.String r0 = r6.f1426a
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r5 = "ERROR :: download fail - "
                r3.append(r5)
                java.lang.String r5 = r1.f1430a
                r3.append(r5)
                java.lang.String r3 = r3.toString()
                android.util.Log.e(r0, r3)
            L_0x016a:
                if (r2 != r10) goto L_0x0176
                net.fxgear.GlobalDefine$Result r0 = r6.d
                long r10 = r1.c
                java.lang.Long r1 = java.lang.Long.valueOf(r10)
                r0.resultExtra = r1
            L_0x0176:
                r10 = r2
                goto L_0x0284
            L_0x0179:
                java.io.File r5 = new java.io.File
                java.lang.String r1 = r1.f1431b
                r5.<init>(r1)
                boolean r1 = net.fxgear.fittingmodenative.f.d((java.io.File) r5)
                if (r1 == 0) goto L_0x0275
                byte r1 = net.fxgear.fittingmodenative.f.f(r5)
                int r8 = r6.j
                if (r1 != r8) goto L_0x026c
                boolean r1 = net.fxgear.fittingmodenative.f.e((java.io.File) r5)
                if (r1 != 0) goto L_0x0196
                goto L_0x026c
            L_0x0196:
                java.io.File r1 = new java.io.File
                android.content.Context r8 = r6.f1427b
                java.io.File r8 = net.fxgear.GlobalDefine.GetTempDirectory(r8)
                long r16 = java.lang.System.currentTimeMillis()
                java.lang.String r3 = java.lang.String.valueOf(r16)
                r1.<init>(r8, r3)
                boolean r3 = r1.exists()
                if (r3 == 0) goto L_0x01b2
                net.fxgear.util.FXUtil.DeleteDirectoryRecursive(r1)
            L_0x01b2:
                long r16 = net.fxgear.fittingmodenative.f.b((java.io.File) r5)
                long r18 = net.fxgear.util.FXUtil.GetAvailableSpaceSize(r1)
                int r3 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
                if (r3 >= 0) goto L_0x024f
                long r16 = net.fxgear.fittingmodenative.f.a((java.io.File) r5, (java.io.File) r1)
                int r3 = (r16 > r13 ? 1 : (r16 == r13 ? 0 : -1))
                if (r3 != 0) goto L_0x0230
                boolean r3 = r22.isCancelled()
                if (r3 != 0) goto L_0x0230
                java.io.File r3 = new java.io.File
                java.lang.String r8 = r9.mBaseDirectoryPath
                r3.<init>(r8)
                boolean r8 = r3.exists()
                if (r8 != 0) goto L_0x01dc
                r3.mkdirs()
            L_0x01dc:
                java.io.File[] r8 = r1.listFiles()
                if (r8 == 0) goto L_0x0225
                int r10 = r8.length
                if (r10 <= 0) goto L_0x0225
                int r10 = r8.length
                r11 = 0
            L_0x01e7:
                if (r11 >= r10) goto L_0x0211
                r15 = r8[r11]
                java.io.File r4 = new java.io.File
                java.lang.String r13 = r15.getName()
                r4.<init>(r3, r13)
                boolean r13 = r4.exists()
                if (r13 == 0) goto L_0x0207
                boolean r13 = r4.isDirectory()
                if (r13 == 0) goto L_0x0204
                net.fxgear.util.FXUtil.DeleteDirectoryRecursive(r4)
                goto L_0x0207
            L_0x0204:
                r4.delete()
            L_0x0207:
                r15.renameTo(r4)
                int r11 = r11 + 1
                r4 = -1
                r13 = 0
                r15 = 0
                goto L_0x01e7
            L_0x0211:
                android.content.Context r3 = r6.f1427b
                net.fxgear.fittingmodenative.e r3 = net.fxgear.fittingmodenative.e.a((android.content.Context) r3)
                int r4 = r6.j
                r3.a((java.lang.String) r12, (int) r4)
                net.fxgear.util.FXUtil.DeleteDirectoryRecursive(r1)
                r5.delete()
                r3 = 0
                goto L_0x0276
            L_0x0225:
                java.lang.String r0 = r6.f1426a
                java.lang.String r2 = "ERROR :: empty zip file or wrong file."
                android.util.Log.e(r0, r2)
                net.fxgear.util.FXUtil.DeleteDirectoryRecursive(r1)
                goto L_0x0273
            L_0x0230:
                r3 = r13
                int r0 = (r16 > r3 ? 1 : (r16 == r3 ? 0 : -1))
                if (r0 != 0) goto L_0x0238
                r20 = -2
                goto L_0x0249
            L_0x0238:
                int r0 = (r16 > r3 ? 1 : (r16 == r3 ? 0 : -1))
                if (r0 <= 0) goto L_0x0247
                net.fxgear.GlobalDefine$Result r0 = r6.d
                java.lang.Long r2 = java.lang.Long.valueOf(r16)
                r0.resultExtra = r2
                r20 = 4
                goto L_0x0249
            L_0x0247:
                r20 = 3
            L_0x0249:
                net.fxgear.util.FXUtil.DeleteDirectoryRecursive(r1)
                r10 = r20
                goto L_0x0284
            L_0x024f:
                java.lang.String r0 = r6.f1426a
                java.lang.String r2 = "ERROR :: INSUFFICIENT_SPACE"
                android.util.Log.e(r0, r2)
                net.fxgear.GlobalDefine$Result r0 = r6.d
                long r2 = net.fxgear.fittingmodenative.f.b((java.io.File) r5)
                long r4 = net.fxgear.util.FXUtil.GetAvailableSpaceSize(r1)
                long r2 = r2 - r4
                java.lang.Long r2 = java.lang.Long.valueOf(r2)
                r0.resultExtra = r2
                net.fxgear.util.FXUtil.DeleteDirectoryRecursive(r1)
                r10 = 4
                goto L_0x0284
            L_0x026c:
                java.lang.String r0 = r6.f1426a
                java.lang.String r1 = "ERROR :: Wrong blendShape file."
                android.util.Log.e(r0, r1)
            L_0x0273:
                r10 = 3
                goto L_0x0284
            L_0x0275:
                r3 = r13
            L_0x0276:
                int r1 = r6.h
                int r1 = r1 + 1
                r6.h = r1
                r1 = r2
                r13 = r3
                r4 = -1
                r10 = 4
                r11 = -2
                goto L_0x0137
            L_0x0283:
                r10 = r1
            L_0x0284:
                boolean r0 = r22.isCancelled()
                if (r0 != 0) goto L_0x028e
                r4 = -1
                if (r10 == r4) goto L_0x0296
                goto L_0x028f
            L_0x028e:
                r4 = -1
            L_0x028f:
                boolean r0 = r6.i
                if (r0 != 0) goto L_0x0296
                r22.d()
            L_0x0296:
                r17 = r10
                goto L_0x02ae
            L_0x0299:
                java.lang.String r0 = r6.f1426a
                java.lang.String r1 = "[ERROR] :: mDownloadList is empty"
                android.util.Log.e(r0, r1)
                r17 = 2
                goto L_0x02ae
            L_0x02a3:
                net.fxgear.GlobalDefine$Result r5 = r6.d
                long r0 = r0 - r2
                java.lang.Long r0 = java.lang.Long.valueOf(r0)
                r5.resultExtra = r0
                r17 = 4
            L_0x02ae:
                boolean r0 = r7.a((net.fxgear.FittingView.ClothesFileInfo) r9)
                if (r0 == 0) goto L_0x02b7
                r17 = -1
                goto L_0x02be
            L_0x02b7:
                java.lang.String r0 = r6.f1426a
                java.lang.String r1 = "[ERROR] :: clothesFileInfo doesn't exist at db"
                android.util.Log.e(r0, r1)
            L_0x02be:
                r8 = r17
                goto L_0x02da
            L_0x02c1:
                java.lang.String r0 = r6.f1426a
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "[ERROR] :: clothesFileInfo is null, id: "
                r1.append(r2)
                int r2 = r6.c
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                android.util.Log.e(r0, r1)
                r8 = 2
            L_0x02da:
                r21 = r8
                goto L_0x02e6
            L_0x02dd:
                java.lang.String r0 = r6.f1426a
                java.lang.String r1 = "[ERROR] :: FittingModeDataManager is null"
                android.util.Log.e(r0, r1)
                r21 = 0
            L_0x02e6:
                java.lang.Integer r0 = java.lang.Integer.valueOf(r21)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.d.e.c.doInBackground(java.lang.Void[]):java.lang.Integer");
        }

        private void d() {
            Log.d(this.f1426a, "DeleteDownloadFiles()+");
            if (this.f != null) {
                Iterator<b> it = this.f.iterator();
                while (it.hasNext()) {
                    File file = new File(it.next().f1431b);
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onCancelled(Integer num) {
            Log.d(this.f1426a, "onCancelled()+");
            if (!this.i) {
                d();
                this.d.resultCode = -2;
                if (this.e != null) {
                    this.e.a(this.d);
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Integer num) {
            Log.d(this.f1426a, "onPostExecute()+");
            this.d.resultCode = num.intValue();
            if (num.intValue() == -1) {
                FXUtil.PrintFileListFromDirectory(GlobalDefine.GetClothDirectory(this.f1427b), (String) null);
            }
            if (this.e != null) {
                this.e.a(this.d);
            }
        }

        public void a(int i2) {
            if (i2 > 0) {
                long j2 = 0;
                for (int i3 = 0; i3 < this.h; i3++) {
                    j2 += this.f.get(i3).c;
                }
                int i4 = (int) (((j2 + ((this.f.get(this.h).c * ((long) i2)) / 100)) * 100) / this.g);
                if (i4 < 100) {
                    publishProgress(new Integer[]{Integer.valueOf(i4)});
                    return;
                }
                publishProgress(new Integer[]{100});
            }
        }

        public int c() {
            return this.c;
        }
    }

    /* compiled from: FittingModeNetworkManager */
    public static class f extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        private d f1432a;

        /* renamed from: b  reason: collision with root package name */
        private i f1433b;
        private b c;

        /* compiled from: FittingModeNetworkManager */
        public static class a extends GlobalDefine.Request {

            /* renamed from: a  reason: collision with root package name */
            public String f1434a;
        }

        /* compiled from: FittingModeNetworkManager */
        public static class b extends GlobalDefine.Result {

            /* renamed from: a  reason: collision with root package name */
            public h f1435a;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (this.f1432a != null) {
                this.f1432a.a();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            this.c.resultCode = 0;
            a aVar = (a) this.c.request;
            if (aVar == null || aVar.f1434a == null) {
                this.c.resultCode = 1;
                return null;
            }
            try {
                this.f1433b = new i();
                String a2 = this.f1433b.a(aVar.f1434a, "GET", (HashMap<String, String>) null);
                if (a2 != null) {
                    this.c.f1435a = new h(a2);
                    this.c.resultCode = -1;
                } else {
                    this.c.resultCode = 11;
                }
            } catch (IllegalArgumentException e) {
                this.c.resultCode = 10;
                e.printStackTrace();
            } catch (IOException e2) {
                this.c.resultCode = 10;
                e2.printStackTrace();
            } catch (JSONException e3) {
                this.c.resultCode = 11;
                e3.printStackTrace();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            if (this.c.resultCode != -1) {
                this.c.f1435a = null;
            }
            if (this.f1432a != null) {
                this.f1432a.a(this.c);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onCancelled(Void voidR) {
            Log.d(e.f1419a, "onCancelled()+");
            this.c.resultCode = -2;
            this.c.f1435a = null;
            if (this.f1432a != null) {
                this.f1432a.a(this.c);
            }
        }

        public static b a(String str, String str2) {
            a aVar = new a();
            aVar.f1434a = String.format("%s/fitting/defaultVideos?sex=%s&kids_yn=%s", new Object[]{GlobalDefine.GetApiURL(), str, str2});
            b bVar = new b();
            bVar.resultCode = 0;
            bVar.request = aVar;
            if (str == null || aVar.f1434a == null) {
                bVar.resultCode = 1;
                return bVar;
            }
            try {
                String a2 = new i().a(aVar.f1434a, "GET", (HashMap<String, String>) null);
                if (a2 != null) {
                    bVar.f1435a = new h(a2);
                    bVar.resultCode = -1;
                } else {
                    bVar.resultCode = 11;
                }
            } catch (IllegalArgumentException e) {
                bVar.resultCode = 10;
                e.printStackTrace();
            } catch (IOException e2) {
                bVar.resultCode = 10;
                e2.printStackTrace();
            } catch (JSONException e3) {
                bVar.resultCode = 11;
                e3.printStackTrace();
            }
            return bVar;
        }

        public static b a(String str) {
            boolean z;
            String str2;
            b bVar = new b();
            bVar.resultCode = 0;
            a aVar = new a();
            bVar.request = aVar;
            if (str == null) {
                bVar.resultCode = 1;
                return bVar;
            }
            if (!str.startsWith("http") || !str.contains(GlobalDefine.UNITY_REAL_VIDEO_QR_DATA_DIRECTORY_NAME)) {
                if (str.length() == 16) {
                    str2 = GlobalDefine.GetApiURL();
                } else {
                    str2 = GlobalDefine.GetLegacyApiUrl();
                }
                aVar.f1434a = String.format("%s/fitting/getVideo?serial=%s&device_id=%s", new Object[]{str2, str, GlobalDefine.GetDeviceUUID()});
                z = false;
            } else {
                String a2 = a(str, 2);
                if (a2 == null) {
                    bVar.resultCode = 3;
                    return bVar;
                }
                aVar.f1434a = String.format("%s/Video/Take?Guid=%s&Json=1&User=%s&Force=1", new Object[]{GlobalDefine.GetLegacyMirrorQRUrl(), a2, "42"});
                z = true;
            }
            try {
                String a3 = new i().a(aVar.f1434a, "GET", (HashMap<String, String>) null);
                if (a3 != null) {
                    JSONObject jSONObject = new JSONObject(a3);
                    if (z) {
                        if (!jSONObject.has("Result")) {
                            bVar.resultCode = 11;
                        } else if (jSONObject.getInt("Result") > 0) {
                            String a4 = a(str, 1);
                            bVar.f1435a = new h();
                            bVar.f1435a.a(a4, str);
                            bVar.resultCode = -1;
                        } else {
                            bVar.resultCode = 3;
                        }
                    } else if (jSONObject.has("code")) {
                        String string = jSONObject.getString("code");
                        if (string != null && string.equals("ER_DELETED_DATA")) {
                            bVar.resultCode = 12;
                        } else if (string != null && string.equals("ER_NOT_MATCH")) {
                            bVar.resultCode = 3;
                        } else if (string == null || !string.equals("ER_UNDEFINED_PARAM_ERROR")) {
                            bVar.resultCode = 0;
                        } else {
                            bVar.resultCode = 1;
                        }
                    } else {
                        bVar.f1435a = new h(a3);
                        bVar.resultCode = -1;
                    }
                } else {
                    bVar.resultCode = 11;
                }
            } catch (IllegalArgumentException e) {
                bVar.resultCode = 10;
                e.printStackTrace();
            } catch (IOException e2) {
                bVar.resultCode = 10;
                e2.printStackTrace();
            } catch (JSONException e3) {
                bVar.resultCode = 11;
                e3.printStackTrace();
            }
            return bVar;
        }

        private static String a(String str, int i) {
            String[] split;
            int i2;
            if (str == null || !str.contains(GlobalDefine.UNITY_REAL_VIDEO_QR_DATA_DIRECTORY_NAME) || (split = str.split("/")) == null) {
                return null;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= split.length) {
                    i3 = -1;
                    break;
                } else if (split[i3].equals(GlobalDefine.UNITY_REAL_VIDEO_QR_DATA_DIRECTORY_NAME)) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 == -1 || (i2 = i3 + i) >= split.length) {
                return null;
            }
            return split[i2];
        }
    }

    public static GlobalDefine.Result a(Context context, ArrayList<String> arrayList) {
        GlobalDefine.Result result = new GlobalDefine.Result();
        result.resultCode = 0;
        if (arrayList == null || arrayList.isEmpty()) {
            result.resultCode = 1;
            return result;
        }
        if (!net.fxgear.fittingmodenative.f.a(context)) {
            Log.e(f1419a, "ERROR :: network disconnected");
            result.resultCode = 10;
        } else if (FXUtil.IsMainThread()) {
            Log.e(f1419a, "ERROR :: illegal state");
            result.resultCode = 2;
        } else if (Thread.currentThread().isInterrupted()) {
            Log.e(f1419a, "cancel GetBaseCategoryVersion");
            result.resultCode = -2;
        } else {
            try {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i));
                    if (i != arrayList.size() - 1) {
                        sb.append(",");
                    }
                }
                String a2 = new i().a(String.format("%s/category/base/version?key=%s", new Object[]{GlobalDefine.GetApiURL(), sb.toString()}), "GET", (HashMap<String, String>) null);
                if (a2 != null) {
                    JSONArray jSONArray = new JSONArray(a2);
                    HashMap hashMap = new HashMap();
                    if (jSONArray.length() > 0) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            String string = jSONObject.has("dir") ? jSONObject.getString("dir") : null;
                            String string2 = jSONObject.has("ver") ? jSONObject.getString("ver") : null;
                            if (!(string == null || string2 == null)) {
                                hashMap.put(string, string2);
                            }
                        }
                    }
                    result.resultExtra = hashMap;
                    result.resultCode = -1;
                }
            } catch (IllegalArgumentException e) {
                result.resultCode = 10;
                e.printStackTrace();
            } catch (IOException e2) {
                result.resultCode = 14;
                e2.printStackTrace();
            } catch (JSONException e3) {
                result.resultCode = 3;
                e3.printStackTrace();
            }
        }
        return result;
    }

    public static int a(Context context, String str) {
        if (str == null || str.isEmpty()) {
            return -1;
        }
        if (!net.fxgear.fittingmodenative.f.a(context)) {
            Log.e(f1419a, "ERROR :: network disconnected");
            return -1;
        } else if (FXUtil.IsMainThread()) {
            Log.e(f1419a, "ERROR :: illegal state");
            return -1;
        } else if (Thread.currentThread().isInterrupted()) {
            Log.e(f1419a, "cancel GetBaseCategoryVersion");
            return -1;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            GlobalDefine.Result a2 = a(context, (ArrayList<String>) arrayList);
            if (a2.resultCode == -1 && a2.resultExtra != null) {
                return Integer.parseInt(((String) ((HashMap) a2.resultExtra).get(str)).substring(2), 16);
            }
            Log.e(f1419a, "ERROR :: Get base category network api fail.");
            return -1;
        }
    }

    public static b a() {
        b bVar;
        String format = String.format("%s/file/getDataZipInfo", new Object[]{GlobalDefine.GetApiURL()});
        if (GlobalDefine.GetAccountUUID() != null) {
            format = format + String.format("?account_uuid=%s", new Object[]{GlobalDefine.GetAccountUUID()});
        }
        try {
            String a2 = new i().a(format, "GET", (HashMap<String, String>) null);
            if (a2 != null) {
                bVar = new b(a2);
            } else {
                bVar = new b();
                bVar.f1412b = GlobalDefine.GetFittingDataRootURL() + GlobalDefine.FITTING_BASE_DATA_FILE_NAME;
                bVar.d = GlobalDefine.GetFittingDataRootURL() + GlobalDefine.FITTING_HAIR_DATA_FILE_NAME;
                bVar.f = GlobalDefine.GetFittingDataRootURL() + GlobalDefine.FITTING_HEAD_DATA_FILE_NAME;
            }
            if (bVar.f1412b != null) {
                return bVar;
            }
            bVar.f1412b = GlobalDefine.GetFittingDataRootURL() + GlobalDefine.FITTING_BASE_DATA_FILE_NAME;
            bVar.d = GlobalDefine.GetFittingDataRootURL() + GlobalDefine.FITTING_HAIR_DATA_FILE_NAME;
            bVar.f = GlobalDefine.GetFittingDataRootURL() + GlobalDefine.FITTING_HEAD_DATA_FILE_NAME;
            return bVar;
        } catch (Exception unused) {
            b bVar2 = new b();
            bVar2.f1412b = GlobalDefine.GetFittingDataRootURL() + GlobalDefine.FITTING_BASE_DATA_FILE_NAME;
            bVar2.d = GlobalDefine.GetFittingDataRootURL() + GlobalDefine.FITTING_HAIR_DATA_FILE_NAME;
            bVar2.f = GlobalDefine.GetFittingDataRootURL() + GlobalDefine.FITTING_HEAD_DATA_FILE_NAME;
            return bVar2;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\d\f.java ==========

package net.fxgear.fittingmodenative.d;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import net.fxgear.util.FXUtil;

/* compiled from: PackageFileCache */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1436a = "f";

    /* renamed from: b  reason: collision with root package name */
    private static f f1437b;
    private Context c;
    /* access modifiers changed from: private */
    public File d;
    /* access modifiers changed from: private */
    public long e;
    private Handler f;
    private HandlerThread g;
    /* access modifiers changed from: private */
    public Object h = new Object();
    private Handler.Callback i = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 99) {
                return false;
            }
            long j = 0;
            synchronized (f.this.h) {
                ArrayList a2 = f.this.b(f.this.d);
                if (a2 != null) {
                    Iterator it = a2.iterator();
                    while (it.hasNext()) {
                        j += ((File) it.next()).length();
                    }
                }
            }
            if (j < f.this.e) {
                return false;
            }
            f.this.c();
            return false;
        }
    };

    private f(Context context, long j) {
        if (j <= 0) {
            FXUtil.OccurRunTimeException("ERROR :: IllegalState - param is wrong.");
        }
        this.e = j;
        this.c = context.getApplicationContext();
        this.d = net.fxgear.fittingmodenative.f.a(context, "FXCache");
        if (this.d != null && !this.d.exists()) {
            this.d.mkdirs();
        }
        this.g = new HandlerThread(f1436a);
        this.g.start();
        this.f = new Handler(this.g.getLooper(), this.i);
        b();
    }

    public long a() {
        long GetAvailableSpaceSize = FXUtil.GetAvailableSpaceSize(this.d);
        if (GetAvailableSpaceSize < 10485760) {
            return 10485760 - GetAvailableSpaceSize;
        }
        return 0;
    }

    public static f a(Context context) {
        if (f1437b == null) {
            f1437b = new f(context, 52428800);
        }
        return f1437b;
    }

    private void b() {
        Log.d(f1436a, "calculateCurrentSize()+");
        if (this.f != null) {
            this.f.removeMessages(99);
            this.f.sendEmptyMessage(99);
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        Log.d(f1436a, "removeOldCacheFiles()+");
        synchronized (this.h) {
            ArrayList<File> b2 = b(this.d);
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
                long j = 0;
                while (true) {
                    if (i2 >= b2.size()) {
                        break;
                    }
                    File file = b2.get(i2);
                    j += file.length();
                    if (this.e == 0) {
                        break;
                    } else if (j >= this.e / 2) {
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

    public boolean a(String str) {
        boolean z;
        synchronized (this.h) {
            String b2 = net.fxgear.fittingmodenative.f.b(this.c, str);
            z = b2 != null && new File(b2).exists();
        }
        return z;
    }

    public boolean b(String str) {
        if (a(str)) {
            return true;
        }
        String b2 = net.fxgear.fittingmodenative.f.b(this.c, str);
        synchronized (this.h) {
            File parentFile = new File(b2).getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (a(this.c, str, b2, false) == -1) {
                b();
                return true;
            }
            File file = new File(b2);
            if (file.exists()) {
                file.delete();
            }
            Log.e(f1436a, "ERROR :: download file fail.");
            return false;
        }
    }

    /* JADX WARNING: type inference failed for: r0v17, types: [java.net.URLConnection] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01a0 A[Catch:{ Exception -> 0x019c }] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01a5 A[Catch:{ Exception -> 0x019c }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01ba A[SYNTHETIC, Splitter:B:111:0x01ba] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01c2 A[Catch:{ Exception -> 0x01be }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01c7 A[Catch:{ Exception -> 0x01be }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01d5 A[SYNTHETIC, Splitter:B:124:0x01d5] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01dd A[Catch:{ Exception -> 0x01d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01e2 A[Catch:{ Exception -> 0x01d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0198 A[SYNTHETIC, Splitter:B:95:0x0198] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(android.content.Context r20, java.lang.String r21, java.lang.String r22, boolean r23) {
        /*
            r19 = this;
            r0 = r21
            r1 = r22
            java.lang.String r3 = f1436a
            java.lang.String r4 = "DownloadFile()+"
            android.util.Log.i(r3, r4)
            r3 = 1
            r4 = -2
            if (r0 == 0) goto L_0x01f4
            if (r1 != 0) goto L_0x0013
            goto L_0x01f4
        L_0x0013:
            boolean r5 = net.fxgear.fittingmodenative.f.a((android.content.Context) r20)
            if (r5 == 0) goto L_0x01ea
            boolean r5 = net.fxgear.util.FXUtil.IsMainThread()
            if (r5 == 0) goto L_0x0029
            java.lang.String r0 = f1436a
            java.lang.String r1 = "ERROR :: illegal state"
            android.util.Log.e(r0, r1)
            r3 = 2
            goto L_0x0212
        L_0x0029:
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            boolean r5 = r5.isInterrupted()
            if (r5 == 0) goto L_0x003d
            java.lang.String r0 = f1436a
            java.lang.String r1 = "cancel download"
            android.util.Log.e(r0, r1)
            r3 = -2
            goto L_0x0212
        L_0x003d:
            java.io.File r5 = new java.io.File
            r5.<init>(r1)
            java.io.File r1 = r5.getParentFile()
            boolean r1 = r1.exists()
            if (r1 != 0) goto L_0x0054
            java.io.File r1 = r5.getParentFile()
            r1.mkdirs()
            goto L_0x005f
        L_0x0054:
            if (r23 != 0) goto L_0x005f
            boolean r1 = r5.exists()
            if (r1 == 0) goto L_0x005f
            r5.delete()
        L_0x005f:
            r1 = 14
            r6 = 0
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch:{ MalformedURLException -> 0x01b0, IOException -> 0x0190, all -> 0x018b }
            java.lang.String r8 = "rw"
            r7.<init>(r5, r8)     // Catch:{ MalformedURLException -> 0x01b0, IOException -> 0x0190, all -> 0x018b }
            long r8 = r7.length()     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x0185, all -> 0x0180 }
            r10 = 0
            if (r23 == 0) goto L_0x008e
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 <= 0) goto L_0x008e
            java.lang.String r2 = f1436a     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x0185, all -> 0x0180 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x0185, all -> 0x0180 }
            r12.<init>()     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x0185, all -> 0x0180 }
            java.lang.String r13 = "exist file size : "
            r12.append(r13)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x0185, all -> 0x0180 }
            r12.append(r8)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x0185, all -> 0x0180 }
            java.lang.String r12 = r12.toString()     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x0185, all -> 0x0180 }
            android.util.Log.d(r2, r12)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x0185, all -> 0x0180 }
            r7.seek(r8)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x0185, all -> 0x0180 }
        L_0x008e:
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x0185, all -> 0x0180 }
            boolean r2 = r2.isInterrupted()     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x0185, all -> 0x0180 }
            if (r2 == 0) goto L_0x00a2
            java.lang.String r0 = f1436a     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x0185, all -> 0x0180 }
            java.lang.String r2 = "cancel download"
            android.util.Log.e(r0, r2)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x0185, all -> 0x0180 }
            r2 = r6
            goto L_0x0165
        L_0x00a2:
            java.net.URL r2 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x0185, all -> 0x0180 }
            r2.<init>(r0)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x0185, all -> 0x0180 }
            java.net.URLConnection r0 = r2.openConnection()     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x0185, all -> 0x0180 }
            r2 = r0
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x0185, all -> 0x0180 }
            r0 = 10000(0x2710, float:1.4013E-41)
            r2.setConnectTimeout(r0)     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            r2.setReadTimeout(r0)     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            java.lang.String r0 = "Range"
            java.lang.String r12 = "bytes=%s-"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            java.lang.String r13 = java.lang.String.valueOf(r8)     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            r14 = 0
            r3[r14] = r13     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            java.lang.String r3 = java.lang.String.format(r12, r3)     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            r2.setRequestProperty(r0, r3)     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            r2.connect()     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r2.getHeaderField(r0)     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            if (r0 == 0) goto L_0x00da
            long r12 = java.lang.Long.parseLong(r0)     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            goto L_0x00dc
        L_0x00da:
            r12 = -1
        L_0x00dc:
            int r0 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x014d
            long r15 = r12 + r8
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            boolean r0 = r0.isInterrupted()     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            if (r0 == 0) goto L_0x00f5
            java.lang.String r0 = f1436a     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            java.lang.String r3 = "cancel download"
            android.util.Log.e(r0, r3)     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            goto L_0x0165
        L_0x00f5:
            long r17 = net.fxgear.util.FXUtil.GetAvailableSpaceSize(r5)     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            int r0 = (r12 > r17 ? 1 : (r12 == r17 ? 0 : -1))
            if (r0 <= 0) goto L_0x0107
            java.lang.String r0 = f1436a     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            java.lang.String r3 = "ERROR :: insufficient space"
            android.util.Log.e(r0, r3)     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            r0 = 4
            r4 = 4
            goto L_0x0165
        L_0x0107:
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            r3.<init>(r5)     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            r5 = -1
            r6 = 0
        L_0x0116:
            int r12 = r3.read(r0)     // Catch:{ MalformedURLException -> 0x0149, IOException -> 0x0146, all -> 0x0141 }
            if (r12 == r5) goto L_0x013e
            java.lang.Thread r13 = java.lang.Thread.currentThread()     // Catch:{ MalformedURLException -> 0x0149, IOException -> 0x0146, all -> 0x0141 }
            boolean r13 = r13.isInterrupted()     // Catch:{ MalformedURLException -> 0x0149, IOException -> 0x0146, all -> 0x0141 }
            if (r13 == 0) goto L_0x012e
            java.lang.String r0 = f1436a     // Catch:{ MalformedURLException -> 0x0149, IOException -> 0x0146, all -> 0x0141 }
            java.lang.String r5 = "cancel download"
            android.util.Log.e(r0, r5)     // Catch:{ MalformedURLException -> 0x0149, IOException -> 0x0146, all -> 0x0141 }
            goto L_0x013f
        L_0x012e:
            if (r12 <= 0) goto L_0x0135
            r7.write(r0, r14, r12)     // Catch:{ MalformedURLException -> 0x0149, IOException -> 0x0146, all -> 0x0141 }
            long r12 = (long) r12
            long r10 = r10 + r12
        L_0x0135:
            r12 = 0
            long r12 = r10 + r8
            int r17 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r17 != 0) goto L_0x0116
            r6 = -1
            goto L_0x0116
        L_0x013e:
            r4 = r6
        L_0x013f:
            r6 = r3
            goto L_0x0165
        L_0x0141:
            r0 = move-exception
            r1 = r0
            r6 = r3
            goto L_0x01d3
        L_0x0146:
            r0 = move-exception
            r6 = r3
            goto L_0x0193
        L_0x0149:
            r0 = move-exception
            r6 = r3
            goto L_0x01b3
        L_0x014d:
            java.lang.String r0 = f1436a     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            r3.<init>()     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            java.lang.String r4 = "ERROR :: invalid download file length : "
            r3.append(r4)     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            r3.append(r12)     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            java.lang.String r3 = r3.toString()     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            android.util.Log.e(r0, r3)     // Catch:{ MalformedURLException -> 0x017e, IOException -> 0x017c }
            r4 = 14
        L_0x0165:
            if (r6 == 0) goto L_0x016d
            r6.close()     // Catch:{ Exception -> 0x016b }
            goto L_0x016d
        L_0x016b:
            r0 = move-exception
            goto L_0x0176
        L_0x016d:
            if (r2 == 0) goto L_0x0172
            r2.disconnect()     // Catch:{ Exception -> 0x016b }
        L_0x0172:
            r7.close()     // Catch:{ Exception -> 0x016b }
            goto L_0x0179
        L_0x0176:
            r0.printStackTrace()
        L_0x0179:
            r3 = r4
            goto L_0x0212
        L_0x017c:
            r0 = move-exception
            goto L_0x0193
        L_0x017e:
            r0 = move-exception
            goto L_0x01b3
        L_0x0180:
            r0 = move-exception
            r1 = r0
            r2 = r6
            goto L_0x01d3
        L_0x0185:
            r0 = move-exception
            r2 = r6
            goto L_0x0193
        L_0x0188:
            r0 = move-exception
            r2 = r6
            goto L_0x01b3
        L_0x018b:
            r0 = move-exception
            r1 = r0
            r2 = r6
            r7 = r2
            goto L_0x01d3
        L_0x0190:
            r0 = move-exception
            r2 = r6
            r7 = r2
        L_0x0193:
            r0.printStackTrace()     // Catch:{ all -> 0x01d1 }
            if (r6 == 0) goto L_0x019e
            r6.close()     // Catch:{ Exception -> 0x019c }
            goto L_0x019e
        L_0x019c:
            r0 = move-exception
            goto L_0x01a9
        L_0x019e:
            if (r2 == 0) goto L_0x01a3
            r2.disconnect()     // Catch:{ Exception -> 0x019c }
        L_0x01a3:
            if (r7 == 0) goto L_0x01ac
            r7.close()     // Catch:{ Exception -> 0x019c }
            goto L_0x01ac
        L_0x01a9:
            r0.printStackTrace()
        L_0x01ac:
            r3 = 14
            goto L_0x0212
        L_0x01b0:
            r0 = move-exception
            r2 = r6
            r7 = r2
        L_0x01b3:
            r1 = 13
            r0.printStackTrace()     // Catch:{ all -> 0x01d1 }
            if (r6 == 0) goto L_0x01c0
            r6.close()     // Catch:{ Exception -> 0x01be }
            goto L_0x01c0
        L_0x01be:
            r0 = move-exception
            goto L_0x01cb
        L_0x01c0:
            if (r2 == 0) goto L_0x01c5
            r2.disconnect()     // Catch:{ Exception -> 0x01be }
        L_0x01c5:
            if (r7 == 0) goto L_0x01ce
            r7.close()     // Catch:{ Exception -> 0x01be }
            goto L_0x01ce
        L_0x01cb:
            r0.printStackTrace()
        L_0x01ce:
            r3 = 13
            goto L_0x0212
        L_0x01d1:
            r0 = move-exception
            r1 = r0
        L_0x01d3:
            if (r6 == 0) goto L_0x01db
            r6.close()     // Catch:{ Exception -> 0x01d9 }
            goto L_0x01db
        L_0x01d9:
            r0 = move-exception
            goto L_0x01e6
        L_0x01db:
            if (r2 == 0) goto L_0x01e0
            r2.disconnect()     // Catch:{ Exception -> 0x01d9 }
        L_0x01e0:
            if (r7 == 0) goto L_0x01e9
            r7.close()     // Catch:{ Exception -> 0x01d9 }
            goto L_0x01e9
        L_0x01e6:
            r0.printStackTrace()
        L_0x01e9:
            throw r1
        L_0x01ea:
            java.lang.String r0 = f1436a
            java.lang.String r1 = "ERROR :: network disconnected"
            android.util.Log.e(r0, r1)
            r3 = 10
            goto L_0x0212
        L_0x01f4:
            java.lang.String r2 = f1436a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "ERROR :: param error, url : "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = ", filePath : "
            r4.append(r0)
            r4.append(r1)
            java.lang.String r0 = r4.toString()
            android.util.Log.e(r2, r0)
        L_0x0212:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingmodenative.d.f.a(android.content.Context, java.lang.String, java.lang.String, boolean):int");
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\d\g.java ==========

package net.fxgear.fittingmodenative.d;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import net.fxgear.GlobalDefine;
import net.fxgear.fittingmodenative.d.c;
import net.fxgear.fittingmodenative.d.e;
import net.fxgear.fittingmodenative.d.h;
import net.fxgear.fittingmodenative.e;
import net.fxgear.util.FXUtil;

/* compiled from: QRRealDataTask */
public class g extends AsyncTask<Void, Integer, Void> implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f1440a = g.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private Context f1441b;
    private String c;
    private b d;
    private d e = new d();
    private ArrayList<a> f;
    private long g = 0;
    private int h = 0;
    private int i = 0;

    /* compiled from: QRRealDataTask */
    public interface b {
        void a(String str);

        void a(String str, int i, int i2);

        void a(d dVar);
    }

    /* compiled from: QRRealDataTask */
    public class c extends GlobalDefine.Request {

        /* renamed from: a  reason: collision with root package name */
        public final String f1444a;

        c(String str) {
            this.f1444a = str;
        }
    }

    /* compiled from: QRRealDataTask */
    public class d extends GlobalDefine.Result {

        /* renamed from: a  reason: collision with root package name */
        public e.c f1446a;

        public d() {
        }
    }

    /* compiled from: QRRealDataTask */
    private class a {

        /* renamed from: a  reason: collision with root package name */
        String f1442a;

        /* renamed from: b  reason: collision with root package name */
        String f1443b;
        long c;

        public a(String str, String str2, long j) {
            this.f1442a = str;
            this.f1443b = str2;
            this.c = j;
        }
    }

    public static g a(Context context, String str, b bVar) {
        g gVar = new g(context, str, bVar);
        gVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return gVar;
    }

    g(Context context, String str, b bVar) {
        this.f1441b = context;
        this.c = str;
        this.d = bVar;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        Log.d(this.f1440a, "onPreExecute()+");
        if (this.d != null) {
            this.d.a(this.c);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        Log.d(this.f1440a, "doInBackground()+");
        this.e.request = new c(this.c);
        this.e.resultCode = 0;
        if (this.f1441b == null || this.c == null) {
            this.e.resultCode = 1;
            return null;
        } else if (isCancelled()) {
            Log.e(this.f1440a, "Task cancel.");
            return null;
        } else {
            e.f.b a2 = e.f.a(this.c);
            if (a2.resultCode != -1) {
                this.e.resultCode = a2.resultCode;
                Log.e(this.f1440a, "ERROR :: error code : " + this.e.resultCode);
                return null;
            } else if (a2.f1435a == null || a2.f1435a.f1448a == null) {
                this.e.resultCode = 11;
                Log.e(this.f1440a, "ERROR :: error code : " + this.e.resultCode);
                return null;
            } else {
                h.a aVar = a2.f1435a.f1448a[0];
                net.fxgear.fittingmodenative.e a3 = net.fxgear.fittingmodenative.e.a(this.f1441b);
                if (a3.e(aVar.e)) {
                    Log.e(this.f1440a, "WARNING :: Exist real data.");
                    this.e.resultCode = 5;
                    return null;
                }
                int i2 = aVar.f1450a.equals(GlobalDefine.GENDER_MAN_STRING) ? 2 : 1;
                int i3 = aVar.f1451b ? 1 : 2;
                File GetRealDirectory = GlobalDefine.GetRealDirectory(this.f1441b, i2, i3);
                if (GetRealDirectory.exists() && !GetRealDirectory.isDirectory()) {
                    GetRealDirectory.delete();
                }
                if (!GetRealDirectory.exists()) {
                    GetRealDirectory.mkdirs();
                }
                long a4 = c.a(this.f1441b, aVar.c);
                if (a4 > 0) {
                    File file = new File(GetRealDirectory, GlobalDefine.FILE_NAME_VIDEO);
                    if (file.exists()) {
                        file.delete();
                    }
                    this.f = new ArrayList<>();
                    this.g += a4;
                    ArrayList<a> arrayList = this.f;
                    a aVar2 = r1;
                    File file2 = file;
                    int i4 = i3;
                    File file3 = GetRealDirectory;
                    a aVar3 = new a(aVar.c, file.getAbsolutePath(), a4);
                    arrayList.add(aVar2);
                    long a5 = c.a(this.f1441b, aVar.d);
                    if (a5 > 0) {
                        File file4 = new File(file3, GlobalDefine.FILE_NAME_ANIMATION);
                        if (file4.exists()) {
                            file4.delete();
                        }
                        this.g += a5;
                        ArrayList<a> arrayList2 = this.f;
                        a aVar4 = r1;
                        File file5 = file4;
                        a aVar5 = new a(aVar.d, file4.getAbsolutePath(), a5);
                        arrayList2.add(aVar4);
                        long GetAvailableSpaceSize = FXUtil.GetAvailableSpaceSize(file3);
                        if (this.g < GetAvailableSpaceSize) {
                            this.h = 0;
                            Iterator<a> it = this.f.iterator();
                            while (it.hasNext()) {
                                a next = it.next();
                                if (isCancelled()) {
                                    Log.e(this.f1440a, "Task cancel.");
                                    return null;
                                }
                                int a6 = c.a(this.f1441b, next.f1442a, next.f1443b, false, this);
                                if (a6 != -1) {
                                    Log.e(this.f1440a, "ERROR :: error code : " + a6);
                                    if (a6 == 4) {
                                        this.e.resultExtra = Long.valueOf(next.c);
                                    }
                                    this.e.resultCode = a6;
                                    return null;
                                }
                                this.h++;
                            }
                            synchronized (this) {
                                if (!file2.exists() || !file5.exists()) {
                                    Log.e(this.f1440a, "ERROR :: Not found download files.");
                                    this.e.resultCode = 0;
                                    return null;
                                }
                                String valueOf = String.valueOf(System.currentTimeMillis());
                                int i5 = i4;
                                if (a3.a(i2, i5, valueOf, GlobalDefine.REAL_VIDEO_BODY_SIZE_CUSTOM)) {
                                    valueOf = String.valueOf(System.currentTimeMillis());
                                }
                                if (!a3.a(i2, i5, valueOf, GlobalDefine.REAL_VIDEO_BODY_SIZE_CUSTOM)) {
                                    File file6 = new File(file3, String.format(GlobalDefine.FILE_NAME_FORMAT_VIDEO, new Object[]{valueOf}));
                                    File file7 = new File(file3, String.format(GlobalDefine.FILE_NAME_FORMAT_ANIMATION, new Object[]{valueOf}));
                                    file2.renameTo(file6);
                                    file5.renameTo(file7);
                                    if (file6.exists() && file6.length() == a4 && file7.exists() && file7.length() == a5) {
                                        this.e.f1446a = a3.g(a3.a(i2, i5, valueOf, GlobalDefine.REAL_VIDEO_BODY_SIZE_CUSTOM, aVar.d, aVar.c, aVar.e, aVar.f));
                                        if (this.e.f1446a != null) {
                                            this.e.resultCode = -1;
                                            return null;
                                        }
                                    }
                                    Log.e(this.f1440a, "ERROR :: IllegalState - wrong data.");
                                    this.e.resultCode = 3;
                                    return null;
                                }
                                Log.e(this.f1440a, "ERROR :: IllegalState - exist data.");
                                this.e.resultCode = 2;
                                return null;
                            }
                        }
                        long j = this.g - GetAvailableSpaceSize;
                        Log.e(this.f1440a, "ERROR :: ERROR_INSUFFICIENT_SPACE - " + j);
                        this.e.resultCode = 4;
                        this.e.resultExtra = Long.valueOf(j);
                        return null;
                    }
                    this.e.resultCode = 11;
                    Log.e(this.f1440a, "ERROR :: error code : " + this.e.resultCode);
                    return null;
                }
                this.e.resultCode = 11;
                Log.e(this.f1440a, "ERROR :: error code : " + this.e.resultCode);
                return null;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        if (this.d != null && !isCancelled()) {
            this.d.a(this.c, 100, numArr[0].intValue());
        }
    }

    public void a() {
        Log.d(this.f1440a, "StopTask()+");
        synchronized (this) {
            if (getStatus() != AsyncTask.Status.FINISHED) {
                cancel(true);
            }
        }
    }

    private void b() {
        Log.d(this.f1440a, "DeleteDownloadFiles()+");
        if (this.f != null) {
            Iterator<a> it = this.f.iterator();
            while (it.hasNext()) {
                File file = new File(it.next().f1443b);
                if (file.exists()) {
                    file.delete();
                }
            }
            this.f.clear();
            this.f = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onCancelled(Void voidR) {
        Log.d(this.f1440a, "onCancelled()+");
        b();
        this.e.f1446a = null;
        this.e.resultCode = -2;
        if (this.d != null) {
            this.d.a(this.e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(Void voidR) {
        Log.d(this.f1440a, "onPostExecute()+");
        if (this.e.resultCode != -1) {
            b();
            this.e.f1446a = null;
        }
        if (this.d != null) {
            this.d.a(this.e);
        }
    }

    public void a(int i2) {
        if (i2 > 0 && this.f != null) {
            if (this.h < this.f.size()) {
                long j = 0;
                for (int i3 = 0; i3 < this.h; i3++) {
                    j += this.f.get(i3).c;
                }
                int i4 = (int) (((j + ((this.f.get(this.h).c * ((long) i2)) / 100)) * 100) / this.g);
                if (i4 < 100 && this.i != i4) {
                    this.i = i4;
                    publishProgress(new Integer[]{Integer.valueOf(i4)});
                    return;
                }
                return;
            }
            publishProgress(new Integer[]{100});
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\d\h.java ==========

package net.fxgear.fittingmodenative.d;

import net.fxgear.GlobalDefine;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RealInfo */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public a[] f1448a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1449b = "result";
    private final String c = "results";

    public h() {
    }

    public h(String str) throws JSONException {
        if (str != null) {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("result") && !jSONObject.isNull("result")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                this.f1448a = new a[1];
                this.f1448a[0] = new a(jSONObject2);
            } else if (!jSONObject.has("results") || jSONObject.isNull("results")) {
                throw new JSONException("ERROR :: Unknown data format.");
            } else {
                JSONArray jSONArray = jSONObject.getJSONArray("results");
                this.f1448a = new a[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.f1448a[i] = new a(jSONArray.getJSONObject(i));
                }
            }
        } else {
            throw new JSONException("ERROR :: json data is null.");
        }
    }

    public void a(String str, String str2) {
        this.f1448a = new a[1];
        this.f1448a[0] = new a(str, str2);
    }

    /* compiled from: RealInfo */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f1450a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1451b;
        public String c;
        public String d;
        public String e;
        public int f;
        private final String h = "sex";
        private final String i = "kids_yn";
        private final String j = "video";
        private final String k = "animation";
        private final String l = "capture";
        private final String m = "version";

        public a(String str, String str2) {
            if (str2 != null) {
                if (!str2.endsWith("/")) {
                    str2 = str2 + "/";
                }
                this.c = str2 + GlobalDefine.FILE_NAME_VIDEO;
                this.d = str2 + GlobalDefine.FILE_NAME_ANIMATION;
                this.e = str2 + GlobalDefine.FILE_NAME_CAPTURE;
            }
            this.f1450a = str;
            this.f1451b = false;
            this.f = -1;
        }

        public a(JSONObject jSONObject) throws JSONException {
            this.f1450a = jSONObject.getString("sex");
            boolean z = false;
            if (jSONObject.has("kids_yn")) {
                this.f1451b = jSONObject.getInt("kids_yn") == 1 ? true : z;
            } else {
                this.f1451b = false;
            }
            this.c = jSONObject.getString("video");
            this.d = jSONObject.getString("animation");
            this.e = jSONObject.getString("capture");
            this.f = jSONObject.getInt("version");
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\d\i.java ==========

package net.fxgear.fittingmodenative.d;

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
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static int f1452a = 10000;

    /* renamed from: b  reason: collision with root package name */
    private static int f1453b = 10000;
    private final String c = "UTF-8";
    private HttpURLConnection d;
    private BufferedReader e;
    private final HostnameVerifier f = new HostnameVerifier() {
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    };

    public String a(String str, String str2, HashMap<String, String> hashMap) throws IOException, IllegalArgumentException {
        InputStreamReader inputStreamReader;
        String readLine;
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("ERROR :: param is null.");
        }
        URL url = new URL(str);
        if (url.getProtocol().toLowerCase().equals("https")) {
            a();
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setHostnameVerifier(this.f);
            this.d = httpsURLConnection;
        } else {
            this.d = (HttpURLConnection) url.openConnection();
        }
        this.d.setRequestMethod(str2);
        this.d.setReadTimeout(f1453b);
        this.d.setConnectTimeout(f1452a);
        this.d.setUseCaches(false);
        this.d.setDoInput(true);
        if (str2.equals("POST")) {
            this.d.setDoOutput(true);
            OutputStream outputStream = this.d.getOutputStream();
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
        this.d.connect();
        StringBuilder sb = new StringBuilder();
        if (this.d.getResponseCode() == 200) {
            inputStreamReader = new InputStreamReader(this.d.getInputStream());
        } else {
            inputStreamReader = new InputStreamReader(this.d.getErrorStream());
        }
        this.e = new BufferedReader(inputStreamReader);
        while (this.e != null && (readLine = this.e.readLine()) != null) {
            sb.append(readLine + 10);
        }
        if (this.e != null) {
            this.e.close();
            this.e = null;
        }
        inputStreamReader.close();
        this.d.disconnect();
        this.d = null;
        return sb.toString();
    }

    private void a() {
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




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingmodenative\d\j.java ==========

package net.fxgear.fittingmodenative.d;

import java.io.IOException;
import java.util.HashMap;
import net.fxgear.fittingmodenative.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Statistics */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1456a = "j";

    public static void a(String str, String str2) {
        if (f.f1467a.c != null) {
            final long a2 = a();
            final String str3 = f.f1467a.c;
            final String str4 = str;
            final String str5 = str2;
            new Thread(new Runnable() {
                public void run() {
                    j.b(str4, str5, str3, a2);
                }
            }).start();
        }
    }

    private static long a() {
        return System.currentTimeMillis() / 1000;
    }

    /* access modifiers changed from: private */
    public static void b(String str, String str2, String str3, long j) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("data", c(str, str2, str3, j));
            i iVar = new i();
            iVar.a(f.f1467a.f1470b + "log/setLogData", "POST", hashMap);
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
}


