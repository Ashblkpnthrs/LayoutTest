package fr.infostrates.layouttest.maze;

import java.util.List;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

public class LabyrintheActivity extends Activity {

    public static final int VICTORY_DIALOG = 0;
    public static final int DEFEAT_DIALOG = 1;

    private LabyrintheView mView = null;
    private LabyrintheEngine mEngine = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mView = new LabyrintheView(this);
        setContentView(mView);

        mEngine = new LabyrintheEngine(this);

        Boule b = new Boule();
        mView.setBoule(b);
        mEngine.setBoule(b);

        List<Bloc> mList = mEngine.buildLabyrinthe();
        mView.setBlocks(mList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mEngine.resume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mEngine.stop();
    }

    @Override
    public Dialog onCreateDialog (int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        switch(id) {
            case VICTORY_DIALOG:
                builder.setCancelable(false)
                        .setMessage("You Win !")
                        .setTitle("Victory ")
                        .setNeutralButton("Retry", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mEngine.reset();
                                mEngine.resume();
                            }
                        });
                break;

            case DEFEAT_DIALOG:
                builder.setCancelable(false)
                        .setMessage("You Loose !")
                        .setTitle("Defeat")
                        .setNeutralButton("Retry", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mEngine.reset();
                                mEngine.resume();
                            }
                        });
        }
        return builder.create();
    }

    @Override
    public void onPrepareDialog (int id, Dialog box) {
        mEngine.stop();
    }
}
