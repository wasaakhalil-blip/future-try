package net.fxgear;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* compiled from: AsyncWorker */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f659a = a.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Handler f660b;
    private Handler c;
    private HandlerThread d = new HandlerThread(this.f659a);
    private Handler.Callback e = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message == null || message.what != 99 || message.obj == null || !(message.obj instanceof b) || a.this.f660b == null) {
                return false;
            }
            boolean unused = a.this.f = true;
            b bVar = (b) message.obj;
            final C0022a aVar = bVar.f665b;
            bVar.f664a.run();
            if (a.this.f660b == null) {
                return false;
            }
            a.this.f660b.post(new Runnable() {
                public void run() {
                    boolean unused = a.this.f = false;
                    if (aVar != null) {
                        aVar.a();
                    }
                }
            });
            return false;
        }
    };
    /* access modifiers changed from: private */
    public boolean f;

    /* renamed from: net.fxgear.a$a  reason: collision with other inner class name */
    /* compiled from: AsyncWorker */
    public interface C0022a {
        void a();
    }

    /* compiled from: AsyncWorker */
    private class b {

        /* renamed from: a  reason: collision with root package name */
        Runnable f664a;

        /* renamed from: b  reason: collision with root package name */
        C0022a f665b;

        private b() {
        }
    }

    public a() {
        this.d.start();
        this.f660b = new Handler(Looper.getMainLooper());
        this.c = new Handler(this.d.getLooper(), this.e);
    }

    public void a(Runnable runnable, C0022a aVar) {
        if (runnable != null && aVar != null) {
            if (this.c != null) {
                b bVar = new b();
                bVar.f664a = runnable;
                bVar.f665b = aVar;
                this.c.obtainMessage(99, bVar).sendToTarget();
                return;
            }
            Log.e(this.f659a, "Illegal state.");
        }
    }

    public boolean a() {
        if (!this.f) {
            return this.c != null && this.c.hasMessages(99);
        }
        return true;
    }

    public void b() {
        Log.d(this.f659a, "Destroy()+");
        if (this.d != null) {
            this.d.quitSafely();
            this.d = null;
        }
        if (this.f660b != null) {
            this.f660b.removeCallbacksAndMessages((Object) null);
            this.f660b = null;
        }
        if (this.c != null) {
            this.c.removeCallbacksAndMessages((Object) null);
            this.c = null;
        }
    }
}
