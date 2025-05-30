from flask import Flask
from models import db
from controllers import list_regions, create_region, edit_region, delete_region, seed_data

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///nation.db'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
db.init_app(app)

app.add_url_rule('/', 'list_regions', list_regions)
app.add_url_rule('/create', 'create_region', create_region, methods=['GET', 'POST'])
app.add_url_rule('/edit/<int:region_id>', 'edit_region', edit_region, methods=['GET', 'POST'])
app.add_url_rule('/delete/<int:region_id>', 'delete_region', delete_region)

if __name__ == '__main__':
    with app.app_context():
        db.create_all()
        seed_data()
    app.run(debug=True)
