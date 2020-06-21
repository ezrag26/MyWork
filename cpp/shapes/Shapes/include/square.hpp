#ifndef MYWORK_SQUARE_HPP
#define MYWORK_SQUARE_HPP

#include <cmath>

#include "rectangle.hpp"

namespace mywork
{

class Square : public Rectangle
{
public:
    explicit Square(COLORS color_ = COLOR_BLACK, const Point& middle_ = Point(150, 150), double side_ = 20);

private:
    virtual void WhoAmI() const;
};

} // mywork

#endif /* MYWORK_SQUARE_HPP */
