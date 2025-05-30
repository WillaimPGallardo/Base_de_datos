from flask import render_template, request, redirect, url_for
from models import db, Region, Continent

def list_regions():
    regions = Region.query.all()
    return render_template('index.html', regions=regions)

def create_region():
    continents = Continent.query.all()
    if request.method == 'POST':
        new_region = Region(
            name=request.form['name'],
            continent_id=request.form['continent_id']
        )
        db.session.add(new_region)
        db.session.commit()
        return redirect(url_for('list_regions'))
    return render_template('create.html', continents=continents)

def edit_region(region_id):
    region = Region.query.get(region_id)
    continents = Continent.query.all()
    if request.method == 'POST':
        region.name = request.form['name']
        region.continent_id = request.form['continent_id']
        db.session.commit()
        return redirect(url_for('list_regions'))
    return render_template('edit.html', region=region, continents=continents)

def delete_region(region_id):
    region = Region.query.get(region_id)
    db.session.delete(region)
    db.session.commit()
    return redirect(url_for('list_regions'))

def seed_data():
    if not Continent.query.first():
        db.session.add_all([
            Continent(name="Asia"),
            Continent(name="Europe"),
            Continent(name="Africa"),
            Continent(name="Oceania"),
            Continent(name="America")
        ])
        db.session.commit()
