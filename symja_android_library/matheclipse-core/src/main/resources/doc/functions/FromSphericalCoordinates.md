## FromSphericalCoordinates

```
FromSphericalCoordinates({r, t, p})
```
 
> returns the cartesian coordinates for the spherical coordinates `{r, t, p}`.

See
* [Wikipedia - Spherical coordinate system](https://en.wikipedia.org/wiki/Spherical_coordinate_system)
* [Wikipedia - Polar coordinate system](https://en.wikipedia.org/wiki/Polar_coordinate_system)
* [Wikipedia - Cartesian coordinate system](https://en.wikipedia.org/wiki/Cartesian_coordinate_system)

### Examples

```
>> FromSphericalCoordinates( {r, t, p} )
{r*Cos(p)*Sin(t),r*Sin(p)*Sin(t),r*Cos(t)}
```
