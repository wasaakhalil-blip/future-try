

// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\arch\lifecycle\a.java ==========

package android.arch.lifecycle;

/* compiled from: GenericLifecycleObserver */
public interface a {
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\arch\lifecycle\b.java ==========

package android.arch.lifecycle;

/* compiled from: Lifecycle */
public abstract class b {

    /* compiled from: Lifecycle */
    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\arch\lifecycle\c.java ==========

package android.arch.lifecycle;

/* compiled from: LifecycleOwner */
public interface c {
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\arch\lifecycle\d.java ==========

package android.arch.lifecycle;

import android.arch.lifecycle.b;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: OnLifecycleEvent */
public @interface d {
    b.a a();
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\arch\lifecycle\ReflectiveGenericLifecycleObserver.java ==========

package android.arch.lifecycle;

import android.arch.lifecycle.b;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ReflectiveGenericLifecycleObserver implements a {

    /* renamed from: a  reason: collision with root package name */
    static final Map<Class, a> f216a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Object f217b;
    private final a c = a(this.f217b.getClass());

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f217b = obj;
    }

    private static a a(Class cls) {
        a aVar = f216a.get(cls);
        if (aVar != null) {
            return aVar;
        }
        return b(cls);
    }

    private static void a(Map<b, b.a> map, b bVar, b.a aVar, Class cls) {
        b.a aVar2 = map.get(bVar);
        if (aVar2 != null && aVar != aVar2) {
            Method method = bVar.f221b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous" + " value " + aVar2 + ", new value " + aVar);
        } else if (aVar2 == null) {
            map.put(bVar, aVar);
        }
    }

    private static a b(Class cls) {
        int i;
        a a2;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (a2 = a(superclass)) == null)) {
            hashMap.putAll(a2.f219b);
        }
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Class a3 : cls.getInterfaces()) {
            for (Map.Entry next : a(a3).f219b.entrySet()) {
                a(hashMap, (b) next.getKey(), (b.a) next.getValue(), cls);
            }
        }
        for (Method method : declaredMethods) {
            d dVar = (d) method.getAnnotation(d.class);
            if (dVar != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(c.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                b.a a4 = dVar.a();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(b.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (a4 == b.a.ON_ANY) {
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    a(hashMap, new b(i, method), a4, cls);
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        a aVar = new a(hashMap);
        f216a.put(cls, aVar);
        return aVar;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final Map<b.a, List<b>> f218a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map<b, b.a> f219b;

        a(Map<b, b.a> map) {
            this.f219b = map;
            for (Map.Entry next : map.entrySet()) {
                b.a aVar = (b.a) next.getValue();
                List list = this.f218a.get(aVar);
                if (list == null) {
                    list = new ArrayList();
                    this.f218a.put(aVar, list);
                }
                list.add(next.getKey());
            }
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        final int f220a;

        /* renamed from: b  reason: collision with root package name */
        final Method f221b;

        b(int i, Method method) {
            this.f220a = i;
            this.f221b = method;
            this.f221b.setAccessible(true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f220a != bVar.f220a || !this.f221b.getName().equals(bVar.f221b.getName())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f220a * 31) + this.f221b.getName().hashCode();
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\annotation\Keep.java ==========

package android.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PACKAGE, ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
public @interface Keep {
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\a\a.java ==========

package android.support.v4.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;

/* compiled from: ActivityCompat */
public class a extends android.support.v4.b.a {

    /* renamed from: android.support.v4.a.a$a  reason: collision with other inner class name */
    /* compiled from: ActivityCompat */
    public interface C0003a {
        void a(int i, String[] strArr, int[] iArr);
    }

    /* compiled from: ActivityCompat */
    public interface b {
        void a(int i);
    }

    public static void a(final Activity activity, final String[] strArr, final int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof b) {
                ((b) activity).a(i);
            }
            activity.requestPermissions(strArr, i);
        } else if (activity instanceof C0003a) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i = 0; i < length; i++) {
                        iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                    }
                    ((C0003a) activity).a(i, strArr, iArr);
                }
            });
        }
    }

    public static boolean a(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\a\b.java ==========

package android.support.v4.a;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: BundleCompat */
public final class b {

    /* compiled from: BundleCompat */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Method f224a;

        /* renamed from: b  reason: collision with root package name */
        private static boolean f225b;

        public static IBinder a(Bundle bundle, String str) {
            if (!f225b) {
                try {
                    f224a = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                    f224a.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", e);
                }
                f225b = true;
            }
            if (f224a != null) {
                try {
                    return (IBinder) f224a.invoke(bundle, new Object[]{str});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", e2);
                    f224a = null;
                }
            }
            return null;
        }
    }

    public static IBinder a(Bundle bundle, String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            return bundle.getBinder(str);
        }
        return a.a(bundle, str);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\b\a.java ==========

package android.support.v4.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Process;
import android.util.TypedValue;

/* compiled from: ContextCompat */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f226a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static TypedValue f227b;

    public static final Drawable a(Context context, int i) {
        int i2;
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getDrawable(i);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (f226a) {
            if (f227b == null) {
                f227b = new TypedValue();
            }
            context.getResources().getValue(i, f227b, true);
            i2 = f227b.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    public static final int b(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColor(i);
        }
        return context.getResources().getColor(i);
    }

    public static int a(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\c\a.java ==========

package android.support.v4.c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IResultReceiver */
public interface a extends IInterface {
    void a(int i, Bundle bundle) throws RemoteException;

    /* renamed from: android.support.v4.c.a$a  reason: collision with other inner class name */
    /* compiled from: IResultReceiver */
    public static abstract class C0004a extends Binder implements a {
        public IBinder asBinder() {
            return this;
        }

        public C0004a() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0005a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
                a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("android.support.v4.os.IResultReceiver");
                return true;
            }
        }

        /* renamed from: android.support.v4.c.a$a$a  reason: collision with other inner class name */
        /* compiled from: IResultReceiver */
        private static class C0005a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f228a;

            C0005a(IBinder iBinder) {
                this.f228a = iBinder;
            }

            public IBinder asBinder() {
                return this.f228a;
            }

            public void a(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.os.IResultReceiver");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f228a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\c\b.java ==========

package android.support.v4.c;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.c.a;

/* compiled from: ResultReceiver */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() {
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: a */
        public b[] newArray(int i) {
            return new b[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final boolean f229a = false;

    /* renamed from: b  reason: collision with root package name */
    final Handler f230b = null;
    a c;

    /* access modifiers changed from: protected */
    public void a(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: android.support.v4.c.b$b  reason: collision with other inner class name */
    /* compiled from: ResultReceiver */
    class C0006b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final int f232a;

        /* renamed from: b  reason: collision with root package name */
        final Bundle f233b;

        C0006b(int i, Bundle bundle) {
            this.f232a = i;
            this.f233b = bundle;
        }

        public void run() {
            b.this.a(this.f232a, this.f233b);
        }
    }

    /* compiled from: ResultReceiver */
    class a extends a.C0004a {
        a() {
        }

        public void a(int i, Bundle bundle) {
            if (b.this.f230b != null) {
                b.this.f230b.post(new C0006b(i, bundle));
            } else {
                b.this.a(i, bundle);
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.c == null) {
                this.c = new a();
            }
            parcel.writeStrongBinder(this.c.asBinder());
        }
    }

    b(Parcel parcel) {
        this.c = a.C0004a.a(parcel.readStrongBinder());
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\c\c.java ==========

package android.support.v4.c;

import android.os.Build;
import android.os.Trace;

/* compiled from: TraceCompat */
public final class c {
    public static void a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void a() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\d\a.java ==========

package android.support.v4.d;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: ArrayMap */
public class a<K, V> extends g<K, V> implements Map<K, V> {

    /* renamed from: a  reason: collision with root package name */
    d<K, V> f234a;

    private d<K, V> b() {
        if (this.f234a == null) {
            this.f234a = new d<K, V>() {
                /* access modifiers changed from: protected */
                public int a() {
                    return a.this.h;
                }

                /* access modifiers changed from: protected */
                public Object a(int i, int i2) {
                    return a.this.g[(i << 1) + i2];
                }

                /* access modifiers changed from: protected */
                public int a(Object obj) {
                    return a.this.a(obj);
                }

                /* access modifiers changed from: protected */
                public int b(Object obj) {
                    return a.this.b(obj);
                }

                /* access modifiers changed from: protected */
                public Map<K, V> b() {
                    return a.this;
                }

                /* access modifiers changed from: protected */
                public void a(K k, V v) {
                    a.this.put(k, v);
                }

                /* access modifiers changed from: protected */
                public V a(int i, V v) {
                    return a.this.a(i, v);
                }

                /* access modifiers changed from: protected */
                public void a(int i) {
                    a.this.d(i);
                }

                /* access modifiers changed from: protected */
                public void c() {
                    a.this.clear();
                }
            };
        }
        return this.f234a;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        a(this.h + map.size());
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return b().d();
    }

    public Set<K> keySet() {
        return b().e();
    }

    public Collection<V> values() {
        return b().f();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\d\b.java ==========

package android.support.v4.d;

/* compiled from: ContainerHelpers */
class b {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f236a = new int[0];

    /* renamed from: b  reason: collision with root package name */
    static final long[] f237b = new long[0];
    static final Object[] c = new Object[0];

    public static int b(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }

    public static int a(int i) {
        return b(i * 8) / 8;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static int a(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i3 = i5 - 1;
            }
        }
        return i4 ^ -1;
    }

    static int a(long[] jArr, int i, long j) {
        int i2 = i - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            long j2 = jArr[i4];
            if (j2 < j) {
                i3 = i4 + 1;
            } else if (j2 <= j) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return i3 ^ -1;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\d\c.java ==========

package android.support.v4.d;

/* compiled from: LongSparseArray */
public class c<E> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f238a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f239b;
    private long[] c;
    private Object[] d;
    private int e;

    public c() {
        this(10);
    }

    public c(int i) {
        this.f239b = false;
        if (i == 0) {
            this.c = b.f237b;
            this.d = b.c;
        } else {
            int a2 = b.a(i);
            this.c = new long[a2];
            this.d = new Object[a2];
        }
        this.e = 0;
    }

    /* renamed from: a */
    public c<E> clone() {
        try {
            c<E> cVar = (c) super.clone();
            try {
                cVar.c = (long[]) this.c.clone();
                cVar.d = (Object[]) this.d.clone();
                return cVar;
            } catch (CloneNotSupportedException unused) {
                return cVar;
            }
        } catch (CloneNotSupportedException unused2) {
            return null;
        }
    }

    public E a(long j) {
        return a(j, (Object) null);
    }

    public E a(long j, E e2) {
        int a2 = b.a(this.c, this.e, j);
        return (a2 < 0 || this.d[a2] == f238a) ? e2 : this.d[a2];
    }

    public void a(int i) {
        if (this.d[i] != f238a) {
            this.d[i] = f238a;
            this.f239b = true;
        }
    }

    private void d() {
        int i = this.e;
        long[] jArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f238a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f239b = false;
        this.e = i2;
    }

    public void b(long j, E e2) {
        int a2 = b.a(this.c, this.e, j);
        if (a2 >= 0) {
            this.d[a2] = e2;
            return;
        }
        int i = a2 ^ -1;
        if (i >= this.e || this.d[i] != f238a) {
            if (this.f239b && this.e >= this.c.length) {
                d();
                i = b.a(this.c, this.e, j) ^ -1;
            }
            if (this.e >= this.c.length) {
                int a3 = b.a(this.e + 1);
                long[] jArr = new long[a3];
                Object[] objArr = new Object[a3];
                System.arraycopy(this.c, 0, jArr, 0, this.c.length);
                System.arraycopy(this.d, 0, objArr, 0, this.d.length);
                this.c = jArr;
                this.d = objArr;
            }
            if (this.e - i != 0) {
                int i2 = i + 1;
                System.arraycopy(this.c, i, this.c, i2, this.e - i);
                System.arraycopy(this.d, i, this.d, i2, this.e - i);
            }
            this.c[i] = j;
            this.d[i] = e2;
            this.e++;
            return;
        }
        this.c[i] = j;
        this.d[i] = e2;
    }

    public int b() {
        if (this.f239b) {
            d();
        }
        return this.e;
    }

    public long b(int i) {
        if (this.f239b) {
            d();
        }
        return this.c[i];
    }

    public E c(int i) {
        if (this.f239b) {
            d();
        }
        return this.d[i];
    }

    public void c() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.f239b = false;
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(b(i));
            sb.append('=');
            Object c2 = c(i);
            if (c2 != this) {
                sb.append(c2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\d\d.java ==========

package android.support.v4.d;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: MapCollections */
abstract class d<K, V> {

    /* renamed from: b  reason: collision with root package name */
    d<K, V>.b f240b;
    d<K, V>.c c;
    d<K, V>.e d;

    /* access modifiers changed from: protected */
    public abstract int a();

    /* access modifiers changed from: protected */
    public abstract int a(Object obj);

    /* access modifiers changed from: protected */
    public abstract Object a(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract V a(int i, V v);

    /* access modifiers changed from: protected */
    public abstract void a(int i);

    /* access modifiers changed from: protected */
    public abstract void a(K k, V v);

    /* access modifiers changed from: protected */
    public abstract int b(Object obj);

    /* access modifiers changed from: protected */
    public abstract Map<K, V> b();

    /* access modifiers changed from: protected */
    public abstract void c();

    d() {
    }

    /* compiled from: MapCollections */
    final class a<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        final int f241a;

        /* renamed from: b  reason: collision with root package name */
        int f242b;
        int c;
        boolean d = false;

        a(int i) {
            this.f241a = i;
            this.f242b = d.this.a();
        }

        public boolean hasNext() {
            return this.c < this.f242b;
        }

        public T next() {
            if (hasNext()) {
                T a2 = d.this.a(this.c, this.f241a);
                this.c++;
                this.d = true;
                return a2;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.d) {
                this.c--;
                this.f242b--;
                this.d = false;
                d.this.a(this.c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: android.support.v4.d.d$d  reason: collision with other inner class name */
    /* compiled from: MapCollections */
    final class C0007d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        int f245a;

        /* renamed from: b  reason: collision with root package name */
        int f246b;
        boolean c = false;

        C0007d() {
            this.f245a = d.this.a() - 1;
            this.f246b = -1;
        }

        public boolean hasNext() {
            return this.f246b < this.f245a;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.f246b++;
                this.c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.c) {
                d.this.a(this.f246b);
                this.f246b--;
                this.f245a--;
                this.c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public K getKey() {
            if (this.c) {
                return d.this.a(this.f246b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.c) {
                return d.this.a(this.f246b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V setValue(V v) {
            if (this.c) {
                return d.this.a(this.f246b, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                if (!b.a(entry.getKey(), d.this.a(this.f246b, 0)) || !b.a(entry.getValue(), d.this.a(this.f246b, 1))) {
                    return false;
                }
                return true;
            }
        }

        public final int hashCode() {
            int i;
            if (this.c) {
                int i2 = 0;
                Object a2 = d.this.a(this.f246b, 0);
                Object a3 = d.this.a(this.f246b, 1);
                if (a2 == null) {
                    i = 0;
                } else {
                    i = a2.hashCode();
                }
                if (a3 != null) {
                    i2 = a3.hashCode();
                }
                return i ^ i2;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* compiled from: MapCollections */
    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int a2 = d.this.a();
            for (Map.Entry entry : collection) {
                d.this.a(entry.getKey(), entry.getValue());
            }
            return a2 != d.this.a();
        }

        public void clear() {
            d.this.c();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int a2 = d.this.a(entry.getKey());
            if (a2 < 0) {
                return false;
            }
            return b.a(d.this.a(a2, 1), entry.getValue());
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return d.this.a() == 0;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new C0007d();
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return d.this.a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public boolean equals(Object obj) {
            return d.a(this, obj);
        }

        public int hashCode() {
            int i;
            int i2;
            int i3 = 0;
            for (int a2 = d.this.a() - 1; a2 >= 0; a2--) {
                Object a3 = d.this.a(a2, 0);
                Object a4 = d.this.a(a2, 1);
                if (a3 == null) {
                    i = 0;
                } else {
                    i = a3.hashCode();
                }
                if (a4 == null) {
                    i2 = 0;
                } else {
                    i2 = a4.hashCode();
                }
                i3 += i ^ i2;
            }
            return i3;
        }
    }

    /* compiled from: MapCollections */
    final class c implements Set<K> {
        c() {
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            d.this.c();
        }

        public boolean contains(Object obj) {
            return d.this.a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return d.a(d.this.b(), collection);
        }

        public boolean isEmpty() {
            return d.this.a() == 0;
        }

        public Iterator<K> iterator() {
            return new a(0);
        }

        public boolean remove(Object obj) {
            int a2 = d.this.a(obj);
            if (a2 < 0) {
                return false;
            }
            d.this.a(a2);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return d.b(d.this.b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return d.c(d.this.b(), collection);
        }

        public int size() {
            return d.this.a();
        }

        public Object[] toArray() {
            return d.this.b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return d.this.a(tArr, 0);
        }

        public boolean equals(Object obj) {
            return d.a(this, obj);
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            for (int a2 = d.this.a() - 1; a2 >= 0; a2--) {
                Object a3 = d.this.a(a2, 0);
                if (a3 == null) {
                    i = 0;
                } else {
                    i = a3.hashCode();
                }
                i2 += i;
            }
            return i2;
        }
    }

    /* compiled from: MapCollections */
    final class e implements Collection<V> {
        e() {
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            d.this.c();
        }

        public boolean contains(Object obj) {
            return d.this.b(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return d.this.a() == 0;
        }

        public Iterator<V> iterator() {
            return new a(1);
        }

        public boolean remove(Object obj) {
            int b2 = d.this.b(obj);
            if (b2 < 0) {
                return false;
            }
            d.this.a(b2);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int a2 = d.this.a();
            int i = 0;
            boolean z = false;
            while (i < a2) {
                if (collection.contains(d.this.a(i, 1))) {
                    d.this.a(i);
                    i--;
                    a2--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int a2 = d.this.a();
            int i = 0;
            boolean z = false;
            while (i < a2) {
                if (!collection.contains(d.this.a(i, 1))) {
                    d.this.a(i);
                    i--;
                    a2--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return d.this.a();
        }

        public Object[] toArray() {
            return d.this.b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return d.this.a(tArr, 1);
        }
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Object[] b(int i) {
        int a2 = a();
        Object[] objArr = new Object[a2];
        for (int i2 = 0; i2 < a2; i2++) {
            objArr[i2] = a(i2, i);
        }
        return objArr;
    }

    public <T> T[] a(T[] tArr, int i) {
        int a2 = a();
        if (tArr.length < a2) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a2);
        }
        for (int i2 = 0; i2 < a2; i2++) {
            tArr[i2] = a(i2, i);
        }
        if (tArr.length > a2) {
            tArr[a2] = null;
        }
        return tArr;
    }

    public static <T> boolean a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (set.size() != set2.size() || !set.containsAll(set2)) {
                return false;
            }
            return true;
        } catch (NullPointerException unused) {
            return false;
        } catch (ClassCastException unused2) {
            return false;
        }
    }

    public Set<Map.Entry<K, V>> d() {
        if (this.f240b == null) {
            this.f240b = new b();
        }
        return this.f240b;
    }

    public Set<K> e() {
        if (this.c == null) {
            this.c = new c();
        }
        return this.c;
    }

    public Collection<V> f() {
        if (this.d == null) {
            this.d = new e();
        }
        return this.d;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\d\e.java ==========

package android.support.v4.d;

/* compiled from: Pools */
public final class e {

    /* compiled from: Pools */
    public interface a<T> {
        T a();

        boolean a(T t);
    }

    /* compiled from: Pools */
    public static class b<T> implements a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object[] f248a;

        /* renamed from: b  reason: collision with root package name */
        private int f249b;

        public b(int i) {
            if (i > 0) {
                this.f248a = new Object[i];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        public T a() {
            if (this.f249b <= 0) {
                return null;
            }
            int i = this.f249b - 1;
            T t = this.f248a[i];
            this.f248a[i] = null;
            this.f249b--;
            return t;
        }

        public boolean a(T t) {
            if (b(t)) {
                throw new IllegalStateException("Already in the pool!");
            } else if (this.f249b >= this.f248a.length) {
                return false;
            } else {
                this.f248a[this.f249b] = t;
                this.f249b++;
                return true;
            }
        }

        private boolean b(T t) {
            for (int i = 0; i < this.f249b; i++) {
                if (this.f248a[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\d\f.java ==========

package android.support.v4.d;

/* compiled from: Preconditions */
public class f {
    public static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\d\g.java ==========

package android.support.v4.d;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* compiled from: SimpleArrayMap */
public class g<K, V> {

    /* renamed from: b  reason: collision with root package name */
    static Object[] f250b;
    static int c;
    static Object[] d;
    static int e;
    int[] f = b.f236a;
    Object[] g = b.c;
    int h = 0;

    private static int a(int[] iArr, int i, int i2) {
        try {
            return b.a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    /* access modifiers changed from: package-private */
    public int a(Object obj, int i) {
        int i2 = this.h;
        if (i2 == 0) {
            return -1;
        }
        int a2 = a(this.f, i2, i);
        if (a2 < 0 || obj.equals(this.g[a2 << 1])) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f[i3] == i) {
            if (obj.equals(this.g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        int i4 = a2 - 1;
        while (i4 >= 0 && this.f[i4] == i) {
            if (obj.equals(this.g[i4 << 1])) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        int i = this.h;
        if (i == 0) {
            return -1;
        }
        int a2 = a(this.f, i, 0);
        if (a2 < 0 || this.g[a2 << 1] == null) {
            return a2;
        }
        int i2 = a2 + 1;
        while (i2 < i && this.f[i2] == 0) {
            if (this.g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = a2 - 1;
        while (i3 >= 0 && this.f[i3] == 0) {
            if (this.g[i3 << 1] == null) {
                return i3;
            }
            i3--;
        }
        return i2 ^ -1;
    }

    private void e(int i) {
        if (i == 8) {
            synchronized (a.class) {
                if (d != null) {
                    Object[] objArr = d;
                    this.g = objArr;
                    d = (Object[]) objArr[0];
                    this.f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (a.class) {
                if (f250b != null) {
                    Object[] objArr2 = f250b;
                    this.g = objArr2;
                    f250b = (Object[]) objArr2[0];
                    this.f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    c--;
                    return;
                }
            }
        }
        this.f = new int[i];
        this.g = new Object[(i << 1)];
    }

    private static void a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (a.class) {
                if (e < 10) {
                    objArr[0] = d;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    d = objArr;
                    e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (a.class) {
                if (c < 10) {
                    objArr[0] = f250b;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f250b = objArr;
                    c++;
                }
            }
        }
    }

    public void clear() {
        if (this.h > 0) {
            int[] iArr = this.f;
            Object[] objArr = this.g;
            int i = this.h;
            this.f = b.f236a;
            this.g = b.c;
            this.h = 0;
            a(iArr, objArr, i);
        }
        if (this.h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public void a(int i) {
        int i2 = this.h;
        if (this.f.length < i) {
            int[] iArr = this.f;
            Object[] objArr = this.g;
            e(i);
            if (this.h > 0) {
                System.arraycopy(iArr, 0, this.f, 0, i2);
                System.arraycopy(objArr, 0, this.g, 0, i2 << 1);
            }
            a(iArr, objArr, i2);
        }
        if (this.h != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return a(obj) >= 0;
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    /* access modifiers changed from: package-private */
    public int b(Object obj) {
        int i = this.h * 2;
        Object[] objArr = this.g;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return b(obj) >= 0;
    }

    public V get(Object obj) {
        int a2 = a(obj);
        if (a2 >= 0) {
            return this.g[(a2 << 1) + 1];
        }
        return null;
    }

    public K b(int i) {
        return this.g[i << 1];
    }

    public V c(int i) {
        return this.g[(i << 1) + 1];
    }

    public V a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.g[i2];
        this.g[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.h <= 0;
    }

    public V put(K k, V v) {
        int i;
        int i2;
        int i3 = this.h;
        if (k == null) {
            i2 = a();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            i2 = a((Object) k, hashCode);
        }
        if (i2 >= 0) {
            int i4 = (i2 << 1) + 1;
            V v2 = this.g[i4];
            this.g[i4] = v;
            return v2;
        }
        int i5 = i2 ^ -1;
        if (i3 >= this.f.length) {
            int i6 = 4;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i6 = 8;
            }
            int[] iArr = this.f;
            Object[] objArr = this.g;
            e(i6);
            if (i3 == this.h) {
                if (this.f.length > 0) {
                    System.arraycopy(iArr, 0, this.f, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.g, 0, objArr.length);
                }
                a(iArr, objArr, i3);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i5 < i3) {
            int i7 = i5 + 1;
            System.arraycopy(this.f, i5, this.f, i7, i3 - i5);
            System.arraycopy(this.g, i5 << 1, this.g, i7 << 1, (this.h - i5) << 1);
        }
        if (i3 != this.h || i5 >= this.f.length) {
            throw new ConcurrentModificationException();
        }
        this.f[i5] = i;
        int i8 = i5 << 1;
        this.g[i8] = k;
        this.g[i8 + 1] = v;
        this.h++;
        return null;
    }

    public V remove(Object obj) {
        int a2 = a(obj);
        if (a2 >= 0) {
            return d(a2);
        }
        return null;
    }

    public V d(int i) {
        int i2 = i << 1;
        V v = this.g[i2 + 1];
        int i3 = this.h;
        int i4 = 0;
        if (i3 <= 1) {
            a(this.f, this.g, i3);
            this.f = b.f236a;
            this.g = b.c;
        } else {
            int i5 = i3 - 1;
            int i6 = 8;
            if (this.f.length <= 8 || this.h >= this.f.length / 3) {
                if (i < i5) {
                    int i7 = i + 1;
                    int i8 = i5 - i;
                    System.arraycopy(this.f, i7, this.f, i, i8);
                    System.arraycopy(this.g, i7 << 1, this.g, i2, i8 << 1);
                }
                int i9 = i5 << 1;
                this.g[i9] = null;
                this.g[i9 + 1] = null;
            } else {
                if (i3 > 8) {
                    i6 = i3 + (i3 >> 1);
                }
                int[] iArr = this.f;
                Object[] objArr = this.g;
                e(i6);
                if (i3 == this.h) {
                    if (i > 0) {
                        System.arraycopy(iArr, 0, this.f, 0, i);
                        System.arraycopy(objArr, 0, this.g, 0, i2);
                    }
                    if (i < i5) {
                        int i10 = i + 1;
                        int i11 = i5 - i;
                        System.arraycopy(iArr, i10, this.f, i, i11);
                        System.arraycopy(objArr, i10 << 1, this.g, i2, i11 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            i4 = i5;
        }
        if (i3 == this.h) {
            this.h = i4;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public int size() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            int i = 0;
            while (i < this.h) {
                try {
                    Object b2 = b(i);
                    Object c2 = c(i);
                    Object obj2 = gVar.get(b2);
                    if (c2 == null) {
                        if (obj2 != null || !gVar.containsKey(b2)) {
                            return false;
                        }
                    } else if (!c2.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (NullPointerException unused) {
                    return false;
                } catch (ClassCastException unused2) {
                    return false;
                }
            }
            return true;
        } else if (!(obj instanceof Map)) {
            return false;
        } else {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.h) {
                try {
                    Object b3 = b(i2);
                    Object c3 = c(i2);
                    Object obj3 = map.get(b3);
                    if (c3 == null) {
                        if (obj3 != null || !map.containsKey(b3)) {
                            return false;
                        }
                    } else if (!c3.equals(obj3)) {
                        return false;
                    }
                    i2++;
                } catch (NullPointerException unused3) {
                    return false;
                } catch (ClassCastException unused4) {
                    return false;
                }
            }
            return true;
        }
    }

    public int hashCode() {
        int[] iArr = this.f;
        Object[] objArr = this.g;
        int i = this.h;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < i) {
            Object obj = objArr[i3];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i2];
            i2++;
            i3 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.h * 28);
        sb.append('{');
        for (int i = 0; i < this.h; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object b2 = b(i);
            if (b2 != this) {
                sb.append(b2);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object c2 = c(i);
            if (c2 != this) {
                sb.append(c2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\media\a.java ==========

package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

/* compiled from: MediaDescriptionCompatApi21 */
class a {
    public static String a(Object obj) {
        return ((MediaDescription) obj).getMediaId();
    }

    public static CharSequence b(Object obj) {
        return ((MediaDescription) obj).getTitle();
    }

    public static CharSequence c(Object obj) {
        return ((MediaDescription) obj).getSubtitle();
    }

    public static CharSequence d(Object obj) {
        return ((MediaDescription) obj).getDescription();
    }

    public static Bitmap e(Object obj) {
        return ((MediaDescription) obj).getIconBitmap();
    }

    public static Uri f(Object obj) {
        return ((MediaDescription) obj).getIconUri();
    }

    public static Bundle g(Object obj) {
        return ((MediaDescription) obj).getExtras();
    }

    public static void a(Object obj, Parcel parcel, int i) {
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    public static Object a(Parcel parcel) {
        return MediaDescription.CREATOR.createFromParcel(parcel);
    }

    /* renamed from: android.support.v4.media.a$a  reason: collision with other inner class name */
    /* compiled from: MediaDescriptionCompatApi21 */
    static class C0008a {
        public static Object a() {
            return new MediaDescription.Builder();
        }

        public static void a(Object obj, String str) {
            ((MediaDescription.Builder) obj).setMediaId(str);
        }

        public static void a(Object obj, CharSequence charSequence) {
            ((MediaDescription.Builder) obj).setTitle(charSequence);
        }

        public static void b(Object obj, CharSequence charSequence) {
            ((MediaDescription.Builder) obj).setSubtitle(charSequence);
        }

        public static void c(Object obj, CharSequence charSequence) {
            ((MediaDescription.Builder) obj).setDescription(charSequence);
        }

        public static void a(Object obj, Bitmap bitmap) {
            ((MediaDescription.Builder) obj).setIconBitmap(bitmap);
        }

        public static void a(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setIconUri(uri);
        }

        public static void a(Object obj, Bundle bundle) {
            ((MediaDescription.Builder) obj).setExtras(bundle);
        }

        public static Object a(Object obj) {
            return ((MediaDescription.Builder) obj).build();
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\media\b.java ==========

package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;
import android.support.v4.media.a;

/* compiled from: MediaDescriptionCompatApi23 */
class b extends a {
    public static Uri h(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }

    /* compiled from: MediaDescriptionCompatApi23 */
    static class a extends a.C0008a {
        public static void b(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\media\c.java ==========

package android.support.v4.media;

import android.media.MediaMetadata;
import android.os.Parcel;

/* compiled from: MediaMetadataCompatApi21 */
class c {
    public static void a(Object obj, Parcel parcel, int i) {
        ((MediaMetadata) obj).writeToParcel(parcel, i);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\media\MediaBrowserCompat.java ==========

package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class MediaBrowserCompat {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f251a = Log.isLoggable("MediaBrowserCompat", 3);

    public static abstract class a {
        public void a(String str, Bundle bundle, Bundle bundle2) {
        }

        public void b(String str, Bundle bundle, Bundle bundle2) {
        }

        public void c(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    public static abstract class b {
        public void a(MediaItem mediaItem) {
        }

        public void a(String str) {
        }
    }

    public static abstract class c {
        public void a(String str, Bundle bundle) {
        }

        public void a(String str, Bundle bundle, List<MediaItem> list) {
        }
    }

    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() {
            /* renamed from: a */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            /* renamed from: a */
            public MediaItem[] newArray(int i) {
                return new MediaItem[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final int f252a;

        /* renamed from: b  reason: collision with root package name */
        private final MediaDescriptionCompat f253b;

        public int describeContents() {
            return 0;
        }

        MediaItem(Parcel parcel) {
            this.f252a = parcel.readInt();
            this.f253b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f252a);
            this.f253b.writeToParcel(parcel, i);
        }

        public String toString() {
            return "MediaItem{" + "mFlags=" + this.f252a + ", mDescription=" + this.f253b + '}';
        }
    }

    private static class ItemReceiver extends android.support.v4.c.b {
        private final String d;
        private final b e;

        /* access modifiers changed from: protected */
        public void a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i != 0 || bundle == null || !bundle.containsKey("media_item")) {
                this.e.a(this.d);
                return;
            }
            Parcelable parcelable = bundle.getParcelable("media_item");
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                this.e.a((MediaItem) parcelable);
            } else {
                this.e.a(this.d);
            }
        }
    }

    private static class SearchResultReceiver extends android.support.v4.c.b {
        private final String d;
        private final Bundle e;
        private final c f;

        /* access modifiers changed from: protected */
        public void a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i != 0 || bundle == null || !bundle.containsKey("search_results")) {
                this.f.a(this.d, this.e);
                return;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
            ArrayList arrayList = null;
            if (parcelableArray != null) {
                arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaItem) parcelable);
                }
            }
            this.f.a(this.d, this.e, arrayList);
        }
    }

    private static class CustomActionResultReceiver extends android.support.v4.c.b {
        private final String d;
        private final Bundle e;
        private final a f;

        /* access modifiers changed from: protected */
        public void a(int i, Bundle bundle) {
            if (this.f != null) {
                switch (i) {
                    case -1:
                        this.f.c(this.d, this.e, bundle);
                        return;
                    case 0:
                        this.f.b(this.d, this.e, bundle);
                        return;
                    case 1:
                        this.f.a(this.d, this.e, bundle);
                        return;
                    default:
                        Log.w("MediaBrowserCompat", "Unknown result code: " + i + " (extras=" + this.e + ", resultData=" + bundle + ")");
                        return;
                }
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\media\MediaDescriptionCompat.java ==========

package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.a;
import android.support.v4.media.b;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() {
        /* renamed from: a */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            if (Build.VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.a(a.a(parcel));
        }

        /* renamed from: a */
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final String f254a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f255b;
    private final CharSequence c;
    private final CharSequence d;
    private final Bitmap e;
    private final Uri f;
    private final Bundle g;
    private final Uri h;
    private Object i;

    public int describeContents() {
        return 0;
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f254a = str;
        this.f255b = charSequence;
        this.c = charSequence2;
        this.d = charSequence3;
        this.e = bitmap;
        this.f = uri;
        this.g = bundle;
        this.h = uri2;
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f254a = parcel.readString();
        this.f255b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.e = (Bitmap) parcel.readParcelable((ClassLoader) null);
        this.f = (Uri) parcel.readParcelable((ClassLoader) null);
        this.g = parcel.readBundle();
        this.h = (Uri) parcel.readParcelable((ClassLoader) null);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.f254a);
            TextUtils.writeToParcel(this.f255b, parcel, i2);
            TextUtils.writeToParcel(this.c, parcel, i2);
            TextUtils.writeToParcel(this.d, parcel, i2);
            parcel.writeParcelable(this.e, i2);
            parcel.writeParcelable(this.f, i2);
            parcel.writeBundle(this.g);
            parcel.writeParcelable(this.h, i2);
            return;
        }
        a.a(a(), parcel, i2);
    }

    public String toString() {
        return this.f255b + ", " + this.c + ", " + this.d;
    }

    public Object a() {
        if (this.i != null || Build.VERSION.SDK_INT < 21) {
            return this.i;
        }
        Object a2 = a.C0008a.a();
        a.C0008a.a(a2, this.f254a);
        a.C0008a.a(a2, this.f255b);
        a.C0008a.b(a2, this.c);
        a.C0008a.c(a2, this.d);
        a.C0008a.a(a2, this.e);
        a.C0008a.a(a2, this.f);
        Bundle bundle = this.g;
        if (Build.VERSION.SDK_INT < 23 && this.h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.h);
        }
        a.C0008a.a(a2, bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            b.a.b(a2, this.h);
        }
        this.i = a.C0008a.a(a2);
        return this.i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.v4.media.MediaDescriptionCompat a(java.lang.Object r6) {
        /*
            r0 = 0
            if (r6 == 0) goto L_0x0082
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L_0x0082
            android.support.v4.media.MediaDescriptionCompat$a r1 = new android.support.v4.media.MediaDescriptionCompat$a
            r1.<init>()
            java.lang.String r2 = android.support.v4.media.a.a((java.lang.Object) r6)
            r1.a((java.lang.String) r2)
            java.lang.CharSequence r2 = android.support.v4.media.a.b(r6)
            r1.a((java.lang.CharSequence) r2)
            java.lang.CharSequence r2 = android.support.v4.media.a.c(r6)
            r1.b((java.lang.CharSequence) r2)
            java.lang.CharSequence r2 = android.support.v4.media.a.d(r6)
            r1.c(r2)
            android.graphics.Bitmap r2 = android.support.v4.media.a.e(r6)
            r1.a((android.graphics.Bitmap) r2)
            android.net.Uri r2 = android.support.v4.media.a.f(r6)
            r1.a((android.net.Uri) r2)
            android.os.Bundle r2 = android.support.v4.media.a.g(r6)
            if (r2 != 0) goto L_0x0040
            r3 = r0
            goto L_0x0048
        L_0x0040:
            java.lang.String r3 = "android.support.v4.media.description.MEDIA_URI"
            android.os.Parcelable r3 = r2.getParcelable(r3)
            android.net.Uri r3 = (android.net.Uri) r3
        L_0x0048:
            if (r3 == 0) goto L_0x0064
            java.lang.String r4 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r4 = r2.containsKey(r4)
            if (r4 == 0) goto L_0x005a
            int r4 = r2.size()
            r5 = 2
            if (r4 != r5) goto L_0x005a
            goto L_0x0065
        L_0x005a:
            java.lang.String r0 = "android.support.v4.media.description.MEDIA_URI"
            r2.remove(r0)
            java.lang.String r0 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            r2.remove(r0)
        L_0x0064:
            r0 = r2
        L_0x0065:
            r1.a((android.os.Bundle) r0)
            if (r3 == 0) goto L_0x006e
            r1.b((android.net.Uri) r3)
            goto L_0x007b
        L_0x006e:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r0 < r2) goto L_0x007b
            android.net.Uri r0 = android.support.v4.media.b.h(r6)
            r1.b((android.net.Uri) r0)
        L_0x007b:
            android.support.v4.media.MediaDescriptionCompat r0 = r1.a()
            r0.i = r6
            return r0
        L_0x0082:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f256a;

        /* renamed from: b  reason: collision with root package name */
        private CharSequence f257b;
        private CharSequence c;
        private CharSequence d;
        private Bitmap e;
        private Uri f;
        private Bundle g;
        private Uri h;

        public a a(String str) {
            this.f256a = str;
            return this;
        }

        public a a(CharSequence charSequence) {
            this.f257b = charSequence;
            return this;
        }

        public a b(CharSequence charSequence) {
            this.c = charSequence;
            return this;
        }

        public a c(CharSequence charSequence) {
            this.d = charSequence;
            return this;
        }

        public a a(Bitmap bitmap) {
            this.e = bitmap;
            return this;
        }

        public a a(Uri uri) {
            this.f = uri;
            return this;
        }

        public a a(Bundle bundle) {
            this.g = bundle;
            return this;
        }

        public a b(Uri uri) {
            this.h = uri;
            return this;
        }

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f256a, this.f257b, this.c, this.d, this.e, this.f, this.g, this.h);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\media\MediaMetadataCompat.java ==========

package android.support.v4.media;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.d.a;

public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR = new Parcelable.Creator<MediaMetadataCompat>() {
        /* renamed from: a */
        public MediaMetadataCompat createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        /* renamed from: a */
        public MediaMetadataCompat[] newArray(int i) {
            return new MediaMetadataCompat[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    static final a<String, Integer> f258a = new a<>();
    private static final String[] c = {"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
    private static final String[] d = {"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
    private static final String[] e = {"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};

    /* renamed from: b  reason: collision with root package name */
    final Bundle f259b;
    private Object f;

    public int describeContents() {
        return 0;
    }

    static {
        f258a.put("android.media.metadata.TITLE", 1);
        f258a.put("android.media.metadata.ARTIST", 1);
        f258a.put("android.media.metadata.DURATION", 0);
        f258a.put("android.media.metadata.ALBUM", 1);
        f258a.put("android.media.metadata.AUTHOR", 1);
        f258a.put("android.media.metadata.WRITER", 1);
        f258a.put("android.media.metadata.COMPOSER", 1);
        f258a.put("android.media.metadata.COMPILATION", 1);
        f258a.put("android.media.metadata.DATE", 1);
        f258a.put("android.media.metadata.YEAR", 0);
        f258a.put("android.media.metadata.GENRE", 1);
        f258a.put("android.media.metadata.TRACK_NUMBER", 0);
        f258a.put("android.media.metadata.NUM_TRACKS", 0);
        f258a.put("android.media.metadata.DISC_NUMBER", 0);
        f258a.put("android.media.metadata.ALBUM_ARTIST", 1);
        f258a.put("android.media.metadata.ART", 2);
        f258a.put("android.media.metadata.ART_URI", 1);
        f258a.put("android.media.metadata.ALBUM_ART", 2);
        f258a.put("android.media.metadata.ALBUM_ART_URI", 1);
        f258a.put("android.media.metadata.USER_RATING", 3);
        f258a.put("android.media.metadata.RATING", 3);
        f258a.put("android.media.metadata.DISPLAY_TITLE", 1);
        f258a.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        f258a.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        f258a.put("android.media.metadata.DISPLAY_ICON", 2);
        f258a.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        f258a.put("android.media.metadata.MEDIA_ID", 1);
        f258a.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        f258a.put("android.media.metadata.MEDIA_URI", 1);
        f258a.put("android.media.metadata.ADVERTISEMENT", 0);
        f258a.put("android.media.metadata.DOWNLOAD_STATUS", 0);
    }

    MediaMetadataCompat(Parcel parcel) {
        this.f259b = parcel.readBundle();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f259b);
    }

    public static MediaMetadataCompat a(Object obj) {
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        c.a(obj, obtain, 0);
        obtain.setDataPosition(0);
        MediaMetadataCompat createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        createFromParcel.f = obj;
        return createFromParcel;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\media\RatingCompat.java ==========

package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import net.fxgear.GlobalDefine;

public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() {
        /* renamed from: a */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        /* renamed from: a */
        public RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final int f260a;

    /* renamed from: b  reason: collision with root package name */
    private final float f261b;

    RatingCompat(int i, float f) {
        this.f260a = i;
        this.f261b = f;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f260a);
        sb.append(" rating=");
        if (this.f261b < GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
            str = "unrated";
        } else {
            str = String.valueOf(this.f261b);
        }
        sb.append(str);
        return sb.toString();
    }

    public int describeContents() {
        return this.f260a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f260a);
        parcel.writeFloat(this.f261b);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\media\session\a.java ==========

package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import java.util.List;

/* compiled from: IMediaControllerCallback */
public interface a extends IInterface {
    void a() throws RemoteException;

    void a(int i) throws RemoteException;

    void a(Bundle bundle) throws RemoteException;

    void a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException;

    void a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException;

    void a(PlaybackStateCompat playbackStateCompat) throws RemoteException;

    void a(CharSequence charSequence) throws RemoteException;

    void a(String str, Bundle bundle) throws RemoteException;

    void a(List<MediaSessionCompat.QueueItem> list) throws RemoteException;

    void a(boolean z) throws RemoteException;

    void b(int i) throws RemoteException;

    void b(boolean z) throws RemoteException;

    /* renamed from: android.support.v4.media.session.a$a  reason: collision with other inner class name */
    /* compiled from: IMediaControllerCallback */
    public static abstract class C0010a extends Binder implements a {
        public IBinder asBinder() {
            return this;
        }

        public C0010a() {
            attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0011a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: android.support.v4.media.session.PlaybackStateCompat} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: android.support.v4.media.MediaMetadataCompat} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: android.support.v4.media.session.ParcelableVolumeInfo} */
        /* JADX WARNING: type inference failed for: r2v0 */
        /* JADX WARNING: type inference failed for: r2v10, types: [java.lang.CharSequence] */
        /* JADX WARNING: type inference failed for: r2v19 */
        /* JADX WARNING: type inference failed for: r2v20 */
        /* JADX WARNING: type inference failed for: r2v21 */
        /* JADX WARNING: type inference failed for: r2v22 */
        /* JADX WARNING: type inference failed for: r2v23 */
        /* JADX WARNING: type inference failed for: r2v24 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r1 = 1
                if (r4 == r0) goto L_0x00f6
                r0 = 0
                r2 = 0
                switch(r4) {
                    case 1: goto L_0x00da;
                    case 2: goto L_0x00d1;
                    case 3: goto L_0x00b9;
                    case 4: goto L_0x00a1;
                    case 5: goto L_0x0092;
                    case 6: goto L_0x007a;
                    case 7: goto L_0x0062;
                    case 8: goto L_0x004a;
                    case 9: goto L_0x003d;
                    case 10: goto L_0x002d;
                    case 11: goto L_0x001d;
                    case 12: goto L_0x0010;
                    default: goto L_0x000b;
                }
            L_0x000b:
                boolean r4 = super.onTransact(r4, r5, r6, r7)
                return r4
            L_0x0010:
                java.lang.String r4 = "android.support.v4.media.session.IMediaControllerCallback"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                r3.b((int) r4)
                return r1
            L_0x001d:
                java.lang.String r4 = "android.support.v4.media.session.IMediaControllerCallback"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x0029
                r0 = 1
            L_0x0029:
                r3.b((boolean) r0)
                return r1
            L_0x002d:
                java.lang.String r4 = "android.support.v4.media.session.IMediaControllerCallback"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x0039
                r0 = 1
            L_0x0039:
                r3.a((boolean) r0)
                return r1
            L_0x003d:
                java.lang.String r4 = "android.support.v4.media.session.IMediaControllerCallback"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                r3.a((int) r4)
                return r1
            L_0x004a:
                java.lang.String r4 = "android.support.v4.media.session.IMediaControllerCallback"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x005e
                android.os.Parcelable$Creator<android.support.v4.media.session.ParcelableVolumeInfo> r4 = android.support.v4.media.session.ParcelableVolumeInfo.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r2 = r4
                android.support.v4.media.session.ParcelableVolumeInfo r2 = (android.support.v4.media.session.ParcelableVolumeInfo) r2
            L_0x005e:
                r3.a((android.support.v4.media.session.ParcelableVolumeInfo) r2)
                return r1
            L_0x0062:
                java.lang.String r4 = "android.support.v4.media.session.IMediaControllerCallback"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x0076
                android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r2 = r4
                android.os.Bundle r2 = (android.os.Bundle) r2
            L_0x0076:
                r3.a((android.os.Bundle) r2)
                return r1
            L_0x007a:
                java.lang.String r4 = "android.support.v4.media.session.IMediaControllerCallback"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x008e
                android.os.Parcelable$Creator r4 = android.text.TextUtils.CHAR_SEQUENCE_CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r2 = r4
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            L_0x008e:
                r3.a((java.lang.CharSequence) r2)
                return r1
            L_0x0092:
                java.lang.String r4 = "android.support.v4.media.session.IMediaControllerCallback"
                r5.enforceInterface(r4)
                android.os.Parcelable$Creator<android.support.v4.media.session.MediaSessionCompat$QueueItem> r4 = android.support.v4.media.session.MediaSessionCompat.QueueItem.CREATOR
                java.util.ArrayList r4 = r5.createTypedArrayList(r4)
                r3.a((java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem>) r4)
                return r1
            L_0x00a1:
                java.lang.String r4 = "android.support.v4.media.session.IMediaControllerCallback"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x00b5
                android.os.Parcelable$Creator<android.support.v4.media.MediaMetadataCompat> r4 = android.support.v4.media.MediaMetadataCompat.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r2 = r4
                android.support.v4.media.MediaMetadataCompat r2 = (android.support.v4.media.MediaMetadataCompat) r2
            L_0x00b5:
                r3.a((android.support.v4.media.MediaMetadataCompat) r2)
                return r1
            L_0x00b9:
                java.lang.String r4 = "android.support.v4.media.session.IMediaControllerCallback"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x00cd
                android.os.Parcelable$Creator<android.support.v4.media.session.PlaybackStateCompat> r4 = android.support.v4.media.session.PlaybackStateCompat.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r2 = r4
                android.support.v4.media.session.PlaybackStateCompat r2 = (android.support.v4.media.session.PlaybackStateCompat) r2
            L_0x00cd:
                r3.a((android.support.v4.media.session.PlaybackStateCompat) r2)
                return r1
            L_0x00d1:
                java.lang.String r4 = "android.support.v4.media.session.IMediaControllerCallback"
                r5.enforceInterface(r4)
                r3.a()
                return r1
            L_0x00da:
                java.lang.String r4 = "android.support.v4.media.session.IMediaControllerCallback"
                r5.enforceInterface(r4)
                java.lang.String r4 = r5.readString()
                int r6 = r5.readInt()
                if (r6 == 0) goto L_0x00f2
                android.os.Parcelable$Creator r6 = android.os.Bundle.CREATOR
                java.lang.Object r5 = r6.createFromParcel(r5)
                r2 = r5
                android.os.Bundle r2 = (android.os.Bundle) r2
            L_0x00f2:
                r3.a(r4, r2)
                return r1
            L_0x00f6:
                java.lang.String r4 = "android.support.v4.media.session.IMediaControllerCallback"
                r6.writeString(r4)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.a.C0010a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }

        /* renamed from: android.support.v4.media.session.a$a$a  reason: collision with other inner class name */
        /* compiled from: IMediaControllerCallback */
        private static class C0011a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f284a;

            C0011a(IBinder iBinder) {
                this.f284a = iBinder;
            }

            public IBinder asBinder() {
                return this.f284a;
            }

            public void a(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f284a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    this.f284a.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (playbackStateCompat != null) {
                        obtain.writeInt(1);
                        playbackStateCompat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f284a.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (mediaMetadataCompat != null) {
                        obtain.writeInt(1);
                        mediaMetadataCompat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f284a.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeTypedList(list);
                    this.f284a.transact(5, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(CharSequence charSequence) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (charSequence != null) {
                        obtain.writeInt(1);
                        TextUtils.writeToParcel(charSequence, obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f284a.transact(6, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f284a.transact(7, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (parcelableVolumeInfo != null) {
                        obtain.writeInt(1);
                        parcelableVolumeInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f284a.transact(8, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeInt(i);
                    this.f284a.transact(9, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeInt(z ? 1 : 0);
                    this.f284a.transact(10, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void b(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeInt(z ? 1 : 0);
                    this.f284a.transact(11, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeInt(i);
                    this.f284a.transact(12, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\media\session\b.java ==========

package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.List;

/* compiled from: IMediaSession */
public interface b extends IInterface {
    void a(int i) throws RemoteException;

    void a(int i, int i2, String str) throws RemoteException;

    void a(long j) throws RemoteException;

    void a(Uri uri, Bundle bundle) throws RemoteException;

    void a(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException;

    void a(MediaDescriptionCompat mediaDescriptionCompat, int i) throws RemoteException;

    void a(RatingCompat ratingCompat) throws RemoteException;

    void a(RatingCompat ratingCompat, Bundle bundle) throws RemoteException;

    void a(a aVar) throws RemoteException;

    void a(String str, Bundle bundle) throws RemoteException;

    void a(String str, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) throws RemoteException;

    void a(boolean z) throws RemoteException;

    boolean a() throws RemoteException;

    boolean a(KeyEvent keyEvent) throws RemoteException;

    String b() throws RemoteException;

    void b(int i) throws RemoteException;

    void b(int i, int i2, String str) throws RemoteException;

    void b(long j) throws RemoteException;

    void b(Uri uri, Bundle bundle) throws RemoteException;

    void b(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException;

    void b(a aVar) throws RemoteException;

    void b(String str, Bundle bundle) throws RemoteException;

    void b(boolean z) throws RemoteException;

    String c() throws RemoteException;

    void c(int i) throws RemoteException;

    void c(String str, Bundle bundle) throws RemoteException;

    PendingIntent d() throws RemoteException;

    void d(String str, Bundle bundle) throws RemoteException;

    long e() throws RemoteException;

    void e(String str, Bundle bundle) throws RemoteException;

    ParcelableVolumeInfo f() throws RemoteException;

    MediaMetadataCompat g() throws RemoteException;

    PlaybackStateCompat h() throws RemoteException;

    List<MediaSessionCompat.QueueItem> i() throws RemoteException;

    CharSequence j() throws RemoteException;

    Bundle k() throws RemoteException;

    int l() throws RemoteException;

    boolean m() throws RemoteException;

    int n() throws RemoteException;

    boolean o() throws RemoteException;

    int p() throws RemoteException;

    void q() throws RemoteException;

    void r() throws RemoteException;

    void s() throws RemoteException;

    void t() throws RemoteException;

    void u() throws RemoteException;

    void v() throws RemoteException;

    void w() throws RemoteException;

    void x() throws RemoteException;

    /* compiled from: IMediaSession */
    public static abstract class a extends Binder implements b {
        public IBinder asBinder() {
            return this;
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C0012a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: android.view.KeyEvent} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: android.support.v4.media.RatingCompat} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v34, resolved type: android.support.v4.media.MediaDescriptionCompat} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v37, resolved type: android.support.v4.media.MediaDescriptionCompat} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v40, resolved type: android.support.v4.media.MediaDescriptionCompat} */
        /* JADX WARNING: type inference failed for: r1v0 */
        /* JADX WARNING: type inference failed for: r1v43 */
        /* JADX WARNING: type inference failed for: r1v44 */
        /* JADX WARNING: type inference failed for: r1v45 */
        /* JADX WARNING: type inference failed for: r1v46 */
        /* JADX WARNING: type inference failed for: r1v47 */
        /* JADX WARNING: type inference failed for: r1v48 */
        /* JADX WARNING: type inference failed for: r1v49 */
        /* JADX WARNING: type inference failed for: r1v50 */
        /* JADX WARNING: type inference failed for: r1v51 */
        /* JADX WARNING: type inference failed for: r1v52 */
        /* JADX WARNING: type inference failed for: r1v53 */
        /* JADX WARNING: type inference failed for: r1v54 */
        /* JADX WARNING: type inference failed for: r1v55 */
        /* JADX WARNING: type inference failed for: r1v56 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 51
                r1 = 0
                r2 = 1
                if (r4 == r0) goto L_0x042d
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                if (r4 == r0) goto L_0x0427
                r0 = 0
                switch(r4) {
                    case 1: goto L_0x03f8;
                    case 2: goto L_0x03d9;
                    case 3: goto L_0x03c5;
                    case 4: goto L_0x03b1;
                    case 5: goto L_0x03a1;
                    case 6: goto L_0x0391;
                    case 7: goto L_0x0381;
                    case 8: goto L_0x0368;
                    case 9: goto L_0x0358;
                    case 10: goto L_0x033f;
                    case 11: goto L_0x0327;
                    case 12: goto L_0x030f;
                    case 13: goto L_0x0303;
                    case 14: goto L_0x02e4;
                    case 15: goto L_0x02c5;
                    case 16: goto L_0x029a;
                    case 17: goto L_0x028a;
                    case 18: goto L_0x027e;
                    case 19: goto L_0x0272;
                    case 20: goto L_0x0266;
                    case 21: goto L_0x025a;
                    case 22: goto L_0x024e;
                    case 23: goto L_0x0242;
                    case 24: goto L_0x0232;
                    case 25: goto L_0x0217;
                    case 26: goto L_0x01f8;
                    case 27: goto L_0x01df;
                    case 28: goto L_0x01c6;
                    case 29: goto L_0x01b6;
                    case 30: goto L_0x019d;
                    case 31: goto L_0x0184;
                    case 32: goto L_0x0174;
                    case 33: goto L_0x0168;
                    case 34: goto L_0x0149;
                    case 35: goto L_0x012a;
                    case 36: goto L_0x00ff;
                    case 37: goto L_0x00ef;
                    case 38: goto L_0x00df;
                    case 39: goto L_0x00cf;
                    case 40: goto L_0x00bc;
                    case 41: goto L_0x00a1;
                    case 42: goto L_0x0082;
                    case 43: goto L_0x0067;
                    case 44: goto L_0x0057;
                    case 45: goto L_0x0047;
                    case 46: goto L_0x0034;
                    case 47: goto L_0x0024;
                    case 48: goto L_0x0014;
                    default: goto L_0x000f;
                }
            L_0x000f:
                boolean r4 = super.onTransact(r4, r5, r6, r7)
                return r4
            L_0x0014:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                r3.c(r4)
                r6.writeNoException()
                return r2
            L_0x0024:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                int r4 = r3.p()
                r6.writeNoException()
                r6.writeInt(r4)
                return r2
            L_0x0034:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x0040
                r0 = 1
            L_0x0040:
                r3.a((boolean) r0)
                r6.writeNoException()
                return r2
            L_0x0047:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                boolean r4 = r3.m()
                r6.writeNoException()
                r6.writeInt(r4)
                return r2
            L_0x0057:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                r3.a((int) r4)
                r6.writeNoException()
                return r2
            L_0x0067:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x007b
                android.os.Parcelable$Creator<android.support.v4.media.MediaDescriptionCompat> r4 = android.support.v4.media.MediaDescriptionCompat.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r1 = r4
                android.support.v4.media.MediaDescriptionCompat r1 = (android.support.v4.media.MediaDescriptionCompat) r1
            L_0x007b:
                r3.b((android.support.v4.media.MediaDescriptionCompat) r1)
                r6.writeNoException()
                return r2
            L_0x0082:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x0096
                android.os.Parcelable$Creator<android.support.v4.media.MediaDescriptionCompat> r4 = android.support.v4.media.MediaDescriptionCompat.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r1 = r4
                android.support.v4.media.MediaDescriptionCompat r1 = (android.support.v4.media.MediaDescriptionCompat) r1
            L_0x0096:
                int r4 = r5.readInt()
                r3.a((android.support.v4.media.MediaDescriptionCompat) r1, (int) r4)
                r6.writeNoException()
                return r2
            L_0x00a1:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x00b5
                android.os.Parcelable$Creator<android.support.v4.media.MediaDescriptionCompat> r4 = android.support.v4.media.MediaDescriptionCompat.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r1 = r4
                android.support.v4.media.MediaDescriptionCompat r1 = (android.support.v4.media.MediaDescriptionCompat) r1
            L_0x00b5:
                r3.a((android.support.v4.media.MediaDescriptionCompat) r1)
                r6.writeNoException()
                return r2
            L_0x00bc:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x00c8
                r0 = 1
            L_0x00c8:
                r3.b((boolean) r0)
                r6.writeNoException()
                return r2
            L_0x00cf:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                r3.b((int) r4)
                r6.writeNoException()
                return r2
            L_0x00df:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                boolean r4 = r3.o()
                r6.writeNoException()
                r6.writeInt(r4)
                return r2
            L_0x00ef:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                int r4 = r3.n()
                r6.writeNoException()
                r6.writeInt(r4)
                return r2
            L_0x00ff:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x0113
                android.os.Parcelable$Creator r4 = android.net.Uri.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                android.net.Uri r4 = (android.net.Uri) r4
                goto L_0x0114
            L_0x0113:
                r4 = r1
            L_0x0114:
                int r7 = r5.readInt()
                if (r7 == 0) goto L_0x0123
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r5 = r7.createFromParcel(r5)
                r1 = r5
                android.os.Bundle r1 = (android.os.Bundle) r1
            L_0x0123:
                r3.a((android.net.Uri) r4, (android.os.Bundle) r1)
                r6.writeNoException()
                return r2
            L_0x012a:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                java.lang.String r4 = r5.readString()
                int r7 = r5.readInt()
                if (r7 == 0) goto L_0x0142
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r5 = r7.createFromParcel(r5)
                r1 = r5
                android.os.Bundle r1 = (android.os.Bundle) r1
            L_0x0142:
                r3.b((java.lang.String) r4, (android.os.Bundle) r1)
                r6.writeNoException()
                return r2
            L_0x0149:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                java.lang.String r4 = r5.readString()
                int r7 = r5.readInt()
                if (r7 == 0) goto L_0x0161
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r5 = r7.createFromParcel(r5)
                r1 = r5
                android.os.Bundle r1 = (android.os.Bundle) r1
            L_0x0161:
                r3.a((java.lang.String) r4, (android.os.Bundle) r1)
                r6.writeNoException()
                return r2
            L_0x0168:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                r3.q()
                r6.writeNoException()
                return r2
            L_0x0174:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                int r4 = r3.l()
                r6.writeNoException()
                r6.writeInt(r4)
                return r2
            L_0x0184:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                android.os.Bundle r4 = r3.k()
                r6.writeNoException()
                if (r4 == 0) goto L_0x0199
                r6.writeInt(r2)
                r4.writeToParcel(r6, r2)
                goto L_0x019c
            L_0x0199:
                r6.writeInt(r0)
            L_0x019c:
                return r2
            L_0x019d:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                java.lang.CharSequence r4 = r3.j()
                r6.writeNoException()
                if (r4 == 0) goto L_0x01b2
                r6.writeInt(r2)
                android.text.TextUtils.writeToParcel(r4, r6, r2)
                goto L_0x01b5
            L_0x01b2:
                r6.writeInt(r0)
            L_0x01b5:
                return r2
            L_0x01b6:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                java.util.List r4 = r3.i()
                r6.writeNoException()
                r6.writeTypedList(r4)
                return r2
            L_0x01c6:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                android.support.v4.media.session.PlaybackStateCompat r4 = r3.h()
                r6.writeNoException()
                if (r4 == 0) goto L_0x01db
                r6.writeInt(r2)
                r4.writeToParcel(r6, r2)
                goto L_0x01de
            L_0x01db:
                r6.writeInt(r0)
            L_0x01de:
                return r2
            L_0x01df:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                android.support.v4.media.MediaMetadataCompat r4 = r3.g()
                r6.writeNoException()
                if (r4 == 0) goto L_0x01f4
                r6.writeInt(r2)
                r4.writeToParcel(r6, r2)
                goto L_0x01f7
            L_0x01f4:
                r6.writeInt(r0)
            L_0x01f7:
                return r2
            L_0x01f8:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                java.lang.String r4 = r5.readString()
                int r7 = r5.readInt()
                if (r7 == 0) goto L_0x0210
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r5 = r7.createFromParcel(r5)
                r1 = r5
                android.os.Bundle r1 = (android.os.Bundle) r1
            L_0x0210:
                r3.e(r4, r1)
                r6.writeNoException()
                return r2
            L_0x0217:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x022b
                android.os.Parcelable$Creator<android.support.v4.media.RatingCompat> r4 = android.support.v4.media.RatingCompat.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r1 = r4
                android.support.v4.media.RatingCompat r1 = (android.support.v4.media.RatingCompat) r1
            L_0x022b:
                r3.a((android.support.v4.media.RatingCompat) r1)
                r6.writeNoException()
                return r2
            L_0x0232:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                long r4 = r5.readLong()
                r3.b((long) r4)
                r6.writeNoException()
                return r2
            L_0x0242:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                r3.x()
                r6.writeNoException()
                return r2
            L_0x024e:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                r3.w()
                r6.writeNoException()
                return r2
            L_0x025a:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                r3.v()
                r6.writeNoException()
                return r2
            L_0x0266:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                r3.u()
                r6.writeNoException()
                return r2
            L_0x0272:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                r3.t()
                r6.writeNoException()
                return r2
            L_0x027e:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                r3.s()
                r6.writeNoException()
                return r2
            L_0x028a:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                long r4 = r5.readLong()
                r3.a((long) r4)
                r6.writeNoException()
                return r2
            L_0x029a:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x02ae
                android.os.Parcelable$Creator r4 = android.net.Uri.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                android.net.Uri r4 = (android.net.Uri) r4
                goto L_0x02af
            L_0x02ae:
                r4 = r1
            L_0x02af:
                int r7 = r5.readInt()
                if (r7 == 0) goto L_0x02be
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r5 = r7.createFromParcel(r5)
                r1 = r5
                android.os.Bundle r1 = (android.os.Bundle) r1
            L_0x02be:
                r3.b((android.net.Uri) r4, (android.os.Bundle) r1)
                r6.writeNoException()
                return r2
            L_0x02c5:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                java.lang.String r4 = r5.readString()
                int r7 = r5.readInt()
                if (r7 == 0) goto L_0x02dd
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r5 = r7.createFromParcel(r5)
                r1 = r5
                android.os.Bundle r1 = (android.os.Bundle) r1
            L_0x02dd:
                r3.d(r4, r1)
                r6.writeNoException()
                return r2
            L_0x02e4:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                java.lang.String r4 = r5.readString()
                int r7 = r5.readInt()
                if (r7 == 0) goto L_0x02fc
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r5 = r7.createFromParcel(r5)
                r1 = r5
                android.os.Bundle r1 = (android.os.Bundle) r1
            L_0x02fc:
                r3.c(r4, r1)
                r6.writeNoException()
                return r2
            L_0x0303:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                r3.r()
                r6.writeNoException()
                return r2
            L_0x030f:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                int r7 = r5.readInt()
                java.lang.String r5 = r5.readString()
                r3.b(r4, r7, r5)
                r6.writeNoException()
                return r2
            L_0x0327:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                int r7 = r5.readInt()
                java.lang.String r5 = r5.readString()
                r3.a((int) r4, (int) r7, (java.lang.String) r5)
                r6.writeNoException()
                return r2
            L_0x033f:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                android.support.v4.media.session.ParcelableVolumeInfo r4 = r3.f()
                r6.writeNoException()
                if (r4 == 0) goto L_0x0354
                r6.writeInt(r2)
                r4.writeToParcel(r6, r2)
                goto L_0x0357
            L_0x0354:
                r6.writeInt(r0)
            L_0x0357:
                return r2
            L_0x0358:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                long r4 = r3.e()
                r6.writeNoException()
                r6.writeLong(r4)
                return r2
            L_0x0368:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                android.app.PendingIntent r4 = r3.d()
                r6.writeNoException()
                if (r4 == 0) goto L_0x037d
                r6.writeInt(r2)
                r4.writeToParcel(r6, r2)
                goto L_0x0380
            L_0x037d:
                r6.writeInt(r0)
            L_0x0380:
                return r2
            L_0x0381:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                java.lang.String r4 = r3.c()
                r6.writeNoException()
                r6.writeString(r4)
                return r2
            L_0x0391:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                java.lang.String r4 = r3.b()
                r6.writeNoException()
                r6.writeString(r4)
                return r2
            L_0x03a1:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                boolean r4 = r3.a()
                r6.writeNoException()
                r6.writeInt(r4)
                return r2
            L_0x03b1:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                android.os.IBinder r4 = r5.readStrongBinder()
                android.support.v4.media.session.a r4 = android.support.v4.media.session.a.C0010a.a(r4)
                r3.b((android.support.v4.media.session.a) r4)
                r6.writeNoException()
                return r2
            L_0x03c5:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                android.os.IBinder r4 = r5.readStrongBinder()
                android.support.v4.media.session.a r4 = android.support.v4.media.session.a.C0010a.a(r4)
                r3.a((android.support.v4.media.session.a) r4)
                r6.writeNoException()
                return r2
            L_0x03d9:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x03ed
                android.os.Parcelable$Creator r4 = android.view.KeyEvent.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r1 = r4
                android.view.KeyEvent r1 = (android.view.KeyEvent) r1
            L_0x03ed:
                boolean r4 = r3.a((android.view.KeyEvent) r1)
                r6.writeNoException()
                r6.writeInt(r4)
                return r2
            L_0x03f8:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                java.lang.String r4 = r5.readString()
                int r7 = r5.readInt()
                if (r7 == 0) goto L_0x0410
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r7 = r7.createFromParcel(r5)
                android.os.Bundle r7 = (android.os.Bundle) r7
                goto L_0x0411
            L_0x0410:
                r7 = r1
            L_0x0411:
                int r0 = r5.readInt()
                if (r0 == 0) goto L_0x0420
                android.os.Parcelable$Creator<android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper> r0 = android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper.CREATOR
                java.lang.Object r5 = r0.createFromParcel(r5)
                r1 = r5
                android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper r1 = (android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper) r1
            L_0x0420:
                r3.a((java.lang.String) r4, (android.os.Bundle) r7, (android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper) r1)
                r6.writeNoException()
                return r2
            L_0x0427:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r6.writeString(r4)
                return r2
            L_0x042d:
                java.lang.String r4 = "android.support.v4.media.session.IMediaSession"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x0441
                android.os.Parcelable$Creator<android.support.v4.media.RatingCompat> r4 = android.support.v4.media.RatingCompat.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                android.support.v4.media.RatingCompat r4 = (android.support.v4.media.RatingCompat) r4
                goto L_0x0442
            L_0x0441:
                r4 = r1
            L_0x0442:
                int r7 = r5.readInt()
                if (r7 == 0) goto L_0x0451
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r5 = r7.createFromParcel(r5)
                r1 = r5
                android.os.Bundle r1 = (android.os.Bundle) r1
            L_0x0451:
                r3.a((android.support.v4.media.RatingCompat) r4, (android.os.Bundle) r1)
                r6.writeNoException()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.b.a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }

        /* renamed from: android.support.v4.media.session.b$a$a  reason: collision with other inner class name */
        /* compiled from: IMediaSession */
        private static class C0012a implements b {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f285a;

            C0012a(IBinder iBinder) {
                this.f285a = iBinder;
            }

            public IBinder asBinder() {
                return this.f285a;
            }

            public void a(String str, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (resultReceiverWrapper != null) {
                        obtain.writeInt(1);
                        resultReceiverWrapper.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f285a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean a(KeyEvent keyEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    boolean z = true;
                    if (keyEvent != null) {
                        obtain.writeInt(1);
                        keyEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f285a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f285a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f285a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    boolean z = false;
                    this.f285a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f285a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f285a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public PendingIntent d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f285a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public long e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f285a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ParcelableVolumeInfo f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f285a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? ParcelableVolumeInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.f285a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.f285a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public MediaMetadataCompat g() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f285a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? MediaMetadataCompat.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public PlaybackStateCompat h() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f285a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? PlaybackStateCompat.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<MediaSessionCompat.QueueItem> i() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f285a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public CharSequence j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f285a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle k() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f285a.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int l() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f285a.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean m() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    boolean z = false;
                    this.f285a.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int n() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f285a.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean o() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    boolean z = false;
                    this.f285a.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int p() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f285a.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (mediaDescriptionCompat != null) {
                        obtain.writeInt(1);
                        mediaDescriptionCompat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f285a.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(MediaDescriptionCompat mediaDescriptionCompat, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (mediaDescriptionCompat != null) {
                        obtain.writeInt(1);
                        mediaDescriptionCompat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.f285a.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (mediaDescriptionCompat != null) {
                        obtain.writeInt(1);
                        mediaDescriptionCompat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f285a.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeInt(i);
                    this.f285a.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void q() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f285a.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f285a.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f285a.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(Uri uri, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f285a.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void r() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f285a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f285a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void d(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f285a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(Uri uri, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f285a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeLong(j);
                    this.f285a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void s() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f285a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void t() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f285a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void u() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f285a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void v() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f285a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void w() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f285a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void x() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f285a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeLong(j);
                    this.f285a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(RatingCompat ratingCompat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (ratingCompat != null) {
                        obtain.writeInt(1);
                        ratingCompat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f285a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (ratingCompat != null) {
                        obtain.writeInt(1);
                        ratingCompat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f285a.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeInt(z ? 1 : 0);
                    this.f285a.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeInt(i);
                    this.f285a.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeInt(z ? 1 : 0);
                    this.f285a.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeInt(i);
                    this.f285a.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void e(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f285a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\media\session\c.java ==========

package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;
import net.fxgear.GlobalDefine;

/* compiled from: MediaControllerCompatApi21 */
class c {

    /* compiled from: MediaControllerCompatApi21 */
    public interface a {
        void a();

        void a(int i, int i2, int i3, int i4, int i5);

        void a(Bundle bundle);

        void a(CharSequence charSequence);

        void a(Object obj);

        void a(String str, Bundle bundle);

        void a(List<?> list);

        void b(Object obj);
    }

    public static Object a(a aVar) {
        return new b(aVar);
    }

    /* renamed from: android.support.v4.media.session.c$c  reason: collision with other inner class name */
    /* compiled from: MediaControllerCompatApi21 */
    public static class C0013c {
        public static AudioAttributes a(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getAudioAttributes();
        }

        public static int b(Object obj) {
            return a(a(obj));
        }

        private static int a(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            switch (audioAttributes.getUsage()) {
                case 1:
                case 11:
                case 12:
                case 14:
                    return 3;
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                case GlobalDefine.RESULT_CODE_ERROR_MALFORMEDURL /*13*/:
                    return 1;
                default:
                    return 3;
            }
        }
    }

    /* compiled from: MediaControllerCompatApi21 */
    static class b<T extends a> extends MediaController.Callback {

        /* renamed from: a  reason: collision with root package name */
        protected final T f286a;

        public b(T t) {
            this.f286a = t;
        }

        public void onSessionDestroyed() {
            this.f286a.a();
        }

        public void onSessionEvent(String str, Bundle bundle) {
            this.f286a.a(str, bundle);
        }

        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.f286a.a((Object) playbackState);
        }

        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.f286a.b(mediaMetadata);
        }

        public void onQueueChanged(List<MediaSession.QueueItem> list) {
            this.f286a.a((List<?>) list);
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
            this.f286a.a(charSequence);
        }

        public void onExtrasChanged(Bundle bundle) {
            this.f286a.a(bundle);
        }

        public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            this.f286a.a(playbackInfo.getPlaybackType(), C0013c.b(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\media\session\d.java ==========

package android.support.v4.media.session;

import android.media.session.MediaSession;

/* compiled from: MediaSessionCompatApi21 */
class d {

    /* compiled from: MediaSessionCompatApi21 */
    static class a {
        public static Object a(Object obj) {
            return ((MediaSession.QueueItem) obj).getDescription();
        }

        public static long b(Object obj) {
            return ((MediaSession.QueueItem) obj).getQueueId();
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\media\session\e.java ==========

package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

/* compiled from: PlaybackStateCompatApi21 */
class e {
    public static int a(Object obj) {
        return ((PlaybackState) obj).getState();
    }

    public static long b(Object obj) {
        return ((PlaybackState) obj).getPosition();
    }

    public static long c(Object obj) {
        return ((PlaybackState) obj).getBufferedPosition();
    }

    public static float d(Object obj) {
        return ((PlaybackState) obj).getPlaybackSpeed();
    }

    public static long e(Object obj) {
        return ((PlaybackState) obj).getActions();
    }

    public static CharSequence f(Object obj) {
        return ((PlaybackState) obj).getErrorMessage();
    }

    public static long g(Object obj) {
        return ((PlaybackState) obj).getLastPositionUpdateTime();
    }

    public static List<Object> h(Object obj) {
        return ((PlaybackState) obj).getCustomActions();
    }

    public static long i(Object obj) {
        return ((PlaybackState) obj).getActiveQueueItemId();
    }

    /* compiled from: PlaybackStateCompatApi21 */
    static final class a {
        public static String a(Object obj) {
            return ((PlaybackState.CustomAction) obj).getAction();
        }

        public static CharSequence b(Object obj) {
            return ((PlaybackState.CustomAction) obj).getName();
        }

        public static int c(Object obj) {
            return ((PlaybackState.CustomAction) obj).getIcon();
        }

        public static Bundle d(Object obj) {
            return ((PlaybackState.CustomAction) obj).getExtras();
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\media\session\f.java ==========

package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;

/* compiled from: PlaybackStateCompatApi22 */
class f {
    public static Bundle a(Object obj) {
        return ((PlaybackState) obj).getExtras();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\media\session\MediaControllerCompat.java ==========

package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.b;
import android.support.v4.media.session.c;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

public final class MediaControllerCompat {

    public static abstract class a implements IBinder.DeathRecipient {

        /* renamed from: a  reason: collision with root package name */
        C0009a f265a;

        /* renamed from: b  reason: collision with root package name */
        boolean f266b;
        private final Object c;

        public void a() {
        }

        public void a(int i) {
        }

        public void a(Bundle bundle) {
        }

        public void a(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void a(b bVar) {
        }

        public void a(PlaybackStateCompat playbackStateCompat) {
        }

        public void a(CharSequence charSequence) {
        }

        public void a(String str, Bundle bundle) {
        }

        public void a(List<MediaSessionCompat.QueueItem> list) {
        }

        public void a(boolean z) {
        }

        public void b(int i) {
        }

        @Deprecated
        public void b(boolean z) {
        }

        public a() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.c = c.a(new b(this));
            } else {
                this.c = new c(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i, Object obj, Bundle bundle) {
            if (this.f265a != null) {
                Message obtainMessage = this.f265a.obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        private static class b implements c.a {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<a> f269a;

            b(a aVar) {
                this.f269a = new WeakReference<>(aVar);
            }

            public void a() {
                a aVar = (a) this.f269a.get();
                if (aVar != null) {
                    aVar.a();
                }
            }

            public void a(String str, Bundle bundle) {
                a aVar = (a) this.f269a.get();
                if (aVar == null) {
                    return;
                }
                if (!aVar.f266b || Build.VERSION.SDK_INT >= 23) {
                    aVar.a(str, bundle);
                }
            }

            public void a(Object obj) {
                a aVar = (a) this.f269a.get();
                if (aVar != null && !aVar.f266b) {
                    aVar.a(PlaybackStateCompat.a(obj));
                }
            }

            public void b(Object obj) {
                a aVar = (a) this.f269a.get();
                if (aVar != null) {
                    aVar.a(MediaMetadataCompat.a(obj));
                }
            }

            public void a(List<?> list) {
                a aVar = (a) this.f269a.get();
                if (aVar != null) {
                    aVar.a(MediaSessionCompat.QueueItem.a(list));
                }
            }

            public void a(CharSequence charSequence) {
                a aVar = (a) this.f269a.get();
                if (aVar != null) {
                    aVar.a(charSequence);
                }
            }

            public void a(Bundle bundle) {
                a aVar = (a) this.f269a.get();
                if (aVar != null) {
                    aVar.a(bundle);
                }
            }

            public void a(int i, int i2, int i3, int i4, int i5) {
                a aVar = (a) this.f269a.get();
                if (aVar != null) {
                    aVar.a(new b(i, i2, i3, i4, i5));
                }
            }
        }

        private static class c extends a.C0010a {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<a> f270a;

            c(a aVar) {
                this.f270a = new WeakReference<>(aVar);
            }

            public void a(String str, Bundle bundle) throws RemoteException {
                a aVar = (a) this.f270a.get();
                if (aVar != null) {
                    aVar.a(1, str, bundle);
                }
            }

            public void a() throws RemoteException {
                a aVar = (a) this.f270a.get();
                if (aVar != null) {
                    aVar.a(8, (Object) null, (Bundle) null);
                }
            }

            public void a(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                a aVar = (a) this.f270a.get();
                if (aVar != null) {
                    aVar.a(2, playbackStateCompat, (Bundle) null);
                }
            }

            public void a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                a aVar = (a) this.f270a.get();
                if (aVar != null) {
                    aVar.a(3, mediaMetadataCompat, (Bundle) null);
                }
            }

            public void a(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                a aVar = (a) this.f270a.get();
                if (aVar != null) {
                    aVar.a(5, list, (Bundle) null);
                }
            }

            public void a(CharSequence charSequence) throws RemoteException {
                a aVar = (a) this.f270a.get();
                if (aVar != null) {
                    aVar.a(6, charSequence, (Bundle) null);
                }
            }

            public void b(boolean z) throws RemoteException {
                a aVar = (a) this.f270a.get();
                if (aVar != null) {
                    aVar.a(11, Boolean.valueOf(z), (Bundle) null);
                }
            }

            public void a(int i) throws RemoteException {
                a aVar = (a) this.f270a.get();
                if (aVar != null) {
                    aVar.a(9, Integer.valueOf(i), (Bundle) null);
                }
            }

            public void a(boolean z) throws RemoteException {
                a aVar = (a) this.f270a.get();
                if (aVar != null) {
                    aVar.a(10, Boolean.valueOf(z), (Bundle) null);
                }
            }

            public void b(int i) throws RemoteException {
                a aVar = (a) this.f270a.get();
                if (aVar != null) {
                    aVar.a(12, Integer.valueOf(i), (Bundle) null);
                }
            }

            public void a(Bundle bundle) throws RemoteException {
                a aVar = (a) this.f270a.get();
                if (aVar != null) {
                    aVar.a(7, bundle, (Bundle) null);
                }
            }

            public void a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                a aVar = (a) this.f270a.get();
                if (aVar != null) {
                    aVar.a(4, parcelableVolumeInfo != null ? new b(parcelableVolumeInfo.f278a, parcelableVolumeInfo.f279b, parcelableVolumeInfo.c, parcelableVolumeInfo.d, parcelableVolumeInfo.e) : null, (Bundle) null);
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$a  reason: collision with other inner class name */
        private class C0009a extends Handler {

            /* renamed from: a  reason: collision with root package name */
            boolean f267a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a f268b;

            public void handleMessage(Message message) {
                if (this.f267a) {
                    switch (message.what) {
                        case 1:
                            this.f268b.a((String) message.obj, message.getData());
                            return;
                        case 2:
                            this.f268b.a((PlaybackStateCompat) message.obj);
                            return;
                        case 3:
                            this.f268b.a((MediaMetadataCompat) message.obj);
                            return;
                        case 4:
                            this.f268b.a((b) message.obj);
                            return;
                        case 5:
                            this.f268b.a((List<MediaSessionCompat.QueueItem>) (List) message.obj);
                            return;
                        case 6:
                            this.f268b.a((CharSequence) message.obj);
                            return;
                        case 7:
                            this.f268b.a((Bundle) message.obj);
                            return;
                        case 8:
                            this.f268b.a();
                            return;
                        case 9:
                            this.f268b.a(((Integer) message.obj).intValue());
                            return;
                        case 10:
                            this.f268b.b(((Boolean) message.obj).booleanValue());
                            return;
                        case 11:
                            this.f268b.a(((Boolean) message.obj).booleanValue());
                            return;
                        case 12:
                            this.f268b.b(((Integer) message.obj).intValue());
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f271a;

        /* renamed from: b  reason: collision with root package name */
        private final int f272b;
        private final int c;
        private final int d;
        private final int e;

        b(int i, int i2, int i3, int i4, int i5) {
            this.f271a = i;
            this.f272b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
        }
    }

    static class MediaControllerImplApi21 {

        /* renamed from: a  reason: collision with root package name */
        private final List<a> f262a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public b f263b;
        private HashMap<a, a> c;

        /* access modifiers changed from: private */
        public void a() {
            if (this.f263b != null) {
                synchronized (this.f262a) {
                    for (a next : this.f262a) {
                        a aVar = new a(next);
                        this.c.put(next, aVar);
                        next.f266b = true;
                        try {
                            this.f263b.a((a) aVar);
                        } catch (RemoteException e) {
                            Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                        }
                    }
                    this.f262a.clear();
                }
            }
        }

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* renamed from: a  reason: collision with root package name */
            private WeakReference<MediaControllerImplApi21> f264a;

            /* access modifiers changed from: protected */
            public void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.f264a.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    b unused = mediaControllerImplApi21.f263b = b.a.a(android.support.v4.a.b.a(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
                    mediaControllerImplApi21.a();
                }
            }
        }

        private static class a extends a.c {
            a(a aVar) {
                super(aVar);
            }

            public void a() throws RemoteException {
                throw new AssertionError();
            }

            public void a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                throw new AssertionError();
            }

            public void a(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                throw new AssertionError();
            }

            public void a(CharSequence charSequence) throws RemoteException {
                throw new AssertionError();
            }

            public void a(Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                throw new AssertionError();
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\media\session\MediaSessionCompat.java ==========

package android.support.v4.media.session;

import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.d;
import java.util.ArrayList;
import java.util.List;

public class MediaSessionCompat {

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator<Token>() {
            /* renamed from: a */
            public Token createFromParcel(Parcel parcel) {
                Object obj;
                if (Build.VERSION.SDK_INT >= 21) {
                    obj = parcel.readParcelable((ClassLoader) null);
                } else {
                    obj = parcel.readStrongBinder();
                }
                return new Token(obj);
            }

            /* renamed from: a */
            public Token[] newArray(int i) {
                return new Token[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final Object f276a;

        /* renamed from: b  reason: collision with root package name */
        private final b f277b;

        public int describeContents() {
            return 0;
        }

        Token(Object obj) {
            this(obj, (b) null);
        }

        Token(Object obj, b bVar) {
            this.f276a = obj;
            this.f277b = bVar;
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (Build.VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f276a, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.f276a);
            }
        }

        public int hashCode() {
            if (this.f276a == null) {
                return 0;
            }
            return this.f276a.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.f276a == null) {
                if (token.f276a == null) {
                    return true;
                }
                return false;
            } else if (token.f276a == null) {
                return false;
            } else {
                return this.f276a.equals(token.f276a);
            }
        }
    }

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new Parcelable.Creator<QueueItem>() {
            /* renamed from: a */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            /* renamed from: a */
            public QueueItem[] newArray(int i) {
                return new QueueItem[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final MediaDescriptionCompat f273a;

        /* renamed from: b  reason: collision with root package name */
        private final long f274b;
        private Object c;

        public int describeContents() {
            return 0;
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j != -1) {
                this.f273a = mediaDescriptionCompat;
                this.f274b = j;
                this.c = obj;
            } else {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
        }

        QueueItem(Parcel parcel) {
            this.f273a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f274b = parcel.readLong();
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f273a.writeToParcel(parcel, i);
            parcel.writeLong(this.f274b);
        }

        public static QueueItem a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new QueueItem(obj, MediaDescriptionCompat.a(d.a.a(obj)), d.a.b(obj));
        }

        public static List<QueueItem> a(List<?> list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object a2 : list) {
                arrayList.add(a((Object) a2));
            }
            return arrayList;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f273a + ", Id=" + this.f274b + " }";
        }
    }

    static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new Parcelable.Creator<ResultReceiverWrapper>() {
            /* renamed from: a */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            /* renamed from: a */
            public ResultReceiverWrapper[] newArray(int i) {
                return new ResultReceiverWrapper[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private ResultReceiver f275a;

        public int describeContents() {
            return 0;
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f275a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f275a.writeToParcel(parcel, i);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\media\session\ParcelableVolumeInfo.java ==========

package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new Parcelable.Creator<ParcelableVolumeInfo>() {
        /* renamed from: a */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        /* renamed from: a */
        public ParcelableVolumeInfo[] newArray(int i) {
            return new ParcelableVolumeInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f278a;

    /* renamed from: b  reason: collision with root package name */
    public int f279b;
    public int c;
    public int d;
    public int e;

    public int describeContents() {
        return 0;
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f278a = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f279b = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f278a);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f279b);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\media\session\PlaybackStateCompat.java ==========

package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.e;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator<PlaybackStateCompat>() {
        /* renamed from: a */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* renamed from: a */
        public PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final int f280a;

    /* renamed from: b  reason: collision with root package name */
    final long f281b;
    final long c;
    final float d;
    final long e;
    final int f;
    final CharSequence g;
    final long h;
    List<CustomAction> i;
    final long j;
    final Bundle k;
    private Object l;

    public int describeContents() {
        return 0;
    }

    PlaybackStateCompat(int i2, long j2, long j3, float f2, long j4, int i3, CharSequence charSequence, long j5, List<CustomAction> list, long j6, Bundle bundle) {
        this.f280a = i2;
        this.f281b = j2;
        this.c = j3;
        this.d = f2;
        this.e = j4;
        this.f = i3;
        this.g = charSequence;
        this.h = j5;
        this.i = new ArrayList(list);
        this.j = j6;
        this.k = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f280a = parcel.readInt();
        this.f281b = parcel.readLong();
        this.d = parcel.readFloat();
        this.h = parcel.readLong();
        this.c = parcel.readLong();
        this.e = parcel.readLong();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.j = parcel.readLong();
        this.k = parcel.readBundle();
        this.f = parcel.readInt();
    }

    public String toString() {
        return "PlaybackState {" + "state=" + this.f280a + ", position=" + this.f281b + ", buffered position=" + this.c + ", speed=" + this.d + ", updated=" + this.h + ", actions=" + this.e + ", error code=" + this.f + ", error message=" + this.g + ", custom actions=" + this.i + ", active item id=" + this.j + "}";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f280a);
        parcel.writeLong(this.f281b);
        parcel.writeFloat(this.d);
        parcel.writeLong(this.h);
        parcel.writeLong(this.c);
        parcel.writeLong(this.e);
        TextUtils.writeToParcel(this.g, parcel, i2);
        parcel.writeTypedList(this.i);
        parcel.writeLong(this.j);
        parcel.writeBundle(this.k);
        parcel.writeInt(this.f);
    }

    public static PlaybackStateCompat a(Object obj) {
        ArrayList arrayList;
        Object obj2 = obj;
        Bundle bundle = null;
        if (obj2 == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> h2 = e.h(obj);
        if (h2 != null) {
            ArrayList arrayList2 = new ArrayList(h2.size());
            for (Object a2 : h2) {
                arrayList2.add(CustomAction.a(a2));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            bundle = f.a(obj);
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(e.a(obj), e.b(obj), e.c(obj), e.d(obj), e.e(obj), 0, e.f(obj), e.g(obj), arrayList, e.i(obj), bundle);
        playbackStateCompat.l = obj2;
        return playbackStateCompat;
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator<CustomAction>() {
            /* renamed from: a */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* renamed from: a */
            public CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final String f282a;

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f283b;
        private final int c;
        private final Bundle d;
        private Object e;

        public int describeContents() {
            return 0;
        }

        CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f282a = str;
            this.f283b = charSequence;
            this.c = i;
            this.d = bundle;
        }

        CustomAction(Parcel parcel) {
            this.f282a = parcel.readString();
            this.f283b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.c = parcel.readInt();
            this.d = parcel.readBundle();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f282a);
            TextUtils.writeToParcel(this.f283b, parcel, i);
            parcel.writeInt(this.c);
            parcel.writeBundle(this.d);
        }

        public static CustomAction a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(e.a.a(obj), e.a.b(obj), e.a.c(obj), e.a.d(obj));
            customAction.e = obj;
            return customAction;
        }

        public String toString() {
            return "Action:mName='" + this.f283b + ", mIcon=" + this.c + ", mExtras=" + this.d;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\a.java ==========

package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: AbsSavedState */
public abstract class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.ClassLoaderCreator<a>() {
        /* renamed from: a */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return a.f299a;
            }
            throw new IllegalStateException("superState must be null");
        }

        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, (ClassLoader) null);
        }

        /* renamed from: a */
        public a[] newArray(int i) {
            return new a[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final a f299a = new a() {
    };

    /* renamed from: b  reason: collision with root package name */
    private final Parcelable f300b;

    public int describeContents() {
        return 0;
    }

    private a() {
        this.f300b = null;
    }

    protected a(Parcelable parcelable) {
        if (parcelable != null) {
            this.f300b = parcelable == f299a ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected a(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f300b = readParcelable == null ? f299a : readParcelable;
    }

    public final Parcelable a() {
        return this.f300b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f300b, i);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\b.java ==========

package android.support.v4.view;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.a.c;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* compiled from: AccessibilityDelegateCompat */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static final C0017b f314b;
    private static final View.AccessibilityDelegate c = new View.AccessibilityDelegate();

    /* renamed from: a  reason: collision with root package name */
    final View.AccessibilityDelegate f315a = f314b.a(this);

    /* renamed from: android.support.v4.view.b$b  reason: collision with other inner class name */
    /* compiled from: AccessibilityDelegateCompat */
    static class C0017b {
        public c a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            return null;
        }

        public boolean a(View.AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return false;
        }

        C0017b() {
        }

        public View.AccessibilityDelegate a(final b bVar) {
            return new View.AccessibilityDelegate() {
                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return bVar.b(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.d(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    bVar.a(view, android.support.v4.view.a.b.a(accessibilityNodeInfo));
                }

                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.c(view, accessibilityEvent);
                }

                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return bVar.a(viewGroup, view, accessibilityEvent);
                }

                public void sendAccessibilityEvent(View view, int i) {
                    bVar.a(view, i);
                }

                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.a(view, accessibilityEvent);
                }
            };
        }
    }

    /* compiled from: AccessibilityDelegateCompat */
    static class a extends C0017b {
        a() {
        }

        public View.AccessibilityDelegate a(final b bVar) {
            return new View.AccessibilityDelegate() {
                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return bVar.b(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.d(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    bVar.a(view, android.support.v4.view.a.b.a(accessibilityNodeInfo));
                }

                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.c(view, accessibilityEvent);
                }

                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return bVar.a(viewGroup, view, accessibilityEvent);
                }

                public void sendAccessibilityEvent(View view, int i) {
                    bVar.a(view, i);
                }

                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.a(view, accessibilityEvent);
                }

                public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                    c a2 = bVar.a(view);
                    if (a2 != null) {
                        return (AccessibilityNodeProvider) a2.a();
                    }
                    return null;
                }

                public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                    return bVar.a(view, i, bundle);
                }
            };
        }

        public c a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            AccessibilityNodeProvider accessibilityNodeProvider = accessibilityDelegate.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return new c(accessibilityNodeProvider);
            }
            return null;
        }

        public boolean a(View.AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i, bundle);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f314b = new a();
        } else {
            f314b = new C0017b();
        }
    }

    /* access modifiers changed from: package-private */
    public View.AccessibilityDelegate a() {
        return this.f315a;
    }

    public void a(View view, int i) {
        c.sendAccessibilityEvent(view, i);
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        c.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public boolean b(View view, AccessibilityEvent accessibilityEvent) {
        return c.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        c.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        c.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void a(View view, android.support.v4.view.a.b bVar) {
        c.onInitializeAccessibilityNodeInfo(view, bVar.a());
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return c.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public c a(View view) {
        return f314b.a(c, view);
    }

    public boolean a(View view, int i, Bundle bundle) {
        return f314b.a(c, view, i, bundle);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\c.java ==========

package android.support.v4.view;

import android.view.MotionEvent;

/* compiled from: MotionEventCompat */
public final class c {
    public static boolean a(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\d.java ==========

package android.support.v4.view;

/* compiled from: NestedScrollingChild */
public interface d {
    boolean isNestedScrollingEnabled();

    void stopNestedScroll();
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\e.java ==========

package android.support.v4.view;

public interface e extends d {
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\f.java ==========

package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

/* compiled from: NestedScrollingChildHelper */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private ViewParent f323a;

    /* renamed from: b  reason: collision with root package name */
    private ViewParent f324b;
    private final View c;
    private boolean d;
    private int[] e;

    public f(View view) {
        this.c = view;
    }

    public void a(boolean z) {
        if (this.d) {
            l.i(this.c);
        }
        this.d = z;
    }

    public boolean a() {
        return this.d;
    }

    public boolean b() {
        return a(0);
    }

    public boolean a(int i) {
        return d(i) != null;
    }

    public boolean b(int i) {
        return a(i, 0);
    }

    public boolean a(int i, int i2) {
        if (a(i2)) {
            return true;
        }
        if (!a()) {
            return false;
        }
        View view = this.c;
        for (ViewParent parent = this.c.getParent(); parent != null; parent = parent.getParent()) {
            if (n.a(parent, view, this.c, i, i2)) {
                a(i2, parent);
                n.b(parent, view, this.c, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void c() {
        c(0);
    }

    public void c(int i) {
        ViewParent d2 = d(i);
        if (d2 != null) {
            n.a(d2, this.c, i);
            a(i, (ViewParent) null);
        }
    }

    public boolean a(int i, int i2, int i3, int i4, int[] iArr) {
        return a(i, i2, i3, i4, iArr, 0);
    }

    public boolean a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        ViewParent d2;
        int i6;
        int i7;
        int[] iArr2 = iArr;
        if (!a() || (d2 = d(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.c.getLocationInWindow(iArr2);
            i7 = iArr2[0];
            i6 = iArr2[1];
        } else {
            i7 = 0;
            i6 = 0;
        }
        n.a(d2, this.c, i, i2, i3, i4, i5);
        if (iArr2 != null) {
            this.c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i7;
            iArr2[1] = iArr2[1] - i6;
        }
        return true;
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2) {
        return a(i, i2, iArr, iArr2, 0);
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent d2;
        int i4;
        int i5;
        if (!a() || (d2 = d(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.c.getLocationInWindow(iArr2);
            i5 = iArr2[0];
            i4 = iArr2[1];
        } else {
            i5 = 0;
            i4 = 0;
        }
        if (iArr == null) {
            if (this.e == null) {
                this.e = new int[2];
            }
            iArr = this.e;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        n.a(d2, this.c, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i5;
            iArr2[1] = iArr2[1] - i4;
        }
        if (iArr[0] == 0 && iArr[1] == 0) {
            return false;
        }
        return true;
    }

    public boolean a(float f, float f2, boolean z) {
        ViewParent d2;
        if (!a() || (d2 = d(0)) == null) {
            return false;
        }
        return n.a(d2, this.c, f, f2, z);
    }

    public boolean a(float f, float f2) {
        ViewParent d2;
        if (!a() || (d2 = d(0)) == null) {
            return false;
        }
        return n.a(d2, this.c, f, f2);
    }

    private ViewParent d(int i) {
        switch (i) {
            case 0:
                return this.f323a;
            case 1:
                return this.f324b;
            default:
                return null;
        }
    }

    private void a(int i, ViewParent viewParent) {
        switch (i) {
            case 0:
                this.f323a = viewParent;
                return;
            case 1:
                this.f324b = viewParent;
                return;
            default:
                return;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\g.java ==========

package android.support.v4.view;

import android.view.View;

/* compiled from: NestedScrollingParent */
public interface g {
    boolean onNestedFling(View view, float f, float f2, boolean z);

    boolean onNestedPreFling(View view, float f, float f2);

    void onNestedPreScroll(View view, int i, int i2, int[] iArr);

    void onNestedScroll(View view, int i, int i2, int i3, int i4);

    void onNestedScrollAccepted(View view, View view2, int i);

    boolean onStartNestedScroll(View view, View view2, int i);

    void onStopNestedScroll(View view);
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\h.java ==========

package android.support.v4.view;

import android.view.View;

/* compiled from: NestedScrollingParent2 */
public interface h extends g {
    void a(View view, int i);

    void a(View view, int i, int i2, int i3, int i4, int i5);

    void a(View view, int i, int i2, int[] iArr, int i3);

    boolean a(View view, View view2, int i, int i2);

    void b(View view, View view2, int i, int i2);
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\i.java ==========

package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: NestedScrollingParentHelper */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f325a;

    /* renamed from: b  reason: collision with root package name */
    private int f326b;

    public i(ViewGroup viewGroup) {
        this.f325a = viewGroup;
    }

    public void a(View view, View view2, int i) {
        a(view, view2, i, 0);
    }

    public void a(View view, View view2, int i, int i2) {
        this.f326b = i;
    }

    public int a() {
        return this.f326b;
    }

    public void a(View view) {
        a(view, 0);
    }

    public void a(View view, int i) {
        this.f326b = 0;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\j.java ==========

package android.support.v4.view;

import android.view.View;

/* compiled from: OnApplyWindowInsetsListener */
public interface j {
    o a(View view, o oVar);
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\k.java ==========

package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: PagerAdapter */
public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    private final DataSetObservable f327a = new DataSetObservable();

    /* renamed from: b  reason: collision with root package name */
    private DataSetObserver f328b;

    public float a(int i) {
        return 1.0f;
    }

    public abstract int a();

    public int a(Object obj) {
        return -1;
    }

    public void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Deprecated
    public void a(View view) {
    }

    public abstract boolean a(View view, Object obj);

    public Parcelable b() {
        return null;
    }

    @Deprecated
    public void b(View view) {
    }

    @Deprecated
    public void b(View view, int i, Object obj) {
    }

    public void a(ViewGroup viewGroup) {
        a((View) viewGroup);
    }

    public Object a(ViewGroup viewGroup, int i) {
        return a((View) viewGroup, i);
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        a((View) viewGroup, i, obj);
    }

    public void b(ViewGroup viewGroup, int i, Object obj) {
        b((View) viewGroup, i, obj);
    }

    public void b(ViewGroup viewGroup) {
        b((View) viewGroup);
    }

    @Deprecated
    public Object a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void c() {
        synchronized (this) {
            if (this.f328b != null) {
                this.f328b.onChanged();
            }
        }
        this.f327a.notifyChanged();
    }

    /* access modifiers changed from: package-private */
    public void a(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f328b = dataSetObserver;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\l.java ==========

package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* compiled from: ViewCompat */
public class l {

    /* renamed from: a  reason: collision with root package name */
    static final j f329a;

    /* compiled from: ViewCompat */
    static class j {

        /* renamed from: b  reason: collision with root package name */
        static Field f332b = null;
        static boolean c = false;
        private static Field d;
        private static boolean e;
        private static Field f;
        private static boolean g;
        private static Method h;

        /* renamed from: a  reason: collision with root package name */
        WeakHashMap<View, Object> f333a = null;

        public o a(View view, o oVar) {
            return oVar;
        }

        public void a(View view, float f2) {
        }

        public void a(View view, int i) {
        }

        public void a(View view, j jVar) {
        }

        public boolean a(View view) {
            return false;
        }

        public o b(View view, o oVar) {
            return oVar;
        }

        public int c(View view) {
            return 0;
        }

        public int f(View view) {
            return 0;
        }

        j() {
        }

        public void a(View view, b bVar) {
            view.setAccessibilityDelegate(bVar == null ? null : bVar.a());
        }

        public boolean k(View view) {
            if (c) {
                return false;
            }
            if (f332b == null) {
                try {
                    f332b = View.class.getDeclaredField("mAccessibilityDelegate");
                    f332b.setAccessible(true);
                } catch (Throwable unused) {
                    c = true;
                    return false;
                }
            }
            try {
                if (f332b.get(view) != null) {
                    return true;
                }
                return false;
            } catch (Throwable unused2) {
                c = true;
                return false;
            }
        }

        public void b(View view) {
            view.postInvalidate();
        }

        public void a(View view, Runnable runnable) {
            view.postDelayed(runnable, a());
        }

        public void a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, a() + j);
        }

        /* access modifiers changed from: package-private */
        public long a() {
            return ValueAnimator.getFrameDelay();
        }

        public int d(View view) {
            if (!e) {
                try {
                    d = View.class.getDeclaredField("mMinWidth");
                    d.setAccessible(true);
                } catch (NoSuchFieldException unused) {
                }
                e = true;
            }
            if (d == null) {
                return 0;
            }
            try {
                return ((Integer) d.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }

        public int e(View view) {
            if (!g) {
                try {
                    f = View.class.getDeclaredField("mMinHeight");
                    f.setAccessible(true);
                } catch (NoSuchFieldException unused) {
                }
                g = true;
            }
            if (f == null) {
                return 0;
            }
            try {
                return ((Integer) f.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }

        public void a(ViewGroup viewGroup, boolean z) {
            if (h == null) {
                Class<ViewGroup> cls = ViewGroup.class;
                try {
                    h = cls.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (NoSuchMethodException e2) {
                    Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", e2);
                }
                h.setAccessible(true);
            }
            try {
                h.invoke(viewGroup, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalAccessException e3) {
                Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e3);
            } catch (IllegalArgumentException e4) {
                Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e4);
            } catch (InvocationTargetException e5) {
                Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e5);
            }
        }

        public boolean i(View view) {
            if (view instanceof d) {
                return ((d) view).isNestedScrollingEnabled();
            }
            return false;
        }

        public void a(View view, Drawable drawable) {
            view.setBackgroundDrawable(drawable);
        }

        public void j(View view) {
            if (view instanceof d) {
                ((d) view).stopNestedScroll();
            }
        }

        public boolean h(View view) {
            return view.getWindowToken() != null;
        }

        public void b(View view, int i) {
            view.offsetTopAndBottom(i);
            if (view.getVisibility() == 0) {
                l(view);
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    l((View) parent);
                }
            }
        }

        private static void l(View view) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
        }

        public Display g(View view) {
            if (h(view)) {
                return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
            }
            return null;
        }
    }

    /* compiled from: ViewCompat */
    static class a extends j {
        a() {
        }
    }

    /* compiled from: ViewCompat */
    static class b extends a {
        b() {
        }

        public boolean a(View view) {
            return view.hasTransientState();
        }

        public void b(View view) {
            view.postInvalidateOnAnimation();
        }

        public void a(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        public void a(View view, Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        public int c(View view) {
            return view.getImportantForAccessibility();
        }

        public void a(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            view.setImportantForAccessibility(i);
        }

        public int d(View view) {
            return view.getMinimumWidth();
        }

        public int e(View view) {
            return view.getMinimumHeight();
        }

        public void a(View view, Drawable drawable) {
            view.setBackground(drawable);
        }
    }

    /* compiled from: ViewCompat */
    static class c extends b {
        c() {
        }

        public int f(View view) {
            return view.getLayoutDirection();
        }

        public Display g(View view) {
            return view.getDisplay();
        }
    }

    /* compiled from: ViewCompat */
    static class d extends c {
        d() {
        }
    }

    /* compiled from: ViewCompat */
    static class e extends d {
        e() {
        }

        public void a(View view, int i) {
            view.setImportantForAccessibility(i);
        }

        public boolean h(View view) {
            return view.isAttachedToWindow();
        }
    }

    /* compiled from: ViewCompat */
    static class f extends e {
        private static ThreadLocal<Rect> d;

        f() {
        }

        public void a(View view, float f) {
            view.setElevation(f);
        }

        public void a(View view, final j jVar) {
            if (jVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) null);
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        return (WindowInsets) o.a(jVar.a(view, o.a((Object) windowInsets)));
                    }
                });
            }
        }

        public boolean i(View view) {
            return view.isNestedScrollingEnabled();
        }

        public void j(View view) {
            view.stopNestedScroll();
        }

        public o a(View view, o oVar) {
            WindowInsets windowInsets = (WindowInsets) o.a(oVar);
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            if (onApplyWindowInsets != windowInsets) {
                windowInsets = new WindowInsets(onApplyWindowInsets);
            }
            return o.a((Object) windowInsets);
        }

        public o b(View view, o oVar) {
            WindowInsets windowInsets = (WindowInsets) o.a(oVar);
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
            if (dispatchApplyWindowInsets != windowInsets) {
                windowInsets = new WindowInsets(dispatchApplyWindowInsets);
            }
            return o.a((Object) windowInsets);
        }

        public void b(View view, int i) {
            boolean z;
            Rect b2 = b();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                b2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !b2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else {
                z = false;
            }
            super.b(view, i);
            if (z && b2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(b2);
            }
        }

        private static Rect b() {
            if (d == null) {
                d = new ThreadLocal<>();
            }
            Rect rect = d.get();
            if (rect == null) {
                rect = new Rect();
                d.set(rect);
            }
            rect.setEmpty();
            return rect;
        }
    }

    /* compiled from: ViewCompat */
    static class g extends f {
        g() {
        }

        public void b(View view, int i) {
            view.offsetTopAndBottom(i);
        }
    }

    /* compiled from: ViewCompat */
    static class h extends g {
        h() {
        }
    }

    /* compiled from: ViewCompat */
    static class i extends h {
        i() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            f329a = new i();
        } else if (Build.VERSION.SDK_INT >= 24) {
            f329a = new h();
        } else if (Build.VERSION.SDK_INT >= 23) {
            f329a = new g();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f329a = new f();
        } else if (Build.VERSION.SDK_INT >= 19) {
            f329a = new e();
        } else if (Build.VERSION.SDK_INT >= 18) {
            f329a = new d();
        } else if (Build.VERSION.SDK_INT >= 17) {
            f329a = new c();
        } else if (Build.VERSION.SDK_INT >= 16) {
            f329a = new b();
        } else if (Build.VERSION.SDK_INT >= 15) {
            f329a = new a();
        } else {
            f329a = new j();
        }
    }

    public static void a(View view, b bVar) {
        f329a.a(view, bVar);
    }

    public static boolean a(View view) {
        return f329a.k(view);
    }

    public static boolean b(View view) {
        return f329a.a(view);
    }

    public static void c(View view) {
        f329a.b(view);
    }

    public static void a(View view, Runnable runnable) {
        f329a.a(view, runnable);
    }

    public static void a(View view, Runnable runnable, long j2) {
        f329a.a(view, runnable, j2);
    }

    public static int d(View view) {
        return f329a.c(view);
    }

    public static void a(View view, int i2) {
        f329a.a(view, i2);
    }

    public static int e(View view) {
        return f329a.f(view);
    }

    public static int f(View view) {
        return f329a.d(view);
    }

    public static int g(View view) {
        return f329a.e(view);
    }

    public static void a(View view, float f2) {
        f329a.a(view, f2);
    }

    public static void a(ViewGroup viewGroup, boolean z) {
        f329a.a(viewGroup, z);
    }

    public static void a(View view, j jVar) {
        f329a.a(view, jVar);
    }

    public static o a(View view, o oVar) {
        return f329a.a(view, oVar);
    }

    public static o b(View view, o oVar) {
        return f329a.b(view, oVar);
    }

    public static void a(View view, Drawable drawable) {
        f329a.a(view, drawable);
    }

    public static boolean h(View view) {
        return f329a.i(view);
    }

    public static void i(View view) {
        f329a.j(view);
    }

    public static void b(View view, int i2) {
        f329a.b(view, i2);
    }

    public static Display j(View view) {
        return f329a.g(view);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\m.java ==========

package android.support.v4.view;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;
import net.fxgear.GlobalDefine;

@Deprecated
/* compiled from: ViewConfigurationCompat */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private static Method f334a;

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                f334a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception unused) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    public static float a(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }
        return c(viewConfiguration, context);
    }

    public static float b(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
        return c(viewConfiguration, context);
    }

    private static float c(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 25 && f334a != null) {
            try {
                return (float) ((Integer) f334a.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception unused) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(16842829, typedValue, true) ? typedValue.getDimension(context.getResources().getDisplayMetrics()) : GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\n.java ==========

package android.support.v4.view;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* compiled from: ViewParentCompat */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    static final c f335a;

    /* compiled from: ViewParentCompat */
    static class c {
        c() {
        }

        public boolean a(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof g) {
                return ((g) viewParent).onStartNestedScroll(view, view2, i);
            }
            return false;
        }

        public void b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof g) {
                ((g) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }

        public void a(ViewParent viewParent, View view) {
            if (viewParent instanceof g) {
                ((g) viewParent).onStopNestedScroll(view);
            }
        }

        public void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof g) {
                ((g) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        public void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof g) {
                ((g) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        public boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            if (viewParent instanceof g) {
                return ((g) viewParent).onNestedFling(view, f, f2, z);
            }
            return false;
        }

        public boolean a(ViewParent viewParent, View view, float f, float f2) {
            if (viewParent instanceof g) {
                return ((g) viewParent).onNestedPreFling(view, f, f2);
            }
            return false;
        }
    }

    /* compiled from: ViewParentCompat */
    static class a extends c {
        a() {
        }
    }

    /* compiled from: ViewParentCompat */
    static class b extends a {
        b() {
        }

        public boolean a(ViewParent viewParent, View view, View view2, int i) {
            try {
                return viewParent.onStartNestedScroll(view, view2, i);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onStartNestedScroll", e);
                return false;
            }
        }

        public void b(ViewParent viewParent, View view, View view2, int i) {
            try {
                viewParent.onNestedScrollAccepted(view, view2, i);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onNestedScrollAccepted", e);
            }
        }

        public void a(ViewParent viewParent, View view) {
            try {
                viewParent.onStopNestedScroll(view);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onStopNestedScroll", e);
            }
        }

        public void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            try {
                viewParent.onNestedScroll(view, i, i2, i3, i4);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onNestedScroll", e);
            }
        }

        public void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            try {
                viewParent.onNestedPreScroll(view, i, i2, iArr);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onNestedPreScroll", e);
            }
        }

        public boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            try {
                return viewParent.onNestedFling(view, f, f2, z);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onNestedFling", e);
                return false;
            }
        }

        public boolean a(ViewParent viewParent, View view, float f, float f2) {
            try {
                return viewParent.onNestedPreFling(view, f, f2);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onNestedPreFling", e);
                return false;
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f335a = new b();
        } else if (Build.VERSION.SDK_INT >= 19) {
            f335a = new a();
        } else {
            f335a = new c();
        }
    }

    public static boolean a(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof h) {
            return ((h) viewParent).a(view, view2, i, i2);
        }
        if (i2 == 0) {
            return f335a.a(viewParent, view, view2, i);
        }
        return false;
    }

    public static void b(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof h) {
            ((h) viewParent).b(view, view2, i, i2);
        } else if (i2 == 0) {
            f335a.b(viewParent, view, view2, i);
        }
    }

    public static void a(ViewParent viewParent, View view, int i) {
        if (viewParent instanceof h) {
            ((h) viewParent).a(view, i);
        } else if (i == 0) {
            f335a.a(viewParent, view);
        }
    }

    public static void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5) {
        if (viewParent instanceof h) {
            ((h) viewParent).a(view, i, i2, i3, i4, i5);
        } else if (i5 == 0) {
            f335a.a(viewParent, view, i, i2, i3, i4);
        }
    }

    public static void a(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof h) {
            ((h) viewParent).a(view, i, i2, iArr, i3);
        } else if (i3 == 0) {
            f335a.a(viewParent, view, i, i2, iArr);
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return f335a.a(viewParent, view, f, f2, z);
    }

    public static boolean a(ViewParent viewParent, View view, float f, float f2) {
        return f335a.a(viewParent, view, f, f2);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\o.java ==========

package android.support.v4.view;

import android.os.Build;
import android.view.WindowInsets;

/* compiled from: WindowInsetsCompat */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private final Object f336a;

    private o(Object obj) {
        this.f336a = obj;
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f336a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f336a).getSystemWindowInsetTop();
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f336a).getSystemWindowInsetRight();
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f336a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public boolean e() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f336a).isConsumed();
        }
        return false;
    }

    public o a(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new o(((WindowInsets) this.f336a).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f336a != null) {
            return this.f336a.equals(oVar.f336a);
        }
        if (oVar.f336a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f336a == null) {
            return 0;
        }
        return this.f336a.hashCode();
    }

    static o a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new o(obj);
    }

    static Object a(o oVar) {
        if (oVar == null) {
            return null;
        }
        return oVar.f336a;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\ViewPager.java ==========

package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.fxgear.GlobalDefine;

public class ViewPager extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f287a = {16842931};
    private static final j ai = new j();
    private static final Comparator<b> e = new Comparator<b>() {
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            return bVar.f293b - bVar2.f293b;
        }
    };
    private static final Interpolator f = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private int A = 1;
    private boolean B;
    private boolean C;
    private int D;
    private int E;
    private int F;
    private float G;
    private float H;
    private float I;
    private float J;
    private int K = -1;
    private VelocityTracker L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private EdgeEffect R;
    private EdgeEffect S;
    private boolean T = true;
    private boolean U = false;
    private boolean V;
    private int W;
    private List<f> aa;
    private f ab;
    private f ac;
    private List<e> ad;
    private g ae;
    private int af;
    private int ag;
    private ArrayList<View> ah;
    private final Runnable aj = new Runnable() {
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.c();
        }
    };
    private int ak = 0;

    /* renamed from: b  reason: collision with root package name */
    k f288b;
    int c;
    private int d;
    private final ArrayList<b> g = new ArrayList<>();
    private final b h = new b();
    private final Rect i = new Rect();
    private int j = -1;
    private Parcelable k = null;
    private ClassLoader l = null;
    private Scroller m;
    private boolean n;
    private h o;
    private int p;
    private Drawable q;
    private int r;
    private int s;
    private float t = -3.4028235E38f;
    private float u = Float.MAX_VALUE;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private boolean z;

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
    }

    public interface e {
        void a(ViewPager viewPager, k kVar, k kVar2);
    }

    public interface f {
        void a(int i);

        void a(int i, float f, int i2);

        void b(int i);
    }

    public interface g {
        void a(View view, float f);
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        Object f292a;

        /* renamed from: b  reason: collision with root package name */
        int f293b;
        boolean c;
        float d;
        float e;

        b() {
        }
    }

    public ViewPager(Context context) {
        super(context);
        a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.m = new Scroller(context, f);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.F = viewConfiguration.getScaledPagingTouchSlop();
        this.M = (int) (400.0f * f2);
        this.N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.R = new EdgeEffect(context);
        this.S = new EdgeEffect(context);
        this.O = (int) (25.0f * f2);
        this.P = (int) (2.0f * f2);
        this.D = (int) (f2 * 16.0f);
        l.a((View) this, (b) new d());
        if (l.d(this) == 0) {
            l.a((View) this, 1);
        }
        l.a((View) this, (j) new j() {

            /* renamed from: b  reason: collision with root package name */
            private final Rect f291b = new Rect();

            public o a(View view, o oVar) {
                o a2 = l.a(view, oVar);
                if (a2.e()) {
                    return a2;
                }
                Rect rect = this.f291b;
                rect.left = a2.a();
                rect.top = a2.b();
                rect.right = a2.c();
                rect.bottom = a2.d();
                int childCount = ViewPager.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    o b2 = l.b(ViewPager.this.getChildAt(i), a2);
                    rect.left = Math.min(b2.a(), rect.left);
                    rect.top = Math.min(b2.b(), rect.top);
                    rect.right = Math.min(b2.c(), rect.right);
                    rect.bottom = Math.min(b2.d(), rect.bottom);
                }
                return a2.a(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.aj);
        if (this.m != null && !this.m.isFinished()) {
            this.m.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i2) {
        if (this.ak != i2) {
            this.ak = i2;
            if (this.ae != null) {
                b(i2 != 0);
            }
            f(i2);
        }
    }

    public void setAdapter(k kVar) {
        if (this.f288b != null) {
            this.f288b.a((DataSetObserver) null);
            this.f288b.a((ViewGroup) this);
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                b bVar = this.g.get(i2);
                this.f288b.a((ViewGroup) this, bVar.f293b, bVar.f292a);
            }
            this.f288b.b((ViewGroup) this);
            this.g.clear();
            f();
            this.c = 0;
            scrollTo(0, 0);
        }
        k kVar2 = this.f288b;
        this.f288b = kVar;
        this.d = 0;
        if (this.f288b != null) {
            if (this.o == null) {
                this.o = new h();
            }
            this.f288b.a((DataSetObserver) this.o);
            this.z = false;
            boolean z2 = this.T;
            this.T = true;
            this.d = this.f288b.a();
            if (this.j >= 0) {
                this.f288b.a(this.k, this.l);
                a(this.j, false, true);
                this.j = -1;
                this.k = null;
                this.l = null;
            } else if (!z2) {
                c();
            } else {
                requestLayout();
            }
        }
        if (this.ad != null && !this.ad.isEmpty()) {
            int size = this.ad.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.ad.get(i3).a(this, kVar2, kVar);
            }
        }
    }

    private void f() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((c) getChildAt(i2).getLayoutParams()).f294a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    public k getAdapter() {
        return this.f288b;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i2) {
        this.z = false;
        a(i2, !this.T, false);
    }

    public void a(int i2, boolean z2) {
        this.z = false;
        a(i2, z2, false);
    }

    public int getCurrentItem() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, boolean z2, boolean z3) {
        a(i2, z2, z3, 0);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, boolean z2, boolean z3, int i3) {
        if (this.f288b == null || this.f288b.a() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z3 || this.c != i2 || this.g.size() == 0) {
            boolean z4 = true;
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 >= this.f288b.a()) {
                i2 = this.f288b.a() - 1;
            }
            int i4 = this.A;
            if (i2 > this.c + i4 || i2 < this.c - i4) {
                for (int i5 = 0; i5 < this.g.size(); i5++) {
                    this.g.get(i5).c = true;
                }
            }
            if (this.c == i2) {
                z4 = false;
            }
            if (this.T) {
                this.c = i2;
                if (z4) {
                    e(i2);
                }
                requestLayout();
                return;
            }
            a(i2);
            a(i2, z2, i3, z4);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void a(int i2, boolean z2, int i3, boolean z3) {
        b b2 = b(i2);
        int clientWidth = b2 != null ? (int) (((float) getClientWidth()) * Math.max(this.t, Math.min(b2.e, this.u))) : 0;
        if (z2) {
            a(clientWidth, 0, i3);
            if (z3) {
                e(i2);
                return;
            }
            return;
        }
        if (z3) {
            e(i2);
        }
        a(false);
        scrollTo(clientWidth, 0);
        d(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(f fVar) {
        this.ab = fVar;
    }

    public void a(f fVar) {
        if (this.aa == null) {
            this.aa = new ArrayList();
        }
        this.aa.add(fVar);
    }

    public void b(f fVar) {
        if (this.aa != null) {
            this.aa.remove(fVar);
        }
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        if (this.ag == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((c) this.ah.get(i3).getLayoutParams()).f;
    }

    public int getOffscreenPageLimit() {
        return this.A;
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to " + 1);
            i2 = 1;
        }
        if (i2 != this.A) {
            this.A = i2;
            c();
        }
    }

    public void setPageMargin(int i2) {
        int i3 = this.p;
        this.p = i2;
        int width = getWidth();
        a(width, width, i2, i3);
        requestLayout();
    }

    public int getPageMargin() {
        return this.p;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.q = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(android.support.v4.b.a.a(getContext(), i2));
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.q;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.q;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: package-private */
    public float a(float f2) {
        return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, int i4) {
        int i5;
        int i6;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (this.m != null && !this.m.isFinished()) {
            i5 = this.n ? this.m.getCurrX() : this.m.getStartX();
            this.m.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            i5 = getScrollX();
        }
        int i7 = i5;
        int scrollY = getScrollY();
        int i8 = i2 - i7;
        int i9 = i3 - scrollY;
        if (i8 == 0 && i9 == 0) {
            a(false);
            c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i10 = clientWidth / 2;
        float f2 = (float) clientWidth;
        float f3 = (float) i10;
        float a2 = f3 + (a(Math.min(1.0f, (((float) Math.abs(i8)) * 1.0f) / f2)) * f3);
        int abs = Math.abs(i4);
        if (abs > 0) {
            i6 = Math.round(Math.abs(a2 / ((float) abs)) * 1000.0f) * 4;
        } else {
            i6 = (int) (((((float) Math.abs(i8)) / ((f2 * this.f288b.a(this.c)) + ((float) this.p))) + 1.0f) * 100.0f);
        }
        int min = Math.min(i6, 600);
        this.n = false;
        this.m.startScroll(i7, scrollY, i8, i9, min);
        l.c(this);
    }

    /* access modifiers changed from: package-private */
    public b a(int i2, int i3) {
        b bVar = new b();
        bVar.f293b = i2;
        bVar.f292a = this.f288b.a((ViewGroup) this, i2);
        bVar.d = this.f288b.a(i2);
        if (i3 < 0 || i3 >= this.g.size()) {
            this.g.add(bVar);
        } else {
            this.g.add(i3, bVar);
        }
        return bVar;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int a2 = this.f288b.a();
        this.d = a2;
        boolean z2 = this.g.size() < (this.A * 2) + 1 && this.g.size() < a2;
        int i2 = this.c;
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.g.size()) {
            b bVar = this.g.get(i3);
            int a3 = this.f288b.a(bVar.f292a);
            if (a3 != -1) {
                if (a3 == -2) {
                    this.g.remove(i3);
                    i3--;
                    if (!z3) {
                        this.f288b.a((ViewGroup) this);
                        z3 = true;
                    }
                    this.f288b.a((ViewGroup) this, bVar.f293b, bVar.f292a);
                    if (this.c == bVar.f293b) {
                        i2 = Math.max(0, Math.min(this.c, a2 - 1));
                    }
                } else if (bVar.f293b != a3) {
                    if (bVar.f293b == this.c) {
                        i2 = a3;
                    }
                    bVar.f293b = a3;
                }
                z2 = true;
            }
            i3++;
        }
        if (z3) {
            this.f288b.b((ViewGroup) this);
        }
        Collections.sort(this.g, e);
        if (z2) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                c cVar = (c) getChildAt(i4).getLayoutParams();
                if (!cVar.f294a) {
                    cVar.c = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                }
            }
            a(i2, false, true);
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        a(this.c);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0066, code lost:
        if (r8.f293b == r0.c) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r0.c
            if (r2 == r1) goto L_0x0011
            int r2 = r0.c
            android.support.v4.view.ViewPager$b r2 = r0.b((int) r2)
            r0.c = r1
            goto L_0x0012
        L_0x0011:
            r2 = 0
        L_0x0012:
            android.support.v4.view.k r1 = r0.f288b
            if (r1 != 0) goto L_0x001a
            r17.g()
            return
        L_0x001a:
            boolean r1 = r0.z
            if (r1 == 0) goto L_0x0022
            r17.g()
            return
        L_0x0022:
            android.os.IBinder r1 = r17.getWindowToken()
            if (r1 != 0) goto L_0x0029
            return
        L_0x0029:
            android.support.v4.view.k r1 = r0.f288b
            r1.a((android.view.ViewGroup) r0)
            int r1 = r0.A
            int r4 = r0.c
            int r4 = r4 - r1
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)
            android.support.v4.view.k r6 = r0.f288b
            int r6 = r6.a()
            int r7 = r6 + -1
            int r8 = r0.c
            int r8 = r8 + r1
            int r1 = java.lang.Math.min(r7, r8)
            int r7 = r0.d
            if (r6 != r7) goto L_0x021a
            r7 = 0
        L_0x004c:
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r8 = r0.g
            int r8 = r8.size()
            if (r7 >= r8) goto L_0x006c
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r8 = r0.g
            java.lang.Object r8 = r8.get(r7)
            android.support.v4.view.ViewPager$b r8 = (android.support.v4.view.ViewPager.b) r8
            int r9 = r8.f293b
            int r10 = r0.c
            if (r9 < r10) goto L_0x0069
            int r9 = r8.f293b
            int r10 = r0.c
            if (r9 != r10) goto L_0x006c
            goto L_0x006d
        L_0x0069:
            int r7 = r7 + 1
            goto L_0x004c
        L_0x006c:
            r8 = 0
        L_0x006d:
            if (r8 != 0) goto L_0x0077
            if (r6 <= 0) goto L_0x0077
            int r8 = r0.c
            android.support.v4.view.ViewPager$b r8 = r0.a((int) r8, (int) r7)
        L_0x0077:
            r9 = 0
            if (r8 == 0) goto L_0x019a
            int r10 = r7 + -1
            if (r10 < 0) goto L_0x0087
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r11 = r0.g
            java.lang.Object r11 = r11.get(r10)
            android.support.v4.view.ViewPager$b r11 = (android.support.v4.view.ViewPager.b) r11
            goto L_0x0088
        L_0x0087:
            r11 = 0
        L_0x0088:
            int r12 = r17.getClientWidth()
            r13 = 1073741824(0x40000000, float:2.0)
            if (r12 > 0) goto L_0x0092
            r3 = 0
            goto L_0x009f
        L_0x0092:
            float r14 = r8.d
            float r14 = r13 - r14
            int r15 = r17.getPaddingLeft()
            float r15 = (float) r15
            float r3 = (float) r12
            float r15 = r15 / r3
            float r3 = r14 + r15
        L_0x009f:
            int r14 = r0.c
            int r14 = r14 + -1
            r15 = r7
            r7 = 0
        L_0x00a5:
            if (r14 < 0) goto L_0x0105
            int r16 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r16 < 0) goto L_0x00d3
            if (r14 >= r4) goto L_0x00d3
            if (r11 != 0) goto L_0x00b0
            goto L_0x0105
        L_0x00b0:
            int r5 = r11.f293b
            if (r14 != r5) goto L_0x0101
            boolean r5 = r11.c
            if (r5 != 0) goto L_0x0101
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r5 = r0.g
            r5.remove(r10)
            android.support.v4.view.k r5 = r0.f288b
            java.lang.Object r11 = r11.f292a
            r5.a((android.view.ViewGroup) r0, (int) r14, (java.lang.Object) r11)
            int r10 = r10 + -1
            int r15 = r15 + -1
            if (r10 < 0) goto L_0x00ff
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r5 = r0.g
            java.lang.Object r5 = r5.get(r10)
            android.support.v4.view.ViewPager$b r5 = (android.support.v4.view.ViewPager.b) r5
            goto L_0x0100
        L_0x00d3:
            if (r11 == 0) goto L_0x00e9
            int r5 = r11.f293b
            if (r14 != r5) goto L_0x00e9
            float r5 = r11.d
            float r7 = r7 + r5
            int r10 = r10 + -1
            if (r10 < 0) goto L_0x00ff
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r5 = r0.g
            java.lang.Object r5 = r5.get(r10)
            android.support.v4.view.ViewPager$b r5 = (android.support.v4.view.ViewPager.b) r5
            goto L_0x0100
        L_0x00e9:
            int r5 = r10 + 1
            android.support.v4.view.ViewPager$b r5 = r0.a((int) r14, (int) r5)
            float r5 = r5.d
            float r7 = r7 + r5
            int r15 = r15 + 1
            if (r10 < 0) goto L_0x00ff
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r5 = r0.g
            java.lang.Object r5 = r5.get(r10)
            android.support.v4.view.ViewPager$b r5 = (android.support.v4.view.ViewPager.b) r5
            goto L_0x0100
        L_0x00ff:
            r5 = 0
        L_0x0100:
            r11 = r5
        L_0x0101:
            int r14 = r14 + -1
            r5 = 0
            goto L_0x00a5
        L_0x0105:
            float r3 = r8.d
            int r4 = r15 + 1
            int r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x0197
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r5 = r0.g
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x011e
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r5 = r0.g
            java.lang.Object r5 = r5.get(r4)
            android.support.v4.view.ViewPager$b r5 = (android.support.v4.view.ViewPager.b) r5
            goto L_0x011f
        L_0x011e:
            r5 = 0
        L_0x011f:
            if (r12 > 0) goto L_0x0123
            r7 = 0
            goto L_0x012b
        L_0x0123:
            int r7 = r17.getPaddingRight()
            float r7 = (float) r7
            float r10 = (float) r12
            float r7 = r7 / r10
            float r7 = r7 + r13
        L_0x012b:
            int r10 = r0.c
        L_0x012d:
            int r10 = r10 + 1
            if (r10 >= r6) goto L_0x0197
            int r11 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r11 < 0) goto L_0x0161
            if (r10 <= r1) goto L_0x0161
            if (r5 != 0) goto L_0x013a
            goto L_0x0197
        L_0x013a:
            int r11 = r5.f293b
            if (r10 != r11) goto L_0x0196
            boolean r11 = r5.c
            if (r11 != 0) goto L_0x0196
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r11 = r0.g
            r11.remove(r4)
            android.support.v4.view.k r11 = r0.f288b
            java.lang.Object r5 = r5.f292a
            r11.a((android.view.ViewGroup) r0, (int) r10, (java.lang.Object) r5)
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r5 = r0.g
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x015f
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r5 = r0.g
            java.lang.Object r5 = r5.get(r4)
            android.support.v4.view.ViewPager$b r5 = (android.support.v4.view.ViewPager.b) r5
            goto L_0x0196
        L_0x015f:
            r5 = 0
            goto L_0x0196
        L_0x0161:
            if (r5 == 0) goto L_0x017d
            int r11 = r5.f293b
            if (r10 != r11) goto L_0x017d
            float r5 = r5.d
            float r3 = r3 + r5
            int r4 = r4 + 1
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r5 = r0.g
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x015f
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r5 = r0.g
            java.lang.Object r5 = r5.get(r4)
            android.support.v4.view.ViewPager$b r5 = (android.support.v4.view.ViewPager.b) r5
            goto L_0x0196
        L_0x017d:
            android.support.v4.view.ViewPager$b r5 = r0.a((int) r10, (int) r4)
            int r4 = r4 + 1
            float r5 = r5.d
            float r3 = r3 + r5
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r5 = r0.g
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x015f
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r5 = r0.g
            java.lang.Object r5 = r5.get(r4)
            android.support.v4.view.ViewPager$b r5 = (android.support.v4.view.ViewPager.b) r5
        L_0x0196:
            goto L_0x012d
        L_0x0197:
            r0.a((android.support.v4.view.ViewPager.b) r8, (int) r15, (android.support.v4.view.ViewPager.b) r2)
        L_0x019a:
            android.support.v4.view.k r1 = r0.f288b
            int r2 = r0.c
            if (r8 == 0) goto L_0x01a3
            java.lang.Object r3 = r8.f292a
            goto L_0x01a4
        L_0x01a3:
            r3 = 0
        L_0x01a4:
            r1.b((android.view.ViewGroup) r0, (int) r2, (java.lang.Object) r3)
            android.support.v4.view.k r1 = r0.f288b
            r1.b((android.view.ViewGroup) r0)
            int r1 = r17.getChildCount()
            r2 = 0
        L_0x01b1:
            if (r2 >= r1) goto L_0x01da
            android.view.View r3 = r0.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            android.support.v4.view.ViewPager$c r4 = (android.support.v4.view.ViewPager.c) r4
            r4.f = r2
            boolean r5 = r4.f294a
            if (r5 != 0) goto L_0x01d7
            float r5 = r4.c
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x01d7
            android.support.v4.view.ViewPager$b r3 = r0.a((android.view.View) r3)
            if (r3 == 0) goto L_0x01d7
            float r5 = r3.d
            r4.c = r5
            int r3 = r3.f293b
            r4.e = r3
        L_0x01d7:
            int r2 = r2 + 1
            goto L_0x01b1
        L_0x01da:
            r17.g()
            boolean r1 = r17.hasFocus()
            if (r1 == 0) goto L_0x0219
            android.view.View r1 = r17.findFocus()
            if (r1 == 0) goto L_0x01ee
            android.support.v4.view.ViewPager$b r3 = r0.b((android.view.View) r1)
            goto L_0x01ef
        L_0x01ee:
            r3 = 0
        L_0x01ef:
            if (r3 == 0) goto L_0x01f7
            int r1 = r3.f293b
            int r2 = r0.c
            if (r1 == r2) goto L_0x0219
        L_0x01f7:
            r1 = 0
        L_0x01f8:
            int r2 = r17.getChildCount()
            if (r1 >= r2) goto L_0x0219
            android.view.View r2 = r0.getChildAt(r1)
            android.support.v4.view.ViewPager$b r3 = r0.a((android.view.View) r2)
            if (r3 == 0) goto L_0x0216
            int r3 = r3.f293b
            int r4 = r0.c
            if (r3 != r4) goto L_0x0216
            r3 = 2
            boolean r2 = r2.requestFocus(r3)
            if (r2 == 0) goto L_0x0216
            goto L_0x0219
        L_0x0216:
            int r1 = r1 + 1
            goto L_0x01f8
        L_0x0219:
            return
        L_0x021a:
            android.content.res.Resources r1 = r17.getResources()     // Catch:{ NotFoundException -> 0x0227 }
            int r2 = r17.getId()     // Catch:{ NotFoundException -> 0x0227 }
            java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x0227 }
            goto L_0x022f
        L_0x0227:
            int r1 = r17.getId()
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
        L_0x022f:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: "
            r3.append(r4)
            int r4 = r0.d
            r3.append(r4)
            java.lang.String r4 = ", found: "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r4 = " Pager id: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " Pager class: "
            r3.append(r1)
            java.lang.Class r1 = r17.getClass()
            r3.append(r1)
            java.lang.String r1 = " Problematic adapter: "
            r3.append(r1)
            android.support.v4.view.k r1 = r0.f288b
            java.lang.Class r1 = r1.getClass()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.a(int):void");
    }

    private void g() {
        if (this.ag != 0) {
            if (this.ah == null) {
                this.ah = new ArrayList<>();
            } else {
                this.ah.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.ah.add(getChildAt(i2));
            }
            Collections.sort(this.ah, ai);
        }
    }

    private void a(b bVar, int i2, b bVar2) {
        b bVar3;
        b bVar4;
        int a2 = this.f288b.a();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? ((float) this.p) / ((float) clientWidth) : GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        if (bVar2 != null) {
            int i3 = bVar2.f293b;
            if (i3 < bVar.f293b) {
                float f3 = bVar2.e + bVar2.d + f2;
                int i4 = i3 + 1;
                int i5 = 0;
                while (i4 <= bVar.f293b && i5 < this.g.size()) {
                    Object obj = this.g.get(i5);
                    while (true) {
                        bVar4 = (b) obj;
                        if (i4 > bVar4.f293b && i5 < this.g.size() - 1) {
                            i5++;
                            obj = this.g.get(i5);
                        }
                    }
                    while (i4 < bVar4.f293b) {
                        f3 += this.f288b.a(i4) + f2;
                        i4++;
                    }
                    bVar4.e = f3;
                    f3 += bVar4.d + f2;
                    i4++;
                }
            } else if (i3 > bVar.f293b) {
                int size = this.g.size() - 1;
                float f4 = bVar2.e;
                while (true) {
                    i3--;
                    if (i3 < bVar.f293b || size < 0) {
                        break;
                    }
                    Object obj2 = this.g.get(size);
                    while (true) {
                        bVar3 = (b) obj2;
                        if (i3 < bVar3.f293b && size > 0) {
                            size--;
                            obj2 = this.g.get(size);
                        }
                    }
                    while (i3 > bVar3.f293b) {
                        f4 -= this.f288b.a(i3) + f2;
                        i3--;
                    }
                    f4 -= bVar3.d + f2;
                    bVar3.e = f4;
                }
            }
        }
        int size2 = this.g.size();
        float f5 = bVar.e;
        int i6 = bVar.f293b - 1;
        this.t = bVar.f293b == 0 ? bVar.e : -3.4028235E38f;
        int i7 = a2 - 1;
        this.u = bVar.f293b == i7 ? (bVar.e + bVar.d) - 1.0f : Float.MAX_VALUE;
        int i8 = i2 - 1;
        while (i8 >= 0) {
            b bVar5 = this.g.get(i8);
            while (i6 > bVar5.f293b) {
                f5 -= this.f288b.a(i6) + f2;
                i6--;
            }
            f5 -= bVar5.d + f2;
            bVar5.e = f5;
            if (bVar5.f293b == 0) {
                this.t = f5;
            }
            i8--;
            i6--;
        }
        float f6 = bVar.e + bVar.d + f2;
        int i9 = bVar.f293b + 1;
        int i10 = i2 + 1;
        while (i10 < size2) {
            b bVar6 = this.g.get(i10);
            while (i9 < bVar6.f293b) {
                f6 += this.f288b.a(i9) + f2;
                i9++;
            }
            if (bVar6.f293b == i7) {
                this.u = (bVar6.d + f6) - 1.0f;
            }
            bVar6.e = f6;
            f6 += bVar6.d + f2;
            i10++;
            i9++;
        }
        this.U = false;
    }

    public static class i extends a {
        public static final Parcelable.Creator<i> CREATOR = new Parcelable.ClassLoaderCreator<i>() {
            /* renamed from: a */
            public i createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new i(parcel, classLoader);
            }

            /* renamed from: a */
            public i createFromParcel(Parcel parcel) {
                return new i(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public i[] newArray(int i) {
                return new i[i];
            }
        };

        /* renamed from: b  reason: collision with root package name */
        int f298b;
        Parcelable c;
        ClassLoader d;

        public i(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f298b);
            parcel.writeParcelable(this.c, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f298b + "}";
        }

        i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f298b = parcel.readInt();
            this.c = parcel.readParcelable(classLoader);
            this.d = classLoader;
        }
    }

    public Parcelable onSaveInstanceState() {
        i iVar = new i(super.onSaveInstanceState());
        iVar.f298b = this.c;
        if (this.f288b != null) {
            iVar.c = this.f288b.b();
        }
        return iVar;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof i)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        i iVar = (i) parcelable;
        super.onRestoreInstanceState(iVar.a());
        if (this.f288b != null) {
            this.f288b.a(iVar.c, iVar.d);
            a(iVar.f298b, false, true);
            return;
        }
        this.j = iVar.f298b;
        this.k = iVar.c;
        this.l = iVar.d;
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        c cVar = (c) layoutParams;
        cVar.f294a |= c(view);
        if (!this.x) {
            super.addView(view, i2, layoutParams);
        } else if (cVar == null || !cVar.f294a) {
            cVar.d = true;
            addViewInLayout(view, i2, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    private static boolean c(View view) {
        return view.getClass().getAnnotation(a.class) != null;
    }

    public void removeView(View view) {
        if (this.x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    /* access modifiers changed from: package-private */
    public b a(View view) {
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            b bVar = this.g.get(i2);
            if (this.f288b.a(view, bVar.f292a)) {
                return bVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public b b(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return a(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    /* access modifiers changed from: package-private */
    public b b(int i2) {
        for (int i3 = 0; i3 < this.g.size(); i3++) {
            b bVar = this.g.get(i3);
            if (bVar.f293b == i2) {
                return bVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.T = true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r17, int r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = 0
            r2 = r17
            int r2 = getDefaultSize(r1, r2)
            r3 = r18
            int r3 = getDefaultSize(r1, r3)
            r0.setMeasuredDimension(r2, r3)
            int r2 = r16.getMeasuredWidth()
            int r3 = r2 / 10
            int r4 = r0.D
            int r3 = java.lang.Math.min(r3, r4)
            r0.E = r3
            int r3 = r16.getPaddingLeft()
            int r2 = r2 - r3
            int r3 = r16.getPaddingRight()
            int r2 = r2 - r3
            int r3 = r16.getMeasuredHeight()
            int r4 = r16.getPaddingTop()
            int r3 = r3 - r4
            int r4 = r16.getPaddingBottom()
            int r3 = r3 - r4
            int r4 = r16.getChildCount()
            r5 = r3
            r3 = r2
            r2 = 0
        L_0x003f:
            r6 = 8
            r7 = 1
            r8 = 1073741824(0x40000000, float:2.0)
            if (r2 >= r4) goto L_0x00c6
            android.view.View r9 = r0.getChildAt(r2)
            int r10 = r9.getVisibility()
            if (r10 == r6) goto L_0x00c1
            android.view.ViewGroup$LayoutParams r6 = r9.getLayoutParams()
            android.support.v4.view.ViewPager$c r6 = (android.support.v4.view.ViewPager.c) r6
            if (r6 == 0) goto L_0x00c1
            boolean r10 = r6.f294a
            if (r10 == 0) goto L_0x00c1
            int r10 = r6.f295b
            r10 = r10 & 7
            int r11 = r6.f295b
            r11 = r11 & 112(0x70, float:1.57E-43)
            r12 = 48
            if (r11 == r12) goto L_0x006f
            r12 = 80
            if (r11 != r12) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            r11 = 0
            goto L_0x0070
        L_0x006f:
            r11 = 1
        L_0x0070:
            r12 = 3
            if (r10 == r12) goto L_0x0078
            r12 = 5
            if (r10 != r12) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            r7 = 0
        L_0x0078:
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r11 == 0) goto L_0x0081
            r10 = 1073741824(0x40000000, float:2.0)
        L_0x007e:
            r12 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0085
        L_0x0081:
            if (r7 == 0) goto L_0x007e
            r12 = 1073741824(0x40000000, float:2.0)
        L_0x0085:
            int r13 = r6.width
            r14 = -1
            r15 = -2
            if (r13 == r15) goto L_0x0097
            int r10 = r6.width
            if (r10 == r14) goto L_0x0093
            int r10 = r6.width
            r13 = r10
            goto L_0x0094
        L_0x0093:
            r13 = r3
        L_0x0094:
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x0098
        L_0x0097:
            r13 = r3
        L_0x0098:
            int r1 = r6.height
            if (r1 == r15) goto L_0x00a5
            int r1 = r6.height
            if (r1 == r14) goto L_0x00a3
            int r1 = r6.height
            goto L_0x00a7
        L_0x00a3:
            r1 = r5
            goto L_0x00a7
        L_0x00a5:
            r1 = r5
            r8 = r12
        L_0x00a7:
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r13, r10)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            r9.measure(r6, r1)
            if (r11 == 0) goto L_0x00ba
            int r1 = r9.getMeasuredHeight()
            int r5 = r5 - r1
            goto L_0x00c1
        L_0x00ba:
            if (r7 == 0) goto L_0x00c1
            int r1 = r9.getMeasuredWidth()
            int r3 = r3 - r1
        L_0x00c1:
            int r2 = r2 + 1
            r1 = 0
            goto L_0x003f
        L_0x00c6:
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r8)
            r0.v = r1
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r8)
            r0.w = r1
            r0.x = r7
            r16.c()
            r1 = 0
            r0.x = r1
            int r2 = r16.getChildCount()
        L_0x00de:
            if (r1 >= r2) goto L_0x0108
            android.view.View r4 = r0.getChildAt(r1)
            int r5 = r4.getVisibility()
            if (r5 == r6) goto L_0x0105
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            android.support.v4.view.ViewPager$c r5 = (android.support.v4.view.ViewPager.c) r5
            if (r5 == 0) goto L_0x00f6
            boolean r7 = r5.f294a
            if (r7 != 0) goto L_0x0105
        L_0x00f6:
            float r7 = (float) r3
            float r5 = r5.c
            float r7 = r7 * r5
            int r5 = (int) r7
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r8)
            int r7 = r0.w
            r4.measure(r5, r7)
        L_0x0105:
            int r1 = r1 + 1
            goto L_0x00de
        L_0x0108:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            a(i2, i4, this.p, this.p);
        }
    }

    private void a(int i2, int i3, int i4, int i5) {
        if (i3 <= 0 || this.g.isEmpty()) {
            b b2 = b(this.c);
            int min = (int) ((b2 != null ? Math.min(b2.e, this.u) : GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) * ((float) ((i2 - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                a(false);
                scrollTo(min, getScrollY());
            }
        } else if (!this.m.isFinished()) {
            this.m.setFinalX(getCurrentItem() * getClientWidth());
        } else {
            scrollTo((int) ((((float) getScrollX()) / ((float) (((i3 - getPaddingLeft()) - getPaddingRight()) + i5))) * ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))), getScrollY());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        boolean z3;
        b a2;
        int i6;
        int i7;
        int childCount = getChildCount();
        int i8 = i4 - i2;
        int i9 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i10 = paddingBottom;
        int i11 = 0;
        int i12 = paddingTop;
        int i13 = paddingLeft;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f294a) {
                    int i15 = cVar.f295b & 7;
                    int i16 = cVar.f295b & 112;
                    if (i15 == 1) {
                        i6 = Math.max((i8 - childAt.getMeasuredWidth()) / 2, i13);
                    } else if (i15 == 3) {
                        i6 = i13;
                        i13 = childAt.getMeasuredWidth() + i13;
                    } else if (i15 != 5) {
                        i6 = i13;
                    } else {
                        i6 = (i8 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i16 == 16) {
                        i7 = Math.max((i9 - childAt.getMeasuredHeight()) / 2, i12);
                    } else if (i16 == 48) {
                        i7 = i12;
                        i12 = childAt.getMeasuredHeight() + i12;
                    } else if (i16 != 80) {
                        i7 = i12;
                    } else {
                        i7 = (i9 - i10) - childAt.getMeasuredHeight();
                        i10 += childAt.getMeasuredHeight();
                    }
                    int i17 = i6 + scrollX;
                    childAt.layout(i17, i7, childAt.getMeasuredWidth() + i17, i7 + childAt.getMeasuredHeight());
                    i11++;
                }
            }
        }
        int i18 = (i8 - i13) - paddingRight;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt2 = getChildAt(i19);
            if (childAt2.getVisibility() != 8) {
                c cVar2 = (c) childAt2.getLayoutParams();
                if (!cVar2.f294a && (a2 = a(childAt2)) != null) {
                    float f2 = (float) i18;
                    int i20 = ((int) (a2.e * f2)) + i13;
                    if (cVar2.d) {
                        cVar2.d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f2 * cVar2.c), 1073741824), View.MeasureSpec.makeMeasureSpec((i9 - i12) - i10, 1073741824));
                    }
                    childAt2.layout(i20, i12, childAt2.getMeasuredWidth() + i20, childAt2.getMeasuredHeight() + i12);
                }
            }
        }
        this.r = i12;
        this.s = i9 - i10;
        this.W = i11;
        if (this.T) {
            z3 = false;
            a(this.c, false, 0, false);
        } else {
            z3 = false;
        }
        this.T = z3;
    }

    public void computeScroll() {
        this.n = true;
        if (this.m.isFinished() || !this.m.computeScrollOffset()) {
            a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.m.getCurrX();
        int currY = this.m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!d(currX)) {
                this.m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        l.c(this);
    }

    private boolean d(int i2) {
        if (this.g.size() != 0) {
            b i3 = i();
            int clientWidth = getClientWidth();
            int i4 = this.p + clientWidth;
            float f2 = (float) clientWidth;
            float f3 = ((float) this.p) / f2;
            int i5 = i3.f293b;
            float f4 = ((((float) i2) / f2) - i3.e) / (i3.d + f3);
            this.V = false;
            a(i5, f4, (int) (((float) i4) * f4));
            if (this.V) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.T) {
            return false;
        } else {
            this.V = false;
            a(0, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 0);
            if (this.V) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.W
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L_0x006d
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r4
            r4 = r3
            r3 = 0
        L_0x001d:
            if (r3 >= r6) goto L_0x006d
            android.view.View r8 = r12.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            android.support.v4.view.ViewPager$c r9 = (android.support.v4.view.ViewPager.c) r9
            boolean r10 = r9.f294a
            if (r10 != 0) goto L_0x002e
            goto L_0x006a
        L_0x002e:
            int r9 = r9.f295b
            r9 = r9 & 7
            if (r9 == r2) goto L_0x004f
            r10 = 3
            if (r9 == r10) goto L_0x0049
            r10 = 5
            if (r9 == r10) goto L_0x003c
            r9 = r4
            goto L_0x005e
        L_0x003c:
            int r9 = r5 - r7
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r7 = r7 + r10
            goto L_0x005b
        L_0x0049:
            int r9 = r8.getWidth()
            int r9 = r9 + r4
            goto L_0x005e
        L_0x004f:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r4)
        L_0x005b:
            r11 = r9
            r9 = r4
            r4 = r11
        L_0x005e:
            int r4 = r4 + r0
            int r10 = r8.getLeft()
            int r4 = r4 - r10
            if (r4 == 0) goto L_0x0069
            r8.offsetLeftAndRight(r4)
        L_0x0069:
            r4 = r9
        L_0x006a:
            int r3 = r3 + 1
            goto L_0x001d
        L_0x006d:
            r12.b(r13, r14, r15)
            android.support.v4.view.ViewPager$g r13 = r12.ae
            if (r13 == 0) goto L_0x00a1
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L_0x007c:
            if (r1 >= r14) goto L_0x00a1
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            android.support.v4.view.ViewPager$c r0 = (android.support.v4.view.ViewPager.c) r0
            boolean r0 = r0.f294a
            if (r0 == 0) goto L_0x008d
            goto L_0x009e
        L_0x008d:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            android.support.v4.view.ViewPager$g r3 = r12.ae
            r3.a(r15, r0)
        L_0x009e:
            int r1 = r1 + 1
            goto L_0x007c
        L_0x00a1:
            r12.V = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.a(int, float, int):void");
    }

    private void b(int i2, float f2, int i3) {
        if (this.ab != null) {
            this.ab.a(i2, f2, i3);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i4 = 0; i4 < size; i4++) {
                f fVar = this.aa.get(i4);
                if (fVar != null) {
                    fVar.a(i2, f2, i3);
                }
            }
        }
        if (this.ac != null) {
            this.ac.a(i2, f2, i3);
        }
    }

    private void e(int i2) {
        if (this.ab != null) {
            this.ab.a(i2);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar = this.aa.get(i3);
                if (fVar != null) {
                    fVar.a(i2);
                }
            }
        }
        if (this.ac != null) {
            this.ac.a(i2);
        }
    }

    private void f(int i2) {
        if (this.ab != null) {
            this.ab.b(i2);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar = this.aa.get(i3);
                if (fVar != null) {
                    fVar.b(i2);
                }
            }
        }
        if (this.ac != null) {
            this.ac.b(i2);
        }
    }

    private void a(boolean z2) {
        boolean z3 = this.ak == 2;
        if (z3) {
            setScrollingCacheEnabled(false);
            if (!this.m.isFinished()) {
                this.m.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.m.getCurrX();
                int currY = this.m.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        d(currX);
                    }
                }
            }
        }
        this.z = false;
        boolean z4 = z3;
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            b bVar = this.g.get(i2);
            if (bVar.c) {
                bVar.c = false;
                z4 = true;
            }
        }
        if (!z4) {
            return;
        }
        if (z2) {
            l.a((View) this, this.aj);
        } else {
            this.aj.run();
        }
    }

    private boolean a(float f2, float f3) {
        return (f2 < ((float) this.E) && f3 > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) || (f2 > ((float) (getWidth() - this.E)) && f3 < GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
    }

    private void b(boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setLayerType(z2 ? this.af : 0, (Paint) null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            h();
            return false;
        }
        if (action != 0) {
            if (this.B) {
                return true;
            }
            if (this.C) {
                return false;
            }
        }
        if (action == 0) {
            float x2 = motionEvent.getX();
            this.I = x2;
            this.G = x2;
            float y2 = motionEvent.getY();
            this.J = y2;
            this.H = y2;
            this.K = motionEvent2.getPointerId(0);
            this.C = false;
            this.n = true;
            this.m.computeScrollOffset();
            if (this.ak != 2 || Math.abs(this.m.getFinalX() - this.m.getCurrX()) <= this.P) {
                a(false);
                this.B = false;
            } else {
                this.m.abortAnimation();
                this.z = false;
                c();
                this.B = true;
                c(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.K;
            if (i2 != -1) {
                int findPointerIndex = motionEvent2.findPointerIndex(i2);
                float x3 = motionEvent2.getX(findPointerIndex);
                float f2 = x3 - this.G;
                float abs = Math.abs(f2);
                float y3 = motionEvent2.getY(findPointerIndex);
                float abs2 = Math.abs(y3 - this.J);
                if (f2 != GlobalDefine.DEFAULT_AUTO_FILTER_VALUE && !a(this.G, f2)) {
                    if (a(this, false, (int) f2, (int) x3, (int) y3)) {
                        this.G = x3;
                        this.H = y3;
                        this.C = true;
                        return false;
                    }
                }
                if (abs > ((float) this.F) && abs * 0.5f > abs2) {
                    this.B = true;
                    c(true);
                    setScrollState(1);
                    this.G = f2 > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE ? this.I + ((float) this.F) : this.I - ((float) this.F);
                    this.H = y3;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > ((float) this.F)) {
                    this.C = true;
                }
                if (this.B && b(x3)) {
                    l.c(this);
                }
            }
        } else if (action == 6) {
            a(motionEvent);
        }
        if (this.L == null) {
            this.L = VelocityTracker.obtain();
        }
        this.L.addMovement(motionEvent2);
        return this.B;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Q) {
            return true;
        }
        boolean z2 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || this.f288b == null || this.f288b.a() == 0) {
            return false;
        }
        if (this.L == null) {
            this.L = VelocityTracker.obtain();
        }
        this.L.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.m.abortAnimation();
                this.z = false;
                c();
                float x2 = motionEvent.getX();
                this.I = x2;
                this.G = x2;
                float y2 = motionEvent.getY();
                this.J = y2;
                this.H = y2;
                this.K = motionEvent.getPointerId(0);
                break;
            case 1:
                if (this.B) {
                    VelocityTracker velocityTracker = this.L;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.N);
                    int xVelocity = (int) velocityTracker.getXVelocity(this.K);
                    this.z = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    b i2 = i();
                    float f2 = (float) clientWidth;
                    a(a(i2.f293b, ((((float) scrollX) / f2) - i2.e) / (i2.d + (((float) this.p) / f2)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.K)) - this.I)), true, true, xVelocity);
                    z2 = h();
                    break;
                }
                break;
            case 2:
                if (!this.B) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.K);
                    if (findPointerIndex == -1) {
                        z2 = h();
                        break;
                    } else {
                        float x3 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x3 - this.G);
                        float y3 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y3 - this.H);
                        if (abs > ((float) this.F) && abs > abs2) {
                            this.B = true;
                            c(true);
                            this.G = x3 - this.I > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE ? this.I + ((float) this.F) : this.I - ((float) this.F);
                            this.H = y3;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.B) {
                    z2 = false | b(motionEvent.getX(motionEvent.findPointerIndex(this.K)));
                    break;
                }
                break;
            case 3:
                if (this.B) {
                    a(this.c, true, 0, false);
                    z2 = h();
                    break;
                }
                break;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                this.G = motionEvent.getX(actionIndex);
                this.K = motionEvent.getPointerId(actionIndex);
                break;
            case 6:
                a(motionEvent);
                this.G = motionEvent.getX(motionEvent.findPointerIndex(this.K));
                break;
        }
        if (z2) {
            l.c(this);
        }
        return true;
    }

    private boolean h() {
        this.K = -1;
        j();
        this.R.onRelease();
        this.S.onRelease();
        return this.R.isFinished() || this.S.isFinished();
    }

    private void c(boolean z2) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z2);
        }
    }

    private boolean b(float f2) {
        boolean z2;
        boolean z3;
        float f3 = this.G - f2;
        this.G = f2;
        float scrollX = ((float) getScrollX()) + f3;
        float clientWidth = (float) getClientWidth();
        float f4 = this.t * clientWidth;
        float f5 = this.u * clientWidth;
        boolean z4 = false;
        b bVar = this.g.get(0);
        b bVar2 = this.g.get(this.g.size() - 1);
        if (bVar.f293b != 0) {
            f4 = bVar.e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (bVar2.f293b != this.f288b.a() - 1) {
            f5 = bVar2.e * clientWidth;
            z3 = false;
        } else {
            z3 = true;
        }
        if (scrollX < f4) {
            if (z2) {
                this.R.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z4 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z3) {
                this.S.onPull(Math.abs(scrollX - f5) / clientWidth);
                z4 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.G += scrollX - ((float) i2);
        scrollTo(i2, getScrollY());
        d(i2);
        return z4;
    }

    private b i() {
        int i2;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        float f2 = clientWidth > 0 ? ((float) this.p) / ((float) clientWidth) : GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        b bVar = null;
        int i3 = 0;
        boolean z2 = true;
        int i4 = -1;
        float f3 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        float f4 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        while (i3 < this.g.size()) {
            b bVar2 = this.g.get(i3);
            if (!z2 && bVar2.f293b != (i2 = i4 + 1)) {
                bVar2 = this.h;
                bVar2.e = f3 + f4 + f2;
                bVar2.f293b = i2;
                bVar2.d = this.f288b.a(bVar2.f293b);
                i3--;
            }
            f3 = bVar2.e;
            float f5 = bVar2.d + f3 + f2;
            if (!z2 && scrollX < f3) {
                return bVar;
            }
            if (scrollX < f5 || i3 == this.g.size() - 1) {
                return bVar2;
            }
            i4 = bVar2.f293b;
            f4 = bVar2.d;
            i3++;
            bVar = bVar2;
            z2 = false;
        }
        return bVar;
    }

    private int a(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.O || Math.abs(i3) <= this.M) {
            i2 += (int) (f2 + (i2 >= this.c ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        return this.g.size() > 0 ? Math.max(this.g.get(0).f293b, Math.min(i2, this.g.get(this.g.size() - 1).f293b)) : i2;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z2 = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && this.f288b != null && this.f288b.a() > 1)) {
            if (!this.R.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.t * ((float) width));
                this.R.setSize(height, width);
                z2 = false | this.R.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.S.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.u + 1.0f)) * ((float) width2));
                this.S.setSize(height2, width2);
                z2 |= this.S.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.R.finish();
            this.S.finish();
        }
        if (z2) {
            l.c(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        super.onDraw(canvas);
        if (this.p > 0 && this.q != null && this.g.size() > 0 && this.f288b != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f5 = (float) width;
            float f6 = ((float) this.p) / f5;
            int i2 = 0;
            b bVar = this.g.get(0);
            float f7 = bVar.e;
            int size = this.g.size();
            int i3 = bVar.f293b;
            int i4 = this.g.get(size - 1).f293b;
            while (i3 < i4) {
                while (i3 > bVar.f293b && i2 < size) {
                    i2++;
                    bVar = this.g.get(i2);
                }
                if (i3 == bVar.f293b) {
                    f3 = (bVar.e + bVar.d) * f5;
                    f2 = bVar.e + bVar.d + f6;
                } else {
                    float a2 = this.f288b.a(i3);
                    f2 = f7 + a2 + f6;
                    f3 = (f7 + a2) * f5;
                }
                if (((float) this.p) + f3 > ((float) scrollX)) {
                    f4 = f6;
                    this.q.setBounds(Math.round(f3), this.r, Math.round(((float) this.p) + f3), this.s);
                    this.q.draw(canvas);
                } else {
                    Canvas canvas2 = canvas;
                    f4 = f6;
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i3++;
                    f7 = f2;
                    f6 = f4;
                } else {
                    return;
                }
            }
        }
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.K) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.G = motionEvent.getX(i2);
            this.K = motionEvent.getPointerId(i2);
            if (this.L != null) {
                this.L.clear();
            }
        }
    }

    private void j() {
        this.B = false;
        this.C = false;
        if (this.L != null) {
            this.L.recycle();
            this.L = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z2) {
        if (this.y != z2) {
            this.y = z2;
        }
    }

    public boolean canScrollHorizontally(int i2) {
        if (this.f288b == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i2 < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.t))) {
                return true;
            }
            return false;
        } else if (i2 <= 0 || scrollX >= ((int) (((float) clientWidth) * this.u))) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(View view, boolean z2, int i2, int i3, int i4) {
        int i5;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom()) {
                    if (a(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z2 || !view.canScrollHorizontally(-i2)) {
            return false;
        }
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                switch (keyCode) {
                    case 21:
                        if (keyEvent.hasModifiers(2)) {
                            return d();
                        }
                        return c(17);
                    case 22:
                        if (keyEvent.hasModifiers(2)) {
                            return e();
                        }
                        return c(66);
                }
            } else if (keyEvent.hasNoModifiers()) {
                return c(2);
            } else {
                if (keyEvent.hasModifiers(1)) {
                    return c(1);
                }
            }
        }
        return false;
    }

    public boolean c(int i2) {
        boolean requestFocus;
        boolean z2;
        View findFocus = findFocus();
        boolean z3 = false;
        View view = null;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z2 = false;
                        break;
                    } else if (parent == this) {
                        z2 = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i2);
        if (findNextFocus != null && findNextFocus != view) {
            if (i2 == 17) {
                int i3 = a(this.i, findNextFocus).left;
                int i4 = a(this.i, view).left;
                if (view == null || i3 < i4) {
                    requestFocus = findNextFocus.requestFocus();
                } else {
                    requestFocus = d();
                }
            } else if (i2 == 66) {
                int i5 = a(this.i, findNextFocus).left;
                int i6 = a(this.i, view).left;
                if (view == null || i5 > i6) {
                    requestFocus = findNextFocus.requestFocus();
                } else {
                    requestFocus = e();
                }
            }
            z3 = requestFocus;
        } else if (i2 == 17 || i2 == 1) {
            z3 = d();
        } else if (i2 == 66 || i2 == 2) {
            z3 = e();
        }
        if (z3) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
        }
        return z3;
    }

    private Rect a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        if (this.c <= 0) {
            return false;
        }
        a(this.c - 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        if (this.f288b == null || this.c >= this.f288b.a() - 1) {
            return false;
        }
        a(this.c + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        b a2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f293b == this.c) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i3 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        b a2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f293b == this.c) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        b a2;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i4 = 0;
            i3 = 1;
        } else {
            i4 = childCount - 1;
            i3 = -1;
        }
        while (i4 != i5) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f293b == this.c && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i4 += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        b a2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f293b == this.c && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof c) && super.checkLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    class d extends b {
        d() {
        }

        public void d(View view, AccessibilityEvent accessibilityEvent) {
            super.d(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(b());
            if (accessibilityEvent.getEventType() == 4096 && ViewPager.this.f288b != null) {
                accessibilityEvent.setItemCount(ViewPager.this.f288b.a());
                accessibilityEvent.setFromIndex(ViewPager.this.c);
                accessibilityEvent.setToIndex(ViewPager.this.c);
            }
        }

        public void a(View view, android.support.v4.view.a.b bVar) {
            super.a(view, bVar);
            bVar.a((CharSequence) ViewPager.class.getName());
            bVar.a(b());
            if (ViewPager.this.canScrollHorizontally(1)) {
                bVar.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                bVar.a(8192);
            }
        }

        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                ViewPager.this.setCurrentItem(ViewPager.this.c - 1);
                return true;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                ViewPager.this.setCurrentItem(ViewPager.this.c + 1);
                return true;
            }
        }

        private boolean b() {
            return ViewPager.this.f288b != null && ViewPager.this.f288b.a() > 1;
        }
    }

    private class h extends DataSetObserver {
        h() {
        }

        public void onChanged() {
            ViewPager.this.b();
        }

        public void onInvalidated() {
            ViewPager.this.b();
        }
    }

    public static class c extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f294a;

        /* renamed from: b  reason: collision with root package name */
        public int f295b;
        float c = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        boolean d;
        int e;
        int f;

        public c() {
            super(-1, -1);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f287a);
            this.f295b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    static class j implements Comparator<View> {
        j() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            c cVar = (c) view.getLayoutParams();
            c cVar2 = (c) view2.getLayoutParams();
            if (cVar.f294a != cVar2.f294a) {
                return cVar.f294a ? 1 : -1;
            }
            return cVar.e - cVar2.e;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\a\a.java ==========

package android.support.v4.view.a;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: AccessibilityEventCompat */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final c f301a;

    /* compiled from: AccessibilityEventCompat */
    static class c {
        public int a(AccessibilityEvent accessibilityEvent) {
            return 0;
        }

        public void a(AccessibilityEvent accessibilityEvent, int i) {
        }

        c() {
        }
    }

    /* renamed from: android.support.v4.view.a.a$a  reason: collision with other inner class name */
    /* compiled from: AccessibilityEventCompat */
    static class C0014a extends c {
        C0014a() {
        }
    }

    /* compiled from: AccessibilityEventCompat */
    static class b extends C0014a {
        b() {
        }

        public void a(AccessibilityEvent accessibilityEvent, int i) {
            accessibilityEvent.setContentChangeTypes(i);
        }

        public int a(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getContentChangeTypes();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f301a = new b();
        } else if (Build.VERSION.SDK_INT >= 16) {
            f301a = new C0014a();
        } else {
            f301a = new c();
        }
    }

    public static void a(AccessibilityEvent accessibilityEvent, int i) {
        f301a.a(accessibilityEvent, i);
    }

    public static int a(AccessibilityEvent accessibilityEvent) {
        return f301a.a(accessibilityEvent);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\a\b.java ==========

package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import net.fxgear.GlobalDefine;
import net.fxgear.util.FXUtil;

/* compiled from: AccessibilityNodeInfoCompat */
public class b {

    /* renamed from: a  reason: collision with root package name */
    static final i f302a;

    /* renamed from: b  reason: collision with root package name */
    public int f303b = -1;
    private final AccessibilityNodeInfo c;

    private static String b(int i2) {
        switch (i2) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case GlobalDefine.RESULT_CODE_ERROR_NOT_FOUND_FILE /*16*/:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case FXUtil.MAX_CUSTOM_FACE_IMAGE_SIZE /*1024*/:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        final Object f304a;

        public static j a(int i, int i2, boolean z, int i3) {
            return new j(b.f302a.a(i, i2, z, i3));
        }

        j(Object obj) {
            this.f304a = obj;
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    public static class k {

        /* renamed from: a  reason: collision with root package name */
        final Object f305a;

        public static k a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new k(b.f302a.a(i, i2, i3, i4, z, z2));
        }

        k(Object obj) {
            this.f305a = obj;
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    static class i {
        public Object a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return null;
        }

        public Object a(int i, int i2, boolean z, int i3) {
            return null;
        }

        public String a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return null;
        }

        public void a(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
        }

        public void b(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
        }

        i() {
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    static class a extends i {
        a() {
        }
    }

    /* renamed from: android.support.v4.view.a.b$b  reason: collision with other inner class name */
    /* compiled from: AccessibilityNodeInfoCompat */
    static class C0015b extends a {
        C0015b() {
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    static class c extends C0015b {
        c() {
        }

        public String a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getViewIdResourceName();
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    static class d extends c {
        d() {
        }

        public void a(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
            accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) obj);
        }

        public Object a(int i, int i2, boolean z, int i3) {
            return AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z);
        }

        public Object a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z);
        }

        public void b(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) obj);
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    static class e extends d {
        e() {
        }

        public Object a(int i, int i2, boolean z, int i3) {
            return AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3);
        }

        public Object a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2);
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    static class f extends e {
        f() {
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    static class g extends f {
        g() {
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    static class h extends g {
        h() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 24) {
            f302a = new h();
        } else if (Build.VERSION.SDK_INT >= 23) {
            f302a = new g();
        } else if (Build.VERSION.SDK_INT >= 22) {
            f302a = new f();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f302a = new e();
        } else if (Build.VERSION.SDK_INT >= 19) {
            f302a = new d();
        } else if (Build.VERSION.SDK_INT >= 18) {
            f302a = new c();
        } else if (Build.VERSION.SDK_INT >= 17) {
            f302a = new C0015b();
        } else if (Build.VERSION.SDK_INT >= 16) {
            f302a = new a();
        } else {
            f302a = new i();
        }
    }

    private b(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.c = accessibilityNodeInfo;
    }

    public static b a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new b(accessibilityNodeInfo);
    }

    public AccessibilityNodeInfo a() {
        return this.c;
    }

    public int b() {
        return this.c.getActions();
    }

    public void a(int i2) {
        this.c.addAction(i2);
    }

    public void a(Rect rect) {
        this.c.getBoundsInParent(rect);
    }

    public void b(Rect rect) {
        this.c.getBoundsInScreen(rect);
    }

    public boolean c() {
        return this.c.isCheckable();
    }

    public boolean d() {
        return this.c.isChecked();
    }

    public boolean e() {
        return this.c.isFocusable();
    }

    public boolean f() {
        return this.c.isFocused();
    }

    public boolean g() {
        return this.c.isSelected();
    }

    public boolean h() {
        return this.c.isClickable();
    }

    public boolean i() {
        return this.c.isLongClickable();
    }

    public boolean j() {
        return this.c.isEnabled();
    }

    public boolean k() {
        return this.c.isPassword();
    }

    public boolean l() {
        return this.c.isScrollable();
    }

    public void a(boolean z) {
        this.c.setScrollable(z);
    }

    public CharSequence m() {
        return this.c.getPackageName();
    }

    public CharSequence n() {
        return this.c.getClassName();
    }

    public void a(CharSequence charSequence) {
        this.c.setClassName(charSequence);
    }

    public CharSequence o() {
        return this.c.getText();
    }

    public CharSequence p() {
        return this.c.getContentDescription();
    }

    public String q() {
        return f302a.a(this.c);
    }

    public void a(Object obj) {
        f302a.a(this.c, ((j) obj).f304a);
    }

    public void b(Object obj) {
        f302a.b(this.c, ((k) obj).f305a);
    }

    public int hashCode() {
        if (this.c == null) {
            return 0;
        }
        return this.c.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.c == null) {
            if (bVar.c != null) {
                return false;
            }
        } else if (!this.c.equals(bVar.c)) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        sb.append("; boundsInParent: " + rect);
        b(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(m());
        sb.append("; className: ");
        sb.append(n());
        sb.append("; text: ");
        sb.append(o());
        sb.append("; contentDescription: ");
        sb.append(p());
        sb.append("; viewId: ");
        sb.append(q());
        sb.append("; checkable: ");
        sb.append(c());
        sb.append("; checked: ");
        sb.append(d());
        sb.append("; focusable: ");
        sb.append(e());
        sb.append("; focused: ");
        sb.append(f());
        sb.append("; selected: ");
        sb.append(g());
        sb.append("; clickable: ");
        sb.append(h());
        sb.append("; longClickable: ");
        sb.append(i());
        sb.append("; enabled: ");
        sb.append(j());
        sb.append("; password: ");
        sb.append(k());
        sb.append("; scrollable: " + l());
        sb.append("; [");
        int b2 = b();
        while (b2 != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b2);
            b2 &= numberOfTrailingZeros ^ -1;
            sb.append(b(numberOfTrailingZeros));
            if (b2 != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\a\c.java ==========

package android.support.v4.view.a;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.a.d;
import android.support.v4.view.a.e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final a f306a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f307b;

    /* compiled from: AccessibilityNodeProviderCompat */
    interface a {
        Object a(c cVar);
    }

    public b a(int i) {
        return null;
    }

    public List<b> a(String str, int i) {
        return null;
    }

    public boolean a(int i, int i2, Bundle bundle) {
        return false;
    }

    public b b(int i) {
        return null;
    }

    /* compiled from: AccessibilityNodeProviderCompat */
    static class d implements a {
        public Object a(c cVar) {
            return null;
        }

        d() {
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat */
    private static class b extends d {
        b() {
        }

        public Object a(final c cVar) {
            return d.a(new d.a() {
                public boolean a(int i, int i2, Bundle bundle) {
                    return cVar.a(i, i2, bundle);
                }

                public List<Object> a(String str, int i) {
                    List<b> a2 = cVar.a(str, i);
                    if (a2 == null) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    int size = a2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(a2.get(i2).a());
                    }
                    return arrayList;
                }

                public Object a(int i) {
                    b a2 = cVar.a(i);
                    if (a2 == null) {
                        return null;
                    }
                    return a2.a();
                }
            });
        }
    }

    /* renamed from: android.support.v4.view.a.c$c  reason: collision with other inner class name */
    /* compiled from: AccessibilityNodeProviderCompat */
    private static class C0016c extends d {
        C0016c() {
        }

        public Object a(final c cVar) {
            return e.a(new e.a() {
                public boolean a(int i, int i2, Bundle bundle) {
                    return cVar.a(i, i2, bundle);
                }

                public List<Object> a(String str, int i) {
                    List<b> a2 = cVar.a(str, i);
                    if (a2 == null) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    int size = a2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(a2.get(i2).a());
                    }
                    return arrayList;
                }

                public Object a(int i) {
                    b a2 = cVar.a(i);
                    if (a2 == null) {
                        return null;
                    }
                    return a2.a();
                }

                public Object b(int i) {
                    b b2 = cVar.b(i);
                    if (b2 == null) {
                        return null;
                    }
                    return b2.a();
                }
            });
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f306a = new C0016c();
        } else if (Build.VERSION.SDK_INT >= 16) {
            f306a = new b();
        } else {
            f306a = new d();
        }
    }

    public c() {
        this.f307b = f306a.a(this);
    }

    public c(Object obj) {
        this.f307b = obj;
    }

    public Object a() {
        return this.f307b;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\a\d.java ==========

package android.support.v4.view.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompatJellyBean */
class d {

    /* compiled from: AccessibilityNodeProviderCompatJellyBean */
    interface a {
        Object a(int i);

        List<Object> a(String str, int i);

        boolean a(int i, int i2, Bundle bundle);
    }

    public static Object a(final a aVar) {
        return new AccessibilityNodeProvider() {
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (AccessibilityNodeInfo) aVar.a(i);
            }

            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
                return aVar.a(str, i);
            }

            public boolean performAction(int i, int i2, Bundle bundle) {
                return aVar.a(i, i2, bundle);
            }
        };
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\a\e.java ==========

package android.support.v4.view.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompatKitKat */
class e {

    /* compiled from: AccessibilityNodeProviderCompatKitKat */
    interface a {
        Object a(int i);

        List<Object> a(String str, int i);

        boolean a(int i, int i2, Bundle bundle);

        Object b(int i);
    }

    public static Object a(final a aVar) {
        return new AccessibilityNodeProvider() {
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (AccessibilityNodeInfo) aVar.a(i);
            }

            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
                return aVar.a(str, i);
            }

            public boolean performAction(int i, int i2, Bundle bundle) {
                return aVar.a(i, i2, bundle);
            }

            public AccessibilityNodeInfo findFocus(int i) {
                return (AccessibilityNodeInfo) aVar.b(i);
            }
        };
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\b\a.java ==========

package android.support.v4.view.b;

import net.fxgear.GlobalDefine;

/* compiled from: FastOutSlowInInterpolator */
public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private static final float[] f316a = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0E-4f, 2.0E-4f, 5.0E-4f, 9.0E-4f, 0.0014f, 0.002f, 0.0027f, 0.0036f, 0.0046f, 0.0058f, 0.0071f, 0.0085f, 0.0101f, 0.0118f, 0.0137f, 0.0158f, 0.018f, 0.0205f, 0.0231f, 0.0259f, 0.0289f, 0.0321f, 0.0355f, 0.0391f, 0.043f, 0.0471f, 0.0514f, 0.056f, 0.0608f, 0.066f, 0.0714f, 0.0771f, 0.083f, 0.0893f, 0.0959f, 0.1029f, 0.1101f, 0.1177f, 0.1257f, 0.1339f, 0.1426f, 0.1516f, 0.161f, 0.1707f, 0.1808f, 0.1913f, 0.2021f, 0.2133f, 0.2248f, 0.2366f, 0.2487f, 0.2611f, 0.2738f, 0.2867f, 0.2998f, 0.3131f, 0.3265f, 0.34f, 0.3536f, 0.3673f, 0.381f, 0.3946f, 0.4082f, 0.4217f, 0.4352f, 0.4485f, 0.4616f, 0.4746f, 0.4874f, 0.5f, 0.5124f, 0.5246f, 0.5365f, 0.5482f, 0.5597f, 0.571f, 0.582f, 0.5928f, 0.6033f, 0.6136f, 0.6237f, 0.6335f, 0.6431f, 0.6525f, 0.6616f, 0.6706f, 0.6793f, 0.6878f, 0.6961f, 0.7043f, 0.7122f, 0.7199f, 0.7275f, 0.7349f, 0.7421f, 0.7491f, 0.7559f, 0.7626f, 0.7692f, 0.7756f, 0.7818f, 0.7879f, 0.7938f, 0.7996f, 0.8053f, 0.8108f, 0.8162f, 0.8215f, 0.8266f, 0.8317f, 0.8366f, 0.8414f, 0.8461f, 0.8507f, 0.8551f, 0.8595f, 0.8638f, 0.8679f, 0.872f, 0.876f, 0.8798f, 0.8836f, 0.8873f, 0.8909f, 0.8945f, 0.8979f, 0.9013f, 0.9046f, 0.9078f, 0.9109f, 0.9139f, 0.9169f, 0.9198f, 0.9227f, 0.9254f, 0.9281f, 0.9307f, 0.9333f, 0.9358f, 0.9382f, 0.9406f, 0.9429f, 0.9452f, 0.9474f, 0.9495f, 0.9516f, 0.9536f, 0.9556f, 0.9575f, 0.9594f, 0.9612f, 0.9629f, 0.9646f, 0.9663f, 0.9679f, 0.9695f, 0.971f, 0.9725f, 0.9739f, 0.9753f, 0.9766f, 0.9779f, 0.9791f, 0.9803f, 0.9815f, 0.9826f, 0.9837f, 0.9848f, 0.9858f, 0.9867f, 0.9877f, 0.9885f, 0.9894f, 0.9902f, 0.991f, 0.9917f, 0.9924f, 0.9931f, 0.9937f, 0.9944f, 0.9949f, 0.9955f, 0.996f, 0.9964f, 0.9969f, 0.9973f, 0.9977f, 0.998f, 0.9984f, 0.9986f, 0.9989f, 0.9991f, 0.9993f, 0.9995f, 0.9997f, 0.9998f, 0.9999f, 0.9999f, 1.0f, 1.0f};

    public /* bridge */ /* synthetic */ float getInterpolation(float f) {
        return super.getInterpolation(f);
    }

    public a() {
        super(f316a);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\view\b\b.java ==========

package android.support.v4.view.b;

import android.view.animation.Interpolator;
import net.fxgear.GlobalDefine;

/* compiled from: LookupTableInterpolator */
abstract class b implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f319a;

    /* renamed from: b  reason: collision with root package name */
    private final float f320b = (1.0f / ((float) (this.f319a.length - 1)));

    public b(float[] fArr) {
        this.f319a = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
            return GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        }
        int min = Math.min((int) (((float) (this.f319a.length - 1)) * f), this.f319a.length - 2);
        return this.f319a[min] + (((f - (((float) min) * this.f320b)) / this.f320b) * (this.f319a[min + 1] - this.f319a[min]));
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\widget\a.java ==========

package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.v4.view.l;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import net.fxgear.GlobalDefine;

/* compiled from: CircleImageView */
class a extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    int f348a;

    /* renamed from: b  reason: collision with root package name */
    private Animation.AnimationListener f349b;

    a(Context context, int i) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (1.75f * f);
        int i3 = (int) (GlobalDefine.DEFAULT_AUTO_FILTER_VALUE * f);
        this.f348a = (int) (3.5f * f);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            l.a((View) this, f * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C0018a(this.f348a));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer((float) this.f348a, (float) i3, (float) i2, 503316480);
            int i4 = this.f348a;
            setPadding(i4, i4, i4, i4);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i);
        l.a((View) this, (Drawable) shapeDrawable);
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f348a * 2), getMeasuredHeight() + (this.f348a * 2));
        }
    }

    public void a(Animation.AnimationListener animationListener) {
        this.f349b = animationListener;
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.f349b != null) {
            this.f349b.onAnimationStart(getAnimation());
        }
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.f349b != null) {
            this.f349b.onAnimationEnd(getAnimation());
        }
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    /* renamed from: android.support.v4.widget.a$a  reason: collision with other inner class name */
    /* compiled from: CircleImageView */
    private class C0018a extends OvalShape {

        /* renamed from: b  reason: collision with root package name */
        private RadialGradient f351b;
        private Paint c = new Paint();

        C0018a(int i) {
            a.this.f348a = i;
            a((int) rect().width());
        }

        /* access modifiers changed from: protected */
        public void onResize(float f, float f2) {
            super.onResize(f, f2);
            a((int) f);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = a.this.getWidth() / 2;
            float f = (float) width;
            float height = (float) (a.this.getHeight() / 2);
            canvas.drawCircle(f, height, f, this.c);
            canvas.drawCircle(f, height, (float) (width - a.this.f348a), paint);
        }

        private void a(int i) {
            float f = (float) (i / 2);
            this.f351b = new RadialGradient(f, f, (float) a.this.f348a, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.c.setShader(this.f351b);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\widget\b.java ==========

package android.support.v4.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v4.d.f;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import net.fxgear.GlobalDefine;

/* compiled from: CircularProgressDrawable */
public class b extends Drawable implements Animatable {

    /* renamed from: a  reason: collision with root package name */
    private static final Interpolator f352a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    private static final Interpolator f353b = new android.support.v4.view.b.a();
    private static final int[] c = {-16777216};
    private final a d = new a();
    private float e;
    private Resources f;
    private Animator g;
    /* access modifiers changed from: private */
    public float h;
    /* access modifiers changed from: private */
    public boolean i;

    private int a(float f2, int i2, int i3) {
        int i4 = (i2 >> 24) & 255;
        int i5 = (i2 >> 16) & 255;
        int i6 = (i2 >> 8) & 255;
        int i7 = i2 & 255;
        return ((i4 + ((int) (((float) (((i3 >> 24) & 255) - i4)) * f2))) << 24) | ((i5 + ((int) (((float) (((i3 >> 16) & 255) - i5)) * f2))) << 16) | ((i6 + ((int) (((float) (((i3 >> 8) & 255) - i6)) * f2))) << 8) | (i7 + ((int) (f2 * ((float) ((i3 & 255) - i7)))));
    }

    public int getOpacity() {
        return -3;
    }

    public b(Context context) {
        this.f = ((Context) f.a(context)).getResources();
        this.d.a(c);
        a(2.5f);
        a();
    }

    private void a(float f2, float f3, float f4, float f5) {
        a aVar = this.d;
        float f6 = this.f.getDisplayMetrics().density;
        aVar.a(f3 * f6);
        aVar.e(f2 * f6);
        aVar.b(0);
        aVar.a(f4 * f6, f5 * f6);
    }

    public void a(int i2) {
        if (i2 == 0) {
            a(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            a(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public void a(float f2) {
        this.d.a(f2);
        invalidateSelf();
    }

    public void a(boolean z) {
        this.d.a(z);
        invalidateSelf();
    }

    public void b(float f2) {
        this.d.f(f2);
        invalidateSelf();
    }

    public void a(float f2, float f3) {
        this.d.b(f2);
        this.d.c(f3);
        invalidateSelf();
    }

    public void c(float f2) {
        this.d.d(f2);
        invalidateSelf();
    }

    public void a(int... iArr) {
        this.d.a(iArr);
        this.d.b(0);
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.e, bounds.exactCenterX(), bounds.exactCenterY());
        this.d.a(canvas, bounds);
        canvas.restore();
    }

    public void setAlpha(int i2) {
        this.d.c(i2);
        invalidateSelf();
    }

    public int getAlpha() {
        return this.d.d();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.d.a(colorFilter);
        invalidateSelf();
    }

    private void d(float f2) {
        this.e = f2;
    }

    public boolean isRunning() {
        return this.g.isRunning();
    }

    public void start() {
        this.g.cancel();
        this.d.k();
        if (this.d.i() != this.d.e()) {
            this.i = true;
            this.g.setDuration(666);
            this.g.start();
            return;
        }
        this.d.b(0);
        this.d.l();
        this.g.setDuration(1332);
        this.g.start();
    }

    public void stop() {
        this.g.cancel();
        d(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        this.d.a(false);
        this.d.b(0);
        this.d.l();
        invalidateSelf();
    }

    /* access modifiers changed from: private */
    public void a(float f2, a aVar) {
        if (f2 > 0.75f) {
            aVar.a(a((f2 - 0.75f) / 0.25f, aVar.h(), aVar.a()));
        } else {
            aVar.a(aVar.h());
        }
    }

    private void b(float f2, a aVar) {
        a(f2, aVar);
        aVar.b(aVar.f() + (((aVar.g() - 0.01f) - aVar.f()) * f2));
        aVar.c(aVar.g());
        aVar.d(aVar.j() + ((((float) (Math.floor((double) (aVar.j() / 0.8f)) + 1.0d)) - aVar.j()) * f2));
    }

    /* access modifiers changed from: private */
    public void a(float f2, a aVar, boolean z) {
        float f3;
        float f4;
        if (this.i) {
            b(f2, aVar);
        } else if (f2 != 1.0f || z) {
            float j = aVar.j();
            if (f2 < 0.5f) {
                float f5 = aVar.f();
                float f6 = f5;
                f3 = (f353b.getInterpolation(f2 / 0.5f) * 0.79f) + 0.01f + f5;
                f4 = f6;
            } else {
                f3 = aVar.f() + 0.79f;
                f4 = f3 - (((1.0f - f353b.getInterpolation((f2 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
            }
            aVar.b(f4);
            aVar.c(f3);
            aVar.d(j + (0.20999998f * f2));
            d((f2 + this.h) * 216.0f);
        }
    }

    private void a() {
        final a aVar = this.d;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                b.this.a(floatValue, aVar);
                b.this.a(floatValue, aVar, false);
                b.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f352a);
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                float unused = b.this.h = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            }

            public void onAnimationRepeat(Animator animator) {
                b.this.a(1.0f, aVar, true);
                aVar.k();
                aVar.c();
                if (b.this.i) {
                    boolean unused = b.this.i = false;
                    animator.cancel();
                    animator.setDuration(1332);
                    animator.start();
                    aVar.a(false);
                    return;
                }
                float unused2 = b.this.h = b.this.h + 1.0f;
            }
        });
        this.g = ofFloat;
    }

    /* compiled from: CircularProgressDrawable */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        final RectF f358a = new RectF();

        /* renamed from: b  reason: collision with root package name */
        final Paint f359b = new Paint();
        final Paint c = new Paint();
        final Paint d = new Paint();
        float e = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        float f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        float g = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        float h = 5.0f;
        int[] i;
        int j;
        float k;
        float l;
        float m;
        boolean n;
        Path o;
        float p = 1.0f;
        float q;
        int r;
        int s;
        int t = 255;
        int u;

        a() {
            this.f359b.setStrokeCap(Paint.Cap.SQUARE);
            this.f359b.setAntiAlias(true);
            this.f359b.setStyle(Paint.Style.STROKE);
            this.c.setStyle(Paint.Style.FILL);
            this.c.setAntiAlias(true);
            this.d.setColor(0);
        }

        /* access modifiers changed from: package-private */
        public void a(float f2, float f3) {
            this.r = (int) f2;
            this.s = (int) f3;
        }

        /* access modifiers changed from: package-private */
        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f358a;
            float f2 = this.q + (this.h / 2.0f);
            if (this.q <= GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                f2 = (((float) Math.min(rect.width(), rect.height())) / 2.0f) - Math.max((((float) this.r) * this.p) / 2.0f, this.h / 2.0f);
            }
            rectF.set(((float) rect.centerX()) - f2, ((float) rect.centerY()) - f2, ((float) rect.centerX()) + f2, ((float) rect.centerY()) + f2);
            float f3 = (this.e + this.g) * 360.0f;
            float f4 = ((this.f + this.g) * 360.0f) - f3;
            this.f359b.setColor(this.u);
            this.f359b.setAlpha(this.t);
            float f5 = this.h / 2.0f;
            rectF.inset(f5, f5);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.d);
            float f6 = -f5;
            rectF.inset(f6, f6);
            canvas.drawArc(rectF, f3, f4, false, this.f359b);
            a(canvas, f3, f4, rectF);
        }

        /* access modifiers changed from: package-private */
        public void a(Canvas canvas, float f2, float f3, RectF rectF) {
            if (this.n) {
                if (this.o == null) {
                    this.o = new Path();
                    this.o.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    this.o.reset();
                }
                this.o.moveTo(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
                this.o.lineTo(((float) this.r) * this.p, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
                this.o.lineTo((((float) this.r) * this.p) / 2.0f, ((float) this.s) * this.p);
                this.o.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((((float) this.r) * this.p) / 2.0f), rectF.centerY() + (this.h / 2.0f));
                this.o.close();
                this.c.setColor(this.u);
                this.c.setAlpha(this.t);
                canvas.save();
                canvas.rotate(f2 + f3, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.o, this.c);
                canvas.restore();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int[] iArr) {
            this.i = iArr;
            b(0);
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            this.u = i2;
        }

        /* access modifiers changed from: package-private */
        public void b(int i2) {
            this.j = i2;
            this.u = this.i[this.j];
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.i[b()];
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return (this.j + 1) % this.i.length;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            b(b());
        }

        /* access modifiers changed from: package-private */
        public void a(ColorFilter colorFilter) {
            this.f359b.setColorFilter(colorFilter);
        }

        /* access modifiers changed from: package-private */
        public void c(int i2) {
            this.t = i2;
        }

        /* access modifiers changed from: package-private */
        public int d() {
            return this.t;
        }

        /* access modifiers changed from: package-private */
        public void a(float f2) {
            this.h = f2;
            this.f359b.setStrokeWidth(f2);
        }

        /* access modifiers changed from: package-private */
        public void b(float f2) {
            this.e = f2;
        }

        /* access modifiers changed from: package-private */
        public float e() {
            return this.e;
        }

        /* access modifiers changed from: package-private */
        public float f() {
            return this.k;
        }

        /* access modifiers changed from: package-private */
        public float g() {
            return this.l;
        }

        /* access modifiers changed from: package-private */
        public int h() {
            return this.i[this.j];
        }

        /* access modifiers changed from: package-private */
        public void c(float f2) {
            this.f = f2;
        }

        /* access modifiers changed from: package-private */
        public float i() {
            return this.f;
        }

        /* access modifiers changed from: package-private */
        public void d(float f2) {
            this.g = f2;
        }

        /* access modifiers changed from: package-private */
        public void e(float f2) {
            this.q = f2;
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
            if (this.n != z) {
                this.n = z;
            }
        }

        /* access modifiers changed from: package-private */
        public void f(float f2) {
            if (f2 != this.p) {
                this.p = f2;
            }
        }

        /* access modifiers changed from: package-private */
        public float j() {
            return this.m;
        }

        /* access modifiers changed from: package-private */
        public void k() {
            this.k = this.e;
            this.l = this.f;
            this.m = this.g;
        }

        /* access modifiers changed from: package-private */
        public void l() {
            this.k = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            this.l = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            this.m = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            b((float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
            c((float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
            d(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\widget\c.java ==========

package android.support.v4.widget;

import android.os.Build;
import android.widget.EdgeEffect;

/* compiled from: EdgeEffectCompat */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final b f360a;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f360a = new a();
        } else {
            f360a = new b();
        }
    }

    /* compiled from: EdgeEffectCompat */
    static class b {
        b() {
        }

        public void a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f);
        }
    }

    /* compiled from: EdgeEffectCompat */
    static class a extends b {
        a() {
        }

        public void a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f, f2);
        }
    }

    public static void a(EdgeEffect edgeEffect, float f, float f2) {
        f360a.a(edgeEffect, f, f2);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\widget\d.java ==========

package android.support.v4.widget;

import android.os.Build;
import android.widget.ListView;

/* compiled from: ListViewCompat */
public final class d {
    public static boolean a(ListView listView, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            return listView.canScrollList(i);
        }
        int childCount = listView.getChildCount();
        if (childCount == 0) {
            return false;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (i > 0) {
            int bottom = listView.getChildAt(childCount - 1).getBottom();
            if (firstVisiblePosition + childCount < listView.getCount() || bottom > listView.getHeight() - listView.getListPaddingBottom()) {
                return true;
            }
            return false;
        }
        int top = listView.getChildAt(0).getTop();
        if (firstVisiblePosition > 0 || top < listView.getListPaddingTop()) {
            return true;
        }
        return false;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v4\widget\SwipeRefreshLayout.java ==========

package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.d;
import android.support.v4.view.f;
import android.support.v4.view.g;
import android.support.v4.view.i;
import android.support.v4.view.l;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import net.fxgear.GlobalDefine;

public class SwipeRefreshLayout extends ViewGroup implements d, g {
    private static final int[] D = {16842766};
    private static final String m = "SwipeRefreshLayout";
    private int A;
    private boolean B;
    private final DecelerateInterpolator C;
    private int E;
    private Animation F;
    private Animation G;
    private Animation H;
    private Animation I;
    private Animation J;
    private int K;
    private a L;
    private Animation.AnimationListener M;
    private final Animation N;
    private final Animation O;

    /* renamed from: a  reason: collision with root package name */
    b f337a;

    /* renamed from: b  reason: collision with root package name */
    boolean f338b;
    int c;
    boolean d;
    a e;
    protected int f;
    float g;
    protected int h;
    int i;
    b j;
    boolean k;
    boolean l;
    private View n;
    private int o;
    private float p;
    private float q;
    private final i r;
    private final f s;
    private final int[] t;
    private final int[] u;
    private boolean v;
    private int w;
    private float x;
    private float y;
    private boolean z;

    public interface a {
        boolean a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    public interface b {
        void a();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.e.clearAnimation();
        this.j.stop();
        this.e.setVisibility(8);
        setColorViewAlpha(255);
        if (this.d) {
            setAnimationProgress(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else {
            setTargetOffsetTopAndBottom(this.h - this.c);
        }
        this.c = this.e.getTop();
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (!z2) {
            a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    private void setColorViewAlpha(int i2) {
        this.e.getBackground().setAlpha(i2);
        this.j.setAlpha(i2);
    }

    public void a(boolean z2, int i2, int i3) {
        this.d = z2;
        this.h = i2;
        this.i = i3;
        this.l = true;
        a();
        this.f338b = false;
    }

    public int getProgressViewStartOffset() {
        return this.h;
    }

    public int getProgressViewEndOffset() {
        return this.i;
    }

    public void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i2 == 0) {
                this.K = (int) (displayMetrics.density * 56.0f);
            } else {
                this.K = (int) (displayMetrics.density * 40.0f);
            }
            this.e.setImageDrawable((Drawable) null);
            this.j.a(i2);
            this.e.setImageDrawable(this.j);
        }
    }

    public SwipeRefreshLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f338b = false;
        this.p = -1.0f;
        this.t = new int[2];
        this.u = new int[2];
        this.A = -1;
        this.E = -1;
        this.M = new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (SwipeRefreshLayout.this.f338b) {
                    SwipeRefreshLayout.this.j.setAlpha(255);
                    SwipeRefreshLayout.this.j.start();
                    if (SwipeRefreshLayout.this.k && SwipeRefreshLayout.this.f337a != null) {
                        SwipeRefreshLayout.this.f337a.a();
                    }
                    SwipeRefreshLayout.this.c = SwipeRefreshLayout.this.e.getTop();
                    return;
                }
                SwipeRefreshLayout.this.a();
            }
        };
        this.N = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                int i;
                if (!SwipeRefreshLayout.this.l) {
                    i = SwipeRefreshLayout.this.i - Math.abs(SwipeRefreshLayout.this.h);
                } else {
                    i = SwipeRefreshLayout.this.i;
                }
                SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((SwipeRefreshLayout.this.f + ((int) (((float) (i - SwipeRefreshLayout.this.f)) * f))) - SwipeRefreshLayout.this.e.getTop());
                SwipeRefreshLayout.this.j.b(1.0f - f);
            }
        };
        this.O = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.a(f);
            }
        };
        this.o = ViewConfiguration.get(context).getScaledTouchSlop();
        this.w = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.C = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.K = (int) (displayMetrics.density * 40.0f);
        c();
        l.a((ViewGroup) this, true);
        this.i = (int) (displayMetrics.density * 64.0f);
        this.p = (float) this.i;
        this.r = new i(this);
        this.s = new f(this);
        setNestedScrollingEnabled(true);
        int i2 = -this.K;
        this.c = i2;
        this.h = i2;
        a(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, D);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        if (this.E < 0) {
            return i3;
        }
        if (i3 == i2 - 1) {
            return this.E;
        }
        return i3 >= this.E ? i3 + 1 : i3;
    }

    private void c() {
        this.e = new a(getContext(), -328966);
        this.j = new b(getContext());
        this.j.a(1);
        this.e.setImageDrawable(this.j);
        this.e.setVisibility(8);
        addView(this.e);
    }

    public void setOnRefreshListener(b bVar) {
        this.f337a = bVar;
    }

    public void setRefreshing(boolean z2) {
        int i2;
        if (!z2 || this.f338b == z2) {
            a(z2, false);
            return;
        }
        this.f338b = z2;
        if (!this.l) {
            i2 = this.i + this.h;
        } else {
            i2 = this.i;
        }
        setTargetOffsetTopAndBottom(i2 - this.c);
        this.k = false;
        b(this.M);
    }

    private void b(Animation.AnimationListener animationListener) {
        this.e.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 11) {
            this.j.setAlpha(255);
        }
        this.F = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f);
            }
        };
        this.F.setDuration((long) this.w);
        if (animationListener != null) {
            this.e.a(animationListener);
        }
        this.e.clearAnimation();
        this.e.startAnimation(this.F);
    }

    /* access modifiers changed from: package-private */
    public void setAnimationProgress(float f2) {
        this.e.setScaleX(f2);
        this.e.setScaleY(f2);
    }

    private void a(boolean z2, boolean z3) {
        if (this.f338b != z2) {
            this.k = z3;
            f();
            this.f338b = z2;
            if (this.f338b) {
                a(this.c, this.M);
            } else {
                a(this.M);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Animation.AnimationListener animationListener) {
        this.G = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
            }
        };
        this.G.setDuration(150);
        this.e.a(animationListener);
        this.e.clearAnimation();
        this.e.startAnimation(this.G);
    }

    private void d() {
        this.H = a(this.j.getAlpha(), 76);
    }

    private void e() {
        this.I = a(this.j.getAlpha(), 255);
    }

    private Animation a(final int i2, final int i3) {
        AnonymousClass4 r0 = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.j.setAlpha((int) (((float) i2) + (((float) (i3 - i2)) * f)));
            }
        };
        r0.setDuration(300);
        this.e.a((Animation.AnimationListener) null);
        this.e.clearAnimation();
        this.e.startAnimation(r0);
        return r0;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeResource(int i2) {
        setProgressBackgroundColorSchemeColor(android.support.v4.b.a.b(getContext(), i2));
    }

    public void setProgressBackgroundColorSchemeColor(int i2) {
        this.e.setBackgroundColor(i2);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = android.support.v4.b.a.b(context, iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        f();
        this.j.a(iArr);
    }

    private void f() {
        if (this.n == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.e)) {
                    this.n = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i2) {
        this.p = (float) i2;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.n == null) {
                f();
            }
            if (this.n != null) {
                View view = this.n;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.e.getMeasuredWidth();
                int i6 = measuredWidth / 2;
                int i7 = measuredWidth2 / 2;
                this.e.layout(i6 - i7, this.c, i6 + i7, this.c + this.e.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.n == null) {
            f();
        }
        if (this.n != null) {
            this.n.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.e.measure(View.MeasureSpec.makeMeasureSpec(this.K, 1073741824), View.MeasureSpec.makeMeasureSpec(this.K, 1073741824));
            this.E = -1;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                if (getChildAt(i4) == this.e) {
                    this.E = i4;
                    return;
                }
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.K;
    }

    public boolean b() {
        if (this.L != null) {
            return this.L.a(this, this.n);
        }
        if (this.n instanceof ListView) {
            return d.a((ListView) this.n, -1);
        }
        return this.n.canScrollVertically(-1);
    }

    public void setOnChildScrollUpCallback(a aVar) {
        this.L = aVar;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        f();
        int actionMasked = motionEvent.getActionMasked();
        if (this.B && actionMasked == 0) {
            this.B = false;
        }
        if (!isEnabled() || this.B || b() || this.f338b || this.v) {
            return false;
        }
        if (actionMasked != 6) {
            switch (actionMasked) {
                case 0:
                    setTargetOffsetTopAndBottom(this.h - this.e.getTop());
                    this.A = motionEvent.getPointerId(0);
                    this.z = false;
                    int findPointerIndex = motionEvent.findPointerIndex(this.A);
                    if (findPointerIndex >= 0) {
                        this.y = motionEvent.getY(findPointerIndex);
                        break;
                    } else {
                        return false;
                    }
                case 1:
                case 3:
                    this.z = false;
                    this.A = -1;
                    break;
                case 2:
                    if (this.A != -1) {
                        int findPointerIndex2 = motionEvent.findPointerIndex(this.A);
                        if (findPointerIndex2 >= 0) {
                            d(motionEvent.getY(findPointerIndex2));
                            break;
                        } else {
                            return false;
                        }
                    } else {
                        Log.e(m, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
            }
        } else {
            a(motionEvent);
        }
        return this.z;
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (Build.VERSION.SDK_INT < 21 && (this.n instanceof AbsListView)) {
            return;
        }
        if (this.n == null || l.h(this.n)) {
            super.requestDisallowInterceptTouchEvent(z2);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return isEnabled() && !this.B && !this.f338b && (i2 & 2) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.r.a(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.q = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        this.v = true;
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0 && this.q > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
            float f2 = (float) i3;
            if (f2 > this.q) {
                iArr[1] = i3 - ((int) this.q);
                this.q = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            } else {
                this.q -= f2;
                iArr[1] = i3;
            }
            b(this.q);
        }
        if (this.l && i3 > 0 && this.q == GlobalDefine.DEFAULT_AUTO_FILTER_VALUE && Math.abs(i3 - iArr[1]) > 0) {
            this.e.setVisibility(8);
        }
        int[] iArr2 = this.t;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, (int[]) null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    public int getNestedScrollAxes() {
        return this.r.a();
    }

    public void onStopNestedScroll(View view) {
        this.r.a(view);
        this.v = false;
        if (this.q > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
            c(this.q);
            this.q = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        }
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        dispatchNestedScroll(i2, i3, i4, i5, this.u);
        int i6 = i5 + this.u[1];
        if (i6 < 0 && !b()) {
            this.q += (float) Math.abs(i6);
            b(this.q);
        }
    }

    public void setNestedScrollingEnabled(boolean z2) {
        this.s.a(z2);
    }

    public boolean isNestedScrollingEnabled() {
        return this.s.a();
    }

    public boolean startNestedScroll(int i2) {
        return this.s.b(i2);
    }

    public void stopNestedScroll() {
        this.s.c();
    }

    public boolean hasNestedScrollingParent() {
        return this.s.b();
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.s.a(i2, i3, i4, i5, iArr);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.s.a(i2, i3, iArr, iArr2);
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        return dispatchNestedFling(f2, f3, z2);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.s.a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.s.a(f2, f3);
    }

    private boolean a(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    private void b(float f2) {
        this.j.a(true);
        float min = Math.min(1.0f, Math.abs(f2 / this.p));
        double d2 = (double) min;
        Double.isNaN(d2);
        float max = (((float) Math.max(d2 - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f2) - this.p;
        float f3 = (float) (this.l ? this.i - this.h : this.i);
        double max2 = (double) (Math.max(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, Math.min(abs, f3 * 2.0f) / f3) / 4.0f);
        double pow = Math.pow(max2, 2.0d);
        Double.isNaN(max2);
        float f4 = ((float) (max2 - pow)) * 2.0f;
        int i2 = this.h + ((int) ((f3 * min) + (f3 * f4 * 2.0f)));
        if (this.e.getVisibility() != 0) {
            this.e.setVisibility(0);
        }
        if (!this.d) {
            this.e.setScaleX(1.0f);
            this.e.setScaleY(1.0f);
        }
        if (this.d) {
            setAnimationProgress(Math.min(1.0f, f2 / this.p));
        }
        if (f2 < this.p) {
            if (this.j.getAlpha() > 76 && !a(this.H)) {
                d();
            }
        } else if (this.j.getAlpha() < 255 && !a(this.I)) {
            e();
        }
        this.j.a((float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, Math.min(0.8f, max * 0.8f));
        this.j.b(Math.min(1.0f, max));
        this.j.c((((max * 0.4f) - 16.0f) + (f4 * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i2 - this.c);
    }

    private void c(float f2) {
        if (f2 > this.p) {
            a(true, true);
            return;
        }
        this.f338b = false;
        this.j.a((float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        AnonymousClass5 r0 = null;
        if (!this.d) {
            r0 = new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    if (!SwipeRefreshLayout.this.d) {
                        SwipeRefreshLayout.this.a((Animation.AnimationListener) null);
                    }
                }
            };
        }
        b(this.c, r0);
        this.j.a(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.B && actionMasked == 0) {
            this.B = false;
        }
        if (!isEnabled() || this.B || b() || this.f338b || this.v) {
            return false;
        }
        switch (actionMasked) {
            case 0:
                this.A = motionEvent.getPointerId(0);
                this.z = false;
                return true;
            case 1:
                int findPointerIndex = motionEvent.findPointerIndex(this.A);
                if (findPointerIndex < 0) {
                    Log.e(m, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.z) {
                    this.z = false;
                    c((motionEvent.getY(findPointerIndex) - this.x) * 0.5f);
                }
                this.A = -1;
                return false;
            case 2:
                int findPointerIndex2 = motionEvent.findPointerIndex(this.A);
                if (findPointerIndex2 < 0) {
                    Log.e(m, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y2 = motionEvent.getY(findPointerIndex2);
                d(y2);
                if (!this.z) {
                    return true;
                }
                float f2 = (y2 - this.x) * 0.5f;
                if (f2 <= GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                    return false;
                }
                b(f2);
                return true;
            case 3:
                return false;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    Log.e(m, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.A = motionEvent.getPointerId(actionIndex);
                return true;
            case 6:
                a(motionEvent);
                return true;
            default:
                return true;
        }
    }

    private void d(float f2) {
        if (f2 - this.y > ((float) this.o) && !this.z) {
            this.x = this.y + ((float) this.o);
            this.z = true;
            this.j.setAlpha(76);
        }
    }

    private void a(int i2, Animation.AnimationListener animationListener) {
        this.f = i2;
        this.N.reset();
        this.N.setDuration(200);
        this.N.setInterpolator(this.C);
        if (animationListener != null) {
            this.e.a(animationListener);
        }
        this.e.clearAnimation();
        this.e.startAnimation(this.N);
    }

    private void b(int i2, Animation.AnimationListener animationListener) {
        if (this.d) {
            c(i2, animationListener);
            return;
        }
        this.f = i2;
        this.O.reset();
        this.O.setDuration(200);
        this.O.setInterpolator(this.C);
        if (animationListener != null) {
            this.e.a(animationListener);
        }
        this.e.clearAnimation();
        this.e.startAnimation(this.O);
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        setTargetOffsetTopAndBottom((this.f + ((int) (((float) (this.h - this.f)) * f2))) - this.e.getTop());
    }

    private void c(int i2, Animation.AnimationListener animationListener) {
        this.f = i2;
        this.g = this.e.getScaleX();
        this.J = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(SwipeRefreshLayout.this.g + ((-SwipeRefreshLayout.this.g) * f));
                SwipeRefreshLayout.this.a(f);
            }
        };
        this.J.setDuration(150);
        if (animationListener != null) {
            this.e.a(animationListener);
        }
        this.e.clearAnimation();
        this.e.startAnimation(this.J);
    }

    /* access modifiers changed from: package-private */
    public void setTargetOffsetTopAndBottom(int i2) {
        this.e.bringToFront();
        l.b((View) this.e, i2);
        this.c = this.e.getTop();
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.A) {
            this.A = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v7\a\a.java ==========

package android.support.v7.a;

/* compiled from: R */
public final class a {

    /* renamed from: android.support.v7.a.a$a  reason: collision with other inner class name */
    /* compiled from: R */
    public static final class C0019a {
        public static final int compat_button_inset_horizontal_material = 2131034236;
        public static final int compat_button_inset_vertical_material = 2131034237;
        public static final int compat_button_padding_horizontal_material = 2131034238;
        public static final int compat_button_padding_vertical_material = 2131034239;
        public static final int compat_control_corner_material = 2131034240;
        public static final int fastscroll_default_thickness = 2131034312;
        public static final int fastscroll_margin = 2131034313;
        public static final int fastscroll_minimum_range = 2131034314;
        public static final int item_touch_helper_max_drag_scroll_per_frame = 2131034336;
        public static final int item_touch_helper_swipe_escape_max_velocity = 2131034337;
        public static final int item_touch_helper_swipe_escape_velocity = 2131034338;
        public static final int notification_action_icon_size = 2131034398;
        public static final int notification_action_text_size = 2131034399;
        public static final int notification_big_circle_margin = 2131034400;
        public static final int notification_content_margin_start = 2131034401;
        public static final int notification_large_icon_height = 2131034402;
        public static final int notification_large_icon_width = 2131034403;
        public static final int notification_main_column_padding_top = 2131034404;
        public static final int notification_media_narrow_margin = 2131034405;
        public static final int notification_right_icon_size = 2131034406;
        public static final int notification_right_side_padding_top = 2131034407;
        public static final int notification_small_icon_background_padding = 2131034408;
        public static final int notification_small_icon_size_as_large = 2131034409;
        public static final int notification_subtext_size = 2131034410;
        public static final int notification_top_pad = 2131034411;
        public static final int notification_top_pad_large_text = 2131034412;
    }

    /* compiled from: R */
    public static final class b {
        public static final int[] FontFamily = {2130837510, 2130837511, 2130837512, 2130837513, 2130837514, 2130837515};
        public static final int[] FontFamilyFont = {2130837509, 2130837516, 2130837517};
        public static final int FontFamilyFont_font = 0;
        public static final int FontFamilyFont_fontStyle = 1;
        public static final int FontFamilyFont_fontWeight = 2;
        public static final int FontFamily_fontProviderAuthority = 0;
        public static final int FontFamily_fontProviderCerts = 1;
        public static final int FontFamily_fontProviderFetchStrategy = 2;
        public static final int FontFamily_fontProviderFetchTimeout = 3;
        public static final int FontFamily_fontProviderPackage = 4;
        public static final int FontFamily_fontProviderQuery = 5;
        public static final int[] RecyclerView = {16842948, 16842993, 2130837504, 2130837505, 2130837506, 2130837507, 2130837508, 2130837518, 2130837519, 2130837520, 2130837521};
        public static final int RecyclerView_android_descendantFocusability = 1;
        public static final int RecyclerView_android_orientation = 0;
        public static final int RecyclerView_fastScrollEnabled = 2;
        public static final int RecyclerView_fastScrollHorizontalThumbDrawable = 3;
        public static final int RecyclerView_fastScrollHorizontalTrackDrawable = 4;
        public static final int RecyclerView_fastScrollVerticalThumbDrawable = 5;
        public static final int RecyclerView_fastScrollVerticalTrackDrawable = 6;
        public static final int RecyclerView_layoutManager = 7;
        public static final int RecyclerView_reverseLayout = 8;
        public static final int RecyclerView_spanCount = 9;
        public static final int RecyclerView_stackFromEnd = 10;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v7\widget\a.java ==========

package android.support.v7.widget;

import android.support.v4.d.e;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AdapterHelper */
class a implements g.a {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<b> f430a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<b> f431b;
    final C0020a c;
    Runnable d;
    final boolean e;
    final g f;
    private e.a<b> g;
    private int h;

    /* renamed from: android.support.v7.widget.a$a  reason: collision with other inner class name */
    /* compiled from: AdapterHelper */
    interface C0020a {
        RecyclerView.w a(int i);

        void a(int i, int i2);

        void a(int i, int i2, Object obj);

        void a(b bVar);

        void b(int i, int i2);

        void b(b bVar);

        void c(int i, int i2);

        void d(int i, int i2);
    }

    a(C0020a aVar) {
        this(aVar, false);
    }

    a(C0020a aVar, boolean z) {
        this.g = new e.b(30);
        this.f430a = new ArrayList<>();
        this.f431b = new ArrayList<>();
        this.h = 0;
        this.c = aVar;
        this.e = z;
        this.f = new g(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        a((List<b>) this.f430a);
        a((List<b>) this.f431b);
        this.h = 0;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f.a(this.f430a);
        int size = this.f430a.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f430a.get(i);
            int i2 = bVar.f432a;
            if (i2 == 4) {
                d(bVar);
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        f(bVar);
                        break;
                    case 2:
                        c(bVar);
                        break;
                }
            } else {
                b(bVar);
            }
            if (this.d != null) {
                this.d.run();
            }
        }
        this.f430a.clear();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        int size = this.f431b.size();
        for (int i = 0; i < size; i++) {
            this.c.b(this.f431b.get(i));
        }
        a((List<b>) this.f431b);
        this.h = 0;
    }

    private void b(b bVar) {
        g(bVar);
    }

    private void c(b bVar) {
        char c2;
        boolean z;
        boolean z2;
        int i = bVar.f433b;
        int i2 = bVar.f433b + bVar.d;
        int i3 = bVar.f433b;
        int i4 = 0;
        char c3 = 65535;
        while (i3 < i2) {
            if (this.c.a(i3) != null || d(i3)) {
                if (c3 == 0) {
                    e(a(2, i, i4, (Object) null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                c2 = 1;
            } else {
                if (c3 == 1) {
                    g(a(2, i, i4, (Object) null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            c3 = c2;
        }
        if (i4 != bVar.d) {
            a(bVar);
            bVar = a(2, i, i4, (Object) null);
        }
        if (c3 == 0) {
            e(bVar);
        } else {
            g(bVar);
        }
    }

    private void d(b bVar) {
        int i = bVar.f433b;
        int i2 = bVar.f433b + bVar.d;
        char c2 = 65535;
        int i3 = i;
        int i4 = 0;
        for (int i5 = bVar.f433b; i5 < i2; i5++) {
            if (this.c.a(i5) != null || d(i5)) {
                if (c2 == 0) {
                    e(a(4, i3, i4, bVar.c));
                    i3 = i5;
                    i4 = 0;
                }
                c2 = 1;
            } else {
                if (c2 == 1) {
                    g(a(4, i3, i4, bVar.c));
                    i3 = i5;
                    i4 = 0;
                }
                c2 = 0;
            }
            i4++;
        }
        if (i4 != bVar.d) {
            Object obj = bVar.c;
            a(bVar);
            bVar = a(4, i3, i4, obj);
        }
        if (c2 == 0) {
            e(bVar);
        } else {
            g(bVar);
        }
    }

    private void e(b bVar) {
        int i;
        if (bVar.f432a == 1 || bVar.f432a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int b2 = b(bVar.f433b, bVar.f432a);
        int i2 = bVar.f433b;
        int i3 = bVar.f432a;
        if (i3 == 2) {
            i = 0;
        } else if (i3 == 4) {
            i = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i4 = b2;
        int i5 = i2;
        int i6 = 1;
        for (int i7 = 1; i7 < bVar.d; i7++) {
            int b3 = b(bVar.f433b + (i * i7), bVar.f432a);
            int i8 = bVar.f432a;
            if (i8 == 2 ? b3 == i4 : i8 == 4 && b3 == i4 + 1) {
                i6++;
            } else {
                b a2 = a(bVar.f432a, i4, i6, bVar.c);
                a(a2, i5);
                a(a2);
                if (bVar.f432a == 4) {
                    i5 += i6;
                }
                i4 = b3;
                i6 = 1;
            }
        }
        Object obj = bVar.c;
        a(bVar);
        if (i6 > 0) {
            b a3 = a(bVar.f432a, i4, i6, obj);
            a(a3, i5);
            a(a3);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar, int i) {
        this.c.a(bVar);
        int i2 = bVar.f432a;
        if (i2 == 2) {
            this.c.a(i, bVar.d);
        } else if (i2 == 4) {
            this.c.a(i, bVar.d, bVar.c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int b(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.f431b.size() - 1; size >= 0; size--) {
            b bVar = this.f431b.get(size);
            if (bVar.f432a == 8) {
                if (bVar.f433b < bVar.d) {
                    i4 = bVar.f433b;
                    i3 = bVar.d;
                } else {
                    i4 = bVar.d;
                    i3 = bVar.f433b;
                }
                if (i < i4 || i > i3) {
                    if (i < bVar.f433b) {
                        if (i2 == 1) {
                            bVar.f433b++;
                            bVar.d++;
                        } else if (i2 == 2) {
                            bVar.f433b--;
                            bVar.d--;
                        }
                    }
                } else if (i4 == bVar.f433b) {
                    if (i2 == 1) {
                        bVar.d++;
                    } else if (i2 == 2) {
                        bVar.d--;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        bVar.f433b++;
                    } else if (i2 == 2) {
                        bVar.f433b--;
                    }
                    i--;
                }
            } else if (bVar.f433b <= i) {
                if (bVar.f432a == 1) {
                    i -= bVar.d;
                } else if (bVar.f432a == 2) {
                    i += bVar.d;
                }
            } else if (i2 == 1) {
                bVar.f433b++;
            } else if (i2 == 2) {
                bVar.f433b--;
            }
        }
        for (int size2 = this.f431b.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f431b.get(size2);
            if (bVar2.f432a == 8) {
                if (bVar2.d == bVar2.f433b || bVar2.d < 0) {
                    this.f431b.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.d <= 0) {
                this.f431b.remove(size2);
                a(bVar2);
            }
        }
        return i;
    }

    private boolean d(int i) {
        int size = this.f431b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f431b.get(i2);
            if (bVar.f432a == 8) {
                if (a(bVar.d, i2 + 1) == i) {
                    return true;
                }
            } else if (bVar.f432a == 1) {
                int i3 = bVar.f433b + bVar.d;
                for (int i4 = bVar.f433b; i4 < i3; i4++) {
                    if (a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void f(b bVar) {
        g(bVar);
    }

    private void g(b bVar) {
        this.f431b.add(bVar);
        int i = bVar.f432a;
        if (i == 4) {
            this.c.a(bVar.f433b, bVar.d, bVar.c);
        } else if (i != 8) {
            switch (i) {
                case 1:
                    this.c.c(bVar.f433b, bVar.d);
                    return;
                case 2:
                    this.c.b(bVar.f433b, bVar.d);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown update op type for " + bVar);
            }
        } else {
            this.c.d(bVar.f433b, bVar.d);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f430a.size() > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i) {
        return (i & this.h) != 0;
    }

    /* access modifiers changed from: package-private */
    public int b(int i) {
        return a(i, 0);
    }

    /* access modifiers changed from: package-private */
    public int a(int i, int i2) {
        int size = this.f431b.size();
        while (i2 < size) {
            b bVar = this.f431b.get(i2);
            if (bVar.f432a == 8) {
                if (bVar.f433b == i) {
                    i = bVar.d;
                } else {
                    if (bVar.f433b < i) {
                        i--;
                    }
                    if (bVar.d <= i) {
                        i++;
                    }
                }
            } else if (bVar.f433b > i) {
                continue;
            } else if (bVar.f432a == 2) {
                if (i < bVar.f433b + bVar.d) {
                    return -1;
                }
                i -= bVar.d;
            } else if (bVar.f432a == 1) {
                i += bVar.d;
            }
            i2++;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.f430a.add(a(4, i, i2, obj));
        this.h |= 4;
        if (this.f430a.size() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        c();
        int size = this.f430a.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f430a.get(i);
            int i2 = bVar.f432a;
            if (i2 == 4) {
                this.c.b(bVar);
                this.c.a(bVar.f433b, bVar.d, bVar.c);
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        this.c.b(bVar);
                        this.c.c(bVar.f433b, bVar.d);
                        break;
                    case 2:
                        this.c.b(bVar);
                        this.c.a(bVar.f433b, bVar.d);
                        break;
                }
            } else {
                this.c.b(bVar);
                this.c.d(bVar.f433b, bVar.d);
            }
            if (this.d != null) {
                this.d.run();
            }
        }
        a((List<b>) this.f430a);
        this.h = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0047, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int c(int r6) {
        /*
            r5 = this;
            java.util.ArrayList<android.support.v7.widget.a$b> r0 = r5.f430a
            int r0 = r0.size()
            r1 = 0
        L_0x0007:
            if (r1 >= r0) goto L_0x004a
            java.util.ArrayList<android.support.v7.widget.a$b> r2 = r5.f430a
            java.lang.Object r2 = r2.get(r1)
            android.support.v7.widget.a$b r2 = (android.support.v7.widget.a.b) r2
            int r3 = r2.f432a
            r4 = 8
            if (r3 == r4) goto L_0x0034
            switch(r3) {
                case 1: goto L_0x002c;
                case 2: goto L_0x001b;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x0047
        L_0x001b:
            int r3 = r2.f433b
            if (r3 > r6) goto L_0x0047
            int r3 = r2.f433b
            int r4 = r2.d
            int r3 = r3 + r4
            if (r3 <= r6) goto L_0x0028
            r6 = -1
            return r6
        L_0x0028:
            int r2 = r2.d
            int r6 = r6 - r2
            goto L_0x0047
        L_0x002c:
            int r3 = r2.f433b
            if (r3 > r6) goto L_0x0047
            int r2 = r2.d
            int r6 = r6 + r2
            goto L_0x0047
        L_0x0034:
            int r3 = r2.f433b
            if (r3 != r6) goto L_0x003b
            int r6 = r2.d
            goto L_0x0047
        L_0x003b:
            int r3 = r2.f433b
            if (r3 >= r6) goto L_0x0041
            int r6 = r6 + -1
        L_0x0041:
            int r2 = r2.d
            if (r2 > r6) goto L_0x0047
            int r6 = r6 + 1
        L_0x0047:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x004a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.a.c(int):int");
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return !this.f431b.isEmpty() && !this.f430a.isEmpty();
    }

    /* compiled from: AdapterHelper */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        int f432a;

        /* renamed from: b  reason: collision with root package name */
        int f433b;
        Object c;
        int d;

        b(int i, int i2, int i3, Object obj) {
            this.f432a = i;
            this.f433b = i2;
            this.d = i3;
            this.c = obj;
        }

        /* access modifiers changed from: package-private */
        public String a() {
            int i = this.f432a;
            if (i == 4) {
                return "up";
            }
            if (i == 8) {
                return "mv";
            }
            switch (i) {
                case 1:
                    return "add";
                case 2:
                    return "rm";
                default:
                    return "??";
            }
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f433b + "c:" + this.d + ",p:" + this.c + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f432a != bVar.f432a) {
                return false;
            }
            if (this.f432a == 8 && Math.abs(this.d - this.f433b) == 1 && this.d == bVar.f433b && this.f433b == bVar.d) {
                return true;
            }
            if (this.d != bVar.d || this.f433b != bVar.f433b) {
                return false;
            }
            if (this.c != null) {
                if (!this.c.equals(bVar.c)) {
                    return false;
                }
            } else if (bVar.c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f432a * 31) + this.f433b) * 31) + this.d;
        }
    }

    public b a(int i, int i2, int i3, Object obj) {
        b a2 = this.g.a();
        if (a2 == null) {
            return new b(i, i2, i3, obj);
        }
        a2.f432a = i;
        a2.f433b = i2;
        a2.d = i3;
        a2.c = obj;
        return a2;
    }

    public void a(b bVar) {
        if (!this.e) {
            bVar.c = null;
            this.g.a(bVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(list.get(i));
        }
        list.clear();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v7\widget\b.java ==========

package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChildHelper */
class b {

    /* renamed from: a  reason: collision with root package name */
    final C0021b f434a;

    /* renamed from: b  reason: collision with root package name */
    final a f435b = new a();
    final List<View> c = new ArrayList();

    /* renamed from: android.support.v7.widget.b$b  reason: collision with other inner class name */
    /* compiled from: ChildHelper */
    interface C0021b {
        int a();

        int a(View view);

        void a(int i);

        void a(View view, int i);

        void a(View view, int i, ViewGroup.LayoutParams layoutParams);

        RecyclerView.w b(View view);

        View b(int i);

        void b();

        void c(int i);

        void c(View view);

        void d(View view);
    }

    b(C0021b bVar) {
        this.f434a = bVar;
    }

    private void g(View view) {
        this.c.add(view);
        this.f434a.c(view);
    }

    private boolean h(View view) {
        if (!this.c.remove(view)) {
            return false;
        }
        this.f434a.d(view);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(View view, boolean z) {
        a(view, -1, z);
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i, boolean z) {
        int i2;
        if (i < 0) {
            i2 = this.f434a.a();
        } else {
            i2 = f(i);
        }
        this.f435b.a(i2, z);
        if (z) {
            g(view);
        }
        this.f434a.a(view, i2);
    }

    private int f(int i) {
        if (i < 0) {
            return -1;
        }
        int a2 = this.f434a.a();
        int i2 = i;
        while (i2 < a2) {
            int e = i - (i2 - this.f435b.e(i2));
            if (e == 0) {
                while (this.f435b.c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void a(View view) {
        int a2 = this.f434a.a(view);
        if (a2 >= 0) {
            if (this.f435b.d(a2)) {
                h(view);
            }
            this.f434a.a(a2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        int f = f(i);
        View b2 = this.f434a.b(f);
        if (b2 != null) {
            if (this.f435b.d(f)) {
                h(b2);
            }
            this.f434a.a(f);
        }
    }

    /* access modifiers changed from: package-private */
    public View b(int i) {
        return this.f434a.b(f(i));
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f435b.a();
        for (int size = this.c.size() - 1; size >= 0; size--) {
            this.f434a.d(this.c.get(size));
            this.c.remove(size);
        }
        this.f434a.b();
    }

    /* access modifiers changed from: package-private */
    public View c(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.c.get(i2);
            RecyclerView.w b2 = this.f434a.b(view);
            if (b2.d() == i && !b2.n() && !b2.q()) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int i2;
        if (i < 0) {
            i2 = this.f434a.a();
        } else {
            i2 = f(i);
        }
        this.f435b.a(i2, z);
        if (z) {
            g(view);
        }
        this.f434a.a(view, i2, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f434a.a() - this.c.size();
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f434a.a();
    }

    /* access modifiers changed from: package-private */
    public View d(int i) {
        return this.f434a.b(i);
    }

    /* access modifiers changed from: package-private */
    public void e(int i) {
        int f = f(i);
        this.f435b.d(f);
        this.f434a.c(f);
    }

    /* access modifiers changed from: package-private */
    public int b(View view) {
        int a2 = this.f434a.a(view);
        if (a2 != -1 && !this.f435b.c(a2)) {
            return a2 - this.f435b.e(a2);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean c(View view) {
        return this.c.contains(view);
    }

    /* access modifiers changed from: package-private */
    public void d(View view) {
        int a2 = this.f434a.a(view);
        if (a2 >= 0) {
            this.f435b.a(a2);
            g(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* access modifiers changed from: package-private */
    public void e(View view) {
        int a2 = this.f434a.a(view);
        if (a2 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f435b.c(a2)) {
            this.f435b.b(a2);
            h(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f435b.toString() + ", hidden list:" + this.c.size();
    }

    /* access modifiers changed from: package-private */
    public boolean f(View view) {
        int a2 = this.f434a.a(view);
        if (a2 == -1) {
            h(view);
            return true;
        } else if (!this.f435b.c(a2)) {
            return false;
        } else {
            this.f435b.d(a2);
            h(view);
            this.f434a.a(a2);
            return true;
        }
    }

    /* compiled from: ChildHelper */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        long f436a = 0;

        /* renamed from: b  reason: collision with root package name */
        a f437b;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            if (i >= 64) {
                b();
                this.f437b.a(i - 64);
                return;
            }
            this.f436a |= 1 << i;
        }

        private void b() {
            if (this.f437b == null) {
                this.f437b = new a();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i) {
            if (i < 64) {
                this.f436a &= (1 << i) ^ -1;
            } else if (this.f437b != null) {
                this.f437b.b(i - 64);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c(int i) {
            if (i < 64) {
                return (this.f436a & (1 << i)) != 0;
            }
            b();
            return this.f437b.c(i - 64);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f436a = 0;
            if (this.f437b != null) {
                this.f437b.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i, boolean z) {
            if (i >= 64) {
                b();
                this.f437b.a(i - 64, z);
                return;
            }
            boolean z2 = (this.f436a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.f436a = (this.f436a & j) | (((j ^ -1) & this.f436a) << 1);
            if (z) {
                a(i);
            } else {
                b(i);
            }
            if (z2 || this.f437b != null) {
                b();
                this.f437b.a(0, z2);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(int i) {
            if (i >= 64) {
                b();
                return this.f437b.d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f436a & j) != 0;
            this.f436a &= j ^ -1;
            long j2 = j - 1;
            this.f436a = (this.f436a & j2) | Long.rotateRight((j2 ^ -1) & this.f436a, 1);
            if (this.f437b != null) {
                if (this.f437b.c(0)) {
                    a(63);
                }
                this.f437b.d(0);
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        public int e(int i) {
            if (this.f437b == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f436a);
                }
                return Long.bitCount(this.f436a & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.f436a & ((1 << i) - 1));
            } else {
                return this.f437b.e(i - 64) + Long.bitCount(this.f436a);
            }
        }

        public String toString() {
            if (this.f437b == null) {
                return Long.toBinaryString(this.f436a);
            }
            return this.f437b.toString() + "xx" + Long.toBinaryString(this.f436a);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v7\widget\c.java ==========

package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.l;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.fxgear.GlobalDefine;

/* compiled from: DefaultItemAnimator */
public class c extends k {
    private static TimeInterpolator i;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.w>> f438a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    ArrayList<ArrayList<b>> f439b = new ArrayList<>();
    ArrayList<ArrayList<a>> c = new ArrayList<>();
    ArrayList<RecyclerView.w> d = new ArrayList<>();
    ArrayList<RecyclerView.w> e = new ArrayList<>();
    ArrayList<RecyclerView.w> f = new ArrayList<>();
    ArrayList<RecyclerView.w> g = new ArrayList<>();
    private ArrayList<RecyclerView.w> j = new ArrayList<>();
    private ArrayList<RecyclerView.w> k = new ArrayList<>();
    private ArrayList<b> l = new ArrayList<>();
    private ArrayList<a> m = new ArrayList<>();

    /* compiled from: DefaultItemAnimator */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.w f458a;

        /* renamed from: b  reason: collision with root package name */
        public int f459b;
        public int c;
        public int d;
        public int e;

        b(RecyclerView.w wVar, int i, int i2, int i3, int i4) {
            this.f458a = wVar;
            this.f459b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    /* compiled from: DefaultItemAnimator */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.w f456a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.w f457b;
        public int c;
        public int d;
        public int e;
        public int f;

        private a(RecyclerView.w wVar, RecyclerView.w wVar2) {
            this.f456a = wVar;
            this.f457b = wVar2;
        }

        a(RecyclerView.w wVar, RecyclerView.w wVar2, int i, int i2, int i3, int i4) {
            this(wVar, wVar2);
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f456a + ", newHolder=" + this.f457b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
        }
    }

    public void a() {
        boolean z = !this.j.isEmpty();
        boolean z2 = !this.l.isEmpty();
        boolean z3 = !this.m.isEmpty();
        boolean z4 = !this.k.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.w> it = this.j.iterator();
            while (it.hasNext()) {
                u(it.next());
            }
            this.j.clear();
            if (z2) {
                final ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.l);
                this.f439b.add(arrayList);
                this.l.clear();
                AnonymousClass1 r6 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            c.this.b(bVar.f458a, bVar.f459b, bVar.c, bVar.d, bVar.e);
                        }
                        arrayList.clear();
                        c.this.f439b.remove(arrayList);
                    }
                };
                if (z) {
                    l.a(((b) arrayList.get(0)).f458a.f413a, r6, g());
                } else {
                    r6.run();
                }
            }
            if (z3) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.m);
                this.c.add(arrayList2);
                this.m.clear();
                AnonymousClass2 r62 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            c.this.a((a) it.next());
                        }
                        arrayList2.clear();
                        c.this.c.remove(arrayList2);
                    }
                };
                if (z) {
                    l.a(((a) arrayList2.get(0)).f456a.f413a, r62, g());
                } else {
                    r62.run();
                }
            }
            if (z4) {
                final ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.k);
                this.f438a.add(arrayList3);
                this.k.clear();
                AnonymousClass3 r5 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            c.this.c((RecyclerView.w) it.next());
                        }
                        arrayList3.clear();
                        c.this.f438a.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    long j2 = 0;
                    long g2 = z ? g() : 0;
                    long e2 = z2 ? e() : 0;
                    if (z3) {
                        j2 = h();
                    }
                    l.a(((RecyclerView.w) arrayList3.get(0)).f413a, r5, g2 + Math.max(e2, j2));
                    return;
                }
                r5.run();
            }
        }
    }

    public boolean a(RecyclerView.w wVar) {
        v(wVar);
        this.j.add(wVar);
        return true;
    }

    private void u(final RecyclerView.w wVar) {
        final View view = wVar.f413a;
        final ViewPropertyAnimator animate = view.animate();
        this.f.add(wVar);
        animate.setDuration(g()).alpha(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE).setListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                c.this.l(wVar);
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                view.setAlpha(1.0f);
                c.this.i(wVar);
                c.this.f.remove(wVar);
                c.this.c();
            }
        }).start();
    }

    public boolean b(RecyclerView.w wVar) {
        v(wVar);
        wVar.f413a.setAlpha(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        this.k.add(wVar);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void c(final RecyclerView.w wVar) {
        final View view = wVar.f413a;
        final ViewPropertyAnimator animate = view.animate();
        this.d.add(wVar);
        animate.alpha(1.0f).setDuration(f()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                c.this.n(wVar);
            }

            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                c.this.k(wVar);
                c.this.d.remove(wVar);
                c.this.c();
            }
        }).start();
    }

    public boolean a(RecyclerView.w wVar, int i2, int i3, int i4, int i5) {
        View view = wVar.f413a;
        int translationX = i2 + ((int) wVar.f413a.getTranslationX());
        int translationY = i3 + ((int) wVar.f413a.getTranslationY());
        v(wVar);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            j(wVar);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX((float) (-i6));
        }
        if (i7 != 0) {
            view.setTranslationY((float) (-i7));
        }
        this.l.add(new b(wVar, translationX, translationY, i4, i5));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void b(RecyclerView.w wVar, int i2, int i3, int i4, int i5) {
        final View view = wVar.f413a;
        final int i6 = i4 - i2;
        final int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        }
        if (i7 != 0) {
            view.animate().translationY(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        }
        final ViewPropertyAnimator animate = view.animate();
        this.e.add(wVar);
        final RecyclerView.w wVar2 = wVar;
        animate.setDuration(e()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                c.this.m(wVar2);
            }

            public void onAnimationCancel(Animator animator) {
                if (i6 != 0) {
                    view.setTranslationX(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
                }
                if (i7 != 0) {
                    view.setTranslationY(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
                }
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                c.this.j(wVar2);
                c.this.e.remove(wVar2);
                c.this.c();
            }
        }).start();
    }

    public boolean a(RecyclerView.w wVar, RecyclerView.w wVar2, int i2, int i3, int i4, int i5) {
        if (wVar == wVar2) {
            return a(wVar, i2, i3, i4, i5);
        }
        float translationX = wVar.f413a.getTranslationX();
        float translationY = wVar.f413a.getTranslationY();
        float alpha = wVar.f413a.getAlpha();
        v(wVar);
        int i6 = (int) (((float) (i4 - i2)) - translationX);
        int i7 = (int) (((float) (i5 - i3)) - translationY);
        wVar.f413a.setTranslationX(translationX);
        wVar.f413a.setTranslationY(translationY);
        wVar.f413a.setAlpha(alpha);
        if (wVar2 != null) {
            v(wVar2);
            wVar2.f413a.setTranslationX((float) (-i6));
            wVar2.f413a.setTranslationY((float) (-i7));
            wVar2.f413a.setAlpha(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        }
        this.m.add(new a(wVar, wVar2, i2, i3, i4, i5));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(final a aVar) {
        final View view;
        RecyclerView.w wVar = aVar.f456a;
        final View view2 = null;
        if (wVar == null) {
            view = null;
        } else {
            view = wVar.f413a;
        }
        RecyclerView.w wVar2 = aVar.f457b;
        if (wVar2 != null) {
            view2 = wVar2.f413a;
        }
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(h());
            this.g.add(aVar.f456a);
            duration.translationX((float) (aVar.e - aVar.c));
            duration.translationY((float) (aVar.f - aVar.d));
            duration.alpha(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE).setListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    c.this.b(aVar.f456a, true);
                }

                public void onAnimationEnd(Animator animator) {
                    duration.setListener((Animator.AnimatorListener) null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
                    view.setTranslationY(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
                    c.this.a(aVar.f456a, true);
                    c.this.g.remove(aVar.f456a);
                    c.this.c();
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator animate = view2.animate();
            this.g.add(aVar.f457b);
            animate.translationX(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE).translationY(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE).setDuration(h()).alpha(1.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    c.this.b(aVar.f457b, false);
                }

                public void onAnimationEnd(Animator animator) {
                    animate.setListener((Animator.AnimatorListener) null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
                    view2.setTranslationY(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
                    c.this.a(aVar.f457b, false);
                    c.this.g.remove(aVar.f457b);
                    c.this.c();
                }
            }).start();
        }
    }

    private void a(List<a> list, RecyclerView.w wVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = list.get(size);
            if (a(aVar, wVar) && aVar.f456a == null && aVar.f457b == null) {
                list.remove(aVar);
            }
        }
    }

    private void b(a aVar) {
        if (aVar.f456a != null) {
            a(aVar, aVar.f456a);
        }
        if (aVar.f457b != null) {
            a(aVar, aVar.f457b);
        }
    }

    private boolean a(a aVar, RecyclerView.w wVar) {
        boolean z = false;
        if (aVar.f457b == wVar) {
            aVar.f457b = null;
        } else if (aVar.f456a != wVar) {
            return false;
        } else {
            aVar.f456a = null;
            z = true;
        }
        wVar.f413a.setAlpha(1.0f);
        wVar.f413a.setTranslationX(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        wVar.f413a.setTranslationY(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        a(wVar, z);
        return true;
    }

    public void d(RecyclerView.w wVar) {
        View view = wVar.f413a;
        view.animate().cancel();
        int size = this.l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.l.get(size).f458a == wVar) {
                view.setTranslationY(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
                view.setTranslationX(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
                j(wVar);
                this.l.remove(size);
            }
        }
        a((List<a>) this.m, wVar);
        if (this.j.remove(wVar)) {
            view.setAlpha(1.0f);
            i(wVar);
        }
        if (this.k.remove(wVar)) {
            view.setAlpha(1.0f);
            k(wVar);
        }
        for (int size2 = this.c.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.c.get(size2);
            a((List<a>) arrayList, wVar);
            if (arrayList.isEmpty()) {
                this.c.remove(size2);
            }
        }
        for (int size3 = this.f439b.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.f439b.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((b) arrayList2.get(size4)).f458a == wVar) {
                    view.setTranslationY(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
                    view.setTranslationX(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
                    j(wVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f439b.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f438a.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.f438a.get(size5);
            if (arrayList3.remove(wVar)) {
                view.setAlpha(1.0f);
                k(wVar);
                if (arrayList3.isEmpty()) {
                    this.f438a.remove(size5);
                }
            }
        }
        this.f.remove(wVar);
        this.d.remove(wVar);
        this.g.remove(wVar);
        this.e.remove(wVar);
        c();
    }

    private void v(RecyclerView.w wVar) {
        if (i == null) {
            i = new ValueAnimator().getInterpolator();
        }
        wVar.f413a.animate().setInterpolator(i);
        d(wVar);
    }

    public boolean b() {
        return !this.k.isEmpty() || !this.m.isEmpty() || !this.l.isEmpty() || !this.j.isEmpty() || !this.e.isEmpty() || !this.f.isEmpty() || !this.d.isEmpty() || !this.g.isEmpty() || !this.f439b.isEmpty() || !this.f438a.isEmpty() || !this.c.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (!b()) {
            i();
        }
    }

    public void d() {
        int size = this.l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b bVar = this.l.get(size);
            View view = bVar.f458a.f413a;
            view.setTranslationY(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
            view.setTranslationX(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
            j(bVar.f458a);
            this.l.remove(size);
        }
        for (int size2 = this.j.size() - 1; size2 >= 0; size2--) {
            i(this.j.get(size2));
            this.j.remove(size2);
        }
        int size3 = this.k.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.w wVar = this.k.get(size3);
            wVar.f413a.setAlpha(1.0f);
            k(wVar);
            this.k.remove(size3);
        }
        for (int size4 = this.m.size() - 1; size4 >= 0; size4--) {
            b(this.m.get(size4));
        }
        this.m.clear();
        if (b()) {
            for (int size5 = this.f439b.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.f439b.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    b bVar2 = (b) arrayList.get(size6);
                    View view2 = bVar2.f458a.f413a;
                    view2.setTranslationY(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
                    view2.setTranslationX(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
                    j(bVar2.f458a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f439b.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f438a.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.f438a.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.w wVar2 = (RecyclerView.w) arrayList2.get(size8);
                    wVar2.f413a.setAlpha(1.0f);
                    k(wVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f438a.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.c.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.c.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    b((a) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.c.remove(arrayList3);
                    }
                }
            }
            a((List<RecyclerView.w>) this.f);
            a((List<RecyclerView.w>) this.e);
            a((List<RecyclerView.w>) this.d);
            a((List<RecyclerView.w>) this.g);
            i();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(List<RecyclerView.w> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).f413a.animate().cancel();
        }
    }

    public boolean a(RecyclerView.w wVar, List<Object> list) {
        return !list.isEmpty() || super.a(wVar, list);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v7\widget\d.java ==========

package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.view.l;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import net.fxgear.GlobalDefine;

/* compiled from: FastScroller */
class d extends RecyclerView.g implements RecyclerView.l {
    private static final int[] g = {16842919};
    private static final int[] h = new int[0];
    private final int[] A = new int[2];
    /* access modifiers changed from: private */
    public final ValueAnimator B = ValueAnimator.ofFloat(new float[]{GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f});
    /* access modifiers changed from: private */
    public int C = 0;
    private final Runnable D = new Runnable() {
        public void run() {
            d.this.a(500);
        }
    };
    private final RecyclerView.m E = new RecyclerView.m() {
        public void a(RecyclerView recyclerView, int i, int i2) {
            d.this.a(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    int f460a;

    /* renamed from: b  reason: collision with root package name */
    int f461b;
    float c;
    int d;
    int e;
    float f;
    private final int i;
    private final int j;
    /* access modifiers changed from: private */
    public final StateListDrawable k;
    /* access modifiers changed from: private */
    public final Drawable l;
    private final int m;
    private final int n;
    private final StateListDrawable o;
    private final Drawable p;
    private final int q;
    private final int r;
    private int s = 0;
    private int t = 0;
    private RecyclerView u;
    private boolean v = false;
    private boolean w = false;
    private int x = 0;
    private int y = 0;
    private final int[] z = new int[2];

    public void a(boolean z2) {
    }

    d(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        this.k = stateListDrawable;
        this.l = drawable;
        this.o = stateListDrawable2;
        this.p = drawable2;
        this.m = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.n = Math.max(i2, drawable.getIntrinsicWidth());
        this.q = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.r = Math.max(i2, drawable2.getIntrinsicWidth());
        this.i = i3;
        this.j = i4;
        this.k.setAlpha(255);
        this.l.setAlpha(255);
        this.B.addListener(new a());
        this.B.addUpdateListener(new b());
        a(recyclerView);
    }

    public void a(RecyclerView recyclerView) {
        if (this.u != recyclerView) {
            if (this.u != null) {
                c();
            }
            this.u = recyclerView;
            if (this.u != null) {
                b();
            }
        }
    }

    private void b() {
        this.u.a((RecyclerView.g) this);
        this.u.a((RecyclerView.l) this);
        this.u.a(this.E);
    }

    private void c() {
        this.u.b((RecyclerView.g) this);
        this.u.b((RecyclerView.l) this);
        this.u.b(this.E);
        f();
    }

    /* access modifiers changed from: private */
    public void d() {
        this.u.invalidate();
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        if (i2 == 2 && this.x != 2) {
            this.k.setState(g);
            f();
        }
        if (i2 == 0) {
            d();
        } else {
            a();
        }
        if (this.x == 2 && i2 != 2) {
            this.k.setState(h);
            c(1200);
        } else if (i2 == 1) {
            c(1500);
        }
        this.x = i2;
    }

    private boolean e() {
        return l.e(this.u) == 1;
    }

    public void a() {
        int i2 = this.C;
        if (i2 != 0) {
            if (i2 == 3) {
                this.B.cancel();
            } else {
                return;
            }
        }
        this.C = 1;
        this.B.setFloatValues(new float[]{((Float) this.B.getAnimatedValue()).floatValue(), 1.0f});
        this.B.setDuration(500);
        this.B.setStartDelay(0);
        this.B.start();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        switch (this.C) {
            case 1:
                this.B.cancel();
                break;
            case 2:
                break;
            default:
                return;
        }
        this.C = 3;
        this.B.setFloatValues(new float[]{((Float) this.B.getAnimatedValue()).floatValue(), 0.0f});
        this.B.setDuration((long) i2);
        this.B.start();
    }

    private void f() {
        this.u.removeCallbacks(this.D);
    }

    private void c(int i2) {
        f();
        this.u.postDelayed(this.D, (long) i2);
    }

    public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.t tVar) {
        if (this.s != this.u.getWidth() || this.t != this.u.getHeight()) {
            this.s = this.u.getWidth();
            this.t = this.u.getHeight();
            b(0);
        } else if (this.C != 0) {
            if (this.v) {
                a(canvas);
            }
            if (this.w) {
                b(canvas);
            }
        }
    }

    private void a(Canvas canvas) {
        int i2 = this.s - this.m;
        int i3 = this.f461b - (this.f460a / 2);
        this.k.setBounds(0, 0, this.m, this.f460a);
        this.l.setBounds(0, 0, this.n, this.t);
        if (e()) {
            this.l.draw(canvas);
            canvas.translate((float) this.m, (float) i3);
            canvas.scale(-1.0f, 1.0f);
            this.k.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            canvas.translate((float) (-this.m), (float) (-i3));
            return;
        }
        canvas.translate((float) i2, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        this.l.draw(canvas);
        canvas.translate(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, (float) i3);
        this.k.draw(canvas);
        canvas.translate((float) (-i2), (float) (-i3));
    }

    private void b(Canvas canvas) {
        int i2 = this.t - this.q;
        int i3 = this.e - (this.d / 2);
        this.o.setBounds(0, 0, this.d, this.q);
        this.p.setBounds(0, 0, this.s, this.r);
        canvas.translate(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, (float) i2);
        this.p.draw(canvas);
        canvas.translate((float) i3, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        this.o.draw(canvas);
        canvas.translate((float) (-i3), (float) (-i2));
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3) {
        int computeVerticalScrollRange = this.u.computeVerticalScrollRange();
        int i4 = this.t;
        this.v = computeVerticalScrollRange - i4 > 0 && this.t >= this.i;
        int computeHorizontalScrollRange = this.u.computeHorizontalScrollRange();
        int i5 = this.s;
        this.w = computeHorizontalScrollRange - i5 > 0 && this.s >= this.i;
        if (this.v || this.w) {
            if (this.v) {
                float f2 = (float) i4;
                this.f461b = (int) ((f2 * (((float) i3) + (f2 / 2.0f))) / ((float) computeVerticalScrollRange));
                this.f460a = Math.min(i4, (i4 * i4) / computeVerticalScrollRange);
            }
            if (this.w) {
                float f3 = (float) i5;
                this.e = (int) ((f3 * (((float) i2) + (f3 / 2.0f))) / ((float) computeHorizontalScrollRange));
                this.d = Math.min(i5, (i5 * i5) / computeHorizontalScrollRange);
            }
            if (this.x == 0 || this.x == 1) {
                b(1);
            }
        } else if (this.x != 0) {
            b(0);
        }
    }

    public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.x == 1) {
            boolean a2 = a(motionEvent.getX(), motionEvent.getY());
            boolean b2 = b(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!a2 && !b2) {
                return false;
            }
            if (b2) {
                this.y = 1;
                this.f = (float) ((int) motionEvent.getX());
            } else if (a2) {
                this.y = 2;
                this.c = (float) ((int) motionEvent.getY());
            }
            b(2);
        } else if (this.x == 2) {
            return true;
        } else {
            return false;
        }
        return true;
    }

    public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.x != 0) {
            if (motionEvent.getAction() == 0) {
                boolean a2 = a(motionEvent.getX(), motionEvent.getY());
                boolean b2 = b(motionEvent.getX(), motionEvent.getY());
                if (a2 || b2) {
                    if (b2) {
                        this.y = 1;
                        this.f = (float) ((int) motionEvent.getX());
                    } else if (a2) {
                        this.y = 2;
                        this.c = (float) ((int) motionEvent.getY());
                    }
                    b(2);
                }
            } else if (motionEvent.getAction() == 1 && this.x == 2) {
                this.c = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                this.f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                b(1);
                this.y = 0;
            } else if (motionEvent.getAction() == 2 && this.x == 2) {
                a();
                if (this.y == 1) {
                    b(motionEvent.getX());
                }
                if (this.y == 2) {
                    a(motionEvent.getY());
                }
            }
        }
    }

    private void a(float f2) {
        int[] g2 = g();
        float max = Math.max((float) g2[0], Math.min((float) g2[1], f2));
        if (Math.abs(((float) this.f461b) - max) >= 2.0f) {
            int a2 = a(this.c, max, g2, this.u.computeVerticalScrollRange(), this.u.computeVerticalScrollOffset(), this.t);
            if (a2 != 0) {
                this.u.scrollBy(0, a2);
            }
            this.c = max;
        }
    }

    private void b(float f2) {
        int[] h2 = h();
        float max = Math.max((float) h2[0], Math.min((float) h2[1], f2));
        if (Math.abs(((float) this.e) - max) >= 2.0f) {
            int a2 = a(this.f, max, h2, this.u.computeHorizontalScrollRange(), this.u.computeHorizontalScrollOffset(), this.s);
            if (a2 != 0) {
                this.u.scrollBy(a2, 0);
            }
            this.f = max;
        }
    }

    private int a(float f2, float f3, int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 == 0) {
            return 0;
        }
        int i6 = i2 - i4;
        int i7 = (int) (((f3 - f2) / ((float) i5)) * ((float) i6));
        int i8 = i3 + i7;
        if (i8 >= i6 || i8 < 0) {
            return 0;
        }
        return i7;
    }

    /* access modifiers changed from: package-private */
    public boolean a(float f2, float f3) {
        if (!e() ? f2 >= ((float) (this.s - this.m)) : f2 <= ((float) (this.m / 2))) {
            return f3 >= ((float) (this.f461b - (this.f460a / 2))) && f3 <= ((float) (this.f461b + (this.f460a / 2)));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(float f2, float f3) {
        return f3 >= ((float) (this.t - this.q)) && f2 >= ((float) (this.e - (this.d / 2))) && f2 <= ((float) (this.e + (this.d / 2)));
    }

    private int[] g() {
        this.z[0] = this.j;
        this.z[1] = this.t - this.j;
        return this.z;
    }

    private int[] h() {
        this.A[0] = this.j;
        this.A[1] = this.s - this.j;
        return this.A;
    }

    /* compiled from: FastScroller */
    private class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private boolean f465b;

        private a() {
            this.f465b = false;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f465b) {
                this.f465b = false;
            } else if (((Float) d.this.B.getAnimatedValue()).floatValue() == GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                int unused = d.this.C = 0;
                d.this.b(0);
            } else {
                int unused2 = d.this.C = 2;
                d.this.d();
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.f465b = true;
        }
    }

    /* compiled from: FastScroller */
    private class b implements ValueAnimator.AnimatorUpdateListener {
        private b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            d.this.k.setAlpha(floatValue);
            d.this.l.setAlpha(floatValue);
            d.this.d();
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v7\widget\e.java ==========

package android.support.v7.widget;

import android.support.v4.c.c;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* compiled from: GapWorker */
final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    static final ThreadLocal<e> f467a = new ThreadLocal<>();
    static Comparator<b> e = new Comparator<b>() {
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            if ((bVar.d == null) != (bVar2.d == null)) {
                if (bVar.d == null) {
                    return 1;
                }
                return -1;
            } else if (bVar.f471a == bVar2.f471a) {
                int i = bVar2.f472b - bVar.f472b;
                if (i != 0) {
                    return i;
                }
                int i2 = bVar.c - bVar2.c;
                if (i2 != 0) {
                    return i2;
                }
                return 0;
            } else if (bVar.f471a) {
                return -1;
            } else {
                return 1;
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    ArrayList<RecyclerView> f468b = new ArrayList<>();
    long c;
    long d;
    private ArrayList<b> f = new ArrayList<>();

    e() {
    }

    /* compiled from: GapWorker */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f471a;

        /* renamed from: b  reason: collision with root package name */
        public int f472b;
        public int c;
        public RecyclerView d;
        public int e;

        b() {
        }

        public void a() {
            this.f471a = false;
            this.f472b = 0;
            this.c = 0;
            this.d = null;
            this.e = 0;
        }
    }

    /* compiled from: GapWorker */
    static class a implements RecyclerView.h.a {

        /* renamed from: a  reason: collision with root package name */
        int f469a;

        /* renamed from: b  reason: collision with root package name */
        int f470b;
        int[] c;
        int d;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i, int i2) {
            this.f469a = i;
            this.f470b = i2;
        }

        /* access modifiers changed from: package-private */
        public void a(RecyclerView recyclerView, boolean z) {
            this.d = 0;
            if (this.c != null) {
                Arrays.fill(this.c, -1);
            }
            RecyclerView.h hVar = recyclerView.m;
            if (recyclerView.l != null && hVar != null && hVar.o()) {
                if (z) {
                    if (!recyclerView.e.d()) {
                        hVar.a(recyclerView.l.a(), (RecyclerView.h.a) this);
                    }
                } else if (!recyclerView.w()) {
                    hVar.a(this.f469a, this.f470b, recyclerView.B, (RecyclerView.h.a) this);
                }
                if (this.d > hVar.x) {
                    hVar.x = this.d;
                    hVar.y = z;
                    recyclerView.d.b();
                }
            }
        }

        public void b(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 >= 0) {
                int i3 = this.d * 2;
                if (this.c == null) {
                    this.c = new int[4];
                    Arrays.fill(this.c, -1);
                } else if (i3 >= this.c.length) {
                    int[] iArr = this.c;
                    this.c = new int[(i3 * 2)];
                    System.arraycopy(iArr, 0, this.c, 0, iArr.length);
                }
                this.c[i3] = i;
                this.c[i3 + 1] = i2;
                this.d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i) {
            if (this.c != null) {
                int i2 = this.d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.c != null) {
                Arrays.fill(this.c, -1);
            }
            this.d = 0;
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f468b.add(recyclerView);
    }

    public void b(RecyclerView recyclerView) {
        this.f468b.remove(recyclerView);
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.c == 0) {
            this.c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.A.a(i, i2);
    }

    private void a() {
        b bVar;
        int size = this.f468b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.f468b.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.A.a(recyclerView, false);
                i += recyclerView.A.d;
            }
        }
        this.f.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.f468b.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                a aVar = recyclerView2.A;
                int abs = Math.abs(aVar.f469a) + Math.abs(aVar.f470b);
                int i5 = i3;
                for (int i6 = 0; i6 < aVar.d * 2; i6 += 2) {
                    if (i5 >= this.f.size()) {
                        bVar = new b();
                        this.f.add(bVar);
                    } else {
                        bVar = this.f.get(i5);
                    }
                    int i7 = aVar.c[i6 + 1];
                    bVar.f471a = i7 <= abs;
                    bVar.f472b = abs;
                    bVar.c = i7;
                    bVar.d = recyclerView2;
                    bVar.e = aVar.c[i6];
                    i5++;
                }
                i3 = i5;
            }
        }
        Collections.sort(this.f, e);
    }

    static boolean a(RecyclerView recyclerView, int i) {
        int c2 = recyclerView.f.c();
        for (int i2 = 0; i2 < c2; i2++) {
            RecyclerView.w e2 = RecyclerView.e(recyclerView.f.d(i2));
            if (e2.c == i && !e2.n()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.w a(RecyclerView recyclerView, int i, long j) {
        if (a(recyclerView, i)) {
            return null;
        }
        RecyclerView.o oVar = recyclerView.d;
        try {
            recyclerView.l();
            RecyclerView.w a2 = oVar.a(i, false, j);
            if (a2 != null) {
                if (!a2.p() || a2.n()) {
                    oVar.a(a2, false);
                } else {
                    oVar.a(a2.f413a);
                }
            }
            return a2;
        } finally {
            recyclerView.b(false);
        }
    }

    private void a(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.w && recyclerView.f.c() != 0) {
                recyclerView.c();
            }
            a aVar = recyclerView.A;
            aVar.a(recyclerView, true);
            if (aVar.d != 0) {
                try {
                    c.a("RV Nested Prefetch");
                    recyclerView.B.a(recyclerView.l);
                    for (int i = 0; i < aVar.d * 2; i += 2) {
                        a(recyclerView, aVar.c[i], j);
                    }
                } finally {
                    c.a();
                }
            }
        }
    }

    private void a(b bVar, long j) {
        RecyclerView.w a2 = a(bVar.d, bVar.e, bVar.f471a ? Long.MAX_VALUE : j);
        if (a2 != null && a2.f414b != null && a2.p() && !a2.n()) {
            a((RecyclerView) a2.f414b.get(), j);
        }
    }

    private void b(long j) {
        int i = 0;
        while (i < this.f.size()) {
            b bVar = this.f.get(i);
            if (bVar.d != null) {
                a(bVar, j);
                bVar.a();
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(long j) {
        a();
        b(j);
    }

    public void run() {
        try {
            c.a("RV Prefetch");
            if (!this.f468b.isEmpty()) {
                int size = this.f468b.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.f468b.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j == 0) {
                    this.c = 0;
                    c.a();
                    return;
                }
                a(TimeUnit.MILLISECONDS.toNanos(j) + this.d);
                this.c = 0;
                c.a();
            }
        } finally {
            this.c = 0;
            c.a();
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v7\widget\f.java ==========

package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/* compiled from: LayoutState */
class f {

    /* renamed from: a  reason: collision with root package name */
    boolean f473a = true;

    /* renamed from: b  reason: collision with root package name */
    int f474b;
    int c;
    int d;
    int e;
    int f = 0;
    int g = 0;
    boolean h;
    boolean i;

    f() {
    }

    /* access modifiers changed from: package-private */
    public boolean a(RecyclerView.t tVar) {
        return this.c >= 0 && this.c < tVar.e();
    }

    /* access modifiers changed from: package-private */
    public View a(RecyclerView.o oVar) {
        View c2 = oVar.c(this.c);
        this.c += this.d;
        return c2;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f474b + ", mCurrentPosition=" + this.c + ", mItemDirection=" + this.d + ", mLayoutDirection=" + this.e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v7\widget\g.java ==========

package android.support.v7.widget;

import android.support.v7.widget.a;
import java.util.List;

/* compiled from: OpReorderer */
class g {

    /* renamed from: a  reason: collision with root package name */
    final a f475a;

    /* compiled from: OpReorderer */
    interface a {
        a.b a(int i, int i2, int i3, Object obj);

        void a(a.b bVar);
    }

    g(a aVar) {
        this.f475a = aVar;
    }

    /* access modifiers changed from: package-private */
    public void a(List<a.b> list) {
        while (true) {
            int b2 = b(list);
            if (b2 != -1) {
                a(list, b2, b2 + 1);
            } else {
                return;
            }
        }
    }

    private void a(List<a.b> list, int i, int i2) {
        a.b bVar = list.get(i);
        a.b bVar2 = list.get(i2);
        int i3 = bVar2.f432a;
        if (i3 != 4) {
            switch (i3) {
                case 1:
                    c(list, i, bVar, i2, bVar2);
                    return;
                case 2:
                    a(list, i, bVar, i2, bVar2);
                    return;
                default:
                    return;
            }
        } else {
            b(list, i, bVar, i2, bVar2);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.List<android.support.v7.widget.a.b> r9, int r10, android.support.v7.widget.a.b r11, int r12, android.support.v7.widget.a.b r13) {
        /*
            r8 = this;
            int r0 = r11.f433b
            int r1 = r11.d
            r2 = 0
            r3 = 1
            if (r0 >= r1) goto L_0x001c
            int r0 = r13.f433b
            int r1 = r11.f433b
            if (r0 != r1) goto L_0x001a
            int r0 = r13.d
            int r1 = r11.d
            int r4 = r11.f433b
            int r1 = r1 - r4
            if (r0 != r1) goto L_0x001a
            r0 = 0
        L_0x0018:
            r2 = 1
            goto L_0x002f
        L_0x001a:
            r0 = 0
            goto L_0x002f
        L_0x001c:
            int r0 = r13.f433b
            int r1 = r11.d
            int r1 = r1 + r3
            if (r0 != r1) goto L_0x002e
            int r0 = r13.d
            int r1 = r11.f433b
            int r4 = r11.d
            int r1 = r1 - r4
            if (r0 != r1) goto L_0x002e
            r0 = 1
            goto L_0x0018
        L_0x002e:
            r0 = 1
        L_0x002f:
            int r1 = r11.d
            int r4 = r13.f433b
            r5 = 2
            if (r1 >= r4) goto L_0x003c
            int r1 = r13.f433b
            int r1 = r1 - r3
            r13.f433b = r1
            goto L_0x005b
        L_0x003c:
            int r1 = r11.d
            int r4 = r13.f433b
            int r6 = r13.d
            int r4 = r4 + r6
            if (r1 >= r4) goto L_0x005b
            int r10 = r13.d
            int r10 = r10 - r3
            r13.d = r10
            r11.f432a = r5
            r11.d = r3
            int r10 = r13.d
            if (r10 != 0) goto L_0x005a
            r9.remove(r12)
            android.support.v7.widget.g$a r9 = r8.f475a
            r9.a(r13)
        L_0x005a:
            return
        L_0x005b:
            int r1 = r11.f433b
            int r4 = r13.f433b
            r6 = 0
            if (r1 > r4) goto L_0x0068
            int r1 = r13.f433b
            int r1 = r1 + r3
            r13.f433b = r1
            goto L_0x0089
        L_0x0068:
            int r1 = r11.f433b
            int r4 = r13.f433b
            int r7 = r13.d
            int r4 = r4 + r7
            if (r1 >= r4) goto L_0x0089
            int r1 = r13.f433b
            int r4 = r13.d
            int r1 = r1 + r4
            int r4 = r11.f433b
            int r1 = r1 - r4
            android.support.v7.widget.g$a r4 = r8.f475a
            int r7 = r11.f433b
            int r7 = r7 + r3
            android.support.v7.widget.a$b r6 = r4.a(r5, r7, r1, r6)
            int r1 = r11.f433b
            int r3 = r13.f433b
            int r1 = r1 - r3
            r13.d = r1
        L_0x0089:
            if (r2 == 0) goto L_0x0097
            r9.set(r10, r13)
            r9.remove(r12)
            android.support.v7.widget.g$a r9 = r8.f475a
            r9.a(r11)
            return
        L_0x0097:
            if (r0 == 0) goto L_0x00d0
            if (r6 == 0) goto L_0x00b5
            int r0 = r11.f433b
            int r1 = r6.f433b
            if (r0 <= r1) goto L_0x00a8
            int r0 = r11.f433b
            int r1 = r6.d
            int r0 = r0 - r1
            r11.f433b = r0
        L_0x00a8:
            int r0 = r11.d
            int r1 = r6.f433b
            if (r0 <= r1) goto L_0x00b5
            int r0 = r11.d
            int r1 = r6.d
            int r0 = r0 - r1
            r11.d = r0
        L_0x00b5:
            int r0 = r11.f433b
            int r1 = r13.f433b
            if (r0 <= r1) goto L_0x00c2
            int r0 = r11.f433b
            int r1 = r13.d
            int r0 = r0 - r1
            r11.f433b = r0
        L_0x00c2:
            int r0 = r11.d
            int r1 = r13.f433b
            if (r0 <= r1) goto L_0x0106
            int r0 = r11.d
            int r1 = r13.d
            int r0 = r0 - r1
            r11.d = r0
            goto L_0x0106
        L_0x00d0:
            if (r6 == 0) goto L_0x00ec
            int r0 = r11.f433b
            int r1 = r6.f433b
            if (r0 < r1) goto L_0x00df
            int r0 = r11.f433b
            int r1 = r6.d
            int r0 = r0 - r1
            r11.f433b = r0
        L_0x00df:
            int r0 = r11.d
            int r1 = r6.f433b
            if (r0 < r1) goto L_0x00ec
            int r0 = r11.d
            int r1 = r6.d
            int r0 = r0 - r1
            r11.d = r0
        L_0x00ec:
            int r0 = r11.f433b
            int r1 = r13.f433b
            if (r0 < r1) goto L_0x00f9
            int r0 = r11.f433b
            int r1 = r13.d
            int r0 = r0 - r1
            r11.f433b = r0
        L_0x00f9:
            int r0 = r11.d
            int r1 = r13.f433b
            if (r0 < r1) goto L_0x0106
            int r0 = r11.d
            int r1 = r13.d
            int r0 = r0 - r1
            r11.d = r0
        L_0x0106:
            r9.set(r10, r13)
            int r13 = r11.f433b
            int r0 = r11.d
            if (r13 == r0) goto L_0x0113
            r9.set(r12, r11)
            goto L_0x0116
        L_0x0113:
            r9.remove(r12)
        L_0x0116:
            if (r6 == 0) goto L_0x011b
            r9.add(r10, r6)
        L_0x011b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.g.a(java.util.List, int, android.support.v7.widget.a$b, int, android.support.v7.widget.a$b):void");
    }

    private void c(List<a.b> list, int i, a.b bVar, int i2, a.b bVar2) {
        int i3 = bVar.d < bVar2.f433b ? -1 : 0;
        if (bVar.f433b < bVar2.f433b) {
            i3++;
        }
        if (bVar2.f433b <= bVar.f433b) {
            bVar.f433b += bVar2.d;
        }
        if (bVar2.f433b <= bVar.d) {
            bVar.d += bVar2.d;
        }
        bVar2.f433b += i3;
        list.set(i, bVar2);
        list.set(i2, bVar);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.util.List<android.support.v7.widget.a.b> r8, int r9, android.support.v7.widget.a.b r10, int r11, android.support.v7.widget.a.b r12) {
        /*
            r7 = this;
            int r0 = r10.d
            int r1 = r12.f433b
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto L_0x000f
            int r0 = r12.f433b
            int r0 = r0 - r4
            r12.f433b = r0
            goto L_0x0028
        L_0x000f:
            int r0 = r10.d
            int r1 = r12.f433b
            int r5 = r12.d
            int r1 = r1 + r5
            if (r0 >= r1) goto L_0x0028
            int r0 = r12.d
            int r0 = r0 - r4
            r12.d = r0
            android.support.v7.widget.g$a r0 = r7.f475a
            int r1 = r10.f433b
            java.lang.Object r5 = r12.c
            android.support.v7.widget.a$b r0 = r0.a(r2, r1, r4, r5)
            goto L_0x0029
        L_0x0028:
            r0 = r3
        L_0x0029:
            int r1 = r10.f433b
            int r5 = r12.f433b
            if (r1 > r5) goto L_0x0035
            int r1 = r12.f433b
            int r1 = r1 + r4
            r12.f433b = r1
            goto L_0x0056
        L_0x0035:
            int r1 = r10.f433b
            int r5 = r12.f433b
            int r6 = r12.d
            int r5 = r5 + r6
            if (r1 >= r5) goto L_0x0056
            int r1 = r12.f433b
            int r3 = r12.d
            int r1 = r1 + r3
            int r3 = r10.f433b
            int r1 = r1 - r3
            android.support.v7.widget.g$a r3 = r7.f475a
            int r5 = r10.f433b
            int r5 = r5 + r4
            java.lang.Object r4 = r12.c
            android.support.v7.widget.a$b r3 = r3.a(r2, r5, r1, r4)
            int r2 = r12.d
            int r2 = r2 - r1
            r12.d = r2
        L_0x0056:
            r8.set(r11, r10)
            int r10 = r12.d
            if (r10 <= 0) goto L_0x0061
            r8.set(r9, r12)
            goto L_0x0069
        L_0x0061:
            r8.remove(r9)
            android.support.v7.widget.g$a r10 = r7.f475a
            r10.a(r12)
        L_0x0069:
            if (r0 == 0) goto L_0x006e
            r8.add(r9, r0)
        L_0x006e:
            if (r3 == 0) goto L_0x0073
            r8.add(r9, r3)
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.g.b(java.util.List, int, android.support.v7.widget.a$b, int, android.support.v7.widget.a$b):void");
    }

    private int b(List<a.b> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f432a != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v7\widget\GridLayoutManager.java ==========

package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.a.b;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;

public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: a  reason: collision with root package name */
    boolean f361a = false;

    /* renamed from: b  reason: collision with root package name */
    int f362b = -1;
    int[] c;
    View[] d;
    final SparseIntArray e = new SparseIntArray();
    final SparseIntArray f = new SparseIntArray();
    c g = new a();
    final Rect h = new Rect();

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(a(context, attributeSet, i, i2).f396b);
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        a(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        a(i);
    }

    public void a(boolean z) {
        if (!z) {
            super.a(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public int a(RecyclerView.o oVar, RecyclerView.t tVar) {
        if (this.i == 0) {
            return this.f362b;
        }
        if (tVar.e() < 1) {
            return 0;
        }
        return a(oVar, tVar, tVar.e() - 1) + 1;
    }

    public int b(RecyclerView.o oVar, RecyclerView.t tVar) {
        if (this.i == 1) {
            return this.f362b;
        }
        if (tVar.e() < 1) {
            return 0;
        }
        return a(oVar, tVar, tVar.e() - 1) + 1;
    }

    public void a(RecyclerView.o oVar, RecyclerView.t tVar, View view, android.support.v4.view.a.b bVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.a(view, bVar);
            return;
        }
        b bVar2 = (b) layoutParams;
        int a2 = a(oVar, tVar, bVar2.f());
        if (this.i == 0) {
            bVar.b((Object) b.k.a(bVar2.a(), bVar2.b(), a2, 1, this.f362b > 1 && bVar2.b() == this.f362b, false));
        } else {
            bVar.b((Object) b.k.a(a2, 1, bVar2.a(), bVar2.b(), this.f362b > 1 && bVar2.b() == this.f362b, false));
        }
    }

    public void c(RecyclerView.o oVar, RecyclerView.t tVar) {
        if (tVar.a()) {
            K();
        }
        super.c(oVar, tVar);
        J();
    }

    public void a(RecyclerView.t tVar) {
        super.a(tVar);
        this.f361a = false;
    }

    private void J() {
        this.e.clear();
        this.f.clear();
    }

    private void K() {
        int u = u();
        for (int i = 0; i < u; i++) {
            b bVar = (b) h(i).getLayoutParams();
            int f2 = bVar.f();
            this.e.put(f2, bVar.b());
            this.f.put(f2, bVar.a());
        }
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.g.a();
    }

    public void a(RecyclerView recyclerView) {
        this.g.a();
    }

    public void b(RecyclerView recyclerView, int i, int i2) {
        this.g.a();
    }

    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.g.a();
    }

    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.g.a();
    }

    public RecyclerView.i a() {
        if (this.i == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    public RecyclerView.i a(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    public RecyclerView.i a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    public boolean a(RecyclerView.i iVar) {
        return iVar instanceof b;
    }

    private void L() {
        int i;
        if (f() == 1) {
            i = (x() - B()) - z();
        } else {
            i = (y() - C()) - A();
        }
        l(i);
    }

    public void a(Rect rect, int i, int i2) {
        int i3;
        int i4;
        if (this.c == null) {
            super.a(rect, i, i2);
        }
        int z = z() + B();
        int A = A() + C();
        if (this.i == 1) {
            i4 = a(i2, rect.height() + A, F());
            i3 = a(i, this.c[this.c.length - 1] + z, E());
        } else {
            i3 = a(i, rect.width() + z, E());
            i4 = a(i2, this.c[this.c.length - 1] + A, F());
        }
        g(i3, i4);
    }

    private void l(int i) {
        this.c = a(this.c, this.f362b, i);
    }

    static int[] a(int[] iArr, int i, int i2) {
        int i3;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public int a(int i, int i2) {
        if (this.i != 1 || !g()) {
            return this.c[i2 + i] - this.c[i];
        }
        return this.c[this.f362b - i] - this.c[(this.f362b - i) - i2];
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.o oVar, RecyclerView.t tVar, LinearLayoutManager.a aVar, int i) {
        super.a(oVar, tVar, aVar, i);
        L();
        if (tVar.e() > 0 && !tVar.a()) {
            b(oVar, tVar, aVar, i);
        }
        M();
    }

    private void M() {
        if (this.d == null || this.d.length != this.f362b) {
            this.d = new View[this.f362b];
        }
    }

    public int a(int i, RecyclerView.o oVar, RecyclerView.t tVar) {
        L();
        M();
        return super.a(i, oVar, tVar);
    }

    public int b(int i, RecyclerView.o oVar, RecyclerView.t tVar) {
        L();
        M();
        return super.b(i, oVar, tVar);
    }

    private void b(RecyclerView.o oVar, RecyclerView.t tVar, LinearLayoutManager.a aVar, int i) {
        boolean z = i == 1;
        int b2 = b(oVar, tVar, aVar.f369a);
        if (z) {
            while (b2 > 0 && aVar.f369a > 0) {
                aVar.f369a--;
                b2 = b(oVar, tVar, aVar.f369a);
            }
            return;
        }
        int e2 = tVar.e() - 1;
        int i2 = aVar.f369a;
        while (i2 < e2) {
            int i3 = i2 + 1;
            int b3 = b(oVar, tVar, i3);
            if (b3 <= b2) {
                break;
            }
            i2 = i3;
            b2 = b3;
        }
        aVar.f369a = i2;
    }

    /* access modifiers changed from: package-private */
    public View a(RecyclerView.o oVar, RecyclerView.t tVar, int i, int i2, int i3) {
        h();
        int c2 = this.j.c();
        int d2 = this.j.d();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View h2 = h(i);
            int d3 = d(h2);
            if (d3 >= 0 && d3 < i3 && b(oVar, tVar, d3) == 0) {
                if (((RecyclerView.i) h2.getLayoutParams()).d()) {
                    if (view2 == null) {
                        view2 = h2;
                    }
                } else if (this.j.a(h2) < d2 && this.j.b(h2) >= c2) {
                    return h2;
                } else {
                    if (view == null) {
                        view = h2;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    private int a(RecyclerView.o oVar, RecyclerView.t tVar, int i) {
        if (!tVar.a()) {
            return this.g.c(i, this.f362b);
        }
        int b2 = oVar.b(i);
        if (b2 != -1) {
            return this.g.c(b2, this.f362b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private int b(RecyclerView.o oVar, RecyclerView.t tVar, int i) {
        if (!tVar.a()) {
            return this.g.b(i, this.f362b);
        }
        int i2 = this.f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int b2 = oVar.b(i);
        if (b2 != -1) {
            return this.g.b(b2, this.f362b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private int c(RecyclerView.o oVar, RecyclerView.t tVar, int i) {
        if (!tVar.a()) {
            return this.g.a(i);
        }
        int i2 = this.e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int b2 = oVar.b(i);
        if (b2 != -1) {
            return this.g.a(b2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.t tVar, LinearLayoutManager.c cVar, RecyclerView.h.a aVar) {
        int i = this.f362b;
        for (int i2 = 0; i2 < this.f362b && cVar.a(tVar) && i > 0; i2++) {
            int i3 = cVar.d;
            aVar.b(i3, Math.max(0, cVar.g));
            i -= this.g.a(i3);
            cVar.d += cVar.e;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0225 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0223  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.support.v7.widget.RecyclerView.o r19, android.support.v7.widget.RecyclerView.t r20, android.support.v7.widget.LinearLayoutManager.c r21, android.support.v7.widget.LinearLayoutManager.b r22) {
        /*
            r18 = this;
            r6 = r18
            r1 = r19
            r2 = r20
            r7 = r21
            r8 = r22
            android.support.v7.widget.h r0 = r6.j
            int r9 = r0.i()
            r10 = 1073741824(0x40000000, float:2.0)
            r11 = 1
            if (r9 == r10) goto L_0x0017
            r13 = 1
            goto L_0x0018
        L_0x0017:
            r13 = 0
        L_0x0018:
            int r0 = r18.u()
            if (r0 <= 0) goto L_0x0026
            int[] r0 = r6.c
            int r3 = r6.f362b
            r0 = r0[r3]
            r14 = r0
            goto L_0x0027
        L_0x0026:
            r14 = 0
        L_0x0027:
            if (r13 == 0) goto L_0x002c
            r18.L()
        L_0x002c:
            int r0 = r7.e
            if (r0 != r11) goto L_0x0032
            r15 = 1
            goto L_0x0033
        L_0x0032:
            r15 = 0
        L_0x0033:
            int r0 = r6.f362b
            if (r15 != 0) goto L_0x0044
            int r0 = r7.d
            int r0 = r6.b((android.support.v7.widget.RecyclerView.o) r1, (android.support.v7.widget.RecyclerView.t) r2, (int) r0)
            int r3 = r7.d
            int r3 = r6.c(r1, r2, r3)
            int r0 = r0 + r3
        L_0x0044:
            r4 = 0
            r5 = 0
        L_0x0046:
            int r3 = r6.f362b
            if (r5 >= r3) goto L_0x009f
            boolean r3 = r7.a((android.support.v7.widget.RecyclerView.t) r2)
            if (r3 == 0) goto L_0x009f
            if (r0 <= 0) goto L_0x009f
            int r3 = r7.d
            int r10 = r6.c(r1, r2, r3)
            int r12 = r6.f362b
            if (r10 > r12) goto L_0x0071
            int r0 = r0 - r10
            if (r0 >= 0) goto L_0x0060
            goto L_0x009f
        L_0x0060:
            android.view.View r3 = r7.a((android.support.v7.widget.RecyclerView.o) r1)
            if (r3 != 0) goto L_0x0067
            goto L_0x009f
        L_0x0067:
            int r4 = r4 + r10
            android.view.View[] r10 = r6.d
            r10[r5] = r3
            int r5 = r5 + 1
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x0046
        L_0x0071:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Item at position "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = " requires "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r2 = " spans but GridLayoutManager has only "
            r1.append(r2)
            int r2 = r6.f362b
            r1.append(r2)
            java.lang.String r2 = " spans."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x009f:
            if (r5 != 0) goto L_0x00a4
            r8.f372b = r11
            return
        L_0x00a4:
            r10 = 0
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r5
            r12 = r5
            r5 = r15
            r0.a((android.support.v7.widget.RecyclerView.o) r1, (android.support.v7.widget.RecyclerView.t) r2, (int) r3, (int) r4, (boolean) r5)
            r0 = 0
            r1 = 0
        L_0x00b3:
            if (r0 >= r12) goto L_0x0101
            android.view.View[] r2 = r6.d
            r2 = r2[r0]
            java.util.List<android.support.v7.widget.RecyclerView$w> r3 = r7.k
            if (r3 != 0) goto L_0x00c9
            if (r15 == 0) goto L_0x00c4
            r6.b((android.view.View) r2)
            r3 = 0
            goto L_0x00d3
        L_0x00c4:
            r3 = 0
            r6.b((android.view.View) r2, (int) r3)
            goto L_0x00d3
        L_0x00c9:
            r3 = 0
            if (r15 == 0) goto L_0x00d0
            r6.a((android.view.View) r2)
            goto L_0x00d3
        L_0x00d0:
            r6.a((android.view.View) r2, (int) r3)
        L_0x00d3:
            android.graphics.Rect r4 = r6.h
            r6.b((android.view.View) r2, (android.graphics.Rect) r4)
            r6.a((android.view.View) r2, (int) r9, (boolean) r3)
            android.support.v7.widget.h r3 = r6.j
            int r3 = r3.e(r2)
            if (r3 <= r1) goto L_0x00e4
            r1 = r3
        L_0x00e4:
            android.view.ViewGroup$LayoutParams r3 = r2.getLayoutParams()
            android.support.v7.widget.GridLayoutManager$b r3 = (android.support.v7.widget.GridLayoutManager.b) r3
            r4 = 1065353216(0x3f800000, float:1.0)
            android.support.v7.widget.h r5 = r6.j
            int r2 = r5.f(r2)
            float r2 = (float) r2
            float r2 = r2 * r4
            int r3 = r3.f364b
            float r3 = (float) r3
            float r2 = r2 / r3
            int r3 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r3 <= 0) goto L_0x00fe
            r10 = r2
        L_0x00fe:
            int r0 = r0 + 1
            goto L_0x00b3
        L_0x0101:
            if (r13 == 0) goto L_0x011f
            r6.a((float) r10, (int) r14)
            r0 = 0
            r1 = 0
        L_0x0108:
            if (r0 >= r12) goto L_0x011f
            android.view.View[] r2 = r6.d
            r2 = r2[r0]
            r3 = 1073741824(0x40000000, float:2.0)
            r6.a((android.view.View) r2, (int) r3, (boolean) r11)
            android.support.v7.widget.h r3 = r6.j
            int r2 = r3.e(r2)
            if (r2 <= r1) goto L_0x011c
            r1 = r2
        L_0x011c:
            int r0 = r0 + 1
            goto L_0x0108
        L_0x011f:
            r0 = 0
        L_0x0120:
            if (r0 >= r12) goto L_0x0182
            android.view.View[] r2 = r6.d
            r2 = r2[r0]
            android.support.v7.widget.h r3 = r6.j
            int r3 = r3.e(r2)
            if (r3 == r1) goto L_0x017c
            android.view.ViewGroup$LayoutParams r3 = r2.getLayoutParams()
            android.support.v7.widget.GridLayoutManager$b r3 = (android.support.v7.widget.GridLayoutManager.b) r3
            android.graphics.Rect r4 = r3.d
            int r5 = r4.top
            int r9 = r4.bottom
            int r5 = r5 + r9
            int r9 = r3.topMargin
            int r5 = r5 + r9
            int r9 = r3.bottomMargin
            int r5 = r5 + r9
            int r9 = r4.left
            int r4 = r4.right
            int r9 = r9 + r4
            int r4 = r3.leftMargin
            int r9 = r9 + r4
            int r4 = r3.rightMargin
            int r9 = r9 + r4
            int r4 = r3.f363a
            int r10 = r3.f364b
            int r4 = r6.a((int) r4, (int) r10)
            int r10 = r6.i
            if (r10 != r11) goto L_0x0168
            int r3 = r3.width
            r10 = 0
            r13 = 1073741824(0x40000000, float:2.0)
            int r3 = a((int) r4, (int) r13, (int) r9, (int) r3, (boolean) r10)
            int r4 = r1 - r5
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r13)
            goto L_0x0178
        L_0x0168:
            r10 = 0
            r13 = 1073741824(0x40000000, float:2.0)
            int r9 = r1 - r9
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r13)
            int r3 = r3.height
            int r4 = a((int) r4, (int) r13, (int) r5, (int) r3, (boolean) r10)
            r3 = r9
        L_0x0178:
            r6.a((android.view.View) r2, (int) r3, (int) r4, (boolean) r11)
            goto L_0x017f
        L_0x017c:
            r10 = 0
            r13 = 1073741824(0x40000000, float:2.0)
        L_0x017f:
            int r0 = r0 + 1
            goto L_0x0120
        L_0x0182:
            r10 = 0
            r8.f371a = r1
            int r0 = r6.i
            r2 = -1
            if (r0 != r11) goto L_0x019d
            int r0 = r7.f
            if (r0 != r2) goto L_0x0197
            int r0 = r7.f374b
            int r1 = r0 - r1
            r3 = r0
            r2 = r1
        L_0x0194:
            r0 = 0
            r1 = 0
            goto L_0x01b2
        L_0x0197:
            int r0 = r7.f374b
            int r1 = r1 + r0
            r2 = r0
            r3 = r1
            goto L_0x0194
        L_0x019d:
            int r0 = r7.f
            if (r0 != r2) goto L_0x01ad
            int r0 = r7.f374b
            int r1 = r0 - r1
            r2 = 0
            r3 = 0
            r17 = r1
            r1 = r0
            r0 = r17
            goto L_0x01b2
        L_0x01ad:
            int r0 = r7.f374b
            int r1 = r1 + r0
            r2 = 0
            r3 = 0
        L_0x01b2:
            if (r10 >= r12) goto L_0x0237
            android.view.View[] r4 = r6.d
            r7 = r4[r10]
            android.view.ViewGroup$LayoutParams r4 = r7.getLayoutParams()
            r9 = r4
            android.support.v7.widget.GridLayoutManager$b r9 = (android.support.v7.widget.GridLayoutManager.b) r9
            int r4 = r6.i
            if (r4 != r11) goto L_0x01f5
            boolean r0 = r18.g()
            if (r0 == 0) goto L_0x01e2
            int r0 = r18.z()
            int[] r1 = r6.c
            int r4 = r6.f362b
            int r5 = r9.f363a
            int r4 = r4 - r5
            r1 = r1[r4]
            int r0 = r0 + r1
            android.support.v7.widget.h r1 = r6.j
            int r1 = r1.f(r7)
            int r1 = r0 - r1
            r15 = r0
            r13 = r1
            goto L_0x0209
        L_0x01e2:
            int r0 = r18.z()
            int[] r1 = r6.c
            int r4 = r9.f363a
            r1 = r1[r4]
            int r0 = r0 + r1
            android.support.v7.widget.h r1 = r6.j
            int r1 = r1.f(r7)
            int r1 = r1 + r0
            goto L_0x0207
        L_0x01f5:
            int r2 = r18.A()
            int[] r3 = r6.c
            int r4 = r9.f363a
            r3 = r3[r4]
            int r2 = r2 + r3
            android.support.v7.widget.h r3 = r6.j
            int r3 = r3.f(r7)
            int r3 = r3 + r2
        L_0x0207:
            r13 = r0
            r15 = r1
        L_0x0209:
            r14 = r2
            r16 = r3
            r0 = r18
            r1 = r7
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r0.a((android.view.View) r1, (int) r2, (int) r3, (int) r4, (int) r5)
            boolean r0 = r9.d()
            if (r0 != 0) goto L_0x0223
            boolean r0 = r9.e()
            if (r0 == 0) goto L_0x0225
        L_0x0223:
            r8.c = r11
        L_0x0225:
            boolean r0 = r8.d
            boolean r1 = r7.hasFocusable()
            r0 = r0 | r1
            r8.d = r0
            int r10 = r10 + 1
            r0 = r13
            r2 = r14
            r1 = r15
            r3 = r16
            goto L_0x01b2
        L_0x0237:
            android.view.View[] r0 = r6.d
            r1 = 0
            java.util.Arrays.fill(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.GridLayoutManager.a(android.support.v7.widget.RecyclerView$o, android.support.v7.widget.RecyclerView$t, android.support.v7.widget.LinearLayoutManager$c, android.support.v7.widget.LinearLayoutManager$b):void");
    }

    private void a(View view, int i, boolean z) {
        int i2;
        int i3;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.d;
        int i4 = rect.top + rect.bottom + bVar.topMargin + bVar.bottomMargin;
        int i5 = rect.left + rect.right + bVar.leftMargin + bVar.rightMargin;
        int a2 = a(bVar.f363a, bVar.f364b);
        if (this.i == 1) {
            i2 = a(a2, i, i5, bVar.width, false);
            i3 = a(this.j.f(), w(), i4, bVar.height, true);
        } else {
            int a3 = a(a2, i, i4, bVar.height, false);
            int a4 = a(this.j.f(), v(), i5, bVar.width, true);
            i3 = a3;
            i2 = a4;
        }
        a(view, i2, i3, z);
    }

    private void a(float f2, int i) {
        l(Math.max(Math.round(f2 * ((float) this.f362b)), i));
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean z2;
        RecyclerView.i iVar = (RecyclerView.i) view.getLayoutParams();
        if (z) {
            z2 = a(view, i, i2, iVar);
        } else {
            z2 = b(view, i, i2, iVar);
        }
        if (z2) {
            view.measure(i, i2);
        }
    }

    private void a(RecyclerView.o oVar, RecyclerView.t tVar, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = -1;
        int i6 = 0;
        if (z) {
            i5 = i;
            i4 = 0;
            i3 = 1;
        } else {
            i4 = i - 1;
            i3 = -1;
        }
        while (i4 != i5) {
            View view = this.d[i4];
            b bVar = (b) view.getLayoutParams();
            bVar.f364b = c(oVar, tVar, d(view));
            bVar.f363a = i6;
            i6 += bVar.f364b;
            i4 += i3;
        }
    }

    public void a(int i) {
        if (i != this.f362b) {
            this.f361a = true;
            if (i >= 1) {
                this.f362b = i;
                this.g.a();
                n();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
    }

    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final SparseIntArray f365a = new SparseIntArray();

        /* renamed from: b  reason: collision with root package name */
        private boolean f366b = false;

        public abstract int a(int i);

        public void a() {
            this.f365a.clear();
        }

        /* access modifiers changed from: package-private */
        public int b(int i, int i2) {
            if (!this.f366b) {
                return a(i, i2);
            }
            int i3 = this.f365a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int a2 = a(i, i2);
            this.f365a.put(i, a2);
            return a2;
        }

        public int a(int i, int i2) {
            int i3;
            int i4;
            int b2;
            int a2 = a(i);
            if (a2 == i2) {
                return 0;
            }
            if (!this.f366b || this.f365a.size() <= 0 || (b2 = b(i)) < 0) {
                i4 = 0;
                i3 = 0;
            } else {
                i3 = this.f365a.get(b2) + a(b2);
                i4 = b2 + 1;
            }
            while (i4 < i) {
                int a3 = a(i4);
                int i5 = i3 + a3;
                if (i5 == i2) {
                    i5 = 0;
                } else if (i5 > i2) {
                    i5 = a3;
                }
                i4++;
            }
            if (a2 + i3 <= i2) {
                return i3;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public int b(int i) {
            int size = this.f365a.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.f365a.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= this.f365a.size()) {
                return -1;
            }
            return this.f365a.keyAt(i4);
        }

        public int c(int i, int i2) {
            int a2 = a(i);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int a3 = a(i5);
                i3 += a3;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = a3;
                }
            }
            return i3 + a2 > i2 ? i4 + 1 : i4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d8, code lost:
        if (r13 == (r2 > r8)) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f5, code lost:
        if (r13 == r10) goto L_0x00bb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0104  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View a(android.view.View r26, int r27, android.support.v7.widget.RecyclerView.o r28, android.support.v7.widget.RecyclerView.t r29) {
        /*
            r25 = this;
            r0 = r25
            r1 = r28
            r2 = r29
            android.view.View r3 = r25.e((android.view.View) r26)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            android.support.v7.widget.GridLayoutManager$b r5 = (android.support.v7.widget.GridLayoutManager.b) r5
            int r6 = r5.f363a
            int r7 = r5.f363a
            int r5 = r5.f364b
            int r7 = r7 + r5
            android.view.View r5 = super.a((android.view.View) r26, (int) r27, (android.support.v7.widget.RecyclerView.o) r28, (android.support.v7.widget.RecyclerView.t) r29)
            if (r5 != 0) goto L_0x0022
            return r4
        L_0x0022:
            r5 = r27
            int r5 = r0.e((int) r5)
            r9 = 1
            if (r5 != r9) goto L_0x002d
            r5 = 1
            goto L_0x002e
        L_0x002d:
            r5 = 0
        L_0x002e:
            boolean r10 = r0.k
            if (r5 == r10) goto L_0x0034
            r5 = 1
            goto L_0x0035
        L_0x0034:
            r5 = 0
        L_0x0035:
            r10 = -1
            if (r5 == 0) goto L_0x0040
            int r5 = r25.u()
            int r5 = r5 - r9
            r11 = -1
            r12 = -1
            goto L_0x0047
        L_0x0040:
            int r5 = r25.u()
            r11 = r5
            r5 = 0
            r12 = 1
        L_0x0047:
            int r13 = r0.i
            if (r13 != r9) goto L_0x0053
            boolean r13 = r25.g()
            if (r13 == 0) goto L_0x0053
            r13 = 1
            goto L_0x0054
        L_0x0053:
            r13 = 0
        L_0x0054:
            int r14 = r0.a((android.support.v7.widget.RecyclerView.o) r1, (android.support.v7.widget.RecyclerView.t) r2, (int) r5)
            r10 = r4
            r8 = -1
            r15 = 0
            r17 = 0
            r18 = -1
        L_0x005f:
            if (r5 == r11) goto L_0x0146
            int r9 = r0.a((android.support.v7.widget.RecyclerView.o) r1, (android.support.v7.widget.RecyclerView.t) r2, (int) r5)
            android.view.View r1 = r0.h((int) r5)
            if (r1 != r3) goto L_0x006d
            goto L_0x0146
        L_0x006d:
            boolean r20 = r1.hasFocusable()
            if (r20 == 0) goto L_0x0087
            if (r9 == r14) goto L_0x0087
            if (r4 == 0) goto L_0x0079
            goto L_0x0146
        L_0x0079:
            r21 = r3
            r23 = r8
            r24 = r10
            r22 = r11
            r8 = r17
            r11 = r18
            goto L_0x0132
        L_0x0087:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            android.support.v7.widget.GridLayoutManager$b r9 = (android.support.v7.widget.GridLayoutManager.b) r9
            int r2 = r9.f363a
            r21 = r3
            int r3 = r9.f363a
            r22 = r11
            int r11 = r9.f364b
            int r3 = r3 + r11
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x00a3
            if (r2 != r6) goto L_0x00a3
            if (r3 != r7) goto L_0x00a3
            return r1
        L_0x00a3:
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x00ab
            if (r4 == 0) goto L_0x00b3
        L_0x00ab:
            boolean r11 = r1.hasFocusable()
            if (r11 != 0) goto L_0x00be
            if (r10 != 0) goto L_0x00be
        L_0x00b3:
            r23 = r8
            r24 = r10
            r8 = r17
        L_0x00b9:
            r11 = r18
        L_0x00bb:
            r19 = 1
            goto L_0x0102
        L_0x00be:
            int r11 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r7)
            int r11 = r20 - r11
            boolean r20 = r1.hasFocusable()
            if (r20 == 0) goto L_0x00db
            if (r11 <= r15) goto L_0x00d1
            goto L_0x00b3
        L_0x00d1:
            if (r11 != r15) goto L_0x00f8
            if (r2 <= r8) goto L_0x00d7
            r11 = 1
            goto L_0x00d8
        L_0x00d7:
            r11 = 0
        L_0x00d8:
            if (r13 != r11) goto L_0x00f8
            goto L_0x00b3
        L_0x00db:
            if (r4 != 0) goto L_0x00f8
            r23 = r8
            r24 = r10
            r8 = 1
            r10 = 0
            boolean r16 = r0.a((android.view.View) r1, (boolean) r10, (boolean) r8)
            if (r16 == 0) goto L_0x00fc
            r8 = r17
            if (r11 <= r8) goto L_0x00ee
            goto L_0x00b9
        L_0x00ee:
            if (r11 != r8) goto L_0x00fe
            r11 = r18
            if (r2 <= r11) goto L_0x00f5
            r10 = 1
        L_0x00f5:
            if (r13 != r10) goto L_0x0100
            goto L_0x00bb
        L_0x00f8:
            r23 = r8
            r24 = r10
        L_0x00fc:
            r8 = r17
        L_0x00fe:
            r11 = r18
        L_0x0100:
            r19 = 0
        L_0x0102:
            if (r19 == 0) goto L_0x0132
            boolean r10 = r1.hasFocusable()
            if (r10 == 0) goto L_0x011f
            int r4 = r9.f363a
            int r3 = java.lang.Math.min(r3, r7)
            int r2 = java.lang.Math.max(r2, r6)
            int r3 = r3 - r2
            r15 = r3
            r17 = r8
            r18 = r11
            r10 = r24
            r8 = r4
            r4 = r1
            goto L_0x013a
        L_0x011f:
            int r8 = r9.f363a
            int r3 = java.lang.Math.min(r3, r7)
            int r2 = java.lang.Math.max(r2, r6)
            int r3 = r3 - r2
            r10 = r1
            r17 = r3
            r18 = r8
            r8 = r23
            goto L_0x013a
        L_0x0132:
            r17 = r8
            r18 = r11
            r8 = r23
            r10 = r24
        L_0x013a:
            int r5 = r5 + r12
            r3 = r21
            r11 = r22
            r1 = r28
            r2 = r29
            r9 = 1
            goto L_0x005f
        L_0x0146:
            r24 = r10
            if (r4 == 0) goto L_0x014b
            goto L_0x014d
        L_0x014b:
            r4 = r24
        L_0x014d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.GridLayoutManager.a(android.view.View, int, android.support.v7.widget.RecyclerView$o, android.support.v7.widget.RecyclerView$t):android.view.View");
    }

    public boolean b() {
        return this.n == null && !this.f361a;
    }

    public static final class a extends c {
        public int a(int i) {
            return 1;
        }

        public int a(int i, int i2) {
            return i % i2;
        }
    }

    public static class b extends RecyclerView.i {

        /* renamed from: a  reason: collision with root package name */
        int f363a = -1;

        /* renamed from: b  reason: collision with root package name */
        int f364b = 0;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public int a() {
            return this.f363a;
        }

        public int b() {
            return this.f364b;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v7\widget\h.java ==========

package android.support.v7.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* compiled from: OrientationHelper */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    protected final RecyclerView.h f476a;

    /* renamed from: b  reason: collision with root package name */
    final Rect f477b;
    private int c;

    public abstract int a(View view);

    public abstract void a(int i);

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    public abstract int h();

    public abstract int i();

    private h(RecyclerView.h hVar) {
        this.c = Integer.MIN_VALUE;
        this.f477b = new Rect();
        this.f476a = hVar;
    }

    public void a() {
        this.c = f();
    }

    public int b() {
        if (Integer.MIN_VALUE == this.c) {
            return 0;
        }
        return f() - this.c;
    }

    public static h a(RecyclerView.h hVar, int i) {
        switch (i) {
            case 0:
                return a(hVar);
            case 1:
                return b(hVar);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static h a(RecyclerView.h hVar) {
        return new h(hVar) {
            public int d() {
                return this.f476a.x() - this.f476a.B();
            }

            public int e() {
                return this.f476a.x();
            }

            public void a(int i) {
                this.f476a.i(i);
            }

            public int c() {
                return this.f476a.z();
            }

            public int e(View view) {
                RecyclerView.i iVar = (RecyclerView.i) view.getLayoutParams();
                return this.f476a.f(view) + iVar.leftMargin + iVar.rightMargin;
            }

            public int f(View view) {
                RecyclerView.i iVar = (RecyclerView.i) view.getLayoutParams();
                return this.f476a.g(view) + iVar.topMargin + iVar.bottomMargin;
            }

            public int b(View view) {
                return this.f476a.j(view) + ((RecyclerView.i) view.getLayoutParams()).rightMargin;
            }

            public int a(View view) {
                return this.f476a.h(view) - ((RecyclerView.i) view.getLayoutParams()).leftMargin;
            }

            public int c(View view) {
                this.f476a.a(view, true, this.f477b);
                return this.f477b.right;
            }

            public int d(View view) {
                this.f476a.a(view, true, this.f477b);
                return this.f477b.left;
            }

            public int f() {
                return (this.f476a.x() - this.f476a.z()) - this.f476a.B();
            }

            public int g() {
                return this.f476a.B();
            }

            public int h() {
                return this.f476a.v();
            }

            public int i() {
                return this.f476a.w();
            }
        };
    }

    public static h b(RecyclerView.h hVar) {
        return new h(hVar) {
            public int d() {
                return this.f476a.y() - this.f476a.C();
            }

            public int e() {
                return this.f476a.y();
            }

            public void a(int i) {
                this.f476a.j(i);
            }

            public int c() {
                return this.f476a.A();
            }

            public int e(View view) {
                RecyclerView.i iVar = (RecyclerView.i) view.getLayoutParams();
                return this.f476a.g(view) + iVar.topMargin + iVar.bottomMargin;
            }

            public int f(View view) {
                RecyclerView.i iVar = (RecyclerView.i) view.getLayoutParams();
                return this.f476a.f(view) + iVar.leftMargin + iVar.rightMargin;
            }

            public int b(View view) {
                return this.f476a.k(view) + ((RecyclerView.i) view.getLayoutParams()).bottomMargin;
            }

            public int a(View view) {
                return this.f476a.i(view) - ((RecyclerView.i) view.getLayoutParams()).topMargin;
            }

            public int c(View view) {
                this.f476a.a(view, true, this.f477b);
                return this.f477b.bottom;
            }

            public int d(View view) {
                this.f476a.a(view, true, this.f477b);
                return this.f477b.top;
            }

            public int f() {
                return (this.f476a.y() - this.f476a.A()) - this.f476a.C();
            }

            public int g() {
                return this.f476a.C();
            }

            public int h() {
                return this.f476a.w();
            }

            public int i() {
                return this.f476a.v();
            }
        };
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v7\widget\i.java ==========

package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.b;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: RecyclerViewAccessibilityDelegate */
public class i extends b {

    /* renamed from: b  reason: collision with root package name */
    final RecyclerView f478b;
    final b c = new a(this);

    public i(RecyclerView recyclerView) {
        this.f478b = recyclerView;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f478b.w();
    }

    public boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        if (b() || this.f478b.getLayoutManager() == null) {
            return false;
        }
        return this.f478b.getLayoutManager().a(i, bundle);
    }

    public void a(View view, android.support.v4.view.a.b bVar) {
        super.a(view, bVar);
        bVar.a((CharSequence) RecyclerView.class.getName());
        if (!b() && this.f478b.getLayoutManager() != null) {
            this.f478b.getLayoutManager().a(bVar);
        }
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !b()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().a(accessibilityEvent);
            }
        }
    }

    public b c() {
        return this.c;
    }

    /* compiled from: RecyclerViewAccessibilityDelegate */
    public static class a extends b {

        /* renamed from: b  reason: collision with root package name */
        final i f479b;

        public a(i iVar) {
            this.f479b = iVar;
        }

        public void a(View view, android.support.v4.view.a.b bVar) {
            super.a(view, bVar);
            if (!this.f479b.b() && this.f479b.f478b.getLayoutManager() != null) {
                this.f479b.f478b.getLayoutManager().a(view, bVar);
            }
        }

        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            if (this.f479b.b() || this.f479b.f478b.getLayoutManager() == null) {
                return false;
            }
            return this.f479b.f478b.getLayoutManager().a(view, i, bundle);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v7\widget\j.java ==========

package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/* compiled from: ScrollbarHelper */
class j {
    static int a(RecyclerView.t tVar, h hVar, View view, View view2, RecyclerView.h hVar2, boolean z, boolean z2) {
        int i;
        if (hVar2.u() == 0 || tVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(hVar2.d(view), hVar2.d(view2));
        int max = Math.max(hVar2.d(view), hVar2.d(view2));
        if (z2) {
            i = Math.max(0, (tVar.e() - max) - 1);
        } else {
            i = Math.max(0, min);
        }
        if (!z) {
            return i;
        }
        return Math.round((((float) i) * (((float) Math.abs(hVar.b(view2) - hVar.a(view))) / ((float) (Math.abs(hVar2.d(view) - hVar2.d(view2)) + 1)))) + ((float) (hVar.c() - hVar.a(view))));
    }

    static int a(RecyclerView.t tVar, h hVar, View view, View view2, RecyclerView.h hVar2, boolean z) {
        if (hVar2.u() == 0 || tVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(hVar2.d(view) - hVar2.d(view2)) + 1;
        }
        return Math.min(hVar.f(), hVar.b(view2) - hVar.a(view));
    }

    static int b(RecyclerView.t tVar, h hVar, View view, View view2, RecyclerView.h hVar2, boolean z) {
        if (hVar2.u() == 0 || tVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return tVar.e();
        }
        return (int) ((((float) (hVar.b(view2) - hVar.a(view))) / ((float) (Math.abs(hVar2.d(view) - hVar2.d(view2)) + 1))) * ((float) tVar.e()));
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v7\widget\k.java ==========

package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/* compiled from: SimpleItemAnimator */
public abstract class k extends RecyclerView.e {
    boolean h = true;

    public abstract boolean a(RecyclerView.w wVar);

    public abstract boolean a(RecyclerView.w wVar, int i, int i2, int i3, int i4);

    public abstract boolean a(RecyclerView.w wVar, RecyclerView.w wVar2, int i, int i2, int i3, int i4);

    public abstract boolean b(RecyclerView.w wVar);

    public void c(RecyclerView.w wVar, boolean z) {
    }

    public void d(RecyclerView.w wVar, boolean z) {
    }

    public void o(RecyclerView.w wVar) {
    }

    public void p(RecyclerView.w wVar) {
    }

    public void q(RecyclerView.w wVar) {
    }

    public void r(RecyclerView.w wVar) {
    }

    public void s(RecyclerView.w wVar) {
    }

    public void t(RecyclerView.w wVar) {
    }

    public boolean h(RecyclerView.w wVar) {
        return !this.h || wVar.n();
    }

    public boolean a(RecyclerView.w wVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2) {
        int i = cVar.f388a;
        int i2 = cVar.f389b;
        View view = wVar.f413a;
        int left = cVar2 == null ? view.getLeft() : cVar2.f388a;
        int top = cVar2 == null ? view.getTop() : cVar2.f389b;
        if (wVar.q() || (i == left && i2 == top)) {
            return a(wVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return a(wVar, i, i2, left, top);
    }

    public boolean b(RecyclerView.w wVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2) {
        if (cVar == null || (cVar.f388a == cVar2.f388a && cVar.f389b == cVar2.f389b)) {
            return b(wVar);
        }
        return a(wVar, cVar.f388a, cVar.f389b, cVar2.f388a, cVar2.f389b);
    }

    public boolean c(RecyclerView.w wVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2) {
        if (cVar.f388a == cVar2.f388a && cVar.f389b == cVar2.f389b) {
            j(wVar);
            return false;
        }
        return a(wVar, cVar.f388a, cVar.f389b, cVar2.f388a, cVar2.f389b);
    }

    public boolean a(RecyclerView.w wVar, RecyclerView.w wVar2, RecyclerView.e.c cVar, RecyclerView.e.c cVar2) {
        int i;
        int i2;
        int i3 = cVar.f388a;
        int i4 = cVar.f389b;
        if (wVar2.c()) {
            int i5 = cVar.f388a;
            i = cVar.f389b;
            i2 = i5;
        } else {
            i2 = cVar2.f388a;
            i = cVar2.f389b;
        }
        return a(wVar, wVar2, i3, i4, i2, i);
    }

    public final void i(RecyclerView.w wVar) {
        p(wVar);
        f(wVar);
    }

    public final void j(RecyclerView.w wVar) {
        t(wVar);
        f(wVar);
    }

    public final void k(RecyclerView.w wVar) {
        r(wVar);
        f(wVar);
    }

    public final void a(RecyclerView.w wVar, boolean z) {
        d(wVar, z);
        f(wVar);
    }

    public final void l(RecyclerView.w wVar) {
        o(wVar);
    }

    public final void m(RecyclerView.w wVar) {
        s(wVar);
    }

    public final void n(RecyclerView.w wVar) {
        q(wVar);
    }

    public final void b(RecyclerView.w wVar, boolean z) {
        c(wVar, z);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v7\widget\l.java ==========

package android.support.v7.widget;

import android.view.View;

/* compiled from: ViewBoundsCheck */
class l {

    /* renamed from: a  reason: collision with root package name */
    final b f480a;

    /* renamed from: b  reason: collision with root package name */
    a f481b = new a();

    /* compiled from: ViewBoundsCheck */
    interface b {
        int a();

        int a(View view);

        View a(int i);

        int b();

        int b(View view);
    }

    l(b bVar) {
        this.f480a = bVar;
    }

    /* compiled from: ViewBoundsCheck */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f482a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f483b;
        int c;
        int d;
        int e;

        /* access modifiers changed from: package-private */
        public int a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i, int i2, int i3, int i4) {
            this.f483b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            this.f482a = i | this.f482a;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f482a = 0;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            if ((this.f482a & 7) != 0 && (this.f482a & (a(this.d, this.f483b) << 0)) == 0) {
                return false;
            }
            if ((this.f482a & 112) != 0 && (this.f482a & (a(this.d, this.c) << 4)) == 0) {
                return false;
            }
            if ((this.f482a & 1792) != 0 && (this.f482a & (a(this.e, this.f483b) << 8)) == 0) {
                return false;
            }
            if ((this.f482a & 28672) == 0 || (this.f482a & (a(this.e, this.c) << 12)) != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public View a(int i, int i2, int i3, int i4) {
        int a2 = this.f480a.a();
        int b2 = this.f480a.b();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a3 = this.f480a.a(i);
            this.f481b.a(a2, b2, this.f480a.a(a3), this.f480a.b(a3));
            if (i3 != 0) {
                this.f481b.a();
                this.f481b.a(i3);
                if (this.f481b.b()) {
                    return a3;
                }
            }
            if (i4 != 0) {
                this.f481b.a();
                this.f481b.a(i4);
                if (this.f481b.b()) {
                    view = a3;
                }
            }
            i += i5;
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public boolean a(View view, int i) {
        this.f481b.a(this.f480a.a(), this.f480a.b(), this.f480a.a(view), this.f480a.b(view));
        if (i == 0) {
            return false;
        }
        this.f481b.a();
        this.f481b.a(i);
        return this.f481b.b();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v7\widget\LinearLayoutManager.java ==========

package android.support.v7.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private c f367a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f368b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private final b g;
    private int h;
    int i;
    h j;
    boolean k;
    int l;
    int m;
    d n;
    final a o;

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.o oVar, RecyclerView.t tVar, a aVar, int i2) {
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i2, boolean z) {
        this.c = false;
        this.k = false;
        this.d = false;
        this.e = true;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.n = null;
        this.o = new a();
        this.g = new b();
        this.h = 2;
        b(i2);
        b(z);
        c(true);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.c = false;
        this.k = false;
        this.d = false;
        this.e = true;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.n = null;
        this.o = new a();
        this.g = new b();
        this.h = 2;
        RecyclerView.h.b a2 = a(context, attributeSet, i2, i3);
        b(a2.f395a);
        b(a2.c);
        a(a2.d);
        c(true);
    }

    public RecyclerView.i a() {
        return new RecyclerView.i(-2, -2);
    }

    public void a(RecyclerView recyclerView, RecyclerView.o oVar) {
        super.a(recyclerView, oVar);
        if (this.f) {
            c(oVar);
            oVar.a();
        }
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (u() > 0) {
            accessibilityEvent.setFromIndex(l());
            accessibilityEvent.setToIndex(m());
        }
    }

    public Parcelable c() {
        if (this.n != null) {
            return new d(this.n);
        }
        d dVar = new d();
        if (u() > 0) {
            h();
            boolean z = this.f368b ^ this.k;
            dVar.c = z;
            if (z) {
                View L = L();
                dVar.f376b = this.j.d() - this.j.b(L);
                dVar.f375a = d(L);
            } else {
                View K = K();
                dVar.f375a = d(K);
                dVar.f376b = this.j.a(K) - this.j.c();
            }
        } else {
            dVar.b();
        }
        return dVar;
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.n = (d) parcelable;
            n();
        }
    }

    public boolean d() {
        return this.i == 0;
    }

    public boolean e() {
        return this.i == 1;
    }

    public void a(boolean z) {
        a((String) null);
        if (this.d != z) {
            this.d = z;
            n();
        }
    }

    public int f() {
        return this.i;
    }

    public void b(int i2) {
        if (i2 == 0 || i2 == 1) {
            a((String) null);
            if (i2 != this.i) {
                this.i = i2;
                this.j = null;
                n();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i2);
    }

    private void J() {
        if (this.i == 1 || !g()) {
            this.k = this.c;
        } else {
            this.k = !this.c;
        }
    }

    public void b(boolean z) {
        a((String) null);
        if (z != this.c) {
            this.c = z;
            n();
        }
    }

    public View c(int i2) {
        int u = u();
        if (u == 0) {
            return null;
        }
        int d2 = i2 - d(h(0));
        if (d2 >= 0 && d2 < u) {
            View h2 = h(d2);
            if (d(h2) == i2) {
                return h2;
            }
        }
        return super.c(i2);
    }

    /* access modifiers changed from: protected */
    public int b(RecyclerView.t tVar) {
        if (tVar.d()) {
            return this.j.f();
        }
        return 0;
    }

    public void c(RecyclerView.o oVar, RecyclerView.t tVar) {
        int i2;
        int i3;
        int i4;
        View c2;
        int i5;
        int i6 = -1;
        if (!(this.n == null && this.l == -1) && tVar.e() == 0) {
            c(oVar);
            return;
        }
        if (this.n != null && this.n.a()) {
            this.l = this.n.f375a;
        }
        h();
        this.f367a.f373a = false;
        J();
        View D = D();
        if (!this.o.d || this.l != -1 || this.n != null) {
            this.o.a();
            this.o.c = this.k ^ this.d;
            a(oVar, tVar, this.o);
            this.o.d = true;
        } else if (D != null && (this.j.a(D) >= this.j.d() || this.j.b(D) <= this.j.c())) {
            this.o.a(D);
        }
        int b2 = b(tVar);
        if (this.f367a.j >= 0) {
            i2 = b2;
            b2 = 0;
        } else {
            i2 = 0;
        }
        int c3 = b2 + this.j.c();
        int g2 = i2 + this.j.g();
        if (!(!tVar.a() || this.l == -1 || this.m == Integer.MIN_VALUE || (c2 = c(this.l)) == null)) {
            if (this.k) {
                i5 = (this.j.d() - this.j.b(c2)) - this.m;
            } else {
                i5 = this.m - (this.j.a(c2) - this.j.c());
            }
            if (i5 > 0) {
                c3 += i5;
            } else {
                g2 -= i5;
            }
        }
        if (!this.o.c ? !this.k : this.k) {
            i6 = 1;
        }
        a(oVar, tVar, this.o, i6);
        a(oVar);
        this.f367a.l = j();
        this.f367a.i = tVar.a();
        if (this.o.c) {
            b(this.o);
            this.f367a.h = c3;
            a(oVar, this.f367a, tVar, false);
            i4 = this.f367a.f374b;
            int i7 = this.f367a.d;
            if (this.f367a.c > 0) {
                g2 += this.f367a.c;
            }
            a(this.o);
            this.f367a.h = g2;
            this.f367a.d += this.f367a.e;
            a(oVar, this.f367a, tVar, false);
            i3 = this.f367a.f374b;
            if (this.f367a.c > 0) {
                int i8 = this.f367a.c;
                h(i7, i4);
                this.f367a.h = i8;
                a(oVar, this.f367a, tVar, false);
                i4 = this.f367a.f374b;
            }
        } else {
            a(this.o);
            this.f367a.h = g2;
            a(oVar, this.f367a, tVar, false);
            i3 = this.f367a.f374b;
            int i9 = this.f367a.d;
            if (this.f367a.c > 0) {
                c3 += this.f367a.c;
            }
            b(this.o);
            this.f367a.h = c3;
            this.f367a.d += this.f367a.e;
            a(oVar, this.f367a, tVar, false);
            i4 = this.f367a.f374b;
            if (this.f367a.c > 0) {
                int i10 = this.f367a.c;
                a(i9, i3);
                this.f367a.h = i10;
                a(oVar, this.f367a, tVar, false);
                i3 = this.f367a.f374b;
            }
        }
        if (u() > 0) {
            if (this.k ^ this.d) {
                int a2 = a(i3, oVar, tVar, true);
                int i11 = i4 + a2;
                int i12 = i3 + a2;
                int b3 = b(i11, oVar, tVar, false);
                i4 = i11 + b3;
                i3 = i12 + b3;
            } else {
                int b4 = b(i4, oVar, tVar, true);
                int i13 = i4 + b4;
                int i14 = i3 + b4;
                int a3 = a(i14, oVar, tVar, false);
                i4 = i13 + a3;
                i3 = i14 + a3;
            }
        }
        b(oVar, tVar, i4, i3);
        if (!tVar.a()) {
            this.j.a();
        } else {
            this.o.a();
        }
        this.f368b = this.d;
    }

    public void a(RecyclerView.t tVar) {
        super.a(tVar);
        this.n = null;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.o.a();
    }

    private void b(RecyclerView.o oVar, RecyclerView.t tVar, int i2, int i3) {
        RecyclerView.o oVar2 = oVar;
        RecyclerView.t tVar2 = tVar;
        if (tVar.b() && u() != 0 && !tVar.a() && b()) {
            List<RecyclerView.w> c2 = oVar.c();
            int size = c2.size();
            int d2 = d(h(0));
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                RecyclerView.w wVar = c2.get(i6);
                if (!wVar.q()) {
                    char c3 = 1;
                    if ((wVar.d() < d2) != this.k) {
                        c3 = 65535;
                    }
                    if (c3 == 65535) {
                        i4 += this.j.e(wVar.f413a);
                    } else {
                        i5 += this.j.e(wVar.f413a);
                    }
                }
            }
            this.f367a.k = c2;
            if (i4 > 0) {
                h(d(K()), i2);
                this.f367a.h = i4;
                this.f367a.c = 0;
                this.f367a.a();
                a(oVar2, this.f367a, tVar2, false);
            }
            if (i5 > 0) {
                a(d(L()), i3);
                this.f367a.h = i5;
                this.f367a.c = 0;
                this.f367a.a();
                a(oVar2, this.f367a, tVar2, false);
            }
            this.f367a.k = null;
        }
    }

    private void a(RecyclerView.o oVar, RecyclerView.t tVar, a aVar) {
        if (!a(tVar, aVar) && !b(oVar, tVar, aVar)) {
            aVar.b();
            aVar.f369a = this.d ? tVar.e() - 1 : 0;
        }
    }

    private boolean b(RecyclerView.o oVar, RecyclerView.t tVar, a aVar) {
        View view;
        int i2;
        boolean z = false;
        if (u() == 0) {
            return false;
        }
        View D = D();
        if (D != null && aVar.a(D, tVar)) {
            aVar.a(D);
            return true;
        } else if (this.f368b != this.d) {
            return false;
        } else {
            if (aVar.c) {
                view = f(oVar, tVar);
            } else {
                view = g(oVar, tVar);
            }
            if (view == null) {
                return false;
            }
            aVar.b(view);
            if (!tVar.a() && b()) {
                if (this.j.a(view) >= this.j.d() || this.j.b(view) < this.j.c()) {
                    z = true;
                }
                if (z) {
                    if (aVar.c) {
                        i2 = this.j.d();
                    } else {
                        i2 = this.j.c();
                    }
                    aVar.f370b = i2;
                }
            }
            return true;
        }
    }

    private boolean a(RecyclerView.t tVar, a aVar) {
        int i2;
        boolean z = false;
        if (tVar.a() || this.l == -1) {
            return false;
        }
        if (this.l < 0 || this.l >= tVar.e()) {
            this.l = -1;
            this.m = Integer.MIN_VALUE;
            return false;
        }
        aVar.f369a = this.l;
        if (this.n != null && this.n.a()) {
            aVar.c = this.n.c;
            if (aVar.c) {
                aVar.f370b = this.j.d() - this.n.f376b;
            } else {
                aVar.f370b = this.j.c() + this.n.f376b;
            }
            return true;
        } else if (this.m == Integer.MIN_VALUE) {
            View c2 = c(this.l);
            if (c2 == null) {
                if (u() > 0) {
                    if ((this.l < d(h(0))) == this.k) {
                        z = true;
                    }
                    aVar.c = z;
                }
                aVar.b();
            } else if (this.j.e(c2) > this.j.f()) {
                aVar.b();
                return true;
            } else if (this.j.a(c2) - this.j.c() < 0) {
                aVar.f370b = this.j.c();
                aVar.c = false;
                return true;
            } else if (this.j.d() - this.j.b(c2) < 0) {
                aVar.f370b = this.j.d();
                aVar.c = true;
                return true;
            } else {
                if (aVar.c) {
                    i2 = this.j.b(c2) + this.j.b();
                } else {
                    i2 = this.j.a(c2);
                }
                aVar.f370b = i2;
            }
            return true;
        } else {
            aVar.c = this.k;
            if (this.k) {
                aVar.f370b = this.j.d() - this.m;
            } else {
                aVar.f370b = this.j.c() + this.m;
            }
            return true;
        }
    }

    private int a(int i2, RecyclerView.o oVar, RecyclerView.t tVar, boolean z) {
        int d2;
        int d3 = this.j.d() - i2;
        if (d3 <= 0) {
            return 0;
        }
        int i3 = -c(-d3, oVar, tVar);
        int i4 = i2 + i3;
        if (!z || (d2 = this.j.d() - i4) <= 0) {
            return i3;
        }
        this.j.a(d2);
        return d2 + i3;
    }

    private int b(int i2, RecyclerView.o oVar, RecyclerView.t tVar, boolean z) {
        int c2;
        int c3 = i2 - this.j.c();
        if (c3 <= 0) {
            return 0;
        }
        int i3 = -c(c3, oVar, tVar);
        int i4 = i2 + i3;
        if (!z || (c2 = i4 - this.j.c()) <= 0) {
            return i3;
        }
        this.j.a(-c2);
        return i3 - c2;
    }

    private void a(a aVar) {
        a(aVar.f369a, aVar.f370b);
    }

    private void a(int i2, int i3) {
        this.f367a.c = this.j.d() - i3;
        this.f367a.e = this.k ? -1 : 1;
        this.f367a.d = i2;
        this.f367a.f = 1;
        this.f367a.f374b = i3;
        this.f367a.g = Integer.MIN_VALUE;
    }

    private void b(a aVar) {
        h(aVar.f369a, aVar.f370b);
    }

    private void h(int i2, int i3) {
        this.f367a.c = i3 - this.j.c();
        this.f367a.d = i2;
        this.f367a.e = this.k ? 1 : -1;
        this.f367a.f = -1;
        this.f367a.f374b = i3;
        this.f367a.g = Integer.MIN_VALUE;
    }

    /* access modifiers changed from: protected */
    public boolean g() {
        return s() == 1;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (this.f367a == null) {
            this.f367a = i();
        }
        if (this.j == null) {
            this.j = h.a(this, this.i);
        }
    }

    /* access modifiers changed from: package-private */
    public c i() {
        return new c();
    }

    public void d(int i2) {
        this.l = i2;
        this.m = Integer.MIN_VALUE;
        if (this.n != null) {
            this.n.b();
        }
        n();
    }

    public void b(int i2, int i3) {
        this.l = i2;
        this.m = i3;
        if (this.n != null) {
            this.n.b();
        }
        n();
    }

    public int a(int i2, RecyclerView.o oVar, RecyclerView.t tVar) {
        if (this.i == 1) {
            return 0;
        }
        return c(i2, oVar, tVar);
    }

    public int b(int i2, RecyclerView.o oVar, RecyclerView.t tVar) {
        if (this.i == 0) {
            return 0;
        }
        return c(i2, oVar, tVar);
    }

    public int c(RecyclerView.t tVar) {
        return i(tVar);
    }

    public int d(RecyclerView.t tVar) {
        return i(tVar);
    }

    public int e(RecyclerView.t tVar) {
        return j(tVar);
    }

    public int f(RecyclerView.t tVar) {
        return j(tVar);
    }

    public int g(RecyclerView.t tVar) {
        return k(tVar);
    }

    public int h(RecyclerView.t tVar) {
        return k(tVar);
    }

    private int i(RecyclerView.t tVar) {
        if (u() == 0) {
            return 0;
        }
        h();
        h hVar = this.j;
        View a2 = a(!this.e, true);
        return j.a(tVar, hVar, a2, b(!this.e, true), this, this.e, this.k);
    }

    private int j(RecyclerView.t tVar) {
        if (u() == 0) {
            return 0;
        }
        h();
        h hVar = this.j;
        View a2 = a(!this.e, true);
        return j.a(tVar, hVar, a2, b(!this.e, true), this, this.e);
    }

    private int k(RecyclerView.t tVar) {
        if (u() == 0) {
            return 0;
        }
        h();
        h hVar = this.j;
        View a2 = a(!this.e, true);
        return j.b(tVar, hVar, a2, b(!this.e, true), this, this.e);
    }

    private void a(int i2, int i3, boolean z, RecyclerView.t tVar) {
        int i4;
        this.f367a.l = j();
        this.f367a.h = b(tVar);
        this.f367a.f = i2;
        int i5 = -1;
        if (i2 == 1) {
            this.f367a.h += this.j.g();
            View L = L();
            c cVar = this.f367a;
            if (!this.k) {
                i5 = 1;
            }
            cVar.e = i5;
            this.f367a.d = d(L) + this.f367a.e;
            this.f367a.f374b = this.j.b(L);
            i4 = this.j.b(L) - this.j.d();
        } else {
            View K = K();
            this.f367a.h += this.j.c();
            c cVar2 = this.f367a;
            if (this.k) {
                i5 = 1;
            }
            cVar2.e = i5;
            this.f367a.d = d(K) + this.f367a.e;
            this.f367a.f374b = this.j.a(K);
            i4 = (-this.j.a(K)) + this.j.c();
        }
        this.f367a.c = i3;
        if (z) {
            this.f367a.c -= i4;
        }
        this.f367a.g = i4;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.j.h() == 0 && this.j.e() == 0;
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.t tVar, c cVar, RecyclerView.h.a aVar) {
        int i2 = cVar.d;
        if (i2 >= 0 && i2 < tVar.e()) {
            aVar.b(i2, Math.max(0, cVar.g));
        }
    }

    public void a(int i2, RecyclerView.h.a aVar) {
        int i3;
        boolean z;
        int i4 = -1;
        if (this.n == null || !this.n.a()) {
            J();
            z = this.k;
            if (this.l == -1) {
                i3 = z ? i2 - 1 : 0;
            } else {
                i3 = this.l;
            }
        } else {
            z = this.n.c;
            i3 = this.n.f375a;
        }
        if (!z) {
            i4 = 1;
        }
        for (int i5 = 0; i5 < this.h && i3 >= 0 && i3 < i2; i5++) {
            aVar.b(i3, 0);
            i3 += i4;
        }
    }

    public void a(int i2, int i3, RecyclerView.t tVar, RecyclerView.h.a aVar) {
        if (this.i != 0) {
            i2 = i3;
        }
        if (u() != 0 && i2 != 0) {
            h();
            a(i2 > 0 ? 1 : -1, Math.abs(i2), true, tVar);
            a(tVar, this.f367a, aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public int c(int i2, RecyclerView.o oVar, RecyclerView.t tVar) {
        if (u() == 0 || i2 == 0) {
            return 0;
        }
        this.f367a.f373a = true;
        h();
        int i3 = i2 > 0 ? 1 : -1;
        int abs = Math.abs(i2);
        a(i3, abs, true, tVar);
        int a2 = this.f367a.g + a(oVar, this.f367a, tVar, false);
        if (a2 < 0) {
            return 0;
        }
        if (abs > a2) {
            i2 = i3 * a2;
        }
        this.j.a(-i2);
        this.f367a.j = i2;
        return i2;
    }

    public void a(String str) {
        if (this.n == null) {
            super.a(str);
        }
    }

    private void a(RecyclerView.o oVar, int i2, int i3) {
        if (i2 != i3) {
            if (i3 > i2) {
                for (int i4 = i3 - 1; i4 >= i2; i4--) {
                    a(i4, oVar);
                }
                return;
            }
            while (i2 > i3) {
                a(i2, oVar);
                i2--;
            }
        }
    }

    private void a(RecyclerView.o oVar, int i2) {
        if (i2 >= 0) {
            int u = u();
            if (this.k) {
                int i3 = u - 1;
                for (int i4 = i3; i4 >= 0; i4--) {
                    View h2 = h(i4);
                    if (this.j.b(h2) > i2 || this.j.c(h2) > i2) {
                        a(oVar, i3, i4);
                        return;
                    }
                }
                return;
            }
            for (int i5 = 0; i5 < u; i5++) {
                View h3 = h(i5);
                if (this.j.b(h3) > i2 || this.j.c(h3) > i2) {
                    a(oVar, 0, i5);
                    return;
                }
            }
        }
    }

    private void b(RecyclerView.o oVar, int i2) {
        int u = u();
        if (i2 >= 0) {
            int e2 = this.j.e() - i2;
            if (this.k) {
                for (int i3 = 0; i3 < u; i3++) {
                    View h2 = h(i3);
                    if (this.j.a(h2) < e2 || this.j.d(h2) < e2) {
                        a(oVar, 0, i3);
                        return;
                    }
                }
                return;
            }
            int i4 = u - 1;
            for (int i5 = i4; i5 >= 0; i5--) {
                View h3 = h(i5);
                if (this.j.a(h3) < e2 || this.j.d(h3) < e2) {
                    a(oVar, i4, i5);
                    return;
                }
            }
        }
    }

    private void a(RecyclerView.o oVar, c cVar) {
        if (cVar.f373a && !cVar.l) {
            if (cVar.f == -1) {
                b(oVar, cVar.g);
            } else {
                a(oVar, cVar.g);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int a(RecyclerView.o oVar, c cVar, RecyclerView.t tVar, boolean z) {
        int i2 = cVar.c;
        if (cVar.g != Integer.MIN_VALUE) {
            if (cVar.c < 0) {
                cVar.g += cVar.c;
            }
            a(oVar, cVar);
        }
        int i3 = cVar.c + cVar.h;
        b bVar = this.g;
        while (true) {
            if ((!cVar.l && i3 <= 0) || !cVar.a(tVar)) {
                break;
            }
            bVar.a();
            a(oVar, tVar, cVar, bVar);
            if (!bVar.f372b) {
                cVar.f374b += bVar.f371a * cVar.f;
                if (!bVar.c || this.f367a.k != null || !tVar.a()) {
                    cVar.c -= bVar.f371a;
                    i3 -= bVar.f371a;
                }
                if (cVar.g != Integer.MIN_VALUE) {
                    cVar.g += bVar.f371a;
                    if (cVar.c < 0) {
                        cVar.g += cVar.c;
                    }
                    a(oVar, cVar);
                }
                if (z && bVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - cVar.c;
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.o oVar, RecyclerView.t tVar, c cVar, b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        View a2 = cVar.a(oVar);
        if (a2 == null) {
            bVar.f372b = true;
            return;
        }
        RecyclerView.i iVar = (RecyclerView.i) a2.getLayoutParams();
        if (cVar.k == null) {
            if (this.k == (cVar.f == -1)) {
                b(a2);
            } else {
                b(a2, 0);
            }
        } else {
            if (this.k == (cVar.f == -1)) {
                a(a2);
            } else {
                a(a2, 0);
            }
        }
        a(a2, 0, 0);
        bVar.f371a = this.j.e(a2);
        if (this.i == 1) {
            if (g()) {
                i6 = x() - B();
                i5 = i6 - this.j.f(a2);
            } else {
                i5 = z();
                i6 = this.j.f(a2) + i5;
            }
            if (cVar.f == -1) {
                int i7 = cVar.f374b;
                i4 = cVar.f374b - bVar.f371a;
                i3 = i6;
                i2 = i7;
            } else {
                int i8 = cVar.f374b;
                i2 = cVar.f374b + bVar.f371a;
                i3 = i6;
                i4 = i8;
            }
        } else {
            int A = A();
            int f2 = this.j.f(a2) + A;
            if (cVar.f == -1) {
                i4 = A;
                i3 = cVar.f374b;
                i2 = f2;
                i5 = cVar.f374b - bVar.f371a;
            } else {
                int i9 = cVar.f374b;
                i3 = cVar.f374b + bVar.f371a;
                i4 = A;
                i2 = f2;
                i5 = i9;
            }
        }
        a(a2, i5, i4, i3, i2);
        if (iVar.d() || iVar.e()) {
            bVar.c = true;
        }
        bVar.d = a2.hasFocusable();
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return (w() == 1073741824 || v() == 1073741824 || !I()) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public int e(int i2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        switch (i2) {
                            case 1:
                                return (this.i != 1 && g()) ? 1 : -1;
                            case 2:
                                return (this.i != 1 && g()) ? -1 : 1;
                            default:
                                return Integer.MIN_VALUE;
                        }
                    } else if (this.i == 1) {
                        return 1;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (this.i == 0) {
                    return 1;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (this.i == 1) {
                return -1;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (this.i == 0) {
            return -1;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    private View K() {
        return h(this.k ? u() - 1 : 0);
    }

    private View L() {
        return h(this.k ? 0 : u() - 1);
    }

    private View a(boolean z, boolean z2) {
        if (this.k) {
            return a(u() - 1, -1, z, z2);
        }
        return a(0, u(), z, z2);
    }

    private View b(boolean z, boolean z2) {
        if (this.k) {
            return a(0, u(), z, z2);
        }
        return a(u() - 1, -1, z, z2);
    }

    private View f(RecyclerView.o oVar, RecyclerView.t tVar) {
        if (this.k) {
            return h(oVar, tVar);
        }
        return i(oVar, tVar);
    }

    private View g(RecyclerView.o oVar, RecyclerView.t tVar) {
        if (this.k) {
            return i(oVar, tVar);
        }
        return h(oVar, tVar);
    }

    private View h(RecyclerView.o oVar, RecyclerView.t tVar) {
        return a(oVar, tVar, 0, u(), tVar.e());
    }

    private View i(RecyclerView.o oVar, RecyclerView.t tVar) {
        return a(oVar, tVar, u() - 1, -1, tVar.e());
    }

    /* access modifiers changed from: package-private */
    public View a(RecyclerView.o oVar, RecyclerView.t tVar, int i2, int i3, int i4) {
        h();
        int c2 = this.j.c();
        int d2 = this.j.d();
        int i5 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View h2 = h(i2);
            int d3 = d(h2);
            if (d3 >= 0 && d3 < i4) {
                if (((RecyclerView.i) h2.getLayoutParams()).d()) {
                    if (view2 == null) {
                        view2 = h2;
                    }
                } else if (this.j.a(h2) < d2 && this.j.b(h2) >= c2) {
                    return h2;
                } else {
                    if (view == null) {
                        view = h2;
                    }
                }
            }
            i2 += i5;
        }
        return view != null ? view : view2;
    }

    private View j(RecyclerView.o oVar, RecyclerView.t tVar) {
        if (this.k) {
            return l(oVar, tVar);
        }
        return m(oVar, tVar);
    }

    private View k(RecyclerView.o oVar, RecyclerView.t tVar) {
        if (this.k) {
            return m(oVar, tVar);
        }
        return l(oVar, tVar);
    }

    private View l(RecyclerView.o oVar, RecyclerView.t tVar) {
        return c(0, u());
    }

    private View m(RecyclerView.o oVar, RecyclerView.t tVar) {
        return c(u() - 1, -1);
    }

    public int l() {
        View a2 = a(0, u(), false, true);
        if (a2 == null) {
            return -1;
        }
        return d(a2);
    }

    public int m() {
        View a2 = a(u() - 1, -1, false, true);
        if (a2 == null) {
            return -1;
        }
        return d(a2);
    }

    /* access modifiers changed from: package-private */
    public View a(int i2, int i3, boolean z, boolean z2) {
        h();
        int i4 = 320;
        int i5 = z ? 24579 : 320;
        if (!z2) {
            i4 = 0;
        }
        if (this.i == 0) {
            return this.r.a(i2, i3, i5, i4);
        }
        return this.s.a(i2, i3, i5, i4);
    }

    /* access modifiers changed from: package-private */
    public View c(int i2, int i3) {
        int i4;
        int i5;
        h();
        if ((i3 > i2 ? 1 : i3 < i2 ? (char) 65535 : 0) == 0) {
            return h(i2);
        }
        if (this.j.a(h(i2)) < this.j.c()) {
            i5 = 16644;
            i4 = 16388;
        } else {
            i5 = 4161;
            i4 = 4097;
        }
        if (this.i == 0) {
            return this.r.a(i2, i3, i5, i4);
        }
        return this.s.a(i2, i3, i5, i4);
    }

    public View a(View view, int i2, RecyclerView.o oVar, RecyclerView.t tVar) {
        int e2;
        View view2;
        View view3;
        J();
        if (u() == 0 || (e2 = e(i2)) == Integer.MIN_VALUE) {
            return null;
        }
        h();
        h();
        a(e2, (int) (((float) this.j.f()) * 0.33333334f), false, tVar);
        this.f367a.g = Integer.MIN_VALUE;
        this.f367a.f373a = false;
        a(oVar, this.f367a, tVar, true);
        if (e2 == -1) {
            view2 = k(oVar, tVar);
        } else {
            view2 = j(oVar, tVar);
        }
        if (e2 == -1) {
            view3 = K();
        } else {
            view3 = L();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }

    public boolean b() {
        return this.n == null && this.f368b == this.d;
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        boolean f373a = true;

        /* renamed from: b  reason: collision with root package name */
        int f374b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h = 0;
        boolean i = false;
        int j;
        List<RecyclerView.w> k = null;
        boolean l;

        c() {
        }

        /* access modifiers changed from: package-private */
        public boolean a(RecyclerView.t tVar) {
            return this.d >= 0 && this.d < tVar.e();
        }

        /* access modifiers changed from: package-private */
        public View a(RecyclerView.o oVar) {
            if (this.k != null) {
                return b();
            }
            View c2 = oVar.c(this.d);
            this.d += this.e;
            return c2;
        }

        private View b() {
            int size = this.k.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = this.k.get(i2).f413a;
                RecyclerView.i iVar = (RecyclerView.i) view.getLayoutParams();
                if (!iVar.d() && this.d == iVar.f()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            a((View) null);
        }

        public void a(View view) {
            View b2 = b(view);
            if (b2 == null) {
                this.d = -1;
            } else {
                this.d = ((RecyclerView.i) b2.getLayoutParams()).f();
            }
        }

        public View b(View view) {
            int f2;
            int size = this.k.size();
            View view2 = null;
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < size; i3++) {
                View view3 = this.k.get(i3).f413a;
                RecyclerView.i iVar = (RecyclerView.i) view3.getLayoutParams();
                if (view3 != view && !iVar.d() && (f2 = (iVar.f() - this.d) * this.e) >= 0 && f2 < i2) {
                    if (f2 == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i2 = f2;
                }
            }
            return view2;
        }
    }

    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() {
            /* renamed from: a */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            /* renamed from: a */
            public d[] newArray(int i) {
                return new d[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f375a;

        /* renamed from: b  reason: collision with root package name */
        int f376b;
        boolean c;

        public int describeContents() {
            return 0;
        }

        public d() {
        }

        d(Parcel parcel) {
            this.f375a = parcel.readInt();
            this.f376b = parcel.readInt();
            this.c = parcel.readInt() != 1 ? false : true;
        }

        public d(d dVar) {
            this.f375a = dVar.f375a;
            this.f376b = dVar.f376b;
            this.c = dVar.c;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f375a >= 0;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f375a = -1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f375a);
            parcel.writeInt(this.f376b);
            parcel.writeInt(this.c ? 1 : 0);
        }
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        int f369a;

        /* renamed from: b  reason: collision with root package name */
        int f370b;
        boolean c;
        boolean d;

        a() {
            a();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f369a = -1;
            this.f370b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int i;
            if (this.c) {
                i = LinearLayoutManager.this.j.d();
            } else {
                i = LinearLayoutManager.this.j.c();
            }
            this.f370b = i;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f369a + ", mCoordinate=" + this.f370b + ", mLayoutFromEnd=" + this.c + ", mValid=" + this.d + '}';
        }

        /* access modifiers changed from: package-private */
        public boolean a(View view, RecyclerView.t tVar) {
            RecyclerView.i iVar = (RecyclerView.i) view.getLayoutParams();
            return !iVar.d() && iVar.f() >= 0 && iVar.f() < tVar.e();
        }

        public void a(View view) {
            int b2 = LinearLayoutManager.this.j.b();
            if (b2 >= 0) {
                b(view);
                return;
            }
            this.f369a = LinearLayoutManager.this.d(view);
            if (this.c) {
                int d2 = (LinearLayoutManager.this.j.d() - b2) - LinearLayoutManager.this.j.b(view);
                this.f370b = LinearLayoutManager.this.j.d() - d2;
                if (d2 > 0) {
                    int e2 = this.f370b - LinearLayoutManager.this.j.e(view);
                    int c2 = LinearLayoutManager.this.j.c();
                    int min = e2 - (c2 + Math.min(LinearLayoutManager.this.j.a(view) - c2, 0));
                    if (min < 0) {
                        this.f370b += Math.min(d2, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int a2 = LinearLayoutManager.this.j.a(view);
            int c3 = a2 - LinearLayoutManager.this.j.c();
            this.f370b = a2;
            if (c3 > 0) {
                int d3 = (LinearLayoutManager.this.j.d() - Math.min(0, (LinearLayoutManager.this.j.d() - b2) - LinearLayoutManager.this.j.b(view))) - (a2 + LinearLayoutManager.this.j.e(view));
                if (d3 < 0) {
                    this.f370b -= Math.min(c3, -d3);
                }
            }
        }

        public void b(View view) {
            if (this.c) {
                this.f370b = LinearLayoutManager.this.j.b(view) + LinearLayoutManager.this.j.b();
            } else {
                this.f370b = LinearLayoutManager.this.j.a(view);
            }
            this.f369a = LinearLayoutManager.this.d(view);
        }
    }

    protected static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f371a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f372b;
        public boolean c;
        public boolean d;

        protected b() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f371a = 0;
            this.f372b = false;
            this.c = false;
            this.d = false;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v7\widget\m.java ==========

package android.support.v7.widget;

import android.support.v4.d.c;
import android.support.v4.d.e;
import android.support.v7.widget.RecyclerView;

/* compiled from: ViewInfoStore */
class m {

    /* renamed from: a  reason: collision with root package name */
    final android.support.v4.d.a<RecyclerView.w, a> f484a = new android.support.v4.d.a<>();

    /* renamed from: b  reason: collision with root package name */
    final c<RecyclerView.w> f485b = new c<>();

    /* compiled from: ViewInfoStore */
    interface b {
        void a(RecyclerView.w wVar);

        void a(RecyclerView.w wVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2);

        void b(RecyclerView.w wVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2);

        void c(RecyclerView.w wVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2);
    }

    m() {
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f484a.clear();
        this.f485b.c();
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.w wVar, RecyclerView.e.c cVar) {
        a aVar = this.f484a.get(wVar);
        if (aVar == null) {
            aVar = a.a();
            this.f484a.put(wVar, aVar);
        }
        aVar.f487b = cVar;
        aVar.f486a |= 4;
    }

    /* access modifiers changed from: package-private */
    public boolean a(RecyclerView.w wVar) {
        a aVar = this.f484a.get(wVar);
        if (aVar == null || (aVar.f486a & 1) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.e.c b(RecyclerView.w wVar) {
        return a(wVar, 4);
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.e.c c(RecyclerView.w wVar) {
        return a(wVar, 8);
    }

    private RecyclerView.e.c a(RecyclerView.w wVar, int i) {
        a c;
        RecyclerView.e.c cVar;
        int a2 = this.f484a.a((Object) wVar);
        if (a2 < 0 || (c = this.f484a.c(a2)) == null || (c.f486a & i) == 0) {
            return null;
        }
        c.f486a &= i ^ -1;
        if (i == 4) {
            cVar = c.f487b;
        } else if (i == 8) {
            cVar = c.c;
        } else {
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }
        if ((c.f486a & 12) == 0) {
            this.f484a.d(a2);
            a.a(c);
        }
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public void a(long j, RecyclerView.w wVar) {
        this.f485b.b(j, wVar);
    }

    /* access modifiers changed from: package-private */
    public void b(RecyclerView.w wVar, RecyclerView.e.c cVar) {
        a aVar = this.f484a.get(wVar);
        if (aVar == null) {
            aVar = a.a();
            this.f484a.put(wVar, aVar);
        }
        aVar.f486a |= 2;
        aVar.f487b = cVar;
    }

    /* access modifiers changed from: package-private */
    public boolean d(RecyclerView.w wVar) {
        a aVar = this.f484a.get(wVar);
        return (aVar == null || (aVar.f486a & 4) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.w a(long j) {
        return this.f485b.a(j);
    }

    /* access modifiers changed from: package-private */
    public void c(RecyclerView.w wVar, RecyclerView.e.c cVar) {
        a aVar = this.f484a.get(wVar);
        if (aVar == null) {
            aVar = a.a();
            this.f484a.put(wVar, aVar);
        }
        aVar.c = cVar;
        aVar.f486a |= 8;
    }

    /* access modifiers changed from: package-private */
    public void e(RecyclerView.w wVar) {
        a aVar = this.f484a.get(wVar);
        if (aVar == null) {
            aVar = a.a();
            this.f484a.put(wVar, aVar);
        }
        aVar.f486a |= 1;
    }

    /* access modifiers changed from: package-private */
    public void f(RecyclerView.w wVar) {
        a aVar = this.f484a.get(wVar);
        if (aVar != null) {
            aVar.f486a &= -2;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        for (int size = this.f484a.size() - 1; size >= 0; size--) {
            RecyclerView.w b2 = this.f484a.b(size);
            a d = this.f484a.d(size);
            if ((d.f486a & 3) == 3) {
                bVar.a(b2);
            } else if ((d.f486a & 1) != 0) {
                if (d.f487b == null) {
                    bVar.a(b2);
                } else {
                    bVar.a(b2, d.f487b, d.c);
                }
            } else if ((d.f486a & 14) == 14) {
                bVar.b(b2, d.f487b, d.c);
            } else if ((d.f486a & 12) == 12) {
                bVar.c(b2, d.f487b, d.c);
            } else if ((d.f486a & 4) != 0) {
                bVar.a(b2, d.f487b, (RecyclerView.e.c) null);
            } else if ((d.f486a & 8) != 0) {
                bVar.b(b2, d.f487b, d.c);
            } else {
                int i = d.f486a;
            }
            a.a(d);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(RecyclerView.w wVar) {
        int b2 = this.f485b.b() - 1;
        while (true) {
            if (b2 < 0) {
                break;
            } else if (wVar == this.f485b.c(b2)) {
                this.f485b.a(b2);
                break;
            } else {
                b2--;
            }
        }
        a remove = this.f484a.remove(wVar);
        if (remove != null) {
            a.a(remove);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        a.b();
    }

    public void h(RecyclerView.w wVar) {
        f(wVar);
    }

    /* compiled from: ViewInfoStore */
    static class a {
        static e.a<a> d = new e.b(20);

        /* renamed from: a  reason: collision with root package name */
        int f486a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView.e.c f487b;
        RecyclerView.e.c c;

        private a() {
        }

        static a a() {
            a a2 = d.a();
            return a2 == null ? new a() : a2;
        }

        static void a(a aVar) {
            aVar.f486a = 0;
            aVar.f487b = null;
            aVar.c = null;
            d.a(aVar);
        }

        static void b() {
            do {
            } while (d.a() != null);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v7\widget\RecyclerView.java ==========

package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.a.b;
import android.support.v7.a.a;
import android.support.v7.widget.a;
import android.support.v7.widget.b;
import android.support.v7.widget.e;
import android.support.v7.widget.l;
import android.support.v7.widget.m;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.fxgear.GlobalDefine;
import net.fxgear.fittingview.data.FittingFaceData;
import net.fxgear.util.FXUtil;

public class RecyclerView extends ViewGroup implements android.support.v4.view.e {
    static final Interpolator H = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private static final int[] I = {16843830};
    private static final int[] J = {16842987};
    /* access modifiers changed from: private */
    public static final boolean K = (Build.VERSION.SDK_INT >= 21);
    private static final boolean L = (Build.VERSION.SDK_INT <= 15);
    private static final boolean M = (Build.VERSION.SDK_INT <= 15);
    private static final Class<?>[] N = {Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};

    /* renamed from: a  reason: collision with root package name */
    static final boolean f377a = (Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20);

    /* renamed from: b  reason: collision with root package name */
    static final boolean f378b = (Build.VERSION.SDK_INT >= 23);
    static final boolean c = (Build.VERSION.SDK_INT >= 16);
    e.a A;
    final t B;
    boolean C;
    boolean D;
    boolean E;
    i F;
    final List<w> G;
    private final q O;
    private r P;
    private final Rect Q;
    private final ArrayList<l> R;
    private l S;
    private int T;
    private boolean U;
    private int V;
    private final AccessibilityManager W;
    private android.support.v4.view.f aA;
    private final int[] aB;
    /* access modifiers changed from: private */
    public final int[] aC;
    private final int[] aD;
    private Runnable aE;
    private final m.b aF;
    private List<j> aa;
    private int ab;
    private int ac;
    private EdgeEffect ad;
    private EdgeEffect ae;
    private EdgeEffect af;
    private EdgeEffect ag;
    private int ah;
    private int ai;
    private VelocityTracker aj;
    private int ak;
    private int al;
    private int am;
    private int an;
    private int ao;
    private k ap;
    private final int aq;
    private final int ar;
    private float as;
    private float at;
    private boolean au;
    private m av;
    private List<m> aw;
    private e.b ax;
    private d ay;
    private final int[] az;
    final o d;
    a e;
    b f;
    final m g;
    boolean h;
    final Runnable i;
    final Rect j;
    final RectF k;
    a l;
    h m;
    p n;
    final ArrayList<g> o;
    boolean p;
    boolean q;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    boolean v;
    boolean w;
    e x;
    final v y;
    e z;

    public interface d {
        int a(int i, int i2);
    }

    public interface j {
        void a(View view);

        void b(View view);
    }

    public static abstract class k {
        public abstract boolean a(int i, int i2);
    }

    public interface l {
        void a(boolean z);

        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class m {
        public void a(RecyclerView recyclerView, int i) {
        }

        public void a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public interface p {
        void a(w wVar);
    }

    public static abstract class u {
        public abstract View a(o oVar, int i, int i2);
    }

    public void e(int i2) {
    }

    public void h(int i2, int i3) {
    }

    public void h(View view) {
    }

    public void i(View view) {
    }

    public RecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.O = new q();
        this.d = new o();
        this.g = new m();
        this.i = new Runnable() {
            public void run() {
                if (RecyclerView.this.s && !RecyclerView.this.isLayoutRequested()) {
                    if (!RecyclerView.this.p) {
                        RecyclerView.this.requestLayout();
                    } else if (RecyclerView.this.u) {
                        RecyclerView.this.t = true;
                    } else {
                        RecyclerView.this.d();
                    }
                }
            }
        };
        this.j = new Rect();
        this.Q = new Rect();
        this.k = new RectF();
        this.o = new ArrayList<>();
        this.R = new ArrayList<>();
        this.T = 0;
        this.w = false;
        this.ab = 0;
        this.ac = 0;
        this.x = new c();
        this.ah = 0;
        this.ai = -1;
        this.as = Float.MIN_VALUE;
        this.at = Float.MIN_VALUE;
        boolean z2 = true;
        this.au = true;
        this.y = new v();
        this.A = K ? new e.a() : null;
        this.B = new t();
        this.C = false;
        this.D = false;
        this.ax = new f();
        this.E = false;
        this.az = new int[2];
        this.aB = new int[2];
        this.aC = new int[2];
        this.aD = new int[2];
        this.G = new ArrayList();
        this.aE = new Runnable() {
            public void run() {
                if (RecyclerView.this.x != null) {
                    RecyclerView.this.x.a();
                }
                RecyclerView.this.E = false;
            }
        };
        this.aF = new m.b() {
            public void a(w wVar, e.c cVar, e.c cVar2) {
                RecyclerView.this.d.c(wVar);
                RecyclerView.this.b(wVar, cVar, cVar2);
            }

            public void b(w wVar, e.c cVar, e.c cVar2) {
                RecyclerView.this.a(wVar, cVar, cVar2);
            }

            public void c(w wVar, e.c cVar, e.c cVar2) {
                wVar.a(false);
                if (RecyclerView.this.w) {
                    if (RecyclerView.this.x.a(wVar, wVar, cVar, cVar2)) {
                        RecyclerView.this.p();
                    }
                } else if (RecyclerView.this.x.c(wVar, cVar, cVar2)) {
                    RecyclerView.this.p();
                }
            }

            public void a(w wVar) {
                RecyclerView.this.m.a(wVar.f413a, RecyclerView.this.d);
            }
        };
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, J, i2, 0);
            this.h = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.h = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.ao = viewConfiguration.getScaledTouchSlop();
        this.as = android.support.v4.view.m.a(viewConfiguration, context);
        this.at = android.support.v4.view.m.b(viewConfiguration, context);
        this.aq = viewConfiguration.getScaledMinimumFlingVelocity();
        this.ar = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.x.a(this.ax);
        b();
        A();
        if (android.support.v4.view.l.d(this) == 0) {
            android.support.v4.view.l.a((View) this, 1);
        }
        this.W = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new i(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, a.b.RecyclerView, i2, 0);
            String string = obtainStyledAttributes2.getString(a.b.RecyclerView_layoutManager);
            if (obtainStyledAttributes2.getInt(a.b.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            this.r = obtainStyledAttributes2.getBoolean(a.b.RecyclerView_fastScrollEnabled, false);
            if (this.r) {
                a((StateListDrawable) obtainStyledAttributes2.getDrawable(a.b.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes2.getDrawable(a.b.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes2.getDrawable(a.b.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes2.getDrawable(a.b.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            obtainStyledAttributes2.recycle();
            a(context, string, attributeSet, i2, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, I, i2, 0);
                boolean z3 = obtainStyledAttributes3.getBoolean(0, true);
                obtainStyledAttributes3.recycle();
                z2 = z3;
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z2);
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return " " + super.toString() + ", adapter:" + this.l + ", layout:" + this.m + ", context:" + getContext();
    }

    public i getCompatAccessibilityDelegate() {
        return this.F;
    }

    public void setAccessibilityDelegateCompat(i iVar) {
        this.F = iVar;
        android.support.v4.view.l.a((View) this, (android.support.v4.view.b) this.F);
    }

    private void a(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        ClassLoader classLoader;
        Constructor<? extends U> constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String a2 = a(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = classLoader.loadClass(a2).asSubclass(h.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(N);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                    } catch (NoSuchMethodException e2) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((h) constructor.newInstance(objArr));
                } catch (NoSuchMethodException e3) {
                    e3.initCause(e2);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + a2, e3);
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + a2, e4);
                } catch (InvocationTargetException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a2, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a2, e6);
                } catch (IllegalAccessException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + a2, e7);
                } catch (ClassCastException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + a2, e8);
                }
            }
        }
    }

    private String a(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(FittingFaceData.FILE_EXTENSION_DOT)) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    private void A() {
        this.f = new b(new b.C0021b() {
            public int a() {
                return RecyclerView.this.getChildCount();
            }

            public void a(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView.this.m(view);
            }

            public int a(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            public void a(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.l(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i);
            }

            public View b(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            public void b() {
                int a2 = a();
                for (int i = 0; i < a2; i++) {
                    View b2 = b(i);
                    RecyclerView.this.l(b2);
                    b2.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            public w b(View view) {
                return RecyclerView.e(view);
            }

            public void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
                w e = RecyclerView.e(view);
                if (e != null) {
                    if (e.r() || e.c()) {
                        e.m();
                    } else {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + e + RecyclerView.this.a());
                    }
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }

            public void c(int i) {
                w e;
                View b2 = b(i);
                if (!(b2 == null || (e = RecyclerView.e(b2)) == null)) {
                    if (!e.r() || e.c()) {
                        e.b(256);
                    } else {
                        throw new IllegalArgumentException("called detach on an already detached child " + e + RecyclerView.this.a());
                    }
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            public void c(View view) {
                w e = RecyclerView.e(view);
                if (e != null) {
                    e.a(RecyclerView.this);
                }
            }

            public void d(View view) {
                w e = RecyclerView.e(view);
                if (e != null) {
                    e.b(RecyclerView.this);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.e = new a(new a.C0020a() {
            public w a(int i) {
                w a2 = RecyclerView.this.a(i, true);
                if (a2 != null && !RecyclerView.this.f.c(a2.f413a)) {
                    return a2;
                }
                return null;
            }

            public void a(int i, int i2) {
                RecyclerView.this.a(i, i2, true);
                RecyclerView.this.C = true;
                RecyclerView.this.B.f410b += i2;
            }

            public void b(int i, int i2) {
                RecyclerView.this.a(i, i2, false);
                RecyclerView.this.C = true;
            }

            public void a(int i, int i2, Object obj) {
                RecyclerView.this.a(i, i2, obj);
                RecyclerView.this.D = true;
            }

            public void a(a.b bVar) {
                c(bVar);
            }

            /* access modifiers changed from: package-private */
            public void c(a.b bVar) {
                int i = bVar.f432a;
                if (i == 4) {
                    RecyclerView.this.m.a(RecyclerView.this, bVar.f433b, bVar.d, bVar.c);
                } else if (i != 8) {
                    switch (i) {
                        case 1:
                            RecyclerView.this.m.a(RecyclerView.this, bVar.f433b, bVar.d);
                            return;
                        case 2:
                            RecyclerView.this.m.b(RecyclerView.this, bVar.f433b, bVar.d);
                            return;
                        default:
                            return;
                    }
                } else {
                    RecyclerView.this.m.a(RecyclerView.this, bVar.f433b, bVar.d, 1);
                }
            }

            public void b(a.b bVar) {
                c(bVar);
            }

            public void c(int i, int i2) {
                RecyclerView.this.g(i, i2);
                RecyclerView.this.C = true;
            }

            public void d(int i, int i2) {
                RecyclerView.this.f(i, i2);
                RecyclerView.this.C = true;
            }
        });
    }

    public void setHasFixedSize(boolean z2) {
        this.q = z2;
    }

    public void setClipToPadding(boolean z2) {
        if (z2 != this.h) {
            k();
        }
        this.h = z2;
        super.setClipToPadding(z2);
        if (this.s) {
            requestLayout();
        }
    }

    public boolean getClipToPadding() {
        return this.h;
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i2) {
            case 0:
                break;
            case 1:
                this.ao = viewConfiguration.getScaledPagingTouchSlop();
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
                break;
        }
        this.ao = viewConfiguration.getScaledTouchSlop();
    }

    public void setAdapter(a aVar) {
        setLayoutFrozen(false);
        a(aVar, false, true);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.x != null) {
            this.x.d();
        }
        if (this.m != null) {
            this.m.c(this.d);
            this.m.b(this.d);
        }
        this.d.a();
    }

    private void a(a aVar, boolean z2, boolean z3) {
        if (this.l != null) {
            this.l.b((c) this.O);
            this.l.b(this);
        }
        if (!z2 || z3) {
            c();
        }
        this.e.a();
        a aVar2 = this.l;
        this.l = aVar;
        if (aVar != null) {
            aVar.a((c) this.O);
            aVar.a(this);
        }
        if (this.m != null) {
            this.m.a(aVar2, this.l);
        }
        this.d.a(aVar2, this.l, z2);
        this.B.e = true;
        u();
    }

    public a getAdapter() {
        return this.l;
    }

    public void setRecyclerListener(p pVar) {
        this.n = pVar;
    }

    public int getBaseline() {
        if (this.m != null) {
            return this.m.t();
        }
        return super.getBaseline();
    }

    public void setLayoutManager(h hVar) {
        if (hVar != this.m) {
            f();
            if (this.m != null) {
                if (this.x != null) {
                    this.x.d();
                }
                this.m.c(this.d);
                this.m.b(this.d);
                this.d.a();
                if (this.p) {
                    this.m.b(this, this.d);
                }
                this.m.b((RecyclerView) null);
                this.m = null;
            } else {
                this.d.a();
            }
            this.f.a();
            this.m = hVar;
            if (hVar != null) {
                if (hVar.q == null) {
                    this.m.b(this);
                    if (this.p) {
                        this.m.c(this);
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + hVar + " is already attached to a RecyclerView:" + hVar.q.a());
                }
            }
            this.d.b();
            requestLayout();
        }
    }

    public void setOnFlingListener(k kVar) {
        this.ap = kVar;
    }

    public k getOnFlingListener() {
        return this.ap;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        r rVar = new r(super.onSaveInstanceState());
        if (this.P != null) {
            rVar.a(this.P);
        } else if (this.m != null) {
            rVar.f404b = this.m.c();
        } else {
            rVar.f404b = null;
        }
        return rVar;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof r)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.P = (r) parcelable;
        super.onRestoreInstanceState(this.P.a());
        if (this.m != null && this.P.f404b != null) {
            this.m.a(this.P.f404b);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void e(w wVar) {
        View view = wVar.f413a;
        boolean z2 = view.getParent() == this;
        this.d.c(b(view));
        if (wVar.r()) {
            this.f.a(view, -1, view.getLayoutParams(), true);
        } else if (!z2) {
            this.f.a(view, true);
        } else {
            this.f.d(view);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(View view) {
        e();
        boolean f2 = this.f.f(view);
        if (f2) {
            w e2 = e(view);
            this.d.c(e2);
            this.d.b(e2);
        }
        a(!f2);
        return f2;
    }

    public h getLayoutManager() {
        return this.m;
    }

    public n getRecycledViewPool() {
        return this.d.g();
    }

    public void setRecycledViewPool(n nVar) {
        this.d.a(nVar);
    }

    public void setViewCacheExtension(u uVar) {
        this.d.a(uVar);
    }

    public void setItemViewCacheSize(int i2) {
        this.d.a(i2);
    }

    public int getScrollState() {
        return this.ah;
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i2) {
        if (i2 != this.ah) {
            this.ah = i2;
            if (i2 != 2) {
                C();
            }
            f(i2);
        }
    }

    public void a(g gVar, int i2) {
        if (this.m != null) {
            this.m.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.o.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.o.add(gVar);
        } else {
            this.o.add(i2, gVar);
        }
        r();
        requestLayout();
    }

    public void a(g gVar) {
        a(gVar, -1);
    }

    public void b(g gVar) {
        if (this.m != null) {
            this.m.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.o.remove(gVar);
        if (this.o.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        r();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(d dVar) {
        if (dVar != this.ay) {
            this.ay = dVar;
            setChildrenDrawingOrderEnabled(this.ay != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(m mVar) {
        this.av = mVar;
    }

    public void a(m mVar) {
        if (this.aw == null) {
            this.aw = new ArrayList();
        }
        this.aw.add(mVar);
    }

    public void b(m mVar) {
        if (this.aw != null) {
            this.aw.remove(mVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (this.m != null) {
            this.m.d(i2);
            awakenScrollBars();
        }
    }

    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollBy(int i2, int i3) {
        if (this.m == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.u) {
            boolean d2 = this.m.d();
            boolean e2 = this.m.e();
            if (d2 || e2) {
                if (!d2) {
                    i2 = 0;
                }
                if (!e2) {
                    i3 = 0;
                }
                a(i2, i3, (MotionEvent) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (!this.s || this.w) {
            android.support.v4.c.c.a("RV FullInvalidate");
            q();
            android.support.v4.c.c.a();
        } else if (this.e.d()) {
            if (this.e.a(4) && !this.e.a(11)) {
                android.support.v4.c.c.a("RV PartialInvalidate");
                e();
                l();
                this.e.b();
                if (!this.t) {
                    if (B()) {
                        q();
                    } else {
                        this.e.c();
                    }
                }
                a(true);
                m();
                android.support.v4.c.c.a();
            } else if (this.e.d()) {
                android.support.v4.c.c.a("RV FullInvalidate");
                q();
                android.support.v4.c.c.a();
            }
        }
    }

    private boolean B() {
        int b2 = this.f.b();
        for (int i2 = 0; i2 < b2; i2++) {
            w e2 = e(this.f.b(i2));
            if (e2 != null && !e2.c() && e2.x()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        d();
        if (this.l != null) {
            e();
            l();
            android.support.v4.c.c.a("RV Scroll");
            a(this.B);
            if (i2 != 0) {
                i7 = this.m.a(i2, this.d, this.B);
                i6 = i2 - i7;
            } else {
                i7 = 0;
                i6 = 0;
            }
            if (i3 != 0) {
                i5 = this.m.b(i3, this.d, this.B);
                i4 = i3 - i5;
            } else {
                i5 = 0;
                i4 = 0;
            }
            android.support.v4.c.c.a();
            x();
            m();
            a(false);
        } else {
            i7 = 0;
            i6 = 0;
            i5 = 0;
            i4 = 0;
        }
        if (!this.o.isEmpty()) {
            invalidate();
        }
        if (a(i7, i5, i6, i4, this.aB, 0)) {
            this.am -= this.aB[0];
            this.an -= this.aB[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.aB[0], (float) this.aB[1]);
            }
            int[] iArr = this.aD;
            iArr[0] = iArr[0] + this.aB[0];
            int[] iArr2 = this.aD;
            iArr2[1] = iArr2[1] + this.aB[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !android.support.v4.view.c.a(motionEvent, 8194)) {
                a(motionEvent.getX(), (float) i6, motionEvent.getY(), (float) i4);
            }
            c(i2, i3);
        }
        if (!(i7 == 0 && i5 == 0)) {
            i(i7, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (i7 == 0 && i5 == 0) {
            return false;
        }
        return true;
    }

    public int computeHorizontalScrollOffset() {
        if (this.m != null && this.m.d()) {
            return this.m.c(this.B);
        }
        return 0;
    }

    public int computeHorizontalScrollExtent() {
        if (this.m != null && this.m.d()) {
            return this.m.e(this.B);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        if (this.m != null && this.m.d()) {
            return this.m.g(this.B);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        if (this.m != null && this.m.e()) {
            return this.m.d(this.B);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        if (this.m != null && this.m.e()) {
            return this.m.f(this.B);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        if (this.m != null && this.m.e()) {
            return this.m.h(this.B);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.T++;
        if (this.T == 1 && !this.u) {
            this.t = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        if (this.T < 1) {
            this.T = 1;
        }
        if (!z2) {
            this.t = false;
        }
        if (this.T == 1) {
            if (z2 && this.t && !this.u && this.m != null && this.l != null) {
                q();
            }
            if (!this.u) {
                this.t = false;
            }
        }
        this.T--;
    }

    public void setLayoutFrozen(boolean z2) {
        if (z2 != this.u) {
            a("Do not setLayoutFrozen in layout or scroll");
            if (!z2) {
                this.u = false;
                if (!(!this.t || this.m == null || this.l == null)) {
                    requestLayout();
                }
                this.t = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 0));
            this.u = true;
            this.U = true;
            f();
        }
    }

    public void a(int i2, int i3) {
        a(i2, i3, (Interpolator) null);
    }

    public void a(int i2, int i3, Interpolator interpolator) {
        if (this.m == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.u) {
            if (!this.m.d()) {
                i2 = 0;
            }
            if (!this.m.e()) {
                i3 = 0;
            }
            if (i2 != 0 || i3 != 0) {
                this.y.a(i2, i3, interpolator);
            }
        }
    }

    public boolean b(int i2, int i3) {
        int i4 = 0;
        if (this.m == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.u) {
            return false;
        } else {
            boolean d2 = this.m.d();
            boolean e2 = this.m.e();
            if (!d2 || Math.abs(i2) < this.aq) {
                i2 = 0;
            }
            if (!e2 || Math.abs(i3) < this.aq) {
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            float f2 = (float) i2;
            float f3 = (float) i3;
            if (!dispatchNestedPreFling(f2, f3)) {
                boolean z2 = d2 || e2;
                dispatchNestedFling(f2, f3, z2);
                if (this.ap != null && this.ap.a(i2, i3)) {
                    return true;
                }
                if (z2) {
                    if (d2) {
                        i4 = 1;
                    }
                    if (e2) {
                        i4 |= 2;
                    }
                    j(i4, 1);
                    this.y.a(Math.max(-this.ar, Math.min(i2, this.ar)), Math.max(-this.ar, Math.min(i3, this.ar)));
                    return true;
                }
            }
            return false;
        }
    }

    public void f() {
        setScrollState(0);
        C();
    }

    private void C() {
        this.y.b();
        if (this.m != null) {
            this.m.G();
        }
    }

    public int getMinFlingVelocity() {
        return this.aq;
    }

    public int getMaxFlingVelocity() {
        return this.ar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0021
            r6.g()
            android.widget.EdgeEffect r3 = r6.ad
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            android.support.v4.widget.c.a(r3, r4, r9)
        L_0x001f:
            r9 = 1
            goto L_0x003c
        L_0x0021:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x003b
            r6.h()
            android.widget.EdgeEffect r3 = r6.af
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            android.support.v4.widget.c.a(r3, r4, r9)
            goto L_0x001f
        L_0x003b:
            r9 = 0
        L_0x003c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0056
            r6.i()
            android.widget.EdgeEffect r9 = r6.ae
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            android.support.v4.widget.c.a(r9, r0, r7)
            goto L_0x0072
        L_0x0056:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0071
            r6.j()
            android.widget.EdgeEffect r9 = r6.ag
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            android.support.v4.widget.c.a(r9, r3, r0)
            goto L_0x0072
        L_0x0071:
            r1 = r9
        L_0x0072:
            if (r1 != 0) goto L_0x007c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x007c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x007f
        L_0x007c:
            android.support.v4.view.l.c(r6)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.a(float, float, float, float):void");
    }

    private void D() {
        boolean z2;
        if (this.ad != null) {
            this.ad.onRelease();
            z2 = this.ad.isFinished();
        } else {
            z2 = false;
        }
        if (this.ae != null) {
            this.ae.onRelease();
            z2 |= this.ae.isFinished();
        }
        if (this.af != null) {
            this.af.onRelease();
            z2 |= this.af.isFinished();
        }
        if (this.ag != null) {
            this.ag.onRelease();
            z2 |= this.ag.isFinished();
        }
        if (z2) {
            android.support.v4.view.l.c(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i2, int i3) {
        boolean z2;
        if (this.ad == null || this.ad.isFinished() || i2 <= 0) {
            z2 = false;
        } else {
            this.ad.onRelease();
            z2 = this.ad.isFinished();
        }
        if (this.af != null && !this.af.isFinished() && i2 < 0) {
            this.af.onRelease();
            z2 |= this.af.isFinished();
        }
        if (this.ae != null && !this.ae.isFinished() && i3 > 0) {
            this.ae.onRelease();
            z2 |= this.ae.isFinished();
        }
        if (this.ag != null && !this.ag.isFinished() && i3 < 0) {
            this.ag.onRelease();
            z2 |= this.ag.isFinished();
        }
        if (z2) {
            android.support.v4.view.l.c(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(int i2, int i3) {
        if (i2 < 0) {
            g();
            this.ad.onAbsorb(-i2);
        } else if (i2 > 0) {
            h();
            this.af.onAbsorb(i2);
        }
        if (i3 < 0) {
            i();
            this.ae.onAbsorb(-i3);
        } else if (i3 > 0) {
            j();
            this.ag.onAbsorb(i3);
        }
        if (i2 != 0 || i3 != 0) {
            android.support.v4.view.l.c(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.ad == null) {
            this.ad = new EdgeEffect(getContext());
            if (this.h) {
                this.ad.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.ad.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (this.af == null) {
            this.af = new EdgeEffect(getContext());
            if (this.h) {
                this.af.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.af.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        if (this.ae == null) {
            this.ae = new EdgeEffect(getContext());
            if (this.h) {
                this.ae.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.ae.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        if (this.ag == null) {
            this.ag = new EdgeEffect(getContext());
            if (this.h) {
                this.ag.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.ag.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        this.ag = null;
        this.ae = null;
        this.af = null;
        this.ad = null;
    }

    public View focusSearch(View view, int i2) {
        View view2;
        boolean z2;
        View d2 = this.m.d(view, i2);
        if (d2 != null) {
            return d2;
        }
        boolean z3 = this.l != null && this.m != null && !o() && !this.u;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z3 || !(i2 == 2 || i2 == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i2);
            if (findNextFocus != null || !z3) {
                view2 = findNextFocus;
            } else {
                d();
                if (c(view) == null) {
                    return null;
                }
                e();
                view2 = this.m.a(view, i2, this.d, this.B);
                a(false);
            }
        } else {
            if (this.m.e()) {
                int i3 = i2 == 2 ? 130 : 33;
                z2 = instance.findNextFocus(this, view, i3) == null;
                if (L) {
                    i2 = i3;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.m.d()) {
                int i4 = (this.m.s() == 1) ^ (i2 == 2) ? 66 : 17;
                z2 = instance.findNextFocus(this, view, i4) == null;
                if (L) {
                    i2 = i4;
                }
            }
            if (z2) {
                d();
                if (c(view) == null) {
                    return null;
                }
                e();
                this.m.a(view, i2, this.d, this.B);
                a(false);
            }
            view2 = instance.findNextFocus(this, view, i2);
        }
        if (view2 == null || view2.hasFocusable()) {
            return a(view, view2, i2) ? view2 : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        a(view2, (View) null);
        return view;
    }

    private boolean a(View view, View view2, int i2) {
        boolean z2 = false;
        if (view2 == null || view2 == this) {
            return false;
        }
        if (view == null) {
            return true;
        }
        if (i2 != 2 && i2 != 1) {
            return b(view, view2, i2);
        }
        boolean z3 = this.m.s() == 1;
        if (i2 == 2) {
            z2 = true;
        }
        if (b(view, view2, z2 ^ z3 ? 66 : 17)) {
            return true;
        }
        if (i2 == 2) {
            return b(view, view2, 130);
        }
        return b(view, view2, 33);
    }

    private boolean b(View view, View view2, int i2) {
        this.j.set(0, 0, view.getWidth(), view.getHeight());
        this.Q.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.j);
        offsetDescendantRectToMyCoords(view2, this.Q);
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 == 130) {
                        return (this.j.top < this.Q.top || this.j.bottom <= this.Q.top) && this.j.bottom < this.Q.bottom;
                    }
                    throw new IllegalArgumentException("direction must be absolute. received:" + i2 + a());
                } else if ((this.j.left < this.Q.left || this.j.right <= this.Q.left) && this.j.right < this.Q.right) {
                    return true;
                } else {
                    return false;
                }
            } else if ((this.j.bottom > this.Q.bottom || this.j.top >= this.Q.bottom) && this.j.top > this.Q.top) {
                return true;
            } else {
                return false;
            }
        } else if ((this.j.right > this.Q.right || this.j.left >= this.Q.right) && this.j.left > this.Q.left) {
            return true;
        } else {
            return false;
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.m.a(this, this.B, view, view2) && view2 != null) {
            a(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void a(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.j.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof i) {
            i iVar = (i) layoutParams;
            if (!iVar.e) {
                Rect rect = iVar.d;
                this.j.left -= rect.left;
                this.j.right += rect.right;
                this.j.top -= rect.top;
                this.j.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.j);
            offsetRectIntoDescendantCoords(view, this.j);
        }
        this.m.a(this, view, this.j, !this.s, view2 == null);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.m.a(this, view, rect, z2);
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        if (this.m == null || !this.m.a(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (o()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        if (r0 >= 30.0f) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.ab = r0
            r1 = 1
            r4.p = r1
            boolean r2 = r4.s
            if (r2 == 0) goto L_0x0014
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            r4.s = r1
            android.support.v7.widget.RecyclerView$h r1 = r4.m
            if (r1 == 0) goto L_0x0020
            android.support.v7.widget.RecyclerView$h r1 = r4.m
            r1.c((android.support.v7.widget.RecyclerView) r4)
        L_0x0020:
            r4.E = r0
            boolean r0 = K
            if (r0 == 0) goto L_0x006b
            java.lang.ThreadLocal<android.support.v7.widget.e> r0 = android.support.v7.widget.e.f467a
            java.lang.Object r0 = r0.get()
            android.support.v7.widget.e r0 = (android.support.v7.widget.e) r0
            r4.z = r0
            android.support.v7.widget.e r0 = r4.z
            if (r0 != 0) goto L_0x0066
            android.support.v7.widget.e r0 = new android.support.v7.widget.e
            r0.<init>()
            r4.z = r0
            android.view.Display r0 = android.support.v4.view.l.j(r4)
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L_0x0054
            if (r0 == 0) goto L_0x0054
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0054
            goto L_0x0056
        L_0x0054:
            r0 = 1114636288(0x42700000, float:60.0)
        L_0x0056:
            android.support.v7.widget.e r1 = r4.z
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.d = r2
            java.lang.ThreadLocal<android.support.v7.widget.e> r0 = android.support.v7.widget.e.f467a
            android.support.v7.widget.e r1 = r4.z
            r0.set(r1)
        L_0x0066:
            android.support.v7.widget.e r0 = r4.z
            r0.a((android.support.v7.widget.RecyclerView) r4)
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.onAttachedToWindow():void");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.x != null) {
            this.x.d();
        }
        f();
        this.p = false;
        if (this.m != null) {
            this.m.b(this, this.d);
        }
        this.G.clear();
        removeCallbacks(this.aE);
        this.g.b();
        if (K) {
            this.z.b(this);
            this.z = null;
        }
    }

    public boolean isAttachedToWindow() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        if (o()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + a());
            }
            throw new IllegalStateException(str);
        } else if (this.ac > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + a()));
        }
    }

    public void a(l lVar) {
        this.R.add(lVar);
    }

    public void b(l lVar) {
        this.R.remove(lVar);
        if (this.S == lVar) {
            this.S = null;
        }
    }

    private boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.S = null;
        }
        int size = this.R.size();
        int i2 = 0;
        while (i2 < size) {
            l lVar = this.R.get(i2);
            if (!lVar.a(this, motionEvent) || action == 3) {
                i2++;
            } else {
                this.S = lVar;
                return true;
            }
        }
        return false;
    }

    private boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.S != null) {
            if (action == 0) {
                this.S = null;
            } else {
                this.S.b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.S = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.R.size();
            for (int i2 = 0; i2 < size; i2++) {
                l lVar = this.R.get(i2);
                if (lVar.a(this, motionEvent)) {
                    this.S = lVar;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.u) {
            return false;
        }
        if (a(motionEvent)) {
            F();
            return true;
        } else if (this.m == null) {
            return false;
        } else {
            boolean d2 = this.m.d();
            boolean e2 = this.m.e();
            if (this.aj == null) {
                this.aj = VelocityTracker.obtain();
            }
            this.aj.addMovement(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            switch (actionMasked) {
                case 0:
                    if (this.U) {
                        this.U = false;
                    }
                    this.ai = motionEvent.getPointerId(0);
                    int x2 = (int) (motionEvent.getX() + 0.5f);
                    this.am = x2;
                    this.ak = x2;
                    int y2 = (int) (motionEvent.getY() + 0.5f);
                    this.an = y2;
                    this.al = y2;
                    if (this.ah == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.aD;
                    this.aD[1] = 0;
                    iArr[0] = 0;
                    int i2 = d2 ? 1 : 0;
                    if (e2) {
                        i2 |= 2;
                    }
                    j(i2, 0);
                    break;
                case 1:
                    this.aj.clear();
                    g(0);
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.ai);
                    if (findPointerIndex >= 0) {
                        int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                        int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                        if (this.ah != 1) {
                            int i3 = x3 - this.ak;
                            int i4 = y3 - this.al;
                            if (!d2 || Math.abs(i3) <= this.ao) {
                                z2 = false;
                            } else {
                                this.am = x3;
                                z2 = true;
                            }
                            if (e2 && Math.abs(i4) > this.ao) {
                                this.an = y3;
                                z2 = true;
                            }
                            if (z2) {
                                setScrollState(1);
                                break;
                            }
                        }
                    } else {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.ai + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    break;
                case 3:
                    F();
                    break;
                case 5:
                    this.ai = motionEvent.getPointerId(actionIndex);
                    int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.am = x4;
                    this.ak = x4;
                    int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.an = y4;
                    this.al = y4;
                    break;
                case 6:
                    c(motionEvent);
                    break;
            }
            if (this.ah == 1) {
                return true;
            }
            return false;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.R.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.R.get(i2).a(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        int i3;
        boolean z2;
        boolean z3 = false;
        if (this.u || this.U) {
            return false;
        }
        if (b(motionEvent)) {
            F();
            return true;
        } else if (this.m == null) {
            return false;
        } else {
            boolean d2 = this.m.d();
            boolean e2 = this.m.e();
            if (this.aj == null) {
                this.aj = VelocityTracker.obtain();
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            if (actionMasked == 0) {
                int[] iArr = this.aD;
                this.aD[1] = 0;
                iArr[0] = 0;
            }
            obtain.offsetLocation((float) this.aD[0], (float) this.aD[1]);
            switch (actionMasked) {
                case 0:
                    this.ai = motionEvent.getPointerId(0);
                    int x2 = (int) (motionEvent.getX() + 0.5f);
                    this.am = x2;
                    this.ak = x2;
                    int y2 = (int) (motionEvent.getY() + 0.5f);
                    this.an = y2;
                    this.al = y2;
                    int i4 = d2 ? 1 : 0;
                    if (e2) {
                        i4 |= 2;
                    }
                    j(i4, 0);
                    break;
                case 1:
                    this.aj.addMovement(obtain);
                    this.aj.computeCurrentVelocity(1000, (float) this.ar);
                    float f2 = d2 ? -this.aj.getXVelocity(this.ai) : GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                    float f3 = e2 ? -this.aj.getYVelocity(this.ai) : GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                    if ((f2 == GlobalDefine.DEFAULT_AUTO_FILTER_VALUE && f3 == GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) || !b((int) f2, (int) f3)) {
                        setScrollState(0);
                    }
                    E();
                    z3 = true;
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.ai);
                    if (findPointerIndex >= 0) {
                        int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                        int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                        int i5 = this.am - x3;
                        int i6 = this.an - y3;
                        if (a(i5, i6, this.aC, this.aB, 0)) {
                            i5 -= this.aC[0];
                            i6 -= this.aC[1];
                            obtain.offsetLocation((float) this.aB[0], (float) this.aB[1]);
                            int[] iArr2 = this.aD;
                            iArr2[0] = iArr2[0] + this.aB[0];
                            int[] iArr3 = this.aD;
                            iArr3[1] = iArr3[1] + this.aB[1];
                        }
                        if (this.ah != 1) {
                            if (!d2 || Math.abs(i3) <= this.ao) {
                                z2 = false;
                            } else {
                                if (i3 > 0) {
                                    i3 -= this.ao;
                                } else {
                                    i3 += this.ao;
                                }
                                z2 = true;
                            }
                            if (e2 && Math.abs(i2) > this.ao) {
                                if (i2 > 0) {
                                    i2 -= this.ao;
                                } else {
                                    i2 += this.ao;
                                }
                                z2 = true;
                            }
                            if (z2) {
                                setScrollState(1);
                            }
                        }
                        if (this.ah == 1) {
                            this.am = x3 - this.aB[0];
                            this.an = y3 - this.aB[1];
                            if (a(d2 ? i3 : 0, e2 ? i2 : 0, obtain)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            if (!(this.z == null || (i3 == 0 && i2 == 0))) {
                                this.z.a(this, i3, i2);
                                break;
                            }
                        }
                    } else {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.ai + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    break;
                case 3:
                    F();
                    break;
                case 5:
                    this.ai = motionEvent.getPointerId(actionIndex);
                    int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.am = x4;
                    this.ak = x4;
                    int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.an = y4;
                    this.al = y4;
                    break;
                case 6:
                    c(motionEvent);
                    break;
            }
            if (!z3) {
                this.aj.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        }
    }

    private void E() {
        if (this.aj != null) {
            this.aj.clear();
        }
        g(0);
        D();
    }

    private void F() {
        E();
        setScrollState(0);
    }

    private void c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.ai) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.ai = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.am = x2;
            this.ak = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.an = y2;
            this.al = y2;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        float f3;
        if (this.m != null && !this.u && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f3 = this.m.e() ? -motionEvent.getAxisValue(9) : GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                if (this.m.d()) {
                    f2 = motionEvent.getAxisValue(10);
                    if (!(f3 == GlobalDefine.DEFAULT_AUTO_FILTER_VALUE && f2 == GlobalDefine.DEFAULT_AUTO_FILTER_VALUE)) {
                        a((int) (f2 * this.as), (int) (f3 * this.at), motionEvent);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.m.e()) {
                        f3 = -axisValue;
                    } else if (this.m.d()) {
                        f2 = axisValue;
                        f3 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                        a((int) (f2 * this.as), (int) (f3 * this.at), motionEvent);
                    }
                }
                f3 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            }
            f2 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            a((int) (f2 * this.as), (int) (f3 * this.at), motionEvent);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.m == null) {
            e(i2, i3);
            return;
        }
        boolean z2 = false;
        if (this.m.w) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            this.m.a(this.d, this.B, i2, i3);
            if (!z2 && this.l != null) {
                if (this.B.c == 1) {
                    N();
                }
                this.m.d(i2, i3);
                this.B.h = true;
                O();
                this.m.e(i2, i3);
                if (this.m.k()) {
                    this.m.d(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.B.h = true;
                    O();
                    this.m.e(i2, i3);
                }
            }
        } else if (this.q) {
            this.m.a(this.d, this.B, i2, i3);
        } else {
            if (this.v) {
                e();
                l();
                I();
                m();
                if (this.B.j) {
                    this.B.f = true;
                } else {
                    this.e.e();
                    this.B.f = false;
                }
                this.v = false;
                a(false);
            } else if (this.B.j) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            if (this.l != null) {
                this.B.d = this.l.a();
            } else {
                this.B.d = 0;
            }
            e();
            this.m.a(this.d, this.B, i2, i3);
            a(false);
            this.B.f = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void e(int i2, int i3) {
        setMeasuredDimension(h.a(i2, getPaddingLeft() + getPaddingRight(), android.support.v4.view.l.f(this)), h.a(i3, getPaddingTop() + getPaddingBottom(), android.support.v4.view.l.g(this)));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4 || i3 != i5) {
            k();
        }
    }

    public void setItemAnimator(e eVar) {
        if (this.x != null) {
            this.x.d();
            this.x.a((e.b) null);
        }
        this.x = eVar;
        if (this.x != null) {
            this.x.a(this.ax);
        }
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.ab++;
    }

    /* access modifiers changed from: package-private */
    public void m() {
        b(true);
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        this.ab--;
        if (this.ab < 1) {
            this.ab = 0;
            if (z2) {
                G();
                y();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        return this.W != null && this.W.isEnabled();
    }

    private void G() {
        int i2 = this.V;
        this.V = 0;
        if (i2 != 0 && n()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            android.support.v4.view.a.a.a(obtain, i2);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    public boolean o() {
        return this.ab > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean a(AccessibilityEvent accessibilityEvent) {
        if (!o()) {
            return false;
        }
        int a2 = accessibilityEvent != null ? android.support.v4.view.a.a.a(accessibilityEvent) : 0;
        if (a2 == 0) {
            a2 = 0;
        }
        this.V = a2 | this.V;
        return true;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!a(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public e getItemAnimator() {
        return this.x;
    }

    /* access modifiers changed from: package-private */
    public void p() {
        if (!this.E && this.p) {
            android.support.v4.view.l.a((View) this, this.aE);
            this.E = true;
        }
    }

    private boolean H() {
        return this.x != null && this.m.b();
    }

    private void I() {
        if (this.w) {
            this.e.a();
            this.m.a(this);
        }
        if (H()) {
            this.e.b();
        } else {
            this.e.e();
        }
        boolean z2 = false;
        boolean z3 = this.C || this.D;
        this.B.i = this.s && this.x != null && (this.w || z3 || this.m.u) && (!this.w || this.l.b());
        t tVar = this.B;
        if (this.B.i && z3 && !this.w && H()) {
            z2 = true;
        }
        tVar.j = z2;
    }

    /* access modifiers changed from: package-private */
    public void q() {
        if (this.l == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.m == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            this.B.h = false;
            if (this.B.c == 1) {
                N();
                this.m.f(this);
                O();
            } else if (!this.e.f() && this.m.x() == getWidth() && this.m.y() == getHeight()) {
                this.m.f(this);
            } else {
                this.m.f(this);
                O();
            }
            P();
        }
    }

    private void J() {
        int i2;
        w wVar = null;
        View focusedChild = (!this.au || !hasFocus() || this.l == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            wVar = d(focusedChild);
        }
        if (wVar == null) {
            K();
            return;
        }
        this.B.l = this.l.b() ? wVar.g() : -1;
        t tVar = this.B;
        if (this.w) {
            i2 = -1;
        } else if (wVar.q()) {
            i2 = wVar.d;
        } else {
            i2 = wVar.e();
        }
        tVar.k = i2;
        this.B.m = n(wVar.f413a);
    }

    private void K() {
        this.B.l = -1;
        this.B.k = -1;
        this.B.m = -1;
    }

    private View L() {
        w b2;
        int i2 = this.B.k != -1 ? this.B.k : 0;
        int e2 = this.B.e();
        int i3 = i2;
        while (i3 < e2) {
            w b3 = b(i3);
            if (b3 == null) {
                break;
            } else if (b3.f413a.hasFocusable()) {
                return b3.f413a;
            } else {
                i3++;
            }
        }
        int min = Math.min(e2, i2);
        while (true) {
            min--;
            if (min < 0 || (b2 = b(min)) == null) {
                return null;
            }
            if (b2.f413a.hasFocusable()) {
                return b2.f413a;
            }
        }
    }

    private void M() {
        View view;
        if (this.au && this.l != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!M || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.f.c(focusedChild)) {
                            return;
                        }
                    } else if (this.f.b() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view2 = null;
                w a2 = (this.B.l == -1 || !this.l.b()) ? null : a(this.B.l);
                if (a2 != null && !this.f.c(a2.f413a) && a2.f413a.hasFocusable()) {
                    view2 = a2.f413a;
                } else if (this.f.b() > 0) {
                    view2 = L();
                }
                if (view2 != null) {
                    if (((long) this.B.m) == -1 || (view = view2.findViewById(this.B.m)) == null || !view.isFocusable()) {
                        view = view2;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private int n(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) {
        if (getScrollState() == 2) {
            OverScroller a2 = this.y.e;
            tVar.n = a2.getFinalX() - a2.getCurrX();
            tVar.o = a2.getFinalY() - a2.getCurrY();
            return;
        }
        tVar.n = 0;
        tVar.o = 0;
    }

    private void N() {
        boolean z2 = true;
        this.B.a(1);
        a(this.B);
        this.B.h = false;
        e();
        this.g.a();
        l();
        I();
        J();
        t tVar = this.B;
        if (!this.B.i || !this.D) {
            z2 = false;
        }
        tVar.g = z2;
        this.D = false;
        this.C = false;
        this.B.f = this.B.j;
        this.B.d = this.l.a();
        a(this.az);
        if (this.B.i) {
            int b2 = this.f.b();
            for (int i2 = 0; i2 < b2; i2++) {
                w e2 = e(this.f.b(i2));
                if (!e2.c() && (!e2.n() || this.l.b())) {
                    this.g.a(e2, this.x.a(this.B, e2, e.e(e2), e2.u()));
                    if (this.B.g && e2.x() && !e2.q() && !e2.c() && !e2.n()) {
                        this.g.a(a(e2), e2);
                    }
                }
            }
        }
        if (this.B.j) {
            s();
            boolean z3 = this.B.e;
            this.B.e = false;
            this.m.c(this.d, this.B);
            this.B.e = z3;
            for (int i3 = 0; i3 < this.f.b(); i3++) {
                w e3 = e(this.f.b(i3));
                if (!e3.c() && !this.g.d(e3)) {
                    int e4 = e.e(e3);
                    boolean a2 = e3.a(8192);
                    if (!a2) {
                        e4 |= 4096;
                    }
                    e.c a3 = this.x.a(this.B, e3, e4, e3.u());
                    if (a2) {
                        a(e3, a3);
                    } else {
                        this.g.b(e3, a3);
                    }
                }
            }
            t();
        } else {
            t();
        }
        m();
        a(false);
        this.B.c = 2;
    }

    private void O() {
        e();
        l();
        this.B.a(6);
        this.e.e();
        this.B.d = this.l.a();
        this.B.f410b = 0;
        this.B.f = false;
        this.m.c(this.d, this.B);
        this.B.e = false;
        this.P = null;
        this.B.i = this.B.i && this.x != null;
        this.B.c = 4;
        m();
        a(false);
    }

    private void P() {
        this.B.a(4);
        e();
        l();
        this.B.c = 1;
        if (this.B.i) {
            for (int b2 = this.f.b() - 1; b2 >= 0; b2--) {
                w e2 = e(this.f.b(b2));
                if (!e2.c()) {
                    long a2 = a(e2);
                    e.c a3 = this.x.a(this.B, e2);
                    w a4 = this.g.a(a2);
                    if (a4 == null || a4.c()) {
                        this.g.c(e2, a3);
                    } else {
                        boolean a5 = this.g.a(a4);
                        boolean a6 = this.g.a(e2);
                        if (!a5 || a4 != e2) {
                            e.c b3 = this.g.b(a4);
                            this.g.c(e2, a3);
                            e.c c2 = this.g.c(e2);
                            if (b3 == null) {
                                a(a2, e2, a4);
                            } else {
                                a(a4, e2, b3, c2, a5, a6);
                            }
                        } else {
                            this.g.c(e2, a3);
                        }
                    }
                }
            }
            this.g.a(this.aF);
        }
        this.m.b(this.d);
        this.B.f409a = this.B.d;
        this.w = false;
        this.B.i = false;
        this.B.j = false;
        this.m.u = false;
        if (this.d.f402b != null) {
            this.d.f402b.clear();
        }
        if (this.m.y) {
            this.m.x = 0;
            this.m.y = false;
            this.d.b();
        }
        this.m.a(this.B);
        m();
        a(false);
        this.g.a();
        if (k(this.az[0], this.az[1])) {
            i(0, 0);
        }
        M();
        K();
    }

    private void a(long j2, w wVar, w wVar2) {
        int b2 = this.f.b();
        int i2 = 0;
        while (i2 < b2) {
            w e2 = e(this.f.b(i2));
            if (e2 == wVar || a(e2) != j2) {
                i2++;
            } else if (this.l == null || !this.l.b()) {
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + e2 + " \n View Holder 2:" + wVar + a());
            } else {
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + e2 + " \n View Holder 2:" + wVar + a());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + wVar2 + " cannot be found but it is necessary for " + wVar + a());
    }

    /* access modifiers changed from: package-private */
    public void a(w wVar, e.c cVar) {
        wVar.a(0, 8192);
        if (this.B.g && wVar.x() && !wVar.q() && !wVar.c()) {
            this.g.a(a(wVar), wVar);
        }
        this.g.a(wVar, cVar);
    }

    private void a(int[] iArr) {
        int b2 = this.f.b();
        if (b2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < b2; i4++) {
            w e2 = e(this.f.b(i4));
            if (!e2.c()) {
                int d2 = e2.d();
                if (d2 < i2) {
                    i2 = d2;
                }
                if (d2 > i3) {
                    i3 = d2;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    private boolean k(int i2, int i3) {
        a(this.az);
        return (this.az[0] == i2 && this.az[1] == i3) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z2) {
        w e2 = e(view);
        if (e2 != null) {
            if (e2.r()) {
                e2.m();
            } else if (!e2.c()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + e2 + a());
            }
        }
        view.clearAnimation();
        l(view);
        super.removeDetachedView(view, z2);
    }

    /* access modifiers changed from: package-private */
    public long a(w wVar) {
        return this.l.b() ? wVar.g() : (long) wVar.c;
    }

    /* access modifiers changed from: package-private */
    public void a(w wVar, e.c cVar, e.c cVar2) {
        wVar.a(false);
        if (this.x.b(wVar, cVar, cVar2)) {
            p();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(w wVar, e.c cVar, e.c cVar2) {
        e(wVar);
        wVar.a(false);
        if (this.x.a(wVar, cVar, cVar2)) {
            p();
        }
    }

    private void a(w wVar, w wVar2, e.c cVar, e.c cVar2, boolean z2, boolean z3) {
        wVar.a(false);
        if (z2) {
            e(wVar);
        }
        if (wVar != wVar2) {
            if (z3) {
                e(wVar2);
            }
            wVar.h = wVar2;
            e(wVar);
            this.d.c(wVar);
            wVar2.a(false);
            wVar2.i = wVar;
        }
        if (this.x.a(wVar, wVar2, cVar, cVar2)) {
            p();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        android.support.v4.c.c.a("RV OnLayout");
        q();
        android.support.v4.c.c.a();
        this.s = true;
    }

    public void requestLayout() {
        if (this.T != 0 || this.u) {
            this.t = true;
        } else {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void r() {
        int c2 = this.f.c();
        for (int i2 = 0; i2 < c2; i2++) {
            ((i) this.f.d(i2).getLayoutParams()).e = true;
        }
        this.d.j();
    }

    public void draw(Canvas canvas) {
        boolean z2;
        boolean z3;
        super.draw(canvas);
        int size = this.o.size();
        boolean z4 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.o.get(i2).a(canvas, this, this.B);
        }
        if (this.ad == null || this.ad.isFinished()) {
            z2 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.h ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
            z2 = this.ad != null && this.ad.draw(canvas);
            canvas.restoreToCount(save);
        }
        if (this.ae != null && !this.ae.isFinished()) {
            int save2 = canvas.save();
            if (this.h) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            z2 |= this.ae != null && this.ae.draw(canvas);
            canvas.restoreToCount(save2);
        }
        if (this.af != null && !this.af.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.h ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-width));
            z2 |= this.af != null && this.af.draw(canvas);
            canvas.restoreToCount(save3);
        }
        if (this.ag == null || this.ag.isFinished()) {
            z3 = z2;
        } else {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.h) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.ag != null && this.ag.draw(canvas)) {
                z4 = true;
            }
            z3 = z4 | z2;
            canvas.restoreToCount(save4);
        }
        if (!z3 && this.x != null && this.o.size() > 0 && this.x.b()) {
            z3 = true;
        }
        if (z3) {
            android.support.v4.view.l.c(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.o.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.o.get(i2).b(canvas, this, this.B);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof i) && this.m.a((i) layoutParams);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.m != null) {
            return this.m.a();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + a());
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.m != null) {
            return this.m.a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + a());
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (this.m != null) {
            return this.m.a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + a());
    }

    /* access modifiers changed from: package-private */
    public void s() {
        int c2 = this.f.c();
        for (int i2 = 0; i2 < c2; i2++) {
            w e2 = e(this.f.d(i2));
            if (!e2.c()) {
                e2.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void t() {
        int c2 = this.f.c();
        for (int i2 = 0; i2 < c2; i2++) {
            w e2 = e(this.f.d(i2));
            if (!e2.c()) {
                e2.a();
            }
        }
        this.d.i();
    }

    /* access modifiers changed from: package-private */
    public void f(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int c2 = this.f.c();
        if (i2 < i3) {
            i6 = i2;
            i5 = i3;
            i4 = -1;
        } else {
            i5 = i2;
            i6 = i3;
            i4 = 1;
        }
        for (int i7 = 0; i7 < c2; i7++) {
            w e2 = e(this.f.d(i7));
            if (e2 != null && e2.c >= i6 && e2.c <= i5) {
                if (e2.c == i2) {
                    e2.a(i3 - i2, false);
                } else {
                    e2.a(i4, false);
                }
                this.B.e = true;
            }
        }
        this.d.a(i2, i3);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void g(int i2, int i3) {
        int c2 = this.f.c();
        for (int i4 = 0; i4 < c2; i4++) {
            w e2 = e(this.f.d(i4));
            if (e2 != null && !e2.c() && e2.c >= i2) {
                e2.a(i3, false);
                this.B.e = true;
            }
        }
        this.d.b(i2, i3);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int c2 = this.f.c();
        for (int i5 = 0; i5 < c2; i5++) {
            w e2 = e(this.f.d(i5));
            if (e2 != null && !e2.c()) {
                if (e2.c >= i4) {
                    e2.a(-i3, z2);
                    this.B.e = true;
                } else if (e2.c >= i2) {
                    e2.a(i2 - 1, -i3, z2);
                    this.B.e = true;
                }
            }
        }
        this.d.a(i2, i3, z2);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, Object obj) {
        int c2 = this.f.c();
        int i4 = i2 + i3;
        for (int i5 = 0; i5 < c2; i5++) {
            View d2 = this.f.d(i5);
            w e2 = e(d2);
            if (e2 != null && !e2.c() && e2.c >= i2 && e2.c < i4) {
                e2.b(2);
                e2.a(obj);
                ((i) d2.getLayoutParams()).e = true;
            }
        }
        this.d.c(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public boolean b(w wVar) {
        return this.x == null || this.x.a(wVar, wVar.u());
    }

    /* access modifiers changed from: package-private */
    public void u() {
        this.w = true;
        v();
    }

    /* access modifiers changed from: package-private */
    public void v() {
        int c2 = this.f.c();
        for (int i2 = 0; i2 < c2; i2++) {
            w e2 = e(this.f.d(i2));
            if (e2 != null && !e2.c()) {
                e2.b(6);
            }
        }
        r();
        this.d.h();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.au;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.au = z2;
    }

    public w b(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return e(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public View c(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public w d(View view) {
        View c2 = c(view);
        if (c2 == null) {
            return null;
        }
        return b(c2);
    }

    static w e(View view) {
        if (view == null) {
            return null;
        }
        return ((i) view.getLayoutParams()).c;
    }

    public int f(View view) {
        w e2 = e(view);
        if (e2 != null) {
            return e2.e();
        }
        return -1;
    }

    public int g(View view) {
        w e2 = e(view);
        if (e2 != null) {
            return e2.d();
        }
        return -1;
    }

    public w b(int i2) {
        w wVar = null;
        if (this.w) {
            return null;
        }
        int c2 = this.f.c();
        for (int i3 = 0; i3 < c2; i3++) {
            w e2 = e(this.f.d(i3));
            if (e2 != null && !e2.q() && d(e2) == i2) {
                if (!this.f.c(e2.f413a)) {
                    return e2;
                }
                wVar = e2;
            }
        }
        return wVar;
    }

    /* access modifiers changed from: package-private */
    public w a(int i2, boolean z2) {
        int c2 = this.f.c();
        w wVar = null;
        for (int i3 = 0; i3 < c2; i3++) {
            w e2 = e(this.f.d(i3));
            if (e2 != null && !e2.q()) {
                if (z2) {
                    if (e2.c != i2) {
                        continue;
                    }
                } else if (e2.d() != i2) {
                    continue;
                }
                if (!this.f.c(e2.f413a)) {
                    return e2;
                }
                wVar = e2;
            }
        }
        return wVar;
    }

    public w a(long j2) {
        w wVar = null;
        if (this.l == null || !this.l.b()) {
            return null;
        }
        int c2 = this.f.c();
        for (int i2 = 0; i2 < c2; i2++) {
            w e2 = e(this.f.d(i2));
            if (e2 != null && !e2.q() && e2.g() == j2) {
                if (!this.f.c(e2.f413a)) {
                    return e2;
                }
                wVar = e2;
            }
        }
        return wVar;
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public void c(int i2) {
        int b2 = this.f.b();
        for (int i3 = 0; i3 < b2; i3++) {
            this.f.b(i3).offsetTopAndBottom(i2);
        }
    }

    public void d(int i2) {
        int b2 = this.f.b();
        for (int i3 = 0; i3 < b2; i3++) {
            this.f.b(i3).offsetLeftAndRight(i2);
        }
    }

    static void a(View view, Rect rect) {
        i iVar = (i) view.getLayoutParams();
        Rect rect2 = iVar.d;
        rect.set((view.getLeft() - rect2.left) - iVar.leftMargin, (view.getTop() - rect2.top) - iVar.topMargin, view.getRight() + rect2.right + iVar.rightMargin, view.getBottom() + rect2.bottom + iVar.bottomMargin);
    }

    /* access modifiers changed from: package-private */
    public Rect j(View view) {
        i iVar = (i) view.getLayoutParams();
        if (!iVar.e) {
            return iVar.d;
        }
        if (this.B.a() && (iVar.e() || iVar.c())) {
            return iVar.d;
        }
        Rect rect = iVar.d;
        rect.set(0, 0, 0, 0);
        int size = this.o.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.j.set(0, 0, 0, 0);
            this.o.get(i2).a(this.j, view, this, this.B);
            rect.left += this.j.left;
            rect.top += this.j.top;
            rect.right += this.j.right;
            rect.bottom += this.j.bottom;
        }
        iVar.e = false;
        return rect;
    }

    /* access modifiers changed from: package-private */
    public void i(int i2, int i3) {
        this.ac++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        h(i2, i3);
        if (this.av != null) {
            this.av.a(this, i2, i3);
        }
        if (this.aw != null) {
            for (int size = this.aw.size() - 1; size >= 0; size--) {
                this.aw.get(size).a(this, i2, i3);
            }
        }
        this.ac--;
    }

    /* access modifiers changed from: package-private */
    public void f(int i2) {
        if (this.m != null) {
            this.m.k(i2);
        }
        e(i2);
        if (this.av != null) {
            this.av.a(this, i2);
        }
        if (this.aw != null) {
            for (int size = this.aw.size() - 1; size >= 0; size--) {
                this.aw.get(size).a(this, i2);
            }
        }
    }

    public boolean w() {
        return !this.s || this.w || this.e.d();
    }

    class v implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        Interpolator f411a = RecyclerView.H;
        private int c;
        private int d;
        /* access modifiers changed from: private */
        public OverScroller e;
        private boolean f = false;
        private boolean g = false;

        v() {
            this.e = new OverScroller(RecyclerView.this.getContext(), RecyclerView.H);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0134, code lost:
            if (r8 > 0) goto L_0x0138;
         */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x0130  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0140  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r22 = this;
                r0 = r22
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$h r1 = r1.m
                if (r1 != 0) goto L_0x000c
                r22.b()
                return
            L_0x000c:
                r22.c()
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                r1.d()
                android.widget.OverScroller r1 = r0.e
                android.support.v7.widget.RecyclerView r2 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$h r2 = r2.m
                android.support.v7.widget.RecyclerView$s r2 = r2.t
                boolean r3 = r1.computeScrollOffset()
                r4 = 0
                if (r3 == 0) goto L_0x01dc
                android.support.v7.widget.RecyclerView r3 = android.support.v7.widget.RecyclerView.this
                int[] r3 = r3.aC
                int r11 = r1.getCurrX()
                int r12 = r1.getCurrY()
                int r5 = r0.c
                int r13 = r11 - r5
                int r5 = r0.d
                int r14 = r12 - r5
                r0.c = r11
                r0.d = r12
                android.support.v7.widget.RecyclerView r5 = android.support.v7.widget.RecyclerView.this
                r9 = 0
                r10 = 1
                r6 = r13
                r7 = r14
                r8 = r3
                boolean r5 = r5.a((int) r6, (int) r7, (int[]) r8, (int[]) r9, (int) r10)
                r6 = 1
                if (r5 == 0) goto L_0x0051
                r5 = r3[r4]
                int r13 = r13 - r5
                r3 = r3[r6]
                int r14 = r14 - r3
            L_0x0051:
                android.support.v7.widget.RecyclerView r3 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$a r3 = r3.l
                if (r3 == 0) goto L_0x00e5
                android.support.v7.widget.RecyclerView r3 = android.support.v7.widget.RecyclerView.this
                r3.e()
                android.support.v7.widget.RecyclerView r3 = android.support.v7.widget.RecyclerView.this
                r3.l()
                java.lang.String r3 = "RV Scroll"
                android.support.v4.c.c.a(r3)
                android.support.v7.widget.RecyclerView r3 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView r5 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$t r5 = r5.B
                r3.a((android.support.v7.widget.RecyclerView.t) r5)
                if (r13 == 0) goto L_0x0084
                android.support.v7.widget.RecyclerView r3 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$h r3 = r3.m
                android.support.v7.widget.RecyclerView r5 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$o r5 = r5.d
                android.support.v7.widget.RecyclerView r7 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$t r7 = r7.B
                int r3 = r3.a((int) r13, (android.support.v7.widget.RecyclerView.o) r5, (android.support.v7.widget.RecyclerView.t) r7)
                int r5 = r13 - r3
                goto L_0x0086
            L_0x0084:
                r3 = 0
                r5 = 0
            L_0x0086:
                if (r14 == 0) goto L_0x009b
                android.support.v7.widget.RecyclerView r7 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$h r7 = r7.m
                android.support.v7.widget.RecyclerView r8 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$o r8 = r8.d
                android.support.v7.widget.RecyclerView r9 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$t r9 = r9.B
                int r7 = r7.b((int) r14, (android.support.v7.widget.RecyclerView.o) r8, (android.support.v7.widget.RecyclerView.t) r9)
                int r8 = r14 - r7
                goto L_0x009d
            L_0x009b:
                r7 = 0
                r8 = 0
            L_0x009d:
                android.support.v4.c.c.a()
                android.support.v7.widget.RecyclerView r9 = android.support.v7.widget.RecyclerView.this
                r9.x()
                android.support.v7.widget.RecyclerView r9 = android.support.v7.widget.RecyclerView.this
                r9.m()
                android.support.v7.widget.RecyclerView r9 = android.support.v7.widget.RecyclerView.this
                r9.a((boolean) r4)
                if (r2 == 0) goto L_0x00e9
                boolean r9 = r2.b()
                if (r9 != 0) goto L_0x00e9
                boolean r9 = r2.c()
                if (r9 == 0) goto L_0x00e9
                android.support.v7.widget.RecyclerView r9 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$t r9 = r9.B
                int r9 = r9.e()
                if (r9 != 0) goto L_0x00cb
                r2.a()
                goto L_0x00e9
            L_0x00cb:
                int r10 = r2.d()
                if (r10 < r9) goto L_0x00dd
                int r9 = r9 - r6
                r2.a((int) r9)
                int r9 = r13 - r5
                int r10 = r14 - r8
                r2.a(r9, r10)
                goto L_0x00e9
            L_0x00dd:
                int r9 = r13 - r5
                int r10 = r14 - r8
                r2.a(r9, r10)
                goto L_0x00e9
            L_0x00e5:
                r3 = 0
                r5 = 0
                r7 = 0
                r8 = 0
            L_0x00e9:
                android.support.v7.widget.RecyclerView r9 = android.support.v7.widget.RecyclerView.this
                java.util.ArrayList<android.support.v7.widget.RecyclerView$g> r9 = r9.o
                boolean r9 = r9.isEmpty()
                if (r9 != 0) goto L_0x00f8
                android.support.v7.widget.RecyclerView r9 = android.support.v7.widget.RecyclerView.this
                r9.invalidate()
            L_0x00f8:
                android.support.v7.widget.RecyclerView r9 = android.support.v7.widget.RecyclerView.this
                int r9 = r9.getOverScrollMode()
                r10 = 2
                if (r9 == r10) goto L_0x0106
                android.support.v7.widget.RecyclerView r9 = android.support.v7.widget.RecyclerView.this
                r9.c(r13, r14)
            L_0x0106:
                android.support.v7.widget.RecyclerView r15 = android.support.v7.widget.RecyclerView.this
                r20 = 0
                r21 = 1
                r16 = r3
                r17 = r7
                r18 = r5
                r19 = r8
                boolean r9 = r15.a((int) r16, (int) r17, (int) r18, (int) r19, (int[]) r20, (int) r21)
                if (r9 != 0) goto L_0x015c
                if (r5 != 0) goto L_0x011e
                if (r8 == 0) goto L_0x015c
            L_0x011e:
                float r9 = r1.getCurrVelocity()
                int r9 = (int) r9
                if (r5 == r11) goto L_0x012d
                if (r5 >= 0) goto L_0x0129
                int r15 = -r9
                goto L_0x012e
            L_0x0129:
                if (r5 <= 0) goto L_0x012d
                r15 = r9
                goto L_0x012e
            L_0x012d:
                r15 = 0
            L_0x012e:
                if (r8 == r12) goto L_0x0137
                if (r8 >= 0) goto L_0x0134
                int r9 = -r9
                goto L_0x0138
            L_0x0134:
                if (r8 <= 0) goto L_0x0137
                goto L_0x0138
            L_0x0137:
                r9 = 0
            L_0x0138:
                android.support.v7.widget.RecyclerView r4 = android.support.v7.widget.RecyclerView.this
                int r4 = r4.getOverScrollMode()
                if (r4 == r10) goto L_0x0145
                android.support.v7.widget.RecyclerView r4 = android.support.v7.widget.RecyclerView.this
                r4.d(r15, r9)
            L_0x0145:
                if (r15 != 0) goto L_0x014f
                if (r5 == r11) goto L_0x014f
                int r4 = r1.getFinalX()
                if (r4 != 0) goto L_0x015c
            L_0x014f:
                if (r9 != 0) goto L_0x0159
                if (r8 == r12) goto L_0x0159
                int r4 = r1.getFinalY()
                if (r4 != 0) goto L_0x015c
            L_0x0159:
                r1.abortAnimation()
            L_0x015c:
                if (r3 != 0) goto L_0x0160
                if (r7 == 0) goto L_0x0165
            L_0x0160:
                android.support.v7.widget.RecyclerView r4 = android.support.v7.widget.RecyclerView.this
                r4.i(r3, r7)
            L_0x0165:
                android.support.v7.widget.RecyclerView r4 = android.support.v7.widget.RecyclerView.this
                boolean r4 = r4.awakenScrollBars()
                if (r4 != 0) goto L_0x0172
                android.support.v7.widget.RecyclerView r4 = android.support.v7.widget.RecyclerView.this
                r4.invalidate()
            L_0x0172:
                if (r14 == 0) goto L_0x0182
                android.support.v7.widget.RecyclerView r4 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$h r4 = r4.m
                boolean r4 = r4.e()
                if (r4 == 0) goto L_0x0182
                if (r7 != r14) goto L_0x0182
                r4 = 1
                goto L_0x0183
            L_0x0182:
                r4 = 0
            L_0x0183:
                if (r13 == 0) goto L_0x0193
                android.support.v7.widget.RecyclerView r5 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$h r5 = r5.m
                boolean r5 = r5.d()
                if (r5 == 0) goto L_0x0193
                if (r3 != r13) goto L_0x0193
                r3 = 1
                goto L_0x0194
            L_0x0193:
                r3 = 0
            L_0x0194:
                if (r13 != 0) goto L_0x0198
                if (r14 == 0) goto L_0x019f
            L_0x0198:
                if (r3 != 0) goto L_0x019f
                if (r4 == 0) goto L_0x019d
                goto L_0x019f
            L_0x019d:
                r3 = 0
                goto L_0x01a0
            L_0x019f:
                r3 = 1
            L_0x01a0:
                boolean r1 = r1.isFinished()
                if (r1 != 0) goto L_0x01c4
                if (r3 != 0) goto L_0x01b1
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                boolean r1 = r1.h((int) r6)
                if (r1 != 0) goto L_0x01b1
                goto L_0x01c4
            L_0x01b1:
                r22.a()
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.e r1 = r1.z
                if (r1 == 0) goto L_0x01dc
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.e r1 = r1.z
                android.support.v7.widget.RecyclerView r3 = android.support.v7.widget.RecyclerView.this
                r1.a((android.support.v7.widget.RecyclerView) r3, (int) r13, (int) r14)
                goto L_0x01dc
            L_0x01c4:
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                r3 = 0
                r1.setScrollState(r3)
                boolean r1 = android.support.v7.widget.RecyclerView.K
                if (r1 == 0) goto L_0x01d7
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.e$a r1 = r1.A
                r1.a()
            L_0x01d7:
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                r1.g((int) r6)
            L_0x01dc:
                if (r2 == 0) goto L_0x01ef
                boolean r1 = r2.b()
                if (r1 == 0) goto L_0x01e8
                r1 = 0
                r2.a(r1, r1)
            L_0x01e8:
                boolean r1 = r0.g
                if (r1 != 0) goto L_0x01ef
                r2.a()
            L_0x01ef:
                r22.d()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.v.run():void");
        }

        private void c() {
            this.g = false;
            this.f = true;
        }

        private void d() {
            this.f = false;
            if (this.g) {
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.f) {
                this.g = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            android.support.v4.view.l.a((View) RecyclerView.this, (Runnable) this);
        }

        public void a(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.d = 0;
            this.c = 0;
            this.e.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            a();
        }

        public void b(int i, int i2) {
            a(i, i2, 0, 0);
        }

        public void a(int i, int i2, int i3, int i4) {
            a(i, i2, b(i, i2, i3, i4));
        }

        private float a(float f2) {
            return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
        }

        private int b(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = z ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i6 = width / 2;
            float f2 = (float) width;
            float f3 = (float) i6;
            float a2 = f3 + (a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / f2)) * f3);
            if (sqrt > 0) {
                i5 = Math.round(Math.abs(a2 / ((float) sqrt)) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((((float) abs) / f2) + 1.0f) * 300.0f);
            }
            return Math.min(i5, 2000);
        }

        public void a(int i, int i2, int i3) {
            a(i, i2, i3, RecyclerView.H);
        }

        public void a(int i, int i2, Interpolator interpolator) {
            int b2 = b(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.H;
            }
            a(i, i2, b2, interpolator);
        }

        public void a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.f411a != interpolator) {
                this.f411a = interpolator;
                this.e = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.d = 0;
            this.c = 0;
            this.e.startScroll(0, 0, i, i2, i3);
            if (Build.VERSION.SDK_INT < 23) {
                this.e.computeScrollOffset();
            }
            a();
        }

        public void b() {
            RecyclerView.this.removeCallbacks(this);
            this.e.abortAnimation();
        }
    }

    /* access modifiers changed from: package-private */
    public void x() {
        int b2 = this.f.b();
        for (int i2 = 0; i2 < b2; i2++) {
            View b3 = this.f.b(i2);
            w b4 = b(b3);
            if (!(b4 == null || b4.i == null)) {
                View view = b4.i.f413a;
                int left = b3.getLeft();
                int top = b3.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    private class q extends c {
        q() {
        }

        public void a() {
            RecyclerView.this.a((String) null);
            RecyclerView.this.B.e = true;
            RecyclerView.this.u();
            if (!RecyclerView.this.e.d()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void a(int i, int i2, Object obj) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.e.a(i, i2, obj)) {
                b();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (!RecyclerView.c || !RecyclerView.this.q || !RecyclerView.this.p) {
                RecyclerView.this.v = true;
                RecyclerView.this.requestLayout();
                return;
            }
            android.support.v4.view.l.a((View) RecyclerView.this, RecyclerView.this.i);
        }
    }

    public static class n {

        /* renamed from: a  reason: collision with root package name */
        SparseArray<a> f397a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        private int f398b = 0;

        static class a {

            /* renamed from: a  reason: collision with root package name */
            ArrayList<w> f399a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            int f400b = 5;
            long c = 0;
            long d = 0;

            a() {
            }
        }

        public void a() {
            for (int i = 0; i < this.f397a.size(); i++) {
                this.f397a.valueAt(i).f399a.clear();
            }
        }

        public w a(int i) {
            a aVar = this.f397a.get(i);
            if (aVar == null || aVar.f399a.isEmpty()) {
                return null;
            }
            ArrayList<w> arrayList = aVar.f399a;
            return arrayList.remove(arrayList.size() - 1);
        }

        public void a(w wVar) {
            int h = wVar.h();
            ArrayList<w> arrayList = b(h).f399a;
            if (this.f397a.get(h).f400b > arrayList.size()) {
                wVar.v();
                arrayList.add(wVar);
            }
        }

        /* access modifiers changed from: package-private */
        public long a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        /* access modifiers changed from: package-private */
        public void a(int i, long j) {
            a b2 = b(i);
            b2.c = a(b2.c, j);
        }

        /* access modifiers changed from: package-private */
        public void b(int i, long j) {
            a b2 = b(i);
            b2.d = a(b2.d, j);
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i, long j, long j2) {
            long j3 = b(i).c;
            return j3 == 0 || j + j3 < j2;
        }

        /* access modifiers changed from: package-private */
        public boolean b(int i, long j, long j2) {
            long j3 = b(i).d;
            return j3 == 0 || j + j3 < j2;
        }

        /* access modifiers changed from: package-private */
        public void a(a aVar) {
            this.f398b++;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f398b--;
        }

        /* access modifiers changed from: package-private */
        public void a(a aVar, a aVar2, boolean z) {
            if (aVar != null) {
                b();
            }
            if (!z && this.f398b == 0) {
                a();
            }
            if (aVar2 != null) {
                a(aVar2);
            }
        }

        private a b(int i) {
            a aVar = this.f397a.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f397a.put(i, aVar2);
            return aVar2;
        }
    }

    static RecyclerView k(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView k2 = k(viewGroup.getChildAt(i2));
            if (k2 != null) {
                return k2;
            }
        }
        return null;
    }

    static void c(w wVar) {
        if (wVar.f414b != null) {
            View view = (View) wVar.f414b.get();
            while (view != null) {
                if (view != wVar.f413a) {
                    ViewParent parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            wVar.f414b = null;
        }
    }

    /* access modifiers changed from: package-private */
    public long getNanoTime() {
        if (K) {
            return System.nanoTime();
        }
        return 0;
    }

    public final class o {

        /* renamed from: a  reason: collision with root package name */
        final ArrayList<w> f401a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        ArrayList<w> f402b = null;
        final ArrayList<w> c = new ArrayList<>();
        int d = 2;
        n e;
        private final List<w> g = Collections.unmodifiableList(this.f401a);
        private int h = 2;
        private u i;

        public o() {
        }

        public void a() {
            this.f401a.clear();
            d();
        }

        public void a(int i2) {
            this.h = i2;
            b();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.d = this.h + (RecyclerView.this.m != null ? RecyclerView.this.m.x : 0);
            for (int size = this.c.size() - 1; size >= 0 && this.c.size() > this.d; size--) {
                d(size);
            }
        }

        public List<w> c() {
            return this.g;
        }

        /* access modifiers changed from: package-private */
        public boolean a(w wVar) {
            if (wVar.q()) {
                return RecyclerView.this.B.a();
            }
            if (wVar.c < 0 || wVar.c >= RecyclerView.this.l.a()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + wVar + RecyclerView.this.a());
            } else if (!RecyclerView.this.B.a() && RecyclerView.this.l.a(wVar.c) != wVar.h()) {
                return false;
            } else {
                if (!RecyclerView.this.l.b() || wVar.g() == RecyclerView.this.l.b(wVar.c)) {
                    return true;
                }
                return false;
            }
        }

        private boolean a(w wVar, int i2, int i3, long j) {
            wVar.m = RecyclerView.this;
            int h2 = wVar.h();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.e.b(h2, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.l.b(wVar, i2);
            this.e.b(wVar.h(), RecyclerView.this.getNanoTime() - nanoTime);
            e(wVar);
            if (!RecyclerView.this.B.a()) {
                return true;
            }
            wVar.g = i3;
            return true;
        }

        public int b(int i2) {
            if (i2 < 0 || i2 >= RecyclerView.this.B.e()) {
                throw new IndexOutOfBoundsException("invalid position " + i2 + ". State " + "item count is " + RecyclerView.this.B.e() + RecyclerView.this.a());
            } else if (!RecyclerView.this.B.a()) {
                return i2;
            } else {
                return RecyclerView.this.e.b(i2);
            }
        }

        public View c(int i2) {
            return a(i2, false);
        }

        /* access modifiers changed from: package-private */
        public View a(int i2, boolean z) {
            return a(i2, z, Long.MAX_VALUE).f413a;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x01ac  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x01d7  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x01da  */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x020a  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0218  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.support.v7.widget.RecyclerView.w a(int r17, boolean r18, long r19) {
            /*
                r16 = this;
                r6 = r16
                r3 = r17
                r0 = r18
                if (r3 < 0) goto L_0x023b
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$t r1 = r1.B
                int r1 = r1.e()
                if (r3 >= r1) goto L_0x023b
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$t r1 = r1.B
                boolean r1 = r1.a()
                r2 = 0
                r7 = 1
                r8 = 0
                if (r1 == 0) goto L_0x0027
                android.support.v7.widget.RecyclerView$w r1 = r16.f((int) r17)
                if (r1 == 0) goto L_0x0028
                r4 = 1
                goto L_0x0029
            L_0x0027:
                r1 = r2
            L_0x0028:
                r4 = 0
            L_0x0029:
                if (r1 != 0) goto L_0x005d
                android.support.v7.widget.RecyclerView$w r1 = r16.b((int) r17, (boolean) r18)
                if (r1 == 0) goto L_0x005d
                boolean r5 = r6.a((android.support.v7.widget.RecyclerView.w) r1)
                if (r5 != 0) goto L_0x005c
                if (r0 != 0) goto L_0x005a
                r5 = 4
                r1.b((int) r5)
                boolean r5 = r1.i()
                if (r5 == 0) goto L_0x004e
                android.support.v7.widget.RecyclerView r5 = android.support.v7.widget.RecyclerView.this
                android.view.View r9 = r1.f413a
                r5.removeDetachedView(r9, r8)
                r1.j()
                goto L_0x0057
            L_0x004e:
                boolean r5 = r1.k()
                if (r5 == 0) goto L_0x0057
                r1.l()
            L_0x0057:
                r6.b((android.support.v7.widget.RecyclerView.w) r1)
            L_0x005a:
                r1 = r2
                goto L_0x005d
            L_0x005c:
                r4 = 1
            L_0x005d:
                if (r1 != 0) goto L_0x018b
                android.support.v7.widget.RecyclerView r5 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.a r5 = r5.e
                int r5 = r5.b((int) r3)
                if (r5 < 0) goto L_0x014e
                android.support.v7.widget.RecyclerView r9 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$a r9 = r9.l
                int r9 = r9.a()
                if (r5 >= r9) goto L_0x014e
                android.support.v7.widget.RecyclerView r9 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$a r9 = r9.l
                int r9 = r9.a((int) r5)
                android.support.v7.widget.RecyclerView r10 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$a r10 = r10.l
                boolean r10 = r10.b()
                if (r10 == 0) goto L_0x0096
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$a r1 = r1.l
                long r10 = r1.b((int) r5)
                android.support.v7.widget.RecyclerView$w r1 = r6.a((long) r10, (int) r9, (boolean) r0)
                if (r1 == 0) goto L_0x0096
                r1.c = r5
                r4 = 1
            L_0x0096:
                if (r1 != 0) goto L_0x00ed
                android.support.v7.widget.RecyclerView$u r0 = r6.i
                if (r0 == 0) goto L_0x00ed
                android.support.v7.widget.RecyclerView$u r0 = r6.i
                android.view.View r0 = r0.a(r6, r3, r9)
                if (r0 == 0) goto L_0x00ed
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$w r1 = r1.b((android.view.View) r0)
                if (r1 == 0) goto L_0x00d0
                boolean r0 = r1.c()
                if (r0 != 0) goto L_0x00b3
                goto L_0x00ed
            L_0x00b3:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view."
                r1.append(r2)
                android.support.v7.widget.RecyclerView r2 = android.support.v7.widget.RecyclerView.this
                java.lang.String r2 = r2.a()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00d0:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view which does not have a ViewHolder"
                r1.append(r2)
                android.support.v7.widget.RecyclerView r2 = android.support.v7.widget.RecyclerView.this
                java.lang.String r2 = r2.a()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00ed:
                if (r1 != 0) goto L_0x0103
                android.support.v7.widget.RecyclerView$n r0 = r16.g()
                android.support.v7.widget.RecyclerView$w r1 = r0.a((int) r9)
                if (r1 == 0) goto L_0x0103
                r1.v()
                boolean r0 = android.support.v7.widget.RecyclerView.f377a
                if (r0 == 0) goto L_0x0103
                r6.f((android.support.v7.widget.RecyclerView.w) r1)
            L_0x0103:
                if (r1 != 0) goto L_0x018b
                android.support.v7.widget.RecyclerView r0 = android.support.v7.widget.RecyclerView.this
                long r0 = r0.getNanoTime()
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
                if (r5 == 0) goto L_0x0121
                android.support.v7.widget.RecyclerView$n r10 = r6.e
                r11 = r9
                r12 = r0
                r14 = r19
                boolean r5 = r10.a((int) r11, (long) r12, (long) r14)
                if (r5 != 0) goto L_0x0121
                return r2
            L_0x0121:
                android.support.v7.widget.RecyclerView r2 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$a r2 = r2.l
                android.support.v7.widget.RecyclerView r5 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$w r2 = r2.b((android.view.ViewGroup) r5, (int) r9)
                boolean r5 = android.support.v7.widget.RecyclerView.K
                if (r5 == 0) goto L_0x0140
                android.view.View r5 = r2.f413a
                android.support.v7.widget.RecyclerView r5 = android.support.v7.widget.RecyclerView.k(r5)
                if (r5 == 0) goto L_0x0140
                java.lang.ref.WeakReference r10 = new java.lang.ref.WeakReference
                r10.<init>(r5)
                r2.f414b = r10
            L_0x0140:
                android.support.v7.widget.RecyclerView r5 = android.support.v7.widget.RecyclerView.this
                long r10 = r5.getNanoTime()
                android.support.v7.widget.RecyclerView$n r5 = r6.e
                long r10 = r10 - r0
                r5.a((int) r9, (long) r10)
                r10 = r2
                goto L_0x018c
            L_0x014e:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Inconsistency detected. Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "(offset:"
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = ")."
                r1.append(r2)
                java.lang.String r2 = "state:"
                r1.append(r2)
                android.support.v7.widget.RecyclerView r2 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$t r2 = r2.B
                int r2 = r2.e()
                r1.append(r2)
                android.support.v7.widget.RecyclerView r2 = android.support.v7.widget.RecyclerView.this
                java.lang.String r2 = r2.a()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x018b:
                r10 = r1
            L_0x018c:
                r9 = r4
                if (r9 == 0) goto L_0x01c7
                android.support.v7.widget.RecyclerView r0 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$t r0 = r0.B
                boolean r0 = r0.a()
                if (r0 != 0) goto L_0x01c7
                r0 = 8192(0x2000, float:1.14794E-41)
                boolean r1 = r10.a((int) r0)
                if (r1 == 0) goto L_0x01c7
                r10.a((int) r8, (int) r0)
                android.support.v7.widget.RecyclerView r0 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$t r0 = r0.B
                boolean r0 = r0.i
                if (r0 == 0) goto L_0x01c7
                int r0 = android.support.v7.widget.RecyclerView.e.e(r10)
                r0 = r0 | 4096(0x1000, float:5.74E-42)
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$e r1 = r1.x
                android.support.v7.widget.RecyclerView r2 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$t r2 = r2.B
                java.util.List r4 = r10.u()
                android.support.v7.widget.RecyclerView$e$c r0 = r1.a((android.support.v7.widget.RecyclerView.t) r2, (android.support.v7.widget.RecyclerView.w) r10, (int) r0, (java.util.List<java.lang.Object>) r4)
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                r1.a((android.support.v7.widget.RecyclerView.w) r10, (android.support.v7.widget.RecyclerView.e.c) r0)
            L_0x01c7:
                android.support.v7.widget.RecyclerView r0 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$t r0 = r0.B
                boolean r0 = r0.a()
                if (r0 == 0) goto L_0x01da
                boolean r0 = r10.p()
                if (r0 == 0) goto L_0x01da
                r10.g = r3
                goto L_0x01ed
            L_0x01da:
                boolean r0 = r10.p()
                if (r0 == 0) goto L_0x01ef
                boolean r0 = r10.o()
                if (r0 != 0) goto L_0x01ef
                boolean r0 = r10.n()
                if (r0 == 0) goto L_0x01ed
                goto L_0x01ef
            L_0x01ed:
                r0 = 0
                goto L_0x0202
            L_0x01ef:
                android.support.v7.widget.RecyclerView r0 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.a r0 = r0.e
                int r2 = r0.b((int) r3)
                r0 = r16
                r1 = r10
                r3 = r17
                r4 = r19
                boolean r0 = r0.a(r1, r2, r3, r4)
            L_0x0202:
                android.view.View r1 = r10.f413a
                android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
                if (r1 != 0) goto L_0x0218
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r1.generateDefaultLayoutParams()
                android.support.v7.widget.RecyclerView$i r1 = (android.support.v7.widget.RecyclerView.i) r1
                android.view.View r2 = r10.f413a
                r2.setLayoutParams(r1)
                goto L_0x0230
            L_0x0218:
                android.support.v7.widget.RecyclerView r2 = android.support.v7.widget.RecyclerView.this
                boolean r2 = r2.checkLayoutParams(r1)
                if (r2 != 0) goto L_0x022e
                android.support.v7.widget.RecyclerView r2 = android.support.v7.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r2.generateLayoutParams((android.view.ViewGroup.LayoutParams) r1)
                android.support.v7.widget.RecyclerView$i r1 = (android.support.v7.widget.RecyclerView.i) r1
                android.view.View r2 = r10.f413a
                r2.setLayoutParams(r1)
                goto L_0x0230
            L_0x022e:
                android.support.v7.widget.RecyclerView$i r1 = (android.support.v7.widget.RecyclerView.i) r1
            L_0x0230:
                r1.c = r10
                if (r9 == 0) goto L_0x0237
                if (r0 == 0) goto L_0x0237
                goto L_0x0238
            L_0x0237:
                r7 = 0
            L_0x0238:
                r1.f = r7
                return r10
            L_0x023b:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "("
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "). Item count:"
                r1.append(r2)
                android.support.v7.widget.RecyclerView r2 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$t r2 = r2.B
                int r2 = r2.e()
                r1.append(r2)
                android.support.v7.widget.RecyclerView r2 = android.support.v7.widget.RecyclerView.this
                java.lang.String r2 = r2.a()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.o.a(int, boolean, long):android.support.v7.widget.RecyclerView$w");
        }

        private void e(w wVar) {
            if (RecyclerView.this.n()) {
                View view = wVar.f413a;
                if (android.support.v4.view.l.d(view) == 0) {
                    android.support.v4.view.l.a(view, 1);
                }
                if (!android.support.v4.view.l.a(view)) {
                    wVar.b(16384);
                    android.support.v4.view.l.a(view, RecyclerView.this.F.c());
                }
            }
        }

        private void f(w wVar) {
            if (wVar.f413a instanceof ViewGroup) {
                a((ViewGroup) wVar.f413a, false);
            }
        }

        private void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        public void a(View view) {
            w e2 = RecyclerView.e(view);
            if (e2.r()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (e2.i()) {
                e2.j();
            } else if (e2.k()) {
                e2.l();
            }
            b(e2);
        }

        /* access modifiers changed from: package-private */
        public void d() {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                d(size);
            }
            this.c.clear();
            if (RecyclerView.K) {
                RecyclerView.this.A.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(int i2) {
            a(this.c.get(i2), true);
            this.c.remove(i2);
        }

        /* access modifiers changed from: package-private */
        public void b(w wVar) {
            boolean z;
            boolean z2 = false;
            if (wVar.i() || wVar.f413a.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(wVar.i());
                sb.append(" isAttached:");
                if (wVar.f413a.getParent() != null) {
                    z2 = true;
                }
                sb.append(z2);
                sb.append(RecyclerView.this.a());
                throw new IllegalArgumentException(sb.toString());
            } else if (wVar.r()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + wVar + RecyclerView.this.a());
            } else if (!wVar.c()) {
                boolean a2 = wVar.A();
                if ((RecyclerView.this.l != null && a2 && RecyclerView.this.l.b(wVar)) || wVar.w()) {
                    if (this.d <= 0 || wVar.a(526)) {
                        z = false;
                    } else {
                        int size = this.c.size();
                        if (size >= this.d && size > 0) {
                            d(0);
                            size--;
                        }
                        if (RecyclerView.K && size > 0 && !RecyclerView.this.A.a(wVar.c)) {
                            int i2 = size - 1;
                            while (i2 >= 0) {
                                if (!RecyclerView.this.A.a(this.c.get(i2).c)) {
                                    break;
                                }
                                i2--;
                            }
                            size = i2 + 1;
                        }
                        this.c.add(size, wVar);
                        z = true;
                    }
                    if (!z) {
                        a(wVar, true);
                        z2 = true;
                    }
                } else {
                    z = false;
                }
                RecyclerView.this.g.g(wVar);
                if (!z && !z2 && a2) {
                    wVar.m = null;
                }
            } else {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.a());
            }
        }

        /* access modifiers changed from: package-private */
        public void a(w wVar, boolean z) {
            RecyclerView.c(wVar);
            if (wVar.a(16384)) {
                wVar.a(0, 16384);
                android.support.v4.view.l.a(wVar.f413a, (android.support.v4.view.b) null);
            }
            if (z) {
                d(wVar);
            }
            wVar.m = null;
            g().a(wVar);
        }

        /* access modifiers changed from: package-private */
        public void b(View view) {
            w e2 = RecyclerView.e(view);
            o unused = e2.q = null;
            boolean unused2 = e2.r = false;
            e2.l();
            b(e2);
        }

        /* access modifiers changed from: package-private */
        public void c(View view) {
            w e2 = RecyclerView.e(view);
            if (!e2.a(12) && e2.x() && !RecyclerView.this.b(e2)) {
                if (this.f402b == null) {
                    this.f402b = new ArrayList<>();
                }
                e2.a(this, true);
                this.f402b.add(e2);
            } else if (!e2.n() || e2.q() || RecyclerView.this.l.b()) {
                e2.a(this, false);
                this.f401a.add(e2);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.a());
            }
        }

        /* access modifiers changed from: package-private */
        public void c(w wVar) {
            if (wVar.r) {
                this.f402b.remove(wVar);
            } else {
                this.f401a.remove(wVar);
            }
            o unused = wVar.q = null;
            boolean unused2 = wVar.r = false;
            wVar.l();
        }

        /* access modifiers changed from: package-private */
        public int e() {
            return this.f401a.size();
        }

        /* access modifiers changed from: package-private */
        public View e(int i2) {
            return this.f401a.get(i2).f413a;
        }

        /* access modifiers changed from: package-private */
        public void f() {
            this.f401a.clear();
            if (this.f402b != null) {
                this.f402b.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public w f(int i2) {
            int size;
            int b2;
            if (this.f402b == null || (size = this.f402b.size()) == 0) {
                return null;
            }
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                w wVar = this.f402b.get(i4);
                if (wVar.k() || wVar.d() != i2) {
                    i4++;
                } else {
                    wVar.b(32);
                    return wVar;
                }
            }
            if (RecyclerView.this.l.b() && (b2 = RecyclerView.this.e.b(i2)) > 0 && b2 < RecyclerView.this.l.a()) {
                long b3 = RecyclerView.this.l.b(b2);
                while (i3 < size) {
                    w wVar2 = this.f402b.get(i3);
                    if (wVar2.k() || wVar2.g() != b3) {
                        i3++;
                    } else {
                        wVar2.b(32);
                        return wVar2;
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public w b(int i2, boolean z) {
            View c2;
            int size = this.f401a.size();
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                w wVar = this.f401a.get(i4);
                if (wVar.k() || wVar.d() != i2 || wVar.n() || (!RecyclerView.this.B.f && wVar.q())) {
                    i4++;
                } else {
                    wVar.b(32);
                    return wVar;
                }
            }
            if (z || (c2 = RecyclerView.this.f.c(i2)) == null) {
                int size2 = this.c.size();
                while (i3 < size2) {
                    w wVar2 = this.c.get(i3);
                    if (wVar2.n() || wVar2.d() != i2) {
                        i3++;
                    } else {
                        if (!z) {
                            this.c.remove(i3);
                        }
                        return wVar2;
                    }
                }
                return null;
            }
            w e2 = RecyclerView.e(c2);
            RecyclerView.this.f.e(c2);
            int b2 = RecyclerView.this.f.b(c2);
            if (b2 != -1) {
                RecyclerView.this.f.e(b2);
                c(c2);
                e2.b(8224);
                return e2;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + e2 + RecyclerView.this.a());
        }

        /* access modifiers changed from: package-private */
        public w a(long j, int i2, boolean z) {
            for (int size = this.f401a.size() - 1; size >= 0; size--) {
                w wVar = this.f401a.get(size);
                if (wVar.g() == j && !wVar.k()) {
                    if (i2 == wVar.h()) {
                        wVar.b(32);
                        if (wVar.q() && !RecyclerView.this.B.a()) {
                            wVar.a(2, 14);
                        }
                        return wVar;
                    } else if (!z) {
                        this.f401a.remove(size);
                        RecyclerView.this.removeDetachedView(wVar.f413a, false);
                        b(wVar.f413a);
                    }
                }
            }
            int size2 = this.c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                w wVar2 = this.c.get(size2);
                if (wVar2.g() == j) {
                    if (i2 == wVar2.h()) {
                        if (!z) {
                            this.c.remove(size2);
                        }
                        return wVar2;
                    } else if (!z) {
                        d(size2);
                        return null;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d(w wVar) {
            if (RecyclerView.this.n != null) {
                RecyclerView.this.n.a(wVar);
            }
            if (RecyclerView.this.l != null) {
                RecyclerView.this.l.a(wVar);
            }
            if (RecyclerView.this.B != null) {
                RecyclerView.this.g.g(wVar);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(a aVar, a aVar2, boolean z) {
            a();
            g().a(aVar, aVar2, z);
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3) {
            int i4;
            int i5;
            int i6;
            if (i2 < i3) {
                i6 = i2;
                i5 = i3;
                i4 = -1;
            } else {
                i5 = i2;
                i6 = i3;
                i4 = 1;
            }
            int size = this.c.size();
            for (int i7 = 0; i7 < size; i7++) {
                w wVar = this.c.get(i7);
                if (wVar != null && wVar.c >= i6 && wVar.c <= i5) {
                    if (wVar.c == i2) {
                        wVar.a(i3 - i2, false);
                    } else {
                        wVar.a(i4, false);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, int i3) {
            int size = this.c.size();
            for (int i4 = 0; i4 < size; i4++) {
                w wVar = this.c.get(i4);
                if (wVar != null && wVar.c >= i2) {
                    wVar.a(i3, true);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3, boolean z) {
            int i4 = i2 + i3;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                w wVar = this.c.get(size);
                if (wVar != null) {
                    if (wVar.c >= i4) {
                        wVar.a(-i3, z);
                    } else if (wVar.c >= i2) {
                        wVar.b(8);
                        d(size);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(u uVar) {
            this.i = uVar;
        }

        /* access modifiers changed from: package-private */
        public void a(n nVar) {
            if (this.e != null) {
                this.e.b();
            }
            this.e = nVar;
            if (nVar != null) {
                this.e.a(RecyclerView.this.getAdapter());
            }
        }

        /* access modifiers changed from: package-private */
        public n g() {
            if (this.e == null) {
                this.e = new n();
            }
            return this.e;
        }

        /* access modifiers changed from: package-private */
        public void c(int i2, int i3) {
            int i4;
            int i5 = i3 + i2;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                w wVar = this.c.get(size);
                if (wVar != null && (i4 = wVar.c) >= i2 && i4 < i5) {
                    wVar.b(2);
                    d(size);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
            if (RecyclerView.this.l == null || !RecyclerView.this.l.b()) {
                d();
                return;
            }
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                w wVar = this.c.get(i2);
                if (wVar != null) {
                    wVar.b(6);
                    wVar.a((Object) null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.c.get(i2).a();
            }
            int size2 = this.f401a.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.f401a.get(i3).a();
            }
            if (this.f402b != null) {
                int size3 = this.f402b.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    this.f402b.get(i4).a();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void j() {
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                i iVar = (i) this.c.get(i2).f413a.getLayoutParams();
                if (iVar != null) {
                    iVar.e = true;
                }
            }
        }
    }

    public static abstract class a<VH extends w> {

        /* renamed from: a  reason: collision with root package name */
        private final b f384a = new b();

        /* renamed from: b  reason: collision with root package name */
        private boolean f385b = false;

        public abstract int a();

        public int a(int i) {
            return 0;
        }

        public abstract VH a(ViewGroup viewGroup, int i);

        public void a(VH vh) {
        }

        public abstract void a(VH vh, int i);

        public void a(RecyclerView recyclerView) {
        }

        public long b(int i) {
            return -1;
        }

        public void b(RecyclerView recyclerView) {
        }

        public boolean b(VH vh) {
            return false;
        }

        public void c(VH vh) {
        }

        public void d(VH vh) {
        }

        public void a(VH vh, int i, List<Object> list) {
            a(vh, i);
        }

        public final VH b(ViewGroup viewGroup, int i) {
            android.support.v4.c.c.a("RV CreateView");
            VH a2 = a(viewGroup, i);
            a2.f = i;
            android.support.v4.c.c.a();
            return a2;
        }

        public final void b(VH vh, int i) {
            vh.c = i;
            if (b()) {
                vh.e = b(i);
            }
            vh.a(1, 519);
            android.support.v4.c.c.a("RV OnBindView");
            a(vh, i, vh.u());
            vh.t();
            ViewGroup.LayoutParams layoutParams = vh.f413a.getLayoutParams();
            if (layoutParams instanceof i) {
                ((i) layoutParams).e = true;
            }
            android.support.v4.c.c.a();
        }

        public final boolean b() {
            return this.f385b;
        }

        public void a(c cVar) {
            this.f384a.registerObserver(cVar);
        }

        public void b(c cVar) {
            this.f384a.unregisterObserver(cVar);
        }

        public final void c() {
            this.f384a.a();
        }

        public final void c(int i) {
            this.f384a.a(i, 1);
        }
    }

    /* access modifiers changed from: package-private */
    public void l(View view) {
        w e2 = e(view);
        i(view);
        if (!(this.l == null || e2 == null)) {
            this.l.d(e2);
        }
        if (this.aa != null) {
            for (int size = this.aa.size() - 1; size >= 0; size--) {
                this.aa.get(size).b(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void m(View view) {
        w e2 = e(view);
        h(view);
        if (!(this.l == null || e2 == null)) {
            this.l.c(e2);
        }
        if (this.aa != null) {
            for (int size = this.aa.size() - 1; size >= 0; size--) {
                this.aa.get(size).a(view);
            }
        }
    }

    public static abstract class h {

        /* renamed from: a  reason: collision with root package name */
        private final l.b f391a = new l.b() {
            public View a(int i) {
                return h.this.h(i);
            }

            public int a() {
                return h.this.z();
            }

            public int b() {
                return h.this.x() - h.this.B();
            }

            public int a(View view) {
                return h.this.h(view) - ((i) view.getLayoutParams()).leftMargin;
            }

            public int b(View view) {
                return h.this.j(view) + ((i) view.getLayoutParams()).rightMargin;
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private final l.b f392b = new l.b() {
            public View a(int i) {
                return h.this.h(i);
            }

            public int a() {
                return h.this.A();
            }

            public int b() {
                return h.this.y() - h.this.C();
            }

            public int a(View view) {
                return h.this.i(view) - ((i) view.getLayoutParams()).topMargin;
            }

            public int b(View view) {
                return h.this.k(view) + ((i) view.getLayoutParams()).bottomMargin;
            }
        };
        private boolean c = true;
        private boolean d = true;
        private int e;
        private int f;
        private int g;
        private int h;
        b p;
        RecyclerView q;
        l r = new l(this.f391a);
        l s = new l(this.f392b);
        s t;
        boolean u = false;
        boolean v = false;
        boolean w = false;
        int x;
        boolean y;

        public interface a {
            void b(int i, int i2);
        }

        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public int f395a;

            /* renamed from: b  reason: collision with root package name */
            public int f396b;
            public boolean c;
            public boolean d;
        }

        public int a(int i, o oVar, t tVar) {
            return 0;
        }

        public abstract i a();

        public View a(View view, int i, o oVar, t tVar) {
            return null;
        }

        public void a(int i, int i2, t tVar, a aVar) {
        }

        public void a(int i, a aVar) {
        }

        public void a(Parcelable parcelable) {
        }

        public void a(a aVar, a aVar2) {
        }

        public void a(t tVar) {
        }

        public void a(RecyclerView recyclerView) {
        }

        public void a(RecyclerView recyclerView, int i, int i2) {
        }

        public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public boolean a(i iVar) {
            return iVar != null;
        }

        public boolean a(o oVar, t tVar, View view, int i, Bundle bundle) {
            return false;
        }

        public boolean a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public int b(int i, o oVar, t tVar) {
            return 0;
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
        }

        public boolean b() {
            return false;
        }

        public int c(t tVar) {
            return 0;
        }

        public Parcelable c() {
            return null;
        }

        public void c(RecyclerView recyclerView, int i, int i2) {
        }

        public int d(o oVar, t tVar) {
            return 0;
        }

        public int d(t tVar) {
            return 0;
        }

        public View d(View view, int i) {
            return null;
        }

        public void d(int i) {
        }

        public void d(RecyclerView recyclerView) {
        }

        public boolean d() {
            return false;
        }

        public int e(t tVar) {
            return 0;
        }

        @Deprecated
        public void e(RecyclerView recyclerView) {
        }

        public boolean e() {
            return false;
        }

        public boolean e(o oVar, t tVar) {
            return false;
        }

        public int f(t tVar) {
            return 0;
        }

        public int g(t tVar) {
            return 0;
        }

        public int h(t tVar) {
            return 0;
        }

        public void k(int i) {
        }

        /* access modifiers changed from: package-private */
        public boolean k() {
            return false;
        }

        public int t() {
            return -1;
        }

        /* access modifiers changed from: package-private */
        public void b(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.q = null;
                this.p = null;
                this.g = 0;
                this.h = 0;
            } else {
                this.q = recyclerView;
                this.p = recyclerView.f;
                this.g = recyclerView.getWidth();
                this.h = recyclerView.getHeight();
            }
            this.e = 1073741824;
            this.f = 1073741824;
        }

        /* access modifiers changed from: package-private */
        public void d(int i, int i2) {
            this.g = View.MeasureSpec.getSize(i);
            this.e = View.MeasureSpec.getMode(i);
            if (this.e == 0 && !RecyclerView.f378b) {
                this.g = 0;
            }
            this.h = View.MeasureSpec.getSize(i2);
            this.f = View.MeasureSpec.getMode(i2);
            if (this.f == 0 && !RecyclerView.f378b) {
                this.h = 0;
            }
        }

        /* access modifiers changed from: package-private */
        public void e(int i, int i2) {
            int u2 = u();
            if (u2 == 0) {
                this.q.e(i, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            for (int i7 = 0; i7 < u2; i7++) {
                View h2 = h(i7);
                Rect rect = this.q.j;
                a(h2, rect);
                if (rect.left < i3) {
                    i3 = rect.left;
                }
                if (rect.right > i5) {
                    i5 = rect.right;
                }
                if (rect.top < i4) {
                    i4 = rect.top;
                }
                if (rect.bottom > i6) {
                    i6 = rect.bottom;
                }
            }
            this.q.j.set(i3, i4, i5, i6);
            a(this.q.j, i, i2);
        }

        public void a(Rect rect, int i, int i2) {
            g(a(i, rect.width() + z() + B(), E()), a(i2, rect.height() + A() + C(), F()));
        }

        public void n() {
            if (this.q != null) {
                this.q.requestLayout();
            }
        }

        public static int a(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        public void a(String str) {
            if (this.q != null) {
                this.q.a(str);
            }
        }

        public void c(boolean z) {
            this.w = z;
        }

        public final boolean o() {
            return this.d;
        }

        /* access modifiers changed from: package-private */
        public void c(RecyclerView recyclerView) {
            this.v = true;
            d(recyclerView);
        }

        /* access modifiers changed from: package-private */
        public void b(RecyclerView recyclerView, o oVar) {
            this.v = false;
            a(recyclerView, oVar);
        }

        public boolean p() {
            return this.v;
        }

        public boolean a(Runnable runnable) {
            if (this.q != null) {
                return this.q.removeCallbacks(runnable);
            }
            return false;
        }

        public void a(RecyclerView recyclerView, o oVar) {
            e(recyclerView);
        }

        public boolean q() {
            return this.q != null && this.q.h;
        }

        public void c(o oVar, t tVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public i a(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof i) {
                return new i((i) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new i((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new i(layoutParams);
        }

        public i a(Context context, AttributeSet attributeSet) {
            return new i(context, attributeSet);
        }

        public boolean r() {
            return this.t != null && this.t.c();
        }

        public int s() {
            return android.support.v4.view.l.e(this.q);
        }

        public void a(View view) {
            a(view, -1);
        }

        public void a(View view, int i) {
            a(view, i, true);
        }

        public void b(View view) {
            b(view, -1);
        }

        public void b(View view, int i) {
            a(view, i, false);
        }

        private void a(View view, int i, boolean z) {
            w e2 = RecyclerView.e(view);
            if (z || e2.q()) {
                this.q.g.e(e2);
            } else {
                this.q.g.f(e2);
            }
            i iVar = (i) view.getLayoutParams();
            if (e2.k() || e2.i()) {
                if (e2.i()) {
                    e2.j();
                } else {
                    e2.l();
                }
                this.p.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.q) {
                int b2 = this.p.b(view);
                if (i == -1) {
                    i = this.p.b();
                }
                if (b2 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.q.indexOfChild(view) + this.q.a());
                } else if (b2 != i) {
                    this.q.m.f(b2, i);
                }
            } else {
                this.p.a(view, i, false);
                iVar.e = true;
                if (this.t != null && this.t.c()) {
                    this.t.b(view);
                }
            }
            if (iVar.f) {
                e2.f413a.invalidate();
                iVar.f = false;
            }
        }

        public void c(View view) {
            this.p.a(view);
        }

        public void f(int i) {
            if (h(i) != null) {
                this.p.a(i);
            }
        }

        public int d(View view) {
            return ((i) view.getLayoutParams()).f();
        }

        public View e(View view) {
            View c2;
            if (this.q == null || (c2 = this.q.c(view)) == null || this.p.c(c2)) {
                return null;
            }
            return c2;
        }

        public View c(int i) {
            int u2 = u();
            for (int i2 = 0; i2 < u2; i2++) {
                View h2 = h(i2);
                w e2 = RecyclerView.e(h2);
                if (e2 != null && e2.d() == i && !e2.c() && (this.q.B.a() || !e2.q())) {
                    return h2;
                }
            }
            return null;
        }

        public void g(int i) {
            a(i, h(i));
        }

        private void a(int i, View view) {
            this.p.e(i);
        }

        public void a(View view, int i, i iVar) {
            w e2 = RecyclerView.e(view);
            if (e2.q()) {
                this.q.g.e(e2);
            } else {
                this.q.g.f(e2);
            }
            this.p.a(view, i, iVar, e2.q());
        }

        public void c(View view, int i) {
            a(view, i, (i) view.getLayoutParams());
        }

        public void f(int i, int i2) {
            View h2 = h(i);
            if (h2 != null) {
                g(i);
                c(h2, i2);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.q.toString());
        }

        public void a(View view, o oVar) {
            c(view);
            oVar.a(view);
        }

        public void a(int i, o oVar) {
            View h2 = h(i);
            f(i);
            oVar.a(h2);
        }

        public int u() {
            if (this.p != null) {
                return this.p.b();
            }
            return 0;
        }

        public View h(int i) {
            if (this.p != null) {
                return this.p.b(i);
            }
            return null;
        }

        public int v() {
            return this.e;
        }

        public int w() {
            return this.f;
        }

        public int x() {
            return this.g;
        }

        public int y() {
            return this.h;
        }

        public int z() {
            if (this.q != null) {
                return this.q.getPaddingLeft();
            }
            return 0;
        }

        public int A() {
            if (this.q != null) {
                return this.q.getPaddingTop();
            }
            return 0;
        }

        public int B() {
            if (this.q != null) {
                return this.q.getPaddingRight();
            }
            return 0;
        }

        public int C() {
            if (this.q != null) {
                return this.q.getPaddingBottom();
            }
            return 0;
        }

        public View D() {
            View focusedChild;
            if (this.q == null || (focusedChild = this.q.getFocusedChild()) == null || this.p.c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void i(int i) {
            if (this.q != null) {
                this.q.d(i);
            }
        }

        public void j(int i) {
            if (this.q != null) {
                this.q.c(i);
            }
        }

        public void a(o oVar) {
            for (int u2 = u() - 1; u2 >= 0; u2--) {
                a(oVar, u2, h(u2));
            }
        }

        private void a(o oVar, int i, View view) {
            w e2 = RecyclerView.e(view);
            if (!e2.c()) {
                if (!e2.n() || e2.q() || this.q.l.b()) {
                    g(i);
                    oVar.c(view);
                    this.q.g.h(e2);
                    return;
                }
                f(i);
                oVar.b(e2);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(o oVar) {
            int e2 = oVar.e();
            for (int i = e2 - 1; i >= 0; i--) {
                View e3 = oVar.e(i);
                w e4 = RecyclerView.e(e3);
                if (!e4.c()) {
                    e4.a(false);
                    if (e4.r()) {
                        this.q.removeDetachedView(e3, false);
                    }
                    if (this.q.x != null) {
                        this.q.x.d(e4);
                    }
                    e4.a(true);
                    oVar.b(e3);
                }
            }
            oVar.f();
            if (e2 > 0) {
                this.q.invalidate();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(View view, int i, int i2, i iVar) {
            return !this.c || !b(view.getMeasuredWidth(), i, iVar.width) || !b(view.getMeasuredHeight(), i2, iVar.height);
        }

        /* access modifiers changed from: package-private */
        public boolean b(View view, int i, int i2, i iVar) {
            return view.isLayoutRequested() || !this.c || !b(view.getWidth(), i, iVar.width) || !b(view.getHeight(), i2, iVar.height);
        }

        private static boolean b(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        public void a(View view, int i, int i2) {
            i iVar = (i) view.getLayoutParams();
            Rect j = this.q.j(view);
            int i3 = i + j.left + j.right;
            int i4 = i2 + j.top + j.bottom;
            int a2 = a(x(), v(), z() + B() + iVar.leftMargin + iVar.rightMargin + i3, iVar.width, d());
            int a3 = a(y(), w(), A() + C() + iVar.topMargin + iVar.bottomMargin + i4, iVar.height, e());
            if (b(view, a2, a3, iVar)) {
                view.measure(a2, a3);
            }
        }

        public static int a(int i, int i2, int i3, int i4, boolean z) {
            int i5;
            int i6 = i - i3;
            int i7 = 0;
            int max = Math.max(0, i6);
            if (z) {
                if (i4 < 0) {
                    if (i4 == -1) {
                        if (i2 == Integer.MIN_VALUE || (i2 != 0 && i2 == 1073741824)) {
                            i5 = max;
                        } else {
                            i2 = 0;
                            i5 = 0;
                        }
                        i7 = i2;
                        max = i5;
                        return View.MeasureSpec.makeMeasureSpec(max, i7);
                    }
                    max = 0;
                    return View.MeasureSpec.makeMeasureSpec(max, i7);
                }
            } else if (i4 < 0) {
                if (i4 == -1) {
                    i7 = i2;
                } else {
                    if (i4 == -2) {
                        if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                            i7 = Integer.MIN_VALUE;
                        }
                    }
                    max = 0;
                }
                return View.MeasureSpec.makeMeasureSpec(max, i7);
            }
            max = i4;
            i7 = 1073741824;
            return View.MeasureSpec.makeMeasureSpec(max, i7);
        }

        public int f(View view) {
            Rect rect = ((i) view.getLayoutParams()).d;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int g(View view) {
            Rect rect = ((i) view.getLayoutParams()).d;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            i iVar = (i) view.getLayoutParams();
            Rect rect = iVar.d;
            view.layout(i + rect.left + iVar.leftMargin, i2 + rect.top + iVar.topMargin, (i3 - rect.right) - iVar.rightMargin, (i4 - rect.bottom) - iVar.bottomMargin);
        }

        public void a(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((i) view.getLayoutParams()).d;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.q == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.q.k;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void a(View view, Rect rect) {
            RecyclerView.a(view, rect);
        }

        public int h(View view) {
            return view.getLeft() - n(view);
        }

        public int i(View view) {
            return view.getTop() - l(view);
        }

        public int j(View view) {
            return view.getRight() + o(view);
        }

        public int k(View view) {
            return view.getBottom() + m(view);
        }

        public void b(View view, Rect rect) {
            if (this.q == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.q.j(view));
            }
        }

        public int l(View view) {
            return ((i) view.getLayoutParams()).d.top;
        }

        public int m(View view) {
            return ((i) view.getLayoutParams()).d.bottom;
        }

        public int n(View view) {
            return ((i) view.getLayoutParams()).d.left;
        }

        public int o(View view) {
            return ((i) view.getLayoutParams()).d.right;
        }

        private int[] b(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int z2 = z();
            int A = A();
            int x2 = x() - B();
            int y2 = y() - C();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i = left - z2;
            int min = Math.min(0, i);
            int i2 = top - A;
            int min2 = Math.min(0, i2);
            int i3 = width - x2;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height - y2);
            if (s() != 1) {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return a(recyclerView, view, rect, z, false);
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] b2 = b(recyclerView, view, rect, z);
            int i = b2[0];
            int i2 = b2[1];
            if ((z2 && !d(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.a(i, i2);
            }
            return true;
        }

        public boolean a(View view, boolean z, boolean z2) {
            boolean z3 = this.r.a(view, 24579) && this.s.a(view, 24579);
            return z ? z3 : !z3;
        }

        private boolean d(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int z = z();
            int A = A();
            int x2 = x() - B();
            int y2 = y() - C();
            Rect rect = this.q.j;
            a(focusedChild, rect);
            if (rect.left - i >= x2 || rect.right - i <= z || rect.top - i2 >= y2 || rect.bottom - i2 <= A) {
                return false;
            }
            return true;
        }

        @Deprecated
        public boolean a(RecyclerView recyclerView, View view, View view2) {
            return r() || recyclerView.o();
        }

        public boolean a(RecyclerView recyclerView, t tVar, View view, View view2) {
            return a(recyclerView, view, view2);
        }

        public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
            c(recyclerView, i, i2);
        }

        public void a(o oVar, t tVar, int i, int i2) {
            this.q.e(i, i2);
        }

        public void g(int i, int i2) {
            this.q.setMeasuredDimension(i, i2);
        }

        public int E() {
            return android.support.v4.view.l.f(this.q);
        }

        public int F() {
            return android.support.v4.view.l.g(this.q);
        }

        /* access modifiers changed from: package-private */
        public void G() {
            if (this.t != null) {
                this.t.a();
            }
        }

        /* access modifiers changed from: private */
        public void a(s sVar) {
            if (this.t == sVar) {
                this.t = null;
            }
        }

        public void c(o oVar) {
            for (int u2 = u() - 1; u2 >= 0; u2--) {
                if (!RecyclerView.e(h(u2)).c()) {
                    a(u2, oVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(android.support.v4.view.a.b bVar) {
            a(this.q.d, this.q.B, bVar);
        }

        public void a(o oVar, t tVar, android.support.v4.view.a.b bVar) {
            if (this.q.canScrollVertically(-1) || this.q.canScrollHorizontally(-1)) {
                bVar.a(8192);
                bVar.a(true);
            }
            if (this.q.canScrollVertically(1) || this.q.canScrollHorizontally(1)) {
                bVar.a(4096);
                bVar.a(true);
            }
            bVar.a((Object) b.j.a(a(oVar, tVar), b(oVar, tVar), e(oVar, tVar), d(oVar, tVar)));
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            a(this.q.d, this.q.B, accessibilityEvent);
        }

        public void a(o oVar, t tVar, AccessibilityEvent accessibilityEvent) {
            if (this.q != null && accessibilityEvent != null) {
                boolean z = true;
                if (!this.q.canScrollVertically(1) && !this.q.canScrollVertically(-1) && !this.q.canScrollHorizontally(-1) && !this.q.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                if (this.q.l != null) {
                    accessibilityEvent.setItemCount(this.q.l.a());
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(View view, android.support.v4.view.a.b bVar) {
            w e2 = RecyclerView.e(view);
            if (e2 != null && !e2.q() && !this.p.c(e2.f413a)) {
                a(this.q.d, this.q.B, view, bVar);
            }
        }

        public void a(o oVar, t tVar, View view, android.support.v4.view.a.b bVar) {
            bVar.b((Object) b.k.a(e() ? d(view) : 0, 1, d() ? d(view) : 0, 1, false, false));
        }

        public void H() {
            this.u = true;
        }

        public int a(o oVar, t tVar) {
            if (this.q == null || this.q.l == null || !e()) {
                return 1;
            }
            return this.q.l.a();
        }

        public int b(o oVar, t tVar) {
            if (this.q == null || this.q.l == null || !d()) {
                return 1;
            }
            return this.q.l.a();
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i, Bundle bundle) {
            return a(this.q.d, this.q.B, i, bundle);
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0074 A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(android.support.v7.widget.RecyclerView.o r2, android.support.v7.widget.RecyclerView.t r3, int r4, android.os.Bundle r5) {
            /*
                r1 = this;
                android.support.v7.widget.RecyclerView r2 = r1.q
                r3 = 0
                if (r2 != 0) goto L_0x0006
                return r3
            L_0x0006:
                r2 = 4096(0x1000, float:5.74E-42)
                r5 = 1
                if (r4 == r2) goto L_0x0044
                r2 = 8192(0x2000, float:1.14794E-41)
                if (r4 == r2) goto L_0x0012
                r2 = 0
            L_0x0010:
                r4 = 0
                goto L_0x0072
            L_0x0012:
                android.support.v7.widget.RecyclerView r2 = r1.q
                r4 = -1
                boolean r2 = r2.canScrollVertically(r4)
                if (r2 == 0) goto L_0x002b
                int r2 = r1.y()
                int r0 = r1.A()
                int r2 = r2 - r0
                int r0 = r1.C()
                int r2 = r2 - r0
                int r2 = -r2
                goto L_0x002c
            L_0x002b:
                r2 = 0
            L_0x002c:
                android.support.v7.widget.RecyclerView r0 = r1.q
                boolean r4 = r0.canScrollHorizontally(r4)
                if (r4 == 0) goto L_0x0010
                int r4 = r1.x()
                int r0 = r1.z()
                int r4 = r4 - r0
                int r0 = r1.B()
                int r4 = r4 - r0
                int r4 = -r4
                goto L_0x0072
            L_0x0044:
                android.support.v7.widget.RecyclerView r2 = r1.q
                boolean r2 = r2.canScrollVertically(r5)
                if (r2 == 0) goto L_0x005b
                int r2 = r1.y()
                int r4 = r1.A()
                int r2 = r2 - r4
                int r4 = r1.C()
                int r2 = r2 - r4
                goto L_0x005c
            L_0x005b:
                r2 = 0
            L_0x005c:
                android.support.v7.widget.RecyclerView r4 = r1.q
                boolean r4 = r4.canScrollHorizontally(r5)
                if (r4 == 0) goto L_0x0010
                int r4 = r1.x()
                int r0 = r1.z()
                int r4 = r4 - r0
                int r0 = r1.B()
                int r4 = r4 - r0
            L_0x0072:
                if (r2 != 0) goto L_0x0077
                if (r4 != 0) goto L_0x0077
                return r3
            L_0x0077:
                android.support.v7.widget.RecyclerView r3 = r1.q
                r3.scrollBy(r4, r2)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.h.a(android.support.v7.widget.RecyclerView$o, android.support.v7.widget.RecyclerView$t, int, android.os.Bundle):boolean");
        }

        /* access modifiers changed from: package-private */
        public boolean a(View view, int i, Bundle bundle) {
            return a(this.q.d, this.q.B, view, i, bundle);
        }

        public static b a(Context context, AttributeSet attributeSet, int i, int i2) {
            b bVar = new b();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.RecyclerView, i, i2);
            bVar.f395a = obtainStyledAttributes.getInt(a.b.RecyclerView_android_orientation, 1);
            bVar.f396b = obtainStyledAttributes.getInt(a.b.RecyclerView_spanCount, 1);
            bVar.c = obtainStyledAttributes.getBoolean(a.b.RecyclerView_reverseLayout, false);
            bVar.d = obtainStyledAttributes.getBoolean(a.b.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return bVar;
        }

        /* access modifiers changed from: package-private */
        public void f(RecyclerView recyclerView) {
            d(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        /* access modifiers changed from: package-private */
        public boolean I() {
            int u2 = u();
            for (int i = 0; i < u2; i++) {
                ViewGroup.LayoutParams layoutParams = h(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public static abstract class g {
        @Deprecated
        public void a(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        public void b(Canvas canvas, RecyclerView recyclerView) {
        }

        public void b(Canvas canvas, RecyclerView recyclerView, t tVar) {
            a(canvas, recyclerView);
        }

        public void a(Canvas canvas, RecyclerView recyclerView, t tVar) {
            b(canvas, recyclerView);
        }

        @Deprecated
        public void a(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void a(Rect rect, View view, RecyclerView recyclerView, t tVar) {
            a(rect, ((i) view.getLayoutParams()).f(), recyclerView);
        }
    }

    public static abstract class w {
        private static final List<Object> o = Collections.EMPTY_LIST;

        /* renamed from: a  reason: collision with root package name */
        public final View f413a;

        /* renamed from: b  reason: collision with root package name */
        WeakReference<RecyclerView> f414b;
        int c = -1;
        int d = -1;
        long e = -1;
        int f = -1;
        int g = -1;
        w h = null;
        w i = null;
        List<Object> j = null;
        List<Object> k = null;
        int l = -1;
        RecyclerView m;
        /* access modifiers changed from: private */
        public int n;
        private int p = 0;
        /* access modifiers changed from: private */
        public o q = null;
        /* access modifiers changed from: private */
        public boolean r = false;
        private int s = 0;

        public w(View view) {
            if (view != null) {
                this.f413a = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3, boolean z) {
            b(8);
            a(i3, z);
            this.c = i2;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, boolean z) {
            if (this.d == -1) {
                this.d = this.c;
            }
            if (this.g == -1) {
                this.g = this.c;
            }
            if (z) {
                this.g += i2;
            }
            this.c += i2;
            if (this.f413a.getLayoutParams() != null) {
                ((i) this.f413a.getLayoutParams()).e = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.d = -1;
            this.g = -1;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (this.d == -1) {
                this.d = this.c;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            return (this.n & 128) != 0;
        }

        public final int d() {
            return this.g == -1 ? this.c : this.g;
        }

        public final int e() {
            if (this.m == null) {
                return -1;
            }
            return this.m.d(this);
        }

        public final int f() {
            return this.d;
        }

        public final long g() {
            return this.e;
        }

        public final int h() {
            return this.f;
        }

        /* access modifiers changed from: package-private */
        public boolean i() {
            return this.q != null;
        }

        /* access modifiers changed from: package-private */
        public void j() {
            this.q.c(this);
        }

        /* access modifiers changed from: package-private */
        public boolean k() {
            return (this.n & 32) != 0;
        }

        /* access modifiers changed from: package-private */
        public void l() {
            this.n &= -33;
        }

        /* access modifiers changed from: package-private */
        public void m() {
            this.n &= -257;
        }

        /* access modifiers changed from: package-private */
        public void a(o oVar, boolean z) {
            this.q = oVar;
            this.r = z;
        }

        /* access modifiers changed from: package-private */
        public boolean n() {
            return (this.n & 4) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean o() {
            return (this.n & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean p() {
            return (this.n & 1) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean q() {
            return (this.n & 8) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i2) {
            return (i2 & this.n) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean r() {
            return (this.n & 256) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean s() {
            return (this.n & 512) != 0 || n();
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3) {
            this.n = (i2 & i3) | (this.n & (i3 ^ -1));
        }

        /* access modifiers changed from: package-private */
        public void b(int i2) {
            this.n = i2 | this.n;
        }

        /* access modifiers changed from: package-private */
        public void a(Object obj) {
            if (obj == null) {
                b((int) FXUtil.MAX_CUSTOM_FACE_IMAGE_SIZE);
            } else if ((1024 & this.n) == 0) {
                y();
                this.j.add(obj);
            }
        }

        private void y() {
            if (this.j == null) {
                this.j = new ArrayList();
                this.k = Collections.unmodifiableList(this.j);
            }
        }

        /* access modifiers changed from: package-private */
        public void t() {
            if (this.j != null) {
                this.j.clear();
            }
            this.n &= -1025;
        }

        /* access modifiers changed from: package-private */
        public List<Object> u() {
            if ((this.n & FXUtil.MAX_CUSTOM_FACE_IMAGE_SIZE) != 0) {
                return o;
            }
            if (this.j == null || this.j.size() == 0) {
                return o;
            }
            return this.k;
        }

        /* access modifiers changed from: package-private */
        public void v() {
            this.n = 0;
            this.c = -1;
            this.d = -1;
            this.e = -1;
            this.g = -1;
            this.p = 0;
            this.h = null;
            this.i = null;
            t();
            this.s = 0;
            this.l = -1;
            RecyclerView.c(this);
        }

        /* access modifiers changed from: private */
        public void a(RecyclerView recyclerView) {
            this.s = android.support.v4.view.l.d(this.f413a);
            recyclerView.a(this, 4);
        }

        /* access modifiers changed from: private */
        public void b(RecyclerView recyclerView) {
            recyclerView.a(this, this.s);
            this.s = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.c + " id=" + this.e + ", oldPos=" + this.d + ", pLpos:" + this.g);
            if (i()) {
                sb.append(" scrap ");
                sb.append(this.r ? "[changeScrap]" : "[attachedScrap]");
            }
            if (n()) {
                sb.append(" invalid");
            }
            if (!p()) {
                sb.append(" unbound");
            }
            if (o()) {
                sb.append(" update");
            }
            if (q()) {
                sb.append(" removed");
            }
            if (c()) {
                sb.append(" ignored");
            }
            if (r()) {
                sb.append(" tmpDetached");
            }
            if (!w()) {
                sb.append(" not recyclable(" + this.p + ")");
            }
            if (s()) {
                sb.append(" undefined adapter position");
            }
            if (this.f413a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final void a(boolean z) {
            this.p = z ? this.p - 1 : this.p + 1;
            if (this.p < 0) {
                this.p = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && this.p == 1) {
                this.n |= 16;
            } else if (z && this.p == 0) {
                this.n &= -17;
            }
        }

        public final boolean w() {
            return (this.n & 16) == 0 && !android.support.v4.view.l.b(this.f413a);
        }

        /* access modifiers changed from: private */
        public boolean z() {
            return (this.n & 16) != 0;
        }

        /* access modifiers changed from: private */
        public boolean A() {
            return (this.n & 16) == 0 && android.support.v4.view.l.b(this.f413a);
        }

        /* access modifiers changed from: package-private */
        public boolean x() {
            return (this.n & 2) != 0;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(w wVar, int i2) {
        if (o()) {
            wVar.l = i2;
            this.G.add(wVar);
            return false;
        }
        android.support.v4.view.l.a(wVar.f413a, i2);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void y() {
        int i2;
        for (int size = this.G.size() - 1; size >= 0; size--) {
            w wVar = this.G.get(size);
            if (wVar.f413a.getParent() == this && !wVar.c() && (i2 = wVar.l) != -1) {
                android.support.v4.view.l.a(wVar.f413a, i2);
                wVar.l = -1;
            }
        }
        this.G.clear();
    }

    /* access modifiers changed from: package-private */
    public int d(w wVar) {
        if (wVar.a(524) || !wVar.p()) {
            return -1;
        }
        return this.e.c(wVar.c);
    }

    /* access modifiers changed from: package-private */
    public void a(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + a());
        }
        Resources resources = getContext().getResources();
        new d(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(a.C0019a.fastscroll_default_thickness), resources.getDimensionPixelSize(a.C0019a.fastscroll_minimum_range), resources.getDimensionPixelOffset(a.C0019a.fastscroll_margin));
    }

    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().a(z2);
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().a();
    }

    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().b(i2);
    }

    public boolean j(int i2, int i3) {
        return getScrollingChildHelper().a(i2, i3);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().c();
    }

    public void g(int i2) {
        getScrollingChildHelper().c(i2);
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().b();
    }

    public boolean h(int i2) {
        return getScrollingChildHelper().a(i2);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr);
    }

    public boolean a(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr, i6);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2);
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2, i4);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().a(f2, f3);
    }

    public static class i extends ViewGroup.MarginLayoutParams {
        w c;
        final Rect d = new Rect();
        boolean e = true;
        boolean f = false;

        public i(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public i(int i, int i2) {
            super(i, i2);
        }

        public i(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public i(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public i(i iVar) {
            super(iVar);
        }

        public boolean c() {
            return this.c.n();
        }

        public boolean d() {
            return this.c.q();
        }

        public boolean e() {
            return this.c.x();
        }

        public int f() {
            return this.c.d();
        }
    }

    public static abstract class c {
        public void a() {
        }

        public void a(int i, int i2) {
        }

        public void a(int i, int i2, Object obj) {
            a(i, i2);
        }
    }

    public static abstract class s {

        /* renamed from: a  reason: collision with root package name */
        private int f405a;

        /* renamed from: b  reason: collision with root package name */
        private RecyclerView f406b;
        private h c;
        private boolean d;
        private boolean e;
        private View f;
        private final a g;

        /* access modifiers changed from: protected */
        public abstract void a(int i, int i2, t tVar, a aVar);

        /* access modifiers changed from: protected */
        public abstract void a(View view, t tVar, a aVar);

        /* access modifiers changed from: protected */
        public abstract void e();

        public void a(int i) {
            this.f405a = i;
        }

        /* access modifiers changed from: protected */
        public final void a() {
            if (this.e) {
                e();
                int unused = this.f406b.B.p = -1;
                this.f = null;
                this.f405a = -1;
                this.d = false;
                this.e = false;
                this.c.a(this);
                this.c = null;
                this.f406b = null;
            }
        }

        public boolean b() {
            return this.d;
        }

        public boolean c() {
            return this.e;
        }

        public int d() {
            return this.f405a;
        }

        /* access modifiers changed from: private */
        public void a(int i, int i2) {
            RecyclerView recyclerView = this.f406b;
            if (!this.e || this.f405a == -1 || recyclerView == null) {
                a();
            }
            this.d = false;
            if (this.f != null) {
                if (a(this.f) == this.f405a) {
                    a(this.f, recyclerView.B, this.g);
                    this.g.a(recyclerView);
                    a();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f = null;
                }
            }
            if (this.e) {
                a(i, i2, recyclerView.B, this.g);
                boolean a2 = this.g.a();
                this.g.a(recyclerView);
                if (!a2) {
                    return;
                }
                if (this.e) {
                    this.d = true;
                    recyclerView.y.a();
                    return;
                }
                a();
            }
        }

        public int a(View view) {
            return this.f406b.g(view);
        }

        /* access modifiers changed from: protected */
        public void b(View view) {
            if (a(view) == d()) {
                this.f = view;
            }
        }

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            private int f407a;

            /* renamed from: b  reason: collision with root package name */
            private int f408b;
            private int c;
            private int d;
            private Interpolator e;
            private boolean f;
            private int g;

            /* access modifiers changed from: package-private */
            public boolean a() {
                return this.d >= 0;
            }

            /* access modifiers changed from: package-private */
            public void a(RecyclerView recyclerView) {
                if (this.d >= 0) {
                    int i = this.d;
                    this.d = -1;
                    recyclerView.a(i);
                    this.f = false;
                } else if (this.f) {
                    b();
                    if (this.e != null) {
                        recyclerView.y.a(this.f407a, this.f408b, this.c, this.e);
                    } else if (this.c == Integer.MIN_VALUE) {
                        recyclerView.y.b(this.f407a, this.f408b);
                    } else {
                        recyclerView.y.a(this.f407a, this.f408b, this.c);
                    }
                    this.g++;
                    if (this.g > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f = false;
                } else {
                    this.g = 0;
                }
            }

            private void b() {
                if (this.e != null && this.c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }
        }
    }

    static class b extends Observable<c> {
        b() {
        }

        public void a() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).a();
            }
        }

        public void a(int i, int i2) {
            a(i, i2, (Object) null);
        }

        public void a(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).a(i, i2, obj);
            }
        }
    }

    public static class r extends android.support.v4.view.a {
        public static final Parcelable.Creator<r> CREATOR = new Parcelable.ClassLoaderCreator<r>() {
            /* renamed from: a */
            public r createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new r(parcel, classLoader);
            }

            /* renamed from: a */
            public r createFromParcel(Parcel parcel) {
                return new r(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public r[] newArray(int i) {
                return new r[i];
            }
        };

        /* renamed from: b  reason: collision with root package name */
        Parcelable f404b;

        r(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f404b = parcel.readParcelable(classLoader == null ? h.class.getClassLoader() : classLoader);
        }

        r(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f404b, 0);
        }

        /* access modifiers changed from: package-private */
        public void a(r rVar) {
            this.f404b = rVar.f404b;
        }
    }

    public static class t {

        /* renamed from: a  reason: collision with root package name */
        int f409a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f410b = 0;
        int c = 1;
        int d = 0;
        boolean e = false;
        boolean f = false;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        int k;
        long l;
        int m;
        int n;
        int o;
        /* access modifiers changed from: private */
        public int p = -1;
        private SparseArray<Object> q;

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            if ((this.c & i2) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i2) + " but it is " + Integer.toBinaryString(this.c));
            }
        }

        /* access modifiers changed from: package-private */
        public void a(a aVar) {
            this.c = 1;
            this.d = aVar.a();
            this.f = false;
            this.g = false;
            this.h = false;
        }

        public boolean a() {
            return this.f;
        }

        public boolean b() {
            return this.j;
        }

        public int c() {
            return this.p;
        }

        public boolean d() {
            return this.p != -1;
        }

        public int e() {
            return this.f ? this.f409a - this.f410b : this.d;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.p + ", mData=" + this.q + ", mItemCount=" + this.d + ", mPreviousLayoutItemCount=" + this.f409a + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f410b + ", mStructureChanged=" + this.e + ", mInPreLayout=" + this.f + ", mRunSimpleAnimations=" + this.i + ", mRunPredictiveAnimations=" + this.j + '}';
        }
    }

    private class f implements e.b {
        f() {
        }

        public void a(w wVar) {
            wVar.a(true);
            if (wVar.h != null && wVar.i == null) {
                wVar.h = null;
            }
            wVar.i = null;
            if (!wVar.z() && !RecyclerView.this.a(wVar.f413a) && wVar.r()) {
                RecyclerView.this.removeDetachedView(wVar.f413a, false);
            }
        }
    }

    public static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        private b f386a = null;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<a> f387b = new ArrayList<>();
        private long c = 120;
        private long d = 120;
        private long e = 250;
        private long f = 250;

        public interface a {
            void a();
        }

        interface b {
            void a(w wVar);
        }

        public abstract void a();

        public abstract boolean a(w wVar, c cVar, c cVar2);

        public abstract boolean a(w wVar, w wVar2, c cVar, c cVar2);

        public abstract boolean b();

        public abstract boolean b(w wVar, c cVar, c cVar2);

        public abstract boolean c(w wVar, c cVar, c cVar2);

        public abstract void d();

        public abstract void d(w wVar);

        public void g(w wVar) {
        }

        public boolean h(w wVar) {
            return true;
        }

        public long e() {
            return this.e;
        }

        public long f() {
            return this.c;
        }

        public long g() {
            return this.d;
        }

        public long h() {
            return this.f;
        }

        /* access modifiers changed from: package-private */
        public void a(b bVar) {
            this.f386a = bVar;
        }

        public c a(t tVar, w wVar, int i, List<Object> list) {
            return j().a(wVar);
        }

        public c a(t tVar, w wVar) {
            return j().a(wVar);
        }

        static int e(w wVar) {
            int d2 = wVar.n & 14;
            if (wVar.n()) {
                return 4;
            }
            if ((d2 & 4) != 0) {
                return d2;
            }
            int f2 = wVar.f();
            int e2 = wVar.e();
            return (f2 == -1 || e2 == -1 || f2 == e2) ? d2 : d2 | 2048;
        }

        public final void f(w wVar) {
            g(wVar);
            if (this.f386a != null) {
                this.f386a.a(wVar);
            }
        }

        public boolean a(w wVar, List<Object> list) {
            return h(wVar);
        }

        public final void i() {
            int size = this.f387b.size();
            for (int i = 0; i < size; i++) {
                this.f387b.get(i).a();
            }
            this.f387b.clear();
        }

        public c j() {
            return new c();
        }

        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public int f388a;

            /* renamed from: b  reason: collision with root package name */
            public int f389b;
            public int c;
            public int d;

            public c a(w wVar) {
                return a(wVar, 0);
            }

            public c a(w wVar, int i) {
                View view = wVar.f413a;
                this.f388a = view.getLeft();
                this.f389b = view.getTop();
                this.c = view.getRight();
                this.d = view.getBottom();
                return this;
            }
        }
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        if (this.ay == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return this.ay.a(i2, i3);
    }

    private android.support.v4.view.f getScrollingChildHelper() {
        if (this.aA == null) {
            this.aA = new android.support.v4.view.f(this);
        }
        return this.aA;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\android\support\v7\widget\StaggeredGridLayoutManager.java ==========

package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.a.b;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import net.fxgear.GlobalDefine;

public class StaggeredGridLayoutManager extends RecyclerView.h {
    private d A;
    private int B;
    private final Rect C = new Rect();
    private final a D = new a();
    private boolean E = false;
    private boolean F;
    private int[] G;
    private final Runnable H;

    /* renamed from: a  reason: collision with root package name */
    e[] f415a;

    /* renamed from: b  reason: collision with root package name */
    h f416b;
    h c;
    boolean d = false;
    boolean e = false;
    int f = -1;
    int g = Integer.MIN_VALUE;
    c h = new c();
    private int i = -1;
    private int j;
    private int k;
    private final f l;
    private BitSet m;
    private int n = 2;
    private boolean o;
    private boolean z;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        boolean z2 = true;
        this.F = true;
        this.H = new Runnable() {
            public void run() {
                StaggeredGridLayoutManager.this.f();
            }
        };
        RecyclerView.h.b a2 = a(context, attributeSet, i2, i3);
        b(a2.f395a);
        a(a2.f396b);
        a(a2.c);
        c(this.n == 0 ? false : z2);
        this.l = new f();
        L();
    }

    public StaggeredGridLayoutManager(int i2, int i3) {
        boolean z2 = true;
        this.F = true;
        this.H = new Runnable() {
            public void run() {
                StaggeredGridLayoutManager.this.f();
            }
        };
        this.j = i3;
        a(i2);
        c(this.n == 0 ? false : z2);
        this.l = new f();
        L();
    }

    private void L() {
        this.f416b = h.a(this, this.j);
        this.c = h.a(this, 1 - this.j);
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        int i2;
        int i3;
        if (u() == 0 || this.n == 0 || !p()) {
            return false;
        }
        if (this.e) {
            i3 = J();
            i2 = K();
        } else {
            i3 = K();
            i2 = J();
        }
        if (i3 == 0 && g() != null) {
            this.h.a();
            H();
            n();
            return true;
        } else if (!this.E) {
            return false;
        } else {
            int i4 = this.e ? -1 : 1;
            int i5 = i2 + 1;
            c.a a2 = this.h.a(i3, i5, i4, true);
            if (a2 == null) {
                this.E = false;
                this.h.a(i5);
                return false;
            }
            c.a a3 = this.h.a(i3, a2.f424a, i4 * -1, true);
            if (a3 == null) {
                this.h.a(a2.f424a);
            } else {
                this.h.a(a3.f424a + 1);
            }
            H();
            n();
            return true;
        }
    }

    public void k(int i2) {
        if (i2 == 0) {
            f();
        }
    }

    public void a(RecyclerView recyclerView, RecyclerView.o oVar) {
        a(this.H);
        for (int i2 = 0; i2 < this.i; i2++) {
            this.f415a[i2].e();
        }
        recyclerView.requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008a, code lost:
        r10 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View g() {
        /*
            r12 = this;
            int r0 = r12.u()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.i
            r2.<init>(r3)
            int r3 = r12.i
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.j
            r5 = -1
            if (r3 != r1) goto L_0x0020
            boolean r3 = r12.i()
            if (r3 == 0) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = -1
        L_0x0021:
            boolean r6 = r12.e
            if (r6 == 0) goto L_0x0027
            r6 = -1
            goto L_0x002b
        L_0x0027:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L_0x002b:
            if (r0 >= r6) goto L_0x002e
            r5 = 1
        L_0x002e:
            if (r0 == r6) goto L_0x00ab
            android.view.View r7 = r12.h((int) r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            android.support.v7.widget.StaggeredGridLayoutManager$b r8 = (android.support.v7.widget.StaggeredGridLayoutManager.b) r8
            android.support.v7.widget.StaggeredGridLayoutManager$e r9 = r8.f420a
            int r9 = r9.e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L_0x0054
            android.support.v7.widget.StaggeredGridLayoutManager$e r9 = r8.f420a
            boolean r9 = r12.a((android.support.v7.widget.StaggeredGridLayoutManager.e) r9)
            if (r9 == 0) goto L_0x004d
            return r7
        L_0x004d:
            android.support.v7.widget.StaggeredGridLayoutManager$e r9 = r8.f420a
            int r9 = r9.e
            r2.clear(r9)
        L_0x0054:
            boolean r9 = r8.f421b
            if (r9 == 0) goto L_0x0059
            goto L_0x00a9
        L_0x0059:
            int r9 = r0 + r5
            if (r9 == r6) goto L_0x00a9
            android.view.View r9 = r12.h((int) r9)
            boolean r10 = r12.e
            if (r10 == 0) goto L_0x0077
            android.support.v7.widget.h r10 = r12.f416b
            int r10 = r10.b((android.view.View) r7)
            android.support.v7.widget.h r11 = r12.f416b
            int r11 = r11.b((android.view.View) r9)
            if (r10 >= r11) goto L_0x0074
            return r7
        L_0x0074:
            if (r10 != r11) goto L_0x008a
            goto L_0x0088
        L_0x0077:
            android.support.v7.widget.h r10 = r12.f416b
            int r10 = r10.a((android.view.View) r7)
            android.support.v7.widget.h r11 = r12.f416b
            int r11 = r11.a((android.view.View) r9)
            if (r10 <= r11) goto L_0x0086
            return r7
        L_0x0086:
            if (r10 != r11) goto L_0x008a
        L_0x0088:
            r10 = 1
            goto L_0x008b
        L_0x008a:
            r10 = 0
        L_0x008b:
            if (r10 == 0) goto L_0x00a9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            android.support.v7.widget.StaggeredGridLayoutManager$b r9 = (android.support.v7.widget.StaggeredGridLayoutManager.b) r9
            android.support.v7.widget.StaggeredGridLayoutManager$e r8 = r8.f420a
            int r8 = r8.e
            android.support.v7.widget.StaggeredGridLayoutManager$e r9 = r9.f420a
            int r9 = r9.e
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x00a0
            r8 = 1
            goto L_0x00a1
        L_0x00a0:
            r8 = 0
        L_0x00a1:
            if (r3 >= 0) goto L_0x00a5
            r9 = 1
            goto L_0x00a6
        L_0x00a5:
            r9 = 0
        L_0x00a6:
            if (r8 == r9) goto L_0x00a9
            return r7
        L_0x00a9:
            int r0 = r0 + r5
            goto L_0x002e
        L_0x00ab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.g():android.view.View");
    }

    private boolean a(e eVar) {
        if (this.e) {
            if (eVar.d() < this.f416b.d()) {
                return !eVar.c(eVar.f428a.get(eVar.f428a.size() - 1)).f421b;
            }
        } else if (eVar.b() > this.f416b.c()) {
            return !eVar.c(eVar.f428a.get(0)).f421b;
        }
        return false;
    }

    public void a(int i2) {
        a((String) null);
        if (i2 != this.i) {
            h();
            this.i = i2;
            this.m = new BitSet(this.i);
            this.f415a = new e[this.i];
            for (int i3 = 0; i3 < this.i; i3++) {
                this.f415a[i3] = new e(i3);
            }
            n();
        }
    }

    public void b(int i2) {
        if (i2 == 0 || i2 == 1) {
            a((String) null);
            if (i2 != this.j) {
                this.j = i2;
                h hVar = this.f416b;
                this.f416b = this.c;
                this.c = hVar;
                n();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void a(boolean z2) {
        a((String) null);
        if (!(this.A == null || this.A.h == z2)) {
            this.A.h = z2;
        }
        this.d = z2;
        n();
    }

    public void a(String str) {
        if (this.A == null) {
            super.a(str);
        }
    }

    public void h() {
        this.h.a();
        n();
    }

    private void M() {
        if (this.j == 1 || !i()) {
            this.e = this.d;
        } else {
            this.e = !this.d;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return s() == 1;
    }

    public void a(Rect rect, int i2, int i3) {
        int i4;
        int i5;
        int z2 = z() + B();
        int A2 = A() + C();
        if (this.j == 1) {
            i5 = a(i3, rect.height() + A2, F());
            i4 = a(i2, (this.k * this.i) + z2, E());
        } else {
            i4 = a(i2, rect.width() + z2, E());
            i5 = a(i3, (this.k * this.i) + A2, F());
        }
        g(i4, i5);
    }

    public void c(RecyclerView.o oVar, RecyclerView.t tVar) {
        a(oVar, tVar, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0163, code lost:
        if (f() != false) goto L_0x0167;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.support.v7.widget.RecyclerView.o r9, android.support.v7.widget.RecyclerView.t r10, boolean r11) {
        /*
            r8 = this;
            android.support.v7.widget.StaggeredGridLayoutManager$a r0 = r8.D
            android.support.v7.widget.StaggeredGridLayoutManager$d r1 = r8.A
            r2 = -1
            if (r1 != 0) goto L_0x000b
            int r1 = r8.f
            if (r1 == r2) goto L_0x0018
        L_0x000b:
            int r1 = r10.e()
            if (r1 != 0) goto L_0x0018
            r8.c((android.support.v7.widget.RecyclerView.o) r9)
            r0.a()
            return
        L_0x0018:
            boolean r1 = r0.e
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0029
            int r1 = r8.f
            if (r1 != r2) goto L_0x0029
            android.support.v7.widget.StaggeredGridLayoutManager$d r1 = r8.A
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = 0
            goto L_0x002a
        L_0x0029:
            r1 = 1
        L_0x002a:
            if (r1 == 0) goto L_0x0043
            r0.a()
            android.support.v7.widget.StaggeredGridLayoutManager$d r5 = r8.A
            if (r5 == 0) goto L_0x0037
            r8.a((android.support.v7.widget.StaggeredGridLayoutManager.a) r0)
            goto L_0x003e
        L_0x0037:
            r8.M()
            boolean r5 = r8.e
            r0.c = r5
        L_0x003e:
            r8.a((android.support.v7.widget.RecyclerView.t) r10, (android.support.v7.widget.StaggeredGridLayoutManager.a) r0)
            r0.e = r4
        L_0x0043:
            android.support.v7.widget.StaggeredGridLayoutManager$d r5 = r8.A
            if (r5 != 0) goto L_0x0060
            int r5 = r8.f
            if (r5 != r2) goto L_0x0060
            boolean r5 = r0.c
            boolean r6 = r8.o
            if (r5 != r6) goto L_0x0059
            boolean r5 = r8.i()
            boolean r6 = r8.z
            if (r5 == r6) goto L_0x0060
        L_0x0059:
            android.support.v7.widget.StaggeredGridLayoutManager$c r5 = r8.h
            r5.a()
            r0.d = r4
        L_0x0060:
            int r5 = r8.u()
            if (r5 <= 0) goto L_0x00cd
            android.support.v7.widget.StaggeredGridLayoutManager$d r5 = r8.A
            if (r5 == 0) goto L_0x0070
            android.support.v7.widget.StaggeredGridLayoutManager$d r5 = r8.A
            int r5 = r5.c
            if (r5 >= r4) goto L_0x00cd
        L_0x0070:
            boolean r5 = r0.d
            if (r5 == 0) goto L_0x0092
            r1 = 0
        L_0x0075:
            int r5 = r8.i
            if (r1 >= r5) goto L_0x00cd
            android.support.v7.widget.StaggeredGridLayoutManager$e[] r5 = r8.f415a
            r5 = r5[r1]
            r5.e()
            int r5 = r0.f419b
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x008f
            android.support.v7.widget.StaggeredGridLayoutManager$e[] r5 = r8.f415a
            r5 = r5[r1]
            int r6 = r0.f419b
            r5.c((int) r6)
        L_0x008f:
            int r1 = r1 + 1
            goto L_0x0075
        L_0x0092:
            if (r1 != 0) goto L_0x00b3
            android.support.v7.widget.StaggeredGridLayoutManager$a r1 = r8.D
            int[] r1 = r1.f
            if (r1 != 0) goto L_0x009b
            goto L_0x00b3
        L_0x009b:
            r1 = 0
        L_0x009c:
            int r5 = r8.i
            if (r1 >= r5) goto L_0x00cd
            android.support.v7.widget.StaggeredGridLayoutManager$e[] r5 = r8.f415a
            r5 = r5[r1]
            r5.e()
            android.support.v7.widget.StaggeredGridLayoutManager$a r6 = r8.D
            int[] r6 = r6.f
            r6 = r6[r1]
            r5.c((int) r6)
            int r1 = r1 + 1
            goto L_0x009c
        L_0x00b3:
            r1 = 0
        L_0x00b4:
            int r5 = r8.i
            if (r1 >= r5) goto L_0x00c6
            android.support.v7.widget.StaggeredGridLayoutManager$e[] r5 = r8.f415a
            r5 = r5[r1]
            boolean r6 = r8.e
            int r7 = r0.f419b
            r5.a((boolean) r6, (int) r7)
            int r1 = r1 + 1
            goto L_0x00b4
        L_0x00c6:
            android.support.v7.widget.StaggeredGridLayoutManager$a r1 = r8.D
            android.support.v7.widget.StaggeredGridLayoutManager$e[] r5 = r8.f415a
            r1.a((android.support.v7.widget.StaggeredGridLayoutManager.e[]) r5)
        L_0x00cd:
            r8.a((android.support.v7.widget.RecyclerView.o) r9)
            android.support.v7.widget.f r1 = r8.l
            r1.f473a = r3
            r8.E = r3
            android.support.v7.widget.h r1 = r8.c
            int r1 = r1.f()
            r8.e((int) r1)
            int r1 = r0.f418a
            r8.b((int) r1, (android.support.v7.widget.RecyclerView.t) r10)
            boolean r1 = r0.c
            if (r1 == 0) goto L_0x0104
            r8.l(r2)
            android.support.v7.widget.f r1 = r8.l
            r8.a((android.support.v7.widget.RecyclerView.o) r9, (android.support.v7.widget.f) r1, (android.support.v7.widget.RecyclerView.t) r10)
            r8.l(r4)
            android.support.v7.widget.f r1 = r8.l
            int r2 = r0.f418a
            android.support.v7.widget.f r5 = r8.l
            int r5 = r5.d
            int r2 = r2 + r5
            r1.c = r2
            android.support.v7.widget.f r1 = r8.l
            r8.a((android.support.v7.widget.RecyclerView.o) r9, (android.support.v7.widget.f) r1, (android.support.v7.widget.RecyclerView.t) r10)
            goto L_0x011f
        L_0x0104:
            r8.l(r4)
            android.support.v7.widget.f r1 = r8.l
            r8.a((android.support.v7.widget.RecyclerView.o) r9, (android.support.v7.widget.f) r1, (android.support.v7.widget.RecyclerView.t) r10)
            r8.l(r2)
            android.support.v7.widget.f r1 = r8.l
            int r2 = r0.f418a
            android.support.v7.widget.f r5 = r8.l
            int r5 = r5.d
            int r2 = r2 + r5
            r1.c = r2
            android.support.v7.widget.f r1 = r8.l
            r8.a((android.support.v7.widget.RecyclerView.o) r9, (android.support.v7.widget.f) r1, (android.support.v7.widget.RecyclerView.t) r10)
        L_0x011f:
            r8.N()
            int r1 = r8.u()
            if (r1 <= 0) goto L_0x0139
            boolean r1 = r8.e
            if (r1 == 0) goto L_0x0133
            r8.b((android.support.v7.widget.RecyclerView.o) r9, (android.support.v7.widget.RecyclerView.t) r10, (boolean) r4)
            r8.c((android.support.v7.widget.RecyclerView.o) r9, (android.support.v7.widget.RecyclerView.t) r10, (boolean) r3)
            goto L_0x0139
        L_0x0133:
            r8.c((android.support.v7.widget.RecyclerView.o) r9, (android.support.v7.widget.RecyclerView.t) r10, (boolean) r4)
            r8.b((android.support.v7.widget.RecyclerView.o) r9, (android.support.v7.widget.RecyclerView.t) r10, (boolean) r3)
        L_0x0139:
            if (r11 == 0) goto L_0x0166
            boolean r11 = r10.a()
            if (r11 != 0) goto L_0x0166
            int r11 = r8.n
            if (r11 == 0) goto L_0x0157
            int r11 = r8.u()
            if (r11 <= 0) goto L_0x0157
            boolean r11 = r8.E
            if (r11 != 0) goto L_0x0155
            android.view.View r11 = r8.g()
            if (r11 == 0) goto L_0x0157
        L_0x0155:
            r11 = 1
            goto L_0x0158
        L_0x0157:
            r11 = 0
        L_0x0158:
            if (r11 == 0) goto L_0x0166
            java.lang.Runnable r11 = r8.H
            r8.a((java.lang.Runnable) r11)
            boolean r11 = r8.f()
            if (r11 == 0) goto L_0x0166
            goto L_0x0167
        L_0x0166:
            r4 = 0
        L_0x0167:
            boolean r11 = r10.a()
            if (r11 == 0) goto L_0x0172
            android.support.v7.widget.StaggeredGridLayoutManager$a r11 = r8.D
            r11.a()
        L_0x0172:
            boolean r11 = r0.c
            r8.o = r11
            boolean r11 = r8.i()
            r8.z = r11
            if (r4 == 0) goto L_0x0186
            android.support.v7.widget.StaggeredGridLayoutManager$a r11 = r8.D
            r11.a()
            r8.a((android.support.v7.widget.RecyclerView.o) r9, (android.support.v7.widget.RecyclerView.t) r10, (boolean) r3)
        L_0x0186:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.a(android.support.v7.widget.RecyclerView$o, android.support.v7.widget.RecyclerView$t, boolean):void");
    }

    public void a(RecyclerView.t tVar) {
        super.a(tVar);
        this.f = -1;
        this.g = Integer.MIN_VALUE;
        this.A = null;
        this.D.a();
    }

    private void N() {
        if (this.c.h() != 1073741824) {
            int u = u();
            float f2 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            for (int i2 = 0; i2 < u; i2++) {
                View h2 = h(i2);
                float e2 = (float) this.c.e(h2);
                if (e2 >= f2) {
                    if (((b) h2.getLayoutParams()).a()) {
                        e2 = (e2 * 1.0f) / ((float) this.i);
                    }
                    f2 = Math.max(f2, e2);
                }
            }
            int i3 = this.k;
            int round = Math.round(f2 * ((float) this.i));
            if (this.c.h() == Integer.MIN_VALUE) {
                round = Math.min(round, this.c.f());
            }
            e(round);
            if (this.k != i3) {
                for (int i4 = 0; i4 < u; i4++) {
                    View h3 = h(i4);
                    b bVar = (b) h3.getLayoutParams();
                    if (!bVar.f421b) {
                        if (!i() || this.j != 1) {
                            int i5 = bVar.f420a.e * this.k;
                            int i6 = bVar.f420a.e * i3;
                            if (this.j == 1) {
                                h3.offsetLeftAndRight(i5 - i6);
                            } else {
                                h3.offsetTopAndBottom(i5 - i6);
                            }
                        } else {
                            h3.offsetLeftAndRight(((-((this.i - 1) - bVar.f420a.e)) * this.k) - ((-((this.i - 1) - bVar.f420a.e)) * i3));
                        }
                    }
                }
            }
        }
    }

    private void a(a aVar) {
        if (this.A.c > 0) {
            if (this.A.c == this.i) {
                for (int i2 = 0; i2 < this.i; i2++) {
                    this.f415a[i2].e();
                    int i3 = this.A.d[i2];
                    if (i3 != Integer.MIN_VALUE) {
                        if (this.A.i) {
                            i3 += this.f416b.d();
                        } else {
                            i3 += this.f416b.c();
                        }
                    }
                    this.f415a[i2].c(i3);
                }
            } else {
                this.A.a();
                this.A.f426a = this.A.f427b;
            }
        }
        this.z = this.A.j;
        a(this.A.h);
        M();
        if (this.A.f426a != -1) {
            this.f = this.A.f426a;
            aVar.c = this.A.i;
        } else {
            aVar.c = this.e;
        }
        if (this.A.e > 1) {
            this.h.f422a = this.A.f;
            this.h.f423b = this.A.g;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.t tVar, a aVar) {
        if (!b(tVar, aVar) && !c(tVar, aVar)) {
            aVar.b();
            aVar.f418a = 0;
        }
    }

    private boolean c(RecyclerView.t tVar, a aVar) {
        int i2;
        if (this.o) {
            i2 = v(tVar.e());
        } else {
            i2 = u(tVar.e());
        }
        aVar.f418a = i2;
        aVar.f419b = Integer.MIN_VALUE;
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean b(RecyclerView.t tVar, a aVar) {
        int i2;
        int i3;
        boolean z2 = false;
        if (tVar.a() || this.f == -1) {
            return false;
        }
        if (this.f < 0 || this.f >= tVar.e()) {
            this.f = -1;
            this.g = Integer.MIN_VALUE;
            return false;
        }
        if (this.A == null || this.A.f426a == -1 || this.A.c < 1) {
            View c2 = c(this.f);
            if (c2 != null) {
                if (this.e) {
                    i2 = J();
                } else {
                    i2 = K();
                }
                aVar.f418a = i2;
                if (this.g != Integer.MIN_VALUE) {
                    if (aVar.c) {
                        aVar.f419b = (this.f416b.d() - this.g) - this.f416b.b(c2);
                    } else {
                        aVar.f419b = (this.f416b.c() + this.g) - this.f416b.a(c2);
                    }
                    return true;
                } else if (this.f416b.e(c2) > this.f416b.f()) {
                    if (aVar.c) {
                        i3 = this.f416b.d();
                    } else {
                        i3 = this.f416b.c();
                    }
                    aVar.f419b = i3;
                    return true;
                } else {
                    int a2 = this.f416b.a(c2) - this.f416b.c();
                    if (a2 < 0) {
                        aVar.f419b = -a2;
                        return true;
                    }
                    int d2 = this.f416b.d() - this.f416b.b(c2);
                    if (d2 < 0) {
                        aVar.f419b = d2;
                        return true;
                    }
                    aVar.f419b = Integer.MIN_VALUE;
                }
            } else {
                aVar.f418a = this.f;
                if (this.g == Integer.MIN_VALUE) {
                    if (t(aVar.f418a) == 1) {
                        z2 = true;
                    }
                    aVar.c = z2;
                    aVar.b();
                } else {
                    aVar.a(this.g);
                }
                aVar.d = true;
            }
        } else {
            aVar.f419b = Integer.MIN_VALUE;
            aVar.f418a = this.f;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void e(int i2) {
        this.k = i2 / this.i;
        this.B = View.MeasureSpec.makeMeasureSpec(i2, this.c.h());
    }

    public boolean b() {
        return this.A == null;
    }

    public int c(RecyclerView.t tVar) {
        return b(tVar);
    }

    private int b(RecyclerView.t tVar) {
        if (u() == 0) {
            return 0;
        }
        return j.a(tVar, this.f416b, b(!this.F), d(!this.F), this, this.F, this.e);
    }

    public int d(RecyclerView.t tVar) {
        return b(tVar);
    }

    public int e(RecyclerView.t tVar) {
        return i(tVar);
    }

    private int i(RecyclerView.t tVar) {
        if (u() == 0) {
            return 0;
        }
        return j.a(tVar, this.f416b, b(!this.F), d(!this.F), this, this.F);
    }

    public int f(RecyclerView.t tVar) {
        return i(tVar);
    }

    public int g(RecyclerView.t tVar) {
        return j(tVar);
    }

    private int j(RecyclerView.t tVar) {
        if (u() == 0) {
            return 0;
        }
        return j.b(tVar, this.f416b, b(!this.F), d(!this.F), this, this.F);
    }

    public int h(RecyclerView.t tVar) {
        return j(tVar);
    }

    private void a(View view, b bVar, boolean z2) {
        if (bVar.f421b) {
            if (this.j == 1) {
                a(view, this.B, a(y(), w(), 0, bVar.height, true), z2);
            } else {
                a(view, a(x(), v(), 0, bVar.width, true), this.B, z2);
            }
        } else if (this.j == 1) {
            a(view, a(this.k, v(), 0, bVar.width, false), a(y(), w(), 0, bVar.height, true), z2);
        } else {
            a(view, a(x(), v(), 0, bVar.width, true), a(this.k, w(), 0, bVar.height, false), z2);
        }
    }

    private void a(View view, int i2, int i3, boolean z2) {
        boolean z3;
        b(view, this.C);
        b bVar = (b) view.getLayoutParams();
        int b2 = b(i2, bVar.leftMargin + this.C.left, bVar.rightMargin + this.C.right);
        int b3 = b(i3, bVar.topMargin + this.C.top, bVar.bottomMargin + this.C.bottom);
        if (z2) {
            z3 = a(view, b2, b3, (RecyclerView.i) bVar);
        } else {
            z3 = b(view, b2, b3, (RecyclerView.i) bVar);
        }
        if (z3) {
            view.measure(b2, b3);
        }
    }

    private int b(int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0) {
            return i2;
        }
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - i3) - i4), mode);
        }
        return i2;
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.A = (d) parcelable;
            n();
        }
    }

    public Parcelable c() {
        int i2;
        int i3;
        if (this.A != null) {
            return new d(this.A);
        }
        d dVar = new d();
        dVar.h = this.d;
        dVar.i = this.o;
        dVar.j = this.z;
        if (this.h == null || this.h.f422a == null) {
            dVar.e = 0;
        } else {
            dVar.f = this.h.f422a;
            dVar.e = dVar.f.length;
            dVar.g = this.h.f423b;
        }
        if (u() > 0) {
            if (this.o) {
                i2 = J();
            } else {
                i2 = K();
            }
            dVar.f426a = i2;
            dVar.f427b = j();
            dVar.c = this.i;
            dVar.d = new int[this.i];
            for (int i4 = 0; i4 < this.i; i4++) {
                if (this.o) {
                    i3 = this.f415a[i4].b(Integer.MIN_VALUE);
                    if (i3 != Integer.MIN_VALUE) {
                        i3 -= this.f416b.d();
                    }
                } else {
                    i3 = this.f415a[i4].a(Integer.MIN_VALUE);
                    if (i3 != Integer.MIN_VALUE) {
                        i3 -= this.f416b.c();
                    }
                }
                dVar.d[i4] = i3;
            }
        } else {
            dVar.f426a = -1;
            dVar.f427b = -1;
            dVar.c = 0;
        }
        return dVar;
    }

    public void a(RecyclerView.o oVar, RecyclerView.t tVar, View view, android.support.v4.view.a.b bVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.a(view, bVar);
            return;
        }
        b bVar2 = (b) layoutParams;
        if (this.j == 0) {
            bVar.b((Object) b.k.a(bVar2.b(), bVar2.f421b ? this.i : 1, -1, -1, bVar2.f421b, false));
        } else {
            bVar.b((Object) b.k.a(-1, -1, bVar2.b(), bVar2.f421b ? this.i : 1, bVar2.f421b, false));
        }
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (u() > 0) {
            View b2 = b(false);
            View d2 = d(false);
            if (b2 != null && d2 != null) {
                int d3 = d(b2);
                int d4 = d(d2);
                if (d3 < d4) {
                    accessibilityEvent.setFromIndex(d3);
                    accessibilityEvent.setToIndex(d4);
                    return;
                }
                accessibilityEvent.setFromIndex(d4);
                accessibilityEvent.setToIndex(d3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int j() {
        View view;
        if (this.e) {
            view = d(true);
        } else {
            view = b(true);
        }
        if (view == null) {
            return -1;
        }
        return d(view);
    }

    public int a(RecyclerView.o oVar, RecyclerView.t tVar) {
        if (this.j == 0) {
            return this.i;
        }
        return super.a(oVar, tVar);
    }

    public int b(RecyclerView.o oVar, RecyclerView.t tVar) {
        if (this.j == 1) {
            return this.i;
        }
        return super.b(oVar, tVar);
    }

    /* access modifiers changed from: package-private */
    public View b(boolean z2) {
        int c2 = this.f416b.c();
        int d2 = this.f416b.d();
        int u = u();
        View view = null;
        for (int i2 = 0; i2 < u; i2++) {
            View h2 = h(i2);
            int a2 = this.f416b.a(h2);
            if (this.f416b.b(h2) > c2 && a2 < d2) {
                if (a2 >= c2 || !z2) {
                    return h2;
                }
                if (view == null) {
                    view = h2;
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public View d(boolean z2) {
        int c2 = this.f416b.c();
        int d2 = this.f416b.d();
        View view = null;
        for (int u = u() - 1; u >= 0; u--) {
            View h2 = h(u);
            int a2 = this.f416b.a(h2);
            int b2 = this.f416b.b(h2);
            if (b2 > c2 && a2 < d2) {
                if (b2 <= d2 || !z2) {
                    return h2;
                }
                if (view == null) {
                    view = h2;
                }
            }
        }
        return view;
    }

    private void b(RecyclerView.o oVar, RecyclerView.t tVar, boolean z2) {
        int d2;
        int q = q(Integer.MIN_VALUE);
        if (q != Integer.MIN_VALUE && (d2 = this.f416b.d() - q) > 0) {
            int i2 = d2 - (-c(-d2, oVar, tVar));
            if (z2 && i2 > 0) {
                this.f416b.a(i2);
            }
        }
    }

    private void c(RecyclerView.o oVar, RecyclerView.t tVar, boolean z2) {
        int c2;
        int p = p(Integer.MAX_VALUE);
        if (p != Integer.MAX_VALUE && (c2 = p - this.f416b.c()) > 0) {
            int c3 = c2 - c(c2, oVar, tVar);
            if (z2 && c3 > 0) {
                this.f416b.a(-c3);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(int r5, android.support.v7.widget.RecyclerView.t r6) {
        /*
            r4 = this;
            android.support.v7.widget.f r0 = r4.l
            r1 = 0
            r0.f474b = r1
            android.support.v7.widget.f r0 = r4.l
            r0.c = r5
            boolean r0 = r4.r()
            r2 = 1
            if (r0 == 0) goto L_0x0030
            int r6 = r6.c()
            r0 = -1
            if (r6 == r0) goto L_0x0030
            boolean r0 = r4.e
            if (r6 >= r5) goto L_0x001d
            r5 = 1
            goto L_0x001e
        L_0x001d:
            r5 = 0
        L_0x001e:
            if (r0 != r5) goto L_0x0029
            android.support.v7.widget.h r5 = r4.f416b
            int r5 = r5.f()
            r6 = r5
            r5 = 0
            goto L_0x0032
        L_0x0029:
            android.support.v7.widget.h r5 = r4.f416b
            int r5 = r5.f()
            goto L_0x0031
        L_0x0030:
            r5 = 0
        L_0x0031:
            r6 = 0
        L_0x0032:
            boolean r0 = r4.q()
            if (r0 == 0) goto L_0x004f
            android.support.v7.widget.f r0 = r4.l
            android.support.v7.widget.h r3 = r4.f416b
            int r3 = r3.c()
            int r3 = r3 - r5
            r0.f = r3
            android.support.v7.widget.f r5 = r4.l
            android.support.v7.widget.h r0 = r4.f416b
            int r0 = r0.d()
            int r0 = r0 + r6
            r5.g = r0
            goto L_0x005f
        L_0x004f:
            android.support.v7.widget.f r0 = r4.l
            android.support.v7.widget.h r3 = r4.f416b
            int r3 = r3.e()
            int r3 = r3 + r6
            r0.g = r3
            android.support.v7.widget.f r6 = r4.l
            int r5 = -r5
            r6.f = r5
        L_0x005f:
            android.support.v7.widget.f r5 = r4.l
            r5.h = r1
            android.support.v7.widget.f r5 = r4.l
            r5.f473a = r2
            android.support.v7.widget.f r5 = r4.l
            android.support.v7.widget.h r6 = r4.f416b
            int r6 = r6.h()
            if (r6 != 0) goto L_0x007a
            android.support.v7.widget.h r6 = r4.f416b
            int r6 = r6.e()
            if (r6 != 0) goto L_0x007a
            r1 = 1
        L_0x007a:
            r5.i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.b(int, android.support.v7.widget.RecyclerView$t):void");
    }

    private void l(int i2) {
        this.l.e = i2;
        f fVar = this.l;
        int i3 = 1;
        if (this.e != (i2 == -1)) {
            i3 = -1;
        }
        fVar.d = i3;
    }

    public void i(int i2) {
        super.i(i2);
        for (int i3 = 0; i3 < this.i; i3++) {
            this.f415a[i3].d(i2);
        }
    }

    public void j(int i2) {
        super.j(i2);
        for (int i3 = 0; i3 < this.i; i3++) {
            this.f415a[i3].d(i2);
        }
    }

    public void b(RecyclerView recyclerView, int i2, int i3) {
        c(i2, i3, 2);
    }

    public void a(RecyclerView recyclerView, int i2, int i3) {
        c(i2, i3, 1);
    }

    public void a(RecyclerView recyclerView) {
        this.h.a();
        n();
    }

    public void a(RecyclerView recyclerView, int i2, int i3, int i4) {
        c(i2, i3, 8);
    }

    public void a(RecyclerView recyclerView, int i2, int i3, Object obj) {
        c(i2, i3, 4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(int r6, int r7, int r8) {
        /*
            r5 = this;
            boolean r0 = r5.e
            if (r0 == 0) goto L_0x0009
            int r0 = r5.J()
            goto L_0x000d
        L_0x0009:
            int r0 = r5.K()
        L_0x000d:
            r1 = 8
            if (r8 != r1) goto L_0x001b
            if (r6 >= r7) goto L_0x0016
            int r2 = r7 + 1
            goto L_0x001d
        L_0x0016:
            int r2 = r6 + 1
            r3 = r2
            r2 = r7
            goto L_0x001f
        L_0x001b:
            int r2 = r6 + r7
        L_0x001d:
            r3 = r2
            r2 = r6
        L_0x001f:
            android.support.v7.widget.StaggeredGridLayoutManager$c r4 = r5.h
            r4.b(r2)
            if (r8 == r1) goto L_0x0036
            switch(r8) {
                case 1: goto L_0x0030;
                case 2: goto L_0x002a;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x0041
        L_0x002a:
            android.support.v7.widget.StaggeredGridLayoutManager$c r8 = r5.h
            r8.a((int) r6, (int) r7)
            goto L_0x0041
        L_0x0030:
            android.support.v7.widget.StaggeredGridLayoutManager$c r8 = r5.h
            r8.b(r6, r7)
            goto L_0x0041
        L_0x0036:
            android.support.v7.widget.StaggeredGridLayoutManager$c r8 = r5.h
            r1 = 1
            r8.a((int) r6, (int) r1)
            android.support.v7.widget.StaggeredGridLayoutManager$c r6 = r5.h
            r6.b(r7, r1)
        L_0x0041:
            if (r3 > r0) goto L_0x0044
            return
        L_0x0044:
            boolean r6 = r5.e
            if (r6 == 0) goto L_0x004d
            int r6 = r5.K()
            goto L_0x0051
        L_0x004d:
            int r6 = r5.J()
        L_0x0051:
            if (r2 > r6) goto L_0x0056
            r5.n()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.c(int, int, int):void");
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r9v4 */
    private int a(RecyclerView.o oVar, f fVar, RecyclerView.t tVar) {
        int i2;
        int c2;
        int i3;
        e eVar;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean m2;
        int i10;
        int i11;
        int i12;
        RecyclerView.o oVar2 = oVar;
        f fVar2 = fVar;
        ? r9 = 0;
        this.m.set(0, this.i, true);
        if (this.l.i) {
            i2 = fVar2.e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            if (fVar2.e == 1) {
                i12 = fVar2.g + fVar2.f474b;
            } else {
                i12 = fVar2.f - fVar2.f474b;
            }
            i2 = i12;
        }
        a(fVar2.e, i2);
        if (this.e) {
            c2 = this.f416b.d();
        } else {
            c2 = this.f416b.c();
        }
        int i13 = c2;
        boolean z2 = false;
        while (fVar.a(tVar) && (this.l.i || !this.m.isEmpty())) {
            View a2 = fVar2.a(oVar2);
            b bVar = (b) a2.getLayoutParams();
            int f2 = bVar.f();
            int c3 = this.h.c(f2);
            boolean z3 = c3 == -1;
            if (z3) {
                eVar = bVar.f421b ? this.f415a[r9] : a(fVar2);
                this.h.a(f2, eVar);
            } else {
                eVar = this.f415a[c3];
            }
            e eVar2 = eVar;
            bVar.f420a = eVar2;
            if (fVar2.e == 1) {
                b(a2);
            } else {
                b(a2, (int) r9);
            }
            a(a2, bVar, (boolean) r9);
            if (fVar2.e == 1) {
                if (bVar.f421b) {
                    i11 = q(i13);
                } else {
                    i11 = eVar2.b(i13);
                }
                int e2 = this.f416b.e(a2) + i11;
                if (z3 && bVar.f421b) {
                    c.a m3 = m(i11);
                    m3.f425b = -1;
                    m3.f424a = f2;
                    this.h.a(m3);
                }
                i4 = e2;
                i5 = i11;
            } else {
                if (bVar.f421b) {
                    i10 = p(i13);
                } else {
                    i10 = eVar2.a(i13);
                }
                i5 = i10 - this.f416b.e(a2);
                if (z3 && bVar.f421b) {
                    c.a n2 = n(i10);
                    n2.f425b = 1;
                    n2.f424a = f2;
                    this.h.a(n2);
                }
                i4 = i10;
            }
            if (bVar.f421b && fVar2.d == -1) {
                if (z3) {
                    this.E = true;
                } else {
                    if (fVar2.e == 1) {
                        m2 = l();
                    } else {
                        m2 = m();
                    }
                    if (!m2) {
                        c.a f3 = this.h.f(f2);
                        if (f3 != null) {
                            f3.d = true;
                        }
                        this.E = true;
                    }
                }
            }
            a(a2, bVar, fVar2);
            if (!i() || this.j != 1) {
                if (bVar.f421b) {
                    i8 = this.c.c();
                } else {
                    i8 = (eVar2.e * this.k) + this.c.c();
                }
                i7 = i8;
                i6 = this.c.e(a2) + i8;
            } else {
                if (bVar.f421b) {
                    i9 = this.c.d();
                } else {
                    i9 = this.c.d() - (((this.i - 1) - eVar2.e) * this.k);
                }
                i6 = i9;
                i7 = i9 - this.c.e(a2);
            }
            if (this.j == 1) {
                a(a2, i7, i5, i6, i4);
            } else {
                a(a2, i5, i7, i4, i6);
            }
            if (bVar.f421b) {
                a(this.l.e, i2);
            } else {
                a(eVar2, this.l.e, i2);
            }
            a(oVar2, this.l);
            if (this.l.h && a2.hasFocusable()) {
                if (bVar.f421b) {
                    this.m.clear();
                } else {
                    this.m.set(eVar2.e, false);
                    z2 = true;
                    r9 = 0;
                }
            }
            z2 = true;
            r9 = 0;
        }
        if (!z2) {
            a(oVar2, this.l);
        }
        if (this.l.e == -1) {
            i3 = this.f416b.c() - p(this.f416b.c());
        } else {
            i3 = q(this.f416b.d()) - this.f416b.d();
        }
        if (i3 > 0) {
            return Math.min(fVar2.f474b, i3);
        }
        return 0;
    }

    private c.a m(int i2) {
        c.a aVar = new c.a();
        aVar.c = new int[this.i];
        for (int i3 = 0; i3 < this.i; i3++) {
            aVar.c[i3] = i2 - this.f415a[i3].b(i2);
        }
        return aVar;
    }

    private c.a n(int i2) {
        c.a aVar = new c.a();
        aVar.c = new int[this.i];
        for (int i3 = 0; i3 < this.i; i3++) {
            aVar.c[i3] = this.f415a[i3].a(i2) - i2;
        }
        return aVar;
    }

    private void a(View view, b bVar, f fVar) {
        if (fVar.e == 1) {
            if (bVar.f421b) {
                p(view);
            } else {
                bVar.f420a.b(view);
            }
        } else if (bVar.f421b) {
            q(view);
        } else {
            bVar.f420a.a(view);
        }
    }

    private void a(RecyclerView.o oVar, f fVar) {
        int i2;
        int i3;
        if (fVar.f473a && !fVar.i) {
            if (fVar.f474b == 0) {
                if (fVar.e == -1) {
                    b(oVar, fVar.g);
                } else {
                    a(oVar, fVar.f);
                }
            } else if (fVar.e == -1) {
                int o2 = fVar.f - o(fVar.f);
                if (o2 < 0) {
                    i3 = fVar.g;
                } else {
                    i3 = fVar.g - Math.min(o2, fVar.f474b);
                }
                b(oVar, i3);
            } else {
                int r = r(fVar.g) - fVar.g;
                if (r < 0) {
                    i2 = fVar.f;
                } else {
                    i2 = Math.min(r, fVar.f474b) + fVar.f;
                }
                a(oVar, i2);
            }
        }
    }

    private void p(View view) {
        for (int i2 = this.i - 1; i2 >= 0; i2--) {
            this.f415a[i2].b(view);
        }
    }

    private void q(View view) {
        for (int i2 = this.i - 1; i2 >= 0; i2--) {
            this.f415a[i2].a(view);
        }
    }

    private void a(int i2, int i3) {
        for (int i4 = 0; i4 < this.i; i4++) {
            if (!this.f415a[i4].f428a.isEmpty()) {
                a(this.f415a[i4], i2, i3);
            }
        }
    }

    private void a(e eVar, int i2, int i3) {
        int i4 = eVar.i();
        if (i2 == -1) {
            if (eVar.b() + i4 <= i3) {
                this.m.set(eVar.e, false);
            }
        } else if (eVar.d() - i4 >= i3) {
            this.m.set(eVar.e, false);
        }
    }

    private int o(int i2) {
        int a2 = this.f415a[0].a(i2);
        for (int i3 = 1; i3 < this.i; i3++) {
            int a3 = this.f415a[i3].a(i2);
            if (a3 > a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    private int p(int i2) {
        int a2 = this.f415a[0].a(i2);
        for (int i3 = 1; i3 < this.i; i3++) {
            int a3 = this.f415a[i3].a(i2);
            if (a3 < a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        int b2 = this.f415a[0].b(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.i; i2++) {
            if (this.f415a[i2].b(Integer.MIN_VALUE) != b2) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        int a2 = this.f415a[0].a(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.i; i2++) {
            if (this.f415a[i2].a(Integer.MIN_VALUE) != a2) {
                return false;
            }
        }
        return true;
    }

    private int q(int i2) {
        int b2 = this.f415a[0].b(i2);
        for (int i3 = 1; i3 < this.i; i3++) {
            int b3 = this.f415a[i3].b(i2);
            if (b3 > b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private int r(int i2) {
        int b2 = this.f415a[0].b(i2);
        for (int i3 = 1; i3 < this.i; i3++) {
            int b3 = this.f415a[i3].b(i2);
            if (b3 < b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private void a(RecyclerView.o oVar, int i2) {
        while (u() > 0) {
            View h2 = h(0);
            if (this.f416b.b(h2) <= i2 && this.f416b.c(h2) <= i2) {
                b bVar = (b) h2.getLayoutParams();
                if (bVar.f421b) {
                    int i3 = 0;
                    while (i3 < this.i) {
                        if (this.f415a[i3].f428a.size() != 1) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                    for (int i4 = 0; i4 < this.i; i4++) {
                        this.f415a[i4].h();
                    }
                } else if (bVar.f420a.f428a.size() != 1) {
                    bVar.f420a.h();
                } else {
                    return;
                }
                a(h2, oVar);
            } else {
                return;
            }
        }
    }

    private void b(RecyclerView.o oVar, int i2) {
        int u = u() - 1;
        while (u >= 0) {
            View h2 = h(u);
            if (this.f416b.a(h2) >= i2 && this.f416b.d(h2) >= i2) {
                b bVar = (b) h2.getLayoutParams();
                if (bVar.f421b) {
                    int i3 = 0;
                    while (i3 < this.i) {
                        if (this.f415a[i3].f428a.size() != 1) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                    for (int i4 = 0; i4 < this.i; i4++) {
                        this.f415a[i4].g();
                    }
                } else if (bVar.f420a.f428a.size() != 1) {
                    bVar.f420a.g();
                } else {
                    return;
                }
                a(h2, oVar);
                u--;
            } else {
                return;
            }
        }
    }

    private boolean s(int i2) {
        if (this.j == 0) {
            if ((i2 == -1) != this.e) {
                return true;
            }
            return false;
        }
        if (((i2 == -1) == this.e) == i()) {
            return true;
        }
        return false;
    }

    private e a(f fVar) {
        int i2;
        int i3;
        int i4 = -1;
        if (s(fVar.e)) {
            i3 = this.i - 1;
            i2 = -1;
        } else {
            i3 = 0;
            i4 = this.i;
            i2 = 1;
        }
        e eVar = null;
        if (fVar.e == 1) {
            int i5 = Integer.MAX_VALUE;
            int c2 = this.f416b.c();
            while (i3 != i4) {
                e eVar2 = this.f415a[i3];
                int b2 = eVar2.b(c2);
                if (b2 < i5) {
                    eVar = eVar2;
                    i5 = b2;
                }
                i3 += i2;
            }
            return eVar;
        }
        int i6 = Integer.MIN_VALUE;
        int d2 = this.f416b.d();
        while (i3 != i4) {
            e eVar3 = this.f415a[i3];
            int a2 = eVar3.a(d2);
            if (a2 > i6) {
                eVar = eVar3;
                i6 = a2;
            }
            i3 += i2;
        }
        return eVar;
    }

    public boolean e() {
        return this.j == 1;
    }

    public boolean d() {
        return this.j == 0;
    }

    public int a(int i2, RecyclerView.o oVar, RecyclerView.t tVar) {
        return c(i2, oVar, tVar);
    }

    public int b(int i2, RecyclerView.o oVar, RecyclerView.t tVar) {
        return c(i2, oVar, tVar);
    }

    private int t(int i2) {
        if (u() != 0) {
            if ((i2 < K()) != this.e) {
                return -1;
            }
            return 1;
        } else if (this.e) {
            return 1;
        } else {
            return -1;
        }
    }

    public void d(int i2) {
        if (!(this.A == null || this.A.f426a == i2)) {
            this.A.b();
        }
        this.f = i2;
        this.g = Integer.MIN_VALUE;
        n();
    }

    public void a(int i2, int i3, RecyclerView.t tVar, RecyclerView.h.a aVar) {
        int i4;
        if (this.j != 0) {
            i2 = i3;
        }
        if (u() != 0 && i2 != 0) {
            a(i2, tVar);
            if (this.G == null || this.G.length < this.i) {
                this.G = new int[this.i];
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.i; i6++) {
                if (this.l.d == -1) {
                    i4 = this.l.f - this.f415a[i6].a(this.l.f);
                } else {
                    i4 = this.f415a[i6].b(this.l.g) - this.l.g;
                }
                if (i4 >= 0) {
                    this.G[i5] = i4;
                    i5++;
                }
            }
            Arrays.sort(this.G, 0, i5);
            for (int i7 = 0; i7 < i5 && this.l.a(tVar); i7++) {
                aVar.b(this.l.c, this.G[i7]);
                this.l.c += this.l.d;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, RecyclerView.t tVar) {
        int i3;
        int i4;
        if (i2 > 0) {
            i4 = J();
            i3 = 1;
        } else {
            i4 = K();
            i3 = -1;
        }
        this.l.f473a = true;
        b(i4, tVar);
        l(i3);
        this.l.c = i4 + this.l.d;
        this.l.f474b = Math.abs(i2);
    }

    /* access modifiers changed from: package-private */
    public int c(int i2, RecyclerView.o oVar, RecyclerView.t tVar) {
        if (u() == 0 || i2 == 0) {
            return 0;
        }
        a(i2, tVar);
        int a2 = a(oVar, this.l, tVar);
        if (this.l.f474b >= a2) {
            i2 = i2 < 0 ? -a2 : a2;
        }
        this.f416b.a(-i2);
        this.o = this.e;
        this.l.f474b = 0;
        a(oVar, this.l);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public int J() {
        int u = u();
        if (u == 0) {
            return 0;
        }
        return d(h(u - 1));
    }

    /* access modifiers changed from: package-private */
    public int K() {
        if (u() == 0) {
            return 0;
        }
        return d(h(0));
    }

    private int u(int i2) {
        int u = u();
        for (int i3 = 0; i3 < u; i3++) {
            int d2 = d(h(i3));
            if (d2 >= 0 && d2 < i2) {
                return d2;
            }
        }
        return 0;
    }

    private int v(int i2) {
        for (int u = u() - 1; u >= 0; u--) {
            int d2 = d(h(u));
            if (d2 >= 0 && d2 < i2) {
                return d2;
            }
        }
        return 0;
    }

    public RecyclerView.i a() {
        if (this.j == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    public RecyclerView.i a(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    public RecyclerView.i a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    public boolean a(RecyclerView.i iVar) {
        return iVar instanceof b;
    }

    public View a(View view, int i2, RecyclerView.o oVar, RecyclerView.t tVar) {
        View e2;
        int i3;
        int i4;
        int i5;
        int i6;
        View a2;
        if (u() == 0 || (e2 = e(view)) == null) {
            return null;
        }
        M();
        int w = w(i2);
        if (w == Integer.MIN_VALUE) {
            return null;
        }
        b bVar = (b) e2.getLayoutParams();
        boolean z2 = bVar.f421b;
        e eVar = bVar.f420a;
        if (w == 1) {
            i3 = J();
        } else {
            i3 = K();
        }
        b(i3, tVar);
        l(w);
        this.l.c = this.l.d + i3;
        this.l.f474b = (int) (((float) this.f416b.f()) * 0.33333334f);
        this.l.h = true;
        this.l.f473a = false;
        a(oVar, this.l, tVar);
        this.o = this.e;
        if (!z2 && (a2 = eVar.a(i3, w)) != null && a2 != e2) {
            return a2;
        }
        if (s(w)) {
            for (int i7 = this.i - 1; i7 >= 0; i7--) {
                View a3 = this.f415a[i7].a(i3, w);
                if (a3 != null && a3 != e2) {
                    return a3;
                }
            }
        } else {
            for (int i8 = 0; i8 < this.i; i8++) {
                View a4 = this.f415a[i8].a(i3, w);
                if (a4 != null && a4 != e2) {
                    return a4;
                }
            }
        }
        boolean z3 = (this.d ^ true) == (w == -1);
        if (!z2) {
            if (z3) {
                i6 = eVar.j();
            } else {
                i6 = eVar.k();
            }
            View c2 = c(i6);
            if (!(c2 == null || c2 == e2)) {
                return c2;
            }
        }
        if (s(w)) {
            for (int i9 = this.i - 1; i9 >= 0; i9--) {
                if (i9 != eVar.e) {
                    if (z3) {
                        i5 = this.f415a[i9].j();
                    } else {
                        i5 = this.f415a[i9].k();
                    }
                    View c3 = c(i5);
                    if (!(c3 == null || c3 == e2)) {
                        return c3;
                    }
                }
            }
        } else {
            for (int i10 = 0; i10 < this.i; i10++) {
                if (z3) {
                    i4 = this.f415a[i10].j();
                } else {
                    i4 = this.f415a[i10].k();
                }
                View c4 = c(i4);
                if (c4 != null && c4 != e2) {
                    return c4;
                }
            }
        }
        return null;
    }

    private int w(int i2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        switch (i2) {
                            case 1:
                                return (this.j != 1 && i()) ? 1 : -1;
                            case 2:
                                return (this.j != 1 && i()) ? -1 : 1;
                            default:
                                return Integer.MIN_VALUE;
                        }
                    } else if (this.j == 1) {
                        return 1;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (this.j == 0) {
                    return 1;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (this.j == 1) {
                return -1;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (this.j == 0) {
            return -1;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public static class b extends RecyclerView.i {

        /* renamed from: a  reason: collision with root package name */
        e f420a;

        /* renamed from: b  reason: collision with root package name */
        boolean f421b;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public boolean a() {
            return this.f421b;
        }

        public final int b() {
            if (this.f420a == null) {
                return -1;
            }
            return this.f420a.e;
        }
    }

    class e {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<View> f428a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        int f429b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        int d = 0;
        final int e;

        e(int i) {
            this.e = i;
        }

        /* access modifiers changed from: package-private */
        public int a(int i) {
            if (this.f429b != Integer.MIN_VALUE) {
                return this.f429b;
            }
            if (this.f428a.size() == 0) {
                return i;
            }
            a();
            return this.f429b;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            c.a f2;
            View view = this.f428a.get(0);
            b c2 = c(view);
            this.f429b = StaggeredGridLayoutManager.this.f416b.a(view);
            if (c2.f421b && (f2 = StaggeredGridLayoutManager.this.h.f(c2.f())) != null && f2.f425b == -1) {
                this.f429b -= f2.a(this.e);
            }
        }

        /* access modifiers changed from: package-private */
        public int b() {
            if (this.f429b != Integer.MIN_VALUE) {
                return this.f429b;
            }
            a();
            return this.f429b;
        }

        /* access modifiers changed from: package-private */
        public int b(int i) {
            if (this.c != Integer.MIN_VALUE) {
                return this.c;
            }
            if (this.f428a.size() == 0) {
                return i;
            }
            c();
            return this.c;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            c.a f2;
            View view = this.f428a.get(this.f428a.size() - 1);
            b c2 = c(view);
            this.c = StaggeredGridLayoutManager.this.f416b.b(view);
            if (c2.f421b && (f2 = StaggeredGridLayoutManager.this.h.f(c2.f())) != null && f2.f425b == 1) {
                this.c += f2.a(this.e);
            }
        }

        /* access modifiers changed from: package-private */
        public int d() {
            if (this.c != Integer.MIN_VALUE) {
                return this.c;
            }
            c();
            return this.c;
        }

        /* access modifiers changed from: package-private */
        public void a(View view) {
            b c2 = c(view);
            c2.f420a = this;
            this.f428a.add(0, view);
            this.f429b = Integer.MIN_VALUE;
            if (this.f428a.size() == 1) {
                this.c = Integer.MIN_VALUE;
            }
            if (c2.d() || c2.e()) {
                this.d += StaggeredGridLayoutManager.this.f416b.e(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(View view) {
            b c2 = c(view);
            c2.f420a = this;
            this.f428a.add(view);
            this.c = Integer.MIN_VALUE;
            if (this.f428a.size() == 1) {
                this.f429b = Integer.MIN_VALUE;
            }
            if (c2.d() || c2.e()) {
                this.d += StaggeredGridLayoutManager.this.f416b.e(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z, int i) {
            int i2;
            if (z) {
                i2 = b(Integer.MIN_VALUE);
            } else {
                i2 = a(Integer.MIN_VALUE);
            }
            e();
            if (i2 != Integer.MIN_VALUE) {
                if (z && i2 < StaggeredGridLayoutManager.this.f416b.d()) {
                    return;
                }
                if (z || i2 <= StaggeredGridLayoutManager.this.f416b.c()) {
                    if (i != Integer.MIN_VALUE) {
                        i2 += i;
                    }
                    this.c = i2;
                    this.f429b = i2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f428a.clear();
            f();
            this.d = 0;
        }

        /* access modifiers changed from: package-private */
        public void f() {
            this.f429b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void c(int i) {
            this.f429b = i;
            this.c = i;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            int size = this.f428a.size();
            View remove = this.f428a.remove(size - 1);
            b c2 = c(remove);
            c2.f420a = null;
            if (c2.d() || c2.e()) {
                this.d -= StaggeredGridLayoutManager.this.f416b.e(remove);
            }
            if (size == 1) {
                this.f429b = Integer.MIN_VALUE;
            }
            this.c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void h() {
            View remove = this.f428a.remove(0);
            b c2 = c(remove);
            c2.f420a = null;
            if (this.f428a.size() == 0) {
                this.c = Integer.MIN_VALUE;
            }
            if (c2.d() || c2.e()) {
                this.d -= StaggeredGridLayoutManager.this.f416b.e(remove);
            }
            this.f429b = Integer.MIN_VALUE;
        }

        public int i() {
            return this.d;
        }

        /* access modifiers changed from: package-private */
        public b c(View view) {
            return (b) view.getLayoutParams();
        }

        /* access modifiers changed from: package-private */
        public void d(int i) {
            if (this.f429b != Integer.MIN_VALUE) {
                this.f429b += i;
            }
            if (this.c != Integer.MIN_VALUE) {
                this.c += i;
            }
        }

        public int j() {
            if (StaggeredGridLayoutManager.this.d) {
                return a(this.f428a.size() - 1, -1, true);
            }
            return a(0, this.f428a.size(), true);
        }

        public int k() {
            if (StaggeredGridLayoutManager.this.d) {
                return a(0, this.f428a.size(), true);
            }
            return a(this.f428a.size() - 1, -1, true);
        }

        /* access modifiers changed from: package-private */
        public int a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int c2 = StaggeredGridLayoutManager.this.f416b.c();
            int d2 = StaggeredGridLayoutManager.this.f416b.d();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f428a.get(i);
                int a2 = StaggeredGridLayoutManager.this.f416b.a(view);
                int b2 = StaggeredGridLayoutManager.this.f416b.b(view);
                boolean z4 = false;
                boolean z5 = !z3 ? a2 < d2 : a2 <= d2;
                if (!z3 ? b2 > c2 : b2 >= c2) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (!z || !z2) {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.d(view);
                        }
                        if (a2 < c2 || b2 > d2) {
                            return StaggeredGridLayoutManager.this.d(view);
                        }
                    } else if (a2 >= c2 && b2 <= d2) {
                        return StaggeredGridLayoutManager.this.d(view);
                    }
                }
                i += i3;
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int a(int i, int i2, boolean z) {
            return a(i, i2, false, false, z);
        }

        public View a(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.f428a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f428a.get(size);
                    if ((StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.d(view2) >= i) || ((!StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.d(view2) <= i) || !view2.hasFocusable())) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f428a.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.f428a.get(i3);
                    if ((StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.d(view3) <= i) || ((!StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.d(view3) >= i) || !view3.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        int[] f422a;

        /* renamed from: b  reason: collision with root package name */
        List<a> f423b;

        c() {
        }

        /* access modifiers changed from: package-private */
        public int a(int i) {
            if (this.f423b != null) {
                for (int size = this.f423b.size() - 1; size >= 0; size--) {
                    if (this.f423b.get(size).f424a >= i) {
                        this.f423b.remove(size);
                    }
                }
            }
            return b(i);
        }

        /* access modifiers changed from: package-private */
        public int b(int i) {
            if (this.f422a == null || i >= this.f422a.length) {
                return -1;
            }
            int g = g(i);
            if (g == -1) {
                Arrays.fill(this.f422a, i, this.f422a.length, -1);
                return this.f422a.length;
            }
            int i2 = g + 1;
            Arrays.fill(this.f422a, i, i2, -1);
            return i2;
        }

        /* access modifiers changed from: package-private */
        public int c(int i) {
            if (this.f422a == null || i >= this.f422a.length) {
                return -1;
            }
            return this.f422a[i];
        }

        /* access modifiers changed from: package-private */
        public void a(int i, e eVar) {
            e(i);
            this.f422a[i] = eVar.e;
        }

        /* access modifiers changed from: package-private */
        public int d(int i) {
            int length = this.f422a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        /* access modifiers changed from: package-private */
        public void e(int i) {
            if (this.f422a == null) {
                this.f422a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.f422a, -1);
            } else if (i >= this.f422a.length) {
                int[] iArr = this.f422a;
                this.f422a = new int[d(i)];
                System.arraycopy(iArr, 0, this.f422a, 0, iArr.length);
                Arrays.fill(this.f422a, iArr.length, this.f422a.length, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.f422a != null) {
                Arrays.fill(this.f422a, -1);
            }
            this.f423b = null;
        }

        /* access modifiers changed from: package-private */
        public void a(int i, int i2) {
            if (this.f422a != null && i < this.f422a.length) {
                int i3 = i + i2;
                e(i3);
                System.arraycopy(this.f422a, i3, this.f422a, i, (this.f422a.length - i) - i2);
                Arrays.fill(this.f422a, this.f422a.length - i2, this.f422a.length, -1);
                c(i, i2);
            }
        }

        private void c(int i, int i2) {
            if (this.f423b != null) {
                int i3 = i + i2;
                for (int size = this.f423b.size() - 1; size >= 0; size--) {
                    a aVar = this.f423b.get(size);
                    if (aVar.f424a >= i) {
                        if (aVar.f424a < i3) {
                            this.f423b.remove(size);
                        } else {
                            aVar.f424a -= i2;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i, int i2) {
            if (this.f422a != null && i < this.f422a.length) {
                int i3 = i + i2;
                e(i3);
                System.arraycopy(this.f422a, i, this.f422a, i3, (this.f422a.length - i) - i2);
                Arrays.fill(this.f422a, i, i3, -1);
                d(i, i2);
            }
        }

        private void d(int i, int i2) {
            if (this.f423b != null) {
                for (int size = this.f423b.size() - 1; size >= 0; size--) {
                    a aVar = this.f423b.get(size);
                    if (aVar.f424a >= i) {
                        aVar.f424a += i2;
                    }
                }
            }
        }

        private int g(int i) {
            if (this.f423b == null) {
                return -1;
            }
            a f = f(i);
            if (f != null) {
                this.f423b.remove(f);
            }
            int size = this.f423b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (this.f423b.get(i2).f424a >= i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return -1;
            }
            this.f423b.remove(i2);
            return this.f423b.get(i2).f424a;
        }

        public void a(a aVar) {
            if (this.f423b == null) {
                this.f423b = new ArrayList();
            }
            int size = this.f423b.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.f423b.get(i);
                if (aVar2.f424a == aVar.f424a) {
                    this.f423b.remove(i);
                }
                if (aVar2.f424a >= aVar.f424a) {
                    this.f423b.add(i, aVar);
                    return;
                }
            }
            this.f423b.add(aVar);
        }

        public a f(int i) {
            if (this.f423b == null) {
                return null;
            }
            for (int size = this.f423b.size() - 1; size >= 0; size--) {
                a aVar = this.f423b.get(size);
                if (aVar.f424a == i) {
                    return aVar;
                }
            }
            return null;
        }

        public a a(int i, int i2, int i3, boolean z) {
            if (this.f423b == null) {
                return null;
            }
            int size = this.f423b.size();
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = this.f423b.get(i4);
                if (aVar.f424a >= i2) {
                    return null;
                }
                if (aVar.f424a >= i && (i3 == 0 || aVar.f425b == i3 || (z && aVar.d))) {
                    return aVar;
                }
            }
            return null;
        }

        static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() {
                /* renamed from: a */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                /* renamed from: a */
                public a[] newArray(int i) {
                    return new a[i];
                }
            };

            /* renamed from: a  reason: collision with root package name */
            int f424a;

            /* renamed from: b  reason: collision with root package name */
            int f425b;
            int[] c;
            boolean d;

            public int describeContents() {
                return 0;
            }

            a(Parcel parcel) {
                this.f424a = parcel.readInt();
                this.f425b = parcel.readInt();
                this.d = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.c = new int[readInt];
                    parcel.readIntArray(this.c);
                }
            }

            a() {
            }

            /* access modifiers changed from: package-private */
            public int a(int i) {
                if (this.c == null) {
                    return 0;
                }
                return this.c[i];
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f424a);
                parcel.writeInt(this.f425b);
                parcel.writeInt(this.d ? 1 : 0);
                if (this.c == null || this.c.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.c.length);
                parcel.writeIntArray(this.c);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f424a + ", mGapDir=" + this.f425b + ", mHasUnwantedGapAfter=" + this.d + ", mGapPerSpan=" + Arrays.toString(this.c) + '}';
            }
        }
    }

    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() {
            /* renamed from: a */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            /* renamed from: a */
            public d[] newArray(int i) {
                return new d[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f426a;

        /* renamed from: b  reason: collision with root package name */
        int f427b;
        int c;
        int[] d;
        int e;
        int[] f;
        List<c.a> g;
        boolean h;
        boolean i;
        boolean j;

        public int describeContents() {
            return 0;
        }

        public d() {
        }

        d(Parcel parcel) {
            this.f426a = parcel.readInt();
            this.f427b = parcel.readInt();
            this.c = parcel.readInt();
            if (this.c > 0) {
                this.d = new int[this.c];
                parcel.readIntArray(this.d);
            }
            this.e = parcel.readInt();
            if (this.e > 0) {
                this.f = new int[this.e];
                parcel.readIntArray(this.f);
            }
            boolean z = false;
            this.h = parcel.readInt() == 1;
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1 ? true : z;
            this.g = parcel.readArrayList(c.a.class.getClassLoader());
        }

        public d(d dVar) {
            this.c = dVar.c;
            this.f426a = dVar.f426a;
            this.f427b = dVar.f427b;
            this.d = dVar.d;
            this.e = dVar.e;
            this.f = dVar.f;
            this.h = dVar.h;
            this.i = dVar.i;
            this.j = dVar.j;
            this.g = dVar.g;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.d = null;
            this.c = 0;
            this.e = 0;
            this.f = null;
            this.g = null;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.d = null;
            this.c = 0;
            this.f426a = -1;
            this.f427b = -1;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f426a);
            parcel.writeInt(this.f427b);
            parcel.writeInt(this.c);
            if (this.c > 0) {
                parcel.writeIntArray(this.d);
            }
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f);
            }
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeList(this.g);
        }
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        int f418a;

        /* renamed from: b  reason: collision with root package name */
        int f419b;
        boolean c;
        boolean d;
        boolean e;
        int[] f;

        a() {
            a();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f418a = -1;
            this.f419b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
            this.e = false;
            if (this.f != null) {
                Arrays.fill(this.f, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(e[] eVarArr) {
            int length = eVarArr.length;
            if (this.f == null || this.f.length < length) {
                this.f = new int[StaggeredGridLayoutManager.this.f415a.length];
            }
            for (int i = 0; i < length; i++) {
                this.f[i] = eVarArr[i].a(Integer.MIN_VALUE);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int i;
            if (this.c) {
                i = StaggeredGridLayoutManager.this.f416b.d();
            } else {
                i = StaggeredGridLayoutManager.this.f416b.c();
            }
            this.f419b = i;
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            if (this.c) {
                this.f419b = StaggeredGridLayoutManager.this.f416b.d() - i;
            } else {
                this.f419b = StaggeredGridLayoutManager.this.f416b.c() + i;
            }
        }
    }
}


