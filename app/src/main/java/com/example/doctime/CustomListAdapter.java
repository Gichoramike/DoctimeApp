//import static java.security.AccessController.getContext;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.widget.ImageView;
//import android.widget.RatingBar;
//import android.widget.TextView;
//
//import com.example.doctime.R;
//
//// CustomListAdapter.java
//public class CustomListAdapter extends ArrayAdapter<DoctorProfile> {
//
//    public CustomListAdapter(Context context, List<DoctorProfile> profiles) {
//        super(context, 0, profiles);
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        // Inflate the custom row layout (list_item.xml)
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
//        }
//
//        // Bind data to views
//        DoctorProfile profile = getItem(position);
//        ImageView profileImage = convertView.findViewById(R.id.profileImage);
//        TextView nameTextView = convertView.findViewById(R.id.nameTextView);
//        TextView hospitalTextView = convertView.findViewById(R.id.hospitalTextView);
//        RatingBar ratingBar = convertView.findViewById(R.id.ratingBar);
//        TextView numericalRatingTextView = convertView.findViewById(R.id.numericalRatingTextView);
//
//        // Set data
//        nameTextView.setText(profile.getName());
//        hospitalTextView.setText(profile.getHospital());
//        ratingBar.setRating((float) profile.getRating());
//        numericalRatingTextView.setText(String.valueOf(profile