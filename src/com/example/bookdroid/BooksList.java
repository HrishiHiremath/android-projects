package com.example.bookdroid;

import java.util.ArrayList;
import java.util.List;

import datasource.Book;
import datasource.Books;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Build;

public class BooksList extends ActionBarActivity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        
        getActionBar().setHomeButtonEnabled(true);

        final ListView listView = (ListView) findViewById(R.id.booksListView);

        final List<Book> booksList = Books.getInstance().getAllBooks();
        
        final List<String> bookNamesList = new ArrayList<String>(booksList.size());
        
        for (Book book : booksList) {
        	
        	bookNamesList.add(book.getTitle());
        }
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
        		bookNamesList);
        
        
        listView.setAdapter(adapter);

        if (savedInstanceState == null) {
        	getSupportFragmentManager().beginTransaction()
        	.add(R.id.container, new PlaceholderFragment())
        	.commit();
        }
    }
    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_books, container, false);
            return rootView;
        }
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	if (android.R.id.home == item.getItemId()) {
    		finish();
    	}
    	return super.onOptionsItemSelected(item);
    }

}
