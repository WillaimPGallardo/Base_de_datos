from flask_sqlalchemy import SQLAlchemy

db = SQLAlchemy()

class Continent(db.Model):
    __tablename__ = 'continents'
    continent_id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(100), nullable=False)
    regions = db.relationship('Region', backref='continent', lazy=True)

class Region(db.Model):
    __tablename__ = 'regions'
    region_id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(100), nullable=False)
    continent_id = db.Column(db.Integer, db.ForeignKey('continents.continent_id'), nullable=False)
