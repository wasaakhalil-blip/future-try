package net.fxgear;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Log;
import android.util.TypedValue;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import net.fxgear.fittingview.data.FittingFaceData;

public class GlobalDefine {
    public static final int AGE_EARLY = 1;
    public static final String AGE_EARLY_STRING = "early";
    public static final int AGE_LATE = 3;
    public static final String AGE_LATE_STRING = "late";
    public static final int AGE_MIDDLE = 2;
    public static final String AGE_MIDDLE_STRING = "middle";
    public static final int ANIMTAION_TYPE_DEFAULT = 0;
    public static final int ANIMTAION_TYPE_WEDDING = 1;
    public static final int AVATAR_ID_NONE = -1;
    public static final String BASE_CATEGORY_NAME_WEDDING = "WomCloOne010";
    public static final int BODY_TEXTURE_TYPE_BOTTOM_NAKED = 2;
    public static final int BODY_TEXTURE_TYPE_DEFAULT = 0;
    public static final int BODY_TEXTURE_TYPE_NAKED = 3;
    public static final int BODY_TEXTURE_TYPE_TOP_NAKED = 1;
    public static final String CLOTH_DIRECTORY_KEYWORD = "Clo";
    public static final String CLOTH_GENDER_PREFIX_MAN = "Man";
    public static final String CLOTH_GENDER_PREFIX_WOMAN = "Wom";
    public static final int CLOTH_ID_NONE = -1;
    public static final String CLOTH_KEYWORD_BOTTOM = "Bot";
    public static final String CLOTH_KEYWORD_COAT = "Cot";
    public static final String CLOTH_KEYWORD_JACKET = "Jac";
    public static final String CLOTH_KEYWORD_ONEPIECE = "One";
    public static final String CLOTH_KEYWORD_SHOES = "Sho";
    public static final String CLOTH_KEYWORD_TOP = "Top";
    public static final int CONTENTS_DATA_COUNT = 3;
    public static final int CONTENTS_DATA_TYPE_BASE = 0;
    public static final int CONTENTS_DATA_TYPE_HAIR = 1;
    public static final int CONTENTS_DATA_TYPE_HEAD = 2;
    public static final int DATA_TYPE_DROPBOX = 3;
    public static final int DATA_TYPE_NEW_BALANCE_DEMO_DROPBOX = 4;
    public static final int DATA_TYPE_SERVER = 0;
    public static final int DATA_TYPE_TEST_3D_ARTS = 2;
    public static final int DATA_TYPE_TEST_GRAPHICS = 1;
    public static final boolean DEBUG = true;
    public static final float DEFAULT_AUTO_FILTER_VALUE = 0.0f;
    public static final String DEFAULT_FOLDER_NAME = "default";
    public static final int DEFAULT_HAIR_TYPE_INDEX = 0;
    public static final int DEFAULT_HEAD_TYPE_ID = 2;
    public static final int DEFAULT_HEAD_TYPE_INDEX = 0;
    public static final int DEFAULT_TEMPERATURE_COLOR_VALUE = -1;
    public static final String DIRECTORY_NAME_ACCESSORIES = "Accessories";
    public static final String DIRECTORY_NAME_ADULT = "Adult";
    public static final String DIRECTORY_NAME_ANIMATION = "Animation";
    public static final String DIRECTORY_NAME_AVATAR = "Avatar";
    public static final String DIRECTORY_NAME_AVATAR_DATA = "AvatarData";
    public static final String DIRECTORY_NAME_BASE = "Base";
    public static final String DIRECTORY_NAME_BODY = "Body";
    public static final String DIRECTORY_NAME_BOTTOM = "Bottom";
    public static final String DIRECTORY_NAME_BOY = "Boy";
    public static final String DIRECTORY_NAME_CHARACTER_DATA = "CharacterData";
    public static final String DIRECTORY_NAME_CLOTH = "Cloth";
    public static final String DIRECTORY_NAME_COAT = "Coat";
    public static final String DIRECTORY_NAME_COMMON = "Common";
    public static final String DIRECTORY_NAME_ENGINE = "Engine";
    public static final String DIRECTORY_NAME_FACE = "Face";
    public static final String DIRECTORY_NAME_GIRL = "Girl";
    public static final String DIRECTORY_NAME_HAIR = "Hair";
    public static final String DIRECTORY_NAME_HEAD = "Head";
    public static final String DIRECTORY_NAME_JACKET = "Jacket";
    public static final String DIRECTORY_NAME_KIDS = "Kids";
    public static final String DIRECTORY_NAME_MAN = "Man";
    public static final String DIRECTORY_NAME_ONEPIECE = "OnePiece";
    public static final String DIRECTORY_NAME_REAL = "Real";
    public static final String DIRECTORY_NAME_ROOT = "Data";
    public static final String DIRECTORY_NAME_RUNTIME = "Runtime";
    public static final String DIRECTORY_NAME_SHOES = "Shoes";
    public static final String DIRECTORY_NAME_SPECIAL_ANIMATIONS = "Special_Animations";
    public static final String DIRECTORY_NAME_TEMP = "TEMP";
    public static final String DIRECTORY_NAME_TOP = "Top";
    public static final String DIRECTORY_NAME_TYPE_RESOURCE = "Resource";
    public static final String DIRECTORY_NAME_UNISEX_ADULT = "UnisexAdult";
    public static final String DIRECTORY_NAME_UNISEX_CHILD = "UnisexChild";
    public static final String DIRECTORY_NAME_WOMAN = "Woman";
    public static final int ENGINE_DATA_TYPE = 0;
    public static final String EXTENSION_BIN = ".bin";
    public static final String EXTENSION_DAT = ".dat";
    public static final String EXTENSION_JPG = ".jpg";
    public static final String EXTENSION_MP4 = ".mp4";
    public static final String EXTENSION_PNG = ".png";
    public static final String EXTENSION_TXT = ".txt";
    public static final String EXTENSION_ZIP = ".zip";
    public static final String FILE_NAME_ANIMATION = "Animation.bin";
    public static final String FILE_NAME_ANIMATION_DEFAULT = "Bone_Animation.bin";
    public static final String FILE_NAME_ANIMATION_WEDDING = "Bone_Animation_Wedding.bin";
    public static final String FILE_NAME_AVATAR_THUMBNAIL = "Avatar_Thumbnail.png";
    public static final String FILE_NAME_BODY_TEXTURE_ARM_THICK = "Part_ArmThick.png";
    public static final String FILE_NAME_BODY_TEXTURE_BUST = "Part_Bust.png";
    public static final String FILE_NAME_BODY_TEXTURE_CALF_LENGTH = "Part_CalfLength.png";
    public static final String FILE_NAME_BODY_TEXTURE_CUP_SIZE = "Part_CupSize.png";
    public static final String FILE_NAME_BODY_TEXTURE_HIP = "Part_Hip.png";
    public static final String FILE_NAME_BODY_TEXTURE_SHOULDER = "Part_Shoulder.png";
    public static final String FILE_NAME_BODY_TEXTURE_THIGH_LENGTH = "Part_ThighLength.png";
    public static final String FILE_NAME_BODY_TEXTURE_THIGH_THICK = "Part_ThighThick.png";
    public static final String FILE_NAME_BODY_TEXTURE_WAIST = "Part_Waist.png";
    public static final String FILE_NAME_BONE_HIERARCHY = "Bone_Hierarchy.bin";
    public static final String FILE_NAME_CAPTURE = "Capture.png";
    public static final String FILE_NAME_CONTROL_ATTRIBUTES = "ControlAttributes.txt";
    public static final String FILE_NAME_CUSTOM_DETECT_CROP_FACE = "Custom_Detect_Crop_Face.png";
    public static final String FILE_NAME_CUSTOM_DETECT_POSITION = "Custom_Detect_Position.bin";
    public static final String FILE_NAME_CUSTOM_TEXTURE = "Texture_Type_Custom.png";
    public static final String FILE_NAME_DESCRIPTION = "Description.txt";
    public static final String FILE_NAME_FORMAT_ANIMATION = "Animation_%s.bin";
    public static final String FILE_NAME_FORMAT_BLEND_TARGET = "Blend_Target_%d.bin";
    public static final String FILE_NAME_FORMAT_CHARACTER_DATA = "CharacterData_%s_%s.dat";
    public static final String FILE_NAME_FORMAT_CLOTH_BASE_MESH = "Cloth%s_Base.bin";
    public static final String FILE_NAME_FORMAT_CLOTH_BLEND_TARGET = "Cloth%s_Tar%s.bin";
    public static final String FILE_NAME_FORMAT_CLOTH_TUCKIN_TARGET = "Cloth%s_Tuckin_Tar%s.bin";
    public static final String FILE_NAME_FORMAT_CUSTOM_MESH_TYPE = "Mesh_Type_%d_Custom.bin";
    public static final String FILE_NAME_FORMAT_VIDEO = "Video_%s.mp4";
    public static final String FILE_NAME_KEYWORD_FORMAT_CUSTOM_MESH_TYPE = "Mesh_Type_%d_Custom";
    public static final String FILE_NAME_MATERIAL_INFO = "MaterialInfo.txt";
    public static final String FILE_NAME_MESH = "Mesh.bin";
    public static final String FILE_NAME_PACKAGE = "package.bin";
    public static final String FILE_NAME_PREFIX_CHARACTER_DATA = "CharacterData";
    public static final String FILE_NAME_PREFIX_VIDEO = "Video_";
    public static final String FILE_NAME_SEPARATOR = "_";
    public static final String FILE_NAME_TEXTURE = "Texture.png";
    public static final String FILE_NAME_TEXTURE_BASE = "Texture_Base.png";
    public static final String FILE_NAME_TEXTURE_BOTTOM_NAKED_JPG = "Texture_bottom_naked.jpg";
    public static final String FILE_NAME_TEXTURE_COLOR = "Texture_Color.png";
    public static final String FILE_NAME_TEXTURE_JPG = "Texture.jpg";
    public static final String FILE_NAME_TEXTURE_NAKED_JPG = "Texture_naked.jpg";
    public static final String FILE_NAME_TEXTURE_SHADE = "Texture_Shading.png";
    public static final String FILE_NAME_TEXTURE_SHADOW = "Texture_Shadow.png";
    public static final String FILE_NAME_TEXTURE_TOP_NAKED_JPG = "Texture_top_naked.jpg";
    public static final String FILE_NAME_THUMBNAIL_NORMAL = "Thumbnail_normal.png";
    public static final String FILE_NAME_THUMBNAIL_SELECTED = "Thumbnail_selected.png";
    public static final String FILE_NAME_VIDEO = "Video.mp4";
    public static final String FITTING_BASE_DATA_FILE_NAME = "DATA_BASE.zip";
    public static final String FITTING_DATA_FILE_NAME = "DATA_V2.zip";
    public static final String FITTING_HAIR_DATA_FILE_NAME = "DATA_HAIR.zip";
    public static final String FITTING_HEAD_DATA_FILE_NAME = "DATA_HEAD.zip";
    public static final String FORMAT_PATH_DEPTH_1 = "%s/%s";
    public static final String FORMAT_QR_ANIMATION_URL = "%s/USER/%s/%s/Animation.bin";
    public static final String FORMAT_QR_CAPTURE_URL = "%s/USER/%s/%s/Capture.png";
    public static final String FORMAT_QR_VIDEO_URL = "%s/USER/%s/%s/Video.mp4";
    public static final String FORMAT_VERIFICATION_CONTENTS_FILE_NAME = "ContentsData_%d.dat";
    public static final int GENDER_MAN = 2;
    public static final String GENDER_MAN_STRING = "man";
    public static final int GENDER_UNISEX = 3;
    public static final String GENDER_UNISEX_STRING = "unisex";
    public static final int GENDER_WOMAN = 1;
    public static final String GENDER_WOMAN_STRING = "woman";
    public static final int ITEM_STATE_DOWNLOADED_DATA = 1;
    public static final int ITEM_STATE_NEED_TO_DOWNLOAD_DATA = 0;
    public static final int ITEM_STATE_NONE_INFO = -1;
    public static final String JSON_KEY_UPDATE_DATE_BASE = "base";
    public static final String JSON_KEY_UPDATE_DATE_HAIR = "hair";
    public static final String JSON_KEY_UPDATE_DATE_HEAD = "head";
    public static final int MODE_ADD_AVATAR = 7;
    public static final int MODE_AVATAR = 1;
    public static final int MODE_AVATAR_BODY_EDITING = 2;
    public static final int MODE_AVATAR_CUSTOM_FACE_EDITING = 6;
    public static final int MODE_AVATAR_FACE_EDITING = 4;
    public static final int MODE_AVATAR_HAIR_EDITING = 3;
    public static final int MODE_AVATAR_SKINTONE_EDITING = 5;
    public static final int MODE_CHECK_CLOTHES_SIZE = 8;
    public static final int MODE_REAL = 0;
    public static final String REAL_VIDEO_BODY_SIZE_CUSTOM = "FREE";
    public static final String REAL_VIDEO_DEFAULT_SIZE_BOY = "160";
    public static final String REAL_VIDEO_DEFAULT_SIZE_GIRL = "130";
    public static final String REAL_VIDEO_DEFAULT_SIZE_MAN = "105";
    public static final String REAL_VIDEO_DEFAULT_SIZE_WOMAN = "44";
    public static final int REAL_VIDEO_ID_NONE = -1;
    public static final String REAL_VIDEO_NONE_DATE = "0";
    public static final int RESULT_CODE_CANCEL = -2;
    public static final int RESULT_CODE_ERROR_CONNECTION = 10;
    public static final int RESULT_CODE_ERROR_EXIST_DATA = 5;
    public static final int RESULT_CODE_ERROR_EXPIRED_DATE = 12;
    public static final int RESULT_CODE_ERROR_FAILED_TO_DETECT = 18;
    public static final int RESULT_CODE_ERROR_FAILED_TO_DETECT_WITH_LOW_SCROE = 19;
    public static final int RESULT_CODE_ERROR_FAILED_TO_DETECT_ZERO_FACE = 20;
    public static final int RESULT_CODE_ERROR_FAILED_TO_SAVE_BITMAP = 17;
    public static final int RESULT_CODE_ERROR_ILLEGAL_STATE = 2;
    public static final int RESULT_CODE_ERROR_INSUFFICIENT_SPACE = 4;
    public static final int RESULT_CODE_ERROR_MALFORMEDURL = 13;
    public static final int RESULT_CODE_ERROR_NETWORK_IO = 14;
    public static final int RESULT_CODE_ERROR_NOT_FOUND_FILE = 16;
    public static final int RESULT_CODE_ERROR_OUT_OF_MEMORY = 15;
    public static final int RESULT_CODE_ERROR_PARAM = 1;
    public static final int RESULT_CODE_ERROR_RESPONSE = 11;
    public static final int RESULT_CODE_ERROR_UNKNOWN = 0;
    public static final int RESULT_CODE_ERROR_WRONG_DATA = 3;
    public static final int RESULT_CODE_OCCURED_EXCEPTION = -3;
    public static final int RESULT_CODE_SUCCESS = -1;
    public static final int STATE_DONE_CHANGE_DEFAULT_REAL_VIDEO = 2;
    public static final int STATE_DOWNLOAD_CHANGE_DEFAULT_REAL_VIDEO = 1;
    public static final int STATE_NONE_CHANGE_DEFAULT_REAL_VIDEO = 0;
    public static final String SYMBOL_TEMP = "_tmp";
    public static final String TAG = "GlobalDefine";
    public static final String TARGET_OS = "Android";
    public static final int THUMBNAIL_HEIGHT = 951;
    public static final int THUMBNAIL_WIDTH = 535;
    public static final String UNITY_CLOTH_DATA_DIRECTORY_NAME = "DAT";
    public static final String UNITY_PREFERENCE_NAME = "net.fxgear.fitnshop.v2.playerprefs";
    public static final String UNITY_REAL_VIDEO_ANIMATION_FILE_FORMAT = "%s_%s_Animation.bin";
    public static final String UNITY_REAL_VIDEO_DATA_DIRECTORY_NAME = "REC";
    public static final int UNITY_REAL_VIDEO_FILE_NAME_COMPONENT_COUNT = 3;
    public static final int UNITY_REAL_VIDEO_GENDER_INDEX = 0;
    public static final String UNITY_REAL_VIDEO_QR_DATA_DIRECTORY_NAME = "USER";
    public static final int UNITY_REAL_VIDEO_SIZE_OR_GUID_INDEX = 1;
    public static final String UNITY_REAL_VIDEO_VERSION_PERFERENCE_FORMAT = "ver_%s_%s";
    public static final String UNITY_REAL_VIDEO_VIDEO_FILE_FORMAT = "%s_%s_Video.mp4";
    public static final String URL_FITTING_DATA_FOLDER = "default/app/";
    public static final String VERIFICATION_FILE_NAME = "vDATA.fx";

    /* renamed from: a  reason: collision with root package name */
    private static String f653a;

    /* renamed from: b  reason: collision with root package name */
    private static String f654b;
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static String h;

    public enum CLOTHES_CATEGORY_TYPE {
        Default,
        TuckIn,
        Swimsuit,
        LongTop,
        Jumpsuit
    }

    public enum ClothesVisualizationOption {
        Color,
        Pressure,
        Tension
    }

    public static class Request {
    }

    public static class Result {
        public Request request;
        public int resultCode;
        public Object resultExtra;
    }

    public static String GetBodyTextureFileName(Context context, int i, int i2, int i3) {
        switch (i) {
            case 1:
                if (i2 != 2) {
                    return FILE_NAME_TEXTURE_JPG;
                }
                switch (i3) {
                    case 1:
                        return FILE_NAME_TEXTURE_TOP_NAKED_JPG;
                    case 2:
                        return FILE_NAME_TEXTURE_BOTTOM_NAKED_JPG;
                    case 3:
                        return FILE_NAME_TEXTURE_NAKED_JPG;
                    default:
                        return FILE_NAME_TEXTURE_JPG;
                }
            case 2:
                if (i2 != 2) {
                    return FILE_NAME_TEXTURE_JPG;
                }
                switch (i3) {
                    case 2:
                    case 3:
                        return FILE_NAME_TEXTURE_NAKED_JPG;
                    default:
                        return FILE_NAME_TEXTURE_JPG;
                }
            default:
                return FILE_NAME_TEXTURE_JPG;
        }
    }

    public static File GetEngineDirectory(Context context) {
        return null;
    }

    public static File GetEngineFaceDirectory(Context context) {
        return null;
    }

    public static String GetFittingDataFileName(int i) {
        switch (i) {
            case 0:
                return FITTING_BASE_DATA_FILE_NAME;
            case 1:
                return FITTING_HAIR_DATA_FILE_NAME;
            case 2:
                return FITTING_HEAD_DATA_FILE_NAME;
            default:
                return null;
        }
    }

    public enum ClothesSize {
        XS,
        S,
        M,
        L,
        XL,
        XXL,
        XXXL;

        public static String getClothesSizeName(ClothesSize clothesSize) {
            switch (clothesSize) {
                case XS:
                case S:
                case M:
                case L:
                case XL:
                    return clothesSize.name();
                case XXL:
                    return "2XL";
                case XXXL:
                    return "3XL";
                default:
                    return null;
            }
        }
    }

    public static File GetRootDirectory(Context context) {
        if (context == null) {
            return null;
        }
        if (f653a != null && f653a.length() > 0) {
            return new File(f653a);
        }
        File file = new File(context.getFilesDir(), DIRECTORY_NAME_ROOT);
        f653a = file.getAbsolutePath();
        return file;
    }

    public static void SetRootDirectory(String str) {
        f653a = str;
    }

    public static void SetRootDirectory(File file) {
        SetRootDirectory(file.getAbsolutePath());
    }

    public static File GetExternalDirectory() {
        return Environment.getExternalStorageDirectory();
    }

    public static File GetTempDirectory(Context context) {
        if (context != null) {
            return new File(GetRootDirectory(context), DIRECTORY_NAME_TEMP);
        }
        return null;
    }

    public static File GetAnimationDirectory(Context context) {
        if (context != null) {
            return new File(GetRootDirectory(context), DIRECTORY_NAME_ANIMATION);
        }
        return null;
    }

    public static File GetAvatarDirectory(Context context) {
        if (context != null) {
            return new File(GetRootDirectory(context), DIRECTORY_NAME_AVATAR);
        }
        return null;
    }

    public static File GetRealDirectory(Context context) {
        if (context != null) {
            return new File(GetRootDirectory(context), DIRECTORY_NAME_REAL);
        }
        return null;
    }

    public static File GetRealDirectory(Context context, int i, int i2) {
        String str;
        if (i == 2) {
            if (i2 == 1) {
                str = DIRECTORY_NAME_BOY;
            } else if (i2 == 2) {
                str = "Man";
            } else {
                Log.e(TAG, "GetRealDirectory(), gender is MAN, undefined age, age = " + i2);
                str = "Man";
            }
        } else if (i != 1) {
            Log.e(TAG, "GetRealDirectory(), gender is undefined, gender = " + i + ", age = " + i2);
            str = DIRECTORY_NAME_WOMAN;
        } else if (i2 == 1) {
            str = DIRECTORY_NAME_GIRL;
        } else if (i2 == 2) {
            str = DIRECTORY_NAME_WOMAN;
        } else {
            Log.e(TAG, "GetRealDirectory(), gender is WOMAN, undefined age, age = " + i2);
            str = DIRECTORY_NAME_WOMAN;
        }
        return new File(GetRealDirectory(context), str);
    }

    public static File GetAvatarCommonDirectory(Context context) {
        if (context != null) {
            return new File(GetAvatarDirectory(context), DIRECTORY_NAME_COMMON);
        }
        return null;
    }

    public static File GetAvatarHeadResourceDirectory(Context context) {
        if (context != null) {
            return new File(GetAvatarCommonDirectory(context), DIRECTORY_NAME_HEAD);
        }
        return null;
    }

    public static File GetAvatarFaceDirectory(Context context, int i, int i2) {
        String str;
        if (context == null) {
            return null;
        }
        if (i == 2) {
            if (i2 == 1) {
                str = DIRECTORY_NAME_BOY;
            } else if (i2 == 2) {
                str = "Man";
            } else {
                Log.e(TAG, "GetAvatarFaceDirectory(), gender is MAN, undefined age, age = " + i2);
                str = "Man";
            }
        } else if (i != 1) {
            Log.e(TAG, "GetAvatarFaceDirectory(), gender is undefined, gender = " + i + ", age = " + i2);
            str = DIRECTORY_NAME_WOMAN;
        } else if (i2 == 1) {
            str = DIRECTORY_NAME_GIRL;
        } else if (i2 == 2) {
            str = DIRECTORY_NAME_WOMAN;
        } else {
            Log.e(TAG, "GetAvatarFaceDirectory(), gender is WOMAN, undefined age, age = " + i2);
            str = DIRECTORY_NAME_WOMAN;
        }
        return new File(String.format("%s" + File.separator + "%s" + File.separator + "%s", new Object[]{GetAvatarDirectory(context).getAbsoluteFile(), str, DIRECTORY_NAME_HEAD}), DIRECTORY_NAME_FACE);
    }

    public static File GetAvatarFaceCommonDirectory(Context context, int i, int i2) {
        return GetAvatarCommonDirectory(context);
    }

    public static String GetClothTargetName(String str) {
        if (str.indexOf("Top") > -1) {
            return str.substring(str.indexOf("Top"), str.length());
        }
        if (str.indexOf(CLOTH_KEYWORD_BOTTOM) > -1) {
            return str.substring(str.indexOf(CLOTH_KEYWORD_BOTTOM), str.length());
        }
        if (str.indexOf(CLOTH_KEYWORD_ONEPIECE) > -1) {
            return str.substring(str.indexOf(CLOTH_KEYWORD_ONEPIECE), str.length());
        }
        if (str.indexOf(CLOTH_KEYWORD_JACKET) > -1) {
            return str.substring(str.indexOf(CLOTH_KEYWORD_JACKET), str.length());
        }
        if (str.indexOf(CLOTH_KEYWORD_COAT) > -1) {
            return str.substring(str.indexOf(CLOTH_KEYWORD_COAT), str.length());
        }
        return null;
    }

    public static File GetClothDirectory(Context context) {
        if (context != null) {
            return new File(GetRootDirectory(context), DIRECTORY_NAME_CLOTH);
        }
        return null;
    }

    public static File GetClothTypeDirectory(Context context, int i, int i2, int i3) {
        String str;
        String str2;
        if (i == 2) {
            if (i2 == 1) {
                str = DIRECTORY_NAME_BOY;
            } else if (i2 == 2) {
                str = "Man";
            } else {
                Log.e(TAG, "GetClothTypeDirectory(), gender is MAN, undefined age, age = " + i2);
                str = "Man";
            }
        } else if (i == 1) {
            if (i2 == 1) {
                str = DIRECTORY_NAME_GIRL;
            } else if (i2 == 2) {
                str = DIRECTORY_NAME_WOMAN;
            } else {
                Log.e(TAG, "GetClothTypeDirectory(), gender is WOMAN, undefined age, age = " + i2);
                str = DIRECTORY_NAME_WOMAN;
            }
        } else if (i2 == 1) {
            str = DIRECTORY_NAME_UNISEX_CHILD;
        } else if (i2 == 2) {
            str = DIRECTORY_NAME_UNISEX_ADULT;
        } else {
            Log.e(TAG, "GetClothTypeDirectory(), gender is UNISEX, undefined age, age = " + i2);
            str = DIRECTORY_NAME_UNISEX_CHILD;
        }
        if (i3 == 0) {
            str2 = "Top";
        } else if (i3 == 1) {
            str2 = DIRECTORY_NAME_BOTTOM;
        } else if (i3 == 2) {
            str2 = DIRECTORY_NAME_ONEPIECE;
        } else if (i3 == 3) {
            str2 = DIRECTORY_NAME_JACKET;
        } else if (i3 == 4) {
            str2 = DIRECTORY_NAME_COAT;
        } else if (i3 == 5) {
            str2 = DIRECTORY_NAME_SHOES;
        } else {
            Log.e(TAG, "GetClothDirectory(), undefined clothType = " + i3);
            str2 = "Top";
        }
        return new File(GetClothDirectory(context).getAbsolutePath() + File.separator + str + File.separator + str2);
    }

    public static CLOTHES_CATEGORY_TYPE GetClothesCategoryType(String str) {
        CLOTHES_CATEGORY_TYPE clothes_category_type;
        CLOTHES_CATEGORY_TYPE clothes_category_type2 = CLOTHES_CATEGORY_TYPE.Default;
        if (str.indexOf(CLOTH_KEYWORD_ONEPIECE) > -1) {
            String substring = str.substring(str.indexOf(CLOTH_KEYWORD_ONEPIECE) + CLOTH_KEYWORD_ONEPIECE.length());
            if (substring.startsWith("9")) {
                return CLOTHES_CATEGORY_TYPE.Swimsuit;
            }
            if (substring.equals("118")) {
                return CLOTHES_CATEGORY_TYPE.Jumpsuit;
            }
            return clothes_category_type2;
        } else if (str.indexOf("Top") <= -1) {
            return (str.indexOf(CLOTH_KEYWORD_BOTTOM) <= -1 || !str.substring(str.indexOf(CLOTH_KEYWORD_BOTTOM) + CLOTH_KEYWORD_BOTTOM.length()).startsWith("9")) ? clothes_category_type2 : CLOTHES_CATEGORY_TYPE.Swimsuit;
        } else {
            String substring2 = str.substring(str.indexOf("Top") + "Top".length());
            if (substring2.startsWith("7")) {
                clothes_category_type = CLOTHES_CATEGORY_TYPE.TuckIn;
            } else if (!substring2.startsWith("011") && !substring2.startsWith("111")) {
                return clothes_category_type2;
            } else {
                clothes_category_type = CLOTHES_CATEGORY_TYPE.LongTop;
            }
            return clothes_category_type;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean CopyFile(java.lang.String r6, java.lang.String r7) throws java.io.IOException {
        /*
            r0 = 0
            if (r6 != 0) goto L_0x000b
            java.lang.String r6 = "GlobalDefine"
            java.lang.String r7 = "CopyFile, sourcePath is null"
            android.util.Log.e(r6, r7)
            return r0
        L_0x000b:
            java.io.File r1 = new java.io.File
            r1.<init>(r7)
            java.io.File r7 = new java.io.File
            r7.<init>(r6)
            boolean r6 = r1.exists()
            if (r6 == 0) goto L_0x001e
            r1.delete()
        L_0x001e:
            r6 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0047 }
            r2.<init>(r7)     // Catch:{ all -> 0x0047 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ all -> 0x0045 }
            r7.<init>(r1)     // Catch:{ all -> 0x0045 }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r6]     // Catch:{ all -> 0x0040 }
        L_0x002d:
            int r3 = r2.read(r1, r0, r6)     // Catch:{ all -> 0x0040 }
            r4 = -1
            if (r3 == r4) goto L_0x0038
            r7.write(r1, r0, r3)     // Catch:{ all -> 0x0040 }
            goto L_0x002d
        L_0x0038:
            r2.close()
            r7.close()
            r6 = 1
            return r6
        L_0x0040:
            r6 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
            goto L_0x0049
        L_0x0045:
            r7 = move-exception
            goto L_0x0049
        L_0x0047:
            r7 = move-exception
            r2 = r6
        L_0x0049:
            if (r2 == 0) goto L_0x004e
            r2.close()
        L_0x004e:
            if (r6 == 0) goto L_0x0053
            r6.close()
        L_0x0053:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.GlobalDefine.CopyFile(java.lang.String, java.lang.String):boolean");
    }

    public static boolean DeleteDirectoryRecursive(String str) {
        Log.i(TAG, "DeleteDirectoryRecursive, path : " + str);
        File file = new File(str);
        if (!file.exists()) {
            Log.e(TAG, "Not found directiry.");
            return false;
        } else if (file.isDirectory()) {
            String[] list = file.list();
            for (int i = 0; i < list.length; i++) {
                String str2 = str + "/" + list[i];
                File file2 = new File(str2);
                if (file2.isDirectory()) {
                    DeleteDirectoryRecursive(str2);
                } else {
                    file2.delete();
                    Log.i(TAG, file2.getName() + " file is delete.");
                }
            }
            file.delete();
            Log.i(TAG, file.getName() + " directory is delete.");
            return true;
        } else {
            Log.e(TAG, "path isn't directory, path :" + str);
            return false;
        }
    }

    public static boolean CopyDirectory(Context context, String str, String str2) {
        File file = new File(str2);
        if (file.exists()) {
            DeleteDirectoryRecursive(str2);
        }
        file.mkdirs();
        String[] list = new File(str).list();
        if (list == null || list.length <= 0) {
            return true;
        }
        int length = list.length;
        int i = 0;
        while (i < length) {
            String name = new File(list[i]).getName();
            try {
                CopyFile(str + File.separator + name, str2 + File.separator + name);
                i++;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public static boolean CopyCustomFaceFiles(Context context, String str, String str2) {
        Log.i(TAG, "CopyCustomFaceFiles()+");
        boolean z = false;
        if (str == null || str2 == null) {
            Log.e(TAG, "[ERROR] :: sourceDirectoryPath or destDirectoryPath is null");
            return false;
        }
        File file = null;
        File file2 = new File(str);
        if (file2.exists() && file2.isDirectory()) {
            String[] GetCustomFaceFile = FittingFaceData.GetCustomFaceFile(file2.getAbsolutePath());
            if (GetCustomFaceFile != null && GetCustomFaceFile.length > 0) {
                file = new File(str2);
                if (file.exists()) {
                    DeleteDirectoryRecursive(str2);
                }
                file.mkdirs();
                int i = 0;
                while (true) {
                    if (i >= GetCustomFaceFile.length) {
                        z = true;
                        break;
                    }
                    String str3 = GetCustomFaceFile[i];
                    if (str3 == null) {
                        if (i != 2) {
                            Log.e(TAG, "[ERROR] :: filePath is null, FittingFaceData index: " + i);
                            break;
                        }
                    } else {
                        File file3 = new File(str3);
                        if (!file3.exists()) {
                            Log.e(TAG, "[ERROR] :: customFaceFile doesn't exist.");
                            break;
                        }
                        try {
                            String name = file3.getName();
                            if (!CopyFile(str + File.separator + name, str2 + File.separator + name)) {
                                Log.e(TAG, "[ERROR] :: fail to copy custom face file");
                                break;
                            }
                        } catch (IOException e2) {
                            Log.e(TAG, "[ERROR] :: IOException, fail to copy custom face file");
                            e2.printStackTrace();
                        }
                    }
                    i++;
                }
            } else {
                Log.e(TAG, "[ERROR] :: source directory doesn't have custom face file.");
            }
        } else {
            Log.e(TAG, "[ERROR] :: source directory doesn't exist.");
        }
        if (!z && file != null && file.exists()) {
            DeleteDirectoryRecursive(str2);
        }
        return z;
    }

    public static File GetClothTypeBaseDirectory(Context context, int i, int i2, int i3) {
        return new File(GetClothTypeDirectory(context, i, i2, i3), DIRECTORY_NAME_BASE);
    }

    public static File GetCharacterDataDirectory(Context context) {
        return new File(GetRootDirectory(context), "CharacterData");
    }

    public static File GetAvatarDataDirectory(Context context) {
        return new File(GetRootDirectory(context), DIRECTORY_NAME_AVATAR_DATA);
    }

    public static File GetAvatarDataDirectory(Context context, int i, int i2, String str) {
        String str2;
        File file = new File(GetRootDirectory(context), DIRECTORY_NAME_AVATAR_DATA);
        if (i == 2) {
            if (i2 == 1) {
                str2 = DIRECTORY_NAME_BOY;
            } else if (i2 == 2) {
                str2 = "Man";
            } else {
                Log.e(TAG, "GetAvatarDataDirectory(), gender is MAN, undefined age, age = " + i2);
                str2 = "Man";
            }
        } else if (i != 1) {
            Log.e(TAG, "GetAvatarDataDirectory(), gender is undefined, gender = " + i + ", age = " + i2);
            str2 = DIRECTORY_NAME_WOMAN;
        } else if (i2 == 1) {
            str2 = DIRECTORY_NAME_GIRL;
        } else if (i2 == 2) {
            str2 = DIRECTORY_NAME_WOMAN;
        } else {
            Log.e(TAG, "GetAvatarDataDirectory(), gender is WOMAN, undefined age, age = " + i2);
            str2 = DIRECTORY_NAME_WOMAN;
        }
        return new File(file.getAbsolutePath() + File.separator + str2 + File.separator + str);
    }

    public static File GetAvatarRuntimeDirectory(Context context) {
        return new File(GetRootDirectory(context).getAbsolutePath() + File.separator + DIRECTORY_NAME_AVATAR_DATA + File.separator + DIRECTORY_NAME_RUNTIME);
    }

    public static String GetCharacterDataFileName(int i, int i2) {
        String str;
        String str2;
        if (i == 1) {
            str = GENDER_WOMAN_STRING;
        } else if (i == 2) {
            str = GENDER_MAN_STRING;
        } else {
            Log.e(TAG, "GetCharacterDataFileName(), gender is undefined, gender = " + i);
            str = GENDER_WOMAN_STRING;
        }
        if (i2 == 1) {
            str2 = AGE_EARLY_STRING;
        } else if (i2 == 2) {
            str2 = AGE_MIDDLE_STRING;
        } else {
            Log.e(TAG, "GetCharacterDataFileName(), age is undefined, age = " + i2);
            str2 = AGE_MIDDLE_STRING;
        }
        return String.format(FILE_NAME_FORMAT_CHARACTER_DATA, new Object[]{str, str2});
    }

    public static File GetBoneAnimationFile(Context context, int i, int i2, int i3) {
        String str;
        String str2;
        if (i == 2) {
            if (i2 == 1) {
                str = DIRECTORY_NAME_BOY;
            } else if (i2 == 2) {
                str = "Man";
            } else {
                Log.e(TAG, "GetBoneAnimationFile(), gender is MAN, undefined age, age = " + i2);
                str = "Man";
            }
        } else if (i != 1) {
            Log.e(TAG, "GetBoneAnimationFile(), gender is undefined, gender = " + i + ", age = " + i2);
            str = DIRECTORY_NAME_WOMAN;
        } else if (i2 == 1) {
            str = DIRECTORY_NAME_GIRL;
        } else if (i2 == 2) {
            str = DIRECTORY_NAME_WOMAN;
        } else {
            Log.e(TAG, "GetBoneAnimationFile(), gender is WOMAN, undefined age, age = " + i2);
            str = DIRECTORY_NAME_WOMAN;
        }
        File file = new File(GetAnimationDirectory(context), str);
        if (!file.exists() || !file.isDirectory()) {
            Log.e(TAG, "[WARNING] Not found directory : " + file.getName());
        } else {
            switch (i3) {
                case 0:
                    str2 = FILE_NAME_ANIMATION_DEFAULT;
                    break;
                case 1:
                    str2 = String.format(FORMAT_PATH_DEPTH_1, new Object[]{DIRECTORY_NAME_SPECIAL_ANIMATIONS, FILE_NAME_ANIMATION_WEDDING});
                    break;
                default:
                    str2 = null;
                    break;
            }
            if (str2 != null) {
                return new File(file, str2);
            }
            Log.e(TAG, "[WARNING] Unknown aniamtion type : " + i3);
        }
        return null;
    }

    public static ArrayList<String> GetBodyTextureFileNames(Context context, int i, int i2) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 <= 3; i3++) {
            String GetBodyTextureFileName = GetBodyTextureFileName(context, i, i2, i3);
            if (!arrayList.contains(GetBodyTextureFileName)) {
                arrayList.add(GetBodyTextureFileName);
            }
        }
        return arrayList;
    }

    public static boolean NeedDefaultRealData(Context context) {
        if (context != null) {
            return context.getSharedPreferences("fitnshop_sdk", 0).getBoolean("default_real_data", true);
        }
        return false;
    }

    public static void SetDefaultRealData(Context context, boolean z) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("fitnshop_sdk", 0).edit();
            edit.putBoolean("default_real_data", z);
            edit.commit();
        }
    }

    public static boolean NeedMigrationUnityData(Context context) {
        if (context != null) {
            return context.getSharedPreferences("fitnshop_sdk", 0).getBoolean("migration_unity_data", true);
        }
        return false;
    }

    public static void SetMigrationUnityData(Context context, boolean z) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("fitnshop_sdk", 0).edit();
            edit.putBoolean("migration_unity_data", z);
            edit.commit();
        }
    }

    public static int GetChangeDefaultRealVideoState(Context context) {
        if (context != null) {
            return context.getSharedPreferences("fitnshop_sdk", 0).getInt("change_default_real_video", 0);
        }
        return 0;
    }

    public static void SetChangeDefaultRealVideoState(Context context, int i) {
        if (context != null && i >= 0 && i <= 2) {
            SharedPreferences.Editor edit = context.getSharedPreferences("fitnshop_sdk", 0).edit();
            edit.putInt("change_default_real_video", i);
            edit.commit();
        }
    }

    public static void SetServerInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        f654b = str;
        d = str2;
        e = str3;
        c = str4;
        f = str5;
        g = str6;
        h = str7;
    }

    public static String GetFittingDataFileURL() {
        switch (0) {
            case 1:
                return "https://dl.dropboxusercontent.com/s/0xysqe9t1tzb6dd/DATA_V2.zip";
            case 2:
                return "https://dl.dropboxusercontent.com/s/0xysqe9t1tzb6dd/DATA_V2.zip";
            case 3:
                return "https://dl.dropboxusercontent.com/s/hqx30wt6w1dg6pq/DATA_V2.zip";
            default:
                return GetFittingDataRootURL() + FITTING_DATA_FILE_NAME;
        }
    }

    public static String GetLegacyApiUrl() {
        return f;
    }

    public static String GetLegacyMirrorQRUrl() {
        return g;
    }

    public static String GetLegacyMirrorDataUrl() {
        return h;
    }

    public static String GetApiURL() {
        return f654b;
    }

    public static String GetDataServerUrl() {
        return c;
    }

    public static String GetDataURL() {
        return c + UNITY_CLOTH_DATA_DIRECTORY_NAME;
    }

    public static String GetFittingDataRootURL() {
        return c + URL_FITTING_DATA_FOLDER;
    }

    public static String GetAccountUUID() {
        return d;
    }

    public static String GetDeviceUUID() {
        return e;
    }

    public static float GetPixelFromDP(Context context, float f2) {
        return TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
    }
}
